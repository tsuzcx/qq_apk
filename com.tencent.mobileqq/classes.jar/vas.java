import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vas
  extends QQUIEventReceiver<MystoryListView, svs>
{
  public vas(@NonNull MystoryListView paramMystoryListView)
  {
    super(paramMystoryListView);
  }
  
  public void a(@NonNull MystoryListView paramMystoryListView, @NonNull svs paramsvs)
  {
    paramMystoryListView.q();
    paramsvs = (vba)paramMystoryListView.a("FeedSegment");
    if (paramsvs != null) {
      paramsvs.j();
    }
    paramMystoryListView = (vcp)paramMystoryListView.a("NewMyStorySegment");
    if (paramMystoryListView != null) {
      paramMystoryListView.a(false);
    }
  }
  
  public Class acceptEventClass()
  {
    return svs.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vas
 * JD-Core Version:    0.7.0.1
 */