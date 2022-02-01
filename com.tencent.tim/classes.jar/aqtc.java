import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.tencent.image.ApngDrawable;

public class aqtc
  implements aqtb.a
{
  private Drawable.Callback mCallback;
  private Drawable mDrawable;
  
  public aqtc(Drawable paramDrawable)
  {
    this.mDrawable = paramDrawable;
  }
  
  private void SU(boolean paramBoolean)
  {
    if ((this.mDrawable instanceof ApngDrawable))
    {
      if (paramBoolean) {
        ((ApngDrawable)this.mDrawable).resume();
      }
    }
    else {
      return;
    }
    ((ApngDrawable)this.mDrawable).pause();
  }
  
  public void a(aqtb.a.a parama)
  {
    this.mCallback = new aqtd(this, parama);
    if (this.mDrawable != null) {
      this.mDrawable.setCallback(this.mCallback);
    }
  }
  
  public void dTN()
  {
    if (this.mDrawable != null)
    {
      SU(true);
      this.mDrawable.setVisible(true, false);
      this.mDrawable.invalidateSelf();
    }
  }
  
  public void dTU()
  {
    if (this.mDrawable != null)
    {
      SU(false);
      this.mDrawable.setVisible(false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqtc
 * JD-Core Version:    0.7.0.1
 */