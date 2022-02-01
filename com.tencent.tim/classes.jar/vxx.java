import android.view.View;
import android.widget.ExpandableListAdapter;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.ExpandableListView.b;

public class vxx
  implements ExpandableListView.b
{
  public vxx(TroopAssisSettingActivity paramTroopAssisSettingActivity) {}
  
  public boolean a(ExpandableListView paramExpandableListView, View paramView, int paramInt1, int paramInt2, long paramLong)
  {
    if (((abgi)paramExpandableListView.getExpandableListAdapter()).getChildType(paramInt1, paramInt2) == 1) {
      return true;
    }
    anpg.bU(this.this$0.getActivity(), this.this$0.app.getCurrentAccountUin());
    paramExpandableListView = (TroopInfo)paramExpandableListView.getExpandableListAdapter().getChild(paramInt1, paramInt2);
    this.this$0.d(paramExpandableListView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vxx
 * JD-Core Version:    0.7.0.1
 */