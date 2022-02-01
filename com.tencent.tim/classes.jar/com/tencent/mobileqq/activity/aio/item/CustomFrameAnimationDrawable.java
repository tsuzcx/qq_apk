package com.tencent.mobileqq.activity.aio.item;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import aqgs;
import aqhu;
import com.immersion.stickersampleapp.HapticManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import mqq.os.MqqHandler;

public class CustomFrameAnimationDrawable
  extends Drawable
  implements Runnable
{
  private boolean NW;
  DecodeRunnable jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$DecodeRunnable = null;
  a jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$a = null;
  public b a;
  private c jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$c;
  private d jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$d;
  private String aUG;
  RectF ah = new RectF();
  private int bSP;
  private int bSQ;
  private boolean bgK;
  private boolean bgL = true;
  private boolean bgM;
  private boolean bgN = true;
  Bitmap currentBitmap = null;
  MqqHandler g;
  private int jD;
  private int mBitmapHeight;
  Resources mRes = null;
  private int mTargetDensity = 160;
  private Vector<Bitmap> p;
  ArrayList<Bitmap> qy;
  Rect src = new Rect();
  
  public CustomFrameAnimationDrawable(Resources paramResources, Bitmap paramBitmap, MqqHandler paramMqqHandler)
  {
    this.g = paramMqqHandler;
    this.currentBitmap = paramBitmap;
    this.qy = null;
    this.mRes = paramResources;
    this.qy = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b = new b();
    this.p = new Vector();
    int j;
    if (paramResources != null)
    {
      j = paramResources.getDisplayMetrics().densityDpi;
      if (j != 0) {}
    }
    for (this.mTargetDensity = i;; this.mTargetDensity = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.mTargetDensity)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.mTargetDensity = this.mTargetDensity;
      if (paramBitmap == null) {
        break label200;
      }
      this.bSP = paramBitmap.getScaledWidth(this.mTargetDensity);
      this.mBitmapHeight = paramBitmap.getScaledHeight(this.mTargetDensity);
      return;
      i = j;
      break;
    }
    label200:
    this.mBitmapHeight = -1;
    this.bSP = -1;
  }
  
  public CustomFrameAnimationDrawable(Resources paramResources, Bitmap paramBitmap, MqqHandler paramMqqHandler, b paramb, String paramString, boolean paramBoolean)
  {
    this(paramResources, paramBitmap, paramMqqHandler);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b = paramb;
    this.aUG = paramString;
    this.bgK = paramBoolean;
    if ((this.aUG != null) && (this.bgK)) {
      ThreadManager.postImmediately(new CustomFrameAnimationDrawable.1(this), null, true);
    }
  }
  
  private CustomFrameAnimationDrawable(b paramb, Resources paramResources)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b = paramb;
    updateLocalState(paramResources);
  }
  
  public static boolean Sx()
  {
    return (!Build.VERSION.RELEASE.equals("5.0.2")) || ((!Build.MODEL.equals("SM-A5009")) && (!Build.MODEL.equals("SM-A7000")) && (!Build.MODEL.equals("Redmi Note 2")));
  }
  
  private void computeBitmapSize()
  {
    if (this.qy != null) {
      if (this.qy.size() != 0) {
        break label48;
      }
    }
    label48:
    for (Bitmap localBitmap = null; localBitmap != null; localBitmap = (Bitmap)this.qy.get(0))
    {
      this.bSP = localBitmap.getScaledWidth(this.mTargetDensity);
      this.mBitmapHeight = localBitmap.getScaledHeight(this.mTargetDensity);
      return;
    }
    this.mBitmapHeight = -1;
    this.bSP = -1;
  }
  
  private void updateLocalState(Resources paramResources)
  {
    int i;
    if (paramResources != null)
    {
      int j = paramResources.getDisplayMetrics().densityDpi;
      i = j;
      if (j == 0) {
        i = 160;
      }
    }
    for (this.mTargetDensity = i;; this.mTargetDensity = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.mTargetDensity)
    {
      computeBitmapSize();
      return;
    }
  }
  
  public void Db(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.bST = paramInt;
  }
  
  public void Dc(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.mCurFrameIndex = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.bSS = paramInt;
  }
  
  public void G(Bitmap paramBitmap)
  {
    this.currentBitmap = paramBitmap;
  }
  
  public e a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.size() > 0)
        {
          localObject1 = localObject2;
          if (paramInt >= 0)
          {
            localObject1 = localObject2;
            if (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.size()) {
              localObject1 = (e)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.get(paramInt);
            }
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$a = parama;
  }
  
  public void a(c paramc)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$c = paramc;
  }
  
  public Bitmap al()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qB != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qB.size() > 0) {
        localObject1 = (Bitmap)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qB.remove(0);
      }
    }
    return localObject1;
  }
  
  public void au(int paramInt1, int paramInt2, int paramInt3)
  {
    e locale = new e();
    locale.mFrameIndex = paramInt1;
    locale.mDuration = paramInt2;
    locale.bSU = paramInt3;
    locale.mFileName = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.add(locale);
  }
  
  public void cdG()
  {
    this.bgL = false;
  }
  
  public void cdH()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.bgO = true;
  }
  
  public void cdI()
  {
    this.NW = true;
    pause();
  }
  
  public void cdJ()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.bgP = true;
  }
  
  public void clear()
  {
    if (this.currentBitmap != null)
    {
      this.currentBitmap.recycle();
      this.currentBitmap = null;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qB;
    Object localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Bitmap localBitmap = (Bitmap)((Iterator)localObject2).next();
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
    }
    ((ArrayList)localObject1).clear();
    if (this.p != null)
    {
      localObject1 = this.p.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Bitmap)((Iterator)localObject1).next();
        if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled())) {
          ((Bitmap)localObject2).recycle();
        }
      }
      this.p.clear();
    }
  }
  
  public void clearFrame()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.clear();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Paint localPaint = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.mPaint;
    if ((this.qy == null) && (this.currentBitmap != null)) {
      if (this.currentBitmap.isRecycled())
      {
        if (QLog.isColorLevel()) {
          QLog.d("CustomFrameAnimationDrawable", 2, "draw use recycle bitmap");
        }
        this.currentBitmap = null;
      }
    }
    label488:
    for (;;)
    {
      return;
      Object localObject = this.currentBitmap;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.bgO)
      {
        paramCanvas.save();
        paramCanvas.scale(-1.0F, 1.0F, this.bSP / 2, this.mBitmapHeight / 2);
      }
      this.src.set(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      this.ah.set(0.0F, 0.0F, this.bSP, this.mBitmapHeight);
      int i = paramCanvas.getWidth();
      float f = paramCanvas.getHeight() * 1.0F / this.mBitmapHeight;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.bST == 1) {
        paramCanvas.translate((i / f - this.bSP) / 2.0F, 0.0F);
      }
      for (;;)
      {
        paramCanvas.drawBitmap((Bitmap)localObject, this.src, this.ah, localPaint);
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.bgO) {
          break;
        }
        paramCanvas.restore();
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.bST == 2) {
          paramCanvas.translate(Math.abs(i / f - this.bSP) / 2.0F, 0.0F);
        }
      }
      if (this.qy != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.mCurFrameIndex < 0) {
          localObject = null;
        }
        for (;;)
        {
          if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
            break label488;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.bgO)
          {
            paramCanvas.save();
            paramCanvas.scale(-1.0F, 1.0F, ((Bitmap)localObject).getWidth() / 2, ((Bitmap)localObject).getHeight() / 2);
          }
          this.src.set(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
          this.ah.set(0.0F, 0.0F, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
          paramCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, localPaint);
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.bgO) {
            break;
          }
          paramCanvas.restore();
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.mCurFrameIndex >= this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.size())
          {
            localObject = (Bitmap)this.qy.get(((e)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.size() - 1)).mFrameIndex);
          }
          else
          {
            localObject = (e)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.mCurFrameIndex);
            localObject = (Bitmap)this.qy.get(((e)localObject).mFrameIndex);
          }
        }
      }
    }
  }
  
  public int getAlpha()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.mPaint.getAlpha();
  }
  
  public int getCurrentFrameIndex()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.mCurFrameIndex;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mBitmapHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.bSP;
  }
  
  public int getLastIndex()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.size() - 1;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void onHide()
  {
    unscheduleSelf(this);
    if ((this.aUG != null) && (this.bgK)) {
      HapticManager.a().V(this.jD);
    }
  }
  
  public void onShow()
  {
    scheduleSelf(this, SystemClock.uptimeMillis() + 50L);
    if ((this.aUG != null) && (this.bgK)) {
      HapticManager.a().W(this.jD);
    }
  }
  
  public void pause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.hi) {
      unscheduleSelf(this);
    }
    if ((this.qy == null) && (this.currentBitmap != null) && (this.bgN))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qB.size())
      {
        Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qB.remove(0);
        if (localBitmap != null) {
          localBitmap.recycle();
        }
        i += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qB.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.bSS = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.mCurFrameIndex;
    }
  }
  
  public void resume()
  {
    this.NW = false;
    unscheduleSelf(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.hi = true;
    scheduleSelf(this, 0L);
  }
  
  public void run()
  {
    if (this.NW)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CustomFrameAnimationDrawable", 2, "paused");
      }
      return;
    }
    int j;
    int i;
    Object localObject1;
    Object localObject2;
    long l;
    if ((this.qy == null) && (this.currentBitmap != null))
    {
      j = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.mCurFrameIndex + 1;
      i = j;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.bgP) {
        i = j % this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.size();
      }
      if (i < this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.size())
      {
        localObject1 = al();
        if (localObject1 != null)
        {
          localObject2 = this.currentBitmap;
          if ((!this.bgM) && (this.p.size() <= 2)) {
            this.p.add(localObject2);
          }
          this.currentBitmap = ((Bitmap)localObject1);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b;
          ((b)localObject1).mCurFrameIndex += 1;
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.bgP)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b;
            ((b)localObject1).mCurFrameIndex %= this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.size();
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$c != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$c.onUpdate(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.mCurFrameIndex);
          }
          invalidateSelf();
        }
        i = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.bSS + 1;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.bgP) {
          break label1020;
        }
        if (i < this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.size()) {
          break label1015;
        }
        l = this.bSQ;
        label260:
        i %= this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.size();
      }
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.size())
      {
        if (i - this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.bSS < 2)
        {
          localObject1 = (e)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.get(i);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$DecodeRunnable == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$DecodeRunnable = new DecodeRunnable(i, ((e)localObject1).mFileName, ((e)localObject1).bSU, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qB);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$DecodeRunnable.c(this.mRes);
            if (this.g != null) {
              this.g.post(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$DecodeRunnable);
            }
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b;
            ((b)localObject1).bSS += 1;
            if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.bgP)
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b;
              ((b)localObject1).bSS %= this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.size();
            }
          }
        }
        localObject1 = (e)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.mCurFrameIndex);
        if (l != 0L) {
          break label583;
        }
      }
      label583:
      for (l = SystemClock.uptimeMillis() + ((e)localObject1).mDuration;; l = SystemClock.uptimeMillis() + l)
      {
        scheduleSelf(this, l);
        if ((this.aUG == null) || (!this.bgK)) {
          break;
        }
        localObject2 = HapticManager.a();
        i = this.jD;
        j = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.mCurFrameIndex;
        ((HapticManager)localObject2).update(i, ((e)localObject1).mDuration * j);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$a != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$a.onEnd();
        }
        if (this.bgL)
        {
          clear();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.clear();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.hi = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.aPN = true;
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$a.onEnd();
      }
      if (this.bgL)
      {
        clear();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.clear();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.hi = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.aPN = true;
      if (this.aUG == null) {
        break;
      }
      if (this.bgK) {
        HapticManager.a().X(this.jD);
      }
      this.jD = 0;
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.size() == 1)
      {
        invalidateSelf();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$c == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$c.onUpdate(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.mCurFrameIndex);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.bgP == true)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.mCurFrameIndex < this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.size())
        {
          invalidateSelf();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$c != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$c.onUpdate(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.mCurFrameIndex);
          }
          localObject1 = (e)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.mCurFrameIndex);
          l = SystemClock.uptimeMillis();
          scheduleSelf(this, ((e)localObject1).mDuration + l);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b;
          ((b)localObject1).mCurFrameIndex += 1;
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.aPN) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$a != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$a.onEnd();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.hi = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.aPN = true;
        if (this.aUG == null) {
          break;
        }
        if (this.bgK) {
          HapticManager.a().X(this.jD);
        }
        this.jD = 0;
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.mCurFrameIndex %= this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.size();
      invalidateSelf();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$c != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$c.onUpdate(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.mCurFrameIndex);
      }
      localObject1 = (e)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.mCurFrameIndex);
      l = SystemClock.uptimeMillis();
      scheduleSelf(this, ((e)localObject1).mDuration + l);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b;
      ((b)localObject1).mCurFrameIndex += 1;
      return;
      label1015:
      l = 0L;
      break label260;
      label1020:
      l = 0L;
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.mPaint.getAlpha())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.mPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.mPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setMirror(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.bgO = paramBoolean;
  }
  
  public void start()
  {
    unscheduleSelf(this);
    if ((this.qy == null) && (this.currentBitmap != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.mCurFrameIndex = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.bSS = 0;
      invalidateSelf();
      scheduleSelf(this, 0L);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.size() == 0)
    {
      if ((this.aUG != null) && (this.bgK)) {
        this.jD = HapticManager.a().h(this.aUG, 2);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.hi = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.aPN = false;
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.size() == -1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.size() == 0)) {}
    for (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.mCurFrameIndex = -1;; this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.mCurFrameIndex = 0)
    {
      scheduleSelf(this, 0L);
      break;
    }
  }
  
  public void stop()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.hi) {
      unscheduleSelf(this);
    }
  }
  
  public void u(int paramInt1, int paramInt2, String paramString)
  {
    e locale = new e();
    locale.mFrameIndex = paramInt1;
    locale.mDuration = paramInt2;
    locale.mFileName = paramString;
    locale.bSU = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$b.qA.add(locale);
  }
  
  class DecodeRunnable
    implements Runnable
  {
    int bSR;
    Resources jdField_d_of_type_AndroidContentResResources;
    BitmapFactory.Options jdField_d_of_type_AndroidGraphicsBitmapFactory$Options = new BitmapFactory.Options();
    String mFileName;
    int mIndex;
    ArrayList<Bitmap> qz;
    
    public DecodeRunnable(String paramString, int paramInt, ArrayList<Bitmap> paramArrayList)
    {
      this.mIndex = paramString;
      this.mFileName = paramInt;
      this.bSR = paramArrayList;
      Object localObject;
      this.qz = localObject;
    }
    
    public void c(Resources paramResources)
    {
      this.jdField_d_of_type_AndroidContentResResources = paramResources;
    }
    
    public void run()
    {
      String str;
      if (CustomFrameAnimationDrawable.a(CustomFrameAnimationDrawable.this)) {
        str = CustomFrameAnimationDrawable.a(CustomFrameAnimationDrawable.this).g(CustomFrameAnimationDrawable.a(CustomFrameAnimationDrawable.this), CustomFrameAnimationDrawable.b(CustomFrameAnimationDrawable.this), this.mIndex);
      }
      for (Object localObject1 = aqgs.getBitmapFromCache(str);; localObject1 = null)
      {
        if (localObject1 == null)
        {
          this.jdField_d_of_type_AndroidGraphicsBitmapFactory$Options.inSampleSize = 1;
          this.jdField_d_of_type_AndroidGraphicsBitmapFactory$Options.inMutable = true;
          if (CustomFrameAnimationDrawable.a(CustomFrameAnimationDrawable.this).size() <= 0) {
            break label251;
          }
        }
        label251:
        Object localObject2;
        for (Bitmap localBitmap1 = (Bitmap)CustomFrameAnimationDrawable.a(CustomFrameAnimationDrawable.this).remove(0);; localObject2 = null)
        {
          if ((!CustomFrameAnimationDrawable.a(CustomFrameAnimationDrawable.this)) && (localBitmap1 != null) && (!localBitmap1.isRecycled()) && (CustomFrameAnimationDrawable.Sx())) {
            this.jdField_d_of_type_AndroidGraphicsBitmapFactory$Options.inBitmap = localBitmap1;
          }
          if (this.bSR != 0) {}
          for (;;)
          {
            try
            {
              localBitmap1 = aqhu.g(this.jdField_d_of_type_AndroidContentResResources, this.bSR);
              localObject1 = localBitmap1;
            }
            catch (OutOfMemoryError localOutOfMemoryError1)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("CustomFrameAnimationDrawable", 2, localOutOfMemoryError1.toString());
              continue;
            }
            if (localObject1 != null)
            {
              if (CustomFrameAnimationDrawable.a(CustomFrameAnimationDrawable.this)) {
                aqgs.e(str, (Bitmap)localObject1);
              }
              this.qz.add(localObject1);
            }
            CustomFrameAnimationDrawable.this.a = null;
            return;
            if (this.mFileName != null) {
              try
              {
                Bitmap localBitmap2 = aqhu.d(this.mFileName, this.jdField_d_of_type_AndroidGraphicsBitmapFactory$Options);
                localObject1 = localBitmap2;
              }
              catch (OutOfMemoryError localOutOfMemoryError2)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("CustomFrameAnimationDrawable", 2, localOutOfMemoryError2.toString());
                }
              }
            }
          }
        }
        str = null;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void onEnd();
  }
  
  public static final class b
    extends Drawable.ConstantState
  {
    public boolean aPN = true;
    int bSS = 0;
    int bST = 0;
    boolean bgO = false;
    boolean bgP = false;
    public boolean hi = false;
    public int mCurFrameIndex = -1;
    final Paint mPaint = new Paint(6);
    int mTargetDensity = 160;
    public ArrayList<CustomFrameAnimationDrawable.e> qA = new ArrayList();
    public ArrayList<Bitmap> qB = new ArrayList();
    
    public int getChangingConfigurations()
    {
      return 0;
    }
    
    @NonNull
    public Drawable newDrawable()
    {
      return new CustomFrameAnimationDrawable(this, null, null);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new CustomFrameAnimationDrawable(this, paramResources, null);
    }
  }
  
  public static abstract interface c
  {
    public abstract void onUpdate(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract String g(int paramInt1, int paramInt2, int paramInt3);
  }
  
  public static class e
  {
    public int bSU;
    public int mDuration;
    public String mFileName;
    public int mFrameIndex;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */