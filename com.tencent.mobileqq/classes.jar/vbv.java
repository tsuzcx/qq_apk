import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vbv
  extends QQUIEventReceiver<vbd, tkn>
{
  public vbv(@NonNull vbd paramvbd)
  {
    super(paramvbd);
  }
  
  public void a(@NonNull vbd paramvbd, @NonNull tkn paramtkn)
  {
    paramvbd.i();
  }
  
  public Class acceptEventClass()
  {
    return tkn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vbv
 * JD-Core Version:    0.7.0.1
 */