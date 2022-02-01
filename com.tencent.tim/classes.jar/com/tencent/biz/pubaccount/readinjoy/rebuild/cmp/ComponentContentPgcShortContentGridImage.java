package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import aqcx;
import aqgz;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.m;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.n;
import com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView;
import java.util.List;
import lie;

public class ComponentContentPgcShortContentGridImage
  extends ComponentContentGridImage
{
  public ComponentContentPgcShortContentGridImage(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentPgcShortContentGridImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void cH(View paramView)
  {
    super.cH(paramView);
    ViewGroup.LayoutParams localLayoutParams;
    SocializeFeedsInfo.n localn;
    if (getCount() == 1)
    {
      localLayoutParams = paramView.getLayoutParams();
      localn = (SocializeFeedsInfo.n)((lie)this.aO).a().mSocialFeedInfo.a.kY.get(0);
      localLayoutParams.height = ((int)((aqgz.getWidth() - aqcx.dip2px(getContext(), 54.0F)) / 2L));
      if (localn.pic_height <= 1.5F * localn.pic_width) {
        break label126;
      }
      localLayoutParams.width = ((int)((aqgz.getWidth() - aqcx.dip2px(getContext(), 54.0F)) / 3L));
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      ((SquareCornerTextImageView)paramView).asB = false;
      return;
      label126:
      if (localn.pic_height >= 1.0F * localn.pic_width) {
        localLayoutParams.width = (localn.pic_width * localLayoutParams.height / localn.pic_height);
      } else if (localn.pic_height > 0.6666667F * localn.pic_width) {
        localLayoutParams.width = (localn.pic_width * localLayoutParams.height / localn.pic_height);
      } else {
        localLayoutParams.width = ((int)((aqgz.getWidth() - aqcx.dip2px(getContext(), 54.0F)) / 2L * 3L / 2L));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentPgcShortContentGridImage
 * JD-Core Version:    0.7.0.1
 */