package com.tencent.mobileqq.minigame.publicaccount;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;

class MiniGamePublicAccountWebFragment$8
  implements Runnable
{
  MiniGamePublicAccountWebFragment$8(MiniGamePublicAccountWebFragment paramMiniGamePublicAccountWebFragment, int paramInt) {}
  
  public void run()
  {
    if ((this.this$0.getActivity() != null) && (!this.this$0.getActivity().isFinishing()) && (MiniGamePublicAccountWebFragment.access$1300(this.this$0) != null)) {
      MiniGamePublicAccountWebFragment.access$1300(this.this$0).setCurrentItem(this.val$pos);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.8
 * JD-Core Version:    0.7.0.1
 */