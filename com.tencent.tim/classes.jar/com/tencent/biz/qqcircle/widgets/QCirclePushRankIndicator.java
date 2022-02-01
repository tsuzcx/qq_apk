package com.tencent.biz.qqcircle.widgets;

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

public class QCirclePushRankIndicator
  extends LinearLayout
{
  private final String Uo = "#FF000000";
  private final String Up = "#4D7C878E";
  private int aDw;
  private int aDx;
  private Context mContext;
  private ArrayList<ImageView> mViewList = new ArrayList();
  
  public QCirclePushRankIndicator(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.aDw = paramInt;
    azS();
  }
  
  private void azS()
  {
    int j = wja.dp2px(6.0F, this.mContext.getResources());
    int k = wja.dp2px(20.0F, this.mContext.getResources());
    int m = wja.dp2px(9.0F, this.mContext.getResources());
    int i = 0;
    if (i < this.aDw)
    {
      BubbleViewLayout localBubbleViewLayout = new BubbleViewLayout(this.mContext);
      Object localObject = new LinearLayout.LayoutParams(-2, -2);
      if (i != 0) {
        ((LinearLayout.LayoutParams)localObject).setMargins(m, 0, 0, 0);
      }
      localBubbleViewLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localBubbleViewLayout.TE(false);
      localBubbleViewLayout.setRadius(3.0F);
      addView(localBubbleViewLayout);
      localObject = new ImageView(this.mContext);
      if (i == 0)
      {
        ((ImageView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(k, j));
        ((ImageView)localObject).setImageDrawable(new ColorDrawable(Color.parseColor("#FF000000")));
      }
      for (;;)
      {
        localBubbleViewLayout.addView((View)localObject);
        this.mViewList.add(localObject);
        i += 1;
        break;
        ((ImageView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(j, j));
        ((ImageView)localObject).setImageDrawable(new ColorDrawable(Color.parseColor("#4D7C878E")));
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
        paramInt = wja.dp2px(6.0F, this.mContext.getResources());
        int j = wja.dp2px(20.0F, this.mContext.getResources());
        ((ImageView)this.mViewList.get(this.aDx)).setImageDrawable(new ColorDrawable(Color.parseColor("#4D7C878E")));
        ((ImageView)this.mViewList.get(this.aDx)).setLayoutParams(new RelativeLayout.LayoutParams(paramInt, paramInt));
        this.aDx = i;
        ((ImageView)this.mViewList.get(this.aDx)).setImageDrawable(new ColorDrawable(Color.parseColor("#FF000000")));
        ((ImageView)this.mViewList.get(this.aDx)).setLayoutParams(new RelativeLayout.LayoutParams(j, paramInt));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushRankIndicator
 * JD-Core Version:    0.7.0.1
 */