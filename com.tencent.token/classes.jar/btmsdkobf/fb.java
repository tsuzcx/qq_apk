package btmsdkobf;

import android.util.SparseArray;
import com.tmsdk.base.conch.ConchService.ConchPushInfo;
import com.tmsdk.base.conch.ConchService.IConchPushListener;
import com.tmsdk.base.conch.ConchService.RevokeTaskInfo;

class fb
  implements Runnable
{
  fb(bk parambk, ConchService.ConchPushInfo paramConchPushInfo) {}
  
  public void run()
  {
    ConchService.ConchPushInfo localConchPushInfo = this.a;
    int j = localConchPushInfo.mConch.cmdId;
    Object localObject = bk.b(this.b);
    int i = j;
    if (localConchPushInfo != null) {
      if (localConchPushInfo.mRevokeInfo != null) {
        break label60;
      }
    }
    for (i = j;; i = localConchPushInfo.mRevokeInfo.mRevokeCmdId)
    {
      localObject = (ConchService.IConchPushListener)((SparseArray)localObject).get(i);
      if (localObject != null) {}
      label60:
      try
      {
        ((ConchService.IConchPushListener)localObject).onRecvPush(localConchPushInfo);
        return;
      }
      catch (Throwable localThrowable) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.fb
 * JD-Core Version:    0.7.0.1
 */