import android.annotation.TargetApi;
import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class wjx
{
  wjx.a a;
  WeakReference<AudioPlayerBase> aa;
  Application mApp;
  
  public wjx(Application paramApplication)
  {
    this.mApp = paramApplication;
  }
  
  private AudioPlayerBase a()
  {
    if (this.aa == null) {
      return null;
    }
    return (AudioPlayerBase)this.aa.get();
  }
  
  @TargetApi(14)
  public int Q(String paramString, int paramInt)
  {
    int i = 0;
    if (AudioPlayerBase.bNK != -1) {
      i = 1;
    }
    BluetoothAdapter localBluetoothAdapter;
    AudioPlayerBase localAudioPlayerBase;
    do
    {
      return i;
      localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
      localAudioPlayerBase = a();
    } while (localAudioPlayerBase == null);
    if (localBluetoothAdapter == null)
    {
      AudioPlayerBase.bNK = 0;
      return 1;
    }
    if ((!localBluetoothAdapter.isEnabled()) || (localBluetoothAdapter.getProfileConnectionState(1) != 2) || (localBluetoothAdapter.getProfileConnectionState(2) == 2))
    {
      AudioPlayerBase.bNK = 0;
      return 1;
    }
    paramString = new wjy(this, localAudioPlayerBase, paramString, paramInt, localBluetoothAdapter);
    localBluetoothAdapter.getProfileProxy(BaseApplication.getContext(), paramString, 1);
    return 2;
  }
  
  public int R(String paramString, int paramInt)
  {
    if (this.mApp == null) {}
    do
    {
      return 0;
      paramString = new wjx.a(paramString, paramInt, null);
      this.a = paramString;
      this.mApp.registerReceiver(paramString, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
      paramString = a();
    } while ((paramString == null) || (paramString.getAudioManager() == null));
    paramString.getAudioManager().startBluetoothSco();
    if (QLog.isColorLevel()) {
      QLog.d("AudioPlayer_SCOHelper", 2, "tryStartBluetoothSCO return: Check_SCO_Result_Check_Access_Need_Return");
    }
    return 2;
  }
  
  public void b(AudioPlayerBase paramAudioPlayerBase)
  {
    if ((paramAudioPlayerBase == null) && (QLog.isColorLevel())) {
      QLog.d("AudioPlayer_SCOHelper", 2, "setAudioPlayer audioPlayer is null");
    }
    this.aa = new WeakReference(paramAudioPlayerBase);
  }
  
  public void bYB()
  {
    if (this.a != null) {
      if (QLog.isColorLevel()) {
        QLog.d("AudioPlayer_SCOHelper", 2, "unregister sco receiver:  " + SystemClock.uptimeMillis());
      }
    }
    try
    {
      this.mApp.unregisterReceiver(this.a);
      label51:
      this.a = null;
      return;
    }
    catch (Exception localException)
    {
      break label51;
    }
  }
  
  class a
    extends BroadcastReceiver
  {
    long HL = 0L;
    boolean bcS = false;
    long lj = 0L;
    int offset;
    String sourcePath;
    
    private a(String paramString, int paramInt)
    {
      this.sourcePath = paramString;
      this.offset = paramInt;
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      long l = SystemClock.uptimeMillis();
      int i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
      if (QLog.isColorLevel()) {
        QLog.d("AudioPlayer_SCOHelper", 2, "onReceive ACTION_SCO_AUDIO_STATE_UPDATED = " + i + " " + this.sourcePath + ", time=" + l);
      }
      paramContext = wjx.a(wjx.this);
      if (1 == i) {
        if (this.lj == 0L)
        {
          this.lj = l;
          if (paramContext != null)
          {
            paramIntent = paramContext.getAudioManager();
            if (paramIntent != null)
            {
              paramIntent.setBluetoothScoOn(true);
              AudioPlayerBase.bdh = true;
            }
            paramContext.bYH();
            if (!paramContext.isPlaying())
            {
              if (QLog.isColorLevel()) {
                QLog.d("AudioPlayer_SCOHelper", 2, "onReceive SCO_AUDIO_STATE_CONNECTED need replay time=" + l);
              }
              paramContext.seekPlay(this.sourcePath, this.offset);
            }
          }
        }
      }
      do
      {
        do
        {
          do
          {
            return;
            if (2 == i)
            {
              this.bcS = true;
              return;
            }
          } while (i != 0);
          if (this.HL == 0L)
          {
            this.HL = l;
            return;
          }
          if ((this.bcS) && (paramContext != null)) {
            paramContext.bYJ();
          }
          if (paramContext != null) {
            paramContext.bYI();
          }
          if (((this.lj == 0L) || (l - this.lj > 2000L)) && (l - this.HL > 1000L)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("AudioPlayer_SCOHelper", 2, "sco disconnected quickly.");
          }
          AudioPlayerBase.bdg = true;
        } while (paramContext == null);
        paramContext.bYF();
        if (paramContext.isPlaying())
        {
          paramContext.seekPlay(this.sourcePath, this.offset);
          return;
        }
        paramContext.Cf(0);
        return;
      } while ((paramContext == null) || (!paramContext.isPlaying()));
      paramContext.Cf(paramContext.a.getCurrentPosition());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wjx
 * JD-Core Version:    0.7.0.1
 */