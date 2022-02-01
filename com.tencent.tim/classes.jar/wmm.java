import android.app.Activity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

final class wmm
  implements avor.a
{
  wmm(int paramInt1, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, int paramInt2, String paramString, Activity paramActivity) {}
  
  public void ansyBack(int paramInt, String... paramVarArgs)
  {
    if ((paramVarArgs.length <= 0) || (paramVarArgs[0] == null))
    {
      QLog.i("PlusPanelUtils", 2, "error get pskey...");
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("pskey_type", "27");
    localHashMap.put("pskey", paramVarArgs[0]);
    localHashMap.put("recv_group_type", this.bPp + "");
    localHashMap.put("recv_group_id", this.a.aTl);
    localHashMap.put("send_nickname", aqgv.l(this.val$app, this.a.aTl, this.val$app.getCurrentUin()));
    localHashMap.put("send_uin", this.val$app.getCurrentUin());
    localHashMap.put("group_count", this.bPq + "");
    paramVarArgs = avor.a(this.wT, localHashMap, true);
    aagc.M(this.u, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wmm
 * JD-Core Version:    0.7.0.1
 */