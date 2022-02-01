import android.os.Bundle;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.TroopAbilityPreVerificationFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.oidb_0xb60.GetPrivilegeRsp;
import tencent.im.oidb.oidb_0xb60.RspBody;

public class arta
  extends jnm.d
{
  public arta(TroopAbilityPreVerificationFragment paramTroopAbilityPreVerificationFragment) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i("TroopAbility.PreVerification", 1, "onResult type=" + this.this$0.bDo + ", appid=" + this.this$0.mAppId + ", code=" + paramInt);
    if ((paramInt != 0) || (paramArrayOfByte == null)) {
      if ((QLog.isColorLevel()) && (paramArrayOfByte == null)) {
        break label441;
      }
    }
    for (;;)
    {
      try
      {
        paramBundle = ((oidb_0xb60.RspBody)new oidb_0xb60.RspBody().mergeFrom(paramArrayOfByte)).wording.get();
        localObject = new StringBuilder().append("req error code=").append(paramInt);
        if (paramArrayOfByte == null)
        {
          paramArrayOfByte = ", data=null";
          QLog.i("TroopAbility.PreVerification", 1, paramArrayOfByte);
          this.this$0.WY(acfp.m(2131715492));
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        paramBundle = "";
        continue;
        paramArrayOfByte = ", msg=" + paramBundle;
        continue;
      }
      paramBundle = new oidb_0xb60.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if ((!paramBundle.get_privilege_rsp.api_groups.has()) || (!paramBundle.get_privilege_rsp.next_req_duration.has()))
        {
          QLog.i("TroopAbility.PreVerification", 1, "rsp invalid");
          this.this$0.WY(acfp.m(2131715484));
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.i("TroopAbility.PreVerification", 1, "parse rsp error", paramArrayOfByte);
        this.this$0.WY(acfp.m(2131715489));
        return;
      }
      TroopAbilityPreVerificationFragment.a(paramBundle);
      QLog.d("TroopAbility.PreVerification", 1, "receive api_groups:" + paramBundle.get_privilege_rsp.api_groups.get() + ", api_names:" + paramBundle.get_privilege_rsp.api_names.get());
      paramArrayOfByte = new HashSet();
      Object localObject = paramBundle.get_privilege_rsp.api_groups.get().iterator();
      while (((Iterator)localObject).hasNext()) {
        paramArrayOfByte.add((Integer)((Iterator)localObject).next());
      }
      boolean bool = this.this$0.a(paramArrayOfByte);
      QLog.i("TroopAbility.PreVerification", 1, "check permission result:" + bool);
      this.this$0.Uf(bool);
      TroopAbilityPreVerificationFragment.access$202(paramBundle.get_privilege_rsp.next_req_duration.get());
      TroopAbilityPreVerificationFragment.access$302(NetConnInfoCenter.getServerTime());
      return;
      label441:
      paramBundle = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arta
 * JD-Core Version:    0.7.0.1
 */