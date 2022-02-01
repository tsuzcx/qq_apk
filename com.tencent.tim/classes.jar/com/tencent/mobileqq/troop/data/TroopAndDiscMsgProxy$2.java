package com.tencent.mobileqq.troop.data;

import anpc;
import apav;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class TroopAndDiscMsgProxy$2
  implements Runnable
{
  public TroopAndDiscMsgProxy$2(apav paramapav, boolean paramBoolean) {}
  
  public void run()
  {
    anpc localanpc = anpc.a(BaseApplication.getContext());
    String str = apav.a(this.this$0).getCurrentAccountUin();
    if (!this.cPE) {}
    for (boolean bool = true;; bool = false)
    {
      localanpc.collectPerformance(str, "aio_break_point", bool, 0L, 0L, new HashMap(), "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAndDiscMsgProxy.2
 * JD-Core Version:    0.7.0.1
 */