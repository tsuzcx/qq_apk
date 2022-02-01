package com.tencent.mobileqq.microapp.apkg;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.d;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.sdk.BaseLibInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import zxs;

final class i
  implements PreloadManager.d
{
  i(h paramh, g.d paramd, long paramLong) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApkgManager", 2, "initApkgByConfig - base libs downloaded");
      }
      try
      {
        g.a(this.c.b, c.a(BaseApplicationImpl.getApplication().getApplicationContext(), "WAWebview.js"));
        g.b(this.c.b, c.a(BaseApplicationImpl.getApplication().getApplicationContext(), "WAService.js"));
        g.c(this.c.b, c.a(BaseApplicationImpl.getApplication().getApplicationContext(), "WAVConsole.js"));
        if (!this.c.b.f())
        {
          String str = zxs.aA(this.c.a.baseLibInfo.baseLibKey, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDsE3WI7sDFUi6QWV/oK8qozDvS\nTlxmu1a3NSFxeOrjlVEVtOx8yIMVFYIixq/Fv1XgUlyvL7bGJbaLLKaqlYruGd2z\nNbaIz90Zm4H0pMFHx4vCYhsRP1HXbVMo2ZDiHEDbnSm/99uzFPPiXqLi8jE9t4if\n0GuYdSZfe5o+SIKT5QIDAQAB");
          g.a(this.c.b, g.a(new File(paramPathResult.folderPath, "WAWebview"), str));
          g.b(this.c.b, g.a(new File(paramPathResult.folderPath, "WAService"), str));
          g.c(this.c.b, g.a(new File(paramPathResult.folderPath, "WAVConsole"), str));
        }
        if (!this.c.b.f())
        {
          g.a(this.c.b, this.a, 1, null, "lib decode invalid");
          return;
        }
      }
      catch (Throwable paramPathResult)
      {
        for (;;)
        {
          paramPathResult.printStackTrace();
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApkgManager", 2, "initApkgByConfig - libs init finished:" + (System.currentTimeMillis() - this.b));
        }
        g.a(this.c.b, this.a, 0, null, "lib init finished");
        return;
      }
    }
    g.a(this.c.b, this.a, 1, null, "download lib failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.i
 * JD-Core Version:    0.7.0.1
 */