import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.biz.troopgift.AIOGiftPanelContainer.2;
import com.tencent.biz.troopgift.AIOGiftPanelContainer.2.1.1.1;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class wmo
  extends batl
{
  wmo(wmn paramwmn, long paramLong, String paramString, int paramInt) {}
  
  public void onDone(batm parambatm)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftPanel.time", 2, "onDone, time=" + (l - this.jdField_a_of_type_Long) + ", total=" + (l - this.jdField_a_of_type_Wmn.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Long));
    }
    if (parambatm.jdField_a_of_type_Int == 0) {
      localObject = parambatm.a().getString("filePath");
    }
    while (!QLog.isColorLevel()) {
      try
      {
        Object localObject;
        parambatm = new File((String)localObject);
        String str = bace.b(parambatm);
        if (QLog.isColorLevel()) {
          QLog.d("AIOGiftPanelContainer", 2, "onDone() content =  " + str + ", filePath = " + (String)localObject);
        }
        if (!TextUtils.isEmpty(str))
        {
          localObject = new wnc(new JSONObject(str), this.jdField_a_of_type_JavaLangString);
          ((wnc)localObject).a(this.jdField_a_of_type_Wmn.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Wmn.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Int);
          this.jdField_a_of_type_Wmn.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_Wnc = ((wnc)localObject);
          this.jdField_a_of_type_Wmn.jdField_a_of_type_Azjq.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Wmn.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Int);
          this.jdField_a_of_type_Wmn.jdField_a_of_type_Azjq.a(false);
          if (!this.jdField_a_of_type_Wmn.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {
            this.jdField_a_of_type_Wmn.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_AndroidOsHandler.post(new AIOGiftPanelContainer.2.1.1.1(this));
          }
          parambatm.deleteOnExit();
        }
        wmm.a(this.jdField_a_of_type_Wmn.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0, true);
        this.jdField_a_of_type_Wmn.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.a(0);
        return;
      }
      catch (IOException parambatm)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("AIOGiftPanelContainer", 2, QLog.getStackTraceString(parambatm));
        return;
      }
      catch (JSONException parambatm)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("AIOGiftPanelContainer", 2, QLog.getStackTraceString(parambatm));
        return;
      }
    }
    QLog.d("AIOGiftPanelContainer", 2, "onError() time =  " + (System.currentTimeMillis() - this.jdField_a_of_type_Wmn.jdField_a_of_type_Long) + ", errorCode = " + parambatm.jdField_a_of_type_Int);
  }
  
  public boolean onStart(batm parambatm)
  {
    return super.onStart(parambatm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wmo
 * JD-Core Version:    0.7.0.1
 */