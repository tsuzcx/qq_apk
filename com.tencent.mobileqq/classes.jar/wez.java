import android.os.Handler;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class wez
  implements Runnable
{
  wez(wey paramwey, List paramList) {}
  
  public void run()
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_Wey.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    TroopInfo localTroopInfo = localTroopManager.a(this.jdField_a_of_type_Wey.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (localTroopInfo == null) {}
    label77:
    do
    {
      do
      {
        return;
      } while (StringUtil.a(localTroopInfo.troopowneruin));
      StringBuilder localStringBuilder = new StringBuilder();
      int i;
      int j;
      oidb_0x899.memberlist localmemberlist;
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        i = 0;
        j = 0;
        if (j >= i) {
          break label198;
        }
        localmemberlist = (oidb_0x899.memberlist)this.jdField_a_of_type_JavaUtilList.get(j);
        if ((localmemberlist != null) && (localmemberlist.uint64_member_uin.has())) {
          break label133;
        }
      }
      for (;;)
      {
        j += 1;
        break label77;
        i = this.jdField_a_of_type_JavaUtilList.size();
        break;
        long l = localmemberlist.uint64_member_uin.get();
        int k = localmemberlist.uint32_privilege.get();
        if (l != 0L) {
          if (k == 2) {
            localStringBuilder.append(l).append("|");
          } else if (k == 1) {
            localTroopInfo.troopowneruin = String.valueOf(l);
          }
        }
      }
      localTroopInfo.Administrator = localStringBuilder.toString();
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.TroopChatPie", 2, "onOIDB0X899_0_Ret: toopUin=" + this.jdField_a_of_type_Wey.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a + ", admin=" + localTroopInfo.Administrator + ", owner=" + localTroopInfo.troopowneruin);
      }
      localTroopManager.b(localTroopInfo);
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.TroopChatPie", 2, localTroopInfo.Administrator);
      }
      if (QLog.isColorLevel()) {
        QLog.d("troop_gag", 2, "onOIDB0X899_0_Ret, sendEmptyMessage-TIMER_ID, hasDestory=" + TroopChatPie.b(this.jdField_a_of_type_Wey.a));
      }
    } while (TroopChatPie.c(this.jdField_a_of_type_Wey.a));
    label133:
    label198:
    this.jdField_a_of_type_Wey.a.b.removeMessages(1);
    this.jdField_a_of_type_Wey.a.b.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wez
 * JD-Core Version:    0.7.0.1
 */