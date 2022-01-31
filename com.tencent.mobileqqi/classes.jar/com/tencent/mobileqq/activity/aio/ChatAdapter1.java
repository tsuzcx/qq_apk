package com.tencent.mobileqq.activity.aio;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ItemBuilderFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.international.LocaleString;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XBaseAdapter;
import dvo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatAdapter1
  extends XBaseAdapter
{
  @Deprecated
  public static long a;
  @Deprecated
  public static String a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Context jdField_a_of_type_AndroidContentContext;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  public ItemBuilderFactory a;
  public QQAppInterface a;
  dvo jdField_a_of_type_Dvo = new dvo(this, null);
  CharSequence jdField_a_of_type_JavaLangCharSequence = null;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  static
  {
    jdField_a_of_type_Long = -1L;
  }
  
  public ChatAdapter1(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory = new ItemBuilderFactory(paramContext, paramQQAppInterface, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
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
    notifyDataSetChanged();
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
    if (localChatMessage != null)
    {
      localChatMessage.parse();
      if (!(localChatMessage instanceof MessageForQzoneFeed)) {
        break label218;
      }
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        Object localObject1 = new JSONObject(((MessageForQzoneFeed)localChatMessage).msg);
        String str1 = ((JSONObject)localObject1).optString("summery");
        String str2 = ((JSONObject)localObject1).optString("content");
        if (str1.equals("上传了照片"))
        {
          str2 = str2.substring(str2.indexOf("《"), str2.indexOf("》") + 1);
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131563329) + ((JSONObject)localObject1).optInt("imageCount") + this.jdField_a_of_type_AndroidContentContext.getString(2131563330) + str2;
          ((MessageForQzoneFeed)localChatMessage).summery = LocaleString.i(this.jdField_a_of_type_AndroidContentContext, str1);
          ((MessageForQzoneFeed)localChatMessage).content = ((String)localObject1);
        }
        return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(localChatMessage);
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOQzoneFeed", 2, "convert msg to json failed,error msg is:" + localJSONException.getMessage(), localJSONException);
        }
        localObject2 = null;
        continue;
      }
      label218:
      if (((localChatMessage instanceof MessageForStructing)) && ((((MessageForStructing)localChatMessage).structingMsg instanceof StructMsgForGeneralShare)))
      {
        localObject2 = (StructMsgForGeneralShare)((MessageForStructing)localChatMessage).structingMsg;
        if (localObject2 != null)
        {
          localObject2 = ((StructMsgForGeneralShare)localObject2).mSourceName;
          if ((localObject2 != null) && (((String)localObject2).equals("QQ空间"))) {
            ((StructMsgForGeneralShare)((MessageForStructing)localChatMessage).structingMsg).mSourceName = LocaleString.i(this.jdField_a_of_type_AndroidContentContext, (String)localObject2);
          }
        }
      }
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
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
    paramView = localChatItemBuilder.a(paramInt, this.jdField_a_of_type_JavaUtilList.size(), localChatMessage1, paramView, paramViewGroup, this.jdField_a_of_type_Dvo);
    paramView.setTag(2131230770, localChatMessage1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ChatAdapter1
 * JD-Core Version:    0.7.0.1
 */