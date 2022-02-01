import android.content.Context;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import java.lang.ref.WeakReference;

public final class tjp
{
  private static volatile tjp a;
  
  public static tjp a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new tjp();
      }
      return a;
    }
    finally {}
  }
  
  public void init(Context paramContext)
  {
    AdIPCManager.INSTANCE.init(paramContext, new WeakReference(tlo.a().a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tjp
 * JD-Core Version:    0.7.0.1
 */