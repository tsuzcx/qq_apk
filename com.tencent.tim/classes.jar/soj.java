import android.content.res.Resources;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.biz.ui.CustomMenuBar;

public class soj
  implements PopupWindow.OnDismissListener
{
  public soj(CustomMenuBar paramCustomMenuBar, ImageView paramImageView, TextView paramTextView) {}
  
  public void onDismiss()
  {
    this.oB.setImageResource(2130844067);
    if (CustomMenuBar.isDefaultTheme()) {
      this.AR.setTextColor(this.this$0.getResources().getColor(2131166326));
    }
    for (;;)
    {
      this.this$0.Bx = false;
      this.this$0.By = true;
      this.this$0.mHandler.removeCallbacks(this.this$0.mRunnable);
      this.this$0.mHandler.postDelayed(this.this$0.mRunnable, 50L);
      return;
      this.AR.setTextColor(this.this$0.getResources().getColor(2131166325));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     soj
 * JD-Core Version:    0.7.0.1
 */