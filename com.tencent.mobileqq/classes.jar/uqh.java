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

class uqh
  implements View.OnClickListener
{
  uqh(uqg paramuqg, uqf paramuqf) {}
  
  public void onClick(View paramView)
  {
    bdla.b(this.jdField_a_of_type_Uqg.jdField_a_of_type_Uqf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005732", "0X8005732", 0, 0, "", "", "", "");
    bdla.b(this.jdField_a_of_type_Uqg.jdField_a_of_type_Uqf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800642F", "0X800642F", 0, 0, String.valueOf(this.jdField_a_of_type_Uqg.jdField_a_of_type_Uqe.jdField_a_of_type_Long), "", "", "");
    String str;
    if (this.jdField_a_of_type_Uqg.jdField_a_of_type_Uqe != null)
    {
      str = String.valueOf(this.jdField_a_of_type_Uqg.jdField_a_of_type_Uqe.jdField_a_of_type_Long);
      if (!TextUtils.isEmpty(str)) {
        break label116;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label116:
      if (this.jdField_a_of_type_Uqg.jdField_a_of_type_Uqe.jdField_a_of_type_Int == 0)
      {
        if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_Uqg.jdField_a_of_type_Uqf.jdField_a_of_type_AndroidAppActivity.getApplicationContext()))
        {
          QQToast.a(this.jdField_a_of_type_Uqg.jdField_a_of_type_Uqf.jdField_a_of_type_AndroidAppActivity, 2131694255, 0).b(((BaseActivity)this.jdField_a_of_type_Uqg.jdField_a_of_type_Uqf.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight());
        }
        else
        {
          this.jdField_a_of_type_Uqg.a(2);
          this.jdField_a_of_type_Uqg.jdField_a_of_type_Uqe.jdField_a_of_type_Int = 2;
          MqqHandler localMqqHandler = this.jdField_a_of_type_Uqg.jdField_a_of_type_Uqf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(SubscriptFeedsActivity.class);
          if ((localMqqHandler != null) && (this.jdField_a_of_type_Uqg.jdField_a_of_type_Uqf.jdField_a_of_type_AndroidAppActivity != null) && ((this.jdField_a_of_type_Uqg.jdField_a_of_type_Uqf.jdField_a_of_type_AndroidAppActivity instanceof SubscriptFeedsActivity))) {
            localMqqHandler.sendEmptyMessage(1007);
          }
          uuc.a(this.jdField_a_of_type_Uqg.jdField_a_of_type_Uqf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Uqg.jdField_a_of_type_Uqf.jdField_a_of_type_AndroidAppActivity, str, new uql(this.jdField_a_of_type_Uqg.jdField_a_of_type_Uqf, this.jdField_a_of_type_Uqg));
        }
      }
      else {
        uqg.a(this.jdField_a_of_type_Uqg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uqh
 * JD-Core Version:    0.7.0.1
 */