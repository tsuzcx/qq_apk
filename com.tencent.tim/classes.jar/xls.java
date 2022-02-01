import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xls
  implements View.OnClickListener
{
  xls(xlr paramxlr) {}
  
  public void onClick(View paramView)
  {
    String str = (String)paramView.getTag();
    if (!TextUtils.isEmpty(str))
    {
      aagc.N(this.this$0.mContext, str);
      if ((this.this$0.skinId > 0) && ((this.this$0.messageType == 2) || (this.this$0.messageType == 3))) {
        anot.a(this.this$0.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "wrap.aiotail.click", 0, 0, "" + this.this$0.skinId, "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xls
 * JD-Core Version:    0.7.0.1
 */