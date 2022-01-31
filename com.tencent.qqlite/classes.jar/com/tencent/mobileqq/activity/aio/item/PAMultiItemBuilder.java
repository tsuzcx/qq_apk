package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bxb;
import bxc;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import java.util.ArrayList;

public class PAMultiItemBuilder
  extends AbstractChatItemBuilder
{
  View.OnClickListener a;
  
  public PAMultiItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bxb(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    ((LinearLayout)paramViewHolder).setOrientation(1);
    paramView = (MessageForPubAccount)paramMessageRecord;
    paramLinearLayout = paramView.mPAMessage;
    int k = (int)(1.0F * BaseChatItemLayout.d);
    ArrayList localArrayList = paramLinearLayout.items;
    ViewGroup localViewGroup = (ViewGroup)paramViewHolder;
    int i = 0;
    for (;;)
    {
      if (i < localArrayList.size())
      {
        bxc localbxc = new bxc(this);
        PAMessage.Item localItem = (PAMessage.Item)localArrayList.get(i);
        localbxc.jdField_a_of_type_Int = 5;
        localbxc.jdField_c_of_type_JavaLangString = localItem.url;
        localbxc.jdField_b_of_type_Int = paramLinearLayout.type;
        localbxc.jdField_b_of_type_JavaLangString = localItem.actionUrl;
        localbxc.jdField_a_of_type_JavaLangString = localItem.nativeJumpString;
        localbxc.jdField_a_of_type_Long = paramView.uniseq;
        localbxc.jdField_c_of_type_Int = i;
        label168:
        ImageView localImageView;
        int j;
        if (i == 0)
        {
          paramMessageRecord = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903090, null);
          TextView localTextView = (TextView)paramMessageRecord.findViewById(2131296711);
          localImageView = (ImageView)paramMessageRecord.findViewById(2131296712);
          String str = Util.e(localItem.title);
          localTextView.setText(str);
          if (localItem.mVideoFlag == 1)
          {
            Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
            if (i != 0) {
              break label528;
            }
            j = 2130838363;
            localObject = ((Resources)localObject).getDrawable(j);
            j = Util.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
            ((Drawable)localObject).setBounds(j, 0, Util.a(this.jdField_a_of_type_AndroidContentContext, 17.0F) + j, Util.a(this.jdField_a_of_type_AndroidContentContext, 20.0F));
            SpannableString localSpannableString = new SpannableString(str + "1");
            localSpannableString.setSpan(new ImageSpan((Drawable)localObject, 0), str.length(), str.length() + 1, 17);
            localTextView.setText(localSpannableString);
          }
        }
        try
        {
          localImageView.setImageDrawable(URLDrawable.getDrawable(localItem.cover));
          localViewGroup.addView(paramMessageRecord);
          paramMessageRecord.setTag(localbxc);
          paramMessageRecord.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramMessageRecord.setOnTouchListener(paramOnLongClickAndTouchListener);
          paramMessageRecord.setOnLongClickListener(paramOnLongClickAndTouchListener);
          i += 1;
          continue;
          if (i == localArrayList.size() - 1)
          {
            paramMessageRecord = new ImageView(this.jdField_a_of_type_AndroidContentContext);
            paramMessageRecord.setLayoutParams(new ViewGroup.LayoutParams(-1, k));
            paramMessageRecord.setBackgroundResource(2130838192);
            localViewGroup.addView(paramMessageRecord);
            paramMessageRecord = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903088, null);
            break label168;
          }
          paramMessageRecord = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          paramMessageRecord.setLayoutParams(new ViewGroup.LayoutParams(-1, k));
          paramMessageRecord.setBackgroundResource(2130838192);
          localViewGroup.addView(paramMessageRecord);
          paramMessageRecord = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903089, null);
          break label168;
          label528:
          j = 2130838364;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localImageView.setImageResource(2130837552);
          }
        }
      }
    }
    return paramViewHolder;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new bxc(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      return;
    }
    paramContext = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if ((paramContext != null) && (paramContext.uniseq == paramChatMessage.uniseq)) {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    long l = paramChatMessage.uniseq;
    if (paramChatMessage.issend == 1) {}
    for (;;)
    {
      PublicAccountUtil.a(paramContext, localContext, str, paramInt, l, bool);
      return;
      bool = false;
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    paramView.a(2131298958, this.jdField_a_of_type_AndroidContentContext.getString(2131363086));
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PAMultiItemBuilder
 * JD-Core Version:    0.7.0.1
 */