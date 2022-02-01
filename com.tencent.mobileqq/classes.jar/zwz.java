import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class zwz
{
  String a = "";
  
  public static zwz a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.videostory.capture", 2, "config TextUtils.isEmpty(config) return");
      }
      return null;
    }
    zwz localzwz = new zwz();
    localzwz.a(paramString);
    return localzwz;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zwz
 * JD-Core Version:    0.7.0.1
 */