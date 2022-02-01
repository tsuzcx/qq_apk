package com.tencent.mobileqq.multimsg;

import ahav;
import ajlc;
import ajlg;
import alvn;
import android.content.Intent;
import android.os.Bundle;
import anot;
import aqmf;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import ujt;
import ujt.d;
import wte;

public class MultiMsgManager$1
  implements Runnable
{
  public MultiMsgManager$1(ajlc paramajlc, ArrayList paramArrayList, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Object localObject2 = this.xM.iterator();
    int j = 0;
    int i = 0;
    Object localObject3;
    Object localObject1;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ChatMessage)((Iterator)localObject2).next();
      if (((ChatMessage)localObject3).msgtype == -2000)
      {
        localObject1 = (MessageForPic)localObject3;
        ujt.a(this.val$app, this.a, (MessageForPic)localObject1, this.djG);
        i += 1;
        label79:
        if (j >= ajlc.a(this.this$0)) {
          break label1537;
        }
      }
    }
    for (;;)
    {
      try
      {
        Thread.sleep(ajlc.b(this.this$0));
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "sendMultuMsgSeperaterFromLocal delay  i = " + j + " mDelayTime = " + ajlc.b(this.this$0));
        }
        j += 1;
        break;
        if (((ChatMessage)localObject3).msgtype == -2011)
        {
          if (!(localObject3 instanceof MessageForStructing)) {
            break label1540;
          }
          localObject1 = ((MessageForStructing)localObject3).structingMsg;
          if ((localObject1 == null) || (!(localObject1 instanceof StructMsgForImageShare))) {
            break label1540;
          }
          ((AbsStructMsg)localObject1).forwardID = this.djG;
          StructMsgForImageShare.sendAndUploadImageShare(this.val$app, (StructMsgForImageShare)localObject1, this.a.aTl, this.a.cZ, this.a.troopUin, 0);
          k = 1;
          if ((k == 0) && ((localObject3 instanceof MessageForStructing)))
          {
            localObject1 = ((MessageForStructing)localObject3).structingMsg;
            ((AbsStructMsg)localObject1).parentUniseq = ((ChatMessage)localObject3).uniseq;
            ((AbsStructMsg)localObject1).forwardID = this.djG;
            aqmf.a(this.val$app, this.a.aTl, this.a.cZ, (AbsStructMsg)localObject1, null);
          }
          break label79;
        }
        if (((ChatMessage)localObject3).msgtype == -5008)
        {
          localObject1 = ((MessageForArkApp)localObject3).ark_app_message;
          ((ArkAppMessage)localObject1).uniSeq = ((ChatMessage)localObject3).uniseq;
          ((ArkAppMessage)localObject1).forwardID = this.djG;
          ujt.b(this.val$app, this.a, (ArkAppMessage)localObject1);
          break label79;
        }
        if (((ChatMessage)localObject3).msgtype == -5017)
        {
          localObject1 = ((MessageForArkApp)localObject3).ark_app_message;
          ((ArkAppMessage)localObject1).uniSeq = ((ChatMessage)localObject3).uniseq;
          ((ArkAppMessage)localObject1).forwardID = this.djG;
          ujt.a(this.val$app, this.a, (ArkAppMessage)localObject1);
          break label79;
        }
        if (((ChatMessage)localObject3).msgtype == -5016)
        {
          QLog.e("MultiMsg_TAG", 1, "MSG_TYPE_ARK_BABYQ_REPLY no longer supported");
          break label79;
        }
        if (((ChatMessage)localObject3).msgtype == -5013)
        {
          localObject1 = ((MessageForArkFlashChat)localObject3).ark_app_message;
          ((ArkFlashChatMessage)localObject1).uniSeq = ((ChatMessage)localObject3).uniseq;
          ((ArkFlashChatMessage)localObject1).forwardID = this.djG;
          ujt.a(this.val$app, this.a, (ArkFlashChatMessage)localObject1, this.djG);
          break label79;
        }
        if ((((ChatMessage)localObject3).msgtype == -1035) || (((ChatMessage)localObject3).msgtype == -1036))
        {
          if (((ChatMessage)localObject3).msgtype == -1036)
          {
            localObject1 = (MessageForMixedMsg)((MessageForLongMsg)localObject3).rebuildLongMsg();
            wte.a().a((MessageRecord)localObject3, (MessageRecord)localObject1, this.djG);
            ((MessageForMixedMsg)localObject1).mForwardFromUniSeq = ((ChatMessage)localObject3).uniseq;
            ((MessageForMixedMsg)localObject1).forwardID = this.djG;
            alvn.a().a(this.val$app, (MessageForMixedMsg)localObject1, this.a, this.djG);
            break label79;
          }
          localObject1 = (MessageForMixedMsg)localObject3;
          continue;
        }
        if (((ChatMessage)localObject3).msgtype == -2022)
        {
          localObject1 = (MessageForShortVideo)localObject3;
          ((MessageForShortVideo)localObject1).forwardID = this.djG;
          ujt.a(this.val$app, this.a, (MessageForShortVideo)localObject1);
          break label79;
        }
        if (((localObject3 instanceof MessageForFile)) || ((localObject3 instanceof MessageForTroopFile)))
        {
          localObject1 = ahav.a(this.val$app, (MessageRecord)localObject3);
          if ((localObject1 != null) && (((Intent)localObject1).getExtras() != null))
          {
            localObject4 = (ForwardFileInfo)((Intent)localObject1).getExtras().getParcelable("fileinfo");
            String str2 = ((Intent)localObject1).getStringExtra("forward_filepath");
            if (localObject4 != null)
            {
              ((ForwardFileInfo)localObject4).jB(((ChatMessage)localObject3).uniseq);
              ((ForwardFileInfo)localObject4).forwardID = this.djG;
              ujt.a(this.val$app, BaseActivity.sTopActivity, this.a, (Intent)localObject1, str2, (ForwardFileInfo)localObject4, false);
            }
          }
          break label79;
        }
        if ((localObject3 instanceof MessageForReplyText))
        {
          localObject1 = (MessageForReplyText)localObject3;
          alvn.a().a(this.val$app, (ChatMessage)localObject1, this.a, 0, this.djG, true);
          break label79;
        }
        localObject1 = ((ChatMessage)localObject3).msg;
        Object localObject4 = new ujt.d();
        ((ujt.d)localObject4).aTw = true;
        ((ujt.d)localObject4).aTy = true;
        localObject1 = ujt.a(this.val$app, null, this.a, (String)localObject1, null, (ujt.d)localObject4);
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          wte.a().i(localObject1[0], ((ChatMessage)localObject3).uniseq, this.djG);
          wte.a().a(this.val$app, ((ChatMessage)localObject3).uniseq, this.djG);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "sendMultuMsgSeperaterFromLocal sendMsg cost = " + (System.currentTimeMillis() - l));
      }
      String str1 = this.a.aTl;
      int m = this.a.cZ;
      localObject2 = (ChatMessage)this.xM.get(0);
      if (localObject2 != null) {}
      for (j = ((ChatMessage)localObject2).istroop;; j = 0)
      {
        if (j == 0) {
          j = 1;
        }
        for (;;)
        {
          if (m == 0) {
            k = 1;
          }
          for (;;)
          {
            label1018:
            anot.a(this.val$app, "CliOper", "", str1, "0X8004876", "0X8004876", 0, 0, j + "", k + "", "" + this.xM.size(), "" + i + "");
            i = 1;
            label1142:
            int n;
            if (m == 0)
            {
              i = 1;
              n = this.xM.size();
              localObject2 = this.xM.iterator();
              k = 0;
              j = 0;
              label1164:
              if (!((Iterator)localObject2).hasNext()) {
                break label1358;
              }
              localObject3 = (MessageRecord)((Iterator)localObject2).next();
              if (((MessageRecord)localObject3).msgtype != -2022) {
                break label1323;
              }
              m = k;
              k = j + 1;
              j = m;
            }
            for (;;)
            {
              m = k;
              k = j;
              j = m;
              break label1164;
              if (j == 3000)
              {
                j = 2;
                break;
              }
              if (j != 1) {
                break label1527;
              }
              j = 3;
              break;
              if (m == 3000)
              {
                k = 2;
                break label1018;
              }
              if (m != 1) {
                break label1522;
              }
              k = 3;
              break label1018;
              if ((m == 3000) || (m == 1))
              {
                i = 2;
                break label1142;
              }
              if ((m == 1000) || (m == 1004))
              {
                i = 3;
                break label1142;
              }
              if (!ChatActivityUtils.e(this.val$app, this.a)) {
                break label1142;
              }
              i = 4;
              break label1142;
              label1323:
              if ((((MessageRecord)localObject3).msgtype == -2005) || (((MessageRecord)localObject3).msgtype == -2017))
              {
                m = k + 1;
                k = j;
                j = m;
                continue;
                label1358:
                anot.a(this.val$app, "CliOper", "", str1, "0X8009ABF", "0X8009ABF", i, 0, n + "", n + "", "" + j, "" + k);
                ajlg.logD("report_0X8009ABF:fromType:%d,msgCount:%d,msgSize:%d,videoMsgCount:%d,fileMsgCount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(n), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(k) });
              }
              else
              {
                m = j;
                j = k;
                k = m;
              }
            }
            label1522:
            k = 4;
          }
          label1527:
          j = 4;
        }
      }
      label1537:
      continue;
      label1540:
      int k = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.MultiMsgManager.1
 * JD-Core Version:    0.7.0.1
 */