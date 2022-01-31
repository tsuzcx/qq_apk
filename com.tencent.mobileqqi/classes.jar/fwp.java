import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter.LocalFileItemHolder;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import java.util.ArrayList;

class fwp
  implements View.OnClickListener
{
  fwp(fwo paramfwo, View paramView) {}
  
  public void onClick(View paramView)
  {
    if ((LocalFileBrowserActivity.a(this.jdField_a_of_type_Fwo.a) != null) && (LocalFileBrowserActivity.a(this.jdField_a_of_type_Fwo.a).isShowing())) {
      LocalFileBrowserActivity.a(this.jdField_a_of_type_Fwo.a).dismiss();
    }
    paramView = (LocalFileAdapter.LocalFileItemHolder)this.jdField_a_of_type_AndroidViewView.getTag();
    this.jdField_a_of_type_Fwo.a.jdField_a_of_type_Int = paramView.jdField_a_of_type_Int;
    paramView = (FileInfo)this.jdField_a_of_type_Fwo.a.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Fwo.a.jdField_a_of_type_Int);
    if ((!FileUtil.a(paramView.c())) || (FileUtil.c(paramView.c())))
    {
      FileManagerUtil.d(paramView.c());
      this.jdField_a_of_type_Fwo.a.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Fwo.a.jdField_a_of_type_Int);
      LocalFileBrowserActivity.a(this.jdField_a_of_type_Fwo.a);
      return;
    }
    FMToastUtil.a(2131558716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fwp
 * JD-Core Version:    0.7.0.1
 */