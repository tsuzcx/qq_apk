import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vdf
  extends QQUIEventReceiver<vcp, svv>
{
  public vdf(@NonNull vcp paramvcp)
  {
    super(paramvcp);
  }
  
  public void a(@NonNull vcp paramvcp, @NonNull svv paramsvv)
  {
    if (paramsvv.a())
    {
      ved.b(this.TAG, "group video upload");
      return;
    }
    if (!paramsvv.b())
    {
      ved.b(this.TAG, "ignore personal video");
      return;
    }
    paramvcp.a(paramsvv);
  }
  
  public Class acceptEventClass()
  {
    return svv.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vdf
 * JD-Core Version:    0.7.0.1
 */