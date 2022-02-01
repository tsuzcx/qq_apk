import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailFetchMgr.1;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;

public class apfm
  implements apfn.a
{
  private LinkedList<String> ad = new LinkedList();
  private LinkedList<apfn> ae = new LinkedList();
  private Map<String, apfn> nE = new HashMap();
  
  private String Bb()
  {
    return " WS:" + this.nE.size() + " QS:" + this.ad.size() + " RS:" + this.ae.size();
  }
  
  public static String a(UUID paramUUID, int paramInt)
  {
    return paramUUID.toString() + "_" + paramInt;
  }
  
  private void dYU()
  {
    if (this.ae.size() >= 10) {}
    label79:
    for (;;)
    {
      return;
      for (;;)
      {
        if (this.ad.size() <= 0) {
          break label79;
        }
        Object localObject = (String)this.ad.remove(0);
        localObject = (apfn)this.nE.remove(localObject);
        if (localObject != null)
        {
          this.ae.add(localObject);
          if (((apfn)localObject).start()) {
            break;
          }
          this.ae.remove(localObject);
        }
      }
    }
  }
  
  public int a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt)
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
    String str = a(paramItem.Id, paramInt);
    if (qu(str))
    {
      apef.b.i("TroopFileThumbnailFetchMgr", apef.b.USR, "[" + str + "] fetchFileThumbnail worker exsited. ");
      return -4;
    }
    apfn localapfn = apfn.a(paramLong, paramItem, paramInt, this);
    if (localapfn == null) {
      return -3;
    }
    apfq.a(paramItem, paramInt);
    this.nE.put(str, localapfn);
    this.ad.add(str);
    apef.b.i("TroopFileThumbnailFetchMgr", apef.b.USR, "[" + str + "] fetchFileThumbnail fileName. " + paramItem.FileName + Bb());
    dYU();
    return 0;
  }
  
  public int a(UUID paramUUID, int paramInt)
  {
    if (paramUUID == null) {
      return -2;
    }
    String str = a(paramUUID, paramInt);
    Object localObject = this.ae.iterator();
    while (((Iterator)localObject).hasNext())
    {
      apfn localapfn = (apfn)((Iterator)localObject).next();
      if (str.equalsIgnoreCase(localapfn.Bd()))
      {
        localapfn.stop();
        ((Iterator)localObject).remove();
      }
    }
    for (paramInt = 1;; paramInt = 0)
    {
      int i = paramInt;
      if (paramInt == 0)
      {
        localObject = (apfn)this.nE.remove(paramUUID);
        if (localObject == null) {
          break label168;
        }
        ((apfn)localObject).stop();
        paramInt |= 0x1;
      }
      label168:
      for (;;)
      {
        boolean bool = this.ad.remove(paramUUID) | paramInt;
        if (bool) {
          apef.b.i("TroopFileThumbnailFetchMgr", apef.b.USR, "[" + str + "] stopFetch. " + Bb());
        }
        dYU();
        return 0;
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt, apfn paramapfn)
  {
    apdz.b(new TroopFileThumbnailFetchMgr.1(this, paramString, paramBoolean, paramInt, paramapfn), false);
  }
  
  public void b(String paramString, boolean paramBoolean, int paramInt, apfn paramapfn)
  {
    this.ae.remove(paramapfn);
    apef.b.i("TroopFileThumbnailFetchMgr", apef.b.USR, "[" + paramString + "] onWorkDoneInter. bSuc:" + paramBoolean + " errCode:" + paramInt + Bb());
    dYU();
  }
  
  protected void dZg()
  {
    Iterator localIterator = this.ae.iterator();
    while (localIterator.hasNext()) {
      ((apfn)localIterator.next()).stop();
    }
    this.ae.clear();
    localIterator = this.nE.values().iterator();
    while (localIterator.hasNext()) {
      ((apfn)localIterator.next()).stop();
    }
    this.nE.clear();
    this.ad.clear();
    apef.b.i("TroopFileThumbnailFetchMgr", apef.b.USR, "stopAllInter");
  }
  
  public void init() {}
  
  protected boolean qu(String paramString)
  {
    Iterator localIterator = this.ae.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equalsIgnoreCase(((apfn)localIterator.next()).Bd())) {
        return true;
      }
    }
    return this.nE.containsKey(paramString);
  }
  
  public void release()
  {
    dZg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apfm
 * JD-Core Version:    0.7.0.1
 */