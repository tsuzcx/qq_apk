package com.tencent.mobileqq.profile.diy;

import android.content.Context;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity.a;
import com.tencent.mobileqq.hiboom.HiBoomTextView;

public class DiyTextView
  extends HiBoomTextView
{
  VipProfileCardDiyActivity.a a;
  
  public DiyTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    if (this.a != null) {
      this.a.fb(paramInt1, paramInt2);
    }
  }
  
  public void setOnMeasuredListener(VipProfileCardDiyActivity.a parama)
  {
    this.a = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.diy.DiyTextView
 * JD-Core Version:    0.7.0.1
 */