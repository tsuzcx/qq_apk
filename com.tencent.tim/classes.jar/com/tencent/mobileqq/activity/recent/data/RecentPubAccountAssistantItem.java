package com.tencent.mobileqq.activity.recent.data;

import acja;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.PubAccountAssistantData;
import com.tencent.mobileqq.data.PublicAccountInfo;
import java.util.ArrayList;
import java.util.List;
import tog;
import wna;

public class RecentPubAccountAssistantItem
  extends RecentBaseData
{
  private PubAccountAssistantData mData;
  
  public RecentPubAccountAssistantItem(PubAccountAssistantData paramPubAccountAssistantData)
    throws NullPointerException
  {
    if (paramPubAccountAssistantData == null) {
      throw new NullPointerException("PubAccountAssistantData is null");
    }
    this.mData = paramPubAccountAssistantData;
    this.mUnreadFlag = 3;
  }
  
  public boolean Gq()
  {
    return false;
  }
  
  public void c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    String str = null;
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    Object localObject3 = qx();
    int i = ng();
    Object localObject1 = paramQQAppInterface.b();
    if (localObject1 != null) {}
    for (QQMessageFacade.Message localMessage = ((QQMessageFacade)localObject1).a((String)localObject3, i);; localMessage = null)
    {
      Object localObject2;
      if (localMessage != null)
      {
        this.mDisplayTime = localMessage.time;
        localObject1 = paramQQAppInterface.a();
        if (localObject1 != null)
        {
          this.mUnreadNum = ((tog)localObject1).A(localMessage.frienduin, localMessage.istroop);
          localObject1 = (acja)paramQQAppInterface.getManager(56);
          if (localObject1 == null) {
            break label606;
          }
          localObject2 = ((acja)localObject1).b((String)localObject3);
          if (localObject2 == null) {
            break label606;
          }
          localObject1 = ((PublicAccountInfo)localObject2).name;
          str = ((PublicAccountInfo)localObject2).summary;
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = localObject3;
        }
        this.mTitleName = ((String)localObject2);
        localObject2 = a();
        if (localMessage != null)
        {
          int j = localMessage.msgtype;
          if ((j != -3006) && (j != -5004)) {
            a(localMessage, i, paramQQAppInterface, paramContext, (MsgSummary)localObject2);
          }
        }
        else
        {
          label196:
          if ((TextUtils.isEmpty(((MsgSummary)localObject2).strContent)) && (TextUtils.isEmpty(((MsgSummary)localObject2).suffix)))
          {
            if (str != null) {
              break label538;
            }
            str = "";
            label227:
            ((MsgSummary)localObject2).strContent = str;
          }
          bI(paramQQAppInterface);
          a(paramQQAppInterface, (MsgSummary)localObject2);
          a(paramQQAppInterface, paramContext, (MsgSummary)localObject2);
          if (!AppSetting.enableTalkBack) {
            break;
          }
          paramQQAppInterface = new StringBuilder(24);
          paramQQAppInterface.append(this.mTitleName);
          if (this.mUnreadNum != 0) {
            break label541;
          }
        }
        for (;;)
        {
          if (this.mMsgExtroInfo != null) {
            paramQQAppInterface.append(this.mMsgExtroInfo + ",");
          }
          paramQQAppInterface.append(this.mLastMsg).append(' ').append(this.mShowTime);
          this.mContentDesc = paramQQAppInterface.toString();
          return;
          this.mUnreadNum = 0;
          break;
          this.mDisplayTime = 0L;
          this.mUnreadNum = 0;
          break;
          ((MsgSummary)localObject2).strContent = "";
          localObject3 = wna.a(localMessage);
          if ((localObject3 == null) || (((PAMessage)localObject3).items == null) || (((PAMessage)localObject3).items.size() == 0))
          {
            a(localMessage, i, paramQQAppInterface, paramContext, (MsgSummary)localObject2);
            break label196;
          }
          localObject1 = ((PAMessage.Item)((PAMessage)localObject3).items.get(0)).title;
          if ((((PAMessage.Item)((PAMessage)localObject3).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject3).items.get(0)).digestList != null)) {
            localObject1 = (String)localObject1 + "：" + (String)((PAMessage.Item)((PAMessage)localObject3).items.get(0)).digestList.get(0);
          }
          for (;;)
          {
            ((MsgSummary)localObject2).strContent = ((CharSequence)localObject1);
            break;
          }
          label538:
          break label227;
          label541:
          if (this.mUnreadNum == 1) {
            paramQQAppInterface.append("有一条未读");
          } else if (this.mUnreadNum == 2) {
            paramQQAppInterface.append("有两条未读");
          } else if (this.mUnreadNum > 0) {
            paramQQAppInterface.append("有").append(this.mUnreadNum).append("条未读");
          }
        }
        label606:
        localObject1 = null;
      }
    }
  }
  
  public long eI()
  {
    return this.mData.mLastMsgTime;
  }
  
  public long eJ()
  {
    return this.mData.mLastDraftTime;
  }
  
  public int ng()
  {
    return this.mData.mType;
  }
  
  public String qx()
  {
    return this.mData.mUin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentPubAccountAssistantItem
 * JD-Core Version:    0.7.0.1
 */