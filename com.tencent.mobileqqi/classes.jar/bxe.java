import com.tencent.litetransfersdk.LiteTransferWrapper;

public class bxe
  implements Runnable
{
  public bxe(LiteTransferWrapper paramLiteTransferWrapper) {}
  
  public void run()
  {
    if (LiteTransferWrapper.access$300(this.a) != 0L)
    {
      this.a.destryOperator(LiteTransferWrapper.access$300(this.a));
      LiteTransferWrapper.access$302(this.a, 0L);
    }
    LiteTransferWrapper.access$402(this.a, null);
    LiteTransferWrapper.access$602(this.a, null);
    this.a.releaseGlobalFuncCallback();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bxe
 * JD-Core Version:    0.7.0.1
 */