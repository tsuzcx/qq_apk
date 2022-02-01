import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xpa
  extends QQUIEventReceiver<xoj, wrd>
{
  public xpa(@NonNull xoj paramxoj)
  {
    super(paramxoj);
  }
  
  public void a(@NonNull xoj paramxoj, @NonNull wrd paramwrd)
  {
    if (paramwrd.a.isSuccess())
    {
      ykq.a(paramxoj.b, "receive user info event. %s.", paramwrd.toString());
      paramxoj.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wrd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xpa
 * JD-Core Version:    0.7.0.1
 */