import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

class ajnx
  implements URLDrawable.URLDrawableListener
{
  ajnx(ajnw paramajnw) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UrlBottomImageSpan", 2, "onLoadCanceled");
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UrlBottomImageSpan", 2, "onLoadFialed");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UrlBottomImageSpan", 2, "onLoadProgressed i:" + paramInt);
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UrlBottomImageSpan", 2, "onLoadSuccessed");
    }
    paramURLDrawable = paramURLDrawable.getCallback();
    if ((paramURLDrawable != null) && ((paramURLDrawable instanceof View)))
    {
      ((View)paramURLDrawable).invalidate();
      ((View)paramURLDrawable).requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajnx
 * JD-Core Version:    0.7.0.1
 */