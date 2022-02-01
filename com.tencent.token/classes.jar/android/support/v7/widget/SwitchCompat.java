package android.support.v7.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import com.tencent.token.dg;
import com.tencent.token.ew;
import com.tencent.token.go.a;
import com.tencent.token.go.j;
import com.tencent.token.gq;
import com.tencent.token.gu;
import com.tencent.token.iq;
import com.tencent.token.je;
import com.tencent.token.jk;
import java.util.List;

public class SwitchCompat
  extends CompoundButton
{
  private static final int[] N = { 16842912 };
  private static final Property<SwitchCompat, Float> b = new Property(Float.class, "thumbPos") {};
  private int A;
  private int B;
  private int C;
  private int D;
  private int E;
  private int F;
  private int G;
  private final TextPaint H;
  private ColorStateList I;
  private Layout J;
  private Layout K;
  private TransformationMethod L;
  private final Rect M = new Rect();
  ObjectAnimator a;
  private Drawable c;
  private ColorStateList d = null;
  private PorterDuff.Mode e = null;
  private boolean f = false;
  private boolean g = false;
  private Drawable h;
  private ColorStateList i = null;
  private PorterDuff.Mode j = null;
  private boolean k = false;
  private boolean l = false;
  private int m;
  private int n;
  private int o;
  private boolean p;
  private CharSequence q;
  private CharSequence r;
  private boolean s;
  private int t;
  private int u;
  private float v;
  private float w;
  private VelocityTracker x = VelocityTracker.obtain();
  private int y;
  private float z;
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, go.a.switchStyle);
  }
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool = true;
    this.H = new TextPaint(1);
    Object localObject = getResources();
    this.H.density = ((Resources)localObject).getDisplayMetrics().density;
    localObject = je.a(paramContext, paramAttributeSet, go.j.SwitchCompat, paramInt, 0);
    this.c = ((je)localObject).a(go.j.SwitchCompat_android_thumb);
    paramAttributeSet = this.c;
    if (paramAttributeSet != null) {
      paramAttributeSet.setCallback(this);
    }
    this.h = ((je)localObject).a(go.j.SwitchCompat_track);
    paramAttributeSet = this.h;
    if (paramAttributeSet != null) {
      paramAttributeSet.setCallback(this);
    }
    this.q = ((je)localObject).c(go.j.SwitchCompat_android_textOn);
    this.r = ((je)localObject).c(go.j.SwitchCompat_android_textOff);
    this.s = ((je)localObject).a(go.j.SwitchCompat_showText, true);
    this.m = ((je)localObject).e(go.j.SwitchCompat_thumbTextPadding, 0);
    this.n = ((je)localObject).e(go.j.SwitchCompat_switchMinWidth, 0);
    this.o = ((je)localObject).e(go.j.SwitchCompat_switchPadding, 0);
    this.p = ((je)localObject).a(go.j.SwitchCompat_splitTrack, false);
    paramAttributeSet = ((je)localObject).e(go.j.SwitchCompat_thumbTint);
    if (paramAttributeSet != null)
    {
      this.d = paramAttributeSet;
      this.f = true;
    }
    paramAttributeSet = iq.a(((je)localObject).a(go.j.SwitchCompat_thumbTintMode, -1), null);
    if (this.e != paramAttributeSet)
    {
      this.e = paramAttributeSet;
      this.g = true;
    }
    if ((this.f) || (this.g)) {
      b();
    }
    paramAttributeSet = ((je)localObject).e(go.j.SwitchCompat_trackTint);
    if (paramAttributeSet != null)
    {
      this.i = paramAttributeSet;
      this.k = true;
    }
    paramAttributeSet = iq.a(((je)localObject).a(go.j.SwitchCompat_trackTintMode, -1), null);
    if (this.j != paramAttributeSet)
    {
      this.j = paramAttributeSet;
      this.l = true;
    }
    if ((this.k) || (this.l)) {
      a();
    }
    paramInt = ((je)localObject).g(go.j.SwitchCompat_switchTextAppearance, 0);
    if (paramInt != 0)
    {
      je localje = je.a(paramContext, paramInt, go.j.TextAppearance);
      paramAttributeSet = localje.e(go.j.TextAppearance_android_textColor);
      if (paramAttributeSet != null) {
        this.I = paramAttributeSet;
      } else {
        this.I = getTextColors();
      }
      paramInt = localje.e(go.j.TextAppearance_android_textSize, 0);
      if (paramInt != 0)
      {
        f1 = paramInt;
        if (f1 != this.H.getTextSize())
        {
          this.H.setTextSize(f1);
          requestLayout();
        }
      }
      paramInt = localje.a(go.j.TextAppearance_android_typeface, -1);
      int i1 = localje.a(go.j.TextAppearance_android_textStyle, -1);
      switch (paramInt)
      {
      default: 
        paramAttributeSet = null;
        break;
      case 3: 
        paramAttributeSet = Typeface.MONOSPACE;
        break;
      case 2: 
        paramAttributeSet = Typeface.SERIF;
        break;
      case 1: 
        paramAttributeSet = Typeface.SANS_SERIF;
      }
      float f1 = 0.0F;
      if (i1 > 0)
      {
        if (paramAttributeSet == null) {
          paramAttributeSet = Typeface.defaultFromStyle(i1);
        } else {
          paramAttributeSet = Typeface.create(paramAttributeSet, i1);
        }
        setSwitchTypeface(paramAttributeSet);
        if (paramAttributeSet != null) {
          paramInt = paramAttributeSet.getStyle();
        } else {
          paramInt = 0;
        }
        paramInt = (0xFFFFFFFF ^ paramInt) & i1;
        paramAttributeSet = this.H;
        if ((paramInt & 0x1) == 0) {
          bool = false;
        }
        paramAttributeSet.setFakeBoldText(bool);
        paramAttributeSet = this.H;
        if ((paramInt & 0x2) != 0) {
          f1 = -0.25F;
        }
        paramAttributeSet.setTextSkewX(f1);
      }
      else
      {
        this.H.setFakeBoldText(false);
        this.H.setTextSkewX(0.0F);
        setSwitchTypeface(paramAttributeSet);
      }
      if (localje.a(go.j.TextAppearance_textAllCaps, false)) {
        this.L = new gu(getContext());
      } else {
        this.L = null;
      }
      localje.a.recycle();
    }
    ((je)localObject).a.recycle();
    paramContext = ViewConfiguration.get(paramContext);
    this.u = paramContext.getScaledTouchSlop();
    this.y = paramContext.getScaledMinimumFlingVelocity();
    refreshDrawableState();
    setChecked(isChecked());
  }
  
  private Layout a(CharSequence paramCharSequence)
  {
    TransformationMethod localTransformationMethod = this.L;
    CharSequence localCharSequence = paramCharSequence;
    if (localTransformationMethod != null) {
      localCharSequence = localTransformationMethod.getTransformation(paramCharSequence, this);
    }
    paramCharSequence = this.H;
    int i1;
    if (localCharSequence != null) {
      i1 = (int)Math.ceil(Layout.getDesiredWidth(localCharSequence, paramCharSequence));
    } else {
      i1 = 0;
    }
    return new StaticLayout(localCharSequence, paramCharSequence, i1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
  }
  
  private void a()
  {
    if ((this.h != null) && ((this.k) || (this.l)))
    {
      this.h = this.h.mutate();
      if (this.k) {
        dg.a(this.h, this.i);
      }
      if (this.l) {
        dg.a(this.h, this.j);
      }
      if (this.h.isStateful()) {
        this.h.setState(getDrawableState());
      }
    }
  }
  
  private void b()
  {
    if ((this.c != null) && ((this.f) || (this.g)))
    {
      this.c = this.c.mutate();
      if (this.f) {
        dg.a(this.c, this.d);
      }
      if (this.g) {
        dg.a(this.c, this.e);
      }
      if (this.c.isStateful()) {
        this.c.setState(getDrawableState());
      }
    }
  }
  
  private boolean getTargetCheckedState()
  {
    return this.z > 0.5F;
  }
  
  private int getThumbOffset()
  {
    float f1;
    if (jk.a(this)) {
      f1 = 1.0F - this.z;
    } else {
      f1 = this.z;
    }
    return (int)(f1 * getThumbScrollRange() + 0.5F);
  }
  
  private int getThumbScrollRange()
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      Rect localRect = this.M;
      ((Drawable)localObject).getPadding(localRect);
      localObject = this.c;
      if (localObject != null) {
        localObject = iq.a((Drawable)localObject);
      } else {
        localObject = iq.a;
      }
      return this.A - this.C - localRect.left - localRect.right - ((Rect)localObject).left - ((Rect)localObject).right;
    }
    return 0;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = this.M;
    int i2 = this.D;
    int i4 = this.E;
    int i6 = this.F;
    int i5 = this.G;
    int i3 = getThumbOffset() + i2;
    Object localObject = this.c;
    if (localObject != null) {
      localObject = iq.a((Drawable)localObject);
    } else {
      localObject = iq.a;
    }
    Drawable localDrawable = this.h;
    int i1 = i3;
    if (localDrawable != null)
    {
      localDrawable.getPadding(localRect);
      int i8 = i3 + localRect.left;
      int i7;
      if (localObject != null)
      {
        i1 = i2;
        if (((Rect)localObject).left > localRect.left) {
          i1 = i2 + (((Rect)localObject).left - localRect.left);
        }
        if (((Rect)localObject).top > localRect.top) {
          i2 = ((Rect)localObject).top - localRect.top + i4;
        } else {
          i2 = i4;
        }
        i3 = i6;
        if (((Rect)localObject).right > localRect.right) {
          i3 = i6 - (((Rect)localObject).right - localRect.right);
        }
        if (((Rect)localObject).bottom > localRect.bottom)
        {
          i7 = i5 - (((Rect)localObject).bottom - localRect.bottom);
          i6 = i1;
          i1 = i7;
          i7 = i2;
        }
        else
        {
          i7 = i5;
          i6 = i1;
          i1 = i7;
          i7 = i2;
        }
      }
      else
      {
        i7 = i4;
        i1 = i5;
        i3 = i6;
        i6 = i2;
      }
      this.h.setBounds(i6, i7, i3, i1);
      i1 = i8;
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((Drawable)localObject).getPadding(localRect);
      i2 = i1 - localRect.left;
      i1 = i1 + this.C + localRect.right;
      this.c.setBounds(i2, i4, i1, i5);
      localObject = getBackground();
      if (localObject != null) {
        dg.a((Drawable)localObject, i2, i4, i1, i5);
      }
    }
    super.draw(paramCanvas);
  }
  
  public void drawableHotspotChanged(float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      super.drawableHotspotChanged(paramFloat1, paramFloat2);
    }
    Drawable localDrawable = this.c;
    if (localDrawable != null) {
      dg.a(localDrawable, paramFloat1, paramFloat2);
    }
    localDrawable = this.h;
    if (localDrawable != null) {
      dg.a(localDrawable, paramFloat1, paramFloat2);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Drawable localDrawable = this.c;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = false | localDrawable.setState(arrayOfInt);
      }
    }
    localDrawable = this.h;
    bool2 = bool1;
    if (localDrawable != null)
    {
      bool2 = bool1;
      if (localDrawable.isStateful()) {
        bool2 = bool1 | localDrawable.setState(arrayOfInt);
      }
    }
    if (bool2) {
      invalidate();
    }
  }
  
  public int getCompoundPaddingLeft()
  {
    if (!jk.a(this)) {
      return super.getCompoundPaddingLeft();
    }
    int i2 = super.getCompoundPaddingLeft() + this.A;
    int i1 = i2;
    if (!TextUtils.isEmpty(getText())) {
      i1 = i2 + this.o;
    }
    return i1;
  }
  
  public int getCompoundPaddingRight()
  {
    if (jk.a(this)) {
      return super.getCompoundPaddingRight();
    }
    int i2 = super.getCompoundPaddingRight() + this.A;
    int i1 = i2;
    if (!TextUtils.isEmpty(getText())) {
      i1 = i2 + this.o;
    }
    return i1;
  }
  
  public boolean getShowText()
  {
    return this.s;
  }
  
  public boolean getSplitTrack()
  {
    return this.p;
  }
  
  public int getSwitchMinWidth()
  {
    return this.n;
  }
  
  public int getSwitchPadding()
  {
    return this.o;
  }
  
  public CharSequence getTextOff()
  {
    return this.r;
  }
  
  public CharSequence getTextOn()
  {
    return this.q;
  }
  
  public Drawable getThumbDrawable()
  {
    return this.c;
  }
  
  public int getThumbTextPadding()
  {
    return this.m;
  }
  
  public ColorStateList getThumbTintList()
  {
    return this.d;
  }
  
  public PorterDuff.Mode getThumbTintMode()
  {
    return this.e;
  }
  
  public Drawable getTrackDrawable()
  {
    return this.h;
  }
  
  public ColorStateList getTrackTintList()
  {
    return this.i;
  }
  
  public PorterDuff.Mode getTrackTintMode()
  {
    return this.j;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    Object localObject = this.c;
    if (localObject != null) {
      ((Drawable)localObject).jumpToCurrentState();
    }
    localObject = this.h;
    if (localObject != null) {
      ((Drawable)localObject).jumpToCurrentState();
    }
    localObject = this.a;
    if ((localObject != null) && (((ObjectAnimator)localObject).isStarted()))
    {
      this.a.end();
      this.a = null;
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, N);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject1 = this.M;
    Object localObject3 = this.h;
    if (localObject3 != null) {
      ((Drawable)localObject3).getPadding((Rect)localObject1);
    } else {
      ((Rect)localObject1).setEmpty();
    }
    int i3 = this.E;
    int i4 = this.G;
    int i5 = ((Rect)localObject1).top;
    int i6 = ((Rect)localObject1).bottom;
    Object localObject2 = this.c;
    Object localObject4;
    int i1;
    if (localObject3 != null) {
      if ((this.p) && (localObject2 != null))
      {
        localObject4 = iq.a((Drawable)localObject2);
        ((Drawable)localObject2).copyBounds((Rect)localObject1);
        ((Rect)localObject1).left += ((Rect)localObject4).left;
        ((Rect)localObject1).right -= ((Rect)localObject4).right;
        i1 = paramCanvas.save();
        paramCanvas.clipRect((Rect)localObject1, Region.Op.DIFFERENCE);
        ((Drawable)localObject3).draw(paramCanvas);
        paramCanvas.restoreToCount(i1);
      }
      else
      {
        ((Drawable)localObject3).draw(paramCanvas);
      }
    }
    int i2 = paramCanvas.save();
    if (localObject2 != null) {
      ((Drawable)localObject2).draw(paramCanvas);
    }
    if (getTargetCheckedState()) {
      localObject1 = this.J;
    } else {
      localObject1 = this.K;
    }
    if (localObject1 != null)
    {
      localObject3 = getDrawableState();
      localObject4 = this.I;
      if (localObject4 != null) {
        this.H.setColor(((ColorStateList)localObject4).getColorForState((int[])localObject3, 0));
      }
      this.H.drawableState = ((int[])localObject3);
      if (localObject2 != null)
      {
        localObject2 = ((Drawable)localObject2).getBounds();
        i1 = ((Rect)localObject2).left + ((Rect)localObject2).right;
      }
      else
      {
        i1 = getWidth();
      }
      i1 /= 2;
      int i7 = ((Layout)localObject1).getWidth() / 2;
      i3 = (i3 + i5 + (i4 - i6)) / 2;
      i4 = ((Layout)localObject1).getHeight() / 2;
      paramCanvas.translate(i1 - i7, i3 - i4);
      ((Layout)localObject1).draw(paramCanvas);
    }
    paramCanvas.restoreToCount(i2);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName("android.widget.Switch");
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName("android.widget.Switch");
    CharSequence localCharSequence1;
    if (isChecked()) {
      localCharSequence1 = this.q;
    } else {
      localCharSequence1 = this.r;
    }
    if (!TextUtils.isEmpty(localCharSequence1))
    {
      CharSequence localCharSequence2 = paramAccessibilityNodeInfo.getText();
      if (TextUtils.isEmpty(localCharSequence2))
      {
        paramAccessibilityNodeInfo.setText(localCharSequence1);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localCharSequence2);
      localStringBuilder.append(' ');
      localStringBuilder.append(localCharSequence1);
      paramAccessibilityNodeInfo.setText(localStringBuilder);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject1 = this.c;
    paramInt1 = 0;
    if (localObject1 != null)
    {
      localObject1 = this.M;
      Object localObject2 = this.h;
      if (localObject2 != null) {
        ((Drawable)localObject2).getPadding((Rect)localObject1);
      } else {
        ((Rect)localObject1).setEmpty();
      }
      localObject2 = iq.a(this.c);
      paramInt2 = Math.max(0, ((Rect)localObject2).left - ((Rect)localObject1).left);
      paramInt1 = Math.max(0, ((Rect)localObject2).right - ((Rect)localObject1).right);
    }
    else
    {
      paramInt2 = 0;
    }
    if (jk.a(this))
    {
      paramInt3 = getPaddingLeft() + paramInt2;
      paramInt4 = this.A + paramInt3 - paramInt2 - paramInt1;
    }
    else
    {
      paramInt4 = getWidth() - getPaddingRight() - paramInt1;
      paramInt3 = paramInt4 - this.A + paramInt2 + paramInt1;
    }
    paramInt1 = getGravity() & 0x70;
    if (paramInt1 != 16)
    {
      if (paramInt1 != 80)
      {
        paramInt1 = getPaddingTop();
        paramInt2 = this.B + paramInt1;
      }
      else
      {
        paramInt2 = getHeight() - getPaddingBottom();
        paramInt1 = paramInt2 - this.B;
      }
    }
    else
    {
      paramInt1 = (getPaddingTop() + getHeight() - getPaddingBottom()) / 2;
      paramInt2 = this.B;
      paramInt1 -= paramInt2 / 2;
      paramInt2 += paramInt1;
    }
    this.D = paramInt3;
    this.E = paramInt1;
    this.G = paramInt2;
    this.F = paramInt4;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.s)
    {
      if (this.J == null) {
        this.J = a(this.q);
      }
      if (this.K == null) {
        this.K = a(this.r);
      }
    }
    Object localObject = this.M;
    Drawable localDrawable = this.c;
    int i4 = 0;
    int i2;
    if (localDrawable != null)
    {
      localDrawable.getPadding((Rect)localObject);
      i2 = this.c.getIntrinsicWidth() - ((Rect)localObject).left - ((Rect)localObject).right;
      i1 = this.c.getIntrinsicHeight();
    }
    else
    {
      i2 = 0;
      i1 = 0;
    }
    if (this.s) {
      i3 = Math.max(this.J.getWidth(), this.K.getWidth()) + this.m * 2;
    } else {
      i3 = 0;
    }
    this.C = Math.max(i3, i2);
    localDrawable = this.h;
    if (localDrawable != null)
    {
      localDrawable.getPadding((Rect)localObject);
      i2 = this.h.getIntrinsicHeight();
    }
    else
    {
      ((Rect)localObject).setEmpty();
      i2 = i4;
    }
    int i6 = ((Rect)localObject).left;
    int i5 = ((Rect)localObject).right;
    localObject = this.c;
    i4 = i5;
    int i3 = i6;
    if (localObject != null)
    {
      localObject = iq.a((Drawable)localObject);
      i3 = Math.max(i6, ((Rect)localObject).left);
      i4 = Math.max(i5, ((Rect)localObject).right);
    }
    i3 = Math.max(this.n, this.C * 2 + i3 + i4);
    int i1 = Math.max(i2, i1);
    this.A = i3;
    this.B = i1;
    super.onMeasure(paramInt1, paramInt2);
    if (getMeasuredHeight() < i1) {
      setMeasuredDimension(getMeasuredWidthAndState(), i1);
    }
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    CharSequence localCharSequence;
    if (isChecked()) {
      localCharSequence = this.q;
    } else {
      localCharSequence = this.r;
    }
    if (localCharSequence != null) {
      paramAccessibilityEvent.getText().add(localCharSequence);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.x.addMovement(paramMotionEvent);
    int i1 = paramMotionEvent.getActionMasked();
    int i2 = 0;
    float f1;
    float f2;
    switch (i1)
    {
    default: 
      break;
    case 2: 
      switch (this.t)
      {
      default: 
        break;
      case 2: 
        float f3 = paramMotionEvent.getX();
        i1 = getThumbScrollRange();
        f1 = f3 - this.v;
        if (i1 != 0) {
          f1 /= i1;
        } else if (f1 > 0.0F) {
          f1 = 1.0F;
        } else {
          f1 = -1.0F;
        }
        f2 = f1;
        if (jk.a(this)) {
          f2 = -f1;
        }
        f2 += this.z;
        if (f2 < 0.0F)
        {
          f1 = 0.0F;
        }
        else
        {
          f1 = f2;
          if (f2 > 1.0F) {
            f1 = 1.0F;
          }
        }
        if (f1 != this.z)
        {
          this.v = f3;
          setThumbPosition(f1);
        }
        return true;
      case 1: 
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        if ((Math.abs(f1 - this.v) > this.u) || (Math.abs(f2 - this.w) > this.u))
        {
          this.t = 2;
          getParent().requestDisallowInterceptTouchEvent(true);
          this.v = f1;
          this.w = f2;
          return true;
        }
        break;
      }
      break;
    case 1: 
    case 3: 
      if (this.t == 2)
      {
        this.t = 0;
        if ((paramMotionEvent.getAction() == 1) && (isEnabled())) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        boolean bool2 = isChecked();
        boolean bool1;
        if (i1 != 0)
        {
          this.x.computeCurrentVelocity(1000);
          f1 = this.x.getXVelocity();
          if (Math.abs(f1) > this.y)
          {
            if (jk.a(this) ? f1 < 0.0F : f1 > 0.0F) {
              bool1 = true;
            } else {
              bool1 = false;
            }
          }
          else {
            bool1 = getTargetCheckedState();
          }
        }
        else
        {
          bool1 = bool2;
        }
        if (bool1 != bool2) {
          playSoundEffect(0);
        }
        setChecked(bool1);
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        localMotionEvent.setAction(3);
        super.onTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
        super.onTouchEvent(paramMotionEvent);
        return true;
      }
      this.t = 0;
      this.x.clear();
      break;
    case 0: 
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      if (isEnabled())
      {
        i1 = i2;
        if (this.c != null)
        {
          i1 = getThumbOffset();
          this.c.getPadding(this.M);
          int i3 = this.E;
          int i4 = this.u;
          int i5 = this.D + i1 - i4;
          int i6 = this.C;
          int i7 = this.M.left;
          int i8 = this.M.right;
          int i9 = this.u;
          int i10 = this.G;
          i1 = i2;
          if (f1 > i5)
          {
            i1 = i2;
            if (f1 < i6 + i5 + i7 + i8 + i9)
            {
              i1 = i2;
              if (f2 > i3 - i4)
              {
                i1 = i2;
                if (f2 < i10 + i9) {
                  i1 = 1;
                }
              }
            }
          }
        }
        if (i1 != 0)
        {
          this.t = 1;
          this.v = f1;
          this.w = f2;
        }
      }
      break;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    super.setChecked(paramBoolean);
    paramBoolean = isChecked();
    Object localObject = getWindowToken();
    float f1 = 1.0F;
    if ((localObject != null) && (ew.q(this)))
    {
      if (!paramBoolean) {
        f1 = 0.0F;
      }
      this.a = ObjectAnimator.ofFloat(this, b, new float[] { f1 });
      this.a.setDuration(250L);
      if (Build.VERSION.SDK_INT >= 18) {
        this.a.setAutoCancel(true);
      }
      this.a.start();
      return;
    }
    localObject = this.a;
    if (localObject != null) {
      ((ObjectAnimator)localObject).cancel();
    }
    if (!paramBoolean) {
      f1 = 0.0F;
    }
    setThumbPosition(f1);
  }
  
  public void setShowText(boolean paramBoolean)
  {
    if (this.s != paramBoolean)
    {
      this.s = paramBoolean;
      requestLayout();
    }
  }
  
  public void setSplitTrack(boolean paramBoolean)
  {
    this.p = paramBoolean;
    invalidate();
  }
  
  public void setSwitchMinWidth(int paramInt)
  {
    this.n = paramInt;
    requestLayout();
  }
  
  public void setSwitchPadding(int paramInt)
  {
    this.o = paramInt;
    requestLayout();
  }
  
  public void setSwitchTypeface(Typeface paramTypeface)
  {
    if (((this.H.getTypeface() != null) && (!this.H.getTypeface().equals(paramTypeface))) || ((this.H.getTypeface() == null) && (paramTypeface != null)))
    {
      this.H.setTypeface(paramTypeface);
      requestLayout();
      invalidate();
    }
  }
  
  public void setTextOff(CharSequence paramCharSequence)
  {
    this.r = paramCharSequence;
    requestLayout();
  }
  
  public void setTextOn(CharSequence paramCharSequence)
  {
    this.q = paramCharSequence;
    requestLayout();
  }
  
  public void setThumbDrawable(Drawable paramDrawable)
  {
    Drawable localDrawable = this.c;
    if (localDrawable != null) {
      localDrawable.setCallback(null);
    }
    this.c = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    requestLayout();
  }
  
  void setThumbPosition(float paramFloat)
  {
    this.z = paramFloat;
    invalidate();
  }
  
  public void setThumbResource(int paramInt)
  {
    setThumbDrawable(gq.b(getContext(), paramInt));
  }
  
  public void setThumbTextPadding(int paramInt)
  {
    this.m = paramInt;
    requestLayout();
  }
  
  public void setThumbTintList(ColorStateList paramColorStateList)
  {
    this.d = paramColorStateList;
    this.f = true;
    b();
  }
  
  public void setThumbTintMode(PorterDuff.Mode paramMode)
  {
    this.e = paramMode;
    this.g = true;
    b();
  }
  
  public void setTrackDrawable(Drawable paramDrawable)
  {
    Drawable localDrawable = this.h;
    if (localDrawable != null) {
      localDrawable.setCallback(null);
    }
    this.h = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    requestLayout();
  }
  
  public void setTrackResource(int paramInt)
  {
    setTrackDrawable(gq.b(getContext(), paramInt));
  }
  
  public void setTrackTintList(ColorStateList paramColorStateList)
  {
    this.i = paramColorStateList;
    this.k = true;
    a();
  }
  
  public void setTrackTintMode(PorterDuff.Mode paramMode)
  {
    this.j = paramMode;
    this.l = true;
    a();
  }
  
  public void toggle()
  {
    setChecked(isChecked() ^ true);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.c) || (paramDrawable == this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.SwitchCompat
 * JD-Core Version:    0.7.0.1
 */