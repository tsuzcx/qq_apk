import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;

public class uaj
  implements View.OnClickListener
{
  public uaj(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, QQBrowserActivity.class);
    paramView.putExtra("url", "http://m.vip.qq.com/freedom/freedom_group_all.html?_wv=1");
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uaj
 * JD-Core Version:    0.7.0.1
 */