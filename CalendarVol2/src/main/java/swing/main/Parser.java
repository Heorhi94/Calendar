package swing.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;

public class Parser {

    public Parser()  throws IOException{

    }


    private static Document getPageWeather () throws IOException {
        String url = "https://pogoda.onet.pl/prognoza-pogody/biala-podlaska-269669";
        Document pageWeather = Jsoup.parse(new URL(url), 5000);
        return pageWeather;
    }

    public static String textWeather()throws IOException{
        Document pageWeather = getPageWeather();
        Element temp =pageWeather.select("div[class = temp]").first();
        String date =  temp.text();
        return date;
    }

    private static Document getPage() throws IOException {
        String url = "https://woman-gu.ru/dlya-prazdnika/pozhelaniya/365-na-kazhdyj-den/";
        Document page = Jsoup.parse(new URL(url), 9000);
        return page;
    }

    public static String textsWish() throws IOException {
        Document page = getPage();
        Element wishes = page.select("ol").first();
        //   System.out.println(wishes);
        //int val = 0;
        String y = null;
     //   Elements[] x = new Elements[366];
        for (int i = 0; i < 365; i++) {
            wishes.select("li").remove(i);
            //    System.out.println(wishes.select("li").remove(i));
          /*  i = val;
            val++;*/
        }
       // var y = wishes.select("li").remove(Days());
        y=wishes.select("li").remove(Days()).text();
            return y;
    }

    public static int Days(){
        Calendar calendar = Calendar.getInstance();
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        return dayOfYear;

    }

    public static String odczuwalna() throws IOException {
        Document page = getPageWeather();
        Element temp = page.select("div[class =feelTemp]").first();
        String texts = temp.text();
        return texts;
    }

    public static String rain() throws IOException{
        Document page = getPageWeather();
        Elements parametr = page.select("div[class = weatherParams]");
        Elements ul = parametr.select("ul");
        Element rain = ul.select("li").first();
        String texts = rain.text();
        return texts;
    }

    public static String wiatr() throws IOException{
        Document page = getPageWeather();
        Elements parametr = page.select("div[class = weatherParams]");
        Elements ul = parametr.select("ul");
        Element wiatr = ul.select("li").remove(1);
        String texts = wiatr.text();
        return texts;
    }

    public static String atmosf() throws IOException{
        Document page = getPageWeather();
        Elements parametr = page.select("div[class = weatherParams]");
        Elements ul = parametr.select("ul");
        Element atmosf = ul.select("li").remove(2);
        String texts = atmosf.text();
        return texts;
    }

    public static String chmury() throws IOException{
        Document page = getPageWeather();
        Elements parametr = page.select("div[class = weatherParams]");
        Elements ul = parametr.select("ul");
        Element chmury = ul.select("li").remove(3);
        String texts = chmury.text();
        return texts;
    }

    public static String wilgotnosc() throws IOException{
        Document page = getPageWeather();
        Elements parametr = page.select("div[class = weatherParams]");
        Elements ul = parametr.select("ul");
        Element wilgotnosc = ul.select("li").remove(4);
        String texts = wilgotnosc.text();
        return texts;
    }
    public static String snow() throws IOException{
        Document page = getPageWeather();
        Elements parametr = page.select("div[class = weatherParams]");
        Elements ul = parametr.select("ul");
        Element snow = ul.select("li").remove(5);
        String texts = snow.text();
        return texts;
    }



    public static String textWeather2() throws IOException{
        Document page = getPageWeather();
        Element temps =page.select("div[class = temp]").first();
        Element temp = page.select("div[class =feelTemp]").first();
        Elements parametr = page.select("div[class = weatherParams]");
        Element desk = parametr.select("div[class = forecastDesc]").first();
        Elements ul = parametr.select("ul");
        Element rain = ul.select("li").first();
        Element wiatr = ul.select("li").remove(1);
        Element atmosf= ul.select("li").remove(2);
        Element chmury = ul.select("li").remove(3);
        Element wilgotnosc = ul.select("li").remove(4);
        Element snow = ul.select("li").remove(5);
        String text1 = desk.text();
        String text = temps.text()+"\n"+temp.text()+"\n"+desk.text()+"\n"+ rain.text()+"\n"+wiatr.text()+"\n"+atmosf.text()+"\n"+chmury.text()+"\n"+wilgotnosc.text() +"\n"+snow.text();
        return text;
    }

    public static void main(String[] args) throws IOException {

        Days();

    }

}
