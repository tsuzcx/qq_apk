import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.biz.qqstory.storyHome.memory.view.StoryMemoriesListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class utt
  extends QQUIEventReceiver<utr, tcd>
{
  public utt(@NonNull utr paramutr)
  {
    super(paramutr);
  }
  
  public void a(@NonNull utr paramutr, @NonNull tcd paramtcd)
  {
    if (paramtcd.a)
    {
      ved.b("Q.qqstory.memories.QQStoryMemoriesPresenter", "receive delete share group member event. %s.", paramtcd);
      utr.a(paramutr).a.h();
    }
  }
  
  public Class acceptEventClass()
  {
    return tcd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utt
 * JD-Core Version:    0.7.0.1
 */