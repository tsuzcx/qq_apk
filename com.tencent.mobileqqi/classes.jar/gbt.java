import android.view.View;
import com.tencent.mobileqq.maproam.activity.RoamingActivity;
import com.tencent.mobileqq.maproam.data.LocationDetail;
import com.tencent.mobileqq.maproam.widget.RoamLocalSearchBar;
import com.tencent.mobileqq.maproam.widget.RoamSearchDialog;
import com.tencent.mobileqq.maproam.widget.RoamSearchDialog.OnSearchResultItemClick;
import com.tencent.widget.AdapterView;

public class gbt
  implements RoamSearchDialog.OnSearchResultItemClick
{
  public gbt(RoamingActivity paramRoamingActivity) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, LocationDetail paramLocationDetail)
  {
    if (paramLocationDetail != null)
    {
      if ((this.a.a != null) && (this.a.a.a != null)) {
        this.a.a.a.dismiss();
      }
      double d1 = paramLocationDetail.a;
      double d2 = paramLocationDetail.b;
      RoamingActivity.a(this.a, d1, d2, paramLocationDetail.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gbt
 * JD-Core Version:    0.7.0.1
 */