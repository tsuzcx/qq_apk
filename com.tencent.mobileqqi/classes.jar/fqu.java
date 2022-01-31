import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.mobileqq.filemanager.data.FileCategoryAdapter.ItemHolder;
import com.tencent.qphone.base.util.QLog;

public class fqu
  implements View.OnClickListener
{
  public fqu(FMLocalFileActivity paramFMLocalFileActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.c()) {
      if (QLog.isColorLevel()) {
        QLog.i(FMLocalFileActivity.b, 2, "click too fast , wait a minute.");
      }
    }
    do
    {
      return;
      this.a.d();
      paramView = (FileCategoryAdapter.ItemHolder)paramView.getTag();
    } while (paramView.a == 0);
    int i = paramView.a;
    FMLocalFileActivity.a(this.a, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fqu
 * JD-Core Version:    0.7.0.1
 */