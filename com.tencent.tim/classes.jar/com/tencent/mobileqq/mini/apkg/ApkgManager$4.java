package com.tencent.mobileqq.mini.apkg;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ApkgManager$4
  implements Runnable
{
  ApkgManager$4(ApkgManager paramApkgManager, MiniAppConfig paramMiniAppConfig, String paramString) {}
  
  public void run()
  {
    int i = 0;
    try
    {
      if ((this.val$miniAppConfig != null) && (this.val$miniAppConfig.config != null) && (!TextUtils.isEmpty(this.val$curPath)))
      {
        String str1 = ApkgManager.getPkgRoot(this.val$miniAppConfig.config);
        String str2 = MD5.toMD5(this.val$miniAppConfig.config.appId);
        Object localObject = new File(str1);
        if (((File)localObject).isDirectory())
        {
          localObject = ((File)localObject).list();
          int j = localObject.length;
          while (i < j)
          {
            CharSequence localCharSequence = localObject[i];
            if ((!TextUtils.isEmpty(localCharSequence)) && (localCharSequence.startsWith(str2)) && (!this.val$curPath.contains(localCharSequence)))
            {
              QLog.d("ApkgManager", 1, "delete pkg : " + localCharSequence);
              FileUtils.delete(str1 + localCharSequence, false);
            }
            i += 1;
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApkgManager", 1, "deleteOldPkg error,", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgManager.4
 * JD-Core Version:    0.7.0.1
 */