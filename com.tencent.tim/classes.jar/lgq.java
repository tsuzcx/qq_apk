import android.os.Bundle;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.oidb_0xb7e.RspBody;

class lgq
  extends jnm.a
{
  lgq(lgp paramlgp, boolean paramBoolean) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      try
      {
        paramBundle = new oidb_0xb7e.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        if (!paramBundle.rpt_top_item.has()) {
          break label129;
        }
        List localList = paramBundle.rpt_top_item.get();
        if ((localList == null) || (localList.size() <= 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d(lgp.TAG, 2, "requestDiandianTopConfig rpt_top_item is empty");
          }
          lcc.a().i(true, null);
          lgp.a(this.this$0, paramArrayOfByte, 0L);
          return;
        }
        lgp.a(this.this$0, paramArrayOfByte, System.currentTimeMillis());
        if (!this.ajY) {
          return;
        }
        lgp.a(this.this$0, paramBundle);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.e(lgp.TAG, 2, "requestDiandianTopConfig parser failed");
      return;
      label129:
      if (QLog.isColorLevel()) {
        QLog.d(lgp.TAG, 2, "requestDiandianTopConfig rpt_top_item is empty");
      }
      lgp.a(this.this$0, paramArrayOfByte, 0L);
      lcc.a().i(true, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(lgp.TAG, 2, "requestDiandianTopConfig failed errorCode = " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lgq
 * JD-Core Version:    0.7.0.1
 */