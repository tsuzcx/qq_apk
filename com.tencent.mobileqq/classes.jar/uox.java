import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uox
  extends QQUIEventReceiver<uoh, spk>
{
  public uox(@NonNull uoh paramuoh)
  {
    super(paramuoh);
  }
  
  public void a(@NonNull uoh paramuoh, @NonNull spk paramspk)
  {
    if (paramspk.a) {
      uoh.d(paramuoh);
    }
  }
  
  public Class acceptEventClass()
  {
    return spk.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uox
 * JD-Core Version:    0.7.0.1
 */