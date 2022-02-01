import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.qphone.base.util.QLog;

class ydj
  extends SosoInterface.a
{
  ydj(ycd paramycd, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    double d3 = 0.0D;
    String str;
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null) && (paramSosoLbsInfo.a.address != null))
    {
      str = paramSosoLbsInfo.a.address;
      if ((paramSosoLbsInfo == null) || (paramSosoLbsInfo.a == null)) {
        break label211;
      }
    }
    label211:
    for (double d1 = paramSosoLbsInfo.a.cd;; d1 = 0.0D)
    {
      double d2 = d3;
      if (paramSosoLbsInfo != null)
      {
        d2 = d3;
        if (paramSosoLbsInfo.a != null) {
          d2 = paramSosoLbsInfo.a.ce;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "onLocationUpdate() latitude=" + d1 + " longitude=" + d2 + ", address=" + str);
      }
      if (this.this$0.a == null) {
        this.this$0.a = ((PublicAccountHandler)this.this$0.app.getBusinessHandler(11));
      }
      if (this.this$0.a != null) {
        this.this$0.a.a(this.this$0.sessionInfo.aTl, d1, d2, str);
      }
      return;
      str = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ydj
 * JD-Core Version:    0.7.0.1
 */