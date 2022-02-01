package com.tencent.av.ui;

import acfp;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.beauty.QavBeautyMenuPanel;
import com.tencent.av.ui.virtual.QavVirtualMenuView;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.widget.shimmer.ShimmerTextView;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import iiv;
import iyb;
import izq;
import jbz;
import jbz.a;
import jcv;
import jcw;
import jcx;
import jcy;
import jcz;
import jda;
import jdb;
import jdc;
import jdd;
import jiu;
import jiv;
import jiw;
import jjm;
import jkn;
import jks;
import jkt;
import jku;
import jll;
import mqq.app.BaseActivity;
import wja;

public class QavPanel
  extends RelativeLayout
{
  public static int axd = 2131379195;
  ImageButton I = null;
  ImageButton J = null;
  ImageButton K = null;
  FrameLayout T = null;
  final String TAG = "QavPanel_" + AudioHelper.hG();
  boolean XD = false;
  private volatile boolean XE;
  boolean XF = false;
  private boolean XG;
  private boolean XH;
  private boolean XI;
  public ClipDrawable a;
  private a jdField_a_of_type_ComTencentAvUiQavPanel$a = new a(Looper.getMainLooper());
  c jdField_a_of_type_ComTencentAvUiQavPanel$c = null;
  private e jdField_a_of_type_ComTencentAvUiQavPanel$e;
  QavPanelSoundWaveView jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView = null;
  ShimmerTextView jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = null;
  public jdd a;
  private jkt jdField_a_of_type_Jkt;
  private jku jdField_a_of_type_Jku;
  jbz[] jdField_a_of_type_ArrayOfJbz = new jbz[5];
  int awS = 0;
  private int awT;
  int awU = -1;
  private int awV;
  public final int awW = 256;
  public final int awX = 257;
  public final int awY = 258;
  public final int awZ = 259;
  public final int axa = 260;
  public final int axb = 261;
  private int axc = 1;
  private LayerDrawable jdField_b_of_type_AndroidGraphicsDrawableLayerDrawable;
  jiw jdField_b_of_type_Jiw = null;
  Button bn = null;
  Button bo = null;
  Button bp = null;
  Button bq = null;
  Button br = null;
  Button bt = null;
  Button bu = null;
  public Button bv = null;
  Button bw = null;
  Button bx = null;
  Button by = null;
  private GradientDrawable c;
  public View.OnClickListener cd = null;
  Drawable ce = null;
  Drawable cf = null;
  RelativeLayout ej = null;
  RelativeLayout ek = null;
  ImageView gB = null;
  ImageView gC = null;
  ImageView gD = null;
  private ImageView gE;
  private ImageView gF;
  View id = null;
  View ie = null;
  View jdField_if = null;
  View ig = null;
  private View ih;
  View.OnTouchListener k = null;
  public VideoAppInterface mApp;
  View mRootView = null;
  TextView mU = null;
  private TextView mV;
  private ValueAnimator x;
  private ValueAnimator y;
  
  public QavPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable = null;
    init();
  }
  
  public QavPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable = null;
    init();
  }
  
  public QavPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable = null;
    init();
  }
  
  private jbz a()
  {
    if (this.awU != -1) {
      return this.jdField_a_of_type_ArrayOfJbz[this.awU];
    }
    return null;
  }
  
  static void a(ImageButton paramImageButton, int paramInt)
  {
    if (paramImageButton == null) {
      return;
    }
    paramImageButton.setImageDrawable(jjm.b(paramImageButton.getResources(), paramInt));
    paramImageButton.setAdjustViewBounds(true);
  }
  
  private void atN()
  {
    View localView = this.mRootView;
    this.ih = localView.findViewById(2131374039);
    this.gE = ((ImageView)localView.findViewById(2131374268));
    this.gF = ((ImageView)localView.findViewById(2131374038));
    this.mV = ((TextView)localView.findViewById(2131374040));
    this.jdField_a_of_type_Jkt = new jkt((Activity)localView.getContext());
    if (this.gE != null) {
      this.gE.setImageDrawable(this.jdField_a_of_type_Jkt.ag());
    }
    if (this.ih != null) {
      this.ih.setVisibility(8);
    }
  }
  
  private void atO()
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    this.jdField_if = localViewGroup.findViewById(2131373944);
    if ((this.jdField_if == null) && (AudioHelper.isDev())) {
      throw new IllegalArgumentException("没找到VIEW_ENUM.HIDE");
    }
    this.ig = localViewGroup.findViewById(2131374249);
    this.K = ((ImageButton)localViewGroup.findViewById(2131374247));
    this.K.setVisibility(8);
    this.J = ((ImageButton)localViewGroup.findViewById(2131374253));
    getRootView();
  }
  
  private void atP()
  {
    this.bo = ((Button)this.mRootView.findViewById(2131363170));
    if (this.bo != null) {
      AudioHelper.a(getResources(), this.bo, 2130842810, 2131166217, 2131166217);
    }
  }
  
  private void atQ()
  {
    this.br = ((Button)this.mRootView.findViewById(2131363169));
    if (this.br != null) {
      AudioHelper.a(getResources(), this.br, 2130842836, 2131166217, 2131166217);
    }
  }
  
  private void atT()
  {
    if ((getContext() instanceof BaseActivity))
    {
      BaseActivity localBaseActivity = (BaseActivity)getContext();
      if ((localBaseActivity.getAppRuntime() instanceof VideoAppInterface)) {
        this.mApp = ((VideoAppInterface)localBaseActivity.getAppRuntime());
      }
    }
  }
  
  private void atU()
  {
    this.I = ((ImageButton)this.mRootView.findViewById(2131373941));
    this.bt = ((Button)this.mRootView.findViewById(2131373942));
    this.id = this.mRootView.findViewById(2131373951);
    atO();
    this.bv = ((Button)this.mRootView.findViewById(2131373947));
    this.bw = ((Button)this.mRootView.findViewById(2131373939));
    ka(false);
  }
  
  private void atV()
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView = new QavPanelSoundWaveView(getContext());
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.ke(true);
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131298283));
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setLayoutParams(localLayoutParams);
  }
  
  private void aub()
  {
    this.c = new GradientDrawable();
    this.c.setShape(1);
    this.c.setSize(wja.dp2px(64.0F, getResources()), wja.dp2px(64.0F, getResources()));
    this.c.setColor(1291845632);
    this.jdField_a_of_type_Jku = new jku(wja.dp2px(64.0F, getResources()), wja.dp2px(64.0F, getResources()));
    this.jdField_a_of_type_Jku.a(0, BitmapFactory.decodeResource(getResources(), 2130842889));
    this.jdField_a_of_type_Jku.a(0, BitmapFactory.decodeResource(getResources(), 2130842890));
    this.jdField_a_of_type_Jku.a(1, BitmapFactory.decodeResource(getResources(), 2130842891));
    this.jdField_a_of_type_Jku.a(2, BitmapFactory.decodeResource(getResources(), 2130842891));
    this.jdField_a_of_type_Jku.a(2, BitmapFactory.decodeResource(getResources(), 2130842893));
    this.jdField_a_of_type_Jku.a(3, BitmapFactory.decodeResource(getResources(), 2130842894));
    this.jdField_a_of_type_Jku.nN(0);
    this.jdField_b_of_type_AndroidGraphicsDrawableLayerDrawable = new LayerDrawable(new Drawable[] { this.c, this.jdField_a_of_type_Jku });
    this.jdField_b_of_type_AndroidGraphicsDrawableLayerDrawable.setLayerInset(0, 0, 0, 0, 0);
    this.jdField_b_of_type_AndroidGraphicsDrawableLayerDrawable.setLayerInset(1, 0, 0, 0, 0);
    this.jdField_b_of_type_AndroidGraphicsDrawableLayerDrawable.setBounds(0, 0, this.jdField_a_of_type_Jku.getIntrinsicWidth(), this.jdField_a_of_type_Jku.getIntrinsicHeight());
    this.bv.setCompoundDrawables(null, this.jdField_b_of_type_AndroidGraphicsDrawableLayerDrawable, null, null);
    this.bv.setOnTouchListener(new jcx(this));
  }
  
  private void aud()
  {
    if (!ws()) {
      QLog.d(this.TAG, 1, "tryPerformLongClick cannot switch muteStatus");
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_ComTencentAvUiQavPanel$e.wu())
      {
        QLog.d(this.TAG, 1, "tryPerformLongClick cannot checkBlockMuteStatus");
        return;
      }
    } while (lZ() != 1);
    if (wt())
    {
      iiv localiiv = this.mApp.b().b();
      localiiv.O("tryPerformLongClick", false);
      localiiv.Z("tryPerformLongClick", 3);
      a("tryPerformLongClick", 1, 3, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel$a.sendEmptyMessageDelayed(261, 4000L);
      return;
      this.mApp.b().a("tryPerformLongClick", this.jdField_a_of_type_ComTencentAvUiQavPanel$e.bO(), true, true, 3);
      a("tryPerformLongClick", 1, 3, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel$e.K(true, true);
    }
  }
  
  @TargetApi(11)
  private void aue()
  {
    if ((this.bv == null) || ((this.bv != null) && (!this.bv.isShown())) || (this.mApp == null)) {}
    while (lZ() != 1) {
      return;
    }
    if (wt())
    {
      iiv localiiv = this.mApp.b().b();
      localiiv.O("tryPlayBtnMuteAnimation", true);
      localiiv.Z("tryPlayBtnMuteAnimation", 2);
      a("tryPlayBtnMuteAnimation start", 1, 2, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel$e.auj();
      if (this.y == null)
      {
        this.y = ValueAnimator.ofInt(new int[] { 0, 3000 });
        this.y.setDuration(3000L);
        this.y.addListener(new jcz(this));
        this.y.addUpdateListener(new jda(this, new int[] { 250, 2750, 3000 }));
      }
      if (this.y.isRunning()) {
        this.y.cancel();
      }
      this.y.start();
      this.XI = true;
      return;
      this.mApp.b().V("tryPlayBtnMuteAnimation onAnimationEnd", 2);
      a("tryPlayBtnMuteAnimation", 1, 2, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel$e.K(false, false);
    }
  }
  
  private void auf()
  {
    if ((this.y != null) && (this.y.isRunning())) {
      this.y.cancel();
    }
  }
  
  private static boolean cB(int paramInt)
  {
    return (paramInt == 2130842887) || (paramInt == 2130842897) || (paramInt == 2130842898);
  }
  
  private void f(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.id = this.mRootView.findViewById(2131373951);
    this.I = ((ImageButton)this.mRootView.findViewById(2131373941));
    this.bt = ((Button)this.mRootView.findViewById(2131373942));
    this.ej = ((RelativeLayout)this.mRootView.findViewById(2131373925));
    this.ek = ((RelativeLayout)this.mRootView.findViewById(2131373927));
    this.bx = ((Button)this.mRootView.findViewById(2131373933));
    Drawable localDrawable;
    if (this.bx != null)
    {
      localDrawable = getResources().getDrawable(2130842862);
      if (localDrawable != null)
      {
        localDrawable.setBounds(0, 0, paramInt, paramInt);
        this.bx.setCompoundDrawables(null, localDrawable, null, null);
      }
    }
    this.by = ((Button)this.mRootView.findViewById(2131373946));
    if (this.by != null)
    {
      localDrawable = getResources().getDrawable(2130842881);
      if (localDrawable != null)
      {
        localDrawable.setBounds(0, 0, paramInt, paramInt);
        this.by.setCompoundDrawables(null, localDrawable, null, null);
      }
    }
    atO();
    this.T = ((FrameLayout)this.mRootView.findViewById(2131373950));
    this.bu = ((Button)this.mRootView.findViewById(2131373949));
    this.bv = ((Button)this.mRootView.findViewById(2131373947));
    this.bw = ((Button)this.mRootView.findViewById(2131373939));
    if (paramBoolean2) {}
    for (paramInt = 2;; paramInt = 1)
    {
      c(paramBoolean1, paramInt, false);
      if (!paramBoolean2) {
        this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(0);
      }
      return;
    }
  }
  
  private void jY(boolean paramBoolean)
  {
    this.I = ((ImageButton)this.mRootView.findViewById(2131373941));
    this.bt = ((Button)this.mRootView.findViewById(2131373942));
    this.id = this.mRootView.findViewById(2131373951);
    atO();
    this.bv = ((Button)this.mRootView.findViewById(2131373947));
    atN();
    this.bw = ((Button)this.mRootView.findViewById(2131373939));
  }
  
  private void jZ(boolean paramBoolean)
  {
    this.I = ((ImageButton)this.mRootView.findViewById(2131373941));
    this.bt = ((Button)this.mRootView.findViewById(2131373942));
    this.id = this.mRootView.findViewById(2131373951);
    atO();
    this.bv = ((Button)this.mRootView.findViewById(2131373947));
    atN();
    this.bw = ((Button)this.mRootView.findViewById(2131373939));
  }
  
  private void mH(int paramInt)
  {
    this.id = this.mRootView.findViewById(2131373951);
    this.bn = ((Button)this.mRootView.findViewById(2131363158));
    this.jdField_if = ((ViewGroup)getParent()).findViewById(2131373944);
    atP();
    atQ();
    this.bp = ((Button)this.mRootView.findViewById(2131374106));
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(0);
  }
  
  private void mI(int paramInt)
  {
    this.id = this.mRootView.findViewById(2131373951);
    this.gC = ((ImageView)this.mRootView.findViewById(2131374104));
    this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = ((ShimmerTextView)this.mRootView.findViewById(2131374105));
    this.gD = ((ImageView)this.mRootView.findViewById(2131373954));
    this.ie = this.mRootView.findViewById(2131374102);
    atP();
    atQ();
    atR();
    atS();
  }
  
  private void mJ(int paramInt)
  {
    this.bn = ((Button)this.mRootView.findViewById(2131363158));
    this.gC = ((ImageView)this.mRootView.findViewById(2131374104));
    this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = ((ShimmerTextView)this.mRootView.findViewById(2131374105));
    this.gD = ((ImageView)this.mRootView.findViewById(2131373954));
    this.ie = this.mRootView.findViewById(2131374102);
    atR();
    this.bq = ((Button)this.mRootView.findViewById(2131374107));
    atS();
  }
  
  private void mL(int paramInt)
  {
    mM(paramInt);
    setBtnTopDrawable(this.bw, 2130842897);
    setBtnTopDrawable(this.jdField_if, 2130842851);
    setBtnTopDrawable(this.ig, 2130842853);
    setBtnTopDrawable(this.J, 2130842871);
  }
  
  private void mM(int paramInt)
  {
    boolean bool2 = false;
    if (this.bv == null) {
      return;
    }
    boolean bool1;
    if ((paramInt == 2131559951) || (paramInt == 2131559950))
    {
      bool1 = true;
      if (jkn.xH()) {
        break label106;
      }
      bool1 = bool2;
    }
    label106:
    for (;;)
    {
      this.XG = bool1;
      if (!this.XG)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable = ((ClipDrawable)this.bv.getResources().getDrawable(2130842888));
        setBtnTopDrawableWithForeGround(this.bv, 2130842887, this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable);
        this.bv.setOnTouchListener(new jcw(this));
        return;
        bool1 = false;
        break;
      }
      aub();
      return;
    }
  }
  
  public static void setBtnTopDrawable(View paramView, int paramInt)
  {
    if ((paramView instanceof Button)) {
      setBtnTopDrawable((Button)paramView, paramInt);
    }
    while (!(paramView instanceof ImageButton)) {
      return;
    }
    a((ImageButton)paramView, paramInt);
  }
  
  public static void setBtnTopDrawable(TextView paramTextView, int paramInt)
  {
    if (paramTextView == null) {
      return;
    }
    if (cB(paramInt)) {}
    for (Drawable localDrawable = jjm.a(paramTextView.getResources(), paramInt, false);; localDrawable = jjm.a(paramTextView.getResources(), paramInt))
    {
      paramTextView.setCompoundDrawables(null, localDrawable, null, null);
      return;
    }
  }
  
  public static void setBtnTopDrawableWithForeGround(TextView paramTextView, int paramInt, Drawable paramDrawable)
  {
    if (paramTextView == null) {
      return;
    }
    paramTextView.setCompoundDrawables(null, jjm.a(paramTextView.getResources(), paramInt, paramDrawable, false), null, null);
  }
  
  private boolean wd()
  {
    return (this.jdField_a_of_type_ComTencentAvUiQavPanel$e != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel$e.wd());
  }
  
  private boolean wq()
  {
    boolean bool = false;
    if (this.mApp != null) {
      bool = this.mApp.sO();
    }
    return bool;
  }
  
  private boolean wt()
  {
    return this.awS == 2131559945;
  }
  
  public void J(int paramInt, boolean paramBoolean)
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = this.TAG;
      localStringBuilder = new StringBuilder().append("updateEffectBtn, effectType[").append(paramInt).append("], mEffectDrawable[");
      if (this.ce == null) {
        break label78;
      }
    }
    label78:
    for (boolean bool = true;; bool = false)
    {
      QLog.d(str, 2, bool + "], ignoreSetSelected[" + paramBoolean + "]");
      return;
    }
  }
  
  void L(long paramLong, int paramInt)
  {
    mO(2);
    EffectSettingUi localEffectSettingUi = (EffectSettingUi)a(2);
    if (localEffectSettingUi == null) {}
    while (!localEffectSettingUi.f(paramLong, paramInt)) {
      return;
    }
    c(paramLong, 2, true);
  }
  
  public void L(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      this.XE = false;
      this.awT = 0;
      if (this.x != null)
      {
        this.x.cancel();
        this.x = null;
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable != null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable.setLevel(0);
      }
      if (this.XG)
      {
        this.jdField_a_of_type_Jkt.nM(0);
        this.jdField_a_of_type_Jku.nO(0);
      }
      return;
    }
    this.XE = true;
  }
  
  public boolean N(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "setViewBackground, id" + izq.aT(paramInt1) + ", selected[" + paramInt2 + "]");
    }
    View localView = v(paramInt1);
    if (localView != null)
    {
      localView.setBackgroundResource(paramInt2);
      return true;
    }
    return false;
  }
  
  public boolean O(int paramInt1, int paramInt2)
  {
    return g(paramInt1, paramInt2, -1);
  }
  
  public <T extends RelativeLayout> T a(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 99) {
      i = this.awU;
    }
    if (this.jdField_a_of_type_ArrayOfJbz[i] != null) {
      return this.jdField_a_of_type_ArrayOfJbz[i].b();
    }
    return null;
  }
  
  public QavPanelSoundWaveView a()
  {
    return this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView;
  }
  
  jbz a(int paramInt, jbz.a parama)
  {
    Object localObject = getContext();
    if ((this.jdField_b_of_type_Jiw == null) || (!(localObject instanceof AVActivity))) {
      return null;
    }
    switch (paramInt)
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      ((QavMenuBaseView)localObject).setVisibility(8);
      ((QavMenuBaseView)localObject).setGravity(80);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout)findViewById(2131373924)).addView((View)localObject, localLayoutParams);
      ((QavMenuBaseView)localObject).a(this);
      ((QavMenuBaseView)localObject).refreshUI();
      return new jbz((RelativeLayout)localObject, paramInt, parama);
      localObject = new QavVirtualMenuView((Context)localObject);
      continue;
      localObject = new QavBeautyMenuPanel((Context)localObject);
      continue;
      localObject = new EffectSettingUi((Context)localObject);
      continue;
      localObject = new QavOperationMenuView((Context)localObject);
    }
  }
  
  public jiu a(int paramInt)
  {
    if (this.jdField_b_of_type_Jiw == null) {
      return null;
    }
    return this.jdField_b_of_type_Jiw.b(paramInt);
  }
  
  public void a(e parame)
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel$e = parame;
  }
  
  @TargetApi(11)
  public void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool2 = true;
    QLog.d(this.TAG, 1, "doSpeakerStatusChange from:=" + paramString + ";lastStatus:=" + paramInt1 + ";nextStatus:=" + paramInt2);
    if ((paramInt2 == paramInt1) || (!this.XG)) {
      return;
    }
    boolean bool1;
    switch (paramInt2)
    {
    default: 
      bool1 = false;
    case 0: 
      while ((this.jdField_a_of_type_ComTencentAvUiQavPanel$e != null) && (this.mApp != null) && (paramBoolean) && (wt()))
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel$e.K(this.mApp.b().b().PV, bool1);
        return;
        if (paramInt1 == 2) {
          auf();
        }
        ar("doSpeakerStatusChange KEEP_SPEAKING_STATUS", 2);
        this.c.setColor(1291845632);
        this.jdField_a_of_type_Jku.setAlpha(255);
        this.jdField_a_of_type_Jku.nN(0);
        bool1 = bool2;
        if (!jll.L(true))
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel$a.removeMessages(259);
          this.jdField_a_of_type_ComTencentAvUiQavPanel$a.sendEmptyMessageAtTime(259, 300L);
          bool1 = bool2;
        }
      }
    case 1: 
      if (paramInt1 == 0)
      {
        QLog.d(this.TAG, 1, "test has call keep speaking status");
        bool1 = true;
      }
      break;
    }
    for (;;)
    {
      ar("doSpeakerStatusChange KEEP_SPEAKING_STATUS", 2);
      this.jdField_a_of_type_Jku.setAlpha(255);
      this.c.setAlpha(255);
      this.c.setColor(-1);
      this.jdField_a_of_type_Jku.nN(1);
      g(2131373947, getResources().getString(2131694251));
      if ((!this.XI) && (wd()))
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel$a.removeMessages(257);
        this.jdField_a_of_type_ComTencentAvUiQavPanel$a.sendEmptyMessageDelayed(257, 5300L);
      }
      if (!jll.L(false))
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel$a.removeMessages(258);
        this.jdField_a_of_type_ComTencentAvUiQavPanel$a.sendEmptyMessageDelayed(258, 300L);
        break;
        if (paramInt1 == 2)
        {
          auf();
          bool1 = false;
          continue;
        }
        if (paramInt1 != 3) {
          break label505;
        }
        bool1 = true;
        continue;
        this.c.setAlpha(255);
        this.c.setColor(-1);
        this.jdField_a_of_type_Jku.nN(2);
        bool1 = false;
        break;
        this.jdField_a_of_type_Jku.setAlpha(127);
        this.jdField_a_of_type_Jku.nN(3);
        this.c.setAlpha(127);
        this.c.setColor(-1);
        auc();
        this.awV += 1;
        bool1 = bool2;
        break;
      }
      break;
      label505:
      bool1 = false;
    }
  }
  
  public void a(jks paramjks)
  {
    if (this.bt != null)
    {
      paramjks.setView(this.bt);
      paramjks.start();
    }
    while (this.I == null) {
      return;
    }
    paramjks.setView(this.I);
    paramjks.start();
  }
  
  public boolean a(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "setViewAccText, id" + izq.aT(paramInt1) + ", text[" + paramString + "], audioType[" + paramInt2 + "]");
    }
    View localView = v(paramInt1);
    if (localView != null)
    {
      jll.b(localView, paramString, paramInt2);
      return true;
    }
    return false;
  }
  
  public boolean a(d paramd)
  {
    if (this.jdField_a_of_type_Jdd == null) {
      return false;
    }
    this.jdField_a_of_type_Jdd.a(paramd);
    return true;
  }
  
  public boolean a(TraeHelper paramTraeHelper)
  {
    if ((paramTraeHelper != null) && (this.bw != null))
    {
      paramTraeHelper.e(this.bw);
      return true;
    }
    return false;
  }
  
  public void ar(String paramString, int paramInt)
  {
    QLog.d(this.TAG, 1, "pressSpeaking hidePressSpreakingGuiderOrTips, from[" + paramString + "], tipsType[" + paramInt + "]");
    if ((this.ih != null) && ((this.axc == paramInt) || (paramInt == 0))) {
      this.ih.setVisibility(8);
    }
  }
  
  void atR()
  {
    this.bp = ((Button)this.mRootView.findViewById(2131374106));
    if (this.bp != null) {
      AudioHelper.a(getResources(), this.bp, 2130843020, 2131166217, 2131166217);
    }
  }
  
  void atS()
  {
    this.gB = ((ImageView)this.mRootView.findViewById(2131374103));
    this.jdField_a_of_type_Jdd = new jdd(getContext(), this.gB, this.gC, this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView, this.gD);
    if (wq())
    {
      this.gB.setContentDescription(getResources().getString(2131721686));
      this.gB.setFocusable(true);
      this.gB.setClickable(true);
      this.gB.setOnClickListener(new jcv(this));
      return;
    }
    this.gB.setOnTouchListener(this.jdField_a_of_type_Jdd);
  }
  
  void atW()
  {
    Object localObject = getResources().getDisplayMetrics();
    int j = getResources().getDimensionPixelSize(2131298283);
    int m = getResources().getDimensionPixelSize(2131298280);
    int i = 0;
    if (this.awS == 2131559945) {
      i = ((DisplayMetrics)localObject).widthPixels * 880 / 750;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "adjustPanel, heightPixels[" + ((DisplayMetrics)localObject).heightPixels + "], widthPixels[" + ((DisplayMetrics)localObject).widthPixels + "], waveHeight[" + j + "], shadowHeight[" + m + "], videoHeight[" + i + "], mPanelType[" + this.awS + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView != null)
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = j;
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void atX()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.startAnim();
    this.XF = true;
  }
  
  public void atY()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.stopAnim();
    this.XF = false;
  }
  
  public void atZ()
  {
    jbz localjbz = this.jdField_a_of_type_ArrayOfJbz[1];
    if (localjbz == null) {}
    while ((!localjbz.isShow) || (!(localjbz.eg instanceof QavOperationMenuView))) {
      return;
    }
    ((QavOperationMenuView)localjbz.eg).refreshUI();
  }
  
  void aua()
  {
    this.mU = ((TextView)this.mRootView.findViewById(2131364460));
    if (this.mU != null) {
      this.mU.setTextColor(getResources().getColor(2131166301));
    }
  }
  
  public void auc()
  {
    if ((this.ih != null) && (wd()))
    {
      this.axc = 2;
      this.ih.setVisibility(0);
      this.gF.getBackground().setAlpha(127);
      this.gF.setVisibility(0);
      this.gE.getBackground().setAlpha(127);
      this.gE.setVisibility(0);
      this.mV.setVisibility(8);
    }
  }
  
  public void aug()
  {
    if ((this.ek != null) && (this.ej != null))
    {
      this.ek.setVisibility(0);
      this.ek.clearAnimation();
      this.ej.clearAnimation();
      this.ej.setVisibility(4);
    }
  }
  
  void auh()
  {
    if (this.jdField_b_of_type_Jiw != null) {
      return;
    }
    this.jdField_b_of_type_Jiw = jiv.a(getResources(), this.awS);
  }
  
  jbz b()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.mRootView.findViewById(2131373926);
    if (localRelativeLayout != null)
    {
      if (AudioHelper.jY(0) == 1) {
        localRelativeLayout.setBackgroundColor(2142236398);
      }
      return new jbz(localRelativeLayout, 0, null);
    }
    return null;
  }
  
  public void b(Animation.AnimationListener paramAnimationListener)
  {
    if ((this.ek != null) && (this.ej != null))
    {
      AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation1.setFillEnabled(true);
      localAlphaAnimation1.setFillAfter(true);
      localAlphaAnimation1.setDuration(400L);
      AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation2.setFillEnabled(true);
      localAlphaAnimation2.setFillAfter(true);
      localAlphaAnimation2.setDuration(400L);
      localAlphaAnimation2.setAnimationListener(paramAnimationListener);
      this.ej.startAnimation(localAlphaAnimation1);
      this.ek.startAnimation(localAlphaAnimation2);
    }
  }
  
  jbz c()
  {
    jbz localjbz = a(1, new iyb(null));
    if ((localjbz != null) && ((localjbz.eg instanceof QavOperationMenuView)))
    {
      QavOperationMenuView localQavOperationMenuView = (QavOperationMenuView)localjbz.eg;
      localQavOperationMenuView.setViewController(this.jdField_b_of_type_Jiw);
      localQavOperationMenuView.setQavMenuActionListener(new jdc(this));
    }
    return localjbz;
  }
  
  public void c(long paramLong, int paramInt, boolean paramBoolean)
  {
    int j = 3;
    if (!(getContext() instanceof AVActivity)) {
      return;
    }
    jbz localjbz = a();
    label137:
    int m;
    label154:
    int i;
    boolean bool1;
    if (localjbz != null)
    {
      if (localjbz.awN == paramInt)
      {
        QLog.w(this.TAG, 1, "showMenu direct, menuType[" + paramInt + "], needAnimation[" + paramBoolean + "], seq[" + paramLong + "]");
        localjbz.h(paramLong, paramBoolean, 3);
        this.mApp.l(new Object[] { Integer.valueOf(123), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        return;
      }
      mO(paramInt);
      if (this.jdField_a_of_type_ArrayOfJbz[paramInt] == null) {
        break label361;
      }
      if (localjbz != null) {
        break label363;
      }
      m = -1;
      if (m != 0) {
        break label373;
      }
      i = -1;
      bool1 = false;
    }
    for (;;)
    {
      label165:
      Object localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder().append("showMenu, MenuType[").append(m).append("->").append(paramInt).append("], seq[").append(paramLong).append("], isVisible[");
      boolean bool2;
      if (getVisibility() == 0)
      {
        bool2 = true;
        label227:
        QLog.w((String)localObject, 1, bool2 + "]");
        this.awU = paramInt;
        if ((m != this.awU) && (m == 0))
        {
          ar("showMenu", 0);
          this.jdField_a_of_type_ComTencentAvUiQavPanel$a.removeMessages(257);
        }
        localObject = new QavPanel.7(this, paramInt, paramLong, paramBoolean, j);
        if (getVisibility() == 0) {
          break label477;
        }
      }
      label477:
      for (paramBoolean = false;; paramBoolean = bool1)
      {
        if (localjbz != null) {
          localjbz.a(paramLong, paramBoolean, i, new jdb(this, (Runnable)localObject));
        }
        if ((localjbz != null) && (paramBoolean)) {
          break;
        }
        ((Runnable)localObject).run();
        return;
        mO(paramInt);
        break label137;
        label361:
        break;
        label363:
        m = localjbz.getKey();
        break label154;
        label373:
        if (m == 1)
        {
          if ((paramInt == 2) || (paramInt == 3))
          {
            i = 2;
            bool1 = true;
            break label165;
          }
          if (paramInt != 0) {
            break label484;
          }
          j = 4;
          i = 2;
          bool1 = true;
          break label165;
        }
        if (m == -1)
        {
          i = -1;
          bool1 = false;
          break label165;
        }
        if ((m != 2) && (m != 3)) {
          break label484;
        }
        if (paramInt == 0)
        {
          j = 4;
          i = 2;
          bool1 = true;
          break label165;
        }
        if (paramInt != 1) {
          break label484;
        }
        i = 2;
        bool1 = true;
        break label165;
        bool2 = false;
        break label227;
      }
      label484:
      j = 4;
      bool1 = false;
      i = -1;
    }
  }
  
  public void c(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "videoSession :" + paramBoolean1 + ", localHasVideo:" + paramInt + ", isVipFunCall:" + paramBoolean2);
    }
    kc(paramBoolean1);
    mN(paramInt);
  }
  
  public boolean cA(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "checkView, id" + izq.aT(paramInt));
    }
    return v(paramInt) == null;
  }
  
  public boolean cC(int paramInt)
  {
    return paramInt == this.awU;
  }
  
  public int cy(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "setViewClickable, id" + izq.aT(paramInt));
    }
    View localView = v(paramInt);
    if (localView != null) {
      return localView.getVisibility();
    }
    return -1;
  }
  
  public void dz(long paramLong)
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel$c != null)
    {
      getContext().unregisterReceiver(this.jdField_a_of_type_ComTencentAvUiQavPanel$c);
      this.jdField_a_of_type_ComTencentAvUiQavPanel$c = null;
    }
    this.awT = 0;
    if (this.x != null)
    {
      this.x.cancel();
      this.x = null;
    }
    if (this.XG)
    {
      anot.a(null, "dc00898", "", "", "0X800ADE2", "0X800ADE2", this.awV, 0, "", "", "", "");
      this.awV = 0;
    }
    this.cd = null;
    while (i < this.jdField_a_of_type_ArrayOfJbz.length)
    {
      if ((this.jdField_a_of_type_ArrayOfJbz[i] != null) && ((this.jdField_a_of_type_ArrayOfJbz[i].eg instanceof QavMenuBaseView))) {
        ((QavMenuBaseView)this.jdField_a_of_type_ArrayOfJbz[i].eg).onDestroy(paramLong);
      }
      this.jdField_a_of_type_ArrayOfJbz[i] = null;
      i += 1;
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView != null) {
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.destory();
    }
    auf();
    if (this.mApp != null) {
      this.mApp = null;
    }
  }
  
  public boolean f(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "setViewMargin, id" + izq.aT(paramInt1) + ", direction[" + paramInt2 + "], margin[" + paramInt3 + "]");
    }
    if (paramInt3 < 0) {
      return false;
    }
    View localView = v(paramInt1);
    if (localView == null) {
      return false;
    }
    try
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      if (localLayoutParams == null) {
        return false;
      }
      if (paramInt2 == 1) {
        localLayoutParams.leftMargin = paramInt3;
      }
      for (;;)
      {
        localView.setLayoutParams(localLayoutParams);
        return true;
        if (paramInt2 == 2) {
          localLayoutParams.rightMargin = paramInt3;
        } else if (paramInt2 == 4) {
          localLayoutParams.bottomMargin = paramInt3;
        } else if (paramInt2 == 3) {
          localLayoutParams.topMargin = paramInt3;
        }
      }
      return false;
    }
    catch (Exception localException) {}
  }
  
  public void g(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.XD) {
      return;
    }
    atT();
    int i = getResources().getDimensionPixelSize(2131298310);
    this.awS = paramInt;
    atV();
    u(this.awS);
    switch (this.awS)
    {
    case 2131559949: 
    default: 
      label92:
      if (this.mRootView != null)
      {
        addView(this.mRootView);
        c(-1020L, 0, false);
      }
      auh();
      Object localObject = (RelativeLayout)findViewById(2131382130);
      if (localObject != null)
      {
        ((RelativeLayout)localObject).addView(this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView);
        ((RelativeLayout)localObject).bringChildToFront(this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView);
      }
      atW();
      this.jdField_a_of_type_ComTencentAvUiQavPanel$c = new c();
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
      ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
      getContext().registerReceiver(this.jdField_a_of_type_ComTencentAvUiQavPanel$c, (IntentFilter)localObject);
      this.XD = true;
      setBtnOnTouchListener(this.k);
      aua();
      mL(this.awS);
      kc(paramBoolean1);
      if (!paramBoolean2) {
        break;
      }
    }
    for (paramInt = 2;; paramInt = 1)
    {
      mN(paramInt);
      setBackgroundColor(33554431);
      if (AudioHelper.jY(0) != 1) {
        break;
      }
      if (this.bw != null) {
        this.bw.setBackgroundColor(Color.argb(255, 68, 128, 2));
      }
      setBackgroundColor(-545259606);
      if (this.ig == null) {
        break;
      }
      this.ig.setBackgroundColor(2145129532);
      return;
      mH(i);
      break label92;
      mI(i);
      break label92;
      mJ(i);
      break label92;
      f(i, paramBoolean1, paramBoolean2);
      break label92;
      jY(paramBoolean2);
      break label92;
      jZ(paramBoolean2);
      break label92;
      atU();
      break label92;
    }
  }
  
  public boolean g(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "setViewRule, id" + izq.aT(paramInt1) + ", verb[" + paramInt2 + "], anchor[" + paramInt3 + "]");
    }
    View localView = v(paramInt1);
    if (localView != null) {
      try
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
        localLayoutParams.addRule(paramInt2, paramInt3);
        localView.setLayoutParams(localLayoutParams);
        return true;
      }
      catch (Exception localException)
      {
        return false;
      }
    }
    return false;
  }
  
  public boolean g(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "setViewAccText, id" + izq.aT(paramInt) + ", text[" + paramString + "]");
    }
    View localView = v(paramInt);
    if (localView != null)
    {
      jll.b(localView, paramString);
      return true;
    }
    return false;
  }
  
  public boolean h(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "setViewSelected, id" + izq.aT(paramInt) + ", selected[" + paramBoolean + "]");
    }
    View localView = v(paramInt);
    if (localView != null)
    {
      localView.setSelected(paramBoolean);
      return true;
    }
    return false;
  }
  
  public boolean i(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "setViewClickable, id" + izq.aT(paramInt));
    }
    View localView = v(paramInt);
    if (localView != null)
    {
      localView.setClickable(paramBoolean);
      return true;
    }
    return false;
  }
  
  void init() {}
  
  public boolean isPressed()
  {
    return (super.isPressed()) || ((this.ig != null) && (this.ig.isPressed())) || ((this.bv != null) && (this.bv.isPressed())) || ((this.bw != null) && (this.bw.isPressed()));
  }
  
  public void ka(boolean paramBoolean)
  {
    kc(paramBoolean);
  }
  
  public void kb(boolean paramBoolean)
  {
    if (this.mApp == null) {}
    label239:
    do
    {
      return;
      if ((wt()) || (this.mApp.b().kB() == 1) || (this.mApp.b().kB() == 0)) {}
      for (boolean bool = true;; bool = false)
      {
        QLog.d(this.TAG, 1, "refreshButtonStatus, from[1], mute[" + paramBoolean + "], canRefresh[" + bool + "]");
        if ((!this.XG) || (!bool)) {
          break;
        }
        if (!paramBoolean) {
          break label239;
        }
        this.jdField_a_of_type_Jku.setAlpha(255);
        this.c.setAlpha(255);
        this.c.setColor(-1);
        this.jdField_a_of_type_Jku.nN(1);
        g(2131373947, getResources().getString(2131694251));
        if ((!this.XI) && (this.jdField_a_of_type_ComTencentAvUiQavPanel$a != null) && (wd()))
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel$a.removeMessages(257);
          this.jdField_a_of_type_ComTencentAvUiQavPanel$a.sendEmptyMessageDelayed(257, 5300L);
        }
        if (jll.L(false)) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvUiQavPanel$a.removeMessages(258);
        this.jdField_a_of_type_ComTencentAvUiQavPanel$a.sendEmptyMessageDelayed(258, 300L);
        return;
      }
      this.jdField_a_of_type_Jku.setAlpha(255);
      this.c.setAlpha(255);
      this.c.setColor(1291845632);
      this.jdField_a_of_type_Jku.nN(0);
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel$a != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel$a.removeMessages(257);
      }
    } while (jll.L(true));
    this.jdField_a_of_type_ComTencentAvUiQavPanel$a.removeMessages(259);
    this.jdField_a_of_type_ComTencentAvUiQavPanel$a.sendEmptyMessageDelayed(259, 300L);
  }
  
  void kc(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView != null)) {
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(8);
    }
    kd(paramBoolean);
  }
  
  public void kd(boolean paramBoolean)
  {
    if (this.id == null) {}
    for (;;)
    {
      return;
      if (paramBoolean) {
        this.id.setVisibility(0);
      }
      while (AudioHelper.jY(0) == 1)
      {
        this.id.setBackgroundColor(-536894208);
        return;
        this.id.setVisibility(8);
      }
    }
  }
  
  public void ke(String paramString)
  {
    QLog.d(this.TAG, 1, "pressSpeaking showPressSpeakingGuider, from[1], text[" + paramString + "], mVoiceGuiderRootContent[" + this.ih + "]");
    if (this.ih != null)
    {
      this.axc = 1;
      this.ih.setVisibility(0);
      this.gF.getBackground().setAlpha(255);
      this.gF.setVisibility(0);
      this.mV.setText(paramString);
      this.mV.setVisibility(0);
      this.gE.setVisibility(8);
    }
  }
  
  void l(View.OnClickListener paramOnClickListener)
  {
    this.cd = paramOnClickListener;
  }
  
  public int lZ()
  {
    iiv localiiv = this.mApp.b().b();
    if (this.awS == 2131559945) {
      return localiiv.kJ();
    }
    return this.mApp.b().kB();
  }
  
  public void mG(int paramInt)
  {
    g(paramInt, false, false);
  }
  
  public void mK(int paramInt)
  {
    if (this.jdField_b_of_type_Jiw == null) {
      return;
    }
    jiw localjiw = this.jdField_b_of_type_Jiw;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localjiw.kV(bool);
      return;
    }
  }
  
  public void mN(int paramInt)
  {
    J(paramInt, false);
  }
  
  void mO(int paramInt)
  {
    jbz localjbz = null;
    if (this.jdField_a_of_type_ArrayOfJbz[paramInt] != null) {
      return;
    }
    if (paramInt == 1) {
      localjbz = c();
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfJbz[paramInt] = localjbz;
      return;
      if (paramInt == 0) {
        localjbz = b();
      } else if (paramInt == 2) {
        localjbz = a(2, new iyb(null));
      } else if (paramInt == 3) {
        localjbz = a(3, new iyb("0X800A567"));
      } else if (paramInt == 4) {
        localjbz = a(4, new iyb(null));
      }
    }
  }
  
  public void setAcceptDrawableTop(Drawable paramDrawable)
  {
    if (this.bn == null) {
      return;
    }
    this.bn.setCompoundDrawablesWithIntrinsicBounds(null, paramDrawable, null, null);
  }
  
  public void setAudioVolumeValue(int paramInt)
  {
    if ((this.bv == null) || ((this.bv != null) && (!this.bv.isShown()))) {
      return;
    }
    int i = this.awT;
    this.awT = paramInt;
    if (this.awT != i)
    {
      if ((this.x == null) || (!this.x.isRunning())) {
        break label222;
      }
      paramInt = ((Integer)this.x.getAnimatedValue()).intValue();
      this.x.cancel();
      i = paramInt;
    }
    for (;;)
    {
      if (this.x == null)
      {
        this.x = new ValueAnimator();
        this.x.addUpdateListener(new jcy(this));
      }
      int j;
      ValueAnimator localValueAnimator;
      long l;
      if (this.awT > i)
      {
        j = 1;
        localValueAnimator = this.x;
        if (j == 0) {
          break label192;
        }
        l = 100L;
        label141:
        localValueAnimator.setDuration(l);
        localValueAnimator = this.x;
        if (paramInt != -1) {
          break label200;
        }
      }
      for (;;)
      {
        localValueAnimator.setIntValues(new int[] { i, this.awT });
        this.x.start();
        return;
        j = 0;
        break;
        label192:
        l = 200L;
        break label141;
        label200:
        i = paramInt;
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable == null) {
        break;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable.setLevel(paramInt);
      return;
      label222:
      paramInt = -1;
    }
  }
  
  public void setBtnOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.k = paramOnTouchListener;
    if (this.bv != null) {
      this.bv.setOnTouchListener(paramOnTouchListener);
    }
    if (this.bw != null) {
      this.bw.setOnTouchListener(paramOnTouchListener);
    }
  }
  
  public void setEffectOperateDrawable(Drawable paramDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "setEffectOperateDrawable");
    }
    this.cf = paramDrawable;
  }
  
  public void setNoVideoAndShareBtnMode()
  {
    if (this.jdField_b_of_type_Jiw != null)
    {
      this.jdField_b_of_type_Jiw.nE(2131697526);
      this.jdField_b_of_type_Jiw.nE(2131697530);
      this.jdField_b_of_type_Jiw.nE(2131697532);
    }
  }
  
  public void setViewEnable(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "setViewEnable, id" + izq.aT(paramInt) + ", enable[" + paramBoolean + "]");
    }
    View localView = v(paramInt);
    if (localView != null) {
      localView.setEnabled(paramBoolean);
    }
  }
  
  public void setViewVisibility(int paramInt1, int paramInt2)
  {
    View localView = v(paramInt1);
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = this.TAG;
      localStringBuilder = new StringBuilder().append("setViewVisibility, id").append(izq.aT(paramInt1)).append("], view[");
      if (localView == null) {
        break label97;
      }
    }
    label97:
    for (boolean bool = true;; bool = false)
    {
      QLog.d(str, 2, bool + "], visibility[" + paramInt2 + "]");
      if (localView != null) {
        localView.setVisibility(paramInt2);
      }
      return;
    }
  }
  
  public void setWaveVisibility(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "timWaveView setWaveVisibility visibility:" + paramInt);
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(paramInt);
  }
  
  View u(int paramInt)
  {
    this.mRootView = LayoutInflater.from(getContext()).inflate(paramInt, this, false);
    return this.mRootView;
  }
  
  public View v(int paramInt)
  {
    Button localButton = null;
    switch (paramInt)
    {
    default: 
      String str = acfp.m(2131710352) + paramInt + "]，Name[" + izq.aT(paramInt) + "]，Name[" + AudioHelper.b(this, paramInt);
      QLog.d(this.TAG, 1, str);
      if (AudioHelper.isDev()) {
        throw new IllegalArgumentException(str);
      }
    case 2131373947: 
      localButton = this.bv;
      return localButton;
    case 2131364460: 
      return this.mU;
    case 2131363158: 
      return this.bn;
    case 2131374106: 
      return this.bp;
    case 2131374107: 
      return this.bq;
    case 2131363170: 
      return this.bo;
    case 2131373933: 
      return this.bx;
    case 2131373939: 
      return this.bw;
    case 2131373941: 
      return this.I;
    case 2131373942: 
      return this.bt;
    case 2131373944: 
      return this.jdField_if;
    case 2131374102: 
      return this.ie;
    case 2131363169: 
      return this.br;
    case 2131373946: 
      return this.by;
    case 2131374103: 
      return this.gB;
    case 2131373950: 
      return this.T;
    case 2131373949: 
      return this.bu;
    case 2131374249: 
      return this.ig;
    }
    return this.J;
  }
  
  public boolean wr()
  {
    return this.XG;
  }
  
  public boolean ws()
  {
    if (wt())
    {
      localiiv = this.mApp.b().b();
      if ((!this.XG) || (localiiv.kJ() == 3) || (this.XH)) {}
    }
    while ((this.XG) && (this.mApp.b().kB() != 3) && (!this.XH))
    {
      iiv localiiv;
      return true;
      return false;
    }
    return false;
  }
  
  public void x(boolean paramBoolean, int paramInt)
  {
    if (paramInt == 2) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      kc(paramBoolean);
      mN(paramInt);
      return;
    }
  }
  
  public void y(boolean paramBoolean, int paramInt)
  {
    if (paramInt == 2) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      kc(paramBoolean);
      mN(paramInt);
      return;
    }
  }
  
  public void z(boolean paramBoolean, int paramInt)
  {
    if ((this.T != null) && (paramBoolean))
    {
      this.T.setVisibility(0);
      if (this.bu != null)
      {
        this.bu.setClickable(false);
        this.bu.setEnabled(false);
      }
    }
  }
  
  public class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        do
        {
          do
          {
            return;
            QavPanel.b(QavPanel.this);
            return;
            QavPanel.c(QavPanel.this);
            return;
          } while ((jll.L(false)) || (QavPanel.this.bv == null) || (!QavPanel.this.bv.isShown()));
          QavPanel.this.ke(QavPanel.this.getResources().getString(2131694252));
          jll.ll(false);
          QavPanel.a(QavPanel.this).auj();
          QavPanel.a(QavPanel.this).sendEmptyMessageDelayed(260, 5000L);
          return;
        } while ((jll.L(true)) || (QavPanel.this.bv == null) || (!QavPanel.this.bv.isShown()) || (!QavPanel.a(QavPanel.this).wu()));
        QavPanel.this.ke(QavPanel.this.getResources().getString(2131694253));
        QavPanel.a(QavPanel.this).auj();
        QavPanel.a(QavPanel.this).sendEmptyMessageDelayed(260, 5000L);
        jll.ll(true);
        return;
        QavPanel.this.ar("MSG_TRY_CLEAN_TIPS", 1);
        return;
      } while (QavPanel.a(QavPanel.this) == null);
      QavPanel.a(QavPanel.this).auj();
      QavPanel.a(QavPanel.this).sendEmptyMessageDelayed(261, 4000L);
    }
  }
  
  public static abstract interface b
  {
    public abstract void aui();
  }
  
  class c
    extends BroadcastReceiver
  {
    c() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
      do
      {
        do
        {
          return;
          if (!"android.intent.action.SCREEN_ON".equals(paramIntent.getAction())) {
            break;
          }
        } while ((QavPanel.this.a == null) || (!QavPanel.this.XF) || (QavPanel.this.a.getVisibility() != 0));
        QavPanel.this.a.startAnim();
        return;
      } while ((!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction())) || (QavPanel.this.a == null));
      QavPanel.this.a.stopAnim();
    }
  }
  
  public static abstract interface d
  {
    public abstract void iB(boolean paramBoolean);
  }
  
  public static abstract interface e
  {
    public abstract void K(boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract void auj();
    
    public abstract long bO();
    
    public abstract boolean wd();
    
    public abstract boolean wu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.QavPanel
 * JD-Core Version:    0.7.0.1
 */