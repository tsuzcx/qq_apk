import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vav
  extends QQUIEventReceiver<MystoryListView, svv>
{
  public vav(@NonNull MystoryListView paramMystoryListView)
  {
    super(paramMystoryListView);
  }
  
  public void a(@NonNull MystoryListView paramMystoryListView, @NonNull svv paramsvv)
  {
    paramMystoryListView.q();
    paramsvv = (vbd)paramMystoryListView.a("FeedSegment");
    if (paramsvv != null) {
      paramsvv.j();
    }
    paramMystoryListView = (vcs)paramMystoryListView.a("NewMyStorySegment");
    if (paramMystoryListView != null) {
      paramMystoryListView.a(false);
    }
  }
  
  public Class acceptEventClass()
  {
    return svv.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vav
 * JD-Core Version:    0.7.0.1
 */