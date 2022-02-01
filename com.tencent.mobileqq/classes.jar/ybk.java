import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ybk
  implements View.OnClickListener
{
  public ybk(StoryMessageListActivity paramStoryMessageListActivity, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a(this.jdField_a_of_type_Int);
    ykv.a("play_video", "del_notice", 0, 0, new String[] { "", "", "", "" });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ybk
 * JD-Core Version:    0.7.0.1
 */