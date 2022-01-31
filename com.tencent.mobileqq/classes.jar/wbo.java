import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.concurrent.ConcurrentHashMap;

public class wbo
  implements View.OnClickListener
{
  public wbo(NearbyChatPie paramNearbyChatPie) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 == null) || (!(localObject1 instanceof Integer))) {
      return;
    }
    paramView = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) {
      paramView = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f;
    }
    for (;;)
    {
      switch (((Integer)localObject1).intValue())
      {
      default: 
        return;
      case 1: 
        ((NearbyCardManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(105)).d.put(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(1));
        localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001)
        {
          paramView = "2";
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) {}
          NearbyHandler.a((QQAppInterface)localObject1, (String)localObject2, paramView, "1", 2, new wbp(this));
          localObject1 = (ShieldMsgManger)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15);
          localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1001) {
            break label284;
          }
          paramView = "0";
          label235:
          if (!((ShieldMsgManger)localObject1).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break label290;
          }
        }
        label284:
        label290:
        for (localObject1 = "1";; localObject1 = "0")
        {
          ReportController.b((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "c2c_tmp", "follow_aio", 0, 0, paramView, "0", (String)localObject1, "");
          return;
          paramView = "1";
          break;
          paramView = "1";
          break label235;
        }
      }
      ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, false);
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8004953", "0X8004953", 0, 0, "", "", "", "");
      }
      Object localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001)
      {
        paramView = "0";
        if (!this.a.U) {
          break label458;
        }
      }
      label458:
      for (localObject1 = "0";; localObject1 = "1")
      {
        ReportController.b((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "c2c_tmp", "block_aio", 0, 0, paramView, "0", (String)localObject1, "");
        return;
        paramView = "1";
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wbo
 * JD-Core Version:    0.7.0.1
 */