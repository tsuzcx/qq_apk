import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.PoiMapActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class jng
  implements View.OnClickListener
{
  public jng(PoiMapActivity paramPoiMapActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.n.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jng
 * JD-Core Version:    0.7.0.1
 */