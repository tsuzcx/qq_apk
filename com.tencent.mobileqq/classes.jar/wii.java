import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wii
  extends QQUIEventReceiver<wic, uqw>
{
  public wii(wic paramwic)
  {
    super(paramwic);
  }
  
  public void a(@NonNull wic paramwic, @NonNull uqw paramuqw)
  {
    if (paramuqw.a.isSuccess())
    {
      wsv.a("Q.qqstory.memories.ProfileFeedPresenter", "receive video delete event. %s. start to refresh year node list", paramuqw.toString());
      wic.a(paramwic, true);
    }
  }
  
  public Class acceptEventClass()
  {
    return uqw.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wii
 * JD-Core Version:    0.7.0.1
 */