import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.open.pcpush.OpenFileUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class dha
  extends AsyncTask
{
  public dha(LocalFileBrowserActivity paramLocalFileBrowserActivity, boolean paramBoolean) {}
  
  protected List a(String... paramVarArgs)
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.c == 6) {
      if (FileManagerUtil.b().equalsIgnoreCase(paramVarArgs[0])) {
        paramVarArgs = FileManagerUtil.a(false, 0);
      }
    }
    for (;;)
    {
      String[] arrayOfString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.getIntent().getStringArrayExtra("STRING_Show_Within_Suffixs");
      if ((arrayOfString == null) || (paramVarArgs == null)) {
        break;
      }
      while (i < paramVarArgs.size())
      {
        FileInfo localFileInfo = (FileInfo)paramVarArgs.get(i);
        int j = i;
        if (!localFileInfo.a()) {
          if (localFileInfo.a() != 0L)
          {
            j = i;
            if (OpenFileUtil.a(localFileInfo.e().toLowerCase(), arrayOfString)) {}
          }
          else
          {
            paramVarArgs.remove(i);
            j = i - 1;
          }
        }
        i = j + 1;
      }
      paramVarArgs = FileUtil.a(paramVarArgs[0], false, 0);
      continue;
      paramVarArgs = FileUtil.a(paramVarArgs[0], false, 1);
    }
    return paramVarArgs;
  }
  
  protected void a(List paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_JavaUtilArrayList.clear();
    if (paramList != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      paramList.clear();
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.getCount() != 0)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.h()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setStackFromBottom(true);
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setStackFromBottom(false);
      }
      LocalFileBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity);
    }
    for (;;)
    {
      FileManagerUtil.a(LocalFileBrowserActivity.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity));
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_JavaUtilMap.containsKey(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.d))
      {
        int i = ((Integer)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.d)).intValue();
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.getCount() > i) {
          LocalFileBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity, i);
        }
      }
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisibility(8);
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, LocalFileBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dha
 * JD-Core Version:    0.7.0.1
 */