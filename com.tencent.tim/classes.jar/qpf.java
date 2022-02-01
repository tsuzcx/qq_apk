import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

class qpf
  extends Drawable
{
  private String TAG = "story.icon.ShareGroupIconDrawable";
  private qpd.a a = new qpg(this);
  private qpd b;
  private Drawable df;
  private Drawable mCurrDrawable;
  
  qpf(@NonNull qpd paramqpd, @NonNull Drawable paramDrawable)
  {
    this.b = paramqpd;
    this.b.a(this.a);
    this.df = paramDrawable;
    this.mCurrDrawable = paramDrawable;
    paramqpd = this.b.as();
    if (paramqpd != null) {
      J(paramqpd);
    }
  }
  
  private void J(@NonNull Drawable paramDrawable)
  {
    qpb.a(this.TAG, "updateCurrentDrawable view:%s drawable: %s", getCallback(), paramDrawable);
    if (paramDrawable != this.mCurrDrawable)
    {
      paramDrawable.setBounds(getBounds());
      paramDrawable.setVisible(isVisible(), true);
      paramDrawable.setState(getState());
      paramDrawable.setLevel(getLevel());
      paramDrawable.setCallback(getCallback());
      if (Build.VERSION.SDK_INT >= 19) {
        paramDrawable.setAlpha(getAlpha());
      }
      Drawable localDrawable = this.mCurrDrawable;
      this.mCurrDrawable = paramDrawable;
      if (localDrawable != null) {
        localDrawable.setCallback(null);
      }
      invalidateSelf();
    }
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    this.mCurrDrawable.draw(paramCanvas);
    this.b.startLoad();
  }
  
  public int getOpacity()
  {
    return this.mCurrDrawable.getOpacity();
  }
  
  public boolean getPadding(@NonNull Rect paramRect)
  {
    return this.mCurrDrawable.getPadding(paramRect);
  }
  
  @NonNull
  public Drawable mutate()
  {
    this.mCurrDrawable.mutate();
    return super.mutate();
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.mCurrDrawable.setBounds(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    this.mCurrDrawable.setLevel(paramInt);
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    this.mCurrDrawable.setState(paramArrayOfInt);
    return true;
  }
  
  public void setAlpha(int paramInt)
  {
    this.mCurrDrawable.setAlpha(paramInt);
  }
  
  public void setColorFilter(int paramInt, @NonNull PorterDuff.Mode paramMode)
  {
    super.setColorFilter(paramInt, paramMode);
    this.mCurrDrawable.setColorFilter(paramInt, paramMode);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    this.mCurrDrawable.setColorFilter(paramColorFilter);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    this.mCurrDrawable.setVisible(paramBoolean1, paramBoolean2);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qpf
 * JD-Core Version:    0.7.0.1
 */