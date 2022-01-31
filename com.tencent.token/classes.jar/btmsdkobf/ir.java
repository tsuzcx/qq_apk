package btmsdkobf;

import com.qq.taf.jce.JceStruct;
import com.tmsdk.base.ISharkCallBackOut;
import com.tmsdk.base.utils.FileOP.CheckResult;
import java.util.ArrayList;
import java.util.Iterator;
import tmsdk.Protocol.MConfigUpdate.SCConfInfo;
import tmsdk.Protocol.MConfigUpdate.ServerConfInfo;

final class ir
  implements ISharkCallBackOut
{
  ir(FileOP.CheckResult paramCheckResult, Object paramObject) {}
  
  public void onFinish(int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct arg5)
  {
    if (??? == null) {
      this.a.mStatusCode = -101;
    }
    synchronized (this.b)
    {
      for (;;)
      {
        this.b.notify();
        return;
        ??? = (SCConfInfo)???;
        if ((??? == null) || (???.vecConfInfo == null))
        {
          this.a.mStatusCode = -101;
        }
        else if (???.vecConfInfo.size() <= 0)
        {
          this.a.mStatusCode = -209;
        }
        else
        {
          if (paramInt3 != 0) {
            break;
          }
          this.a.mStatusCode = -208;
          ??? = ???.vecConfInfo.iterator();
          if (???.hasNext())
          {
            ??? = (ServerConfInfo)???.next();
            this.a.mUrl = ???.url;
          }
        }
      }
      this.a.mStatusCode = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ir
 * JD-Core Version:    0.7.0.1
 */