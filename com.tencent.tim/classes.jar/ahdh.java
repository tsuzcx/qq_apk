import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar.1.1;

public class ahdh
  implements ausj.a
{
  public ahdh(QfileEditBottomBar paramQfileEditBottomBar, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    ThreadManager.executeOnFileThread(new QfileEditBottomBar.1.1(this));
    if (this.val$sheet.isShowing()) {
      this.val$sheet.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahdh
 * JD-Core Version:    0.7.0.1
 */