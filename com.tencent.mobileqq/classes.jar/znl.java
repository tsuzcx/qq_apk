import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class znl
  implements View.OnClickListener
{
  znl(znk paramznk, TroopStoryItemInfo paramTroopStoryItemInfo) {}
  
  public void onClick(View paramView)
  {
    StoryVideoItem localStoryVideoItem = ((wte)wth.a(5)).a(this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryItemInfo.storyId);
    if (localStoryVideoItem != null) {
      ((wlt)wth.a().b(3)).a(localStoryVideoItem);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     znl
 * JD-Core Version:    0.7.0.1
 */