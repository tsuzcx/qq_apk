package com.tencent.mobileqq.magicface.drawable;

import afnu;
import afpu;
import aixk;
import aixk.c;
import aixm;
import aixp;
import android.os.Handler;
import android.os.Message;
import aqhq;
import aquz;
import aqvc;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.b;
import com.tencent.mobileqq.data.Emoticon;
import java.io.File;

public class PngFrameManager$3
  implements Runnable
{
  public PngFrameManager$3(aixk paramaixk, String paramString, aixk.c paramc) {}
  
  public void run()
  {
    if (aqhq.fileExists(this.val$path))
    {
      ??? = aixp.F(this.val$path);
      this.a.object = ???;
      synchronized (this.this$0)
      {
        if (this.this$0.mHandler != null) {
          this.this$0.mHandler.obtainMessage(227, this.a).sendToTarget();
        }
        return;
      }
    }
    ??? = this.a.c.c.e.eId;
    ??? = new aquz(afnu.bEm.replace("[eIdSub]", ((String)???).substring(0, 2)).replace("[eId]", (CharSequence)???).replace("[width]", "200").replace("[height]", "200"), new File(this.val$path));
    ((aquz)???).cWw = true;
    this.this$0.c.a((aquz)???, new aixm(this), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameManager.3
 * JD-Core Version:    0.7.0.1
 */