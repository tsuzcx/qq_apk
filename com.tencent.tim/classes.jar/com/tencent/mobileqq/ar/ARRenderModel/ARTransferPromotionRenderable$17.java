package com.tencent.mobileqq.ar.ARRenderModel;

import adbk;
import adbm.a;
import adda;
import addg;
import addi;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ARTransferPromotionRenderable$17
  implements Runnable
{
  public ARTransferPromotionRenderable$17(addg paramaddg, View paramView) {}
  
  public void run()
  {
    float f = addg.a(this.this$0).getRotateDegree();
    boolean bool = addg.a(this.this$0).ud.isEmpty();
    addg.e(this.this$0);
    if (this.this$0.cCJ != 4)
    {
      QLog.d("ARTransferPromotionRenderable", 1, "not under nativeGameStatus:GameStatus_INSIDE_WORLD_360 mNativeGameStatus:" + this.this$0.cCJ);
      addg.d(this.this$0, false);
    }
    adbm.a locala;
    do
    {
      do
      {
        return;
        ThreadManager.getSubThreadHandler().post(new ARTransferPromotionRenderable.17.1(this, f));
        if (!bool) {
          break;
        }
      } while (addg.a(this.this$0) == null);
      addg.a(this.this$0).hg(2, 0);
      return;
      locala = addg.a(this.this$0).a((int)f);
      if ((locala == null) || (TextUtils.isEmpty(locala.mVideoUrl))) {
        break;
      }
    } while (addg.a(this.this$0) != 6);
    if (addg.a(this.this$0).isPlaying()) {
      addg.a(this.this$0).akG();
    }
    addg.a(this.this$0, locala);
    addg.a(this.this$0, new ARTransferPromotionRenderable.17.2(this));
    addg.a(this.this$0);
    ThreadManager.getUIHandler().post(new ARTransferPromotionRenderable.17.3(this));
    QLog.d("ARTransferPromotionRenderable", 1, "switchGameStatus ARPromotionConstant.GameStatus_WORLD_360_VIDEO_OVER fit current degree:" + f);
    return;
    addg.d(this.this$0, false);
    QLog.d("ARTransferPromotionRenderable", 1, "switchGameStatus ARPromotionConstant.GameStatus_WORLD_360_VIDEO_OVER not fit degree " + f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.17
 * JD-Core Version:    0.7.0.1
 */