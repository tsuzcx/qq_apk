import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment;
import com.tencent.qphone.base.util.QLog;

public class alsu
  extends achq
{
  public alsu(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment) {}
  
  public void f(long paramLong1, int paramInt, long paramLong2)
  {
    if (ReceiptMessageDetailFragment.c(this.this$0) == paramLong1)
    {
      if (paramInt != 0) {
        break label109;
      }
      QLog.d("ReceiptMessageDetailFragment", 4, "get read status in c2c succs with readtime: " + paramLong2);
      if (paramLong2 > 0L) {
        ReceiptMessageDetailFragment.a(this.this$0, 1, 1, true);
      }
      if (this.this$0.isAdded())
      {
        ReceiptMessageDetailFragment localReceiptMessageDetailFragment = this.this$0;
        if (paramLong2 <= 0L) {
          break label104;
        }
        paramInt = 1;
        ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment, paramInt, true);
      }
      ReceiptMessageDetailFragment.a(this.this$0).removeObserver(this);
    }
    label104:
    label109:
    do
    {
      return;
      paramInt = 0;
      break;
      QLog.d("ReceiptMessageDetailFragment", 4, "get read status in c2c fail with reply code: " + paramInt);
      ReceiptMessageDetailFragment.a(this.this$0).removeObserver(this);
    } while (!this.this$0.isAdded());
    ReceiptMessageDetailFragment.a(this.this$0).sendEmptyMessage(20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alsu
 * JD-Core Version:    0.7.0.1
 */