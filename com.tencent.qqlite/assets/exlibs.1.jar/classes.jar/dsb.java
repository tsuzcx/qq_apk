import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineHandler.EFILETYPE;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar.IActionBarClickEvent;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.HorizontalListViewAdapter.HlistViewHolder;
import com.tencent.widget.ActionSheet;

public final class dsb
  implements View.OnClickListener
{
  public dsb(String paramString, DataLineHandler paramDataLineHandler, BaseActivity paramBaseActivity, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent) {}
  
  public void onClick(View paramView)
  {
    int i = FileManagerUtil.a(this.jdField_a_of_type_JavaLangString);
    DataLineHandler.EFILETYPE localEFILETYPE = DataLineHandler.EFILETYPE.FILE_TYPE_FILE;
    switch (i)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, localEFILETYPE);
      if ((paramView.getTag() instanceof HorizontalListViewAdapter.HlistViewHolder))
      {
        paramView = (HorizontalListViewAdapter.HlistViewHolder)paramView.getTag();
        if (paramView.a.isShowing()) {
          paramView.a.dismiss();
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent.e();
      }
      return;
      localEFILETYPE = DataLineHandler.EFILETYPE.FILE_TYPE_IMAGE;
      continue;
      localEFILETYPE = DataLineHandler.EFILETYPE.FILE_TYPE_VIDEO;
      continue;
      localEFILETYPE = DataLineHandler.EFILETYPE.FILE_TYPE_AUDIO;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dsb
 * JD-Core Version:    0.7.0.1
 */