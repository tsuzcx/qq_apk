import android.view.View;
import com.tencent.mobileqq.activity.NearbyPeopleListFrame;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

public class awy
  implements OverScrollViewListener
{
  public awy(NearbyPeopleListFrame paramNearbyPeopleListFrame) {}
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(this.a.jdField_a_of_type_Long);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(this.a.jdField_a_of_type_Long);
    if (NetworkUtil.e(NearbyPeopleListFrame.c(this.a)))
    {
      this.a.a(true, true);
      return true;
    }
    paramView = NearbyPeopleListFrame.a(this.a).obtainMessage(1, 1, 0);
    NearbyPeopleListFrame.a(this.a).sendMessageDelayed(paramView, 1000L);
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(this.a.jdField_a_of_type_Long);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     awy
 * JD-Core Version:    0.7.0.1
 */