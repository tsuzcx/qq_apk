import android.os.Handler;
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
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class egk
  implements ActionSheet.OnButtonClickListener
{
  public egk(TroopActivity paramTroopActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int j = 0;
    paramView = (RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.b.getManager(19);
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
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.b.a().b(AppConstants.ag, 9000, -i);
        paramView = (RecentManagerFor3rdPart)this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.b.getManager(31);
        if (paramInt == 0) {
          break;
        }
        paramView.b(AppConstants.ag, 9000);
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.b.a(Conversation.class);
        if (paramView != null) {
          paramView.sendMessage(paramView.obtainMessage(1009));
        }
        return;
        i = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.b);
        Handler localHandler = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.b.a(NotificationView.class);
        if (localHandler != null) {
          localHandler.sendEmptyMessage(1014);
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
      i = RecommendTroopManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.b);
      paramView.b();
      paramView.a();
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.b.a(RecommendTroopView.class);
      paramInt = i;
      if (paramView != null)
      {
        paramView.sendEmptyMessage(105);
        paramInt = i;
      }
    }
    i = paramInt;
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.b.a().a(AppConstants.aa, 0);
    if ((paramView == null) || (paramView.size() == 0)) {
      l = 0L;
    }
    for (paramInt = 1;; paramInt = 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.b, "CliOper", "", "", "Grp_recommend", "Grp_recom_empty", 0, 0, "", "", "", "");
      break;
      l = ((MessageForSystemMsg)paramView.get(paramView.size() - 1)).getSystemMsg().msg_time.get() * 1000L;
    }
    paramView.a(AppConstants.ag, 9000, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     egk
 * JD-Core Version:    0.7.0.1
 */