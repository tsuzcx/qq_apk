package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import com.tencent.token.ez;
import com.tencent.token.fp;
import com.tencent.token.ii;
import com.tencent.token.il;
import com.tencent.token.ip;
import com.tencent.token.ir;
import com.tencent.token.jf;

public class AppCompatTextView
  extends TextView
  implements ez, fp
{
  private final ii b = new ii(this);
  private final ip c;
  
  public AppCompatTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842884);
  }
  
  public AppCompatTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(jf.a(paramContext), paramAttributeSet, paramInt);
    this.b.a(paramAttributeSet, paramInt);
    this.c = ip.a(this);
    this.c.a(paramAttributeSet, paramInt);
    this.c.a();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Object localObject = this.b;
    if (localObject != null) {
      ((ii)localObject).d();
    }
    localObject = this.c;
    if (localObject != null) {
      ((ip)localObject).a();
    }
  }
  
  public int getAutoSizeMaxTextSize()
  {
    if (a) {
      return super.getAutoSizeMaxTextSize();
    }
    ip localip = this.c;
    if (localip != null) {
      return Math.round(localip.b.d);
    }
    return -1;
  }
  
  public int getAutoSizeMinTextSize()
  {
    if (a) {
      return super.getAutoSizeMinTextSize();
    }
    ip localip = this.c;
    if (localip != null) {
      return Math.round(localip.b.c);
    }
    return -1;
  }
  
  public int getAutoSizeStepGranularity()
  {
    if (a) {
      return super.getAutoSizeStepGranularity();
    }
    ip localip = this.c;
    if (localip != null) {
      return Math.round(localip.b.b);
    }
    return -1;
  }
  
  public int[] getAutoSizeTextAvailableSizes()
  {
    if (a) {
      return super.getAutoSizeTextAvailableSizes();
    }
    ip localip = this.c;
    if (localip != null) {
      return localip.b.e;
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
    ip localip = this.c;
    if (localip != null) {
      return localip.b.a;
    }
    return 0;
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    ii localii = this.b;
    if (localii != null) {
      return localii.b();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    ii localii = this.b;
    if (localii != null) {
      return localii.c();
    }
    return null;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return il.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ip localip = this.c;
    if (localip != null) {
      localip.b();
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
    ip localip = this.c;
    if (localip != null) {
      localip.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    if (a)
    {
      super.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
      return;
    }
    ip localip = this.c;
    if (localip != null) {
      localip.a(paramArrayOfInt, paramInt);
    }
  }
  
  public void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    if (a)
    {
      super.setAutoSizeTextTypeWithDefaults(paramInt);
      return;
    }
    ip localip = this.c;
    if (localip != null) {
      localip.a(paramInt);
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
    ii localii = this.b;
    if (localii != null) {
      localii.a(paramInt);
    }
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    ii localii = this.b;
    if (localii != null) {
      localii.a(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    ii localii = this.b;
    if (localii != null) {
      localii.a(paramMode);
    }
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    ip localip = this.c;
    if (localip != null) {
      localip.a(paramContext, paramInt);
    }
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    if (a)
    {
      super.setTextSize(paramInt, paramFloat);
      return;
    }
    ip localip = this.c;
    if (localip != null) {
      localip.a(paramInt, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatTextView
 * JD-Core Version:    0.7.0.1
 */