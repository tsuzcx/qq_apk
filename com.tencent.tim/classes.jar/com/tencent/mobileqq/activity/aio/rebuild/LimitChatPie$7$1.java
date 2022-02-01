package com.tencent.mobileqq.activity.aio.rebuild;

import aftr;
import afxx;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import ybb;
import ybj;

public class LimitChatPie$7$1
  implements Runnable
{
  public LimitChatPie$7$1(ybj paramybj, int paramInt, aftr paramaftr) {}
  
  public void run()
  {
    afxx.a(this.jdField_a_of_type_Ybj.this$0.app, this.alR, this.jdField_a_of_type_Aftr);
    ThreadManager.getUIHandler().post(new LimitChatPie.7.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.7.1
 * JD-Core Version:    0.7.0.1
 */