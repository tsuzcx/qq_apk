import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xux
  extends QQUIEventReceiver<xuh, voc>
{
  public xux(@NonNull xuh paramxuh)
  {
    super(paramxuh);
  }
  
  public void a(@NonNull xuh paramxuh, @NonNull voc paramvoc)
  {
    if (paramvoc.a())
    {
      xvv.b(this.TAG, "group video upload");
      return;
    }
    if (!paramvoc.b())
    {
      xvv.b(this.TAG, "ignore personal video");
      return;
    }
    paramxuh.a(paramvoc);
  }
  
  public Class acceptEventClass()
  {
    return voc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xux
 * JD-Core Version:    0.7.0.1
 */