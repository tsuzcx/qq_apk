import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class kba
  implements ausj.a
{
  kba(kaw paramkaw, QQAppInterface paramQQAppInterface, Context paramContext, Uri paramUri, SessionInfo paramSessionInfo, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.val$actionSheet.dismiss();
      return;
    case 0: 
      wmj.a(this.val$app, (BaseActivity)this.val$context, this.e, this.a);
      PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit().putString("LastScreenShotUri", null).commit();
      this.val$actionSheet.dismiss();
      return;
    }
    wmj.a(this.val$app, (Activity)this.val$context, this.a, null, null);
    this.val$actionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kba
 * JD-Core Version:    0.7.0.1
 */