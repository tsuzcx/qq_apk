import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class abss
  implements EIPCResultCallback
{
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code == 0) {
      ApolloUtil.Da("测试版本tips:预下载动作成功");
    }
    for (;;)
    {
      QLog.i("CmShow_RenderViewController", 1, "CmShow_ preLoadRes result.code:" + paramEIPCResult.code);
      return;
      ApolloUtil.Da("测试版本tips:预下载动作失败 ret:" + paramEIPCResult.code);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abss
 * JD-Core Version:    0.7.0.1
 */