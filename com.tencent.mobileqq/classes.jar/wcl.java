import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wcl
  extends QQUIEventReceiver<wcj, vdl>
{
  public wcl(@NonNull wcj paramwcj)
  {
    super(paramwcj);
  }
  
  public void a(@NonNull wcj paramwcj, @NonNull vdl paramvdl)
  {
    if (paramvdl.a.isSuccess())
    {
      wxe.a(this.TAG, "receive user info event. %s.", paramvdl.toString());
      paramwcj.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return vdl.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wcl
 * JD-Core Version:    0.7.0.1
 */