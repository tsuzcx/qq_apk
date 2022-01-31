import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vzy
  extends QQUIEventReceiver<vzl, vdl>
{
  public vzy(@NonNull vzl paramvzl)
  {
    super(paramvzl);
  }
  
  public void a(@NonNull vzl paramvzl, @NonNull vdl paramvdl)
  {
    if (paramvdl.a.isSuccess())
    {
      wxe.a(paramvzl.b, "receive user info event. %s.", paramvdl.toString());
      paramvzl.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return vdl.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vzy
 * JD-Core Version:    0.7.0.1
 */