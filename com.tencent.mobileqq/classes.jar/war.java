import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class war
  extends QQUIEventReceiver<wah, vdl>
{
  public war(@NonNull wah paramwah)
  {
    super(paramwah);
  }
  
  public void a(@NonNull wah paramwah, @NonNull vdl paramvdl)
  {
    if (paramvdl.a.isSuccess())
    {
      wxe.a(paramwah.b, "receive user info event. %s.", paramvdl.toString());
      paramwah.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return vdl.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     war
 * JD-Core Version:    0.7.0.1
 */