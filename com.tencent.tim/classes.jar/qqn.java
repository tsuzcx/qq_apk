import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListView;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListView.c;
import com.tencent.widget.HorizontalListView.d;

public class qqn
  implements HorizontalListView.d
{
  public qqn(StoryPickerHorizontalListView paramStoryPickerHorizontalListView) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    if ((paramInt == 4097) && (this.a.a != null)) {
      this.a.a.rP(this.a.b.avR);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqn
 * JD-Core Version:    0.7.0.1
 */