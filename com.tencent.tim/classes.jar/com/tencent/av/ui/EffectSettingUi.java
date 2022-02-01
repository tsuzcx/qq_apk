package com.tencent.av.ui;

import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anhs;
import anon;
import anot;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.doodle.DoodleToolbar;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import igd;
import iiv;
import ikx;
import ina;
import iop;
import iow;
import irk;
import iti;
import ixo;
import iyr;
import iyu;
import iyv;
import iyw;
import iyx;
import iyy;
import java.lang.ref.WeakReference;
import jhr.a;
import jht;
import jht.a;
import jij;
import jik;
import jll;
import wja;

public class EffectSettingUi
  extends QavMenuBaseView
{
  SparseArray<BaseToolbar> V = new SparseArray();
  boolean Wp = false;
  public iyr a;
  public jht.a a;
  public int avL = -1;
  Runnable bS = null;
  private View.OnClickListener bZ = new iyu(this);
  LinearLayout cZ = null;
  RelativeLayout ea = null;
  RelativeLayout eb;
  RelativeLayout ec;
  public WeakReference<AVActivity> mContext = null;
  
  public EffectSettingUi(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Jht$a = null;
    this.TAG = ("EffectSettingUi" + AudioHelper.hG());
    if ((paramContext instanceof AVActivity)) {
      this.mContext = new WeakReference((AVActivity)paramContext);
    }
    setId(2131368767);
  }
  
  private int J(int paramInt1, int paramInt2)
  {
    BaseToolbar localBaseToolbar = (BaseToolbar)this.V.get(paramInt1);
    if ((localBaseToolbar != null) && (localBaseToolbar.isAvailable()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d(this.TAG, 4, String.format("checkAbility 期望的按钮可用, effectBtnID[%s]", new Object[] { Integer.valueOf(paramInt1) }));
      }
      jF(true);
      return paramInt1;
    }
    paramInt1 = cw(paramInt2);
    if ((BaseToolbar)this.V.get(paramInt1) != null)
    {
      jF(true);
      return paramInt1;
    }
    jF(false);
    return paramInt1;
  }
  
  private boolean M(int paramInt1, int paramInt2)
  {
    int i = J(paramInt1, paramInt2);
    BaseToolbar localBaseToolbar = (BaseToolbar)this.V.get(i);
    if (localBaseToolbar != null) {
      localBaseToolbar.performClick();
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.TAG, 1, "reSelectBtn, effectBtnID[" + paramInt1 + "], ignoreID[" + paramInt2 + "], selectid[" + i + "], ret[" + bool + "]");
      }
      return bool;
    }
  }
  
  private BaseToolbar a(boolean paramBoolean, Class<? extends BaseToolbar> paramClass)
  {
    paramClass = BaseToolbar.createToolbar(this.mApp, (AVActivity)this.mContext.get(), paramClass);
    paramClass.initBtn(this.cZ, paramBoolean, this.bZ);
    this.V.put(paramClass.getEffectBtnId(), paramClass);
    paramClass.updateBtnStatus();
    return paramClass;
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, long paramLong)
  {
    if (paramVideoAppInterface != null) {
      paramVideoAppInterface.l(new Object[] { Integer.valueOf(125), Long.valueOf(paramLong) });
    }
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, boolean paramBoolean)
  {
    paramVideoAppInterface = paramVideoAppInterface.b();
    if (paramVideoAppInterface != null)
    {
      int i = paramVideoAppInterface.b().amI;
      int j = paramVideoAppInterface.b().relationType;
      boolean bool = paramVideoAppInterface.b().PY;
      if (3 == j) {
        return (!paramBoolean) || ((i == 2) && (bool));
      }
    }
    return false;
  }
  
  public static boolean a(AVActivity paramAVActivity)
  {
    boolean bool2 = false;
    paramAVActivity = paramAVActivity.a;
    boolean bool1 = bool2;
    if (paramAVActivity != null)
    {
      int i = paramAVActivity.b().amI;
      bool1 = bool2;
      if (2 == paramAVActivity.b().relationType)
      {
        bool1 = bool2;
        if (i == 4) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void asH()
  {
    if (!a(this.mApp, false)) {}
    do
    {
      do
      {
        return;
      } while ((!jik.isDeviceSupport()) || ((BaseToolbar)this.V.get(7) != null));
      asG();
      jhr.a locala = jik.a(this.mApp).a();
      if ((locala != null) && (locala.Zo))
      {
        asI();
        return;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d(this.TAG, 4, "先不创建红包固定按钮");
  }
  
  private void asJ()
  {
    HorizontalScrollView localHorizontalScrollView = (HorizontalScrollView)this.ea.findViewById(2131368634);
    ViewTreeObserver localViewTreeObserver = localHorizontalScrollView.getViewTreeObserver();
    localViewTreeObserver.addOnGlobalLayoutListener(new iyw(this, localViewTreeObserver, localHorizontalScrollView));
  }
  
  private void asL()
  {
    Button localButton = (Button)this.ea.findViewById(2131373922);
    localButton.setOnClickListener(new iyx(this));
    if (AudioHelper.jY(0) == 1) {
      localButton.setBackgroundColor(Color.argb(100, 0, 0, 0));
    }
  }
  
  public static boolean b(AVActivity paramAVActivity)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    paramAVActivity = paramAVActivity.a;
    boolean bool1 = bool3;
    if (paramAVActivity != null)
    {
      int i = paramAVActivity.b().amI;
      bool1 = bool3;
      if (1 == paramAVActivity.b().relationType) {
        if (i != 4) {
          break label48;
        }
      }
    }
    label48:
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  private void dh(long paramLong)
  {
    boolean bool1 = true;
    boolean bool2 = a(this.mApp, true);
    boolean bool3 = ikx.b(this.mApp);
    if (iop.uR()) {
      iop.g(this.mApp);
    }
    igd.aJ(this.TAG, "initBtn:" + bool2 + "|" + bool3);
    boolean bool4 = ZimuToolbar.isShow(this.mApp);
    a(bool3, EffectToolbar.class);
    a(bool2, FaceToolbar.class);
    a(bool2, DoodleToolbar.class);
    a(true, BeautyToolbar.class);
    a(true, VoiceChangeToolbar.class);
    int i;
    if ((bool2) && (bool4))
    {
      a(bool1, ZimuToolbar.class);
      i = 0;
    }
    for (;;)
    {
      if (i < this.V.size())
      {
        if (!(this.V.valueAt(i) instanceof FaceToolbar)) {
          break label369;
        }
        if (((BaseToolbar)this.V.valueAt(i)).mEffectBtnRedTouch == null)
        {
          ((BaseToolbar)this.V.valueAt(i)).mEffectBtnRedTouch = iti.a(this.mApp, ((BaseToolbar)this.V.valueAt(i)).mEffectBtn, 3);
          if (((BaseToolbar)this.V.valueAt(i)).mEffectBtnRedTouch != null)
          {
            int j = (int)jll.a(getContext(), ((BaseToolbar)this.V.valueAt(i)).mEffectBtn.getPaddingRight());
            int k = (int)jll.a(getContext(), ((BaseToolbar)this.V.valueAt(i)).mEffectBtn.getPaddingTop());
            ((BaseToolbar)this.V.valueAt(i)).mEffectBtnRedTouch.a(0, j, k, 0).a();
          }
        }
      }
      VideoController localVideoController = this.mApp.b();
      if (localVideoController != null) {
        setSelectedBtn(localVideoController.b().ans);
      }
      asK();
      return;
      bool1 = false;
      break;
      label369:
      i += 1;
    }
  }
  
  private void jF(boolean paramBoolean)
  {
    this.Wp = paramBoolean;
  }
  
  public void F(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "updateBtnStatus, reselect[" + paramBoolean + "], mCurSelectedId[" + this.avL + "], isShown[" + isShown() + "], seq[" + paramLong + "]");
    }
    int i = 0;
    while (i < this.V.size())
    {
      ((BaseToolbar)this.V.valueAt(i)).updateBtnStatus();
      i += 1;
    }
    if (paramBoolean)
    {
      BaseToolbar localBaseToolbar = (BaseToolbar)this.V.get(this.avL);
      if (localBaseToolbar != null) {
        localBaseToolbar.hideToolbar(paramLong);
      }
      setCurSelectedId(-1, "updateBtnStatus");
    }
    if (isShown()) {
      M(this.avL, -1);
    }
  }
  
  public void G(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Iyr != null) {
      this.jdField_a_of_type_Iyr.asD();
    }
    this.mApp.l(new Object[] { Integer.valueOf(6105), Integer.valueOf(100), Long.valueOf(paramLong) });
  }
  
  void I(int paramInt, boolean paramBoolean)
  {
    BaseToolbar localBaseToolbar = (BaseToolbar)this.V.get(paramInt);
    if (localBaseToolbar != null) {
      localBaseToolbar.setEffectBtnVisibility(paramBoolean);
    }
  }
  
  public void a(QavPanel paramQavPanel)
  {
    super.a(paramQavPanel);
    di(-1013L);
  }
  
  void a(Boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.ea != null)
    {
      if (paramBoolean.booleanValue()) {
        this.ea.setBackgroundColor(paramInt1);
      }
    }
    else {
      return;
    }
    this.ea.setBackgroundResource(paramInt2);
  }
  
  public boolean a(long paramLong, int paramInt, boolean paramBoolean)
  {
    int j = 1;
    a(this.mApp, paramLong);
    BaseToolbar localBaseToolbar = (BaseToolbar)this.V.get(paramInt);
    int k = this.avL;
    if (localBaseToolbar != null) {}
    for (boolean bool = localBaseToolbar.tryShowToolbar(paramLong, this.ec, k, paramBoolean);; bool = true)
    {
      QLog.w(this.TAG, 1, "tryShowToolbar, SelectedId[" + k + "->" + paramInt + "], bFromPerformClick[" + paramBoolean + "], showToolbar[" + bool + "], seq[" + paramLong + "]");
      if (bool)
      {
        int i = j;
        Object localObject;
        if (k != paramInt)
        {
          localObject = (BaseToolbar)this.V.get(k);
          setCurSelectedId(paramInt, "tryShowToolbar");
          if ((localObject != null) && (this.avL != k)) {
            ((BaseToolbar)localObject).hideToolbar(paramLong);
          }
          if (this.avL == 7) {
            irk.a().pause(8);
          }
          if (k == 7) {
            irk.a().resume(8);
          }
          ((AVActivity)this.mContext.get()).cP(paramLong);
          localObject = (HorizontalScrollView)this.ea.findViewById(2131368634);
          if (paramInt == 1) {
            i = j;
          }
        }
        else
        {
          if (i > 7) {
            break label443;
          }
          localObject = (BaseToolbar)this.V.get(i);
          if ((localObject != null) && (i != paramInt)) {
            break label320;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          i = j;
          if (paramInt != 7) {
            break;
          }
          ((HorizontalScrollView)localObject).fullScroll(66);
          i = j;
          break;
          label320:
          if (((BaseToolbar)localObject).isAvailable())
          {
            ((BaseToolbar)localObject).hideToolbar(paramLong);
            if (QLog.isColorLevel()) {
              QLog.i(this.TAG, 2, "tryShowToolbar, check fail, id[" + i + "]");
            }
          }
        }
      }
      else if (paramInt == 1)
      {
        if (!a((AVActivity)this.mContext.get())) {
          break label502;
        }
        anon.QU("0X8007F27");
      }
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(this.TAG, 4, String.format("按钮点击失败, lastSelectedId[%s], newSelectId[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt) }));
        }
        label443:
        if (localBaseToolbar != null)
        {
          localBaseToolbar.onButtonClick(k, paramBoolean, bool);
          if ((bool) && ((localBaseToolbar instanceof FaceToolbar)) && (localBaseToolbar.mEffectBtnRedTouch != null))
          {
            iti.a(this.mApp, localBaseToolbar.mEffectBtnRedTouch, 3);
            localBaseToolbar.mEffectBtnRedTouch = null;
          }
        }
        return bool;
        label502:
        if (b((AVActivity)this.mContext.get())) {
          anon.QU("0X8007F2D");
        }
      }
    }
  }
  
  void asG()
  {
    if (this.jdField_a_of_type_Jht$a != null) {
      return;
    }
    this.jdField_a_of_type_Jht$a = new iyv(this);
    if (QLog.isDevelopLevel()) {
      QLog.d(this.TAG, 4, "listenAVRedBagEvent");
    }
    jik.a(this.mApp).b(new WeakReference(this.jdField_a_of_type_Jht$a));
  }
  
  void asI()
  {
    if (this.mApp == null) {}
    do
    {
      do
      {
        return;
      } while (!a(this.mApp, false));
      if (!iow.va())
      {
        QLog.d(this.TAG, 1, "createRedBagBtn, ptu的so没加载成功, soloadedPTV[" + GraphicRenderMgr.soloadedPTV + "], ptuSoVersion[" + GraphicRenderMgr.ptuSoVersion + "]");
        return;
      }
    } while ((BaseToolbar)this.V.get(7) != null);
    if (QLog.isDevelopLevel()) {
      QLog.d(this.TAG, 4, "创建红包入口");
    }
    a(true, RedbagToolbar.class);
    asK();
    jik.a(this.mApp).kz("EffectSettingUi");
  }
  
  public void asK()
  {
    if (this.mContext == null) {}
    Object localObject;
    do
    {
      return;
      localObject = (AVActivity)this.mContext.get();
    } while ((localObject == null) || (this.cZ == null));
    Resources localResources = ((AVActivity)localObject).getResources();
    HorizontalScrollView localHorizontalScrollView = (HorizontalScrollView)this.ea.findViewById(2131368634);
    if (localHorizontalScrollView.getTag() == null)
    {
      QLog.w(this.TAG, 1, "adjustScrollView, 等待onGlobalLayout");
      return;
    }
    int j = ((AVActivity)localObject).getWindow().getDecorView().getWidth() - wja.dp2px(60.0F, localResources);
    if (j == 0)
    {
      QLog.w(this.TAG, 1, "adjustScrollView, window没有高度");
      return;
    }
    int k = this.cZ.getMeasuredWidth();
    if (k < j)
    {
      QLog.w(this.TAG, 1, "adjustScrollView, 无需处理2, winShowW[" + j + "], btnsW[" + k + "]");
      return;
    }
    int m = (int)localResources.getDimension(2131298121);
    int n = k - j;
    if (n < m / 2)
    {
      QLog.w(this.TAG, 1, "adjustScrollView, 无需处理3, hideW[" + n + "], halfBtnW[" + m / 2 + "]");
      return;
    }
    int i1 = n % m;
    int i2 = n / m;
    int i = m / 2 - i1;
    if (i2 > 0) {
      if (i1 >= m / 2) {
        break label418;
      }
    }
    label418:
    for (i = m / 2 - i1;; i = m / 2 + m - i1)
    {
      QLog.w(this.TAG, 1, "adjustScrollView, winW[" + ((AVActivity)localObject).getWindow().getDecorView().getWidth() + "], winShowW[" + j + "], btnsW[" + k + "], qav_effect_btn_width[" + m + "], hideW[" + n + "], oneHideW[" + i1 + "], move[" + i + "]");
      localObject = (RelativeLayout.LayoutParams)localHorizontalScrollView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(i, 0, 0, 0);
      localHorizontalScrollView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
  }
  
  void asM()
  {
    int i;
    if (AudioHelper.jY(3) == 1)
    {
      AudioHelper.UA(acfp.m(2131705763));
      i = 100;
      if ((i < 105) && ((BaseToolbar)this.V.get(i) == null)) {}
    }
    else
    {
      return;
    }
    Object localObject = a(true, RedbagToolbar.class);
    ((BaseToolbar)localObject).updateBtnStatus();
    if (AudioHelper.jY(0) == 1)
    {
      localObject = ((BaseToolbar)localObject).mEffectBtn;
      if (i % 2 != 0) {
        break label89;
      }
    }
    label89:
    for (int j = -65536;; j = -16711936)
    {
      ((Button)localObject).setBackgroundColor(j);
      i += 1;
      break;
    }
  }
  
  void asN()
  {
    if (!this.mApp.b().b().PY)
    {
      I(5, true);
      I(3, false);
      I(2, false);
      I(6, false);
      I(7, false);
      I(1, false);
      I(4, false);
      return;
    }
    BaseToolbar localBaseToolbar = (BaseToolbar)this.V.get(1);
    if (localBaseToolbar != null) {
      localBaseToolbar.updateBtnStatus();
    }
    I(1, true);
    I(5, true);
    I(4, true);
    boolean bool1 = ZimuToolbar.isShow(this.mApp);
    boolean bool2 = a(this.mApp, true);
    I(3, bool2);
    I(2, bool2);
    if ((bool1) && (bool2)) {}
    for (bool1 = true;; bool1 = false)
    {
      I(6, bool1);
      I(7, bool2);
      return;
    }
  }
  
  public long bL()
  {
    if ((this.mApp == null) || (this.mApp.b() == null)) {
      return 0L;
    }
    return this.mApp.b().by();
  }
  
  boolean cu(int paramInt)
  {
    return (this.avL == paramInt) && (isShown());
  }
  
  int cw(int paramInt)
  {
    int i = 0;
    while (i < this.V.size())
    {
      BaseToolbar localBaseToolbar = (BaseToolbar)this.V.valueAt(i);
      if ((localBaseToolbar != null) && (localBaseToolbar.getEffectBtnId() != paramInt) && (localBaseToolbar.isAvailable())) {
        return localBaseToolbar.getEffectBtnId();
      }
      i += 1;
    }
    return -1;
  }
  
  void di(long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.TAG, 1, "initUI, seq[" + paramLong + "]");
    }
    setGravity(80);
    this.ea = ((RelativeLayout)((AVActivity)this.mContext.get()).getLayoutInflater().inflate(2131559897, this).findViewById(2131373981));
    this.ea.setOnTouchListener(new iyy(this));
    ViewGroup localViewGroup = (ViewGroup)getParent();
    this.ec = ((RelativeLayout)this.ea.findViewById(2131374254));
    this.eb = ((RelativeLayout)findViewById(2131373985));
    this.cZ = ((LinearLayout)this.eb.findViewById(2131370507));
    this.mApp.V(0, null);
    this.mApp.V(1, null);
    this.mApp.V(2, null);
    asJ();
    dh(paramLong);
    asL();
    asM();
    if (AudioHelper.jY(0) == 1)
    {
      setBackgroundColor(-256);
      this.ea.setBackgroundColor(-65281);
      this.ec.setBackgroundColor(-16711936);
      localViewGroup.setBackgroundColor(-1);
      findViewById(2131373985).setBackgroundColor(-7829368);
    }
  }
  
  void dj(long paramLong)
  {
    int i = 0;
    while (i < this.V.size())
    {
      ((BaseToolbar)this.V.valueAt(i)).destroy(paramLong, this.mApp);
      i += 1;
    }
    this.V.clear();
  }
  
  boolean f(long paramLong, int paramInt)
  {
    asH();
    asN();
    int i = this.avL;
    if (paramInt != -1) {
      i = paramInt;
    }
    i = J(i, -1);
    QLog.w(this.TAG, 1, "show, EffectBtnID 原[" + this.avL + "], 期望[" + paramInt + "], 最终[" + i + "], seq[" + paramLong + "]");
    if (!this.Wp)
    {
      QQToast.a((Context)this.mContext.get(), ((AVActivity)this.mContext.get()).getString(2131697544), 1).show();
      ixo.arZ();
      return isShown();
    }
    anhs.a().uh();
    ina.a().uh();
    ixo.y(this.mApp.b().b().relationType, bL());
    Object localObject = (BaseToolbar)this.V.get(i);
    if (localObject != null) {
      ((BaseToolbar)localObject).performClick();
    }
    jij.a(this.mApp, (BaseToolbar)this.V.get(7));
    localObject = this.mApp.b().b();
    if ((localObject != null) && (((iiv)localObject).ta()) && (((iiv)localObject).amI == 2)) {
      anot.a(null, "dc00898", "", "", "0X8008AD5", "0X8008AD5", 0, 0, "", "", "", "");
    }
    return true;
  }
  
  public boolean isShown()
  {
    return getVisibility() == 0;
  }
  
  public void ma(int paramInt)
  {
    long l = AudioHelper.hG();
    QLog.w(this.TAG, 1, "exitSubEffectPanel, ExitID[" + paramInt + "], mCurSelectedId[" + this.avL + "], isShown[" + isShown() + "], seq[" + l + "]");
    int i;
    if (this.avL == paramInt)
    {
      i = J(-1, paramInt);
      if (!isShown()) {
        break label115;
      }
      if (i > paramInt) {
        G(l, true);
      }
    }
    else
    {
      return;
    }
    M(i, paramInt);
    return;
    label115:
    BaseToolbar localBaseToolbar = (BaseToolbar)this.V.get(this.avL);
    if (localBaseToolbar != null) {
      localBaseToolbar.hideToolbar(l);
    }
    setCurSelectedId(-1, "exitSubEffectPanel");
  }
  
  boolean onBackPressed()
  {
    if (!((AVActivity)this.mContext.get()).mControlUI.wH()) {
      return false;
    }
    G(-1012L, true);
    return true;
  }
  
  public void onDestroy(long paramLong)
  {
    dj(paramLong);
    this.jdField_a_of_type_Jht$a = null;
    if (this.jdField_a_of_type_Iyr != null)
    {
      this.jdField_a_of_type_Iyr.onDestroy();
      this.jdField_a_of_type_Iyr = null;
    }
    if (this.bS != null)
    {
      this.mApp.getHandler().removeCallbacks(this.bS);
      this.bS = null;
    }
    URLDrawable.clearMemoryCache();
    if (!((AVActivity)this.mContext.get()).Ox)
    {
      VideoController localVideoController = ((AVActivity)this.mContext.get()).a;
      if ((localVideoController != null) && (localVideoController.b().state != 0) && (localVideoController.b().state != 7)) {
        localVideoController.b().ans = this.avL;
      }
    }
    this.mContext = null;
    super.onDestroy(paramLong);
  }
  
  public void setCurSelectedId(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "setCurSelectedId, [" + this.avL + "--->" + paramInt + "], from[" + paramString + "]");
    }
    if (this.avL != paramInt) {
      this.avL = paramInt;
    }
  }
  
  public void setSelectedBtn(int paramInt)
  {
    if (paramInt == this.avL) {
      return;
    }
    M(paramInt, -1);
    setCurSelectedId(paramInt, "setSelectedBtn");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.EffectSettingUi
 * JD-Core Version:    0.7.0.1
 */