import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter.f;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rof
  implements View.OnClickListener
{
  public rof(TroopStoryMemoriesListAdapter.f paramf, TroopStoryItemInfo paramTroopStoryItemInfo) {}
  
  public void onClick(View paramView)
  {
    StoryVideoItem localStoryVideoItem = ((psu)psx.a(5)).a(this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryItemInfo.storyId);
    if (localStoryVideoItem != null) {
      ((pnx)psx.a().b(3)).a(localStoryVideoItem);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rof
 * JD-Core Version:    0.7.0.1
 */