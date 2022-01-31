import com.tencent.litetransfersdk.LiteTransferListenerCallback;
import com.tencent.litetransfersdk.LiteTransferOperatorCallback;
import com.tencent.litetransfersdk.LiteTransferWrapper;

public class ur
  implements Runnable
{
  public ur(LiteTransferWrapper paramLiteTransferWrapper) {}
  
  public void run()
  {
    if (LiteTransferWrapper.access$300(this.a) == 0L)
    {
      this.a.initGlobalFuncCallback();
      LiteTransferWrapper.access$402(this.a, new LiteTransferOperatorCallback(LiteTransferWrapper.access$500(this.a)));
      LiteTransferWrapper.access$602(this.a, new LiteTransferListenerCallback(LiteTransferWrapper.access$500(this.a)));
      LiteTransferWrapper.access$302(this.a, this.a.createOperator(LiteTransferWrapper.access$400(this.a), LiteTransferWrapper.access$600(this.a)));
      this.a.checkPathExist();
      this.a.SetProxyToJni();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ur
 * JD-Core Version:    0.7.0.1
 */