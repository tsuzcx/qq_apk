import android.os.Bundle;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.c;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public final class abrw
  implements EIPCResultCallback
{
  public abrw(String paramString1, String paramString2, CmShowRenderView.c paramc) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    CmShowRenderView.access$002(true);
    paramEIPCResult = paramEIPCResult.data;
    int i = paramEIPCResult.getInt("selfUinStatus");
    int j = paramEIPCResult.getInt("friendUinStatus");
    abru.dl(this.val$selfUin, i);
    abru.dl(this.SO, j);
    if (this.a != null) {
      this.a.fy(true);
    }
    QLog.i("CmShow_CmShowRenderView", 1, "initCmShowData selfUinStatus:" + i + " friendUinStatus:" + j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abrw
 * JD-Core Version:    0.7.0.1
 */