

import JD.Spider;
import org.junit.Test;

import JD.domin.Page;
import JD.download.DownloadImpl;
import JD.process.ProcessImpl;

public class TestSpider {

    @Test
    public void test1() throws Exception {
        Spider spider = new Spider();

        //给接口注入实现类
        spider.setDownloadable(new DownloadImpl());
        spider.setProcessable(new ProcessImpl());

        String url = "https://item.jd.com/6405874.html";
        //String url2 = "https://item.jd.com/4938582.html";
        Page page = spider.download(url);
        spider.process(page);
    }
}
