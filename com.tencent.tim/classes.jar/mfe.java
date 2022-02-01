import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.f;
import com.tencent.biz.pubaccount.readinjoy.service.redpacket.RIJAidlClientRedPacketModule.requestShouldDoTaskTiming.1.onShouldDoTaskTimingCallback.1;
import com.tencent.mobileqq.app.ThreadManager;
import kotlin.Metadata;
import mqq.os.MqqHandler;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/service/redpacket/RIJAidlClientRedPacketModule$requestShouldDoTaskTiming$1", "Lcom/tencent/biz/pubaccount/readinjoy/service/redpacket/IShouldDoTaskTimingCallback$Stub;", "onShouldDoTaskTimingCallback", "", "shouldDoTaskTiming", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class mfe
  extends mfb.a
{
  mfe(RIJRedPacketManager.f paramf) {}
  
  public void lJ(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post((Runnable)new RIJAidlClientRedPacketModule.requestShouldDoTaskTiming.1.onShouldDoTaskTimingCallback.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mfe
 * JD-Core Version:    0.7.0.1
 */