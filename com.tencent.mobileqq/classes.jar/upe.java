import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class upe
  extends QQUIEventReceiver<uoh, upd>
{
  public upe(@NonNull uoh paramuoh)
  {
    super(paramuoh);
  }
  
  public void a(@NonNull uoh paramuoh, @NonNull upd paramupd)
  {
    paramuoh.a(paramupd);
  }
  
  public Class acceptEventClass()
  {
    return upd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upe
 * JD-Core Version:    0.7.0.1
 */