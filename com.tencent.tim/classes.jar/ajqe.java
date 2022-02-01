import android.os.Bundle;
import com.tencent.mobileqq.nearby.NearbyJsInterface;
import com.tencent.mobileqq.nearby.NearbyJsInterface.a;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.HashMap;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cmd0x8c1.oidb_0x8c1.RspBody;
import tencent.im.oidb.cmd0x8c1.oidb_0x8c1.SelfCardInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ajqe
  implements BusinessObserver
{
  public ajqe(NearbyJsInterface paramNearbyJsInterface, String paramString, boolean paramBoolean) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramInt = 1;
    int i = 0;
    Object localObject;
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null) {
        localObject = new oidb_sso.OIDBSSOPkg();
      }
    }
    for (;;)
    {
      try
      {
        paramBundle = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramBundle);
        if ((paramBundle.uint32_result.has()) && (paramBundle.uint32_result.get() == 0) && (paramBundle.bytes_bodybuffer.has()) && (paramBundle.bytes_bodybuffer.get() != null))
        {
          localObject = new oidb_0x8c1.RspBody();
          ((oidb_0x8c1.RspBody)localObject).mergeFrom(paramBundle.bytes_bodybuffer.get().toByteArray());
          paramBundle = (oidb_0x8c1.SelfCardInfo)((oidb_0x8c1.RspBody)localObject).msg_card_info.get();
          if (!paramBundle.int32_friend_flag.has()) {
            break label257;
          }
          if (paramBundle.int32_friend_flag.get() != 1) {
            continue;
          }
          break label264;
          this.this$0.mClient.a(paramBundle.bytes_xml_msg.get().toByteArray(), String.valueOf(paramBundle.uint64_uin.get()), 2, paramInt);
          paramBundle = new NearbyJsInterface.a(String.valueOf(paramBundle.uint64_uin.get()), paramBundle.int32_direction_flag.get());
          this.this$0.lT.put(String.valueOf(this.bNj), paramBundle);
          if (this.cpN) {
            NearbyJsInterface.a(this.this$0, paramBundle);
          }
        }
        return;
        paramInt = 0;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      paramInt = 1001;
      continue;
      label257:
      paramInt = 1001;
      continue;
      label264:
      if (paramInt != 0) {
        paramInt = i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajqe
 * JD-Core Version:    0.7.0.1
 */