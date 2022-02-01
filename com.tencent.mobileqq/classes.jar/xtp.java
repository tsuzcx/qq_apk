import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xtp
  extends QQUIEventReceiver<xss, xto>
{
  public xtp(@NonNull xss paramxss)
  {
    super(paramxss);
  }
  
  public void a(@NonNull xss paramxss, @NonNull xto paramxto)
  {
    paramxss.a(paramxto);
  }
  
  public Class acceptEventClass()
  {
    return xto.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xtp
 * JD-Core Version:    0.7.0.1
 */