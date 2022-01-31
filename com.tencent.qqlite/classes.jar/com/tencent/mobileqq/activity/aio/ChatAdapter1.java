package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import bsw;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ItemBuilderFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qqlite.data.MarkFaceMessage;
import com.tencent.widget.MenuPopupDialog;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;
import java.util.List;

public class ChatAdapter1
  extends XBaseAdapter
{
  @Deprecated
  public static long a;
  @Deprecated
  public static String a;
  private Context jdField_a_of_type_AndroidContentContext;
  bsw jdField_a_of_type_Bsw = new bsw(this, null);
  AIOTimeReporter jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  public ItemBuilderFactory a;
  public QQAppInterface a;
  public Boolean a;
  CharSequence jdField_a_of_type_JavaLangCharSequence = null;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  static
  {
    jdField_a_of_type_Long = -1L;
  }
  
  public ChatAdapter1(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory = new ItemBuilderFactory(paramContext, paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public ChatAdapter1(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, AIOTimeReporter paramAIOTimeReporter, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory = new ItemBuilderFactory(paramContext, paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter = paramAIOTimeReporter;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return this.jdField_a_of_type_JavaUtilList.indexOf(paramChatMessage);
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a();
    }
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramChatMessage);
    if (i >= 0)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramChatMessage);
      b(i, i);
    }
  }
  
  public void a(List paramList)
  {
    ChatMessage localChatMessage;
    int i;
    int j;
    if (paramList.size() > 0)
    {
      localChatMessage = (ChatMessage)paramList.get(paramList.size() - 1);
      i = 1;
      for (;;)
      {
        if ((localChatMessage instanceof MessageForGrayTips))
        {
          i += 1;
          if (paramList.size() - i >= 0)
          {
            localChatMessage = (ChatMessage)paramList.get(paramList.size() - i);
          }
          else
          {
            j = 0;
            if ((localChatMessage instanceof MessageForMarketFace)) {
              break;
            }
          }
        }
      }
    }
    label407:
    label413:
    label431:
    for (;;)
    {
      label85:
      return;
      int k = i + 1;
      Object localObject1;
      Object localObject2;
      if (paramList.size() - k >= 0)
      {
        for (localObject1 = (ChatMessage)paramList.get(paramList.size() - k);; localObject1 = (ChatMessage)paramList.get(paramList.size() - k))
        {
          localObject2 = localObject1;
          i = j;
          if (!(localObject1 instanceof MessageForGrayTips)) {
            break label184;
          }
          k += 1;
          if (paramList.size() - k < 0) {
            break;
          }
        }
        i = 0;
        localObject2 = localObject1;
        label184:
        if (!(localObject2 instanceof MessageForMarketFace)) {
          break label407;
        }
        paramList = (List)localObject2;
      }
      for (;;)
      {
        if ((i == 0) || (localChatMessage == null) || (paramList == null)) {
          break label431;
        }
        localChatMessage.isMarketFaceFlow = false;
        paramList.isMarketFaceFlow = false;
        if ((localChatMessage.istroop != 1) && (localChatMessage.istroop != 3000)) {
          break label85;
        }
        localObject1 = ((MessageForMarketFace)localChatMessage).mMarkFaceMessage;
        localObject2 = ((MessageForMarketFace)paramList).mMarkFaceMessage;
        if (localObject1 == null)
        {
          localChatMessage.parse();
          localObject1 = ((MessageForMarketFace)localChatMessage).mMarkFaceMessage;
        }
        for (;;)
        {
          if (localObject2 == null) {
            paramList.parse();
          }
          for (paramList = ((MessageForMarketFace)paramList).mMarkFaceMessage;; paramList = (List)localObject2)
          {
            if ((localObject1 == null) || (paramList == null) || (((MarkFaceMessage)localObject1).dwTabID != paramList.dwTabID) || (!EmosmUtils.bytes2eId(((MarkFaceMessage)localObject1).sbufID, ((MarkFaceMessage)localObject1).mediaType).equals(EmosmUtils.bytes2eId(paramList.sbufID, paramList.mediaType)))) {
              break label413;
            }
            localChatMessage.isMarketFaceFlow = true;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_show_follow", 0, 0, "", ((MarkFaceMessage)localObject1).dwTabID + "", "", "");
            return;
            localObject2 = null;
            i = 0;
            break label184;
            break;
          }
          break;
        }
        j = 1;
        break;
        paramList = null;
        localChatMessage = null;
        i = 1;
      }
    }
  }
  
  public void a(List paramList, CharSequence paramCharSequence)
  {
    int i = 0;
    Object localObject = null;
    ChatMessage localChatMessage;
    if (i < paramList.size())
    {
      localChatMessage = (ChatMessage)paramList.get(i);
      if (((localObject == null) || (localChatMessage.time - localObject.time > 180L)) && (MessageUtils.b(localChatMessage.msgtype))) {}
      for (localChatMessage.mNeedTimeStamp = true;; localChatMessage.mNeedTimeStamp = false)
      {
        if (i != paramList.size() - 1) {
          localChatMessage.isMarketFaceFlow = false;
        }
        i += 1;
        localObject = localChatMessage;
        break;
      }
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()) && (paramCharSequence != null))
    {
      localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(0);
      localChatMessage.mNeedGrayTips = true;
      localChatMessage.mMessageSource = paramCharSequence;
    }
    if ((localObject != null) && (!localObject.isMarketFaceFlow)) {
      a(paramList);
    }
    super.notifyDataSetChanged();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bsw.a != null) {
      this.jdField_a_of_type_Bsw.a.dismiss();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return ((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt)).uniseq;
  }
  
  public int getItemViewType(int paramInt)
  {
    ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localChatMessage != null) {
      localChatMessage.parse();
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(localChatMessage);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    long l1 = System.currentTimeMillis();
    StartupTracker.a(null, "AIO_ChatAdapter_getView");
    ChatMessage localChatMessage1 = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    StartupTracker.a(null, "AIO_ChatAdapter_itemBuilder");
    ChatItemBuilder localChatItemBuilder = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(localChatMessage1, this);
    StartupTracker.a("AIO_ChatAdapter_itemBuilder", null);
    if (paramInt != 0)
    {
      ChatMessage localChatMessage2 = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
      if ((localChatMessage2 != null) && ((localChatMessage2 instanceof MessageForTroopUnreadTips))) {
        localChatMessage1.mNeedTimeStamp = true;
      }
    }
    paramView = localChatItemBuilder.a(paramInt, this.jdField_a_of_type_JavaUtilList.size(), localChatMessage1, paramView, paramViewGroup, this.jdField_a_of_type_Bsw);
    if (paramView != null) {
      paramView.setTag(2131296295, localChatMessage1);
    }
    long l2 = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(localChatMessage1), l2 - l1);
    }
    StartupTracker.a("AIO_ChatAdapter_getView", null);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 29;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ChatAdapter1
 * JD-Core Version:    0.7.0.1
 */