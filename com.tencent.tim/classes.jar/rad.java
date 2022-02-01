import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.widget.HorizontalListView.b;

public class rad
  implements HorizontalListView.b
{
  public rad(StoryHomeHorizontalListView paramStoryHomeHorizontalListView) {}
  
  public void ap(int paramInt, boolean paramBoolean)
  {
    if (StoryHomeHorizontalListView.a(this.f) != null) {
      StoryHomeHorizontalListView.a(this.f).ap(paramInt, paramBoolean);
    }
    ram.b("HorizontalListView", "on item scroll mHasMore=%b, mIsLoadingMore:%b", Boolean.valueOf(StoryHomeHorizontalListView.a(this.f)), Boolean.valueOf(StoryHomeHorizontalListView.b(this.f)));
    this.f.brV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rad
 * JD-Core Version:    0.7.0.1
 */