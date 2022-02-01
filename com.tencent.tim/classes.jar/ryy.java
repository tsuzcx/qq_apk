import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;

public class ryy
{
  private static final String aDA;
  public static final String aDB;
  public static final String aDC;
  public static final String aDD;
  public static final String aDE;
  private static final String arq = aqul.getSDKPrivatePath("cache/");
  public static final String[] bK = { "follow_guide_pics", "praise_guide_pics" };
  public static final HashMap<String, String> eP;
  public static final HashMap<String, String> eQ;
  public static final HashMap<String, String> eR;
  
  static
  {
    aDA = aqul.getSDKPrivatePath("qsubscribe/");
    aDB = aDA + "file/";
    aDC = aDA + "cache/";
    aDD = aDB + "animation/";
    aDE = arq + "tencent_sdk_download/";
    eP = new HashMap();
    eQ = new HashMap();
    eR = new HashMap();
    eP.put("follow_guide_pics", "https://down.qq.com/video_story/certified_account/animation_pics/follow_guide_pics.zip");
    eP.put("praise_guide_pics", "https://down.qq.com/video_story/certified_account/animation_pics/praise_guide_pics.zip");
    eQ.put("follow_guide_pics", aDD + "follow_guide_pics" + File.separator);
    eQ.put("praise_guide_pics", aDD + "praise_guide_pics" + File.separator);
    eR.put("follow_guide_pics", "KEY_SUBSCRIBE_FOLLOW_GUIDE_DOWNLOAD_URL");
    eR.put("praise_guide_pics", "KEY_SUBSCRIBE_FOLLOW_PRAISE_DOWNLOAD_URL");
  }
  
  public static String al(String paramString1, String paramString2)
  {
    String str = String.format("https://h5.qzone.qq.com/subscription/addgoods/%s?_proxy=1&_wv=3", new Object[] { paramString1 });
    paramString1 = str;
    if (paramString2 != null)
    {
      paramString1 = str;
      if (!aqmr.isEmpty(paramString2)) {
        paramString1 = str + "&id=" + URLEncoder.encode(paramString2);
      }
    }
    return paramString1;
  }
  
  public static String gu(String paramString)
  {
    return String.format("https://h5.qzone.qq.com/subscription/openshop/%s?_proxy=1&_wv=3", new Object[] { paramString });
  }
  
  public static String gv(String paramString)
  {
    return "https://h5.qzone.qq.com/subscription/morerecommend/{uin}?_proxy=1&_wv=3&_p=".replace("{uin}", paramString);
  }
  
  public static String gw(String paramString)
  {
    paramString = aDB + paramString;
    if (QLog.isColorLevel()) {
      QLog.d("SubscribeConstants", 4, "QSUSCRIBE_DOWNLOAD_ROOT_PATH" + aDB + "   getSDKPrivatePath realPath=" + paramString);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ryy
 * JD-Core Version:    0.7.0.1
 */