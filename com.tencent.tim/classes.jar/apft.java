import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileScanTask;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileScanTask.a;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileScaner.1;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileScaner.2;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileScaner.3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class apft
  implements TroopFileScanTask.a
{
  private static apft a;
  private static long arr = 1L;
  private LinkedList<Long> ad = new LinkedList();
  private LinkedList<TroopFileScanTask> af = new LinkedList();
  private LinkedList<TroopFileScanTask> ag = new LinkedList();
  private Map<Long, TroopFileScanTask> nG = new HashMap();
  
  private String Be()
  {
    return " WS:" + this.nG.size() + " QS:" + this.ad.size() + " PRS:" + this.ag.size() + " RS:" + this.af.size();
  }
  
  public static apft a()
  {
    try
    {
      if (a == null) {
        a = new apft();
      }
      apft localapft = a;
      return localapft;
    }
    finally {}
  }
  
  private LinkedList<TroopFileScanTask> b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.nG.entrySet().iterator();
    TroopFileScanTask localTroopFileScanTask;
    while (localIterator.hasNext())
    {
      localTroopFileScanTask = (TroopFileScanTask)((Map.Entry)localIterator.next()).getValue();
      if (paramString.equalsIgnoreCase(localTroopFileScanTask.getFilePath()))
      {
        localLinkedList.add(localTroopFileScanTask);
        localIterator.remove();
      }
    }
    localIterator = this.ag.iterator();
    while (localIterator.hasNext())
    {
      localTroopFileScanTask = (TroopFileScanTask)localIterator.next();
      if (paramString.equalsIgnoreCase(localTroopFileScanTask.getFilePath()))
      {
        localLinkedList.add(localTroopFileScanTask);
        localIterator.remove();
      }
    }
    return localLinkedList;
  }
  
  private void b(long paramLong, boolean paramBoolean, int paramInt, TroopFileScanTask paramTroopFileScanTask)
  {
    this.af.remove(paramTroopFileScanTask);
    this.ag.remove(paramTroopFileScanTask);
    apef.b.i("TroopFileScaner", apef.b.USR, "[" + paramLong + "] onTaskDoneInter.  bSuc:" + paramBoolean + " errCode:" + paramInt + Be());
    Object localObject = b(paramTroopFileScanTask.getFilePath());
    if ((localObject != null) && (((LinkedList)localObject).size() > 0))
    {
      apef.b.w("TroopFileScaner", apef.b.USR, "[" + paramLong + "] onTaskDoneInter. " + ((LinkedList)localObject).size() + " same task passive complete. " + Be());
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TroopFileScanTask)((Iterator)localObject).next()).a(paramBoolean, paramInt, paramTroopFileScanTask.getFilePath(), paramTroopFileScanTask.getFileSize(), paramTroopFileScanTask.aa(), paramTroopFileScanTask.aw(), paramTroopFileScanTask.ax(), paramTroopFileScanTask.q());
      }
    }
    cUQ();
  }
  
  private boolean cM(long paramLong)
  {
    int i = 1;
    Iterator localIterator = this.af.iterator();
    TroopFileScanTask localTroopFileScanTask;
    while (localIterator.hasNext())
    {
      localTroopFileScanTask = (TroopFileScanTask)localIterator.next();
      if (paramLong == localTroopFileScanTask.ht())
      {
        localTroopFileScanTask.stop();
        localIterator.remove();
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        localIterator = this.ag.iterator();
        if (localIterator.hasNext())
        {
          localTroopFileScanTask = (TroopFileScanTask)localIterator.next();
          if (paramLong != localTroopFileScanTask.ht()) {
            break label215;
          }
          localTroopFileScanTask.stop();
          localIterator.remove();
          bool1 = true;
        }
      }
      label215:
      for (;;)
      {
        break;
        if ((TroopFileScanTask)this.nG.remove(Long.valueOf(paramLong)) != null) {}
        for (;;)
        {
          bool2 = bool1 | i | this.ad.remove(Long.valueOf(paramLong));
          if (bool2) {
            apef.b.i("TroopFileScaner", apef.b.USR, "[" + paramLong + "] stopScan." + Be());
          }
          return bool2;
          i = 0;
        }
      }
    }
  }
  
  private void cUQ()
  {
    if (this.af.size() >= 2) {}
    label146:
    for (;;)
    {
      return;
      for (;;)
      {
        if (this.ad.size() <= 0) {
          break label146;
        }
        long l = ((Long)this.ad.remove(0)).longValue();
        TroopFileScanTask localTroopFileScanTask = (TroopFileScanTask)this.nG.remove(Long.valueOf(l));
        if (localTroopFileScanTask != null) {
          if (qw(localTroopFileScanTask.getFilePath()))
          {
            apef.b.w("TroopFileScaner", apef.b.USR, "[" + localTroopFileScanTask.ht() + "] has same task gening. add WD task");
            this.ag.add(localTroopFileScanTask);
            localTroopFileScanTask.dZk();
          }
          else
          {
            this.af.add(localTroopFileScanTask);
            if (localTroopFileScanTask.start()) {
              break;
            }
            this.af.remove(localTroopFileScanTask);
          }
        }
      }
    }
  }
  
  private boolean qw(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator = this.af.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equalsIgnoreCase(((TroopFileScanTask)localIterator.next()).getFilePath())) {
        return true;
      }
    }
    return false;
  }
  
  public long a(String paramString, apft.a parama, Bundle paramBundle)
  {
    long l2 = arr;
    arr = l2 + 1L;
    long l1 = l2;
    if (l2 == 0L)
    {
      l1 = arr;
      arr = l1 + 1L;
    }
    parama = TroopFileScanTask.a(l1, paramString, this, parama);
    if (parama == null) {
      return 0L;
    }
    apdz.b(new TroopFileScaner.1(this, l1, parama, paramString), true);
    return l1;
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, TroopFileScanTask paramTroopFileScanTask)
  {
    apdz.b(new TroopFileScaner.3(this, paramLong, paramBoolean, paramInt, paramTroopFileScanTask), false);
  }
  
  public void lM(long paramLong)
  {
    apdz.b(new TroopFileScaner.2(this, paramLong), true);
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong1, String paramString, long paramLong2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, Bundle paramBundle, int paramInt);
    
    public abstract void aK(long paramLong1, long paramLong2);
    
    public abstract void y(long paramLong1, long paramLong2, long paramLong3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apft
 * JD-Core Version:    0.7.0.1
 */