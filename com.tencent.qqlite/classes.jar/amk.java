import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import cooperation.qqfav.QfavUtil;

public class amk
  implements DialogInterface.OnClickListener
{
  public amk(ForwardOperations paramForwardOperations) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = false;
    paramInt = this.a.c();
    if (paramInt == -1) {}
    for (;;)
    {
      return;
      String str;
      if (paramInt == 0)
      {
        paramDialogInterface = this.a.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("QQLite", 0);
        str = "favorites_first_share_" + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        bool = paramDialogInterface.getBoolean(str, true);
        if (!bool) {
          QfavUtil.a(this.a.jdField_a_of_type_AndroidAppActivity, 2131362749, 2);
        }
      }
      while (!bool)
      {
        ForwardOperations.a(this.a.jdField_a_of_type_AndroidAppActivity, true, "addToQQFavorites", this.a.jdField_a_of_type_Long);
        return;
        paramDialogInterface.edit().putBoolean(str, false).commit();
        paramDialogInterface = this.a.jdField_a_of_type_AndroidAppActivity.getString(2131362752);
        str = this.a.jdField_a_of_type_AndroidOsBundle.getString("app_name");
        StringBuilder localStringBuilder = new StringBuilder().append(paramDialogInterface);
        paramDialogInterface = str;
        if (TextUtils.isEmpty(str)) {
          paramDialogInterface = this.a.jdField_a_of_type_AndroidAppActivity.getString(2131362753);
        }
        paramDialogInterface = paramDialogInterface;
        paramDialogInterface = DialogUtil.a(this.a.jdField_a_of_type_AndroidAppActivity, 230, this.a.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131362688), this.a.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131362750), paramDialogInterface, this.a.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131362690), new aml(this), new amm(this));
        paramDialogInterface.setOnDismissListener(new amn(this));
        if (!this.a.jdField_a_of_type_AndroidAppActivity.isFinishing())
        {
          this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(null);
          paramDialogInterface.show();
          continue;
          if (2 == paramInt) {
            QfavUtil.a(this.a.jdField_a_of_type_AndroidAppActivity, 2131362718, 1);
          } else if (3 == paramInt) {
            QfavUtil.a(this.a.jdField_a_of_type_AndroidAppActivity, 2131362751, 1);
          } else {
            QfavUtil.a(this.a.jdField_a_of_type_AndroidAppActivity, 2131362748, 1);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     amk
 * JD-Core Version:    0.7.0.1
 */