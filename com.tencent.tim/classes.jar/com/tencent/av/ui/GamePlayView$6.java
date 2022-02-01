package com.tencent.av.ui;

import android.app.Activity;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.av.gameplay.ARNativeBridge;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import igd;

class GamePlayView$6
  implements Runnable
{
  public void run()
  {
    GamePlayView.a(this.this$0).getWindowManager().getDefaultDisplay().getHeight();
    igd.aJ("ARZimuTask_GamePlayView", "createEngineBusiness " + GamePlayView.a(this.this$0).getWidth() + "|" + GamePlayView.a(this.this$0).getHeight() + "|" + this.val$height + "|" + this.aws);
    GamePlayView.a(this.this$0).nativeCreateEngineBusiness(this.val$id, this.val$path, GamePlayView.a(this.this$0), this.b, this.val$path, GamePlayView.a(this.this$0).getWindowManager().getDefaultDisplay().getWidth(), GamePlayView.a(this.this$0).getWindowManager().getDefaultDisplay().getHeight(), this.val$id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.GamePlayView.6
 * JD-Core Version:    0.7.0.1
 */