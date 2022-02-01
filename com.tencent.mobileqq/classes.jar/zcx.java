import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zcx
  implements View.OnClickListener
{
  zcx(zcw paramzcw) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.a != null) {
      this.a.a.a.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zcx
 * JD-Core Version:    0.7.0.1
 */