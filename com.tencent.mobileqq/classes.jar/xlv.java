import com.tencent.biz.qqstory.storyHome.memory.view.MemoriesInnerListView;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;

public class xlv
  implements HorizontalListView.OnScrollStateChangedListener
{
  public xlv(MemoriesInnerListView paramMemoriesInnerListView) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    if ((paramInt == 4097) && (this.a.a != null)) {
      this.a.a.a(MemoriesInnerListView.a(this.a).a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xlv
 * JD-Core Version:    0.7.0.1
 */