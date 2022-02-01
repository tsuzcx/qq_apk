import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.widget.HorizontalListView.OnItemScrollEventListener;

public class xvg
  implements HorizontalListView.OnItemScrollEventListener
{
  public xvg(StoryHomeHorizontalListView paramStoryHomeHorizontalListView) {}
  
  public void onItemScrollNonVisible(int paramInt, boolean paramBoolean)
  {
    if (StoryHomeHorizontalListView.a(this.a) != null) {
      StoryHomeHorizontalListView.a(this.a).onItemScrollNonVisible(paramInt, paramBoolean);
    }
    xvv.a("HorizontalListView", "on item scroll mHasMore=%b, mIsLoadingMore:%b", Boolean.valueOf(StoryHomeHorizontalListView.a(this.a)), Boolean.valueOf(StoryHomeHorizontalListView.b(this.a)));
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvg
 * JD-Core Version:    0.7.0.1
 */