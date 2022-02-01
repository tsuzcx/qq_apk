import android.os.Bundle;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.redpacket.AVRedPacketManager.GameStateInfo;
import com.tencent.av.redpacket.AVRedPacketManager.b;
import com.tencent.qphone.base.util.QLog;

public class irr
  implements AVRedPacketManager.b
{
  public irr(AVRedPacketManager paramAVRedPacketManager) {}
  
  public void u(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "onLoadFinish, isSucc=" + paramBoolean + ",type=" + paramInt);
    }
    if (!AVRedPacketManager.a(this.this$0, true)) {}
    do
    {
      do
      {
        return;
      } while (paramInt != 1);
      if ((this.this$0.a.gameMode == 1) && (this.this$0.a.gameState == 1))
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("key", this.this$0.a.key);
        localBundle.putInt("gameState", 1);
        localBundle.putInt("fromWho", 1);
        localBundle.putInt("musicId", this.this$0.asN);
        localBundle.putInt("enterType", this.this$0.a.enterType);
        this.this$0.b.apW();
        this.this$0.g(1, localBundle);
        this.this$0.a(false, 1011, AVRedPacketManager.mQ, null);
        this.this$0.a(false, 1021, AVRedPacketManager.mS, null);
        return;
      }
    } while ((this.this$0.a.gameMode != 2) || (this.this$0.a.gameState != 1));
    long l = Math.abs(System.currentTimeMillis() - this.this$0.a.mRedPacketComeStartTime);
    paramBoolean = jik.k(AVRedPacketManager.a(this.this$0));
    if (l >= AVRedPacketManager.mV)
    {
      if (paramBoolean)
      {
        this.this$0.aqa();
        return;
      }
      this.this$0.startGame();
      return;
    }
    if (paramBoolean)
    {
      this.this$0.a(false, 1028, AVRedPacketManager.mV - l, null);
      return;
    }
    this.this$0.a(false, 1026, AVRedPacketManager.mV - l, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     irr
 * JD-Core Version:    0.7.0.1
 */