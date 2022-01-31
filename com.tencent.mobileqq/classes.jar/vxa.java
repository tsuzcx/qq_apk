import android.view.View;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter;

public class vxa
{
  public View a;
  public View b;
  
  public vxa(TroopStoryMemoriesListAdapter paramTroopStoryMemoriesListAdapter, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.b = paramView.findViewById(2131378948);
  }
  
  public void a(TroopStoryItemInfo paramTroopStoryItemInfo)
  {
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new vxb(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vxa
 * JD-Core Version:    0.7.0.1
 */