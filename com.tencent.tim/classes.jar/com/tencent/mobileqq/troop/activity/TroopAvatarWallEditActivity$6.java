package com.tencent.mobileqq.troop.activity;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import ausj;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.io.File;
import java.net.URL;
import jqg;
import jqo;
import rvx;

class TroopAvatarWallEditActivity$6
  implements Runnable
{
  TroopAvatarWallEditActivity$6(TroopAvatarWallEditActivity paramTroopAvatarWallEditActivity, URLDrawable paramURLDrawable, ausj paramausj) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, "QR Check Start!");
      }
      Object localObject = new Bundle();
      String str1 = this.x.getURL().toString();
      if (this.this$0.a == null)
      {
        CookieSyncManager.createInstance(this.this$0.getApplicationContext());
        this.this$0.a = CookieManager.getInstance();
      }
      String str2 = this.this$0.a.getCookie(str1);
      if (str2 != null)
      {
        ((Bundle)localObject).putString("Cookie", str2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, "Get cookie: " + jqo.b(str2, new String[0]) + " from " + jqo.filterKeyForLog(str1, new String[0]));
        }
      }
      localObject = jqg.a(BaseApplication.getContext(), str1, (Bundle)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, "saveTmpImage path = " + (String)localObject);
      }
      this.this$0.aWb = ((String)localObject);
      asfg.cEz = jqo.filterKeyForLog(str1, new String[0]);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        if (rvx.a(Uri.parse("file://" + new File((String)localObject).getAbsolutePath()), this.this$0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, "has QRCode ");
          }
          this.this$0.runOnUiThread(new TroopAvatarWallEditActivity.6.1(this));
        }
      }
      for (;;)
      {
        asfg.cEz = null;
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, "no QRCode ");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, "showMenuActionSheet error : " + localException.getMessage());
        return;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, "showMenuActionSheet error : " + localUnsatisfiedLinkError.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity.6
 * JD-Core Version:    0.7.0.1
 */