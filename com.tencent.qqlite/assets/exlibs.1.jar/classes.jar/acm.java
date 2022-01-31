import android.content.Context;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.data.ChatBackgroundInfo;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;

class acm
  implements View.OnClickListener
{
  acm(acl paramacl) {}
  
  public void onClick(View paramView)
  {
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      Toast.makeText(this.a.a.jdField_a_of_type_AndroidAppActivity, this.a.a.getBaseContext().getString(2131363511), 0).show();
      return;
    }
    paramView = (ChatBackgroundInfo)((View)paramView.getParent()).getTag();
    if (paramView.type.equals("1"))
    {
      if (this.a.a.jdField_a_of_type_ComTencentMobileqqAppSVIPHandler.c() >= 1)
      {
        str = AppConstants.bb + paramView.id + ".png";
        if (!NetworkUtil.e(BaseApplication.getContext()))
        {
          Toast.makeText(this.a.a.jdField_a_of_type_AndroidAppActivity, this.a.a.getBaseContext().getString(2131363376), 0).show();
          return;
        }
        this.a.a.app.a().a(paramView.url, str);
        return;
      }
      DialogUtil.a(this.a.a, 230).setTitle(this.a.a.getString(2131362939)).setMessage(this.a.a.getString(2131364068)).setPositiveButton(this.a.a.getString(2131364293), new aco(this, paramView)).setNegativeButton(this.a.a.getString(2131362794), new acn(this)).show();
      return;
    }
    String str = AppConstants.bb + paramView.id + ".png";
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      Toast.makeText(this.a.a.jdField_a_of_type_AndroidAppActivity, this.a.a.getBaseContext().getString(2131363376), 0).show();
      return;
    }
    this.a.a.app.a().a(paramView.url, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     acm
 * JD-Core Version:    0.7.0.1
 */