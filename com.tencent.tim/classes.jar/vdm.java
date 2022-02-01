import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.H5MagicPlayerActivity;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vdm
  implements View.OnClickListener
{
  public vdm(H5MagicPlayerActivity paramH5MagicPlayerActivity) {}
  
  public void onClick(View paramView)
  {
    H5MagicPlayerActivity.a(this.this$0);
    if ((this.this$0.selfUin.equals(this.this$0.senderUin)) && (this.this$0.b != null)) {
      anot.a(null, "CliOper", "", "", "MbFasong", "MbGuanbi", 0, 0, this.this$0.b.epId, "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      anot.a(null, "CliOper", "", "", "MbJieshou", "MbZhudongGuanbi", 0, 0, this.this$0.b.epId, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vdm
 * JD-Core Version:    0.7.0.1
 */