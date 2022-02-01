import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xgg
  implements View.OnClickListener
{
  xgg(xge paramxge) {}
  
  public void onClick(View paramView)
  {
    this.a.b();
    this.a.a.i();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xgg
 * JD-Core Version:    0.7.0.1
 */