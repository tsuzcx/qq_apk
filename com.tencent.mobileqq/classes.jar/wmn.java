import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troopgift.AIOGiftPanelContainer.2;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class wmn
  extends azjp
{
  public wmn(AIOGiftPanelContainer.2 param2, azjq paramazjq, long paramLong, azfo paramazfo) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGiftPanelContainer", 2, "onError() time =  " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + ", errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    long l = System.currentTimeMillis();
    int i = this.jdField_a_of_type_Azjq.a(this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Int == 5) {
      wnc.a(paramString2);
    }
    do
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOGiftPanelContainer", 2, "onGetExtraData() , configURL = " + paramString1 + ", serverVer=" + paramInt + ", localVer=" + i + ", exIds=" + paramString2);
        }
        QLog.d("TroopGiftPanel.time", 1, "onGetExtraData, time=" + (l - this.jdField_a_of_type_Long) + ", total=" + (l - this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Long));
        this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_Wnc = wnc.a(this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
        if ((paramInt > i) || (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_Wnc == null)) {
          break;
        }
        wmm.a(this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0, true);
        this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.a(0);
        return;
        if ((this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Int == 6) || (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Int == 4)) {
          wnc.a(paramString2, this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
        }
      }
    } while (TextUtils.isEmpty(paramString1));
    Object localObject = new File(ajed.bm);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = ajed.bm + "troopGiftConfig.tmp";
    paramString1 = new batm(paramString1, new File((String)localObject));
    paramString1.b = 3;
    Bundle localBundle = new Bundle();
    localBundle.putString("filePath", (String)localObject);
    this.jdField_a_of_type_Azfo.a().a(paramString1, new wmo(this, l, paramString2, paramInt), localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wmn
 * JD-Core Version:    0.7.0.1
 */