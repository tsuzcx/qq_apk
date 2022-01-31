import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.mobileqq.werewolves.WereWolvesLoadingView;
import com.tencent.mobileqq.werewolves.WerewolvesObserver;
import com.tencent.mobileqq.werewolves.WerewolvesPluginInterface;
import com.tencent.mobileqq.werewolves.WerewolvesPluginManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class vtx
  extends WerewolvesObserver
{
  public vtx(GameRoomChatPie paramGameRoomChatPie) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.werewolf.GameRoomChatPie", 2, "onDownLoadedPluginResult result = " + paramInt);
    }
    if (paramInt == 0) {
      this.a.bf();
    }
    do
    {
      return;
      QQToast.a(this.a.a(), "游戏加载失败", 0).a();
    } while (this.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView == null);
    this.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.setProgress(0);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.werewolf.GameRoomChatPie", 2, "onNotifyGameRoomSpeakerStatus uin = " + paramLong2 + " isSeaking = " + paramBoolean);
    }
    if ((!this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(String.valueOf(paramLong1))) || (this.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager == null)) {}
    WerewolvesPluginInterface localWerewolvesPluginInterface;
    do
    {
      return;
      localWerewolvesPluginInterface = this.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    } while (localWerewolvesPluginInterface == null);
    localWerewolvesPluginInterface.a(String.valueOf(paramLong2), paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vtx
 * JD-Core Version:    0.7.0.1
 */