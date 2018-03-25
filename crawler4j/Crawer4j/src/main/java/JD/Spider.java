package JD;

import JD.domin.Pagec;
import JD.domin.Pagec;
import JD.download.Downloadable;
import JD.process.Processable;
import edu.uci.ics.crawler4j.crawler.Page;

public class Spider {

    private Downloadable downloadable;
    private Processable processable;

    //下载页面源代码
    public Pagec download(String url){
        return downloadable.download(url);
    }

    //解析页面源代码
    public void process(Pagec pagec){
        processable.process(pagec);
    }

    //将解析后的数据保存到数据库

    public Downloadable getDownloadable() {
        return downloadable;
    }

    public void setDownloadable(Downloadable downloadable) {
        this.downloadable = downloadable;
    }

    public Processable getProcessable() {
        return processable;
    }

    public void setProcessable(Processable processable) {
        this.processable = processable;
    }

}
