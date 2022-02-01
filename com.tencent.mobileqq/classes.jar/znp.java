import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class znp
  implements View.OnClickListener
{
  znp(zno paramzno, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Zno.jdField_b_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a != null) {
      this.jdField_a_of_type_Zno.jdField_b_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Zno.jdField_b_of_type_ComTencentImageURLImageView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     znp
 * JD-Core Version:    0.7.0.1
 */