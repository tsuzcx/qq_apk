import QQService.SvcDevLoginInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.RecentLoginDevActivity;
import java.util.ArrayList;

public class del
  implements View.OnClickListener
{
  public del(RecentLoginDevActivity paramRecentLoginDevActivity, RelativeLayout paramRelativeLayout, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = (SvcDevLoginInfo)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getTag();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramView.stDeviceItemDes);
    RecentLoginDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity, paramView.strDeviceName, localArrayList, RecentLoginDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity), this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     del
 * JD-Core Version:    0.7.0.1
 */