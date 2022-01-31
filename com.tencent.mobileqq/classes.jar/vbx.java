import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vbx
  extends QQUIEventReceiver<vba, vbw>
{
  public vbx(@NonNull vba paramvba)
  {
    super(paramvba);
  }
  
  public void a(@NonNull vba paramvba, @NonNull vbw paramvbw)
  {
    paramvba.a(paramvbw);
  }
  
  public Class acceptEventClass()
  {
    return vbw.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vbx
 * JD-Core Version:    0.7.0.1
 */