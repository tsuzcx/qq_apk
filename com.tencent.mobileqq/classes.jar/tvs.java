import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class tvs
  implements View.OnClickListener
{
  tvs(tvr paramtvr, tvq paramtvq) {}
  
  public void onClick(View paramView)
  {
    bcst.b(this.jdField_a_of_type_Tvr.jdField_a_of_type_Tvq.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005732", "0X8005732", 0, 0, "", "", "", "");
    bcst.b(this.jdField_a_of_type_Tvr.jdField_a_of_type_Tvq.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800642F", "0X800642F", 0, 0, String.valueOf(this.jdField_a_of_type_Tvr.jdField_a_of_type_Tvp.jdField_a_of_type_Long), "", "", "");
    String str;
    if (this.jdField_a_of_type_Tvr.jdField_a_of_type_Tvp != null)
    {
      str = String.valueOf(this.jdField_a_of_type_Tvr.jdField_a_of_type_Tvp.jdField_a_of_type_Long);
      if (!TextUtils.isEmpty(str)) {
        break label116;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label116:
      if (this.jdField_a_of_type_Tvr.jdField_a_of_type_Tvp.jdField_a_of_type_Int == 0)
      {
        if (!bgnt.d(this.jdField_a_of_type_Tvr.jdField_a_of_type_Tvq.jdField_a_of_type_AndroidAppActivity.getApplicationContext()))
        {
          QQToast.a(this.jdField_a_of_type_Tvr.jdField_a_of_type_Tvq.jdField_a_of_type_AndroidAppActivity, 2131693948, 0).b(((BaseActivity)this.jdField_a_of_type_Tvr.jdField_a_of_type_Tvq.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight());
        }
        else
        {
          this.jdField_a_of_type_Tvr.a(2);
          this.jdField_a_of_type_Tvr.jdField_a_of_type_Tvp.jdField_a_of_type_Int = 2;
          MqqHandler localMqqHandler = this.jdField_a_of_type_Tvr.jdField_a_of_type_Tvq.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(SubscriptFeedsActivity.class);
          if ((localMqqHandler != null) && (this.jdField_a_of_type_Tvr.jdField_a_of_type_Tvq.jdField_a_of_type_AndroidAppActivity != null) && ((this.jdField_a_of_type_Tvr.jdField_a_of_type_Tvq.jdField_a_of_type_AndroidAppActivity instanceof SubscriptFeedsActivity))) {
            localMqqHandler.sendEmptyMessage(1007);
          }
          tzo.a(this.jdField_a_of_type_Tvr.jdField_a_of_type_Tvq.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Tvr.jdField_a_of_type_Tvq.jdField_a_of_type_AndroidAppActivity, str, new tvw(this.jdField_a_of_type_Tvr.jdField_a_of_type_Tvq, this.jdField_a_of_type_Tvr));
        }
      }
      else {
        tvr.a(this.jdField_a_of_type_Tvr);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tvs
 * JD-Core Version:    0.7.0.1
 */