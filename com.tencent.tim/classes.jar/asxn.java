import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.VoIPListener;
import mqq.app.AppRuntime;
import mqq.manager.PushManager;

@ProxyService(proxy=VoIPProxy.class)
public class asxn
  extends VoIPProxy
{
  private aseu mQavMultiObserver = new asxp(this);
  private VoIPProxy.VoIPListener mVoIPListener;
  
  private void qavDeInitSDK()
  {
    QLog.i("VoIPProxyImpl", 1, "qavDeInitSDK");
    ((PushManager)BaseApplicationImpl.getApplication().getRuntime().getManager(5)).unregistProxyMessagePush(AppSetting.getAppId(), BaseApplicationImpl.getApplication().getQQProcessName());
    asej localasej = asej.a();
    localasej.b(this.mQavMultiObserver);
    localasej.emQ();
  }
  
  public int enableLocalAudio(boolean paramBoolean)
  {
    aser localaser = asej.a().a();
    if (localaser != null)
    {
      localaser.Uw(paramBoolean);
      return 0;
    }
    return -1;
  }
  
  public int enableRemoteAudio(boolean paramBoolean)
  {
    aser localaser = asej.a().a();
    if (localaser != null)
    {
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localaser.Ux(paramBoolean);
        return 0;
      }
    }
    return -1;
  }
  
  public void exitRoom()
  {
    aser localaser = asej.a().a();
    if (localaser != null) {
      localaser.exitRoom();
    }
  }
  
  public void init(long paramLong, VoIPProxy.VoIPListener paramVoIPListener)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    ((PushManager)((AppRuntime)localObject).getManager(5)).registProxyMessagePush(AppSetting.getAppId(), BaseApplicationImpl.getApplication().getQQProcessName(), "", new String[] { "MultiVideo.c2sack", "MultiVideo.s2c" });
    asev.a(new asex());
    asem localasem = asem.a();
    localasem.s((AppRuntime)localObject);
    localasem.a(new asxo(this));
    localObject = asej.a();
    ((asej)localObject).a(BaseApplicationImpl.getApplication().getApplicationContext(), paramLong, localasem);
    this.mVoIPListener = paramVoIPListener;
    ((asej)localObject).a(this.mQavMultiObserver);
  }
  
  public int joinRoom(long paramLong, int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    aser localaser = asej.a().a();
    if (localaser != null)
    {
      asei.a locala = new asei.a();
      locala.aqx = 11;
      locala.aww = 14;
      locala.elI = 1;
      locala.elJ = paramInt;
      locala.mUin = paramLong;
      locala.mOpenId = paramString;
      locala.bDB = 1;
      locala.bc = paramArrayOfByte;
      return localaser.a(locala);
    }
    return -4;
  }
  
  public void setAudioRoute(int paramInt)
  {
    aser localaser = asej.a().a();
    if (localaser != null) {
      localaser.setAudioRoute(paramInt);
    }
  }
  
  public void unInit()
  {
    qavDeInitSDK();
    this.mVoIPListener = null;
  }
  
  public void updateRoomInfo()
  {
    aser localaser = asej.a().a();
    if (localaser != null) {
      localaser.updateRoomInfo();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asxn
 * JD-Core Version:    0.7.0.1
 */