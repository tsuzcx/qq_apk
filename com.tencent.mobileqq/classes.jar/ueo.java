import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ueo
  extends QQUIEventReceiver<uec, sxr>
{
  public ueo(@NonNull uec paramuec)
  {
    super(paramuec);
  }
  
  public void a(@NonNull uec paramuec, @NonNull sxr paramsxr)
  {
    if (uec.a(paramuec) == null)
    {
      urk.b(this.TAG, "ignore this user info event. %s.", paramsxr.toString());
      return;
    }
    urk.a(this.TAG, "receive user info event. %s.", paramsxr.toString());
    uec.a(paramuec).c();
  }
  
  public Class acceptEventClass()
  {
    return sxr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ueo
 * JD-Core Version:    0.7.0.1
 */