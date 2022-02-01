import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.biz.qqstory.storyHome.memory.view.StoryMemoriesListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yka
  extends QQUIEventReceiver<yjy, wsl>
{
  public yka(@NonNull yjy paramyjy)
  {
    super(paramyjy);
  }
  
  public void a(@NonNull yjy paramyjy, @NonNull wsl paramwsl)
  {
    if (paramwsl.a)
    {
      yuk.b("Q.qqstory.memories.QQStoryMemoriesPresenter", "receive delete share group member event. %s.", paramwsl);
      yjy.a(paramyjy).a.h();
    }
  }
  
  public Class acceptEventClass()
  {
    return wsl.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yka
 * JD-Core Version:    0.7.0.1
 */