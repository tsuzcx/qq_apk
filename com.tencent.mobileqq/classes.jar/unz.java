import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class unz
  extends QQUIEventReceiver<MystoryListView, siz>
{
  public unz(@NonNull MystoryListView paramMystoryListView)
  {
    super(paramMystoryListView);
  }
  
  public void a(@NonNull MystoryListView paramMystoryListView, @NonNull siz paramsiz)
  {
    paramMystoryListView.q();
    paramsiz = (uoh)paramMystoryListView.a("FeedSegment");
    if (paramsiz != null) {
      paramsiz.j();
    }
    paramMystoryListView = (upw)paramMystoryListView.a("NewMyStorySegment");
    if (paramMystoryListView != null) {
      paramMystoryListView.a(false);
    }
  }
  
  public Class acceptEventClass()
  {
    return siz.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     unz
 * JD-Core Version:    0.7.0.1
 */