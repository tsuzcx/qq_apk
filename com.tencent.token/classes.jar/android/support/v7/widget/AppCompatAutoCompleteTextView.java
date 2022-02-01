package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import com.tencent.token.fn;
import com.tencent.token.hg.a;
import com.tencent.token.hi;
import com.tencent.token.iw;
import com.tencent.token.iz;
import com.tencent.token.jd;
import com.tencent.token.jt;
import com.tencent.token.jw;

public class AppCompatAutoCompleteTextView
  extends AutoCompleteTextView
  implements fn
{
  private static final int[] a = { 16843126 };
  private final iw b;
  private final jd c;
  
  public AppCompatAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, hg.a.autoCompleteTextViewStyle);
  }
  
  public AppCompatAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(jt.a(paramContext), paramAttributeSet, paramInt);
    paramContext = jw.a(getContext(), paramAttributeSet, a, paramInt, 0);
    if (paramContext.f(0)) {
      setDropDownBackgroundDrawable(paramContext.a(0));
    }
    paramContext.a.recycle();
    this.b = new iw(this);
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
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return iz.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
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
  
  public void setDropDownBackgroundResource(int paramInt)
  {
    setDropDownBackgroundDrawable(hi.b(getContext(), paramInt));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatAutoCompleteTextView
 * JD-Core Version:    0.7.0.1
 */