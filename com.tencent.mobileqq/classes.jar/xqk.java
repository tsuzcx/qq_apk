import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter;

public class xqk
{
  public TextView a;
  public TextView b;
  
  public xqk(TroopStoryMemoriesListAdapter paramTroopStoryMemoriesListAdapter, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380363));
    this.b = ((TextView)paramView.findViewById(2131379657));
  }
  
  public void a(TroopStoryItemInfo paramTroopStoryItemInfo)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(xqz.c(paramTroopStoryItemInfo.publishTime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xqk
 * JD-Core Version:    0.7.0.1
 */