import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class wqh
  extends TroopObserver
{
  public wqh(ShowExternalTroopListActivity paramShowExternalTroopListActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, List paramList1, List paramList2)
  {
    this.a.b = false;
    if ((!paramBoolean) || (paramList1 == null) || (paramList1.size() == 0) || (paramInt != 0))
    {
      this.a.jdField_a_of_type_Int = 0;
      if (this.a.jdField_a_of_type_ComTencentWidgetXListView.isOverscrollHeadVisiable())
      {
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 800L);
        ShowExternalTroopListActivity.a(this.a);
      }
      if (!this.a.jdField_a_of_type_Boolean)
      {
        paramList1 = new ArrayList();
        this.a.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter.a(paramList1);
        paramInt = this.a.getTitleBarHeight();
        QQToast.a(this.a, 1, this.a.getString(2131430402), 0).b(paramInt);
        return;
      }
      this.a.a();
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentWidgetXListView.isOverscrollHeadVisiable())
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 800L);
      ShowExternalTroopListActivity.a(this.a);
    }
    this.a.c.setVisibility(0);
    if (this.a.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter != null)
    {
      this.a.jdField_a_of_type_Int = paramList1.size();
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter.a(paramList1);
    }
    this.a.a(paramList2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wqh
 * JD-Core Version:    0.7.0.1
 */