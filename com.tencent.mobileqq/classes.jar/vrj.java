import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.werewolves.WerewolvesPluginInterface;

public class vrj
  implements DialogInterface.OnClickListener
{
  public vrj(GameRoomChatPie paramGameRoomChatPie, WerewolvesPluginInterface paramWerewolvesPluginInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.W = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.V = true;
    GameRoomChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie, false);
    if ((this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface.a()) && (!this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface.b())) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.a, "dc00899", "Grp_wolf", "", "ready_time", "ready_kick", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vrj
 * JD-Core Version:    0.7.0.1
 */