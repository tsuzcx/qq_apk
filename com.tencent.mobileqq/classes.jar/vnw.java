import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.ArkHighLightClickCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.statistics.ArkAppReportController;
import com.tencent.mobileqq.text.QQText.ArkHighlightSpan;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class vnw
  implements DialogInterface.OnClickListener
{
  public vnw(TextItemBuilder paramTextItemBuilder, QQCustomDialog paramQQCustomDialog, View paramView, TextItemBuilder.ArkHighLightClickCallback paramArkHighLightClickCallback, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {}
    try
    {
      QQText.ArkHighlightSpan.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder$ArkHighLightClickCallback);
      ArkAppReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "__global__", "ArkAlertDialogConfirm", 0L, 0L, 0L, 0L, 0L, "", "");
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      ArkRecommendController.a(this.jdField_a_of_type_AndroidViewView.getContext(), "open", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      ArkAppCenter.b("ArkDialog", String.format("PositiveButton click failed, err=%s", new Object[] { paramDialogInterface.getMessage() }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vnw
 * JD-Core Version:    0.7.0.1
 */