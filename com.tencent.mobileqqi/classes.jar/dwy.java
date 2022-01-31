import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;

class dwy
  implements PinnedDividerListView.OnLayoutListener
{
  dwy(dwx paramdwx) {}
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.q() <= 0)
    {
      if (this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.q() != 0) {
        break label127;
      }
      paramInt2 = this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount();
      if (this.a.a.jdField_a_of_type_Dxo != null) {
        break label110;
      }
    }
    label110:
    for (paramInt1 = 0; paramInt2 < paramInt1 + this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.k(); paramInt1 = this.a.a.jdField_a_of_type_Dxo.getCount())
    {
      this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      this.a.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return;
    }
    label127:
    this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
    this.a.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dwy
 * JD-Core Version:    0.7.0.1
 */