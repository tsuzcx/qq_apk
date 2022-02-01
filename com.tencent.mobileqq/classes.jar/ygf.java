import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.biz.qqstory.storyHome.memory.view.StoryMemoriesListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ygf
  extends QQUIEventReceiver<ygd, woq>
{
  public ygf(@NonNull ygd paramygd)
  {
    super(paramygd);
  }
  
  public void a(@NonNull ygd paramygd, @NonNull woq paramwoq)
  {
    if (paramwoq.a)
    {
      yqp.b("Q.qqstory.memories.QQStoryMemoriesPresenter", "receive delete share group member event. %s.", paramwoq);
      ygd.a(paramygd).a.h();
    }
  }
  
  public Class acceptEventClass()
  {
    return woq.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ygf
 * JD-Core Version:    0.7.0.1
 */