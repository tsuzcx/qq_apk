import android.content.Context;
import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class abye
  implements abhh.a
{
  public abye(Context paramContext, AppInterface paramAppInterface, CmGameStartChecker.StartCheckParam paramStartCheckParam, long paramLong) {}
  
  public void cBX()
  {
    ApolloGameUtil.b(this.val$finalContext, (QQAppInterface)this.b, this.i);
    long l = SystemClock.uptimeMillis() - this.qE;
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_gameId", String.valueOf(this.i.gameId));
    localHashMap.put("param_src", String.valueOf(this.i.src));
    anpc.a(this.val$finalContext).collectPerformance(this.b.getCurrentAccountUin(), "cmgame_data_init_duration", true, l, 0L, localHashMap, "", false);
    QLog.d("CmGameStat", 1, new Object[] { "cmgame_data_init_duration=", Long.valueOf(l) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abye
 * JD-Core Version:    0.7.0.1
 */