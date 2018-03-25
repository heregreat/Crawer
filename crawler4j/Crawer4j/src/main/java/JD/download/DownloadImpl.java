package JD.download;

import JD.domin.Pagec;
import JD.domin.Pagec;
import JD.utils.PageUtil;

public class DownloadImpl implements Downloadable {

    public Pagec download(String url) {
        Pagec page = new Pagec();
        String content=PageUtil.getContent(url);//根据url得到内容
        page.setContent(content);
        page.setDataUrl(url);
        return page;
    }
}