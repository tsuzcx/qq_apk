import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.open.agent.CardContainer.a;
import com.tencent.open.agent.OpenSelectPermissionFragment.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arsf
  implements CompoundButton.OnCheckedChangeListener
{
  public arsf(OpenSelectPermissionFragment.a parama, CardContainer.a parama1) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.a.isChecked = paramBoolean;
    this.b.notifyDataSetChanged();
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arsf
 * JD-Core Version:    0.7.0.1
 */