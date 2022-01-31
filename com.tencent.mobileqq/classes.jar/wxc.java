import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class wxc
{
  String a = "";
  
  public static wxc a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.videostory.capture", 2, "config TextUtils.isEmpty(config) return");
      }
      return null;
    }
    wxc localwxc = new wxc();
    localwxc.a(paramString);
    return localwxc;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wxc
 * JD-Core Version:    0.7.0.1
 */