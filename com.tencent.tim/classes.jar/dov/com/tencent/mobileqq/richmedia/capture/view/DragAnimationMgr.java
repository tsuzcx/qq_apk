package dov.com.tencent.mobileqq.richmedia.capture.view;

import acfp;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import ayxp;
import ayxq;
import azbx;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class DragAnimationMgr
{
  private View EL;
  private View NB;
  private View NC;
  private DragViewIcon jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon;
  private a jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$a;
  private b jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b = new b();
  private boolean bHj;
  private boolean dBI;
  private int eMZ = 0;
  private ViewGroup fr;
  
  private int Sl()
  {
    int i = -1;
    if (this.eMZ == 0) {
      i = Math.max(this.EL.getHeight(), this.NC.getHeight());
    }
    do
    {
      return i;
      if (this.eMZ != -1) {
        break;
      }
    } while (!this.bHj);
    return azbx.dip2px(40.0F);
    if (this.eMZ == 1) {
      return this.NC.getHeight();
    }
    return this.EL.getHeight();
  }
  
  public static ObjectAnimator a(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F });
    paramView.setDuration(150L);
    if (paramAnimatorListenerAdapter != null) {
      paramView.addListener(paramAnimatorListenerAdapter);
    }
    paramView.start();
    return paramView;
  }
  
  public static void a(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    a(true, paramView, paramAnimatorListenerAdapter, paramView.getHeight());
  }
  
  private void a(DragViewIcon paramDragViewIcon, int paramInt)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(paramDragViewIcon, "offset", new int[] { paramInt, 0 });
    localObjectAnimator.setStartDelay(125L);
    localObjectAnimator.setDuration(330L);
    paramDragViewIcon.dBM = true;
    localObjectAnimator.addListener(new ayxq(this, paramDragViewIcon));
    localObjectAnimator.start();
  }
  
  private void a(DragViewIcon paramDragViewIcon, int paramInt1, int paramInt2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    paramDragViewIcon = ObjectAnimator.ofInt(paramDragViewIcon, "offset", new int[] { paramInt1, paramInt2 });
    paramDragViewIcon.setDuration(100L);
    paramDragViewIcon.addListener(paramAnimatorListenerAdapter);
    paramDragViewIcon.start();
  }
  
  private static void a(boolean paramBoolean, View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter, int paramInt)
  {
    ObjectAnimator localObjectAnimator;
    if (paramBoolean) {
      localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
    }
    for (paramView = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { paramInt, 0.0F });; paramView = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { 0.0F, paramInt }))
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.play(localObjectAnimator).with(paramView);
      localAnimatorSet.setDuration(270L);
      if (paramAnimatorListenerAdapter != null) {
        localAnimatorSet.addListener(paramAnimatorListenerAdapter);
      }
      localAnimatorSet.start();
      return;
      localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F });
    }
  }
  
  private boolean aRu()
  {
    return (this.bHj) || ((this.eMZ >= 0) && (this.eMZ <= 2));
  }
  
  private void aq(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    int i = this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.getOffset();
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DragAnimationMgr", 2, "upScreenAnimation: currentOffset=" + i + " mAnimationDirection=" + hd(this.eMZ));
      }
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$a != null) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$a.dc(false, false);
      }
    }
    boolean bool1;
    label178:
    do
    {
      return;
      if (i < 0) {}
      for (bool1 = true;; bool1 = false)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DragAnimationMgr", 2, "upScreenAnimation: leftDirection=" + bool1 + " mAnimationDirection=" + hd(this.eMZ));
        }
        if (!bool1) {
          break label178;
        }
        if (this.eMZ != 2) {
          break label205;
        }
        if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$a == null) {
          break;
        }
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$a.dc(true, false);
        return;
      }
      if (this.eMZ != 1) {
        break;
      }
    } while (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$a == null);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$a.dc(false, false);
    return;
    label205:
    int j = DragViewIcon.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon);
    float f1 = paramMotionEvent.getRawY();
    float f2 = Math.abs(f1 - this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.startY);
    int k = this.fr.getHeight() / 2;
    if (QLog.isColorLevel()) {
      QLog.i("DragAnimationMgr", 2, "upScreenAnimation: currentY=" + f1 + " startY=" + this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.startY + " moveYOffset=" + f2 + " parentHeightHalf=" + k);
    }
    boolean bool2 = bool3;
    if (j < this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.eNg)
    {
      bool2 = bool3;
      if (f2 <= k) {
        bool2 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("DragAnimationMgr", 2, "upScreenAnimation: leftDirection=" + bool1 + " inRegion=" + bool2);
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$a != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$a.dc(bool1, bool2);
    }
    if (j <= 5)
    {
      a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon, i);
      return;
    }
    j = DragViewIcon.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon, i);
    a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon, i, j, new ayxp(this));
  }
  
  public static ObjectAnimator b(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    return a(paramView, paramAnimatorListenerAdapter);
  }
  
  public static void b(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    a(false, paramView, paramAnimatorListenerAdapter, paramView.getHeight());
  }
  
  private void bO(float paramFloat)
  {
    int i = 0;
    switch (this.eMZ)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.GU = (Math.max(i, paramFloat) / 4.0F);
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.GU <= 0.0F) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.GU = azbx.dip2px(1.0F);
      }
      return;
      i = this.EL.getWidth() / 2;
      continue;
      i = this.NC.getWidth() / 2;
      continue;
      i = Math.max(this.EL.getWidth(), this.NC.getWidth()) / 2;
    }
  }
  
  public static ObjectAnimator c(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
    paramView.setDuration(150L);
    if (paramAnimatorListenerAdapter != null) {
      paramView.addListener(paramAnimatorListenerAdapter);
    }
    paramView.start();
    return paramView;
  }
  
  public static void c(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    a(true, paramView, paramAnimatorListenerAdapter, -paramView.getHeight());
  }
  
  public static void d(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    a(false, paramView, paramAnimatorListenerAdapter, -paramView.getHeight());
  }
  
  private void eUg()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon == null)
    {
      int i = Sl();
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon = new DragViewIcon(this.NB.getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, i);
      localLayoutParams.addRule(15, -1);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.setTranslationY(azbx.dip2px(17.0F));
      this.fr.addView(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon);
      if (this.bHj) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.afO(-65536);
      }
    }
    for (;;)
    {
      eUh();
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.setVisibility(0);
      return;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.setOffset(0);
    }
  }
  
  private void eUh()
  {
    int j = 0;
    int i = this.NB.getLeft();
    int k = this.NB.getWidth() / 2 + i;
    switch (this.eMZ)
    {
    default: 
      if (this.bHj)
      {
        j = (int)(azbx.dip2px(40.0F) * 3.5F);
        i = j;
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.eNe = j;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.eNf = i;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.eNg = ((int)this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.GU);
      return;
      i = Math.abs(k - (this.EL.getLeft() + this.EL.getWidth() / 2));
      continue;
      j = Math.abs(k - (this.NC.getLeft() + this.NC.getWidth() / 2));
      i = 0;
      continue;
      i = this.EL.getLeft();
      int n = this.EL.getWidth() / 2;
      j = this.NC.getLeft();
      int m = this.NC.getWidth() / 2;
      i = Math.abs(k - (i + n));
      j = Math.abs(k - (m + j));
      continue;
      i = 0;
    }
  }
  
  private void eUi()
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.setOffset(0);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.setVisibility(8);
  }
  
  private String hd(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unKnown test=" + this.bHj;
    case 0: 
      return "BI_DIRECTION";
    case 2: 
      return "RIGHT_DIRECTION";
    }
    return "LEFT_DIRECTION";
  }
  
  private void y(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$a != null) {
      if (paramBoolean1) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$a.ZU(paramBoolean2);
      }
    }
    while (!this.bHj)
    {
      return;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$a.ZV(paramBoolean2);
      return;
    }
    if (paramBoolean1)
    {
      QQToast.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.getContext(), acfp.m(2131705299) + paramBoolean2, 0).show();
      return;
    }
    QQToast.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.getContext(), acfp.m(2131705298) + paramBoolean2 + " max:" + paramBoolean3, 0).show();
  }
  
  public void ZT(boolean paramBoolean)
  {
    this.dBI = paramBoolean;
  }
  
  public void a(ViewGroup paramViewGroup, View paramView1, View paramView2, View paramView3)
  {
    this.fr = paramViewGroup;
    this.NB = paramView1;
    this.NC = paramView2;
    this.EL = paramView3;
    this.eMZ = 0;
    if (paramView2 == null)
    {
      if (paramView3 == null)
      {
        this.eMZ = -1;
        return;
      }
      this.eMZ = 2;
      return;
    }
    if (paramView3 == null)
    {
      this.eMZ = 1;
      return;
    }
    this.eMZ = 0;
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$a = parama;
  }
  
  public void afN(int paramInt)
  {
    int i = this.eMZ;
    this.eMZ = paramInt;
    if (!aRu()) {
      this.eMZ = i;
    }
  }
  
  protected void ao(MotionEvent paramMotionEvent)
  {
    boolean bool = aRu();
    if (!bool) {
      if (QLog.isColorLevel()) {
        QLog.i("DragAnimationMgr", 2, "longTouchDown: valid=" + bool + " mAnimationDirection=" + this.eMZ);
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.startX = paramMotionEvent.getRawX();
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.startY = paramMotionEvent.getRawY();
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.lastX = paramMotionEvent.getRawX();
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.lastY = paramMotionEvent.getRawY();
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.currentX = paramMotionEvent.getRawX();
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.currentY = paramMotionEvent.getRawY();
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.dxN = false;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.dBL = false;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.dBJ = false;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.dBK = false;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.status = 0;
      bO(b.eNa);
      eUg();
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$a != null) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$a.eUj();
      }
    } while (!QLog.isColorLevel());
    QLog.i("DragAnimationMgr", 2, "longTouchDown: hasMoved=" + this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.dxN + " startX=" + this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.startX);
  }
  
  protected void ap(MotionEvent paramMotionEvent)
  {
    boolean bool = aRu();
    if (!bool) {
      if (QLog.isColorLevel()) {
        QLog.i("DragAnimationMgr", 2, "longTouchDown: valid=" + bool + " mAnimationDirection=" + this.eMZ);
      }
    }
    label533:
    do
    {
      return;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.currentX = paramMotionEvent.getRawX();
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.currentY = paramMotionEvent.getRawY();
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.xDiff = (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.currentX - this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.lastX);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.yDiff = (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.currentY - this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.lastY);
      if (QLog.isColorLevel()) {
        QLog.i("DragAnimationMgr", 2, "longTouchDown: hasMoved=" + this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.dxN + " startX=" + this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.startX + "  xDiff=" + this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.xDiff + "  lastX=" + this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.lastX);
      }
      if (this.dBI)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DragAnimationMgr", 2, "handleTouch hasCheckLong" + this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.dBK);
        }
        if (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.dBK)
        {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.dBK = true;
          if (Math.abs(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.xDiff) <= b.eNd) {
            break label533;
          }
        }
        for (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.dBJ = false;; this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.dBJ = true)
        {
          if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$a != null) {
            this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$a.ZW(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.dBJ);
          }
          if (QLog.isColorLevel()) {
            QLog.i("DragAnimationMgr", 2, "handleTouch enableMoved" + this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.dBJ);
          }
          if (QLog.isColorLevel()) {
            QLog.i("DragAnimationMgr", 2, "handleTouch enableMoved" + this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.dBJ);
          }
          if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.dBJ)
          {
            ePE();
            if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.dxN)
            {
              this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.lastX = this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.currentX;
              this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.lastY = this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.currentY;
            }
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("DragAnimationMgr", 2, "handleTouch[Adsorption] xDiff=" + this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.xDiff + " currentX=" + this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.currentX + " yDiff=" + this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.yDiff + " currentY=" + this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.currentY);
          return;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("DragAnimationMgr", 2, "handleTouch mCaptureAnimationEnd=false");
  }
  
  protected boolean ax(MotionEvent paramMotionEvent)
  {
    boolean bool = aRu();
    if (!bool)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DragAnimationMgr", 2, "longTouchUp: valid=" + bool + " mAnimationDirection=" + this.eMZ);
      }
      return false;
    }
    aq(paramMotionEvent);
    return true;
  }
  
  protected void ePE()
  {
    if (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.dxN)
    {
      float f = Math.abs(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.xDiff);
      if (QLog.isColorLevel()) {
        QLog.i("DragAnimationMgr", 2, "longTouchMoveUser: absMoveInter=" + f + " limit=" + b.eNc);
      }
      if (f > b.eNc) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.dxN = false;
      }
    }
    int j;
    int i;
    switch (this.eMZ)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.i("DragAnimationMgr", 2, "longTouchMoveUser: [big] mAnimationDirection=" + this.eMZ + " xDiff=" + this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.xDiff);
      }
      if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.dxN) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$a != null)) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$a.eUl();
      }
      if (QLog.isColorLevel()) {
        QLog.i("DragAnimationMgr", 2, "longTouchMoveUser: hasMoved=" + this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.dxN + " mAnimationDirection=" + this.eMZ);
      }
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.dxN)
      {
        j = (int)(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.getOffset() + this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.xDiff);
        switch (this.eMZ)
        {
        default: 
          i = j;
        }
      }
      break;
    }
    for (;;)
    {
      if (Math.abs(i) >= b.eNb) {
        break label392;
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.setOffset(0);
      return;
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.xDiff <= 0.0F) {
        break;
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.dxN = true;
      break;
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.xDiff >= 0.0F) {
        break;
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.dxN = true;
      break;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$b.dxN = true;
      break;
      i = j;
      if (j < 0)
      {
        i = 0;
        continue;
        i = j;
        if (j > 0) {
          i = 0;
        }
      }
    }
    label392:
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.setOffset(i);
  }
  
  public void resetUI()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon != null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.setOffset(0);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.setVisibility(8);
    }
  }
  
  public class DragViewIcon
    extends View
    implements Runnable
  {
    float GV = 0.5F;
    RectF bN = new RectF();
    float centerX = 0.0F;
    float centerY = 0.0F;
    public boolean dBM = false;
    boolean dBN = false;
    boolean dBO = false;
    Paint jdField_do;
    int eNe = 0;
    int eNf = 0;
    int eNg;
    int eNh;
    int eNi = -1;
    int eNj;
    int eNk;
    boolean isFirst = false;
    int mHeight;
    Paint mPaint;
    int mWidth;
    int offset = 0;
    
    public DragViewIcon(Context paramContext)
    {
      super();
      init();
    }
    
    public DragViewIcon(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      init();
    }
    
    private int Sm()
    {
      if (this.offset < 0) {}
      for (int i = this.eNe + this.offset;; i = this.eNf - this.offset)
      {
        int j = i;
        if (i < 0) {
          j = 0;
        }
        return j;
      }
    }
    
    private void a(Canvas paramCanvas, RectF paramRectF)
    {
      paramCanvas.drawRect(paramRectF, this.mPaint);
      this.eNk = ((int)paramRectF.width());
    }
    
    private void init()
    {
      setLayerType(1, null);
      this.mPaint = new Paint();
      this.mPaint.setAntiAlias(true);
      this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.jdField_do = new Paint();
      this.jdField_do.setAntiAlias(true);
      this.jdField_do.setStyle(Paint.Style.FILL_AND_STROKE);
      this.jdField_do.setColor(0);
    }
    
    private int mg(int paramInt)
    {
      if (paramInt < 0) {
        return -this.eNe;
      }
      return this.eNf;
    }
    
    void afO(int paramInt)
    {
      this.eNi = paramInt;
    }
    
    public int getOffset()
    {
      return this.offset;
    }
    
    protected void onDraw(Canvas paramCanvas)
    {
      super.onDraw(paramCanvas);
      this.mWidth = getWidth();
      this.mHeight = getHeight();
      if (this.mWidth <= 0) {
        return;
      }
      if (this.centerX == 0.0F)
      {
        this.centerX = (this.mWidth / 2);
        this.centerY = (this.mHeight / 2);
        this.eNh = ((int)(this.mHeight * this.GV));
      }
      this.mPaint.setColor(0);
      this.bN.set(0.0F, 0.0F, this.mWidth, this.mHeight);
      paramCanvas.drawRect(this.bN, this.mPaint);
      float f1 = this.mHeight / 2.0F;
      this.mPaint.setColor(this.eNi);
      if (this.offset == 0) {
        paramCanvas.drawCircle(this.centerX, this.centerY, f1, this.mPaint);
      }
      label157:
      label1082:
      label1086:
      for (;;)
      {
        f1 = Math.abs(DragAnimationMgr.a(DragAnimationMgr.this).currentY - DragAnimationMgr.a(DragAnimationMgr.this).startY);
        int i = DragAnimationMgr.a(DragAnimationMgr.this).getHeight() / 2;
        if (QLog.isColorLevel()) {
          QLog.i("DragAnimationMgr", 2, "upScreenAnimation: currentY=" + DragAnimationMgr.a(DragAnimationMgr.this).currentY + " startY=" + DragAnimationMgr.a(DragAnimationMgr.this).startY + " moveYOffset=" + f1 + " parentHeightHalf=" + i);
        }
        int k;
        if (f1 > i)
        {
          if (!this.dBN) {
            break;
          }
          this.dBN = false;
          postDelayed(this, 5L);
          return;
          k = Sm();
          if (Math.abs(this.offset) <= this.eNh) {
            if (k < this.eNg) {
              i = 1;
            }
          }
        }
        for (;;)
        {
          if (i == 0) {
            break label1086;
          }
          float f2;
          if (k < this.eNg)
          {
            if (!this.isFirst)
            {
              this.isFirst = true;
              this.eNj = this.eNk;
              this.dBN = true;
              postDelayed(this, 5L);
            }
            if (k == 0)
            {
              if (this.offset < 0)
              {
                this.offset = (-this.eNe);
                paramCanvas.drawCircle(this.centerX - this.eNe, this.centerY, f1, this.jdField_do);
                break label157;
                paramCanvas.drawCircle(this.centerX, this.centerY, f1, this.mPaint);
                paramCanvas.drawCircle(this.centerX + this.offset, this.centerY, f1, this.mPaint);
                if (this.offset < 0) {
                  this.bN.set(this.centerX + this.offset, 0.0F, this.centerX, this.mHeight);
                }
                for (;;)
                {
                  a(paramCanvas, this.bN);
                  this.isFirst = false;
                  if (!this.dBN) {
                    break label1082;
                  }
                  this.dBN = false;
                  this.dBO = false;
                  if (this.dBM) {
                    break label1082;
                  }
                  postDelayed(this, 5L);
                  i = 0;
                  break;
                  this.bN.set(this.centerX, 0.0F, this.centerX + this.offset, this.mHeight);
                }
                i = 1;
                continue;
              }
              paramCanvas.drawCircle(this.centerX + this.eNf, this.centerY, f1, this.jdField_do);
              this.offset = this.eNf;
              break label157;
            }
            i = (int)(k * 1.0F / this.eNg * this.eNj);
            int j;
            if (this.offset < 0)
            {
              j = k - this.eNe;
              i += k - this.eNe;
            }
            for (;;)
            {
              paramCanvas.drawCircle(this.centerX + j, this.centerY, f1, this.mPaint);
              paramCanvas.drawCircle(this.centerX + i, this.centerY, f1, this.mPaint);
              RectF localRectF = this.bN;
              f1 = this.centerX;
              f2 = j;
              float f3 = this.centerX;
              localRectF.set(f2 + f1, 0.0F, i + f3, this.mHeight);
              a(paramCanvas, this.bN);
              break;
              j = this.eNf - k - i;
              i = this.eNf - k;
            }
          }
          this.isFirst = false;
          if (this.dBN)
          {
            this.dBN = false;
            this.dBO = true;
            if (!this.dBM) {
              postDelayed(this, 5L);
            }
          }
          if (this.offset < 0)
          {
            i = this.offset + this.eNh;
            this.bN.set(this.centerX + this.offset, 0.0F, this.centerX + i, this.mHeight);
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("DragAnimationMgr", 2, "onDraw: maxIconWidth=" + this.eNh + " width=" + this.bN.width() + " radius=" + f1 + " mHeight=" + this.mHeight);
            }
            f2 = this.centerX;
            paramCanvas.drawCircle(i + f2, this.centerY, f1, this.mPaint);
            paramCanvas.drawCircle(this.centerX + this.offset, this.centerY, f1, this.mPaint);
            a(paramCanvas, this.bN);
            break;
            i = this.offset - this.eNh;
            this.bN.set(this.centerX + i, 0.0F, this.centerX + this.offset, this.mHeight);
          }
          i = Sm();
          if ((this.dBN) || (i >= this.eNg)) {
            break;
          }
          this.isFirst = false;
          return;
          i = 0;
        }
      }
    }
    
    public void run()
    {
      if (this.offset < 0) {}
      for (boolean bool = true;; bool = false)
      {
        if (!this.dBM) {
          DragAnimationMgr.a(DragAnimationMgr.this, this.dBN, bool, this.dBO);
        }
        return;
      }
    }
    
    public void setOffset(int paramInt)
    {
      this.offset = paramInt;
      invalidate();
    }
  }
  
  public static abstract interface a
  {
    public abstract void ZU(boolean paramBoolean);
    
    public abstract void ZV(boolean paramBoolean);
    
    public abstract void ZW(boolean paramBoolean);
    
    public abstract void dc(boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract void eUj();
    
    public abstract void eUk();
    
    public abstract void eUl();
  }
  
  public static class b
  {
    static final int eNa = azbx.dip2px(20.0F);
    static final int eNb = azbx.dip2px(2.0F);
    static final int eNc = azbx.dip2px(4.0F);
    static final int eNd = azbx.dip2px(8.0F);
    public float GU = eNa;
    public float currentX;
    public float currentY;
    public boolean dBJ;
    public boolean dBK;
    public boolean dBL;
    public boolean dxN;
    public float lastX;
    public float lastY;
    public float startX;
    public float startY;
    public int status = 0;
    public float xDiff;
    public float yDiff;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.DragAnimationMgr
 * JD-Core Version:    0.7.0.1
 */