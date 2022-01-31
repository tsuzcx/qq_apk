import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.PoiMapActivity.TabView;
import com.tencent.qphone.base.util.QLog;

public class bmr
  implements View.OnClickListener
{
  public bmr(PoiMapActivity paramPoiMapActivity) {}
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof PoiMapActivity.TabView))
    {
      this.a.a(((PoiMapActivity.TabView)paramView).a);
      if (QLog.isDevelopLevel()) {
        QLog.i("PoiMapActivity", 4, "mTabClickListener" + ((PoiMapActivity.TabView)paramView).a);
      }
      this.a.a("share_locate", "click_tab" + (((PoiMapActivity.TabView)paramView).a + 1), "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bmr
 * JD-Core Version:    0.7.0.1
 */