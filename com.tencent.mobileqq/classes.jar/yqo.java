import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter.4;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter.4.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class yqo
  implements View.OnClickListener
{
  public yqo(StoryListPresenter.4.1 param1) {}
  
  public void onClick(View paramView)
  {
    yup.a("home_page", "clk_up_know", 0, 0, new String[0]);
    this.a.a.this$0.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yqo
 * JD-Core Version:    0.7.0.1
 */