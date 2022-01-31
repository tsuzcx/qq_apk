import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.biz.qqstory.storyHome.memory.view.StoryMemoriesListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class utw
  extends QQUIEventReceiver<utu, tcg>
{
  public utw(@NonNull utu paramutu)
  {
    super(paramutu);
  }
  
  public void a(@NonNull utu paramutu, @NonNull tcg paramtcg)
  {
    if (paramtcg.a)
    {
      veg.b("Q.qqstory.memories.QQStoryMemoriesPresenter", "receive delete share group member event. %s.", paramtcg);
      utu.a(paramutu).a.h();
    }
  }
  
  public Class acceptEventClass()
  {
    return tcg.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utw
 * JD-Core Version:    0.7.0.1
 */