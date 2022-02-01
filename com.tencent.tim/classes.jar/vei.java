import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.QQPermissionCallback;

public class vei
  implements QQPermissionCallback
{
  public vei(JumpActivity paramJumpActivity, boolean paramBoolean) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("JumpAction", 1, "system share.doShare denied sd grant");
    aqha.a(this.this$0, new vej(this));
    paramArrayOfString = new HashMap();
    anpc.a(BaseApplication.getContext()).collectPerformance("", "noSDPermissionShareDeny", true, 0L, 0L, paramArrayOfString, "");
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("JumpAction", 1, "system share.doShare user grant");
    JumpActivity.a(this.this$0, this.aXJ);
    paramArrayOfString = new HashMap();
    anpc.a(BaseApplication.getContext()).collectPerformance("", "noSDPermissionShareGrant", true, 0L, 0L, paramArrayOfString, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     vei
 * JD-Core Version:    0.7.0.1
 */