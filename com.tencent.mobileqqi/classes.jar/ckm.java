import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.EmosmDetailActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.qphone.base.util.QLog;

public class ckm
  extends EmoticonPackageDownloadListener
{
  public ckm(EmosmDetailActivity paramEmosmDetailActivity) {}
  
  public void onJsonComplete(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if ((Long.parseLong(paramEmoticonPackage.epId) == Long.parseLong(EmosmDetailActivity.a(this.a))) && (paramInt == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.EmosmDetailActivity", 2, "json is complete,result ok: " + EmosmDetailActivity.a(this.a));
      }
      this.a.b.getPreferences().edit().putInt("emosm_json_last_download_timestamp", (int)(System.currentTimeMillis() / 1000L)).commit();
      this.a.runOnUiThread(new ckn(this, paramEmoticonPackage));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ckm
 * JD-Core Version:    0.7.0.1
 */