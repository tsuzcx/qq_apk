import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.1;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil.c;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class abod
  implements ApolloGameUtil.c
{
  public abod(CmGameSubProcessHandler.1 param1) {}
  
  public void HB(int paramInt)
  {
    int i = 0;
    ApolloCmdChannel localApolloCmdChannel = abmt.a();
    if (localApolloCmdChannel != null) {}
    for (;;)
    {
      try
      {
        if (!QLog.isColorLevel()) {
          break label106;
        }
        QLog.d("cmgame_process.CmGameSubProcessHandler", 2, new Object[] { "createGameShortCut errorCode:", Integer.valueOf(paramInt) });
      }
      catch (Exception localException)
      {
        JSONObject localJSONObject;
        QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "createGameShortCut Exception:" + localException);
        return;
      }
      localJSONObject = new JSONObject();
      localJSONObject.put("ret", i);
      localApolloCmdChannel.callbackFromRequest(this.a.Od, i, "cs.create_xy_shortcut.local", localJSONObject.toString());
      return;
      label106:
      if (paramInt == 1) {
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abod
 * JD-Core Version:    0.7.0.1
 */