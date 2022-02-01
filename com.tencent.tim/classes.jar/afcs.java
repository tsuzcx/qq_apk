import android.os.Bundle;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.dating.MsgBoxListActivity.6.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class afcs
  implements ajww.a
{
  public afcs(MsgBoxListActivity paramMsgBoxListActivity) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MsgBoxListActivity", 2, "follow onReceive errorCode = [" + paramInt + "]");
    }
    this.this$0.mUIHandler.post(new MsgBoxListActivity.6.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afcs
 * JD-Core Version:    0.7.0.1
 */