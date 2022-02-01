package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import ankt;
import aqmr;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.SquareImageView;
import ryx;
import rze;
import sin;

public class SubscribeFollowInfoView
  extends BaseWidgetView<CertifiedAccountMeta.StFeed>
{
  private FollowTextView d;
  private SquareImageView l;
  private TextView zV;
  
  public SubscribeFollowInfoView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public SubscribeFollowInfoView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public SubscribeFollowInfoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean MN()
  {
    return (getData() != null) && (aqmr.isEmpty(((CertifiedAccountMeta.StFeed)getData()).poster.nick.get()));
  }
  
  public void e(Context paramContext, View paramView)
  {
    this.l = ((SquareImageView)paramView.findViewById(2131369666));
    this.zV = ((TextView)paramView.findViewById(2131380565));
    this.d = ((FollowTextView)paramView.findViewById(2131380717));
  }
  
  public int getLayoutId()
  {
    return 2131558843;
  }
  
  protected void q(CertifiedAccountMeta.StFeed paramStFeed)
  {
    sin localsin = new sin(this, paramStFeed);
    if (this.l != null)
    {
      this.l.getLayoutParams().width = ankt.dip2px(27.0F);
      this.l.getLayoutParams().height = ankt.dip2px(27.0F);
      ryx.b(paramStFeed.poster.icon.get(), this.l);
      this.l.setOnClickListener(localsin);
    }
    if (this.zV != null)
    {
      this.zV.setText(paramStFeed.poster.nick.get());
      this.zV.setOnClickListener(localsin);
    }
    if (this.d != null)
    {
      if (rze.bg(paramStFeed.poster.attr.get())) {
        this.d.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.d.setVisibility(0);
    this.d.setFeedData(paramStFeed);
    this.d.setExtraTypeInfo(getExtraTypeInfo());
  }
  
  public void r(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null)
    {
      if (this.l != null)
      {
        this.l.getLayoutParams().width = ankt.dip2px(27.0F);
        this.l.getLayoutParams().height = ankt.dip2px(27.0F);
        ryx.b(paramStFeed.poster.icon.get(), this.l);
      }
      if (this.zV != null) {
        this.zV.setText(paramStFeed.poster.nick.get());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeFollowInfoView
 * JD-Core Version:    0.7.0.1
 */