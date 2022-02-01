import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yhf
  extends QQUIEventReceiver<MystoryListView, wcu>
{
  public yhf(@NonNull MystoryListView paramMystoryListView)
  {
    super(paramMystoryListView);
  }
  
  public void a(@NonNull MystoryListView paramMystoryListView, @NonNull wcu paramwcu)
  {
    paramMystoryListView.q();
    paramwcu = (yhn)paramMystoryListView.a("FeedSegment");
    if (paramwcu != null) {
      paramwcu.j();
    }
    paramMystoryListView = (yjc)paramMystoryListView.a("NewMyStorySegment");
    if (paramMystoryListView != null) {
      paramMystoryListView.a(false);
    }
  }
  
  public Class acceptEventClass()
  {
    return wcu.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhf
 * JD-Core Version:    0.7.0.1
 */