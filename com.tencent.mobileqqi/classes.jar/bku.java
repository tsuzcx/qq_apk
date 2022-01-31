import android.os.Handler;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantSettingActivity;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantSettingAdapter;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class bku
  extends PublicAccountObserver
{
  public bku(PubAccountAssistantSettingActivity paramPubAccountAssistantSettingActivity) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Object localObject = (PublicAccountDataManager)this.a.b.getManager(51);
      PubAccountAssistantSettingActivity.a(this.a, ((PublicAccountDataManager)localObject).a());
      localObject = PubAccountAssistantSettingActivity.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((PublicAccountInfo)((Iterator)localObject).next()).mShowMsgFlag == -1) {
          ((Iterator)localObject).remove();
        }
      }
      if ((PubAccountAssistantSettingActivity.a(this.a) != null) && (PubAccountAssistantSettingActivity.a(this.a).size() > 0)) {
        Collections.sort(PubAccountAssistantSettingActivity.a(this.a), PubAccountAssistantSettingActivity.a(this.a));
      }
      PubAccountAssistantSettingActivity.a(this.a).a(PubAccountAssistantSettingActivity.a(this.a));
      PubAccountAssistantSettingActivity.a(this.a).sendEmptyMessage(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bku
 * JD-Core Version:    0.7.0.1
 */