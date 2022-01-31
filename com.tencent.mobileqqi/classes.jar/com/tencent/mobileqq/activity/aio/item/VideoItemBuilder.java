package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import ebm;
import ebn;

public class VideoItemBuilder
  extends BaseBubbleBuilder
{
  private View.OnClickListener a;
  
  public VideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ebm(this);
  }
  
  private void a(ImageView paramImageView, int paramInt)
  {
    Bitmap localBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), paramInt);
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("setting_text_size", 0);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramImageView.getLayoutParams();
    int i = localSharedPreferences.getInt("chat_text_size_type", 0);
    int j = localBitmap.getWidth();
    int k = localBitmap.getHeight();
    int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427654);
    int n = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427655);
    switch (i)
    {
    default: 
      paramImageView.setImageResource(paramInt);
      return;
    }
    localLayoutParams.width = (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b * j / m + n);
    localLayoutParams.height = (k * this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b / m);
    paramImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramImageView.setLayoutParams(localLayoutParams);
    paramImageView.setImageResource(paramInt);
  }
  
  private void a(MessageForVideo paramMessageForVideo, boolean paramBoolean) {}
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    ebn localebn = (ebn)paramViewHolder;
    paramBaseChatItemLayout = paramBaseChatItemLayout.getContext();
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(paramBaseChatItemLayout).inflate(2130903117, null);
      localebn.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.findViewById(2131231227));
      localebn.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewHolder.findViewById(2131231226));
    }
    paramView = (MessageForVideo)paramChatMessage;
    if (paramView.isSend()) {
      localebn.jdField_a_of_type_AndroidWidgetTextView.setPadding(BaseChatItemLayout.s, BaseChatItemLayout.n, BaseChatItemLayout.q, BaseChatItemLayout.o);
    }
    for (;;)
    {
      localebn.jdField_a_of_type_AndroidWidgetImageView.setPadding(BaseChatItemLayout.p, 0, 0, 0);
      localebn.jdField_a_of_type_AndroidWidgetTextView.setText(paramView.text);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (paramChatMessage.msg.contains(paramBaseChatItemLayout.getResources().getString(2131560135))) {
        paramViewHolder.setContentDescription(paramBaseChatItemLayout.getResources().getString(2131560149));
      }
      return paramViewHolder;
      localebn.jdField_a_of_type_AndroidWidgetTextView.setPadding(BaseChatItemLayout.s, BaseChatItemLayout.n, BaseChatItemLayout.q, BaseChatItemLayout.o);
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ebn(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558926);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131234874) {
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    ebn localebn = (ebn)paramViewHolder;
    localebn.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    if ((paramBubbleInfo.a == 0) || (!paramBubbleInfo.a()))
    {
      paramView = paramView.getResources();
      if (localebn.jdField_a_of_type_AndroidWidgetTextView.getText().toString().contains(this.jdField_a_of_type_AndroidContentContext.getString(2131560131)))
      {
        paramViewHolder = paramView.getColorStateList(2131362125);
        localebn.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
        return;
      }
      if (paramChatMessage.isSend())
      {
        paramViewHolder = paramView.getColorStateList(2131362090);
        localebn.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
        if (!paramChatMessage.isSend()) {
          break label149;
        }
      }
      label149:
      for (paramViewHolder = paramView.getColorStateList(2131362089);; paramViewHolder = paramView.getColorStateList(2131362088))
      {
        localebn.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
        return;
        paramViewHolder = paramView.getColorStateList(2131362087);
        break;
      }
    }
    if (paramBubbleInfo.b == 0) {
      localebn.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramBubbleInfo.c == 0)
    {
      localebn.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131362088));
      return;
      localebn.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.b);
    }
    localebn.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramBubbleInfo.c);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.VideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */