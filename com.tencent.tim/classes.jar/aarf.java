import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.qphone.base.util.QLog;

public class aarf
  extends SosoInterface.a
{
  public aarf(NewFlowCameraActivity paramNewFlowCameraActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      this.this$0.bo = paramSosoLbsInfo.a.cd;
      this.this$0.bp = paramSosoLbsInfo.a.ce;
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "onLocationUpdate() latitude=" + this.this$0.bo + " longitude=" + this.this$0.bp);
      }
      if (NewFlowCameraActivity.a(this.this$0) != null) {
        NewFlowCameraActivity.d(this.this$0);
      }
    }
    do
    {
      return;
      this.this$0.bo = 0.0D;
      this.this$0.bp = 0.0D;
    } while (!QLog.isColorLevel());
    QLog.d("PTV.NewFlowCameraActivity", 2, "onLocationUpdate() error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aarf
 * JD-Core Version:    0.7.0.1
 */