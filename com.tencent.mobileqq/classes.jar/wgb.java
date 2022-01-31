import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wgb
  extends QQUIEventReceiver<wfn, usb>
{
  public wgb(@NonNull wfn paramwfn)
  {
    super(paramwfn);
  }
  
  public void a(@NonNull wfn paramwfn, @NonNull usb paramusb)
  {
    if (wfn.a(paramwfn) == null)
    {
      wsv.b(this.TAG, "ignore this troop nick name change event. %s.", paramusb.toString());
      return;
    }
    wsv.a(this.TAG, "receive troop nick name change event. %s.", paramusb.toString());
    wfn.a(paramwfn).c();
  }
  
  public Class acceptEventClass()
  {
    return usb.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wgb
 * JD-Core Version:    0.7.0.1
 */