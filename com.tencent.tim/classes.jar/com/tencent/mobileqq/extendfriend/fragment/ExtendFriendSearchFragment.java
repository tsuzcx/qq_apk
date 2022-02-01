package com.tencent.mobileqq.extendfriend.fragment;

import acfd;
import aehc;
import afsg;
import afsi;
import afsr;
import aftq;
import afua;
import afvl;
import afvo;
import afvp;
import afvq;
import afvr;
import afvs;
import afvt;
import afvu;
import afvv;
import afvv.a;
import afwe;
import afwf;
import afxf;
import afzj;
import amxm;
import amxm.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import anot;
import aqiw;
import aqmu;
import auru;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.pulltorefresh.LoadingLayoutBase;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.Mode;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.State;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.a;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.c;
import com.tencent.mobileqq.extendfriend.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendMultiLinesTagsView;
import com.tencent.mobileqq.nearby.anim.NearbyZanAnimLayout;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.BounceScrollView.c;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.List;
import jll.a;
import wja;

public class ExtendFriendSearchFragment
  extends ExtendFriendBaseFragment
  implements afvv.a, amxm.a, TextWatcher, View.OnClickListener, TextView.OnEditorActionListener, PullToRefreshBase.a, PullToRefreshBase.c<RecyclerView>, BounceScrollView.c
{
  private List<String> AA;
  private View Cd;
  private View Cj;
  private Intent Z;
  private acfd jdField_a_of_type_Acfd = new afvp(this);
  private afvl jdField_a_of_type_Afvl;
  CancelReceiver jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchFragment$CancelReceiver;
  ExtendFriendMultiLinesTagsView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView;
  ExtendFriendMultiLinesTagsView b;
  public QuickPinyinEditText b;
  private boolean bZx;
  private afsr c = new afvo(this);
  private int cUO = 1;
  private int cUt;
  private boolean caO;
  private boolean cbl;
  private boolean cbm = true;
  private byte[] dF;
  ViewGroup ec;
  private BounceScrollView j;
  private boolean mLoading;
  int mMode = 0;
  private amxm mSoftKeyboardStateHelper;
  SystemBarCompact mSystemBarComp;
  private long mUpdateTime;
  private auru n;
  ImageView zm;
  
  private void FQ()
  {
    try
    {
      if ((this.mSystemBarComp != null) && (ThemeUtil.isInNightMode(this.mActivity.app)))
      {
        int i = getResources().getColor(2131167120);
        this.mSystemBarComp.setStatusBarMask(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP));
      }
      return;
    }
    catch (Exception localException)
    {
      QZLog.e("ExtendFriendSearchFragment", "catch an exception when set the NightMode for StatusBar.", localException);
    }
  }
  
  private void IA(boolean paramBoolean)
  {
    boolean bool2 = true;
    QuickPinyinEditText localQuickPinyinEditText = this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText;
    boolean bool1;
    if (paramBoolean)
    {
      bool1 = true;
      localQuickPinyinEditText.setFocusable(bool1);
      localQuickPinyinEditText = this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText;
      if (!paramBoolean) {
        break label44;
      }
    }
    label44:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      localQuickPinyinEditText.setFocusableInTouchMode(paramBoolean);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void IB(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      if (this.ec.getVisibility() != i) {
        this.ec.setVisibility(i);
      }
      return;
    }
  }
  
  private void Ip(String paramString)
  {
    float f3 = this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWidth() - this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getPaddingLeft() - this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getPaddingRight();
    float f4 = this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getTextSize();
    float f2 = 18.0F;
    float f1 = f2;
    if (f4 > 1.0F)
    {
      f1 = f2;
      if (f3 > 1.0F) {
        f1 = f3 / f4;
      }
    }
    f1 = Math.max(f1, 12.0F);
    String str = paramString;
    int i;
    int k;
    if (aehc.d(paramString) > f1)
    {
      i = Math.max(0, (int)(f1 - 4.0F));
      k = i;
      if (i < paramString.length()) {
        if (!TextUtils.equals(String.valueOf(paramString.charAt(i - 1)), "、")) {}
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if (aehc.d(paramString.substring(0, i) + "…") > f1)
      {
        str = paramString.substring(0, k) + "…";
        this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(str);
        return;
      }
      k = i;
    }
  }
  
  private void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, byte[] paramArrayOfByte, boolean paramBoolean3, boolean paramBoolean4, int paramInt, List<afua> paramList, aftq paramaftq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSearchFragment", 2, String.format("handleGetSquareStrangerList success=%s searchKey=%s", new Object[] { Boolean.valueOf(paramBoolean1), paramString }));
    }
    if ((!isAdded()) || (this.jdField_a_of_type_Afwe == null)) {
      return;
    }
    paramString = this.jdField_a_of_type_Afwe;
    int i;
    if (paramBoolean1)
    {
      i = 0;
      paramString.Nw(i);
      if ((paramBoolean1) && (paramList != null)) {
        break label230;
      }
      if (this.bZx) {
        this.jdField_a_of_type_Afwe.bx(1, true);
      }
      this.jdField_a_of_type_Afwe.clear();
      if (this.cUO != 0) {
        break label222;
      }
      paramInt = 2131696743;
      label110:
      ci(getString(paramInt), 1);
      label121:
      if (this.jdField_a_of_type_Afwe.getItemCount() == 0) {
        this.jdField_a_of_type_Afwe.ID(true);
      }
      this.jdField_a_of_type_Afwe.notifyDataSetChanged();
      if ((!this.bZx) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView != null)) {
        if (!paramBoolean1) {
          break label542;
        }
      }
    }
    label542:
    for (paramInt = 2131701185;; paramInt = 2131701184)
    {
      paramString = getResources().getString(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false).setRefreshResultLabel(paramString);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.ddB();
      this.mLoading = false;
      dch();
      Iv(true);
      return;
      i = 1;
      break;
      label222:
      paramInt = 2131701184;
      break label110;
      label230:
      this.caO = paramBoolean2;
      this.dF = paramArrayOfByte;
      this.caM = paramBoolean3;
      this.caN = paramBoolean4;
      this.cUt = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSearchFragment", 2, String.format("handleGetSquareStrangerList mLoadOver=%s mRequestCookies=%s mProfileComplete=%s mShowCard=%s mMaxLikeCount=%s matchCount=%d limitDuration=%d", new Object[] { Boolean.valueOf(this.caO), this.dF, Boolean.valueOf(this.caM), Boolean.valueOf(this.caN), Integer.valueOf(this.cUt), Integer.valueOf(paramaftq.cUo), Integer.valueOf(paramaftq.cUp) }));
      }
      if (!this.bZx) {
        this.jdField_a_of_type_Afwe.clear();
      }
      if (this.caO) {
        this.jdField_a_of_type_Afwe.bx(2, false);
      }
      this.jdField_a_of_type_Afwe.addAll(paramList);
      if (!this.bZx) {
        this.mRecyclerView.scrollToPosition(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView != null)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false);
        if (paramString != null)
        {
          this.mUpdateTime = System.currentTimeMillis();
          paramString.setLastUpdatedLabel(String.format("%s%s", new Object[] { getResources().getString(2131720481), aqmu.a(this.mUpdateTime, true, "yyyy-MM-dd") }));
        }
      }
      if (this.Z == null) {
        this.Z = new Intent();
      }
      this.Z.putExtra("remain_match_count", paramaftq.cUo);
      this.Z.putExtra("limit_chat_duration", paramaftq.cUp);
      getActivity().setResult(-1, this.Z);
      break label121;
    }
  }
  
  private void brD()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSearchFragment", 2, "autoRefresh");
    }
    if ((!isAdded()) || (this.jdField_a_of_type_Afwe == null)) {}
    do
    {
      return;
      if (!aqiw.isNetworkAvailable(this.mActivity)) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView == null);
    LoadingLayoutBase localLoadingLayoutBase = this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a();
    if (localLoadingLayoutBase != null) {}
    for (int i = localLoadingLayoutBase.getHeight();; i = 0)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.isRefreshing()) || (i == 0))
      {
        Iu(false);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setRefreshing();
      this.jdField_a_of_type_Afwe.bx(0, true);
      return;
      this.cUO = 0;
      dcY();
      return;
    }
  }
  
  private void dcY()
  {
    a(false, this.mSearchKey, false, null, false, false, 0, null, null);
  }
  
  private boolean mf(String paramString)
  {
    return this.jdField_a_of_type_Afsi.Z(2).contains(paramString);
  }
  
  private void xU(int paramInt)
  {
    this.mMode = paramInt;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("switchToMode ");
      if (this.mMode != 1) {
        break label104;
      }
    }
    label104:
    for (String str = "result";; str = "search")
    {
      QLog.i("ExtendFriendSearchFragment", 2, str);
      if (paramInt != 1) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.getVisibility() != 0) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setVisibility(0);
      }
      if (this.j.getVisibility() != 8) {
        this.j.setVisibility(8);
      }
      K(false, 50L);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.requestFocus();
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText("");
    if (this.j.getVisibility() != 0) {
      this.j.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.getVisibility() != 8) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setVisibility(8);
    }
    K(true, 50L);
  }
  
  protected int DF()
  {
    return 1033;
  }
  
  protected int DG()
  {
    return this.cUt;
  }
  
  public void IM()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSearchFragment", 2, "showInputMethod");
    }
    if ((this.mActivity != null) && (this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText != null))
    {
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.clearFocus();
      ((InputMethodManager)this.mActivity.getSystemService("input_method")).showSoftInput(this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText, 0);
    }
  }
  
  public void Iq(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSearchFragment", 2, String.format("search keyword=%s", new Object[] { paramString }));
    }
    boolean bool = TextUtils.isEmpty(this.mSearchKey);
    this.mSearchKey = paramString;
    xU(1);
    auru localauru;
    if (this.n != null)
    {
      this.n.removeMessages(13);
      localauru = this.n;
      if (!bool) {
        break label98;
      }
    }
    label98:
    for (long l = 200L;; l = 50L)
    {
      localauru.sendEmptyMessageDelayed(13, l);
      ThreadManager.postImmediately(new ExtendFriendSearchFragment.10(this, paramString), null, true);
      return;
    }
  }
  
  public void Iu(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSearchFragment", 2, String.format("requestSquareStrangerList loadMore=%s keyword=%s", new Object[] { Boolean.valueOf(paramBoolean), this.mSearchKey }));
    }
    this.bZx = paramBoolean;
    if (!this.bZx)
    {
      this.caO = false;
      this.dF = null;
    }
    if (this.jdField_b_of_type_Afsg != null)
    {
      if (this.mApp != null)
      {
        this.XN = System.currentTimeMillis();
        this.jdField_b_of_type_Afsg.a(this.mApp.getCurrentUin(), this.dF, 20, this.mSearchKey, this.XN, "", mf(this.mSearchKey));
        this.mLoading = true;
      }
    }
    else {
      return;
    }
    QLog.e("ExtendFriendSearchFragment", 2, "requestSquareStrangerList mApp is null");
  }
  
  public void K(boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSearchFragment", 2, "requestToggleInputMethod " + paramBoolean);
    }
    if (paramBoolean)
    {
      this.n.removeMessages(12);
      if (this.n.hasMessages(11)) {}
    }
    do
    {
      this.n.sendEmptyMessageDelayed(11, paramLong);
      do
      {
        return;
      } while (paramLong != 0L);
      this.n.removeMessages(11);
      this.n.sendEmptyMessage(11);
      return;
      this.n.removeMessages(11);
      if (!this.n.hasMessages(12))
      {
        this.n.sendEmptyMessageDelayed(12, paramLong);
        return;
      }
    } while (paramLong != 0L);
    this.n.removeMessages(12);
    this.n.sendEmptyMessage(11);
  }
  
  public void a(PullToRefreshBase<RecyclerView> paramPullToRefreshBase)
  {
    if (this.f.hasMessages(10))
    {
      this.f.removeMessages(10);
      bOS();
    }
    anot.a(this.mApp, "dc00898", "", "", "0X80092D4", "0X80092D4", 0, 0, "", "", "", "");
    if (aqiw.isNetworkAvailable(this.mActivity))
    {
      Iu(false);
      dck();
      this.jdField_a_of_type_Afwe.bx(0, true);
      return;
    }
    this.cUO = 0;
    dcY();
  }
  
  public void a(PullToRefreshBase paramPullToRefreshBase, PullToRefreshBase.State paramState, PullToRefreshBase.Mode paramMode) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString();
    if (TextUtils.isEmpty(paramEditable)) {
      this.zm.setVisibility(8);
    }
    for (;;)
    {
      if ((this.mMode == 1) && (TextUtils.isEmpty(paramEditable))) {
        xU(0);
      }
      return;
      this.zm.setVisibility(0);
    }
  }
  
  public void b(PullToRefreshBase<RecyclerView> paramPullToRefreshBase) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void dcf()
  {
    K(false, 50L);
  }
  
  public void dct()
  {
    this.n.post(new ExtendFriendSearchFragment.3(this));
  }
  
  protected void gR()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSearchFragment", 2, "hideInputMethod");
    }
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.clearFocus();
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWindowToken(), 0);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      gR();
      continue;
      IM();
      continue;
      brD();
    }
  }
  
  public void he(int paramInt)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      getActivity().getWindow().addFlags(67108864);
      if (this.mSystemBarComp != null) {
        return;
      }
      this.mSystemBarComp = new SystemBarCompact(getActivity(), false, getResources().getColor(paramInt));
      this.mSystemBarComp.init();
    }
    if (Build.VERSION.SDK_INT >= 19) {
      getActivity().getWindow().addFlags(67108864);
    }
    FQ();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSearchFragment", 2, String.format("onActivityResult requestCode=%s resultCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    if (paramInt1 == 1033)
    {
      dcm();
      bV(true, true);
      if (paramInt2 == 8193) {
        dcl();
      }
      this.cUx = -1;
      if (this.Z == null) {
        this.Z = new Intent();
      }
      this.Z.putExtra("has_entered_profile", true);
      getActivity().setResult(-1, this.Z);
    }
    do
    {
      do
      {
        return;
        if ((paramInt1 != 1) || (paramInt2 != -1)) {
          break;
        }
        paramIntent = this.jdField_a_of_type_Afwe.a(this.cUw);
      } while ((paramIntent == null) || (paramIntent.mAddFriendVerified));
      paramIntent.mAddFriendVerified = true;
      this.jdField_a_of_type_Afwe.notifyItemChanged(this.cUw);
      if (this.AA == null) {
        this.AA = new ArrayList();
      }
      this.AA.add(paramIntent.mUin);
      if (this.Z == null) {
        this.Z = new Intent();
      }
      if (this.Z.hasExtra("add_frd_list")) {
        this.Z.removeExtra("add_frd_list");
      }
      this.Z.putStringArrayListExtra("add_frd_list", (ArrayList)this.AA);
      getActivity().setResult(-1, this.Z);
      return;
    } while ((paramInt1 != 2) || (paramInt2 != -1));
    if (this.Z == null) {
      this.Z = new Intent();
    }
    this.Z.putExtra("has_entered_profile", true);
    getActivity().setResult(-1, this.Z);
    bV(false, true);
  }
  
  public boolean onBackEvent()
  {
    if (this.mMode == 1)
    {
      xU(0);
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i;
    if (this.mMode == 0)
    {
      i = 1;
      switch (paramView.getId())
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 2;
      break;
      if (this.mMode == 1) {
        xU(0);
      }
      for (;;)
      {
        anot.a(this.mApp, "dc00898", "", "", "0X800941A", "0X800941A", i, 0, "", "", "", "");
        break;
        if (this.mActivity != null) {
          this.mActivity.finish();
        }
      }
      this.jdField_a_of_type_Afsi.a().clear();
      anot.a(this.mApp, "dc00898", "", "", "0X8009418", "0X8009418", 0, 0, "", "", "", "");
      continue;
      if (this.mMode == 1) {
        xU(0);
      }
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText("");
      anot.a(this.mApp, "dc00898", "", "", "0X8009419", "0X8009419", i, 0, "", "", "", "");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = this.mActivity.getWindow();
    if (paramBundle != null)
    {
      paramBundle.setFormat(-3);
      paramBundle.setBackgroundDrawable(new ColorDrawable(-1));
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchFragment$CancelReceiver = new CancelReceiver();
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.search.cancel");
    paramBundle.addAction("com.tencent.mobileqq.search.finish");
    this.mActivity.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchFragment$CancelReceiver, paramBundle);
    this.jdField_a_of_type_Afsi.a().a(this);
    this.mApp.addObserver(this.c);
    this.mApp.addObserver(this.jdField_a_of_type_Acfd);
    this.n = new auru(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Afvl = new afvl(this.mApp);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = (ViewGroup)paramLayoutInflater.inflate(2131561340, null);
    paramViewGroup = paramLayoutInflater.findViewById(2131379809);
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText = ((QuickPinyinEditText)paramLayoutInflater.findViewById(2131377837));
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setImeOptions(3);
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(this);
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
    boolean bool;
    if ("1".equals(DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.search_input_type.name(), "0")))
    {
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setInputType(524321);
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(50) });
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(this.jdField_a_of_type_Afsi.uC());
      this.mSoftKeyboardStateHelper = new amxm(paramLayoutInflater);
      this.mSoftKeyboardStateHelper.a(this);
      this.zm = ((ImageView)paramLayoutInflater.findViewById(2131377808));
      this.zm.setOnTouchListener(new jll.a());
      this.zm.setOnClickListener(this);
      paramBundle = paramLayoutInflater.findViewById(2131377807);
      paramBundle.setOnTouchListener(new jll.a());
      paramBundle.setOnClickListener(this);
      paramLayoutInflater.findViewById(2131368531).setOnClickListener(this);
      if (paramViewGroup != null)
      {
        paramBundle = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
        paramBundle.topMargin = ImmersiveUtils.getStatusBarHeight(this.mActivity);
        paramViewGroup.setLayoutParams(paramBundle);
      }
      this.ec = ((ViewGroup)paramLayoutInflater.findViewById(2131368532));
      this.Cj = paramLayoutInflater.findViewById(2131379244);
      this.j = ((BounceScrollView)paramLayoutInflater.findViewById(2131379245));
      this.j.setOnScrollChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView = ((ExtendFriendMultiLinesTagsView)paramLayoutInflater.findViewById(2131368541));
      this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView = ((ExtendFriendMultiLinesTagsView)paramLayoutInflater.findViewById(2131376933));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView.setViewMargin(wja.dp2px(10.0F, getResources()), wja.dp2px(10.0F, getResources()));
      this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView.setViewMargin(wja.dp2px(10.0F, getResources()), wja.dp2px(10.0F, getResources()));
      paramBundle = this.jdField_a_of_type_Afsi.Z(2);
      this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView.setSearchTags((ArrayList)paramBundle);
      paramBundle = this.jdField_a_of_type_Afsi.a().eP();
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView.setSearchTags((ArrayList)paramBundle);
      if (paramBundle.size() <= 0) {
        break label799;
      }
      bool = true;
      label431:
      IB(bool);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView.setOnItemClickListener(new afvq(this));
      this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView.setOnItemClickListener(new afvr(this));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView = ((PullToRefreshRecyclerView)paramLayoutInflater.findViewById(2131373844));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setOnRefreshListener(this);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false).setRefreshingLabel(getResources().getString(2131701186));
      this.mLayoutManager = new afzj(this.mActivity);
      this.mRecyclerView = ((RecyclerView)this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.bX());
      this.mRecyclerView.setId(2131376994);
      this.mRecyclerView.setLayoutManager(this.mLayoutManager);
      ((SimpleItemAnimator)this.mRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setOnPullEventListener(this);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setMode(PullToRefreshBase.Mode.MANUAL_REFRESH_ONLY);
      this.mRecyclerView.setOnScrollListener(new afvs(this));
      this.jdField_a_of_type_Afwf = new afwf(this);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver = new afvt(this);
      this.jdField_a_of_type_Afwe = new afwe(this, this, null, null, this.mRecyclerView, this.mActivity, 1, this.mGdtAppReceiver);
      this.jdField_a_of_type_Afwe.registerAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
      this.jdField_a_of_type_Afwe.a(this.jdField_a_of_type_Afvl);
      this.mRecyclerView.setAdapter(this.jdField_a_of_type_Afwe);
      this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout = ((NearbyZanAnimLayout)paramLayoutInflater.findViewById(2131368498));
      paramViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new afvu(this, paramViewGroup));
      this.Cd = paramLayoutInflater.findViewById(2131372394);
      if (this.Cd != null)
      {
        bool = ThemeUtil.isInNightMode(this.mActivity.app);
        paramViewGroup = this.Cd;
        if (!bool) {
          break label805;
        }
      }
    }
    label799:
    label805:
    for (int i = 0;; i = 8)
    {
      paramViewGroup.setVisibility(i);
      xU(0);
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setInputType(524289);
      break;
      bool = false;
      break label431;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchFragment$CancelReceiver != null)
      {
        this.mActivity.unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchFragment$CancelReceiver);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchFragment$CancelReceiver = null;
      }
      this.n.removeCallbacksAndMessages(null);
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
      if (this.jdField_a_of_type_Afvl != null)
      {
        this.jdField_a_of_type_Afvl.flush();
        this.jdField_a_of_type_Afvl = null;
      }
      if (this.mApp != null)
      {
        this.mApp.removeObserver(this.c);
        this.mApp.removeObserver(this.jdField_a_of_type_Acfd);
        this.mApp = null;
      }
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver != null) {
        this.jdField_a_of_type_Afwe.unregisterAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
      }
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
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 3) || ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)))
    {
      if (this.mMode == 0) {}
      for (paramInt = 1;; paramInt = 2)
      {
        paramTextView = this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString().trim();
        if (!TextUtils.isEmpty(paramTextView)) {
          Iq(paramTextView);
        }
        K(false, 50L);
        anot.a(this.mApp, "dc00898", "", "", "0X800941B", "0X800941B", paramInt, 0, "", "", "", "");
        return true;
      }
    }
    return false;
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (getActivity() != null) {
      getActivity().overridePendingTransition(0, 2130772403);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    he(2131167361);
    if ((!this.cbm) && (this.mMode == 1))
    {
      IA(false);
      this.n.postDelayed(new ExtendFriendSearchFragment.9(this), 50L);
    }
    this.cbm = false;
    if ((this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText != null) && (this.jdField_a_of_type_Afsi != null)) {
      Ip(this.jdField_a_of_type_Afsi.uC());
    }
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    K(false, 50L);
  }
  
  public void onSoftKeyboardClosed()
  {
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(false);
    this.cbl = false;
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(true);
    this.cbl = true;
  }
  
  public void onStop()
  {
    super.onStop();
    gR();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText != null) {
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
    }
    super.onViewStateRestored(paramBundle);
    if (this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText != null) {
      this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
    }
  }
  
  public void w(float paramFloat1, float paramFloat2) {}
  
  public class CancelReceiver
    extends BroadcastReceiver
  {
    public CancelReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("com.tencent.mobileqq.search.cancel".equals(paramIntent.getAction())) {
        if (ExtendFriendSearchFragment.this.mActivity != null) {
          ExtendFriendSearchFragment.this.mActivity.finish();
        }
      }
      while ((!"com.tencent.mobileqq.search.finish".equals(paramIntent.getAction())) || (ExtendFriendSearchFragment.this.mActivity == null)) {
        return;
      }
      ExtendFriendSearchFragment.this.mActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchFragment
 * JD-Core Version:    0.7.0.1
 */