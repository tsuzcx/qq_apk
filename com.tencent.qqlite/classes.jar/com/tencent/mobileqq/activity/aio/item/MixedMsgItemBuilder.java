package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import bvx;
import bvy;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.MixedImageOnclickListener;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.AnimationTextView.OnDoubleClick;
import com.tencent.mobileqq.widget.MixedMsgLinearLayout;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MixedMsgItemBuilder
  extends BaseBubbleBuilder
  implements FileTransferManager.Callback
{
  private static final String b = MixedMsgItemBuilder.class.getSimpleName();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bvx(this);
  private MixedImageOnclickListener jdField_a_of_type_ComTencentMobileqqActivityAioMixedImageOnclickListener = new MixedImageOnclickListener();
  private AnimationTextView.OnDoubleClick jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = new bvy(this);
  
  public MixedMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMixedImageOnclickListener.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder, List paramList)
  {
    if (paramSpannableStringBuilder.length() > 0)
    {
      MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
      ((MessageForText)localMessageRecord).sb = new SpannableStringBuilder(paramSpannableStringBuilder);
      paramSpannableStringBuilder.clear();
      paramList.add(localMessageRecord);
    }
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if ((AbsDownloader.a(paramURLDrawable.getURL().toString())) && (paramURLDrawable.getStatus() != 1)) {}
    try
    {
      paramURLDrawable.startDownload();
      return;
    }
    catch (OutOfMemoryError paramURLDrawable) {}
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 2;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (MixedMsgItemBuilder.MixedHolder)paramViewHolder;
    int i;
    if (MixedMsgItemBuilder.MixedHolder.a(paramBaseChatItemLayout) != null)
    {
      i = 1;
      if (MixedMsgItemBuilder.MixedHolder.a(paramBaseChatItemLayout) != paramChatMessage.uniseq) {
        break label49;
      }
    }
    label49:
    for (int j = 1;; j = 0)
    {
      if ((j & i) == 0) {
        break label55;
      }
      return paramView;
      i = 0;
      break;
    }
    label55:
    Object localObject1;
    Object localObject2;
    if ((paramChatMessage instanceof MessageForMixedMsg))
    {
      paramBaseChatItemLayout = (MessageForMixedMsg)paramChatMessage;
      localObject1 = paramBaseChatItemLayout.msgElemList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((localObject2 instanceof MessageForPic))
        {
          localObject2 = (MessageForPic)localObject2;
          if (((MessageForPic)localObject2).time == 0L) {
            MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject2, paramBaseChatItemLayout);
          }
        }
      }
      paramBaseChatItemLayout = a(paramViewHolder, (MixedMsgLinearLayout)paramView, paramBaseChatItemLayout.msgElemList, paramOnLongClickAndTouchListener);
      MixedMsgItemBuilder.MixedHolder.a((MixedMsgItemBuilder.MixedHolder)paramViewHolder, paramChatMessage.uniseq);
    }
    for (;;)
    {
      paramChatMessage = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramView = paramBaseChatItemLayout;
      if (paramChatMessage == null) {
        break;
      }
      paramChatMessage.a(paramBaseChatItemLayout, this);
      return paramBaseChatItemLayout;
      paramBaseChatItemLayout = paramView;
      if ((paramChatMessage instanceof MessageForLongMsg))
      {
        localObject2 = (MessageForLongMsg)paramChatMessage;
        localObject1 = new ArrayList();
        paramBaseChatItemLayout = paramView;
        if (((MessageForLongMsg)localObject2).longMsgFragmentList != null)
        {
          paramBaseChatItemLayout = paramView;
          if (!((MessageForLongMsg)localObject2).longMsgFragmentList.isEmpty())
          {
            paramBaseChatItemLayout = new SpannableStringBuilder();
            localObject2 = ((MessageForLongMsg)localObject2).longMsgFragmentList.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              Object localObject3 = (MessageRecord)((Iterator)localObject2).next();
              if ((localObject3 instanceof MessageForText))
              {
                paramBaseChatItemLayout.append(((MessageForText)localObject3).sb);
              }
              else if ((localObject3 instanceof MessageForPic))
              {
                a(paramBaseChatItemLayout, (List)localObject1);
                ((List)localObject1).add(localObject3);
              }
              else if ((localObject3 instanceof MessageForMixedMsg))
              {
                localObject3 = (MessageForMixedMsg)localObject3;
                j = ((MessageForMixedMsg)localObject3).msgElemList.size();
                i = 0;
                label371:
                MessageRecord localMessageRecord;
                if (i < j)
                {
                  localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject3).msgElemList.get(i);
                  if (!(localMessageRecord instanceof MessageForPic)) {
                    break label453;
                  }
                  if (((MessageForPic)localMessageRecord).time == 0L) {
                    MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localMessageRecord, (MessageForMixedMsg)localObject3);
                  }
                  a(paramBaseChatItemLayout, (List)localObject1);
                  ((List)localObject1).add(localMessageRecord);
                }
                for (;;)
                {
                  i += 1;
                  break label371;
                  break;
                  label453:
                  if ((localMessageRecord instanceof MessageForText)) {
                    paramBaseChatItemLayout.append(((MessageForText)localMessageRecord).sb);
                  } else {
                    ((List)localObject1).add(localMessageRecord);
                  }
                }
              }
            }
            a(paramBaseChatItemLayout, (List)localObject1);
            paramBaseChatItemLayout = a(paramViewHolder, (MixedMsgLinearLayout)paramView, (List)localObject1, paramOnLongClickAndTouchListener);
            MixedMsgItemBuilder.MixedHolder.a((MixedMsgItemBuilder.MixedHolder)paramViewHolder, paramChatMessage.uniseq);
          }
        }
      }
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new MixedMsgItemBuilder.MixedHolder(this);
  }
  
  public MixedMsgLinearLayout a(BaseBubbleBuilder.ViewHolder paramViewHolder, MixedMsgLinearLayout paramMixedMsgLinearLayout, List paramList, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    ArrayList localArrayList = new ArrayList(paramList);
    paramList = paramMixedMsgLinearLayout;
    if (paramMixedMsgLinearLayout == null)
    {
      paramList = new MixedMsgLinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramList.setId(2131296305);
      paramList.setOrientation(1);
      paramList.setFocusable(false);
      paramList.setClickable(true);
      paramList.setMinimumHeight(AIOUtils.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramList.setPadding(2131492966, 2131492964, 2131492967, 2131492965);
      paramMixedMsgLinearLayout = new RelativeLayout.LayoutParams(-2, -2);
      paramMixedMsgLinearLayout.addRule(1, 2131296453);
      paramMixedMsgLinearLayout.addRule(3, 2131296764);
      paramMixedMsgLinearLayout.leftMargin = AIOUtils.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramMixedMsgLinearLayout.rightMargin = AIOUtils.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramList.setLayoutParams(paramMixedMsgLinearLayout);
      paramList.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
      MixedMsgItemBuilder.MixedHolder.a((MixedMsgItemBuilder.MixedHolder)paramViewHolder, paramList);
    }
    paramList.a(localArrayList);
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      paramMixedMsgLinearLayout = (MessageRecord)localArrayList.get(i);
      paramViewHolder = paramList.getChildAt(i);
      if (paramViewHolder == null)
      {
        i += 1;
      }
      else
      {
        Object localObject;
        if ((paramMixedMsgLinearLayout instanceof MessageForText))
        {
          localObject = (AnimationTextView)paramViewHolder;
          ((AnimationTextView)localObject).setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
          ((AnimationTextView)localObject).setText(((MessageForText)paramMixedMsgLinearLayout).sb);
          label257:
          paramMixedMsgLinearLayout = (LinearLayout.LayoutParams)paramViewHolder.getLayoutParams();
          paramMixedMsgLinearLayout.topMargin = BaseChatItemLayout.n;
          if (i != j - 1) {
            break label428;
          }
        }
        label428:
        for (paramMixedMsgLinearLayout.bottomMargin = BaseChatItemLayout.n;; paramMixedMsgLinearLayout.bottomMargin = 0)
        {
          paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
          paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
          break;
          if ((paramMixedMsgLinearLayout instanceof MessageForPic))
          {
            paramMixedMsgLinearLayout = (MessageForPic)paramMixedMsgLinearLayout;
            localObject = (ChatThumbView)paramViewHolder;
            URLDrawable localURLDrawable = PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramMixedMsgLinearLayout, (ChatThumbView)localObject);
            ((ChatThumbView)localObject).setTag(2131296318, paramMixedMsgLinearLayout);
            ((ChatThumbView)localObject).setImageDrawable(localURLDrawable);
            ((ChatThumbView)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            a(localURLDrawable);
            if (paramMixedMsgLinearLayout.isSendFromLocal()) {
              break label257;
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMixedMsgLinearLayout, 2);
            break label257;
          }
          if (!QLog.isColorLevel()) {
            break label257;
          }
          QLog.e(b, 2, "mixed type not support yet." + paramMixedMsgLinearLayout.getClass().getSimpleName());
          break label257;
        }
      }
    }
    paramList.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramList.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramList.b = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
    return paramList;
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return "说" + paramChatMessage.msg;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131298983: 
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    case 2131298988: 
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage));
      return;
    case 2131296652: 
      paramChatMessage = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
      paramContext = new Bundle();
      paramContext.putInt("forward_type", -1);
      paramContext.putString("forward_text", paramChatMessage.toString());
      paramChatMessage = new Intent(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
      paramChatMessage.putExtras(paramContext);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramChatMessage, 21);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
      return;
    case 2131296656: 
      QfavBuilder.b(paramChatMessage).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 8);
      return;
    }
    a(paramChatMessage);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (((paramFileMsg.e != 1) && (paramFileMsg.e != 131075)) || (paramInt1 != 2003)) {}
    label86:
    label470:
    label476:
    label484:
    for (;;)
    {
      return;
      MixedMsgItemBuilder.MixedHolder localMixedHolder = (MixedMsgItemBuilder.MixedHolder)AIOUtils.a(paramView);
      paramView = null;
      Object localObject1;
      if ((localMixedHolder.a instanceof MessageForMixedMsg))
      {
        paramView = (MessageForMixedMsg)localMixedHolder.a;
        if ((MixedMsgItemBuilder.MixedHolder.a(localMixedHolder) != null) && (paramView != null) && (paramView.msgElemList != null)) {
          for (paramView = paramView.msgElemList.iterator(); paramView.hasNext(); paramView = (MessageForPic)localObject1)
          {
            localObject1 = (MessageRecord)paramView.next();
            if ((localObject1 == null) || (((MessageRecord)localObject1).uniseq != paramFileMsg.c) || (!(localObject1 instanceof MessageForPic)) || (((MessageForPic)localObject1).subMsgId != paramFileMsg.d)) {
              break label86;
            }
          }
        }
      }
      else
      {
        for (;;)
        {
          if (paramView == null) {
            break label484;
          }
          paramInt2 = MixedMsgItemBuilder.MixedHolder.a(localMixedHolder).getChildCount();
          paramInt1 = 0;
          label250:
          Object localObject2;
          if (paramInt1 < paramInt2)
          {
            paramFileMsg = MixedMsgItemBuilder.MixedHolder.a(localMixedHolder).getChildAt(paramInt1);
            if ((paramFileMsg instanceof ChatThumbView))
            {
              localObject1 = ((ChatThumbView)paramFileMsg).getTag(2131296318);
              if (((localObject1 instanceof MessageForPic)) && (((MessageForPic)localObject1).uniseq == paramView.uniseq) && (((MessageForPic)localObject1).subMsgId == paramView.subMsgId))
              {
                paramFileMsg = (ChatThumbView)paramFileMsg;
                if (paramFileMsg == null) {
                  break label468;
                }
                paramFileMsg.setImageDrawable(PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramFileMsg));
                return;
                if (!(localMixedHolder.a instanceof MessageForLongMsg)) {
                  break label476;
                }
                localObject1 = (MessageForLongMsg)localMixedHolder.a;
                if ((((MessageForLongMsg)localObject1).longMsgFragmentList == null) || (((MessageForLongMsg)localObject1).longMsgFragmentList.isEmpty())) {
                  break label476;
                }
                localObject1 = ((MessageForLongMsg)localObject1).longMsgFragmentList.iterator();
                do
                {
                  if (!((Iterator)localObject1).hasNext()) {
                    break;
                  }
                  localObject2 = (MessageRecord)((Iterator)localObject1).next();
                } while (localObject2 == null);
                if (((MessageRecord)localObject2).uniseq != paramFileMsg.c) {
                  break label470;
                }
                if ((localObject2 instanceof MessageForPic)) {
                  paramView = (MessageForPic)localObject2;
                }
              }
            }
          }
          for (;;)
          {
            label376:
            break label322;
            if ((localObject2 instanceof MessageForMixedMsg))
            {
              localObject2 = ((MessageForMixedMsg)localObject2).msgElemList.iterator();
              for (;;)
              {
                if (((Iterator)localObject2).hasNext())
                {
                  MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
                  if (((localMessageRecord instanceof MessageForPic)) && (((MessageForPic)localMessageRecord).subMsgId == paramFileMsg.d))
                  {
                    paramView = (MessageForPic)localMessageRecord;
                    break label376;
                    paramInt1 += 1;
                    break label171;
                    paramFileMsg = null;
                    break label250;
                    break;
                  }
                }
              }
            }
          }
          continue;
          paramView = null;
          continue;
          paramView = null;
        }
      }
    }
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    MixedMsgItemBuilder.MixedHolder localMixedHolder = (MixedMsgItemBuilder.MixedHolder)paramViewHolder;
    if ((paramBubbleInfo.a == 0) || (!paramBubbleInfo.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramViewHolder = paramView.getColorStateList(2131427481);
        if (!paramChatMessage.isSend()) {
          break label79;
        }
      }
      label79:
      for (paramView = paramView.getColorStateList(2131427480);; paramView = paramView.getColorStateList(2131427479))
      {
        MixedMsgItemBuilder.MixedHolder.a(localMixedHolder).a(paramViewHolder, paramView);
        return;
        paramViewHolder = paramView.getColorStateList(2131427478);
        break;
      }
    }
    paramViewHolder = ColorStateList.valueOf(-16777216);
    paramView = paramView.getResources().getColorStateList(2131427479);
    if (paramBubbleInfo.c != 0) {
      paramViewHolder = ColorStateList.valueOf(paramBubbleInfo.c);
    }
    if (paramBubbleInfo.d != 0) {
      paramView = ColorStateList.valueOf(paramBubbleInfo.d);
    }
    MixedMsgItemBuilder.MixedHolder.a(localMixedHolder).a(paramViewHolder, paramView);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    paramView.a(this.jdField_a_of_type_AndroidContentContext.getString(2131362795));
    paramView.a(2131298988, this.jdField_a_of_type_AndroidContentContext.getString(2131363122));
    paramView.a(2131296652, this.jdField_a_of_type_AndroidContentContext.getString(2131363568));
    paramView.a(2131296656, this.jdField_a_of_type_AndroidContentContext.getString(2131362658));
    a(paramView);
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */