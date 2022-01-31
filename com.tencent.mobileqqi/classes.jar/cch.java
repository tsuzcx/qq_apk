import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.BaseHornListActivity;
import com.tencent.mobileqq.activity.MyPublishedHornActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class cch
  implements ActionSheet.OnButtonClickListener
{
  public cch(BaseHornListActivity paramBaseHornListActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.a.d();
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 0: 
      paramView = new Intent(this.a.a, QQBrowserActivity.class);
      paramView.putExtra("uin", this.a.b.a());
      paramView.putExtra("isShowAd", false);
      paramView.putExtra("url", String.format("http://imgcache.qq.com/club/horn/rel/myComment.html?_bid=179&uin=%1$s&pvsrc=nearby&_wv=5123", new Object[] { this.a.b.a() }));
      paramView.putExtra("business", 2147549184L);
      this.a.startActivity(paramView);
      return;
    }
    paramView = new Intent(this.a.a, MyPublishedHornActivity.class);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cch
 * JD-Core Version:    0.7.0.1
 */