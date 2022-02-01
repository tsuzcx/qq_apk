package com.tencent.mobileqq.activity;

import adac;
import adae;
import akwp;
import altz;
import alub;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import anot;
import aqiw;
import aqje;
import aqwc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.lang.ref.WeakReference;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import vse;
import vsf;

public class RegisterVerifyCodeActivity
  extends RegisterNewBaseActivity
  implements adac, TextWatcher, View.OnClickListener, View.OnKeyListener, CompoundButton.OnCheckedChangeListener
{
  private static final int[] fu = { 2131381523, 2131381524, 2131381525, 2131381526, 2131381527, 2131381528 };
  private TextView Eq;
  private TextView Fz;
  private altz jdField_a_of_type_Altz;
  private alub jdField_a_of_type_Alub;
  private EditText[] jdField_a_of_type_ArrayOfAndroidWidgetEditText = new EditText[6];
  private String aOb;
  private String aPA;
  private String aPv;
  private String aPy;
  private String aPz;
  private int bKD = 60;
  private boolean baa = true;
  private boolean bad = true;
  private boolean bah = true;
  private AccountObserver d = new vsf(this);
  private LinearLayout gu;
  private LinearLayout gv;
  private Runnable runnableCountdown = new RegisterVerifyCodeActivity.1(this);
  private int second = 60;
  private adae smsContent;
  private MqqHandler u = new vse(this);
  private CheckBox w;
  private CheckBox x;
  
  private void bGv()
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      J(2131693404, 0);
      return;
    }
    Object localObject = new StringBuilder("");
    int i = 0;
    while (i < 6)
    {
      Editable localEditable = this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i].getText();
      if (localEditable != null) {
        ((StringBuilder)localObject).append(localEditable.toString());
      }
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    if (localObject != null) {
      localObject = ((String)localObject).trim();
    }
    for (;;)
    {
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        try
        {
          ((AccountManager)this.app.getManager(0)).sendRegisterByCommitSmsVerifycode((String)localObject, this.d);
          Bv(2131717032);
          anot.c(this.app, "dc00898", "", "", "0X8007CC8", "0X8007CC8", 0, 0, "", "", "", "");
          if ((this.gu.getVisibility() == 0) && (this.w.isChecked()) && (this.gv != null) && (this.gv.getVisibility() == 0) && (this.x != null) && (this.x.isChecked()))
          {
            anot.c(this.app, "dc00898", "", "", "0X8007CC8", "0X8007CC8", 1, 0, "", "", "", "");
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        if ((this.gu.getVisibility() != 0) && ((this.gv == null) || (this.gv.getVisibility() != 0)))
        {
          anot.c(this.app, "dc00898", "", "", "0X8007CC8", "0X8007CC8", 4, 0, "", "", "", "");
          return;
        }
        if ((this.gv != null) && (this.gv.getVisibility() == 0) && (this.x != null) && (!this.x.isChecked())) {
          anot.c(this.app, "dc00898", "", "", "0X8007CC8", "0X8007CC8", 2, 0, "", "", "", "");
        }
        if ((this.gu.getVisibility() != 0) || (this.w.isChecked())) {
          break;
        }
        anot.c(this.app, "dc00898", "", "", "0X8007CC8", "0X8007CC8", 3, 0, "", "", "", "");
        return;
      }
      J(2131717045, 0);
      return;
    }
  }
  
  private void bRs()
  {
    try
    {
      this.aOb = null;
      ((AccountManager)this.app.getManager(0)).sendRegistByResendSms(this.d);
      Bv(2131717125);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void initViews()
  {
    tK(2131717154);
    bVd();
    boolean bool = getIntent().getBooleanExtra("key_register_from_fail_pay_lh", false);
    if (bool) {
      Bw(100);
    }
    for (;;)
    {
      TextView localTextView = (TextView)findViewById(2131381120);
      String str1 = "+" + this.countryCode + " " + this.phoneNum;
      String str2 = getString(2131717146, new Object[] { str1 });
      SpannableString localSpannableString = new SpannableString(str2);
      ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(-31676);
      int i = str2.indexOf(str1);
      int j = str2.indexOf(str1);
      localSpannableString.setSpan(localForegroundColorSpan, i, str1.length() + j, 33);
      localTextView.setText(localSpannableString);
      this.Eq = ((TextView)findViewById(2131363970));
      this.Eq.setOnClickListener(this);
      this.Eq.setText(getString(2131717113) + "(" + this.second + "s)");
      this.handler.postDelayed(this.runnableCountdown, 1000L);
      i = 0;
      while (i < 6)
      {
        this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i] = ((EditText)findViewById(fu[i]).findViewById(2131381127));
        this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i].addTextChangedListener(this);
        this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i].setOnKeyListener(this);
        i += 1;
      }
      Bw(66);
    }
    this.w = ((CheckBox)findViewById(2131364579));
    this.w.setOnCheckedChangeListener(this);
    this.gu = ((LinearLayout)findViewById(2131370175));
    if ((this.aRQ) && (!this.aRR))
    {
      this.gu.setVisibility(8);
      this.baa = false;
    }
    do
    {
      return;
      if (bool)
      {
        this.baa = getIntent().getBooleanExtra("key_register_chose_bind_phone", false);
        this.w.setChecked(this.baa);
        this.w.setEnabled(false);
        if (!this.baa) {
          akwp.a().cuJ = false;
        }
      }
      this.Fz = ((TextView)findViewById(2131381102));
      this.x = ((CheckBox)findViewById(2131364584));
      this.x.setOnCheckedChangeListener(this);
      this.gv = ((LinearLayout)findViewById(2131370243));
    } while (getResources().getDisplayMetrics().heightPixels < 480);
    new a(this).execute(new Void[0]);
  }
  
  private int q(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterVerifyCodeActivity", 2, "v1:" + paramString1 + " v2:" + paramString2);
    }
    String[] arrayOfString = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int j;
    int k;
    if (arrayOfString.length > paramString2.length)
    {
      j = arrayOfString.length;
      k = 0;
    }
    for (;;)
    {
      if (k >= j) {
        break label146;
      }
      int i;
      int m;
      for (;;)
      {
        try
        {
          i = Integer.parseInt(arrayOfString[k]);
        }
        catch (Exception paramString1)
        {
          i = 0;
        }
        try
        {
          m = Integer.parseInt(paramString2[k]);
          if (i <= m) {
            break label129;
          }
          return 1;
        }
        catch (Exception paramString1)
        {
          break label119;
        }
        j = paramString2.length;
        break;
        label119:
        paramString1.printStackTrace();
        m = 0;
      }
      label129:
      if (i < m) {
        return -1;
      }
      k += 1;
    }
    label146:
    return 0;
  }
  
  private void restartTimer(int paramInt)
  {
    this.Eq.setEnabled(false);
    this.Eq.setClickable(false);
    this.second = paramInt;
    this.Eq.setText(getString(2131717113) + "(" + this.second + "s)");
    this.handler.postDelayed(this.runnableCountdown, 1000L);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = 1;
    int j = 0;
    Editable localEditable;
    if (j < 6)
    {
      localEditable = this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[j].getText();
      if (localEditable == null) {
        break label163;
      }
    }
    label135:
    label163:
    for (int k = localEditable.toString().length();; k = 0)
    {
      View localView = findViewById(fu[j]).findViewById(2131370493);
      if ((localEditable != null) && (localEditable == paramEditable))
      {
        if (k <= 0) {
          break label135;
        }
        localView.setBackgroundColor(-9474193);
        if (j < 5)
        {
          this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(j + 1)].requestFocus();
          this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(j + 1)].setSelection(this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(j + 1)].length());
        }
      }
      label116:
      if ((localEditable == null) || (k <= 0)) {
        i = 0;
      }
      for (;;)
      {
        j += 1;
        break;
        if (k != 0) {
          break label116;
        }
        localView.setBackgroundColor(-2170912);
        break label116;
        if (i != 0) {
          bGv();
        }
        return;
      }
    }
  }
  
  public void bRp()
  {
    akwp.a().cuJ = this.bah;
    akwp.a().b(this.app, this.bah);
    boolean bool1 = getIntent().getBooleanExtra("key_register_from_fail_pay_lh", false);
    boolean bool2 = getIntent().getBooleanExtra("key_register_phonenum_bindnewqq", true);
    Object localObject1 = new StringBuilder("");
    int i = 0;
    while (i < 6)
    {
      localObject2 = this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i].getText();
      if (localObject2 != null) {
        ((StringBuilder)localObject1).append(localObject2.toString());
      }
      i += 1;
    }
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = localObject2;
    if (localObject2 != null) {
      localObject1 = ((String)localObject2).trim();
    }
    if (bool1)
    {
      if (this.jdField_a_of_type_Alub == null) {
        this.jdField_a_of_type_Alub = new alub(this);
      }
      getIntent().putExtra("key_register_smscode", (String)localObject1);
      getIntent().putExtra("key_register_autologin", true);
      getIntent().putExtra("key_register_phonenum_bindnewqq", bool2);
      this.jdField_a_of_type_Alub.dI(getIntent());
      return;
    }
    if (this.aRQ)
    {
      localObject2 = new Intent(this, RegisterChooseLoginActivity.class);
      ((Intent)localObject2).putExtra("phonenum", this.phoneNum);
      ((Intent)localObject2).putExtra("invite_code", this.aLv);
      ((Intent)localObject2).putExtra("key", this.countryCode);
      ((Intent)localObject2).putExtra("key_register_smscode", (String)localObject1);
      ((Intent)localObject2).putExtra("key_register_binded_qq", this.aPv);
      ((Intent)localObject2).putExtra("key_register_binded_qq_nick", this.aPy);
      ((Intent)localObject2).putExtra("key_register_binded_qq_face_url", this.aPz);
      ((Intent)localObject2).putExtra("key_register_has_pwd", this.aRR);
      ((Intent)localObject2).putExtra("key_register_chose_bind_phone", this.baa);
      ((Intent)localObject2).putExtra("key_register_from", 5);
      startActivity((Intent)localObject2);
      return;
    }
    RegisterByNicknameAndPwdActivity.a(this.app, this, this.phoneNum, this.countryCode, (String)localObject1, false, this.aRR, true, this.aLv, 5, "", "", true);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131562063);
    if (QLog.isDevelopLevel()) {
      aqwc.h(getClass().getSimpleName(), getIntent());
    }
    this.phoneNum = getIntent().getStringExtra("phonenum");
    this.aLv = getIntent().getStringExtra("invite_code");
    this.countryCode = getIntent().getStringExtra("key");
    int i = getIntent().getIntExtra("key_register_left_time", 0);
    long l = getIntent().getLongExtra("key_register_exit_time", 0L);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onCreate countryCode=").append(this.countryCode).append(", phoneNum=").append(aqje.encrypt(this.phoneNum)).append(", leftTime=").append(i).append(", exitTime=").append(l).append(", inviteCode=");
      if (this.aLv == null)
      {
        paramBundle = "";
        QLog.d("RegisterVerifyCodeActivity", 2, paramBundle);
      }
    }
    else
    {
      if ((i > 0) && (i < 60) && (l > 0L))
      {
        l = System.currentTimeMillis() - l;
        if ((l > 0L) && (l < i * 1000L)) {
          this.second = (i - (int)(l / 1000L));
        }
        if (QLog.isColorLevel()) {
          QLog.d("RegisterVerifyCodeActivity", 2, "onCreate interval=" + l + ", second=" + this.second);
        }
      }
      this.aRQ = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
      this.aRR = getIntent().getBooleanExtra("key_register_has_pwd", true);
      this.aPv = getIntent().getStringExtra("key_register_binded_qq");
      this.app.setHandler(getClass(), this.u);
      initViews();
      this.smsContent = new adae(null, getIntent().getLongExtra("register_verify_code_start_time", 0L));
      this.smsContent.a(this, this);
      anot.a(this.app, "CliOper", "", "", "0X8006656", "0X8006656", 0, 0, "", "", "", "");
      anot.c(this.app, "dc00898", "", "", "0X8007361", "0X8007361", 0, 0, "", "", "", "");
      if (this.aRQ) {
        break label539;
      }
      anot.c(this.app, "dc00898", "", "", "0X8007361", "0X8007361", 1, 0, "", "", "", "");
      label482:
      if (this.mFrom != 7) {
        break label610;
      }
      anot.a(this.app, "new_reg_805", "msg_page", "page_exp", "", 1, "", "1", "", "", "", "", "", "", "");
    }
    for (;;)
    {
      return true;
      paramBundle = this.aLv;
      break;
      label539:
      if (!this.aRR)
      {
        anot.c(this.app, "dc00898", "", "", "0X8007361", "0X8007361", 2, 0, "", "", "", "");
        break label482;
      }
      anot.c(this.app, "dc00898", "", "", "0X8007361", "0X8007361", 3, 0, "", "", "", "");
      break label482;
      label610:
      anot.a(this.app, "new_reg_805", "msg_page", "page_exp", "", 1, "", "2", "", "", "", "", "", "", "");
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_Alub != null) {
      this.jdField_a_of_type_Alub.onResume();
    }
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    runOnUiThread(new RegisterVerifyCodeActivity.4(this, paramString1, paramString2));
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    if (this.jdField_a_of_type_Alub != null) {
      this.jdField_a_of_type_Alub.onAccountChanged();
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.second > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RegisterVerifyCodeActivity", 2, "onBackEvent second=" + this.second + ", curTime=" + System.currentTimeMillis());
      }
      getIntent().putExtra("key_register_left_time", this.second);
      getIntent().putExtra("key_register_exit_time", System.currentTimeMillis());
      setResult(-1, getIntent());
    }
    finish();
    return false;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.getId() == 2131364584) {
      this.bah = paramBoolean;
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (paramBoolean)
      {
        anot.a(this.app, "CliOper", "", "", "0X8006657", "0X8006657", 0, 0, "", "", "", "");
        this.baa = true;
        if (this.x != null) {
          this.x.setEnabled(true);
        }
      }
      else
      {
        this.baa = false;
        if (this.x != null)
        {
          this.x.setOnCheckedChangeListener(null);
          this.bah = false;
          this.x.setChecked(false);
          this.x.setEnabled(false);
          this.x.setOnCheckedChangeListener(this);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext())) {
      J(2131693404, 0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131363918: 
        bGv();
        break;
      case 2131363970: 
        bRs();
        anot.a(this.app, "new_reg_805", "msg_page", "resend_clk", "", 1, "", "", "", "", "", "", "", "", "");
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    gV();
    if (this.smsContent != null) {
      this.smsContent.unregister();
    }
    this.smsContent = null;
    this.handler.removeCallbacks(this.runnableCountdown);
    if (this.jdField_a_of_type_Altz != null) {
      this.jdField_a_of_type_Altz.onDestroy();
    }
    this.jdField_a_of_type_Altz = null;
    if (this.jdField_a_of_type_Alub != null) {
      this.jdField_a_of_type_Alub.onDestroy();
    }
    this.jdField_a_of_type_Alub = null;
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 0) && ((paramView instanceof EditText)))
    {
      paramView = ((EditText)paramView).getText();
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt < 6)
      {
        paramKeyEvent = this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[paramInt].getText();
        if ((paramKeyEvent == null) || (paramKeyEvent != paramView)) {
          break label157;
        }
        if ((paramInt <= 0) || (paramInt >= 6) || (paramKeyEvent.toString().length() > 0)) {
          break label124;
        }
        this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(paramInt - 1)].setText("");
        this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(paramInt - 1)].requestFocus();
        this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(paramInt - 1)].setSelection(this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(paramInt - 1)].length());
      }
      label124:
      while ((paramInt < 0) || (paramInt >= 6) || (paramKeyEvent.toString().length() <= 0)) {
        return false;
      }
      this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[paramInt].setText("");
      return false;
      label157:
      paramInt += 1;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      if ((this.dialog != null) && (this.dialog.isShowing())) {
        this.dialog.dismiss();
      }
      this.dialog = null;
      if (this.jdField_a_of_type_Alub != null) {
        this.jdField_a_of_type_Alub.onPause();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public static class a
    extends AsyncTask<Void, Void, Void>
  {
    WeakReference<RegisterVerifyCodeActivity> mActivity = null;
    
    public a(RegisterVerifyCodeActivity paramRegisterVerifyCodeActivity)
    {
      this.mActivity = new WeakReference(paramRegisterVerifyCodeActivity);
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      boolean bool3 = true;
      File localFile = new File(BaseApplication.getContext().getFilesDir(), "RegDevLockCfg.xml");
      if (!HttpDownloadUtil.a(null, "https://dldir1.qq.com/qqfile/qd/RegDevLockCfg.xml?mType=ConfigCheck", localFile))
      {
        if (QLog.isColorLevel()) {
          QLog.d("RegisterVerifyCodeActivity", 2, "download cfg file failed.");
        }
        return null;
      }
      paramVarArgs = DocumentBuilderFactory.newInstance();
      label524:
      label530:
      label536:
      label542:
      label547:
      label553:
      label558:
      label563:
      for (;;)
      {
        try
        {
          localObject3 = paramVarArgs.newDocumentBuilder().parse(localFile).getDocumentElement();
          paramVarArgs = ((Element)localObject3).getElementsByTagName("Enable");
          if (paramVarArgs.getLength() <= 0) {
            break label553;
          }
          if (Integer.parseInt(((Text)((Element)paramVarArgs.item(0)).getChildNodes().item(0)).getNodeValue()) == 1)
          {
            bool1 = true;
            break label558;
            paramVarArgs = ((Element)localObject3).getElementsByTagName("EnableVersion");
            if (paramVarArgs.getLength() <= 0) {
              break label547;
            }
            paramVarArgs = ((Text)((Element)paramVarArgs.item(0)).getChildNodes().item(0)).getNodeValue();
            localObject1 = ((Element)localObject3).getElementsByTagName("CheckBoxDefStatus");
            if (((NodeList)localObject1).getLength() <= 0) {
              break label542;
            }
            if (Integer.parseInt(((Text)((Element)((NodeList)localObject1).item(0)).getChildNodes().item(0)).getNodeValue()) == 1)
            {
              bool1 = bool3;
              break label563;
              localObject1 = ((Element)localObject3).getElementsByTagName("CheckBoxWording");
              if (((NodeList)localObject1).getLength() <= 0) {
                break label536;
              }
              localObject1 = ((Text)((Element)((NodeList)localObject1).item(0)).getChildNodes().item(0)).getNodeValue();
              localObject2 = ((Element)localObject3).getElementsByTagName("CheckBoxHighlightWording");
              if (((NodeList)localObject2).getLength() <= 0) {
                break label530;
              }
              localObject2 = ((Text)((Element)((NodeList)localObject2).item(0)).getChildNodes().item(0)).getNodeValue();
              localObject3 = ((Element)localObject3).getElementsByTagName("IntroductionURL");
              if (((NodeList)localObject3).getLength() <= 0) {
                break label524;
              }
              localObject3 = ((Text)((Element)((NodeList)localObject3).item(0)).getChildNodes().item(0)).getNodeValue();
              Bundle localBundle = new Bundle();
              localBundle.putBoolean("visibility", bool2);
              localBundle.putString("enableVersion", paramVarArgs);
              localBundle.putBoolean("checked", bool1);
              localBundle.putString("openDevLockText", (String)localObject1);
              localBundle.putString("openDevLockHelpText", (String)localObject2);
              localBundle.putString("openDevLockHelpURL", (String)localObject3);
              paramVarArgs = (RegisterVerifyCodeActivity)this.mActivity.get();
              return null;
            }
          }
          else
          {
            bool1 = false;
            break label558;
          }
          bool1 = false;
        }
        catch (Exception paramVarArgs)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RegisterVerifyCodeActivity", 2, "parse cfg file failed.");
          }
          paramVarArgs.printStackTrace();
          return null;
        }
        finally
        {
          localFile.delete();
        }
        Object localObject3 = null;
        continue;
        Object localObject2 = null;
        continue;
        Object localObject1 = null;
        continue;
        boolean bool1 = false;
        continue;
        paramVarArgs = "";
        continue;
        boolean bool2 = false;
        continue;
        bool2 = bool1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterVerifyCodeActivity
 * JD-Core Version:    0.7.0.1
 */