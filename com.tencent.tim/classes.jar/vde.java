import android.view.View;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.data.Groups;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import java.util.List;

public class vde
  implements AdapterView.c
{
  public vde(GroupManagerActivity paramGroupManagerActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramInt - 1 < 0) || (this.a.oW.size() <= paramInt - 1)) {
      return;
    }
    GroupManagerActivity.a(this.a, (Groups)this.a.oW.get(paramInt - 1));
    GroupManagerActivity.a(this.a, aqha.a(this.a, 2131694540, 2131694544, GroupManagerActivity.a(this.a).group_name, GroupManagerActivity.a(this.a), GroupManagerActivity.b(this.a)));
    GroupManagerActivity.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vde
 * JD-Core Version:    0.7.0.1
 */