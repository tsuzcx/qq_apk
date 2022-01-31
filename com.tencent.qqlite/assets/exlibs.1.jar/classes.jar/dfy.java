import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.mobileqq.filemanager.data.FileCategoryAdapter.ItemHolder;
import com.tencent.qphone.base.util.QLog;

public class dfy
  implements View.OnClickListener
{
  public dfy(FMLocalFileActivity paramFMLocalFileActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.c()) {
      if (QLog.isColorLevel()) {
        QLog.i(FMLocalFileActivity.c, 2, "click too fast , wait a minute.");
      }
    }
    do
    {
      return;
      this.a.g();
      paramView = (FileCategoryAdapter.ItemHolder)paramView.getTag();
    } while (paramView.a == 0);
    int i = paramView.a;
    FMLocalFileActivity.a(this.a, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dfy
 * JD-Core Version:    0.7.0.1
 */