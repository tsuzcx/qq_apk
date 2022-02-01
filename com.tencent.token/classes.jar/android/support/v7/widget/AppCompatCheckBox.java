package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.tencent.token.gq;
import com.tencent.token.hg.a;
import com.tencent.token.hi;
import com.tencent.token.ix;
import com.tencent.token.jt;

public class AppCompatCheckBox
  extends CheckBox
  implements gq
{
  private final ix a = new ix(this);
  
  public AppCompatCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, hg.a.checkboxStyle);
  }
  
  public AppCompatCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(jt.a(paramContext), paramAttributeSet, paramInt);
    this.a.a(paramAttributeSet, paramInt);
  }
  
  public int getCompoundPaddingLeft()
  {
    int j = super.getCompoundPaddingLeft();
    ix localix = this.a;
    int i = j;
    if (localix != null) {
      i = localix.a(j);
    }
    return i;
  }
  
  public ColorStateList getSupportButtonTintList()
  {
    ix localix = this.a;
    if (localix != null) {
      return localix.a;
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportButtonTintMode()
  {
    ix localix = this.a;
    if (localix != null) {
      return localix.b;
    }
    return null;
  }
  
  public void setButtonDrawable(int paramInt)
  {
    setButtonDrawable(hi.b(getContext(), paramInt));
  }
  
  public void setButtonDrawable(Drawable paramDrawable)
  {
    super.setButtonDrawable(paramDrawable);
    paramDrawable = this.a;
    if (paramDrawable != null) {
      paramDrawable.a();
    }
  }
  
  public void setSupportButtonTintList(ColorStateList paramColorStateList)
  {
    ix localix = this.a;
    if (localix != null) {
      localix.a(paramColorStateList);
    }
  }
  
  public void setSupportButtonTintMode(PorterDuff.Mode paramMode)
  {
    ix localix = this.a;
    if (localix != null) {
      localix.a(paramMode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatCheckBox
 * JD-Core Version:    0.7.0.1
 */