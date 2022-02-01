import android.os.Handler;
import android.os.Message;
import com.tencent.av.service.LBSInfo;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;

public class aefy
  extends acgs
{
  public aefy(LocationSelectActivity paramLocationSelectActivity) {}
  
  protected void b(boolean paramBoolean, LBSInfo paramLBSInfo)
  {
    if (paramLBSInfo != null) {}
    for (paramLBSInfo = paramLBSInfo.w(); Math.abs(System.currentTimeMillis() - this.this$0.VV) > 1200L; paramLBSInfo = null)
    {
      this.this$0.c(paramBoolean, paramLBSInfo);
      return;
    }
    Message localMessage = this.this$0.mHandler.obtainMessage(1000);
    localMessage.obj = new Object[] { Boolean.valueOf(paramBoolean), paramLBSInfo };
    this.this$0.mHandler.sendMessageDelayed(localMessage, 1200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aefy
 * JD-Core Version:    0.7.0.1
 */