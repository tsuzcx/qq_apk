import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.qphone.base.util.QLog;

public class vwv
  extends PublicAccountObserver
{
  public vwv(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  public void a(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramInt == 0) {
      this.a.c(this.a.a.getIntent());
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.c(this.a.a.getIntent());
    }
  }
  
  public void b(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramInt == 0) {
      this.a.c(this.a.a.getIntent());
    }
  }
  
  public void t_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "onDownPublicAccount");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vwv
 * JD-Core Version:    0.7.0.1
 */