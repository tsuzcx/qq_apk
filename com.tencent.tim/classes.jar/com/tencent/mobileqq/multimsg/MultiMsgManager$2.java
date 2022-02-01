package com.tencent.mobileqq.multimsg;

import acrb;
import ajlc;
import akxj;
import akxm;
import akxy;
import alte;
import altg;
import anaz;
import android.os.Bundle;
import anfr;
import angi;
import anot;
import ansu;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MultiMsgManager$2
  implements Runnable
{
  public MultiMsgManager$2(ajlc paramajlc, ArrayList paramArrayList, int paramInt1, HashMap paramHashMap, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, String paramString, int paramInt2, Bundle paramBundle) {}
  
  public void run()
  {
    ArrayList localArrayList1 = new ArrayList(this.xN);
    ajlc.access$202(System.currentTimeMillis());
    Object localObject2;
    if (this.djH == 5)
    {
      ajlc.a(this.this$0);
      if (this.djH != 2) {
        this.this$0.a(this.lE, this.C.uniseq, this.val$app);
      }
      localObject1 = this.val$app.a().b();
      localObject2 = this.C;
      if (this.djH == 5) {
        break label170;
      }
    }
    label170:
    for (boolean bool = true;; bool = false)
    {
      localObject2 = ((acrb)localObject1).a((MessageRecord)localObject2, localArrayList1, null, true, bool);
      if (this.djH == 5) {
        altg.dL(this.val$app);
      }
      if (localObject2 != null) {
        break label296;
      }
      if (this.djH != 2) {
        break label175;
      }
      ((MessageHandler)this.val$app.getBusinessHandler(0)).notifyUI(8031, false, Integer.valueOf(3));
      return;
      ajlc.a(this.this$0, 0);
      break;
    }
    label175:
    this.C.extraflag = 32768;
    this.val$app.a().e(this.bQI, this.dhX, this.C.uniseq);
    Object localObject1 = this.bQI;
    int i = this.dhX;
    long l = this.C.uniseq;
    ((MessageHandler)this.val$app.getBusinessHandler(0)).notifyUI(MessageHandler.gz(this.dhX), false, new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
    return;
    label296:
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList5 = new ArrayList();
    localObject1 = null;
    Object localObject3 = this.val$app.getAccount();
    int j;
    Iterator localIterator;
    if (this.djH == 2)
    {
      j = 0;
      localIterator = ((ArrayList)localObject2).iterator();
    }
    label361:
    label493:
    Object localObject5;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject4 = (MessageRecord)localIterator.next();
        Object localObject6;
        if ((localObject4 instanceof MessageForPic))
        {
          localObject6 = akxj.a(7, (MessageForPic)localObject4, j, (String)localObject3, this.bQI, this.val$app.getAccount());
          if (localObject6 != null)
          {
            if (this.djH == 5)
            {
              if (this.Q == null) {
                break label493;
              }
              i = this.Q.getInt("ReceiptMsgManager.EXTRA_KEY_PHOTO_SIZE_SPEC", 0);
              label448:
              ((akxm)localObject6).dpD = i;
              localObject4 = ((akxm)localObject6).b;
              if (i != 2) {
                break label515;
              }
            }
            label515:
            for (i = 1;; i = 0)
            {
              for (;;)
              {
                ((akxy)localObject4).dpK = i;
                localArrayList2.add(localObject6);
                break label361;
                j = this.dhX;
                break;
                try
                {
                  i = Integer.valueOf(alte.v((MessageRecord)localObject4)).intValue();
                }
                catch (NumberFormatException localNumberFormatException)
                {
                  i = 0;
                }
              }
              break label448;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.e("MultiMsg_TAG", 2, "[requestSendMultiMsg]createForwardPicInfo from MessageForPic failed");
          }
        }
        else if ((localNumberFormatException instanceof MessageForMixedMsg))
        {
          localObject5 = akxj.a(7, (MessageForMixedMsg)localNumberFormatException, j, (String)localObject3, this.bQI, this.val$app.getAccount());
          if (localObject5 != null) {
            localArrayList2.addAll((Collection)localObject5);
          } else if (QLog.isColorLevel()) {
            QLog.e("MultiMsg_TAG", 2, "[requestSendMultiMsg]createForwardPicInfos from MessageForMixedMsg failed");
          }
        }
        else if (((MessageRecord)localObject5).msgtype == -1036)
        {
          localObject5 = ((MessageForLongMsg)localObject5).longMsgFragmentList.iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (MessageRecord)((Iterator)localObject5).next();
            if ((localObject6 instanceof MessageForMixedMsg))
            {
              localObject6 = akxj.a(7, (MessageForMixedMsg)localObject6, j, (String)localObject3, this.bQI, this.val$app.getAccount());
              if (localObject6 != null) {
                localArrayList2.addAll((Collection)localObject6);
              }
            }
          }
        }
        else if ((localObject5 instanceof MessageForStructing))
        {
          localObject5 = ((MessageForStructing)localObject5).structingMsg;
          if ((localObject5 != null) && ((localObject5 instanceof StructMsgForImageShare)))
          {
            localObject6 = ((StructMsgForImageShare)localObject5).getFirstImageElement();
            if (localObject6 != null)
            {
              if (((ansu)localObject6).j == null)
              {
                if (((ansu)localObject6).d == null) {
                  ((ansu)localObject6).d = ((StructMsgForImageShare)localObject5);
                }
                ((ansu)localObject6).j = ((ansu)localObject6).a();
              }
              localObject5 = akxj.a(7, ((ansu)localObject6).j, this.dhX, (String)localObject3, this.bQI, this.val$app.getAccount());
              if (localObject5 != null) {
                localArrayList2.add(localObject5);
              } else if (QLog.isColorLevel()) {
                QLog.e("MultiMsg_TAG", 2, "[requestSendMultiMsg]createForwardPicInfo from MessageForPic failed");
              }
            }
          }
        }
        else if ((localObject5 instanceof MessageForShortVideo))
        {
          localObject6 = ShortVideoUtils.e((MessageForShortVideo)localObject5);
          ((MessageForShortVideo)localObject5).videoFileName = ((String)localObject6);
          if (localObject1 != null) {
            break label1643;
          }
          localObject1 = anfr.a(5, 5);
        }
      }
    }
    label1026:
    label1617:
    label1628:
    label1633:
    label1643:
    for (;;)
    {
      localObject5 = anfr.a(5, localObject5, (angi)localObject1);
      if (localObject5 != null) {
        localArrayList3.add(localObject5);
      }
      for (;;)
      {
        break;
        if (QLog.isColorLevel()) {
          QLog.e("MultiMsg_TAG", 2, "[requestSendMultiMsg]createShortVideoForwardInfo failed");
        }
      }
      if (((localObject5 instanceof MessageForPtt)) && (this.djH == 5))
      {
        localArrayList4.add((MessageForPtt)localObject5);
        break label361;
      }
      if ((localObject5 instanceof MessageForFile))
      {
        localArrayList5.add(localObject5);
        break label361;
      }
      if (!(localObject5 instanceof MessageForTroopFile)) {
        break label361;
      }
      localArrayList5.add(localObject5);
      break label361;
      localObject3 = (ChatMessage)localArrayList1.get(0);
      if (localObject3 != null) {}
      for (i = ((ChatMessage)localObject3).istroop;; i = 0)
      {
        if (i == 0) {
          i = 1;
        }
        for (;;)
        {
          if (this.dhX == 0) {
            j = 1;
          }
          for (;;)
          {
            anot.a(this.val$app, "CliOper", "", "", "0X8004660", "0X8004660", 0, 0, i + "", j + "", "" + localArrayList1.size(), "" + localArrayList2.size());
            if ((localArrayList2.size() == 0) && (localArrayList3.size() == 0) && (localArrayList4.size() == 0) && (localArrayList5.size() == 0))
            {
              if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, "[requestSendMultiMsg]There's not any picture messages, goto onPackAndSendMsg");
              }
              ajlc.a(this.this$0, this.val$app, this.bQI, this.dhX, this.lE, this.C, null, (ArrayList)localObject2, true, this.djH);
              return;
              if (i == 3000)
              {
                i = 2;
                break label1026;
              }
              if (i != 1) {
                break label1633;
              }
              i = 3;
              break label1026;
              if (this.dhX == 3000)
              {
                j = 2;
                continue;
              }
              if (this.dhX != 1) {
                break label1628;
              }
              j = 3;
              continue;
            }
            if (localArrayList2.size() > 0)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, "[requestSendMultiMsg]Upload pictures, count is [" + localArrayList2.size() + "], goto requestUploadPics");
              }
              if (this.djH != 5) {
                break label1617;
              }
              ajlc.a(this.this$0, this.C.uniseq, 1);
            }
            for (;;)
            {
              ajlc.a(this.this$0, this.val$app, this.bQI, this.dhX, this.lE, this.C, (ArrayList)localObject2, localArrayList2, this.djH);
              if (localArrayList3.size() > 0)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("MultiMsg_TAG", 2, "[requestSendMultiMsg]Upload videos, count is [" + localArrayList3.size() + "], goto requestUploadVideos");
                }
                ajlc.a(this.this$0, 2);
                ajlc.a(this.this$0, this.val$app, this.bQI, this.dhX, this.lE, this.C, (ArrayList)localObject2, localArrayList3, (angi)localObject1, this.djH);
              }
              if (localArrayList4.size() > 0)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("MultiMsg_TAG", 2, "[requestSendMultiMsg]Upload ptts, count is [" + localArrayList4.size() + "], goto requestUploadPtts");
                }
                ajlc.a(this.this$0, this.val$app, this.bQI, this.dhX, this.C, (ArrayList)localObject2, this.djH, this.Q);
              }
              if ((localArrayList5.size() <= 0) || (!QLog.isColorLevel())) {
                break;
              }
              QLog.d("MultiMsg_TAG", 2, "[requestSendMultiMsg]Upload files, count is [" + localArrayList5.size() + "], goto requestUploadFiles");
              return;
              ajlc.a(this.this$0, 1);
            }
            j = 4;
          }
          i = 4;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.MultiMsgManager.2
 * JD-Core Version:    0.7.0.1
 */