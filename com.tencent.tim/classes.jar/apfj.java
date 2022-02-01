import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.filemanager.forward.TroopFileToTroopForwarder.2;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;

public class apfj
  extends apfu
{
  smq.l a = new apfk(this);
  
  protected apfj(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    super(paramLong, paramItem);
  }
  
  private int Ll()
  {
    QQAppInterface localQQAppInterface = apef.getApp();
    if (localQQAppInterface == null)
    {
      apef.b.e("TroopFileToTroopForwarder", apef.b.USR, "[" + this.coy + "] startTroop2Troop app=null");
      return -1;
    }
    apef.b.i("TroopFileToTroopForwarder", apef.b.USR, "[" + this.coy + "] startTroop2Troop. BusId:" + this.c.BusId + " ForwardBusId:" + this.c.ForwardBusId + " ForwardPath:" + this.c.ForwardPath + " entrySessionID:" + this.c.entrySessionID + " with:" + this.c.width + " height:" + this.c.height);
    smq.a(localQQAppInterface, false, this.mTroopUin, this.c, this.mTroopUin, 0L, this.a);
    apdw.a(this.mTroopUin, this.c, 4, 0);
    return 0;
  }
  
  public static apfj a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      apef.b.e("TroopFileToTroopForwarder", apef.b.USR, "getTroop2TroopForwarder. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      apef.b.e("TroopFileToTroopForwarder", apef.b.USR, "getTroop2TroopForwarder. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      apef.b.e("TroopFileToTroopForwarder", apef.b.USR, "getTroop2TroopForwarder. item.id=null");
      return null;
    }
    if (paramItem.ForwardTroopuin == 0L)
    {
      apef.b.e("TroopFileToTroopForwarder", apef.b.USR, "getTroop2TroopForwarder. ForwardTroopuin=0");
      return null;
    }
    if ((paramItem.BusId != 102) && (paramItem.BusId != 104))
    {
      apef.b.e("TroopFileToTroopForwarder", apef.b.USR, "getTroop2TroopForwarder. BusId err:" + paramItem.BusId);
      return null;
    }
    if (TextUtils.isEmpty(paramItem.ForwardPath))
    {
      apef.b.e("TroopFileToTroopForwarder", apef.b.USR, "getTroop2TroopForwarder. ForwardPath=null");
      return null;
    }
    return new apfj(paramLong, paramItem);
  }
  
  private final void c(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    paramString2 = apef.getApp();
    apef.b.i("TroopFileToTroopForwarder", apef.b.USR, "[" + this.coy + "] onFowardToTroopResult isSuccess:true retCode:" + paramInt1);
    if (paramInt1 < 0)
    {
      paramInt2 = 207;
      switch (paramInt1)
      {
      default: 
        paramString1 = paramString3;
        paramInt1 = paramInt2;
      }
      for (;;)
      {
        paramString1 = new apsd.a(this.c.FileName, this.c.ForwardTroopuin, 5, paramInt1, paramString1);
        apdw.a(this.mTroopUin, this.c, 5, paramString1);
        if (paramString2 == null) {
          break;
        }
        paramString1 = paramString2.a().b(this.c.entrySessionID);
        if (paramString1 != null)
        {
          long l = paramString1.structMsgSeq;
          paramString2.b().t("" + this.mTroopUin, 1, l);
        }
        return;
        paramInt1 = 202;
        paramString1 = paramString3;
        continue;
        paramInt1 = 600;
        paramString1 = paramString3;
        continue;
        paramInt1 = 701;
        paramString1 = paramString3;
        continue;
        paramInt1 = 706;
        paramString1 = acfp.m(2131715701);
        continue;
        if (this.c.BusId == 102)
        {
          this.c.BusId = 104;
          if (paramString2 != null)
          {
            apef.b.w("TroopFileToTroopForwarder", apef.b.USR, "[" + this.coy + "] onFowardToTroopResult: space no enough. fowrd temp.");
            smq.a(paramString2, false, this.mTroopUin, this.c, this.mTroopUin, 0L, this.a);
            return;
          }
          paramInt1 = 204;
          paramString1 = paramString3;
        }
        else
        {
          paramInt1 = 204;
          paramString1 = paramString3;
          continue;
          paramInt1 = -139;
          paramString1 = paramString3;
          continue;
          if ((!TextUtils.isEmpty(this.c.LocalFile)) && (new VFSFile(this.c.LocalFile).exists()))
          {
            apef.b.w("TroopFileToTroopForwarder", apef.b.USR, "[" + this.coy + "] onFowardToTroopResult: -6101. start local uploadl.");
            apfx.a().e(this.mTroopUin, this.c, null);
            return;
          }
          paramInt1 = 603;
          paramString1 = paramString3;
          continue;
          paramInt1 = 705;
          paramString1 = paramString3;
        }
      }
      apef.b.e("TroopFileToTroopForwarder", apef.b.USR, "[" + this.coy + "] onFowardToTroopResult fail. removeMsgByUniseq fail.");
      return;
    }
    new Handler(Looper.getMainLooper()).post(new TroopFileToTroopForwarder.2(this));
    this.c.FilePath = paramString1;
    apef.b.i("TroopFileToTroopForwarder", apef.b.USR, "[" + this.coy + "] onFowardToTroopResult sucess. mItem.FilePath:" + paramString1);
    paramString3 = this.c.getInfo(this.mTroopUin);
    if (paramString3 != null) {
      paramString3.FilePath = paramString1;
    }
    if (paramString2 != null)
    {
      paramString2 = paramString2.a().b(this.c.entrySessionID);
      if (paramString2 != null) {
        paramString2.strTroopFilePath = paramString1;
      }
    }
    for (;;)
    {
      apdw.a(this.mTroopUin, this.c, 7, 0);
      dZm();
      return;
      apef.b.e("TroopFileToTroopForwarder", apef.b.USR, "[" + this.coy + "] onFowardToTroopResult sucess. update entity.strTroopFilePath fail.");
    }
  }
  
  public int Li()
  {
    return Ll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apfj
 * JD-Core Version:    0.7.0.1
 */