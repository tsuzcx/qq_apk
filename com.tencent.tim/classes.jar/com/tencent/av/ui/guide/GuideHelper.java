package com.tencent.av.ui.guide;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.ViewStub;
import aqmj;
import asfe;
import com.tencent.av.VideoController;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import iiv;
import jhk;
import jhl;
import jhm;
import jjk.c;
import mqq.util.WeakReference;

public class GuideHelper
{
  static String RW = "qav_guide_gesture/data.json";
  public static String RX = "qav_guide_gesture/images/";
  private static long pA;
  private static long pz = -1L;
  private boolean Zn;
  DelayTryShowRunnable a;
  public b a;
  private final int azX = 2;
  private Context mContext;
  private boolean mIsDestroyed;
  
  static
  {
    pA = -1L;
  }
  
  public GuideHelper()
  {
    this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$b = new b();
  }
  
  private int a(long paramLong, Context paramContext)
  {
    boolean bool1 = a(paramLong, paramContext);
    boolean bool2 = ah(paramContext);
    int i = -1;
    if ((!bool1) && (!bool2)) {
      i = 2;
    }
    do
    {
      return i;
      if (!bool1) {
        return 0;
      }
    } while (bool2);
    return 1;
  }
  
  private void a(long paramLong, Context paramContext, int paramInt)
  {
    int j = a(paramLong, paramContext);
    if ((j != -1) && ((paramInt == 2) || ((j != 2) && (paramInt == j)) || (j == 2))) {}
    for (int i = 1; i == 0; i = 0)
    {
      if (AudioHelper.isDev()) {
        QLog.w("GuideHelper", 1, "tryShow, checkCondition false, had_show[" + pz + "], seq[" + paramLong + "]");
      }
      return;
    }
    if (this.mIsDestroyed)
    {
      QLog.w("GuideHelper", 1, "tryShow, mIsDestroyed[" + this.mIsDestroyed + "], seq[" + paramLong + "]");
      return;
    }
    i = paramInt;
    if (paramInt == 2) {
      if (j != 2) {
        break label223;
      }
    }
    label223:
    for (i = 0; !a(paramLong, paramContext, i); i = j)
    {
      QLog.w("GuideHelper", 1, "tryShow, initTipsView false, had_show[" + pz + "], seq[" + paramLong + "]");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$b.lottieDrawable == null) && (i == 0))
    {
      QLog.w("GuideHelper", 1, "tryShow, loadedLottieDrawable, seq[" + paramLong + "]");
      return;
    }
    if (this.Zn)
    {
      QLog.w("GuideHelper", 1, "not support show double times guider under one-time talk");
      return;
    }
    this.Zn = true;
    this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$b.show(true);
    jjk.c.axh();
    asfe.getUIHandler().postDelayed(new GuideHelper.3(this, paramLong), 5000L);
    if (i == 0)
    {
      m(paramContext, paramLong);
      return;
    }
    n(paramContext, paramLong);
  }
  
  private boolean a(long paramLong, Context paramContext)
  {
    boolean bool1 = false;
    if (m(paramContext) == 0L)
    {
      paramContext = (AVActivity)paramContext;
      iiv localiiv = VideoController.a().b();
      if ((localiiv == null) || (paramContext.mControlUI == null)) {
        return true;
      }
      boolean bool3 = localiiv.isVideo();
      boolean bool4 = paramContext.mControlUI.wH();
      boolean bool5 = paramContext.mControlUI.a().cC(0);
      boolean bool2 = paramContext.mControlUI.aE(paramLong);
      if ((bool3) && (bool4) && (bool5) && (bool2)) {}
    }
    for (bool1 = true;; bool1 = true) {
      return bool1;
    }
  }
  
  private boolean a(long paramLong, Context paramContext, int paramInt)
  {
    if (!(paramContext instanceof AVActivity)) {
      QLog.w("GuideHelper", 1, "initTipsView, fail, context[" + paramContext + "], seq[" + paramLong + "]");
    }
    label281:
    for (;;)
    {
      return false;
      AVActivity localAVActivity = (AVActivity)paramContext;
      int i;
      if (paramInt == 0)
      {
        i = 1;
        if (this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$b.iv == null)
        {
          if (this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$b.o == null)
          {
            this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$b.o = ((ViewStub)localAVActivity.findViewById(2131373993));
            if (this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$b.o != null) {
              this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$b.o.inflate();
            }
          }
          this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$b.iw = localAVActivity.findViewById(2131374152);
          this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$b.iv = this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$b.iw.findViewById(2131374235);
        }
        this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$b.iw.setOnTouchListener(new jhk(this, paramLong));
        if (i == 0) {
          break label236;
        }
        new a().a(paramLong, paramContext, RW, new jhl(this, paramLong, paramContext, paramInt));
      }
      for (;;)
      {
        if ((localAVActivity == null) || (localAVActivity.mControlUI == null) || (localAVActivity.mControlUI.a() == null)) {
          break label281;
        }
        return true;
        i = 0;
        break;
        label236:
        paramContext = this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$b.iv.getLayoutParams();
        paramContext.width = -2;
        paramContext.height = -2;
        this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$b.iv.setBackgroundDrawable(localAVActivity.getResources().getDrawable(2130842911));
      }
    }
  }
  
  private boolean ah(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1;
    if (n(paramContext) != 0L) {
      bool1 = true;
    }
    int i;
    for (;;)
    {
      if (!bool1)
      {
        paramContext = (AVActivity)paramContext;
        iiv localiiv = VideoController.a().b();
        if ((localiiv == null) || (paramContext.mControlUI == null))
        {
          return true;
          bool1 = false;
        }
        else if (!localiiv.sW())
        {
          i = 1;
          bool1 = paramContext.mControlUI.wH();
          boolean bool3 = paramContext.mControlUI.a().cC(0);
          if ((bool1) && (bool3))
          {
            bool1 = bool2;
            if (i != 0) {
              break;
            }
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    for (;;)
    {
      return bool1;
      i = 0;
      break;
    }
  }
  
  private void hide(long paramLong)
  {
    this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$b.show(false);
  }
  
  static long m(Context paramContext)
  {
    if (pz == -1L) {
      pz = aqmj.j(paramContext).getLong("qav_UserGuide_gesture_had_show", 0L);
    }
    return pz;
  }
  
  static void m(Context paramContext, long paramLong)
  {
    pz = System.currentTimeMillis();
    paramContext = aqmj.j(paramContext).edit();
    paramContext.putLong("qav_UserGuide_gesture_had_show", pz);
    paramContext.apply();
    QLog.w("AVActivity", 1, "qav_UserGuide_gesture, save, time[" + pz + "], seq[" + paramLong + "]");
  }
  
  private static long n(Context paramContext)
  {
    if (pA == -1L) {
      pA = aqmj.j(paramContext).getLong("qav_UserGuide_textchat_had_show2", 0L);
    }
    return pA;
  }
  
  private static void n(Context paramContext, long paramLong)
  {
    pA = System.currentTimeMillis();
    paramContext = aqmj.j(paramContext).edit();
    paramContext.putLong("qav_UserGuide_textchat_had_show2", pA);
    paramContext.apply();
    QLog.w("AVActivity", 1, "qav_UserGuide_gesture, save, time[" + pz + "], seq[" + paramLong + "]");
  }
  
  public void a(long paramLong, Context paramContext, int paramInt1, int paramInt2)
  {
    if (4 == paramInt1)
    {
      if (this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$DelayTryShowRunnable == null) {
        this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$DelayTryShowRunnable = new DelayTryShowRunnable();
      }
      this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$DelayTryShowRunnable.target = paramInt2;
    }
    do
    {
      this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$DelayTryShowRunnable.a(paramLong, paramContext, this, 2000L);
      while (paramInt1 == 0)
      {
        hide(paramLong);
        return;
        if (3 == paramInt1)
        {
          if (this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$DelayTryShowRunnable != null) {
            this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$DelayTryShowRunnable.removeCallback(paramLong);
          }
          hide(paramLong);
        }
      }
    } while (99 != paramInt1);
    a(paramLong, paramContext, paramInt2);
  }
  
  public void awu()
  {
    this.Zn = false;
    a(-1L, this.mContext, 1);
  }
  
  public boolean cF(int paramInt)
  {
    return ah(this.mContext);
  }
  
  public void onCreate(Context paramContext)
  {
    this.mIsDestroyed = false;
    this.Zn = false;
    this.mContext = paramContext;
  }
  
  public void onDestroy(long paramLong)
  {
    hide(paramLong);
    this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$b.clear();
    this.mIsDestroyed = true;
    this.Zn = false;
  }
  
  static class DelayTryShowRunnable
    implements Runnable
  {
    WeakReference<Context> k = null;
    WeakReference<GuideHelper> l = null;
    long seq = 0L;
    public int target;
    
    public final boolean a(long paramLong1, Context paramContext, GuideHelper paramGuideHelper, long paramLong2)
    {
      this.seq = paramLong1;
      this.k = new WeakReference(paramContext);
      this.l = new WeakReference(paramGuideHelper);
      asfe.getUIHandler().removeCallbacks(this);
      return asfe.getUIHandler().postDelayed(this, paramLong2);
    }
    
    public final void removeCallback(long paramLong)
    {
      QLog.w("GuideHelper", 1, "removeCallback, seq[" + paramLong + "], last_seq[" + this.seq + "]");
      this.seq = 0L;
      this.k = null;
      this.l = null;
      asfe.getUIHandler().removeCallbacks(this);
    }
    
    public void run()
    {
      if (this.seq == 0L) {
        return;
      }
      if (this.k != null) {}
      for (Context localContext = (Context)this.k.get(); localContext == null; localContext = null)
      {
        QLog.w("GuideHelper", 1, "DelayTryShowRunnable, context fail, seq[" + this.seq + "]");
        return;
      }
      if (this.l != null) {}
      for (GuideHelper localGuideHelper = (GuideHelper)this.l.get(); localGuideHelper == null; localGuideHelper = null)
      {
        QLog.w("GuideHelper", 1, "DelayTryShowRunnable, GuideHelper fail, seq[" + this.seq + "]");
        return;
      }
      GuideHelper.a(localGuideHelper, this.seq, localContext, this.target);
    }
  }
  
  public static class a
  {
    void a(long paramLong, Context paramContext, String paramString, a parama)
    {
      try
      {
        LottieComposition.Factory.fromAssetFileName(paramContext, paramString, new jhm(this, paramContext, paramLong, parama));
        return;
      }
      catch (Exception paramContext)
      {
        QLog.e("GuideHelper", 1, "fromAssetFileName fail, seq[" + paramLong + "]", paramContext);
        asfe.getUIHandler().post(new GuideHelper.LottieDrawableHelper.2(this, parama));
      }
    }
    
    public static abstract interface a
    {
      public abstract void a(LottieDrawable paramLottieDrawable);
    }
  }
  
  public static class b
  {
    public View iv = null;
    View iw = null;
    public LottieDrawable lottieDrawable = null;
    ViewStub o = null;
    
    public void clear()
    {
      this.o = null;
      this.iv = null;
      this.lottieDrawable = null;
    }
    
    public void show(boolean paramBoolean)
    {
      int i;
      if (paramBoolean)
      {
        i = 0;
        if (this.lottieDrawable != null)
        {
          if (!paramBoolean) {
            break label76;
          }
          this.lottieDrawable.playAnimation();
        }
      }
      for (;;)
      {
        if (this.o != null) {
          this.o.setVisibility(i);
        }
        if (this.iw != null) {
          this.iw.setVisibility(i);
        }
        if (this.iv != null) {
          this.iv.setVisibility(i);
        }
        return;
        i = 8;
        break;
        label76:
        this.lottieDrawable.pauseAnimation();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.guide.GuideHelper
 * JD-Core Version:    0.7.0.1
 */