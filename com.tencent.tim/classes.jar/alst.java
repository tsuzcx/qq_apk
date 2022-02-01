import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment;
import com.tencent.qphone.base.util.QLog;

public class alst
  extends achq
{
  public alst(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment) {}
  
  public void ax(long paramLong, int paramInt)
  {
    if (ReceiptMessageDetailFragment.b(this.this$0) == paramLong)
    {
      if (paramInt != 0) {
        break label78;
      }
      QLog.d("ReceiptMessageDetailFragment", 4, "send read report in c2c succ");
      ReceiptMessageDetailFragment.a(this.this$0, 0, 0, false);
      ReceiptMessageDetailFragment.a(this.this$0).removeObserver(this);
      if (this.this$0.isAdded())
      {
        ReceiptMessageDetailFragment.a(this.this$0).sendEmptyMessage(4);
        ReceiptMessageDetailFragment.a(this.this$0, 1, true);
      }
    }
    label78:
    do
    {
      return;
      QLog.d("ReceiptMessageDetailFragment", 4, "send read report in c2c fail with reply codes: " + paramInt);
      ReceiptMessageDetailFragment.a(this.this$0).removeObserver(this);
    } while (!this.this$0.isAdded());
    ReceiptMessageDetailFragment.a(this.this$0).sendEmptyMessage(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alst
 * JD-Core Version:    0.7.0.1
 */