import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wki
  extends QQUIEventReceiver<wjw, vdl>
{
  public wki(@NonNull wjw paramwjw)
  {
    super(paramwjw);
  }
  
  public void a(@NonNull wjw paramwjw, @NonNull vdl paramvdl)
  {
    if (wjw.a(paramwjw) == null)
    {
      wxe.b(this.TAG, "ignore this user info event. %s.", paramvdl.toString());
      return;
    }
    wxe.a(this.TAG, "receive user info event. %s.", paramvdl.toString());
    wjw.a(paramwjw).c();
  }
  
  public Class acceptEventClass()
  {
    return vdl.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wki
 * JD-Core Version:    0.7.0.1
 */