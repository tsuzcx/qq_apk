import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ugx
  extends QQUIEventReceiver<ugr, spl>
{
  public ugx(ugr paramugr)
  {
    super(paramugr);
  }
  
  public void a(@NonNull ugr paramugr, @NonNull spl paramspl)
  {
    if (paramspl.a.isSuccess())
    {
      urk.a("Q.qqstory.memories.ProfileFeedPresenter", "receive video delete event. %s. start to refresh year node list", paramspl.toString());
      ugr.a(paramugr, true);
    }
  }
  
  public Class acceptEventClass()
  {
    return spl.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ugx
 * JD-Core Version:    0.7.0.1
 */