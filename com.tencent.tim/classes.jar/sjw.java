import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

public class sjw
  implements URLDrawable.URLDrawableListener
{
  public sjw(AsyncRichTextView paramAsyncRichTextView) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AsyncRichTextView", 4, "onLoadSuccessed ");
    }
    this.g.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sjw
 * JD-Core Version:    0.7.0.1
 */