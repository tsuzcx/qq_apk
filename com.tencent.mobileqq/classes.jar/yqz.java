import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yqz
  extends QQUIEventReceiver<MystoryListView, wma>
{
  public yqz(@NonNull MystoryListView paramMystoryListView)
  {
    super(paramMystoryListView);
  }
  
  public void a(@NonNull MystoryListView paramMystoryListView, @NonNull wma paramwma)
  {
    paramMystoryListView.q();
    paramwma = (yrh)paramMystoryListView.a("FeedSegment");
    if (paramwma != null) {
      paramwma.j();
    }
    paramMystoryListView = (ysw)paramMystoryListView.a("NewMyStorySegment");
    if (paramMystoryListView != null) {
      paramMystoryListView.a(false);
    }
  }
  
  public Class acceptEventClass()
  {
    return wma.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yqz
 * JD-Core Version:    0.7.0.1
 */