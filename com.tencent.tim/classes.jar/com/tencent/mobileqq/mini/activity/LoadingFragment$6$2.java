package com.tencent.mobileqq.mini.activity;

import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;

class LoadingFragment$6$2
  implements Runnable
{
  LoadingFragment$6$2(LoadingFragment.6 param6) {}
  
  public void run()
  {
    AppLoaderFactory.getAppLoaderManager().onBaselibUpdated(this.this$1.this$0.getActivity(), LoadingFragment.access$000(this.this$1.this$0));
    AppLoaderFactory.getAppLoaderManager().loadApkgByConfig(LoadingFragment.access$000(this.this$1.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.LoadingFragment.6.2
 * JD-Core Version:    0.7.0.1
 */