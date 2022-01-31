package com.tencent.mobileqq.activity;

import AccostSvc.EventItem;
import MessageSvcPack.UinPairReadInfo;
import abk;
import abl;
import abm;
import abn;
import abo;
import abq;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.Layout;
import android.text.TextPaint;
import android.text.format.Time;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.IndividualExpireInfoHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.C2CMessageProcessor;
import com.tencent.mobileqq.app.message.DiscMessageProcessor;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFunnyFace;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentEmotionData;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.TestStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemHr;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout1;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.EmotcationSpan;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.data.TroopMessageProcessor;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ForwardSendPicUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlite.data.MarkFaceMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatActivityFacade
{
  public static final int a = 3478;
  public static long a = 0L;
  private static final String jdField_a_of_type_JavaLangString = ChatActivityFacade.class.getSimpleName();
  private static final short jdField_a_of_type_Short = 100;
  public static final boolean a = true;
  
  static
  {
    jdField_a_of_type_Long = -1L;
  }
  
  public static int a(List paramList, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return -1;
    }
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      if (a((RecentEmotionData)paramList.get(i), paramInt1, paramInt2, paramString)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static long a(long paramLong, Time paramTime)
  {
    paramTime.set(paramLong);
    int i = paramTime.year;
    int j = paramTime.month;
    paramTime.set(0, 0, 0, paramTime.monthDay, j, i);
    return paramTime.toMillis(false);
  }
  
  public static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    long l2 = paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      if (l2 == -1L) {
        return paramSessionInfo.jdField_a_of_type_Long;
      }
      if (l2 != paramSessionInfo.jdField_a_of_type_Long)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.sendGroupMsgReadConfirm", 2, "groupUin is " + paramSessionInfo.jdField_a_of_type_JavaLangString + ", shmsgseq  is " + l2);
        }
        try
        {
          ((TroopMessageProcessor)paramQQAppInterface.a().a("troop_processor")).a(Long.valueOf(paramSessionInfo.jdField_a_of_type_JavaLangString).longValue(), l2);
          paramSessionInfo.jdField_a_of_type_Long = l2;
          return l2;
        }
        catch (Exception paramQQAppInterface)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.sendGroupMsgReadConfirm", 2, "sendReadConfirm" + paramQQAppInterface);
            }
          }
        }
      }
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 3000)
    {
      if (l2 == -1L) {
        return paramSessionInfo.jdField_a_of_type_Long;
      }
      if (l2 != paramSessionInfo.jdField_a_of_type_Long)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.sendDisMsgReadConfirm", 2, "disUin is " + paramSessionInfo.jdField_a_of_type_JavaLangString + ", shmsgseq  is " + l2);
        }
        ((DiscMessageProcessor)paramQQAppInterface.a().a("disc_processor")).a(Long.valueOf(paramSessionInfo.jdField_a_of_type_JavaLangString).longValue(), l2);
        paramSessionInfo.jdField_a_of_type_Long = l2;
        return l2;
      }
    }
    long l1;
    if (MsgProxyUtils.a(paramSessionInfo.jdField_a_of_type_Int))
    {
      if (l2 == -1L) {
        return paramSessionInfo.jdField_a_of_type_Long;
      }
      if ((l2 != 0L) && (l2 != paramSessionInfo.jdField_a_of_type_Long)) {
        if (paramSessionInfo.jdField_a_of_type_Int == 1006)
        {
          if (paramSessionInfo.f == null) {
            break label607;
          }
          l1 = Long.valueOf(paramSessionInfo.f).longValue();
        }
      }
    }
    for (;;)
    {
      if (l1 != -1L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.sendMsgReadedReport", 2, "msgReadedReportUin is " + l1 + ", shmsgseq  is " + l2);
        }
        ArrayList localArrayList = new ArrayList();
        if (paramSessionInfo.jdField_a_of_type_Int == 1024)
        {
          byte[] arrayOfByte = paramQQAppInterface.a().d(paramSessionInfo.jdField_a_of_type_JavaLangString);
          if (arrayOfByte != null)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 4, "Readcomfirmed------->Sig:" + HexUtil.a(arrayOfByte) + ",length:" + arrayOfByte.length);
            }
            localArrayList.add(new UinPairReadInfo(l1, l2, 0L, arrayOfByte));
          }
        }
        for (;;)
        {
          ((C2CMessageProcessor)paramQQAppInterface.a().a("c2c_processor")).b(localArrayList);
          paramSessionInfo.jdField_a_of_type_Long = l2;
          return l2;
          l1 = Long.valueOf(paramSessionInfo.jdField_a_of_type_JavaLangString).longValue();
          break;
          if (QLog.isDevelopLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 4, "Readcomfirmed------->crmSig is null:");
          }
          localArrayList.add(new UinPairReadInfo(l1, l2, 0L, null));
          continue;
          localArrayList.add(new UinPairReadInfo(l1, l2, 0L, null));
        }
      }
      return paramSessionInfo.jdField_a_of_type_Long;
      label607:
      l1 = -1L;
    }
  }
  
  public static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForPic paramMessageForPic)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramSessionInfo != null)
    {
      l1 = l2;
      if (paramMessageForPic != null)
      {
        paramSessionInfo = MessageRecordFactory.a(paramMessageForPic);
        ((SVIPHandler)paramQQAppInterface.a(12)).a(paramSessionInfo);
        paramQQAppInterface.a().a(paramSessionInfo, paramQQAppInterface.a());
        l1 = paramSessionInfo.uniseq;
      }
    }
    return l1;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    MessageRecord localMessageRecord = a(paramQQAppInterface, paramString, paramSessionInfo, -3);
    long l = 0L;
    if (localMessageRecord != null) {
      l = localMessageRecord.uniseq;
    }
    if (l != -1L) {
      a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, paramString, l, true);
    }
    return l;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, long paramLong, int paramInt2)
  {
    if (paramString1 != null)
    {
      paramString1 = TransfileUtile.a(paramString1, paramString3, paramString4, paramLong, paramInt2);
      paramString3 = MessageRecordFactory.a(-20000);
      paramString3.selfuin = paramQQAppInterface.a();
      paramString3.frienduin = paramString2;
      paramString3.senderuin = paramQQAppInterface.a();
      paramString3.msg = paramString1;
      paramString3.msgtype = -20000;
      paramString3.isread = true;
      paramString3.issend = 1;
      paramString3.istroop = paramInt1;
      ((SVIPHandler)paramQQAppInterface.a(12)).a(paramString3);
      paramQQAppInterface.a().a(paramString3, paramQQAppInterface.a());
      return paramString3.uniseq;
    }
    return 0L;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (MsgProxyUtils.a(paramSessionInfo.jdField_a_of_type_Int))
    {
      paramQQAppInterface = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
      if ((paramQQAppInterface != null) && (!paramQQAppInterface.isEmpty()))
      {
        int i = paramQQAppInterface.size() - 1;
        while (i >= 0)
        {
          paramSessionInfo = (MessageRecord)paramQQAppInterface.get(i);
          if (!MsgUtils.b(paramSessionInfo.issend)) {
            return paramSessionInfo;
          }
          i -= 1;
        }
      }
    }
    return null;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForPtt paramMessageForPtt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramSessionInfo != null)
    {
      localObject1 = localObject2;
      if (paramMessageForPtt != null)
      {
        localObject1 = MessageRecordFactory.a(paramMessageForPtt);
        ((SVIPHandler)paramQQAppInterface.a(12)).a((MessageRecord)localObject1);
        paramQQAppInterface.a().a((MessageRecord)localObject1, paramQQAppInterface.a());
      }
    }
    return localObject1;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2)
  {
    if (paramSessionInfo == null) {}
    while (paramString1 == null) {
      return null;
    }
    paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
    paramSessionInfo.path = paramString1;
    paramSessionInfo.size = 0L;
    paramSessionInfo.type = 1;
    paramSessionInfo.isRead = true;
    paramSessionInfo.serial();
    ((SVIPHandler)paramQQAppInterface.a(12)).a(paramSessionInfo);
    paramQQAppInterface.a().a(paramSessionInfo, paramQQAppInterface.a());
    return paramSessionInfo;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!android.text.TextUtils.isEmpty(paramString))
    {
      localObject1 = localObject2;
      if (paramSessionInfo != null)
      {
        int i = paramSessionInfo.jdField_a_of_type_Int;
        localObject1 = new byte[3];
        PkgTools.a(paramString.length(), (byte[])localObject1, 0, 3, "utf-8");
        localObject1 = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, i);
        ((MessageForPtt)localObject1).url = paramString;
        ((MessageForPtt)localObject1).fileSize = paramInt;
        ((MessageForPtt)localObject1).itemType = 2;
        ((MessageForPtt)localObject1).sttAbility = 0;
        ((MessageForPtt)localObject1).longPttVipFlag = MessageUtils.a(paramQQAppInterface, paramQQAppInterface.a());
        ((MessageForPtt)localObject1).serial();
        ((SVIPHandler)paramQQAppInterface.a(12)).a((MessageRecord)localObject1);
        paramQQAppInterface.a().a((MessageRecord)localObject1, paramQQAppInterface.a());
      }
    }
    return localObject1;
  }
  
  public static AbsShareMsg a(Context paramContext, String paramString, List paramList, Map paramMap)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramMap == null)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i;
    int j;
    label44:
    StringBuilder localStringBuilder;
    Object localObject3;
    Object localObject2;
    if (paramList.size() >= 3)
    {
      i = 3;
      j = 0;
      if (j >= i) {
        break label457;
      }
      localStringBuilder = new StringBuilder();
      localObject3 = (ChatMessage)paramList.get(j);
      localObject2 = (String)paramMap.get(((ChatMessage)localObject3).senderuin);
      if (android.text.TextUtils.isEmpty((CharSequence)localObject2)) {
        break label639;
      }
      localObject1 = localObject2;
      if (((String)localObject2).length() <= 12) {}
    }
    label457:
    label639:
    for (Object localObject1 = ((String)localObject2).substring(0, 11) + "...";; localObject1 = "  ")
    {
      if ((localObject3 instanceof MessageForPic))
      {
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(":  ");
        localStringBuilder.append("[图片]");
        localArrayList.add(new StructMsgItemTitle(localStringBuilder.toString()));
      }
      for (;;)
      {
        j += 1;
        break label44;
        i = paramList.size();
        break;
        if ((localObject3 instanceof MessageForText))
        {
          localObject3 = ((MessageForText)localObject3).msg;
          localObject2 = localObject3;
          if (com.tencent.mobileqq.text.TextUtils.a((String)localObject3)) {
            localObject2 = com.tencent.mobileqq.text.TextUtils.b((String)localObject3);
          }
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(":  ");
          localStringBuilder.append((String)localObject2);
          localArrayList.add(new StructMsgItemTitle(a(paramContext, (int)(BaseChatItemLayout.g * 0.8F), 2, localStringBuilder.toString()).toString()));
        }
        else if (((localObject3 instanceof MessageForMixedMsg)) || ((localObject3 instanceof MessageForLongMsg)))
        {
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(":  ");
          localStringBuilder.append(MessageForMixedMsg.getTextFromMixedMsg((ChatMessage)localObject3));
          localArrayList.add(new StructMsgItemTitle(a(paramContext, (int)(BaseChatItemLayout.g * 0.8F), 2, localStringBuilder.toString()).toString()));
        }
        else if ((localObject3 instanceof MessageForStructing))
        {
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(":  ");
          localStringBuilder.append("[结构化消息]");
          localArrayList.add(new StructMsgItemTitle(localStringBuilder.toString()));
        }
      }
      paramMap = paramString;
      if (!android.text.TextUtils.isEmpty(paramString))
      {
        paramMap = paramString;
        if (paramString.length() > 20) {
          paramMap = paramString.substring(0, 19) + "...";
        }
      }
      paramString = String.format("转发自: %s", new Object[] { paramMap });
      paramContext = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(35).a("[转发多条消息]").a(3).a("viewMultiMsg", "", null, null, null).a(paramString, null).d(paramContext.getResources().getString(2131363136)).a();
      paramString = new StructMsgItemLayout1(localArrayList);
      paramString.a(new StructMsgItemHr());
      paramString.a(new StructMsgItemSummary(String.format("查看%s条转发消息", new Object[] { Integer.valueOf(paramList.size()) })));
      paramContext.addItem(paramString);
      return paramContext;
    }
  }
  
  private static CharSequence a(Context paramContext, int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    int k = 30;
    paramContext = paramContext.getResources();
    TextPaint localTextPaint = new TextPaint(1);
    localTextPaint.density = paramContext.getDisplayMetrics().density;
    int m = paramCharSequence.length();
    int i = 0;
    int j = i;
    if (i < m)
    {
      if (Layout.getDesiredWidth(paramCharSequence, 0, i + 1, localTextPaint) > paramInt1 * paramInt2) {
        j = i - 1;
      }
    }
    else if (j >= m)
    {
      paramContext = paramCharSequence;
      if (j <= 30) {}
    }
    else
    {
      if (j <= 30) {
        break label146;
      }
    }
    label146:
    for (paramInt1 = k;; paramInt1 = j)
    {
      paramContext = paramCharSequence.subSequence(0, paramInt1).toString() + "…";
      return paramContext;
      i += 1;
      break;
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    a(paramQQAppInterface, paramSessionInfo, "我在这里，点击查看：http://maps.google.com/maps?q=" + paramString1 + "," + paramString2 + "&iwloc=A&hl=zh-CN (" + paramString3 + ")", -1L);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface = new abo(paramContext, paramQQAppInterface, paramChatMessage);
    paramChatMessage = (InputMethodManager)paramContext.getSystemService("input_method");
    boolean bool = paramChatMessage.isActive();
    if (((paramContext instanceof Activity)) && (bool)) {
      paramChatMessage.hideSoftInputFromWindow(((Activity)paramContext).getWindow().getDecorView().getWindowToken(), 0);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        new Handler(paramContext.getMainLooper()).postDelayed(paramQQAppInterface, 60L);
        return;
      }
      paramQQAppInterface.run();
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    if ((paramInt == 1001) && (!paramQQAppInterface.b(paramString1))) {
      paramQQAppInterface.a().a(paramString1, paramInt, paramString2, paramLong);
    }
    do
    {
      TransferRequest localTransferRequest;
      do
      {
        do
        {
          return;
          if ((paramInt != 0) || (a(paramQQAppInterface, paramString1, paramInt, paramLong))) {
            break;
          }
          if (paramBoolean)
          {
            StreamDataManager.a(paramQQAppInterface, paramString1, paramString2, paramLong);
            return;
          }
        } while (StreamDataManager.b(paramString2) < 1);
        StreamDataManager.a(paramString2, paramQQAppInterface, paramString1, paramLong);
        return;
        localTransferRequest = new TransferRequest();
        localTransferRequest.jdField_a_of_type_JavaLangString = paramQQAppInterface.getAccount();
        localTransferRequest.jdField_b_of_type_JavaLangString = paramString1;
        localTransferRequest.jdField_a_of_type_Int = paramInt;
        localTransferRequest.jdField_b_of_type_Int = 2;
        localTransferRequest.jdField_a_of_type_Long = paramLong;
        localTransferRequest.jdField_a_of_type_Boolean = true;
        localTransferRequest.h = paramString2;
        localTransferRequest.jdField_d_of_type_Int = 1002;
        localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramQQAppInterface.a().a(paramString1, paramInt, paramLong);
        paramQQAppInterface.a().a(localTransferRequest);
      } while ((localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) || (!(localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPtt)));
      paramQQAppInterface = (MessageForPtt)localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    } while ((!paramQQAppInterface.c2cViaOffline) || (paramQQAppInterface.timeLength > 0));
    paramQQAppInterface.timeLength = QQRecorder.a(paramString2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    if (!ChatActivityUtils.a(paramQQAppInterface, paramSessionInfo)) {}
    do
    {
      do
      {
        return;
      } while ((ChatActivityUtils.a(paramContext, paramSessionInfo)) || (1024 == paramSessionInfo.jdField_a_of_type_Int));
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "single way insert " + paramSessionInfo.jdField_a_of_type_JavaLangString);
      }
      ChatActivityUtils.b(paramContext, paramSessionInfo);
      paramContext = MessageRecordFactory.a(-2019);
      long l = MessageCache.a();
      paramContext.init(paramQQAppInterface.a(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, "", l, -2019, paramSessionInfo.jdField_a_of_type_Int, l);
      paramContext.isread = true;
    } while (MessageHandlerUtils.a(paramQQAppInterface, paramContext, false));
    paramQQAppInterface.a().a(paramContext, paramContext.selfuin);
    ReportController.b(paramQQAppInterface, "CliOper", "", paramSessionInfo.jdField_a_of_type_JavaLangString, "Manage_stranger", "Manage_str_aio_exp", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, long paramLong)
  {
    paramContext = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    if ((paramContext != null) && (paramContext.isSendFromLocal())) {
      paramQQAppInterface.a().d(paramQQAppInterface.a().a(paramContext.frienduin, paramContext.uniseq));
    }
    paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    paramContext = MessageRecordFactory.a(paramContext);
    paramQQAppInterface.a().a(paramContext, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Intent paramIntent, String paramString, ForwardFileInfo paramForwardFileInfo)
  {
    if (!paramIntent.getBooleanExtra("not_forward", false)) {}
    do
    {
      return;
      paramQQAppInterface.a().a(paramForwardFileInfo.b(), paramForwardFileInfo.e(), paramForwardFileInfo.a(), Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString), paramSessionInfo.jdField_a_of_type_Int);
    } while (!paramIntent.getBooleanExtra("not_forward", false));
    paramIntent.removeExtra("not_forward");
    paramIntent.getExtras().remove("not_forward");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Intent paramIntent, String paramString, ForwardFileInfo paramForwardFileInfo, boolean paramBoolean)
  {
    if ((paramForwardFileInfo != null) && (paramForwardFileInfo.a() == 10006) && (paramSessionInfo.jdField_a_of_type_Int == 1)) {
      a(paramQQAppInterface, paramContext, paramSessionInfo, paramIntent, paramString, paramForwardFileInfo);
    }
    for (;;)
    {
      return;
      if (paramIntent.getBooleanExtra("isFromShare", false))
      {
        if (!paramIntent.getBooleanExtra("sendMultiple", false))
        {
          if (paramSessionInfo.jdField_a_of_type_Int == 1)
          {
            paramQQAppInterface.a().a(paramString, paramSessionInfo.jdField_a_of_type_JavaLangString);
            return;
          }
          paramQQAppInterface.a().a(paramString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true);
        }
      }
      else if (paramIntent.getBooleanExtra("not_forward", false))
      {
        if ((paramQQAppInterface.a().b(paramForwardFileInfo.b()) == null) && (QLog.isColorLevel())) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "there has a Bug!,sissionId[" + paramForwardFileInfo.b() + "]");
        }
        switch (paramForwardFileInfo.a())
        {
        }
        while ((!paramBoolean) && (paramIntent.getBooleanExtra("not_forward", false)))
        {
          paramIntent.removeExtra("not_forward");
          paramIntent.getExtras().remove("not_forward");
          return;
          if ((FileManagerUtil.a()) && (paramForwardFileInfo.d() > 5242880L))
          {
            FMDialogUtil.a(paramContext, 2131362018, 2131362016, new abm(paramSessionInfo, paramQQAppInterface, paramForwardFileInfo));
          }
          else if (paramSessionInfo.jdField_a_of_type_Int == 1)
          {
            paramQQAppInterface.a().a(paramForwardFileInfo.a(), paramSessionInfo.jdField_a_of_type_JavaLangString);
          }
          else
          {
            paramQQAppInterface.a().a(paramForwardFileInfo.a(), paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true);
            continue;
            if (paramSessionInfo.jdField_a_of_type_Int == 1)
            {
              if (!android.text.TextUtils.isEmpty(paramForwardFileInfo.a())) {
                paramQQAppInterface.a().a(paramForwardFileInfo.a(), paramSessionInfo.jdField_a_of_type_JavaLangString);
              } else {
                paramQQAppInterface.a().a(paramForwardFileInfo.b(), paramSessionInfo.jdField_a_of_type_JavaLangString);
              }
            }
            else
            {
              paramContext = paramQQAppInterface.a().a(paramForwardFileInfo.b());
              if (paramContext.peerType == 3000)
              {
                paramContext = paramQQAppInterface.a().a(paramContext, paramQQAppInterface.a(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
                if (paramSessionInfo.jdField_a_of_type_Int == 0) {
                  paramQQAppInterface.a().b(paramContext, 21);
                } else if (paramSessionInfo.jdField_a_of_type_Int == 3000) {
                  paramQQAppInterface.a().b(paramContext, 22);
                }
              }
              else
              {
                paramContext = paramQQAppInterface.a().a(paramContext, paramQQAppInterface.a(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
                paramQQAppInterface.a().a(paramContext, paramSessionInfo.jdField_a_of_type_Int);
                continue;
                paramContext = paramQQAppInterface.a().a(paramForwardFileInfo.b());
                paramQQAppInterface.a().b(paramContext, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
                continue;
                if ((FileManagerUtil.a()) && (paramForwardFileInfo.d() > 5242880L) && (paramForwardFileInfo.c() == 3)) {
                  FMDialogUtil.a(paramContext, 2131362018, 2131362016, new abn(paramSessionInfo, paramForwardFileInfo, paramQQAppInterface));
                } else if (paramSessionInfo.jdField_a_of_type_Int == 1)
                {
                  if (!android.text.TextUtils.isEmpty(paramForwardFileInfo.a())) {
                    paramQQAppInterface.a().a(paramForwardFileInfo.a(), paramSessionInfo.jdField_a_of_type_JavaLangString);
                  } else {
                    paramQQAppInterface.a().a(paramForwardFileInfo.b(), paramSessionInfo.jdField_a_of_type_JavaLangString);
                  }
                }
                else {
                  paramQQAppInterface.a().a(paramForwardFileInfo.b(), paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon)
  {
    if (paramEmoticon == null) {
      Toast.makeText(paramContext, "emoticon is null.", 0).show();
    }
    do
    {
      return;
      if (((paramEmoticon.jobType == 0) || (paramEmoticon.jobType == 2)) && (!paramEmoticon.hasEncryptKey()))
      {
        Toast.makeText(paramContext, "emoticon Encrypt Key is null.", 0).show();
        return;
      }
      paramContext = ((EmoticonManager)paramQQAppInterface.getManager(13)).a(paramEmoticon.epId);
    } while (paramContext == null);
    MarkFaceMessage localMarkFaceMessage = new MarkFaceMessage();
    localMarkFaceMessage.cSubType = paramContext.type;
    localMarkFaceMessage.sbufID = EmosmUtils.eId2Byte(paramEmoticon.eId, paramEmoticon.jobType);
    localMarkFaceMessage.dwTabID = Integer.valueOf(paramEmoticon.epId).intValue();
    localMarkFaceMessage.sbfKey = paramEmoticon.encryptKey.getBytes();
    localMarkFaceMessage.imageWidth = paramEmoticon.width;
    localMarkFaceMessage.imageHeight = paramEmoticon.height;
    localMarkFaceMessage.faceName = paramEmoticon.name;
    if (paramEmoticon.isSound) {
      localMarkFaceMessage.mediaType = 1;
    }
    if (paramEmoticon.jobType == 1) {
      localMarkFaceMessage.mediaType = 2;
    }
    if (1 == paramContext.type) {
      localMarkFaceMessage.cSubType = 3;
    }
    if ((paramEmoticon.jobType == 2) && (paramEmoticon.magicValue != null)) {
      localMarkFaceMessage.mobileparam = paramEmoticon.magicValue.getBytes();
    }
    paramContext = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, localMarkFaceMessage);
    paramContext.sendFaceName = paramEmoticon.name;
    if (paramContext.istroop == 1) {
      AnonymousChatHelper.a().a(paramContext);
    }
    for (;;)
    {
      paramQQAppInterface.a().a(paramContext, null);
      a(paramQQAppInterface, paramEmoticon);
      return;
      if (AnonymousChatHelper.a().jdField_a_of_type_Boolean) {
        AnonymousChatHelper.a().jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, long paramLong)
  {
    paramContext = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    if (paramContext != null)
    {
      paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
      paramContext = MessageRecordFactory.a(paramContext);
      paramQQAppInterface.a().a(paramContext, null, true);
      a(paramQQAppInterface, paramEmoticon);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "reSendEmosmMessage : mr is null.");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    if (paramString == null) {
      return;
    }
    ImageUtil.a(-1L, paramSessionInfo.jdField_a_of_type_Int, true, "image_send_prepare", "ChatActivity.sendCustomEmotion");
    if (!FileUtils.b(paramString))
    {
      ChatActivityUtils.a(paramContext, 2131363432, 0);
      ImageUtil.a(-1L, paramSessionInfo.jdField_a_of_type_Int, true, "image_send_prepared_failed", "ChatActivity.sendCustomEmotion");
      return;
    }
    paramContext = new PicUploadInfo.Builder();
    paramContext.a(paramString);
    paramContext.d(1006);
    paramContext.d(paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramContext.c(TranDbRecord.PicDbRecord.e);
    paramContext.e(paramSessionInfo.jdField_b_of_type_JavaLangString);
    paramContext.c(paramQQAppInterface.a());
    paramContext.e(paramSessionInfo.jdField_a_of_type_Int);
    paramSessionInfo = PicBusiManager.a(1, 1006);
    paramSessionInfo.a(paramContext.a());
    PicBusiManager.a(paramSessionInfo, paramQQAppInterface);
    new abk(paramQQAppInterface, paramString).execute(new Void[0]);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, int paramInt, long paramLong)
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      ChatActivityUtils.a(paramContext, 2131362790, 0);
      return;
    }
    paramSessionInfo = paramQQAppInterface.a().a(paramString, paramInt, paramLong);
    if (paramSessionInfo == null)
    {
      ChatActivityUtils.a(paramContext, 2131363388, 0);
      return;
    }
    if (paramSessionInfo.isSendFromLocal()) {
      paramQQAppInterface.a().d(paramQQAppInterface.a().a(paramSessionInfo.frienduin, paramSessionInfo.uniseq));
    }
    paramContext = StructMsgFactory.a(paramSessionInfo.msgData);
    paramQQAppInterface.a().b(paramString, paramInt, paramLong);
    if ((paramContext instanceof StructMsgForImageShare))
    {
      StructMsgForImageShare.resendAndUploadImageShare(paramQQAppInterface, paramSessionInfo, (StructMsgForImageShare)paramContext);
      return;
    }
    paramContext = MessageRecordFactory.a(paramSessionInfo);
    paramQQAppInterface.a().a(paramContext, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, long paramLong)
  {
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) && (((TroopGagMgr)paramQQAppInterface.getManager(42)).a(paramSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean) && ((paramContext instanceof ChatActivity)))
    {
      paramContext = (ChatActivity)paramContext;
      QQToast.a(paramQQAppInterface.a(), 2131362553, 0).b(paramContext.getTitleBarHeight());
      return;
    }
    paramContext = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    if (paramContext != null)
    {
      long l = paramContext.msgseq;
      if (paramContext.isSendFromLocal()) {
        paramQQAppInterface.a().d(paramQQAppInterface.a().a(paramContext.frienduin, paramContext.uniseq));
      }
    }
    paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    paramContext = MessageRecordFactory.a(paramContext);
    paramQQAppInterface.a().a(paramContext, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, String paramString4)
  {
    if (FileUtils.b(paramString1)) {
      ForwardSendPicUtil.a(paramQQAppInterface, paramString1, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_b_of_type_JavaLangString, false, paramContext);
    }
    long l1;
    long l2;
    do
    {
      do
      {
        return;
        l1 = a(paramQQAppInterface, paramString1, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramString2, paramString3, paramLong, paramInt);
        paramContext = paramQQAppInterface.a().a(paramString3, paramLong);
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "ChatActivity.handleForwardData forwardPic wait for download1,uniseq:" + l1 + ",filePath:" + paramString1 + ",forwardImageOrgServerpath:" + paramString2 + ",forwardImageOrgItemId:" + paramLong + ",processor:" + paramContext);
        }
      } while ((paramContext == null) || (!(paramContext instanceof BaseTransProcessor)));
      paramContext = (BaseTransProcessor)paramContext;
      l2 = paramContext.c();
      if (QLog.isColorLevel()) {
        QLog.d("streamptt", 2, "ChatActivity.handleForwardData forwardPic wait for download2,msgId:" + l1 + ",filePath:" + paramString1 + ",get download process status:" + l2);
      }
    } while ((l2 != 2000L) && (l2 != 2001L) && (l2 != 2002L));
    paramQQAppInterface.a().a(l1, paramString4, paramQQAppInterface, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, paramString1, paramString2, paramString3, paramLong, paramInt);
    paramContext.a().o = paramString4;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " sendMessage start currenttime:" + System.currentTimeMillis());
    }
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return;
      a(paramQQAppInterface, paramSessionInfo, paramString, paramArrayList);
      new abl(paramQQAppInterface, paramString).execute(new Void[0]);
      paramQQAppInterface.a().f(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
    } while (!QLog.isColorLevel());
    QLog.d("SendMsgBtn", 2, " sendMessage end currenttime:" + System.currentTimeMillis());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, List paramList)
  {
    Object localObject1 = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("single_way_friend_list", "");
    if (android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        String str = (String)paramList.next();
        int i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
          if ((((JSONObject)localObject2).has("uin")) && (((JSONObject)localObject2).has("type")) && (((JSONObject)localObject2).getString("uin").equals(MsgProxyUtils.a(str))))
          {
            localObject2 = paramQQAppInterface.a().a(str, 0);
            ChatActivityUtils.a(paramContext, str, 0);
            localObject2 = ((List)localObject2).iterator();
            if (((Iterator)localObject2).hasNext())
            {
              MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
              if (localMessageRecord.msgtype != -2019) {
                continue;
              }
              paramQQAppInterface.a().b(str, localMessageRecord.istroop, localMessageRecord.uniseq);
              continue;
            }
          }
          i += 1;
        }
      }
      catch (JSONException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    Iterator localIterator = TestStructMsg.a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (StructMsgForGeneralShare)localIterator.next();
      String str = paramQQAppInterface.a();
      int i = MobileQQService.jdField_c_of_type_Int;
      MobileQQService.jdField_c_of_type_Int = i + 1;
      long l = i;
      localObject = MessageRecordFactory.a(paramQQAppInterface, str, paramSessionInfo.jdField_a_of_type_JavaLangString, str, paramSessionInfo.jdField_a_of_type_Int, l, (AbsStructMsg)localObject);
      if (!MessageHandlerUtils.a(paramQQAppInterface, (MessageRecord)localObject, false)) {
        paramQQAppInterface.a().b((MessageRecord)localObject, ((MessageRecord)localObject).selfuin);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ChatAdapter1 paramChatAdapter1, long paramLong)
  {
    Object localObject = (FriendManager)paramQQAppInterface.getManager(8);
    if ((paramSessionInfo.jdField_a_of_type_Int != 1) || (((FriendManager)localObject).f(paramSessionInfo.jdField_a_of_type_JavaLangString))) {}
    label151:
    for (;;)
    {
      return;
      int i = 0;
      if (i < paramChatAdapter1.getCount())
      {
        localObject = (ChatMessage)paramChatAdapter1.getItem(i);
        if ((localObject == null) || (MsgProxyUtils.i(((ChatMessage)localObject).msgtype))) {}
      }
      for (long l = ((ChatMessage)localObject).shmsgseq;; l = 0L)
      {
        if (l <= 1L + paramLong) {
          break label151;
        }
        paramChatAdapter1 = paramQQAppInterface.a();
        localObject = (MessageForTroopUnreadTips)MessageRecordFactory.a(-4009);
        ((MessageForTroopUnreadTips)localObject).init(paramChatAdapter1, paramSessionInfo.jdField_a_of_type_JavaLangString, paramChatAdapter1, "", MessageCache.a(), -4009, 1, 0L);
        paramQQAppInterface.a().a((MessageRecord)localObject, paramChatAdapter1);
        return;
        i += 1;
        break;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForFunnyFace paramMessageForFunnyFace)
  {
    paramQQAppInterface.a().b(paramMessageForFunnyFace.frienduin, paramMessageForFunnyFace.msgtype, paramMessageForFunnyFace.uniseq);
    paramSessionInfo = MessageRecordFactory.a(paramMessageForFunnyFace);
    paramQQAppInterface.a().a(paramSessionInfo, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AbsStructMsg paramAbsStructMsg)
  {
    switch (paramSessionInfo.jdField_a_of_type_Int)
    {
    }
    for (String str1 = paramQQAppInterface.a();; str1 = paramSessionInfo.jdField_b_of_type_JavaLangString)
    {
      String str2 = paramQQAppInterface.a();
      String str3 = paramSessionInfo.jdField_a_of_type_JavaLangString;
      int i = paramSessionInfo.jdField_a_of_type_Int;
      int j = MobileQQService.jdField_c_of_type_Int;
      MobileQQService.jdField_c_of_type_Int = j + 1;
      paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, str2, str3, str1, i, j, paramAbsStructMsg);
      paramQQAppInterface.a().a(paramSessionInfo, null);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    int i = Math.abs(new Random().nextInt());
    int j = MobileQQService.jdField_c_of_type_Int;
    MobileQQService.jdField_c_of_type_Int = j + 1;
    a(paramQQAppInterface, paramSessionInfo, paramString, j, 1010, false, (byte)1, (byte)0, (short)0, i, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt, long paramLong)
  {
    if (paramLong != -1L)
    {
      Object localObject = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
      if ((localObject instanceof MessageForPtt))
      {
        localObject = (MessageForPtt)localObject;
        ((MessageForPtt)localObject).url = paramString;
        ((MessageForPtt)localObject).fileSize = paramInt;
        ((MessageForPtt)localObject).isread = false;
        ((MessageForPtt)localObject).itemType = 2;
        ((MessageForPtt)localObject).serial();
        paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong, ((MessageForPtt)localObject).msgData);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, long paramLong)
  {
    long l;
    if (paramLong > 0L)
    {
      l = paramLong;
      l += 1L;
      if (paramLong <= 0L) {
        break label69;
      }
    }
    label69:
    for (paramLong = MobileQQService.jdField_c_of_type_Int;; paramLong = l)
    {
      MobileQQService.jdField_c_of_type_Int = (int)paramLong;
      a(paramQQAppInterface, paramSessionInfo, paramString, l, 1010, false, (byte)1, (byte)0, (short)0, Math.abs(new Random().nextInt()));
      return;
      l = MobileQQService.jdField_c_of_type_Int;
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, long paramLong, int paramInt1, boolean paramBoolean, byte paramByte1, byte paramByte2, short paramShort, int paramInt2)
  {
    b(paramQQAppInterface, paramSessionInfo, paramString, paramLong, paramInt1, paramBoolean, paramByte1, paramByte2, paramShort, paramInt2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, long paramLong, int paramInt1, boolean paramBoolean, byte paramByte1, byte paramByte2, short paramShort, int paramInt2, ArrayList paramArrayList)
  {
    b(paramQQAppInterface, paramSessionInfo, paramString, paramLong, paramInt1, paramBoolean, paramByte1, paramByte2, paramShort, paramInt2, paramArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2)
  {
    if (paramSessionInfo == null) {}
    while (paramString1 == null) {
      return;
    }
    paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
    paramSessionInfo.path = paramString1;
    paramSessionInfo.size = 0L;
    paramSessionInfo.type = 1;
    paramSessionInfo.isRead = true;
    paramSessionInfo.serial();
    ((SVIPHandler)paramQQAppInterface.a(12)).a(paramSessionInfo);
    paramQQAppInterface.a().a(paramSessionInfo, paramQQAppInterface.a());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3)
  {
    a(paramQQAppInterface, paramSessionInfo, "我在这里，点击查看：http://maps.google.com/maps?q=" + paramString1 + "," + paramString2 + "&iwloc=A&hl=zh-CN (" + paramString3 + ")");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createTextMessageToshow start currenttime:" + System.currentTimeMillis());
    }
    int i = MobileQQService.jdField_c_of_type_Int;
    MobileQQService.jdField_c_of_type_Int = i + 1;
    long l = i;
    ArrayList localArrayList = new ArrayList();
    paramArrayList = Utils.a(paramString, 560, 20, paramArrayList, localArrayList);
    boolean bool;
    short s2;
    Random localRandom;
    short s1;
    label196:
    int j;
    label311:
    String str;
    if (paramArrayList.size() > 1)
    {
      bool = true;
      s2 = 0;
      localRandom = new Random();
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 1 seq = " + l + " partAtInfoArrayLists.size() = " + localArrayList.size() + " partArray.size() = " + paramArrayList.size() + " isDivide = " + bool + " currenttime:" + System.currentTimeMillis());
      }
      if (bool)
      {
        s1 = (short)(byte)(int)l;
        i = 0;
        s2 = s1;
        if (paramQQAppInterface.a().a(paramQQAppInterface.getAccount(), paramSessionInfo.jdField_a_of_type_Int, s1))
        {
          if (i <= 10) {
            break label439;
          }
          s2 = (short)(byte)paramQQAppInterface.a().a(paramQQAppInterface.getAccount(), paramSessionInfo.jdField_a_of_type_Int);
        }
        paramQQAppInterface.a().a(paramQQAppInterface.getAccount(), paramSessionInfo.jdField_a_of_type_Int, s2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 2 currenttime:" + System.currentTimeMillis());
      }
      j = Math.abs(localRandom.nextInt());
      i = 0;
      if (i >= paramArrayList.size()) {
        break label465;
      }
      str = (String)paramArrayList.get(i);
      if (localArrayList.size() <= i) {
        break label460;
      }
    }
    label439:
    label460:
    for (paramString = (ArrayList)localArrayList.get(i);; paramString = null)
    {
      if ((paramSessionInfo.jdField_a_of_type_Int == 3000) || (paramSessionInfo.jdField_a_of_type_Int == 1)) {
        j = Math.abs(localRandom.nextInt());
      }
      a(paramQQAppInterface, paramSessionInfo, str, l, -1000, bool, (byte)paramArrayList.size(), (byte)i, s2, j, paramString);
      int k = MobileQQService.jdField_c_of_type_Int;
      MobileQQService.jdField_c_of_type_Int = k + 1;
      l = k;
      i += 1;
      break label311;
      bool = false;
      break;
      s1 = (short)(byte)Math.abs(localRandom.nextInt());
      i += 1;
      break label196;
    }
    label465:
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 3 currenttime:" + System.currentTimeMillis());
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createTextMessageToshow end currenttime:" + System.currentTimeMillis());
    }
  }
  
  @TargetApi(9)
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    int i = paramSessionInfo.jdField_a_of_type_Int;
    if ((i == 0) || (i == 1) || (i == 3000) || (i == 1001) || (i == 1006) || (i == 1004) || (i == 1000) || (i == 3))
    {
      localObject1 = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0);
      if (paramBoolean) {
        break label176;
      }
      long l = ((SharedPreferences)localObject1).getLong("last_pull_individual_expire_info_time", 0L);
      if (System.currentTimeMillis() - l <= 86400000L) {
        break label176;
      }
      localObject2 = (IndividualExpireInfoHandler)paramQQAppInterface.a(34);
      if (localObject2 == null) {
        break label176;
      }
      ((IndividualExpireInfoHandler)localObject2).a();
      if (Build.VERSION.SDK_INT > 8) {
        break label152;
      }
      ((SharedPreferences)localObject1).edit().putLong("last_pull_individual_expire_info_time", System.currentTimeMillis()).commit();
    }
    label152:
    label176:
    do
    {
      return;
      ((SharedPreferences)localObject1).edit().putLong("last_pull_individual_expire_info_time", System.currentTimeMillis()).apply();
      return;
      i = ((SharedPreferences)localObject1).getInt("renewal_tail_tip_exit", 0);
    } while (i == 0);
    Object localObject2 = ((SharedPreferences)localObject1).getString("renewal_tail_tip", "");
    Object localObject1 = ((SharedPreferences)localObject1).edit();
    ((SharedPreferences.Editor)localObject1).putInt("renewal_tail_tip_exit", 0);
    if (Build.VERSION.SDK_INT <= 8) {
      ((SharedPreferences.Editor)localObject1).commit();
    }
    for (;;)
    {
      MsgProxyUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, -4020);
      paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramQQAppInterface.a(), paramSessionInfo.jdField_a_of_type_Int, -4020, (String)localObject2);
      ReportController.b(paramQQAppInterface, "CliOper", "", paramSessionInfo.jdField_a_of_type_JavaLangString, "aio_pay", "aio_show", 0, 0, "" + i, "", "", "");
      return;
      ((SharedPreferences.Editor)localObject1).apply();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = StructMsgFactory.a(paramArrayOfByte);
      if (paramArrayOfByte != null)
      {
        str = paramQQAppInterface.a();
        i = MobileQQService.jdField_c_of_type_Int;
        MobileQQService.jdField_c_of_type_Int = i + 1;
        l = i;
        paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, str, paramSessionInfo.jdField_a_of_type_JavaLangString, str, paramSessionInfo.jdField_a_of_type_Int, l, paramArrayOfByte);
        paramQQAppInterface.a().a(paramSessionInfo, null);
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i;
      long l;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("structMsg", 2, "forward structMsg msgobj is null");
      return;
    }
    QLog.d("structMsg", 2, "forward structMsg data is null");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface.a().b(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
    if (paramChatMessage.isSendFromLocal()) {
      paramQQAppInterface.a().d(paramQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, CharSequence paramCharSequence)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " decodeToSaveEmoIndex start currenttime:" + System.currentTimeMillis());
    }
    if (paramCharSequence == null) {
      return;
    }
    Object localObject1;
    ArrayList localArrayList;
    int j;
    int i;
    label111:
    Object localObject3;
    int k;
    RecentEmotionData localRecentEmotionData;
    if ((paramCharSequence instanceof QQText))
    {
      localObject1 = (QQText)paramCharSequence;
      paramCharSequence.length();
      paramCharSequence = paramQQAppInterface.a().createEntityManager();
      localArrayList = new ArrayList();
      localObject2 = (QQText.EmotcationSpan[])((QQText)localObject1).getSpans(0, ((QQText)localObject1).length(), QQText.EmotcationSpan.class);
      localObject1 = new ArrayList();
      j = localObject2.length;
      i = 0;
      if (i >= j) {
        break label312;
      }
      localObject3 = localObject2[i];
      k = ((QQText.EmotcationSpan)localObject3).a();
      if (((QQText.EmotcationSpan)localObject3).jdField_a_of_type_Boolean) {
        break label235;
      }
      localObject3 = "0," + k;
      if (!((ArrayList)localObject1).contains(localObject3))
      {
        localRecentEmotionData = new RecentEmotionData();
        a(localRecentEmotionData, paramQQAppInterface.a(), 0, 0, k, null);
        localArrayList.add(localRecentEmotionData);
        ((ArrayList)localObject1).add(localObject3);
      }
    }
    for (;;)
    {
      i += 1;
      break label111;
      localObject1 = new QQText(paramCharSequence.toString(), 3);
      break;
      label235:
      localObject3 = "4," + k;
      if (!((ArrayList)localObject1).contains(localObject3))
      {
        localRecentEmotionData = new RecentEmotionData();
        a(localRecentEmotionData, paramQQAppInterface.a(), 0, 4, k, null);
        localArrayList.add(localRecentEmotionData);
        ((ArrayList)localObject1).add(localObject3);
      }
    }
    label312:
    Object localObject2 = paramCharSequence.a();
    for (;;)
    {
      try
      {
        ((EntityTransaction)localObject2).a();
        paramQQAppInterface = paramCharSequence.a(RecentEmotionData.class, false, null, null, null, null, null, null);
        if (paramQQAppInterface != null) {
          break label802;
        }
        paramQQAppInterface = new ArrayList();
        k = 0;
        i = 0;
        if (paramQQAppInterface.size() > 0)
        {
          j = 0;
          k = i;
          if (j < paramQQAppInterface.size())
          {
            localObject3 = (RecentEmotionData)paramQQAppInterface.get(j);
            if (((ArrayList)localObject1).contains(((RecentEmotionData)localObject3).type + "," + ((RecentEmotionData)localObject3).emoIndex))
            {
              paramCharSequence.b((Entity)localObject3);
              paramQQAppInterface.remove(localObject3);
              j -= 1;
              break label805;
            }
            if (((RecentEmotionData)localObject3).emoId <= i) {
              break label799;
            }
            i = ((RecentEmotionData)localObject3).emoId;
            break label805;
          }
        }
        i = 0;
        localObject1 = new ArrayList();
        j = 0;
        if (j < 100)
        {
          int m = localArrayList.size() - 1 - j;
          if (m >= 0)
          {
            ((List)localObject1).add((RecentEmotionData)localArrayList.get(m));
            i += 1;
            break label812;
          }
        }
        else
        {
          j = paramQQAppInterface.size() + i - 100;
          if (j > 0)
          {
            i = 0;
            if (i < paramQQAppInterface.size())
            {
              if (i >= j) {
                break label819;
              }
              paramCharSequence.b((RecentEmotionData)paramQQAppInterface.get(i));
              break label819;
            }
          }
          i = ((List)localObject1).size() - 1;
          if (i >= 0)
          {
            paramQQAppInterface = (RecentEmotionData)((List)localObject1).get(i);
            k += 1;
            paramQQAppInterface.emoId = k;
            paramCharSequence.a(paramQQAppInterface);
            i -= 1;
            continue;
          }
          ((EntityTransaction)localObject2).c();
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "add Recent Emoticon error", paramQQAppInterface);
        }
        return;
      }
      finally
      {
        if (QLog.isColorLevel()) {
          QLog.d("SendMsgBtn", 2, " decodeToSaveEmoIndex end currenttime:" + System.currentTimeMillis());
        }
        ((EntityTransaction)localObject2).b();
        paramCharSequence.a();
      }
      break label812;
      label799:
      break label805;
      label802:
      continue;
      label805:
      j += 1;
      continue;
      label812:
      j += 1;
      continue;
      label819:
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    List localList = localEntityManager.a(RecentEmotionData.class, false, null, null, null, null, null, null);
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    if (a((List)localObject, 3, 0, paramString) < 0) {
      b(paramQQAppInterface, localEntityManager, 3, 0, paramString, (List)localObject);
    }
    localEntityManager.a();
  }
  
  public static void a(RecentEmotionData paramRecentEmotionData, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    paramRecentEmotionData.uin = paramString1;
    paramRecentEmotionData.emoId = paramInt1;
    paramRecentEmotionData.type = paramInt2;
    paramRecentEmotionData.emoIndex = paramInt3;
    paramRecentEmotionData.emoPath = paramString2;
  }
  
  public static void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt)
  {
    if ((!AppSetting.n) && (paramInt == 0)) {
      return;
    }
    paramQQCustomMenu.a(2131298932, paramContext.getString(2131363076));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageForLongMsg paramMessageForLongMsg)
  {
    paramContext = paramMessageForLongMsg.longMsgFragmentList;
    if ((paramContext == null) || (paramContext.isEmpty())) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      paramMessageForLongMsg = (MessageRecord)paramContext.next();
      if (paramMessageForLongMsg.extraflag == 32768)
      {
        if (paramMessageForLongMsg.isSendFromLocal()) {
          paramQQAppInterface.a().d(paramQQAppInterface.a().a(paramMessageForLongMsg.frienduin, paramMessageForLongMsg.uniseq));
        }
        paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramMessageForLongMsg.uniseq);
        if (paramMessageForLongMsg.msgtype == -1000)
        {
          paramMessageForLongMsg = MessageRecordFactory.a(paramMessageForLongMsg);
          paramQQAppInterface.a().a(paramMessageForLongMsg, null, true);
        }
      }
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Emoticon paramEmoticon)
  {
    ThreadManager.b(new abq(paramQQAppInterface, paramEmoticon));
    return true;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.a().a(paramString, paramInt, paramLong);
    if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof MessageForPtt))) {
      return ((MessageForPtt)paramQQAppInterface).c2cViaOffline;
    }
    return false;
  }
  
  public static boolean a(RecentEmotionData paramRecentEmotionData, int paramInt1, int paramInt2, String paramString)
  {
    if (paramRecentEmotionData == null) {}
    do
    {
      do
      {
        do
        {
          return false;
        } while (paramRecentEmotionData.type != paramInt1);
        if ((paramInt1 == 3) && (paramString != null) && (paramString.equalsIgnoreCase(paramRecentEmotionData.emoPath))) {
          return true;
        }
      } while (paramRecentEmotionData.emoIndex != paramInt2);
      if ((paramRecentEmotionData.emoPath == null) && (paramString == null)) {
        return true;
      }
    } while ((paramRecentEmotionData.emoPath == null) || (paramString == null) || (!paramRecentEmotionData.emoPath.equalsIgnoreCase(paramString)));
    return true;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    int i = MobileQQService.jdField_c_of_type_Int;
    MobileQQService.jdField_c_of_type_Int = i + 1;
    long l = i;
    String str = paramQQAppInterface.a();
    paramSessionInfo = MessageRecordFactory.a(str, paramSessionInfo.jdField_a_of_type_JavaLangString, str, paramSessionInfo.jdField_a_of_type_Int, l);
    paramQQAppInterface.a().a(paramSessionInfo, null);
    if ((paramContext instanceof ChatActivity)) {
      ((ChatActivity)paramContext).a().a(paramSessionInfo);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.shakemsg", 2, "create new shake message,shmsgseq is:" + paramSessionInfo.shmsgseq + ",msgUid is:" + paramSessionInfo.msgUid + ",time is:" + System.currentTimeMillis());
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString, null);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    Friends localFriends;
    RichStatus localRichStatus;
    if (paramSessionInfo.jdField_a_of_type_Int == 0)
    {
      localFriends = ((FriendManager)paramQQAppInterface.getManager(8)).c(paramSessionInfo.jdField_a_of_type_JavaLangString);
      if (localFriends == null) {
        break label925;
      }
      localRichStatus = localFriends.getRichStatus();
      if (localFriends.richTime != 0L) {
        break label66;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOSign", 2, "richTime is 0,do not insert this sign msg");
      }
    }
    label66:
    long l;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AIOSign", 2, "richTime is:" + localFriends.richTime);
      }
      l = System.currentTimeMillis() - localFriends.richTime * 1000L;
      if ((l > 604800000L) || (l < 0L)) {
        break label880;
      }
      l = paramQQAppInterface.a().e(paramSessionInfo.jdField_a_of_type_JavaLangString);
      if (localFriends.richTime > l) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "----------insertSignMsgIfNeeded feedTime<=lastTime friendUin: " + paramSessionInfo.jdField_a_of_type_JavaLangString + " feedTime: " + localFriends.richTime + " lastfeedTime: " + localFriends.richTime);
    return;
    Object localObject1 = new JSONObject();
    for (;;)
    {
      int i;
      try
      {
        ((JSONObject)localObject1).put("ver", "1.0");
        ((JSONObject)localObject1).put("time", String.valueOf(localFriends.richTime));
        if ((localRichStatus.jdField_c_of_type_JavaLangString != null) && (localRichStatus.jdField_c_of_type_JavaLangString.trim().length() > 0))
        {
          ((JSONObject)localObject1).put("aid", String.valueOf(localRichStatus.jdField_b_of_type_Int));
          ((JSONObject)localObject1).put("actiontext", localRichStatus.jdField_c_of_type_JavaLangString);
        }
        if ((localRichStatus.jdField_d_of_type_JavaLangString != null) && (localRichStatus.jdField_d_of_type_JavaLangString.trim().length() > 0))
        {
          ((JSONObject)localObject1).put("did", String.valueOf(localRichStatus.jdField_c_of_type_Int));
          ((JSONObject)localObject1).put("datatext", localRichStatus.jdField_d_of_type_JavaLangString);
        }
        ((JSONObject)localObject1).put("loctextpos", String.valueOf(localRichStatus.jdField_d_of_type_Int));
        if ((localRichStatus.a != null) && (localRichStatus.a.size() > 0))
        {
          int j = localRichStatus.a.size();
          localObject2 = new JSONArray();
          i = 0;
          if (i < j)
          {
            String str = (String)localRichStatus.a.get(i);
            if ((str == null) || (str.trim().length() <= 0)) {
              break label962;
            }
            ((JSONArray)localObject2).put(str);
            break label962;
          }
          if (((JSONArray)localObject2).length() > 0) {
            ((JSONObject)localObject1).put("plaintext", localObject2);
          }
        }
        if ((localRichStatus.e != null) && (localRichStatus.e.trim().length() > 0)) {
          ((JSONObject)localObject1).put("loctext", localRichStatus.e);
        }
        if (((JSONObject)localObject1).length() > 3) {
          break label652;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "sign is empty,rs.actionText is:" + localRichStatus.jdField_c_of_type_JavaLangString + ",rs.dataText is:" + localRichStatus.jdField_d_of_type_JavaLangString + ",rs.plainText is:" + localRichStatus.a + ",rs.locationText is:" + localRichStatus.e);
        return;
      }
      catch (JSONException paramQQAppInterface) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "insertSignMsgIfNeeded failed,error msg is:" + paramQQAppInterface.getMessage(), paramQQAppInterface);
      return;
      label652:
      localObject1 = ((JSONObject)localObject1).toString();
      Object localObject2 = MessageRecordFactory.a(-1034);
      l = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
      ((MessageRecord)localObject2).init(paramQQAppInterface.a(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject1, l, -1034, paramSessionInfo.jdField_a_of_type_Int, l);
      ((MessageRecord)localObject2).isread = true;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "----------addFriendFeedMsg  friendUin: " + paramSessionInfo.jdField_a_of_type_JavaLangString + " msgTime: " + ((MessageRecord)localObject2).time);
      }
      if (!MessageHandlerUtils.a(paramQQAppInterface, (MessageRecord)localObject2, false)) {
        paramQQAppInterface.a().a((MessageRecord)localObject2, ((MessageRecord)localObject2).selfuin);
      }
      paramQQAppInterface.a().e(paramSessionInfo.jdField_a_of_type_JavaLangString, localFriends.richTime);
      if ((localRichStatus.jdField_c_of_type_JavaLangString != null) && (localRichStatus.jdField_c_of_type_JavaLangString.trim().length() > 0)) {}
      for (paramSessionInfo = String.valueOf(localRichStatus.jdField_b_of_type_Int);; paramSessionInfo = "normalsign")
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "Rich_status", "card_exposure_aio", 0, 0, "", "", paramSessionInfo, "");
        return;
      }
      label880:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOSign", 2, "intervalTime is:" + l / 86400000L + ",do not insert this sign msg");
      return;
      label925:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("AIOSign", 2, "f is null,insert sign msg failed,curFriendUin is:" + paramSessionInfo.jdField_a_of_type_JavaLangString);
      return;
      label962:
      i += 1;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, long paramLong, int paramInt1, boolean paramBoolean, byte paramByte1, byte paramByte2, short paramShort, int paramInt2)
  {
    String str1 = "";
    if (paramString != null) {
      str1 = MessageUtils.a(paramString, true);
    }
    paramInt1 = (int)MessageCache.a();
    String str2 = paramQQAppInterface.a();
    long l = MessageUtils.a(paramInt2);
    if ((paramSessionInfo.jdField_a_of_type_Int == 1004) || (paramSessionInfo.jdField_a_of_type_Int == 1020) || (paramSessionInfo.jdField_a_of_type_Int == 1000)) {
      paramString = paramSessionInfo.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      ChatMessage localChatMessage = (ChatMessage)MessageRecordFactory.a(-1000);
      localChatMessage.init(str2, paramSessionInfo.jdField_a_of_type_JavaLangString, paramString, str1, paramInt1, -1000, paramSessionInfo.jdField_a_of_type_Int, paramLong);
      localChatMessage.longMsgCount = paramByte1;
      localChatMessage.longMsgIndex = paramByte2;
      localChatMessage.longMsgId = paramShort;
      localChatMessage.isread = true;
      localChatMessage.msgUid = l;
      localChatMessage.shmsgseq = MessageUtils.a(paramLong, paramSessionInfo.jdField_a_of_type_Int);
      localChatMessage.issend = 1;
      localChatMessage.mAnimFlag = true;
      paramQQAppInterface.a().a(localChatMessage, null);
      return;
      if (paramSessionInfo.jdField_a_of_type_Int == 1006) {
        paramString = paramSessionInfo.e;
      } else {
        paramString = str2;
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, long paramLong, int paramInt1, boolean paramBoolean, byte paramByte1, byte paramByte2, short paramShort, int paramInt2, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createMsgQueueAndSend start currenttime:" + System.currentTimeMillis() + " sessionInfo.entrance:" + paramSessionInfo.jdField_c_of_type_Int);
    }
    String str1 = "";
    if (paramString != null) {
      str1 = MessageUtils.a(paramString, true, paramArrayList);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createMsgQueueAndSend step 1  currenttime:" + System.currentTimeMillis());
    }
    paramInt1 = (int)MessageCache.a();
    String str2 = paramQQAppInterface.a();
    long l = MessageUtils.a(paramInt2);
    if ((paramSessionInfo.jdField_a_of_type_Int == 1004) || (paramSessionInfo.jdField_a_of_type_Int == 1020) || (paramSessionInfo.jdField_a_of_type_Int == 1000)) {
      paramString = paramSessionInfo.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " createMsgQueueAndSend step 2 time = " + paramInt1 + " selfUin = " + str2 + " senderUin = " + paramString + " msgUid = " + l + " currenttime:" + System.currentTimeMillis());
      }
      ChatMessage localChatMessage = (ChatMessage)MessageRecordFactory.a(-1000);
      localChatMessage.init(str2, paramSessionInfo.jdField_a_of_type_JavaLangString, paramString, str1, paramInt1, -1000, paramSessionInfo.jdField_a_of_type_Int, paramLong);
      localChatMessage.longMsgCount = paramByte1;
      localChatMessage.longMsgIndex = paramByte2;
      localChatMessage.longMsgId = paramShort;
      localChatMessage.isread = true;
      localChatMessage.msgUid = l;
      localChatMessage.shmsgseq = MessageUtils.a(paramLong, paramSessionInfo.jdField_a_of_type_Int);
      localChatMessage.issend = 1;
      localChatMessage.mAnimFlag = true;
      paramString = (MessageForText)localChatMessage;
      paramString.msgVia = paramSessionInfo.jdField_c_of_type_Int;
      if (paramArrayList != null) {
        paramString.atInfoList = paramArrayList;
      }
      if (localChatMessage.istroop == 1) {
        AnonymousChatHelper.a().a(localChatMessage);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SendMsgBtn", 2, " createMsgQueueAndSend step 3  currenttime:" + System.currentTimeMillis());
        }
        paramQQAppInterface.a().a(localChatMessage, null);
        if (QLog.isColorLevel()) {
          QLog.d("SendMsgBtn", 2, " createMsgQueueAndSend end currenttime:" + System.currentTimeMillis());
        }
        return;
        if (paramSessionInfo.jdField_a_of_type_Int != 1006) {
          break label488;
        }
        paramString = paramSessionInfo.e;
        break;
        if (AnonymousChatHelper.a().jdField_a_of_type_Boolean) {
          AnonymousChatHelper.a().jdField_a_of_type_Boolean = false;
        }
      }
      label488:
      paramString = str2;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    FileManagerEntity localFileManagerEntity;
    if ((paramChatMessage instanceof MessageForFile))
    {
      localFileManagerEntity = paramQQAppInterface.a().a(paramChatMessage.uniseq, paramChatMessage.frienduin, paramChatMessage.istroop);
      if ((localFileManagerEntity == null) && (QLog.isColorLevel())) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "why FileManagerEntity is null?! may be is old data!");
      }
      if (paramChatMessage.isSendFromLocal()) {
        paramQQAppInterface.a().d(paramQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq));
      }
      if (localFileManagerEntity != null)
      {
        if (localFileManagerEntity.cloudType != 0) {
          break label145;
        }
        paramQQAppInterface.a().a(localFileManagerEntity.nSessionId);
      }
    }
    for (;;)
    {
      paramQQAppInterface.a().b(localFileManagerEntity);
      if ((localFileManagerEntity != null) && (localFileManagerEntity.bDelInAio) && (localFileManagerEntity.bDelInFM) && (localFileManagerEntity.cloudType == 0)) {
        paramQQAppInterface.a().d(localFileManagerEntity.nSessionId);
      }
      return;
      label145:
      paramQQAppInterface.a().a(localFileManagerEntity.nSessionId);
    }
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, EntityManager paramEntityManager, int paramInt1, int paramInt2, String paramString, List paramList)
  {
    int i = 0;
    if (paramList.size() == 0)
    {
      localRecentEmotionData = new RecentEmotionData();
      a(localRecentEmotionData, paramQQAppInterface.a(), 0, paramInt1, paramInt2, paramString);
      paramEntityManager.a(localRecentEmotionData);
      paramList.add(localRecentEmotionData);
      return true;
    }
    int j = paramList.size();
    if (j == 100)
    {
      while (i < j - 1)
      {
        paramQQAppInterface = (RecentEmotionData)paramList.get(i);
        paramQQAppInterface.type = ((RecentEmotionData)paramList.get(i + 1)).type;
        paramQQAppInterface.emoIndex = ((RecentEmotionData)paramList.get(i + 1)).emoIndex;
        paramQQAppInterface.emoPath = ((RecentEmotionData)paramList.get(i + 1)).emoPath;
        paramEntityManager.a(paramQQAppInterface);
        i += 1;
      }
      paramQQAppInterface = (RecentEmotionData)paramList.get(j - 1);
      a(paramQQAppInterface, paramQQAppInterface.uin, paramQQAppInterface.emoId, paramInt1, paramInt2, paramString);
      paramEntityManager.a(paramQQAppInterface);
      paramList.add(paramQQAppInterface);
      return true;
    }
    RecentEmotionData localRecentEmotionData = new RecentEmotionData();
    a(localRecentEmotionData, paramQQAppInterface.a(), j, paramInt1, paramInt2, paramString);
    paramEntityManager.b(localRecentEmotionData);
    paramList.add(localRecentEmotionData);
    return true;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-4005);
    long l = MessageCache.a();
    localMessageRecord.init(paramQQAppInterface.a(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, BaseApplicationImpl.getContext().getString(2131363127), l, -4005, paramSessionInfo.jdField_a_of_type_Int, l);
    localMessageRecord.isread = true;
    if (!MessageHandlerUtils.a(paramQQAppInterface, localMessageRecord, false)) {
      paramQQAppInterface.a().a(localMessageRecord, localMessageRecord.selfuin);
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    Object localObject1 = new EventItem(18, null);
    ((EventItem)localObject1).eventType = 538052865;
    Object localObject2 = new JceOutputStream();
    ((JceOutputStream)localObject2).setServerEncoding("utf-8");
    ((EventItem)localObject1).writeTo((JceOutputStream)localObject2);
    localObject1 = new String(((JceOutputStream)localObject2).toByteArray());
    localObject2 = paramQQAppInterface.a();
    paramSessionInfo = paramSessionInfo.jdField_a_of_type_JavaLangString;
    paramQQAppInterface = paramQQAppInterface.c();
    int i = MobileQQService.jdField_c_of_type_Int;
    MobileQQService.jdField_c_of_type_Int = i + 1;
    ((MessageHandler)localObject2).a(paramSessionInfo, (String)localObject1, (byte)18, paramQQAppInterface, i, -1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade
 * JD-Core Version:    0.7.0.1
 */