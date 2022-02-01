package com.tencent.qqmini.minigame.ui;

import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.IDrawableLoadedCallBack;

class LoadingUI$1
  implements MiniAppProxy.IDrawableLoadedCallBack
{
  LoadingUI$1(LoadingUI paramLoadingUI) {}
  
  public void onLoadSuccessed(Drawable paramDrawable)
  {
    LoadingUI.access$000(this.this$0).setVisibility(0);
    LoadingUI.access$100(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.LoadingUI.1
 * JD-Core Version:    0.7.0.1
 */