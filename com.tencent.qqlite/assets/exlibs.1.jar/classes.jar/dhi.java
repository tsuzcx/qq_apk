import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter.LocalFileItemHolder;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.widget.MenuPopupDialog;
import java.util.ArrayList;

class dhi
  implements View.OnClickListener
{
  dhi(dhh paramdhh, View paramView) {}
  
  public void onClick(View paramView)
  {
    if (LocalFileBrowserActivity.a(this.jdField_a_of_type_Dhh.a) != null) {
      LocalFileBrowserActivity.a(this.jdField_a_of_type_Dhh.a).dismiss();
    }
    paramView = (LocalFileAdapter.LocalFileItemHolder)this.jdField_a_of_type_AndroidViewView.getTag();
    this.jdField_a_of_type_Dhh.a.b = paramView.a;
    paramView = (FileInfo)this.jdField_a_of_type_Dhh.a.a.get(this.jdField_a_of_type_Dhh.a.b);
    if ((!FileUtil.a(paramView.d())) || (FileUtil.c(paramView.d())))
    {
      FileManagerUtil.d(paramView.d());
      this.jdField_a_of_type_Dhh.a.a.remove(this.jdField_a_of_type_Dhh.a.b);
      LocalFileBrowserActivity.a(this.jdField_a_of_type_Dhh.a);
      return;
    }
    FMToastUtil.a(2131361978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dhi
 * JD-Core Version:    0.7.0.1
 */