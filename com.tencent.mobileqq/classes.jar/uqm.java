import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uqm
  extends QQUIEventReceiver<upw, sjc>
{
  public uqm(@NonNull upw paramupw)
  {
    super(paramupw);
  }
  
  public void a(@NonNull upw paramupw, @NonNull sjc paramsjc)
  {
    if (paramsjc.a())
    {
      urk.b(this.TAG, "group video upload");
      return;
    }
    if (!paramsjc.b())
    {
      urk.b(this.TAG, "ignore personal video");
      return;
    }
    paramupw.a(paramsjc);
  }
  
  public Class acceptEventClass()
  {
    return sjc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uqm
 * JD-Core Version:    0.7.0.1
 */