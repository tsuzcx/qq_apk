import android.os.RemoteException;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.f;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "shouldDoTaskTiming", "", "onShouldDoTaskTimingCallback"}, k=3, mv={1, 1, 16})
final class mfi
  implements RIJRedPacketManager.f
{
  mfi(mfb parammfb) {}
  
  public final void lJ(boolean paramBoolean)
  {
    try
    {
      this.a.lJ(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
      QLog.e("RIJAidlServerRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mfi
 * JD-Core Version:    0.7.0.1
 */