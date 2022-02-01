import java.util.Set;

class apeb
  extends apew.a
{
  apeb(apdz paramapdz) {}
  
  protected void p(Set<Long> paramSet)
  {
    this.this$0.dTP = 1;
    if ((paramSet != null) && (paramSet.contains(Long.valueOf(apdz.c(this.this$0))))) {
      this.this$0.dTP = 2;
    }
    apef.b.i("TroopFileTransferMgr", apef.b.USR, "onW2MPausedDownload mW2MPausedUploadState:" + this.this$0.dTO + " mW2MPausedDownloadState:" + this.this$0.dTP);
    if (this.this$0.dTO > 0)
    {
      if ((this.this$0.dTP == 2) || (this.this$0.dTO == 2)) {
        apsd.e(apdz.b(this.this$0), apdz.d(this.this$0), 107);
      }
      this.this$0.dTO = 0;
      this.this$0.dTP = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apeb
 * JD-Core Version:    0.7.0.1
 */