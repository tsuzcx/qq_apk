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

public class xbo
  extends bbwt
{
  xbo(xbn paramxbn, long paramLong, String paramString, int paramInt) {}
  
  public void onDone(bbwu parambbwu)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftPanel.time", 2, "onDone, time=" + (l - this.jdField_a_of_type_Long) + ", total=" + (l - this.jdField_a_of_type_Xbn.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Long));
    }
    if (parambbwu.jdField_a_of_type_Int == 0) {
      localObject = parambbwu.a().getString("filePath");
    }
    while (!QLog.isColorLevel()) {
      try
      {
        Object localObject;
        parambbwu = new File((String)localObject);
        String str = bbdx.b(parambbwu);
        if (QLog.isColorLevel()) {
          QLog.d("AIOGiftPanelContainer", 2, "onDone() content =  " + str + ", filePath = " + (String)localObject);
        }
        if (!TextUtils.isEmpty(str))
        {
          localObject = new xcc(new JSONObject(str), this.jdField_a_of_type_JavaLangString);
          ((xcc)localObject).a(this.jdField_a_of_type_Xbn.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Xbn.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Int);
          this.jdField_a_of_type_Xbn.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_Xcc = ((xcc)localObject);
          this.jdField_a_of_type_Xbn.jdField_a_of_type_Balh.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Xbn.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Int);
          this.jdField_a_of_type_Xbn.jdField_a_of_type_Balh.a(false);
          if (!this.jdField_a_of_type_Xbn.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {
            this.jdField_a_of_type_Xbn.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_AndroidOsHandler.post(new AIOGiftPanelContainer.2.1.1.1(this));
          }
          parambbwu.deleteOnExit();
        }
        xbm.a(this.jdField_a_of_type_Xbn.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0, true);
        this.jdField_a_of_type_Xbn.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.a(0);
        return;
      }
      catch (IOException parambbwu)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("AIOGiftPanelContainer", 2, QLog.getStackTraceString(parambbwu));
        return;
      }
      catch (JSONException parambbwu)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("AIOGiftPanelContainer", 2, QLog.getStackTraceString(parambbwu));
        return;
      }
    }
    QLog.d("AIOGiftPanelContainer", 2, "onError() time =  " + (System.currentTimeMillis() - this.jdField_a_of_type_Xbn.jdField_a_of_type_Long) + ", errorCode = " + parambbwu.jdField_a_of_type_Int);
  }
  
  public boolean onStart(bbwu parambbwu)
  {
    return super.onStart(parambbwu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xbo
 * JD-Core Version:    0.7.0.1
 */