import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class avjv
  extends RemoteCommand
{
  private SparseArray<List<avjv.a>> p = new SparseArray();
  
  public avjv(AppRuntime paramAppRuntime)
  {
    super("com.tencent.qqfav.favoritesremotecommand");
    a(0, new avjw());
  }
  
  public boolean a(int paramInt, avjv.a parama)
  {
    List localList = (List)this.p.get(paramInt);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.p.put(paramInt, localObject);
    }
    if (!((List)localObject).contains(parama)) {
      return ((List)localObject).add(parama);
    }
    return false;
  }
  
  public boolean b(int paramInt, avjv.a parama)
  {
    List localList = (List)this.p.get(paramInt);
    if ((localList != null) && (localList.contains(parama))) {
      return localList.remove(parama);
    }
    return false;
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    int i = paramBundle.getInt("com.tencent.qqfav.favoritesremotecommand.id", -1);
    if (-1 != i)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("FavoritesRemoteCommand", 4, "invoke: dataInvoke=" + paramBundle.toString());
      }
      paramOnInvokeFinishLinstener = (List)this.p.get(i);
      if (paramOnInvokeFinishLinstener == null) {
        break label100;
      }
      paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.iterator();
      do
      {
        if (!paramOnInvokeFinishLinstener.hasNext()) {
          break;
        }
      } while (!((avjv.a)paramOnInvokeFinishLinstener.next()).f(i, paramBundle));
    }
    label100:
    do
    {
      while (!paramOnInvokeFinishLinstener.hasNext())
      {
        do
        {
          return paramBundle;
          paramOnInvokeFinishLinstener = (List)this.p.get(0);
        } while (paramOnInvokeFinishLinstener == null);
        paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.iterator();
      }
    } while (!((avjv.a)paramOnInvokeFinishLinstener.next()).f(i, paramBundle));
    return paramBundle;
  }
  
  public static abstract interface a
  {
    public abstract boolean f(int paramInt, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avjv
 * JD-Core Version:    0.7.0.1
 */