import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class avej
{
  private static Map<String, String> aH;
  private static Map<String, String> aI = new HashMap();
  
  static
  {
    aI.put("comicIndex", "https://qc.vip.qq.com/pages/index.html?asyncMode=3");
    aI.put("comicCategory", "https://qc.vip.qq.com/gc/pages/category.html?from=1006002&filter=0&categoryType=1&sort=4&_bid=354&_wv=1027&_cwv=4&_webviewtype=4&asyncMode=3&_wvx=3");
    aI.put("comicGroup", "https://qc.vip.qq.com/gc/pages/user/home.html?_wv=1091118887&_wvx=3&asyncMode=3&_sharp_v=1&_sonic_xv=32&cancelColorTab=1");
    aI.put("comicMore", "https://qc.vip.qq.com/gc/pages/community/square.html?_wv=3&_cwv=4&origin=1&from=10000001");
    aI.put("comicPayDownload", "https://cdn.vip.qq.com/club/client/comic/release/html/payDownload.html");
    aI.put("comicPayRead", "https://cdn.vip.qq.com/club/client/comic/release/html/payRead.html");
    aI.put("comicDetailComic", "https://cdn.vip.qq.com/club/client/comic/release/html/detail.html");
    aI.put("comicDetailNovel", "https://cdn.vip.qq.com/club/client/comic/release/html/detail.html");
    aI.put("comicDetailVideo", "https://cdn.vip.qq.com/club/client/comic/release/html/video.html");
    aI.put("comicMyPic", "https://cdn.vip.qq.com/club/client/comic/release/html/my_pic.html");
    aI.put("comicVideoSimple", "https://cdn.vip.qq.com/club/client/comic/release/html/video.html");
    aI.put("comicReadShare", "https://cdn.vip.qq.com/club/client/comic/release/html/read_share.html");
    aI.put("comicPicShare", "https://cdn.vip.qq.com/club/client/comic/release/html/pic_share.html");
    aI.put("comicReport", "https://guanjia.qq.com/online_server/m_report.html");
    aI.put("comicCdn", "https://imgcache.gtimg.cn/club/mobile/profile/comic_center/");
    aI.put("comicFav", "https://qc.vip.qq.com/gc/pages/user/favorite.html?_wv=3&_cwv=4&asyncMode=3&_sharp_v=1&_sonic_xv=32");
    aI.put("comicReaderContent", "https://cdn.vip.qq.com/club/client/comic/release/html/readerIndex.html");
    aI.put("comicSearch", "https://cdn.vip.qq.com/club/client/comic/release/html/search.html?platId=109&_bid=354&pos=external&_wv=1027&from=6");
    aI.put("comicBarrageList", "https://cdn.vip.qq.com/club/client/comic/release/html/bulletScreen.html");
    aI.put("comicQRCode", "https://cdn.vip.qq.com/club/client/comic/release/html/redirect.html");
  }
  
  public static String N(String paramString1, String paramString2, String paramString3)
  {
    String str2 = "";
    String str1 = str2;
    if (!paramString1.isEmpty())
    {
      str1 = str2;
      if (!paramString2.isEmpty())
      {
        str1 = str2;
        if (!paramString3.isEmpty()) {
          str1 = paramString1.replaceAll("(" + paramString2 + "=[^&]*)", paramString2 + "=" + paramString3);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("VipComicUrlHelper", 2, "replaceUrlFieldValueReg url is " + paramString1 + "fieldName is " + paramString2 + ",newValue is " + paramString3 + ", newUrl is " + str1);
    }
    return str1;
  }
  
  public static String O(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1.indexOf(paramString2) == -1)
    {
      localObject = Uri.parse(paramString1).buildUpon();
      ((Uri.Builder)localObject).appendQueryParameter(paramString2, paramString3);
    }
    for (Object localObject = ((Uri.Builder)localObject).build().toString();; localObject = paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicUrlHelper", 2, "addUrlField url is " + paramString1 + "fieldName is " + paramString2 + ",Value is " + paramString3 + ", newUrl is " + (String)localObject);
      }
      return localObject;
    }
  }
  
  public static String getUrl(String paramString)
  {
    String str1 = null;
    if (aH != null) {
      str1 = (String)aH.get(paramString);
    }
    String str2 = str1;
    if (str1 == null) {
      str2 = (String)aI.get(paramString);
    }
    return str2;
  }
  
  public static boolean tj(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null) {
      if ((paramString.indexOf("banSlideToTab=1") == -1) && (paramString.indexOf("bodong.vip.qq.com") == -1) && (paramString.indexOf("qc.vip.qq.com") == -1))
      {
        bool1 = bool2;
        if (paramString.indexOf("cdn.vip.qq.com/club/client/comic") == -1) {}
      }
      else
      {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("VipComicUrlHelper", 2, "isBoodoUrl() url is " + paramString + " isBoodo is " + bool1);
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avej
 * JD-Core Version:    0.7.0.1
 */