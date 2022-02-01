import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vzo
  extends QQUIEventReceiver<vzf, voc>
{
  public vzo(@NonNull vzf paramvzf)
  {
    super(paramvzf);
  }
  
  public void a(@NonNull vzf paramvzf, @NonNull voc paramvoc)
  {
    paramvzf.a.b(paramvoc);
  }
  
  public Class acceptEventClass()
  {
    return voc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vzo
 * JD-Core Version:    0.7.0.1
 */