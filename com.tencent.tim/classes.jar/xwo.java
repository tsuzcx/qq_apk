import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class xwo
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  xwo(xwn paramxwn) {}
  
  public void onGlobalLayout()
  {
    if (this.this$0.bkc)
    {
      this.this$0.bkc = false;
      xwn.a(this.this$0).sendEmptyMessageDelayed(23, 100L);
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, " doOnCreate_initUI onGlobalLayout");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xwo
 * JD-Core Version:    0.7.0.1
 */