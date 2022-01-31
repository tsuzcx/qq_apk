import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.gameroom.GameRoomAVController;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.werewolves.WerewolvesHandler.Callback;
import com.tencent.mobileqq.widget.QQToast;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;

public class vrg
  implements WerewolvesHandler.Callback
{
  public vrg(GameRoomChatPie paramGameRoomChatPie) {}
  
  public void a(int paramInt, oidb_0x8ed.RspBody paramRspBody)
  {
    if ((paramInt == 0) && (this.a.X))
    {
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 2, "已成功退出游戏房间", 0).a();
      SharedPreUtils.l(this.a.a(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.a(this.a.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vrg
 * JD-Core Version:    0.7.0.1
 */