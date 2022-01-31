import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class wx
  extends FriendListObserver
{
  public wx(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString1, AddFriendVerifyActivity.a(this.a))) && (!TextUtils.isEmpty(paramString2))) {
      AddFriendVerifyActivity.c(this.a).setText(paramString2);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (!AddFriendVerifyActivity.a(this.a).equals(paramString)) {
      return;
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        this.a.a(this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim(), paramBundle.getByteArray("sig"));
        return;
      }
      if ((paramBundle.getString("ErrorString") != null) && (!paramBundle.getString("ErrorString").trim().equals(""))) {}
      for (paramString = paramBundle.getString("ErrorString");; paramString = this.a.getString(2131363405))
      {
        QQToast.a(this.a, 1, paramString, 1).b(this.a.getTitleBarHeight());
        return;
      }
    }
    QQToast.a(this.a, 1, this.a.getString(2131363397), 1).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     wx
 * JD-Core Version:    0.7.0.1
 */