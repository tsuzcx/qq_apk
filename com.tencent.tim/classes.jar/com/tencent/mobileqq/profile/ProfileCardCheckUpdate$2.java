package com.tencent.mobileqq.profile;

import alcm;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aqep;
import aquz;
import aqva;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ProfileCardCheckUpdate$2
  implements Runnable
{
  public ProfileCardCheckUpdate$2(alcm paramalcm, String paramString1, String paramString2) {}
  
  public void run()
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate start downloadLabelConfigJson url=" + this.val$url + ",version=" + this.val$version);
    }
    try
    {
      Object localObject = aqep.aW(this.this$0.app.getApplication());
      localObject = new File((String)localObject + ".tmp");
      aquz localaquz = new aquz(this.val$url, (File)localObject);
      localaquz.cxX = "profileCardDownload";
      localaquz.cxW = "VIP_profilecard";
      localaquz.bC = 1;
      localaquz.cWw = true;
      int j = aqva.a(localaquz, this.this$0.app);
      if (j == 0) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate downloadLabelConfigJson result code=" + j);
        }
        if (i != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate downloadLabelConfigJson update label config  success version=" + this.val$version);
          }
          this.this$0.app.getPreferences().edit().putString("profileLabelVersion", this.val$version).commit();
          alcm.a(this.this$0, (File)localObject);
        }
        return;
        i = 0;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardCheckUpdate.2
 * JD-Core Version:    0.7.0.1
 */