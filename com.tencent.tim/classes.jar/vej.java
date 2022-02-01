import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.startup.step.CheckPermission.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class vej
  implements CheckPermission.a
{
  vej(vei paramvei) {}
  
  public void bK()
  {
    QLog.i("JumpAction", 1, "system share.doShare show self dialog grant");
    HashMap localHashMap = new HashMap();
    anpc.a(BaseApplication.getContext()).collectPerformance("", "noSDPermissionShareSelftGrant", true, 0L, 0L, localHashMap, "");
  }
  
  public void reject()
  {
    QLog.i("JumpAction", 1, "system share.doShare show self dialog denied");
    HashMap localHashMap = new HashMap();
    anpc.a(BaseApplication.getContext()).collectPerformance("", "noSDPermissionShareSelftDeny", true, 0L, 0L, localHashMap, "");
    this.a.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     vej
 * JD-Core Version:    0.7.0.1
 */