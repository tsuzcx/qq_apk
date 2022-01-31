import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wkk
  extends QQUIEventReceiver<wjw, uwk>
{
  public wkk(@NonNull wjw paramwjw)
  {
    super(paramwjw);
  }
  
  public void a(@NonNull wjw paramwjw, @NonNull uwk paramuwk)
  {
    if (wjw.a(paramwjw) == null)
    {
      wxe.b(this.TAG, "ignore this troop nick name change event. %s.", paramuwk.toString());
      return;
    }
    wxe.a(this.TAG, "receive troop nick name change event. %s.", paramuwk.toString());
    wjw.a(paramwjw).c();
  }
  
  public Class acceptEventClass()
  {
    return uwk.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wkk
 * JD-Core Version:    0.7.0.1
 */