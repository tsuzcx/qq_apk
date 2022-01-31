package com.tencent.mobileqq.activity.aio.item;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumHandler;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.customviews.MessageProgressTextView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgClickHandler;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.RecyclerListener;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qqfav.QfavUtil;
import efu;
import efv;
import efw;
import efx;
import java.io.File;
import java.net.URL;

public class StructingMsgItemBuilder
  extends BaseBubbleBuilder
  implements FileTransferManager.Callback
{
  private static StructingMsgItemBuilder.ViewCache jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$ViewCache;
  private final float jdField_a_of_type_Float;
  public AbsListView.RecyclerListener a;
  
  public StructingMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_ComTencentWidgetAbsListView$RecyclerListener = new efx(this);
    if ((paramContext instanceof ChatActivity))
    {
      paramQQAppInterface = (ChatActivity)paramContext;
      if (paramQQAppInterface.a != null) {
        paramQQAppInterface.a.setRecyclerListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$RecyclerListener);
      }
    }
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
  }
  
  public static StructingMsgItemBuilder.ViewCache a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$ViewCache == null) {
      jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$ViewCache = new StructingMsgItemBuilder.ViewCache();
    }
    return jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$ViewCache;
  }
  
  private StructMsgForGeneralShare a(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForStructing)) {
      paramChatMessage = null;
    }
    StructMsgForGeneralShare localStructMsgForGeneralShare;
    do
    {
      return paramChatMessage;
      paramChatMessage = (MessageForStructing)paramChatMessage;
      if (!(paramChatMessage.structingMsg instanceof StructMsgForGeneralShare)) {
        break;
      }
      localStructMsgForGeneralShare = (StructMsgForGeneralShare)paramChatMessage.structingMsg;
      paramChatMessage = localStructMsgForGeneralShare;
    } while (localStructMsgForGeneralShare.getProgress() >= 0);
    return null;
  }
  
  private void a(View paramView, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    new StructMsgClickHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView).a(paramStructMsgForGeneralShare.mMsgAction, paramStructMsgForGeneralShare.mMsgUrl, paramStructMsgForGeneralShare.mMsgActionData, paramStructMsgForGeneralShare.mMsg_A_ActionData);
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForStructing paramMessageForStructing)
  {
    int i = ((StructMsgForGeneralShare)paramMessageForStructing.structingMsg).getProgress();
    if ((paramMessageForStructing.extraflag == 32772) && (i >= 0) && (i < 100))
    {
      TroopQZoneUploadAlbumHandler localTroopQZoneUploadAlbumHandler = (TroopQZoneUploadAlbumHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(30);
      localTroopQZoneUploadAlbumHandler.a(MessageUtils.a(paramMessageForStructing.msgUid), paramMessageForStructing.frienduin, paramMessageForStructing.uniseq);
      localTroopQZoneUploadAlbumHandler.a(paramBaseChatItemLayout, new efu(this, paramMessageForStructing, paramBaseChatItemLayout));
    }
  }
  
  private void a(StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramBaseChatItemLayout.setHeadIconVisible(false);
      paramStructingMsgViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130840509);
      int i = paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
      int j = paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
      paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, i, 0, j);
      return;
    }
    paramBaseChatItemLayout.setHeadIconVisible(true);
  }
  
  private void a(StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean, AbsStructMsg paramAbsStructMsg, Resources paramResources)
  {
    RelativeLayout localRelativeLayout = paramStructingMsgViewHolder.b;
    if (localRelativeLayout == null)
    {
      localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramStructingMsgViewHolder.b = localRelativeLayout;
      localRelativeLayout.setId(2131230782);
      paramBaseChatItemLayout.addView(localRelativeLayout);
    }
    for (;;)
    {
      Object localObject2 = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      }
      ((RelativeLayout.LayoutParams)localObject1).topMargin = AIOUtils.a(2.0F, paramResources);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.a(10.0F, paramResources);
      ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131230779);
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131230779);
      if (paramBoolean)
      {
        ((RelativeLayout.LayoutParams)localObject1).addRule(1, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131230773);
      }
      for (;;)
      {
        localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = localRelativeLayout.getChildAt(0);
        paramResources = (Resources)localObject1;
        if (localObject1 != null)
        {
          paramResources = (Resources)localObject1;
          if (paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
          {
            localObject2 = paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
            paramResources = (Resources)localObject1;
            if (localObject2 != null)
            {
              localObject2 = ((View)localObject2).getTag(2131230767);
              if (QLog.isColorLevel()) {
                QLog.d("structMsg", 2, "bindviwfor structmsg tag:" + localObject2);
              }
              if (localObject2 != null)
              {
                paramResources = (Resources)localObject1;
                if (localObject2.getClass() == paramAbsStructMsg.getClass()) {}
              }
              else
              {
                paramResources = null;
              }
            }
          }
        }
        localRelativeLayout.removeAllViews();
        paramAbsStructMsg = paramAbsStructMsg.getSourceView(this.jdField_a_of_type_AndroidContentContext, paramResources);
        if (paramAbsStructMsg == null) {
          break;
        }
        localRelativeLayout.addView(paramAbsStructMsg);
        return;
        ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131230773);
        ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131230779);
      }
      paramBaseChatItemLayout.removeView(localRelativeLayout);
      paramStructingMsgViewHolder.b = null;
      return;
    }
  }
  
  private void a(IHttpCommunicatorListener paramIHttpCommunicatorListener, StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder)
  {
    if (paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    Object localObject;
    int i;
    if ((paramIHttpCommunicatorListener instanceof BaseTransProcessor))
    {
      localObject = (BaseTransProcessor)paramIHttpCommunicatorListener;
      i = (int)((BaseTransProcessor)localObject).c();
      if ((i != 1004) || (!((BaseTransProcessor)localObject).b()) || (!((BaseTransProcessor)localObject).c())) {
        break label416;
      }
      i = 1006;
    }
    label416:
    for (;;)
    {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131230767);
      ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131230767);
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131230767);
      ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131230767);
      if ((paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131230813) == null) && (paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView != null)) {
        paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView, (ViewGroup.LayoutParams)localObject);
      }
      switch (i)
      {
      default: 
        if (paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null) {
          break;
        }
        paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
        paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
        return;
      case 1000: 
      case 1001: 
      case 1002: 
      case 1006: 
      case 4001: 
        if (paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null)
        {
          MessageProgressTextView localMessageProgressTextView = new MessageProgressTextView(this.jdField_a_of_type_AndroidContentContext);
          localMessageProgressTextView.setTextColor(-1);
          localMessageProgressTextView.setTextSize(2, 15.0F);
          localMessageProgressTextView.setGravity(17);
          localMessageProgressTextView.setId(2131230813);
          localMessageProgressTextView.setBackgroundDrawable(new AIOSendMask(2130706432, this.jdField_a_of_type_Float * 12.0F));
          if (paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
            paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localMessageProgressTextView, (ViewGroup.LayoutParams)localObject);
          }
          paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = localMessageProgressTextView;
        }
        paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor((BaseTransProcessor)paramIHttpCommunicatorListener);
        paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
        switch (i)
        {
        }
        for (;;)
        {
          paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.a();
          return;
          paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(0);
          return;
          paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(0);
        }
        if (paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null) {
          break;
        }
        paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
        paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(4);
        return;
      }
    }
  }
  
  private boolean a(AbsStructMsg paramAbsStructMsg)
  {
    return 19 == paramAbsStructMsg.mMsgServiceID;
  }
  
  public static void d()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$ViewCache != null)
    {
      jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$ViewCache.a();
      jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$ViewCache = null;
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    paramChatMessage = (MessageForStructing)paramChatMessage;
    if ((paramChatMessage != null) && (paramChatMessage.structingMsg != null) && (paramChatMessage.structingMsg.hasFlag(4))) {
      return 0;
    }
    return 2;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramViewGroup = (StructingMsgItemBuilder.StructingMsgViewHolder)paramView.getTag();
    paramOnLongClickAndTouchListener = paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
    paramChatMessage = (MessageForStructing)paramChatMessage;
    AbsStructMsg localAbsStructMsg = paramChatMessage.structingMsg;
    if (localAbsStructMsg == null) {
      return paramView;
    }
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    a(paramViewGroup, paramOnLongClickAndTouchListener, localAbsStructMsg.hasFlag(4));
    a(paramViewGroup, paramOnLongClickAndTouchListener, paramChatMessage.isSend(), localAbsStructMsg, localResources);
    paramView.requestLayout();
    return paramView;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramViewHolder = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramViewHolder.setId(2131230779);
      paramViewHolder.setMinimumHeight(AIOUtils.a(44.0F, paramView));
      paramViewHolder.setClickable(true);
      paramViewHolder.setPadding(paramView.getDimensionPixelSize(2131427461), paramView.getDimensionPixelSize(2131427459), paramView.getDimensionPixelSize(2131427462), paramView.getDimensionPixelSize(2131427460));
      paramViewHolder.setBackgroundResource(2130837645);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      int i = AIOUtils.a(3.0F, paramView);
      ((RelativeLayout.LayoutParams)localObject).setMargins(i, 0, i, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131230940);
      paramViewHolder.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      if (!MessageForStructing.class.isInstance(paramChatMessage)) {}
      MessageForStructing localMessageForStructing;
      AbsStructMsg localAbsStructMsg;
      do
      {
        return paramViewHolder;
        localMessageForStructing = (MessageForStructing)paramChatMessage;
        localAbsStructMsg = localMessageForStructing.structingMsg;
        if (localAbsStructMsg != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      paramView = new StringBuilder().append("structMsg is null,msgdata:");
      if (localMessageForStructing == null) {
        paramChatMessage = "null";
      }
      for (;;)
      {
        QLog.d("structMsg", 2, paramChatMessage);
        return paramViewHolder;
        if (localMessageForStructing.msgData == null) {
          paramChatMessage = "null";
        } else {
          paramChatMessage = Integer.valueOf(localMessageForStructing.msgData.length);
        }
      }
      localAbsStructMsg.uniseq = localMessageForStructing.uniseq;
      localAbsStructMsg.uin = localMessageForStructing.frienduin;
      localAbsStructMsg.uinType = localMessageForStructing.istroop;
      localAbsStructMsg.currentAccountUin = localMessageForStructing.selfuin;
      localAbsStructMsg.messageVersion = localMessageForStructing.versionCode;
      if (StructMsgForImageShare.class.isInstance(localAbsStructMsg))
      {
        paramChatMessage = (StructMsgForImageShare)localAbsStructMsg;
        paramChatMessage.mIsSend = localMessageForStructing.issend;
        paramChatMessage.mUniseq = localMessageForStructing.uniseq;
        paramChatMessage.mMsgType = localMessageForStructing.msgtype;
      }
      paramBaseChatItemLayout.setAddStatesFromChildren(false);
      paramChatMessage = paramBaseChatItemLayout.getTag();
      if (paramChatMessage != null) {}
      for (paramChatMessage = (StructingMsgItemBuilder.StructingMsgViewHolder)paramChatMessage;; paramChatMessage = null)
      {
        if (paramChatMessage == null) {}
        for (paramView = new StructingMsgItemBuilder.StructingMsgViewHolder();; paramView = paramChatMessage)
        {
          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
          paramChatMessage = paramView.jdField_a_of_type_AndroidWidgetRelativeLayout;
          localObject = paramChatMessage;
          if (paramChatMessage == null)
          {
            localObject = (RelativeLayout)paramViewHolder;
            paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject);
          }
          paramViewHolder.setTag(paramView);
          String str;
          if ((localAbsStructMsg instanceof StructMsgForGeneralShare))
          {
            str = ((StructMsgForGeneralShare)localAbsStructMsg).getLayoutStr();
            paramChatMessage = a().a(str, (ViewGroup)paramViewHolder);
            if (paramChatMessage != null)
            {
              paramChatMessage = localAbsStructMsg.getView(this.jdField_a_of_type_AndroidContentContext, paramChatMessage, paramOnLongClickAndTouchListener);
              label447:
              paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
              paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
              if (!(localAbsStructMsg instanceof AbsShareMsg)) {
                break label705;
              }
              paramViewHolder.setOnClickListener(((AbsShareMsg)localAbsStructMsg).getOnClickListener());
              if (!StructMsgForImageShare.class.isInstance(localAbsStructMsg)) {
                break label675;
              }
              FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBaseChatItemLayout, this);
            }
          }
          for (;;)
          {
            ((RelativeLayout)localObject).addView(paramChatMessage);
            if (!localMessageForStructing.isSendFromLocal()) {
              break;
            }
            paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForStructing.frienduin, localMessageForStructing.uniseq);
            paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject);
            a(paramChatMessage, paramView);
            return paramViewHolder;
            paramChatMessage = localAbsStructMsg.getView(this.jdField_a_of_type_AndroidContentContext, null, paramOnLongClickAndTouchListener);
            a().a(str, paramChatMessage, (ViewGroup)paramViewHolder);
            break label447;
            if (((RelativeLayout)localObject).getChildCount() > 0)
            {
              paramChatMessage = ((RelativeLayout)localObject).getChildAt(0);
              if (paramChatMessage != null)
              {
                paramChatMessage = paramChatMessage.getTag(2131230767);
                if (QLog.isColorLevel()) {
                  QLog.d("structMsg", 2, "bindviwfor structmsg tag:" + paramChatMessage);
                }
                if ((paramChatMessage == null) || (paramChatMessage.getClass() == localAbsStructMsg.getClass())) {}
              }
            }
            ((RelativeLayout)localObject).removeAllViews();
            paramChatMessage = localAbsStructMsg.getView(this.jdField_a_of_type_AndroidContentContext, null, paramOnLongClickAndTouchListener);
            break label447;
            label675:
            if ((StructMsgForGeneralShare.class.isInstance(localAbsStructMsg)) && (a(localAbsStructMsg)))
            {
              a(paramBaseChatItemLayout, localMessageForStructing);
              continue;
              label705:
              if (localAbsStructMsg.mMsgServiceID == 3) {
                paramViewHolder.setClickable(true);
              }
            }
          }
        }
      }
      paramViewHolder = paramView;
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new StructingMsgItemBuilder.StructingMsgViewHolder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    AbsStructMsg localAbsStructMsg = ((MessageForStructing)paramChatMessage).structingMsg;
    if (localAbsStructMsg != null) {
      if ((localAbsStructMsg instanceof AbsShareMsg))
      {
        paramChatMessage = (AbsShareMsg)localAbsStructMsg;
        if ((paramChatMessage.mContentTitle != null) && (paramChatMessage.mContentTitle.trim().length() > 0))
        {
          paramChatMessage = "" + paramChatMessage.mContentTitle;
          localObject = paramChatMessage;
          if (localAbsStructMsg.mMsgBrief != null)
          {
            localObject = paramChatMessage;
            if (localAbsStructMsg.mMsgBrief.trim().length() <= 0) {}
          }
        }
      }
    }
    for (Object localObject = paramChatMessage + localAbsStructMsg.mMsgBrief;; localObject = "")
    {
      return this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558910, new Object[] { localObject });
      paramChatMessage = "";
      break;
    }
  }
  
  @SuppressLint({"NewApi"})
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (paramInt == 2131231190) {
      if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForStructing)))
      {
        localObject2 = (MessageForStructing)paramChatMessage;
        if (((MessageForStructing)localObject2).structingMsg != null)
        {
          if (!(((MessageForStructing)localObject2).structingMsg instanceof StructMsgForImageShare)) {
            break label248;
          }
          paramChatMessage = (StructMsgForImageShare)((MessageForStructing)localObject2).structingMsg;
          localObject3 = paramChatMessage.getFirstImageElement();
          if (localObject3 == null) {
            break label357;
          }
          if (((StructMsgItemImage)localObject3).a == null) {
            ((StructMsgItemImage)localObject3).a = paramChatMessage;
          }
          paramChatMessage = ((StructMsgItemImage)localObject3).a();
          localObject4 = ForwardUtils.a(this.jdField_a_of_type_AndroidContentContext, paramChatMessage);
          if (!new File(paramChatMessage.path).exists()) {
            break label147;
          }
          ((StructMsgItemImage)localObject3).h = paramChatMessage.path;
          if (!TextUtils.isEmpty(((StructMsgItemImage)localObject3).h)) {
            break label229;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "StructingMsgItemBuilder onMenuItemClicked forward imageElement.mShareImageUrl is null!!!");
          }
        }
      }
    }
    label147:
    Object localObject1;
    Object localObject5;
    label229:
    label248:
    AbsShareMsg localAbsShareMsg;
    label357:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject1 = null;
            localObject5 = ((URLDrawable)localObject4).getURL().toString();
            if (AbsDownloader.a((String)localObject5)) {
              paramChatMessage = AbsDownloader.a((String)localObject5).getAbsolutePath();
            }
            for (;;)
            {
              ((StructMsgItemImage)localObject3).h = paramChatMessage;
              break;
              localObject5 = AbsDownloader.a(URLDrawableHelper.a(paramChatMessage, 65537).toString());
              paramChatMessage = localObject1;
              if (localObject5 != null)
              {
                paramChatMessage = localObject1;
                if (((File)localObject5).exists()) {
                  paramChatMessage = ((File)localObject5).getAbsolutePath();
                }
              }
            }
            if (!AbsDownloader.a(((URLDrawable)localObject4).getURL().toString())) {
              ((URLDrawable)localObject4).startDownload();
            }
            paramChatMessage = new Bundle();
            paramChatMessage.putInt("forward_type", -3);
            ((MessageForStructing)localObject2).structingMsg.mCommentText = null;
            paramChatMessage.putByteArray("stuctmsg_bytes", ((MessageForStructing)localObject2).structingMsg.getBytes());
            paramContext = new Intent(paramContext, ForwardRecentActivity.class);
            paramContext.putExtras(paramChatMessage);
            ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramContext, 21);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
            return;
          } while (!QLog.isColorLevel());
          QLog.d(jdField_a_of_type_JavaLangString, 2, "StructingMsgItemBuilder onMenuItemClicked forward imageElement is null!!!");
          return;
          if (paramInt == 2131234872)
          {
            ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
            return;
          }
          if (paramInt != 2131231192) {
            break label967;
          }
        } while ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing)));
        paramContext = (MessageForStructing)paramChatMessage;
      } while (paramContext.structingMsg == null);
      localAbsShareMsg = (AbsShareMsg)paramContext.structingMsg;
      if (!(localAbsShareMsg instanceof StructMsgForImageShare)) {
        break label518;
      }
      paramContext = QfavUtil.a((StructMsgForImageShare)localAbsShareMsg);
    } while (paramContext == null);
    QfavBuilder.a(paramContext.j, localAbsShareMsg.uinType, paramContext.i, paramContext.b, paramContext.h, paramContext.c).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 3);
    return;
    label518:
    int i;
    if (!TextUtils.isEmpty(localAbsShareMsg.mMsgActionData))
    {
      String[] arrayOfString1 = localAbsShareMsg.mMsgActionData.split("&");
      i = arrayOfString1.length;
      localObject3 = null;
      localObject2 = null;
      localObject1 = null;
      paramContext = null;
      paramInt = 0;
      if (paramInt < i)
      {
        String[] arrayOfString2 = arrayOfString1[paramInt].split("=");
        localObject4 = localObject3;
        localObject5 = localObject2;
        Object localObject6 = localObject1;
        Object localObject7 = paramContext;
        if (arrayOfString2.length > 1)
        {
          if (!arrayOfString2[0].trim().equals("lat")) {
            break label656;
          }
          localObject7 = arrayOfString2[1];
          localObject6 = localObject1;
          localObject5 = localObject2;
          localObject4 = localObject3;
        }
        for (;;)
        {
          paramInt += 1;
          localObject3 = localObject4;
          localObject2 = localObject5;
          localObject1 = localObject6;
          paramContext = (Context)localObject7;
          break;
          label656:
          if (arrayOfString2[0].trim().equals("lon"))
          {
            localObject6 = arrayOfString2[1];
            localObject4 = localObject3;
            localObject5 = localObject2;
            localObject7 = paramContext;
          }
          else if (arrayOfString2[0].trim().equals("loc"))
          {
            localObject5 = arrayOfString2[1];
            localObject4 = localObject3;
            localObject6 = localObject1;
            localObject7 = paramContext;
          }
          else
          {
            localObject4 = localObject3;
            localObject5 = localObject2;
            localObject6 = localObject1;
            localObject7 = paramContext;
            if (arrayOfString2[0].trim().equals("title"))
            {
              localObject4 = arrayOfString2[1];
              localObject5 = localObject2;
              localObject6 = localObject1;
              localObject7 = paramContext;
            }
          }
        }
      }
      if ((localAbsShareMsg.mMsgServiceID == 32) && (!TextUtils.isEmpty(paramContext)) && (!TextUtils.isEmpty(localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        QfavBuilder.a(Float.valueOf(paramContext).floatValue(), Float.valueOf(localObject1).floatValue(), (String)localObject3, (String)localObject2, null).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 7);
        return;
      }
    }
    paramContext = QfavUtil.a(localAbsShareMsg.getXmlBytes());
    if ((localAbsShareMsg instanceof StructMsgForAudioShare)) {
      i = 10;
    }
    for (paramInt = 2;; paramInt = 0)
    {
      QfavBuilder.a(paramInt, localAbsShareMsg.mContentTitle, localAbsShareMsg.mMsgUrl, localAbsShareMsg.mSourceName, localAbsShareMsg.mContentSummary, localAbsShareMsg.mContentCover, localAbsShareMsg.mContentSrc, paramContext).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, i);
      return;
      label967:
      if (paramInt != 2131234877) {
        break;
      }
      paramContext = (MessageForStructing)paramChatMessage;
      if ((paramContext == null) || (paramContext.structingMsg == null) || (!"web".equals(paramContext.structingMsg.mMsgAction)) || (paramContext.structingMsg.mMsgUrl == null)) {
        break;
      }
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramContext.structingMsg.mMsgUrl);
      return;
      i = 2;
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    Object localObject1 = AIOUtils.a(paramView);
    if (!StructingMsgItemBuilder.StructingMsgViewHolder.class.isInstance(localObject1)) {}
    Context localContext;
    Object localObject2;
    do
    {
      return;
      localContext = this.jdField_a_of_type_AndroidContentContext;
      localObject1 = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      localObject2 = a((ChatMessage)localObject1);
      if (localObject2 != null)
      {
        a(paramView, (StructMsgForGeneralShare)localObject2);
        return;
      }
      paramView = localContext.getString(2131562859);
      localObject2 = localContext.getString(2131561439);
    } while (!((ChatMessage)localObject1).isSendFromLocal());
    DialogUtil.a(localContext, 230, paramView, (String)localObject2, new efv(this, localContext, (ChatMessage)localObject1), new efw(this)).show();
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (!BaseChatItemLayout.class.isInstance(paramView)) {}
    label9:
    do
    {
      ChatMessage localChatMessage;
      do
      {
        do
        {
          do
          {
            break label9;
            break label9;
            do
            {
              return;
            } while (paramFileMsg.e != 1);
            paramView = AIOUtils.a(paramView);
          } while (!StructingMsgItemBuilder.StructingMsgViewHolder.class.isInstance(paramView));
          paramView = (StructingMsgItemBuilder.StructingMsgViewHolder)paramView;
        } while ((!StructingMsgItemBuilder.StructingMsgViewHolder.class.isInstance(paramView)) || (paramView.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (!MessageForStructing.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage)));
        localChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      } while ((localChatMessage.uniseq != paramFileMsg.c) || (!localChatMessage.isSendFromLocal()));
      if (QLog.isColorLevel()) {
        QLog.d("structMsg", 2, "handleMessage status = " + paramInt1 + ", retCode = " + paramInt2 + ", message.uniseq = " + localChatMessage.uniseq + ", file.uniseq = " + paramFileMsg.c);
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localChatMessage.frienduin, localChatMessage.uniseq), paramView);
    } while (paramInt1 != 1005);
    a();
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Object localObject = (MessageForStructing)paramChatMessage;
    if ((((MessageForStructing)localObject).structingMsg != null) && (StructMsgForImageShare.class.isInstance(((MessageForStructing)localObject).structingMsg)) && (paramChatMessage.isSendFromLocal()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
      if ((localObject instanceof MessageForStructing))
      {
        localObject = ((StructMsgForImageShare)((MessageForStructing)localObject).structingMsg).getFirstImageElement();
        if ((localObject != null) && (((StructMsgItemImage)localObject).c <= 0L))
        {
          paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
          if ((paramChatMessage instanceof BaseTransProcessor)) {
            return ((BaseTransProcessor)paramChatMessage).c() == 1005L;
          }
          return true;
        }
      }
    }
    return super.a(paramChatMessage, paramBaseChatItemLayout);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    Object localObject = (MessageForStructing)AIOUtils.a(paramView);
    paramView = new QQCustomMenu();
    localObject = ((MessageForStructing)localObject).structingMsg;
    if (localObject != null)
    {
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (((AbsStructMsg)localObject).fwFlag != 1)
      {
        if (((AbsStructMsg)localObject).hasFlag(8)) {
          paramView.a(2131234877, localResources.getString(2131561883));
        }
        if (!((AbsStructMsg)localObject).hasFlag(1)) {
          paramView.a(2131231190, localResources.getString(2131562129));
        }
        if (!((AbsStructMsg)localObject).hasFlag(2)) {
          paramView.a(2131231192, localResources.getString(2131560772));
        }
      }
    }
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    return paramView.a();
  }
  
  protected void b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    AbsStructMsg localAbsStructMsg = ((MessageForStructing)paramChatMessage).structingMsg;
    if ((localAbsStructMsg != null) && (StructMsgForImageShare.class.isInstance(localAbsStructMsg)))
    {
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramChatMessage != null) && (BaseTransProcessor.class.isInstance(paramChatMessage)))
      {
        a(paramBaseChatItemLayout, ((BaseTransProcessor)paramChatMessage).a(), 0, 0);
        return;
      }
      paramBaseChatItemLayout.setProgressVisable(false);
      return;
    }
    super.b(paramChatMessage, paramBaseChatItemLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */