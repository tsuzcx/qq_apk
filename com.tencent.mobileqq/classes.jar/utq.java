import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class utq
  extends QQUIEventReceiver<utk, tce>
{
  public utq(utk paramutk)
  {
    super(paramutk);
  }
  
  public void a(@NonNull utk paramutk, @NonNull tce paramtce)
  {
    if (paramtce.a.isSuccess())
    {
      ved.a("Q.qqstory.memories.ProfileFeedPresenter", "receive video delete event. %s. start to refresh year node list", paramtce.toString());
      utk.a(paramutk, true);
    }
  }
  
  public Class acceptEventClass()
  {
    return tce.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utq
 * JD-Core Version:    0.7.0.1
 */