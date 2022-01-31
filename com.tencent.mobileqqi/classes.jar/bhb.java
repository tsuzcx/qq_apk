import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.PoiMapActivity.POI;
import com.tencent.biz.PoiMapActivity.PoiItemAdapter;
import com.tencent.biz.coupon.CouponActivity;

public class bhb
  implements View.OnClickListener
{
  public bhb(PoiMapActivity.PoiItemAdapter paramPoiItemAdapter, PoiMapActivity.POI paramPOI) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPoiMapActivity$POI.d))
    {
      paramView = this.jdField_a_of_type_ComTencentBizPoiMapActivity$POI.e;
      localObject = new Intent(this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a, CouponActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a.startActivity((Intent)localObject);
      if ((this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a.a != null) && (this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a.f < this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a.a.length))
      {
        localObject = "";
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPoiMapActivity$POI.d))
        {
          paramView = (View)localObject;
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPoiMapActivity$POI.e)) {}
        }
        else
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPoiMapActivity$POI.d)) {
            break label222;
          }
        }
      }
    }
    label222:
    for (paramView = this.jdField_a_of_type_ComTencentBizPoiMapActivity$POI.d;; paramView = this.jdField_a_of_type_ComTencentBizPoiMapActivity$POI.e)
    {
      Uri localUri = Uri.parse(paramView);
      paramView = (View)localObject;
      if (localUri != null)
      {
        paramView = (View)localObject;
        if (localUri.isHierarchical()) {
          paramView = localUri.getQueryParameter("shop_id");
        }
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPoiMapActivity$POI.d)) {
        break label233;
      }
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a.a("share_locate", "click_share_tuan", this.jdField_a_of_type_ComTencentBizPoiMapActivity$POI.c, paramView, "0");
      return;
      paramView = this.jdField_a_of_type_ComTencentBizPoiMapActivity$POI.d;
      break;
    }
    label233:
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a.a("share_locate", "click_quan", this.jdField_a_of_type_ComTencentBizPoiMapActivity$POI.c, paramView, "0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bhb
 * JD-Core Version:    0.7.0.1
 */