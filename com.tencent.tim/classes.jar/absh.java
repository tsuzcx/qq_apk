import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.sdk.CmShowSpriteDrawerInfoBridge.4.1;
import com.tencent.mobileqq.apollo.sdk.IPCSpriteContext;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class absh
  implements EIPCResultCallback
{
  absh(absf paramabsf, abse paramabse) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    Object localObject = (IPCSpriteContext)paramEIPCResult.data.getParcelable("IPCSpriteContext");
    paramEIPCResult = paramEIPCResult.data.getString("js_content");
    QLog.i("CmShow_SpriteDrawerInfoBridge", 1, "checkfDressChanged CmShow_ spriteJs:" + paramEIPCResult);
    if (TextUtils.isEmpty(paramEIPCResult)) {
      abwh.a(this.c.zM(), 300, 301, new Object[] { "spriteJs is empty" });
    }
    do
    {
      return;
      localObject = (absb)absf.a(this.this$0).a(100);
    } while (localObject == null);
    ThreadManagerV2.excute(new CmShowSpriteDrawerInfoBridge.4.1(this, paramEIPCResult, (absb)localObject), 16, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     absh
 * JD-Core Version:    0.7.0.1
 */