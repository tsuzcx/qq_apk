package cooperation.qqfav.widget;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qqfav.QfavReport;
import igd;
import ige;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class FavoriteActionSheet
  implements View.OnClickListener
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 4;
  public static final int d = 8;
  public ActionSheet a;
  public FavoriteActionSheet.Actions a;
  public List a;
  AppRuntime a;
  public boolean a;
  public List b = new ArrayList();
  int e = 1;
  int f = -1;
  
  public FavoriteActionSheet(Activity paramActivity, FavoriteActionSheet.Actions paramActions, int paramInt1, int paramInt2, AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet$Actions = null;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_MqqAppAppRuntime = null;
    this.e = paramInt1;
    this.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet$Actions = paramActions;
    this.f = paramInt2;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(paramActivity, null));
    if ((this.e & 0x1) != 0)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131562129, 5);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1));
    }
    if ((this.e & 0x2) != 0)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131560522, 5);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(2));
    }
    if ((this.e & 0x4) != 0)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131560772, 5);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(4));
    }
    if ((this.e & 0x8) != 0)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131558745, 5);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(8));
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131561746);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new igd(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new ige(this));
  }
  
  private void a()
  {
    QfavReport.a(this.jdField_a_of_type_MqqAppAppRuntime, "User_Forward", this.f, 0, 0);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramString, 5);
    this.b.add(paramString);
  }
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qqfav.widget.FavoriteActionSheet
 * JD-Core Version:    0.7.0.1
 */