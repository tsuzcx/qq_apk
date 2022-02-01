import android.app.Activity;
import android.text.TextUtils;
import com.tencent.tim.filemanager.app.UniformDownload.1.1;

public class atsx
  implements ahch.c
{
  public void ai(String paramString, long paramLong)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "nofilename.x";
    }
    this.a.mActivity.runOnUiThread(new UniformDownload.1.1(this, str, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atsx
 * JD-Core Version:    0.7.0.1
 */