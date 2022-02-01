package com.tencent.mobileqq.minigame.publicaccount;

import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.d;
import com.tencent.mobileqq.app.ThreadManagerV2;

class MiniGamePublicAccountWebFragment$3
  implements PreloadManager.d
{
  MiniGamePublicAccountWebFragment$3(MiniGamePublicAccountWebFragment paramMiniGamePublicAccountWebFragment, View paramView) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    ThreadManagerV2.getUIHandlerV2().post(new MiniGamePublicAccountWebFragment.3.1(this, paramInt, paramPathResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.3
 * JD-Core Version:    0.7.0.1
 */