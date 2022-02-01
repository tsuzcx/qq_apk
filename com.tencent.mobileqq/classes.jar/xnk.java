import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xnk
  extends QQUIEventReceiver<xmx, wrd>
{
  public xnk(@NonNull xmx paramxmx)
  {
    super(paramxmx);
  }
  
  public void a(@NonNull xmx paramxmx, @NonNull wrd paramwrd)
  {
    if (paramwrd.a.isSuccess())
    {
      ykq.a(paramxmx.b, "receive user info event. %s.", paramwrd.toString());
      paramxmx.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wrd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnk
 * JD-Core Version:    0.7.0.1
 */