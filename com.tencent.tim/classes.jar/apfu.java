import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class apfu
{
  smq.h jdField_a_of_type_Smq$h = new apfw(this);
  smq.n jdField_a_of_type_Smq$n = new apfv(this);
  public TroopFileTransferManager.Item c;
  public String coy;
  public long mTroopUin;
  
  protected apfu(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    this.mTroopUin = paramLong;
    this.c = paramItem;
    if (this.c.Id != null) {}
    for (paramItem = this.c.Id.toString();; paramItem = "")
    {
      this.coy = paramItem;
      return;
    }
  }
  
  public static apfu a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      apef.b.e("TroopFileUploadFeedsSender", apef.b.USR, "getSender. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      apef.b.e("TroopFileUploadFeedsSender", apef.b.USR, "getSender. item=null");
      return null;
    }
    if (paramItem.Id == null) {
      apef.b.e("TroopFileUploadFeedsSender", apef.b.USR, "getSender. item.id=null");
    }
    return new apfu(paramLong, paramItem);
  }
  
  public UUID a()
  {
    return this.c.Id;
  }
  
  public void dZm()
  {
    QQAppInterface localQQAppInterface = apef.getApp();
    if (localQQAppInterface == null)
    {
      apef.b.e("TroopFileUploadFeedsSender", apef.b.USR, "[" + this.coy + "] reqFeedMsgV2 app=null");
      return;
    }
    apef.b.i("TroopFileUploadFeedsSender", apef.b.USR, "[" + this.coy + "] reqFeedMsgV2");
    smq.a(localQQAppInterface, this.mTroopUin, this.c, this.jdField_a_of_type_Smq$n);
  }
  
  public long hs()
  {
    return this.mTroopUin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apfu
 * JD-Core Version:    0.7.0.1
 */