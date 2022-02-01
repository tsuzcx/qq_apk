package com.tencent.mobileqq.activity.recent.data;

import acbn;
import acfp;
import aeha;
import android.content.Context;
import android.text.TextUtils;
import aqgv;
import aqiu;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Locale;
import tog;

public class RecentItemConfessMsg
  extends RecentBaseData
{
  public final ConfessInfo mConfessInfo = new ConfessInfo();
  public MessageRecord mMsg;
  public int mType;
  public String mUin = "";
  public QQMessageFacade.Message msg;
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, MessageRecord paramMessageRecord)
  {
    this.mMsg = paramMessageRecord;
    if (this.mMsg == null)
    {
      this.mConfessInfo.reset();
      this.mUin = "";
      this.mType = 0;
      return;
    }
    if ((this.mMsg.istroop == 1032) && (TextUtils.equals(this.mMsg.frienduin, acbn.blL)))
    {
      this.mUin = acbn.blL;
      this.mType = 1032;
      return;
    }
    paramMessageRecord = this.mMsg.getExtInfoFromExtStr("ext_key_confess_info");
    this.mConfessInfo.parseFromJsonStr(paramMessageRecord);
    this.mUin = this.mMsg.senderuin;
    if (TextUtils.equals(this.mConfessInfo.confessorUinStr, paramString)) {}
    for (this.mType = 1033;; this.mType = 1034)
    {
      if (TextUtils.isEmpty(this.mMsg.selfuin)) {
        this.mMsg.selfuin = paramString;
      }
      if (this.msg == null) {
        this.msg = new QQMessageFacade.Message();
      }
      MessageRecord.copyMessageRecordBaseField(this.msg, this.mMsg);
      this.msg.istroop = this.mType;
      this.msg.frienduin = this.mUin;
      this.msg.emoRecentMsg = null;
      this.msg.fileType = -1;
      paramQQAppInterface.b().b(this.msg);
      return;
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    Object localObject2;
    Object localObject1;
    do
    {
      return;
      if ((this.mType == 1032) && (TextUtils.equals(this.mUin, acbn.blL)))
      {
        localObject2 = a();
        str = aqgv.b(paramQQAppInterface, this.mMsg.senderuin, true);
        localObject1 = str;
        if (TextUtils.equals(str, this.mMsg.senderuin))
        {
          localObject1 = str;
          if (!TextUtils.isEmpty(this.mMsg.msg2)) {
            localObject1 = this.mMsg.msg2;
          }
        }
        ((MsgSummary)localObject2).strContent = String.format(acfp.m(2131713680), new Object[] { localObject1, this.mMsg.msg });
        this.mTitleName = acfp.m(2131713674);
        this.mDisplayTime = this.mMsg.time;
        this.mUnreadNum = this.mMsg.longMsgCount;
        this.mUnreadFlag = 3;
        a(paramQQAppInterface, paramContext, (MsgSummary)localObject2);
        cuS();
        return;
      }
    } while (this.msg == null);
    MsgSummary localMsgSummary = a();
    String str = "";
    if (this.mType == 1033)
    {
      localObject2 = aqgv.b(paramQQAppInterface, this.mUin, true);
      if (TextUtils.isEmpty(this.mConfessInfo.topic))
      {
        this.mTitleName = ((String)localObject2);
        localObject1 = str;
      }
    }
    for (;;)
    {
      this.mUnreadNum = paramQQAppInterface.a().e(this.mUin, this.mType, this.mConfessInfo.topicId);
      this.mUnreadFlag = 1;
      this.mDisplayTime = this.msg.time;
      this.mMenuFlag = 1;
      this.mStatus = 0;
      aqiu.a(paramContext, paramQQAppInterface, this.msg, this.msg.istroop, localMsgSummary, (String)localObject1, false, false);
      localMsgSummary.bShowDraft = false;
      a(paramQQAppInterface, paramContext, localMsgSummary);
      cuS();
      return;
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() > 7) {
          localObject1 = aeha.a((String)localObject2, 7.0F);
        }
      }
      this.mTitleName = String.format(Locale.getDefault(), "%s—%s", new Object[] { localObject1, this.mConfessInfo.topic });
      localObject1 = str;
      continue;
      if (this.mType == 1034)
      {
        this.mTitleName = this.mConfessInfo.confessorNick;
        localObject1 = str;
        if (this.msg.msgtype == -2066)
        {
          str = paramQQAppInterface.getCurrentNickname();
          localObject1 = str;
          if (str.length() > 7) {
            localObject1 = aeha.a(str, 7.0F);
          }
        }
      }
      else
      {
        this.mTitleName = aqgv.b(paramQQAppInterface, this.mUin, true);
        localObject1 = str;
      }
    }
  }
  
  public long eI()
  {
    if (this.mMsg == null) {
      return 0L;
    }
    return this.mMsg.time;
  }
  
  public long eJ()
  {
    return 0L;
  }
  
  public int ng()
  {
    return this.mType;
  }
  
  public String qx()
  {
    return this.mUin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg
 * JD-Core Version:    0.7.0.1
 */