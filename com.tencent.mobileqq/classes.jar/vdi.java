import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vdi
  extends QQUIEventReceiver<vcs, svy>
{
  public vdi(@NonNull vcs paramvcs)
  {
    super(paramvcs);
  }
  
  public void a(@NonNull vcs paramvcs, @NonNull svy paramsvy)
  {
    if (paramsvy.a())
    {
      veg.b(this.TAG, "group video upload");
      return;
    }
    if (!paramsvy.b())
    {
      veg.b(this.TAG, "ignore personal video");
      return;
    }
    paramvcs.a(paramsvy);
  }
  
  public Class acceptEventClass()
  {
    return svy.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vdi
 * JD-Core Version:    0.7.0.1
 */