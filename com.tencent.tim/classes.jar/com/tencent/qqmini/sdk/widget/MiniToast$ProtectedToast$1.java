package com.tencent.qqmini.sdk.widget;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.qqmini.sdk.R.anim;
import com.tencent.qqmini.sdk.R.id;

class MiniToast$ProtectedToast$1
  implements Runnable
{
  MiniToast$ProtectedToast$1(MiniToast.ProtectedToast paramProtectedToast) {}
  
  public void run()
  {
    this.this$0.cancel();
    this.this$0.getView().findViewById(R.id.toast_background);
    AnimationUtils.loadAnimation(this.this$0.getView().getContext(), R.anim.mini_sdk_toast_exit_anim);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.MiniToast.ProtectedToast.1
 * JD-Core Version:    0.7.0.1
 */