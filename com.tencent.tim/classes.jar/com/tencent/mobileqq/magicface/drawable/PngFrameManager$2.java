package com.tencent.mobileqq.magicface.drawable;

import afgc;
import afnu;
import aixk;
import aixk.c;
import aixo;
import ajdg;
import android.os.Handler;
import android.os.Message;
import aquz;
import aqva;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.io.File;

public class PngFrameManager$2
  implements Runnable
{
  public PngFrameManager$2(aixk paramaixk, aixk.c paramc) {}
  
  public void run()
  {
    File localFile = new File(afnu.bEu.replace("[epId]", this.a.epId));
    ajdg localajdg = (ajdg)this.this$0.mApp.getManager(14);
    ??? = localajdg.b(this.a.epId);
    Object localObject1 = ???;
    if (??? == null)
    {
      localObject1 = new EmoticonPackage();
      ((EmoticonPackage)localObject1).epId = this.a.epId;
      ((EmoticonPackage)localObject1).aio = true;
    }
    synchronized (this.this$0)
    {
      if (this.this$0.mHandler != null)
      {
        if (!localFile.exists()) {
          break label165;
        }
        this.a.type = this.this$0.a.e(localFile);
        this.this$0.mHandler.obtainMessage(224, this.a).sendToTarget();
        ((EmoticonPackage)localObject1).rscType = this.a.type;
        localajdg.m((EmoticonPackage)localObject1);
      }
      label165:
      aquz localaquz;
      do
      {
        return;
        localaquz = new aquz(afgc.kw(this.a.epId), localFile);
        localaquz.cWs = true;
      } while ((aqva.a(localaquz, this.this$0.mApp) != 0) || (this.this$0.a == null) || (this.this$0.mHandler == null));
      this.a.type = this.this$0.a.e(localFile);
      ((EmoticonPackage)localObject1).rscType = this.a.type;
      localajdg.m((EmoticonPackage)localObject1);
      this.this$0.mHandler.obtainMessage(224, this.a).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameManager.2
 * JD-Core Version:    0.7.0.1
 */