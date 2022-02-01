import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PatchedButton;

public class wwt
  extends www
{
  private boolean mEnable;
  
  public wwt(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  protected void Ad()
  {
    if (!this.mEnable) {
      return;
    }
    super.Ad();
  }
  
  public void ccG()
  {
    if (!this.mEnable) {
      return;
    }
    super.ccG();
  }
  
  protected void ccs()
  {
    this.isHideBottom = true;
    if (!this.bgj)
    {
      this.mEnable = true;
      this.bgj = true;
      return;
    }
    this.mEnable = false;
  }
  
  public boolean isEnabled()
  {
    return this.mEnable;
  }
  
  public void l(Boolean paramBoolean)
  {
    if (!this.mEnable) {
      return;
    }
    super.l(paramBoolean);
  }
  
  public void o(int paramInt1, int paramInt2)
  {
    if (!this.mEnable) {
      return;
    }
    super.o(paramInt1, paramInt2);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      anot.a(null, "dc00898", "", "", "0X800A48A", "0X800A48A", 0, 0, "", "", "", "");
    }
  }
  
  public void v(TextView paramTextView)
  {
    if (!this.mEnable) {
      return;
    }
    super.v(paramTextView);
  }
  
  public int wi()
  {
    return 2130847087;
  }
  
  public void zf(boolean paramBoolean)
  {
    if (!this.mEnable) {
      return;
    }
    super.zf(paramBoolean);
  }
  
  public void zg(boolean paramBoolean)
  {
    if (!this.mEnable) {}
    boolean bool;
    do
    {
      return;
      super.zg(paramBoolean);
      bool = Se();
      if (!paramBoolean) {
        break;
      }
    } while (bool);
    this.f.b.setBackgroundResource(2130838286);
    return;
    this.f.b.setBackgroundResource(2130838286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wwt
 * JD-Core Version:    0.7.0.1
 */