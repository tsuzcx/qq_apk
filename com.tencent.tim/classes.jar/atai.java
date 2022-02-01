import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.AudioDeviceInterface;
import com.tencent.sharp.jni.TraeAudioSession.a;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class atai
  implements TraeAudioSession.a
{
  public atai(AudioDeviceInterface paramAudioDeviceInterface) {}
  
  public void S(long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    try
    {
      AudioDeviceInterface.access$000(this.a).lock();
      AudioDeviceInterface.access$102(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "onVoicecallPreprocessRes signalAll");
      }
      AudioDeviceInterface.access$200(this.a).signalAll();
      AudioDeviceInterface.access$000(this.a).unlock();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void U(long paramLong, int paramInt) {}
  
  public void a(long paramLong, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3)
  {
    if (AudioDeviceInterface.access$300(this.a)) {
      AudioDeviceInterface.access$400(this.a, paramString1);
    }
  }
  
  public void g(long paramLong, int paramInt, String paramString) {}
  
  public void kP(String paramString) {}
  
  public void onAudioRouteSwitchEnd(String paramString, long paramLong) {}
  
  public void onAudioRouteSwitchStart(String paramString1, String paramString2) {}
  
  public void onConnectDeviceRes(int paramInt, String paramString, boolean paramBoolean) {}
  
  public void onDeviceChangabledUpdate(boolean paramBoolean) {}
  
  public void onGetConnectedDeviceRes(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      AudioDeviceInterface.access$400(this.a, paramString);
    }
  }
  
  public void onGetConnectingDeviceRes(int paramInt, String paramString) {}
  
  public void onGetDeviceListRes(int paramInt, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3) {}
  
  public void onGetStreamTypeRes(int paramInt1, int paramInt2) {}
  
  public void onIsDeviceChangabledRes(int paramInt, boolean paramBoolean) {}
  
  public void onVoicecallPreprocessRes(int paramInt)
  {
    try
    {
      AudioDeviceInterface.access$000(this.a).lock();
      AudioDeviceInterface.access$102(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "onVoicecallPreprocessRes signalAll");
      }
      AudioDeviceInterface.access$200(this.a).signalAll();
      AudioDeviceInterface.access$000(this.a).unlock();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atai
 * JD-Core Version:    0.7.0.1
 */