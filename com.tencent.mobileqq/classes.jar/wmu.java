import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.biz.qqstory.storyHome.memory.view.StoryMemoriesListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wmu
  extends QQUIEventReceiver<wms, uve>
{
  public wmu(@NonNull wms paramwms)
  {
    super(paramwms);
  }
  
  public void a(@NonNull wms paramwms, @NonNull uve paramuve)
  {
    if (paramuve.a)
    {
      wxe.b("Q.qqstory.memories.QQStoryMemoriesPresenter", "receive delete share group member event. %s.", paramuve);
      wms.a(paramwms).a.h();
    }
  }
  
  public Class acceptEventClass()
  {
    return uve.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wmu
 * JD-Core Version:    0.7.0.1
 */