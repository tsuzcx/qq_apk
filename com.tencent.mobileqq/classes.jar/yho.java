import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yho
  extends QQUIEventReceiver<yhc, xas>
{
  public yho(@NonNull yhc paramyhc)
  {
    super(paramyhc);
  }
  
  public void a(@NonNull yhc paramyhc, @NonNull xas paramxas)
  {
    if (yhc.a(paramyhc) == null)
    {
      yuk.b(this.TAG, "ignore this user info event. %s.", paramxas.toString());
      return;
    }
    yuk.a(this.TAG, "receive user info event. %s.", paramxas.toString());
    yhc.a(paramyhc).c();
  }
  
  public Class acceptEventClass()
  {
    return xas.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yho
 * JD-Core Version:    0.7.0.1
 */