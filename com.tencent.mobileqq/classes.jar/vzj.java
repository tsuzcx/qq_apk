import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vzj
  extends QQUIEventReceiver<vzf, vuc>
{
  public vzj(@NonNull vzf paramvzf)
  {
    super(paramvzf);
  }
  
  public void a(@NonNull vzf paramvzf, @NonNull vuc paramvuc)
  {
    paramvzf.a.b(paramvuc);
  }
  
  public Class acceptEventClass()
  {
    return vuc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vzj
 * JD-Core Version:    0.7.0.1
 */