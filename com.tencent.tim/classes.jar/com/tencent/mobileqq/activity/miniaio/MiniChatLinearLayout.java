package com.tencent.mobileqq.activity.miniaio;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import wio;
import zng;

public class MiniChatLinearLayout
  extends LinearLayout
  implements zng
{
  protected boolean bdK;
  protected boolean brG;
  private CheckBox mCheckBox;
  
  public MiniChatLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.brG) {}
    while (BaseChatItemLayout.bdx) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.brG) {
      return true;
    }
    if (BaseChatItemLayout.bdx)
    {
      wio.d(this, paramMotionEvent);
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCheckBox(int paramInt, ChatMessage paramChatMessage, MiniChatLinearLayout paramMiniChatLinearLayout, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ViewGroup paramViewGroup)
  {
    if (BaseChatItemLayout.bdx)
    {
      if (this.mCheckBox != null) {
        break label126;
      }
      this.mCheckBox = new CheckBox(getContext());
      this.mCheckBox.setButtonDrawable(null);
      this.mCheckBox.setId(2131364529);
      this.mCheckBox.setOnCheckedChangeListener(BaseChatItemLayout.w);
      paramMiniChatLinearLayout = new LinearLayout.LayoutParams(1, 1);
      addView(this.mCheckBox, paramMiniChatLinearLayout);
    }
    for (;;)
    {
      this.mCheckBox.setTag(paramChatMessage);
      paramMiniChatLinearLayout = AIOLongShotHelper.a();
      if ((paramMiniChatLinearLayout != null) && (paramMiniChatLinearLayout.RS())) {
        this.mCheckBox.setChecked(paramMiniChatLinearLayout.n(paramChatMessage));
      }
      if (this.mCheckBox != null) {
        this.mCheckBox.setVisibility(8);
      }
      return;
      label126:
      paramMiniChatLinearLayout = new LinearLayout.LayoutParams(1, 1);
      this.mCheckBox.setLayoutParams(paramMiniChatLinearLayout);
    }
  }
  
  public void setFrom(boolean paramBoolean)
  {
    this.bdK = paramBoolean;
  }
  
  public void setIsShieldTouchForItem(boolean paramBoolean)
  {
    this.brG = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniChatLinearLayout
 * JD-Core Version:    0.7.0.1
 */