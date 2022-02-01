import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.a;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.b;
import java.io.File;
import java.util.TreeMap;

public class adbx
{
  static String brN;
  
  public static String a(PromotionConfigInfo.a parama)
  {
    if (parama == null) {
      return null;
    }
    parama = (PromotionConfigInfo.b)parama.b().get(Integer.valueOf(0));
    if (parama == null) {
      return null;
    }
    return a(parama);
  }
  
  public static String a(PromotionConfigInfo.b paramb)
  {
    return paramb.brM + "entry" + File.separator;
  }
  
  private static String ae(String paramString, int paramInt)
  {
    return getRootDir() + paramString + File.separator + paramInt + File.separator;
  }
  
  public static String b(PromotionConfigInfo.a parama)
  {
    parama = (PromotionConfigInfo.b)parama.b().get(Integer.valueOf(0));
    if (parama == null) {
      return null;
    }
    return b(parama);
  }
  
  public static String b(PromotionConfigInfo.b paramb)
  {
    return paramb.brM + "guide" + File.separator;
  }
  
  public static String f(String paramString1, int paramInt, String paramString2)
  {
    return ae(paramString1, paramInt) + paramString2 + ".zip";
  }
  
  public static final String g(String paramString1, int paramInt, String paramString2)
  {
    return ae(paramString1, paramInt) + paramString2 + File.separator;
  }
  
  public static String getRootDir()
  {
    if (brN == null) {
      if (!aqfo.isExistSDCard()) {
        break label56;
      }
    }
    label56:
    for (String str = aqul.getSDKPrivatePath(acbn.SDCARD_PATH) + "pddata/prd/" + "ar_promotion" + File.separator;; str = BaseApplicationImpl.getApplication().getFilesDir() + "/pddata/prd/" + "ar_promotion" + File.separator)
    {
      brN = str;
      return brN;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adbx
 * JD-Core Version:    0.7.0.1
 */