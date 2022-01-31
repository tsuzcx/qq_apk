import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import cooperation.qqindividuality.QQIndividualityBridgeActivity;
import cooperation.qqindividuality.QQIndividualityUtils;

public class vjx
  implements View.OnClickListener
{
  public vjx(RichStatItemBuilder paramRichStatItemBuilder) {}
  
  public void onClick(View paramView)
  {
    String str = IndividuationUrlHelper.a("signatureHistoryH5Url");
    if ((!TextUtils.isEmpty(str)) && (str.startsWith("http")))
    {
      paramView = str;
      if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        paramView = str + "&fuin=" + this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      }
      VasWebviewUtil.openQQBrowserWithoutAD(this.a.jdField_a_of_type_AndroidContentContext, paramView, -1L, null, false, -1);
    }
    for (;;)
    {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "signiture", "aio_clk_his", 0, 0, "", "", "", "");
      return;
      paramView = new Intent(this.a.jdField_a_of_type_AndroidContentContext, QQIndividualityBridgeActivity.class);
      paramView.putExtra("key_uin", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      paramView.putExtra("key__entry_type", 2);
      paramView.putExtra(QQIndividualityUtils.l, 2);
      paramView.putExtra("key_uin_name", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      paramView.putExtra(QQIndividualityUtils.e, "path");
      paramView.putExtra(QQIndividualityUtils.f, "name");
      this.a.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vjx
 * JD-Core Version:    0.7.0.1
 */