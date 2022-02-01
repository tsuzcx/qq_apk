import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.tfs.AsyncTask;
import com.tencent.mobileqq.minigame.manager.EngineChannel;
import com.tencent.mobileqq.minigame.manager.EngineChannel.Receiver;
import com.tencent.mobileqq.minigame.manager.InstalledEngine;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ajcu
  extends AsyncTask
  implements EngineChannel.Receiver
{
  private InstalledEngine a;
  private int installEngineRequestCount;
  private EngineChannel mEngineChannel;
  private int mLibType = 3;
  private MiniAppInfo mMiniAppInfo;
  private ajct.a mMiniLibLoadListener;
  
  public ajcu(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(InstalledEngine paramInstalledEngine)
  {
    for (;;)
    {
      try
      {
        if (this.a == null)
        {
          QLog.i("MiniAppEngineLoadTask", 1, "[MiniEng]mEngine == null, loadEngineTask is reset?");
          return;
        }
        long l = System.currentTimeMillis();
        QLog.i("MiniAppEngineLoadTask", 1, "[MiniEng]initEngine");
        if (paramInstalledEngine != null) {
          ajcv.a().b(paramInstalledEngine);
        }
        if (!ajcv.a().loadAllMiniSo())
        {
          QLog.e("MiniAppEngineLoadTask", 1, "[MiniEng]initEngine fail");
          onTaskFailed();
          continue;
        }
        QLog.e("MiniAppEngineLoadTask", 1, "[MiniEng]loadSo cost time " + (System.currentTimeMillis() - l));
      }
      finally {}
      onTaskSucceed();
    }
  }
  
  private boolean a(InstalledEngine paramInstalledEngine, MiniAppInfo paramMiniAppInfo)
  {
    boolean bool = true;
    if (paramInstalledEngine == null) {
      bool = false;
    }
    while (paramMiniAppInfo != null) {
      return bool;
    }
    return true;
  }
  
  private void sendCommand(int paramInt, Bundle paramBundle)
  {
    paramBundle.putInt("baseLibType", this.mLibType);
    paramBundle.putInt("enginePid", Process.myPid());
    QLog.i("MiniAppEngineLoadTask", 1, "[MiniEng]installEngineRequestCount " + this.installEngineRequestCount);
    if (this.installEngineRequestCount >= 2)
    {
      QLog.i("MiniAppEngineLoadTask", 1, "[MiniEng]GET_INSTALLED_ENGINE_LIST requestCount reaches max 2");
      onTaskFailed(103, acfp.m(2131708383));
    }
    do
    {
      return;
      this.mEngineChannel.send(paramInt, paramBundle);
    } while (paramInt != 3);
    this.installEngineRequestCount += 1;
  }
  
  public void b(EngineChannel paramEngineChannel)
  {
    this.mEngineChannel = paramEngineChannel;
  }
  
  public void c(ajct.a parama)
  {
    this.mMiniLibLoadListener = parama;
  }
  
  public void executeAsync()
  {
    if (this.mEngineChannel == null)
    {
      onTaskFailed(1, acfp.m(2131708378));
      return;
    }
    EngineChannel localEngineChannel = new EngineChannel();
    localEngineChannel.setName("AppEngine(" + Process.myPid() + ")");
    localEngineChannel.setReceiver(this);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("engineChannel", localEngineChannel);
    sendCommand(1, localBundle);
  }
  
  public void onReceiveData(int paramInt, Bundle paramBundle)
  {
    QLog.i("MiniAppEngineLoadTask", 1, "[MiniEng] onReceiveData what=" + paramInt);
    if (paramBundle != null) {
      paramBundle.setClassLoader(getClass().getClassLoader());
    }
    if (paramInt == 51) {
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getParcelableArrayList("installedEngineList");
        if (paramBundle != null)
        {
          paramInt = paramBundle.size();
          QLog.i("MiniAppEngineLoadTask", 1, "[MiniEng] getInstalledEngineList success " + paramInt);
          if (paramInt > 0)
          {
            paramBundle = (InstalledEngine)paramBundle.get(0);
            if (a(paramBundle, this.mMiniAppInfo))
            {
              this.a = paramBundle;
              a(paramBundle);
            }
          }
        }
      }
    }
    do
    {
      do
      {
        return;
        onTaskFailed(101, acfp.m(2131708380));
        return;
        QLog.i("MiniAppEngineLoadTask", 1, "[MiniEng] no engine installed, send cmd WHAT_INSTALL_LATEST_ENGINE");
        sendCommand(3, new Bundle());
        return;
        QLog.i("MiniAppEngineLoadTask", 1, "[MiniEng] getInstalledEngineList miniAppEngineList is null");
        onTaskFailed(102, acfp.m(2131708376));
        return;
        QLog.i("MiniAppEngineLoadTask", 1, "[MiniEng] getInstalledEngineList data is null");
        onTaskFailed(102, acfp.m(2131708375));
        return;
        if (paramInt == 52)
        {
          QLog.i("MiniAppEngineLoadTask", 1, "[MiniEng]EVENT_INSTALL_LATEST_ENGINE_BEGIN");
          return;
        }
        if (paramInt != 53) {
          break;
        }
      } while (paramBundle == null);
      paramBundle = paramBundle.getString("engineInstallerMessage");
      QLog.i("MiniAppEngineLoadTask", 1, "[MiniEng]EVENT_INSTALL_LATEST_ENGINE_PROCESS " + paramBundle);
      return;
    } while (paramInt != 54);
    QLog.i("MiniAppEngineLoadTask", 1, "[MiniEng]EVENT_INSTALL_LATEST_ENGINE_FINISH");
    sendCommand(1, new Bundle());
  }
  
  public void reset()
  {
    try
    {
      QLog.i("MiniAppEngineLoadTask", 1, "[MiniEng]" + this + " reset ");
      this.installEngineRequestCount = 0;
      this.mMiniAppInfo = null;
      this.a = null;
      super.reset();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajcu
 * JD-Core Version:    0.7.0.1
 */