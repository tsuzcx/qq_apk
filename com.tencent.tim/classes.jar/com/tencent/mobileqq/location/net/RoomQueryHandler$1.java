package com.tencent.mobileqq.location.net;

import airc;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class RoomQueryHandler$1
  implements Runnable
{
  public RoomQueryHandler$1(airc paramairc, int paramInt, String paramString) {}
  
  public void run()
  {
    if (airc.a(this.this$0).get())
    {
      QLog.d("RoomQueryHandler", 1, new Object[] { "run: invoked. stop old loop query ", " uinType: ", Integer.valueOf(this.alR), " sessionUin: ", this.bfK });
      return;
    }
    airc.a(this.this$0, this.alR, this.bfK);
    airc.a(this.this$0).postDelayed(this, airc.access$200());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.RoomQueryHandler.1
 * JD-Core Version:    0.7.0.1
 */