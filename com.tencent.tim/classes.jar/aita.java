import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.location.ui.LocationPickFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aita
  implements View.OnClickListener
{
  public aita(LocationPickFragment paramLocationPickFragment, EditText paramEditText) {}
  
  public void onClick(View paramView)
  {
    this.bi.setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aita
 * JD-Core Version:    0.7.0.1
 */