package com.tencent.biz.pubaccount.AccountDetail.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.widget.BubbleViewLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import wja;

public class AccountDetailBannerIndicator
  extends LinearLayout
{
  private final String Uo = "#FFFFFFFF";
  private final String Up = "#33FFFFFF";
  private int aDw;
  private int aDx;
  private Context mContext;
  private ArrayList<ImageView> mViewList = new ArrayList();
  
  public AccountDetailBannerIndicator(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.aDw = paramInt;
    azS();
  }
  
  private void azS()
  {
    int j = wja.dp2px(6.0F, this.mContext.getResources());
    int k = wja.dp2px(9.0F, this.mContext.getResources());
    int i = 0;
    if (i < this.aDw)
    {
      BubbleViewLayout localBubbleViewLayout = new BubbleViewLayout(this.mContext);
      Object localObject = new LinearLayout.LayoutParams(-2, -2);
      if (i != 0) {
        ((LinearLayout.LayoutParams)localObject).setMargins(k, 0, 0, 0);
      }
      localBubbleViewLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localBubbleViewLayout.TE(false);
      localBubbleViewLayout.setRadius(3.0F);
      addView(localBubbleViewLayout);
      localObject = new ImageView(this.mContext);
      ((ImageView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(j, j));
      if (i == 0) {
        ((ImageView)localObject).setImageDrawable(new ColorDrawable(Color.parseColor("#FFFFFFFF")));
      }
      for (;;)
      {
        localBubbleViewLayout.addView((View)localObject);
        this.mViewList.add(localObject);
        i += 1;
        break;
        ((ImageView)localObject).setImageDrawable(new ColorDrawable(Color.parseColor("#33FFFFFF")));
      }
    }
  }
  
  public void om(int paramInt)
  {
    if (this.aDw > 1) {}
    for (int i = paramInt % this.aDw;; i = paramInt)
    {
      if (paramInt < 0) {
        i += this.aDw;
      }
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("AccountDetailBannerIndicator", 2, "updateCurrentItem->pos:" + paramInt + ", newPos:" + i);
        }
        ((ImageView)this.mViewList.get(this.aDx)).setImageDrawable(new ColorDrawable(Color.parseColor("#33FFFFFF")));
        this.aDx = i;
        ((ImageView)this.mViewList.get(this.aDx)).setImageDrawable(new ColorDrawable(Color.parseColor("#FFFFFFFF")));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailBannerIndicator
 * JD-Core Version:    0.7.0.1
 */