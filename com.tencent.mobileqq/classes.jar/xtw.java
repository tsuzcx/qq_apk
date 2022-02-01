import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListView;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;

public class xtw
  implements HorizontalListView.OnScrollStateChangedListener
{
  public xtw(StoryPickerHorizontalListView paramStoryPickerHorizontalListView) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    if ((paramInt == 4097) && (this.a.jdField_a_of_type_Xtz != null)) {
      this.a.jdField_a_of_type_Xtz.a(this.a.jdField_a_of_type_Xtt.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xtw
 * JD-Core Version:    0.7.0.1
 */