package com.tencent.mobileqq.activity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.ims.signature.SignatureKickData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSigHandler;
import com.tencent.mobileqq.international.LocaleString;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cxj;
import cxk;
import cxl;
import cxm;
import cxn;
import cxo;
import cxp;
import cxq;
import cxr;
import cxs;
import cxt;
import cxv;
import cxw;
import cxx;
import cxy;
import cxz;
import cya;
import cyb;
import cyc;
import mqq.app.Constants.LogoutReason;

public class NotificationActivity
  extends BaseActivity
{
  public static final int a = 0;
  public static NotificationActivity a;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  private static final String e = "sec_sig_tag";
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 8;
  public static final int j = 9;
  public static final int k = 10;
  public static final int l = 11;
  private Dialog jdField_a_of_type_AndroidAppDialog = null;
  public String a;
  private Constants.LogoutReason jdField_a_of_type_MqqAppConstants$LogoutReason = Constants.LogoutReason.tips;
  private String b;
  private String c = null;
  private String d = "";
  private int m;
  private int n;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity = null;
  }
  
  public NotificationActivity()
  {
    this.jdField_a_of_type_JavaLangString = "http://fwd.z.qq.com:8080/forward.jsp?bid=906";
    this.jdField_b_of_type_JavaLangString = null;
  }
  
  private Dialog a()
  {
    AlertDialog localAlertDialog = new AlertDialog.Builder(this).create();
    localAlertDialog.show();
    Object localObject = localAlertDialog.getWindow();
    ((Window)localObject).setContentView(2130903294);
    Button localButton1 = (Button)((Window)localObject).findViewById(2131231993);
    Button localButton2 = (Button)((Window)localObject).findViewById(2131231992);
    localObject = (TextView)((Window)localObject).findViewById(2131231987);
    if ((localButton1 == null) || (localObject == null)) {
      return null;
    }
    ((TextView)localObject).setText(getString(2131562388) + "6.0.3" + getString(2131562560));
    localButton1.setOnClickListener(new cxt(this));
    localButton2.setOnClickListener(new cxv(this));
    return localAlertDialog;
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.jdField_a_of_type_AndroidAppDialog = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidAppDialog != null)
      {
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppDialog.show();
      }
      return;
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(getString(2131563168)).setMessage(getString(2131562954)).setPositiveButton(2131562701, new cxx(this)).setNegativeButton(2131562163, new cxw(this));
      continue;
      this.jdField_b_of_type_JavaLangString = getString(2131563295);
      this.c = getString(2131562953);
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.c).setPositiveButton(17039370, new cxy(this));
      continue;
      TextView localTextView = new TextView(this);
      localTextView.setLinksClickable(true);
      localTextView.setMovementMethod(LinkMovementMethod.getInstance());
      localTextView.setTextSize(getResources().getInteger(2131492867));
      localTextView.setTextColor(getResources().getColor(2131361800));
      if (this.jdField_b_of_type_JavaLangString == null) {
        this.jdField_b_of_type_JavaLangString = getString(2131563295);
      }
      localTextView.setText(2131562946);
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setMessage(this.c).addView(localTextView).setPositiveButton(2131562701, new cxz(this));
      continue;
      try
      {
        this.jdField_a_of_type_AndroidAppDialog = a();
      }
      catch (Exception localException)
      {
        c();
      }
      continue;
      if (QQPlayerService.a()) {
        sendBroadcast(new Intent("qqplayer_exit_action"));
      }
      paramInt = 2131562539;
      if (this.jdField_a_of_type_MqqAppConstants$LogoutReason != Constants.LogoutReason.kicked) {
        paramInt = 2131562702;
      }
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.c).setNegativeButton(paramInt, new cya(this));
      if (this.jdField_a_of_type_MqqAppConstants$LogoutReason != Constants.LogoutReason.kicked)
      {
        ((QQCustomDialog)this.jdField_a_of_type_AndroidAppDialog).setPositiveButton(2131562318, new cyb(this));
        continue;
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.c).setPositiveButton(17039370, new cyc(this));
        continue;
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.c).setPositiveButton(17039370, new cxk(this));
        continue;
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(getString(2131562325)).setMessage(getString(2131562692)).setPositiveButton(getString(2131561632), new cxm(this)).setNegativeButton(getString(2131561745), new cxl(this));
        continue;
        if (this.n == 40)
        {
          this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(a(), 231, getString(2131561767), this.c, 2131561747, 2131562742, new cxn(this), new cxo(this));
        }
        else
        {
          this.jdField_a_of_type_AndroidAppDialog = DialogUtil.b(this, 230).setMessageWithUrl(this.c).setTitle(getString(2131563202)).setPositiveButton(17039370, new cxp(this));
          continue;
          Object localObject = getIntent().getExtras();
          String str1 = ((Bundle)localObject).getString("dlg_title");
          String str2 = ((Bundle)localObject).getString("dlg_content");
          String str3 = ((Bundle)localObject).getString("dlg_lbutton");
          String str4 = ((Bundle)localObject).getString("dlg_rbutton");
          localObject = ((Bundle)localObject).getString("dlg_url");
          this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(str1).setMessage(str2).setPositiveButton(str4, new cxr(this, (String)localObject)).setNegativeButton(str3, new cxq(this));
        }
      }
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "send broadcast:NewIntent.ACTION_ACCOUNT_KICKED");
    }
    Intent localIntent = new Intent();
    if (localIntent != null)
    {
      localIntent.setAction("mqq.i.intent.action.ACCOUNT_KICKED");
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
    }
  }
  
  private void e()
  {
    ConfigHandler localConfigHandler = (ConfigHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(4);
    if (localConfigHandler != null) {
      localConfigHandler.a();
    }
  }
  
  public void c()
  {
    sendBroadcast(new Intent("qqplayer_exit_action"));
    finish();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.k();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903293);
    jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity = this;
    this.m = getIntent().getIntExtra("type", 0);
    paramBundle = getIntent().getAction();
    if (QLog.isColorLevel()) {
      QLog.d("NotificationActivity", 2, "NotificationActivity action = " + paramBundle);
    }
    if ("mqq.i.intent.action.ACCOUNT_EXPIRED".equals(paramBundle))
    {
      this.m = 1;
      e();
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = LocaleString.d(this, getIntent().getStringExtra("title"));
      this.c = LocaleString.e(this, getIntent().getStringExtra("msg"));
      this.d = getIntent().getStringExtra("loginalias");
      this.n = getIntent().getIntExtra("loginret", 0);
      this.jdField_a_of_type_MqqAppConstants$LogoutReason = ((Constants.LogoutReason)getIntent().getSerializableExtra("reason"));
      Object localObject = getIntent().getStringExtra("securityScan");
      if ((localObject != null) && ("security_scan".equals(localObject))) {
        this.m = 7;
      }
      if (("mqq.i.intent.action.ACCOUNT_KICKED".equals(paramBundle)) && (this.jdField_a_of_type_MqqAppConstants$LogoutReason == Constants.LogoutReason.secKicked))
      {
        if (QLog.isColorLevel()) {
          QLog.d("sec_sig_tag", 2, "NotificationActivity:sec kick");
        }
        localObject = getIntent().getByteArrayExtra("data");
        paramBundle = new signature.SignatureKickData();
        try
        {
          paramBundle.mergeFrom((byte[])localObject);
          if (!paramBundle.has())
          {
            return false;
            if ("mqq.i.intent.action.ACCOUNT_TIPS".equals(paramBundle))
            {
              this.m = 6;
              continue;
            }
            if ("mqq.i.intent.action.ACCOUNT_KICKED".equals(paramBundle))
            {
              d();
              e();
              this.m = 5;
              continue;
            }
            if ("mqq.i.intent.action.GRAY".equals(paramBundle))
            {
              this.m = 2;
              continue;
            }
            if (!"mqq.i.intent.action.SUSPEND".equals(paramBundle)) {
              continue;
            }
            this.m = 4;
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          do
          {
            do
            {
              for (;;)
              {
                localInvalidProtocolBufferMicroException.printStackTrace();
              }
              if ((paramBundle.str_left_button.has()) && (paramBundle.str_packname.has()) && (paramBundle.u32_check_result.has()) && (paramBundle.str_right_button.has()) && (paramBundle.str_url.has())) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("sec_sig_tag", 2, "NotificationActivity:package fail");
            return false;
            SecSigHandler.a(paramBundle.u32_check_result.get());
            this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.c).setPositiveButton(paramBundle.str_right_button.get(), new cxs(this, paramBundle)).setNegativeButton(paramBundle.str_left_button.get(), new cxj(this));
          } while (this.jdField_a_of_type_AndroidAppDialog == null);
          this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
          this.jdField_a_of_type_AndroidAppDialog.show();
          return false;
        }
      }
    }
    a(this.m);
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity == this) {
      jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity = null;
    }
  }
  
  protected void doOnUserLeaveHint()
  {
    super.doOnUserLeaveHint();
    if (this.m == 3) {
      c();
    }
  }
  
  public void finish()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.jdField_a_of_type_AndroidAppDialog = null;
    super.finish();
    jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity = null;
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity
 * JD-Core Version:    0.7.0.1
 */