package com.tencent.mobileqq.adapter;

import abej;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class ForwardRecentListAdapter$1
  implements Runnable
{
  public ForwardRecentListAdapter$1(abej paramabej, List paramList) {}
  
  public void run()
  {
    ArrayList localArrayList = abej.a(this.this$0, this.val$list);
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      ThreadManager.getUIHandler().post(new ForwardRecentListAdapter.1.1(this, localArrayList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ForwardRecentListAdapter.1
 * JD-Core Version:    0.7.0.1
 */