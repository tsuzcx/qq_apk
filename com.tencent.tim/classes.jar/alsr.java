import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class alsr
  implements View.OnClickListener
{
  public alsr(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment, MessageForPic paramMessageForPic) {}
  
  public void onClick(View paramView)
  {
    if (!this.this$0.isAdded()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.a(this.this$0.getActivity(), ReceiptMessageDetailFragment.a(this.this$0), this.i, ReceiptMessageDetailFragment.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alsr
 * JD-Core Version:    0.7.0.1
 */