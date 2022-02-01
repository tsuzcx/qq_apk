package com.tencent.mobileqq.nearby.gameroom;

import acfp;
import ajtu;
import ajtv;
import ajtw.b;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqcx;
import aqdj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;

public class RecentUserInvitePanel
  extends HorizontalScrollView
{
  List<ajtw.b> DB;
  public a a;
  LinearLayout dK;
  boolean isShowMore = false;
  
  public RecentUserInvitePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initUI();
  }
  
  public RecentUserInvitePanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initUI();
  }
  
  private View a(ajtw.b paramb)
  {
    Object localObject1 = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    View localView = inflate(getContext(), 2131561442, null);
    Object localObject2 = (ImageView)localView.findViewById(2131368427);
    ImageView localImageView = (ImageView)localView.findViewById(2131368463);
    int i;
    if (paramb.uinType == 0)
    {
      localObject1 = aqdj.a(localQQAppInterface, 1, paramb.uin);
      i = -1;
    }
    for (;;)
    {
      ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
      if (i != -1) {
        localImageView.setImageResource(i);
      }
      for (;;)
      {
        localObject2 = (TextView)localView.findViewById(2131372190);
        localObject1 = "";
        if (paramb.displayName != null) {
          localObject1 = (String)TextUtils.ellipsize(paramb.displayName, ((TextView)localObject2).getPaint(), aqcx.dip2px(getContext(), 65.0F), TextUtils.TruncateAt.END);
        }
        ((TextView)localObject2).setText((CharSequence)localObject1);
        localObject1 = (Button)localView.findViewById(2131369358);
        ((Button)localObject1).setOnClickListener(new ajtu(this, paramb));
        K((View)localObject1, paramb.cqf);
        localView.setTag(paramb);
        return localView;
        if (paramb.uinType != 1) {
          break label220;
        }
        localObject1 = aqdj.a(localQQAppInterface, 4, paramb.uin);
        i = 2130842156;
        break;
        localImageView.setVisibility(8);
      }
      label220:
      i = -1;
    }
  }
  
  private View cl()
  {
    int i = this.dK.getChildCount();
    View localView = inflate(getContext(), 2131561442, null);
    ((ImageView)localView.findViewById(2131368427)).setImageResource(2130842158);
    ((ImageView)localView.findViewById(2131368463)).setVisibility(8);
    TextView localTextView = (TextView)localView.findViewById(2131372190);
    if (i == 0) {
      localTextView.setText(acfp.m(2131713718));
    }
    for (;;)
    {
      localTextView.setMaxLines(2);
      localTextView.setSingleLine(false);
      localTextView.setGravity(1);
      ((Button)localView.findViewById(2131369358)).setVisibility(8);
      localView.setOnClickListener(new ajtv(this));
      return localView;
      localTextView.setText(acfp.m(2131713719));
    }
  }
  
  public void K(View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof Button))
    {
      paramView = (Button)paramView;
      if (paramBoolean)
      {
        paramView.setText(acfp.m(2131713721));
        paramView.setAlpha(0.5F);
      }
    }
    else
    {
      return;
    }
    paramView.setText(acfp.m(2131713720));
  }
  
  public void a(ajtw.b paramb)
  {
    int i = 0;
    while (i < this.dK.getChildCount())
    {
      View localView = this.dK.getChildAt(i);
      if ((localView.getTag() instanceof ajtw.b))
      {
        ajtw.b localb = (ajtw.b)localView.getTag();
        if ((localb.uinType == paramb.uinType) && (localb.uin.equals(paramb.uin))) {
          K((Button)localView.findViewById(2131369358), paramb.cqf);
        }
      }
      i += 1;
    }
  }
  
  public void av(List<ajtw.b> paramList, boolean paramBoolean)
  {
    this.DB = paramList;
    this.isShowMore = paramBoolean;
    this.dK.removeAllViews();
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = a((ajtw.b)paramList.next());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = aqcx.dip2px(getContext(), 16.0F);
      this.dK.addView((View)localObject, localLayoutParams);
    }
    if (paramBoolean)
    {
      paramList = cl();
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).leftMargin = aqcx.dip2px(getContext(), 16.0F);
      ((LinearLayout.LayoutParams)localObject).rightMargin = aqcx.dip2px(getContext(), 16.0F);
      this.dK.addView(paramList, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void initUI()
  {
    this.dK = new LinearLayout(getContext());
    this.dK.setOrientation(0);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    addView(this.dK, localLayoutParams);
    setHorizontalScrollBarEnabled(false);
  }
  
  public void setOnClickListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(View paramView, ajtw.b paramb);
    
    public abstract void hj(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel
 * JD-Core Version:    0.7.0.1
 */