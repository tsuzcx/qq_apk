import com.tencent.av.avgesture.AVGestureWrapper.AVUploadReport;
import com.tencent.sveffects.Reporter;
import com.tencent.sveffects.SdkContext;

public final class adih
  implements AVGestureWrapper.AVUploadReport
{
  public void avGestureUploadReport(String paramString1, String paramString2)
  {
    SdkContext.getInstance().getReporter().reportToCompass("dc00898", "", paramString1, paramString1, 0, 0, "", "", paramString2, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adih
 * JD-Core Version:    0.7.0.1
 */