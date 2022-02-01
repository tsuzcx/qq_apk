import com.tencent.av.ui.AVActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

public class ixl
  implements URLDrawable.URLDrawableListener
{
  public ixl(AVActivity paramAVActivity) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    AVActivity.a(this.this$0, false);
    QLog.i(this.this$0.TAG, 1, "MoreBtnTips. onLoadCanceled().");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    AVActivity.a(this.this$0, false);
    QLog.i(this.this$0.TAG, 1, "MoreBtnTips. onLoadFialed().");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    QLog.i(this.this$0.TAG, 1, "MoreBtnTips. onLoadProgressed(). i = " + paramInt);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    AVActivity.a(this.this$0, true);
    QLog.i(this.this$0.TAG, 1, "MoreBtnTips. onLoadSuccessed().");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ixl
 * JD-Core Version:    0.7.0.1
 */