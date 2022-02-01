import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter;
import java.util.ArrayList;
import java.util.Iterator;

public class znf
{
  public View a;
  public View b;
  
  public znf(TroopStoryMemoriesListAdapter paramTroopStoryMemoriesListAdapter, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.b = paramView.findViewById(2131369944);
  }
  
  public void a(TroopStoryItemInfo paramTroopStoryItemInfo)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.jdField_a_of_type_JavaUtilArrayList.iterator();
    float f = 0.0F;
    if (localIterator.hasNext())
    {
      switch (((TroopStoryItemInfo)localIterator.next()).itemType)
      {
      }
      for (;;)
      {
        break;
        if ((zof.b(paramTroopStoryItemInfo.publishTime)) || (zof.d(paramTroopStoryItemInfo.publishTime)))
        {
          f = zps.a(this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.jdField_a_of_type_AndroidContentContext, 44.0F) + f;
        }
        else
        {
          f = zps.a(this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.jdField_a_of_type_AndroidContentContext, 71.0F) + f;
          continue;
          f = zps.a(this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.jdField_a_of_type_AndroidContentContext, 95.0F) + f;
          continue;
          f = zps.a(this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.jdField_a_of_type_AndroidContentContext, 70.0F) + f;
          continue;
          f = zps.a(this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.jdField_a_of_type_AndroidContentContext, 95.0F) + f;
        }
      }
    }
    int i = (int)(this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.jdField_a_of_type_Float - f);
    paramTroopStoryItemInfo = (LinearLayout.LayoutParams)this.b.getLayoutParams();
    if (i <= 0)
    {
      paramTroopStoryItemInfo.height = 0;
      this.b.setLayoutParams(paramTroopStoryItemInfo);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    paramTroopStoryItemInfo.height = i;
    this.b.setLayoutParams(paramTroopStoryItemInfo);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     znf
 * JD-Core Version:    0.7.0.1
 */