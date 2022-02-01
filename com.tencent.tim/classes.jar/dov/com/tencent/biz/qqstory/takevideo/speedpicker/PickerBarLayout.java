package dov.com.tencent.biz.qqstory.takevideo.speedpicker;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import ayrx;
import ayrx.a;
import aysn;
import aysn.a;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class PickerBarLayout
  extends RelativeLayout
  implements ayrx.a, aysn.a
{
  private float GE = 38.0F;
  private float GF = 50.0F;
  private float GG = 18.0F;
  private float GH = 146.0F;
  private float GI = 102.0F;
  private float GJ = 22.0F;
  private float GK = 22.0F;
  private float GL = 4.0F;
  private float GM = 36.0F;
  private float GN;
  private List<String> NF = new ArrayList();
  private View Nr;
  private CheckForLongPress a;
  private ayrx jdField_b_of_type_Ayrx;
  private aysn jdField_b_of_type_Aysn;
  private int mActivePointerId = -1;
  private int mCurIndex;
  boolean mHasPerformedLongPress;
  private WeakReference<a> mListenerRef;
  private View tS;
  
  public PickerBarLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public PickerBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PickerBarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int A(float paramFloat)
  {
    if (this.jdField_b_of_type_Ayrx != null) {
      return this.jdField_b_of_type_Ayrx.y(paramFloat);
    }
    return -1;
  }
  
  private void bM(float paramFloat)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    float f;
    if (this.tS != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.tS.getLayoutParams();
      if (localLayoutParams != null)
      {
        if (paramFloat >= this.GI / 2.0F + this.GJ) {
          break label82;
        }
        f = this.GI / 2.0F + this.GJ;
      }
    }
    for (;;)
    {
      localLayoutParams.topMargin = Math.round(f - this.GI / 2.0F);
      localLayoutParams.bottomMargin = Math.round(-this.GI);
      requestLayout();
      return;
      label82:
      f = paramFloat;
      if (paramFloat > getHeight() - this.GI / 2.0F - this.GK) {
        f = getHeight() - this.GI / 2.0F - this.GK;
      }
    }
  }
  
  private float cn()
  {
    return Math.round(this.GG) - this.GG - (Math.round(this.GL) - this.GL) + (Math.round(this.GF) - this.GF);
  }
  
  private void eTu()
  {
    this.tS = new View(getContext());
    this.jdField_b_of_type_Aysn = new aysn();
    this.jdField_b_of_type_Aysn.a(getContext(), 2130840140, 2130840139, 2130840141, this);
    this.tS.setBackground(this.jdField_b_of_type_Aysn);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(Math.round(this.GH), Math.round(this.GI));
    localLayoutParams.addRule(11);
    localLayoutParams.setMargins(0, 0, Math.round(this.GL), 0);
    addView(this.tS, localLayoutParams);
  }
  
  private void eTv()
  {
    this.Nr = new View(getContext());
    this.jdField_b_of_type_Ayrx = new ayrx();
    float f = cn();
    this.jdField_b_of_type_Ayrx.a(getContext(), this.NF.size(), (Math.round(this.GF) - this.GE) / 2.0F + f, (Math.round(this.GF) - this.GE) / 2.0F - f, this);
    this.Nr.setBackground(this.jdField_b_of_type_Ayrx);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(Math.round(this.GF), -1);
    localLayoutParams.addRule(11);
    localLayoutParams.setMargins(0, 0, Math.round(this.GG), 0);
    addView(this.Nr, localLayoutParams);
  }
  
  private void gI(Context paramContext)
  {
    this.GE = PickerContainer.c(paramContext, this.GE);
    this.GF = PickerContainer.c(paramContext, this.GF);
    this.GG = PickerContainer.c(paramContext, this.GG);
    this.GH = PickerContainer.c(paramContext, this.GH);
    this.GI = PickerContainer.c(paramContext, this.GI);
    this.GL = PickerContainer.c(paramContext, this.GL);
    this.GJ = PickerContainer.c(paramContext, this.GJ);
    this.GK = PickerContainer.c(paramContext, this.GK);
    this.GM = PickerContainer.c(paramContext, this.GM);
  }
  
  private boolean n(float paramFloat)
  {
    return getWidth() - this.GG - this.GF <= paramFloat;
  }
  
  private void u(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramInt >= 0) && (paramInt < this.NF.size()) && (this.mListenerRef != null))
    {
      a locala = (a)this.mListenerRef.get();
      if (locala != null) {
        locala.f(paramInt, (String)this.NF.get(paramInt), paramBoolean1, paramBoolean2);
      }
    }
  }
  
  private void v(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a locala;
    if (this.mListenerRef != null)
    {
      locala = (a)this.mListenerRef.get();
      if (locala != null)
      {
        if (!paramBoolean1) {
          break label50;
        }
        if (!paramBoolean2) {
          break label41;
        }
        locala.afC(paramInt);
      }
    }
    return;
    label41:
    locala.afD(paramInt);
    return;
    label50:
    if (paramBoolean2)
    {
      locala.afF(paramInt);
      return;
    }
    locala.afG(paramInt);
  }
  
  private int z(float paramFloat)
  {
    this.GN = paramFloat;
    int i = A(paramFloat);
    if (QLog.isColorLevel()) {
      QLog.d("PickerBarLayout", 2, "movemark posY:" + paramFloat + " markindex:" + i + "  curIndex:" + this.mCurIndex);
    }
    if (i != this.mCurIndex)
    {
      this.mCurIndex = i;
      u(this.mCurIndex, false, false);
    }
    setMarkText(this.mCurIndex);
    float f = paramFloat;
    if (this.mHasPerformedLongPress) {
      f = paramFloat - this.GM;
    }
    bM(f);
    invalidate();
    return this.mCurIndex;
  }
  
  public int Sh()
  {
    return this.NF.size();
  }
  
  public void a(int paramInt1, int paramInt2, RectF paramRectF)
  {
    if ((this.jdField_b_of_type_Ayrx != null) && (paramRectF != null)) {
      bM(paramRectF.centerY());
    }
  }
  
  public void a(int paramInt, RectF paramRectF)
  {
    if (((paramInt == 1) || (paramInt == 4)) && (paramRectF != null)) {
      bM(paramRectF.centerY());
    }
  }
  
  public boolean a(EditVideoParams paramEditVideoParams, Context paramContext, a parama)
  {
    this.mListenerRef = new WeakReference(parama);
    gI(paramContext);
    this.NF.add("4x");
    this.NF.add("2x");
    this.NF.add("1x");
    if (paramEditVideoParams.Li())
    {
      this.NF.add("1/2");
      this.NF.add("1/4");
    }
    if (paramEditVideoParams.Lh()) {
      this.NF.add(PickerContainer.cXS);
    }
    eTv();
    eTu();
    return true;
  }
  
  public void afC(int paramInt)
  {
    if (paramInt == 1) {}
    for (;;)
    {
      v(paramInt, true, true);
      return;
      if ((paramInt != 4) && (this.jdField_b_of_type_Aysn != null)) {
        this.jdField_b_of_type_Aysn.stop();
      }
    }
  }
  
  public void afD(int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.tS != null) {
        this.tS.setVisibility(0);
      }
      if (this.jdField_b_of_type_Ayrx.a(this.GN) != null) {
        bM(this.GN - this.GM);
      }
      if (this.jdField_b_of_type_Aysn != null)
      {
        setMarkText(this.mCurIndex);
        this.jdField_b_of_type_Aysn.stop();
        this.jdField_b_of_type_Aysn.afv(2);
        this.jdField_b_of_type_Aysn.start();
      }
    }
    for (;;)
    {
      v(paramInt, true, false);
      return;
      if (paramInt == 3)
      {
        if (this.jdField_b_of_type_Ayrx != null)
        {
          RectF localRectF = this.jdField_b_of_type_Ayrx.o();
          if (localRectF != null) {
            bM(localRectF.centerY());
          }
        }
        if (this.tS != null) {
          this.tS.setVisibility(0);
        }
        if (this.jdField_b_of_type_Aysn != null)
        {
          this.jdField_b_of_type_Aysn.stop();
          this.jdField_b_of_type_Aysn.afv(5);
          this.jdField_b_of_type_Aysn.start();
        }
      }
      else if ((paramInt != 4) && (paramInt == 0) && (this.jdField_b_of_type_Aysn != null))
      {
        this.jdField_b_of_type_Aysn.stop();
        this.jdField_b_of_type_Aysn.afv(1);
        this.jdField_b_of_type_Aysn.start();
      }
    }
  }
  
  public void afE(int paramInt)
  {
    if (this.jdField_b_of_type_Aysn != null) {
      this.jdField_b_of_type_Aysn.stop();
    }
  }
  
  public void afF(int paramInt)
  {
    v(paramInt, false, true);
  }
  
  public void afG(int paramInt)
  {
    if (paramInt == 2) {}
    for (;;)
    {
      v(paramInt, false, false);
      return;
      if (paramInt == 4)
      {
        if (this.jdField_b_of_type_Ayrx != null)
        {
          this.jdField_b_of_type_Ayrx.stop();
          this.jdField_b_of_type_Ayrx.afv(3);
          this.jdField_b_of_type_Ayrx.start();
        }
      }
      else if (paramInt == 6) {
        bM(this.GN);
      }
    }
  }
  
  public void afH(int paramInt) {}
  
  public void bK(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PickerBarLayout", 2, "startenter:" + paramFloat);
    }
    this.GN = paramFloat;
    this.mCurIndex = A(paramFloat);
    u(this.mCurIndex, true, false);
    int i;
    int j;
    if ((this.jdField_b_of_type_Aysn != null) && (this.jdField_b_of_type_Ayrx != null))
    {
      i = this.jdField_b_of_type_Aysn.Sf();
      boolean bool1 = this.jdField_b_of_type_Aysn.isRunning();
      j = this.jdField_b_of_type_Ayrx.Sf();
      boolean bool2 = this.jdField_b_of_type_Ayrx.isRunning();
      if (QLog.isColorLevel()) {
        QLog.d("PickerBarLayout", 2, "drawable state, markdrawble:" + i + " isrun:" + bool1 + "  groundrawable:" + j + " isrun:" + bool2);
      }
      if ((i != 1) || (j != 0)) {
        break label223;
      }
      this.jdField_b_of_type_Aysn.stop();
      this.jdField_b_of_type_Aysn.afv(6);
      this.jdField_b_of_type_Aysn.start();
      this.jdField_b_of_type_Ayrx.stop();
      this.jdField_b_of_type_Ayrx.afv(1);
      this.jdField_b_of_type_Ayrx.start();
    }
    label223:
    do
    {
      return;
      if (i == 4)
      {
        this.jdField_b_of_type_Aysn.stop();
        this.jdField_b_of_type_Aysn.afv(2);
        this.jdField_b_of_type_Aysn.start();
        return;
      }
      if (j == 3)
      {
        this.jdField_b_of_type_Ayrx.stop();
        this.jdField_b_of_type_Ayrx.afv(1);
        this.jdField_b_of_type_Ayrx.start();
        return;
      }
      if (i == 5)
      {
        this.jdField_b_of_type_Aysn.stop();
        this.jdField_b_of_type_Aysn.afv(6);
        this.jdField_b_of_type_Aysn.start();
        this.jdField_b_of_type_Ayrx.stop();
        this.jdField_b_of_type_Ayrx.afv(1);
        this.jdField_b_of_type_Ayrx.start();
        return;
      }
      if (j == 4)
      {
        this.jdField_b_of_type_Ayrx.stop();
        this.jdField_b_of_type_Ayrx.afv(1);
        this.jdField_b_of_type_Ayrx.start();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PickerBarLayout", 2, "startenter: state not process!!");
  }
  
  public void bL(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PickerBarLayout", 2, "startleave:" + paramFloat);
    }
    this.GN = paramFloat;
    int i = z(this.GN);
    if (i != this.mCurIndex) {
      this.mCurIndex = i;
    }
    u(this.mCurIndex, false, true);
    int j;
    if ((this.jdField_b_of_type_Aysn != null) && (this.jdField_b_of_type_Ayrx != null))
    {
      this.jdField_b_of_type_Ayrx.a(this.mCurIndex, false, false);
      i = this.jdField_b_of_type_Aysn.Sf();
      boolean bool1 = this.jdField_b_of_type_Aysn.isRunning();
      j = this.jdField_b_of_type_Ayrx.Sf();
      boolean bool2 = this.jdField_b_of_type_Ayrx.isRunning();
      if (QLog.isColorLevel()) {
        QLog.d("PickerBarLayout", 2, "drawable state, markdrawble:" + i + " isrun:" + bool1 + "  groundrawable:" + j + " isrun:" + bool2);
      }
      if ((i != 3) || (j != 2)) {
        break label228;
      }
      this.jdField_b_of_type_Aysn.stop();
      this.jdField_b_of_type_Aysn.afv(4);
      this.jdField_b_of_type_Aysn.start();
    }
    label228:
    do
    {
      return;
      if (j == 1)
      {
        this.jdField_b_of_type_Ayrx.stop();
        this.jdField_b_of_type_Ayrx.afv(3);
        this.jdField_b_of_type_Ayrx.start();
        return;
      }
      if (i == 2)
      {
        this.jdField_b_of_type_Aysn.stop();
        this.jdField_b_of_type_Aysn.afv(4);
        this.jdField_b_of_type_Aysn.start();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PickerBarLayout", 2, "startleave: state not process!!");
  }
  
  public void bs(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 != 4) || (this.jdField_b_of_type_Ayrx == null) || (paramInt3 == 0)) {}
    RectF localRectF;
    do
    {
      return;
      localRectF = this.jdField_b_of_type_Ayrx.a(this.GN);
    } while (localRectF == null);
    bM((localRectF.centerY() - this.GN + this.GM) * (paramInt2 + 1) / paramInt3 + (this.GN - this.GM));
  }
  
  public void cD(int paramInt, boolean paramBoolean)
  {
    this.mCurIndex = paramInt;
    setMarkText(this.mCurIndex);
    if (this.jdField_b_of_type_Ayrx != null) {
      this.jdField_b_of_type_Ayrx.a(this.mCurIndex, true, paramBoolean);
    }
    invalidate();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return true;
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      if (!n(paramMotionEvent.getX())) {
        return false;
      }
      this.GN = paramMotionEvent.getY();
      this.mHasPerformedLongPress = false;
      if (this.a == null) {
        this.a = new CheckForLongPress();
      }
      this.a.cCe();
      postDelayed(this.a, ViewConfiguration.getLongPressTimeout());
      continue;
      int i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      if (i != -1)
      {
        float f = paramMotionEvent.getY(i);
        if (this.mHasPerformedLongPress)
        {
          z(f);
          continue;
          i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
          if (i == -1) {
            if (QLog.isColorLevel()) {
              QLog.d("PickerBarLayout", 2, "ACTION_UP with activePointerIndex = -1");
            }
          }
          for (f = paramMotionEvent.getY();; f = paramMotionEvent.getY(i))
          {
            if (this.mHasPerformedLongPress) {
              break label270;
            }
            if (this.a != null) {
              removeCallbacks(this.a);
            }
            if (this.jdField_b_of_type_Ayrx == null) {
              break;
            }
            paramMotionEvent = this.jdField_b_of_type_Ayrx.a(f);
            if (paramMotionEvent == null) {
              break;
            }
            z(paramMotionEvent.centerY());
            cD(this.mCurIndex, true);
            break;
          }
          label270:
          bL(f);
          this.mActivePointerId = -1;
          this.mHasPerformedLongPress = false;
          continue;
          i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
          if (i != -1)
          {
            paramMotionEvent.getY(i);
            bL(paramMotionEvent.getY());
            this.mActivePointerId = -1;
            this.mHasPerformedLongPress = false;
          }
        }
      }
    }
  }
  
  public void setMarkText(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.NF.size())) {}
    while (this.jdField_b_of_type_Aysn == null) {
      return;
    }
    this.jdField_b_of_type_Aysn.setText((String)this.NF.get(paramInt));
  }
  
  public void unInit()
  {
    this.mListenerRef = null;
    if (this.jdField_b_of_type_Ayrx != null) {
      this.jdField_b_of_type_Ayrx.stop();
    }
    if (this.jdField_b_of_type_Aysn != null) {
      this.jdField_b_of_type_Aysn.stop();
    }
    this.NF.clear();
    this.tS = null;
    if (this.jdField_b_of_type_Aysn != null)
    {
      this.jdField_b_of_type_Aysn.unInit();
      this.jdField_b_of_type_Aysn = null;
    }
    this.Nr = null;
    if (this.jdField_b_of_type_Ayrx != null)
    {
      this.jdField_b_of_type_Ayrx.unInit();
      this.jdField_b_of_type_Ayrx = null;
    }
    this.mActivePointerId = -1;
  }
  
  class CheckForLongPress
    implements Runnable
  {
    private int cpb;
    
    CheckForLongPress() {}
    
    public void cCe()
    {
      this.cpb = PickerBarLayout.b(PickerBarLayout.this);
    }
    
    public void run()
    {
      if ((PickerBarLayout.this.getParent() != null) && (this.cpb == PickerBarLayout.a(PickerBarLayout.this)))
      {
        PickerBarLayout.this.mHasPerformedLongPress = true;
        PickerBarLayout.this.getParent().requestDisallowInterceptTouchEvent(true);
        PickerBarLayout.this.sendAccessibilityEvent(2);
        PickerBarLayout.this.bK(PickerBarLayout.a(PickerBarLayout.this));
      }
    }
  }
  
  static abstract interface a
  {
    public abstract void afC(int paramInt);
    
    public abstract void afD(int paramInt);
    
    public abstract void afF(int paramInt);
    
    public abstract void afG(int paramInt);
    
    public abstract void f(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerBarLayout
 * JD-Core Version:    0.7.0.1
 */