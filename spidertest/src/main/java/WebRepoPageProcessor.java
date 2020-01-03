import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class WebRepoPageProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    public void process(Page page) {
//        System.out.println("this is the test: "+page.getHtml().links().toString());
        System.out.println("spider: " + page.getHtml().getDocument().data());
        page.addTargetRequests(page.getHtml().links().all());
    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new WebRepoPageProcessor()).addUrl("http://www.dangdang.com/").thread(2).run();
    }
}
