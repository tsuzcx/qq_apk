import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.biz.qqstory.storyHome.memory.view.StoryMemoriesListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xll
  extends QQUIEventReceiver<xlj, vub>
{
  public xll(@NonNull xlj paramxlj)
  {
    super(paramxlj);
  }
  
  public void a(@NonNull xlj paramxlj, @NonNull vub paramvub)
  {
    if (paramvub.a)
    {
      xvv.b("Q.qqstory.memories.QQStoryMemoriesPresenter", "receive delete share group member event. %s.", paramvub);
      xlj.a(paramxlj).a.h();
    }
  }
  
  public Class acceptEventClass()
  {
    return vub.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xll
 * JD-Core Version:    0.7.0.1
 */