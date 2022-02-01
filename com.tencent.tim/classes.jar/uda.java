import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.AccountManageActivity.4.1;
import com.tencent.mobileqq.widget.RotateSwitchImageView;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class uda
  implements View.OnClickListener
{
  public uda(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.this$0.aQU) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = this.this$0;
      boolean bool;
      label111:
      int i;
      if (!this.this$0.fk)
      {
        bool = true;
        ((AccountManageActivity)localObject).fk = bool;
        if (!this.this$0.fk) {
          break label229;
        }
        this.this$0.rightViewText.setVisibility(8);
        this.this$0.rightHighLView.setVisibility(0);
        this.this$0.rightViewText.setText(2131721066);
        this.this$0.BA.setTextColor(this.this$0.getResources().getColor(2131167385));
        if (AccountManageActivity.a(this.this$0) != null)
        {
          localObject = AccountManageActivity.a(this.this$0, AccountManageActivity.a(this.this$0));
          if ((localObject instanceof ShaderAnimLayout)) {
            ((ShaderAnimLayout)localObject).eiX();
          }
          AccountManageActivity.a(this.this$0).eiK();
          AccountManageActivity.a(this.this$0, null);
        }
        int j = this.this$0.fJ.getChildCount();
        i = 0;
        label185:
        if (i >= j) {
          break label341;
        }
        localObject = this.this$0.fJ.getChildAt(i);
        if ((localObject != null) && (((View)localObject).getTag() != null)) {
          break label289;
        }
      }
      for (;;)
      {
        i += 1;
        break label185;
        bool = false;
        break;
        label229:
        this.this$0.rightViewText.setVisibility(0);
        this.this$0.rightHighLView.setVisibility(8);
        this.this$0.rightViewText.setText(2131721064);
        this.this$0.BA.setTextColor(this.this$0.getResources().getColorStateList(2131167312));
        break label111;
        label289:
        localObject = ((View)localObject).findViewById(2131372193);
        if (localObject != null)
        {
          ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
          localLayoutParams.width = ((int)(AccountManageActivity.a(this.this$0) * AccountManageActivity.b(this.this$0)));
          ((View)localObject).setLayoutParams(localLayoutParams);
        }
      }
      label341:
      this.this$0.bFm();
      this.this$0.vG(this.this$0.fk);
      this.this$0.aQU = false;
      AccountManageActivity.a(this.this$0).postDelayed(new AccountManageActivity.4.1(this), 400L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uda
 * JD-Core Version:    0.7.0.1
 */