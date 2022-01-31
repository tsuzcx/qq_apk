import android.view.View;
import com.tencent.mobileqq.activity.PhoneUnityChangeActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class tkr
  implements ActionSheet.OnButtonClickListener
{
  public tkr(PhoneUnityChangeActivity paramPhoneUnityChangeActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.a.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
    if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.a, 230, "解除手机号码绑定", "解除绑定，将降低QQ的安全性，并将无法发QQ消息给手机通讯录联系人（服务器存储的通讯录数据也将被删除）、无法在QQ查看手机话费。注:解绑不影响密码保护功能。", "解绑", "取消", new tks(this), new tkt(this));
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (!this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) && (!this.a.isFinishing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tkr
 * JD-Core Version:    0.7.0.1
 */