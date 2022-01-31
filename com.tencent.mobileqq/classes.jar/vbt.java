import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vbt
  extends QQUIEventReceiver<vbd, tcg>
{
  public vbt(@NonNull vbd paramvbd)
  {
    super(paramvbd);
  }
  
  public void a(@NonNull vbd paramvbd, @NonNull tcg paramtcg)
  {
    if (paramtcg.a) {
      vbd.d(paramvbd);
    }
  }
  
  public Class acceptEventClass()
  {
    return tcg.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vbt
 * JD-Core Version:    0.7.0.1
 */