import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class abpb
  implements INetInfoHandler
{
  private long by;
  private int mGameId;
  
  public abpb(int paramInt)
  {
    this.mGameId = paramInt;
  }
  
  private void HJ(int paramInt)
  {
    if (System.currentTimeMillis() - this.by < 500L) {}
    for (;;)
    {
      return;
      this.by = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameNetInfoHandler", 2, "[notifyEngineNetChange], type:" + paramInt);
      }
      try
      {
        ApolloCmdChannel localApolloCmdChannel = abmt.a();
        if (localApolloCmdChannel != null)
        {
          Object localObject = abmt.a(this.mGameId);
          if (localObject != null)
          {
            localObject = ((abos)localObject).b();
            if (localObject != null)
            {
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("type", paramInt);
              localApolloCmdChannel.callbackFromRequest(((ApolloSurfaceView)localObject).getLuaState(), 0, "sc.network_change.local", localJSONObject.toString());
              return;
            }
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("cmgame_process.CmGameNetInfoHandler", 1, "errInfo->" + localException.getMessage());
      }
    }
  }
  
  public void onNetMobile2None()
  {
    HJ(4);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    HJ(3);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    HJ(1);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    HJ(2);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    HJ(6);
  }
  
  public void onNetWifi2None()
  {
    HJ(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abpb
 * JD-Core Version:    0.7.0.1
 */