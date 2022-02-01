import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xod
  extends QQUIEventReceiver<xnt, wrd>
{
  public xod(@NonNull xnt paramxnt)
  {
    super(paramxnt);
  }
  
  public void a(@NonNull xnt paramxnt, @NonNull wrd paramwrd)
  {
    if (paramwrd.a.isSuccess())
    {
      ykq.a(paramxnt.b, "receive user info event. %s.", paramwrd.toString());
      paramxnt.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wrd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xod
 * JD-Core Version:    0.7.0.1
 */