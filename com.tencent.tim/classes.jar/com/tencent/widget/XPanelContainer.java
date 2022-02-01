package com.tencent.widget;

import adyf;
import afnq;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import aqmj;
import aqmq;
import aqnm;
import aqom;
import auqs;
import auvr;
import auvs;
import auvt;
import auvu;
import auwa;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel;
import com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import wja;

public class XPanelContainer
  extends FrameLayout
  implements Runnable
{
  public static int aLe;
  private static boolean dll = ;
  private static int euY;
  public static int euZ;
  public static int eva;
  public static volatile int evb;
  public static boolean tg;
  private int Im;
  private View LB;
  private View LC;
  public a a;
  private d a;
  private long aze = -1L;
  private c b;
  private boolean bwy;
  private SparseArray<View> dW = new SparseArray(4);
  public boolean dlm = false;
  private boolean dln;
  private boolean dlo;
  private boolean dlp;
  private boolean dlq = true;
  private boolean dlr;
  private boolean dls;
  public boolean es = true;
  private int evc;
  private int evd = -1;
  private int eve = -1;
  private int evf = 0;
  private int evg;
  public WeakReference<b> iY;
  private int mStatus = 0;
  private int orientation = -1;
  private int screenHeightDp = -1;
  private int screenWidthDp = -1;
  private int[] tA = new int[2];
  
  public XPanelContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  @TargetApi(11)
  public XPanelContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    exU();
    if (aLe == 0)
    {
      euZ = (int)(OZ() * paramContext.getResources().getDisplayMetrics().density);
      aLe = Pa();
      if (!auwa.hasNavBar(paramContext)) {
        break label313;
      }
      i = auwa.getNavigationBarHeight(paramContext);
    }
    label313:
    for (eva = (int)((paramContext.getResources().getDisplayMetrics().heightPixels + i) * 0.5D);; eva = (int)(paramContext.getResources().getDisplayMetrics().heightPixels * 0.5D))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.XPanelContainer", 2, " mMAXExternalPanelheight = " + eva + "mExternalPanelheight=" + aLe);
      }
      if (QLog.isColorLevel()) {
        QLog.d("XPanelContainer", 2, " mDefaultExternalPanelheight = " + euZ + "mMAXExternalPanelheight=" + eva + "density=" + paramContext.getResources().getDisplayMetrics().density + "mNavigationBarHeight=" + i);
      }
      this.Im = ImmersiveUtils.getStatusBarHeight(getContext());
      if ((Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT < 24) && (!aqom.aFr())) {
        setOnSystemUiVisibilityChangeListener(new auvr(this));
      }
      return;
    }
  }
  
  public static int OZ()
  {
    return 196;
  }
  
  private static int Pa()
  {
    if (euY > 0) {
      return euY;
    }
    return aqnm.dip2px(196.0F);
  }
  
  @TargetApi(11)
  private void exQ()
  {
    if ((dll) && (this.dlo))
    {
      if (this.bwy) {
        if (this.evg >= aLe)
        {
          this.evg = 0;
          this.bwy = false;
        }
      }
      while ((!this.dln) || (this.evg > 0)) {
        return;
      }
      this.evg = 0;
      this.dln = false;
      return;
    }
    if (AnimationUtils.currentAnimationTimeMillis() >= this.aze + 0L)
    {
      this.evg = 0;
      return;
    }
    float f = (float)(AnimationUtils.currentAnimationTimeMillis() - this.aze) / 0.0F;
    this.evg = ((int)(aLe - auqs.viscousFluid(f) * aLe));
  }
  
  private void exT()
  {
    int i = euY;
    if (i > 0)
    {
      aqmj.a(BaseApplication.getContext(), "", true, "sp_key_input_height", Integer.valueOf(i));
      if (QLog.isColorLevel()) {
        QLog.i("XPanelContainer", 2, "saveInputMethodPanelHeight.height = " + i);
      }
    }
  }
  
  private void exU()
  {
    if (euY == 0) {
      euY = ((Integer)aqmj.a(getContext(), "", "sp_key_input_height", Integer.valueOf(0))).intValue();
    }
    if (QLog.isColorLevel()) {
      QLog.i("XPanelContainer", 2, "initInputMethodPanelHeight.height = " + euY);
    }
  }
  
  private void fE(int paramInt1, int paramInt2)
  {
    if (this.iY == null) {}
    for (b localb = null;; localb = (b)this.iY.get())
    {
      if (localb != null) {
        localb.fE(paramInt1, paramInt2);
      }
      return;
    }
  }
  
  private int nA()
  {
    if ((this.LC != null) && ((this.LC instanceof e))) {
      return ((e)this.LC).vV();
    }
    return euZ;
  }
  
  private void setStatus(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("XPanelContainer", 2, "setStatus status=" + paramInt + " mStatus=" + this.mStatus + " mSoftInputChange=" + this.dls + " mSoftInputShowing=" + this.dlr);
    }
    if (paramInt != this.mStatus)
    {
      int i = this.mStatus;
      this.mStatus = paramInt;
      if (this.b != null) {
        this.b.n(i, this.mStatus);
      }
      URLDrawable.resume();
      ApngImage.playByTag(0);
      if ((this.LC != null) && (paramInt <= 1) && ((!(this.LC instanceof VoiceTextEditPanel)) || (paramInt != 1)))
      {
        if ((!this.dls) || (this.dlr)) {
          break label175;
        }
        if ((this.LC instanceof VoiceTextEditPanel)) {
          this.mStatus = 36;
        }
      }
    }
    return;
    label175:
    if (this.LC.getVisibility() == 0)
    {
      this.LC.setVisibility(8);
      this.LC = null;
      postDelayed(this, 1L);
      return;
    }
    this.LC = null;
  }
  
  private void wo(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer$d != null) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer$d.wo(paramBoolean);
    }
  }
  
  private void z(int paramInt, View paramView)
  {
    if ((paramView != null) && (paramInt == 10)) {}
    try
    {
      paramView = (HongBaoPanel)paramView;
      paramView.doRedManagerShowReport();
      paramView.tryGetFailedImage();
      return;
    }
    catch (Throwable paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public void X(View paramView, boolean paramBoolean)
  {
    this.LB = paramView;
    if (paramView.getOnFocusChangeListener() == null) {
      paramView.setOnFocusChangeListener(new auvs(this));
    }
    if ((paramBoolean) && (paramView.getParent() != null) && ((paramView.getParent() instanceof ViewGroup)))
    {
      paramView = (ViewGroup)paramView.getParent();
      paramView.setDescendantFocusability(131072);
      paramView.setFocusableInTouchMode(true);
    }
  }
  
  @TargetApi(11)
  public boolean aJS()
  {
    return bK(true);
  }
  
  @TargetApi(11)
  public boolean aJT()
  {
    return m(true, true);
  }
  
  public boolean aJU()
  {
    return this.dlq;
  }
  
  public boolean aJV()
  {
    return (this.LC != null) && ((this.LC instanceof VoiceTextEditPanel));
  }
  
  public void aLz()
  {
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
  }
  
  public void abp(int paramInt)
  {
    cm(paramInt, true);
  }
  
  @TargetApi(11)
  public boolean bK(boolean paramBoolean)
  {
    return m(paramBoolean, false);
  }
  
  public View cE()
  {
    return this.LC;
  }
  
  @TargetApi(11)
  public void cm(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.XPanelContainer", 2, " showExternalPanel panelId = " + paramInt + " mStatus = " + this.mStatus + " ready = " + this.dlq);
    }
    if (!this.dlq) {}
    label116:
    do
    {
      do
      {
        for (;;)
        {
          return;
          this.evf = paramInt;
          fE(this.mStatus, paramInt);
          Object localObject2;
          Object localObject1;
          if (tg)
          {
            if (paramInt == 1) {
              if (this.LB.requestFocusFromTouch())
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.aio.XPanelContainer", 2, " requestFocusFromTouch success ");
                }
                wja.eR(this.LB);
                if (this.LC != null) {
                  this.LC.setVisibility(8);
                }
              }
            }
            for (;;)
            {
              for (;;)
              {
                requestLayout();
                return;
                if (!QLog.isColorLevel()) {
                  break label116;
                }
                QLog.e("Q.aio.XPanelContainer", 2, " requestFocusFromTouch fail ");
                break label116;
                if (paramInt > 1)
                {
                  aLz();
                  if (this.mStatus == 1) {
                    this.mStatus = 0;
                  }
                  localObject2 = (View)this.dW.get(paramInt);
                  localObject1 = localObject2;
                  if (localObject2 != null)
                  {
                    localObject1 = localObject2;
                    if (this.b.r(paramInt))
                    {
                      this.dW.remove(paramInt);
                      removeView((View)localObject2);
                      localObject1 = null;
                    }
                  }
                  z(paramInt, (View)localObject1);
                  localObject2 = localObject1;
                  if (localObject1 == null) {}
                  try
                  {
                    localObject2 = this.b.a(paramInt);
                    if (localObject2 == null) {
                      break;
                    }
                    addView((View)localObject2);
                    this.dW.put(paramInt, localObject2);
                    if (localObject2 != this.LC)
                    {
                      if (this.LC != null) {
                        this.LC.setVisibility(8);
                      }
                      ((View)localObject2).setVisibility(0);
                      this.LC = ((View)localObject2);
                    }
                  }
                  catch (Exception localException1)
                  {
                    for (;;)
                    {
                      localObject2 = localObject1;
                      if (QLog.isColorLevel())
                      {
                        QLog.d("XPanelContainer", 2, localException1, new Object[0]);
                        localObject2 = localObject1;
                      }
                    }
                  }
                }
              }
              aJS();
            }
          }
          if (paramInt == 1)
          {
            wja.eR(this.LB);
            return;
          }
          if (paramInt <= 1) {
            break label928;
          }
          this.dlm = false;
          if (paramInt == 3)
          {
            EmoticonMainPanel.XA = System.currentTimeMillis();
            aqmq.track(null, "AIO_EmoticonPanel_OpenDuration");
            localObject2 = (View)this.dW.get(paramInt);
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (this.b.r(paramInt))
              {
                this.dW.remove(paramInt);
                removeView((View)localObject2);
                localObject1 = null;
              }
            }
            z(paramInt, (View)localObject1);
            localObject2 = localObject1;
            if (localObject1 != null) {}
          }
          try
          {
            localObject2 = this.b.a(paramInt);
            if (localObject2 != null)
            {
              addView((View)localObject2);
              this.dW.put(paramInt, localObject2);
              if (localObject2 != this.LC)
              {
                if (this.LC != null) {
                  this.LC.setVisibility(8);
                }
                ((View)localObject2).setVisibility(0);
                this.LC = ((View)localObject2);
              }
              if (this.mStatus == 0)
              {
                if (QLog.isDevelopLevel()) {
                  QLog.d("Q.aio.XPanelContainer", 4, " showExternalPanel mAnimationPosition= " + this.evg + "mExternalPanelheight=" + aLe);
                }
                if (this.evg > 0) {
                  continue;
                }
                this.evd = paramInt;
                URLDrawable.pause();
                ApngImage.pauseByTag(0);
                this.dlo = paramBoolean;
                if ((dll) && (paramBoolean))
                {
                  this.bwy = true;
                  paramInt = getHeight();
                  int i = aLe;
                  localObject1 = ValueAnimator.ofInt(new int[] { paramInt, paramInt - aLe });
                  ((ValueAnimator)localObject1).setDuration(150L);
                  ((ValueAnimator)localObject1).addUpdateListener(new auvt(this, paramInt));
                  ((ValueAnimator)localObject1).start();
                  return;
                  if (paramInt != 21) {
                    break label409;
                  }
                  aqmq.track(null, "apollo_panel_open");
                }
              }
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              localObject2 = localObject1;
              if (QLog.isColorLevel())
              {
                QLog.d("XPanelContainer", 2, localException2, new Object[0]);
                localObject2 = localObject1;
              }
            }
            this.evg = aLe;
            this.aze = AnimationUtils.currentAnimationTimeMillis();
            requestLayout();
            return;
          }
        }
        if (this.mStatus != 1) {
          break;
        }
        if ((this.evg != 0) && (this.evg != aLe))
        {
          if (QLog.isColorLevel()) {
            QLog.d("XPanelContainer", 2, new Object[] { "mAnimationPosition went wrong. mAnimationPosition = ", Integer.valueOf(this.evg), " mExternalPanelheight = ", Integer.valueOf(aLe) });
          }
          this.evg = aLe;
          this.aze = AnimationUtils.currentAnimationTimeMillis();
        }
        this.evd = paramInt;
        aLz();
      } while ((this.evg != 0) || (this.dlr) || (this.eve <= 0) || (getHeight() < this.eve));
      if (QLog.isColorLevel()) {
        QLog.w("XPanelContainer", 2, "soft input status error, reset");
      }
      reset();
      return;
    } while (this.mStatus == paramInt);
    label409:
    setStatus(paramInt);
    return;
    label928:
    throw new IllegalArgumentException("wrong argument..must be SOFT_INPUT,EXTERNAL_EMOTICON,EXTERNAL_INPUT");
  }
  
  public void exP()
  {
    adyf localadyf;
    if ((this.b instanceof BaseChatPie))
    {
      localadyf = (adyf)((BaseChatPie)this.b).a(50);
      if (localadyf == null) {}
    }
    for (boolean bool = localadyf.afS();; bool = true)
    {
      if (bool)
      {
        aLz();
        if (QLog.isColorLevel()) {
          QLog.w("XPanelContainer", 2, "hideKeyboardInConsiderLeftSwipe");
        }
      }
      return;
    }
  }
  
  public void exR()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.XPanelContainer", 2, " clearAllPanel ");
    }
    if ((this.LC instanceof VoiceTextEditPanel)) {
      return;
    }
    int i = 0;
    try
    {
      while (i < this.dW.size())
      {
        View localView = (View)this.dW.get(this.dW.keyAt(i));
        if (localView.getParent() != null) {
          removeView(localView);
        }
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      this.dW.clear();
      this.LC = null;
      afnq.daU();
    }
  }
  
  public void exS()
  {
    if (tg)
    {
      if (this.b != null) {}
      this.mStatus = 1;
      this.evf = 1;
      this.evd = 0;
      if (this.LC != null)
      {
        if (this.LC.getVisibility() != 0) {
          break label60;
        }
        this.LC.setVisibility(8);
        this.LC = null;
      }
    }
    return;
    label60:
    this.LC = null;
  }
  
  public void ja(View paramView)
  {
    X(paramView, true);
  }
  
  @TargetApi(11)
  public boolean m(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.LC instanceof EmoticonMainPanel))
    {
      EmoticonMainPanel localEmoticonMainPanel = (EmoticonMainPanel)this.LC;
      localEmoticonMainPanel.removeView(localEmoticonMainPanel.BO);
    }
    if (this.b != null) {
      this.b.bo();
    }
    boolean bool;
    if (this.mStatus > 0)
    {
      bool = true;
      if (!tg) {
        break label102;
      }
      if (this.mStatus == 1)
      {
        if (!paramBoolean2) {
          break label95;
        }
        exP();
      }
      label77:
      this.evf = 0;
      requestLayout();
    }
    label95:
    label102:
    do
    {
      return bool;
      bool = false;
      break;
      aLz();
      break label77;
      if (this.mStatus == 1)
      {
        if (paramBoolean2) {
          try
          {
            exP();
            return bool;
          }
          catch (Exception localException)
          {
            QLog.e("XPanelContainer", 1, localException, new Object[0]);
            return bool;
          }
        }
        aLz();
        return bool;
      }
    } while (this.mStatus <= 1);
    if (this.evg > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.XPanelContainer", 2, "  hideAllPanel return  mAnimationPosition = " + this.evg);
      }
      return true;
    }
    this.evf = 0;
    this.evd = 0;
    if (paramBoolean1) {}
    for (int i = aLe;; i = 0)
    {
      this.evg = i;
      this.aze = AnimationUtils.currentAnimationTimeMillis();
      if ((!dll) || (!paramBoolean1)) {
        break;
      }
      this.dln = true;
      i = getHeight();
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { i - aLe, i });
      localValueAnimator.setDuration(150L);
      localValueAnimator.addUpdateListener(new auvu(this, i));
      localValueAnimator.start();
      return bool;
    }
    requestLayout();
    return bool;
  }
  
  @TargetApi(13)
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (VersionUtils.isHoneycombMR2()) {
      if ((paramConfiguration.orientation != this.orientation) && ((this.screenWidthDp != paramConfiguration.screenWidthDp) || (this.screenHeightDp != paramConfiguration.screenHeightDp)))
      {
        this.orientation = -1;
        this.screenHeightDp = -1;
        this.screenHeightDp = -1;
        this.eve = -1;
        aJS();
      }
    }
    while (paramConfiguration.orientation == this.orientation) {
      return;
    }
    this.orientation = -1;
    this.eve = -1;
    aJS();
  }
  
  @TargetApi(13)
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.XPanelContainer", 2, "  changed = " + paramInt1 + "top=" + paramInt2 + "bottom=" + paramInt4 + " mAnimationPosition = " + this.evg);
    }
    if ((getContext() instanceof SplashActivity))
    {
      i = ((Activity)getContext()).getWindow().getAttributes().softInputMode;
      if (i != 18)
      {
        QLog.e("XPanelContainer", 1, "illegal soft input mode: " + i);
        ((Activity)getContext()).getWindow().setSoftInputMode(18);
        requestLayout();
      }
    }
    int n = getPaddingRight();
    int j = getPaddingLeft();
    int m = getPaddingBottom();
    int k = getPaddingTop();
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      if (tg)
      {
        long l = System.currentTimeMillis();
        if ((getContext() instanceof Activity))
        {
          bool = ((Activity)getContext()).isInMultiWindowMode();
          QLog.d("XPanelContainer", 1, "targetSdk > 24 tmpIsMultiScreen= " + bool + ",calltime = " + (System.currentTimeMillis() - l));
          if (tg != bool)
          {
            this.dlp = true;
            tg = bool;
          }
        }
      }
    }
    for (;;)
    {
      if (this.es)
      {
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer$a != null) {
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer$a.onChangeMultiScreen(tg);
        }
        this.es = false;
      }
      if (this.dlp)
      {
        this.dlp = false;
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer$a != null) {
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer$a.onChangeMultiScreen(tg);
        }
        if (this.LC != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.XPanelContainer", 2, "  multi screen change to normal ");
          }
          this.LC.setVisibility(8);
          this.LC = null;
        }
        ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
        exR();
        setStatus(0);
        this.evf = 0;
        this.evd = -1;
        euZ = (int)(OZ() * getContext().getResources().getDisplayMetrics().density);
        aLe = euZ;
        evb = 0;
        paramInt1 = paramInt3 - paramInt1 - n;
        paramInt2 = paramInt4 - paramInt2 - m;
        try
        {
          View localView = getChildAt(0);
          localView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 - j, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - k, 1073741824));
          localView.layout(j, k, paramInt1, paramInt2);
          return;
          if ((Build.VERSION.SDK_INT >= 21) && (getSystemUiVisibility() == 0) && (((getContext() instanceof SplashActivity)) || ((getContext() instanceof ChatActivity))))
          {
            if (getParent() != null) {
              ((View)getParent()).getLocationInWindow(this.tA);
            }
            if (this.tA[1] < this.Im - 5) {}
            for (bool = true; tg != bool; bool = false)
            {
              QLog.d("XPanelContainer", 1, "tmpIsMultiScreen= " + bool + ", coordinate " + this.tA[1] + ", default top " + this.Im);
              this.dlp = true;
              tg = bool;
              break;
            }
          }
        }
        catch (Exception localException1)
        {
          while (!QLog.isColorLevel()) {}
          QLog.d("Q.aio.XPanelContainer", 2, "  error = " + localException1);
          return;
        }
      }
    }
    int i1 = paramInt4 - paramInt2;
    int i = this.mStatus;
    Object localObject;
    float f;
    if ((this.eve < 0) && (paramBoolean) && (i1 > 0))
    {
      localObject = getResources().getConfiguration();
      this.orientation = ((Configuration)localObject).orientation;
      if (VersionUtils.isHoneycombMR2())
      {
        this.screenWidthDp = ((Configuration)localObject).screenWidthDp;
        this.screenHeightDp = ((Configuration)localObject).screenHeightDp;
      }
      this.eve = i1;
      if (getResources().getConfiguration().orientation != 2) {
        break label1292;
      }
      f = 0.3F * this.eve;
      label796:
      int i2 = (int)f;
      if ((this.eve <= i1) || (this.eve - i1 <= i2)) {
        break label1306;
      }
      bool = true;
      label825:
      if (bool != this.dlr) {
        break label1312;
      }
      this.dls = false;
      label839:
      this.dlr = bool;
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.XPanelContainer", 2, new Object[] { " setStatus onLayout before finalStatus = ", Integer.valueOf(i), " softInputShowing = ", Boolean.valueOf(bool), " mStatus = ", Integer.valueOf(this.mStatus), " changed = ", Boolean.valueOf(paramBoolean), " mPendingStatus = ", Integer.valueOf(this.evd), " mIsMultiScreen = ", Boolean.valueOf(tg), " mCoordinates[1] = ", Integer.valueOf(this.tA[1]), " mClickStatus = ", Integer.valueOf(this.evf), "mNormalSize = ", Integer.valueOf(this.eve), " height = ", Integer.valueOf(i1), " dHeight = " + i2 + " mSoftInputChange=" + this.dls });
      }
      paramInt3 = paramInt3 - paramInt1 - n;
      paramInt2 = paramInt4 - paramInt2 - m;
      localObject = getChildAt(0);
    }
    for (;;)
    {
      try
      {
        if (!tg) {
          break label1501;
        }
        euZ = (int)(OZ() * getContext().getResources().getDisplayMetrics().density);
        aLe = nA();
        evb = 0;
        if (this.evf != 1) {
          break label1320;
        }
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - j, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - k, 1073741824));
        ((View)localObject).layout(j, k, paramInt3, paramInt2);
        setStatus(this.evf);
        this.evd = 0;
        return;
      }
      catch (Exception localException2)
      {
        QLog.e("Q.aio.XPanelContainer", 1, "main.getContext: " + ((View)localObject).getContext() + " \n " + localException2.toString() + " crash happen restore init status", localException2);
        if (this.LC != null) {
          this.LC.setVisibility(8);
        }
        setStatus(0);
        this.evd = -1;
        requestLayout();
        return;
      }
      if (i1 <= this.eve) {
        break;
      }
      this.eve = i1;
      break;
      label1292:
      f = 0.2F * this.eve;
      break label796;
      label1306:
      bool = false;
      break label825;
      label1312:
      this.dls = true;
      break label839;
      label1320:
      if (this.evf == 0)
      {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - j, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - k, 1073741824));
        ((View)localObject).layout(j, k, paramInt3, paramInt2);
      }
      else
      {
        if ((this.LC == null) || (this.LC.getVisibility() != 0))
        {
          this.evf = 0;
          this.evd = -1;
          setStatus(this.evf);
          requestLayout();
          return;
        }
        this.LC.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - j, 1073741824), View.MeasureSpec.makeMeasureSpec(aLe, 1073741824));
        this.LC.layout(j, paramInt2 - aLe, paramInt3, paramInt2);
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - j, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - k - aLe, 1073741824));
        ((View)localObject).layout(j, k, paramInt3, paramInt2 - aLe);
      }
    }
    label1501:
    if (((!bool) || (this.mStatus == 1)) && (this.evc == 0)) {
      this.evc = paramInt2;
    }
    if (getResources().getConfiguration().orientation == 2)
    {
      if (evb != 0) {
        exR();
      }
      evb = 0;
      euZ = (int)(OZ() * getContext().getResources().getDisplayMetrics().density);
      aLe = nA();
    }
    if ((bool) && (this.mStatus != 1)) {
      if ((this.LC instanceof VoiceTextEditPanel))
      {
        ((VoiceTextEditPanel)this.LC).yO(true);
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - j, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - k - aLe, 1073741824));
        ((View)localObject).layout(j, k, paramInt3, paramInt2 - aLe);
        ((VoiceTextEditPanel)this.LC).e(j, k, paramInt3, paramInt2, bool);
        label1682:
        paramInt1 = this.evc - paramInt2;
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.XPanelContainer", 2, new Object[] { " onLayout inputHeight ", Integer.valueOf(paramInt1), " mExternalPanelheight = ", Integer.valueOf(aLe), " mDefaultExternalPanelheight = ", Integer.valueOf(euZ), " mAddedHeight = ", Integer.valueOf(evb) });
        }
        if (getResources().getConfiguration().orientation == 1)
        {
          euZ = (int)(OZ() * getContext().getResources().getDisplayMetrics().density);
          if (aLe != paramInt1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.XPanelContainer", 2, " mExternalPanelheight=" + aLe + " inputHeight=" + paramInt1 + " mDefaultExternalPanelheight=" + euZ + " mMAXHExternalPanelheight=" + eva + " mAnimationPosition=" + this.evg);
            }
            if (this.evg == 0)
            {
              if (paramInt1 <= euZ) {
                break label2189;
              }
              if (paramInt1 <= eva) {
                break label2174;
              }
              if (eva <= euZ) {
                break label2165;
              }
              aLe = eva;
              label1925:
              evb = aLe - euZ;
            }
            exR();
            if (QLog.isColorLevel()) {
              QLog.d("XPanelContainer", 2, "mExternalPanelheight=" + aLe + "mAddedHeight=" + evb);
            }
          }
        }
        label1984:
        if ((!paramBoolean) || (!bool)) {
          break label3370;
        }
        paramInt1 = 1;
        this.evd = -1;
      }
    }
    label2165:
    label2174:
    do
    {
      do
      {
        setStatus(paramInt1);
        this.evf = paramInt1;
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.XPanelContainer", 2, new Object[] { " onLayout after finalStatus = ", Integer.valueOf(paramInt1), " softInputShowing = ", Boolean.valueOf(bool), " mStatus = ", Integer.valueOf(this.mStatus), " changed = ", Boolean.valueOf(paramBoolean), " mPendingStatus = ", Integer.valueOf(this.evd) });
        }
        if (!(this.LC instanceof VoiceTextEditPanel)) {
          break;
        }
        ((VoiceTextEditPanel)this.LC).caI();
        return;
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - j, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - k, 1073741824));
        ((View)localObject).layout(j, k, paramInt3, paramInt2);
        break label1682;
        aLe = euZ;
        break label1925;
        aLe = paramInt1;
        euY = paramInt1;
        exT();
        break label1925;
        aLe = euZ;
        break label1925;
        if ((this.evd > 1) && ((!bool) || (paramBoolean)))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.aio.XPanelContainer", 4, " onLayout bom panel mannule layout  =  softInputShowing " + bool + " changed = " + paramBoolean);
          }
          if ((bool) && (paramBoolean))
          {
            requestLayout();
            return;
          }
          exQ();
          if ((dll) && (this.dlo)) {
            if (this.bwy) {
              paramInt1 = this.evg;
            }
          }
          while (this.LC == null)
          {
            QLog.e("XPanelContainer", 1, " onLayout panel error:curPanel==nulll ,restore status NONE ");
            setStatus(0);
            this.evd = -1;
            requestLayout();
            return;
            paramInt1 = aLe;
            continue;
            if (!this.dlo) {
              this.dlo = true;
            }
            paramInt1 = aLe - this.evg;
          }
          if ((this.LC instanceof VoiceTextEditPanel)) {
            ((VoiceTextEditPanel)this.LC).e(j, paramInt2 - paramInt1, paramInt3, paramInt2 - paramInt1 + aLe, bool);
          }
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("Q.aio.XPanelContainer", 4, " onLayout bom panel mannule layout calcposition d= " + paramInt1 + "mAnimationPosition = " + this.evg + "isOpenAnim=" + this.bwy + "mExternalPanelheight=" + aLe);
            }
            ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - j, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - k - paramInt1, 1073741824));
            ((View)localObject).layout(j, k, paramInt3, paramInt2 - paramInt1);
            if ((this.bwy) || ((this.evg != 0) && (this.evd <= 1))) {
              break label2645;
            }
            setStatus(this.evd);
            this.evd = -1;
            if (!QLog.isDevelopLevel()) {
              break;
            }
            QLog.d("Q.aio.XPanelContainer", 4, " onLayout bom panel mannule layout,end ，not canvas =  isOpenAnim " + this.bwy + " mAnimationPosition = " + this.evg);
            return;
            this.LC.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - j, 1073741824), View.MeasureSpec.makeMeasureSpec(aLe, 1073741824));
            this.LC.layout(j, paramInt2 - paramInt1, paramInt3, paramInt2 - paramInt1 + aLe);
          }
          if (dll) {
            break;
          }
          postDelayed(this, 1L);
          return;
        }
        if ((this.evd == 0) && (this.mStatus > 1))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.aio.XPanelContainer", 4, " onLayout reget =  mAnimationPosition = " + this.evg);
          }
          exQ();
          if (this.LC == null)
          {
            QLog.e("XPanelContainer", 1, " onLayout panel error:curPanel==nulll ,restore status NONE ");
            setStatus(0);
            this.evd = -1;
            requestLayout();
            return;
          }
          if ((this.LC instanceof VoiceTextEditPanel)) {
            ((VoiceTextEditPanel)this.LC).e(j, paramInt2 - this.evg, paramInt3, paramInt2 - this.evg + aLe, bool);
          }
          for (;;)
          {
            ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - j, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - k - this.evg, 1073741824));
            ((View)localObject).layout(j, k, paramInt3, paramInt2 - this.evg);
            if (this.evg != 0) {
              break;
            }
            setStatus(this.evd);
            this.evd = -1;
            return;
            this.LC.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - j, 1073741824), View.MeasureSpec.makeMeasureSpec(aLe, 1073741824));
            this.LC.layout(j, paramInt2 - this.evg, paramInt3, paramInt2 - this.evg + aLe);
          }
          if (dll) {
            break;
          }
          postDelayed(this, 1L);
          return;
        }
        if ((this.mStatus > 1) && (!bool))
        {
          if (QLog.isDevelopLevel()) {
            if (this.LC != null) {
              break label3049;
            }
          }
          for (paramInt1 = 0;; paramInt1 = this.LC.getVisibility())
          {
            QLog.d("Q.aio.XPanelContainer", 4, " onLayout bom panel ,confirm it mExternalPanelheight= " + aLe + " bottom = " + paramInt2 + "  mCurPanel.getVisibility() " + paramInt1);
            if ((this.LC != null) && (this.LC.getVisibility() == 0)) {
              break;
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("Q.aio.XPanelContainer", 4, " onLayout panel hold on error ,restore status NONE ");
            }
            setStatus(0);
            this.evd = -1;
            requestLayout();
            return;
          }
          if (QLog.isDevelopLevel())
          {
            ViewParent localViewParent = this.LC.getParent();
            QLog.d("Q.aio.XPanelContainer", 4, " onLayout bom panel ,confirm it vp.ViewParent = " + localViewParent.getClass().getName());
          }
          ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - j, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - k - aLe, 1073741824));
          ((View)localObject).layout(j, k, paramInt3, paramInt2 - aLe);
          if (!(this.LC instanceof VoiceTextEditPanel))
          {
            this.LC.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - j, 1073741824), View.MeasureSpec.makeMeasureSpec(aLe, 1073741824));
            this.LC.layout(j, paramInt2 - aLe, paramInt3, paramInt2);
            break label1984;
          }
          ((VoiceTextEditPanel)this.LC).e(j, paramInt2 - aLe, paramInt3, paramInt2, bool);
          break label1984;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.aio.XPanelContainer", 4, " onLayout use default layout = ");
        }
        if ((this.LC instanceof VoiceTextEditPanel))
        {
          ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - j, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - k - aLe, 1073741824));
          ((View)localObject).layout(j, k, paramInt3, paramInt2 - aLe);
          ((VoiceTextEditPanel)this.LC).e(j, k, paramInt3, paramInt2, bool);
          break label1984;
        }
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - j, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - k, 1073741824));
        ((View)localObject).layout(j, k, paramInt3, paramInt2);
        break label1984;
        if (this.evd == 0) {
          break label3392;
        }
        paramInt1 = i;
      } while (!paramBoolean);
      paramInt1 = i;
    } while (bool);
    label2189:
    label2645:
    label3049:
    if (paramBoolean)
    {
      if (i == 28) {
        break label3426;
      }
      if (i == 35) {
        paramInt1 = i;
      }
    }
    for (;;)
    {
      label3370:
      label3392:
      this.evd = -1;
      break;
      paramInt1 = 0;
      continue;
      label3426:
      paramInt1 = i;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), paramInt1), getDefaultSize(getSuggestedMinimumHeight(), paramInt2));
  }
  
  public void reset()
  {
    if (QLog.isColorLevel()) {
      QLog.d("XPanelContainer", 2, "-->finish--reset resetPosition");
    }
    this.evd = -1;
    setStatus(0);
    this.dlm = true;
    this.bwy = false;
    this.dln = false;
    this.evg = 0;
    requestLayout();
  }
  
  public void run()
  {
    requestLayout();
  }
  
  public void setIsInMultiScreen(boolean paramBoolean)
  {
    if (tg != paramBoolean)
    {
      this.dlp = true;
      tg = paramBoolean;
    }
  }
  
  public void setOnChangeMultiScreenListener(a parama)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer$a = parama;
  }
  
  public void setOnGoingToShowPanelListener(b paramb)
  {
    this.iY = new WeakReference(paramb);
  }
  
  public void setOnPanelChangeListener(c paramc)
  {
    this.b = paramc;
  }
  
  public void setReadyToShow(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("XPanelContainer", 2, "setReadyToShow() called with: readyToShow = [" + paramBoolean + "]");
    }
    if (this.dlq != paramBoolean)
    {
      this.dlq = paramBoolean;
      wo(paramBoolean);
    }
  }
  
  public void setReadyToShowChangeListener(d paramd)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer$d = paramd;
  }
  
  public int vm()
  {
    return this.mStatus;
  }
  
  public static abstract interface a
  {
    public abstract void onChangeMultiScreen(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void fE(int paramInt1, int paramInt2);
  }
  
  public static abstract interface c
  {
    public abstract View a(int paramInt);
    
    public abstract void bo();
    
    public abstract void n(int paramInt1, int paramInt2);
    
    public abstract boolean r(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void wo(boolean paramBoolean);
  }
  
  public static abstract interface e
  {
    public abstract int vV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.XPanelContainer
 * JD-Core Version:    0.7.0.1
 */