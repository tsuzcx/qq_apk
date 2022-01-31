import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.pb.troop.bindgame.GCBindGroup.GCBindGroupSsoServerRsp;
import com.tencent.qphone.base.util.QLog;

public class tvo
  extends ProtoUtils.TroopProtocolObserver
{
  public tvo(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null)) {}
    try
    {
      paramBundle = new GCBindGroup.GCBindGroupSsoServerRsp();
      paramBundle.mergeFrom(paramArrayOfByte);
      this.a.a(paramBundle);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.e("Q.troopinfo", 1, "parse game bind status failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tvo
 * JD-Core Version:    0.7.0.1
 */