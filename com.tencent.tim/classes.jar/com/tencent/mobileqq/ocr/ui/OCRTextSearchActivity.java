package com.tencent.mobileqq.ocr.ui;

import aklr;
import aklt;
import akod;
import akoe;
import akof;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anot;
import aqcl;
import aqfp;
import aqho;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

public class OCRTextSearchActivity
  extends FragmentActivity
  implements View.OnClickListener
{
  View Ai;
  ImageButton G;
  public EditText I;
  private int RV = 0;
  public BaseOCRTextSearchFragment.a a;
  public a a;
  private b a;
  public SearchResultFragment a;
  String bUc;
  RelativeLayout cQ;
  LinearLayout ch;
  aklt d;
  public InputMethodManager d;
  ImageView dr;
  FragmentManager mFragmentManager;
  View mMaskView;
  RelativeLayout mRoot;
  String mSearchKeyWord;
  public String mSessionId;
  
  public OCRTextSearchActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment = null;
    this.jdField_d_of_type_Aklt = new akod(this);
    this.jdField_d_of_type_AndroidViewInputmethodInputMethodManager = null;
    this.jdField_a_of_type_ComTencentMobileqqOcrUiOCRTextSearchActivity$b = new b(null);
    this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment$a = new akof(this);
  }
  
  private void dCp()
  {
    if (this.I.getText() != null) {}
    for (String str1 = this.I.getText().toString();; str1 = "")
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1)) {
        str2 = this.I.getHint().toString();
      }
      str1 = str2.trim();
      if (!TextUtils.isEmpty(str1)) {
        break;
      }
      return;
    }
    this.bUc = null;
    fU(str1);
    bx(true);
    anot.a(null, "dc00898", "", "", "0X80082EE", "0X80082EE", 0, 0, "", "", "", "");
  }
  
  public static void e(BaseActivity paramBaseActivity, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent(paramBaseActivity, OCRTextSearchActivity.class);
    localIntent.putExtra("keyWord", paramString);
    paramBaseActivity.startActivity(localIntent);
    paramBaseActivity.overridePendingTransition(0, 0);
    aqfp.Sz(false);
  }
  
  void Hp(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.Ai.setVisibility(0);
    if (this.mFragmentManager.findFragmentByTag("search_result") == null) {
      Se(paramInt);
    }
    FragmentTransaction localFragmentTransaction = this.mFragmentManager.beginTransaction();
    localFragmentTransaction.show(this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment);
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  public void NH(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.G.setVisibility(0);
    this.I.removeTextChangedListener(this.jdField_a_of_type_ComTencentMobileqqOcrUiOCRTextSearchActivity$b);
    this.I.setText(paramString);
    this.I.setSelection(this.I.getText().length());
    this.I.addTextChangedListener(this.jdField_a_of_type_ComTencentMobileqqOcrUiOCRTextSearchActivity$b);
  }
  
  protected void NI(String paramString)
  {
    if (paramString.equals(""))
    {
      this.G.setVisibility(8);
      return;
    }
    this.G.setVisibility(0);
  }
  
  public void Sd(int paramInt)
  {
    if (isFinishing()) {}
    do
    {
      return;
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        Sf(1);
        this.RV = 0;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment == null);
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment.reset();
    return;
    Hp(1);
    this.RV = 1;
  }
  
  public void Se(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment != null);
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment = new SearchResultFragment();
    FragmentTransaction localFragmentTransaction = this.mFragmentManager.beginTransaction();
    localFragmentTransaction.add(2131377207, this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment, "search_result");
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  void Sf(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.Ai.setVisibility(8);
    if (this.mFragmentManager.findFragmentByTag("search_result") == null) {
      Se(paramInt);
    }
    FragmentTransaction localFragmentTransaction = this.mFragmentManager.beginTransaction();
    localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment);
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  @TargetApi(14)
  protected void aDR()
  {
    this.mRoot = ((RelativeLayout)super.findViewById(2131377565));
    this.mRoot.setOnClickListener(this);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      this.mRoot.setFitsSystemWindows(true);
    }
    this.cQ = ((RelativeLayout)super.findViewById(2131377786));
    this.I = ((EditText)this.cQ.findViewById(2131366542));
    this.I.setHintTextColor(-1431918938);
    this.I.setEllipsize(TextUtils.TruncateAt.END);
    this.G = ((ImageButton)this.cQ.findViewById(2131368696));
    aqcl.b(this.I, getString(2131692173));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.G.getLayoutParams();
    localLayoutParams.width = ((int)aqho.convertDpToPixel(this, 22.0F));
    localLayoutParams.height = ((int)aqho.convertDpToPixel(this, 22.0F));
    this.G.setLayoutParams(localLayoutParams);
    ((Button)this.cQ.findViewById(2131363801)).setVisibility(8);
    this.dr = ((ImageView)this.cQ.findViewById(2131369671));
    this.dr.setVisibility(0);
    this.ch = ((LinearLayout)super.findViewById(2131377851));
    this.Ai = super.findViewById(2131377207);
    if (this.jdField_d_of_type_AndroidViewInputmethodInputMethodManager == null) {
      this.jdField_d_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)super.getSystemService("input_method"));
    }
    this.G.setOnClickListener(this);
    this.dr.setOnClickListener(this);
    this.I.setImeOptions(3);
    this.I.setSingleLine(true);
    this.I.setOnEditorActionListener(new akoe(this));
    this.I.setOnClickListener(this);
    this.mMaskView = findViewById(2131371159);
    if ("1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"))) {
      this.mMaskView.setVisibility(0);
    }
  }
  
  public void bx(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.I.clearFocus();
      this.I.setCursorVisible(false);
      Sd(0);
      this.ch.setVisibility(0);
      this.G.setEnabled(false);
      this.I.setEnabled(false);
      return;
    }
    this.ch.setVisibility(8);
    this.G.setEnabled(true);
    this.I.setEnabled(true);
  }
  
  public void doOnBackPressed()
  {
    finish();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_ComTencentMobileqqOcrUiOCRTextSearchActivity$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqOcrUiOCRTextSearchActivity$a.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.mFragmentManager = getSupportFragmentManager();
    setContentView(2131561520);
    aDR();
    Object localObject = getIntent();
    if (localObject == null) {
      finish();
    }
    do
    {
      return true;
      ix();
      Sd(this.RV);
      localObject = ((Intent)localObject).getStringExtra("keyWord");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        NH((String)localObject);
        fU((String)localObject);
        bx(true);
        this.RV = 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqOcrUiOCRTextSearchActivity$a = new a(this);
      this.jdField_a_of_type_ComTencentMobileqqOcrUiOCRTextSearchActivity$a.MW(false);
    } while (paramBundle == null);
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment = ((SearchResultFragment)this.mFragmentManager.findFragmentByTag("search_result"));
    return true;
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_d_of_type_Aklt);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getStringExtra("keyWord");
    if (!TextUtils.isEmpty(paramIntent))
    {
      NH(paramIntent);
      fU(paramIntent);
      bx(true);
      this.RV = 1;
    }
  }
  
  @TargetApi(9)
  public void doOnResume()
  {
    super.doOnResume();
    if (this.RV == 0)
    {
      super.getWindow().setSoftInputMode(36);
      this.I.setCursorVisible(true);
      return;
    }
    super.getWindow().setSoftInputMode(34);
    this.I.setCursorVisible(false);
  }
  
  public void doOnStart()
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrUiOCRTextSearchActivity$a.onStart();
  }
  
  public void fU(String paramString)
  {
    aklr localaklr = (aklr)this.app.getManager(228);
    this.mSessionId = aklr.y(this.app);
    localaklr.r(this.mSessionId, paramString, SystemClock.elapsedRealtime());
    this.mSearchKeyWord = paramString;
  }
  
  public void finish()
  {
    if (this.I != null) {
      this.jdField_d_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.I.getWindowToken(), 0);
    }
    setResult(-1);
    super.finish();
    overridePendingTransition(0, 2130772001);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  protected void ix()
  {
    this.I.addTextChangedListener(this.jdField_a_of_type_ComTencentMobileqqOcrUiOCRTextSearchActivity$b);
    this.app.addObserver(this.jdField_d_of_type_Aklt);
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
      this.I.setText("");
      this.I.setCursorVisible(true);
      this.jdField_d_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.I, 0);
      continue;
      this.jdField_d_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      this.I.clearFocus();
      this.I.setCursorVisible(false);
      continue;
      this.I.setCursorVisible(true);
      continue;
      finish();
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public static class a
    extends FlingGestureHandler
  {
    boolean ctm = true;
    
    public a(Activity paramActivity)
    {
      super();
    }
    
    public void MW(boolean paramBoolean)
    {
      this.ctm = paramBoolean;
      if (!Vj()) {
        coC();
      }
      this.mTopLayout.setInterceptTouchFlag(paramBoolean);
    }
    
    public void flingLToR()
    {
      if (this.ctm) {
        super.flingLToR();
      }
    }
  }
  
  class b
    implements TextWatcher
  {
    private b() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      paramEditable = OCRTextSearchActivity.this.I.getText().toString();
      OCRTextSearchActivity.this.NI(paramEditable);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity
 * JD-Core Version:    0.7.0.1
 */