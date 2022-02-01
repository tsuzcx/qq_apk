package com.tencent.mobileqq.jsp;

import aijf;
import aijg;
import aijh;
import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class IdentificationApiPlugin$1$1
  implements Runnable
{
  public IdentificationApiPlugin$1$1(aijg paramaijg, FaceDetectForThirdPartyManager.AppConf paramAppConf) {}
  
  public void run()
  {
    aijf.a(this.a.a);
    int i;
    if (Build.VERSION.SDK_INT >= 23) {
      if (aijf.a(this.a.a).checkSelfPermission("android.permission.CAMERA") == 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        ((QQBrowserActivity)aijf.a(this.a.a)).requestPermissions(new aijh(this), 1, new String[] { "android.permission.CAMERA" });
        return;
        i = 0;
      }
      else
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("FaceRecognition.AppConf", this.b);
        aijf.a(this.a.a, localIntent);
        return;
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.IdentificationApiPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */