package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.token.core.bean.AbnormalLoginMsgResult;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.utils.l;
import java.util.List;

class a
  extends BaseAdapter
{
  private AbnormalLoginActivity a = null;
  private AbnormalLoginMsgResult b;
  private LayoutInflater c = null;
  
  public a(AbnormalLoginActivity paramAbnormalLoginActivity)
  {
    this.b = ((AbnormalLoginMsgResult)paramAbnormalLoginActivity.getIntent().getExtras().get("msgs"));
    this.a = paramAbnormalLoginActivity;
    this.c = LayoutInflater.from(paramAbnormalLoginActivity);
  }
  
  protected void a(View paramView, SafeMsgItem paramSafeMsgItem, int paramInt, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout1 = (RelativeLayout)paramView.findViewById(2131558524);
    RelativeLayout localRelativeLayout2 = (RelativeLayout)paramView.findViewById(2131558530);
    RelativeLayout localRelativeLayout3 = (RelativeLayout)paramView.findViewById(2131558534);
    TextView localTextView3 = (TextView)paramView.findViewById(2131558539);
    TextView localTextView4 = (TextView)paramView.findViewById(2131558540);
    TextView localTextView5 = (TextView)paramView.findViewById(2131558541);
    TextView localTextView1 = (TextView)paramView.findViewById(2131558527);
    TextView localTextView2 = (TextView)paramView.findViewById(2131558528);
    ImageView localImageView1 = (ImageView)paramView.findViewById(2131558525);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131558526);
    ImageView localImageView3 = (ImageView)paramView.findViewById(2131558532);
    ImageView localImageView4 = (ImageView)paramView.findViewById(2131558536);
    ImageView localImageView5 = (ImageView)paramView.findViewById(2131558533);
    paramView = (ImageView)paramView.findViewById(2131558537);
    if (paramInt == 0)
    {
      localRelativeLayout1.setVisibility(0);
      ((ViewGroup.MarginLayoutParams)localRelativeLayout1.getLayoutParams()).topMargin = ((int)(10.0F * IndexActivity.S_DENSITY));
      if ((!paramBoolean) && (!paramSafeMsgItem.s())) {
        break label523;
      }
      if ((!paramSafeMsgItem.r()) && (!paramSafeMsgItem.s())) {
        break label456;
      }
      localTextView3.setTextAppearance(this.a, 2131362164);
      localTextView4.setTextAppearance(this.a, 2131362163);
      localRelativeLayout2.setVisibility(4);
      localRelativeLayout3.setVisibility(0);
      localImageView4.setBackgroundResource(2130837798);
      if (paramInt != getCount() - 3) {
        break label448;
      }
      paramView.setVisibility(4);
      label263:
      localTextView3.setText(paramSafeMsgItem.c());
      paramInt = paramSafeMsgItem.d().indexOf('|');
      if (paramInt == -1) {
        break label592;
      }
      localTextView4.setText(paramSafeMsgItem.d().substring(0, paramInt));
    }
    for (;;)
    {
      localTextView5.setText(l.d(paramSafeMsgItem.e() * 1000L));
      paramView = l.b(paramSafeMsgItem.e() * 1000L);
      if (paramView.length() <= 2) {
        break label604;
      }
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(0);
      localTextView2.setText(paramView);
      localImageView1.setVisibility(4);
      localImageView2.setVisibility(0);
      return;
      SafeMsgItem localSafeMsgItem = (SafeMsgItem)this.b.mMsgList.get(paramInt - 1);
      if ((localSafeMsgItem != null) && (!l.a(localSafeMsgItem.mTime * 1000L, paramSafeMsgItem.mTime * 1000L)))
      {
        localRelativeLayout1.setVisibility(0);
        ((ViewGroup.MarginLayoutParams)localRelativeLayout1.getLayoutParams()).topMargin = 0;
        break;
      }
      localRelativeLayout1.setVisibility(8);
      break;
      label448:
      paramView.setVisibility(0);
      break label263;
      label456:
      localImageView4.setBackgroundResource(2130837799);
      if (paramInt == getCount() - 3) {
        paramView.setVisibility(4);
      }
      for (;;)
      {
        localTextView3.setTextAppearance(this.a, 2131362160);
        localTextView4.setTextAppearance(this.a, 2131362159);
        localRelativeLayout2.setVisibility(4);
        localRelativeLayout3.setVisibility(0);
        break;
        paramView.setVisibility(0);
      }
      label523:
      localTextView3.setTextAppearance(this.a, 2131362164);
      localTextView4.setTextAppearance(this.a, 2131362163);
      localRelativeLayout2.setVisibility(0);
      localRelativeLayout3.setVisibility(4);
      localImageView3.setBackgroundResource(2130837797);
      if (paramInt == getCount() - 3)
      {
        localImageView5.setVisibility(4);
        break label263;
      }
      localImageView5.setVisibility(0);
      break label263;
      label592:
      localTextView4.setText(paramSafeMsgItem.d());
    }
    label604:
    localTextView2.setVisibility(8);
    localTextView1.setVisibility(0);
    localTextView1.setText(paramView);
    localImageView1.setVisibility(0);
    localImageView2.setVisibility(4);
  }
  
  public boolean areAllItemsEnabled()
  {
    return true;
  }
  
  public int getCount()
  {
    if ((this.b == null) || (this.b.mCnt == 0)) {
      return 0;
    }
    return this.b.mCnt + 2;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = true;
    View localView = paramView;
    if (paramView == null) {
      localView = this.c.inflate(2130968604, paramViewGroup, false);
    }
    if ((this.b.mCnt >= 1) && (paramInt >= this.b.mCnt))
    {
      localView.setVisibility(4);
      return localView;
    }
    paramView = (SafeMsgItem)this.b.mMsgList.get(paramInt);
    if (paramView != null) {
      if ((paramView.b() & 0x4) != 4) {
        break label104;
      }
    }
    for (;;)
    {
      a(localView, paramView, paramInt, bool);
      localView.setVisibility(0);
      return localView;
      label104:
      bool = false;
    }
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.a
 * JD-Core Version:    0.7.0.1
 */