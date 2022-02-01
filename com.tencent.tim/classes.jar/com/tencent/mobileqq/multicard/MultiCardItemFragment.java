package com.tencent.mobileqq.multicard;

import ajjf;
import ajjh;
import ajjl;
import ajkl;
import ajko;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import anot;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public class MultiCardItemFragment
  extends PublicBaseFragment
  implements MultiCardRootLayout.a
{
  public static final ajko<MultiCardRootLayout> a;
  public static final ajko<ajjh> b;
  public static final ajko<ajkl> c;
  public static final ajko<View> d = new ajko();
  private ajjf a;
  private MultiCardRootLayout b;
  private ajjl c;
  private boolean coG;
  private boolean coH;
  private boolean coI;
  private boolean coJ;
  private boolean coK;
  private boolean coL;
  private QQAppInterface mApp;
  private int mPosition;
  private String mTroopUin;
  
  static
  {
    jdField_a_of_type_Ajko = new ajko();
    jdField_b_of_type_Ajko = new ajko();
    jdField_c_of_type_Ajko = new ajko();
  }
  
  private void Mf(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Ajjl != null)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("uin", this.jdField_a_of_type_Ajjf.getUin());
      ((Bundle)localObject).putString("troopuin", this.mTroopUin);
      this.jdField_c_of_type_Ajjl.a(this);
      this.jdField_c_of_type_Ajjl.da((Bundle)localObject);
      if (paramBoolean)
      {
        this.jdField_c_of_type_Ajjl.doOnCreate(null);
        this.coG = true;
      }
      this.jdField_c_of_type_Ajjl.a(this.jdField_a_of_type_Ajjf);
      localObject = getParentFragment();
      if ((localObject != null) && ((localObject instanceof MultiCardFragment)))
      {
        paramBoolean = ((MultiCardFragment)localObject).aqW();
        this.jdField_c_of_type_Ajjl.Mb(paramBoolean);
      }
    }
  }
  
  private void O(ViewGroup paramViewGroup)
  {
    if ((this.jdField_c_of_type_Ajjl != null) && (this.jdField_c_of_type_Ajjl.a() != null))
    {
      if (paramViewGroup != null) {
        paramViewGroup.removeView(this.jdField_c_of_type_Ajjl.a());
      }
      if (!(this.jdField_c_of_type_Ajjl instanceof ajjh)) {
        break label111;
      }
      jdField_b_of_type_Ajko.bs((ajjh)this.jdField_c_of_type_Ajjl);
    }
    for (;;)
    {
      this.jdField_c_of_type_Ajjl = null;
      if (QLog.isColorLevel()) {
        QLog.d("MultiCardItemFragment", 2, "removeViewAndAddDelegateIntoCache, friendviewcache:" + jdField_b_of_type_Ajko.count() + " strangerviewcache:" + jdField_c_of_type_Ajko.count());
      }
      return;
      label111:
      if ((this.jdField_c_of_type_Ajjl instanceof ajkl)) {
        jdField_c_of_type_Ajko.bs((ajkl)this.jdField_c_of_type_Ajjl);
      }
    }
  }
  
  private MultiAIOBaseViewPager a()
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment != null) && ((localFragment instanceof MultiCardFragment))) {
      return ((MultiCardFragment)localFragment).a();
    }
    return null;
  }
  
  private void b(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout = ((MultiCardRootLayout)jdField_a_of_type_Ajko.P());
      if (this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout == null)
      {
        this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout = ((MultiCardRootLayout)paramLayoutInflater.inflate(2131559448, paramViewGroup, false));
        if (QLog.isColorLevel()) {
          QLog.d("MultiCardItemFragment", 2, "create rootView ");
        }
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.setListener(this);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MultiCardItemFragment", 2, "reuse cache rootView ");
      }
      this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.removeAllViews();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("MultiCardItemFragment", 2, "rootview is valid");
      }
    }
  }
  
  public static View ck()
  {
    View localView = null;
    if (d != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("intimatetest", 2, "getDnaViewFromCache" + d.count());
      }
      localView = (View)d.P();
    }
    return localView;
  }
  
  private void dxX()
  {
    boolean bool = true;
    if (this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout == null) {
      return;
    }
    if (this.jdField_a_of_type_Ajjf == null)
    {
      O(this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
      this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.Mg(true);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.Mg(false);
    int i;
    if (this.jdField_a_of_type_Ajjf.getType() == 0) {
      if ((this.jdField_c_of_type_Ajjl instanceof ajjh))
      {
        i = 1;
        if ((getUserVisibleHint()) && (!this.coI))
        {
          if (this.jdField_c_of_type_Ajjl != null) {
            this.jdField_c_of_type_Ajjl.doOnResume();
          }
          this.coI = true;
        }
        if (i != 0) {
          break label305;
        }
      }
    }
    for (;;)
    {
      Mf(bool);
      return;
      O(this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
      this.jdField_c_of_type_Ajjl = ((ajjl)jdField_b_of_type_Ajko.P());
      if (this.jdField_c_of_type_Ajjl == null)
      {
        this.jdField_c_of_type_Ajjl = new ajjh(this.mApp, getActivity(), this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getContext(), this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
        i = 0;
        break;
      }
      this.jdField_c_of_type_Ajjl.setParentView(this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
      i = 0;
      break;
      if (this.jdField_a_of_type_Ajjf.getType() == 1)
      {
        if ((this.jdField_c_of_type_Ajjl instanceof ajkl))
        {
          i = 1;
          break;
        }
        O(this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
        this.jdField_c_of_type_Ajjl = ((ajjl)jdField_c_of_type_Ajko.P());
        if (this.jdField_c_of_type_Ajjl == null)
        {
          this.jdField_c_of_type_Ajjl = new ajkl(this.mApp, getActivity(), this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getContext(), this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
          i = 0;
          break;
        }
        this.jdField_c_of_type_Ajjl.setParentView(this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
        if (QLog.isColorLevel()) {
          QLog.d("MultiCardItemFragment", 2, "reuse strangerdelegate");
        }
      }
      i = 0;
      break;
      label305:
      bool = false;
    }
  }
  
  private void dxY()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout == null) {}
    do
    {
      return;
      localObject = getParentFragment();
    } while ((localObject == null) || (!(localObject instanceof MultiCardFragment)));
    Object localObject = ((MultiCardFragment)localObject).a();
    int i = ((MultiAIOBaseViewPager)localObject).getMeasuredWidth();
    int j = ((MultiAIOBaseViewPager)localObject).getPaddingLeft();
    int k = ((MultiAIOBaseViewPager)localObject).getPaddingRight();
    int m = ((MultiAIOBaseViewPager)localObject).getMeasuredHeight();
    int n = ((MultiAIOBaseViewPager)localObject).getPaddingTop();
    int i1 = ((MultiAIOBaseViewPager)localObject).getPaddingBottom();
    localObject = this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = getResources().getDisplayMetrics().widthPixels;
    float f = (i - j - k) * 1.0F / ((ViewGroup.LayoutParams)localObject).width;
    ((ViewGroup.LayoutParams)localObject).height = ((int)((m - n - i1) * 1.0F / f + 0.5F));
    this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.setPivotX(-1.0F);
    this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.setPivotY(-1.0F);
    this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.setScaleX(f);
    this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.setScaleY(f);
  }
  
  public static void e(ViewGroup paramViewGroup, View paramView)
  {
    if ((paramViewGroup != null) && (paramView != null))
    {
      paramViewGroup.removeView(paramView);
      if ((paramView != null) && (d != null))
      {
        d.bs(paramView);
        if (QLog.isColorLevel()) {
          QLog.d("intimatetest", 2, "removeViewAndAddDnaViewToCache" + d.count());
        }
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("intimatetest", 2, "removeViewAndAddDnaViewToCache in vie null");
  }
  
  private void initData(Bundle paramBundle)
  {
    if (paramBundle != null) {
      this.mPosition = paramBundle.getInt("KEY_POSITION");
    }
  }
  
  public void Mc(boolean paramBoolean)
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment != null) && ((localFragment instanceof MultiCardFragment))) {
      ((MultiCardFragment)localFragment).Mc(paramBoolean);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, ajjf paramajjf, String paramString)
  {
    this.mApp = paramQQAppInterface;
    this.mPosition = paramInt;
    this.jdField_a_of_type_Ajjf = paramajjf;
    this.mTroopUin = paramString;
  }
  
  public void a(MultiCardRootLayout paramMultiCardRootLayout)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout == null) || (this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout != paramMultiCardRootLayout)) {}
    do
    {
      return;
      paramMultiCardRootLayout = getParentFragment();
    } while ((this.jdField_c_of_type_Ajjl == null) || (paramMultiCardRootLayout == null) || (!(paramMultiCardRootLayout instanceof MultiCardFragment)));
    ((MultiCardFragment)paramMultiCardRootLayout).a(this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout, this.jdField_c_of_type_Ajjl.a(), this.jdField_c_of_type_Ajjl);
  }
  
  public boolean al(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        paramMotionEvent = a();
        if ((paramMotionEvent == null) || (paramMotionEvent.getCurrentItem() == this.mPosition)) {
          break;
        }
        return true;
        bool1 = bool2;
      } while (this.jdField_c_of_type_Ajjl == null);
      bool1 = bool2;
    } while (!this.jdField_c_of_type_Ajjl.L(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()));
    return false;
  }
  
  public void b(ajjf paramajjf)
  {
    if ((this.jdField_a_of_type_Ajjf == null) && (paramajjf == null)) {}
    while ((this.jdField_a_of_type_Ajjf != null) && (paramajjf != null) && (paramajjf.getTimeStamp() <= this.jdField_a_of_type_Ajjf.getTimeStamp())) {
      return;
    }
    this.jdField_a_of_type_Ajjf = paramajjf;
    dxX();
  }
  
  public void c(ajjl paramajjl)
  {
    paramajjl = getParentFragment();
    if ((paramajjl != null) && ((paramajjl instanceof MultiCardFragment)) && (this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout != null) && (this.jdField_c_of_type_Ajjl != null)) {
      ((MultiCardFragment)paramajjl).c(this.jdField_c_of_type_Ajjl);
    }
  }
  
  public int getPosition()
  {
    return this.mPosition;
  }
  
  public boolean kt(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return false;
      Mc(true);
    } while (this.jdField_c_of_type_Ajjl != null);
    return true;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_c_of_type_Ajjl != null) {
      this.jdField_c_of_type_Ajjl.cqt();
    }
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardItemFragment", 2, "onCreate() called with: savedInstanceState = [" + paramBundle + "], " + this.mPosition);
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
    b(paramLayoutInflater, paramViewGroup);
    if (this.jdField_a_of_type_Ajjf == null)
    {
      paramLayoutInflater = getParentFragment();
      if ((paramLayoutInflater != null) && ((paramLayoutInflater instanceof MultiCardFragment))) {
        ((MultiCardFragment)paramLayoutInflater).Rb(this.mPosition);
      }
    }
    dxX();
    paramLayoutInflater = this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardItemFragment", 2, "onDestroy() pos:" + this.mPosition);
    }
    try
    {
      if (this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.setListener(null);
        jdField_a_of_type_Ajko.bs(this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
        this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout = null;
      }
      if (this.jdField_c_of_type_Ajjl != null)
      {
        this.jdField_c_of_type_Ajjl.doOnDestroy();
        O(null);
        this.coL = true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MultiCardItemFragment", 2, "onDestroy() called Exception");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardItemFragment", 2, "onDestroy() rootcache :" + jdField_a_of_type_Ajko.count() + " friendviewcache:" + jdField_b_of_type_Ajko.count() + " strangerviewcache:" + jdField_c_of_type_Ajko.count());
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardItemFragment", 2, "onDestroyView() pos:" + this.mPosition);
    }
    View localView = getView();
    if ((this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout != null) && ((localView instanceof ViewGroup)))
    {
      if ((this.jdField_c_of_type_Ajjl != null) && (this.jdField_c_of_type_Ajjl.a() != null)) {
        this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.removeView(this.jdField_c_of_type_Ajjl.a());
      }
      ((ViewGroup)localView).removeView(this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
    }
    try
    {
      if (this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.setListener(null);
        jdField_a_of_type_Ajko.bs(this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout);
        this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout = null;
      }
      if (this.jdField_c_of_type_Ajjl != null)
      {
        this.jdField_c_of_type_Ajjl.doOnDestroy();
        O(null);
        this.coL = true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MultiCardItemFragment", 2, "onDestroyView() called Exception");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardItemFragment", 2, "onDestroyView() rootcache :" + jdField_a_of_type_Ajko.count() + " friendviewcache:" + jdField_b_of_type_Ajko.count() + " strangerviewcache:" + jdField_c_of_type_Ajko.count());
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (this.jdField_c_of_type_Ajjl != null) {
      this.jdField_c_of_type_Ajjl.cqr();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardItemFragment", 2, "onPause() called " + this.mPosition);
    }
    if ((this.jdField_c_of_type_Ajjl != null) && (this.coG) && (this.coH) && (this.coI))
    {
      this.jdField_c_of_type_Ajjl.doOnPause();
      this.coJ = true;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardItemFragment", 2, "onResume() called " + this.mPosition);
    }
    if ((this.jdField_c_of_type_Ajjl != null) && (getUserVisibleHint()))
    {
      this.jdField_c_of_type_Ajjl.doOnResume();
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
      QLog.d("MultiCardItemFragment", 2, "onStart() called " + this.mPosition);
    }
    if ((this.jdField_c_of_type_Ajjl != null) && (getUserVisibleHint()) && (this.coG))
    {
      this.jdField_c_of_type_Ajjl.doOnStart();
      this.coH = true;
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardItemFragment", 2, "onStop() called");
    }
    if ((this.jdField_c_of_type_Ajjl != null) && (this.coJ))
    {
      this.jdField_c_of_type_Ajjl.doOnStop();
      this.coK = true;
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardItemFragment", 2, "onViewCreated() called with: view = [" + paramView + "], mPosition = [" + this.mPosition + "], savedInstanceState = " + paramBundle);
    }
    paramView.setTag(Integer.valueOf(this.mPosition));
    dxY();
    if ((paramView instanceof FrameLayout))
    {
      paramBundle = new MultiCardMaskView(getActivity());
      paramBundle.setId(2131372080);
      paramBundle.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((FrameLayout)paramView).addView(paramBundle);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.jdField_c_of_type_Ajjl != null) {
      this.jdField_c_of_type_Ajjl.onWindowFocusChanged(paramBoolean);
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardItemFragment", 2, "setUserVisibleHint() called with: isVisibleToUser = [" + paramBoolean + "] pos:" + getPosition());
    }
    super.setUserVisibleHint(paramBoolean);
    if (this.jdField_b_of_type_ComTencentMobileqqMulticardMultiCardRootLayout == null) {}
    do
    {
      return;
      if (paramBoolean)
      {
        anot.a(null, "dc00898", "", "", "0X800A213", "0X800A213", 0, 0, "", "", "", "");
        if (!this.coG) {
          dxX();
        }
        if (!this.coH)
        {
          if (this.jdField_c_of_type_Ajjl != null) {
            this.jdField_c_of_type_Ajjl.doOnStart();
          }
          this.coH = true;
        }
        if (this.jdField_c_of_type_Ajjl != null) {
          this.jdField_c_of_type_Ajjl.doOnResume();
        }
        this.coI = true;
        return;
      }
    } while ((!this.coG) || (!this.coH) || (!this.coI));
    if (this.jdField_c_of_type_Ajjl != null) {
      this.jdField_c_of_type_Ajjl.doOnPause();
    }
    this.coJ = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardItemFragment
 * JD-Core Version:    0.7.0.1
 */