import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter.4;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter.4.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qxu
  implements View.OnClickListener
{
  public qxu(StoryListPresenter.4.1 param1) {}
  
  public void onClick(View paramView)
  {
    rar.a("home_page", "clk_up_shoot", 0, 0, new String[0]);
    this.a.a.this$0.jdField_a_of_type_Qye.b(false, true, 13, null);
    this.a.a.this$0.jdField_a_of_type_Qzy.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qxu
 * JD-Core Version:    0.7.0.1
 */