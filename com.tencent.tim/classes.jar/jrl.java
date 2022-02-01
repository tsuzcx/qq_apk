import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;

public final class jrl
  implements skj.a
{
  public jrl(Activity paramActivity, boolean paramBoolean, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    int i = paramBundle.getInt("currentFragment", -1);
    if (QLog.isColorLevel()) {
      QLog.i("SensorAPIJavaScript", 2, "isFromAio callback " + i);
    }
    if (i == 2)
    {
      paramBundle = new Intent(this.val$activity, SplashActivity.class);
      paramBundle.setFlags(67108864);
      this.val$activity.startActivity(paramBundle);
      return;
    }
    if ((this.abp) && (!TextUtils.isEmpty(this.Uf)))
    {
      paramBundle = wja.a(new Intent(this.val$activity, SplashActivity.class), null);
      paramBundle.putExtra("uin", this.Uf);
      paramBundle.putExtra("uintype", 1);
      this.val$activity.startActivity(paramBundle);
      return;
    }
    this.val$activity.setResult(4660);
    this.val$activity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jrl
 * JD-Core Version:    0.7.0.1
 */