import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class apff
{
  smq.l a = new apfg(this);
  protected TroopFileTransferManager.Item c;
  protected String coy;
  protected long mTroopUin;
  protected int mType;
  
  protected apff(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    this.mTroopUin = paramLong;
    this.c = paramItem;
    if (this.c.Id != null) {}
    for (paramItem = this.c.Id.toString();; paramItem = "")
    {
      this.coy = paramItem;
      this.mType = paramInt;
      return;
    }
  }
  
  private int Lj()
  {
    QQAppInterface localQQAppInterface = apef.getApp();
    if (localQQAppInterface == null)
    {
      apef.b.e("TroopFileFromTroopForwarder", apef.b.USR, "[" + this.coy + "] troop2weiyun app=null");
      return -1;
    }
    apef.b.i("TroopFileFromTroopForwarder", apef.b.USR, "[" + this.coy + "] troop2weiyun. BusId:" + this.c.BusId + " ForwardBusId:" + this.c.ForwardBusId + " ForwardPath:" + this.c.ForwardPath);
    smq.a(localQQAppInterface, true, this.mTroopUin, this.c, localQQAppInterface.getLongAccountUin(), 0L, this.a);
    return 0;
  }
  
  public static apff a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      apef.b.e("TroopFileFromTroopForwarder", apef.b.USR, "getTroop2WeiyunForwarder. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      apef.b.e("TroopFileFromTroopForwarder", apef.b.USR, "getTroop2WeiyunForwarder. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      apef.b.e("TroopFileFromTroopForwarder", apef.b.USR, "getTroop2WeiyunForwarder. item.id=null");
      return null;
    }
    if (paramItem.ForwardTroopuin == 0L)
    {
      apef.b.e("TroopFileFromTroopForwarder", apef.b.USR, "getTroop2WeiyunForwarder. ForwardTroopuin=0");
      return null;
    }
    if (paramItem.BusId != 25)
    {
      apef.b.e("TroopFileFromTroopForwarder", apef.b.USR, "getTroop2WeiyunForwarder. BusId err:" + paramItem.BusId);
      return null;
    }
    if (TextUtils.isEmpty(paramItem.ForwardPath))
    {
      apef.b.e("TroopFileFromTroopForwarder", apef.b.USR, "get2WeiyunForwarder. ForwardPath=null");
      return null;
    }
    return new apff(paramLong, paramItem, 1);
  }
  
  private final void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    paramInt2 = 601;
    if (!paramBoolean)
    {
      awou.nP(-1);
      apef.b.e("TroopFileFromTroopForwarder", apef.b.USR, "[" + this.coy + "] onTroop2weiyunResult isSuccess:false ");
      paramString1 = new apsd.a(this.c.FileName, this.mTroopUin, 5, 601);
      apdw.a(this.mTroopUin, this.c, 5, paramString1);
      return;
    }
    apef.b.i("TroopFileFromTroopForwarder", apef.b.USR, "[" + this.coy + "] onTroop2weiyunResult retCode:" + paramInt1 + " sClientWording:" + paramString3);
    awou.nP(paramInt1);
    if (paramInt1 != 0)
    {
      switch (paramInt1)
      {
      default: 
        paramInt1 = paramInt2;
      }
      for (;;)
      {
        paramString1 = new apsd.a(this.c.FileName, this.mTroopUin, 5, paramInt1, paramString3);
        apdw.a(this.mTroopUin, this.c, 5, paramString1);
        return;
        paramInt1 = 202;
        continue;
        paramInt1 = 702;
        continue;
        paramInt1 = 703;
        continue;
        paramInt1 = 702;
        continue;
        paramInt1 = 701;
        continue;
        paramInt1 = 705;
        continue;
        paramInt1 = paramInt2;
        if (!TextUtils.isEmpty(paramString3)) {
          paramInt1 = 704;
        }
      }
    }
    paramString1 = new apsd.a(this.c.FileName, this.mTroopUin, 5, 602);
    apdw.a(this.mTroopUin, this.c, 5, paramString1);
  }
  
  public int Li()
  {
    if (1 == this.mType) {
      return Lj();
    }
    return -1;
  }
  
  public UUID a()
  {
    return this.c.Id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apff
 * JD-Core Version:    0.7.0.1
 */