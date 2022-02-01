import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.RecentFileAdapter.ItemHolder;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;

class fqo
  implements View.OnClickListener
{
  fqo(fqn paramfqn, View paramView) {}
  
  public void onClick(View paramView)
  {
    if ((FMActivity.a(this.jdField_a_of_type_Fqn.a) != null) && (FMActivity.a(this.jdField_a_of_type_Fqn.a).isShowing())) {
      FMActivity.a(this.jdField_a_of_type_Fqn.a).dismiss();
    }
    paramView = ((RecentFileAdapter.ItemHolder)this.jdField_a_of_type_AndroidViewView.getTag()).a;
    if (this.jdField_a_of_type_Fqn.a.b.a().b(paramView.nSessionId)) {
      this.jdField_a_of_type_Fqn.a.a.setVisible();
    }
    FMActivity.a(this.jdField_a_of_type_Fqn.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fqo
 * JD-Core Version:    0.7.0.1
 */