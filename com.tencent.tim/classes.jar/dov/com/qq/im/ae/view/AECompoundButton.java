package dov.com.qq.im.ae.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import atau.a;

public class AECompoundButton
  extends FrameLayout
{
  private ImageView Il;
  private Drawable dv;
  private int eFF;
  private int eFG;
  
  public AECompoundButton(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AECompoundButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AECompoundButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    i(paramContext, paramAttributeSet);
  }
  
  private void i(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    j(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(2131558552, this, true);
    this.Il = ((ImageView)findViewById(2131369759));
    if (this.dv != null) {
      this.Il.setImageDrawable(this.dv);
    }
  }
  
  private void j(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {}
    do
    {
      return;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.pw);
    } while (paramContext == null);
    this.dv = paramContext.getDrawable(1);
    this.eFF = paramContext.getDimensionPixelSize(2, 0);
    this.eFG = paramContext.getDimensionPixelSize(0, 0);
    paramContext.recycle();
  }
  
  public ImageView H()
  {
    return this.Il;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.Il != null) && (this.eFF != 0) && (this.eFG != 0))
    {
      ViewGroup.LayoutParams localLayoutParams = this.Il.getLayoutParams();
      localLayoutParams.width = this.eFF;
      localLayoutParams.height = this.eFG;
      this.Il.setLayoutParams(localLayoutParams);
    }
  }
  
  public void setForegroundAndBackgroundResource(@DrawableRes int paramInt1, @DrawableRes int paramInt2)
  {
    setForegroundResource(paramInt1);
    setBackgroundResource(paramInt2);
  }
  
  public void setForegroundResource(@DrawableRes int paramInt)
  {
    if (this.Il != null) {
      this.Il.setImageResource(paramInt);
    }
  }
  
  public void setForegroundSize(int paramInt1, int paramInt2)
  {
    this.eFF = paramInt1;
    this.eFG = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.view.AECompoundButton
 * JD-Core Version:    0.7.0.1
 */