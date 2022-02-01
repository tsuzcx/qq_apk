import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.nearby.now.StoryPlayController;
import com.tencent.mobileqq.nearby.now.view.QQStoryVideoPlayerErrorView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajvs
  implements View.OnClickListener
{
  ajvs(ajvr paramajvr) {}
  
  public void onClick(View paramView)
  {
    this.a.this$0.a.dui();
    this.a.this$0.b.b.setVisibility(8);
    this.a.this$0.b.closeBtn.setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajvs
 * JD-Core Version:    0.7.0.1
 */