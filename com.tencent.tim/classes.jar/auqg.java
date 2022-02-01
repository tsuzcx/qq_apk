import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.widget.IphonePickerView;
import com.tencent.tim.widget.IphonePickerView.c;

public class auqg
  implements View.OnClickListener
{
  public auqg(IphonePickerView paramIphonePickerView) {}
  
  public void onClick(View paramView)
  {
    if (IphonePickerView.a(this.c) != null) {
      IphonePickerView.a(this.c).dn();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auqg
 * JD-Core Version:    0.7.0.1
 */