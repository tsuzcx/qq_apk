import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.av.ui.MultiMembersVideoUI;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class jaj
  implements AdapterView.OnItemClickListener
{
  public jaj(MultiMembersVideoUI paramMultiMembersVideoUI) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.a == null) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      jai.a locala = (jai.a)paramView.getTag();
      if (locala == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MultiMembersVideoUI", 2, "onItemClick-->holder is null");
        }
      }
      else if ((this.a.iG.size() > 8) && ((this.a.aqx == 1) || (this.a.aqx == 2))) {
        this.a.a.d(locala.uin, locala.awy, paramInt, true);
      } else {
        this.a.a.d(locala.uin, locala.awy, paramInt, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jaj
 * JD-Core Version:    0.7.0.1
 */