package com.tencent.mobileqq.profile.view;

import albb;
import alcn;
import android.content.res.Resources;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.widget.RatioLayout;
import com.tencent.mobileqq.widget.RatioLayout.LayoutParams;
import java.util.List;

class ProfileTagView$2$1
  implements Runnable
{
  ProfileTagView$2$1(ProfileTagView.2 param2, List paramList) {}
  
  public void run()
  {
    if (this.EV != null)
    {
      int k = ProfileTagView.a().length - 1;
      int i;
      if (this.EV.size() >= k)
      {
        i = k;
        if ((!this.a.this$0.mIsFullScreen) || (this.a.this$0.cwK) || (this.a.this$0.x[k] == null) || (i != 0)) {
          break label341;
        }
        this.a.this$0.Xu.setVisibility(0);
      }
      Object localObject2;
      Object localObject1;
      for (;;)
      {
        if ((this.a.b.e.pa == 0) && (this.a.this$0.x[k] == null))
        {
          localObject2 = this.a.this$0.x;
          localObject1 = View.inflate(this.a.this$0.getContext(), 2131562261, null);
          localObject2[k] = localObject1;
          localObject2 = new RatioLayout.LayoutParams(-2, -2, 0.5F, 0.5F, 0.5F, 0.5F);
          this.a.this$0.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          ((View)localObject1).setVisibility(4);
          ((View)localObject1).setTag(new albb(32, null));
          ((View)localObject1).setOnClickListener(this.a.this$0.jdField_a_of_type_Alcn.mOnClickListener);
          ((View)localObject1).setId(2131375589);
          ((View)localObject1).setTag(2131375589, Integer.valueOf(-1));
          ((View)localObject1).setTag(2131375591, Integer.valueOf(ProfileTagView.a().length - 1));
        }
        j = 0;
        while (j < k)
        {
          localObject1 = this.a.this$0.x[j];
          if (((localObject1 instanceof VipTagView)) && (((View)localObject1).getVisibility() != 8))
          {
            ((VipTagView)localObject1).setShakingState(false);
            ((View)localObject1).setVisibility(8);
          }
          j += 1;
        }
        i = this.EV.size();
        break;
        label341:
        this.a.this$0.Xu.setVisibility(4);
      }
      int j = 0;
      if (j < i)
      {
        localObject2 = (ProfileLabelInfo)this.EV.get(j);
        if (this.a.this$0.x[j] == null)
        {
          localObject1 = new VipTagView(this.a.this$0.getContext());
          this.a.this$0.x[j] = localObject1;
          this.a.this$0.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.addView((View)localObject1);
          ((VipTagView)localObject1).setGravity(17);
          ((VipTagView)localObject1).setTag(2131375589, Integer.valueOf(j));
          ((VipTagView)localObject1).setTag(2131375591, Integer.valueOf(ProfileTagView.g()[j]));
          ((VipTagView)localObject1).setTextColor(-1);
        }
        VipTagView localVipTagView = (VipTagView)this.a.this$0.x[j];
        if ((this.a.this$0.mIsFullScreen) && (!this.a.this$0.cwK))
        {
          localObject1 = ProfileTagView.a()[ProfileTagView.g()[j]];
          localObject1 = new RatioLayout.LayoutParams(-2, -2, 0.5F, 0.5F, ((PointF)localObject1).x, ((PointF)localObject1).y);
          localVipTagView.setVisibility(0);
          localVipTagView.setShakingState(true);
          label575:
          localVipTagView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          localVipTagView.setLabelAndPraise(((ProfileLabelInfo)localObject2).labelName, ((ProfileLabelInfo)localObject2).likeNum.intValue());
          localVipTagView.setTag(2131375590, ((ProfileLabelInfo)localObject2).labelId);
          if ((!this.a.this$0.a(localVipTagView)) || (this.a.b.e.pa == 0)) {
            break label715;
          }
          localVipTagView.setTagColor(this.a.this$0.getResources().getColor(2131166849), this.a.this$0.getResources().getColor(2131166847));
        }
        for (;;)
        {
          j += 1;
          break;
          localObject1 = new RatioLayout.LayoutParams(-2, -2, 0.5F, 0.5F, 0.5F, 0.5F);
          localVipTagView.setVisibility(4);
          break label575;
          label715:
          localVipTagView.setTagColor(this.a.this$0.getResources().getColor(2131166848), this.a.this$0.getResources().getColor(2131166846));
        }
      }
    }
    this.a.this$0.SQ((int)this.a.b.d.backgroundColor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileTagView.2.1
 * JD-Core Version:    0.7.0.1
 */