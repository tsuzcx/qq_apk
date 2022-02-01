package com.tencent.mobileqq.activity.aio.anim;

import android.view.View;
import aqqr;
import aqqs.a;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richstatus.RichStatusEditText;
import com.tencent.widget.ListView;
import mqq.os.MqqHandler;
import wnt;

public class SigTlpAnimation$2
  implements Runnable
{
  public SigTlpAnimation$2(wnt paramwnt, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (!this.asI.equals(this.this$0.aTv))
    {
      this.this$0.aTv = this.asI;
      localObject = aqqr.cb(this.this$0.aTw, this.val$dirPath);
      if (this.this$0.hB((String)localObject)) {}
    }
    else
    {
      return;
    }
    Object localObject = this.this$0.c;
    String[] arrayOfString = this.this$0.cA;
    if (this.this$0.a.interval != 0)
    {
      i = this.this$0.a.interval;
      ((VipPngPlayAnimationDrawable)localObject).c(arrayOfString, i);
      this.this$0.c.setCurrentType(103);
      if ((this.this$0.view == null) || (!(this.this$0.view instanceof RichStatusEditText)))
      {
        localObject = this.this$0.c;
        if (this.this$0.a.ece == 0) {
          break label219;
        }
      }
    }
    label219:
    for (int i = this.this$0.a.ece;; i = 3)
    {
      ((VipPngPlayAnimationDrawable)localObject).mRepeatCount = i;
      this.this$0.mView = new View(this.this$0.l.getContext());
      ThreadManager.getUIHandler().post(new SigTlpAnimation.2.1(this));
      return;
      i = 50;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.SigTlpAnimation.2
 * JD-Core Version:    0.7.0.1
 */