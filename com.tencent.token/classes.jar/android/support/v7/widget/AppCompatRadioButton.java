package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import com.tencent.token.gc;
import com.tencent.token.gs.a;
import com.tencent.token.gu;
import com.tencent.token.ij;
import com.tencent.token.ip;
import com.tencent.token.jf;

public class AppCompatRadioButton
  extends RadioButton
  implements gc
{
  private final ij a = new ij(this);
  private final ip b;
  
  public AppCompatRadioButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, gs.a.radioButtonStyle);
  }
  
  public AppCompatRadioButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(jf.a(paramContext), paramAttributeSet, paramInt);
    this.a.a(paramAttributeSet, paramInt);
    this.b = new ip(this);
    this.b.a(paramAttributeSet, paramInt);
  }
  
  public int getCompoundPaddingLeft()
  {
    int j = super.getCompoundPaddingLeft();
    ij localij = this.a;
    int i = j;
    if (localij != null) {
      i = localij.a(j);
    }
    return i;
  }
  
  public ColorStateList getSupportButtonTintList()
  {
    ij localij = this.a;
    if (localij != null) {
      return localij.a;
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportButtonTintMode()
  {
    ij localij = this.a;
    if (localij != null) {
      return localij.b;
    }
    return null;
  }
  
  public void setButtonDrawable(int paramInt)
  {
    setButtonDrawable(gu.b(getContext(), paramInt));
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
    ij localij = this.a;
    if (localij != null) {
      localij.a(paramColorStateList);
    }
  }
  
  public void setSupportButtonTintMode(PorterDuff.Mode paramMode)
  {
    ij localij = this.a;
    if (localij != null) {
      localij.a(paramMode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatRadioButton
 * JD-Core Version:    0.7.0.1
 */