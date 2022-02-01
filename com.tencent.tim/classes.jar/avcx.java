import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.webbundle.sdk.WebBundleH5OptionListner;
import cooperation.comic.VipComicHelper.3.1;
import mqq.os.MqqHandler;

public final class avcx
  implements WebBundleH5OptionListner
{
  avcx(SharedPreferences paramSharedPreferences) {}
  
  public void enableWebBundle(boolean paramBoolean)
  {
    QLog.d("WebBundle.Comic", 2, "handle enable webbundle. enable = " + paramBoolean);
    this.val$sp.edit().putBoolean("webbundle_enable", paramBoolean).apply();
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new VipComicHelper.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avcx
 * JD-Core Version:    0.7.0.1
 */