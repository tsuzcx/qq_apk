import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr.b;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class apfb
{
  smq.m a = new apfc(this);
  protected TroopFileProtoReqMgr.b c;
  protected TroopFileTransferManager.Item c;
  protected String coy;
  protected long mTroopUin;
  
  private apfb(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    this.mTroopUin = paramLong;
    this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    if (this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id != null) {}
    for (paramItem = this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id.toString();; paramItem = "")
    {
      this.coy = paramItem;
      return;
    }
  }
  
  public static apfb a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      apef.b.e("TroopFilePreviewWorker", apef.b.USR, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      apef.b.e("TroopFilePreviewWorker", apef.b.USR, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      apef.b.e("TroopFilePreviewWorker", apef.b.USR, "getWoker. item.id=null");
      return null;
    }
    return new apfb(paramLong, paramItem);
  }
  
  public UUID a()
  {
    return this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id;
  }
  
  public boolean getPreviewInfo()
  {
    QQAppInterface localQQAppInterface = apef.getApp();
    if (localQQAppInterface == null)
    {
      apef.b.e("TroopFilePreviewWorker", apef.b.USR, "[" + this.coy + "] getPreviewInfo app=null");
      return false;
    }
    apef.b.i("TroopFilePreviewWorker", apef.b.USR, "[" + this.coy + "] getPreviewInfo");
    this.jdField_c_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b = smq.a(localQQAppInterface, this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 0, true, false, this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apfb
 * JD-Core Version:    0.7.0.1
 */