import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class jbp
  implements View.OnClickListener
{
  public jbp(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  public void onClick(View paramView)
  {
    aqji.c.edZ();
    anot.a(null, "P_CliOper", "Grp_qiqiqun", "", "show_middle", "Clk_call", 0, 0, this.this$0.Rv, "", "", "");
    this.this$0.mA(10);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jbp
 * JD-Core Version:    0.7.0.1
 */