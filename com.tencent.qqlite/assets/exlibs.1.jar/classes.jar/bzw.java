import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousStatusListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;

public class bzw
  implements AnonymousChatHelper.AnonymousStatusListener
{
  public bzw(TroopChatPie paramTroopChatPie) {}
  
  public void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals(TroopChatPie.N(this.a).a))) {
      TroopChatPie.h(this.a).post(new bzx(this, paramString2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bzw
 * JD-Core Version:    0.7.0.1
 */