import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ydt
  extends QQUIEventReceiver<ydh, wwx>
{
  public ydt(@NonNull ydh paramydh)
  {
    super(paramydh);
  }
  
  public void a(@NonNull ydh paramydh, @NonNull wwx paramwwx)
  {
    if (ydh.a(paramydh) == null)
    {
      yqp.b(this.TAG, "ignore this user info event. %s.", paramwwx.toString());
      return;
    }
    yqp.a(this.TAG, "receive user info event. %s.", paramwwx.toString());
    ydh.a(paramydh).c();
  }
  
  public Class acceptEventClass()
  {
    return wwx.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydt
 * JD-Core Version:    0.7.0.1
 */