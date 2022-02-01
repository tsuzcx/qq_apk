package com.tencent.mobileqq.unifiedebug;

import android.content.Context;
import apzu;
import apzu.a;
import com.tencent.qphone.base.util.QLog;
import java.util.Queue;

public class UnifiedDebugManager$5
  implements Runnable
{
  public UnifiedDebugManager$5(apzu paramapzu, long paramLong1, Context paramContext, String paramString1, int paramInt, long paramLong2, String paramString2) {}
  
  public void run()
  {
    synchronized (this.this$0.N)
    {
      apzu.a locala = (apzu.a)this.this$0.N.peek();
      if ((locala != null) && (locala.seq == this.kQ))
      {
        this.this$0.b(this.val$context, this.crW, this.dYc, this.val$delay, this.kQ, this.ccF);
        if (QLog.isColorLevel()) {
          QLog.d("UnifiedDebugManager", 2, "start debug(retry): seq=" + this.kQ);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.UnifiedDebugManager.5
 * JD-Core Version:    0.7.0.1
 */