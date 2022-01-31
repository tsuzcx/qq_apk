import android.os.AsyncTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.activity.LocalFileCategoryBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import java.util.ArrayList;
import java.util.List;

public class fww
  extends AsyncTask
{
  public fww(LocalFileCategoryBrowserActivity paramLocalFileCategoryBrowserActivity) {}
  
  protected List a(Void... paramVarArgs)
  {
    switch (this.a.jdField_b_of_type_Int)
    {
    case 0: 
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      return null;
    case 10: 
      return FileCategoryUtil.a(this.a.jdField_b_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext());
    case 1: 
      return FileCategoryUtil.c(this.a.jdField_b_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext());
    case 2: 
      return FileCategoryUtil.b(this.a.getApplicationContext());
    }
    return FileCategoryUtil.e(this.a.getApplicationContext());
  }
  
  protected void a(List paramList)
  {
    if (paramList == null)
    {
      LocalFileCategoryBrowserActivity.a(this.a);
      LocalFileCategoryBrowserActivity.b(this.a);
      FileManagerUtil.a(LocalFileCategoryBrowserActivity.a(this.a));
      return;
    }
    this.a.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    LocalFileCategoryBrowserActivity.a(this.a);
    LocalFileCategoryBrowserActivity.c(this.a);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
    LocalFileCategoryBrowserActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fww
 * JD-Core Version:    0.7.0.1
 */