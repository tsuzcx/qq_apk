import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.contact.newfriend.RecommendListView;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecommendContactMsg;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class eet
  implements View.OnClickListener
{
  public eet(RecommendListView paramRecommendListView) {}
  
  public void onClick(View paramView)
  {
    PhoneContactManagerImp localPhoneContactManagerImp;
    if (paramView.getId() == 2131230988)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.b();
      if (this.a.jdField_a_of_type_Efb != null) {
        this.a.jdField_a_of_type_Efb.a = -1;
      }
      paramView = (Button)paramView;
      if (paramView.getTag() != null)
      {
        int i = ((Integer)paramView.getTag()).intValue();
        paramView = (RecommendContactMsg)this.a.jdField_a_of_type_Efb.getItem(i);
        localPhoneContactManagerImp = (PhoneContactManagerImp)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
        if (paramView != null)
        {
          if ((paramView.source == null) || (paramView.source.length() <= 0)) {
            break label154;
          }
          localPhoneContactManagerImp.b(paramView.uin);
        }
      }
    }
    for (;;)
    {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "frd_recommend", "Delete_frd_offer", 0, 0, "0", "", "", "");
      return;
      label154:
      localPhoneContactManagerImp.b(paramView.mobileNo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eet
 * JD-Core Version:    0.7.0.1
 */