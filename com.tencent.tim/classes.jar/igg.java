import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class igg
{
  public static String gA()
  {
    if (aqfo.isExistSDCard()) {}
    for (String str1 = aqul.getSDKPrivatePath(acbn.SDCARD_PATH);; str1 = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath())
    {
      String str2 = str1;
      if (str1 != null)
      {
        str2 = str1;
        if (!str1.endsWith(File.separator)) {
          str2 = str1 + File.separator;
        }
      }
      return str2 + "pddata/prd/" + "av_redpacket" + File.separator;
    }
  }
  
  public static String gB()
  {
    return gu() + "beauty" + File.separator;
  }
  
  public static String gC()
  {
    return aqul.getSDKPrivatePath(acbn.SDCARD_PATH + "av_image_data" + File.separator);
  }
  
  public static String gD()
  {
    return aqul.getSDKPrivatePath(acbn.SDCARD_PATH + "av_report_record_dir");
  }
  
  public static String gE()
  {
    return BaseApplicationImpl.getLogExternalPath(BaseApplicationImpl.getContext()) + "/tencent/msflogs/com/tencent/tim/";
  }
  
  public static String gu()
  {
    return aqul.getSDKPrivatePath(acbn.SDCARD_PATH + "qav" + File.separator);
  }
  
  public static String gv()
  {
    return aqul.getSDKPrivatePath(acbn.SDCARD_PATH + "ptv_template" + File.separator);
  }
  
  public static String gw()
  {
    return aqul.getSDKPrivatePath(acbn.SDCARD_PATH + "new_ptv_template" + File.separator);
  }
  
  public static String gx()
  {
    return gw() + "new_ptv_template_usable" + File.separator;
  }
  
  public static String gy()
  {
    return gu() + "effect";
  }
  
  public static String gz()
  {
    return aqul.getSDKPrivatePath(acbn.SDCARD_PATH + "funcall" + File.separator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     igg
 * JD-Core Version:    0.7.0.1
 */