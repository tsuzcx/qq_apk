import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.config.APMModuleConfig;
import common.config.service.QzoneConfig;

public class tyb
  extends txq
{
  protected void a(APMModuleConfig paramAPMModuleConfig)
  {
    String str2;
    String str1;
    if (BaseApplicationImpl.sProcessId == 2)
    {
      paramAPMModuleConfig.threshold = QzoneConfig.getInstance().getConfig("QzoneHomepage", "DropFrame_Stack_Threshold", paramAPMModuleConfig.threshold);
      str2 = QzoneConfig.getInstance().getConfig("QzoneHomepage", "DropFrame_Stack_UserSampleRatio");
      str1 = QzoneConfig.getInstance().getConfig("QzoneHomepage", "Dropframe_Stack_EventSampleRatio");
      if (TextUtils.isEmpty(str2)) {}
    }
    try
    {
      f = Float.valueOf(str2).floatValue();
      if (f >= 0.0F) {
        paramAPMModuleConfig.userRatio = f;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          float f = Float.valueOf(str1).floatValue();
          if (f >= 0.0F) {
            paramAPMModuleConfig.evenRatio = f;
          }
          return;
        }
        catch (Exception paramAPMModuleConfig)
        {
          paramAPMModuleConfig.printStackTrace();
        }
        localException = localException;
        localException.printStackTrace();
      }
    }
    if (!TextUtils.isEmpty(str1)) {}
  }
  
  protected void bER() {}
  
  public String oF()
  {
    return "looper";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tyb
 * JD-Core Version:    0.7.0.1
 */