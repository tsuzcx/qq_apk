import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.SeekBar;
import com.tencent.av.ui.beauty.BeautySeekView;

public class jft
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public jft(BeautySeekView paramBeautySeekView) {}
  
  public void onGlobalLayout()
  {
    if ((this.this$0.YX) && (BeautySeekView.a(this.this$0) != null) && (BeautySeekView.a(this.this$0).getWidth() > 0))
    {
      this.this$0.YX = false;
      BeautySeekView.a(this.this$0, BeautySeekView.a(this.this$0).getProgress());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jft
 * JD-Core Version:    0.7.0.1
 */