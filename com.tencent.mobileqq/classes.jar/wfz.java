import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wfz
  extends QQUIEventReceiver<wfn, uzc>
{
  public wfz(@NonNull wfn paramwfn)
  {
    super(paramwfn);
  }
  
  public void a(@NonNull wfn paramwfn, @NonNull uzc paramuzc)
  {
    if (wfn.a(paramwfn) == null)
    {
      wsv.b(this.TAG, "ignore this user info event. %s.", paramuzc.toString());
      return;
    }
    wsv.a(this.TAG, "receive user info event. %s.", paramuzc.toString());
    wfn.a(paramwfn).c();
  }
  
  public Class acceptEventClass()
  {
    return uzc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wfz
 * JD-Core Version:    0.7.0.1
 */