import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.biz.qqstory.storyHome.memory.view.StoryMemoriesListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wil
  extends QQUIEventReceiver<wij, uqv>
{
  public wil(@NonNull wij paramwij)
  {
    super(paramwij);
  }
  
  public void a(@NonNull wij paramwij, @NonNull uqv paramuqv)
  {
    if (paramuqv.a)
    {
      wsv.b("Q.qqstory.memories.QQStoryMemoriesPresenter", "receive delete share group member event. %s.", paramuqv);
      wij.a(paramwij).a.h();
    }
  }
  
  public Class acceptEventClass()
  {
    return uqv.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wil
 * JD-Core Version:    0.7.0.1
 */