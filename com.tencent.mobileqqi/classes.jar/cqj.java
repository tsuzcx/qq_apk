import android.content.res.Resources;
import android.widget.Button;
import com.tencent.mobileqq.activity.BaseHornListActivity;
import com.tencent.mobileqq.activity.HornPublishActivity;
import com.tencent.mobileqq.app.NearHornHandler;
import com.tencent.mobileqq.app.NearHornObserver;
import com.tencent.mobileqq.data.HornDetail;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.VipUtils;
import java.util.Iterator;
import java.util.List;

public class cqj
  extends NearHornObserver
{
  public cqj(HornPublishActivity paramHornPublishActivity) {}
  
  protected void a(boolean paramBoolean, List paramList, int paramInt, String paramString)
  {
    this.a.jdField_a_of_type_JavaLangString = paramString;
    if (paramBoolean)
    {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Svip", "", "Vip_nearby", "Vip_nearby_freeHorn", 0, 0, "", "", "", "");
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.jdField_a_of_type_JavaUtilList != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.jdField_a_of_type_JavaUtilList.clear();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          paramString = (HornDetail)paramList.next();
          this.a.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.jdField_a_of_type_JavaUtilList.add(paramString);
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity.setResult(1);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity.finish();
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
      switch (paramInt)
      {
      default: 
        this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity.a(2131563060);
        break;
      case 210000: 
        this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity.a(2131563029);
        break;
      case 210001: 
        HornPublishActivity.a(this.a);
        break;
      case 100351: 
        if (VipUtils.a(this.a.b)) {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity.a(2131562529);
        } else {
          HornPublishActivity.a(this.a);
        }
        break;
      case 100353: 
        this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity.a(2131563027);
        break;
      case 100354: 
        this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity.a(2131563218);
        break;
      case 100355: 
        paramList = this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity.getResources().getString(2131561908);
        paramString = paramString.split("=");
        if (paramString.length > 1) {
          paramList = paramString[1];
        }
        this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity.a(paramList);
      }
    }
  }
  
  protected void a(boolean paramBoolean, List paramList, Boolean paramBoolean1, Boolean paramBoolean2, int paramInt, String paramString)
  {
    if (paramBoolean) {
      HornPublishActivity.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cqj
 * JD-Core Version:    0.7.0.1
 */