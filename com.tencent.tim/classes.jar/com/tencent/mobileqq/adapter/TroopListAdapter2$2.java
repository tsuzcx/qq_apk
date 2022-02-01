package com.tencent.mobileqq.adapter;

import abge;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

public class TroopListAdapter2$2
  implements Runnable
{
  public TroopListAdapter2$2(abge paramabge) {}
  
  public void run()
  {
    List localList = abge.a(this.this$0);
    ThreadManager.getUIHandler().post(new TroopListAdapter2.2.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TroopListAdapter2.2
 * JD-Core Version:    0.7.0.1
 */