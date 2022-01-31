import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vyc
  extends QQUIEventReceiver<vya, uzc>
{
  public vyc(@NonNull vya paramvya)
  {
    super(paramvya);
  }
  
  public void a(@NonNull vya paramvya, @NonNull uzc paramuzc)
  {
    if (paramuzc.a.isSuccess())
    {
      wsv.a(this.TAG, "receive user info event. %s.", paramuzc.toString());
      paramvya.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return uzc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vyc
 * JD-Core Version:    0.7.0.1
 */