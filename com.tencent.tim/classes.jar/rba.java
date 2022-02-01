import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

public abstract interface rba
  extends rdb.a
{
  public abstract boolean G(MotionEvent paramMotionEvent);
  
  public abstract void K(MotionEvent paramMotionEvent);
  
  public abstract boolean KS();
  
  public abstract Bitmap U();
  
  @NonNull
  public abstract DoodleLayout a();
  
  public abstract void brZ();
  
  public abstract void bsa();
  
  public abstract void dZ(int paramInt1, int paramInt2);
  
  public abstract Bitmap e(int paramInt);
  
  public abstract byte[] f(int paramInt);
  
  public abstract boolean isEmpty();
  
  public abstract void s(Bitmap paramBitmap);
  
  public abstract int ta();
  
  public abstract boolean y(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rba
 * JD-Core Version:    0.7.0.1
 */