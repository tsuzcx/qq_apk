import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

final class aijb
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((aija.ah != null) && (aija.ah.size() > 0))
    {
      Iterator localIterator = aija.ah.iterator();
      while (localIterator.hasNext())
      {
        aija localaija = (aija)((WeakReference)localIterator.next()).get();
        if (localaija != null) {
          localaija.onReceive(paramContext, paramIntent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aijb
 * JD-Core Version:    0.7.0.1
 */