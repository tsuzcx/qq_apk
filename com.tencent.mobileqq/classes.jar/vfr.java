import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.statistics.ArkAppReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class vfr
  implements DialogInterface.OnClickListener
{
  public vfr(TextItemBuilder paramTextItemBuilder, QQCustomDialog paramQQCustomDialog, QQAppInterface paramQQAppInterface, View paramView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {}
    try
    {
      ArkRecommendController.a(((FragmentActivity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder.a).getChatFragment().a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ArkAppReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "__global__", "ArkAlertDialogNotConfirm", 0L, 0L, 0L, 0L, 0L, "", "");
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      ArkRecommendController.a(this.jdField_a_of_type_AndroidViewView.getContext(), "close", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      ArkAppCenter.b("ArkDialog", String.format("NegativeButton click failed, err=%s", new Object[] { paramDialogInterface.getMessage() }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vfr
 * JD-Core Version:    0.7.0.1
 */