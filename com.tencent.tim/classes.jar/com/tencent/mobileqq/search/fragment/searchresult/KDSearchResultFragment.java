package com.tencent.mobileqq.search.fragment.searchresult;

import amnj;
import amnk;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import aqyx;
import arju;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import kee;
import mqq.app.AppRuntime;
import rom;

public class KDSearchResultFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private ImageButton G;
  private amnk jdField_a_of_type_Amnk;
  private arju jdField_a_of_type_Arju;
  public WebViewProgressBar a;
  private TouchWebView c;
  private QuickPinyinEditText d;
  private Button mCancelBtn;
  private String mKeyword;
  private String mUrl;
  
  public static Intent a(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("magic_code", 15453);
    localIntent.putExtra("url", paramString2);
    localIntent.putExtra("keyword", paramString1);
    localIntent.setClass(paramContext, PublicFragmentActivityForTool.class);
    localIntent.putExtra("public_fragment_class", KDSearchResultFragment.class.getName());
    return localIntent;
  }
  
  private void bindData()
  {
    this.c.loadUrl(this.mUrl);
    this.d.setText(this.mKeyword);
  }
  
  private void cL(View paramView)
  {
    try
    {
      paramView.setBackgroundResource(2130838901);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("KDSearchResultFragment", 1, "doOnCreate, e = " + QLog.getStackTraceString(localException));
      try
      {
        paramView.setBackgroundResource(2130851023);
        return;
      }
      catch (Error paramView)
      {
        QLog.e("KDSearchResultFragment", 1, "doOnCreate, e = " + QLog.getStackTraceString(paramView));
      }
    }
  }
  
  private void initEditText()
  {
    this.d.setFocusable(false);
    this.d.setOnClickListener(this);
    this.d.setImeOptions(3);
    this.d.getInputExtras(true).putInt("QUICK_SEARCH", 1);
    this.G.setOnClickListener(this);
    this.G.setVisibility(0);
    this.mCancelBtn.setVisibility(0);
    this.mCancelBtn.setText(2131721058);
    this.mCancelBtn.setOnClickListener(this);
  }
  
  private void initWebView()
  {
    this.jdField_a_of_type_Arju = new arju();
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setController(this.jdField_a_of_type_Arju);
    this.jdField_a_of_type_Arju.a(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar);
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setVisibility(8);
    this.jdField_a_of_type_Amnk = new amnj(this, getActivity(), getActivity(), getAppInterface(), this.c);
    this.jdField_a_of_type_Amnk.setmTimeBeforeLoadUrl(System.currentTimeMillis());
    new aqyx(this.jdField_a_of_type_Amnk).a(null, kee.getAppInterface(), null);
    this.c.setWillNotCacheDrawing(false);
    this.c.setDrawingCacheEnabled(true);
  }
  
  public AppInterface getAppInterface()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof ToolAppRuntime))
      {
        localObject = ((AppRuntime)localObject).getAppRuntime("modular_web");
        if (!(localObject instanceof AppInterface)) {
          break label53;
        }
        return (AppInterface)localObject;
      }
      if ((localObject instanceof QQAppInterface)) {
        return (QQAppInterface)localObject;
      }
    }
    return null;
    label53:
    return null;
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
      UniteSearchActivity.p(getActivity(), "", 26);
      getActivity().finish();
      continue;
      ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.d.getWindowToken(), 0);
      getActivity().finish();
      continue;
      UniteSearchActivity.p(getActivity(), this.mKeyword, 26);
      getActivity().finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    super.onCreate(paramBundle);
    paramBundle = getActivity().getIntent();
    int i = paramBundle.getIntExtra("magic_code", 0);
    if (i == 15453) {
      bool = true;
    }
    rom.assertTrue(bool, "you must use the function:CheckArithHWResultFragment.open() to open this page!!!! :" + i);
    this.mUrl = paramBundle.getStringExtra("url");
    this.mKeyword = paramBundle.getStringExtra("keyword");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561655, paramViewGroup, false);
    paramViewGroup = paramLayoutInflater.findViewById(2131377546);
    this.c = ((TouchWebView)paramLayoutInflater.findViewById(2131382134));
    this.d = ((QuickPinyinEditText)paramLayoutInflater.findViewById(2131366542));
    this.G = ((ImageButton)paramLayoutInflater.findViewById(2131368696));
    this.mCancelBtn = ((Button)paramLayoutInflater.findViewById(2131363801));
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar = ((WebViewProgressBar)paramLayoutInflater.findViewById(2131372947));
    paramBundle = paramLayoutInflater.findViewById(2131381922);
    paramBundle.setBackgroundColor(1996488704);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
      paramBundle.setVisibility(0);
    }
    for (;;)
    {
      this.c.setVisibility(0);
      cL(paramViewGroup);
      initEditText();
      initWebView();
      bindData();
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        getActivity().getWindow().addFlags(67108864);
        int i = getResources().getColor(2131167361);
        paramBundle = new SystemBarCompact(getActivity(), true, i);
        paramBundle.setStatusDrawable(getResources().getDrawable(2130847060));
        paramBundle.init();
        paramViewGroup.setFitsSystemWindows(true);
        paramViewGroup.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
        ImmersiveUtils.clearCoverForStatus(getActivity().getWindow(), true);
      }
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      paramBundle.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Amnk != null) {
      this.jdField_a_of_type_Amnk.onDestroy();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Amnk != null) {
      this.jdField_a_of_type_Amnk.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Amnk != null) {
      this.jdField_a_of_type_Amnk.onResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchresult.KDSearchResultFragment
 * JD-Core Version:    0.7.0.1
 */