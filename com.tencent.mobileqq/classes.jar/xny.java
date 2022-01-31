import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.widget.ProgressBar;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;

class xny
  implements Runnable
{
  xny(xns paramxns) {}
  
  public void run()
  {
    if (EditLocalVideoActivity.a(this.a.a) == null)
    {
      EditLocalVideoActivity.a(this.a.a, (ProgressBar)this.a.a.a(2131370397));
      EditLocalVideoActivity.a(this.a.a).setProgressDrawable(new ClipDrawable(new ColorDrawable(Color.parseColor("#1ab5ee")), 3, 1));
      EditLocalVideoActivity.a(this.a.a).setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4e000000")));
    }
    EditLocalVideoActivity.a(this.a.a).setVisibility(0);
    EditLocalVideoActivity.a(this.a.a).setProgress(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xny
 * JD-Core Version:    0.7.0.1
 */