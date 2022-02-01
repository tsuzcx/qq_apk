import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class mqf
  implements URLDrawable.URLDrawableListener
{
  mqf(mpy parammpy) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    mpy.b(this.b);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = aqhu.drawableToBitmap(paramURLDrawable.getCurrDrawable());
    mpy.a(this.b, paramURLDrawable, mpy.a(this.b).coverPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mqf
 * JD-Core Version:    0.7.0.1
 */