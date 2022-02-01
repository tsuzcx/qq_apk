import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardD55Manager.1.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ahhi
  extends jnm.d
{
  ahhi(ahhh paramahhh, String paramString, long paramLong) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.d("ForwardD55Manager", 1, "fetchAppInfoByD55 onResult errorCode: " + paramInt);
    ahlw.report("KEY_STAGE_1_D55");
    ThreadManager.getUIHandler().post(new ForwardD55Manager.1.1(this, paramArrayOfByte, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahhi
 * JD-Core Version:    0.7.0.1
 */