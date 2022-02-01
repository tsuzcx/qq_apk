package com.tencent.biz.pubaccount.readinjoy.viola.view;

import aafx;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import muj;
import nxn;
import nxo;

public abstract class ViolaLazyFragment
  extends PublicBaseFragment
{
  private Boolean J = Boolean.valueOf(true);
  private NavBarCommon a;
  private String aoH = "status_bar_color_style";
  private boolean auG;
  private boolean avt;
  private boolean avu;
  private int bda = 0;
  private int bdb = -1;
  private View.OnClickListener cC = new nxn(this);
  private RelativeLayout fB;
  private ImageView le;
  private ImageView lf;
  private ViewGroup mContainer;
  private ViewGroup mContentView;
  private boolean mIsStart;
  private LayoutInflater mLayoutInflater;
  private View mRootView;
  private SystemBarCompact mSystemBarComp;
  private TextView tM;
  private TextView tN;
  private TextView tO;
  private TextView tP;
  
  private void a(NavBarCommon paramNavBarCommon)
  {
    this.tM = ((TextView)paramNavBarCommon.findViewById(2131369579));
    this.tM.setOnClickListener(this.cC);
    this.tN = ((TextView)paramNavBarCommon.findViewById(2131380514));
    this.le = ((ImageView)paramNavBarCommon.findViewById(2131369967));
    if ((this.tN != null) && (this.le != null))
    {
      this.tN.setOnClickListener(this.cC);
      this.le.setOnClickListener(this.cC);
    }
    this.tO = ((TextView)paramNavBarCommon.findViewById(2131369627));
    this.tP = ((TextView)paramNavBarCommon.findViewById(2131369612));
    this.lf = ((ImageView)paramNavBarCommon.findViewById(2131369594));
  }
  
  public static void j(Activity paramActivity, int paramInt)
  {
    if ((paramActivity != null) && (paramActivity.getWindow() != null)) {
      paramActivity.getWindow().setFlags(paramInt, paramInt);
    }
  }
  
  protected void B(ViewGroup paramViewGroup)
  {
    if ((getUserVisibleHint()) && (!this.avt))
    {
      this.avt = true;
      C(paramViewGroup);
      return;
    }
    aVa();
  }
  
  protected void C(ViewGroup paramViewGroup)
  {
    b(pw(), paramViewGroup);
    aGC();
    a(getArguments(), this.mContentView);
  }
  
  public void X(float paramFloat)
  {
    this.a.setAlpha(paramFloat);
  }
  
  public abstract void a(Bundle paramBundle, ViewGroup paramViewGroup);
  
  public void a(Boolean paramBoolean, boolean paramBoolean1)
  {
    FragmentActivity localFragmentActivity;
    if ((paramBoolean1) && (paramBoolean != this.J))
    {
      localFragmentActivity = getActivity();
      if (paramBoolean.booleanValue()) {
        break label37;
      }
    }
    label37:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      aafx.setStatusBarDarkIcon(localFragmentActivity, paramBoolean1);
      this.J = paramBoolean;
      return;
    }
  }
  
  public abstract void aF(Bundle paramBundle);
  
  public void aGC()
  {
    if (getActivity() == null) {
      return;
    }
    this.a = ((NavBarCommon)this.fB.findViewById(2131377361));
    a(this.a);
  }
  
  protected void aUV() {}
  
  protected void aUW()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (!this.J.booleanValue()) {}
    for (boolean bool = true;; bool = false)
    {
      aafx.setStatusBarDarkIcon(localFragmentActivity, bool);
      return;
    }
  }
  
  protected void aUX() {}
  
  protected void aUY() {}
  
  protected void aUZ() {}
  
  protected void aVa()
  {
    this.mRootView = this.mLayoutInflater.inflate(2131559121, this.mContainer, false);
    aF(getArguments());
  }
  
  public void aYe()
  {
    if (this.mSystemBarComp != null) {
      this.mSystemBarComp.setStatusBarVisible(2, 0);
    }
  }
  
  public void an(String paramString, boolean paramBoolean)
  {
    if (("status_bar_color_style".equals(this.aoH)) || (paramBoolean)) {
      this.aoH = paramString;
    }
  }
  
  public void b(int paramInt, ViewGroup paramViewGroup)
  {
    if ((getRootView() == null) || (getRootView().getParent() == null)) {
      this.mRootView = this.mLayoutInflater.inflate(2131559121, paramViewGroup, false);
    }
    try
    {
      this.fB = ((RelativeLayout)this.mRootView.findViewById(2131379881));
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.fB.setFitsSystemWindows(true);
        this.fB.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
      }
      paramViewGroup = (ViewGroup)this.mLayoutInflater.inflate(paramInt, (ViewGroup)this.mRootView, false);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(3, 2131377361);
      this.fB.addView(paramViewGroup, localLayoutParams);
      this.mContentView = paramViewGroup;
      return;
    }
    catch (Exception paramViewGroup)
    {
      QLog.e("ViolaLazyFragment", 1, paramViewGroup.getMessage());
    }
  }
  
  public void bcf()
  {
    if ((!this.avt) && (getRootView() != null))
    {
      this.avt = true;
      C(this.mContainer);
    }
  }
  
  public void bcg()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.auG = true;
      this.fB.setFitsSystemWindows(false);
      this.fB.setPadding(0, 0, 0, 0);
      if (getActivity().mSystemBarComp != null) {
        break label135;
      }
      getActivity().setImmersiveStatus(0);
    }
    for (;;)
    {
      if (this.fB.indexOfChild(this.a) != -1)
      {
        this.fB.removeView(this.a);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
        localLayoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(getActivity());
        this.a.setLayoutParams(localLayoutParams);
        this.fB.addView(this.a);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.mContentView.setLayoutParams(localLayoutParams);
      }
      return;
      label135:
      getActivity().mSystemBarComp.setStatusBarDrawable(null);
      getActivity().mSystemBarComp.setStatusBarColor(0);
      getActivity().mSystemBarComp.setStatusColor(0);
    }
  }
  
  public void bch()
  {
    if (this.mSystemBarComp != null) {
      this.mSystemBarComp.setStatusBarVisible(0, 0);
    }
  }
  
  public void bci()
  {
    if (((getActivity() instanceof BaseActivity)) && (getActivity().mSystemBarComp != null))
    {
      Window localWindow = getActivity().getWindow();
      if (localWindow != null) {
        localWindow.setFlags(1024, 1024);
      }
      this.mSystemBarComp = getActivity().mSystemBarComp;
      this.mSystemBarComp.init();
      aYe();
    }
  }
  
  public void bcj()
  {
    if (!this.auG) {
      oI("#ffffff");
    }
    oK("#ffffff");
    oM("#000000");
    oL("#000000");
    oO("drawable_black");
    oN("#000000");
  }
  
  public void bck()
  {
    if (this.bdb < 0) {
      this.bdb = getActivity().getWindow().getDecorView().getSystemUiVisibility();
    }
    muj.aM(getActivity());
  }
  
  public void bcl()
  {
    getActivity().getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new nxo(this));
    int i = getActivity().getWindow().getDecorView().getSystemUiVisibility();
    getActivity().getWindow().getDecorView().setSystemUiVisibility(i | 0x2 | 0x400);
  }
  
  public void bcm()
  {
    j(getActivity(), 1024);
  }
  
  public void d(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.tM.setVisibility(0);
    this.tM.setText(paramString);
    this.tM.setEnabled(true);
    if (paramOnClickListener != null) {
      this.tM.setOnClickListener(paramOnClickListener);
    }
  }
  
  public abstract void doOnBackPressed();
  
  public View getRootView()
  {
    return this.mRootView;
  }
  
  public Boolean h()
  {
    return this.J;
  }
  
  public void h(Boolean paramBoolean)
  {
    this.J = paramBoolean;
  }
  
  public void hideTitleBar()
  {
    try
    {
      if (getRootView() != null)
      {
        this.a = ((NavBarCommon)getRootView().findViewById(2131377361));
        this.bda = this.a.getVisibility();
        if (this.a.getVisibility() == 0) {
          this.a.setVisibility(8);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ViolaLazyFragment", 2, localThrowable, new Object[0]);
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (Build.VERSION.SDK_INT >= 11) {
      j(getActivity(), 16777216);
    }
  }
  
  public ViewGroup j()
  {
    return this.mContentView;
  }
  
  public String kQ()
  {
    return this.aoH;
  }
  
  public ViewGroup o()
  {
    return this.fB;
  }
  
  public void o(View.OnClickListener paramOnClickListener)
  {
    if (this.a != null) {
      this.a.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void oI(String paramString)
  {
    an(paramString, false);
  }
  
  public void oJ(String paramString)
  {
    if ((!this.auG) && (ImmersiveUtils.isSupporImmersive() == 1) && (!"status_bar_color_style".equals(paramString)) && ((getActivity() instanceof BaseActivity)) && (getActivity().mSystemBarComp != null))
    {
      this.mSystemBarComp = getActivity().mSystemBarComp;
      this.mSystemBarComp.init();
      this.mSystemBarComp.setStatusBarColor(Color.parseColor(paramString));
    }
  }
  
  public void oK(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.a.getVisibility() != 0) {
        this.a.setVisibility(0);
      }
      this.a.setBackgroundColor(Color.parseColor(paramString));
    }
  }
  
  public void oL(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.tM.getVisibility() != 0) {
        this.tM.setVisibility(0);
      }
      this.tM.setTextColor(Color.parseColor(paramString));
    }
  }
  
  public void oM(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.tO.getVisibility() != 0) {
        this.tO.setVisibility(0);
      }
      this.tO.setTextColor(Color.parseColor(paramString));
    }
  }
  
  public void oN(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if ((this.tP.getVisibility() != 0) && (!TextUtils.isEmpty(this.tP.getText()))) {
        this.tP.setVisibility(0);
      }
      this.tP.setTextColor(Color.parseColor(paramString));
    }
  }
  
  public void oO(String paramString)
  {
    if (getActivity() != null)
    {
      if (!"drawable_black".equals(paramString)) {
        break label46;
      }
      this.tM.setVisibility(0);
      this.tM.setBackgroundDrawable(getActivity().getResources().getDrawable(2130850369));
    }
    label46:
    while (!"drawable_white".equals(paramString)) {
      return;
    }
    this.tM.setVisibility(0);
    this.tM.setBackgroundDrawable(getActivity().getResources().getDrawable(2130851758));
  }
  
  public void oP(String paramString)
  {
    this.mContentView.setBackgroundColor(Color.parseColor(paramString));
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    QLog.d("ViolaLazyFragment", 2, "debugForTimeCost onAttach:" + System.currentTimeMillis());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.d("ViolaLazyFragment", 2, "debugForTimeCost onCreate:" + System.currentTimeMillis());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    QLog.d("ViolaLazyFragment", 2, "debugForTimeCost onCreateView:" + System.currentTimeMillis());
    this.mLayoutInflater = paramLayoutInflater;
    this.mContainer = paramViewGroup;
    if (Build.VERSION.SDK_INT >= 11) {
      j(getActivity(), 16777216);
    }
    B(paramViewGroup);
    if (this.mRootView == null) {}
    for (paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);; paramLayoutInflater = this.mRootView)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.mContentView = null;
    this.mLayoutInflater = null;
    if (this.avt) {
      aUZ();
    }
    this.avt = false;
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.avt) {
      aUX();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    oJ(this.aoH);
    FragmentActivity localFragmentActivity;
    if (getUserVisibleHint())
    {
      localFragmentActivity = getActivity();
      if (this.J.booleanValue()) {
        break label53;
      }
    }
    label53:
    for (boolean bool = true;; bool = false)
    {
      aafx.setStatusBarDarkIcon(localFragmentActivity, bool);
      if (this.avt) {
        aUW();
      }
      return;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    VideoReport.addToDetectionWhitelist(getActivity());
    QLog.d("ViolaLazyFragment", 2, "debugForTimeCost onStart:" + System.currentTimeMillis());
    if ((this.avt) && (!this.mIsStart) && (getUserVisibleHint()))
    {
      this.mIsStart = true;
      aUV();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if ((this.avt) && (this.mIsStart) && (getUserVisibleHint()))
    {
      this.mIsStart = false;
      aUY();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.avu) {
      bck();
    }
  }
  
  public abstract int pw();
  
  public void qs(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.setBackgroundColor(0);
      return;
    }
    this.a.setBackgroundColor(-1);
  }
  
  public void setRightButtonText(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.tP.setVisibility(0);
    this.tP.setText(paramString);
    this.tP.setEnabled(true);
    if (paramOnClickListener != null) {
      this.tP.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.a.setTitle(paramCharSequence);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if ((paramBoolean) && (!this.avt)) {
      bcf();
    }
    if ((this.avt) && (getRootView() != null))
    {
      if (paramBoolean)
      {
        this.mIsStart = true;
        aUV();
        aUW();
      }
    }
    else {
      return;
    }
    this.mIsStart = false;
    aUX();
    aUY();
  }
  
  public void showTitleBar()
  {
    try
    {
      this.a = ((NavBarCommon)this.fB.findViewById(2131377361));
      if ((this.a.getVisibility() != 0) && (this.bda == 0)) {
        this.a.setVisibility(0);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ViolaLazyFragment", 2, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaLazyFragment
 * JD-Core Version:    0.7.0.1
 */