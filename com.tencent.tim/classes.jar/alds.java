import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.VipProfileCardPreviewActivity;
import com.tencent.mobileqq.profile.view.VipScaledViewPager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class alds
  implements ViewPager.OnPageChangeListener
{
  boolean cwu = false;
  boolean isDragging = false;
  
  public alds(VipProfileCardPreviewActivity paramVipProfileCardPreviewActivity) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "onPageScrollStateChanged state = " + paramInt);
    }
    if (paramInt == 1)
    {
      this.this$0.a.startScroll();
      this.this$0.SI(this.this$0.dsw);
      this.cwu = true;
    }
    if (paramInt == 2) {
      this.isDragging = true;
    }
    if (paramInt == 0)
    {
      if (this.isDragging)
      {
        this.this$0.yK(this.this$0.dsw);
        this.isDragging = false;
        this.this$0.a.stopScroll();
      }
      if (this.cwu)
      {
        this.this$0.a.stopScroll();
        this.cwu = false;
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "onPageScrolled pos = " + paramInt1);
    }
    this.this$0.a.startScroll();
  }
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "onPageSelected pos = " + paramInt);
    }
    this.this$0.a.stopScroll();
    this.this$0.SK(paramInt);
    this.this$0.dsw = paramInt;
    if (((alct)this.this$0.EQ.get(paramInt)).c.agr == alcs.agk)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "report shopping template = " + paramInt);
      }
      anot.a(this.this$0.app, "CliOper", "", "", "Shop_Malltemplate", "0X8005B93", 0, 0, "", "", "", "");
    }
    anot.a(this.this$0.app, "CliOper", "", "", "card_mall", "0X8004C26", 0, 0, "", "", "", VipUtils.d(this.this$0.app, this.this$0.app.getCurrentAccountUin()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alds
 * JD-Core Version:    0.7.0.1
 */