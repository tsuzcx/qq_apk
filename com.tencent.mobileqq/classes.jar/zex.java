import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.gameroom.GameRoomAVController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class zex
  implements Runnable
{
  public zex(HotChatHandler paramHotChatHandler, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    if ((!GameRoomAVController.a().jdField_a_of_type_Boolean) && (!GameRoomAVController.a().c))
    {
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        break label110;
      }
      localHotChatInfo = (HotChatInfo)this.jdField_a_of_type_JavaUtilList.get(0);
    }
    label110:
    while (GameRoomAVController.a().a() != 1) {
      try
      {
        long l = Long.parseLong(localHotChatInfo.troopUin);
        GameRoomAVController.a().a(1, null, l, localHotChatInfo.name);
        return;
      }
      catch (Exception localException)
      {
        HotChatInfo localHotChatInfo;
        while (!QLog.isColorLevel()) {}
        QLog.e("HotChatHandler", 2, "handleGetMyHostChatListRespError hc.troopUin: " + localHotChatInfo.troopUin);
        return;
      }
    }
    GameRoomAVController.a().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zex
 * JD-Core Version:    0.7.0.1
 */