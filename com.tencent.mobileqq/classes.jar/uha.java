import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.biz.qqstory.storyHome.memory.view.StoryMemoriesListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uha
  extends QQUIEventReceiver<ugy, spk>
{
  public uha(@NonNull ugy paramugy)
  {
    super(paramugy);
  }
  
  public void a(@NonNull ugy paramugy, @NonNull spk paramspk)
  {
    if (paramspk.a)
    {
      urk.b("Q.qqstory.memories.QQStoryMemoriesPresenter", "receive delete share group member event. %s.", paramspk);
      ugy.a(paramugy).a.h();
    }
  }
  
  public Class acceptEventClass()
  {
    return spk.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uha
 * JD-Core Version:    0.7.0.1
 */