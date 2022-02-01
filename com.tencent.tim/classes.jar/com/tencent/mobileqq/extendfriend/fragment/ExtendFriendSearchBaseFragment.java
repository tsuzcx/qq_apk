package com.tencent.mobileqq.extendfriend.fragment;

import aehc;
import afvm;
import afvn;
import amxm;
import amxm.a;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
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
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import auru;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendMultiLinesTagsView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.BounceScrollView.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import jll;
import wja;

public abstract class ExtendFriendSearchBaseFragment
  extends PublicBaseFragment
  implements amxm.a, Handler.Callback, TextWatcher, View.OnClickListener, TextView.OnEditorActionListener, BounceScrollView.c
{
  private View Cd;
  private TextView RP;
  private TextView RQ;
  private ExtendFriendMultiLinesTagsView a;
  private ExtendFriendMultiLinesTagsView b;
  private FrameLayout bA;
  private QuickPinyinEditText c;
  private boolean cbk = true;
  private ViewGroup ec;
  private ViewGroup ed;
  private BounceScrollView i;
  protected FragmentActivity mActivity;
  protected QQAppInterface mApp;
  private int mMode = -1;
  private amxm mSoftKeyboardStateHelper;
  private SystemBarCompact mSystemBarComp;
  private auru n;
  private ImageView zl;
  
  private void FQ()
  {
    try
    {
      if ((this.mSystemBarComp != null) && (ThemeUtil.isInNightMode(this.mActivity.app)))
      {
        int j = getResources().getColor(2131167120);
        this.mSystemBarComp.setStatusBarMask(new PorterDuffColorFilter(j, PorterDuff.Mode.SRC_ATOP));
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ExtendFriendSearchBaseFragment", 1, "showStatusBarMask fail.", localException);
    }
  }
  
  private void IA(boolean paramBoolean)
  {
    this.c.setFocusable(paramBoolean);
    this.c.setFocusableInTouchMode(paramBoolean);
  }
  
  private void IM()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSearchBaseFragment", 2, "showInputMethod");
    }
    this.c.clearFocus();
    ((InputMethodManager)this.mActivity.getSystemService("input_method")).showSoftInput(this.c, 0);
  }
  
  private void J(boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSearchBaseFragment", 2, String.format("toggleInputMethod open=%s delay=%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) }));
    }
    this.n.removeMessages(12);
    this.n.removeMessages(11);
    if (paramBoolean) {
      if (!this.n.hasMessages(11)) {
        this.n.sendEmptyMessageDelayed(11, paramLong);
      }
    }
    while (this.n.hasMessages(12)) {
      return;
    }
    this.n.sendEmptyMessageDelayed(12, paramLong);
  }
  
  private void gR()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSearchBaseFragment", 2, "hideInputMethod");
    }
    this.c.clearFocus();
    ((InputMethodManager)this.mActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.c.getWindowToken(), 0);
  }
  
  private void he(int paramInt)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.mSystemBarComp == null))
    {
      this.mSystemBarComp = new SystemBarCompact(getActivity(), false, getResources().getColor(paramInt));
      this.mSystemBarComp.init();
      if (Build.VERSION.SDK_INT >= 19) {
        this.mActivity.getWindow().addFlags(67108864);
      }
      FQ();
    }
  }
  
  private void kR(String paramString)
  {
    xU(1);
    Im(paramString);
  }
  
  private void xU(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSearchBaseFragment", 2, String.format("switchToMode oldMode=%s newMode=%s", new Object[] { Integer.valueOf(this.mMode), Integer.valueOf(paramInt) }));
    }
    if (this.mMode != paramInt)
    {
      this.mMode = paramInt;
      if (this.mMode == 1)
      {
        this.i.setVisibility(8);
        this.bA.setVisibility(0);
        J(false, 50L);
      }
    }
    else
    {
      return;
    }
    this.c.requestFocus();
    this.c.setText("");
    this.i.setVisibility(0);
    this.bA.setVisibility(8);
    J(true, 50L);
  }
  
  abstract void Im(String paramString);
  
  public void Ip(String paramString)
  {
    float f1;
    String str;
    int j;
    int k;
    if (this.c != null)
    {
      float f3 = this.c.getWidth() - this.c.getPaddingLeft() - this.c.getPaddingRight();
      float f4 = this.c.getTextSize();
      float f2 = 18.0F;
      f1 = f2;
      if (f4 > 1.0F)
      {
        f1 = f2;
        if (f3 > 1.0F) {
          f1 = f3 / f4;
        }
      }
      f1 = Math.max(f1, 12.0F);
      str = paramString;
      if (aehc.d(paramString) > f1)
      {
        j = Math.max(0, (int)(f1 - 4.0F));
        k = j;
        if (j < paramString.length()) {
          if (!TextUtils.equals(String.valueOf(paramString.charAt(j - 1)), "、")) {}
        }
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if (aehc.d(paramString.substring(0, j) + "…") > f1)
      {
        str = paramString.substring(0, k) + "…";
        this.c.setHint(str);
        return;
      }
      k = j;
    }
  }
  
  abstract void N(ViewGroup paramViewGroup);
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.c.getText().toString();
    if (TextUtils.isEmpty(paramEditable)) {
      this.zl.setVisibility(8);
    }
    for (;;)
    {
      if ((this.mMode == 1) && (TextUtils.isEmpty(paramEditable))) {
        xU(0);
      }
      return;
      this.zl.setVisibility(0);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  abstract void dcs();
  
  public void ee(ArrayList<String> paramArrayList)
  {
    int k = 0;
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (int j = 1;; j = 0)
    {
      this.a.setSearchTags(paramArrayList);
      paramArrayList = this.ec;
      if (j != 0) {
        k = 8;
      }
      paramArrayList.setVisibility(k);
      return;
    }
  }
  
  public void ef(ArrayList<String> paramArrayList)
  {
    int k = 0;
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (int j = 1;; j = 0)
    {
      this.b.setSearchTags(paramArrayList);
      paramArrayList = this.ed;
      if (j != 0) {
        k = 8;
      }
      paramArrayList.setVisibility(k);
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      gR();
      continue;
      IM();
    }
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
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.mMode == 1)
      {
        xU(0);
      }
      else if (this.mActivity != null)
      {
        this.mActivity.finish();
        continue;
        dcs();
        continue;
        if (this.mMode == 1) {
          xU(0);
        }
        this.c.setText("");
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mActivity = getActivity();
    this.mApp = this.mActivity.app;
    paramBundle = this.mActivity.getWindow();
    if (paramBundle != null)
    {
      paramBundle.setFormat(-3);
      paramBundle.setBackgroundDrawable(new ColorDrawable(-1));
    }
    this.n = new auru(Looper.getMainLooper(), this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = (ViewGroup)paramLayoutInflater.inflate(2131561342, null);
    paramViewGroup = paramLayoutInflater.findViewById(2131379809);
    if (paramViewGroup != null)
    {
      paramBundle = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
      paramBundle.topMargin = ImmersiveUtils.getStatusBarHeight(this.mActivity);
      paramViewGroup.setLayoutParams(paramBundle);
      he(2131167361);
    }
    this.c = ((QuickPinyinEditText)paramLayoutInflater.findViewById(2131377837));
    this.c.setImeOptions(3);
    this.c.setOnEditorActionListener(this);
    this.c.addTextChangedListener(this);
    this.c.setFilters(new InputFilter[] { new InputFilter.LengthFilter(50) });
    this.c.setInputType(524289);
    this.zl = ((ImageView)paramLayoutInflater.findViewById(2131377808));
    this.zl.setOnTouchListener(jll.a);
    this.zl.setOnClickListener(this);
    this.RP = ((TextView)paramLayoutInflater.findViewById(2131377807));
    this.RP.setOnTouchListener(jll.a);
    this.RP.setOnClickListener(this);
    this.bA = ((FrameLayout)paramLayoutInflater.findViewById(2131377815));
    N(this.bA);
    this.i = ((BounceScrollView)paramLayoutInflater.findViewById(2131377860));
    this.i.setOnScrollChangedListener(this);
    this.ec = ((ViewGroup)paramLayoutInflater.findViewById(2131368532));
    this.a = ((ExtendFriendMultiLinesTagsView)paramLayoutInflater.findViewById(2131368541));
    this.a.setViewMargin(wja.dp2px(10.0F, getResources()), wja.dp2px(10.0F, getResources()));
    this.a.setOnItemClickListener(new afvm(this));
    this.RQ = ((TextView)paramLayoutInflater.findViewById(2131368531));
    this.RQ.setOnClickListener(this);
    this.ed = ((ViewGroup)paramLayoutInflater.findViewById(2131376897));
    this.b = ((ExtendFriendMultiLinesTagsView)paramLayoutInflater.findViewById(2131376933));
    this.b.setViewMargin(wja.dp2px(10.0F, getResources()), wja.dp2px(10.0F, getResources()));
    this.b.setOnItemClickListener(new afvn(this));
    this.Cd = paramLayoutInflater.findViewById(2131372394);
    if (this.Cd != null)
    {
      boolean bool = ThemeUtil.isInNightMode(this.mActivity.app);
      paramViewGroup = this.Cd;
      if (!bool) {
        break label477;
      }
    }
    label477:
    for (int j = 0;; j = 8)
    {
      paramViewGroup.setVisibility(j);
      this.mSoftKeyboardStateHelper = new amxm(paramLayoutInflater);
      this.mSoftKeyboardStateHelper.a(this);
      xU(0);
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.n.removeCallbacksAndMessages(null);
    this.c.removeTextChangedListener(this);
    this.c.setOnEditorActionListener(null);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt != 3)
    {
      bool1 = bool2;
      if (paramKeyEvent != null)
      {
        bool1 = bool2;
        if (paramKeyEvent.getKeyCode() != 66) {}
      }
    }
    else
    {
      paramTextView = this.c.getText().toString().trim();
      if (!TextUtils.isEmpty(paramTextView)) {
        kR(paramTextView);
      }
      J(false, 50L);
      bool1 = true;
    }
    return bool1;
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (this.mActivity != null) {
      this.mActivity.overridePendingTransition(0, 2130772403);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((!this.cbk) && (this.mMode == 1))
    {
      IA(false);
      this.n.postDelayed(new ExtendFriendSearchBaseFragment.3(this), 50L);
    }
    this.cbk = false;
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    J(false, 50L);
  }
  
  public void onSoftKeyboardClosed()
  {
    this.c.setCursorVisible(false);
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    this.c.setCursorVisible(true);
  }
  
  public void onStop()
  {
    super.onStop();
    gR();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    if (this.c != null) {
      this.c.removeTextChangedListener(this);
    }
    super.onViewStateRestored(paramBundle);
    if (this.c != null) {
      this.c.addTextChangedListener(this);
    }
  }
  
  public void w(float paramFloat1, float paramFloat2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchBaseFragment
 * JD-Core Version:    0.7.0.1
 */