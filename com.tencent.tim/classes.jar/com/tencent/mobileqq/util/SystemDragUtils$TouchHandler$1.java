package com.tencent.mobileqq.util;

import android.content.Context;
import aqfl;
import aqfl.c;
import aurs;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import java.lang.ref.WeakReference;

public class SystemDragUtils$TouchHandler$1
  implements Runnable
{
  public SystemDragUtils$TouchHandler$1(aqfl.c paramc, BaseBubbleBuilder.e parame) {}
  
  public void run()
  {
    aurs.runOnUiThread(new SystemDragUtils.TouchHandler.1.1(this, aqfl.b((Context)this.this$0.iq.get(), this.d)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.SystemDragUtils.TouchHandler.1
 * JD-Core Version:    0.7.0.1
 */