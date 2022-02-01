import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class bwg
  extends MessageObserver
{
  public bwg(AutoRemarkActivity paramAutoRemarkActivity) {}
  
  protected void a(String paramString)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      paramString = this.a.getString(2131562784);
      QQToast.a(this.a, 1, paramString, 0).b(this.a.d());
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    long l1 = FriendSystemMsgController.a().b();
    if (!TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      try
      {
        long l2 = Long.parseLong(paramString1);
        l1 = l2;
        if (paramBoolean) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        if (SystemMsgUtils.a(FriendSystemMsgController.a().a(Long.valueOf(l1)), paramInt3, paramString2, paramString4))
        {
          this.a.setResult(-1);
          this.a.finish();
        }
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    paramString1 = null;
    if (this.a.jdField_a_of_type_AndroidWidgetEditText != null) {
      paramString1 = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    }
    SystemMsgUtils.a(FriendSystemMsgController.a().a(Long.valueOf(l1)), paramInt1, paramString2, paramInt2);
    SystemMsgUtils.a(l1, paramInt1, paramString1, paramInt4);
    this.a.setResult(-1);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bwg
 * JD-Core Version:    0.7.0.1
 */