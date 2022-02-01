import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.weather.SessionClearFragment.a;
import com.tencent.mobileqq.activity.weather.SessionClearFragment.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class abcw
  implements View.OnClickListener
{
  public abcw(SessionClearFragment.b paramb, SessionClearFragment.a parama, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.a.mCheckBox.isChecked()) {}
    for (((acsf)this.b.vM.get(this.val$i)).isCheck = false;; ((acsf)this.b.vM.get(this.val$i)).isCheck = true)
    {
      this.b.notifyItemChanged(this.val$i);
      this.b.cBc();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abcw
 * JD-Core Version:    0.7.0.1
 */