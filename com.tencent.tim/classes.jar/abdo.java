import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.fragment.AppletsSettingFragment.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class abdo
  implements CompoundButton.OnCheckedChangeListener
{
  abdo(abdn paramabdn) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = ((Integer)paramCompoundButton.getTag()).intValue();
    AppletItem localAppletItem = (AppletItem)this.a.mDataList.get(i);
    abdn.a(this.a).a(paramCompoundButton, paramBoolean, localAppletItem);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abdo
 * JD-Core Version:    0.7.0.1
 */