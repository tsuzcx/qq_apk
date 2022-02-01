import android.os.Bundle;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.PlayActionConfig;
import com.tencent.mobileqq.apollo.sdk.CmShowSpriteDrawerInfoBridge.1.1;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class absg
  implements EIPCResultCallback
{
  absg(absf paramabsf, long paramLong, CmShowRenderView.PlayActionConfig paramPlayActionConfig) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    try
    {
      if ((paramEIPCResult.code != 0) || (paramEIPCResult.data == null))
      {
        QLog.e("CmShow_SpriteDrawerInfoBridge", 1, "playAction onCallback result.code:" + paramEIPCResult.code);
        ApolloUtil.Da("播放动作失败");
        return;
      }
      paramEIPCResult.data.setClassLoader(SpriteTaskParam.class.getClassLoader());
      paramEIPCResult = (SpriteTaskParam)paramEIPCResult.data.getParcelable("SpriteTaskParam");
      QLog.i("CmShow_SpriteDrawerInfoBridge", 1, "use:" + (System.currentTimeMillis() - this.NX) + "playAction CmShow_ spriteTaskParam:" + paramEIPCResult);
      if (paramEIPCResult != null)
      {
        paramEIPCResult.a = this.this$0;
        paramEIPCResult.av = this.a.av;
        this.this$0.a(paramEIPCResult);
        ThreadManager.executeOnSubThread(new CmShowSpriteDrawerInfoBridge.1.1(this, paramEIPCResult));
        return;
      }
    }
    catch (Exception paramEIPCResult)
    {
      QLog.i("CmShow_SpriteDrawerInfoBridge", 1, "playAction onCallback e:", paramEIPCResult);
      return;
    }
    QLog.i("CmShow_SpriteDrawerInfoBridge", 1, "playAction onCallback spriteTaskParam==null ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     absg
 * JD-Core Version:    0.7.0.1
 */