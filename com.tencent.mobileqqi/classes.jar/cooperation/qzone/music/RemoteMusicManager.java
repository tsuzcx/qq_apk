package cooperation.qzone.music;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.IActionListener;
import cooperation.qzone.remote.RemoteServiceProxy;
import cooperation.qzone.remote.SendMsg;
import icx;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class RemoteMusicManager
  implements QzoneMusicConst
{
  static final String TAG = "RemoteMusicManager";
  private static Object lock = new Object();
  private static RemoteMusicManager mInstance;
  IActionListener mActionListener = new icx(this);
  private Handler mMainHandler = new Handler(Looper.getMainLooper());
  private ArrayList mMusicEventListeners = new ArrayList();
  private AtomicInteger mReqestId = new AtomicInteger(1);
  private RemoteServiceProxy serviceProxy = new RemoteServiceProxy("com.qzone.music.service.QzoneMusicService", QzoneMusicPluginProxyService.class);
  
  public RemoteMusicManager()
  {
    this.serviceProxy.setActionListener(this.mActionListener);
  }
  
  public static RemoteMusicManager getInstance()
  {
    if (mInstance == null) {}
    synchronized (lock)
    {
      if (mInstance == null) {
        mInstance = new RemoteMusicManager();
      }
      return mInstance;
    }
  }
  
  public void addOnMusicEventListener(RemoteMusicManager.MusicEventListener paramMusicEventListener)
  {
    this.mMusicEventListeners.add(paramMusicEventListener);
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RemoteMusicManager", 2, "----destroy----");
    }
    if (this.serviceProxy != null) {
      this.serviceProxy.stopBaseService();
    }
  }
  
  public void getPlayMode()
  {
    sendData("cmd.getPlayMode", null, true);
  }
  
  public void getPlayingSong()
  {
    sendData("cmd.getPlayingSong", null, true);
  }
  
  public void notifyPlayListChange()
  {
    sendData("cmd.notifyPlayListChange", null, false);
  }
  
  public void pausePlay()
  {
    sendData("cmd.pausePlay", null, false);
  }
  
  public void playMusicList(long paramLong, int paramInt1, int paramInt2, int paramInt3, ArrayList paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("param.uin", paramLong);
    localBundle.putInt("param.origin", paramInt1);
    localBundle.putInt("param.index", paramInt2);
    localBundle.putInt("param.playModeRandom", paramInt3);
    localBundle.putSerializable("param.songList", paramArrayList);
    sendData("cmd.playMusicList", localBundle, false);
  }
  
  public void removeOnMusicEventListener(RemoteMusicManager.MusicEventListener paramMusicEventListener)
  {
    this.mMusicEventListeners.remove(paramMusicEventListener);
  }
  
  public void resumePlay()
  {
    sendData("cmd.resumePlay", null, false);
  }
  
  protected int sendData(String paramString, Bundle paramBundle, long paramLong, boolean paramBoolean)
  {
    SendMsg localSendMsg = new SendMsg(paramString);
    paramString = paramBundle;
    if (paramBundle == null) {
      paramString = new Bundle();
    }
    if ((paramString != null) && (paramString.size() > 0)) {
      localSendMsg.extraData.putAll(paramString);
    }
    int i = this.mReqestId.incrementAndGet();
    localSendMsg.setRequestId(i);
    if (paramLong > 0L) {
      localSendMsg.setTimeout(paramLong);
    }
    localSendMsg.setNeedCallback(paramBoolean);
    if (paramBoolean) {
      localSendMsg.actionListener = this.mActionListener;
    }
    try
    {
      this.serviceProxy.sendMsg(localSendMsg);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      throw new RuntimeException("sendMsg is fail", paramString);
    }
  }
  
  public int sendData(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    try
    {
      int i = sendData(paramString, paramBundle, 0L, paramBoolean);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public void setPlayMode(long paramLong, int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("param.uin", paramLong);
    localBundle.putInt("param.playModeRandom", paramInt1);
    localBundle.putInt("param.playModeAuto", paramInt2);
    sendData("cmd.setPlayMode", localBundle, false);
  }
  
  public void stopPlay()
  {
    sendData("cmd.stopPlay", null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qzone.music.RemoteMusicManager
 * JD-Core Version:    0.7.0.1
 */