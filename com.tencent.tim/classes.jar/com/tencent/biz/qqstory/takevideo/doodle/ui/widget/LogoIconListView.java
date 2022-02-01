package com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.widget.HorizontalListView;
import rfr;
import rik;
import rit;

@TargetApi(14)
public class LogoIconListView
  extends HorizontalListView
  implements FaceViewPager.a
{
  private int bsj;
  
  public LogoIconListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (Build.VERSION.SDK_INT >= 9) {
      super.setOverScrollMode(2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    rit localrit = (rit)super.getAdapter();
    if ((paramInt < 0) || (paramInt >= localrit.getCount())) {
      return;
    }
    Object localObject = (rik)localrit.getItem(paramInt);
    int i;
    if ((localObject != null) && ("LocationFacePackage".equals(((rik)localObject).getType())))
    {
      if (DoodleLayout.aHL)
      {
        localObject = "2";
        DoodleLayout.e("exp_place", 0, 0, new String[] { localObject });
      }
    }
    else
    {
      localrit.xC(paramInt);
      i = localrit.tv();
      if ((this.bsj >= super.getFirstVisiblePosition()) && (this.bsj <= super.getLastVisiblePosition())) {
        rfr.setAlpha(super.getChild(this.bsj), 0.5F);
      }
      if ((paramInt >= super.getFirstVisiblePosition()) && (paramInt <= super.getLastVisiblePosition())) {
        rfr.setAlpha(super.getChild(paramInt), 1.0F);
      }
      if (paramInt > super.getFirstVisiblePosition()) {
        break label179;
      }
      i = -i;
      super.smoothScrollToPositionFromLeftOrRight(super.getFirstVisiblePosition(), i, 100);
    }
    for (;;)
    {
      this.bsj = paramInt;
      return;
      localObject = "1";
      break;
      label179:
      if (paramInt >= super.getLastVisiblePosition()) {
        super.smoothScrollToPositionFromLeftOrRight(super.getFirstVisiblePosition(), i, 100);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.widget.LogoIconListView
 * JD-Core Version:    0.7.0.1
 */