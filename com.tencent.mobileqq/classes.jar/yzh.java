import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class yzh
{
  String a = "";
  
  public static yzh a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.videostory.capture", 2, "config TextUtils.isEmpty(config) return");
      }
      return null;
    }
    yzh localyzh = new yzh();
    localyzh.a(paramString);
    return localyzh;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yzh
 * JD-Core Version:    0.7.0.1
 */