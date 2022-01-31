import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class utt
  extends QQUIEventReceiver<utn, tch>
{
  public utt(utn paramutn)
  {
    super(paramutn);
  }
  
  public void a(@NonNull utn paramutn, @NonNull tch paramtch)
  {
    if (paramtch.a.isSuccess())
    {
      veg.a("Q.qqstory.memories.ProfileFeedPresenter", "receive video delete event. %s. start to refresh year node list", paramtch.toString());
      utn.a(paramutn, true);
    }
  }
  
  public Class acceptEventClass()
  {
    return tch.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utt
 * JD-Core Version:    0.7.0.1
 */