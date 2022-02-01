import com.tencent.mobileqq.activity.CloudFileActivity;
import com.tencent.mobileqq.activity.CloudFileActivity.16.1;
import com.tencent.mobileqq.activity.CloudFileActivity.16.2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.teamwork.PadInfo;
import java.util.List;
import mqq.os.MqqHandler;

public class urg
  extends aulm
{
  public urg(CloudFileActivity paramCloudFileActivity) {}
  
  public void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, int paramInt3, int paramInt4, List<PadInfo> paramList)
  {
    super.a(paramBoolean1, paramInt1, paramInt2, paramBoolean2, paramBoolean3, paramInt3, paramInt4, paramList);
    if ((paramBoolean1) && (!this.this$0.Pp()) && (paramInt1 == 4))
    {
      if (QLog.isColorLevel()) {
        QLog.i("CloudFileFrame<QFileCloud>", 1, "onGetPadList");
      }
      this.this$0.b.postDelayed(new CloudFileActivity.16.1(this), 1000L);
    }
  }
  
  public void c(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    super.c(paramBoolean, paramInt, paramString1, paramString2);
    if (!this.this$0.Pp())
    {
      if (QLog.isColorLevel()) {
        QLog.i("CloudFileFrame<QFileCloud>", 1, "onPushMessageCreateTeamWorkDoc.domainId[" + paramInt + "] padId[" + paramString1 + "] padUrl[" + paramString1 + "]");
      }
      this.this$0.b.postDelayed(new CloudFileActivity.16.2(this), 3000L);
    }
  }
  
  public void wF(boolean paramBoolean)
  {
    super.wF(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("CloudFileFrame<QFileCloud>", 1, "onRefreshTeamWorkThumb");
    }
    if (this.this$0.a != null) {
      this.this$0.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     urg
 * JD-Core Version:    0.7.0.1
 */