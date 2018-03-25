package JD.process;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;
import org.json.JSONArray;
import org.json.JSONObject;

import JD.domin.Page;
import JD.utils.HtmlUtil;
import JD.utils.PageUtil;

public class ProcessImpl implements Processable {

    public void process(Page page) {

        HtmlCleaner htmlCleaner = new HtmlCleaner();
        TagNode rootNode = htmlCleaner.clean(page.getContent());
        try {
            //ID
            String goodName = HtmlUtil.getText(rootNode, "//*[@class='sku-name']");// 得到商品名称
            System.out.println(goodName);
            page.setGoodName(goodName);
            //Ram
            String Ram = HtmlUtil.getText(rootNode, "//*[@id=\"detail\"]/div[2]/div[2]/div[1]/div[6]/dl/dd[4]");
            System.out.println("内存："+Ram);
            page.setRam(Ram);
            //Battery
            String Battery = HtmlUtil.getText(rootNode, "//*[@id=\"detail\"]/div[2]/div[2]/div[1]/div[10]/dl/dd[1]");
            System.out.println("电池容量："+Battery+"mAh");
            page.setBattery(Battery);
            //Color
            String Color = HtmlUtil.getText(rootNode, "//*[@id=\"detail\"]/div[2]/div[2]/div[1]/div[2]/dl/dd[1]");
            System.out.println("颜色："+Color);
            page.setColor(Color);
            //Camer_pixel
            String Camera_Pixel = HtmlUtil.getText(rootNode, "//*[@id=\"detail\"]/div[2]/div[2]/div[1]/div[9]/dl/dd[3]");
            System.out.println("后置摄像头像素："+Camera_Pixel);
            page.setColor(Camera_Pixel);

            // ID
            String url = page.getDataUrl();
            Pattern compile = Pattern.compile("https://item.jd.com/([0-9]+).html");
            Matcher matcher = compile.matcher(url);
            String goodid = null;
            if (matcher.find()) {
                goodid = matcher.group(1);
                page.setGoodId(goodid);
            }

            //Price
            //jQuery6221047([{"op":"5688.00","m":"11000.00","id":"J_4938582","p":"4999.00"}]);
            String pricejson = PageUtil
                    .getContent("http://p.3.cn/prices/get?skuid=J_" + goodid);
            JSONArray jsonArray = new JSONArray(pricejson);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String price = jsonObject.getString("p");
            System.out.println("售价："+price);
            page.setPrice(price);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}