package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.browser.TroopQQBrowserHelper;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import dyf;
import dyg;

public class ActivityChatItemBuilder
  extends AbstractChatItemBuilder
  implements View.OnClickListener
{
  protected String b;
  
  public ActivityChatItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout = (dyg)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903366, null);
      paramLinearLayout.b = ((TextView)paramViewHolder.findViewById(2131232293));
      paramLinearLayout.c = ((TextView)paramViewHolder.findViewById(2131232298));
      paramLinearLayout.d = ((TextView)paramViewHolder.findViewById(2131232299));
      paramLinearLayout.a = ((ImageView)paramViewHolder.findViewById(2131232296));
      paramViewHolder.setOnClickListener(this);
      paramLinearLayout.b.setOnClickListener(this);
      paramLinearLayout.c.setOnClickListener(this);
      paramLinearLayout.d.setOnClickListener(this);
      paramLinearLayout.a.setOnClickListener(this);
    }
    if ((paramMessageRecord instanceof MessageForActivity))
    {
      paramView = (MessageForActivity)paramMessageRecord;
      paramLinearLayout.b.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558885));
      paramLinearLayout.c.setText(paramView.title);
      a(paramView.summary, paramLinearLayout.d);
    }
    try
    {
      paramMessageRecord = URLDrawable.getDrawable(paramView.bigPic, paramViewHolder.getResources().getDrawable(2130838410), paramViewHolder.getResources().getDrawable(2130838409));
      paramLinearLayout.a.setBackgroundDrawable(paramMessageRecord);
      this.b = paramView.url;
      if (TextUtils.isEmpty(paramView.title))
      {
        paramMessageRecord = "";
        paramLinearLayout = new StringBuilder().append(paramMessageRecord);
        if (!TextUtils.isEmpty(paramView.summary)) {
          break label299;
        }
        paramMessageRecord = "";
        paramViewHolder.setContentDescription(paramMessageRecord);
        return paramViewHolder;
      }
    }
    catch (Exception paramMessageRecord)
    {
      for (;;)
      {
        paramLinearLayout.a.setBackgroundResource(2130838409);
        continue;
        paramMessageRecord = paramView.title;
        continue;
        label299:
        paramMessageRecord = paramView.summary;
      }
    }
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new dyg(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  protected void a(String paramString, TextView paramTextView)
  {
    paramTextView.getViewTreeObserver().addOnPreDrawListener(new dyf(this, paramTextView, paramString));
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
  
  public void onClick(View paramView)
  {
    TroopQQBrowserHelper.a(this.jdField_a_of_type_AndroidContentContext, this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ActivityChatItemBuilder
 * JD-Core Version:    0.7.0.1
 */