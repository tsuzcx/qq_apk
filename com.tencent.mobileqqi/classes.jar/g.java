import android.util.SparseIntArray;
import android.view.View;
import com.dataline.activities.DLBaseFileViewActivity;
import com.dataline.util.file.DLFileInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;

public class g
  implements ActionSheet.OnButtonClickListener
{
  public g(DLBaseFileViewActivity paramDLBaseFileViewActivity, SparseIntArray paramSparseIntArray, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (this.jdField_a_of_type_AndroidUtilSparseIntArray.get(Integer.valueOf(paramInt).intValue()))
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "bug, why come here, which" + paramInt);
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      this.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity.l();
      continue;
      QfavBuilder.c(this.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity.a.a).a(this.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity.b).a(this.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity.a(), this.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity.b.getAccount());
      QfavReport.a(this.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity.b, 7, 3);
      continue;
      this.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity.k();
      continue;
      FileManagerUtil.a(this.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity.a(), this.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity.a.a);
      continue;
      this.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity.m();
      continue;
      this.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     g
 * JD-Core Version:    0.7.0.1
 */