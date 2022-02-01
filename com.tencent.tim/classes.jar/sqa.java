import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class sqa
{
  String aFI = "";
  
  public static sqa a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.videostory.capture", 2, "config TextUtils.isEmpty(config) return");
      }
      return null;
    }
    sqa localsqa = new sqa();
    localsqa.tw(paramString);
    return localsqa;
  }
  
  public void tw(String paramString)
  {
    this.aFI = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sqa
 * JD-Core Version:    0.7.0.1
 */