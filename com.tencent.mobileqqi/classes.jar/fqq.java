import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.CloudFileBrowserActivity;
import com.tencent.mobileqq.filemanager.activity.FMCloudActivity;
import com.tencent.mobileqq.filemanager.data.FileCategoryAdapter.ItemHolder;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.qphone.base.util.QLog;

public class fqq
  implements View.OnClickListener
{
  public fqq(FMCloudActivity paramFMCloudActivity) {}
  
  private void a(long paramLong)
  {
    int i = 5;
    boolean bool = this.a.g();
    switch ((int)paramLong)
    {
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return;
    case 10: 
      if (bool) {
        i = 3;
      }
      if (!this.a.g()) {
        break;
      }
    }
    for (String str = "file_choose_aio";; str = "file_assistant_in")
    {
      FileManagerReporter.fileAssistantReportData localfileAssistantReportData = new FileManagerReporter.fileAssistantReportData();
      localfileAssistantReportData.jdField_a_of_type_Int = i;
      localfileAssistantReportData.jdField_a_of_type_JavaLangString = str;
      FileManagerReporter.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), localfileAssistantReportData);
      return;
      if (bool)
      {
        i = 4;
        break;
      }
      i = 6;
      break;
      if (bool) {
        break;
      }
      i = 7;
      break;
      if (bool)
      {
        i = 6;
        break;
      }
      i = 8;
      break;
      if (bool)
      {
        i = 7;
        break;
      }
      i = 9;
      break;
      if (bool)
      {
        i = 2;
        break;
      }
      i = 4;
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    if (!this.a.c()) {
      QLog.i(FMCloudActivity.jdField_b_of_type_JavaLangString, 1, "click too fast , wait a minute.");
    }
    do
    {
      return;
      this.a.d();
      paramView = (FileCategoryAdapter.ItemHolder)paramView.getTag();
    } while (paramView.jdField_a_of_type_Int == 0);
    long l = paramView.jdField_a_of_type_Int;
    String str = paramView.jdField_a_of_type_JavaLangString;
    Bundle localBundle = null;
    paramView = localBundle;
    switch ((int)l)
    {
    }
    for (paramView = localBundle;; paramView = new Intent(this.a.getApplicationContext(), CloudFileBrowserActivity.class))
    {
      a(l);
      if (paramView == null) {
        break;
      }
      try
      {
        localBundle = new Bundle();
        localBundle.putLong("category", l);
        localBundle.putString("categoryid", str);
        paramView.putExtra("bundle", localBundle);
        this.a.startActivityForResult(paramView, 101);
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fqq
 * JD-Core Version:    0.7.0.1
 */