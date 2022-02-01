import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SubaccountUgActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class dno
  implements View.OnClickListener
{
  public dno(SubaccountUgActivity paramSubaccountUgActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubaccountUgActivity.a(), null);
    paramView.a(2131561629);
    paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubaccountUgActivity.getResources().getString(2131561946), 3);
    paramView.d(2131561746);
    paramView.a(new dnp(this, paramView));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dno
 * JD-Core Version:    0.7.0.1
 */