import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.biz.qqstory.storyHome.memory.view.StoryMemoriesListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yag
  extends QQUIEventReceiver<yae, wiw>
{
  public yag(@NonNull yae paramyae)
  {
    super(paramyae);
  }
  
  public void a(@NonNull yae paramyae, @NonNull wiw paramwiw)
  {
    if (paramwiw.a)
    {
      ykq.b("Q.qqstory.memories.QQStoryMemoriesPresenter", "receive delete share group member event. %s.", paramwiw);
      yae.a(paramyae).a.h();
    }
  }
  
  public Class acceptEventClass()
  {
    return wiw.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yag
 * JD-Core Version:    0.7.0.1
 */