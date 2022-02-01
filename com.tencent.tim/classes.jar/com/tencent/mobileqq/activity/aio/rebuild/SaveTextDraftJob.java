package com.tencent.mobileqq.activity.aio.rebuild;

import aiyx;
import aqmr;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class SaveTextDraftJob
  implements Runnable
{
  private aiyx a;
  private String aLz;
  private WeakReference<QQAppInterface> bV;
  private WeakReference<BaseChatPie> dU;
  private String mAtInfoStr;
  private MessageForReplyText.SourceMsgInfo mSourceMsgInfo;
  private String mixedMsgInfoHtml;
  private SessionInfo sessionInfo;
  private Object tag;
  private CharSequence text;
  
  public SaveTextDraftJob(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, aiyx paramaiyx, String paramString1, CharSequence paramCharSequence, QQAppInterface paramQQAppInterface, String paramString2, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, Object paramObject)
  {
    this.dU = new WeakReference(paramBaseChatPie);
    this.sessionInfo = paramSessionInfo;
    this.a = paramaiyx;
    this.mixedMsgInfoHtml = paramString1;
    this.text = paramCharSequence;
    this.bV = new WeakReference(paramQQAppInterface);
    this.aLz = paramString2;
    this.mSourceMsgInfo = paramSourceMsgInfo;
    this.tag = paramObject;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SaveTextDraftJob", 2, "saving text draft");
    }
    Object localObject1 = (QQAppInterface)this.bV.get();
    if (localObject1 == null) {
      if (QLog.isColorLevel()) {
        QLog.i("SaveTextDraftJob", 2, "saving text draft failed with null app");
      }
    }
    Object localObject2;
    BaseChatPie localBaseChatPie;
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.sessionInfo.aTl == null) || (this.sessionInfo.aTl.length() <= 2) || (((QQAppInterface)localObject1).b() == null));
        if (this.a == null) {
          this.a = aiyx.a((QQAppInterface)localObject1);
        }
        localObject2 = this.a.b((QQAppInterface)localObject1, this.sessionInfo.aTl, this.sessionInfo.cZ);
      } while (((aqmr.isEmpty(this.aLz)) && (aqmr.isEmpty(String.valueOf(this.text))) && (this.mSourceMsgInfo == null) && (((DraftTextInfo)localObject2).sourceMsgSeq == 0L)) || ((!aqmr.isEmpty(this.aLz)) && (this.aLz.equals(String.valueOf(this.text)))));
      if (((this.text == null) || (this.text.length() <= 0)) && (this.mSourceMsgInfo == null)) {
        break label504;
      }
      localObject2 = new DraftTextInfo();
      ((DraftTextInfo)localObject2).uin = this.sessionInfo.aTl;
      ((DraftTextInfo)localObject2).type = this.sessionInfo.cZ;
      if (this.mSourceMsgInfo != null)
      {
        ((DraftTextInfo)localObject2).sourceMsgSeq = this.mSourceMsgInfo.mSourceMsgSeq;
        ((DraftTextInfo)localObject2).sourceSenderUin = this.mSourceMsgInfo.mSourceMsgSenderUin;
        ((DraftTextInfo)localObject2).sourceToUin = this.mSourceMsgInfo.mSourceMsgToUin;
        ((DraftTextInfo)localObject2).sourceMsgText = this.mSourceMsgInfo.mSourceMsgText;
        ((DraftTextInfo)localObject2).mSourceMsgTime = this.mSourceMsgInfo.mSourceMsgTime;
        ((DraftTextInfo)localObject2).mSourceSummaryFlag = this.mSourceMsgInfo.mSourceSummaryFlag;
        ((DraftTextInfo)localObject2).mSourceType = this.mSourceMsgInfo.mType;
        ((DraftTextInfo)localObject2).mSourceRichMsg = this.mSourceMsgInfo.mRichMsg;
        ((DraftTextInfo)localObject2).mSourceUid = this.mSourceMsgInfo.origUid;
        ((DraftTextInfo)localObject2).mSourceAtInfoStr = this.mSourceMsgInfo.mAtInfoStr;
        ((DraftTextInfo)localObject2).sourceMsgTroopName = this.mSourceMsgInfo.mSourceMsgTroopName;
      }
      if (this.text == null) {
        break;
      }
      ((DraftTextInfo)localObject2).text = this.text.toString();
      ((DraftTextInfo)localObject2).mixedMsgInfoHtml = this.mixedMsgInfoHtml;
      ((DraftTextInfo)localObject2).mAtInfoStr = this.mAtInfoStr;
      localBaseChatPie = (BaseChatPie)this.dU.get();
    } while (localBaseChatPie == null);
    localBaseChatPie.aLz = ((DraftTextInfo)localObject2).text;
    ((DraftTextInfo)localObject2).time = NetConnInfoCenter.getServerTimeMillis();
    this.a.a((QQAppInterface)localObject1, (DraftTextInfo)localObject2);
    for (;;)
    {
      localObject2 = ((QQAppInterface)localObject1).b();
      localObject1 = this.a.a((QQAppInterface)localObject1, this.sessionInfo.aTl, this.sessionInfo.cZ);
      if (localObject1 == null) {
        break;
      }
      ((QQMessageFacade)localObject2).b(this.sessionInfo.aTl, this.sessionInfo.cZ, this.sessionInfo.troopUin, ((DraftSummaryInfo)localObject1).getSummary(), ((DraftSummaryInfo)localObject1).getTime());
      return;
      label504:
      this.a.o((QQAppInterface)localObject1, this.sessionInfo.aTl, this.sessionInfo.cZ);
    }
    ((QQMessageFacade)localObject2).b(this.sessionInfo.aTl, this.sessionInfo.cZ, this.sessionInfo.troopUin, "", 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.SaveTextDraftJob
 * JD-Core Version:    0.7.0.1
 */