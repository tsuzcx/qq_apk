import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vca
  extends QQUIEventReceiver<vbd, vbz>
{
  public vca(@NonNull vbd paramvbd)
  {
    super(paramvbd);
  }
  
  public void a(@NonNull vbd paramvbd, @NonNull vbz paramvbz)
  {
    paramvbd.a(paramvbz);
  }
  
  public Class acceptEventClass()
  {
    return vbz.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vca
 * JD-Core Version:    0.7.0.1
 */