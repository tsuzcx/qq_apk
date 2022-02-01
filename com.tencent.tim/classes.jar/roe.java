import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter.c;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter.d;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class roe
  implements View.OnClickListener
{
  public roe(TroopStoryMemoriesListAdapter.d paramd) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.a != null) {
      this.a.a.a.bvJ();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     roe
 * JD-Core Version:    0.7.0.1
 */