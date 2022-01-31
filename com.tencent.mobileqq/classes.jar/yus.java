import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class yus
{
  String a = "";
  
  public static yus a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.videostory.capture", 2, "config TextUtils.isEmpty(config) return");
      }
      return null;
    }
    yus localyus = new yus();
    localyus.a(paramString);
    return localyus;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yus
 * JD-Core Version:    0.7.0.1
 */