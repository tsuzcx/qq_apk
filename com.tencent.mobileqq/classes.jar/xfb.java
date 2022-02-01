import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListView;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;

public class xfb
  implements HorizontalListView.OnScrollStateChangedListener
{
  public xfb(StoryPickerHorizontalListView paramStoryPickerHorizontalListView) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    if ((paramInt == 4097) && (this.a.jdField_a_of_type_Xfe != null)) {
      this.a.jdField_a_of_type_Xfe.a(this.a.jdField_a_of_type_Xey.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xfb
 * JD-Core Version:    0.7.0.1
 */