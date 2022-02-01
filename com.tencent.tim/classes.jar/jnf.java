import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.biz.PoiMapActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class jnf
  implements View.OnClickListener
{
  public jnf(PoiMapActivity paramPoiMapActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.n.cancel();
    String str2 = this.this$0.I.getText().toString();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.this$0.report("share_locate", "click_sch_cancel", str1, "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jnf
 * JD-Core Version:    0.7.0.1
 */