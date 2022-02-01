package com.tencent.mobileqq.search.activity;

import acfp;
import acnk;
import acnl;
import acnm;
import acnn;
import amjm;
import amkb;
import amkf;
import amkx;
import amky;
import amkz;
import amla;
import amlb;
import amub;
import amxg;
import amxk;
import amxm;
import amxm.a;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.Secure;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.a;
import com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import pb.unite.search.DynamicTabSearch.SubHotWord;

public class ActiveEntitySearchActivity
  extends FragmentActivity
  implements amkb, amkf, amxm.a, TextWatcher, TextView.OnEditorActionListener, AssociateSearchWordsFragment.a
{
  public static boolean cDe = true;
  public static boolean cDf;
  public Button C;
  protected ImageView Dt;
  View GR;
  protected acnk a;
  protected ActiveEntitySearchFragment a;
  public AssociateSearchWordsFragment a;
  protected HotWordsForSubBussFragment a;
  public ImageButton as;
  public long[] as;
  acnl jdField_b_of_type_Acnl = new amlb(this);
  protected acnm b;
  acnn jdField_b_of_type_Acnn = new amla(this);
  public QuickPinyinEditText b;
  public String caI;
  private int dCA = -1;
  private int dCB = -1;
  public int dCC = 1;
  public int dCz;
  private int fromType;
  public String keyword;
  protected FragmentManager mFragmentManager;
  amxm mSoftKeyboardStateHelper;
  private String name;
  
  private void Hp(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, "showFragment  fragment=" + paramInt);
        }
        if (paramInt != this.dCA)
        {
          boolean bool = isFinishing();
          if (!bool) {}
        }
        else
        {
          return;
        }
        this.dCA = paramInt;
        FragmentTransaction localFragmentTransaction = this.mFragmentManager.beginTransaction();
        switch (paramInt)
        {
        case 1: 
          this.dCB = this.dCA;
          if (this.mFragmentManager.findFragmentByTag("search_result") == null) {
            Se(paramInt);
          }
          localFragmentTransaction.show(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment);
          localFragmentTransaction.commitAllowingStateLoss();
          Sf(3);
          Sf(2);
          break;
        case 2: 
          if (this.mFragmentManager.findFragmentByTag("hot_words") != null) {
            break label166;
          }
        }
      }
      finally {}
      Se(paramInt);
      label166:
      localObject.show(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentHotWordsForSubBussFragment);
      localObject.commitAllowingStateLoss();
      Sf(3);
      Sf(1);
      amxk.b("sub_result", "exp_home", new String[] { "", amxk.c(this.jdField_as_of_type_ArrayOfLong), "", "" });
      continue;
      if (this.mFragmentManager.findFragmentByTag("associated_words") == null) {
        Se(paramInt);
      }
      localObject.show(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment);
      localObject.commitAllowingStateLoss();
      Sf(2);
      Sf(1);
    }
  }
  
  private void Sf(int paramInt)
  {
    FragmentTransaction localFragmentTransaction = this.mFragmentManager.beginTransaction();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.mFragmentManager.findFragmentByTag("hot_words") == null);
        localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentHotWordsForSubBussFragment);
        localFragmentTransaction.commitAllowingStateLoss();
        return;
      } while (this.mFragmentManager.findFragmentByTag("search_result") == null);
      localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment);
      localFragmentTransaction.commitAllowingStateLoss();
      return;
    } while (this.mFragmentManager.findFragmentByTag("associated_words") == null);
    localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment);
    localFragmentTransaction.commitAllowingStateLoss();
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.md(null);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, long[] paramArrayOfLong)
  {
    int j = 4;
    UniteSearchActivity localUniteSearchActivity;
    int i;
    if ((paramContext instanceof UniteSearchActivity))
    {
      localUniteSearchActivity = (UniteSearchActivity)paramContext;
      if (localUniteSearchActivity.IQ() == 1) {
        i = 3;
      }
    }
    for (;;)
    {
      a(paramContext, paramString1, paramString2, paramArrayOfLong, i);
      return;
      if (localUniteSearchActivity.IQ() == 3)
      {
        i = 6;
        continue;
        if ((paramContext instanceof PublicFragmentActivity))
        {
          i = 9;
        }
        else
        {
          i = j;
          if ((paramContext instanceof ActiveEntitySearchActivity))
          {
            i = j;
            if (((ActiveEntitySearchActivity)paramContext).dCz == 9) {
              i = 9;
            }
          }
        }
      }
      else
      {
        i = 4;
      }
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, long[] paramArrayOfLong, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, ActiveEntitySearchActivity.class);
    localIntent.putExtra("group_name_string", paramString2);
    localIntent.putExtra("keyword", paramString1);
    localIntent.putExtra("fromType", -1);
    localIntent.putExtra("group_mask_long_array", paramArrayOfLong);
    localIntent.putExtra("from_type_for_report", paramInt);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, long[] paramArrayOfLong, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, ActiveEntitySearchActivity.class);
    localIntent.putExtra("group_name_string", paramString);
    localIntent.putExtra("group_mask_long_array", paramArrayOfLong);
    localIntent.putExtra("fromType", paramInt);
    paramContext.startActivity(localIntent);
  }
  
  private void initView()
  {
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText = ((QuickPinyinEditText)super.findViewById(2131366542));
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getInputExtras(true).putInt("QUICK_SEARCH", 1);
    String str = (String)amjm.mR.get(amjm.a(this.jdField_as_of_type_ArrayOfLong));
    if (!TextUtils.isEmpty(str)) {
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(str);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setImeOptions(3);
      if (!TextUtils.isEmpty(this.keyword))
      {
        if (this.keyword.length() > 50) {
          this.keyword = this.keyword.substring(0, 50);
        }
        this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(this.keyword);
        this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(this.keyword.length());
        cDe = false;
      }
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(this);
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(50) });
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.dEb = 50;
      this.jdField_as_of_type_AndroidWidgetImageButton = ((ImageButton)super.findViewById(2131368696));
      this.jdField_as_of_type_AndroidWidgetImageButton.setOnClickListener(new amkx(this));
      this.jdField_as_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.C = ((Button)super.findViewById(2131363801));
      this.C.setVisibility(8);
      this.C.setText(2131721058);
      this.C.setOnClickListener(new amky(this));
      this.Dt = ((ImageView)super.findViewById(2131369671));
      this.Dt.setVisibility(0);
      this.Dt.setOnClickListener(new amkz(this));
      this.mSoftKeyboardStateHelper = new amxm(super.findViewById(2131377546));
      this.mSoftKeyboardStateHelper.a(this);
      return;
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(acfp.m(2131701994));
    }
  }
  
  public int IQ()
  {
    return 3;
  }
  
  protected void PK(String paramString)
  {
    if (this.jdField_b_of_type_Acnm != null)
    {
      this.jdField_b_of_type_Acnm.FI(paramString);
      return;
    }
    if (this.jdField_a_of_type_Acnk != null)
    {
      this.jdField_a_of_type_Acnk.FI(paramString);
      return;
    }
    QLog.e("Q.uniteSearch.ActiveEntitySearchActivity", 2, "handler unll");
  }
  
  public void PL(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.keyword = paramString;
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(paramString);
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, "onHotWordClick keyword=" + this.keyword);
      }
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(paramString.length());
      Pn(false);
      this.dCz = 1;
      aPD();
    }
  }
  
  public void PM(String paramString) {}
  
  public void PN(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(paramString);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(acfp.m(2131701997));
  }
  
  public void Pn(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.clearFocus();
    }
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWindowToken(), 0);
  }
  
  void Se(int paramInt)
  {
    FragmentTransaction localFragmentTransaction = this.mFragmentManager.beginTransaction();
    switch (paramInt)
    {
    default: 
    case 2: 
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentHotWordsForSubBussFragment != null);
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentHotWordsForSubBussFragment = new HotWordsForSubBussFragment();
      Bundle localBundle = new Bundle();
      localBundle.putLongArray("group_masks", this.jdField_as_of_type_ArrayOfLong);
      localBundle.putInt("fromType", this.fromType);
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentHotWordsForSubBussFragment.setArguments(localBundle);
      localFragmentTransaction.add(2131377814, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentHotWordsForSubBussFragment, "hot_words");
      localFragmentTransaction.commitAllowingStateLoss();
      return;
    case 1: 
      if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment == null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment = a();
      }
      localFragmentTransaction.add(2131377814, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment, "search_result");
      localFragmentTransaction.commitAllowingStateLoss();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment == null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment = new AssociateSearchWordsFragment();
    }
    localFragmentTransaction.add(2131377814, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment, "associated_words");
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  protected ActiveEntitySearchFragment a()
  {
    return ActiveEntitySearchFragment.a(this.fromType, this.jdField_as_of_type_ArrayOfLong, this.name, this.keyword);
  }
  
  public void a(DynamicTabSearch.SubHotWord paramSubHotWord)
  {
    paramSubHotWord = paramSubHotWord.search_word.get().toStringUtf8();
    if (!TextUtils.isEmpty(paramSubHotWord))
    {
      this.keyword = paramSubHotWord;
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(paramSubHotWord);
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, "onSubHotWordItemClick keyword=" + this.keyword);
      }
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(paramSubHotWord.length());
      Pn(false);
      this.dCz = 8;
      this.dCC = 2;
      aPD();
    }
  }
  
  public void aPD()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment == null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment = a();
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment.dOl();
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment.fp = null;
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment.Id(this.keyword);
    Hp(1);
    this.caI = this.keyword;
    this.C.setVisibility(8);
    this.jdField_as_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(false);
    amxg.b(this.dCz, this.jdField_as_of_type_ArrayOfLong, this.name, this.keyword);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString();
    if (this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.awp())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, "正在输入拼音，不触发文本变动逻辑。 keyword=" + paramEditable);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, "afterTextChanged keyword=" + paramEditable);
    }
    paramEditable = paramEditable.trim();
    this.keyword = paramEditable;
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment.keyword = paramEditable;
    if (TextUtils.isEmpty(paramEditable))
    {
      Hp(2);
      this.jdField_as_of_type_AndroidWidgetImageButton.setVisibility(8);
      return;
    }
    this.jdField_as_of_type_AndroidWidgetImageButton.setVisibility(0);
    Hp(3);
    PK(paramEditable);
  }
  
  public boolean avZ()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText == null) {
      return false;
    }
    return this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.awp();
  }
  
  public boolean awa()
  {
    return false;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public Fragment c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment;
  }
  
  protected void dOd()
  {
    if (this.fromType == 10)
    {
      this.jdField_b_of_type_Acnm = ((acnm)this.app.getBusinessHandler(111));
      addObserver(this.jdField_b_of_type_Acnn);
      this.jdField_a_of_type_Acnk = null;
      return;
    }
    this.jdField_a_of_type_Acnk = ((acnk)this.app.getBusinessHandler(152));
    addObserver(this.jdField_b_of_type_Acnl);
    this.jdField_b_of_type_Acnm = null;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if ((Build.MANUFACTURER.equalsIgnoreCase("huawei")) && (Settings.Secure.getInt(getContentResolver(), "display_notch_status", 0) == 1)) {
      this.mActNeedImmersive = false;
    }
    super.doOnCreate(paramBundle);
    QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 1, "doOnCreate start");
    super.setContentView(2131561779);
    View localView = super.findViewById(2131377546);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      localView.setFitsSystemWindows(true);
    }
    this.GR = findViewById(2131377814);
    this.fromType = getIntent().getIntExtra("fromType", -1);
    this.jdField_as_of_type_ArrayOfLong = getIntent().getLongArrayExtra("group_mask_long_array");
    this.dCz = getIntent().getIntExtra("from_type_for_report", 4);
    this.name = getIntent().getStringExtra("group_name_string");
    this.keyword = getIntent().getStringExtra("keyword");
    initView();
    dOd();
    this.mFragmentManager = super.getSupportFragmentManager();
    if (paramBundle != null)
    {
      if (this.mFragmentManager.findFragmentByTag("search_result") != null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment = ((ActiveEntitySearchFragment)this.mFragmentManager.findFragmentByTag("search_result"));
      }
      if (this.mFragmentManager.findFragmentByTag("associated_words") != null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment = ((AssociateSearchWordsFragment)this.mFragmentManager.findFragmentByTag("associated_words"));
      }
      if (this.mFragmentManager.findFragmentByTag("hot_words") != null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentHotWordsForSubBussFragment = ((HotWordsForSubBussFragment)this.mFragmentManager.findFragmentByTag("hot_words"));
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment == null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment = a();
    }
    if (!TextUtils.isEmpty(this.keyword)) {
      aPD();
    }
    for (;;)
    {
      QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 1, "doOnCreate end");
      return true;
      Hp(2);
      new Handler(getMainLooper()).postDelayed(new ActiveEntitySearchActivity.1(this), 500L);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver();
    QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 1, "doOnDestroy");
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    amxg.dOA();
    QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 1, "doOnPause");
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    amxg.a(this.dCz, this.jdField_as_of_type_ArrayOfLong, this.name, this.keyword);
    QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 1, "doOnResume");
  }
  
  public void fM(String paramString, int paramInt)
  {
    amxk.b("sub_result", "clk_auto", new String[] { vo(), amxk.c(this.jdField_as_of_type_ArrayOfLong), paramString, "" + paramInt });
    if (!TextUtils.isEmpty(paramString))
    {
      this.keyword = paramString;
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(paramString);
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, "onAssociateWordClick keyword=" + this.keyword);
      }
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(paramString.length());
      Pn(false);
      this.dCz = 2;
      aPD();
    }
    amub.a(null, new ReportModelDC02528().module("subweb_search").action("clk_thinkword_list").obj1(amxk.c(this.jdField_as_of_type_ArrayOfLong)).ver1(vo()).ver4(paramString).ver7("{experiment_id:" + amub.cce + "}"));
  }
  
  public void gR()
  {
    Pn(true);
  }
  
  public double getLat()
  {
    return UniteSearchActivity.latitude;
  }
  
  public long[] m()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment.jdField_as_of_type_ArrayOfLong;
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 3) || ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)))
    {
      this.keyword = this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString().trim();
      if (!TextUtils.isEmpty(this.keyword))
      {
        this.dCz = 5;
        this.dCC = 3;
        aPD();
      }
      gR();
      return true;
    }
    return false;
  }
  
  public void onSoftKeyboardClosed()
  {
    if (this.dCA == 3) {
      return;
    }
    this.C.setVisibility(8);
    this.jdField_as_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(false);
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    if ((!cDe) || (!isResume()) || (this.dCA == 3)) {
      return;
    }
    this.C.setVisibility(0);
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(true);
    String str = this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString().trim();
    this.keyword = str;
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment.keyword = str;
    if (TextUtils.isEmpty(str))
    {
      Hp(2);
      this.jdField_as_of_type_AndroidWidgetImageButton.setVisibility(8);
      return;
    }
    this.jdField_as_of_type_AndroidWidgetImageButton.setVisibility(0);
    Hp(3);
    PK(str);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramCharSequence = this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString();
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, "onTextChanged keyword=" + paramCharSequence + " activity keyword=" + this.keyword);
    }
  }
  
  protected void removeObserver()
  {
    if (this.fromType == 10)
    {
      removeObserver(this.jdField_b_of_type_Acnn);
      return;
    }
    removeObserver(this.jdField_b_of_type_Acnl);
  }
  
  public String vo()
  {
    return this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString();
  }
  
  public double z()
  {
    return UniteSearchActivity.longitude;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity
 * JD-Core Version:    0.7.0.1
 */