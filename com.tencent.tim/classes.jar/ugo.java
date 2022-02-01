import android.view.View;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;

public class ugo
  implements ausj.a
{
  public ugo(AssociatedAccountActivity paramAssociatedAccountActivity, boolean paramBoolean, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = paramInt;
    if (!this.aRz) {
      i = paramInt + 1;
    }
    this.val$actionSheet.cancel();
    switch (i)
    {
    default: 
      return;
    case 0: 
      AssociatedAccountActivity.a(this.this$0);
      anot.a(this.this$0.app, "CliOper", "", "", "0X8007149", "0X8007149", 0, 0, "", "", "", "");
      return;
    case 2: 
      AssociatedAccountActivity.b(this.this$0);
      anot.a(this.this$0.app, "CliOper", "", "", "0X8007145", "0X8007145", 0, 0, "", "", "", "");
      return;
    }
    AssociatedAccountActivity.c(this.this$0);
    anot.a(this.this$0.app, "CliOper", "", "", "0X8007148", "0X8007148", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ugo
 * JD-Core Version:    0.7.0.1
 */