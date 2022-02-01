import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.XEditTextEx;

class wvj
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  wvj(wvd paramwvd) {}
  
  public void onGlobalLayout()
  {
    if ((wvd.a(this.this$0).a.getLineCount() > 3) && (wvd.a(this.this$0).OO()) && (wvd.a(this.this$0).Ph()))
    {
      this.this$0.a.setVisibility(0);
      return;
    }
    this.this$0.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wvj
 * JD-Core Version:    0.7.0.1
 */