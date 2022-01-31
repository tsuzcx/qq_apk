import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class tho
  extends QQUIEventReceiver<thk, tch>
{
  public tho(@NonNull thk paramthk)
  {
    super(paramthk);
  }
  
  public void a(@NonNull thk paramthk, @NonNull tch paramtch)
  {
    paramthk.a.b(paramtch);
  }
  
  public Class acceptEventClass()
  {
    return tch.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tho
 * JD-Core Version:    0.7.0.1
 */