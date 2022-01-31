import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.HornListActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HornDetail;

public class cqh
  implements View.OnClickListener
{
  public cqh(HornListActivity paramHornListActivity) {}
  
  public void onClick(View paramView)
  {
    if (HornListActivity.a(this.a))
    {
      HornListActivity.a(this.a, false);
      paramView = new Intent(this.a.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramView.putExtra("uin", this.a.b.a());
      paramView.putExtra("isShowAd", false);
      paramView.putExtra("url", String.format("http://imgcache.qq.com/club/horn/rel/comment.html?hornKey=%1$s&_bid=179&uin=%2$s&pvsrc=nearby&_wv=5123", new Object[] { this.a.jdField_a_of_type_ComTencentMobileqqDataHornDetail.hornKey, this.a.b.a() }));
      paramView.putExtra("business", 2147549184L);
      this.a.startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cqh
 * JD-Core Version:    0.7.0.1
 */