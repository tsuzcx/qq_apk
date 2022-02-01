package com.tencent.mobileqq.activity;

import acfp;
import acll;
import aclm;
import afrz;
import afsb;
import afsf;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqha;
import aqiw;
import aqju;
import ausj;
import auss;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLEncoder;
import java.util.ArrayList;
import mqq.util.WeakReference;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import vlf;
import vlg;
import vlh;
import vln;
import vlo;
import vlp;
import vlq;
import vlr;
import vls;
import vlt;
import yuu;

public class PhoneUnityBindInfoActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  public TextView EA;
  public aqju H;
  public aqju I;
  private aqju J;
  private aqju K;
  public yuu a;
  public BroadcastReceiver aE = new vlf(this);
  public boolean aYX = true;
  public boolean aYY;
  public boolean aYZ;
  private boolean aZa;
  private boolean aZb;
  private boolean aZc;
  public boolean aZd;
  private Bundle ac;
  public Bundle ad;
  private DevlockInfo b;
  public aclm c = new vlh(this);
  public RelativeLayout fY;
  public RelativeLayout gU;
  public RelativeLayout gV;
  public ausj mActionSheet;
  public boolean mInit;
  public int mSource = -1;
  
  private boolean Qm()
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("last_time_recommend_dialog" + this.app.getCurrentAccountUin(), 0);
    long l1 = localSharedPreferences.getLong("last_time", 0L);
    if (localSharedPreferences.getLong("duration", -1L) != -1L) {}
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 2592000000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "isOverTimeThirtyDays is overtime 30 days, so show dialog tips!");
      }
      localSharedPreferences.edit().putLong("last_time", l2).apply();
      bool = true;
    }
    while (!QLog.isColorLevel()) {
      return bool;
    }
    QLog.d("IphoneTitleBarActivity", 2, "isOverTimeThirtyDays is in 30 days, so do not show dialog tips! duration = " + 2592000000L);
    return false;
  }
  
  private void a(RelativeLayout paramRelativeLayout, int paramInt1, int paramInt2)
  {
    int j = 0;
    if (paramRelativeLayout == null) {}
    Object localObject;
    int i;
    label46:
    label70:
    label94:
    do
    {
      return;
      if (paramInt1 != 1) {
        break;
      }
      localObject = this;
      paramRelativeLayout.setOnClickListener((View.OnClickListener)localObject);
      localObject = (TextView)paramRelativeLayout.findViewById(2131375087);
      if (localObject != null)
      {
        if (paramInt1 != 1) {
          break label194;
        }
        i = 0;
        ((TextView)localObject).setVisibility(i);
        if (paramInt1 == 1)
        {
          if (paramInt2 != 2) {
            break label201;
          }
          ((TextView)localObject).setText(2131696803);
        }
      }
      localObject = (ProgressBar)paramRelativeLayout.findViewById(2131375086);
      if (localObject != null)
      {
        if (paramInt1 != 2) {
          break label251;
        }
        i = 0;
        ((ProgressBar)localObject).setVisibility(i);
        if (AppSetting.enableTalkBack) {
          ((ProgressBar)localObject).setContentDescription(super.getString(2131696804));
        }
      }
      localObject = (Button)paramRelativeLayout.findViewById(2131375082);
      if (localObject != null)
      {
        ((Button)localObject).setOnClickListener(this);
        if (paramInt1 != 3) {
          break label258;
        }
        i = 0;
        ((Button)localObject).setVisibility(i);
      }
      paramRelativeLayout = (ImageView)paramRelativeLayout.findViewById(2131375081);
    } while (paramRelativeLayout == null);
    label148:
    if ((paramInt1 != 3) && (paramInt2 != 4)) {}
    for (paramInt1 = j;; paramInt1 = 8)
    {
      paramRelativeLayout.setVisibility(paramInt1);
      return;
      localObject = null;
      break;
      label194:
      i = 8;
      break label46;
      label201:
      if (paramInt2 == 4)
      {
        ((TextView)localObject).setText(2131696806);
        paramRelativeLayout.setOnClickListener(null);
        break label70;
      }
      if (paramInt2 == 3)
      {
        ((TextView)localObject).setText(2131696769);
        break label70;
      }
      if (paramInt2 != 1) {
        break label70;
      }
      ((TextView)localObject).setText(2131696805);
      break label70;
      label251:
      i = 8;
      break label94;
      label258:
      i = 8;
      break label148;
    }
  }
  
  private void a(boolean paramBoolean1, Bundle paramBundle, boolean paramBoolean2)
  {
    int j = 1;
    bSq();
    if (paramBoolean1) {
      this.ad = paramBundle;
    }
    if (paramBundle == null) {}
    String str;
    label87:
    label93:
    do
    {
      return;
      c(paramBundle, d(paramBundle));
      int i;
      if (paramBundle.getInt("need_unify", 0) == 1)
      {
        i = 1;
        str = paramBundle.getString("skip_url");
        if ((!paramBoolean2) || (TextUtils.isEmpty(str))) {
          break label87;
        }
      }
      for (;;)
      {
        if ((j != 0) || (i == 0)) {
          break label93;
        }
        bt(paramBundle);
        return;
        i = 0;
        break;
        j = 0;
      }
    } while (j == 0);
    vS(str);
  }
  
  private static Bundle[] a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getParcelableArray("phone_info");
    if ((paramBundle == null) || (paramBundle.length == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramBundle.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramBundle[i];
      if ((localObject instanceof Bundle)) {
        localArrayList.add((Bundle)localObject);
      }
      i += 1;
    }
    return (Bundle[])localArrayList.toArray(new Bundle[localArrayList.size()]);
  }
  
  public static SpannableStringBuilder b(String paramString)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
    localSpannableStringBuilder.setSpan(new StyleSpan(1), 0, paramString.length(), 18);
    return localSpannableStringBuilder;
  }
  
  private void bSi()
  {
    if (this.aZb)
    {
      QLog.i("IphoneTitleBarActivity", 1, "fetchSecurePhoneNum, in progress");
      return;
    }
    this.aZb = true;
    bSp();
    QLog.i("IphoneTitleBarActivity", 1, "fetchSecurePhoneNum, start");
    WeakReference localWeakReference = new WeakReference(this);
    afsf.a().a(this.app, this.app.getCurrentAccountUin(), new vln(this, localWeakReference));
  }
  
  private void bSj()
  {
    Intent localIntent = new Intent(this, BindNumberActivity.class);
    localIntent.putExtra("kSrouce", this.mSource);
    super.startActivityForResult(localIntent, 1003);
  }
  
  private void bSk()
  {
    Intent localIntent = new Intent(this, PhoneUnityChangeActivity.class);
    localIntent.putExtra("kSrouce", this.mSource);
    super.startActivityForResult(localIntent, 1004);
    anot.a(this.app, "dc00898", "", "", "0X8009EC2", "0X8009EC2", 0, 0, "", "", "", "");
  }
  
  private void bSl()
  {
    if (!this.aZa)
    {
      bSj();
      return;
    }
    bSk();
  }
  
  private void bSm()
  {
    QLog.i("IphoneTitleBarActivity", 1, "openDevLockSetting");
    this.aZc = true;
    anot.a(this.app, "CliOper", "", "", "0X8005B84", "0X8005B84", 0, 0, "", "", "", "");
    Object localObject = new IntentFilter("mqq.intent.action.DEVLOCK_ROAM");
    super.registerReceiver(this.aE, (IntentFilter)localObject);
    localObject = new Intent();
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).setAction("android.intent.action.VIEW");
    ((Intent)localObject).putExtra("devlock_open_source", "PhoneUnity");
    ((Intent)localObject).putExtra("enable_open_allowset_dev", true);
    ((Intent)localObject).setData(Uri.parse("mqqdevlock://devlock/open?"));
    super.startActivity((Intent)localObject);
  }
  
  private void bSn()
  {
    a.h(this.app, "0X800AE50");
    QLog.i("IphoneTitleBarActivity", 1, "showUnityPromptDialog");
    if (this.K == null)
    {
      aqju localaqju = aqha.a(this, 230);
      localaqju.setCancelable(true);
      localaqju.adjustMessageTopBottomMargin(8.0F, 40.0F);
      localaqju.setTitle(2131696788);
      localaqju.setMessage(2131696787);
      localaqju.setPositiveButton(2131696869, new vls(this));
      this.K = localaqju;
    }
    if ((!this.K.isShowing()) && (!isFinishing())) {
      this.K.show();
    }
  }
  
  private void bSo()
  {
    a(this.fY, 2, 1);
    Button localButton = (Button)super.findViewById(2131364419);
    if (localButton != null) {
      localButton.setOnClickListener(null);
    }
  }
  
  private void bSp()
  {
    a(this.gV, 2, 1);
    Button localButton = (Button)super.findViewById(2131364420);
    if (localButton != null) {
      localButton.setOnClickListener(null);
    }
  }
  
  private void bSq()
  {
    if (this.fY != null)
    {
      localObject = (ProgressBar)this.fY.findViewById(2131375086);
      if (localObject != null) {
        ((ProgressBar)localObject).setVisibility(8);
      }
    }
    Object localObject = (Button)super.findViewById(2131364419);
    if (localObject != null) {
      ((Button)localObject).setOnClickListener(this);
    }
  }
  
  private void bSr()
  {
    if (this.gV != null)
    {
      localObject = (ProgressBar)this.gV.findViewById(2131375086);
      if (localObject != null) {
        ((ProgressBar)localObject).setVisibility(8);
      }
    }
    Object localObject = (Button)super.findViewById(2131364420);
    if (localObject != null) {
      ((Button)localObject).setOnClickListener(this);
    }
  }
  
  private void bSs()
  {
    Object localObject = (TextView)this.gU.findViewById(2131375085);
    if (localObject != null) {
      ((TextView)localObject).setText(2131696781);
    }
    localObject = (PhoneContactManagerImp)this.app.getManager(11);
    int i = ((PhoneContactManagerImp)localObject).xy();
    if (((i != 8) && (i != 9)) || (!((PhoneContactManagerImp)localObject).Uw())) {}
    for (localObject = acfp.m(2131709528);; localObject = acfp.m(2131709538))
    {
      TextView localTextView = (TextView)this.gU.findViewById(2131375087);
      if (localTextView != null)
      {
        localTextView.setText((CharSequence)localObject);
        localTextView.setVisibility(0);
      }
      localObject = this.gU.findViewById(2131375086);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.gU.findViewById(2131375082);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.gU.findViewById(2131375081);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      return;
    }
  }
  
  private void bSu()
  {
    if (this.J == null)
    {
      this.J = aqha.b(this, 0, super.getString(2131719921), super.getString(2131719922), super.getString(2131719919), super.getString(2131719920), new vlt(this), new vlg(this));
      this.J.setCancelable(false);
    }
    if ((this.J != null) && (!this.J.isShowing()) && (!isFinishing()))
    {
      this.J.show();
      anot.a(this.app, "dc00898", "", "", "0X800A603", "0X800A603", 0, 0, "", "", "", "");
    }
  }
  
  private void bt(Bundle paramBundle)
  {
    if (this.aZd) {
      return;
    }
    String str2 = paramBundle.getString("country_code");
    String str1 = paramBundle.getString("phone");
    Object localObject3 = "";
    Object localObject2 = "";
    Object localObject4 = paramBundle.getParcelableArray("phone_info");
    int i;
    Object localObject1;
    if (localObject4 != null)
    {
      i = 0;
      localObject1 = str1;
      paramBundle = (Bundle)localObject3;
      if (i < localObject4.length)
      {
        localObject3 = (Bundle)localObject4[i];
        if (localObject3 == null)
        {
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = paramBundle;
          paramBundle = (Bundle)localObject3;
        }
        for (;;)
        {
          i += 1;
          localObject3 = localObject2;
          localObject2 = localObject1;
          localObject1 = paramBundle;
          paramBundle = (Bundle)localObject3;
          break;
          switch (((Bundle)localObject3).getInt("phone_type", 0))
          {
          default: 
            localObject3 = paramBundle;
            paramBundle = (Bundle)localObject1;
            localObject1 = localObject2;
            localObject2 = localObject3;
            break;
          case 1: 
            localObject3 = ((Bundle)localObject3).getString("phone");
            localObject1 = localObject2;
            localObject2 = paramBundle;
            paramBundle = (Bundle)localObject3;
            break;
          case 8: 
            localObject3 = ((Bundle)localObject3).getString("phone");
            localObject2 = paramBundle;
            paramBundle = (Bundle)localObject1;
            localObject1 = localObject3;
            break;
          case 4: 
            localObject3 = ((Bundle)localObject3).getString("phone");
            paramBundle = (Bundle)localObject1;
            localObject1 = localObject2;
            localObject2 = localObject3;
          }
        }
      }
      localObject3 = localObject2;
      localObject2 = paramBundle;
      paramBundle = (Bundle)localObject1;
      localObject1 = localObject3;
    }
    for (;;)
    {
      localObject3 = this.mActionSheet;
      if (localObject3 != null) {
        ((ausj)localObject3).dismiss();
      }
      if ((paramBundle != null) && (((paramBundle.equals(localObject2)) && (!paramBundle.equals(localObject1))) || ((TextUtils.isEmpty((CharSequence)localObject2)) && (!paramBundle.equals(localObject1)))))
      {
        bSn();
        return;
      }
      localObject3 = (ausj)auss.a(this, null);
      ((ausj)localObject3).setSupportBottomRadius(true);
      this.mActionSheet = ((ausj)localObject3);
      localObject4 = LayoutInflater.from(this).inflate(2131559751, null);
      if (localObject4 != null)
      {
        ((View)localObject4).setOnClickListener(new vlo(this));
        Object localObject6 = Bitmap.Config.ARGB_8888;
        Object localObject5 = (LinearLayout)((View)localObject4).findViewById(2131373052);
        if (localObject5 != null)
        {
          TextView localTextView = (TextView)((LinearLayout)localObject5).findViewById(2131373054);
          if ((localTextView != null) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.equals((CharSequence)localObject2, paramBundle)))
          {
            ((LinearLayout)localObject5).setVisibility(0);
            i = (int)localTextView.getTextSize();
            localObject6 = Bitmap.createBitmap(i * 2, i * 2, (Bitmap.Config)localObject6);
            localObject6 = new ImageSpan(getApplicationContext(), (Bitmap)localObject6);
            SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(acfp.m(2131709541));
            localSpannableStringBuilder.setSpan(localObject6, 1, 2, 33);
            ((TextView)((LinearLayout)localObject5).findViewById(2131373053)).setText(localSpannableStringBuilder);
            localTextView.setText((CharSequence)localObject2);
          }
        }
        localObject2 = (LinearLayout)((View)localObject4).findViewById(2131373043);
        if (localObject2 != null)
        {
          localObject5 = (TextView)((LinearLayout)localObject2).findViewById(2131373045);
          if ((localObject5 != null) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.equals((CharSequence)localObject1, paramBundle)))
          {
            ((LinearLayout)localObject2).setVisibility(0);
            ((TextView)localObject5).setText((CharSequence)localObject1);
          }
        }
        localObject1 = (LinearLayout)((View)localObject4).findViewById(2131373070);
        if (localObject1 != null)
        {
          localObject2 = (TextView)((View)localObject4).findViewById(2131373078);
          if ((localObject2 != null) && (!TextUtils.isEmpty(paramBundle)))
          {
            ((LinearLayout)localObject1).setVisibility(0);
            ((TextView)localObject2).setText(paramBundle);
          }
        }
        ((View)localObject4).setBackgroundResource(2130851726);
        ((ausj)localObject3).addViewCustomeTitle((View)localObject4);
      }
      ((ausj)localObject3).addButton(b(String.format(super.getString(2131696777), new Object[] { paramBundle })), 8);
      ((ausj)localObject3).addButton(super.getString(2131696776), 8);
      ((ausj)localObject3).addButton(super.getString(2131721058), 8);
      ((ausj)localObject3).setOnCancelListener(new vlp(this));
      ((ausj)localObject3).a(new vlq(this));
      ((ausj)localObject3).a(new vlr(this, str2, str1, (ausj)localObject3));
      localObject2 = ((ausj)localObject3).getActionContentView();
      localObject1 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject2).getLayoutParams();
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = new RelativeLayout.LayoutParams(-2, -2);
      }
      paramBundle.addRule(12, 0);
      paramBundle.addRule(13, -1);
      paramBundle.setMargins(80, 0, 80, 0);
      ((RelativeLayout)localObject2).setLayoutParams(paramBundle);
      ((ausj)localObject3).show();
      anot.a(this.app, "dc00898", "", "", "0X8009EC7", "0X8009EC7", 0, 0, "", "", "", "");
      return;
      localObject1 = "";
      localObject2 = "";
      paramBundle = str1;
    }
  }
  
  private void c(Bundle paramBundle, String paramString)
  {
    boolean bool2 = true;
    paramBundle = a(paramBundle);
    int i;
    int n;
    int m;
    if (paramBundle != null)
    {
      int k = 0;
      int j = 1;
      i = 1;
      n = j;
      m = i;
      if (k < paramBundle.length)
      {
        Object localObject = paramBundle[k];
        if (localObject == null) {}
        for (;;)
        {
          k += 1;
          break;
          switch (localObject.getInt("phone_type", 0))
          {
          default: 
            break;
          case 4: 
            i = localObject.getInt("status", 0);
            break;
          case 8: 
            j = localObject.getInt("status", 0);
            break;
          case 16: 
            localObject.getInt("status", 0);
          }
        }
      }
    }
    else
    {
      n = 1;
      m = 1;
    }
    bSs();
    label187:
    boolean bool1;
    if (TextUtils.isEmpty(paramString))
    {
      this.fY.setVisibility(8);
      this.gU.setVisibility(8);
      paramBundle = this.fY;
      if (m != 2) {
        break label246;
      }
      i = 1;
      a(paramBundle, i, m);
      if (n != 2) {
        break label251;
      }
      bool1 = true;
      label204:
      if (TextUtils.isEmpty(paramString)) {
        break label257;
      }
    }
    for (;;)
    {
      if (h(bool1, bool2)) {
        bSu();
      }
      return;
      this.fY.setVisibility(0);
      this.gU.setVisibility(0);
      break;
      label246:
      i = 3;
      break label187;
      label251:
      bool1 = false;
      break label204;
      label257:
      bool2 = false;
    }
  }
  
  private void c(DevlockInfo paramDevlockInfo)
  {
    this.aZb = false;
    bSr();
    if (paramDevlockInfo == null)
    {
      QLog.i("IphoneTitleBarActivity", 1, "onGetDevlockInfo, fail");
      return;
    }
    QLog.i("IphoneTitleBarActivity", 1, "fetchSecurePhoneNum, success");
    this.b = paramDevlockInfo;
    afrz.a().update(paramDevlockInfo.TransferInfo);
    TextView localTextView = (TextView)findViewById(2131363495);
    Button localButton = (Button)findViewById(2131364420);
    if (TextUtils.isEmpty(paramDevlockInfo.Mobile))
    {
      a.h(this.app, "0X800AE4C");
      localTextView.setText(2131696791);
      localButton.setText(2131696771);
      if (this.gV != null) {
        this.gV.setVisibility(8);
      }
    }
    for (;;)
    {
      e(paramDevlockInfo);
      return;
      localTextView.setText(paramDevlockInfo.Mobile);
      localButton.setText(2131696780);
      if (this.gV != null) {
        this.gV.setVisibility(0);
      }
    }
  }
  
  private String d(Bundle paramBundle)
  {
    if (this.EA != null)
    {
      Button localButton = (Button)findViewById(2131364419);
      String str = paramBundle.getString("phone");
      if (!TextUtils.isEmpty(str))
      {
        this.aZa = true;
        this.EA.setText(str);
        localButton.setText(2131696780);
      }
      for (;;)
      {
        return str;
        a.h(this.app, "0X800AE4B");
        this.aZa = false;
        this.EA.setText(2131696791);
        localButton.setText(2131696771);
        if (!paramBundle.containsKey("skip_url")) {
          this.f.i(true, false, 17);
        }
      }
    }
    return "";
  }
  
  private void e(DevlockInfo paramDevlockInfo)
  {
    boolean bool2 = false;
    if (paramDevlockInfo.DevSetup == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!TextUtils.isEmpty(paramDevlockInfo.Mobile)) {
        bool2 = true;
      }
      QLog.i("IphoneTitleBarActivity", 1, "setDevLockLayoutStatus, open=" + bool1 + "phoneSet=" + bool2);
      if (!bool2) {
        break label107;
      }
      if (afrz.a().Dx() != afrz.cTE) {
        break;
      }
      a(this.gV, 1, 4);
      return;
    }
    if (bool1)
    {
      a(this.gV, 1, 2);
      return;
    }
    label107:
    a(this.gV, 3, 1);
  }
  
  private void f(DevlockInfo paramDevlockInfo)
  {
    if (paramDevlockInfo == null)
    {
      QLog.i("IphoneTitleBarActivity", 1, "dev lock info not exists");
      bSi();
    }
    do
    {
      return;
      Intent localIntent;
      if (TextUtils.isEmpty(paramDevlockInfo.Mobile))
      {
        QLog.i("IphoneTitleBarActivity", 1, "onClickChangeSecurePhone, no secure phone");
        localIntent = new Intent(this, AuthDevOpenUgActivity.class);
        localIntent.putExtra("DevlockInfo", paramDevlockInfo);
        startActivityForResult(localIntent, 0);
        return;
      }
      if (paramDevlockInfo.AllowSet == 0)
      {
        QLog.i("IphoneTitleBarActivity", 1, "onClickChangeSecurePhone, allow set is 0");
        localIntent = new Intent(this, AuthDevOpenUgActivity.class);
        localIntent.putExtra("DevlockInfo", paramDevlockInfo);
        startActivityForResult(localIntent, 0);
        return;
      }
    } while (paramDevlockInfo.AllowSet != 1);
    QLog.i("IphoneTitleBarActivity", 1, "onClickChangeSecurePhone, allow set is 1");
    afsb.a(this, this.app, afsb.cTH, 1003, null);
  }
  
  private boolean h(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "isNeedShowTips isDevLock = " + paramBoolean1 + ", isBindPhoneNumber = " + paramBoolean2 + ", isBackFromDevLock = " + this.aZc);
    }
    if (paramBoolean1) {
      return false;
    }
    if (this.aZc)
    {
      this.aZc = false;
      return false;
    }
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.app.getManager(11);
    int i = localPhoneContactManagerImp.xy();
    if (((i != 8) && (i != 9)) || (!localPhoneContactManagerImp.Uw())) {}
    for (paramBoolean1 = false;; paramBoolean1 = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "isNeedShowTips isOpenContact = " + paramBoolean1);
      }
      if (((!paramBoolean2) && (!paramBoolean1)) || (!Qm())) {
        break;
      }
      return true;
    }
  }
  
  private void vS(String paramString)
  {
    paramString = new StringBuilder(paramString);
    paramString.append("?");
    paramString.append("type=" + afsb.cTK);
    paramString.append("&plat=1");
    paramString.append("&app=1");
    paramString.append("&version=3.4.4.3058");
    paramString.append("&device=" + URLEncoder.encode(Build.DEVICE));
    paramString.append("&system=" + Build.VERSION.RELEASE);
    paramString.append("&systemInt=" + Integer.toString(Build.VERSION.SDK_INT));
    paramString = paramString.toString();
    Intent localIntent = new Intent(this, PhoneUnityVerifyActivity.class);
    localIntent.putExtra("url", paramString);
    super.startActivityForResult(localIntent, 1006);
    BaseActivity.sTopActivity.overridePendingTransition(2130772009, 0);
  }
  
  public void bSt()
  {
    a.h(this.app, "0X800AE4D");
    anot.a(this.app, "CliOper", "", "", "0X8005B85", "0X8005B85", 0, 0, "", "", "", "");
    Intent localIntent = new Intent(this, SettingActivity2.class);
    localIntent.putExtra("kSrouce", 2);
    localIntent.putExtra("selfSet_leftViewText", getString(2131701652));
    super.startActivityForResult(localIntent, 1002);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneUnityBindInfoActivity", 2, "doOnActivityResult requestCode = " + paramInt1 + " resultCode = " + paramInt2);
    }
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
        n(4, null);
        return;
        super.setResult(paramInt2);
        n(4, null);
        return;
        if (paramInt2 == -1) {
          if (this.mSource == 21) {
            super.setResult(paramInt2);
          }
        }
        for (;;)
        {
          n(4, null);
          if ((paramInt2 != -1) || (paramIntent == null) || (paramIntent.getBooleanExtra("phone_num_login_result", true))) {
            break;
          }
          a(this.fY, 3, 1);
          return;
          super.setResult(paramInt2);
        }
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          switch (paramIntent.getIntExtra("resultState", 5))
          {
          default: 
            super.setResult(paramInt2);
            super.finish();
            return;
          }
          n(4, null);
          return;
        }
      } while (paramInt2 != 0);
      paramIntent = this.ad;
    } while ((paramIntent == null) || ((paramIntent.getInt("need_unify", 0) == 1) && (TextUtils.isEmpty(paramIntent.getString("skip_url")))));
    bt(paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.aZc = false;
    this.mSource = getIntent().getIntExtra("kSrouce", -1);
    this.aYY = getIntent().getBooleanExtra("kIsWeb", false);
    this.aYZ = getIntent().getBooleanExtra("kBindNew", false);
    this.ac = getIntent().getBundleExtra("kBindPhoneData");
    super.setContentView(2131561533);
    super.setTitle(getString(2131701652));
    super.setContentBackgroundResource(2130838900);
    this.a = ((yuu)this.app.getManager(102));
    if ((!this.f.Uv()) && (!this.aYZ) && (this.aYY))
    {
      paramBundle = new Intent(this, BindNumberActivity.class);
      paramBundle.putExtra("cmd_param_is_from_uni", true);
      paramBundle.putExtra("cmd_param_is_from_change_bind", false);
      paramBundle.putExtra("kUnityWebBind", true);
      paramBundle.putExtra("kSrouce", this.mSource);
      startActivityForResult(paramBundle, 1007);
      return true;
    }
    this.gU = ((RelativeLayout)super.findViewById(2131373067));
    if (this.gU != null)
    {
      this.gU.setBackgroundResource(2130839701);
      this.gU.setOnClickListener(this);
      bSs();
    }
    this.fY = ((RelativeLayout)super.findViewById(2131373069));
    if (this.fY != null)
    {
      this.fY.setBackgroundResource(2130839695);
      paramBundle = (TextView)this.fY.findViewById(2131375085);
      if (paramBundle != null) {
        paramBundle.setText(2131696784);
      }
      paramBundle = (TextView)this.fY.findViewById(2131375087);
      if (paramBundle != null) {
        paramBundle.setText(2131696803);
      }
    }
    this.gV = ((RelativeLayout)super.findViewById(2131373068));
    if (this.gV != null)
    {
      this.gV.setBackgroundResource(2130839695);
      paramBundle = (TextView)this.gV.findViewById(2131375085);
      if (paramBundle != null) {
        paramBundle.setText(2131693215);
      }
      paramBundle = (TextView)this.gV.findViewById(2131375087);
      if (paramBundle != null) {
        paramBundle.setText(2131696803);
      }
    }
    this.EA = ((TextView)super.findViewById(2131363494));
    if (this.a != null) {
      this.a.bpb = true;
    }
    super.addObserver(this.c);
    if (this.aYZ)
    {
      n(1, null);
      ContactBindedActivity.b(this.app, 222, 1);
    }
    for (;;)
    {
      a.h(this.app, "0X800AE4A");
      anot.a(this.app, "dc00898", "", "", "0X8009EC1", "0X8009EC1", 0, 0, "", "", "", "");
      return true;
      n(4, this.ac);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    super.removeObserver(this.c);
    bSq();
    bSr();
    if (this.mActionSheet != null)
    {
      this.mActionSheet.superDismiss();
      this.mActionSheet = null;
    }
    if (this.H != null)
    {
      this.H.dismiss();
      this.H = null;
    }
    if (this.I != null)
    {
      this.I.dismiss();
      this.I = null;
    }
    if (this.J != null)
    {
      this.J.dismiss();
      this.J = null;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.mInit))
    {
      this.mInit = true;
      if (this.aYZ) {
        QQToast.a(BaseApplication.getContext(), 2, 2131696807, 0);
      }
    }
  }
  
  public void n(int paramInt, Bundle paramBundle)
  {
    bSi();
    if (paramBundle == null)
    {
      bSo();
      paramBundle = (acll)this.app.getBusinessHandler(34);
      if (paramBundle != null)
      {
        QLog.i("IphoneTitleBarActivity", 1, "refreshServerData, getPhoneUnityInfo");
        paramBundle.f(paramInt, 31, null, null);
      }
      return;
    }
    QLog.i("IphoneTitleBarActivity", 1, "init with prefetched bind phone data");
    a(true, paramBundle, false);
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    switch (paramView.getId())
    {
    }
    label544:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bSl();
      continue;
      f(this.b);
      continue;
      bSt();
      continue;
      a.h(this.app, "0X800AE4E");
      anot.a(this.app, "CliOper", "", "", "0X8005B86", "0X8005B86", 0, 0, "", "", "", "");
      Object localObject1 = null;
      Object localObject2 = this.ad;
      if (localObject2 != null) {
        localObject1 = ((Bundle)localObject2).getByteArray("vaskey");
      }
      localObject2 = new Intent(this, PhoneUnityPhoneLoginActivity.class);
      ((Intent)localObject2).putExtra("phone_num_login_sig", (byte[])localObject1);
      super.startActivityForResult((Intent)localObject2, 1005);
      continue;
      QLog.i("IphoneTitleBarActivity", 1, "phone_unity_info_devlock clicked");
      a.h(this.app, "0X800AE4F");
      anot.a(this.app, "CliOper", "", "", "0X8005B87", "0X8005B87", 0, 0, "", "", "", "");
      this.aZc = true;
      localObject1 = new IntentFilter("mqq.intent.action.DEVLOCK_ROAM");
      super.registerReceiver(this.aE, (IntentFilter)localObject1);
      localObject1 = new Intent();
      ((Intent)localObject1).setFlags(268435456);
      ((Intent)localObject1).setAction("android.intent.action.VIEW");
      ((Intent)localObject1).putExtra("devlock_open_source", "PhoneUnity");
      ((Intent)localObject1).setData(Uri.parse("mqqdevlock://devlock/open?"));
      super.startActivity((Intent)localObject1);
      continue;
      localObject1 = paramView.getParent();
      if ((localObject1 != null) && ((localObject1 instanceof RelativeLayout))) {
        switch (((RelativeLayout)localObject1).getId())
        {
        default: 
          break;
        case 2131373068: 
          bSm();
          break;
        case 2131373069: 
          anot.a(this.app, "CliOper", "", "", "0X8005B83", "0X8005B83", 0, 0, "", "", "", "");
          if (!aqiw.isNetSupport(this))
          {
            QQToast.a(this, getString(2131693404), 0).show(getTitleBarHeight());
          }
          else
          {
            a(this.fY, 2, 1);
            localObject1 = (acll)this.app.getBusinessHandler(34);
            if (localObject1 != null)
            {
              localObject2 = this.ad;
              if (localObject2 != null)
              {
                QLog.i("IphoneTitleBarActivity", 1, "phone_unity_info_login, bindPhoneNumLogin");
                localObject2 = ((Bundle)localObject2).getByteArray("vaskey");
                if (localObject2 != null) {
                  ((acll)localObject1).aL((byte[])localObject2);
                }
              }
            }
            for (;;)
            {
              if (i == 0) {
                break label544;
              }
              a(this.fY, 3, 1);
              break;
              i = 1;
            }
          }
          break;
        }
      }
    }
  }
  
  static class a
  {
    public static void h(QQAppInterface paramQQAppInterface, String paramString)
    {
      anot.a(paramQQAppInterface, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity
 * JD-Core Version:    0.7.0.1
 */