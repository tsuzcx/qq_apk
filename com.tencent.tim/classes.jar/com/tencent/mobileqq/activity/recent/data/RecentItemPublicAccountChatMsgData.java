package com.tencent.mobileqq.activity.recent.data;

import aako;
import acbn;
import acfp;
import acja;
import ahta;
import ahtc;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import aqnl;
import avcb;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.ArrayList;
import java.util.List;
import kya;
import mqq.os.MqqHandler;
import nyn;
import obt;
import odv;
import ogp;
import org.json.JSONObject;
import tog;
import wna;
import yiz;
import yiz.a;

public class RecentItemPublicAccountChatMsgData
  extends RecentItemChatMsgData
{
  private boolean isNewKandian;
  public String mReportKeyBytesOacMsgxtend = "";
  
  public RecentItemPublicAccountChatMsgData(RecentUser paramRecentUser)
    throws NullPointerException
  {
    super(paramRecentUser);
    this.isNewKandian = TextUtils.equals(paramRecentUser.uin, acbn.blw);
    if (this.isNewKandian) {
      this.mUnreadFlag = 2;
    }
  }
  
  private void a(AbsStructMsg paramAbsStructMsg, Context paramContext)
  {
    if ((!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(acfp.m(2131713686))) && (!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(acfp.m(2131713691))) && (!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(acfp.m(2131713683))) && (!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(acfp.m(2131713694))) && (!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(acfp.m(2131713697))))
    {
      if (!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(String.format(paramContext.getString(2131698672), new Object[] { Integer.valueOf(this.mUnreadNum) }))) {}
    }
    else {
      this.mMsgExtroInfo = "";
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, QQMessageFacade paramQQMessageFacade, QQMessageFacade.Message paramMessage)
  {
    int i;
    if (paramMessage != null)
    {
      i = paramMessage.msgtype;
      if ((i == -3006) || (i == -5004)) {
        break label1097;
      }
      a(paramMessage, this.mUser.getType(), paramQQAppInterface, paramContext, this.msgSummary);
      if ((i == -2025) && (this.mUnreadNum > 0) && (nyn.e(paramQQAppInterface, this.mUser.uin)))
      {
        this.mExtraInfoColor = -881592;
        this.mMsgExtroInfo = paramMessage.msg;
        this.msgSummary.strContent = "";
      }
    }
    else
    {
      paramContext = null;
      paramQQMessageFacade = (acja)paramQQAppInterface.getManager(56);
      if ((paramQQMessageFacade != null) && (!aako.L(paramQQAppInterface))) {
        break label1281;
      }
    }
    for (;;)
    {
      try
      {
        paramContext = paramQQMessageFacade.a(this.mUser.uin, true);
        if ((paramContext == null) && (paramQQMessageFacade != null))
        {
          paramQQMessageFacade = paramQQMessageFacade.a(this.mUser.uin);
          if (paramQQMessageFacade != null) {
            this.mTitleName = paramQQMessageFacade.name;
          }
          if (this.isNewKandian) {
            this.mTitleName = obt.b(paramQQAppInterface, paramQQAppInterface.getApp());
          }
        }
        if (paramContext == null) {
          break label1296;
        }
        this.mTitleName = paramContext.name;
        this.mAuthenIconId = 0;
        if (acbn.blP.equals(this.mUser.uin)) {
          this.mTitleName = KandianDailyManager.a(paramMessage);
        }
        if ((paramMessage == null) || (paramMessage.getMessageText() == null)) {
          break label1304;
        }
        this.mDisplayTime = paramMessage.time;
        if (("2747277822".equals(this.mUser.uin)) && (ahta.isInited())) {
          ahtc.a(paramQQAppInterface, paramMessage, this.msgSummary, this);
        }
        if ((!this.isNewKandian) && (nyn.e(paramQQAppInterface, this.mUser.uin)))
        {
          i = paramQQAppInterface.a().G(this.mUser.uin, this.mUser.getType());
          if (this.mUnreadNum > 0)
          {
            if (!acbn.blO.equals(this.mUser.uin)) {
              break label1326;
            }
            if (i <= 0) {
              break label1318;
            }
            this.mUnreadNum = 1;
            this.mUnreadFlag = 2;
          }
        }
        if ((paramMessage != null) && (paramMessage.mExJsonObject != null)) {
          this.mReportKeyBytesOacMsgxtend = paramMessage.mExJsonObject.optString("report_key_bytes_oac_msg_extend", null);
        }
        if (acbn.blN.equals(this.mUser.uin)) {
          kya.a(this, 9);
        }
        ogp.a().beA();
        odv.a(this);
        if (("2909288299".equals(this.mUser.uin)) && (this.mUnreadNum > 0))
        {
          paramContext = paramMessage.getExtInfoFromExtStr("news_has_report");
          if ((TextUtils.isEmpty(paramContext)) || (!"1".equals(paramContext)))
          {
            paramMessage.saveExtInfoToExtStr("news_has_report", "1");
            ThreadManager.getSubThreadHandler().postDelayed(new RecentItemPublicAccountChatMsgData.3(this, paramQQAppInterface), 10000L);
          }
        }
        return;
        this.mMsgExtroInfo = "";
        this.mExtraInfoColor = 0;
        if (this.isNewKandian)
        {
          paramQQMessageFacade = paramQQMessageFacade.d(this.mUser.uin, this.mUser.getType());
          if ((paramQQMessageFacade == null) || (!(paramQQMessageFacade instanceof MessageForStructing))) {
            break;
          }
          paramQQMessageFacade = (MessageForStructing)paramQQMessageFacade;
          if (paramQQMessageFacade.structingMsg == null) {
            paramQQMessageFacade.parse();
          }
          if ((this.mUnreadNum > 0) && (paramQQMessageFacade.structingMsg != null) && (!TextUtils.isEmpty(paramQQMessageFacade.structingMsg.mOrangeWord)))
          {
            if (paramQQMessageFacade.structingMsg.mOrangeWord.length() >= 8)
            {
              this.mMsgExtroInfo = ("[" + paramQQMessageFacade.structingMsg.mOrangeWord.substring(0, 8) + "]");
              a(paramQQMessageFacade.structingMsg, paramContext);
              this.mExtraInfoColor = paramContext.getResources().getColor(2131167410);
            }
          }
          else
          {
            if ((paramQQMessageFacade.extInt != 1) || (paramQQMessageFacade.extLong != 1)) {
              break;
            }
            return;
          }
          this.mMsgExtroInfo = ("[" + paramQQMessageFacade.structingMsg.mOrangeWord + "]");
          continue;
        }
        if ((acbn.blO.equals(this.mUser.uin)) || (acbn.blP.equals(this.mUser.uin)))
        {
          paramQQMessageFacade = null;
          if ((paramMessage.lastMsg instanceof MessageForStructing))
          {
            MessageForStructing localMessageForStructing = (MessageForStructing)paramMessage.lastMsg;
            paramQQMessageFacade = localMessageForStructing;
            if (!localMessageForStructing.mIsParsed)
            {
              localMessageForStructing.parse();
              paramQQMessageFacade = localMessageForStructing;
            }
            if ((paramQQMessageFacade == null) || (paramQQMessageFacade.structingMsg == null)) {
              break;
            }
            this.msgSummary.strContent = paramQQMessageFacade.structingMsg.mMsgBrief;
            this.msgSummary.suffix = "";
            if ((TextUtils.isEmpty(paramQQMessageFacade.structingMsg.mOrangeWord)) || (this.mUnreadNum <= 0)) {
              break;
            }
            this.mMsgExtroInfo = ("[" + paramQQMessageFacade.structingMsg.mOrangeWord + "]");
            a(paramQQMessageFacade.structingMsg, paramContext);
            this.mExtraInfoColor = -881592;
            break;
          }
          if (paramMessage.msgtype != -2011) {
            continue;
          }
          paramQQMessageFacade = new MessageForStructing();
          paramQQMessageFacade.msgData = paramMessage.msgData;
          paramQQMessageFacade.parse();
          paramMessage.lastMsg = paramQQMessageFacade;
          continue;
        }
        if (("2290230341".equals(this.mUser.uin)) && (avcb.cy(paramQQAppInterface)))
        {
          paramContext = paramMessage.getExtInfoFromExtStr("qzone_msg_box_promot");
          if (TextUtils.isEmpty(paramContext)) {
            break;
          }
          this.msgSummary.strContent = paramContext;
          break;
        }
        if (this.mUnreadNum > 0)
        {
          bool = true;
          paramContext = aqnl.a(paramQQAppInterface, paramMessage, bool);
          if (paramContext != null) {
            this.msgSummary.strContent = paramContext;
          }
          paramContext = yiz.a(paramQQAppInterface, this.mUser.uin);
          if ((paramContext == null) || (paramContext.Ka != paramMessage.uniseq) || (!paramContext.isExpired())) {
            break;
          }
          ThreadManager.post(new RecentItemPublicAccountChatMsgData.2(this, paramQQAppInterface, paramContext), 2, null, false);
          break;
        }
        boolean bool = false;
        continue;
        label1097:
        this.msgSummary.strContent = "";
        paramQQMessageFacade = wna.a(paramMessage);
        if ((paramQQMessageFacade == null) || (paramQQMessageFacade.items == null) || (paramQQMessageFacade.items.size() == 0))
        {
          a(paramMessage, this.mUser.getType(), paramQQAppInterface, paramContext, this.msgSummary);
          break;
        }
        paramContext = ((PAMessage.Item)paramQQMessageFacade.items.get(0)).title;
        if ((((PAMessage.Item)paramQQMessageFacade.items.get(0)).cover == null) && (((PAMessage.Item)paramQQMessageFacade.items.get(0)).digestList != null))
        {
          paramContext = paramContext + "：" + (String)((PAMessage.Item)paramQQMessageFacade.items.get(0)).digestList.get(0);
          this.msgSummary.strContent = paramContext;
          break;
        }
        continue;
      }
      catch (Throwable paramContext)
      {
        paramContext = paramQQMessageFacade.b(this.mUser.uin);
        continue;
      }
      label1281:
      paramContext = paramQQMessageFacade.b(this.mUser.uin);
      continue;
      label1296:
      this.mAuthenIconId = 0;
      continue;
      label1304:
      this.mDisplayTime = this.mUser.lastmsgtime;
      continue;
      label1318:
      this.mUnreadFlag = 1;
      continue;
      label1326:
      if (acbn.blP.equals(this.mUser.uin))
      {
        if (i > 0) {
          this.mUnreadFlag = 2;
        } else {
          this.mUnreadFlag = 1;
        }
      }
      else if ((this.mUnreadNum == 1) && (i > 0))
      {
        this.mUnreadFlag = 2;
      }
      else if (i > 0)
      {
        this.mUnreadNum -= 1;
        this.mUnreadFlag = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData
 * JD-Core Version:    0.7.0.1
 */