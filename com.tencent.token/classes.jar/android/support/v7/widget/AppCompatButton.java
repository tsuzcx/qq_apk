package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.tencent.token.fn;
import com.tencent.token.gd;
import com.tencent.token.hg.a;
import com.tencent.token.iw;
import com.tencent.token.jd;
import com.tencent.token.jf;
import com.tencent.token.jt;

public class AppCompatButton
  extends Button
  implements fn, gd
{
  private final iw b = new iw(this);
  private final jd c;
  
  public AppCompatButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, hg.a.buttonStyle);
  }
  
  public AppCompatButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(jt.a(paramContext), paramAttributeSet, paramInt);
    this.b.a(paramAttributeSet, paramInt);
    this.c = jd.a(this);
    this.c.a(paramAttributeSet, paramInt);
    this.c.a();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Object localObject = this.b;
    if (localObject != null) {
      ((iw)localObject).d();
    }
    localObject = this.c;
    if (localObject != null) {
      ((jd)localObject).a();
    }
  }
  
  public int getAutoSizeMaxTextSize()
  {
    if (a) {
      return super.getAutoSizeMaxTextSize();
    }
    jd localjd = this.c;
    if (localjd != null) {
      return Math.round(localjd.b.d);
    }
    return -1;
  }
  
  public int getAutoSizeMinTextSize()
  {
    if (a) {
      return super.getAutoSizeMinTextSize();
    }
    jd localjd = this.c;
    if (localjd != null) {
      return Math.round(localjd.b.c);
    }
    return -1;
  }
  
  public int getAutoSizeStepGranularity()
  {
    if (a) {
      return super.getAutoSizeStepGranularity();
    }
    jd localjd = this.c;
    if (localjd != null) {
      return Math.round(localjd.b.b);
    }
    return -1;
  }
  
  public int[] getAutoSizeTextAvailableSizes()
  {
    if (a) {
      return super.getAutoSizeTextAvailableSizes();
    }
    jd localjd = this.c;
    if (localjd != null) {
      return localjd.b.e;
    }
    return new int[0];
  }
  
  public int getAutoSizeTextType()
  {
    if (a)
    {
      if (super.getAutoSizeTextType() == 1) {
        return 1;
      }
      return 0;
    }
    jd localjd = this.c;
    if (localjd != null) {
      return localjd.b.a;
    }
    return 0;
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    iw localiw = this.b;
    if (localiw != null) {
      return localiw.b();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    iw localiw = this.b;
    if (localiw != null) {
      return localiw.c();
    }
    return null;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(Button.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(Button.class.getName());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    jd localjd = this.c;
    if (localjd != null) {
      localjd.b();
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if ((this.c != null) && (!a) && (this.c.b.d())) {
      this.c.b.c();
    }
  }
  
  public void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (a)
    {
      super.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    jd localjd = this.c;
    if (localjd != null) {
      localjd.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    if (a)
    {
      super.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
      return;
    }
    jd localjd = this.c;
    if (localjd != null) {
      localjd.a(paramArrayOfInt, paramInt);
    }
  }
  
  public void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    if (a)
    {
      super.setAutoSizeTextTypeWithDefaults(paramInt);
      return;
    }
    jd localjd = this.c;
    if (localjd != null) {
      localjd.a(paramInt);
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    paramDrawable = this.b;
    if (paramDrawable != null) {
      paramDrawable.a();
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    iw localiw = this.b;
    if (localiw != null) {
      localiw.a(paramInt);
    }
  }
  
  public void setSupportAllCaps(boolean paramBoolean)
  {
    jd localjd = this.c;
    if (localjd != null) {
      localjd.a(paramBoolean);
    }
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    iw localiw = this.b;
    if (localiw != null) {
      localiw.a(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    iw localiw = this.b;
    if (localiw != null) {
      localiw.a(paramMode);
    }
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    jd localjd = this.c;
    if (localjd != null) {
      localjd.a(paramContext, paramInt);
    }
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    if (a)
    {
      super.setTextSize(paramInt, paramFloat);
      return;
    }
    jd localjd = this.c;
    if (localjd != null) {
      localjd.a(paramInt, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatButton
 * JD-Core Version:    0.7.0.1
 */