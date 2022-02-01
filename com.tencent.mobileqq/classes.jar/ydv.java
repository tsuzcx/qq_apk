import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ydv
  extends QQUIEventReceiver<ydh, wpw>
{
  public ydv(@NonNull ydh paramydh)
  {
    super(paramydh);
  }
  
  public void a(@NonNull ydh paramydh, @NonNull wpw paramwpw)
  {
    if (ydh.a(paramydh) == null)
    {
      yqp.b(this.TAG, "ignore this troop nick name change event. %s.", paramwpw.toString());
      return;
    }
    yqp.a(this.TAG, "receive troop nick name change event. %s.", paramwpw.toString());
    ydh.a(paramydh).c();
  }
  
  public Class acceptEventClass()
  {
    return wpw.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydv
 * JD-Core Version:    0.7.0.1
 */