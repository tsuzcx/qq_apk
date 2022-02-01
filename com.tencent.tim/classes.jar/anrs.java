import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class anrs
  implements View.OnClickListener
{
  public anrs(StructMsgForHypertext paramStructMsgForHypertext) {}
  
  public void onClick(View paramView)
  {
    new anra(null, paramView, this.a.message).i("web", this.a.mSourceUrl, null, null);
    anot.a(null, "CliOper", "", "", "0X800567C", "0X800567C", 0, 0, this.a.mMsgServiceID + "", "", "", "");
    anot.a(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anrs
 * JD-Core Version:    0.7.0.1
 */