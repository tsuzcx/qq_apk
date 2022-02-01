import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.nearby.profilecard.LabelContainer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akby
  extends akbw
  implements View.OnClickListener
{
  protected LabelContainer a(View paramView, int paramInt1, ajuu paramajuu, int paramInt2)
  {
    ((TextView)paramView.findViewById(2131381177)).setText(fF[paramInt1]);
    paramInt1 = riw.dip2px(this.mContext, 6.0F);
    int i = riw.dip2px(this.mContext, 6.0F);
    LabelContainer localLabelContainer = (LabelContainer)paramView.findViewById(2131370115);
    localLabelContainer.setSpace(paramInt1, i);
    paramView.setTag(paramajuu);
    paramView.setOnClickListener(this);
    if (this.mContainer.getChildCount() == paramInt2 - 1)
    {
      paramInt1 = riw.dip2px(this.mContext, 10.0F);
      paramView.setBackgroundResource(2130839689);
      paramView.setPadding(0, paramInt1, 0, paramInt1);
    }
    return localLabelContainer;
  }
  
  protected boolean arH()
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof ajuu))
    {
      ajuu localajuu = (ajuu)paramView.getTag();
      Intent localIntent = new Intent(this.mContext, ChooseInterestTagActivity.class);
      localIntent.putExtra("interest_tag_type", localajuu.tagType);
      localIntent.putExtra("is_from_judge", false);
      localIntent.putExtra("is_from_nearby", true);
      localIntent.putExtra("from_where", "NearbyPeopleProfileActivity");
      localIntent.putParcelableArrayListExtra("choosed_interest_tags", localajuu.tagInfos);
      ((Activity)this.mContext).startActivityForResult(localIntent, 11);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected int tU()
  {
    return 2131561438;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akby
 * JD-Core Version:    0.7.0.1
 */