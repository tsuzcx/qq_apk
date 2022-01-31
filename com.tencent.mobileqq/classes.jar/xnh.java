import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;

public class xnh
  implements View.OnClickListener
{
  public xnh(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void onClick(View paramView)
  {
    if (EditLocalVideoActivity.a(this.a).isPlaying())
    {
      EditLocalVideoActivity.c(this.a, false);
      EditLocalVideoActivity.a(this.a).pause();
      EditLocalVideoActivity.b(this.a).setVisibility(0);
      return;
    }
    EditLocalVideoActivity.c(this.a, true);
    EditLocalVideoActivity.a(this.a).setVisibility(8);
    EditLocalVideoActivity.a(this.a).start();
    EditLocalVideoActivity.b(this.a).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xnh
 * JD-Core Version:    0.7.0.1
 */