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
    RelativeLayout localRelativeLayout3 = (RelativeLayout)paramView.findViewById(2131165695);
    RelativeLayout localRelativeLayout1 = (RelativeLayout)paramView.findViewById(2131165693);
    RelativeLayout localRelativeLayout2 = (RelativeLayout)paramView.findViewById(2131165694);
    TextView localTextView3 = (TextView)paramView.findViewById(2131166070);
    TextView localTextView4 = (TextView)paramView.findViewById(2131166069);
    TextView localTextView5 = (TextView)paramView.findViewById(2131165754);
    TextView localTextView2 = (TextView)paramView.findViewById(2131165689);
    TextView localTextView1 = (TextView)paramView.findViewById(2131165690);
    ImageView localImageView1 = (ImageView)paramView.findViewById(2131165691);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131165692);
    ImageView localImageView3 = (ImageView)paramView.findViewById(2131165699);
    ImageView localImageView4 = (ImageView)paramView.findViewById(2131165700);
    ImageView localImageView5 = (ImageView)paramView.findViewById(2131165701);
    paramView = (ImageView)paramView.findViewById(2131165702);
    if (paramInt == 0)
    {
      localRelativeLayout3.setVisibility(0);
      ((ViewGroup.MarginLayoutParams)localRelativeLayout3.getLayoutParams()).topMargin = ((int)(IndexActivity.S_DENSITY * 10.0F));
    }
    else
    {
      SafeMsgItem localSafeMsgItem = (SafeMsgItem)this.b.mMsgList.get(paramInt - 1);
      if ((localSafeMsgItem != null) && (!l.a(localSafeMsgItem.mTime * 1000L, paramSafeMsgItem.mTime * 1000L)))
      {
        localRelativeLayout3.setVisibility(0);
        ((ViewGroup.MarginLayoutParams)localRelativeLayout3.getLayoutParams()).topMargin = 0;
      }
      else
      {
        localRelativeLayout3.setVisibility(8);
      }
    }
    if ((!paramBoolean) && (!paramSafeMsgItem.s()))
    {
      localTextView3.setTextAppearance(this.a, 2131558772);
      localTextView4.setTextAppearance(this.a, 2131558771);
      localRelativeLayout1.setVisibility(0);
      localRelativeLayout2.setVisibility(4);
      localImageView3.setBackgroundResource(2131099943);
      if (paramInt == getCount() - 3) {
        localImageView5.setVisibility(4);
      } else {
        localImageView5.setVisibility(0);
      }
    }
    else if ((!paramSafeMsgItem.r()) && (!paramSafeMsgItem.s()))
    {
      localImageView4.setBackgroundResource(2131099945);
      if (paramInt == getCount() - 3) {
        paramView.setVisibility(4);
      } else {
        paramView.setVisibility(0);
      }
      localTextView3.setTextAppearance(this.a, 2131558768);
      localTextView4.setTextAppearance(this.a, 2131558767);
      localRelativeLayout1.setVisibility(4);
      localRelativeLayout2.setVisibility(0);
    }
    else
    {
      localTextView3.setTextAppearance(this.a, 2131558772);
      localTextView4.setTextAppearance(this.a, 2131558771);
      localRelativeLayout1.setVisibility(4);
      localRelativeLayout2.setVisibility(0);
      localImageView4.setBackgroundResource(2131099944);
      if (paramInt == getCount() - 3) {
        paramView.setVisibility(4);
      } else {
        paramView.setVisibility(0);
      }
    }
    localTextView3.setText(paramSafeMsgItem.c());
    paramInt = paramSafeMsgItem.d().indexOf('|');
    if (paramInt != -1) {
      localTextView4.setText(paramSafeMsgItem.d().substring(0, paramInt));
    } else {
      localTextView4.setText(paramSafeMsgItem.d());
    }
    localTextView5.setText(l.d(paramSafeMsgItem.e() * 1000L));
    paramView = l.b(paramSafeMsgItem.e() * 1000L);
    if (paramView.length() > 2)
    {
      localTextView2.setVisibility(8);
      localTextView1.setVisibility(0);
      localTextView1.setText(paramView);
      localImageView1.setVisibility(4);
      localImageView2.setVisibility(0);
      return;
    }
    localTextView1.setVisibility(8);
    localTextView2.setVisibility(0);
    localTextView2.setText(paramView);
    localImageView1.setVisibility(0);
    localImageView2.setVisibility(4);
  }
  
  public boolean areAllItemsEnabled()
  {
    return true;
  }
  
  public int getCount()
  {
    AbnormalLoginMsgResult localAbnormalLoginMsgResult = this.b;
    if ((localAbnormalLoginMsgResult != null) && (localAbnormalLoginMsgResult.mCnt != 0)) {
      return this.b.mCnt + 2;
    }
    return 0;
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
    View localView = paramView;
    if (paramView == null) {
      localView = this.c.inflate(2131296284, paramViewGroup, false);
    }
    int i = this.b.mCnt;
    boolean bool = true;
    if ((i >= 1) && (paramInt >= this.b.mCnt))
    {
      localView.setVisibility(4);
      return localView;
    }
    paramView = (SafeMsgItem)this.b.mMsgList.get(paramInt);
    if (paramView != null)
    {
      if ((paramView.b() & 0x4) != 4) {
        bool = false;
      }
      a(localView, paramView, paramInt, bool);
    }
    localView.setVisibility(0);
    return localView;
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