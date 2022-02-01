package com.tencent.mobileqq.minigame.publicaccount;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import arkn;

class MiniGamePublicAccountWebFragment$5
  implements arkn
{
  MiniGamePublicAccountWebFragment$5(MiniGamePublicAccountWebFragment paramMiniGamePublicAccountWebFragment) {}
  
  public void onItemLonClick(View paramView, int paramInt) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (paramInt == 5) {
      MiniGamePublicAccountWebFragment.access$1100(this.this$0);
    }
    while (paramInt != 1) {
      return;
    }
    this.this$0.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.5
 * JD-Core Version:    0.7.0.1
 */