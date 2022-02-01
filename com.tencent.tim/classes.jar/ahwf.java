import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.haoliyou.JefsClass.CancelableRunnable;
import com.tencent.mobileqq.haoliyou.JefsClass.b;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ahwf
  implements JefsClass.b
{
  public ahwf(JefsClass paramJefsClass, Context paramContext, Intent paramIntent, String paramString, int paramInt) {}
  
  public void a(String paramString1, String paramString2, String paramString3, List<ResolveInfo> paramList, JefsClass.CancelableRunnable paramCancelableRunnable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TeleScreen|JefsClass", 2, "checkAndDo() ]");
    }
    JefsClass.a(this.this$0, this.val$context, this.val$intent, this.val$url, paramString1, paramString2, paramString3, paramList, paramCancelableRunnable, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahwf
 * JD-Core Version:    0.7.0.1
 */