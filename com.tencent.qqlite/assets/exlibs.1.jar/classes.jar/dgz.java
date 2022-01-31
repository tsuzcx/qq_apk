import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.util.IClickListener_Ver51;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.qphone.base.util.QLog;

public class dgz
  implements View.OnClickListener
{
  public dgz(BaseFileAssistantActivity paramBaseFileAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.j())
    {
      FMDataCache.b();
      this.a.f(false);
      if (this.a.g())
      {
        this.a.setResult(5);
        this.a.finish();
        return;
      }
      BaseFileAssistantActivity.a(this.a).setVisibility(0);
      BaseFileAssistantActivity.b(this.a).setText(2131361939);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setVisibility(8);
      this.a.setTitle(this.a.b);
      this.a.d();
      this.a.c();
      if (this.a.jdField_a_of_type_Int == 1) {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.a.b(false);
      return;
    }
    if (BaseFileAssistantActivity.a(this.a) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BaseFileAssistantActivity<FileAssistant>", 2, "onRightEditClick");
      }
      BaseFileAssistantActivity.a(this.a).g();
    }
    FMDataCache.b();
    this.a.f(true);
    BaseFileAssistantActivity.c(this.a).setVisibility(0);
    BaseFileAssistantActivity.d(this.a).setText(2131361966);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setVisibility(0);
    this.a.d();
    this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.a.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dgz
 * JD-Core Version:    0.7.0.1
 */