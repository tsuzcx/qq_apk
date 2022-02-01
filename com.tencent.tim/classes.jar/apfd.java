import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.MD5;
import java.util.ArrayList;
import java.util.List;

public class apfd
  extends apey
{
  smq.f a;
  protected String aEL;
  protected String coA;
  protected boolean mIsHttps;
  protected List<String> mUrlList = new ArrayList();
  
  protected apfd(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, apey.a parama)
  {
    super(paramLong, paramItem, paramBundle, parama);
    this.jdField_a_of_type_Smq$f = new apfe(this);
  }
  
  public static apfd a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, apey.a parama)
  {
    if (paramLong == 0L)
    {
      apef.b.e("TroopZipInnerFileDownloadWorker", apef.b.USR, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      apef.b.e("TroopZipInnerFileDownloadWorker", apef.b.USR, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      apef.b.e("TroopZipInnerFileDownloadWorker", apef.b.USR, "getWoker. item.id=null");
      return null;
    }
    if (TextUtils.isEmpty(paramItem.zipFilePath))
    {
      apef.b.e("TroopZipInnerFileDownloadWorker", apef.b.USR, "getWoker. zipFilePath=null");
      return null;
    }
    if (TextUtils.isEmpty(paramItem.zipInnerPath))
    {
      apef.b.e("TroopZipInnerFileDownloadWorker", apef.b.USR, "getWoker. zipInnerPath=null");
      return null;
    }
    return new apfd(paramLong, paramItem, paramBundle, parama);
  }
  
  String d(long paramLong)
  {
    return (paramLong & 0xFF) + "." + (paramLong >> 8 & 0xFF) + "." + (paramLong >> 16 & 0xFF) + "." + (paramLong >> 24 & 0xFF);
  }
  
  protected void dYW()
  {
    apdw.a(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 8);
    QQAppInterface localQQAppInterface = apef.getApp();
    if (localQQAppInterface == null)
    {
      apef.b.e("TroopZipInnerFileDownloadWorker", apef.b.USR, "[" + this.coy + "] reqDownload app=null");
      this.jdField_a_of_type_Apdx$a.resultCode = 9;
      this.jdField_a_of_type_Apdx$a.dTI = 902;
      e(true, apue.a.dVY, apue.a.dWt, 1);
      return;
    }
    apef.b.i("TroopZipInnerFileDownloadWorker", apef.b.USR, "[" + this.coy + "] reqDownload");
    Object localObject = apef.a(this.mTroopUin);
    if (localObject != null)
    {
      apbr localapbr = ((apsf)localObject).a(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
      if (localapbr != null)
      {
        localObject = ((apsf)localObject).a(localapbr.mParentId);
        if (localObject != null)
        {
          localapbr.Status = 8;
          ((apbr)localObject).a(localapbr);
        }
      }
    }
    this.mIsHttps = false;
    this.aEL = null;
    this.jdField_c_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b = smq.a(localQQAppInterface, this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipFilePath, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipBusId, this.jdField_a_of_type_Smq$f);
    WE(1);
    apue.ebR();
  }
  
  public boolean start()
  {
    this.mUrlList.clear();
    return super.start();
  }
  
  protected void startDownload()
  {
    QQAppInterface localQQAppInterface = apef.getApp();
    if (localQQAppInterface == null)
    {
      apef.b.e("TroopZipInnerFileDownloadWorker", apef.b.USR, "[" + this.coy + "] startDownload app=null");
      this.jdField_a_of_type_Apdx$a.resultCode = 9;
      this.jdField_a_of_type_Apdx$a.dTI = 902;
      e(true, apue.a.dVY, apue.a.dWt, 1);
      return;
    }
    String str = MD5.toMD5(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    this.mTmpFilePath = (this.coz + str);
    if (this.jdField_a_of_type_Apeu != null)
    {
      this.jdField_a_of_type_Apeu.bme();
      this.jdField_a_of_type_Apeu = null;
    }
    this.YS = System.currentTimeMillis();
    this.jdField_a_of_type_Apdx$a.arf = ahbj.getFileSize(this.mTmpFilePath);
    long l = apef.hr();
    apef.b.i("TroopZipInnerFileDownloadWorker", apef.b.USR, "[" + this.coy + "] startDownload. nSessionId:" + l + " firstIP=" + this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + " urlParams:" + this.coA + " mTmpFilePath:" + this.mTmpFilePath);
    this.jdField_a_of_type_Apeu = apfa.a(localQQAppInterface, l, this.mTmpFilePath, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal, this.mUrlList, this.coA, null, this.mIsHttps, this.aEL);
    if (this.jdField_a_of_type_Apeu == null)
    {
      this.jdField_a_of_type_Apdx$a.resultCode = 9;
      this.jdField_a_of_type_Apdx$a.dTI = 903;
      e(true, apue.a.dVY, apue.a.dWt, 1);
      return;
    }
    this.jdField_a_of_type_Apeu.a(this);
    this.jdField_a_of_type_Apeu.download();
    WE(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apfd
 * JD-Core Version:    0.7.0.1
 */