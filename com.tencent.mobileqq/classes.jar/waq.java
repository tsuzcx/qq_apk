import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousStatusListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import mqq.os.MqqHandler;

public class waq
  implements AnonymousChatHelper.AnonymousStatusListener
{
  public waq(TroopChatPie paramTroopChatPie) {}
  
  public void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals(this.a.a.a))) {
      TroopChatPie.m(this.a).post(new war(this, paramString2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     waq
 * JD-Core Version:    0.7.0.1
 */