package com.tencent.qqmini.sdk.launcher;

import com.tencent.qqmini.sdk.widget.MiniToast;

class MiniAppInfoLoadingFragment$3
  implements Runnable
{
  MiniAppInfoLoadingFragment$3(MiniAppInfoLoadingFragment paramMiniAppInfoLoadingFragment) {}
  
  public void run()
  {
    MiniToast.makeText(this.this$0.getActivity(), 1, "启动失败，小程序包配置错误", 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.MiniAppInfoLoadingFragment.3
 * JD-Core Version:    0.7.0.1
 */