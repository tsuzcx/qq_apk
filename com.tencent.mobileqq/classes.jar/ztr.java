import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

final class ztr
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Iterator localIterator = ztq.a().iterator();
    while (localIterator.hasNext())
    {
      ztq localztq = (ztq)((WeakReference)localIterator.next()).get();
      if (localztq != null) {
        localztq.a(paramContext, paramIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ztr
 * JD-Core Version:    0.7.0.1
 */