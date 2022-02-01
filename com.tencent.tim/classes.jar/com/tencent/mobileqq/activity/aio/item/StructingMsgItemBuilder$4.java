package com.tencent.mobileqq.activity.aio.item;

import ahgq;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import anot;
import anqu;
import anqv;
import anre;
import ansr;
import anty;
import antz;
import anun;
import anur;
import anux;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import obo;

class StructingMsgItemBuilder$4
  implements Runnable
{
  StructingMsgItemBuilder$4(StructingMsgItemBuilder paramStructingMsgItemBuilder, ChatMessage paramChatMessage, Context paramContext) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StructingMsgItemBuildertime", 4, "zhuanfa struct_public start:" + System.currentTimeMillis());
    }
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "structingMsgItem public forward");
    }
    MessageForStructing localMessageForStructing;
    AbsShareMsg localAbsShareMsg;
    Object localObject1;
    if ((this.b != null) && ((this.b instanceof MessageForStructing)))
    {
      localMessageForStructing = (MessageForStructing)this.b;
      if ((localMessageForStructing.structingMsg instanceof AbsShareMsg))
      {
        localAbsShareMsg = (AbsShareMsg)localMessageForStructing.structingMsg;
        if ((!(localAbsShareMsg instanceof StructMsgForGeneralShare)) || (!((StructMsgForGeneralShare)localAbsShareMsg).mIsPAVideoStructMsg)) {
          break label272;
        }
        localObject1 = (StructMsgForGeneralShare)anre.a(localAbsShareMsg.getBytes());
        obo.a((StructMsgForGeneralShare)localObject1);
        ((StructMsgForGeneralShare)localObject1).mSourceAction = "web";
        localObject2 = this.this$0.sessionInfo.aTl;
        ((StructMsgForGeneralShare)localObject1).mSourceUrl = obo.fj((String)localObject2);
        ((StructMsgForGeneralShare)localObject1).mSourceName = this.this$0.sessionInfo.aTn;
        ((StructMsgForGeneralShare)localObject1).source_puin = ((String)localObject2);
        ((StructMsgForGeneralShare)localObject1).mSourceIcon = "https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png";
        ((StructMsgForGeneralShare)localObject1).setFlag(0);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("forward_type", -3);
        ((Bundle)localObject2).putInt("structmsg_service_id", ((StructMsgForGeneralShare)localObject1).mMsgServiceID);
        ((Bundle)localObject2).putByteArray("stuctmsg_bytes", ((StructMsgForGeneralShare)localObject1).getBytes());
        localObject1 = new Intent();
        ((Intent)localObject1).putExtras((Bundle)localObject2);
        ahgq.f((Activity)this.this$0.mContext, (Intent)localObject1, 21);
      }
    }
    return;
    label272:
    Object localObject13 = null;
    Object localObject12 = null;
    Object localObject11 = null;
    Object localObject3 = null;
    Object localObject10 = null;
    Object localObject2 = null;
    String str2 = this.this$0.sessionInfo.aTn;
    String str1 = localAbsShareMsg.mSourceIcon;
    Object localObject4 = localAbsShareMsg.mMsgUrl;
    Object localObject9 = localAbsShareMsg.mMsgAction;
    Object localObject7 = localAbsShareMsg.mMsgActionData;
    Object localObject6 = localAbsShareMsg.mMsg_A_ActionData;
    Object localObject5 = localAbsShareMsg.mMsg_I_ActionData;
    Object localObject8 = localAbsShareMsg.mMsgBrief;
    long l = localAbsShareMsg.msgId;
    String str3 = localAbsShareMsg.uin;
    int i;
    if ((localAbsShareMsg instanceof StructMsgForGeneralShare))
    {
      localObject1 = (StructMsgForGeneralShare)localAbsShareMsg;
      StructingMsgItemBuilder.bVM = StructMsgForGeneralShare.clickedItemIndex;
      if (StructingMsgItemBuilder.bVM != 0)
      {
        i = 0;
        if (i < localAbsShareMsg.getItemCount())
        {
          localObject1 = localAbsShareMsg.getItemByIndex(i);
          if ((TextUtils.isEmpty(((anqu)localObject1).chH)) || (Integer.valueOf(((anqu)localObject1).chH).intValue() != StructingMsgItemBuilder.bVM) || ((!(localObject1 instanceof anty)) && (!(localObject1 instanceof antz)))) {}
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        if (!(localObject1 instanceof anqv)) {
          break label1801;
        }
        localObject1 = (anqv)localObject1;
        localObject9 = ((anqv)localObject1).rz;
        localObject6 = ((anqv)localObject1).cgX;
        localObject8 = ((anqv)localObject1).ku;
        localObject11 = ((anqv)localObject1).cgY;
        localObject10 = ((anqv)localObject1).cgZ;
        localObject7 = ((anqv)localObject1).cha;
        localObject5 = ((anqv)localObject1).chb;
        i = 0;
        localObject1 = localObject12;
        label529:
        if (i < ((ArrayList)localObject9).size())
        {
          localObject4 = (anqu)((ArrayList)localObject9).get(i);
          if ((localObject4 instanceof StructMsgItemTitle))
          {
            localObject4 = ((StructMsgItemTitle)localObject4).getText();
            localObject1 = localObject3;
            localObject3 = localObject4;
            localObject4 = localObject2;
            localObject2 = localObject1;
            localObject1 = localObject4;
          }
          for (;;)
          {
            i += 1;
            localObject4 = localObject3;
            localObject3 = localObject2;
            localObject2 = localObject1;
            localObject1 = localObject4;
            break label529;
            i += 1;
            break;
            if ((localObject4 instanceof anux))
            {
              localObject4 = ((anux)localObject4).getText();
              localObject3 = localObject1;
              localObject1 = localObject2;
              localObject2 = localObject4;
            }
            else
            {
              if (!(localObject4 instanceof ansr)) {
                break label1782;
              }
              localObject4 = ((ansr)localObject4).aNt;
              localObject2 = localObject3;
              localObject3 = localObject1;
              localObject1 = localObject4;
            }
          }
        }
        localObject4 = localObject7;
        localObject7 = localObject2;
        localObject9 = localObject1;
        localObject2 = localObject11;
        localObject1 = localObject8;
        localObject8 = localObject3;
        localObject3 = localObject10;
      }
      for (;;)
      {
        localObject10 = localMessageForStructing.senderuin;
        localObject11 = Long.toString(localAbsShareMsg.msgId);
        anot.a(this.this$0.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005455", "0X8005455", 0, 0, (String)localObject10, (String)localObject1, (String)localObject11, "");
        if ((str1 == null) || ("".equals(str1)))
        {
          localObject10 = "https://url.cn/JS8oE7";
          label785:
          this.this$0.a(this.I, this.this$0.sessionInfo.aTl, (String)localObject9, (String)localObject8, (String)localObject7, str2, (String)localObject1, (String)localObject10, (String)localObject6, (String)localObject2, localObject3, (String)localObject4, (String)localObject5, l, str3);
          anot.a(this.this$0.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005455", "0X8005455", 0, 0, str3, "" + l, "" + StructingMsgItemBuilder.bVM, "android");
          return;
          i = 0;
          localObject1 = localObject13;
          localObject2 = localObject11;
          localObject3 = localObject10;
          label921:
          if (i >= localAbsShareMsg.getItemCount()) {
            break label1665;
          }
          localObject10 = localAbsShareMsg.getItemByIndex(i);
          if ((localObject10 instanceof anqv))
          {
            localObject12 = (anqv)localObject10;
            localObject11 = ((anqv)localObject12).rz;
            if ((((anqv)localObject12).cgX == null) || ("".equals(((anqv)localObject12).cgX)) || ((localObject9 != null) && (!"".equals(localObject9)))) {
              break label1662;
            }
            localObject9 = ((anqv)localObject12).cgX;
            label1005:
            localObject10 = localObject4;
            if (((anqv)localObject12).ku != null)
            {
              localObject10 = localObject4;
              if (!"".equals(((anqv)localObject12).ku)) {
                if (localObject4 != null)
                {
                  localObject10 = localObject4;
                  if (!"".equals(localObject4)) {}
                }
                else
                {
                  localObject10 = ((anqv)localObject12).ku;
                }
              }
            }
            if ((((anqv)localObject12).cgY == null) || ("".equals(((anqv)localObject12).cgY)) || ((localObject7 != null) && (!"".equals(localObject7)))) {
              break label1655;
            }
            localObject4 = ((anqv)localObject12).cgY;
            label1107:
            if ((((anqv)localObject12).cgZ == null) || (!"".equals(((anqv)localObject12).cgZ)) || ((localObject6 != null) && (!"".equals(localObject6)))) {
              break label1652;
            }
            localObject6 = ((anqv)localObject12).cgZ;
            label1152:
            if ((((anqv)localObject12).cha == null) || (!"".equals(((anqv)localObject12).cha)) || ((localObject5 != null) && (!"".equals(localObject5)))) {
              break label1649;
            }
            localObject5 = ((anqv)localObject12).cha;
            label1197:
            if ((((anqv)localObject12).chb == null) || (!"".equals(((anqv)localObject12).chb)) || ((localObject8 != null) && (!"".equals(localObject8)))) {
              break label1642;
            }
            localObject7 = ((anqv)localObject12).chb;
            label1242:
            int j = 0;
            if (j >= ((ArrayList)localObject11).size()) {
              break label1735;
            }
            localObject8 = (anqu)((ArrayList)localObject11).get(j);
            if (("title".equals(((anqu)localObject8).mTypeName)) && (localObject1 == null))
            {
              if (!(localObject8 instanceof StructMsgItemTitle)) {
                break label1720;
              }
              localObject8 = ((StructMsgItemTitle)localObject8).getText();
              localObject1 = localObject3;
              localObject3 = localObject8;
            }
            for (;;)
            {
              label1309:
              j += 1;
              localObject8 = localObject3;
              localObject3 = localObject1;
              localObject1 = localObject8;
              break;
              if (("summary".equals(((anqu)localObject8).mTypeName)) && (localObject2 == null))
              {
                if (!(localObject8 instanceof anux)) {
                  break label1720;
                }
                localObject2 = ((anux)localObject8).getText();
                localObject8 = localObject1;
                localObject1 = localObject3;
                localObject3 = localObject8;
              }
              else if (("picture".equals(((anqu)localObject8).mTypeName)) && (localObject3 == null))
              {
                if (!(localObject8 instanceof ansr)) {
                  break label1720;
                }
                localObject8 = ((ansr)localObject8).aNt;
                localObject3 = localObject1;
                localObject1 = localObject8;
              }
              else if (("pavideo".equals(((anqu)localObject8).mTypeName)) && (localObject3 == null))
              {
                if (!(localObject8 instanceof anur)) {
                  break label1720;
                }
                localObject8 = ((anur)localObject8).imgUrl;
                localObject3 = localObject1;
                localObject1 = localObject8;
              }
              else
              {
                if ((!"paaudio".equals(((anqu)localObject8).mTypeName)) || (localObject3 != null) || (!(localObject8 instanceof anun))) {
                  break label1720;
                }
                localObject8 = ((anun)localObject8).mCoverUrl;
                localObject3 = localObject1;
                localObject1 = localObject8;
              }
            }
          }
          localObject10 = localObject8;
          localObject8 = localObject9;
          localObject9 = localObject1;
          localObject1 = localObject7;
          localObject7 = localObject3;
          localObject11 = localObject5;
          localObject3 = localObject9;
          localObject5 = localObject2;
          localObject9 = localObject4;
          localObject2 = localObject8;
          localObject4 = localObject1;
          localObject8 = localObject11;
          localObject1 = localObject10;
        }
        for (;;)
        {
          i += 1;
          localObject10 = localObject9;
          localObject9 = localObject8;
          localObject8 = localObject3;
          localObject11 = localObject2;
          localObject12 = localObject1;
          localObject3 = localObject7;
          localObject2 = localObject5;
          localObject1 = localObject8;
          localObject8 = localObject12;
          localObject5 = localObject9;
          localObject7 = localObject4;
          localObject9 = localObject11;
          localObject4 = localObject10;
          break label921;
          localObject10 = str1;
          break label785;
          label1642:
          localObject7 = localObject8;
          break label1242;
          label1649:
          break label1197;
          label1652:
          break label1152;
          label1655:
          localObject4 = localObject7;
          break label1107;
          label1662:
          break label1005;
          label1665:
          localObject12 = localObject6;
          localObject6 = localObject9;
          localObject9 = localObject3;
          localObject10 = localObject2;
          localObject11 = localObject1;
          localObject2 = localObject7;
          localObject1 = localObject4;
          localObject3 = localObject12;
          localObject4 = localObject5;
          localObject5 = localObject8;
          localObject7 = localObject9;
          localObject8 = localObject10;
          localObject9 = localObject11;
          break;
          label1720:
          localObject8 = localObject1;
          localObject1 = localObject3;
          localObject3 = localObject8;
          break label1309;
          label1735:
          localObject8 = localObject7;
          localObject7 = localObject10;
          localObject10 = localObject1;
          localObject11 = localObject2;
          localObject1 = localObject8;
          localObject8 = localObject5;
          localObject2 = localObject9;
          localObject9 = localObject7;
          localObject7 = localObject3;
          localObject5 = localObject11;
          localObject3 = localObject10;
        }
        label1782:
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        break;
        label1801:
        localObject3 = localObject6;
        localObject6 = localObject9;
        localObject11 = null;
        localObject10 = null;
        localObject9 = null;
        localObject2 = localObject7;
        localObject1 = localObject4;
        localObject4 = localObject5;
        localObject5 = localObject8;
        localObject7 = localObject11;
        localObject8 = localObject10;
      }
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */