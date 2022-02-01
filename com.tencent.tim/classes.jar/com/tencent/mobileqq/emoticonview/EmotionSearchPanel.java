package com.tencent.mobileqq.emoticonview;

import afmw;
import afnd;
import afnu;
import afov;
import afow;
import afox;
import afoy;
import afoz;
import afpa;
import afpb;
import afpc;
import afpd;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ankt;
import aqmr;
import aqnm;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class EmotionSearchPanel
  extends RelativeLayout
  implements View.OnClickListener
{
  public static int keyboardHeight;
  public View BT;
  TextView RA;
  afnd a;
  public BaseChatPie a;
  public QQAppInterface app;
  private boolean bZZ;
  public EditText bc;
  private int cSM;
  private int cSN;
  private int cSO = ankt.dip2px(60.0F);
  private final int cSP = 200;
  int cSQ;
  public int cSR = 0;
  public boolean caa = false;
  boolean cab = false;
  public boolean isDestory = false;
  PopupWindow j;
  RelativeLayout jW;
  RelativeLayout jX;
  RelativeLayout jY;
  FrameLayout mask;
  ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = null;
  public float screenWidth;
  final float wc = 0.99F;
  public ImageView yU;
  
  public EmotionSearchPanel(Context paramContext)
  {
    super(paramContext, null);
  }
  
  public EmotionSearchPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public EmotionSearchPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int Dp()
  {
    return this.cSQ / 2 - Dr() - ankt.dip2px(16.0F);
  }
  
  private int Dq()
  {
    return this.cSQ / 2 - Dr();
  }
  
  private int Dr()
  {
    Object localObject2 = this.bc.getText().toString();
    Object localObject1 = localObject2;
    if (aqmr.isEmpty((String)localObject2)) {
      localObject1 = this.bc.getHint().toString();
    }
    localObject2 = new Rect();
    this.bc.getPaint().getTextBounds((String)localObject1, 0, ((String)localObject1).length(), (Rect)localObject2);
    return ((Rect)localObject2).width() / 2;
  }
  
  private void MT(int paramInt)
  {
    if (aqmr.isEmpty(this.bc.getText().toString()))
    {
      afnu.cN("0X800AE27", paramInt);
      return;
    }
    afnu.cN("0X800AE29", paramInt);
  }
  
  private void MU(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jY.getLayoutParams();
    localLayoutParams.width = paramInt;
    this.jY.setLayoutParams(localLayoutParams);
  }
  
  private void MV(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.bc.getLayoutParams();
    localLayoutParams.leftMargin = paramInt;
    this.bc.setLayoutParams(localLayoutParams);
  }
  
  private void MW(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jW.getLayoutParams();
    localLayoutParams.setMargins(0, 0, 0, paramInt);
    this.jW.setLayoutParams(localLayoutParams);
  }
  
  private void Q(float paramFloat1, float paramFloat2)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
    localAlphaAnimation.setDuration(200L);
    this.mask.startAnimation(localAlphaAnimation);
  }
  
  private boolean ajG()
  {
    return (!this.cab) && (!this.bZZ);
  }
  
  private void dbf()
  {
    MX(3);
    if (!this.caa) {
      dbj();
    }
    hideSoftInput();
    afnd localafnd = (afnd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a().a(7);
    if (this.bZZ)
    {
      localafnd.HT(this.bc.getText().toString());
      localafnd.HZ(true);
    }
    localafnd.MK(4);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.Af(12);
  }
  
  private void dbg()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    int i = Dp();
    localValueAnimator.setDuration(200L);
    localValueAnimator.addUpdateListener(new afox(this, i));
    if (ajG()) {
      MV(i);
    }
    localValueAnimator.start();
  }
  
  private void dbh()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    int i = this.bc.getWidth();
    int k = ankt.dip2px(27.0F);
    int m = this.cSQ;
    int n = this.jY.getWidth();
    int i1 = Dq();
    localValueAnimator.setDuration(200L);
    localValueAnimator.addUpdateListener(new afoy(this, n, m - i, i1 - k));
    localValueAnimator.addListener(new afoz(this));
    localValueAnimator.start();
  }
  
  private void dbn()
  {
    if (this.BT != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        this.BT.getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
      }
    }
    else {
      return;
    }
    this.BT.getViewTreeObserver().removeGlobalOnLayoutListener(this.onGlobalLayoutListener);
  }
  
  private void hideSoftInput()
  {
    if ((getContext() != null) && (this.bc != null))
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        localInputMethodManager.hideSoftInputFromWindow(this.bc.getWindowToken(), 0);
        if (QLog.isColorLevel()) {
          QLog.d("EmotionSearchPanel", 2, new Object[] { "hideSoftInput, ", this.bc.getWindowToken() });
        }
      }
    }
  }
  
  private void initView()
  {
    this.bc = ((EditText)findViewById(2131366390));
    this.RA = ((TextView)findViewById(2131366389));
    this.jX = ((RelativeLayout)findViewById(2131366391));
    this.jW = ((RelativeLayout)findViewById(2131366388));
    this.jW.setBackgroundColor(getContext().getResources().getColor(2131165785));
    this.jY = ((RelativeLayout)findViewById(2131366377));
    this.yU = ((ImageView)findViewById(2131369888));
    this.yU.setOnClickListener(this);
    this.mask = ((FrameLayout)findViewById(2131371159));
    this.RA.setOnClickListener(this);
    this.mask.setOnClickListener(this);
    this.BT = ((Activity)getContext()).getWindow().getDecorView();
    this.bc.setBackgroundDrawable(s(18));
    this.jY.setBackgroundDrawable(s(18));
    this.bc.setOnEditorActionListener(new afov(this));
    this.bc.addTextChangedListener(new afow(this));
  }
  
  private void k(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.screenWidth = ankt.aE(getContext());
    if (!aqmr.isEmpty(paramString))
    {
      this.bc.setText(paramString);
      this.bc.setSelection(paramString.length());
      this.cab = true;
      MV(0);
      this.yU.setVisibility(0);
      this.cSM = paramInt1;
      this.cSQ = paramInt2;
      if (this.cSQ <= 0) {
        this.cSQ = ((int)this.screenWidth);
      }
      if (keyboardHeight <= 0) {
        break label154;
      }
    }
    label154:
    for (this.cSN = (keyboardHeight - this.cSM);; this.cSN = (paramInt3 - (this.jY.getHeight() - this.jX.getHeight()) / 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchPanel", 2, "init initAnimStartParam =" + this.cSN);
      }
      return;
      this.cab = false;
      this.yU.setVisibility(8);
      break;
    }
  }
  
  public void MX(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchPanel", 2, new Object[] { "setEmotionStatus,status ", Integer.valueOf(paramInt) });
    }
    this.cSR = paramInt;
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, int paramInt1, boolean paramBoolean, String paramString, int paramInt2, int paramInt3, afnd paramafnd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchPanel", 2, "init start searchRootStartBottomMargin=" + this.cSM + " upDis=" + paramInt2 + " width=" + paramInt3 + " hasWord=" + this.cab + " keyboardHeight= " + keyboardHeight);
    }
    MX(1);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.app = paramQQAppInterface;
    this.isDestory = false;
    initView();
    k(paramString, paramInt1, paramInt3, paramInt2);
    this.jdField_a_of_type_Afnd = paramafnd;
    dbi();
    if (paramBoolean) {
      this.bc.setText("");
    }
  }
  
  public void dbi()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchPanel", 2, "startEntryAinm =" + this.cSN);
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, this.cSN });
    localValueAnimator.setDuration(200L);
    localValueAnimator.addUpdateListener(new afpa(this));
    localValueAnimator.addListener(new afpb(this));
    localValueAnimator.start();
    Q(0.0F, 0.71F);
    dbg();
  }
  
  public void dbj()
  {
    int m = ((afmw)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a().a(1)).Di();
    int i = this.cSN - ankt.dip2px(12.0F);
    if (this.cab) {
      i = this.cSN - ankt.dip2px(24.0F);
    }
    int k = i;
    if (this.cSN < 0) {
      k = i + m;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, k });
    localValueAnimator.setDuration(200L);
    localValueAnimator.addUpdateListener(new afpc(this));
    localValueAnimator.start();
    if (this.cSN < 0) {
      ((afnd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a().a(7)).MK(4);
    }
    Q(0.71F, 0.0F);
    dbh();
  }
  
  public void dbk()
  {
    this.onGlobalLayoutListener = new afpd(this);
    this.BT.getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
  }
  
  public void dbl()
  {
    if (this.j == null) {
      this.j = new PopupWindow(this, -1, -1);
    }
    this.j.setFocusable(true);
    this.j.setSoftInputMode(16);
    try
    {
      if (Build.VERSION.SDK_INT >= 22) {
        this.j.setAttachedInDecor(false);
      }
      this.j.setClippingEnabled(false);
      this.j.showAtLocation(this, 0, 0, 0);
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchPanel", 2, new Object[] { "showEmotionSearchWindow,height ", Integer.valueOf(this.j.getHeight()) });
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EmotionSearchPanel", 2, localThrowable, new Object[0]);
    }
  }
  
  public void dbm()
  {
    if (this.j != null) {
      this.j.dismiss();
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchPanel", 2, new Object[] { "setEmotionStatus,dispatchKeyEvent code=", Integer.valueOf(paramKeyEvent.getKeyCode()) });
    }
    if (paramKeyEvent.getKeyCode() == 4) {
      dbf();
    }
    return super.dispatchKeyEvent(paramKeyEvent);
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
      MT(1);
      dbf();
      continue;
      MT(2);
      dbf();
      continue;
      this.bc.setText("");
      this.yU.setVisibility(8);
    }
  }
  
  public void onDestory()
  {
    this.isDestory = true;
    dbn();
    dbm();
    MX(0);
  }
  
  protected Drawable s(int paramInt)
  {
    if (ThemeUtil.isNowThemeIsNight(this.app, false, null)) {}
    for (String str = "#1C1C1C";; str = "#F5F6FA") {
      return aqnm.h(Color.parseColor(str), aqnm.dip2px(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionSearchPanel
 * JD-Core Version:    0.7.0.1
 */