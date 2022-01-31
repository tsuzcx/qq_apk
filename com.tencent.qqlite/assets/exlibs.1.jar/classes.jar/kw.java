import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.bmqq.profile.BmqqProfileCardActivity;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

class kw
  implements View.OnClickListener
{
  kw(kv paramkv) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.a, EnterpriseDetailActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", this.a.a.a.mBmqqMasterUin);
    localBundle.putBoolean("need_finish", false);
    localBundle.putString("selfSet_leftViewText", "员工资料");
    paramView.putExtras(localBundle);
    this.a.a.startActivityForResult(paramView, 2000);
    paramView = new HashMap();
    paramView.put("Uin", this.a.a.a.mBmqqUin);
    paramView.put("MasterUin", this.a.a.a.mBmqqMasterUin);
    paramView.put("Company", this.a.a.a.mBmqqCompany);
    paramView.put("Flag", String.valueOf(this.a.a.a.mFlag));
    StatisticCollector.a(this.a.a).a(this.a.a.app.a(), "actJumpToCrmMain", true, -1L, -1L, paramView, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kw
 * JD-Core Version:    0.7.0.1
 */