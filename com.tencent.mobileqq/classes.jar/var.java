import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class var
  extends QQUIEventReceiver<vai, uow>
{
  public var(@NonNull vai paramvai)
  {
    super(paramvai);
  }
  
  public void a(@NonNull vai paramvai, @NonNull uow paramuow)
  {
    paramvai.a.b(paramuow);
  }
  
  public Class acceptEventClass()
  {
    return uow.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     var
 * JD-Core Version:    0.7.0.1
 */