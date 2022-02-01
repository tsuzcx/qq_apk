import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wqc
  extends QQUIEventReceiver<wpu, wci>
{
  public wqc(@NonNull wpu paramwpu)
  {
    super(paramwpu);
  }
  
  public void a(@NonNull wpu paramwpu, @NonNull wci paramwci)
  {
    if (paramwci.a.isSuccess())
    {
      xvv.a(this.TAG, "receive user info event. %s.", paramwci.toString());
      paramwpu = paramwpu.a();
      if (paramwpu != null) {
        paramwpu.a();
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return wci.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wqc
 * JD-Core Version:    0.7.0.1
 */