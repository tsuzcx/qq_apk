import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PatchedButton;

public class wvl
  extends www
{
  public static final String TAG = ahtj.bLH + "GameMsgChatHelper";
  
  public wvl(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  private ahsz a()
  {
    if ((this.f == null) || (!(this.f instanceof xzk)))
    {
      QLog.w(TAG, 1, " param error.");
      return null;
    }
    return ((xzk)this.f).a();
  }
  
  protected void Ad()
  {
    super.Ad();
    if (this.ak != null) {
      this.ak.setVisibility(8);
    }
    if (this.f.b != null)
    {
      Object localObject1 = (LinearLayout)this.f.mAIORootView.findViewById(2131367818);
      Object localObject2 = (LinearLayout.LayoutParams)((LinearLayout)localObject1).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = 0;
      ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = this.f.b;
      ViewGroup.LayoutParams localLayoutParams = ((View)localObject1).getLayoutParams();
      localObject2 = localLayoutParams;
      if ((localLayoutParams instanceof FrameLayout.LayoutParams))
      {
        localObject1 = (View)this.f.b.getParent();
        localObject2 = ((View)localObject1).getLayoutParams();
      }
      if ((localObject2 instanceof LinearLayout.LayoutParams))
      {
        localObject2 = (LinearLayout.LayoutParams)localObject2;
        ((LinearLayout.LayoutParams)localObject2).width = wja.dp2px(60.0F, this.f.mActivity.getResources());
        ((LinearLayout.LayoutParams)localObject2).height = wja.dp2px(34.0F, this.f.mActivity.getResources());
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        this.f.b.setVisibility(0);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.f.b.setBackgroundResource(wi());
        this.f.b.setText(2131691441);
        if (AppSetting.enableTalkBack) {
          this.f.b.setContentDescription(acfp.m(2131714614));
        }
      }
      this.f.b.setEnabled(false);
    }
  }
  
  protected void ccs()
  {
    this.isHideBottom = true;
  }
  
  public void cct()
  {
    super.cct();
    LinearLayout localLinearLayout = (LinearLayout)this.f.mAIORootView.findViewById(2131367818);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    localLayoutParams.bottomMargin = 0;
    localLinearLayout.setLayoutParams(localLayoutParams);
    this.f.b.setEnabled(false);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ahsz localahsz = a();
      if (localahsz != null) {
        awot.a().c(localahsz.mAppId, "1", "145", "920", "92005", "206353", "", "", "20", "0");
      }
    }
  }
  
  public void zf(boolean paramBoolean) {}
  
  public void zg(boolean paramBoolean)
  {
    if (this.n != null) {
      this.n.setSelected(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wvl
 * JD-Core Version:    0.7.0.1
 */