import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter.c;

public class roc
  implements View.OnLongClickListener
{
  public roc(TroopStoryMemoriesListAdapter paramTroopStoryMemoriesListAdapter, int paramInt) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.a.a != null) {
      return this.a.a.e(paramView, this.val$position);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     roc
 * JD-Core Version:    0.7.0.1
 */