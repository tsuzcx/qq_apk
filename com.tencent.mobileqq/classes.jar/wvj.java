import android.view.View;
import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class wvj
  implements ActionSheet.OnButtonClickListener
{
  public wvj(SettingActivity2 paramSettingActivity2, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
    DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2, 230, "停用手机通讯录匹配", "停用后，你将无法使用QQ跟手机通讯录中的朋友联系。服务器上属于你的通讯录加密数据也将被删除。", "停用", "取消", new wvk(this), new wvl(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wvj
 * JD-Core Version:    0.7.0.1
 */