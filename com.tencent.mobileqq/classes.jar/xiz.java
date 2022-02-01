import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xiz
  extends QQUIEventReceiver<xin, wci>
{
  public xiz(@NonNull xin paramxin)
  {
    super(paramxin);
  }
  
  public void a(@NonNull xin paramxin, @NonNull wci paramwci)
  {
    if (xin.a(paramxin) == null)
    {
      xvv.b(this.TAG, "ignore this user info event. %s.", paramwci.toString());
      return;
    }
    xvv.a(this.TAG, "receive user info event. %s.", paramwci.toString());
    xin.a(paramxin).c();
  }
  
  public Class acceptEventClass()
  {
    return wci.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xiz
 * JD-Core Version:    0.7.0.1
 */