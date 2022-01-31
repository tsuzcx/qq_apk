import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantSettingActivity;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantSettingAdapter;

public class bkt
  extends Handler
{
  public bkt(PubAccountAssistantSettingActivity paramPubAccountAssistantSettingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    PubAccountAssistantSettingActivity.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bkt
 * JD-Core Version:    0.7.0.1
 */