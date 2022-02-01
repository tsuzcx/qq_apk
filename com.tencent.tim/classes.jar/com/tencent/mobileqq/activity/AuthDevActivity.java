package com.tencent.mobileqq.activity;

import QQService.DeviceItemDes;
import QQService.SvcDevLoginInfo;
import acfd;
import achs;
import acll;
import aclm;
import afrz;
import afsb;
import afsf;
import aiak;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aneg;
import anot;
import aqiw;
import aqmu;
import arhz;
import ausj;
import auss;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import face.qqlogin.FaceSecureCheck.SecureCheckResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.Ticket;
import tencent.im.oidb.oidb_0x5e1.RspBody;
import tencent.im.oidb.oidb_0x5e1.UdcUinData;
import ugx;
import ugy;
import ugz;
import uha;
import uhb;
import uhc;
import uhd;
import uhe;
import uhf;
import uhg;
import uhh;
import uhi;

public class AuthDevActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private Dialog B;
  private TextView Cc;
  private TextView Cd;
  private TextView Ce;
  private TextView Cf;
  private ProgressBar J;
  private String QT;
  private ausj R;
  private ausj S;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new uhb(this);
  private FaceSecureCheck.SecureCheckResponse jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse;
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
  private oidb_0x5e1.RspBody jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody;
  private String aKU = "";
  private String aKV;
  private String aKW;
  private boolean aRB;
  private boolean aRC = true;
  private boolean aRD = true;
  private boolean aRE;
  private boolean aRF;
  private boolean aRG;
  private boolean aRH;
  private aclm jdField_b_of_type_Aclm = new uhi(this);
  private WtloginObserver jdField_b_of_type_MqqObserverWtloginObserver = new uhh(this);
  private acfd e = new uhg(this);
  private LinearLayout fR;
  private String mAppId;
  private Handler mHandler = new ugx(this);
  private FormSimpleItem q;
  private List<SvcDevLoginInfo> qf;
  private List<SvcDevLoginInfo> qk = new ArrayList();
  private List<SvcDevLoginInfo> ql = new ArrayList();
  private FormSimpleItem r;
  private FormSwitchItem t;
  private FormSwitchItem u;
  private FormSwitchItem v;
  private arhz w;
  
  private void a(String paramString1, ArrayList<DeviceItemDes> paramArrayList, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = getResources().getString(2131696152);
    }
    this.R = ((ausj)auss.a(this, null));
    if (paramBoolean1) {}
    for (paramString1 = getString(2131693195, new Object[] { str });; paramString1 = getString(2131693193, new Object[] { str }))
    {
      this.R.setMainTitle(paramString1);
      this.R.addRadioButton(getResources().getString(2131693192), 3, false);
      this.R.addCancelButton(2131721058);
      this.R.a(new uhf(this, paramString2, paramArrayList, paramInt, paramBoolean2, paramLong));
      this.R.show();
      return;
    }
  }
  
  private void a(String paramString1, ArrayList<DeviceItemDes> paramArrayList, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2, byte[] paramArrayOfByte, boolean paramBoolean3, SvcDevLoginInfo paramSvcDevLoginInfo)
  {
    this.S = ((ausj)auss.a(this, null));
    LinearLayout localLinearLayout = (LinearLayout)getLayoutInflater().inflate(2131559303, this.S.getRootView(), false);
    TextView localTextView = (TextView)localLinearLayout.findViewById(2131362015);
    boolean bool1 = Arrays.equals(NetConnInfoCenter.GUID, paramArrayOfByte);
    boolean bool2 = a(paramSvcDevLoginInfo);
    if (this.aRB)
    {
      paramSvcDevLoginInfo = getString(2131693158);
      paramArrayOfByte = getString(2131693158);
      if (paramLong2 > 0L)
      {
        paramArrayOfByte = new Date(1000L * paramLong2);
        paramSvcDevLoginInfo = getString(2131693154, new Object[] { new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(paramArrayOfByte) });
        paramArrayOfByte = getString(2131693154, new Object[] { new SimpleDateFormat("yyyy年MM月dd日 HH点mm分", Locale.getDefault()).format(paramArrayOfByte) });
        if ((bool1) || (bool2)) {
          paramSvcDevLoginInfo = getString(2131693160);
        }
        localTextView.setText(paramSvcDevLoginInfo);
        if ((!bool1) && (!bool2)) {
          break label355;
        }
        paramArrayOfByte = getString(2131693160);
      }
      label355:
      for (;;)
      {
        localTextView.setContentDescription(paramArrayOfByte);
        this.S.addView(localLinearLayout);
        if (this.aRB) {
          this.S.a(getResources().getString(2131693241), 5, 0);
        }
        if ((!bool1) || (this.aRB)) {
          this.S.a(getResources().getString(2131692511), 3, 1);
        }
        this.S.addCancelButton(2131721058);
        this.S.a(new uhe(this, paramString2, paramLong1, paramString1, paramInt, paramBoolean3, paramArrayList, paramBoolean1, paramBoolean2));
        this.S.show();
        return;
        QLog.e("Q.devlock.AuthDevActivity", 1, "format login time error: time <= 0");
        break;
      }
    }
    if (bool1) {}
    for (paramArrayOfByte = getString(2131693151);; paramArrayOfByte = getString(2131693194, new Object[] { paramString1 }))
    {
      localTextView.setText(paramArrayOfByte);
      break;
    }
  }
  
  private boolean a(SvcDevLoginInfo paramSvcDevLoginInfo)
  {
    if (paramSvcDevLoginInfo == null) {
      return false;
    }
    Iterator localIterator = this.ql.iterator();
    while (localIterator.hasNext()) {
      if (Arrays.equals(((SvcDevLoginInfo)localIterator.next()).vecGuid, paramSvcDevLoginInfo.vecGuid)) {
        return true;
      }
    }
    return false;
  }
  
  private void bGl()
  {
    boolean bool1 = afsf.a().b(this.app, this.aKU, 0L);
    boolean bool2 = afsf.a().a(this.app, this.aKU, 0L);
    if ((bool1) && (bool2))
    {
      this.qk.clear();
      this.Cc.setVisibility(0);
      this.Cc.setText(getString(2131693250));
      this.J.setVisibility(0);
      this.Cd.setText(getString(2131693164));
      this.Ce.setVisibility(8);
      this.r.setVisibility(8);
      this.q.setVisibility(8);
      return;
    }
    QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "onCreate getRecentLoginDevList failed recentLoginRet=", Boolean.valueOf(bool1), " loginDevRet=", Boolean.valueOf(bool2) });
  }
  
  private void bGm()
  {
    QLog.d("Q.devlock.AuthDevActivity", 1, "startGetAuthDevList.begin to getAuthLoginDevList");
    boolean bool = afsf.a().c(this.app, this.aKU, 0L);
    if (bool)
    {
      this.Cc.setVisibility(0);
      this.Cc.setText(getString(2131693245));
      this.J.setVisibility(0);
      this.Cd.setText(getString(2131693165));
      this.Ce.setVisibility(0);
      this.r.setVisibility(0);
      this.q.setVisibility(0);
      return;
    }
    QLog.d("Q.devlock.AuthDevActivity", 1, "startGetAuthDevList getAuthLoginDevList failed ret =" + bool);
  }
  
  private void bGp()
  {
    aneg.a(this.app, getCurrentAccountUin(), new ugz(this));
    if (!"secureStateOk".equals(this.aKW)) {
      aneg.a(this.app, getCurrentAccountUin(), new uha(this));
    }
  }
  
  private void bGq()
  {
    if (!aqiw.isNetSupport(this)) {
      QQToast.a(this, getString(2131693404), 0).show(getTitleBarHeight());
    }
    int i;
    do
    {
      do
      {
        return;
        if (this.aRB)
        {
          anot.a(this.app, "CliOper", "", "", "My_eq_lock", "My_eq_lock_close", 0, 0, "", "", "", "");
          anot.a(null, "dc00898", "", "", "0X800A71C", "0X800A71C", 0, 0, "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.d("DevRpt", 2, "登录保护页点击开关，关闭登录保护的用户数、次数！0X800A71C");
          }
          QLog.d("Q.devlock.AuthDevActivity", 1, "onClick.begin to close dev lock");
          bGn();
          return;
        }
        QLog.d("Q.devlock.AuthDevActivity", 1, "onClick.begin to CheckDevLockSms");
        localObject = (DevlockInfo)getIntent().getParcelableExtra("DevlockInfo");
        if ((TextUtils.isEmpty(this.QT)) || ((localObject != null) && (((DevlockInfo)localObject).AllowSet == 0)))
        {
          Intent localIntent = new Intent(this, AuthDevOpenUgActivity.class);
          localIntent.putExtra("DevlockInfo", (Parcelable)localObject);
          startActivityForResult(localIntent, 0);
          return;
        }
        if (afrz.a().Dx() == afrz.cTE)
        {
          afrz.a().E(this, this.QT);
          return;
        }
        anot.a(this.app, "CliOper", "", "", "My_eq_lock", "My_eq_lock_open", 0, 0, "0", "", "", "");
        anot.a(null, "dc00898", "", "", "0X800A71B", "0X800A71B", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("DevRpt", 2, "登录保护页点击开关，开启登录保护的用户数、次数！0X800A71B");
        }
        if (this.aRD) {
          break;
        }
      } while ((this.w != null) && (this.w.isShowing()));
      showProgressDialog();
      return;
      showProgressDialog();
      this.aRD = false;
      Object localObject = this.app.getCurrentAccountUin();
      i = afsf.a().a(this.app, (String)localObject, "", null, this.jdField_b_of_type_MqqObserverWtloginObserver);
    } while (i == 0);
    this.aRD = true;
    bwV();
    QLog.d("Q.devlock.AuthDevActivity", 1, "onClick.CheckDevLockSms fail ret=" + i);
    QQToast.a(getApplicationContext(), getString(2131693218), 0).show(getTitleBarHeight());
  }
  
  private void bwV()
  {
    this.mHandler.post(new AuthDevActivity.12(this));
  }
  
  private void fz(List<SvcDevLoginInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.Cc.setVisibility(4);
      this.fR.setVisibility(8);
      return;
    }
    this.fR.removeAllViews();
    this.fR.setVisibility(0);
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)paramList.get(i);
      if (localSvcDevLoginInfo == null)
      {
        i += 1;
      }
      else
      {
        View localView = getLayoutInflater().inflate(2131561302, this.fR, false);
        RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131369468);
        label127:
        TextView localTextView1;
        Object localObject1;
        if (j == 1)
        {
          localRelativeLayout.setBackgroundResource(2130839682);
          TextView localTextView2 = (TextView)localView.findViewById(2131372190);
          localTextView1 = (TextView)localView.findViewById(2131369154);
          Object localObject2 = localSvcDevLoginInfo.strDeviceName;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = getResources().getString(2131696152);
          }
          localObject2 = null;
          boolean bool1 = Arrays.equals(NetConnInfoCenter.GUID, localSvcDevLoginInfo.vecGuid);
          boolean bool2 = a(localSvcDevLoginInfo);
          if (bool1) {
            localObject2 = "（" + getResources().getString(2131696149) + "）";
          }
          SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject1);
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localSpannableStringBuilder.append((CharSequence)localObject2);
            uhc localuhc = new uhc(this);
            int k = ((String)localObject1).length();
            localSpannableStringBuilder.setSpan(localuhc, k, ((String)localObject2).length() + k, 33);
          }
          localTextView2.setText(localSpannableStringBuilder);
          localObject1 = new StringBuilder();
          localObject2 = new StringBuilder();
          if (bool2) {
            ((StringBuilder)localObject2).append(getString(2131693159)).append(" ").append(localSvcDevLoginInfo.strDeviceName);
          }
          if ((localSvcDevLoginInfo.iLoginTime > 0L) && (!this.aRB)) {
            ((StringBuilder)localObject1).append(aqmu.getFormatTime(localSvcDevLoginInfo.iLoginTime * 1000L, "yyyy-MM-dd "));
          }
          if (!TextUtils.isEmpty(localSvcDevLoginInfo.strLoginLocation)) {
            ((StringBuilder)localObject1).append(localSvcDevLoginInfo.strLoginLocation);
          }
          if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceTypeInfo))
          {
            if (((StringBuilder)localObject1).length() > 0) {
              ((StringBuilder)localObject1).append(" ");
            }
            ((StringBuilder)localObject1).append(localSvcDevLoginInfo.strDeviceTypeInfo);
          }
          if ((!bool2) || (this.aRB)) {
            break label578;
          }
          localTextView1.setText(((StringBuilder)localObject2).toString());
        }
        for (;;)
        {
          localRelativeLayout.setClickable(true);
          localRelativeLayout.setTag(localSvcDevLoginInfo);
          localRelativeLayout.setOnClickListener(new uhd(this, paramList, localRelativeLayout, i, localSvcDevLoginInfo));
          this.fR.addView(localView);
          break;
          if (i == 0)
          {
            localRelativeLayout.setBackgroundResource(2130839701);
            break label127;
          }
          if (i == j - 1)
          {
            localRelativeLayout.setBackgroundResource(2130839689);
            break label127;
          }
          localRelativeLayout.setBackgroundResource(2130839695);
          break label127;
          label578:
          if (((StringBuilder)localObject1).length() > 0) {
            localTextView1.setText(((StringBuilder)localObject1).toString());
          }
        }
      }
    }
    paramList = this.Cc;
    if (this.fR.getChildCount() == 0) {}
    for (i = 4;; i = 0)
    {
      paramList.setVisibility(i);
      return;
    }
  }
  
  private void showProgressDialog()
  {
    this.mHandler.post(new AuthDevActivity.11(this));
  }
  
  private void zJ(int paramInt)
  {
    if ((this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody != null) && (this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.size() != 0))
    {
      ((oidb_0x5e1.UdcUinData)this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.get(0)).user_login_guard_face.set(paramInt);
      FormSimpleItem localFormSimpleItem = this.r;
      if (paramInt == 1) {}
      for (Object localObject = getString(2131693360);; localObject = getString(2131693367))
      {
        localFormSimpleItem.setRightText((CharSequence)localObject);
        localObject = new Intent();
        ((Intent)localObject).putExtra("faceStateKey", String.valueOf(paramInt));
        setResult(-1, (Intent)localObject);
        return;
      }
    }
    QLog.e("Q.devlock.AuthDevActivity", 1, "refreshUserFaceState mFAceStateRsp is null or rpt_msg_uin_data is empty");
  }
  
  void bGn()
  {
    bGo();
    ReportDialog localReportDialog = new ReportDialog(this, 2131756467);
    localReportDialog.setContentView(2131559127);
    TextView localTextView = (TextView)localReportDialog.findViewById(2131365867);
    if (localTextView != null) {
      localTextView.setText(getString(2131693179));
    }
    localTextView = (TextView)localReportDialog.findViewById(2131365863);
    if (localTextView != null)
    {
      localObject = (achs)this.app.getManager(92);
      if ((localObject != null) && (((achs)localObject).aaX()) && (((achs)localObject).getAuthMode() == 1)) {}
      localTextView.setText(getString(2131693178));
    }
    localTextView = (TextView)localReportDialog.findViewById(2131365852);
    if (localTextView != null) {
      localTextView.setText(2131721059);
    }
    Object localObject = (TextView)localReportDialog.findViewById(2131365858);
    if (localObject != null) {
      ((TextView)localObject).setText(2131721058);
    }
    localReportDialog.setOnDismissListener(new ugy(this));
    if (localTextView != null) {
      localTextView.setOnClickListener(this);
    }
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(this);
    }
    this.B = localReportDialog;
    this.B.show();
  }
  
  void bGo()
  {
    if ((this.B == null) || (this.B.isShowing())) {}
    try
    {
      this.B.dismiss();
      label24:
      this.B = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.r.setClickable(true);
  }
  
  public void finish()
  {
    super.finish();
    if (getIntent().getBooleanExtra("from_risk_hint", false))
    {
      getIntent().removeExtra("from_risk_hint");
      Intent localIntent = new Intent(this, LoginInfoActivity.class);
      localIntent.putExtra("from_risk_hint", true);
      startActivity(localIntent);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1003) {
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getExtras();
        if (paramIntent != null) {
          break label28;
        }
      }
    }
    label28:
    label616:
    for (;;)
    {
      return;
      paramInt1 = paramIntent.getInt("resultState", 1);
      if (paramInt1 == 2) {
        afrz.a().Nd(afrz.cTF);
      }
      while (paramInt1 != 1)
      {
        this.QT = paramIntent.getString("resultMobileMask");
        if (paramInt1 != 2) {
          break label108;
        }
        this.q.setRightText(this.QT);
        return;
        if (paramInt1 == 3)
        {
          afrz.a().Nd(afrz.cTE);
          afrz.a().je(0L);
        }
      }
      continue;
      label108:
      if (paramInt1 == 3)
      {
        this.q.setRightText(super.getString(2131693224));
        return;
        boolean bool1;
        if ((paramInt1 == 11) || (paramInt1 == 21))
        {
          QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "onActivityResult requestCode == REQ_SMS_CODE, resultCode is ", Integer.valueOf(paramInt2) });
          if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getBooleanExtra("key_face_scan_result", false)))
          {
            zJ(1);
            return;
          }
          if (paramIntent == null) {}
          for (bool1 = true;; bool1 = false)
          {
            QLog.e("Q.devlock.AuthDevActivity", 1, new Object[] { "onActivityResult requestCode == REQ_SMS_CODE, data == null ? ", Boolean.valueOf(bool1) });
            if (paramIntent == null) {
              break;
            }
            QLog.e("Q.devlock.AuthDevActivity", 1, new Object[] { "onActivityResult requestCode == REQ_SMS_CODE, KEY_FACE_SCAN_RESULT is ", Boolean.valueOf(paramIntent.getBooleanExtra("key_face_scan_result", false)) });
            return;
          }
        }
        if (paramInt1 == 12)
        {
          if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getBooleanExtra("key_face_scan_result", false))) {
            zJ(0);
          }
        }
        else if (paramInt1 == 0)
        {
          QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "onActivityResult requestCode is 0, resultCode is : ", Integer.valueOf(paramInt2) });
          if (((paramInt2 == 0) || (paramInt2 == -1)) && (paramIntent != null) && (paramIntent.getExtras() != null) && (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null))
          {
            paramIntent = paramIntent.getExtras();
            if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup == 1)
            {
              bool1 = true;
              label370:
              boolean bool2 = paramIntent.getBoolean("auth_dev_open", bool1);
              String str = paramIntent.getString("phone_num");
              if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet != 1) {
                break label616;
              }
              bool1 = true;
              boolean bool3 = paramIntent.getBoolean("allow_set");
              QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "status is ", Boolean.valueOf(bool1), "open is ", Boolean.valueOf(bool2), " status is ", Boolean.valueOf(bool1), " allowSet is ", Boolean.valueOf(bool3) });
              if (!bool2) {
                break label622;
              }
              this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup = 1;
              label496:
              this.aRB = bool2;
              if (!TextUtils.isEmpty(str))
              {
                this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = str;
                this.QT = str;
              }
              this.aRC = bool3;
              if (!bool3) {
                break label633;
              }
            }
            label622:
            label633:
            for (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet = 1;; this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet = 0)
            {
              if (!this.aRB) {
                break label642;
              }
              this.t.setOnCheckedChangeListener(null);
              this.t.setChecked(true);
              this.t.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
              bGm();
              paramIntent = this.app.getHandler(LoginInfoActivity.class);
              if (paramIntent == null) {
                break;
              }
              paramIntent.obtainMessage(20140331, 1, 0).sendToTarget();
              return;
              bool1 = false;
              break label370;
              bool1 = false;
              break label404;
              this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup = 0;
              break label496;
            }
          }
        }
      }
    }
  }
  
  public boolean onBackEvent()
  {
    Object localObject1 = getIntent();
    if (localObject1 != null)
    {
      localObject1 = ((Intent)localObject1).getExtras();
      if ((localObject1 == null) || (!((Bundle)localObject1).containsKey("devlock_need_broadcast"))) {}
    }
    for (boolean bool = ((Bundle)localObject1).getBoolean("devlock_need_broadcast");; bool = false)
    {
      if (bool)
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setAction("mqq.intent.action.DEVLOCK_ROAM");
        ((Intent)localObject1).putExtra("auth_dev_open", this.aRB);
        if (this.aRB)
        {
          Object localObject2 = (WtloginManager)this.app.getManager(1);
          if (localObject2 != null)
          {
            localObject2 = ((WtloginManager)localObject2).GetLocalTicket(this.app.getCurrentAccountUin(), 16L, 33554432);
            if (localObject2 != null) {
              ((Intent)localObject1).putExtra("devlock_roam_sig", ((Ticket)localObject2)._sig);
            }
          }
        }
        sendBroadcast((Intent)localObject1, "com.tencent.tim.msg.permission.pushnotify");
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("auth_dev_open", this.aRB);
      ((Intent)localObject1).putExtra("allow_set", this.aRC);
      ((Intent)localObject1).putExtra("phone_num", this.QT);
      if ((this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody != null) && (!this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.isEmpty())) {
        ((Intent)localObject1).putExtra("faceStateKey", String.valueOf(((oidb_0x5e1.UdcUinData)this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.get(0)).user_login_guard_face.get()));
      }
      setResult(0, (Intent)localObject1);
      if ((AuthDevOpenUgActivity.OH()) && (this.aRH))
      {
        finish();
        startActivity(new Intent(this, LoginInfoActivity.class));
      }
      finish();
      return false;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", "https://kf.qq.com/touch/apifaq/1211147RVfAV140617UV3MZn.html?ADTAG=veda.mobileqq.en");
      ((Intent)localObject).putExtra("hide_more_button", true);
      startActivity((Intent)localObject);
      anot.a(null, "dc00898", "", "", "0X800A720", "0X800A720", 0, 0, "", "", "", "");
      if (QLog.isColorLevel())
      {
        QLog.d("DevRpt", 2, "点击帮助！0X800A720");
        continue;
        bGq();
        continue;
        this.app.sendWirelessMeibaoReq(1);
        anot.a(this.app, "CliOper", "", "", "My_eq_lock", "Clk_protect_detail", 0, 0, "", "", "", "");
        anot.a(this.app, "dc00898", "", "", "0X800ACA0", "0X800ACA0", 0, 0, "1", "", "", "");
        if ((TextUtils.isEmpty(this.app.getCurrentAccountUin())) && (QLog.isColorLevel())) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "onClick current is empty");
        }
        afsb.a(this, this.app, afsb.cTH, 1003, null);
        continue;
        bGo();
        anot.a(this.app, "dc00899", "DevLockSwitchDialog", this.app.getCurrentAccountUin(), "clickCancel", "dialogRightBtn", 0, 1, "", "", "", "");
        anot.a(null, "dc00898", "", "", "0X800A71E", "0X800A71E", 0, 0, "", "", "", "");
        if (QLog.isColorLevel())
        {
          QLog.d("DevRpt", 2, "登录保护页关闭登录保护时的确认弹窗中点击取消！0X800A71E");
          continue;
          int i;
          try
          {
            bGo();
            localObject = getSharedPreferences(LoginInfoActivity.md5sum(getCurrentAccountUin()) + "_" + LoginInfoActivity.aNY, 0).edit();
            ((SharedPreferences.Editor)localObject).putLong(LoginInfoActivity.aNY, System.currentTimeMillis());
            ((SharedPreferences.Editor)localObject).commit();
            anot.a(null, "dc00898", "", "", "0X800A71D", "0X800A71D", 0, 0, "", "", "", "");
            if (QLog.isColorLevel()) {
              QLog.d("DevRpt", 2, "登录保护页关闭登录保护时的确认弹窗中点击关闭！0X800A71D");
            }
            anot.a(this.app, "dc00899", "DevLockSwitchDialog", this.app.getCurrentAccountUin(), "clickClose", "dialogLeftBtn", 0, 2, "", "", "", "");
            if (QLog.isColorLevel()) {
              QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.begin to CloseDevLock");
            }
            if (!this.aRD)
            {
              if ((this.w != null) && (this.w.isShowing())) {
                continue;
              }
              showProgressDialog();
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
            showProgressDialog();
            this.aRD = false;
            str = this.app.getCurrentAccountUin();
            i = afsf.a().a(this.app, str, this.jdField_b_of_type_MqqObserverWtloginObserver);
          }
          if (i != 0)
          {
            bwV();
            this.aRD = true;
            if (QLog.isColorLevel()) {
              QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.CloseDevLock fail ret =" + i);
            }
            QQToast.a(getApplicationContext(), getString(2131693177), 0).show(getTitleBarHeight());
            continue;
            anot.a(null, "dc00898", "", "", "0X800A31B", "0X800A31B", 0, 0, "", "", "", "");
            if (afrz.a().Dx() == afrz.cTE)
            {
              QQToast.a(getApplicationContext(), getString(2131693368), 0).show(getTitleBarHeight());
            }
            else if (this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody == null)
            {
              QLog.e("Q.devlock.AuthDevActivity", 1, "faceVerifyLayout click error : mFaceStateRsp is null");
            }
            else
            {
              if ((this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data != null) && (!this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.isEmpty())) {
                break;
              }
              QLog.e("Q.devlock.AuthDevActivity", 1, "faceVerifyLayout click error : mFaceStateRsp.rpt_msg_uin_data is null or empty");
            }
          }
        }
      }
    }
    this.r.setClickable(false);
    QQAppInterface localQQAppInterface = this.app;
    if (this.QT == null)
    {
      str = "";
      label815:
      aiak.a(localQQAppInterface, this, str, this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody, this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse, new AuthDevActivity.13(this));
      if (((oidb_0x5e1.UdcUinData)this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.get(0)).user_login_guard_face.get() != 1) {
        break label903;
      }
    }
    label903:
    for (String str = "1";; str = "0")
    {
      anot.a(null, "dc00898", "", "", "0X800AA7D", "0X800AA7D", 0, 0, str, "", "", "");
      break;
      str = this.QT;
      break label815;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131561301);
    this.q = ((FormSimpleItem)super.findViewById(2131377906));
    this.q.setOnClickListener(this);
    this.fR = ((LinearLayout)super.findViewById(2131363107));
    this.J = ((ProgressBar)super.findViewById(2131373700));
    this.Ce = ((TextView)findViewById(2131370889));
    this.r = ((FormSimpleItem)findViewById(2131366680));
    this.r.setOnClickListener(this);
    this.Cd = ((TextView)findViewById(2131380559));
    this.t = ((FormSwitchItem)super.findViewById(2131363113));
    this.u = ((FormSwitchItem)findViewById(2131363589));
    this.Cc = ((TextView)super.findViewById(2131363109));
    this.Cc.setVisibility(4);
    this.v = ((FormSwitchItem)super.findViewById(2131382361));
    this.v.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.v.setVisibility(8);
    this.Cf = ((TextView)super.findViewById(2131382360));
    this.Cf.setVisibility(8);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(2131694592);
    this.rightViewText.setOnClickListener(this);
    paramBundle = super.getIntent();
    this.aRG = paramBundle.getExtras().getBoolean("auth_dev_gray_switch");
    this.aRB = paramBundle.getExtras().getBoolean("auth_dev_open");
    this.QT = paramBundle.getExtras().getString("phone_num");
    this.aRE = paramBundle.getExtras().getBoolean("allow_set");
    this.aRF = paramBundle.getExtras().getBoolean("enable_open_allowset_dev");
    this.aRH = paramBundle.getExtras().getBoolean("h5_flag");
    this.aKW = paramBundle.getExtras().getString("secureState", "secureStateUNKNOWN");
    this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = ((DevlockInfo)paramBundle.getParcelableExtra("DevlockInfo"));
    if ("secureStateOk".equals(this.aKW))
    {
      this.mAppId = paramBundle.getStringExtra("faceAppId");
      this.aKV = paramBundle.getStringExtra("faceTmpKey");
      this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse = new FaceSecureCheck.SecureCheckResponse();
      this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse.bool_sec_pass.set(true);
      this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse.str_tmpkey.set(this.aKV);
      this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse.str_openid.set(this.mAppId);
    }
    if (!this.aRG) {
      this.u.setVisibility(8);
    }
    for (;;)
    {
      if (AppSetting.enableTalkBack)
      {
        this.rightViewText.setContentDescription(getString(2131693172));
        this.u.setContentDescription(getString(2131694804));
      }
      if (TextUtils.equals(paramBundle.getExtras().getString("devlock_open_source"), "PhoneUnity")) {
        this.leftView.setText(2131701652);
      }
      this.t.setChecked(this.aRB);
      this.t.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      if (this.app == null)
      {
        QLog.e("Q.devlock.AuthDevActivity", 1, "app is null, refresh app");
        this.app = ((QQAppInterface)getAppRuntime());
      }
      if (this.app != null) {
        break;
      }
      finish();
      QLog.e("Q.devlock.AuthDevActivity", 1, "error : app is null");
      return;
      super.setTitle(2131693155);
      this.rightViewText.setVisibility(8);
      anot.a(null, "dc00898", "", "", "0X800AC52", "0X800AC52", 0, 0, "", "", "", "");
    }
    boolean bool = SettingCloneUtil.readValue(this, this.app.getCurrentAccountUin(), "login_accounts", "qqsetting_bothonline_key", true);
    this.u.setChecked(bool);
    this.u.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    paramBundle = this.app.getHandler(LoginInfoActivity.class);
    if (paramBundle != null)
    {
      if (!this.aRB) {
        break label904;
      }
      paramBundle.obtainMessage(20140331, 1, 0).sendToTarget();
    }
    for (;;)
    {
      if (AppSetting.enableTalkBack) {
        this.t.setContentDescription(getString(2131693215));
      }
      try
      {
        this.aKU = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "packName = " + this.aKU);
        }
        addObserver(this.e);
        addObserver(this.jdField_b_of_type_Aclm);
        if (afrz.a().Dx() == afrz.cTE)
        {
          this.q.setRightText(super.getString(2131693224));
          anot.a(this.app, "dc00898", "", "", "0X800AC9F", "0X800AC9F", 0, 0, "1", "", "", "");
          if (!this.aRB) {
            break label941;
          }
          paramBundle = (acll)this.app.getBusinessHandler(34);
          if (paramBundle != null) {
            paramBundle.cMq();
          }
          bGm();
          bGp();
          return;
          label904:
          paramBundle.obtainMessage(20140331, 0, 0).sendToTarget();
        }
      }
      catch (PackageManager.NameNotFoundException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          continue;
          this.q.setRightText(this.QT);
          continue;
          label941:
          if ((this.aRE) && ((afsf.a().ajV()) || (this.aRF))) {
            bGq();
          } else if (this.aRG) {
            bGl();
          } else {
            this.J.setVisibility(8);
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bwV();
    removeObserver(this.e);
    removeObserver(this.jdField_b_of_type_Aclm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity
 * JD-Core Version:    0.7.0.1
 */