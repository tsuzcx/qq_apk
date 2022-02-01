import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.biz.pubaccount.Advertisement.view.AdControlView;

public class jxg
  implements View.OnTouchListener
{
  public jxg(VideoCoverFragment paramVideoCoverFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      VideoCoverFragment.a(this.this$0).aBb();
      if (!this.this$0.yI())
      {
        if (!VideoCoverFragment.a(this.this$0)) {
          break label47;
        }
        this.this$0.lB(false);
      }
    }
    return false;
    label47:
    this.this$0.lB(true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jxg
 * JD-Core Version:    0.7.0.1
 */