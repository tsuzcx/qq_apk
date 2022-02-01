import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper.4.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.observer.BusinessObserver;

public class aagr
  implements BusinessObserver
{
  aagr(aagq paramaagq, long paramLong) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    ThreadManager.postImmediately(new VoiceRedPacketHelper.4.1.1(this, paramBoolean, paramBundle, paramInt), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aagr
 * JD-Core Version:    0.7.0.1
 */