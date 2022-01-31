import android.os.Bundle;
import android.widget.EditText;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class btz
  extends FriendListObserver
{
  public btz(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  protected void b(boolean paramBoolean, Bundle paramBundle)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (paramBoolean)
    {
      if (paramBundle.getInt("resultCode") == 0)
      {
        String str = paramBundle.getString("friend_mobile_number");
        int i = paramBundle.getInt("friend_setting");
        int j = paramBundle.getInt("source_id");
        this.a.a(paramBundle.getString("uin"), (byte)i, true, this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), j, str, paramBundle.getByteArray("sig"));
        return;
      }
      if ((paramBundle.getString("ErrorString") != null) && (!paramBundle.getString("ErrorString").trim().equals(""))) {}
      for (paramBundle = paramBundle.getString("ErrorString");; paramBundle = this.a.getString(2131563223))
      {
        QQToast.a(this.a, 1, paramBundle, 1).b(this.a.d());
        return;
      }
    }
    QQToast.a(this.a, 1, this.a.getString(2131562783), 1).b(this.a.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     btz
 * JD-Core Version:    0.7.0.1
 */