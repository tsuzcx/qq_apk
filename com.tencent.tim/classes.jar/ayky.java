import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ayky
  implements View.OnClickListener
{
  ayky(aykw paramaykw) {}
  
  public void onClick(View paramView)
  {
    this.this$0.ag.setSelectAllOnFocus(false);
    this.this$0.ag.setSelection(this.this$0.ag.length());
    this.this$0.ag.setOnClickListener(null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayky
 * JD-Core Version:    0.7.0.1
 */