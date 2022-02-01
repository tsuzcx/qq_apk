import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class apfh
{
  smq.l b = new apfi(this);
  protected long mTroopUin;
  protected int mType;
  protected Map<UUID, TroopFileTransferManager.Item> nC = new HashMap();
  protected Map<UUID, Integer> nF = new HashMap();
  
  protected apfh(long paramLong, List<TroopFileTransferManager.Item> paramList, int paramInt)
  {
    this.mTroopUin = paramLong;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)paramList.next();
      this.nC.put(localItem.Id, localItem);
    }
    this.mType = paramInt;
  }
  
  private int Lk()
  {
    QQAppInterface localQQAppInterface = apef.getApp();
    if (localQQAppInterface == null)
    {
      apef.b.e("TroopFileFromTroopForwarder", apef.b.USR, "multiTroop2weiyun app=null");
      return -1;
    }
    Iterator localIterator = this.nC.values().iterator();
    while (localIterator.hasNext())
    {
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)localIterator.next();
      if (localItem.Id == null)
      {
        apef.b.e("TroopFileFromTroopForwarder", apef.b.USR, "multiTroop2weiyun. item.id=null");
      }
      else if (localItem.ForwardTroopuin == 0L)
      {
        apef.b.e("TroopFileFromTroopForwarder", apef.b.USR, "multiTroop2weiyun. ForwardTroopuin=0");
      }
      else if (localItem.BusId != 25)
      {
        apef.b.e("TroopFileFromTroopForwarder", apef.b.USR, "multiTroop2weiyun. BusId err:" + localItem.BusId);
      }
      else if (TextUtils.isEmpty(localItem.ForwardPath))
      {
        apef.b.e("TroopFileFromTroopForwarder", apef.b.USR, "multiTroop2weiyun. ForwardPath=null");
      }
      else
      {
        apef.b.i("TroopFileFromTroopForwarder", apef.b.USR, "[" + localItem.Id.toString() + "] multiTroop2weiyun. BusId:" + localItem.BusId + " ForwardBusId:" + localItem.ForwardBusId + " ForwardPath:" + localItem.ForwardPath);
        try
        {
          this.nF.put(localItem.Id, Integer.valueOf(2147483647));
          smq.a(localQQAppInterface, true, this.mTroopUin, localItem, localQQAppInterface.getLongAccountUin(), 0L, this.b);
        }
        finally {}
      }
    }
    return 0;
  }
  
  public static apfh a(long paramLong, List<TroopFileTransferManager.Item> paramList)
  {
    if (paramLong == 0L)
    {
      apef.b.e("TroopFileFromTroopForwarder", apef.b.USR, "getTroop2WeiyunForwarder. troopuin=0");
      return null;
    }
    if (paramList == null)
    {
      apef.b.e("TroopFileFromTroopForwarder", apef.b.USR, "getTroop2WeiyunForwarder. item=null");
      return null;
    }
    return new apfh(paramLong, paramList, 1);
  }
  
  private final void a(TroopFileTransferManager.Item paramItem, boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    if (!paramBoolean) {}
    try
    {
      awou.nP(-1);
      this.nF.put(paramItem.Id, Integer.valueOf(-1));
      apef.b.e("TroopFileFromTroopForwarder", apef.b.USR, "[" + paramItem.Id.toString() + "] onRspMultiCopyToWeiyun fail. isSuc:" + paramBoolean);
      return;
    }
    finally {}
    apef.b.i("TroopFileFromTroopForwarder", apef.b.USR, "[" + paramItem.Id.toString() + "] onRspMultiCopyToWeiyun retCode:" + paramInt1);
    awou.nP(paramInt1);
    if (paramInt1 == 0)
    {
      this.nF.remove(paramItem.Id);
      if (this.nF.size() != 0) {
        break label212;
      }
      paramString1 = new apsd.a(paramItem.FileName, this.mTroopUin, 5, 604);
      apdw.a(this.mTroopUin, paramItem, 5, paramString1);
    }
    label316:
    for (;;)
    {
      return;
      this.nF.put(paramItem.Id, Integer.valueOf(paramInt1));
      break;
      label212:
      paramString1 = this.nF.keySet().iterator();
      do
      {
        if (!paramString1.hasNext()) {
          break;
        }
        paramString2 = (UUID)paramString1.next();
      } while (((Integer)this.nF.get(paramString2)).intValue() != 2147483647);
      for (paramInt1 = 0;; paramInt1 = 1)
      {
        if (paramInt1 == 0) {
          break label316;
        }
        paramString1 = new apsd.a(paramItem.FileName, this.mTroopUin, 5, 605);
        apdw.a(this.mTroopUin, paramItem, 5, paramString1);
        break;
      }
    }
  }
  
  public int Li()
  {
    if (1 == this.mType) {
      return Lk();
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apfh
 * JD-Core Version:    0.7.0.1
 */