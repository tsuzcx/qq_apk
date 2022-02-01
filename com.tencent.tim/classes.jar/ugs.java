import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AssociatedAccountManageActivity;
import com.tencent.mobileqq.widget.RotateSwitchImageView;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ugs
  implements View.OnClickListener
{
  public ugs(AssociatedAccountManageActivity paramAssociatedAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (!(paramView instanceof RotateSwitchImageView)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      View localView1 = AssociatedAccountManageActivity.a(this.this$0, paramView);
      View localView2 = AssociatedAccountManageActivity.b(this.this$0, paramView);
      Object localObject;
      if (AssociatedAccountManageActivity.a(this.this$0) == null)
      {
        AssociatedAccountManageActivity.a(this.this$0, (RotateSwitchImageView)paramView);
        AssociatedAccountManageActivity.a(this.this$0).eiL();
        if (localView2 != null)
        {
          localObject = (RelativeLayout.LayoutParams)localView2.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(AssociatedAccountManageActivity.a(this.this$0) * 12.0F + AssociatedAccountManageActivity.b(this.this$0) * 75.0F));
          localView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if ((localView1 instanceof ShaderAnimLayout)) {
          ((ShaderAnimLayout)localView1).eiU();
        }
        if (AppSetting.enableTalkBack) {
          paramView.setContentDescription(this.this$0.getString(2131691504));
        }
      }
      else if (AssociatedAccountManageActivity.a(this.this$0) == paramView)
      {
        AssociatedAccountManageActivity.a(this.this$0).eiK();
        if (localView2 != null)
        {
          localObject = (RelativeLayout.LayoutParams)localView2.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(AssociatedAccountManageActivity.c(this.this$0) * 12.0F));
          localView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if ((localView1 instanceof ShaderAnimLayout)) {
          ((ShaderAnimLayout)localView1).eiX();
        }
        AssociatedAccountManageActivity.a(this.this$0, null);
        if (AppSetting.enableTalkBack) {
          paramView.setContentDescription(this.this$0.getString(2131721546));
        }
      }
      else
      {
        AssociatedAccountManageActivity.a(this.this$0).eiK();
        localObject = AssociatedAccountManageActivity.b(this.this$0, AssociatedAccountManageActivity.a(this.this$0));
        if (localObject != null)
        {
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
          localLayoutParams.rightMargin = ((int)(AssociatedAccountManageActivity.d(this.this$0) * 12.0F));
          ((View)localObject).setLayoutParams(localLayoutParams);
        }
        ((RotateSwitchImageView)paramView).eiL();
        if (localView2 != null)
        {
          localObject = (RelativeLayout.LayoutParams)localView2.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(AssociatedAccountManageActivity.e(this.this$0) * 12.0F + AssociatedAccountManageActivity.f(this.this$0) * 75.0F));
          localView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if (AppSetting.enableTalkBack)
        {
          paramView.setContentDescription(this.this$0.getString(2131691504));
          AssociatedAccountManageActivity.a(this.this$0).setContentDescription(this.this$0.getString(2131721546));
        }
        if ((localView1 instanceof ShaderAnimLayout)) {
          ((ShaderAnimLayout)localView1).eiU();
        }
        localView1 = AssociatedAccountManageActivity.a(this.this$0, AssociatedAccountManageActivity.a(this.this$0));
        if ((localView1 instanceof ShaderAnimLayout)) {
          ((ShaderAnimLayout)localView1).eiX();
        }
        AssociatedAccountManageActivity.a(this.this$0, (RotateSwitchImageView)paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ugs
 * JD-Core Version:    0.7.0.1
 */