import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter.c;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter.h;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class roh
  implements View.OnClickListener
{
  public roh(TroopStoryMemoriesListAdapter.h paramh, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.a != null) {
      this.a.a.a.n(this.val$position, this.a.Y);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     roh
 * JD-Core Version:    0.7.0.1
 */