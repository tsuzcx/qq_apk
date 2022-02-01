package com.app.hubert.guide.core;

import com.app.hubert.guide.lifecycle.FragmentLifecycleAdapter;
import com.app.hubert.guide.util.LogUtil;

class Controller$5
  extends FragmentLifecycleAdapter
{
  Controller$5(Controller paramController) {}
  
  public void onDestroyView()
  {
    LogUtil.i("v4ListenerFragment.onDestroyView");
    this.this$0.remove();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.app.hubert.guide.core.Controller.5
 * JD-Core Version:    0.7.0.1
 */