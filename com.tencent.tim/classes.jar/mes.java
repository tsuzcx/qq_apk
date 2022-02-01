import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupTips.1;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class mes
  extends PopupWindow
  implements View.OnClickListener
{
  private boolean amg = true;
  private RIJRedPacketPopupView d = (RIJRedPacketPopupView)getContentView();
  private int gravity = 17;
  private int showDuration;
  
  public mes(Context paramContext)
  {
    super(new RIJRedPacketPopupView(paramContext), -2, -2);
    aON();
  }
  
  public void aON()
  {
    this.d.nP(false);
    this.d.nO(false);
    setAnimationStyle(2131756488);
  }
  
  public void aOO()
  {
    this.d.nP(true);
    this.d.nO(true);
    this.d.setOnCloseIconClickListener(this);
    setAnimationStyle(2131756489);
  }
  
  public boolean isShowing()
  {
    return super.isShowing();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      dismiss();
    }
  }
  
  public void rI(int paramInt)
  {
    this.showDuration = paramInt;
  }
  
  public void setGravity(int paramInt)
  {
    this.gravity = paramInt;
  }
  
  public void setTips(String paramString)
  {
    this.d.setText(paramString);
  }
  
  public void showAsDropDown(View paramView)
  {
    showAsDropDown(paramView, 0, 0);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    int i = 0;
    this.d.measure(0, 0);
    if (this.gravity == 17) {
      i = (-this.d.getMeasuredWidth() + paramView.getWidth()) / 2;
    }
    for (;;)
    {
      super.showAsDropDown(paramView, i + paramInt1, paramInt2);
      if (this.amg) {
        ThreadManager.getUIHandler().postDelayed(new RIJRedPacketPopupTips.1(this), this.showDuration);
      }
      return;
      if (this.gravity == 3) {
        i = -this.d.getMeasuredWidth() + paramView.getWidth();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mes
 * JD-Core Version:    0.7.0.1
 */