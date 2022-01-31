import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wwg
  extends QQUIEventReceiver<wvq, uow>
{
  public wwg(@NonNull wvq paramwvq)
  {
    super(paramwvq);
  }
  
  public void a(@NonNull wvq paramwvq, @NonNull uow paramuow)
  {
    if (paramuow.a())
    {
      wxe.b(this.TAG, "group video upload");
      return;
    }
    if (!paramuow.b())
    {
      wxe.b(this.TAG, "ignore personal video");
      return;
    }
    paramwvq.a(paramuow);
  }
  
  public Class acceptEventClass()
  {
    return uow.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wwg
 * JD-Core Version:    0.7.0.1
 */