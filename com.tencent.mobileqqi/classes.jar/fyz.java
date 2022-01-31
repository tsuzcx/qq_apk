import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class fyz
  implements View.OnClickListener
{
  public fyz(SendBottomBar paramSendBottomBar) {}
  
  private void a()
  {
    int i = TroopFileUtils.a(SendBottomBar.a(this.a));
    if (i == 0)
    {
      TroopFileError.a(SendBottomBar.a(this.a), SendBottomBar.a(this.a).getString(2131560350));
      this.a.b();
      return;
    }
    if (1 == i)
    {
      fza localfza = new fza(this);
      DialogUtil.a(SendBottomBar.a(this.a), 230, SendBottomBar.a(this.a).getString(2131560332), SendBottomBar.a(this.a).getString(2131560337), 2131561746, 2131560308, localfza, localfza).show();
      return;
    }
    this.a.b();
  }
  
  public void onClick(View paramView)
  {
    int j;
    switch (SendBottomBar.a(this.a).b())
    {
    default: 
      j = SendBottomBar.a(this.a).a();
      if (j != 1) {
        break;
      }
    }
    for (int i = 1; j == 5; i = 0)
    {
      this.a.b();
      return;
      SendBottomBar.a(this.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fyz
 * JD-Core Version:    0.7.0.1
 */