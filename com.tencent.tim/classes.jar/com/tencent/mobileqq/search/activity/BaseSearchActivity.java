package com.tencent.mobileqq.search.activity;

import acfp;
import amld;
import amle;
import amlf;
import amxj;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import anot;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public abstract class BaseSearchActivity
  extends FragmentActivity
  implements TextWatcher, TextView.OnEditorActionListener
{
  public static int dCE = -1;
  protected Button C;
  protected ImageView Dt;
  protected CancelReceiver a;
  protected ImageButton as;
  protected BaseSearchFragment b;
  public QuickPinyinEditText b;
  protected boolean cDg;
  public boolean cDh;
  public String caJ;
  public String caK;
  public String caL;
  public int dCD;
  public int dCF;
  
  private void initView()
  {
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText = ((QuickPinyinEditText)super.findViewById(2131366542));
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(vm());
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setImeOptions(3);
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(this);
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
    if ("1".equals(DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.search_input_type.name(), "0"))) {
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setInputType(524321);
    }
    for (;;)
    {
      if (this.cDg) {
        this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getInputExtras(true).putInt("QUICK_SEARCH", 1);
      }
      this.as = ((ImageButton)super.findViewById(2131368696));
      this.as.setOnClickListener(new amld(this));
      this.C = ((Button)super.findViewById(2131363801));
      this.C.setVisibility(0);
      this.C.setText(2131721058);
      this.C.setOnClickListener(new amle(this));
      this.Dt = ((ImageView)super.findViewById(2131369671));
      this.Dt.setVisibility(0);
      this.Dt.setOnClickListener(new amlf(this));
      return;
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setInputType(524289);
    }
  }
  
  protected void Iq(String paramString)
  {
    if ((this.caJ != null) && (this.caJ.equals(paramString))) {
      return;
    }
    this.caJ = paramString;
    this.jdField_b_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment.Id(paramString);
  }
  
  protected abstract BaseSearchFragment a();
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString();
    if (TextUtils.isEmpty(paramEditable)) {
      this.as.setVisibility(8);
    }
    for (;;)
    {
      paramEditable = paramEditable.trim();
      if (!paramEditable.equals(this.caJ)) {
        amxk.ako = 0L;
      }
      Iq(paramEditable);
      return;
      this.as.setVisibility(0);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void diu()
  {
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "cancelType-3 ResultModule:" + amxj.zq());
    }
    anot.a(null, "CliOper", "", "", "0X8005E13", "0X8005E13", 0, 0, "3", "", amxj.zq(), "");
    a(this, new Intent("com.tencent.mobileqq.search.cancel"));
    dCE = 0;
    finish();
  }
  
  @TargetApi(14)
  public boolean doOnCreate(Bundle paramBundle)
  {
    dCE = -1;
    super.doOnCreate(paramBundle);
    super.setContentView(getLayoutId());
    paramBundle = super.findViewById(2131377546);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      paramBundle.setFitsSystemWindows(true);
    }
    this.dCD = super.getIntent().getIntExtra("extra_key_fts_type", 0);
    initView();
    this.caJ = super.getIntent().getStringExtra("keyword");
    paramBundle = super.getSupportFragmentManager();
    this.jdField_b_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment = a();
    paramBundle = paramBundle.beginTransaction();
    paramBundle.replace(2131377814, this.jdField_b_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment);
    paramBundle.commit();
    if (!TextUtils.isEmpty(this.caJ))
    {
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(this.caJ);
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(this.caJ.length());
      this.jdField_b_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment.Id(this.caJ);
      gR();
    }
    this.a = new CancelReceiver();
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.search.cancel");
    super.registerReceiver(this.a, paramBundle);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      if (this.a != null)
      {
        super.unregisterReceiver(this.a);
        this.a = null;
      }
      try
      {
        this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFocusable(false);
        this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFocusableInTouchMode(false);
        this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setVisibility(8);
        if (this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getParent() != null) {
          ((ViewGroup)this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getParent()).removeView(this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText);
        }
        this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
        this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(null);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
      catch (Error localError)
      {
        for (;;)
        {
          localError.printStackTrace();
        }
      }
      amxk.cm = null;
      dCE = -1;
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localException1.printStackTrace();
      }
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    aqoe.a.cUV = false;
  }
  
  protected void gR()
  {
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.clearFocus();
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWindowToken(), 0);
  }
  
  protected int getLayoutId()
  {
    return 2131561652;
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 3) || ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)))
    {
      paramTextView = this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString().trim();
      if (!TextUtils.isEmpty(paramTextView)) {
        Iq(paramTextView);
      }
      gR();
      return true;
    }
    return false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected String vm()
  {
    return acfp.m(2131703153);
  }
  
  public class CancelReceiver
    extends BroadcastReceiver
  {
    public CancelReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("com.tencent.mobileqq.search.cancel".equals(paramIntent.getAction())) {
        BaseSearchActivity.this.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.BaseSearchActivity
 * JD-Core Version:    0.7.0.1
 */