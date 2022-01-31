import android.view.View;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import com.tencent.mobileqq.activity.contact.troop.RecommendTroopView;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecentManagerFor3rdPart;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.RecommendTroopMsg;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class wij
  implements ActionSheet.OnButtonClickListener
{
  public wij(TroopActivity paramTroopActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int j = 0;
    paramView = (RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.getManager(21);
    long l = 0L;
    int i = 0;
    switch (paramInt)
    {
    default: 
      i = 0;
      paramInt = j;
    case 0: 
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.a().c(AppConstants.S, 9000, -i);
        paramView = (RecentManagerFor3rdPart)this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.getManager(32);
        if (paramInt == 0) {
          break;
        }
        paramView.a(AppConstants.S, 9000);
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.getHandler(Conversation.class);
        if (paramView != null) {
          paramView.sendMessage(paramView.obtainMessage(1009));
        }
        return;
        i = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app);
        MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.getHandler(NotificationView.class);
        if (localMqqHandler != null) {
          localMqqHandler.sendEmptyMessage(1014);
        }
        if (paramView != null) {}
        for (paramView = paramView.a();; paramView = null)
        {
          if ((paramView != null) && (paramView.size() != 0)) {
            break label216;
          }
          paramInt = 1;
          break;
        }
        label216:
        l = ((RecommendTroopMsg)paramView.get(0)).timeStamp;
        paramInt = j;
      }
    }
    paramInt = i;
    if (paramView != null)
    {
      i = RecommendTroopManagerImp.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app);
      paramView.b();
      paramView.a();
      paramView.a(1);
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.getHandler(RecommendTroopView.class);
      paramInt = i;
      if (paramView != null)
      {
        paramView.sendEmptyMessage(105);
        paramInt = i;
      }
    }
    i = paramInt;
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.a().b(AppConstants.L, 0);
    if ((paramView == null) || (paramView.size() == 0)) {
      l = 0L;
    }
    for (paramInt = 1;; paramInt = 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app, "CliOper", "", "", "Grp_recommend", "Grp_recom_empty", 0, 0, "", "", "", "");
      ReportController.b(null, "P_CliOper", "Grp_recom", "", "msg_page", "Clk_del", 0, 0, "", "", "", "");
      break;
      l = ((MessageForSystemMsg)paramView.get(paramView.size() - 1)).getSystemMsg().msg_time.get() * 1000L;
    }
    paramView.a(AppConstants.S, 9000, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wij
 * JD-Core Version:    0.7.0.1
 */