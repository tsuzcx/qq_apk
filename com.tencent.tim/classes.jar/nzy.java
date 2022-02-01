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

class nzy
  implements View.OnClickListener
{
  nzy(nzx.a parama, nzx paramnzx) {}
  
  public void onClick(View paramView)
  {
    anot.a(this.a.jdField_a_of_type_Nzx.mApp, "P_CliOper", "Pb_account_lifeservice", "", "0X8005732", "0X8005732", 0, 0, "", "", "", "");
    anot.a(this.a.jdField_a_of_type_Nzx.mApp, "CliOper", "", "", "0X800642F", "0X800642F", 0, 0, String.valueOf(this.a.jdField_a_of_type_Nzw.uin), "", "", "");
    String str;
    if (this.a.jdField_a_of_type_Nzw != null)
    {
      str = String.valueOf(this.a.jdField_a_of_type_Nzw.uin);
      if (!TextUtils.isEmpty(str)) {
        break label116;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label116:
      if (this.a.jdField_a_of_type_Nzw.followStatus == 0)
      {
        if (!aqiw.isNetSupport(this.a.jdField_a_of_type_Nzx.mActivity.getApplicationContext()))
        {
          QQToast.a(this.a.jdField_a_of_type_Nzx.mActivity, 2131696272, 0).show(((BaseActivity)this.a.jdField_a_of_type_Nzx.mActivity).getTitleBarHeight());
        }
        else
        {
          this.a.ut(2);
          this.a.jdField_a_of_type_Nzw.followStatus = 2;
          MqqHandler localMqqHandler = this.a.jdField_a_of_type_Nzx.mApp.getHandler(SubscriptFeedsActivity.class);
          if ((localMqqHandler != null) && (this.a.jdField_a_of_type_Nzx.mActivity != null) && ((this.a.jdField_a_of_type_Nzx.mActivity instanceof SubscriptFeedsActivity))) {
            localMqqHandler.sendEmptyMessage(1007);
          }
          ocp.a(this.a.jdField_a_of_type_Nzx.mApp, this.a.jdField_a_of_type_Nzx.mActivity, str, new nzx.b(this.a.jdField_a_of_type_Nzx, this.a));
        }
      }
      else {
        nzx.a.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nzy
 * JD-Core Version:    0.7.0.1
 */