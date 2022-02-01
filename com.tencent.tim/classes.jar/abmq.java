import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.List;

class abmq
  implements abto.c
{
  abmq(abmm paramabmm, int paramInt) {}
  
  public void e(boolean paramBoolean, String paramString, List<abto.a> paramList)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = -1)
    {
      paramString = EIPCResult.createResult(i, null);
      this.this$0.callbackResult(this.val$callbackId, paramString);
      QLog.i("cmgame_process.CmGameServerQIPCModule", 2, "onDownLoadFinish onDownLoadFinish sucess:" + paramBoolean);
      return;
    }
  }
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramBoolean) {}
    for (paramInt1 = 0;; paramInt1 = -1)
    {
      paramString = EIPCResult.createResult(paramInt1, null);
      this.this$0.callbackResult(this.val$callbackId, paramString);
      QLog.i("cmgame_process.CmGameServerQIPCModule", 2, "onDownLoadFinish onDownLoadFinish sucess:" + paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abmq
 * JD-Core Version:    0.7.0.1
 */