import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troopgift.AIOGiftPanelContainer.2;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class smy
  extends apsy
{
  public smy(AIOGiftPanelContainer.2 param2, apsz paramapsz, long paramLong, apqk paramapqk) {}
  
  public void onError(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGiftPanelContainer", 2, "onError() time =  " + (System.currentTimeMillis() - this.AG) + ", errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
  }
  
  public void z(String paramString1, int paramInt, String paramString2)
  {
    long l = System.currentTimeMillis();
    int i = this.jdField_a_of_type_Apsz.jN(this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.bxP);
    if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.bxP == 5) {
      snf.tr(paramString2);
    }
    do
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOGiftPanelContainer", 2, "onGetExtraData() , configURL = " + paramString1 + ", serverVer=" + paramInt + ", localVer=" + i + ", exIds=" + paramString2);
        }
        QLog.d("TroopGiftPanel.time", 1, "onGetExtraData, time=" + (l - this.AG) + ", total=" + (l - this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.CW));
        this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.a = snf.a(this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.mBaseChatPie.mContext, this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.bxP, this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.mBaseChatPie.sessionInfo.troopUin);
        if ((paramInt > i) || (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.a == null)) {
          break;
        }
        smx.a(this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0, true);
        this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.yD(0);
        return;
        if ((this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.bxP == 1) || (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.bxP == 6) || (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.bxP == 4)) {
          snf.cN(paramString2, this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.mBaseChatPie.sessionInfo.troopUin);
        }
      }
    } while (TextUtils.isEmpty(paramString1));
    Object localObject = new File(acbn.bmj);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = acbn.bmj + "troopGiftConfig.tmp";
    paramString1 = new aquz(paramString1, new File((String)localObject));
    paramString1.retryCount = 3;
    Bundle localBundle = new Bundle();
    localBundle.putString("filePath", (String)localObject);
    this.jdField_a_of_type_Apqk.a().a(paramString1, new smz(this, l, paramString2, paramInt), localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     smy
 * JD-Core Version:    0.7.0.1
 */