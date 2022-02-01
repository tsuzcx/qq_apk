import android.text.TextUtils;
import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailGenMgr.1;
import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailGenTask;
import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailGenTask.a;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public class apfp
  implements TroopFileThumbnailGenTask.a
{
  private LinkedList<String> ad = new LinkedList();
  private LinkedList<TroopFileThumbnailGenTask> af = new LinkedList();
  private LinkedList<TroopFileThumbnailGenTask> ag = new LinkedList();
  private Map<String, TroopFileThumbnailGenTask> nG = new HashMap();
  
  private String Be()
  {
    return " WS:" + this.nG.size() + " QS:" + this.ad.size() + " PRS:" + this.ag.size() + " RS:" + this.af.size();
  }
  
  private LinkedList<TroopFileThumbnailGenTask> a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.nG.entrySet().iterator();
    TroopFileThumbnailGenTask localTroopFileThumbnailGenTask;
    while (localIterator.hasNext())
    {
      localTroopFileThumbnailGenTask = (TroopFileThumbnailGenTask)((Map.Entry)localIterator.next()).getValue();
      if ((paramInt == localTroopFileThumbnailGenTask.Lm()) && (paramString.equalsIgnoreCase(localTroopFileThumbnailGenTask.Bf())))
      {
        localLinkedList.add(localTroopFileThumbnailGenTask);
        localIterator.remove();
      }
    }
    localIterator = this.ag.iterator();
    while (localIterator.hasNext())
    {
      localTroopFileThumbnailGenTask = (TroopFileThumbnailGenTask)localIterator.next();
      if ((paramInt == localTroopFileThumbnailGenTask.Lm()) && (paramString.equalsIgnoreCase(localTroopFileThumbnailGenTask.Bf())))
      {
        localLinkedList.add(localTroopFileThumbnailGenTask);
        localIterator.remove();
      }
    }
    return localLinkedList;
  }
  
  private boolean ao(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator = this.af.iterator();
    while (localIterator.hasNext())
    {
      TroopFileThumbnailGenTask localTroopFileThumbnailGenTask = (TroopFileThumbnailGenTask)localIterator.next();
      if ((paramInt == localTroopFileThumbnailGenTask.Lm()) && (paramString.equalsIgnoreCase(localTroopFileThumbnailGenTask.Bf()))) {
        return true;
      }
    }
    return false;
  }
  
  public static String b(UUID paramUUID, int paramInt)
  {
    return paramUUID.toString() + "_" + paramInt;
  }
  
  private void cUQ()
  {
    if (this.af.size() >= 4) {}
    label179:
    for (;;)
    {
      return;
      for (;;)
      {
        if (this.ad.size() <= 0) {
          break label179;
        }
        Object localObject = (String)this.ad.remove(0);
        localObject = (TroopFileThumbnailGenTask)this.nG.remove(localObject);
        if (localObject != null) {
          if (ao(((TroopFileThumbnailGenTask)localObject).Bf(), ((TroopFileThumbnailGenTask)localObject).Lm()))
          {
            apef.b.w("TroopFileThumbnailGenMgr", apef.b.USR, "[" + ((TroopFileThumbnailGenTask)localObject).getTaskId() + "] has same task gening. add WD task");
            this.ag.add(localObject);
            ((TroopFileThumbnailGenTask)localObject).dZk();
          }
          else
          {
            this.af.add(localObject);
            if (((TroopFileThumbnailGenTask)localObject).start()) {
              break;
            }
            apef.b.e("TroopFileThumbnailGenMgr", apef.b.USR, "[" + ((TroopFileThumbnailGenTask)localObject).getTaskId() + "] start failed!!");
            this.af.remove(localObject);
          }
        }
      }
    }
  }
  
  public int a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, String paramString)
  {
    if ((paramLong == 0L) || (paramItem == null)) {
      return -1;
    }
    if (paramItem.Id == null) {
      return -2;
    }
    if (paramInt == 0) {
      return -5;
    }
    String str = b(paramItem.Id, paramInt);
    if (qv(str))
    {
      apef.b.i("TroopFileThumbnailGenMgr", apef.b.USR, "[" + str + "] genFileThumbnail task exsited. ");
      return -4;
    }
    paramString = TroopFileThumbnailGenTask.a(paramLong, paramItem, paramInt, paramString, this);
    if (paramString == null) {
      return -3;
    }
    apfq.a(paramItem, paramInt);
    this.nG.put(str, paramString);
    this.ad.add(str);
    apef.b.i("TroopFileThumbnailGenMgr", apef.b.USR, "[" + str + "] genFileThumbnail filePath:" + paramItem.LocalFile + Be());
    cUQ();
    return 0;
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt, TroopFileThumbnailGenTask paramTroopFileThumbnailGenTask)
  {
    apdz.b(new TroopFileThumbnailGenMgr.1(this, paramString, paramBoolean, paramInt, paramTroopFileThumbnailGenTask), false);
  }
  
  public int b(UUID paramUUID, int paramInt)
  {
    if (paramUUID == null) {
      return -2;
    }
    String str = b(paramUUID, paramInt);
    Object localObject = this.af.iterator();
    TroopFileThumbnailGenTask localTroopFileThumbnailGenTask;
    while (((Iterator)localObject).hasNext())
    {
      localTroopFileThumbnailGenTask = (TroopFileThumbnailGenTask)((Iterator)localObject).next();
      if (str.equalsIgnoreCase(localTroopFileThumbnailGenTask.getTaskId()))
      {
        localTroopFileThumbnailGenTask.stop();
        ((Iterator)localObject).remove();
      }
    }
    for (paramInt = 1;; paramInt = 0)
    {
      int i = paramInt;
      if (paramInt == 0)
      {
        localObject = this.ag.iterator();
        if (((Iterator)localObject).hasNext())
        {
          localTroopFileThumbnailGenTask = (TroopFileThumbnailGenTask)((Iterator)localObject).next();
          if (!str.equalsIgnoreCase(localTroopFileThumbnailGenTask.getTaskId())) {
            break label231;
          }
          localTroopFileThumbnailGenTask.stop();
          ((Iterator)localObject).remove();
          paramInt = 1;
        }
      }
      label231:
      for (;;)
      {
        break;
        localObject = (TroopFileThumbnailGenTask)this.nG.remove(paramUUID);
        i = paramInt;
        if (localObject != null)
        {
          ((TroopFileThumbnailGenTask)localObject).stop();
          i = paramInt | 0x1;
        }
        boolean bool = this.ad.remove(paramUUID) | i;
        if (bool) {
          apef.b.i("TroopFileThumbnailGenMgr", apef.b.USR, "[" + str + "] stopGen." + Be());
        }
        cUQ();
        return 0;
      }
    }
  }
  
  public void b(String paramString, boolean paramBoolean, int paramInt, TroopFileThumbnailGenTask paramTroopFileThumbnailGenTask)
  {
    this.af.remove(paramTroopFileThumbnailGenTask);
    this.ag.remove(paramTroopFileThumbnailGenTask);
    apef.b.i("TroopFileThumbnailGenMgr", apef.b.USR, "[" + paramString + "] onTaskDoneInter.  bSuc:" + paramBoolean + " errCode:" + paramInt + Be());
    LinkedList localLinkedList = a(paramTroopFileThumbnailGenTask.Bf(), paramTroopFileThumbnailGenTask.Lm());
    if ((localLinkedList != null) && (localLinkedList.size() > 0))
    {
      apef.b.w("TroopFileThumbnailGenMgr", apef.b.USR, "[" + paramString + "] onTaskDoneInter. " + localLinkedList.size() + " same task passive complete. " + Be());
      paramString = localLinkedList.iterator();
      while (paramString.hasNext()) {
        ((TroopFileThumbnailGenTask)paramString.next()).w(paramBoolean, paramInt, paramTroopFileThumbnailGenTask.getThumbPath());
      }
    }
    cUQ();
  }
  
  protected void dZg()
  {
    Iterator localIterator = this.af.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileThumbnailGenTask)localIterator.next()).stop();
    }
    this.af.clear();
    this.nG.clear();
    this.ad.clear();
    this.ag.clear();
    apef.b.i("TroopFileThumbnailGenMgr", apef.b.USR, "stopAllInter");
  }
  
  public void init() {}
  
  protected boolean qv(String paramString)
  {
    Iterator localIterator = this.af.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equalsIgnoreCase(((TroopFileThumbnailGenTask)localIterator.next()).getTaskId())) {
        return true;
      }
    }
    localIterator = this.ag.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equalsIgnoreCase(((TroopFileThumbnailGenTask)localIterator.next()).getTaskId())) {
        return true;
      }
    }
    return this.nG.containsKey(paramString);
  }
  
  public void release()
  {
    dZg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apfp
 * JD-Core Version:    0.7.0.1
 */