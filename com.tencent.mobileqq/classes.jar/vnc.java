import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vnc
  extends QQUIEventReceiver<vmu, uzc>
{
  public vnc(@NonNull vmu paramvmu)
  {
    super(paramvmu);
  }
  
  public void a(@NonNull vmu paramvmu, @NonNull uzc paramuzc)
  {
    if (paramuzc.a.isSuccess())
    {
      wsv.a(this.TAG, "receive user info event. %s.", paramuzc.toString());
      paramvmu = paramvmu.a();
      if (paramvmu != null) {
        paramvmu.a();
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return uzc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vnc
 * JD-Core Version:    0.7.0.1
 */