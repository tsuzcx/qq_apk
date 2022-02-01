package com.tencent.mobileqq.multiaio;

import ajia;
import ajib;
import ajic;
import ajid;
import ajie;
import ajif;
import ajil;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import com.tencent.widget.ListView;
import wkj;
import zof;

public class MultiAIOItemFragment
  extends PublicBaseFragment
{
  private ViewStub J;
  private MultiAIOBaseViewPager.j jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$j;
  private zof jdField_a_of_type_Zof;
  private boolean coG;
  private boolean coH;
  private boolean coI;
  private boolean coJ;
  private boolean coK;
  private boolean coL;
  private GestureDetector mGestureDetector;
  private int mPosition;
  private SessionInfo mSessionInfo = new SessionInfo();
  
  private int[] T()
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment instanceof MultiAIOFragment)) {
      return ((MultiAIOFragment)localFragment).T();
    }
    return new int[0];
  }
  
  private int[] U()
  {
    int[] arrayOfInt = new int[2];
    Fragment localFragment = getParentFragment();
    if ((localFragment instanceof MultiAIOFragment)) {
      return ((MultiAIOFragment)localFragment).U();
    }
    return arrayOfInt;
  }
  
  private ajil a()
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment instanceof MultiAIOFragment)) {
      return ((MultiAIOFragment)localFragment).a();
    }
    return null;
  }
  
  private Intent a(Activity paramActivity)
  {
    return paramActivity.getIntent();
  }
  
  private RecentBaseData a(int paramInt)
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment instanceof MultiAIOFragment)) {
      return ((MultiAIOFragment)localFragment).a(paramInt);
    }
    return null;
  }
  
  private MultiAIOBaseViewPager a()
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment != null) && ((localFragment instanceof MultiAIOFragment))) {
      return ((MultiAIOFragment)localFragment).a();
    }
    return null;
  }
  
  @Nullable
  private View b(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    ajil localajil = a();
    if (localajil == null)
    {
      getActivity().finish();
      return null;
    }
    this.jdField_a_of_type_Zof = localajil.b(this);
    if (this.jdField_a_of_type_Zof == null)
    {
      getActivity().finish();
      return null;
    }
    if ((paramBundle == null) && (!getUserVisibleHint())) {}
    paramBundle = localajil.N(this.mPosition);
    paramLayoutInflater = this.jdField_a_of_type_Zof.a(paramLayoutInflater, paramBundle, paramViewGroup);
    this.jdField_a_of_type_Zof.Vy();
    this.coG = true;
    if (paramLayoutInflater == null)
    {
      getActivity().finish();
      return null;
    }
    return paramLayoutInflater;
  }
  
  private void dxH()
  {
    ListView localListView = (ListView)getView().findViewById(2131370537);
    Object localObject = localListView.getOnScrollListener();
    localListView.setOnScrollListener(new ajid(this, (AbsListView.e)localObject));
    MultiAIOBaseViewPager localMultiAIOBaseViewPager = a();
    if (localMultiAIOBaseViewPager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$j = new ajie(this, (AbsListView.e)localObject, localListView);
      localMultiAIOBaseViewPager.a(this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$j);
    }
    if ((this.mPosition == 0) && (this.jdField_a_of_type_Zof != null) && ((localListView instanceof ChatXListView)))
    {
      localObject = T();
      if ((localObject != null) && (localObject.length == 2) && (localObject[0] >= 0))
      {
        localListView.post(new MultiAIOItemFragment.6(this, localListView, (int[])localObject));
        this.jdField_a_of_type_Zof.BO(true);
        localListView.postDelayed(new MultiAIOItemFragment.7(this), 500L);
      }
      localListView.addOnLayoutChangeListener(new ajif(this, localListView));
    }
  }
  
  private void hd(View paramView)
  {
    FitSystemWindowsRelativeLayout localFitSystemWindowsRelativeLayout = (FitSystemWindowsRelativeLayout)paramView.findViewById(2131362332);
    if (localFitSystemWindowsRelativeLayout == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOItemFragment", 2, "initAIORootView() afRoot == null");
      }
    }
    do
    {
      return;
      this.mGestureDetector = new GestureDetector(paramView.getContext(), new ajia(this), new Handler(Looper.getMainLooper()));
      localFitSystemWindowsRelativeLayout.setDispatchTouchEventListener(new ajib(this));
      localFitSystemWindowsRelativeLayout.setOnInterceptTouchEventListener(new ajic(this));
      paramView = getParentFragment();
    } while ((paramView == null) || (!(paramView instanceof MultiAIOFragment)));
    paramView = ((MultiAIOFragment)paramView).a();
    int i = paramView.getMeasuredWidth();
    int j = paramView.getPaddingLeft();
    int k = paramView.getPaddingRight();
    int m = paramView.getMeasuredHeight();
    int n = paramView.getPaddingTop();
    int i1 = paramView.getPaddingBottom();
    paramView = localFitSystemWindowsRelativeLayout.getLayoutParams();
    paramView.width = getResources().getDisplayMetrics().widthPixels;
    float f = (i - j - k) * 1.0F / paramView.width;
    paramView.height = ((int)((m - n - i1) * 1.0F / f + 0.5F));
    localFitSystemWindowsRelativeLayout.setPivotX(-1.0F);
    localFitSystemWindowsRelativeLayout.setPivotY(-1.0F);
    localFitSystemWindowsRelativeLayout.setScaleX(f);
    localFitSystemWindowsRelativeLayout.setScaleY(f);
  }
  
  private void iJ(int paramInt1, int paramInt2)
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment instanceof MultiAIOFragment)) {
      ((MultiAIOFragment)localFragment).iI(paramInt1, paramInt2);
    }
  }
  
  private void initData(Bundle paramBundle)
  {
    boolean bool = false;
    if (paramBundle != null) {
      this.mPosition = paramBundle.getInt("KEY_POSITION");
    }
    paramBundle = a(getActivity());
    Object localObject = a(this.mPosition);
    if (localObject == null)
    {
      QLog.e("MultiAIOItemFragment", 1, "initData: recentBaseData == null");
      return;
    }
    this.mSessionInfo.aTl = ((RecentBaseData)localObject).qx();
    this.mSessionInfo.cZ = ((RecentBaseData)localObject).ng();
    this.mSessionInfo.aTn = ((RecentBaseData)localObject).getTitleName();
    this.mSessionInfo.bPu = paramBundle.getIntExtra("key_mini_from", 0);
    this.mSessionInfo.troopUin = this.mSessionInfo.aTl;
    this.mSessionInfo.a = new wkj();
    this.mSessionInfo.a.img = getResources().getDrawable(2130851037);
    this.mSessionInfo.a.k = getResources().getColorStateList(2131165375);
    this.mSessionInfo.cN = ChatTextSizeSettingActivity.ag(getActivity());
    localObject = this.mSessionInfo.getExtras();
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = new Bundle();
    }
    if (!isVisible()) {
      bool = true;
    }
    paramBundle.putBoolean("KEY_DELAY_SET_READ", bool);
    paramBundle.putBoolean("KEY_IS_IN_MULTI_AIO", true);
    this.mSessionInfo.setExtras(paramBundle);
  }
  
  public void QS(int paramInt)
  {
    zof localzof;
    if (this.jdField_a_of_type_Zof != null)
    {
      localzof = this.jdField_a_of_type_Zof;
      if (this.mPosition == paramInt) {
        break label35;
      }
    }
    label35:
    for (boolean bool = true;; bool = false)
    {
      localzof.BP(bool);
      this.jdField_a_of_type_Zof.aIH();
      return;
    }
  }
  
  public void QT(int paramInt)
  {
    if ((this.jdField_a_of_type_Zof != null) && (paramInt == this.mPosition)) {
      this.jdField_a_of_type_Zof.cqs();
    }
  }
  
  public SessionInfo a()
  {
    return this.mSessionInfo;
  }
  
  public int getPosition()
  {
    return this.mPosition;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Zof != null) {
      this.jdField_a_of_type_Zof.cqt();
    }
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOItemFragment", 2, "onCreate() called with: savedInstanceState = [" + paramBundle + "], " + this.mPosition);
    }
    Bundle localBundle = getArguments();
    if (paramBundle != null) {}
    for (;;)
    {
      initData(paramBundle);
      return;
      paramBundle = localBundle;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = b(paramLayoutInflater, paramViewGroup, paramBundle);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOItemFragment", 2, "onDestroy() called");
    }
    try
    {
      if (this.jdField_a_of_type_Zof != null)
      {
        this.jdField_a_of_type_Zof.doOnDestroy();
        this.coL = true;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MultiAIOItemFragment", 2, "onDestroy() called Exception");
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Object localObject = getView();
    if (localObject != null)
    {
      localObject = ((View)localObject).findViewById(2131362332);
      ajil localajil = a();
      if (localajil != null) {
        localajil.he((View)localObject);
      }
    }
    localObject = a();
    if (localObject != null) {
      ((MultiAIOBaseViewPager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$j);
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (this.jdField_a_of_type_Zof != null) {
      this.jdField_a_of_type_Zof.cqr();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOItemFragment", 2, "onPause() called " + this.mPosition);
    }
    if ((this.jdField_a_of_type_Zof != null) && (this.coG) && (this.coH) && (this.coI))
    {
      this.jdField_a_of_type_Zof.doOnPause();
      this.coJ = true;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOItemFragment", 2, "onResume() called " + this.mPosition);
    }
    if ((this.jdField_a_of_type_Zof != null) && (getUserVisibleHint()))
    {
      this.jdField_a_of_type_Zof.doOnResume();
      this.coI = true;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("KEY_POSITION", this.mPosition);
  }
  
  public void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOItemFragment", 2, "onStart() called " + this.mPosition);
    }
    if ((this.jdField_a_of_type_Zof != null) && (getUserVisibleHint()) && (this.coG))
    {
      this.jdField_a_of_type_Zof.doOnStart();
      this.coH = true;
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOItemFragment", 2, "onStop() called");
    }
    if ((this.jdField_a_of_type_Zof != null) && (this.coJ))
    {
      this.jdField_a_of_type_Zof.doOnStop();
      this.coK = true;
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOItemFragment", 2, "onViewCreated() called with: view = [" + paramView + "], mPosition = [" + this.mPosition + "], savedInstanceState = " + paramBundle);
    }
    paramView.setTag(Integer.valueOf(this.mPosition));
    hd(paramView);
    if ((paramView instanceof FrameLayout))
    {
      paramBundle = new View(getActivity());
      paramBundle.setId(2131372080);
      paramBundle.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((FrameLayout)paramView).addView(paramBundle);
    }
    if (this.coG) {
      dxH();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.jdField_a_of_type_Zof != null) {
      this.jdField_a_of_type_Zof.onWindowFocusChanged(paramBoolean);
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOItemFragment", 2, "setUserVisibleHint() called with: isVisibleToUser = [" + paramBoolean + "]");
    }
    super.setUserVisibleHint(paramBoolean);
    if (this.jdField_a_of_type_Zof == null) {}
    do
    {
      return;
      if (paramBoolean)
      {
        this.jdField_a_of_type_Zof.BP(false);
        if (!this.coG)
        {
          View localView = this.J.inflate();
          localView = this.jdField_a_of_type_Zof.a(null, localView, null);
          this.jdField_a_of_type_Zof.Vy();
          this.coG = true;
          hd(localView);
          dxH();
        }
        if (!this.coH)
        {
          this.jdField_a_of_type_Zof.doOnStart();
          this.coH = true;
        }
        this.jdField_a_of_type_Zof.doOnResume();
        this.coI = true;
        return;
      }
      this.jdField_a_of_type_Zof.BP(true);
    } while ((!this.coG) || (!this.coH) || (!this.coI));
    this.jdField_a_of_type_Zof.doOnPause();
    this.coJ = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOItemFragment
 * JD-Core Version:    0.7.0.1
 */