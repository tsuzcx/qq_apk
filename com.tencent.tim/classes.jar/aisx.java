import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.location.ui.LocationPickFragment;
import com.tencent.mobileqq.location.ui.PoiSlideBottomPanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aisx
  implements View.OnClickListener
{
  public aisx(LocationPickFragment paramLocationPickFragment, EditText paramEditText) {}
  
  public void onClick(View paramView)
  {
    this.bi.setText("");
    LocationPickFragment.a(this.this$0).hide();
    anot.a(null, "CliOper", "", "", "0X800A961", "0X800A961", 0, 0, "0", "0", "0", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aisx
 * JD-Core Version:    0.7.0.1
 */