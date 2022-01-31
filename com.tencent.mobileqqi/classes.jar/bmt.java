import android.content.Intent;
import android.view.View;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.PoiMapActivity.ShopListAdapter;
import com.tencent.biz.PoiMapActivity.Shops;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class bmt
  implements AdapterView.OnItemClickListener
{
  public bmt(PoiMapActivity paramPoiMapActivity) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a.a.a(paramInt);
    if (paramAdapterView == null) {}
    do
    {
      return;
      paramView = new Intent(this.a, CouponActivity.class);
      paramView.putExtra("url", paramAdapterView.g);
      this.a.startActivity(paramView);
      if (paramAdapterView.b != 0) {
        this.a.a("rec_locate", "view_share_tuan", paramAdapterView.h, "", "");
      }
    } while (paramAdapterView.c == 0);
    this.a.a("rec_locate", "click_quan", paramAdapterView.h, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bmt
 * JD-Core Version:    0.7.0.1
 */