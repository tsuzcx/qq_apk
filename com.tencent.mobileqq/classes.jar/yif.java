import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yif
  extends QQUIEventReceiver<yhn, wrd>
{
  public yif(@NonNull yhn paramyhn)
  {
    super(paramyhn);
  }
  
  public void a(@NonNull yhn paramyhn, @NonNull wrd paramwrd)
  {
    paramyhn.i();
  }
  
  public Class acceptEventClass()
  {
    return wrd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yif
 * JD-Core Version:    0.7.0.1
 */