import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.RspBody;
import com.tencent.qphone.base.util.QLog;

public class zun
  extends ProtoUtils.TroopProtocolObserver
{
  public zun(TroopHandler paramTroopHandler) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      paramBundle = new oidb_0x496.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        TroopHandler.a(this.a, paramBundle);
        TroopHandler.b(this.a, paramBundle);
        TroopHandler.c(this.a, paramBundle);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        while (!QLog.isColorLevel()) {}
        QLog.i("TroopHandler", 2, "getTroopConfig, e=" + paramArrayOfByte.toString());
        return;
      }
    }
    QLog.i("TroopHandler", 1, "getTroopConfig, errorCode=" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zun
 * JD-Core Version:    0.7.0.1
 */