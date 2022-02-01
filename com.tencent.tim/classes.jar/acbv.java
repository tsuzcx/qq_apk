import android.os.Bundle;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.concurrent.ConcurrentHashMap;

class acbv
  extends accn
{
  acbv(acbu paramacbu) {}
  
  public void onCardDownload(boolean paramBoolean, Object paramObject)
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
      if (acbn.blz.equals(paramObject.uin))
      {
        acbu.a(this.b, paramObject);
        acbu.a(this.b).d = acbu.a(this.b);
        acbu.a(this.b).gh[0] = acbu.a(this.b).strNick;
        acbu.a(this.b).gh[4] = acbu.a(this.b).strReMark;
      }
    }
    if (acbu.a(this.b).get("getZanVoteCount") != null)
    {
      paramObject = (Bundle)acbu.a(this.b).get("getZanVoteCount");
      int i = paramObject.getInt("key_process_callback_id");
      paramObject = paramObject.getString("key_js_callback_id");
      Bundle localBundle = new Bundle();
      localBundle.putString("key_method_action", "getZanVoteCount");
      localBundle.putLong("key_get_zan_vote_count", acbu.a(this.b).lVoteCount);
      localBundle.putString("web_js_call_back_id", paramObject);
      this.b.callbackResult(i, EIPCResult.createSuccessResult(localBundle));
      acbu.a(this.b).remove("getZanVoteCount");
    }
  }
  
  public void onGetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    acbu.a(this.b).babyQSwitch = paramBoolean2;
    if (QLog.isColorLevel()) {
      QLog.d("BabyQIPCModule", 2, "babyqWeb onGetBabyQSwitch babyQSwitch = " + paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acbv
 * JD-Core Version:    0.7.0.1
 */