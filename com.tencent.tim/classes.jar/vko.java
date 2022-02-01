import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.mobileqq.activity.Now;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vko
  implements View.OnClickListener
{
  public vko(Now paramNow) {}
  
  public void onClick(View paramView)
  {
    if (Now.a(this.this$0) != null) {
      Now.a(this.this$0).brF();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vko
 * JD-Core Version:    0.7.0.1
 */