import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

final class uar
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Iterator localIterator = uaq.access$000().iterator();
    while (localIterator.hasNext())
    {
      uaq localuaq = (uaq)((WeakReference)localIterator.next()).get();
      if (localuaq != null) {
        localuaq.onReceive(paramContext, paramIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uar
 * JD-Core Version:    0.7.0.1
 */