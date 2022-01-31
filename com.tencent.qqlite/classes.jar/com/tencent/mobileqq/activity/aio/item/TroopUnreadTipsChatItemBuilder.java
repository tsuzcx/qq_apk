package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import bxo;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;

public class TroopUnreadTipsChatItemBuilder
  extends AbstractChatItemBuilder
{
  public TroopUnreadTipsChatItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = (bxo)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903112, null);
      paramViewHolder = (TextView)paramView.findViewById(2131296823);
      paramViewHolder.setMovementMethod(null);
      paramViewHolder.setGravity(17);
      paramViewHolder = paramView;
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        paramViewHolder = (TextView)paramView.findViewById(2131296834);
        paramLinearLayout = (TextView)paramView.findViewById(2131296835);
        paramViewHolder.setBackgroundColor(2130838315);
        paramLinearLayout.setBackgroundColor(2130838315);
        paramViewHolder = paramView;
      }
    }
    paramView = (TextView)paramViewHolder.findViewById(2131296823);
    if ((paramMessageRecord.istroop == 1) && (AnonymousChatHelper.a().a(paramMessageRecord.senderuin)))
    {
      paramView.setTextColor(AnonymousChatHelper.d);
      return paramViewHolder;
    }
    paramView.setTextColor(paramViewHolder.getResources().getColorStateList(2131427337));
    return paramViewHolder;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new bxo(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopUnreadTipsChatItemBuilder
 * JD-Core Version:    0.7.0.1
 */