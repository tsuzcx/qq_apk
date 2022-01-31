import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wtt
  extends QQUIEventReceiver<MystoryListView, uot>
{
  public wtt(@NonNull MystoryListView paramMystoryListView)
  {
    super(paramMystoryListView);
  }
  
  public void a(@NonNull MystoryListView paramMystoryListView, @NonNull uot paramuot)
  {
    paramMystoryListView.q();
    paramuot = (wub)paramMystoryListView.a("FeedSegment");
    if (paramuot != null) {
      paramuot.j();
    }
    paramMystoryListView = (wvq)paramMystoryListView.a("NewMyStorySegment");
    if (paramMystoryListView != null) {
      paramMystoryListView.a(false);
    }
  }
  
  public Class acceptEventClass()
  {
    return uot.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wtt
 * JD-Core Version:    0.7.0.1
 */