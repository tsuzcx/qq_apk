import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class awfw
  implements avtz.c
{
  awfw(awfv paramawfv) {}
  
  public void d(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzonePersonalizeJsPlugin", 4, "FontInterface.TrueTypeResult font:" + paramInt + ", fontPath:" + paramString1);
    }
    if (TextUtils.isEmpty(paramString1))
    {
      awfv.a(this.a, paramString2, -2, "font download failed.");
      return;
    }
    awfv.a(this.a, paramString2, 0, "success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awfw
 * JD-Core Version:    0.7.0.1
 */