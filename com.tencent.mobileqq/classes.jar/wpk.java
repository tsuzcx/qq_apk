import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wpk
  extends QQUIEventReceiver<MystoryListView, ukk>
{
  public wpk(@NonNull MystoryListView paramMystoryListView)
  {
    super(paramMystoryListView);
  }
  
  public void a(@NonNull MystoryListView paramMystoryListView, @NonNull ukk paramukk)
  {
    paramMystoryListView.q();
    paramukk = (wps)paramMystoryListView.a("FeedSegment");
    if (paramukk != null) {
      paramukk.j();
    }
    paramMystoryListView = (wrh)paramMystoryListView.a("NewMyStorySegment");
    if (paramMystoryListView != null) {
      paramMystoryListView.a(false);
    }
  }
  
  public Class acceptEventClass()
  {
    return ukk.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wpk
 * JD-Core Version:    0.7.0.1
 */