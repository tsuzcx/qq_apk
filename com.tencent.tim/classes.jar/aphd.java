import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.homework.entry.ui.HomeWorkTroopSelectorFragment;
import com.tencent.mobileqq.troop.homework.entry.ui.HomeWorkTroopSelectorFragment.a;
import com.tencent.mobileqq.troop.homework.entry.ui.HomeWorkTroopSelectorFragment.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class aphd
  implements View.OnClickListener
{
  public aphd(HomeWorkTroopSelectorFragment paramHomeWorkTroopSelectorFragment) {}
  
  public void onClick(View paramView)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (HomeWorkTroopSelectorFragment.a(this.this$0) != null)
    {
      int j = HomeWorkTroopSelectorFragment.a(this.this$0).getCount();
      int i = 0;
      while (i < j)
      {
        localObject = (HomeWorkTroopSelectorFragment.b)HomeWorkTroopSelectorFragment.a(this.this$0).getItem(i);
        if ((((Boolean)((HomeWorkTroopSelectorFragment.b)localObject).second).booleanValue()) && (!HomeWorkTroopSelectorFragment.a(this.this$0).equals(((TroopInfo)((HomeWorkTroopSelectorFragment.b)localObject).first).troopuin)))
        {
          localArrayList1.add(((TroopInfo)((HomeWorkTroopSelectorFragment.b)localObject).first).troopname);
          localArrayList2.add(((TroopInfo)((HomeWorkTroopSelectorFragment.b)localObject).first).troopuin);
        }
        i += 1;
      }
    }
    Object localObject = new Intent();
    ((Intent)localObject).putStringArrayListExtra("HomeWorkConstants:homework_async_uin_list_key", localArrayList2);
    ((Intent)localObject).putStringArrayListExtra("HomeWorkConstants:homework_async_name_list_key", localArrayList1);
    this.this$0.getActivity().setResult(262, (Intent)localObject);
    this.this$0.getActivity().doOnBackPressed();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aphd
 * JD-Core Version:    0.7.0.1
 */