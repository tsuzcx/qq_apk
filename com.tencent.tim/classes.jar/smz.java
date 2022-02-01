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

public class smz
  extends aquy
{
  smz(smy paramsmy, long paramLong, String paramString, int paramInt) {}
  
  public void onDone(aquz paramaquz)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftPanel.time", 2, "onDone, time=" + (l - this.CX) + ", total=" + (l - this.a.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.CW));
    }
    if (paramaquz.errCode == 0) {
      localObject = paramaquz.getParams().getString("filePath");
    }
    while (!QLog.isColorLevel()) {
      try
      {
        Object localObject;
        paramaquz = new File((String)localObject);
        String str = aqhq.readFileToString(paramaquz);
        if (QLog.isColorLevel()) {
          QLog.d("AIOGiftPanelContainer", 2, "onDone() content =  " + str + ", filePath = " + (String)localObject);
        }
        if (!TextUtils.isEmpty(str))
        {
          localObject = new snf(new JSONObject(str), this.aEQ);
          ((snf)localObject).X(this.a.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.mBaseChatPie.mContext, this.a.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.bxP);
          this.a.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.a = ((snf)localObject);
          this.a.jdField_a_of_type_Apsz.jX(this.Un, this.a.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.bxP);
          this.a.jdField_a_of_type_Apsz.Sg(false);
          if (!this.a.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.mBaseChatPie.mActivity.isFinishing()) {
            this.a.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.mUIHandler.post(new AIOGiftPanelContainer.2.1.1.1(this));
          }
          paramaquz.deleteOnExit();
        }
        smx.a(this.a.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0, true);
        this.a.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.yD(0);
        return;
      }
      catch (IOException paramaquz)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("AIOGiftPanelContainer", 2, QLog.getStackTraceString(paramaquz));
        return;
      }
      catch (JSONException paramaquz)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("AIOGiftPanelContainer", 2, QLog.getStackTraceString(paramaquz));
        return;
      }
    }
    QLog.d("AIOGiftPanelContainer", 2, "onError() time =  " + (System.currentTimeMillis() - this.a.AG) + ", errorCode = " + paramaquz.errCode);
  }
  
  public boolean onStart(aquz paramaquz)
  {
    return super.onStart(paramaquz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     smz
 * JD-Core Version:    0.7.0.1
 */