package com.tencent.mobileqq.activity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import ayw;
import ayy;
import ayz;
import aza;
import azb;
import azc;
import azd;
import aze;
import azf;
import azg;
import azh;
import azi;
import azj;
import azk;
import azl;
import azm;
import azn;
import azo;
import azp;
import azr;
import azs;
import azt;
import azu;
import azv;
import azw;
import azx;
import azy;
import com.tencent.ims.signature.SignatureKickData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSigHandler;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new azt(this);
  public String a;
  private Constants.LogoutReason jdField_a_of_type_MqqAppConstants$LogoutReason = Constants.LogoutReason.tips;
  private boolean jdField_a_of_type_Boolean = false;
  private String b = null;
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
  }
  
  private Dialog a()
  {
    AlertDialog localAlertDialog = new AlertDialog.Builder(this).create();
    localAlertDialog.show();
    Object localObject = localAlertDialog.getWindow();
    ((Window)localObject).setContentView(2130903248);
    Button localButton1 = (Button)((Window)localObject).findViewById(2131297368);
    Button localButton2 = (Button)((Window)localObject).findViewById(2131297367);
    localObject = (TextView)((Window)localObject).findViewById(2131297362);
    if ((localButton1 == null) || (localObject == null)) {
      return null;
    }
    ((TextView)localObject).setText(getString(2131363559) + "3.3.0" + getString(2131363560));
    localButton1.setOnClickListener(new azp(this));
    localButton2.setOnClickListener(new azr(this));
    return localAlertDialog;
  }
  
  private void a(int paramInt)
  {
    int i1 = -1;
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.jdField_a_of_type_AndroidAppDialog = null;
    int i3;
    switch (paramInt)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidAppDialog != null)
        {
          this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
          this.jdField_a_of_type_AndroidAppDialog.show();
        }
        return;
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(getString(2131363140)).setMessage(getString(2131363142)).setPositiveButton(2131363039, new azv(this)).setNegativeButton(2131363447, new azu(this));
        continue;
        this.b = getString(2131363141);
        this.c = getString(2131363143);
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(this.b).setMessage(this.c).setPositiveButton(17039370, new azw(this));
        continue;
        TextView localTextView = new TextView(this);
        localTextView.setLinksClickable(true);
        localTextView.setMovementMethod(LinkMovementMethod.getInstance());
        localTextView.setTextSize(getResources().getInteger(2131558400));
        localTextView.setTextColor(getResources().getColor(2131427332));
        this.b = getString(2131363141);
        localTextView.setText(2131362914);
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setMessage(this.c).addView(localTextView).setPositiveButton(2131363039, new azx(this));
        continue;
        try
        {
          this.jdField_a_of_type_AndroidAppDialog = a();
        }
        catch (Exception localException)
        {
          c();
        }
      }
    case 5: 
      if (QQPlayerService.a()) {
        sendBroadcast(new Intent("qqplayer_exit_action"));
      }
      paramInt = 2131362791;
      if (this.jdField_a_of_type_MqqAppConstants$LogoutReason != Constants.LogoutReason.kicked) {
        paramInt = 2131364198;
      }
      if (this.c != null)
      {
        i3 = this.c.indexOf("http://110.qq.com/");
        i2 = i3;
        if (i3 > 0) {
          i1 = "http://110.qq.com/".length() + i3;
        }
      }
      break;
    }
    for (int i2 = i3;; i2 = -1)
    {
      if (this.c != null) {}
      for (Object localObject1 = this.c;; localObject1 = "")
      {
        localObject1 = new SpannableString((CharSequence)localObject1);
        if ((i2 > 0) && (i1 > i2)) {
          ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(getResources().getColor(2131427372)), i2, i1, 33);
        }
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(this.b).setMessage((CharSequence)localObject1).setNegativeButton(paramInt, new azy(this));
        if (this.jdField_a_of_type_MqqAppConstants$LogoutReason == Constants.LogoutReason.kicked) {
          break;
        }
        ((QQCustomDialog)this.jdField_a_of_type_AndroidAppDialog).setPositiveButton(2131362927, new ayy(this));
        break;
      }
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(this.b).setMessage(this.c).setPositiveButton(17039370, new ayz(this));
      break;
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(this.b).setMessage(this.c).setPositiveButton(17039370, new aza(this));
      break;
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(getString(2131363601)).setMessage(getString(2131363604)).setPositiveButton(getString(2131363602), new azc(this)).setNegativeButton(getString(2131363603), new azb(this));
      break;
      if (this.n == 40)
      {
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(getActivity(), 231, getString(2131364190), this.c, 2131364189, 2131364188, new azd(this), new aze(this));
        break;
      }
      switch (this.n)
      {
      default: 
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.b(this, 230).setMessageWithUrl(this.c).setTitle(getString(2131363174)).setPositiveButton(17039370, new azk(this));
        break;
      case 41: 
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setMessage(getString(2131363605)).setTitle("温馨提示").setNegativeButton(2131363607, new azg(this)).setPositiveButton(2131363608, new azf(this));
        break;
      case 116: 
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setMessage(getString(2131363606)).setTitle("温馨提示").setNegativeButton(2131363607, new azj(this)).setPositiveButton(2131363609, new azh(this));
        break;
        Object localObject2 = getIntent().getExtras();
        localObject1 = ((Bundle)localObject2).getString("dlg_title");
        String str1 = ((Bundle)localObject2).getString("dlg_content");
        String str2 = ((Bundle)localObject2).getString("dlg_lbutton");
        String str3 = ((Bundle)localObject2).getString("dlg_rbutton");
        localObject2 = ((Bundle)localObject2).getString("dlg_url");
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle((String)localObject1).setMessage(str1).setPositiveButton(str3, new azm(this, (String)localObject2)).setNegativeButton(str2, new azl(this));
        break;
        localObject1 = getResources().getString(2131364335);
        str1 = getResources().getString(2131364336);
        str2 = getResources().getString(2131364339);
        str3 = getResources().getString(2131364338);
        Object localObject3 = getResources().getString(2131364337);
        localObject2 = new CheckBox(this);
        ((CheckBox)localObject2).setText((CharSequence)localObject3);
        ((CheckBox)localObject2).setTextSize(getResources().getInteger(2131558400));
        ((CheckBox)localObject2).setTextColor(getResources().getColor(2131427332));
        localObject3 = this.app.a().getSharedPreferences(this.app.getAccount(), 0);
        boolean bool = ((SharedPreferences)localObject3).getBoolean("MemoryAlertAutoClear", false);
        ((CheckBox)localObject2).setChecked(bool);
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle((String)localObject1).setMessage(str1).setView((View)localObject2).setPositiveButton(str3, new azo(this, (CheckBox)localObject2, bool, (SharedPreferences)localObject3)).setNegativeButton(str2, new azn(this, (CheckBox)localObject2, bool, (SharedPreferences)localObject3));
        break;
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
      localIntent.setAction("mqql.intent.action.ACCOUNT_KICKED");
      this.app.a().sendBroadcast(localIntent);
    }
  }
  
  private void e()
  {
    ConfigHandler localConfigHandler = (ConfigHandler)this.app.a(4);
    if (localConfigHandler != null) {
      localConfigHandler.a();
    }
  }
  
  public void c()
  {
    sendBroadcast(new Intent("qqplayer_exit_action"));
    finish();
    this.app.b(false);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903247);
    this.m = getIntent().getIntExtra("type", 0);
    paramBundle = getIntent().getAction();
    if (QLog.isColorLevel()) {
      QLog.d("NotificationActivity", 2, "NotificationActivity action = " + paramBundle);
    }
    if ("mqql.intent.action.ACCOUNT_EXPIRED".equals(paramBundle))
    {
      this.m = 1;
      e();
    }
    for (;;)
    {
      this.b = getIntent().getStringExtra("title");
      this.c = getIntent().getStringExtra("msg");
      this.d = getIntent().getStringExtra("loginalias");
      this.n = getIntent().getIntExtra("loginret", 0);
      this.jdField_a_of_type_MqqAppConstants$LogoutReason = ((Constants.LogoutReason)getIntent().getSerializableExtra("reason"));
      Object localObject = getIntent().getStringExtra("securityScan");
      if ((localObject != null) && ("security_scan".equals(localObject))) {
        this.m = 7;
      }
      if (("mqql.intent.action.ACCOUNT_KICKED".equals(paramBundle)) && (this.jdField_a_of_type_MqqAppConstants$LogoutReason == Constants.LogoutReason.secKicked))
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
            if ("mqql.intent.action.ACCOUNT_TIPS".equals(paramBundle))
            {
              this.m = 6;
              continue;
            }
            if ("mqql.intent.action.ACCOUNT_KICKED".equals(paramBundle))
            {
              d();
              e();
              this.m = 5;
              continue;
            }
            if ("mqql.intent.action.GRAY".equals(paramBundle))
            {
              this.m = 2;
              continue;
            }
            if (!"mqql.intent.action.SUSPEND".equals(paramBundle)) {
              continue;
            }
            this.m = 4;
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          for (;;)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
          }
          if ((!paramBundle.str_left_button.has()) || (!paramBundle.str_packname.has()) || (!paramBundle.u32_check_result.has()) || (!paramBundle.str_right_button.has()) || (!paramBundle.str_url.has()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("sec_sig_tag", 2, "NotificationActivity:package fail");
            }
            return false;
          }
          SecSigHandler.a(paramBundle.u32_check_result.get());
          this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(this.b).setMessage(this.c).setPositiveButton(paramBundle.str_right_button.get(), new azs(this, paramBundle)).setNegativeButton(paramBundle.str_left_button.get(), new azi(this));
          if (this.jdField_a_of_type_AndroidAppDialog != null)
          {
            this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
            this.jdField_a_of_type_AndroidAppDialog.show();
          }
          return true;
        }
      }
    }
    a(this.m);
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.qqlite.closeNotification"));
    return false;
  }
  
  protected void doOnDestroy()
  {
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    super.doOnDestroy();
    if (jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity == this) {
      jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity = null;
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      ((QQCustomDialog)this.jdField_a_of_type_AndroidAppDialog).setPositiveButton(2131364456, new ayw(this));
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
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity = this;
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity
 * JD-Core Version:    0.7.0.1
 */