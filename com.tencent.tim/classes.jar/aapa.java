import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aapa
  implements View.OnClickListener
{
  public aapa(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void onClick(View paramView)
  {
    if (EditLocalVideoActivity.a(this.this$0).isPlaying())
    {
      EditLocalVideoActivity.b(this.this$0, false);
      EditLocalVideoActivity.a(this.this$0).pause();
      EditLocalVideoActivity.a(this.this$0).setVisibility(0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      EditLocalVideoActivity.b(this.this$0, true);
      EditLocalVideoActivity.b(this.this$0).setVisibility(8);
      EditLocalVideoActivity.a(this.this$0).start();
      EditLocalVideoActivity.a(this.this$0).setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aapa
 * JD-Core Version:    0.7.0.1
 */