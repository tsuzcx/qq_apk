import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMRecentFileActivity;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.RecentFileAdapter.ItemHolder;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;

class fri
  implements View.OnClickListener
{
  fri(frh paramfrh, View paramView) {}
  
  public void onClick(View paramView)
  {
    if ((FMRecentFileActivity.a(this.jdField_a_of_type_Frh.a) != null) && (FMRecentFileActivity.a(this.jdField_a_of_type_Frh.a).isShowing())) {
      FMRecentFileActivity.a(this.jdField_a_of_type_Frh.a).dismiss();
    }
    paramView = ((RecentFileAdapter.ItemHolder)this.jdField_a_of_type_AndroidViewView.getTag()).a;
    if (this.jdField_a_of_type_Frh.a.b.a().b(paramView.nSessionId)) {
      this.jdField_a_of_type_Frh.a.a.setVisible();
    }
    FMRecentFileActivity.a(this.jdField_a_of_type_Frh.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fri
 * JD-Core Version:    0.7.0.1
 */