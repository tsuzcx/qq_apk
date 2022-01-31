import com.dataline.util.widget.AsyncImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

public class ev
  implements URLDrawable.URLDrawableListener
{
  public ev(AsyncImageView paramAsyncImageView) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.d("AsyncImageView", 1, "canceled ");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.d("AsyncImageView", 1, "urldrawable load failed ");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.a.setImageDrawable(null);
    this.a.setImageDrawable(paramURLDrawable);
    QLog.d("AsyncImageView", 1, "successed ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ev
 * JD-Core Version:    0.7.0.1
 */