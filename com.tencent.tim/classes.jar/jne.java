import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.biz.PoiMapActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class jne
  implements View.OnClickListener
{
  public jne(PoiMapActivity paramPoiMapActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.I.setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jne
 * JD-Core Version:    0.7.0.1
 */