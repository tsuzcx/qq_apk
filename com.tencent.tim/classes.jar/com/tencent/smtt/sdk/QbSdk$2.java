package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import com.tencent.smtt.utils.TbsLog;

final class QbSdk$2
  extends Thread
{
  QbSdk$2(Context paramContext, Handler paramHandler) {}
  
  public void run()
  {
    int i = q.a().a(true, this.a);
    TbsDownloader.setAppContext(this.a);
    TbsLog.i("QbSdk", "QbSdk preinit ver is " + i);
    Object localObject = q.a();
    Context localContext = this.a;
    if (g.a == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((q)localObject).b(localContext, bool);
      TbsLog.i("QbSdk", "preInit", "#2-1# prepare initAndLoadSo");
      g.a(true).a(this.a, false, false, null);
      TbsLog.i("QbSdk", "preInit", "#2-2# SDKEngine init finish");
      localObject = y.a();
      ((y)localObject).a(this.a, null);
      TbsLog.i("QbSdk", "preInit", "#2-3# X5CoreEngine init finish");
      bool = ((y)localObject).b();
      this.b.sendEmptyMessage(3);
      if (bool) {
        break;
      }
      this.b.sendEmptyMessage(2);
      return;
    }
    this.b.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdk.2
 * JD-Core Version:    0.7.0.1
 */