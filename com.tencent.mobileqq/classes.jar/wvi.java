import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.ProGallery;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.FileUtils;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Iterator;

public class wvi
  implements View.OnClickListener
{
  public wvi(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_b_of_type_AndroidWidgetButton.setClickable(false);
    if (this.a.getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
    {
      paramView = this.a.jdField_b_of_type_JavaUtilArrayList.iterator();
      for (long l = 0L; paramView.hasNext(); l = FileUtils.a((String)paramView.next()) + l) {}
      if (this.a.jdField_b_of_type_JavaUtilArrayList.size() == 0)
      {
        int i = this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.getFirstVisiblePosition();
        if (i < this.a.jdField_a_of_type_JavaUtilArrayList.size()) {
          FileUtils.a((String)this.a.jdField_a_of_type_JavaUtilArrayList.get(i));
        }
      }
      if (FileManagerUtil.a()) {
        FMDialogUtil.a(this.a, 2131428241, 2131428237, new wvj(this));
      }
    }
    for (;;)
    {
      LpReportInfo_pf00064.allReport(603, 1);
      return;
      this.a.i();
      continue;
      this.a.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wvi
 * JD-Core Version:    0.7.0.1
 */