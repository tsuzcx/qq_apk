import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.widget.QQBlurView;

class yiv
  implements View.OnAttachStateChangeListener
{
  yiv(yiu paramyiu) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (yiu.a(this.this$0) != null) {
      yiu.a(this.this$0).destory();
    }
    if (yiu.a(this.this$0) != null)
    {
      yiu.a(this.this$0).onDestroy();
      yiu.a(this.this$0, null);
    }
    yiu.a(this.this$0).removeOnAttachStateChangeListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yiv
 * JD-Core Version:    0.7.0.1
 */