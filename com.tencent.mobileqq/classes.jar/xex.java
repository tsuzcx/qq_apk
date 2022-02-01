import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xex
  extends QQUIEventReceiver<xep, wrd>
{
  public xex(@NonNull xep paramxep)
  {
    super(paramxep);
  }
  
  public void a(@NonNull xep paramxep, @NonNull wrd paramwrd)
  {
    if (paramwrd.a.isSuccess())
    {
      ykq.a(this.TAG, "receive user info event. %s.", paramwrd.toString());
      paramxep = paramxep.a();
      if (paramxep != null) {
        paramxep.a();
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return wrd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xex
 * JD-Core Version:    0.7.0.1
 */