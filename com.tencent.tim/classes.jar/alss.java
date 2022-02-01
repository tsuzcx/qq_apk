import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment;
import com.tencent.qphone.base.util.QLog;

public class alss
  implements URLDrawableDownListener
{
  public alss(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "URLDrawableDownListener onLoadCancelled: ");
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "URLDrawableDownListener onLoadFailed: ");
    }
    ReceiptMessageDetailFragment.a(this.this$0).setVisibility(8);
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "URLDrawableDownListener onLoadInterrupted: ");
    }
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "URLDrawableDownListener onLoadProgressed: " + paramURLDrawable + " / " + paramInt);
    }
    ReceiptMessageDetailFragment.a(this.this$0).setLevel(paramInt);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    ReceiptMessageDetailFragment.a(this.this$0).setVisibility(8);
    ReceiptMessageDetailFragment.a(this.this$0, paramURLDrawable);
    ReceiptMessageDetailFragment.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alss
 * JD-Core Version:    0.7.0.1
 */