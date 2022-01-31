import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.international.LocaleString;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class bwi
  extends FriendListObserver
{
  private bwi(AutoRemarkActivity paramAutoRemarkActivity) {}
  
  protected void a(String paramString, byte paramByte1, byte paramByte2)
  {
    if (((paramString == null) && (this.a.jdField_f_of_type_JavaLangString.equals(this.a.b.a()))) || ((paramString != null) && (paramString.equals(this.a.jdField_f_of_type_JavaLangString))))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      QQToast.a(this.a, 2, 2131562880, 0).b(this.a.d());
      this.a.setResult(-1, null);
      this.a.finish();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (!paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      QQToast.a(this.a, 1, 2131561435, 0).b(this.a.d());
      return;
    }
    if (NetworkUtil.e(this.a))
    {
      this.a.g = 0;
      if (!this.a.jdField_a_of_type_AndroidWidgetEditText.getText().equals(""))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(this.a.jdField_f_of_type_JavaLangString, this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(this.a.jdField_f_of_type_JavaLangString, (byte)this.a.jdField_f_of_type_Int, (byte)0);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    QQToast.a(this.a, 2, 2131562880, 0).b(this.a.d());
    this.a.setResult(-1);
    this.a.finish();
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (paramBoolean) {
      if (!AutoRemarkActivity.a(this.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AutoRemarkActivity", 2, "onGetAutoInfo remark = " + paramString1);
        }
        this.a.jdField_a_of_type_AndroidWidgetEditText.setText(paramString1);
      }
    }
    for (;;)
    {
      try
      {
        this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.a.jdField_a_of_type_AndroidWidgetEditText.getText().length());
        AutoRemarkActivity.a(this.a).setContentDescription(this.a.getResources().getString(2131562433) + this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
        this.a.jdField_f_of_type_Int = paramInt;
        LocaleString.a(this.a.a(this.a.jdField_f_of_type_Int), this.a.jdField_a_of_type_AndroidWidgetTextView);
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
      this.a.jdField_f_of_type_Int = 0;
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.a(this.a.jdField_f_of_type_Int));
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if ((paramBoolean) && (NetworkUtil.e(this.a)))
    {
      this.a.g = 0;
      this.a.jdField_f_of_type_JavaLangString = paramString1;
      this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(paramString1, (byte)this.a.jdField_f_of_type_Int, (byte)0);
      return;
    }
    if ((this.a.g == 2) || (!NetworkUtil.e(this.a)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      QQToast.a(this.a, 2, 2131562880, 0).b(this.a.d());
      this.a.setResult(-1, null);
      this.a.finish();
      return;
    }
    paramString2 = this.a;
    paramString2.g += 1;
    this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(paramString1, this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
  }
  
  protected void b(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (paramBoolean)
    {
      int i = paramBundle.getInt("resultCode");
      localObject = paramBundle.getString("uin");
      if (i == 0)
      {
        i = paramBundle.getInt("friend_setting");
        if (paramBundle.getString("nick_name") == null) {}
        switch (i)
        {
        default: 
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
          QQToast.a(this.a, 2, 2131562880, 0).b(this.a.d());
          this.a.a();
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          this.a.jdField_f_of_type_JavaLangString = ((String)localObject);
          this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a((String)localObject, this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), true);
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
          QQToast.a(this.a.a(), 2, 2131561615, 0).b(this.a.d());
          this.a.a();
          return;
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
          QQToast.a(this.a, 2, 2131562880, 0).b(this.a.d());
          this.a.a();
          return;
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("uin = ").append(paramBundle.getInt("uin")).append("adduin = ").append(paramBundle.getInt("adduin")).append("  uinsetting = ").append(paramBundle.getInt("adduinsetting")).append("  result = ").append(paramBundle.getInt("result")).append("   errorCode = ").append(paramBundle.getShort("errorCode"));
            QLog.d("AutoRemarkActivity", 2, ((StringBuilder)localObject).toString());
          }
          if ((paramBundle.getString("ErrorString") == null) || (paramBundle.getString("ErrorString").trim().equals(""))) {
            break;
          }
          paramBundle = paramBundle.getString("ErrorString");
          QQToast.a(this.a, 1, paramBundle, 0).b(this.a.d());
        } while (!QLog.isColorLevel());
        QLog.d("AutoRemarkActivity", 2, "add friend response error and ErroString = " + paramBundle);
        return;
        QQToast.a(this.a, 1, 2131562783, 0).b(this.a.d());
      } while (!QLog.isColorLevel());
      QLog.d("AutoRemarkActivity", 2, "add friend response error and no ErroString");
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      QQToast.a(this.a, 1, 2131562783, 0).b(this.a.d());
    } while (!QLog.isColorLevel());
    QLog.d("AutoRemarkActivity", 2, "add friend response error and isSuccuss = NO");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bwi
 * JD-Core Version:    0.7.0.1
 */