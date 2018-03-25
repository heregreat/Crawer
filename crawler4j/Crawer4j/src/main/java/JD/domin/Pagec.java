package JD.domin;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.url.WebURL;

import java.util.HashMap;
import java.util.Map;

/**
 * 页面实体类
 * 保存页面信息
 */
public class Pagec {

    private String Id;// 商品ID
    private String Name;//商品名称
    private String Url;//商品URL地址
    private String price;//价格
    private String Ram;
    private String Battery;
    private String Color;
    private String Camera_pixel;
    private Map<String, String> param = new HashMap<String, String>();//商品参数规格
    private String content;//页面原始源代码内容

    public String getGoodId() {
        return Id;
    }
    public void setGoodId(String goodId) {
        this.Id = goodId;
    }

    public String getGoodName() {
        return Name;
    }
    public void setGoodName(String goodName) {
        this.Name = goodName;
    }

    public String getRam() {
        return Ram;
    }
    public void setRam(String Ram) {
        this.Ram = Ram;
    }

    public String getBattery() {
        return Battery;
    }
    public void setBattery(String Battery) {
        this.Battery = Battery;
    }

    public String getColor() {
        return Color;
    }
    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getCamera_pixel() {
        return Camera_pixel;
    }
    public void setCamera_pixel(String Camera_pixel) {
        this.Camera_pixel = Camera_pixel;
    }
    public String getDataUrl() {
        return Url;
    }
    public void setDataUrl(String dataUrl) {
        this.Url = dataUrl;
    }
    public Map<String, String> getParam() {
        return param;
    }
    public void setParam(String key,String value) {
        this.param.put(key, value);
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
}
