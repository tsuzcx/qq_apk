import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.utils.QQCustomDialog;

final class uuf
  implements DialogInterface.OnClickListener
{
  uuf(Activity paramActivity, ProfileParams paramProfileParams, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        ForwardSdkShareOption.a(this.jdField_a_of_type_AndroidAppActivity, false, "shareToQzone", Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams.a()).longValue());
      } while ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing()));
      this.jdField_a_of_type_AndroidAppActivity.setResult(0);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
    } while (uuc.a == null);
    uuc.a.dismiss();
    uuc.a = null;
    this.jdField_a_of_type_AndroidAppActivity.finish();
    uuc.d(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uuf
 * JD-Core Version:    0.7.0.1
 */