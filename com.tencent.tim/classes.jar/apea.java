import java.util.Set;

class apea
  extends apfx.a
{
  apea(apdz paramapdz) {}
  
  protected void o(Set<Long> paramSet)
  {
    this.this$0.dTO = 1;
    if ((paramSet != null) && (paramSet.contains(Long.valueOf(apdz.a(this.this$0))))) {
      this.this$0.dTO = 2;
    }
    apef.b.i("TroopFileTransferMgr", apef.b.USR, "onW2MPausedUpload mW2MPausedUploadState:" + this.this$0.dTO + " mW2MPausedDownloadState:" + this.this$0.dTP);
    if (this.this$0.dTP > 0)
    {
      if ((this.this$0.dTP == 2) || (this.this$0.dTO == 2)) {
        apsd.e(apdz.a(this.this$0), apdz.b(this.this$0), 107);
      }
      this.this$0.dTO = 0;
      this.this$0.dTP = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apea
 * JD-Core Version:    0.7.0.1
 */