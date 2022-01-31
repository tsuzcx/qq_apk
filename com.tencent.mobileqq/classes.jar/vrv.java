import android.view.View;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class vrv
  implements ActionSheet.OnButtonClickListener
{
  public vrv(HotChatPie paramHotChatPie, ActionSheet paramActionSheet, ChatMessage paramChatMessage, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, this.jdField_a_of_type_JavaLangString, false, 1);
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.BaseTroopChatPie", 2, "del hot chat member onClick, uin=" + this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin);
      }
      if (!NetworkUtil.d(BaseApplication.getContext()))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a().getString(2131434794), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a().getTitleBarHeight());
        return;
      }
    } while ((HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a.a(35) == null);
    paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a(), 230).setMessage(2131437328).setNegativeButton(2131433682, new vrx(this)).setPositiveButton(2131433680, new vrw(this));
    paramView.setTitle(2131437327);
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vrv
 * JD-Core Version:    0.7.0.1
 */