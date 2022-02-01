package com.tencent.mobileqq.activity;

import acfp;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import anot;
import aqiw;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import cooperation.troop.TroopBaseProxyActivity;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import vnx;
import vny;
import vnz;
import voa;
import wja;

public class QQIdentiferLegacy
  extends ReportV4Fragment
  implements Handler.Callback, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static boolean aZr;
  public Dialog X;
  private FaceDetectForThirdPartyManager.AppConf a;
  private AtomicInteger aA = new AtomicInteger(0);
  private boolean aZs;
  private IphoneTitleBarActivity b;
  public MqqHandler b;
  private AtomicBoolean bD = new AtomicBoolean(false);
  private int baS;
  public Button dp;
  private int mAppId;
  public CheckBox mCheckBox;
  private BroadcastReceiver mReceiver = new vny(this);
  private String method;
  
  public QQIdentiferLegacy()
  {
    this.jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  }
  
  private void F(String paramString1, String paramString2)
  {
    if ("setFaceData".equals(this.method)) {
      anot.a(null, "dc00898", "", "", paramString1, paramString1, 0, 0, "", "", "", "");
    }
    while (!"loginVerify".equals(this.method)) {
      return;
    }
    anot.c(null, "dc00898", "", "", paramString2, paramString2, 0, 0, "", "", "", "");
  }
  
  private void aS(String paramString, boolean paramBoolean)
  {
    int i = this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getIntExtra("srcAppId", 0);
    String str1 = this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getStringExtra("key");
    String str2 = this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getStringExtra("method");
    String str3 = this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getStringExtra("uin");
    long l = this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getLongExtra("nonce", -1L);
    if (i != 0)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("srcAppId", i);
      localBundle.putString("key", str1);
      localBundle.putString("lightInfo", paramString);
      localBundle.putString("method", str2);
      localBundle.putString("uin", str3);
      localBundle.putLong("nonce", l);
      this.bD.set(true);
      QLog.d("QQIdentiferLegacy", 1, "sendPacket start");
      QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_app_conf", localBundle, new voa(this, paramBoolean));
    }
  }
  
  private void bSW()
  {
    if (!aqiw.isNetSupport(getActivity()))
    {
      QQToast.a(getActivity(), getString(2131693404), 0).show(this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getTitleBarHeight());
      return;
    }
    if (this.bD.compareAndSet(true, true))
    {
      QLog.e("QQIdentiferLegacy", 1, "onClick is loading");
      QQToast.a(this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, acfp.m(2131711784), 1).show(this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getTitleBarHeight());
      return;
    }
    if ((this.aZs) || (this.a == null) || (this.a.ret == 15))
    {
      xO(true);
      if (this.aZs)
      {
        QLog.e("QQIdentiferLegacy", 1, "onClick is light error");
        return;
      }
      if (this.a == null)
      {
        QLog.e("QQIdentiferLegacy", 1, "onClick mAppConf == null");
        return;
      }
      if (this.a.ret == 15)
      {
        QLog.e("QQIdentiferLegacy", 1, "onClick appconf.ret is 15, light error");
        return;
      }
    }
    bSX();
  }
  
  private void bSX()
  {
    if (("setFaceData".equals(this.method)) || ("deleteFace".equals(this.method)))
    {
      QLog.d("QQIdentiferLegacy", 1, "method is METHOD_SETTING_FACE_DATA, nextPage is QQIdentiferActivity");
      localIntent1 = getActivity().getIntent();
      Intent localIntent2 = new Intent(this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQIdentiferActivity.class);
      localIntent2.putExtra("platformAppId", this.mAppId);
      localIntent2.putExtra("srcAppId", this.mAppId);
      localIntent2.putExtra("srcOpenId", localIntent1.getStringExtra("srcOpenId"));
      localIntent2.putExtra("key", localIntent1.getStringExtra("key"));
      localIntent2.putExtra("method", this.method);
      localIntent2.putExtra("serviceType", localIntent1.getIntExtra("serviceType", -1));
      localIntent2.putExtra("FaceRecognition.AppConf", this.a);
      localIntent2.putExtra("key_identification_type", this.a.mode);
      startActivityForResult(localIntent2, 22);
      return;
    }
    QLog.d("QQIdentiferLegacy", 1, new Object[] { "set result ok, method is ", this.method });
    Intent localIntent1 = new Intent();
    localIntent1.putExtra("FaceRecognition.AppConf", this.a);
    this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.setResult(-1, localIntent1);
    this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.finish();
  }
  
  private void bSY()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity == null)
    {
      QLog.e("QQIdentiferLegacy", 1, "dealAppconfResult error : activity is null");
      return;
    }
    if (this.aZs)
    {
      F("0X800A85A", "0X800A85B");
      vZ(getString(2131693361));
      return;
    }
    if (this.a == null)
    {
      vZ(acfp.m(2131711788));
      return;
    }
    if (this.a.ret == 15)
    {
      F("0X800A85A", "0X800A85B");
      vZ(getString(2131693361));
      return;
    }
    bSX();
  }
  
  private CharSequence d(int paramInt)
  {
    Object localObject = getString(paramInt);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    if (Build.VERSION.SDK_INT >= 24) {}
    SpannableStringBuilder localSpannableStringBuilder;
    URLSpan[] arrayOfURLSpan;
    int j;
    int k;
    int m;
    for (localObject = Html.fromHtml((String)localObject, 0);; localObject = Html.fromHtml((String)localObject))
    {
      localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject);
      arrayOfURLSpan = (URLSpan[])localSpannableStringBuilder.getSpans(0, ((Spanned)localObject).length(), URLSpan.class);
      i = arrayOfURLSpan.length;
      paramInt = 0;
      while (paramInt < i)
      {
        URLSpan localURLSpan = arrayOfURLSpan[paramInt];
        j = localSpannableStringBuilder.getSpanStart(localURLSpan);
        k = localSpannableStringBuilder.getSpanEnd(localURLSpan);
        m = localSpannableStringBuilder.getSpanFlags(localURLSpan);
        QQIdentiferLegacy.3 local3 = new QQIdentiferLegacy.3(this, localURLSpan.getURL());
        localSpannableStringBuilder.removeSpan(localURLSpan);
        localSpannableStringBuilder.setSpan(local3, j, k, m);
        paramInt += 1;
      }
    }
    localObject = (ForegroundColorSpan[])localSpannableStringBuilder.getSpans(0, ((Spanned)localObject).length(), ForegroundColorSpan.class);
    int i = localObject.length;
    paramInt = 0;
    while (paramInt < i)
    {
      arrayOfURLSpan = localObject[paramInt];
      j = localSpannableStringBuilder.getSpanStart(arrayOfURLSpan);
      k = localSpannableStringBuilder.getSpanEnd(arrayOfURLSpan);
      m = localSpannableStringBuilder.getSpanFlags(arrayOfURLSpan);
      localSpannableStringBuilder.removeSpan(arrayOfURLSpan);
      localSpannableStringBuilder.setSpan(arrayOfURLSpan, j, k, m);
      paramInt += 1;
    }
    return localSpannableStringBuilder;
  }
  
  private void vZ(String paramString)
  {
    ThreadManager.getUIHandler().post(new QQIdentiferLegacy.2(this, paramString));
  }
  
  private void xO(boolean paramBoolean)
  {
    this.aZs = false;
    this.a = null;
    this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
    YTAGReflectLiveCheckInterface.getLiveCheckType(getActivity().getApplicationContext(), new vnz(this, paramBoolean));
  }
  
  public void bSZ()
  {
    if (this.X != null) {
      this.X.cancel();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      showLoadingView();
      return true;
    }
    if ((paramMessage.arg1 == 24) && (paramMessage.obj != null) && ((paramMessage.obj instanceof String))) {
      aS((String)paramMessage.obj, false);
    }
    bSZ();
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 22)
    {
      QLog.d("QQIdentiferLegacy", 1, "onActivity requestCode == AuthDevActivity.REQ_IDENTIFICATION, resultCode is : " + paramInt2);
      if ((paramInt2 == -1) && (this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity != null))
      {
        this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.setResult(paramInt2, paramIntent);
        this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.finish();
      }
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity = ((IphoneTitleBarActivity)paramActivity);
    xO(false);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    aZr = paramBoolean;
    this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131372348).setEnabled(paramBoolean);
    if (paramBoolean) {
      F("0X800A858", "0X800A859");
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    int i;
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    case 2131372348: 
      if (Build.VERSION.SDK_INT >= 23) {
        if (this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.checkSelfPermission("android.permission.CAMERA") == 0) {
          i = 1;
        }
      }
      break;
    }
    for (;;)
    {
      label71:
      if (i == 0) {
        this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.requestPermissions(new vnx(this), 1, new String[] { "android.permission.CAMERA" });
      }
      for (;;)
      {
        if (!"loginVerify".equals(this.method)) {
          break label154;
        }
        anot.a(null, "dc00898", "", "", "0X800A319", "0X800A319", 0, 0, "", "", "", "");
        break;
        i = 0;
        break label71;
        bSW();
      }
      label154:
      if (!"setFaceData".equals(this.method)) {
        break;
      }
      anot.a(null, "dc00898", "", "", "0X800A31E", "0X800A31E", 0, 0, "", "", "", "");
      break;
      CheckBox localCheckBox = this.mCheckBox;
      if (!this.mCheckBox.isChecked()) {}
      for (;;)
      {
        localCheckBox.setChecked(bool);
        break;
        bool = false;
      }
      i = 1;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2131561383, paramViewGroup, false);
    this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.setTitle(acfp.m(2131711764));
    this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.setLeftViewName(2131690700);
    this.method = this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getStringExtra("method");
    this.mAppId = this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getIntExtra("srcAppId", 0);
    paramViewGroup = this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getStringExtra("name");
    if ((TextUtils.isEmpty(this.method)) && (paramBundle != null))
    {
      this.method = paramBundle.getString("method");
      QLog.d("QQIdentiferLegacy", 1, new Object[] { "saveInstanceState is not null, method is ", this.method });
    }
    if ("setFaceData".equalsIgnoreCase(this.method))
    {
      paramLayoutInflater = getString(2131701216);
      ((TextView)localView.findViewById(2131379424)).setText(paramLayoutInflater);
      this.mCheckBox = ((CheckBox)localView.findViewById(2131364572));
      paramLayoutInflater = (TextView)localView.findViewById(2131379425);
      paramLayoutInflater.setMovementMethod(LinkMovementMethod.getInstance());
      if (!"setFaceData".equals(this.method)) {
        break label498;
      }
      paramLayoutInflater.setText(d(2131701873));
      label220:
      this.mCheckBox.setOnCheckedChangeListener(this);
      this.dp = ((Button)localView.findViewById(2131372348));
      this.dp.setOnClickListener(this);
      localView.findViewById(2131379425).setOnClickListener(this);
      localView.findViewById(2131364576).setOnClickListener(this);
      int i = this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getIntExtra("serviceType", -1);
      anot.a(null, "dc00898", "", "", "0X80097E9", "0X80097E9", 0, 0, i + "", "", this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getIntExtra("srcAppId", 0) + "", "");
      if (this.baS == 0)
      {
        paramLayoutInflater = new IntentFilter();
        paramLayoutInflater.addAction("tencent.av.v2q.StartVideoChat");
        paramLayoutInflater.addAction("tencent.av.v2q.AvSwitch");
        paramLayoutInflater.addAction("mqq.intent.action.ACCOUNT_KICKED");
        this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.registerReceiver(this.mReceiver, paramLayoutInflater);
        this.baS = 1;
      }
      if (!"loginVerify".equals(this.method)) {
        break label512;
      }
      anot.a(null, "dc00898", "", "", "0X800A318", "0X800A318", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, localView);
      return localView;
      paramBundle = getString(2131701871);
      paramLayoutInflater = paramViewGroup;
      if (paramViewGroup == null) {
        paramLayoutInflater = "";
      }
      paramLayoutInflater = String.format(paramBundle, new Object[] { paramLayoutInflater });
      break;
      label498:
      paramLayoutInflater.setText(d(2131701872));
      break label220;
      label512:
      if ("setFaceData".equals(this.method)) {
        anot.a(null, "dc00898", "", "", "0X800A31D", "0X800A31D", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.baS == 1)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.unregisterReceiver(this.mReceiver);
      this.baS = 0;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    QLog.d("QQIdentiferLegacy", 1, "onSaveInstanceState");
    paramBundle.putString("method", this.method);
  }
  
  public void showLoadingView()
  {
    if (this.X == null)
    {
      this.X = TroopBaseProxyActivity.a(getActivity());
      this.X.findViewById(2131372861).getLayoutParams().width = -2;
      TextView localTextView = (TextView)this.X.findViewById(2131373180);
      localTextView.setSingleLine();
      wja.dp2px(15.0F, getResources());
      localTextView.setPadding(15, 0, 15, 0);
      localTextView.setText(acfp.m(2131711782));
    }
    this.X.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferLegacy
 * JD-Core Version:    0.7.0.1
 */