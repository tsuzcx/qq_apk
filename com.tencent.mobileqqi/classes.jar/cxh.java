import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.HornListActivity;
import com.tencent.mobileqq.activity.NearPeopleActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.HornDetail;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.HornAnimationView.OnHornItemClickObserver;
import java.util.List;

public class cxh
  implements HornAnimationView.OnHornItemClickObserver
{
  public cxh(NearPeopleActivity paramNearPeopleActivity) {}
  
  public void a(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Object localObject;
    do
    {
      do
      {
        return;
      } while (paramView.getTag() == null);
      ReportController.b(this.a.b, "P_CliOper", "Svip", "", "Vip_nearby", "Vip_nearby_enterProfileCardNew", 0, 0, "", "", "", "");
      paramView = (HornDetail)paramView.getTag();
      localObject = new ProfileActivity.AllInOne(paramView.uin, 41);
      ((ProfileActivity.AllInOne)localObject).g = paramView.nickName;
      ((ProfileActivity.AllInOne)localObject).a = paramView.seg;
      ((ProfileActivity.AllInOne)localObject).e = 4;
      ((ProfileActivity.AllInOne)localObject).f = 5;
      ProfileActivity.a(this.a, (ProfileActivity.AllInOne)localObject);
      return;
    } while (paramView.getTag() == null);
    try
    {
      ReportController.b(this.a.b, "P_CliOper", "Svip", "", "Vip_nearby", "Vip_nearby_enterHornListNew", 0, 0, "", "", "", "");
      paramView = (HornDetail)paramView.getTag();
      NearPeopleActivity.a(this.a).a = paramView;
      paramView = (HornDetail)NearPeopleActivity.a(this.a).get(NearPeopleActivity.a(this.a).size() - 1);
      localObject = new Intent(this.a, HornListActivity.class);
      ((Intent)localObject).putExtra("lastHornKey", paramView.hornKey);
      ((Intent)localObject).putExtra("lastSvrBuff", NearPeopleActivity.c(this.a));
      ((Intent)localObject).putExtra("hornHasMore", this.a.a);
      this.a.startActivityForResult((Intent)localObject, 0);
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cxh
 * JD-Core Version:    0.7.0.1
 */