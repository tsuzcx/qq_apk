import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aoyw
  implements AdapterView.OnItemClickListener
{
  public aoyw(NewTroopContactView paramNewTroopContactView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    String str = ((ResultRecord)paramView.getTag()).uin;
    if (this.b.iX(str))
    {
      NewTroopContactView.a(this.b, str);
      this.b.a.notifyDataSetChanged();
      this.b.cz(false);
      NewTroopContactView.a(this.b);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoyw
 * JD-Core Version:    0.7.0.1
 */