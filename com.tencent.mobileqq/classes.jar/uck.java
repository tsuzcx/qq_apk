import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class uck
  implements View.OnClickListener
{
  uck(ucj paramucj, uci paramuci) {}
  
  public void onClick(View paramView)
  {
    bcef.b(this.jdField_a_of_type_Ucj.jdField_a_of_type_Uci.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005732", "0X8005732", 0, 0, "", "", "", "");
    bcef.b(this.jdField_a_of_type_Ucj.jdField_a_of_type_Uci.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800642F", "0X800642F", 0, 0, String.valueOf(this.jdField_a_of_type_Ucj.jdField_a_of_type_Uch.jdField_a_of_type_Long), "", "", "");
    String str;
    if (this.jdField_a_of_type_Ucj.jdField_a_of_type_Uch != null)
    {
      str = String.valueOf(this.jdField_a_of_type_Ucj.jdField_a_of_type_Uch.jdField_a_of_type_Long);
      if (!TextUtils.isEmpty(str)) {
        break label116;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label116:
      if (this.jdField_a_of_type_Ucj.jdField_a_of_type_Uch.jdField_a_of_type_Int == 0)
      {
        if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_Ucj.jdField_a_of_type_Uci.jdField_a_of_type_AndroidAppActivity.getApplicationContext()))
        {
          QQToast.a(this.jdField_a_of_type_Ucj.jdField_a_of_type_Uci.jdField_a_of_type_AndroidAppActivity, 2131694064, 0).b(((BaseActivity)this.jdField_a_of_type_Ucj.jdField_a_of_type_Uci.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight());
        }
        else
        {
          this.jdField_a_of_type_Ucj.a(2);
          this.jdField_a_of_type_Ucj.jdField_a_of_type_Uch.jdField_a_of_type_Int = 2;
          MqqHandler localMqqHandler = this.jdField_a_of_type_Ucj.jdField_a_of_type_Uci.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(SubscriptFeedsActivity.class);
          if ((localMqqHandler != null) && (this.jdField_a_of_type_Ucj.jdField_a_of_type_Uci.jdField_a_of_type_AndroidAppActivity != null) && ((this.jdField_a_of_type_Ucj.jdField_a_of_type_Uci.jdField_a_of_type_AndroidAppActivity instanceof SubscriptFeedsActivity))) {
            localMqqHandler.sendEmptyMessage(1007);
          }
          ugf.a(this.jdField_a_of_type_Ucj.jdField_a_of_type_Uci.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ucj.jdField_a_of_type_Uci.jdField_a_of_type_AndroidAppActivity, str, new uco(this.jdField_a_of_type_Ucj.jdField_a_of_type_Uci, this.jdField_a_of_type_Ucj));
        }
      }
      else {
        ucj.a(this.jdField_a_of_type_Ucj);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     uck
 * JD-Core Version:    0.7.0.1
 */