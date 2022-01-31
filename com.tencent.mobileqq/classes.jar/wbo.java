import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wbo
  extends QQUIEventReceiver<wax, vdl>
{
  public wbo(@NonNull wax paramwax)
  {
    super(paramwax);
  }
  
  public void a(@NonNull wax paramwax, @NonNull vdl paramvdl)
  {
    if (paramvdl.a.isSuccess())
    {
      wxe.a(paramwax.b, "receive user info event. %s.", paramvdl.toString());
      paramwax.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return vdl.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wbo
 * JD-Core Version:    0.7.0.1
 */