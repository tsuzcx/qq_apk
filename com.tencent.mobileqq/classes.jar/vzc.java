import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.mobileqq.werewolves.WereWolvesLoadingView;
import com.tencent.mobileqq.werewolves.WerewolvesPluginManager;
import com.tencent.qphone.base.util.QLog;

class vzc
  implements Runnable
{
  vzc(vzb paramvzb) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.werewolf.GameRoomChatPie", 2, "initPlugin! hasDestory = " + GameRoomChatPie.a(this.a.a));
    }
    if ((!GameRoomChatPie.b(this.a.a)) && (this.a.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView != null))
    {
      this.a.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.c();
      GameRoomChatPie.a(this.a.a).removeView(this.a.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView);
      this.a.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.setBackgroundDrawable(null);
      this.a.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.b.setBackgroundDrawable(null);
      this.a.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a((ViewGroup)this.a.a.o);
      this.a.a.d(false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vzc
 * JD-Core Version:    0.7.0.1
 */