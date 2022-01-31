import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecentManagerFor3rdPart;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class cey
  implements ActionSheet.OnButtonClickListener
{
  public cey(TroopActivity paramTroopActivity, ActionSheet paramActionSheet) {}
  
  public void a(View paramView, int paramInt)
  {
    int j = 0;
    int i;
    switch (paramInt)
    {
    default: 
      i = 0;
      paramInt = j;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.a().b(AppConstants.aj, 9000, -paramInt);
      paramView = (RecentManagerFor3rdPart)this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.getManager(30);
      if (i == 0) {
        break;
      }
      paramView.b(AppConstants.aj, 9000);
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.a(Conversation.class);
      if (paramView != null) {
        paramView.sendMessage(paramView.obtainMessage(1009));
      }
      return;
      paramInt = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app);
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.a(NotificationView.class);
      if (paramView != null) {
        paramView.sendEmptyMessage(1014);
      }
      i = 1;
    }
    paramView.a(AppConstants.aj, 9000, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cey
 * JD-Core Version:    0.7.0.1
 */