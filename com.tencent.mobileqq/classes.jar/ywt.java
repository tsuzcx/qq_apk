import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BabyQIPCModule;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.concurrent.ConcurrentHashMap;

public class ywt
  extends CardObserver
{
  public ywt(BabyQIPCModule paramBabyQIPCModule) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BabyQIPCModule", 2, "babyqWeb onCardDownload ");
    }
    if ((paramObject instanceof Card))
    {
      paramObject = (Card)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("BabyQIPCModule", 2, "babyqWeb onCardDownload set card info uin = " + paramObject.uin);
      }
      if (AppConstants.au.equals(paramObject.uin))
      {
        BabyQIPCModule.a(this.a, paramObject);
        BabyQIPCModule.a(this.a).jdField_a_of_type_ComTencentMobileqqDataCard = BabyQIPCModule.a(this.a);
        BabyQIPCModule.a(this.a).jdField_a_of_type_ArrayOfJavaLangString[0] = BabyQIPCModule.a(this.a).strNick;
        BabyQIPCModule.a(this.a).jdField_a_of_type_ArrayOfJavaLangString[4] = BabyQIPCModule.a(this.a).strReMark;
      }
    }
    if (BabyQIPCModule.a(this.a).get("getZanVoteCount") != null)
    {
      paramObject = (Bundle)BabyQIPCModule.a(this.a).get("getZanVoteCount");
      int i = paramObject.getInt("key_process_callback_id");
      paramObject = paramObject.getString("key_js_callback_id");
      Bundle localBundle = new Bundle();
      localBundle.putString("key_method_action", "getZanVoteCount");
      localBundle.putLong("key_get_zan_vote_count", BabyQIPCModule.a(this.a).lVoteCount);
      localBundle.putString("web_js_call_back_id", paramObject);
      this.a.callbackResult(i, EIPCResult.createSuccessResult(localBundle));
      BabyQIPCModule.a(this.a).remove("getZanVoteCount");
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    BabyQIPCModule.a(this.a).babyQSwitch = paramBoolean2;
    if (QLog.isColorLevel()) {
      QLog.d("BabyQIPCModule", 2, "babyqWeb onGetBabyQSwitch babyQSwitch = " + paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ywt
 * JD-Core Version:    0.7.0.1
 */