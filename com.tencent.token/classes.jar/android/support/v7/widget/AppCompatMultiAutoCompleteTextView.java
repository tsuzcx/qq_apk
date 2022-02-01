package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import com.tencent.token.ez;
import com.tencent.token.gs.a;
import com.tencent.token.gu;
import com.tencent.token.ii;
import com.tencent.token.il;
import com.tencent.token.ip;
import com.tencent.token.jf;
import com.tencent.token.ji;

public class AppCompatMultiAutoCompleteTextView
  extends MultiAutoCompleteTextView
  implements ez
{
  private static final int[] a = { 16843126 };
  private final ii b;
  private final ip c;
  
  public AppCompatMultiAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, gs.a.autoCompleteTextViewStyle);
  }
  
  public AppCompatMultiAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(jf.a(paramContext), paramAttributeSet, paramInt);
    paramContext = ji.a(getContext(), paramAttributeSet, a, paramInt, 0);
    if (paramContext.f(0)) {
      setDropDownBackgroundDrawable(paramContext.a(0));
    }
    paramContext.a.recycle();
    this.b = new ii(this);
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
  
  public void setDropDownBackgroundResource(int paramInt)
  {
    setDropDownBackgroundDrawable(gu.b(getContext(), paramInt));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatMultiAutoCompleteTextView
 * JD-Core Version:    0.7.0.1
 */