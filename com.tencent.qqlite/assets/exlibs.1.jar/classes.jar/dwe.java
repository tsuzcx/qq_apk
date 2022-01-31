import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class dwe
  implements View.OnClickListener
{
  public dwe(SendBottomBar paramSendBottomBar) {}
  
  private void a()
  {
    int i = TroopFileUtils.a(SendBottomBar.a(this.a));
    if (i == 0)
    {
      TroopFileError.a(SendBottomBar.a(this.a), SendBottomBar.a(this.a).getString(2131362256));
      this.a.b();
      return;
    }
    if (1 == i)
    {
      dwf localdwf = new dwf(this);
      DialogUtil.a(SendBottomBar.a(this.a), 230, SendBottomBar.a(this.a).getString(2131362238), SendBottomBar.a(this.a).getString(2131362243), 2131362794, 2131362205, localdwf, localdwf).show();
      return;
    }
    this.a.b();
  }
  
  public void onClick(View paramView)
  {
    SendBottomBar.a(this.a).b();
    int j = SendBottomBar.a(this.a).a();
    if (j == 1) {}
    for (int i = 1; j == 5; i = 0)
    {
      this.a.b();
      return;
    }
    if (i != 0)
    {
      a();
      return;
    }
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dwe
 * JD-Core Version:    0.7.0.1
 */