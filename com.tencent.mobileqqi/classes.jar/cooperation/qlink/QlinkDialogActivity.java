package cooperation.qlink;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CheckPttListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import iap;
import iaq;
import iar;
import ias;

public class QlinkDialogActivity
  extends BaseActivity
{
  static final String jdField_a_of_type_JavaLangString = "QlinkDialogActivity";
  private static final long[] jdField_a_of_type_ArrayOfLong = { 100L, 200L, 200L, 100L };
  public QQCustomDialog a;
  public boolean a;
  String b;
  
  public QlinkDialogActivity()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Activity paramActivity, String paramString, int paramInt)
  {
    paramActivity = new ProfileActivity.AllInOne(paramString, 40);
    paramActivity.e = 4;
    paramActivity.f = 5;
    Intent localIntent = new Intent(this, ChatActivity.class);
    if (((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramString)) {
      paramInt = 0;
    }
    for (;;)
    {
      localIntent.putExtra("uin", paramString);
      localIntent.putExtra("uintype", paramInt);
      localIntent.putExtra("uinname", paramActivity.g);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
      return;
      paramInt = 1001;
      localIntent.putExtra("rich_accost_sig", FMDataCache.a(paramString));
    }
  }
  
  private void a(Activity paramActivity, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString2);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    iap localiap = new iap(this, paramString1);
    paramString1 = new iaq(this, paramString1);
    iar localiar = new iar(this);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new ias(this, paramActivity, paramString2, localiap, paramString1, localiar));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(paramActivity, 230, paramActivity.getString(2131560849), paramString2, 2131560847, 2131560848, localiap, paramString1);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(localiar);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  void a(Intent paramIntent)
  {
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    paramIntent = paramIntent.getStringExtra("qlink_content");
    a(this, this.jdField_b_of_type_JavaLangString, paramIntent);
    a(this.jdField_b_of_type_JavaLangString, true);
  }
  
  void a(String paramString, boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramString == null)) {}
    boolean bool1;
    boolean bool2;
    SharedPreferences localSharedPreferences;
    do
    {
      Vibrator localVibrator;
      do
      {
        do
        {
          return;
          System.currentTimeMillis();
          bool1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.g();
          bool2 = NoDisturbUtil.a(((BaseApplicationImpl)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
        } while ((bool1) || (!bool2));
        localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
        localVibrator = (Vibrator)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSystemService("vibrator");
      } while (localVibrator == null);
      bool1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c();
      bool2 = d();
      boolean bool3 = c();
      boolean bool4 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.l();
      boolean bool5 = e();
      if ((bool3) && (bool4) && (!bool1) && (bool5)) {
        localVibrator.vibrate(jdField_a_of_type_ArrayOfLong, -1);
      }
    } while ((!paramBoolean) || (!bool2) || (bool1) || (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.j()) || (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.k()) || (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.l()) || (!e()));
    int i = localSharedPreferences.getInt("sound_type" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131165197);
    if (a(paramString)) {
      i = 2131165215;
    }
    for (;;)
    {
      ((BaseApplicationImpl)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).a(i, false);
      return;
    }
  }
  
  boolean a(String paramString)
  {
    return (String.valueOf(AppConstants.U).equals(paramString)) || (String.valueOf(AppConstants.W).equals(paramString)) || (String.valueOf(AppConstants.V).equals(paramString));
  }
  
  boolean c()
  {
    return this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e() != 0;
  }
  
  boolean d()
  {
    return this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.d() != 0;
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
    a(paramIntent);
  }
  
  boolean e()
  {
    return (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) || (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().e());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setTitle(null);
    a(getIntent());
  }
  
  public void onDestroy()
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_JavaLangString, true);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qlink.QlinkDialogActivity
 * JD-Core Version:    0.7.0.1
 */