import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper.3.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.observer.BusinessObserver;

public class aagp
  implements BusinessObserver
{
  aagp(aago paramaago, long paramLong) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    ThreadManager.postImmediately(new VoiceRedPacketHelper.3.1.1(this, paramBoolean, paramBundle, paramInt), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aagp
 * JD-Core Version:    0.7.0.1
 */