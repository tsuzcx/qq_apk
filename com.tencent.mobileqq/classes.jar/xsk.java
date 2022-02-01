import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xsk
  extends QQUIEventReceiver<MystoryListView, vnz>
{
  public xsk(@NonNull MystoryListView paramMystoryListView)
  {
    super(paramMystoryListView);
  }
  
  public void a(@NonNull MystoryListView paramMystoryListView, @NonNull vnz paramvnz)
  {
    paramMystoryListView.q();
    paramvnz = (xss)paramMystoryListView.a("FeedSegment");
    if (paramvnz != null) {
      paramvnz.j();
    }
    paramMystoryListView = (xuh)paramMystoryListView.a("NewMyStorySegment");
    if (paramMystoryListView != null) {
      paramMystoryListView.a(false);
    }
  }
  
  public Class acceptEventClass()
  {
    return vnz.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xsk
 * JD-Core Version:    0.7.0.1
 */