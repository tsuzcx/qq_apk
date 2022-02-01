package com.tencent.mobileqq.app;

import android.net.Uri;
import android.text.TextUtils;
import aqge;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;

class QQAppInterface$15
  implements Runnable
{
  QQAppInterface$15(QQAppInterface paramQQAppInterface, int paramInt) {}
  
  public void run()
  {
    boolean bool1 = this.this$0.bF();
    boolean bool2 = this.this$0.abn();
    if ((!this.this$0.abt()) && (bool2) && (!bool1) && (!this.this$0.YI()) && (!this.this$0.YJ()) && (this.this$0.YK()) && (QQAppInterface.aj(this.this$0)))
    {
      Object localObject = SkinEngine.getInstances().getSkinRootPath();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new StringBuilder((String)localObject);
        ((StringBuilder)localObject).append(File.separatorChar).append("voice").append(File.separatorChar).append("tab").append(this.cxu).append(".mp3");
        File localFile = new File(((StringBuilder)localObject).toString());
        if (QLog.isColorLevel()) {
          QLog.d("playThemeVoice", 2, "Uri:" + ((StringBuilder)localObject).toString());
        }
        if (localFile.exists()) {
          aqge.a(Uri.fromFile(localFile), false, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.15
 * JD-Core Version:    0.7.0.1
 */