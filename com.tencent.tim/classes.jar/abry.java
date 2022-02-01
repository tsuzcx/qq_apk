import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.b;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public final class abry
  implements EIPCResultCallback
{
  public abry(CmShowRenderView.b paramb) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool = true;
    QLog.i("CmShow_CmShowRenderView", 1, "changeApolloStatus ipc code:" + paramEIPCResult.code);
    ApolloUtil.Da("changeApolloStatus code:" + paramEIPCResult.code);
    CmShowRenderView.b localb;
    if (this.a != null)
    {
      localb = this.a;
      if (paramEIPCResult.code != 0) {
        break label82;
      }
    }
    for (;;)
    {
      localb.Ee(bool);
      return;
      label82:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abry
 * JD-Core Version:    0.7.0.1
 */