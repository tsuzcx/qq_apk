import android.os.Bundle;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

public class ahxc
  implements BusinessObserver
{
  private final SparseArray<WeakReference<ahxe>> cq = new SparseArray();
  private int id;
  
  private void K(boolean paramBoolean, Bundle paramBundle)
  {
    int j = 0;
    int i;
    if (paramBundle != null) {
      i = paramBundle.getInt("req_id");
    }
    for (;;)
    {
      synchronized (this.cq)
      {
        localObject1 = (WeakReference)this.cq.get(i);
        if (localObject1 == null) {
          break label149;
        }
        localObject2 = (ahxe)((WeakReference)localObject1).get();
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          this.cq.delete(i);
          return;
        }
        i = paramBundle.getInt("result");
        j = paramBundle.getInt("jump_result");
        ??? = paramBundle.getString("jump_url");
        localObject2 = paramBundle.getString("ext_info");
        paramBundle = (Bundle)???;
        if (localObject1 == null) {
          break label148;
        }
        ((ahxe)localObject1).a(paramBoolean, i, j, paramBundle, (String)localObject2);
        return;
      }
      Object localObject1 = null;
      Object localObject2 = null;
      paramBundle = null;
      i = 0;
      continue;
      label148:
      return;
      label149:
      localObject1 = null;
    }
  }
  
  int a(ahxe paramahxe)
  {
    synchronized (this.cq)
    {
      SparseArray localSparseArray2 = this.cq;
      int i = this.id + 1;
      this.id = i;
      localSparseArray2.append(i, new WeakReference(paramahxe));
      i = this.id;
      return i;
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    K(paramBoolean, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahxc
 * JD-Core Version:    0.7.0.1
 */