import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class vxl
  implements Runnable
{
  public vxl(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    this.a.bh();
    Object localObject1 = ((TroopGagMgr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, true);
    Object localObject2 = this.a.b.obtainMessage(2);
    ((Message)localObject2).obj = localObject1;
    this.a.b.sendMessage((Message)localObject2);
    localObject1 = ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    int i = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    int j = NetworkUtil.a(BaseApplicationImpl.getContext());
    if (((i == 1) || (i == 4) || ((i == -1) && (((TroopMessageManager)localObject2).c > 0))) && (((TroopMessageManager)localObject2).jdField_a_of_type_Boolean) && (localObject1 != null) && (((TroopInfo)localObject1).wMemberNum < ((TroopMessageManager)localObject2).b) && ((j == 4) || (j == 1))) {
      ((TroopMessageManager)localObject2).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, Math.min(this.a.q, ((TroopMessageManager)localObject2).jdField_a_of_type_Int));
    }
    i = DBUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "troop_game_feed", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.TroopChatPie", 2, "read game feed red dot, num=" + i);
    }
    localObject2 = TroopChatPie.j(this.a).obtainMessage(86);
    ((Message)localObject2).arg1 = i;
    ((Message)localObject2).sendToTarget();
    if ((localObject1 != null) && (((TroopInfo)localObject1).isGameBind())) {
      TroopReportor.a("Grp_game", "Grp_AIO", "aio_exp", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vxl
 * JD-Core Version:    0.7.0.1
 */