import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yne
  extends QQUIEventReceiver<MystoryListView, wif>
{
  public yne(@NonNull MystoryListView paramMystoryListView)
  {
    super(paramMystoryListView);
  }
  
  public void a(@NonNull MystoryListView paramMystoryListView, @NonNull wif paramwif)
  {
    paramMystoryListView.q();
    paramwif = (ynm)paramMystoryListView.a("FeedSegment");
    if (paramwif != null) {
      paramwif.j();
    }
    paramMystoryListView = (ypb)paramMystoryListView.a("NewMyStorySegment");
    if (paramMystoryListView != null) {
      paramMystoryListView.a(false);
    }
  }
  
  public Class acceptEventClass()
  {
    return wif.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yne
 * JD-Core Version:    0.7.0.1
 */