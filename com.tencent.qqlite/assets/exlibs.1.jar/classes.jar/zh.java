import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class zh
  extends FriendListObserver
{
  private zh(AutoRemarkActivity paramAutoRemarkActivity) {}
  
  protected void a(String paramString, byte paramByte1, byte paramByte2)
  {
    if (((paramString == null) && (this.a.f.equals(this.a.app.a()))) || ((paramString != null) && (paramString.equals(this.a.f))))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      QQToast.a(this.a, 2, 2131363384, 0).b(this.a.getTitleBarHeight());
      this.a.setResult(-1, null);
      this.a.finish();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (!paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      QQToast.a(this.a, 1, 2131363385, 0).b(this.a.getTitleBarHeight());
      return;
    }
    if (NetworkUtil.e(this.a))
    {
      this.a.h = 0;
      paramString = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
      if (paramString.length() != 0)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.a.f, paramString, false);
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(this.a.f, (byte)this.a.g, (byte)0);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    QQToast.a(this.a, 2, 2131363384, 0).b(this.a.getTitleBarHeight());
    this.a.setResult(-1);
    this.a.finish();
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if ((paramBoolean) && (NetworkUtil.e(this.a)))
    {
      this.a.h = 0;
      this.a.f = paramString1;
      this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(paramString1, (byte)this.a.g, (byte)0);
      return;
    }
    if ((this.a.h == 2) || (!NetworkUtil.e(this.a)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      QQToast.a(this.a, 2, 2131363384, 0).b(this.a.getTitleBarHeight());
      this.a.setResult(-1, null);
      this.a.finish();
      return;
    }
    paramString2 = this.a;
    paramString2.h += 1;
    this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(paramString1, this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), false);
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if (!TextUtils.equals(this.a.f, paramString1)) {
      return;
    }
    if (paramBoolean) {
      if (!AutoRemarkActivity.a(this.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AutoRemarkActivity", 2, "onGetAutoInfo remark = " + paramString2);
        }
        this.a.jdField_a_of_type_AndroidWidgetEditText.setText(paramString2);
      }
    }
    for (;;)
    {
      try
      {
        this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.a.jdField_a_of_type_AndroidWidgetEditText.getText().length());
        AutoRemarkActivity.a(this.a).setContentDescription(this.a.getResources().getString(2131363027) + this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
        this.a.g = paramInt;
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.a(this.a.g));
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        return;
      }
      catch (IndexOutOfBoundsException paramString1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AutoRemarkActivity", 2, "onGetAutoInfo | IndexOutOfBoundsException");
        continue;
      }
      this.a.g = 0;
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.a(this.a.g));
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (!TextUtils.equals(paramString, this.a.f)) {}
    label354:
    do
    {
      do
      {
        do
        {
          return;
          if (!paramBoolean1) {
            break label354;
          }
          if (paramBundle.getInt("resultCode") == 0)
          {
            int i = paramBundle.getInt("friend_setting");
            if (paramBundle.getString("nick_name") == null) {}
            switch (i)
            {
            default: 
              this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
              QQToast.a(this.a, 2, 2131363384, 0).b(this.a.getTitleBarHeight());
              this.a.a();
              return;
            case 0: 
            case 100: 
              this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
              QQToast.a(this.a.getActivity(), 2, 2131363676, 0).b(this.a.getTitleBarHeight());
              this.a.a();
              return;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
            QQToast.a(this.a, 2, 2131363384, 0).b(this.a.getTitleBarHeight());
            this.a.a();
            return;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
          if ((paramBundle.getString("ErrorString") == null) || (paramBundle.getString("ErrorString").trim().equals(""))) {
            break;
          }
          paramString = paramBundle.getString("ErrorString");
          QQToast.a(this.a, 1, paramString, 0).b(this.a.getTitleBarHeight());
        } while (!QLog.isColorLevel());
        QLog.d("AutoRemarkActivity", 2, "add friend response error and ErroString = " + paramString);
        return;
        QQToast.a(this.a, 1, 2131363383, 0).b(this.a.getTitleBarHeight());
      } while (!QLog.isColorLevel());
      QLog.d("AutoRemarkActivity", 2, "add friend response error and no ErroString");
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      QQToast.a(this.a, 1, 2131363383, 0).b(this.a.getTitleBarHeight());
    } while (!QLog.isColorLevel());
    QLog.d("AutoRemarkActivity", 2, "add friend response error and isSuccuss = NO");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     zh
 * JD-Core Version:    0.7.0.1
 */