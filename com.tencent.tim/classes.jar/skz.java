import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.biz.troop.TroopMemberApiService.a;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import mqq.observer.BusinessObserver;
import tencent.im.group.nearbybanner.nearbybanner.Banners;
import tencent.im.group.nearbybanner.nearbybanner.RspBody;

public class skz
  implements BusinessObserver
{
  public skz(TroopMemberApiService.a parama, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.val$data.remove("data");
    if (!paramBoolean)
    {
      this.a.d.j(16, this.val$data);
      return;
    }
    paramBundle = paramBundle.getByteArray("data");
    nearbybanner.RspBody localRspBody = new nearbybanner.RspBody();
    try
    {
      localRspBody.mergeFrom(paramBundle);
      if ((localRspBody.uint32_result.get() != 0) && (!localRspBody.msg_banners.has()))
      {
        this.a.d.j(16, this.val$data);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      this.a.d.j(16, this.val$data);
      return;
      paramBundle = (nearbybanner.Banners)localRspBody.msg_banners.get();
      if (!paramBundle.rpt_banner_info.has())
      {
        this.a.d.j(16, this.val$data);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      this.a.d.j(16, this.val$data);
      return;
    }
    this.val$data.putByteArray("data", paramBundle.toByteArray());
    this.a.d.j(16, this.val$data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     skz
 * JD-Core Version:    0.7.0.1
 */