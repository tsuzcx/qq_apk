import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.app.UniformDownload.1.1;

public class agjk
  implements ahch.c
{
  agjk(agjj paramagjj, Bundle paramBundle, String paramString, long paramLong1, long paramLong2) {}
  
  public void ai(String paramString, long paramLong)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "nofilename.x";
    }
    this.a.mActivity.runOnUiThread(new UniformDownload.1.1(this, str, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agjk
 * JD-Core Version:    0.7.0.1
 */