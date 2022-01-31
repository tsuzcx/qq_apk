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
import com.tencent.token.utils.s;
import java.util.List;

final class b
  extends BaseAdapter
{
  private AbnormalLoginActivity a = null;
  private AbnormalLoginMsgResult b;
  private LayoutInflater c = null;
  
  public b(AbnormalLoginActivity paramAbnormalLoginActivity)
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
    if ((this.b == null) || (this.b.mCnt == 0)) {
      return 0;
    }
    return this.b.mCnt + 2;
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
    View localView = paramView;
    if (paramView == null) {
      localView = this.c.inflate(2130903041, paramViewGroup, false);
    }
    if ((this.b.mCnt > 0) && (paramInt >= this.b.mCnt))
    {
      localView.setVisibility(4);
      return localView;
    }
    Object localObject = (SafeMsgItem)this.b.mMsgList.get(paramInt);
    int i;
    RelativeLayout localRelativeLayout1;
    RelativeLayout localRelativeLayout2;
    RelativeLayout localRelativeLayout3;
    TextView localTextView1;
    TextView localTextView2;
    ImageView localImageView1;
    ImageView localImageView2;
    ImageView localImageView3;
    ImageView localImageView4;
    ImageView localImageView5;
    ImageView localImageView6;
    if (localObject != null)
    {
      if ((((SafeMsgItem)localObject).mFlag & 0x4) != 4) {
        break label523;
      }
      i = 1;
      localRelativeLayout1 = (RelativeLayout)localView.findViewById(2131296265);
      localRelativeLayout2 = (RelativeLayout)localView.findViewById(2131296271);
      localRelativeLayout3 = (RelativeLayout)localView.findViewById(2131296275);
      localTextView1 = (TextView)localView.findViewById(2131296280);
      localTextView2 = (TextView)localView.findViewById(2131296281);
      TextView localTextView3 = (TextView)localView.findViewById(2131296282);
      paramView = (TextView)localView.findViewById(2131296268);
      paramViewGroup = (TextView)localView.findViewById(2131296269);
      localImageView1 = (ImageView)localView.findViewById(2131296266);
      localImageView2 = (ImageView)localView.findViewById(2131296267);
      localImageView3 = (ImageView)localView.findViewById(2131296273);
      localImageView4 = (ImageView)localView.findViewById(2131296277);
      localImageView5 = (ImageView)localView.findViewById(2131296274);
      localImageView6 = (ImageView)localView.findViewById(2131296278);
      if (paramInt != 0) {
        break label529;
      }
      localRelativeLayout1.setVisibility(0);
      ((ViewGroup.MarginLayoutParams)localRelativeLayout1.getLayoutParams()).topMargin = ((int)(10.0F * IndexActivity.S_DENSITY));
      label281:
      if (i == 0)
      {
        if ((((SafeMsgItem)localObject).mFlag & 0x1) != 1) {
          break label609;
        }
        i = 1;
        label300:
        if (i == 0) {
          break label705;
        }
      }
      if ((((SafeMsgItem)localObject).mFlag & 0x100) != 256) {
        break label615;
      }
      i = 1;
      label323:
      if (i == 0)
      {
        if ((((SafeMsgItem)localObject).mFlag & 0x1) != 1) {
          break label621;
        }
        i = 1;
        label342:
        if (i == 0) {
          break label636;
        }
      }
      localTextView1.setTextAppearance(this.a, 2131427424);
      localTextView2.setTextAppearance(this.a, 2131427425);
      localRelativeLayout2.setVisibility(4);
      localRelativeLayout3.setVisibility(0);
      localImageView4.setBackgroundResource(2130837723);
      if (paramInt != getCount() - 3) {
        break label627;
      }
      localImageView6.setVisibility(4);
      label404:
      localTextView1.setText(((SafeMsgItem)localObject).mTitle);
      paramInt = ((SafeMsgItem)localObject).mContent.indexOf('|');
      if (paramInt == -1) {
        break label774;
      }
      localTextView2.setText(((SafeMsgItem)localObject).mContent.substring(0, paramInt));
      label445:
      localTextView3.setText(s.d(((SafeMsgItem)localObject).mTime * 1000L));
      localObject = s.c(((SafeMsgItem)localObject).mTime * 1000L);
      if (((String)localObject).length() <= 2) {
        break label787;
      }
      paramView.setVisibility(8);
      paramViewGroup.setVisibility(0);
      paramViewGroup.setText((CharSequence)localObject);
      localImageView1.setVisibility(4);
      localImageView2.setVisibility(0);
    }
    for (;;)
    {
      localView.setVisibility(0);
      return localView;
      label523:
      i = 0;
      break;
      label529:
      SafeMsgItem localSafeMsgItem = (SafeMsgItem)this.b.mMsgList.get(paramInt - 1);
      if ((localSafeMsgItem != null) && (!s.a(localSafeMsgItem.mTime * 1000L, ((SafeMsgItem)localObject).mTime * 1000L)))
      {
        localRelativeLayout1.setVisibility(0);
        ((ViewGroup.MarginLayoutParams)localRelativeLayout1.getLayoutParams()).topMargin = 0;
        break label281;
      }
      localRelativeLayout1.setVisibility(8);
      break label281;
      label609:
      i = 0;
      break label300;
      label615:
      i = 0;
      break label323;
      label621:
      i = 0;
      break label342;
      label627:
      localImageView6.setVisibility(0);
      break label404;
      label636:
      localImageView4.setBackgroundResource(2130837724);
      if (paramInt == getCount() - 3) {
        localImageView6.setVisibility(4);
      }
      for (;;)
      {
        localTextView1.setTextAppearance(this.a, 2131427426);
        localTextView2.setTextAppearance(this.a, 2131427427);
        localRelativeLayout2.setVisibility(4);
        localRelativeLayout3.setVisibility(0);
        break;
        localImageView6.setVisibility(0);
      }
      label705:
      localTextView1.setTextAppearance(this.a, 2131427424);
      localTextView2.setTextAppearance(this.a, 2131427425);
      localRelativeLayout2.setVisibility(0);
      localRelativeLayout3.setVisibility(4);
      localImageView3.setBackgroundResource(2130837722);
      if (paramInt == getCount() - 3)
      {
        localImageView5.setVisibility(4);
        break label404;
      }
      localImageView5.setVisibility(0);
      break label404;
      label774:
      localTextView2.setText(((SafeMsgItem)localObject).mContent);
      break label445;
      label787:
      paramViewGroup.setVisibility(8);
      paramView.setVisibility(0);
      paramView.setText((CharSequence)localObject);
      localImageView1.setVisibility(0);
      localImageView2.setVisibility(4);
    }
  }
  
  public final boolean isEnabled(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.b
 * JD-Core Version:    0.7.0.1
 */