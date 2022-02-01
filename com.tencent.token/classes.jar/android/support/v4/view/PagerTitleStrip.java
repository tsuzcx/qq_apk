package android.support.v4.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.token.eu;
import com.tencent.token.fx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@ViewPager.a
public class PagerTitleStrip
  extends ViewGroup
{
  private static final int[] n = { 16842804, 16842901, 16842904, 16842927 };
  private static final int[] o = { 16843660 };
  ViewPager a;
  TextView b;
  TextView c;
  TextView d;
  float e = -1.0F;
  int f;
  private int g = -1;
  private int h;
  private int i;
  private boolean j;
  private boolean k;
  private final a l = new a();
  private WeakReference<eu> m;
  private int p;
  
  public PagerTitleStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TextView localTextView = new TextView(paramContext);
    this.b = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.c = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.d = localTextView;
    addView(localTextView);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, n);
    boolean bool = false;
    int i1 = paramAttributeSet.getResourceId(0, 0);
    if (i1 != 0)
    {
      fx.a(this.b, i1);
      fx.a(this.c, i1);
      fx.a(this.d, i1);
    }
    int i2 = paramAttributeSet.getDimensionPixelSize(1, 0);
    if (i2 != 0)
    {
      float f1 = i2;
      this.b.setTextSize(0, f1);
      this.c.setTextSize(0, f1);
      this.d.setTextSize(0, f1);
    }
    if (paramAttributeSet.hasValue(2))
    {
      i2 = paramAttributeSet.getColor(2, 0);
      this.b.setTextColor(i2);
      this.c.setTextColor(i2);
      this.d.setTextColor(i2);
    }
    this.i = paramAttributeSet.getInteger(3, 80);
    paramAttributeSet.recycle();
    this.f = this.c.getTextColors().getDefaultColor();
    setNonPrimaryAlpha(0.6F);
    this.b.setEllipsize(TextUtils.TruncateAt.END);
    this.c.setEllipsize(TextUtils.TruncateAt.END);
    this.d.setEllipsize(TextUtils.TruncateAt.END);
    if (i1 != 0)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(i1, o);
      bool = paramAttributeSet.getBoolean(0, false);
      paramAttributeSet.recycle();
    }
    if (bool)
    {
      setSingleLineAllCaps(this.b);
      setSingleLineAllCaps(this.c);
      setSingleLineAllCaps(this.d);
    }
    else
    {
      this.b.setSingleLine();
      this.c.setSingleLine();
      this.d.setSingleLine();
    }
    this.h = ((int)(paramContext.getResources().getDisplayMetrics().density * 16.0F));
  }
  
  private static void setSingleLineAllCaps(TextView paramTextView)
  {
    paramTextView.setTransformationMethod(new b(paramTextView.getContext()));
  }
  
  final void a(int paramInt)
  {
    this.j = true;
    this.b.setText(null);
    this.c.setText(null);
    this.d.setText(null);
    int i1 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int)((getWidth() - getPaddingLeft() - getPaddingRight()) * 0.8F)), -2147483648);
    int i2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, getHeight() - getPaddingTop() - getPaddingBottom()), -2147483648);
    this.b.measure(i1, i2);
    this.c.measure(i1, i2);
    this.d.measure(i1, i2);
    this.g = paramInt;
    if (!this.k) {
      a(paramInt, this.e, false);
    }
    this.j = false;
  }
  
  void a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    if (paramInt != this.g)
    {
      this.a.getAdapter();
      a(paramInt);
    }
    else if ((!paramBoolean) && (paramFloat == this.e))
    {
      return;
    }
    this.k = true;
    int i4 = this.b.getMeasuredWidth();
    int i9 = this.c.getMeasuredWidth();
    int i3 = this.d.getMeasuredWidth();
    int i8 = i9 / 2;
    int i5 = getWidth();
    paramInt = getHeight();
    int i7 = getPaddingLeft();
    int i6 = getPaddingRight();
    int i1 = getPaddingTop();
    int i2 = getPaddingBottom();
    int i10 = i6 + i8;
    float f2 = 0.5F + paramFloat;
    float f1 = f2;
    if (f2 > 1.0F) {
      f1 = f2 - 1.0F;
    }
    i8 = i5 - i10 - (int)((i5 - (i7 + i8) - i10) * f1) - i8;
    i9 += i8;
    int i12 = this.b.getBaseline();
    int i11 = this.c.getBaseline();
    i10 = this.d.getBaseline();
    int i13 = Math.max(Math.max(i12, i11), i10);
    i12 = i13 - i12;
    i11 = i13 - i11;
    i10 = i13 - i10;
    i13 = this.b.getMeasuredHeight();
    int i14 = this.c.getMeasuredHeight();
    int i15 = this.d.getMeasuredHeight();
    i13 = Math.max(Math.max(i13 + i12, i14 + i11), i15 + i10);
    i14 = this.i & 0x70;
    if (i14 != 16)
    {
      if (i14 != 80)
      {
        paramInt = i12 + i1;
        i2 = i11 + i1;
        i1 += i10;
      }
      else
      {
        i1 = paramInt - i2 - i13;
        paramInt = i12 + i1;
        i2 = i11 + i1;
        i1 += i10;
      }
    }
    else
    {
      i1 = (paramInt - i1 - i2 - i13) / 2;
      paramInt = i12 + i1;
      i2 = i11 + i1;
      i1 += i10;
    }
    TextView localTextView = this.c;
    localTextView.layout(i8, i2, i9, localTextView.getMeasuredHeight() + i2);
    i2 = Math.min(i7, i8 - this.h - i4);
    localTextView = this.b;
    localTextView.layout(i2, paramInt, i4 + i2, localTextView.getMeasuredHeight() + paramInt);
    paramInt = Math.max(i5 - i6 - i3, i9 + this.h);
    localTextView = this.d;
    localTextView.layout(paramInt, i1, paramInt + i3, localTextView.getMeasuredHeight() + i1);
    this.e = paramFloat;
    this.k = false;
  }
  
  final void a(eu parameu1, eu parameu2)
  {
    if (parameu1 != null)
    {
      parameu1.b(this.l);
      this.m = null;
    }
    if (parameu2 != null)
    {
      parameu2.a(this.l);
      this.m = new WeakReference(parameu2);
    }
    parameu1 = this.a;
    if (parameu1 != null)
    {
      this.g = -1;
      this.e = -1.0F;
      a(parameu1.getCurrentItem());
      requestLayout();
    }
  }
  
  int getMinHeight()
  {
    Drawable localDrawable = getBackground();
    if (localDrawable != null) {
      return localDrawable.getIntrinsicHeight();
    }
    return 0;
  }
  
  public int getTextSpacing()
  {
    return this.h;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = getParent();
    if ((localObject instanceof ViewPager))
    {
      localObject = (ViewPager)localObject;
      eu localeu = ((ViewPager)localObject).getAdapter();
      ((ViewPager)localObject).a(this.l);
      a locala = this.l;
      if (((ViewPager)localObject).d == null) {
        ((ViewPager)localObject).d = new ArrayList();
      }
      ((ViewPager)localObject).d.add(locala);
      this.a = ((ViewPager)localObject);
      localObject = this.m;
      if (localObject != null) {
        localObject = (eu)((WeakReference)localObject).get();
      } else {
        localObject = null;
      }
      a((eu)localObject, localeu);
      return;
    }
    throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ViewPager localViewPager = this.a;
    if (localViewPager != null)
    {
      a(localViewPager.getAdapter(), null);
      this.a.a(null);
      localViewPager = this.a;
      a locala = this.l;
      if (localViewPager.d != null) {
        localViewPager.d.remove(locala);
      }
      this.a = null;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.a != null)
    {
      float f1 = this.e;
      if (f1 < 0.0F) {
        f1 = 0.0F;
      }
      a(this.g, f1, true);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824)
    {
      int i2 = getPaddingTop() + getPaddingBottom();
      int i3 = getChildMeasureSpec(paramInt2, i2, -2);
      int i1 = View.MeasureSpec.getSize(paramInt1);
      paramInt1 = getChildMeasureSpec(paramInt1, (int)(i1 * 0.2F), -2);
      this.b.measure(paramInt1, i3);
      this.c.measure(paramInt1, i3);
      this.d.measure(paramInt1, i3);
      if (View.MeasureSpec.getMode(paramInt2) == 1073741824)
      {
        paramInt1 = View.MeasureSpec.getSize(paramInt2);
      }
      else
      {
        paramInt1 = this.c.getMeasuredHeight();
        paramInt1 = Math.max(getMinHeight(), paramInt1 + i2);
      }
      setMeasuredDimension(i1, View.resolveSizeAndState(paramInt1, paramInt2, this.c.getMeasuredState() << 16));
      return;
    }
    throw new IllegalStateException("Must measure with an exact width");
  }
  
  public void requestLayout()
  {
    if (!this.j) {
      super.requestLayout();
    }
  }
  
  public void setGravity(int paramInt)
  {
    this.i = paramInt;
    requestLayout();
  }
  
  public void setNonPrimaryAlpha(float paramFloat)
  {
    this.p = ((int)(paramFloat * 255.0F) & 0xFF);
    int i1 = this.p << 24 | this.f & 0xFFFFFF;
    this.b.setTextColor(i1);
    this.d.setTextColor(i1);
  }
  
  public void setTextColor(int paramInt)
  {
    this.f = paramInt;
    this.c.setTextColor(paramInt);
    paramInt = this.p << 24 | this.f & 0xFFFFFF;
    this.b.setTextColor(paramInt);
    this.d.setTextColor(paramInt);
  }
  
  public void setTextSpacing(int paramInt)
  {
    this.h = paramInt;
    requestLayout();
  }
  
  final class a
    extends DataSetObserver
    implements ViewPager.d, ViewPager.e
  {
    private int b;
    
    a() {}
    
    public final void a()
    {
      if (this.b == 0)
      {
        PagerTitleStrip localPagerTitleStrip = PagerTitleStrip.this;
        int i = localPagerTitleStrip.a.getCurrentItem();
        PagerTitleStrip.this.a.getAdapter();
        localPagerTitleStrip.a(i);
        float f2 = PagerTitleStrip.this.e;
        float f1 = 0.0F;
        if (f2 >= 0.0F) {
          f1 = PagerTitleStrip.this.e;
        }
        localPagerTitleStrip = PagerTitleStrip.this;
        localPagerTitleStrip.a(localPagerTitleStrip.a.getCurrentItem(), f1, true);
      }
    }
    
    public final void a(int paramInt)
    {
      this.b = paramInt;
    }
    
    public final void a(int paramInt, float paramFloat)
    {
      int i = paramInt;
      if (paramFloat > 0.5F) {
        i = paramInt + 1;
      }
      PagerTitleStrip.this.a(i, paramFloat, false);
    }
    
    public final void a(eu parameu1, eu parameu2)
    {
      PagerTitleStrip.this.a(parameu1, parameu2);
    }
    
    public final void onChanged()
    {
      PagerTitleStrip localPagerTitleStrip = PagerTitleStrip.this;
      int i = localPagerTitleStrip.a.getCurrentItem();
      PagerTitleStrip.this.a.getAdapter();
      localPagerTitleStrip.a(i);
      float f2 = PagerTitleStrip.this.e;
      float f1 = 0.0F;
      if (f2 >= 0.0F) {
        f1 = PagerTitleStrip.this.e;
      }
      localPagerTitleStrip = PagerTitleStrip.this;
      localPagerTitleStrip.a(localPagerTitleStrip.a.getCurrentItem(), f1, true);
    }
  }
  
  static final class b
    extends SingleLineTransformationMethod
  {
    private Locale a;
    
    b(Context paramContext)
    {
      this.a = paramContext.getResources().getConfiguration().locale;
    }
    
    public final CharSequence getTransformation(CharSequence paramCharSequence, View paramView)
    {
      paramCharSequence = super.getTransformation(paramCharSequence, paramView);
      if (paramCharSequence != null) {
        return paramCharSequence.toString().toUpperCase(this.a);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.PagerTitleStrip
 * JD-Core Version:    0.7.0.1
 */