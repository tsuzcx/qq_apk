import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;

public class bkz
  implements ActionSheet.OnButtonClickListener
{
  public bkz(SplashActivity paramSplashActivity, List paramList, ActionSheet paramActionSheet) {}
  
  public void a(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.c();
    if ((paramInt < 0) && (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return;
    }
    try
    {
      SplashActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, ((Integer)((Pair)this.jdField_a_of_type_JavaUtilList.get(paramInt)).first).intValue(), (ble)((Pair)this.jdField_a_of_type_JavaUtilList.get(paramInt)).second);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    catch (Throwable paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bkz
 * JD-Core Version:    0.7.0.1
 */