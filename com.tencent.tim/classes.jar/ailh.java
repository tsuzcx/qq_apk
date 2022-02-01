import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ailh
  extends BroadcastReceiver
{
  public ailh(UiApiPlugin paramUiApiPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((UiApiPlugin.ai != null) && (UiApiPlugin.ai.size() > 0))
    {
      Iterator localIterator = UiApiPlugin.ai.iterator();
      while (localIterator.hasNext())
      {
        UiApiPlugin localUiApiPlugin = (UiApiPlugin)((WeakReference)localIterator.next()).get();
        if (localUiApiPlugin != null) {
          localUiApiPlugin.onReceive(paramContext, paramIntent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ailh
 * JD-Core Version:    0.7.0.1
 */