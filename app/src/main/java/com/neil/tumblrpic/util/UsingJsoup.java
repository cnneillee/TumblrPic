package com.neil.tumblrpic.util;

import com.neil.tumblrpic.Constant;
import com.neil.tumblrpic.bean.ExtraInfo;
import com.neil.tumblrpic.bean.ImageBean;
import com.neil.tumblrpic.bean.MainImgBean;
import com.neil.tumblrpic.bean.Tag;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class UsingJsoup {
    private static final String BLOGER_URL = "http://maggy-ch.tumblr.com";


    private static List<ImageBean> imgBeanList;
    private static List<MainImgBean> mainimgBeanList;

    public static List<MainImgBean> searchImgsJsoup(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            // String title = doc.title();
            imgBeanList = new ArrayList<ImageBean>();
            mainimgBeanList = new ArrayList<MainImgBean>();
            Elements articles = doc.getElementsByTag("article");
            for (int i = 0; i < articles.size(); i++) {

                MainImgBean mainImgBean = new MainImgBean();

                Element element = articles.get(i);
                //get the data-post-id
                String id = element.attr("data-post-id");
                mainImgBean.setId(id);
/*
                //get the data-json
                String dataJson = element.attr("data-json");
                Log.e("GSON", dataJson);
                Gson gson = new GsonBuilder().serializeNulls().create();

                ArticleItemDataJson articleItemDataJson = gson.fromJson(dataJson,
                        ArticleItemDataJson.class);
                String blogUrl = articleItemDataJson.getTumblelog_data().getUrl();
                mainImgBean.setBlogUrl(blogUrl);
*/
                //post_content
                Elements postContent = element.getElementsByClass("post_content");
                String imgSrc = getImgSrc1(postContent.get(postContent.size() - 1));
                mainImgBean.setSrc(imgSrc);
                String imgDesc = getImgDesrc1(postContent.get(postContent.size() - 1));
                mainImgBean.setDesc(imgDesc);

                String blogUrl = getImgBlogUrl1(postContent.get(postContent.size() - 1));
                mainImgBean.setBlogUrl(blogUrl);

                //post_footer
                Elements postFooter = element.getElementsByClass("post_footer");

                //post_tags
                Elements postTags = element.getElementsByClass("post_content");

                Elements tags = element.getElementsByClass("post_tag");
                List<Tag> tagslist = new ArrayList<Tag>();
                for (Element ele : tags) {
                    String tagurl = ele.attr("href");
                    String title = ele.attr("title");
                    Tag tag = new Tag(tagurl, title);
                    tagslist.add(tag);
                }

                mainImgBean.setTags(tagslist);
                mainimgBeanList.add(mainImgBean);
                new ImageLoaderThread(imgSrc).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mainimgBeanList;
    }

    private static String getImgBlogUrl1(Element element) {
        Element eleImgNode = element.getElementsByClass("photo").get(0);
        String blogUrl = eleImgNode.attr("data-pin-url").split("/post")[0];
        return blogUrl;
    }

    private static String getImgSrc1(Element element) {
        Element eleImgNode = element.getElementsByClass("photo").get(0);
        return eleImgNode.attr("src");
    }

    private static String getImgDesrc1(Element element) {
        Element eleImgNode = element.getElementsByClass("photo").get(0);
        return eleImgNode.attr("data-pin-description");
    }


    public static List<ImageBean> getImgBeanList(int pageNum) {
        if (pageNum <= 0)
            return null;
        try {
//            Document doc = Jsoup.parse(new URL(BLOGER_URL + PAGE + pageNum), 5000);
            Document doc = Jsoup.connect(BLOGER_URL + Constant.PAGE + pageNum).get();
            // String title = doc.title();
            imgBeanList = new ArrayList<ImageBean>();
            Elements articles = doc.getElementsByTag("article");
            for (int i = 0; i < articles.size(); i++) {
                Element element = articles.get(i);
                Document articleDoc = Jsoup.parse(element.html());

                String id = element.attr("data-post-id");
                String imgSrc = getImgSrc(articleDoc);
                ExtraInfo extra = getImgExtra(articleDoc);
                ImageBean imageBean = new ImageBean(id, imgSrc, extra);
                imgBeanList.add(imageBean);

                new ImageLoaderThread(imgSrc).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imgBeanList;
    }

    /**
     * ��ȡ�ڵ㸽����Ϣ
     *
     * @param articleDoc
     * @return
     */
    private static ExtraInfo getImgExtra(Document articleDoc) {

        // ȡ��note�ڵ�
        Elements elements = articleDoc.getElementsByClass("date-note-wrapper");
        if (elements.size() <= 0)
            return null;
        // ȡ��note��Ϣ
        Element eleNote = elements.get(0)
                .getElementsByClass("notes-pop-container").get(0)
                .firstElementSibling();
        String notes = eleNote.text();

        // ȡ��date��Ϣ
        Element eleDate = elements.get(0).child(1);
        String date = eleDate.text();

        // ȡ��caption�ڵ�
        Elements captionNode = articleDoc.getElementsByClass("caption");
        // ȡ��caption
        String caption = captionNode.get(0).child(0).child(0).text();

        // ȡ��tags�ڵ�
        Elements tags = articleDoc.getElementsByClass("tag-link");
        List<String> tagslist = new ArrayList<String>();
        for (Element ele : tags) {
            tagslist.add(ele.text());
        }
        ExtraInfo extra = new ExtraInfo(date, notes, tagslist, caption);
        System.out.println("TOSTRING:\n" + extra.toString());
        return extra;
    }

    /**
     * ��ȡimg·��
     *
     * @param articleDoc
     * @return
     */
    private static String getImgSrc(Document articleDoc) {
        Elements elements = articleDoc
                .getElementsByClass("photo");
        return elements.get(0).attr("src");
//        System.out.println("values: "
//                + elements.get(0).childNode(1).attr("src"));
//        return elements.get(0).childNode(1).attr("src");
    }
}
