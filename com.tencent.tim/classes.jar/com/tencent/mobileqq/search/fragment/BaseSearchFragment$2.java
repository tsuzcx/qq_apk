package com.tencent.mobileqq.search.fragment;

import amwd;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class BaseSearchFragment$2
  implements Runnable
{
  BaseSearchFragment$2(BaseSearchFragment paramBaseSearchFragment, boolean paramBoolean) {}
  
  public void run()
  {
    if (!this.this$0.cDy)
    {
      this.this$0.a.init();
      this.this$0.cDy = true;
    }
    ThreadManager.getUIHandler().post(new BaseSearchFragment.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.BaseSearchFragment.2
 * JD-Core Version:    0.7.0.1
 */