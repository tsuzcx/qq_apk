import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.a;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class anrq
  extends QIPCModule
{
  public anrq(StructMsgForGeneralShare.a parama, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("receipt_set_read".equals(paramString)) {
      StructMsgForGeneralShare.a.a(this.this$0, paramBundle);
    }
    for (;;)
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.d(StructMsgForGeneralShare.access$000(), 2, "unknown action");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anrq
 * JD-Core Version:    0.7.0.1
 */