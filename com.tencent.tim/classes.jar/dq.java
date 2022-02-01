import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class dq
  implements View.OnClickListener
{
  dq(dm paramdm, PrinterItemMsgRecord paramPrinterItemMsgRecord, Context paramContext) {}
  
  @SuppressLint({"NewApi"})
  public void onClick(View paramView)
  {
    if (2131365692 == paramView.getId())
    {
      dr localdr = new dr(this);
      ds localds = new ds(this);
      aqha.a(this.val$context, 230, this.val$context.getString(2131695407), this.val$context.getString(2131695391), 2131721058, 2131695421, localdr, localds).show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dq
 * JD-Core Version:    0.7.0.1
 */