import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class xgc
{
  String a = "";
  
  public static xgc a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.videostory.capture", 2, "config TextUtils.isEmpty(config) return");
      }
      return null;
    }
    xgc localxgc = new xgc();
    localxgc.a(paramString);
    return localxgc;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xgc
 * JD-Core Version:    0.7.0.1
 */