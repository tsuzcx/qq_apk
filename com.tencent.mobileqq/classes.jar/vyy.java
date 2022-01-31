import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.werewolves.WerewolvesPluginInterface;

public class vyy
  implements DialogInterface.OnClickListener
{
  public vyy(GameRoomChatPie paramGameRoomChatPie, boolean paramBoolean, WerewolvesPluginInterface paramWerewolvesPluginInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.W = true;
    GameRoomChatPie.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.V = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface.a()) && (!this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface.b())) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.a, "dc00899", "Grp_wolf", "", "ready_time", "ready_kick", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vyy
 * JD-Core Version:    0.7.0.1
 */