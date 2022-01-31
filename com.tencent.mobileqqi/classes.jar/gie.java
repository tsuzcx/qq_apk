import android.os.AsyncTask;
import com.tencent.mobileqq.richstatus.ISameStatusListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class gie
  extends AsyncTask
{
  public gie(StatusManager paramStatusManager) {}
  
  protected ArrayList a(Void... paramVarArgs)
  {
    return this.a.a();
  }
  
  protected void a(ArrayList paramArrayList)
  {
    StatusManager.b(this.a, paramArrayList);
    StatusManager.b(this.a, null);
    if (StatusManager.c(this.a) != null)
    {
      paramArrayList = this.a.a(StatusManager.b(this.a), StatusManager.c(this.a), StatusManager.b(this.a));
      StatusManager.a(this.a, null);
      if (StatusManager.c(this.a) != null)
      {
        Iterator localIterator = StatusManager.c(this.a).iterator();
        if (localIterator.hasNext())
        {
          ISameStatusListener localISameStatusListener = (ISameStatusListener)localIterator.next();
          int i = StatusManager.b(this.a);
          if ((StatusManager.a(this.a) != null) && (StatusManager.a(this.a).length > 1)) {}
          for (boolean bool = true;; bool = false)
          {
            localISameStatusListener.a(true, true, i, paramArrayList, bool);
            break;
          }
        }
      }
    }
  }
  
  protected void onCancelled()
  {
    StatusManager.b(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gie
 * JD-Core Version:    0.7.0.1
 */