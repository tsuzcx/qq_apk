package cooperation.qlink;

import android.content.ComponentName;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import ifq;
import ifr;
import ifs;
import ift;
import ifu;
import ifv;
import ifw;
import ifx;
import ify;

public class QlinkStandardDialogActivity
  extends BaseActivity
{
  static final String jdField_a_of_type_JavaLangString = "QlinkStandardDialogActivity";
  final DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new ifq(this);
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  boolean jdField_a_of_type_Boolean = false;
  String b;
  
  private void a(String paramString)
  {
    if (paramString == null)
    {
      QLog.e("QlinkStandardDialogActivity", 1, "[QLINK]-QQ createCannotNbyDialog: tips=null");
      return;
    }
    Object localObject = new ifx(this);
    ify localify = new ify(this);
    int i = 2131560875;
    if (-1 != paramString.indexOf(getString(2131560872))) {
      i = 2131560873;
    }
    for (;;)
    {
      paramString = DialogUtil.a(this, 230, getString(2131560867), paramString, 2131560874, i, (DialogInterface.OnClickListener)localObject, localify);
      paramString.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
      paramString.show();
      return;
      localObject = localify;
      localify = null;
    }
  }
  
  private void d()
  {
    Object localObject = new ifr(this);
    localObject = DialogUtil.a(this, 230, getString(2131560852), getString(2131560853), 2131560854, 2131560855, (DialogInterface.OnClickListener)localObject, null);
    ((QQCustomDialog)localObject).setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    ((QQCustomDialog)localObject).show();
  }
  
  private void e()
  {
    Object localObject = new ifs(this);
    localObject = DialogUtil.a(this, 230, getString(2131560868), getString(2131560856), 2131560857, 2131560858, (DialogInterface.OnClickListener)localObject, null);
    ((QQCustomDialog)localObject).setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    ((QQCustomDialog)localObject).show();
  }
  
  private void f()
  {
    Object localObject = new ift(this);
    ifu localifu = new ifu(this);
    localObject = DialogUtil.a(this, 230, getString(2131560867), getString(2131560859), 2131560860, 2131560861, (DialogInterface.OnClickListener)localObject, localifu);
    ((QQCustomDialog)localObject).setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    ((QQCustomDialog)localObject).show();
  }
  
  private void g()
  {
    Object localObject = new ifv(this);
    localObject = DialogUtil.a(this, 230, getString(2131560867), getString(2131560864), 2131560865, 2131560866, (DialogInterface.OnClickListener)localObject, null);
    ((QQCustomDialog)localObject).setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    ((QQCustomDialog)localObject).show();
  }
  
  private void h()
  {
    Object localObject = new ifw(this);
    localObject = DialogUtil.a(this, 230, getString(2131560867), getString(2131560869), 2131560870, 2131560871, (DialogInterface.OnClickListener)localObject, null);
    ((QQCustomDialog)localObject).setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    ((QQCustomDialog)localObject).show();
  }
  
  private void i()
  {
    Intent localIntent = new Intent("/");
    localIntent.setComponent(new ComponentName("com.android.settings", "com.android.settings.TetherSettings"));
    localIntent.setAction("android.intent.action.VIEW");
    startActivity(localIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setTitle(null);
    switch (getIntent().getIntExtra("str_type", 0))
    {
    default: 
      finish();
      return;
    case 1: 
      d();
      return;
    case 2: 
      e();
      return;
    case 3: 
      f();
      return;
    case 4: 
      g();
      return;
    case 5: 
      h();
      return;
    }
    a(getIntent().getStringExtra("param_cannotnby_tips"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qlink.QlinkStandardDialogActivity
 * JD-Core Version:    0.7.0.1
 */