import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.tim.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.tim.filemanager.widget.QfileEditBottomBar;

public class aufc
  implements ausj.a
{
  public aufc(QfileEditBottomBar paramQfileEditBottomBar, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    QfileEditBottomBar.a(this.b).a().IY(false);
    QfileEditBottomBar.a(this.b).deN();
    QfileEditBottomBar.a(this.b).ej(atwb.db());
    QfileEditBottomBar.a(this.b).fn(atwb.ep());
    QfileEditBottomBar.a(this.b).ek(atwb.dd());
    atwb.clearSelected();
    QfileEditBottomBar.a(this.b).IP(false);
    QfileEditBottomBar.a(this.b).refreshUI();
    if (this.val$sheet.isShowing()) {
      this.val$sheet.dismiss();
    }
    QfileEditBottomBar.a(this.b).eul();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aufc
 * JD-Core Version:    0.7.0.1
 */