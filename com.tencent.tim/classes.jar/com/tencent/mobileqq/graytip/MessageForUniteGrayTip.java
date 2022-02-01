package com.tencent.mobileqq.graytip;

import ahvt;
import ahvv;
import ahwa;
import ahwb;
import android.content.Context;
import android.graphics.drawable.Drawable.Callback;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import aofe;
import aofk;
import aqft;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForGrayTips.HightlightClickableSpan;
import com.tencent.mobileqq.data.MessageForGrayTips.HightlightItem;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import localpb.uniteGrayTip.UniteGrayTip.BusinessData;
import localpb.uniteGrayTip.UniteGrayTip.HightlightParam;
import localpb.uniteGrayTip.UniteGrayTip.UniteGrayTipMsg;

public class MessageForUniteGrayTip
  extends ChatMessage
{
  public String appGuideTipsOpKey;
  public String caidanAnimUrl;
  public String caidanAnimUrlMd5;
  public ahvv callback;
  public String contentDescription;
  public boolean dkTipHasReport;
  public boolean docTipHasReport;
  public String editMsgData;
  public int editState;
  public long editTime;
  public String extUin;
  public int hasRead;
  public String masterUin;
  public int subType;
  public String taskId;
  public ahwa tipParam;
  
  private void encode()
  {
    int j = 1;
    if (this.tipParam == null)
    {
      QLog.e(ahwb.TAG, 1, "MessageForUniteGrayTip, encode failed, tipParam == null");
      return;
    }
    UniteGrayTip.UniteGrayTipMsg localUniteGrayTipMsg = new UniteGrayTip.UniteGrayTipMsg();
    localUniteGrayTipMsg.graytip_id.set(this.tipParam.dbK);
    localUniteGrayTipMsg.graytip_level.set(this.tipParam.dbL);
    if ((this.tipParam.lw != null) && (this.tipParam.lw.length > 0))
    {
      localObject = this.tipParam.lw;
      int k = localObject.length;
      i = 0;
      while (i < k)
      {
        int m = localObject[i];
        localUniteGrayTipMsg.graytip_mutex_id.add(Integer.valueOf(m));
        i += 1;
      }
    }
    if (!TextUtils.isEmpty(this.tipParam.bLT)) {
      localUniteGrayTipMsg.graytip_key.set(this.tipParam.bLT);
    }
    if (!TextUtils.isEmpty(this.tipParam.wording)) {
      localUniteGrayTipMsg.content.set(this.tipParam.wording);
    }
    if ((this.tipParam.xg != null) && (!this.tipParam.xg.isEmpty()))
    {
      localObject = ((ArrayList)this.tipParam.xg.clone()).iterator();
      if (((Iterator)localObject).hasNext())
      {
        MessageForGrayTips.HightlightItem localHightlightItem = (MessageForGrayTips.HightlightItem)((Iterator)localObject).next();
        UniteGrayTip.HightlightParam localHightlightParam = new UniteGrayTip.HightlightParam();
        localHightlightParam.start.set(localHightlightItem.start);
        localHightlightParam.end.set(localHightlightItem.end);
        localHightlightParam.uin.set(localHightlightItem.uin);
        PBUInt32Field localPBUInt32Field = localHightlightParam.needUpdateNick;
        if (localHightlightItem.needUpdateNick) {}
        for (i = 1;; i = 0)
        {
          localPBUInt32Field.set(i);
          localHightlightParam.actionType.set(localHightlightItem.actionType);
          localHightlightParam.textColor.set(localHightlightItem.textColor);
          if (!TextUtils.isEmpty(localHightlightItem.icon)) {
            localHightlightParam.icon.set(localHightlightItem.icon);
          }
          if (!TextUtils.isEmpty(localHightlightItem.mMsgActionData)) {
            localHightlightParam.mMsgActionData.set(localHightlightItem.mMsgActionData);
          }
          if (!TextUtils.isEmpty(localHightlightItem.mMsg_A_ActionData)) {
            localHightlightParam.mMsg_A_ActionData.set(localHightlightItem.mMsg_A_ActionData);
          }
          localUniteGrayTipMsg.hightlight_item.add(localHightlightParam);
          break;
        }
      }
    }
    Object localObject = localUniteGrayTipMsg.isLocalTroopMsg;
    if (this.tipParam.ciH) {}
    for (int i = j;; i = 0)
    {
      ((PBUInt32Field)localObject).set(i);
      localObject = new UniteGrayTip.BusinessData();
      ((UniteGrayTip.BusinessData)localObject).haveRead.set(this.hasRead);
      ((UniteGrayTip.BusinessData)localObject).subType.set(this.subType);
      if (!TextUtils.isEmpty(this.masterUin)) {
        ((UniteGrayTip.BusinessData)localObject).masterUin.set(this.masterUin);
      }
      if (!TextUtils.isEmpty(this.extUin)) {
        ((UniteGrayTip.BusinessData)localObject).extUin.set(this.extUin);
      }
      if (!TextUtils.isEmpty(this.taskId)) {
        ((UniteGrayTip.BusinessData)localObject).taskId.set(this.taskId);
      }
      ((UniteGrayTip.BusinessData)localObject).editState.set(this.editState);
      ((UniteGrayTip.BusinessData)localObject).editTime.set(this.editTime);
      if (!TextUtils.isEmpty(this.editMsgData)) {
        ((UniteGrayTip.BusinessData)localObject).editMsgData.set(this.editMsgData);
      }
      if (!TextUtils.isEmpty(this.caidanAnimUrl)) {
        ((UniteGrayTip.BusinessData)localObject).caidanAnimUrl.set(this.caidanAnimUrl);
      }
      if (!TextUtils.isEmpty(this.caidanAnimUrlMd5)) {
        ((UniteGrayTip.BusinessData)localObject).caidanAnimUrlMd5.set(this.caidanAnimUrlMd5);
      }
      localUniteGrayTipMsg.business_data.set((MessageMicro)localObject);
      this.msgData = localUniteGrayTipMsg.toByteArray();
      return;
    }
  }
  
  public void doParse()
  {
    UniteGrayTip.UniteGrayTipMsg localUniteGrayTipMsg = new UniteGrayTip.UniteGrayTipMsg();
    label711:
    label717:
    for (;;)
    {
      int k;
      String str2;
      String str1;
      int m;
      Object localObject2;
      try
      {
        localUniteGrayTipMsg.mergeFrom(this.msgData);
        int j = localUniteGrayTipMsg.graytip_id.get();
        k = localUniteGrayTipMsg.graytip_level.get();
        str2 = localUniteGrayTipMsg.graytip_key.get();
        str1 = localUniteGrayTipMsg.content.get();
        m = localUniteGrayTipMsg.isLocalTroopMsg.get();
        if ((!localUniteGrayTipMsg.graytip_mutex_id.has()) || (localUniteGrayTipMsg.graytip_mutex_id.size() <= 0)) {
          break label711;
        }
        localObject2 = (ArrayList)localUniteGrayTipMsg.graytip_mutex_id.get();
        int[] arrayOfInt = new int[((ArrayList)localObject2).size()];
        int i = 0;
        if (i >= ((ArrayList)localObject2).size() - 1) {
          break label717;
        }
        arrayOfInt[i] = ((Integer)((ArrayList)localObject2).get(i)).intValue();
        i += 1;
        continue;
        Iterator localIterator = null;
        localObject2 = localIterator;
        if (localUniteGrayTipMsg.hightlight_item.has())
        {
          localObject2 = localIterator;
          if (localUniteGrayTipMsg.hightlight_item.size() > 0)
          {
            localObject2 = new ArrayList();
            localIterator = ((ArrayList)localUniteGrayTipMsg.hightlight_item.get()).iterator();
            if (localIterator.hasNext())
            {
              UniteGrayTip.HightlightParam localHightlightParam = (UniteGrayTip.HightlightParam)localIterator.next();
              i = localHightlightParam.start.get();
              int n = localHightlightParam.end.get();
              long l = localHightlightParam.uin.get();
              int i1 = localHightlightParam.needUpdateNick.get();
              int i2 = localHightlightParam.actionType.get();
              String str3 = localHightlightParam.icon.get();
              int i3 = localHightlightParam.textColor.get();
              ((ArrayList)localObject2).add(new MessageForGrayTips.HightlightItem(i, n, l, i1, i2, localHightlightParam.mMsgActionData.get(), localHightlightParam.mMsg_A_ActionData.get(), str3, null, i3));
              continue;
            }
          }
        }
        this.tipParam = new ahwa(this.frienduin, this.senderuin, str1, this.istroop, this.msgtype, j, this.time);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.e(ahwb.TAG, 1, "MessageForUniteGrayTip, doParese failed, " + localException.getMessage());
        return;
      }
      this.tipParam.bLT = str2;
      this.tipParam.dbL = k;
      this.tipParam.lw = localException;
      this.tipParam.xg = ((ArrayList)localObject2);
      Object localObject1 = this.tipParam;
      if (m == 1) {}
      for (boolean bool = true;; bool = false)
      {
        ((ahwa)localObject1).ciH = bool;
        this.msg = str1;
        localObject1 = (UniteGrayTip.BusinessData)localUniteGrayTipMsg.business_data.get();
        if (localObject1 == null) {
          break;
        }
        this.hasRead = ((UniteGrayTip.BusinessData)localObject1).haveRead.get();
        this.subType = ((UniteGrayTip.BusinessData)localObject1).subType.get();
        if (((UniteGrayTip.BusinessData)localObject1).masterUin.has()) {
          this.masterUin = ((UniteGrayTip.BusinessData)localObject1).masterUin.get();
        }
        if (((UniteGrayTip.BusinessData)localObject1).extUin.has()) {
          this.extUin = ((UniteGrayTip.BusinessData)localObject1).extUin.get();
        }
        if (((UniteGrayTip.BusinessData)localObject1).taskId.has()) {
          this.taskId = ((UniteGrayTip.BusinessData)localObject1).taskId.get();
        }
        if (((UniteGrayTip.BusinessData)localObject1).editState.has()) {
          this.editState = ((UniteGrayTip.BusinessData)localObject1).editState.get();
        }
        if (((UniteGrayTip.BusinessData)localObject1).editTime.has()) {
          this.editTime = ((UniteGrayTip.BusinessData)localObject1).editTime.get();
        }
        if (((UniteGrayTip.BusinessData)localObject1).editMsgData.has()) {
          this.editMsgData = ((UniteGrayTip.BusinessData)localObject1).editMsgData.get();
        }
        if (((UniteGrayTip.BusinessData)localObject1).caidanAnimUrl.has()) {
          this.caidanAnimUrl = ((UniteGrayTip.BusinessData)localObject1).caidanAnimUrl.get();
        }
        if (!((UniteGrayTip.BusinessData)localObject1).caidanAnimUrlMd5.has()) {
          break;
        }
        this.caidanAnimUrlMd5 = ((UniteGrayTip.BusinessData)localObject1).caidanAnimUrlMd5.get();
        return;
      }
      localObject1 = null;
    }
  }
  
  public SpannableStringBuilder getHightlightMsgText(QQAppInterface paramQQAppInterface, Context paramContext, boolean paramBoolean, Drawable.Callback paramCallback)
  {
    Object localObject2;
    if ((this.tipParam == null) || (this.tipParam.xg == null) || (this.tipParam.xg.isEmpty()))
    {
      localObject2 = new SpannableStringBuilder(this.msg);
      return localObject2;
    }
    Collections.sort(this.tipParam.xg, new ahvt(this));
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("revoke msg GrayTips -> msg=").append(this.msg);
    Object localObject3 = "";
    Object localObject1 = this.msg;
    int n = 0;
    int m = 0;
    if (this.contentDescription == null) {
      localObject2 = new StringBuilder();
    }
    for (int k = 1;; k = 0)
    {
      TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
      Iterator localIterator = this.tipParam.xg.iterator();
      if (localIterator.hasNext())
      {
        Object localObject4 = (MessageForGrayTips.HightlightItem)localIterator.next();
        int j = ((MessageForGrayTips.HightlightItem)localObject4).start - n;
        int i1 = ((MessageForGrayTips.HightlightItem)localObject4).end - n;
        int i;
        label210:
        label227:
        String str2;
        String str3;
        if (j > ((String)localObject1).length())
        {
          i = ((String)localObject1).length();
          if (i1 <= ((String)localObject1).length()) {
            break label504;
          }
          j = ((String)localObject1).length();
          localStringBuilder.append(" ;item.start=").append(((MessageForGrayTips.HightlightItem)localObject4).start).append(",end=").append(((MessageForGrayTips.HightlightItem)localObject4).end);
          localStringBuilder.append("|index1=").append(i).append(",index2=").append(j).append("|lastEnd=").append(n);
          String str1 = ((String)localObject1).substring(0, i);
          str2 = (String)localObject3 + str1;
          str3 = ((String)localObject1).substring(i, j);
          if (k != 0)
          {
            ((StringBuilder)localObject2).append(str1);
            if (TextUtils.isEmpty(((MessageForGrayTips.HightlightItem)localObject4).icon)) {
              ((StringBuilder)localObject2).append(str3);
            }
          }
          localObject3 = ((String)localObject1).substring(j, ((String)localObject1).length());
          n = ((MessageForGrayTips.HightlightItem)localObject4).end;
          ((MessageForGrayTips.HightlightItem)localObject4).start = str2.length();
          if (!((MessageForGrayTips.HightlightItem)localObject4).needUpdateNick) {
            break label519;
          }
          localObject1 = str2 + localTroopManager.getTroopMemberName(this.frienduin, new StringBuilder().append("").append(((MessageForGrayTips.HightlightItem)localObject4).uin).toString());
          m = 1;
        }
        for (;;)
        {
          ((MessageForGrayTips.HightlightItem)localObject4).end = ((String)localObject1).length();
          localObject4 = localObject1;
          localObject1 = localObject3;
          localObject3 = localObject4;
          break;
          i = j;
          if (j >= 0) {
            break label210;
          }
          i = 0;
          break label210;
          label504:
          j = i1;
          if (i1 >= 0) {
            break label227;
          }
          j = 0;
          break label227;
          label519:
          localObject1 = str2 + str3;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("GrayTips", 2, localStringBuilder.toString());
      }
      if (k != 0)
      {
        ((StringBuilder)localObject2).append((String)localObject1);
        this.contentDescription = ((StringBuilder)localObject2).toString();
        QLog.i("content", 1, this.contentDescription);
      }
      localObject1 = (String)localObject3 + (String)localObject1;
      if (m != 0)
      {
        this.msg = ((String)localObject1);
        this.tipParam.wording = ((String)localObject1);
      }
      if (this.tipParam.dbK == 2)
      {
        localObject1 = new SpannableStringBuilder(new aofk((CharSequence)localObject1, 3));
        label667:
        localObject3 = this.tipParam.xg.iterator();
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject2 = (MessageForGrayTips.HightlightItem)((Iterator)localObject3).next();
        if (localObject2 != null)
        {
          if (TextUtils.isEmpty(((MessageForGrayTips.HightlightItem)localObject2).icon))
          {
            ((SpannableStringBuilder)localObject1).setSpan(new MessageForGrayTips.HightlightClickableSpan(paramQQAppInterface, ((MessageForGrayTips.HightlightItem)localObject2).textColor, paramContext, (MessageForGrayTips.HightlightItem)localObject2, this), ((MessageForGrayTips.HightlightItem)localObject2).start, ((MessageForGrayTips.HightlightItem)localObject2).end, 33);
            continue;
            localObject1 = new SpannableStringBuilder(new aofe((CharSequence)localObject1, 16));
            break label667;
          }
          MessageForGrayTips.decodeImageSpan(paramContext, (SpannableStringBuilder)localObject1, (MessageForGrayTips.HightlightItem)localObject2, paramBoolean, paramCallback);
        }
      }
      localObject2 = null;
    }
  }
  
  public String getSummaryMsg()
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    int i;
    int k;
    if ((this.tipParam != null) && (this.tipParam.dbK == 655397))
    {
      if ((this.tipParam.xg == null) || (this.tipParam.xg.isEmpty())) {
        break label234;
      }
      Iterator localIterator = this.tipParam.xg.iterator();
      j = 0;
      for (i = 0; localIterator.hasNext(); i = k)
      {
        MessageForGrayTips.HightlightItem localHightlightItem = (MessageForGrayTips.HightlightItem)localIterator.next();
        if ((localHightlightItem == null) || (TextUtils.isEmpty(localHightlightItem.icon))) {
          break label225;
        }
        localStringBuilder.append(this.msg.substring(j, localHightlightItem.start));
        i = localHightlightItem.end;
        j = 1;
        k = j;
        j = i;
      }
    }
    for (;;)
    {
      if (i == 0) {
        localStringBuilder.append(this.msg);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(ahwb.TAG, 2, "getSummary" + aqft.pk(this.msg));
        }
        return localStringBuilder.toString();
        localStringBuilder.append(this.msg.substring(j));
      }
      return super.getSummaryMsg();
      label225:
      k = i;
      i = j;
      j = k;
      break;
      label234:
      i = 0;
    }
  }
  
  public void initGrayTipMsg(QQAppInterface paramQQAppInterface, ahwa paramahwa)
  {
    if ((paramahwa == null) || (!paramahwa.HQ()))
    {
      if (QLog.isColorLevel()) {
        if (paramahwa != null) {
          break label53;
        }
      }
      label53:
      for (paramQQAppInterface = "null tipParam";; paramQQAppInterface = "msgtype: " + paramahwa.msgtype + " id: " + paramahwa.dbK)
      {
        QLog.e(ahwb.TAG, 2, "revoke msg createGrayTipMsg failed, error: " + paramQQAppInterface);
        return;
      }
    }
    init(paramQQAppInterface.getCurrentAccountUin(), paramahwa.uin, paramahwa.senderUin, paramahwa.wording, paramahwa.time, paramahwa.msgtype, paramahwa.uinType, paramahwa.time);
    this.mIsParsed = true;
    this.isread = true;
    this.tipParam = paramahwa;
    this.msgData = null;
  }
  
  public void postRead()
  {
    parse();
  }
  
  public void prewrite()
  {
    try
    {
      encode();
      return;
    }
    catch (Exception localException)
    {
      QLog.e(ahwb.TAG, 1, "MessageForUniteGrayTip, prewrite failed, " + localException.getMessage());
    }
  }
  
  public void updateUniteGrayTipMsg(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ahwb.TAG, 2, "updateUniteGrayTipMsg");
    }
    this.msg = paramString;
    if (this.tipParam != null)
    {
      this.tipParam.wording = paramString;
      prewrite();
      paramQQAppInterface.b().c(this.frienduin, this.istroop, this.uniseq, this.msgData);
    }
  }
  
  public void updateUniteGrayTipMsgData(QQAppInterface paramQQAppInterface)
  {
    prewrite();
    paramQQAppInterface.b().c(this.frienduin, this.istroop, this.uniseq, this.msgData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.graytip.MessageForUniteGrayTip
 * JD-Core Version:    0.7.0.1
 */