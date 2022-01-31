package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import egn;

public class TroopUnreadTipsChatItemBuilder
  extends AbstractChatItemBuilder
{
  public TroopUnreadTipsChatItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramMessageRecord = (egn)paramViewHolder;
    paramMessageRecord = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903133, null);
      paramMessageRecord = (TextView)paramViewHolder.findViewById(2131231357);
      paramMessageRecord.setMovementMethod(null);
      paramMessageRecord.setTextColor(paramViewHolder.getResources().getColorStateList(2131361807));
      paramMessageRecord.setGravity(17);
      paramMessageRecord = paramViewHolder;
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        paramMessageRecord = (TextView)paramViewHolder.findViewById(2131231368);
        paramView = (TextView)paramViewHolder.findViewById(2131231369);
        paramMessageRecord.setBackgroundColor(2130838453);
        paramView.setBackgroundColor(2130838453);
        paramMessageRecord = paramViewHolder;
      }
    }
    return paramMessageRecord;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new egn(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopUnreadTipsChatItemBuilder
 * JD-Core Version:    0.7.0.1
 */