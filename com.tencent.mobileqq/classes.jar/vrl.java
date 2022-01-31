import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vrl
  extends QQUIEventReceiver<vrd, vdl>
{
  public vrl(@NonNull vrd paramvrd)
  {
    super(paramvrd);
  }
  
  public void a(@NonNull vrd paramvrd, @NonNull vdl paramvdl)
  {
    if (paramvdl.a.isSuccess())
    {
      wxe.a(this.TAG, "receive user info event. %s.", paramvdl.toString());
      paramvrd = paramvrd.a();
      if (paramvrd != null) {
        paramvrd.a();
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return vdl.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vrl
 * JD-Core Version:    0.7.0.1
 */