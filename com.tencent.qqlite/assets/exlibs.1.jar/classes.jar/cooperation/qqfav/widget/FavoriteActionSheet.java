package cooperation.qqfav.widget;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qqfav.QfavReport;
import fld;
import fle;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class FavoriteActionSheet
  implements View.OnClickListener
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = "qqfav.FavoriteActionSheet";
  public static final int b = 2;
  public static final int c = 4;
  public static final int d = 8;
  public static final int e = 16;
  public static final int f = 32;
  public ActionSheet a;
  public FavoriteActionSheet.Actions a;
  public List a;
  AppRuntime jdField_a_of_type_MqqAppAppRuntime = null;
  public boolean a;
  public List b = new ArrayList();
  int g = 1;
  int h = -1;
  
  public FavoriteActionSheet(Activity paramActivity, FavoriteActionSheet.Actions paramActions, int paramInt1, int paramInt2, AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet$Actions = null;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.g = paramInt1;
    this.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet$Actions = paramActions;
    this.h = paramInt2;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    if (paramBoolean) {}
    for (this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(paramActivity, null, 2131624119));; this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(paramActivity, null)))
    {
      if ((this.g & 0x10) != 0)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131363433, 5);
        this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(16));
      }
      if ((this.g & 0x20) != 0)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131362770, 5);
        this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(32));
      }
      if ((this.g & 0x1) != 0)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131363568, 5);
        this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1));
      }
      if ((this.g & 0x2) != 0)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131362432, 5);
        this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(2));
      }
      if ((this.g & 0x4) != 0)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131362658, 5);
        this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(4));
      }
      if ((this.g & 0x8) != 0)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131362006, 5);
        this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(8));
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131362790);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new fld(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new fle(this));
      return;
    }
  }
  
  private void b()
  {
    QfavReport.a(this.jdField_a_of_type_MqqAppAppRuntime, "User_Forward", this.h, 0, 0);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null)
    {
      if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
        break label44;
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      if (QLog.isDevelopLevel()) {
        QLog.d("qqfav.FavoriteActionSheet", 4, "dismiss|showing");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
      return;
      label44:
      if (QLog.isDevelopLevel()) {
        QLog.d("qqfav.FavoriteActionSheet", 4, "dismiss|not showing");
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramString, 5);
    this.b.add(paramString);
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()))
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qqfav.widget.FavoriteActionSheet
 * JD-Core Version:    0.7.0.1
 */