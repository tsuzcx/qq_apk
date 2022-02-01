package com.tencent.mobileqq.ark;

import adqb;
import adqb.e;
import adqi;
import android.os.Bundle;
import aquz;
import aqva;
import aqvc;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.lang.ref.WeakReference;

public class ArkAppCGI$9
  implements Runnable
{
  public ArkAppCGI$9(adqb paramadqb, adqb.e parame) {}
  
  public void run()
  {
    try
    {
      Object localObject = (QQAppInterface)adqb.a(this.this$0).get();
      if (localObject == null)
      {
        ArkAppCenter.r("ArkApp.ArkAppCGI", "runTask_retry, app is null, return");
        return;
      }
      localObject = ((aqva)((QQAppInterface)localObject).getManager(47)).a(1);
      File localFile = new File(adqb.sL());
      this.a.rspFile = localFile;
      aquz localaquz = new aquz(this.a.url, localFile);
      localaquz.cWw = true;
      localaquz.cWy = true;
      if (this.a.cookie != null) {
        localaquz.addHeader("Cookie", this.a.cookie);
      }
      if (this.a.referer != null) {
        localaquz.addHeader("Referer", this.a.referer);
      }
      Bundle localBundle = new Bundle();
      ((aqvc)localObject).a(localaquz, new adqi(this, localFile), localBundle);
      return;
    }
    catch (Exception localException)
    {
      ArkAppCenter.r("ArkApp.ArkAppCGI", String.format("runTask fail, url=%s, msg=%s", new Object[] { this.a.url, localException.getMessage() }));
      adqb.a(this.this$0, this.a, false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.9
 * JD-Core Version:    0.7.0.1
 */