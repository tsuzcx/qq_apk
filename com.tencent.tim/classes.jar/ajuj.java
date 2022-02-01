import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class ajuj
  implements View.OnClickListener
{
  public ajuj(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject1;
    if ((ChooseInterestTagActivity.a(this.this$0) == 3) || (ChooseInterestTagActivity.a(this.this$0) == 2) || (ChooseInterestTagActivity.a(this.this$0) == 1) || (ChooseInterestTagActivity.a(this.this$0) == 4))
    {
      localObject1 = (InterestTagInfo)paramView.getTag();
      if (localObject1 != null)
      {
        ChooseInterestTagActivity.a(this.this$0).remove(localObject1);
        ChooseInterestTagActivity.a(this.this$0, (InterestTagInfo)localObject1);
        ChooseInterestTagActivity.b(this.this$0, (InterestTagInfo)localObject1);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      try
      {
        int[] arrayOfInt = new int[2];
        paramView.getLocationInWindow(arrayOfInt);
        if (arrayOfInt[0] <= 0) {
          continue;
        }
        InterestTagInfo localInterestTagInfo = (InterestTagInfo)paramView.getTag();
        if (localInterestTagInfo == null) {
          continue;
        }
        Paint localPaint = new Paint();
        localPaint.setTextSize((float)(ChooseInterestTagActivity.a(this.this$0) * 14.0F + 0.5D));
        localPaint.setColor(this.this$0.getResources().getColor(2131167363));
        localPaint.setFakeBoldText(false);
        localPaint.setAntiAlias(true);
        Object localObject2 = localInterestTagInfo.tagName;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = " ";
        }
        localObject2 = localObject1;
        if (((String)localObject1).length() > 8) {
          localObject2 = ((String)localObject1).substring(0, 8) + "...";
        }
        float f = localPaint.measureText((String)localObject2);
        int i = (int)(ChooseInterestTagActivity.a(this.this$0) * 64.0F + 0.5D + f);
        localObject1 = new ajuy(this.this$0, arrayOfInt[0], i);
        ((ajuy)localObject1).a(ChooseInterestTagActivity.a(this.this$0));
        ((ajuy)localObject1).f(localInterestTagInfo);
        ((ajuy)localObject1).showAsDropDown(paramView, -(int)((i - 40.0F * ChooseInterestTagActivity.a(this.this$0)) / 2.0F), 10);
      }
      catch (Exception localException) {}
      if (QLog.isDevelopLevel()) {
        QLog.i("choose_interest_tag", 4, localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajuj
 * JD-Core Version:    0.7.0.1
 */