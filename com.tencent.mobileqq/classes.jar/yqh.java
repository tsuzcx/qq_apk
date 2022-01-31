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

public class yqh
  extends bdvu
{
  yqh(yqg paramyqg, long paramLong, String paramString, int paramInt) {}
  
  public void onDone(bdvv parambdvv)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftPanel.time", 2, "onDone, time=" + (l - this.jdField_a_of_type_Long) + ", total=" + (l - this.jdField_a_of_type_Yqg.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Long));
    }
    if (parambdvv.jdField_a_of_type_Int == 0) {
      localObject = parambdvv.a().getString("filePath");
    }
    while (!QLog.isColorLevel()) {
      try
      {
        Object localObject;
        parambdvv = new File((String)localObject);
        String str = bdcs.b(parambdvv);
        if (QLog.isColorLevel()) {
          QLog.d("AIOGiftPanelContainer", 2, "onDone() content =  " + str + ", filePath = " + (String)localObject);
        }
        if (!TextUtils.isEmpty(str))
        {
          localObject = new yqv(new JSONObject(str), this.jdField_a_of_type_JavaLangString);
          ((yqv)localObject).a(this.jdField_a_of_type_Yqg.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Yqg.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Int);
          this.jdField_a_of_type_Yqg.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_Yqv = ((yqv)localObject);
          this.jdField_a_of_type_Yqg.jdField_a_of_type_Bcju.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Yqg.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Int);
          this.jdField_a_of_type_Yqg.jdField_a_of_type_Bcju.a(false);
          if (!this.jdField_a_of_type_Yqg.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {
            this.jdField_a_of_type_Yqg.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_AndroidOsHandler.post(new AIOGiftPanelContainer.2.1.1.1(this));
          }
          parambdvv.deleteOnExit();
        }
        yqf.a(this.jdField_a_of_type_Yqg.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0, true);
        this.jdField_a_of_type_Yqg.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.a(0);
        return;
      }
      catch (IOException parambdvv)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("AIOGiftPanelContainer", 2, QLog.getStackTraceString(parambdvv));
        return;
      }
      catch (JSONException parambdvv)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("AIOGiftPanelContainer", 2, QLog.getStackTraceString(parambdvv));
        return;
      }
    }
    QLog.d("AIOGiftPanelContainer", 2, "onError() time =  " + (System.currentTimeMillis() - this.jdField_a_of_type_Yqg.jdField_a_of_type_Long) + ", errorCode = " + parambdvv.jdField_a_of_type_Int);
  }
  
  public boolean onStart(bdvv parambdvv)
  {
    return super.onStart(parambdvv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yqh
 * JD-Core Version:    0.7.0.1
 */