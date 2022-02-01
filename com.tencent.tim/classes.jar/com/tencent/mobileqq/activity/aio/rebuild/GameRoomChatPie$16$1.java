package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import aree;
import com.tencent.mobileqq.werewolves.WereWolvesLoadingView;
import com.tencent.qphone.base.util.QLog;
import xzp;

class GameRoomChatPie$16$1
  implements Runnable
{
  GameRoomChatPie$16$1(GameRoomChatPie.16 param16) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.this$0.TAG, 2, "initPlugin! hasDestory = " + this.a.this$0.aSY);
    }
    if ((!this.a.this$0.aSY) && (this.a.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView != null))
    {
      this.a.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.ehz();
      xzp.a(this.a.this$0).removeView(this.a.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView);
      this.a.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.setBackgroundDrawable(null);
      this.a.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.root.setBackgroundDrawable(null);
      this.a.this$0.jdField_a_of_type_Aree.U((ViewGroup)this.a.this$0.xo);
      this.a.this$0.setDarkTheme(false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.16.1
 * JD-Core Version:    0.7.0.1
 */