import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class quu
  implements View.OnClickListener
{
  public quu(StoryMessageListActivity paramStoryMessageListActivity, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.this$0.wC(this.val$position);
    rar.a("play_video", "del_notice", 0, 0, new String[] { "", "", "", "" });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     quu
 * JD-Core Version:    0.7.0.1
 */