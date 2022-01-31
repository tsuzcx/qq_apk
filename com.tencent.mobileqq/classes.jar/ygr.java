import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.activity.pendant.PendantMarketConfig.EntryConfig;
import com.tencent.mobileqq.adapter.AvatarPendantAdapter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class ygr
  implements View.OnClickListener
{
  public ygr(AvatarPendantAdapter paramAvatarPendantAdapter, PendantMarketConfig.EntryConfig paramEntryConfig, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqActivityPendantPendantMarketConfig$EntryConfig.b);
    paramView.putExtra("isShowAd", false);
    this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    if ((this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidContentContext instanceof AvatarPendantActivity)) {
      ((AvatarPendantActivity)this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidContentContext).a = -1L;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      VasWebviewUtil.reportCommercialDrainage("", "faceaddon", "0X8008486", "", 1, 0, 0, "", "", "");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006334", "0X8006334", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ygr
 * JD-Core Version:    0.7.0.1
 */