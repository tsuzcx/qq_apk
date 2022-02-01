package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import acfd;
import acfp;
import ajdo;
import akwl;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqdj;
import aqha;
import aqiw;
import aqje;
import aqju;
import auru;
import auum;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import java.util.List;
import zpt;
import zpu;
import zpv;
import zpw;
import zpx;
import zpy;
import zpz;
import zqa;
import zqb;

public class BindNumberActivity
  extends DialogBaseActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, View.OnKeyListener, CompoundButton.OnCheckedChangeListener, auum
{
  protected CheckBox E;
  public aqju H;
  public aqju I;
  protected TextView Na;
  public EditText aO;
  public aqju aa;
  protected String bay = acfp.m(2131703211);
  public String baz;
  public boolean bsj;
  public boolean bsk;
  protected boolean bsl;
  protected boolean bsm;
  protected boolean bsn;
  public boolean bso;
  public acfd c;
  public String countryCode = "+86";
  public akwl d;
  protected ViewGroup dH;
  protected Button eH;
  public akwl g;
  private final Handler handler = new auru(Looper.getMainLooper(), this);
  private int mSource = -1;
  
  private void Fr(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindNumberActivity", 2, String.format("finish2 [%s]", new Object[] { Integer.valueOf(paramInt) }));
    }
    super.finish();
    if (VH()) {
      overridePendingTransition(2130772002, 2130772369);
    }
  }
  
  private void cqU()
  {
    this.aO.postDelayed(new BindNumberActivity.1(this), 300L);
  }
  
  private void cqV()
  {
    this.baz = this.aO.getText().toString().trim();
    if (TextUtils.isEmpty(this.baz))
    {
      showToast(acfp.m(2131703221));
      return;
    }
    if ((this.countryCode.equalsIgnoreCase("+86")) && (this.baz.length() != 11))
    {
      showToast(2131696842);
      return;
    }
    if (!aqiw.isNetSupport(this))
    {
      showToast(2131696348);
      return;
    }
    if (this.bsm)
    {
      this.handler.sendEmptyMessage(0);
      return;
    }
    this.handler.sendEmptyMessage(2);
  }
  
  private void dm(String paramString1, String paramString2)
  {
    paramString1 = paramString1 + " " + paramString2;
    Rect localRect = new Rect();
    this.Na.getPaint().getTextBounds(paramString1, 0, paramString1.length(), localRect);
    int i = getResources().getDimensionPixelSize(2131297878);
    int j = getResources().getDimensionPixelSize(2131297877);
    if (localRect.right > i - j * 2) {
      this.Na.setText(paramString2);
    }
    for (;;)
    {
      if (AppSetting.enableTalkBack) {
        this.Na.setContentDescription(this.Na.getText() + acfp.m(2131703213));
      }
      return;
      this.Na.setText(paramString1);
    }
  }
  
  private void doCommit()
  {
    if (this.bsk) {
      report("dc00898", "0X8009EC3", 0);
    }
    report("dc00898", "0X8009F12", 0);
    if (this.bsm)
    {
      if (this.aa == null) {
        this.aa = aqha.a(this, 230, null, acfp.m(2131703220), getString(2131721058), getString(2131721079), new zpu(this), new zpv(this));
      }
      if ((this.aa != null) && (!this.aa.isShowing()) && (!isFinishing())) {
        this.aa.show();
      }
      return;
    }
    cqV();
  }
  
  protected void L(int paramInt, List<String> paramList)
  {
    if (QLog.isColorLevel()) {
      if (paramList != null) {
        break label81;
      }
    }
    View localView;
    label81:
    for (Object localObject = "null";; localObject = Integer.valueOf(paramList.size()))
    {
      QLog.i("BindNumberActivity", 2, String.format("updateFrdInPhoneContact [%s, %s]", new Object[] { Integer.valueOf(paramInt), localObject }));
      localView = this.dH.findViewById(2131367588);
      if ((paramInt >= 10) && (paramList != null) && (paramList.size() >= 3)) {
        break;
      }
      localView.setVisibility(8);
      return;
    }
    localView.setVisibility(0);
    ((TextView)localView.findViewById(2131372299)).setText(String.format(getString(2131696826), new Object[] { Integer.valueOf(paramInt) }));
    int[] arrayOfInt = new int[3];
    int[] tmp142_140 = arrayOfInt;
    tmp142_140[0] = 2131368376;
    int[] tmp148_142 = tmp142_140;
    tmp148_142[1] = 2131368377;
    int[] tmp154_148 = tmp148_142;
    tmp154_148[2] = 2131368378;
    tmp154_148;
    paramInt = 0;
    label163:
    ImageView localImageView;
    if (paramInt < arrayOfInt.length)
    {
      localImageView = (ImageView)localView.findViewById(arrayOfInt[paramInt]);
      if (localImageView != null) {
        break label196;
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label163;
      break;
      label196:
      if (paramInt < paramList.size()) {}
      for (localObject = (String)paramList.get(paramInt);; localObject = null)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label239;
        }
        localImageView.setVisibility(8);
        break;
      }
      label239:
      localImageView.setVisibility(0);
      localImageView.setImageDrawable(aqdj.a(this.app, 1, (String)localObject));
      if ((localImageView instanceof ThemeImageView)) {
        ((ThemeImageView)localImageView).setSupportMaskView(true);
      }
    }
  }
  
  protected boolean VH()
  {
    boolean bool = false;
    if ((this.bsn) || (this.mSource == 9) || (this.mSource == 11) || (this.mSource == 10)) {
      bool = true;
    }
    return bool;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    if ((paramInt2 > 0) && (paramInt4 > 0) && (paramInt2 < paramInt4) && (paramInt1 == paramInt3)) {
      this.handler.sendEmptyMessageDelayed(4, 100L);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    cqW();
  }
  
  public void bK(Bundle paramBundle)
  {
    report("dc00898", "0X8009F14", 0);
    Object localObject = paramBundle.getString("k_uin");
    if (TextUtils.isEmpty(this.countryCode)) {}
    for (paramBundle = this.baz;; paramBundle = this.countryCode + " " + this.baz)
    {
      localObject = getResources().getString(2131696845, new Object[] { paramBundle, localObject, this.app.getCurrentAccountUin() });
      int i = ((String)localObject).indexOf(paramBundle);
      localObject = new SpannableString((CharSequence)localObject);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.rgb(255, 159, 64)), i, paramBundle.length() + i, 17);
      paramBundle = aqha.a(this, 230, null, (CharSequence)localObject, getString(2131721058), getString(2131721079), new zpy(this), new zpz(this));
      if ((paramBundle != null) && (!paramBundle.isShowing()) && (!isFinishing())) {
        paramBundle.show();
      }
      return;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void cqW()
  {
    boolean bool2 = false;
    if ((this.eH == null) || (this.aO == null)) {
      return;
    }
    if (this.bso)
    {
      this.eH.setEnabled(false);
      return;
    }
    boolean bool1 = bool2;
    if (this.aO.getText().toString().trim().length() > 0)
    {
      bool1 = bool2;
      if (this.E.isChecked()) {
        bool1 = true;
      }
    }
    this.eH.setEnabled(bool1);
  }
  
  public void cqX()
  {
    Intent localIntent = new Intent(this, BindVerifyActivity.class);
    localIntent.putExtra("kSrouce", this.mSource);
    localIntent.putExtra("kBindType", 0);
    localIntent.putExtra("keyReqBindMode", 0);
    localIntent.putExtra("k_number", this.baz);
    localIntent.putExtra("k_country_code", this.countryCode);
    localIntent.putExtra("k_is_block", getIntent().getBooleanExtra("k_is_block", false));
    localIntent.putExtra("key_is_from_qqhotspot", getIntent().getBooleanExtra("key_is_from_qqhotspot", false));
    localIntent.putExtra("cmd_param_is_from_uni", this.bsj);
    localIntent.putExtra("key_is_from_qav_multi_call", getIntent().getBooleanExtra("key_is_from_qav_multi_call", false));
    localIntent.putExtra("cmd_param_is_from_change_bind", this.bsk);
    localIntent.addFlags(536870912);
    localIntent.addFlags(67108864);
    if (!isFinishing()) {
      startActivityForResult(localIntent, 2);
    }
  }
  
  public void cqY()
  {
    Object localObject;
    if (this.mSource == 10)
    {
      localObject = new Intent(this, SplashActivity.class);
      ((Intent)localObject).putExtra("main_tab_id", 1);
      ((Intent)localObject).setFlags(603979776);
      startActivity((Intent)localObject);
    }
    for (;;)
    {
      setResult(-1);
      Fr(3);
      return;
      localObject = (PhoneContactManagerImp)this.app.getManager(11);
      RespondQueryQQBindingStat localRespondQueryQQBindingStat = ((PhoneContactManagerImp)localObject).a();
      if ((!((PhoneContactManagerImp)localObject).Ut()) && (localRespondQueryQQBindingStat != null) && (!localRespondQueryQQBindingStat.isStopFindMatch))
      {
        localObject = new Intent(this, PhoneMatchActivity.class);
        ((Intent)localObject).putExtra("key_from_contact_first", true);
        startActivity((Intent)localObject);
      }
    }
  }
  
  public void cqZ()
  {
    anot.a(this.app, "CliOper", "", "", "0X8005B78", "0X8005B78", 0, 0, "", "", "", "");
    if (this.H == null) {
      this.H = aqha.a(this, 230, null, "该手机号码已绑定一个无密码的QQ号，需给原QQ号设置密码后才能解绑并绑定新QQ号。", null, acfp.m(2131703212), new zqa(this), null);
    }
    if ((this.H != null) && (!this.H.isShowing()) && (!isFinishing())) {
      this.H.show();
    }
  }
  
  public void cra()
  {
    anot.a(this.app, "CliOper", "", "", "0X8005B77", "0X8005B77", 0, 0, "", "", "", "");
    if (this.I == null) {
      this.I = aqha.a(this, 230, null, acfp.m(2131703218), null, acfp.m(2131703216), new zqb(this), null);
    }
    if ((this.I != null) && (!this.I.isShowing()) && (!isFinishing())) {
      this.I.show();
    }
  }
  
  protected void crb()
  {
    if ((this.mSource == 10) || (this.mSource == 11) || (this.mSource == 15) || (this.mSource == 17) || (this.mSource == 1) || (this.mSource == 12) || (this.mSource == 14)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        L(0, null);
        return;
      }
      Object localObject = (ajdo)this.app.getManager(11);
      if (localObject != null)
      {
        localObject = ((ajdo)localObject).d();
        i = ((Integer)localObject[0]).intValue();
        localObject = (List)localObject[1];
      }
      for (;;)
      {
        L(i, (List)localObject);
        if (this.c == null)
        {
          this.c = new zpt(this);
          this.app.addObserver(this.c);
        }
        localObject = (FriendListHandler)this.app.getBusinessHandler(1);
        if (localObject == null) {
          break;
        }
        ((FriendListHandler)localObject).IZ(3);
        return;
        localObject = null;
        i = 0;
      }
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1) {
      if (paramInt2 == -1)
      {
        this.bay = paramIntent.getStringExtra("k_name");
        this.countryCode = ("+" + paramIntent.getStringExtra("k_code"));
        dm(this.bay, this.countryCode);
      }
    }
    for (;;)
    {
      return;
      if ((paramInt1 == 2) && (paramInt2 != 0))
      {
        setResult(paramInt2, paramIntent);
        if (paramInt2 != -1) {
          break;
        }
        i(paramIntent, 3);
        if (this.mSource == 7) {
          anot.a(this.app, "CliOper", "", "", "0X80053E2", "0X80053E2", 0, 0, "", "", "", "");
        }
        while (this.mSource == 11)
        {
          anot.a(this.app, "CliOper", "", "", "0X8006EFA", "0X8006EFA", 0, 0, "", "", "", "");
          return;
          if (this.mSource == 12) {
            anot.a(this.app, "CliOper", "", "", "0X80053DC", "0X80053DC", 0, 0, "", "", "", "");
          }
        }
      }
    }
    Fr(3);
  }
  
  public void doOnBackPressed()
  {
    boolean bool = false;
    if ((this.mSource == 10) || (this.mSource == 11))
    {
      if (this.mSource == 10) {
        bool = true;
      }
      BS(bool);
      return;
    }
    if (getIntent().getBooleanExtra("k_is_block", false)) {
      anot.a(this.app, "CliOper", "", "", "0X80053D4", "0X80053D4", 0, 0, "", "", "", "");
    }
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.mSource = getIntent().getIntExtra("kSrouce", -1);
    this.bsm = getIntent().getBooleanExtra("kNeedUnbind", false);
    this.bsn = getIntent().getBooleanExtra("key_is_modal_pop", false);
    this.bsj = getIntent().getBooleanExtra("cmd_param_is_from_uni", false);
    this.bsk = getIntent().getBooleanExtra("cmd_param_is_from_change_bind", false);
    this.bsl = getIntent().getBooleanExtra("kUnityWebBind", false);
    if (QLog.isColorLevel()) {
      QLog.d("BindNumberActivity", 2, String.format("onCreate [%s, %s, %s]", new Object[] { Boolean.valueOf(this.bsj), Boolean.valueOf(this.bsk), Integer.valueOf(this.mSource) }));
    }
    getWindow().setSoftInputMode(18);
    setContentView(2131559738);
    Resources localResources;
    if ((Build.MANUFACTURER.equalsIgnoreCase("Letv")) && (Build.MODEL.equalsIgnoreCase("X900+")))
    {
      this.dH = ((ViewGroup)findViewById(2131372296));
      this.dH.getRootView().setBackgroundDrawable(getResources().getDrawable(2130838900));
      localResources = getResources();
      if (!this.bsk) {
        break label706;
      }
      paramBundle = localResources.getString(2131696829);
      label242:
      setTitle("", "");
      if (!VH()) {
        break label746;
      }
      setLeftButton(2131721059, null);
      if (this.leftViewNotBack != null) {
        this.leftViewNotBack.setVisibility(8);
      }
      setRightButton(2131721059, this);
      label291:
      ((TextView)findViewById(2131372300)).setText(paramBundle);
      paramBundle = localResources.getString(2131696824);
      if (!this.bsk) {
        break label835;
      }
      paramBundle = localResources.getString(2131696825);
    }
    label706:
    label835:
    for (;;)
    {
      ((TextView)findViewById(2131372298)).setText(paramBundle);
      crb();
      label378:
      int i;
      if (0 != 0)
      {
        this.bay = "";
        new StringBuilder().append('+');
        throw new NullPointerException();
        this.Na = ((TextView)findViewById(2131365474));
        this.Na.setOnClickListener(this);
        dm(this.bay, this.countryCode);
        this.E = ((CheckBox)findViewById(2131380103));
        this.E.setOnCheckedChangeListener(this);
        this.E.setContentDescription(acfp.m(2131703222));
        this.aO = ((EditText)findViewById(2131372579));
        this.aO.addTextChangedListener(this);
        this.aO.setSingleLine();
        this.aO.setText(this.baz);
        if (!TextUtils.isEmpty(this.baz)) {
          this.aO.setSelection(this.baz.length());
        }
        this.aO.requestFocus();
        this.aO.setOnKeyListener(this);
        this.eH = ((Button)findViewById(2131365059));
        this.eH.setOnClickListener(this);
        cqW();
        findViewById(2131380104).setOnClickListener(this);
        findViewById(2131380106).setOnClickListener(this);
        switch (this.mSource)
        {
        case 0: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 10: 
        case 13: 
        case 16: 
        default: 
          i = 0;
        }
      }
      for (;;)
      {
        report("dc00898", "0X8009F11", i);
        return true;
        paramBundle = (BounceScrollView)findViewById(2131363711);
        if (paramBundle == null) {
          break;
        }
        paramBundle.setOnSizeChangeListener(this);
        break;
        if ((this.mSource == 12) || (this.mSource == 14))
        {
          paramBundle = localResources.getString(2131696827);
          break label242;
        }
        paramBundle = localResources.getString(2131696828);
        break label242;
        label746:
        setLeftViewName(2131690700);
        break label291;
        paramBundle = aqje.bg(this);
        if ("86".equals(paramBundle)) {
          break label378;
        }
        this.bay = "";
        this.countryCode = ('+' + paramBundle);
        break label378;
        i = 2;
        continue;
        i = 3;
        continue;
        i = 1;
        continue;
        i = 4;
        continue;
        i = 5;
        continue;
        i = 6;
      }
    }
  }
  
  public void doOnDestroy()
  {
    if (this.g != null)
    {
      this.app.unRegistObserver(this.g);
      this.g = null;
    }
    if (this.d != null)
    {
      this.app.unRegistObserver(this.d);
      this.d = null;
    }
    if (this.c != null)
    {
      this.app.removeObserver(this.c);
      this.c = null;
    }
    if (this.aa != null)
    {
      this.aa.dismiss();
      this.aa = null;
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
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (TextUtils.isEmpty(this.baz)) {
      cqU();
    }
  }
  
  public void finish()
  {
    Fr(0);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1: 
    default: 
      throw new RuntimeException("Unknown message: " + paramMessage.what);
    case 0: 
      if (this.d == null)
      {
        this.d = new zpw(this);
        this.app.registObserver(this.d);
      }
      paramMessage = (ajdo)this.app.getManager(11);
      j(2131719519, 1000L, true);
      paramMessage.bi(this.bsj, this.bsk);
    }
    do
    {
      do
      {
        return true;
        if (this.g == null)
        {
          this.g = new zpx(this);
          this.app.registObserver(this.g);
        }
        this.bso = true;
        cqW();
        this.f.a(this.countryCode, this.baz, 0, this.bsj, this.bsk);
      } while (3 == paramMessage.what);
      j(2131719519, 1000L, true);
      return true;
      this.handler.removeMessages(4);
      paramMessage = (BounceScrollView)findViewById(2131363711);
    } while (paramMessage == null);
    paramMessage.fullScroll(130);
    return true;
  }
  
  public void i(Intent paramIntent, int paramInt)
  {
    Intent localIntent = new Intent();
    if (paramIntent == null)
    {
      paramIntent = null;
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "onBindSuc src: " + this.mSource + ", per: " + paramIntent);
      }
      if (this.mSource != 10) {
        break label169;
      }
      paramIntent = new Intent(this, SplashActivity.class);
      paramIntent.putExtra("main_tab_id", 1);
      paramIntent.setFlags(603979776);
      startActivity(paramIntent);
    }
    for (;;)
    {
      setResult(-1, localIntent);
      Fr(paramInt);
      if (this.bsk) {
        anot.a(this.app, "dc00898", "", "", "0X8009EC4", "0X8009EC4", 0, 0, "", "", "", "");
      }
      return;
      paramIntent = paramIntent.getStringExtra("check_permission_result");
      break;
      label169:
      if (this.mSource != 21) {
        if (this.mSource == 22)
        {
          QQToast.a(this, 2131696841, 1).show();
        }
        else if (this.bsl)
        {
          paramIntent = new Intent(this, PhoneUnityBindInfoActivity.class);
          paramIntent.putExtra("kSrouce", this.mSource);
          paramIntent.putExtra("kBindNew", true);
          startActivity(paramIntent);
        }
        else if (("permission_denied".equals(paramIntent)) || ("permission_denied_by_user".equals(paramIntent)))
        {
          localIntent.putExtra("check_permission_result", paramIntent);
          paramIntent = new Intent(this, GuideBindPhoneActivity.class);
          paramIntent.putExtra("kSrouce", this.mSource);
          paramIntent.putExtra("fromKeyForContactBind", 1);
          startActivity(paramIntent);
        }
        else if ("permission_granted".equals(paramIntent))
        {
          ContactBindedActivity.a(this.app, this.mSource, 1, localIntent);
          localIntent.putExtra("check_permission_result", paramIntent);
        }
      }
    }
  }
  
  public boolean onBackEvent()
  {
    if ((this.mSource == 10) || (this.mSource == 11))
    {
      if (this.mSource == 10) {}
      for (boolean bool = true;; bool = false)
      {
        BS(bool);
        return true;
      }
    }
    report("dc00898", "0X8009F13", 0);
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("key_user_cancel", 1);
    setResult(0, (Intent)localObject);
    if (this.aO != null)
    {
      localObject = (InputMethodManager)getSystemService("input_method");
      if (localObject != null) {
        ((InputMethodManager)localObject).hideSoftInputFromWindow(this.aO.getWindowToken(), 0);
      }
    }
    finish();
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.E.isChecked()) {
      this.E.setContentDescription(acfp.m(2131703223));
    }
    for (;;)
    {
      cqW();
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      this.E.setContentDescription(acfp.m(2131703219));
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    switch (paramView.getId())
    {
    default: 
      this.app.logout(true);
      startActivity(new Intent(this, LoginActivity.class));
      Fr(1);
      report("CliOper", "0X80053D3", 0);
    case 2131365474: 
    case 2131369579: 
    case 2131369581: 
    case 2131369612: 
    case 2131365059: 
    case 2131380106: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        startActivityForResult(new Intent(this, CountryActivity.class), 1);
        continue;
        if ((this.mSource == 10) || (this.mSource == 11))
        {
          if (this.mSource == 10) {}
          for (;;)
          {
            BS(bool1);
            break;
            bool1 = false;
          }
        }
        setResult(0);
        finish();
        continue;
        doCommit();
        continue;
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", "https://qq-web.cdn-go.cn/agreement/latest/mqq/bindphone.html");
        startActivity((Intent)localObject);
      }
    }
    Object localObject = this.E;
    if (!this.E.isChecked()) {}
    for (bool1 = bool2;; bool1 = false)
    {
      ((CheckBox)localObject).setChecked(bool1);
      break;
    }
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramView == this.aO) && (66 == paramInt) && (paramKeyEvent.getAction() == 0))
    {
      cqV();
      return true;
    }
    return false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void report(String paramString1, String paramString2, int paramInt)
  {
    anot.a(this.app, paramString1, "", "", paramString2, paramString2, paramInt, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindNumberActivity
 * JD-Core Version:    0.7.0.1
 */