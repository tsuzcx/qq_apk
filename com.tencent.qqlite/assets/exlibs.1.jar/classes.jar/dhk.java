import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.data.FilePreviewDataReporter;
import java.util.Random;

public class dhk
  implements View.OnClickListener
{
  public dhk(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void onClick(View paramView)
  {
    FilePreviewActivity.a(this.a);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.a.jdField_b_of_type_AndroidWidgetTextView.setText(2131364063);
    this.a.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null)
    {
      paramView = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter;
      paramView.a += 1;
    }
    int i = new Random(System.currentTimeMillis()).nextInt(1500);
    new Handler().postDelayed(new dhl(this), i % 1001 + 500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dhk
 * JD-Core Version:    0.7.0.1
 */