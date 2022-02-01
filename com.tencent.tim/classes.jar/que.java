import com.tencent.biz.qqstory.storyHome.memory.view.MemoriesInnerListView;
import com.tencent.biz.qqstory.storyHome.memory.view.MemoriesInnerListView.a;
import com.tencent.widget.HorizontalListView.d;

public class que
  implements HorizontalListView.d
{
  public que(MemoriesInnerListView paramMemoriesInnerListView) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    if ((paramInt == 4097) && (this.a.b != null)) {
      this.a.b.rO(MemoriesInnerListView.a(this.a).avR);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     que
 * JD-Core Version:    0.7.0.1
 */