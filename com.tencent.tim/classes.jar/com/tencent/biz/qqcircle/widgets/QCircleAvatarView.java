package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import aqcx;
import aqdj;
import atau.a;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.SquareImageView;
import feedcloud.FeedCloudMeta.StUser;
import ous;
import ovd;

public class QCircleAvatarView
  extends FrameLayout
{
  private boolean azG;
  private int bhX = 2130844753;
  private SquareImageView e;
  private SquareImageView f;
  private int mBorderColor;
  private int mBorderWidth;
  private int mIconHeight;
  private int mIconWidth;
  
  public QCircleAvatarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleAvatarView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleAvatarView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext, paramAttributeSet);
  }
  
  protected void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.rr);
    if (paramContext != null)
    {
      this.mIconWidth = ((int)paramContext.getDimension(2, aqcx.dip2px(getContext(), 24.0F)));
      this.mIconHeight = ((int)paramContext.getDimension(1, aqcx.dip2px(getContext(), 24.0F)));
      this.mBorderColor = paramContext.getColor(3, 0);
      this.mBorderWidth = ((int)paramContext.getDimension(4, 0.0F));
      this.azG = paramContext.getBoolean(0, true);
      paramContext.recycle();
    }
    this.e = new SquareImageView(getContext(), null, 0);
    paramContext = new ViewGroup.LayoutParams(-1, -1);
    if (this.mBorderWidth != 0) {
      this.e.setPadding(this.mBorderWidth, this.mBorderWidth, this.mBorderWidth, this.mBorderWidth);
    }
    this.e.setLayoutParams(paramContext);
    this.e.setRoundRect(90);
    this.e.setBackgroundDrawable(getResources().getDrawable(2130840645));
    if (this.mBorderColor != 0) {
      this.e.setBackgroundColor(this.mBorderColor);
    }
    super.addView(this.e);
  }
  
  public void setAuthDrawable(int paramInt)
  {
    this.bhX = paramInt;
    if (this.f != null) {
      this.f.setBackgroundResource(paramInt);
    }
  }
  
  public void setAvatar(AppInterface paramAppInterface, String paramString)
  {
    if (this.e != null) {
      this.e.setBackgroundDrawable(aqdj.a(paramAppInterface, 1, 4, paramString));
    }
  }
  
  public void setAvatarUrl(String paramString)
  {
    if (this.e != null) {
      ous.b(paramString, this.e);
    }
  }
  
  public void setIsAuth(boolean paramBoolean)
  {
    Object localObject;
    if (this.f == null)
    {
      this.f = new SquareImageView(getContext(), null, 0);
      localObject = new FrameLayout.LayoutParams(this.mIconWidth, this.mIconHeight);
      ((FrameLayout.LayoutParams)localObject).gravity = 85;
      this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.f.setRoundRect(90);
      this.f.setBackgroundResource(this.bhX);
      localObject = this.f;
      if (!this.azG) {
        break label121;
      }
    }
    label121:
    for (int i = 0;; i = 8)
    {
      ((SquareImageView)localObject).setVisibility(i);
      super.addView(this.f);
      if ((!this.azG) || (!paramBoolean)) {
        break;
      }
      this.f.setVisibility(0);
      return;
    }
    this.f.setVisibility(8);
  }
  
  public void setUser(AppInterface paramAppInterface, FeedCloudMeta.StUser paramStUser)
  {
    if ((paramStUser != null) && (!TextUtils.isEmpty(paramStUser.id.get())))
    {
      setAvatar(paramAppInterface, paramStUser.id.get());
      setIsAuth(ovd.c(paramStUser));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleAvatarView
 * JD-Core Version:    0.7.0.1
 */