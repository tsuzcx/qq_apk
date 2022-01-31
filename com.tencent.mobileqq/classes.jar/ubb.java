import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ListAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ubb
  implements View.OnClickListener
{
  public ubb(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new ArrayList();
    Iterator localIterator = this.a.a.b.iterator();
    while (localIterator.hasNext()) {
      paramView.add(Long.valueOf(Long.parseLong((String)localIterator.next())));
    }
    TroopMemberListActivity.a(this.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ubb
 * JD-Core Version:    0.7.0.1
 */