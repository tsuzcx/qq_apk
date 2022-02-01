package com.tencent.mobileqq.activity.messagesearch;

import acff;
import android.text.TextUtils;
import anqu;
import anqv;
import aqgv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class C2CLinkElement
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String iconUrl;
  public int isSend;
  public int mPos;
  public long msgSeq;
  public String nickname;
  public String sendUin;
  public long time;
  public String timeSecond = "0";
  public String title;
  public String uin;
  public String url;
  
  public static String getStructMsgInfo(AbsShareMsg paramAbsShareMsg, String paramString)
  {
    Object localObject1;
    Object localObject2;
    if (paramString.equals("cover"))
    {
      localObject1 = paramAbsShareMsg.mContentCover;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if ((paramAbsShareMsg instanceof StructMsgForGeneralShare))
        {
          paramAbsShareMsg = (StructMsgForGeneralShare)paramAbsShareMsg;
          localObject2 = localObject1;
          if (paramAbsShareMsg.mStructMsgItemLists != null)
          {
            localObject2 = localObject1;
            if (!paramAbsShareMsg.mStructMsgItemLists.isEmpty())
            {
              Iterator localIterator = paramAbsShareMsg.mStructMsgItemLists.iterator();
              paramAbsShareMsg = (AbsShareMsg)localObject1;
              if (!localIterator.hasNext()) {
                return paramAbsShareMsg;
              }
              localObject2 = (anqu)localIterator.next();
              if (!(localObject2 instanceof anqv)) {
                break label214;
              }
              localObject1 = paramAbsShareMsg;
              if (((anqv)localObject2).rz == null) {
                break label248;
              }
              localObject1 = paramAbsShareMsg;
              if (((anqv)localObject2).rz.isEmpty()) {
                break label248;
              }
              localObject2 = ((anqv)localObject2).rz.iterator();
              localObject1 = paramAbsShareMsg;
              label176:
              do
              {
                paramAbsShareMsg = (AbsShareMsg)localObject1;
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                paramAbsShareMsg = (anqu)((Iterator)localObject2).next();
                if (!paramString.equals("cover")) {
                  break label206;
                }
                paramAbsShareMsg = StructMsgForGeneralShare.getCoverForChatHistory(paramAbsShareMsg);
                localObject1 = paramAbsShareMsg;
              } while (TextUtils.isEmpty(paramAbsShareMsg));
              localObject1 = paramAbsShareMsg;
              if (TextUtils.isEmpty(paramAbsShareMsg)) {
                break label248;
              }
              localObject2 = paramAbsShareMsg;
            }
          }
        }
      }
    }
    label206:
    label214:
    label228:
    do
    {
      return localObject2;
      localObject1 = paramAbsShareMsg.mContentTitle;
      break;
      paramAbsShareMsg = StructMsgForGeneralShare.getTitleForChatHistory(paramAbsShareMsg);
      break label176;
      if (!paramString.equals("cover")) {
        break label240;
      }
      paramAbsShareMsg = StructMsgForGeneralShare.getCoverForChatHistory((anqu)localObject2);
      localObject2 = paramAbsShareMsg;
    } while (!TextUtils.isEmpty(paramAbsShareMsg));
    for (;;)
    {
      break;
      label240:
      paramAbsShareMsg = StructMsgForGeneralShare.getTitleForChatHistory((anqu)localObject2);
      break label228;
      label248:
      paramAbsShareMsg = (AbsShareMsg)localObject1;
    }
    return paramAbsShareMsg;
  }
  
  public static C2CLinkElement parseFrom(QQAppInterface paramQQAppInterface, Object paramObject, acff paramacff, SimpleDateFormat paramSimpleDateFormat, int paramInt)
  {
    AbsShareMsg localAbsShareMsg = null;
    paramacff = localAbsShareMsg;
    if ((paramObject instanceof MessageForStructing))
    {
      paramObject = (MessageForStructing)paramObject;
      paramacff = localAbsShareMsg;
      if (paramObject.structingMsg != null)
      {
        paramacff = localAbsShareMsg;
        if ((paramObject.structingMsg instanceof AbsShareMsg))
        {
          localAbsShareMsg = (AbsShareMsg)paramObject.structingMsg;
          paramacff = new C2CLinkElement();
          paramacff.uin = paramObject.frienduin;
          paramacff.title = getStructMsgInfo(localAbsShareMsg, "title");
          paramacff.iconUrl = getStructMsgInfo(localAbsShareMsg, "cover");
          paramacff.nickname = aqgv.s(paramQQAppInterface, paramObject.senderuin);
          paramacff.time = paramObject.time;
          paramacff.timeSecond = paramSimpleDateFormat.format(new Date(paramObject.time * 1000L));
          paramacff.mPos = paramInt;
          paramacff.msgSeq = paramObject.shmsgseq;
          paramacff.sendUin = paramObject.senderuin;
          paramacff.isSend = paramObject.issend;
          paramacff.url = localAbsShareMsg.mMsgUrl;
        }
      }
    }
    return paramacff;
  }
  
  public String description()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.title).append('\n');
    localStringBuilder.append(this.uin).append('\n');
    localStringBuilder.append(this.nickname).append('\n');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CLinkElement
 * JD-Core Version:    0.7.0.1
 */