import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.widget.QQToast;

class wlm
  implements URLDrawable.URLDrawableListener
{
  wlm(wll paramwll) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    wll.d(this.this$0);
    QQToast.a(this.this$0.mActivity, 0, 2131695103, 1).show();
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    wll.d(this.this$0);
    QQToast.a(this.this$0.mActivity, 0, 2131695103, 1).show();
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    wll.d(this.this$0);
    wll.a(this.this$0, wll.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wlm
 * JD-Core Version:    0.7.0.1
 */