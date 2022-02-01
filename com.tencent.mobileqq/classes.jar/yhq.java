import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yhq
  extends QQUIEventReceiver<yhc, wtr>
{
  public yhq(@NonNull yhc paramyhc)
  {
    super(paramyhc);
  }
  
  public void a(@NonNull yhc paramyhc, @NonNull wtr paramwtr)
  {
    if (yhc.a(paramyhc) == null)
    {
      yuk.b(this.TAG, "ignore this troop nick name change event. %s.", paramwtr.toString());
      return;
    }
    yuk.a(this.TAG, "receive troop nick name change event. %s.", paramwtr.toString());
    yhc.a(paramyhc).c();
  }
  
  public Class acceptEventClass()
  {
    return wtr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhq
 * JD-Core Version:    0.7.0.1
 */