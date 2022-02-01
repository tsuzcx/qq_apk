package com.tencent.token;

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
import com.tencent.token.ui.AbnormalLoginActivity;
import com.tencent.token.ui.IndexActivity;
import java.util.List;

public final class xp
  extends BaseAdapter
{
  private AbnormalLoginActivity a = null;
  private AbnormalLoginMsgResult b;
  private LayoutInflater c = null;
  
  public xp(AbnormalLoginActivity paramAbnormalLoginActivity)
  {
    this.b = ((AbnormalLoginMsgResult)paramAbnormalLoginActivity.getIntent().getExtras().get("msgs"));
    this.a = paramAbnormalLoginActivity;
    this.c = LayoutInflater.from(paramAbnormalLoginActivity);
  }
  
  public final boolean areAllItemsEnabled()
  {
    return true;
  }
  
  public final int getCount()
  {
    AbnormalLoginMsgResult localAbnormalLoginMsgResult = this.b;
    if ((localAbnormalLoginMsgResult != null) && (localAbnormalLoginMsgResult.mCnt != 0)) {
      return this.b.mCnt + 2;
    }
    return 0;
  }
  
  public final Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = this.c.inflate(2131296284, paramViewGroup, false);
    }
    if ((this.b.mCnt > 0) && (paramInt >= this.b.mCnt))
    {
      paramView.setVisibility(4);
      return paramView;
    }
    SafeMsgItem localSafeMsgItem1 = (SafeMsgItem)this.b.mMsgList.get(paramInt);
    if (localSafeMsgItem1 != null)
    {
      int i;
      if ((localSafeMsgItem1.mFlag & 0x4) == 4) {
        i = 1;
      } else {
        i = 0;
      }
      RelativeLayout localRelativeLayout3 = (RelativeLayout)paramView.findViewById(2131165699);
      RelativeLayout localRelativeLayout1 = (RelativeLayout)paramView.findViewById(2131165697);
      RelativeLayout localRelativeLayout2 = (RelativeLayout)paramView.findViewById(2131165698);
      TextView localTextView3 = (TextView)paramView.findViewById(2131166076);
      TextView localTextView4 = (TextView)paramView.findViewById(2131166075);
      TextView localTextView5 = (TextView)paramView.findViewById(2131165758);
      TextView localTextView1 = (TextView)paramView.findViewById(2131165693);
      TextView localTextView2 = (TextView)paramView.findViewById(2131165694);
      ImageView localImageView2 = (ImageView)paramView.findViewById(2131165695);
      ImageView localImageView3 = (ImageView)paramView.findViewById(2131165696);
      ImageView localImageView4 = (ImageView)paramView.findViewById(2131165703);
      ImageView localImageView5 = (ImageView)paramView.findViewById(2131165704);
      paramViewGroup = (ImageView)paramView.findViewById(2131165705);
      ImageView localImageView1 = (ImageView)paramView.findViewById(2131165706);
      if (paramInt == 0)
      {
        localRelativeLayout3.setVisibility(0);
        ((ViewGroup.MarginLayoutParams)localRelativeLayout3.getLayoutParams()).topMargin = ((int)(10.0F * IndexActivity.S_DENSITY));
      }
      else
      {
        SafeMsgItem localSafeMsgItem2 = (SafeMsgItem)this.b.mMsgList.get(paramInt - 1);
        if ((localSafeMsgItem2 != null) && (!aac.a(localSafeMsgItem2.mTime * 1000L, localSafeMsgItem1.mTime * 1000L)))
        {
          localRelativeLayout3.setVisibility(0);
          ((ViewGroup.MarginLayoutParams)localRelativeLayout3.getLayoutParams()).topMargin = 0;
        }
        else
        {
          localRelativeLayout3.setVisibility(8);
        }
      }
      if ((i == 0) && (!localSafeMsgItem1.d()))
      {
        localTextView3.setTextAppearance(this.a, 2131558772);
        localTextView4.setTextAppearance(this.a, 2131558771);
        localRelativeLayout1.setVisibility(0);
        localRelativeLayout2.setVisibility(4);
        localImageView4.setBackgroundResource(2131099944);
        if (paramInt == getCount() - 3) {
          paramViewGroup.setVisibility(4);
        } else {
          paramViewGroup.setVisibility(0);
        }
      }
      else if ((!localSafeMsgItem1.c()) && (!localSafeMsgItem1.d()))
      {
        localImageView5.setBackgroundResource(2131099946);
        if (paramInt == getCount() - 3) {
          localImageView1.setVisibility(4);
        } else {
          localImageView1.setVisibility(0);
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
        localImageView5.setBackgroundResource(2131099945);
        if (paramInt == getCount() - 3) {
          localImageView1.setVisibility(4);
        } else {
          localImageView1.setVisibility(0);
        }
      }
      localTextView3.setText(localSafeMsgItem1.mTitle);
      paramInt = localSafeMsgItem1.mContent.indexOf('|');
      if (paramInt != -1) {
        localTextView4.setText(localSafeMsgItem1.mContent.substring(0, paramInt));
      } else {
        localTextView4.setText(localSafeMsgItem1.mContent);
      }
      localTextView5.setText(aac.d(localSafeMsgItem1.mTime * 1000L));
      paramViewGroup = aac.b(localSafeMsgItem1.mTime * 1000L);
      if (paramViewGroup.length() > 2)
      {
        localTextView1.setVisibility(8);
        localTextView2.setVisibility(0);
        localTextView2.setText(paramViewGroup);
        localImageView2.setVisibility(4);
        localImageView3.setVisibility(0);
      }
      else
      {
        localTextView2.setVisibility(8);
        localTextView1.setVisibility(0);
        localTextView1.setText(paramViewGroup);
        localImageView2.setVisibility(0);
        localImageView3.setVisibility(4);
      }
    }
    paramView.setVisibility(0);
    return paramView;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xp
 * JD-Core Version:    0.7.0.1
 */