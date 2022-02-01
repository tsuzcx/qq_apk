import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yoh
  implements View.OnClickListener
{
  yoh(yog paramyog, TroopStoryItemInfo paramTroopStoryItemInfo) {}
  
  public void onClick(View paramView)
  {
    StoryVideoItem localStoryVideoItem = ((vuu)vux.a(5)).a(this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryItemInfo.storyId);
    if (localStoryVideoItem != null) {
      ((vns)vux.a().b(3)).a(localStoryVideoItem);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yoh
 * JD-Core Version:    0.7.0.1
 */