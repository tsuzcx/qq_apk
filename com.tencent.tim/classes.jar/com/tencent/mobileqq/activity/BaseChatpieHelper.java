package com.tencent.mobileqq.activity;

import acbn;
import acei;
import acfp;
import acja;
import aegu;
import aflb;
import ahsz;
import ahta;
import ahtd;
import ahwa;
import ailx;
import aine;
import ajlc;
import ajoo;
import ajpd;
import anaz;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import anre;
import aofe;
import aoff;
import aont;
import apsb;
import apsb.a;
import aptw;
import aqfx;
import aqgv;
import aqhu;
import aqip;
import aqiw;
import aqmr;
import artw;
import aurd;
import ausb;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.utils.VideoUpConfigInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XEditTextEx.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jqs;
import mqq.os.MqqHandler;
import top;
import ujt;
import wki;
import wnf;
import xkx;
import znk;

public class BaseChatpieHelper
{
  private BaseChatPie a;
  boolean aTh = false;
  boolean aTi = false;
  private QQAppInterface app;
  private int bEL = 1;
  private FragmentActivity mActivity;
  private Context mContext;
  private SessionInfo sessionInfo;
  
  public BaseChatpieHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
    this.app = paramBaseChatPie.app;
    this.sessionInfo = paramBaseChatPie.sessionInfo;
    this.mActivity = paramBaseChatPie.mActivity;
    this.mContext = paramBaseChatPie.mContext;
  }
  
  public static int a(String paramString, ChatXListView paramChatXListView, int paramInt, List<ChatMessage> paramList1, List<ChatMessage> paramList2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString, 2, "keepPostionScroll mReadedCnt " + paramInt);
    }
    int k = paramList1.size();
    int i1 = paramList2.size();
    int n = paramChatXListView.getScrollY();
    int m = paramChatXListView.getFirstVisiblePosition();
    int i;
    int j;
    if (paramChatXListView.isOverscrollHeadVisiable())
    {
      i = paramChatXListView.getFirstVisiblePosition() - paramChatXListView.getHeaderViewsCount();
      j = paramInt;
      if (k > 0)
      {
        j = paramInt;
        if (m >= 0)
        {
          if (i1 <= 0) {
            break label748;
          }
          if (i < k) {
            break label741;
          }
          j = k - 1;
          label111:
          i = j;
          if (j >= 0) {
            break label738;
          }
          j += paramChatXListView.getHeaderViewsCount();
          i = j;
          if (j >= 0) {
            break label738;
          }
          i = 0;
          label141:
          long l = ((ChatMessage)paramList1.get(i)).uniseq;
          j = 0;
          label160:
          if (j >= i1) {
            break label732;
          }
          if (((ChatMessage)paramList2.get(j)).uniseq != l) {
            break label419;
          }
          label188:
          if ((j >= 0) || (paramList1.size() <= i + 1)) {
            break label714;
          }
          l = ((ChatMessage)paramList1.get(i + 1)).uniseq;
          k = 0;
          label227:
          if (k >= i1) {
            break label714;
          }
          if (((ChatMessage)paramList2.get(k)).uniseq != l) {
            break label428;
          }
          j = i;
          m = 1;
          i = k;
          k = j;
          j = m;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(paramString, 2, "refreshListAdapter newTop:" + i + " oldScorllY " + n + " oldFirst " + k);
      }
      if (i >= 0)
      {
        k = paramInt + i;
        paramInt = k;
        if (j != 0) {
          paramInt = k - 1;
        }
        if ((n < 0) && (i == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.i(paramString, 2, "springBackOverScrollHeaderView newTop:" + i + " oldScorllY " + n);
          }
          paramChatXListView.springBackOverScrollHeaderView();
          j = paramInt;
        }
        label419:
        label428:
        do
        {
          return j;
          i = paramChatXListView.getFirstVisiblePosition();
          break;
          j += 1;
          break label160;
          k += 1;
          break label227;
          if (n >= 0) {
            break label559;
          }
          j = paramChatXListView.getHeight();
          try
          {
            k = paramChatXListView.getChildAt(paramChatXListView.getHeaderViewsCount()).getBottom();
            k = j - k;
          }
          catch (NullPointerException paramList1)
          {
            for (;;)
            {
              k = paramChatXListView.getHeight();
            }
          }
          paramChatXListView.hideOverScrollHeaderView();
          paramChatXListView.setSelectionFromBottom(paramChatXListView.getHeaderViewsCount() + i, k + n - paramChatXListView.getPaddingBottom());
          j = paramInt;
        } while (!QLog.isColorLevel());
        QLog.i(paramString, 2, "setSelectionFromBottom_1 newTop:" + i + " oldScorllY " + n + " bottom " + k);
        return paramInt;
        label559:
        j = paramChatXListView.getHeight();
        try
        {
          k = paramChatXListView.getChildAt(paramChatXListView.getHeaderViewsCount()).getBottom();
          j -= k;
        }
        catch (NullPointerException paramList1)
        {
          for (;;)
          {
            j = paramChatXListView.getHeight();
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i(paramString, 2, "setSelectionFromBottom_2 newTop:" + i + " oldScorllY " + n + " bottom " + j);
        }
        paramChatXListView.setSelectionFromBottom(i + paramChatXListView.getHeaderViewsCount(), j - paramChatXListView.getPaddingBottom());
        return paramInt;
      }
      if (QLog.isColorLevel()) {
        QLog.i(paramString, 2, "hideOverScrollHeaderView newTop:" + i + " oldScorllY " + n);
      }
      paramChatXListView.hideOverScrollHeaderView();
      return i1;
      label714:
      k = i;
      m = 0;
      i = j;
      j = m;
      continue;
      label732:
      j = -1;
      break label188;
      label738:
      break label141;
      label741:
      j = i;
      break label111;
      label748:
      j = -1;
      k = i;
      m = 0;
      i = j;
      j = m;
    }
  }
  
  public static void a(SessionInfo paramSessionInfo, EditText paramEditText, Button paramButton, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w("BaseChatpieHelper", 2, "exitMsgFilterMode ");
    }
    paramSessionInfo.beA = false;
    paramSessionInfo.aTq = null;
    if (paramBoolean) {
      paramEditText.setText("");
    }
    paramButton.setText(acfp.m(2131703064));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, XEditTextEx paramXEditTextEx, boolean paramBoolean)
  {
    boolean bool2 = true;
    int i = 120;
    int j = VipUtils.a(paramQQAppInterface, null);
    Object localObject;
    boolean bool1;
    if ((j & 0x4) != 0)
    {
      i = xkx.f(paramQQAppInterface, "SVIP_MaxPtt");
      if (paramXEditTextEx.getInputExtras(true).getInt("Channels") != 1)
      {
        paramQQAppInterface = QQRecorder.a();
        localObject = paramXEditTextEx.getInputExtras(true);
        if (paramBoolean) {
          break label191;
        }
        bool1 = true;
        label59:
        ((Bundle)localObject).putBoolean("DoesSupportDirectlyAudio", bool1);
        paramXEditTextEx.getInputExtras(true).putInt("Channels", 1);
        paramXEditTextEx.getInputExtras(true).putInt("SampleRate", paramQQAppInterface.mSampleRate);
        paramXEditTextEx.getInputExtras(true).putInt("TimeLength", i);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("sougouptt params : support = ");
          if (paramBoolean) {
            break label197;
          }
        }
      }
    }
    label191:
    label197:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      QLog.d("BaseChatpieHelper", 2, paramBoolean + "sample = " + paramQQAppInterface.mSampleRate + " max = " + i);
      paramXEditTextEx.mUserData = paramQQAppInterface;
      return;
      if ((j & 0x2) == 0) {
        break;
      }
      i = xkx.f(paramQQAppInterface, "VIP_MaxPtt");
      break;
      bool1 = false;
      break label59;
    }
  }
  
  public static boolean a(Button paramButton, CharSequence paramCharSequence, int paramInt)
  {
    return false;
  }
  
  static boolean a(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.isread) || (paramMessage.isSendFromLocal()) || (paramQQAppInterface.e(paramMessage)) || (top.c(paramQQAppInterface, paramMessage))) {
      return false;
    }
    if (((HotChatManager)paramQQAppInterface.getManager(60)).kj(paramMessage.frienduin)) {
      return false;
    }
    if (paramMessage.istroop == 7220) {
      return false;
    }
    if (1036 == paramMessage.istroop) {
      return false;
    }
    if ((paramMessage.istroop == 1008) && (acbn.blO.equals(paramMessage.senderuin))) {
      return false;
    }
    if ((paramMessage.istroop == 1008) && (acbn.blP.equals(paramMessage.senderuin))) {
      return false;
    }
    if (top.gS(paramMessage.senderuin)) {
      return false;
    }
    if (((paramMessage.istroop == 1001) || (paramMessage.istroop == 10002)) && (top.v(paramMessage))) {
      return false;
    }
    if (top.w(paramMessage)) {
      return false;
    }
    if (paramMessage.msgtype == -2058) {
      return false;
    }
    if ((paramMessage.istroop != 7220) && (TextUtils.equals(paramMessage.frienduin, acbn.blw))) {
      return false;
    }
    if (aegu.ag(paramMessage)) {
      return false;
    }
    if ((aine.aE(paramMessage)) || (aine.aD(paramMessage))) {
      return false;
    }
    if ((paramMessage.istroop == 0) && (FriendsStatusUtil.g(paramMessage.frienduin, paramQQAppInterface))) {
      return false;
    }
    if ((paramMessage.istroop == 0) && (TextUtils.equals(paramMessage.frienduin, acbn.bkL))) {
      return false;
    }
    if (((paramSessionInfo != null) && (paramSessionInfo.cZ == 10007)) || (paramMessage.istroop == 10007)) {
      return false;
    }
    return !acbn.blN.equals(paramMessage.senderuin);
  }
  
  public static List<ChatMessage> b(List<ChatMessage> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseChatpieHelper", 2, "filterTargetUinMsgList size list == null, targetUin=" + paramString);
      }
      return localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatpieHelper", 2, "filterTargetUinMsgList size " + paramList.size() + ", targetUin=" + paramString);
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)paramList.next();
      if (paramString.equals(localChatMessage.senderuin)) {
        localArrayList.add(localChatMessage);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.w("BaseChatpieHelper", 2, "filterTargetUinMsgList targetList " + localArrayList.size() + ", targetUin=" + paramString);
    }
    return localArrayList;
  }
  
  public static boolean b(SessionInfo paramSessionInfo)
  {
    return false;
  }
  
  public static boolean v(QQAppInterface paramQQAppInterface)
  {
    if (ShortVideoUtils.awI()) {}
    do
    {
      return true;
      ShortVideoUtils.B(paramQQAppInterface);
    } while (ShortVideoUtils.awI());
    return false;
  }
  
  CharSequence a(Intent paramIntent, QQMessageFacade.Message paramMessage)
  {
    for (;;)
    {
      Object localObject3;
      try
      {
        if (paramMessage.msgtype == -2016)
        {
          localObject1 = paramMessage.msg.split("\\|");
          if (localObject1.length <= 0) {
            break label1068;
          }
          localObject1 = localObject1[0].trim();
          break label1062;
          localObject3 = new SpannableStringBuilder();
          localObject2 = apsb.a(paramMessage);
          if (localObject2 != null) {
            paramMessage.nickName = ((apsb.a)localObject2).nickname;
          }
          if (paramMessage.istroop != 10007) {
            break label395;
          }
          paramIntent = ((ahta)this.app.getManager(358)).a(ahtd.s(paramMessage));
          if ((paramIntent == null) || (TextUtils.isEmpty(paramIntent.mNickInGame)))
          {
            ((SpannableStringBuilder)localObject3).append(acfp.m(2131694203));
            label126:
            if (localObject1 == null) {
              break label1065;
            }
            ((SpannableStringBuilder)localObject3).append("：");
            ((SpannableStringBuilder)localObject3).append((CharSequence)localObject1);
            break label1065;
          }
        }
        else
        {
          if ((paramMessage.msgtype == -2011) || (paramMessage.msgtype == -2059))
          {
            localObject1 = anre.a(paramMessage.msgData);
            if (localObject1 != null)
            {
              localObject1 = ((AbsStructMsg)localObject1).mMsgBrief;
              break label1075;
            }
            localObject1 = paramMessage.msg;
            break label1075;
          }
          if (paramMessage.msgtype == -2000)
          {
            if ((((HotChatManager)this.app.getManager(60)).kj(paramMessage.frienduin)) || (acei.W(paramMessage)))
            {
              localObject1 = this.mContext.getResources().getString(2131692311);
              break label1078;
            }
            localObject1 = paramMessage.getMessageText();
            break label1078;
          }
          if (paramMessage.msgtype == -7001)
          {
            localObject1 = this.mContext.getResources().getString(2131696093);
            continue;
          }
          localObject2 = paramMessage.getMessageText();
          localObject1 = localObject2;
          if (!aptw.bg(paramMessage)) {
            continue;
          }
          if (!aptw.bi(paramMessage)) {
            aptw.aI(paramMessage);
          }
          localObject3 = aptw.x(paramMessage);
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            continue;
          }
          localObject1 = localObject3;
          continue;
        }
        ((SpannableStringBuilder)localObject3).append(paramIntent.mNickInGame);
        continue;
        if (paramMessage.nickName == null) {
          break label635;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e("BaseChatpieHelper", 1, "getMessageTipsStr error: " + paramMessage, paramIntent);
        return "";
      }
      label395:
      Object localObject2 = localObject1;
      int i;
      if (paramMessage.nickName.equals(this.mContext.getString(2131695447)))
      {
        localObject1 = ((CharSequence)localObject1).toString();
        i = 0;
        label437:
        if (i >= aoff.hj.length) {
          break label1092;
        }
        localObject2 = localObject1;
        if (((String)localObject1).indexOf('\024' + aoff.hj[i]) == -1) {
          break label1081;
        }
        localObject2 = ((String)localObject1).replace('\024' + aoff.hj[i], "\024" + (char)i);
      }
      for (;;)
      {
        localObject1 = paramIntent.getStringExtra("uinname");
        ((SpannableStringBuilder)localObject3).append(new aofe("[" + (String)localObject1 + "]", 16));
        ((SpannableStringBuilder)localObject3).append(" ");
        ((SpannableStringBuilder)localObject3).append(new aofe(paramMessage.nickName, 16));
        ausb.a(this.app).a(paramMessage, paramIntent, (SpannableStringBuilder)localObject3);
        localObject1 = localObject2;
        break label126;
        label635:
        String str = paramIntent.getStringExtra("uinname");
        ausb.a(this.app).a(paramMessage, (SpannableStringBuilder)localObject3);
        if ((str == null) || (str.length() == 0))
        {
          ((SpannableStringBuilder)localObject3).append(paramMessage.frienduin);
          break label126;
        }
        if (7000 == paramMessage.istroop)
        {
          localObject2 = paramIntent.getStringExtra("subAccountLatestNick");
          if (localObject2 != null)
          {
            paramIntent = (Intent)localObject2;
            if (((String)localObject2).length() != 0) {}
          }
          else
          {
            paramIntent = paramMessage.senderuin;
          }
          ((SpannableStringBuilder)localObject3).append(str);
          ((SpannableStringBuilder)localObject3).append(" ");
          ((SpannableStringBuilder)localObject3).append(paramIntent);
          break label126;
        }
        if ((1010 == paramMessage.istroop) || (1001 == paramMessage.istroop))
        {
          if (String.valueOf(acbn.bkE).equals(paramMessage.frienduin))
          {
            localObject2 = aqgv.G(this.app, paramMessage.senderuin);
            paramIntent = (Intent)localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              paramIntent = paramMessage.senderuin;
            }
          }
          for (;;)
          {
            ((SpannableStringBuilder)localObject3).append(str);
            ((SpannableStringBuilder)localObject3).append("-");
            ((SpannableStringBuilder)localObject3).append(paramIntent);
            if (paramMessage.msgtype != -1024) {
              break;
            }
            paramIntent = String.format(this.mContext.getResources().getString(2131700986), new Object[] { paramIntent });
            break label1099;
            localObject2 = aqgv.G(this.app, paramMessage.frienduin);
            paramIntent = (Intent)localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              paramIntent = paramMessage.frienduin;
            }
          }
        }
        if (1024 == paramMessage.istroop)
        {
          paramIntent = jqs.getNickName(this.app, paramMessage.frienduin);
          if (TextUtils.isEmpty(paramIntent))
          {
            ((SpannableStringBuilder)localObject3).append(str);
            break label126;
          }
          ((SpannableStringBuilder)localObject3).append(paramIntent);
          break label126;
        }
        if ((7220 == paramMessage.istroop) && (paramMessage.extInt == 2) && (!TextUtils.isEmpty(paramMessage.senderuin)))
        {
          paramIntent = ((acja)this.app.getManager(56)).b(paramMessage.senderuin);
          if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.name)))
          {
            ((SpannableStringBuilder)localObject3).append(paramIntent.name);
            break label126;
          }
          ((SpannableStringBuilder)localObject3).append(str);
          break label126;
        }
        ((SpannableStringBuilder)localObject3).append(str);
        break label126;
        paramIntent = (Intent)localObject1;
        break label1099;
        for (;;)
        {
          label1062:
          break;
          label1065:
          return localObject3;
          label1068:
          localObject1 = "";
        }
        label1075:
        break;
        label1078:
        break;
        label1081:
        i += 1;
        localObject1 = localObject2;
        break label437;
        label1092:
        localObject2 = localObject1;
      }
      label1099:
      Object localObject1 = paramIntent;
    }
  }
  
  void bG(Intent paramIntent)
  {
    if (paramIntent == null) {}
    int i;
    do
    {
      do
      {
        Bundle localBundle;
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("BaseChatpieHelper", 2, "uploadPreviewPhoto");
          }
          aqhu.a(-1L, this.sessionInfo.cZ, true, "image_send_prepare", "ChatActivity.uploadPreviewPhoto:request=" + paramIntent.getIntExtra(aqfx.REQUEST_CODE, -1));
          localBundle = paramIntent.getExtras();
        } while (localBundle == null);
        if (localBundle.getBoolean("deleteImage", false))
        {
          this.a.aG(true, false);
          return;
        }
        i = paramIntent.getIntExtra(aqfx.REQUEST_CODE, -1);
      } while ((i != 2) && (i != 1));
      paramIntent = paramIntent.getParcelableArrayListExtra("imageInfos");
    } while ((paramIntent == null) || (paramIntent.isEmpty()));
    if (paramIntent.size() == 1)
    {
      if (i == 1)
      {
        t(this.sessionInfo.entrance, 1, "");
        return;
      }
      t(this.sessionInfo.entrance, 2, "");
      return;
    }
    t(this.sessionInfo.entrance, 4, "" + paramIntent.size());
  }
  
  void bH(Intent paramIntent)
  {
    Object localObject = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.PreUploadVideoConfig.name(), "0|0|1.0|5|480000|0");
    aqip.bj(String.valueOf(0), "checking", "<BDH_LOG> DPCConfig of PreUploadVideoConfig :" + (String)localObject);
    float f1 = 0.0F;
    float f3 = 0.0F;
    float f2 = 0.0F;
    long l2 = 0L;
    if ((localObject != null) && (((String)localObject).length() > 0))
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject == null) || (localObject.length < 5)) {}
    }
    for (;;)
    {
      int i;
      long l1;
      int i1;
      try
      {
        k = Integer.valueOf(localObject[0]).intValue();
        boolean bool3;
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        try
        {
          j = Integer.valueOf(localObject[1]).intValue();
          f2 = f3;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          for (;;)
          {
            boolean bool1;
            boolean bool2;
            int j = 0;
            i = 0;
            i1 = k;
          }
        }
        try
        {
          f1 = Float.valueOf(localObject[2]).floatValue();
          f2 = f1;
          i = Integer.valueOf(localObject[3]).intValue();
        }
        catch (NumberFormatException localNumberFormatException3)
        {
          i = 0;
          f1 = f2;
          i1 = k;
          break label612;
        }
        try
        {
          l1 = Long.valueOf(localObject[4]).longValue();
          n = k;
          m = j;
          k = i;
          f2 = f1;
          aqip.bj(String.valueOf(0), "checking", "<BDH_LOG> DPCConfig PreUpEnable:" + n + " HardEncodeEnable:" + m + " Limits:" + k + " dpcDuration:" + f2 + " dpcTimeout:" + l1);
          bool3 = VideoUpConfigInfo.isPreUpload();
          bool1 = VideoUpConfigInfo.sIsHardCodeEnable;
          if ((m != 1) || (!bool1)) {
            break label668;
          }
          bool2 = true;
          aqip.bj(String.valueOf(0), "checking", "<BDH_LOG> HardCodeEnable: " + bool2 + " DPC:" + m + " BDH:" + bool1);
          if (!VideoUpConfigInfo.getIsUpdated())
          {
            if (QLog.isColorLevel()) {
              QLog.d("BaseChatpieHelper", 2, "<BDH_LOG>VideoUpConfigInfo is not updated");
            }
            HwServlet.getConfig(this.app, this.app.getCurrentAccountUin());
            VideoUpConfigInfo.setIsUpdated();
          }
          if (!aqiw.isWifiConnected(BaseApplication.getContext())) {
            break label680;
          }
          if ((n != 1) || (!bool3)) {
            break label674;
          }
          bool1 = true;
          aqip.bj(String.valueOf(0), "checking", "<BDH_LOG> Enable: " + bool1 + " DPC:" + n + " BDH:" + bool3 + " isWifi");
          if ((this.sessionInfo.cZ == 9501) || (this.sessionInfo.cZ == 1008)) {
            bool1 = false;
          }
          bool3 = bool1;
          if (this.sessionInfo.cZ != 0)
          {
            bool3 = bool1;
            if (this.sessionInfo.cZ != 3000)
            {
              bool3 = bool1;
              if (this.sessionInfo.cZ != 1)
              {
                bool3 = bool1;
                if (this.sessionInfo.cZ != 1008) {
                  bool3 = false;
                }
              }
            }
          }
          if ((!bool3) || (!aont.Q(this.sessionInfo.cZ, this.sessionInfo.aTl))) {
            break label686;
          }
          paramIntent.putExtra("key_video_presend_enable", true);
          paramIntent.putExtra("key_video_hard_encode_enable", bool2);
          paramIntent.putExtra("key_video_presend_slice_duration", f2);
          anhz.cGj = bool2;
          anhz.cGk = bool3;
          return;
        }
        catch (NumberFormatException localNumberFormatException4)
        {
          i1 = k;
          break label612;
        }
        localNumberFormatException1 = localNumberFormatException1;
        j = 0;
        i1 = 0;
        i = 0;
      }
      label612:
      f2 = f1;
      int k = i;
      int m = j;
      int n = i1;
      if (QLog.isColorLevel())
      {
        QLog.e("BaseChatpieHelper", 2, "<BDH_LOG>get DpcConfig Erro", localNumberFormatException1);
        l1 = l2;
        f2 = f1;
        k = i;
        m = j;
        n = i1;
        continue;
        label668:
        bool2 = false;
        continue;
        label674:
        bool1 = false;
        continue;
        label680:
        bool1 = false;
        continue;
        label686:
        paramIntent.putExtra("key_video_presend_enable", false);
        continue;
        k = 0;
        m = 0;
        n = 0;
        l1 = l2;
      }
    }
  }
  
  public void bJm()
  {
    znk.a().a(this.sessionInfo.cZ, this.sessionInfo.aTl, this.a);
  }
  
  public void bJn()
  {
    znk.a().b(this.sessionInfo.cZ, this.sessionInfo.aTl, this.a);
    if ((this.app.b() != null) && (!znk.a().l(this.sessionInfo.cZ, this.sessionInfo.aTl))) {
      this.app.b().aZ(this.sessionInfo.cZ, this.sessionInfo.aTl);
    }
  }
  
  void bn(Intent paramIntent)
  {
    this.bEL = 1;
  }
  
  void t(int paramInt1, int paramInt2, String paramString)
  {
    ThreadManager.post(new BaseChatpieHelper.1(this, paramInt2, paramInt1, paramString), 2, null, false);
  }
  
  public void x(Activity paramActivity, Intent paramIntent)
  {
    ArrayList localArrayList = (ArrayList)ajlc.a().fH();
    String str = ailx.s(localArrayList);
    paramIntent.putExtra("chatuin", this.sessionInfo.aTl);
    paramIntent.putExtra("chattype", this.sessionInfo.cZ);
    paramIntent.putExtra("msgs", str);
    paramActivity.setResult(-1, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("jubaoApiPlugin", 2, "select msg size = " + localArrayList.size());
    }
  }
  
  static class UnreadTask
    implements Runnable
  {
    private BaseChatPie a;
    private WeakReference<QQAppInterface> mAppRef;
    private SessionInfo sessionInfo;
    
    UnreadTask(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie)
    {
      this.mAppRef = new WeakReference(paramQQAppInterface);
      this.a = paramBaseChatPie;
      this.sessionInfo = paramBaseChatPie.a();
    }
    
    void g(QQAppInterface paramQQAppInterface, int paramInt)
    {
      boolean bool1 = true;
      int j = 0;
      boolean bool2;
      int i;
      if (paramInt > 0)
      {
        bool2 = true;
        if ((this.sessionInfo.cZ != 1) && (this.sessionInfo.cZ != 3000)) {
          break label99;
        }
        i = 1;
        bool1 = false;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("sendback", 2, "onPreSetReadConfirm_AIOEggs hasUnreadCount=" + paramInt + "isC2C=" + bool1);
        }
        if ((i == 0) && (!bool1))
        {
          return;
          bool2 = false;
          break;
          label99:
          if (!top.fv(this.sessionInfo.cZ)) {
            break label387;
          }
          i = 0;
          continue;
        }
        int k;
        ChatMessage localChatMessage;
        long l2;
        if (bool2)
        {
          paramQQAppInterface = this.a.cF();
          k = paramQQAppInterface.size();
          if (j >= k) {
            break label379;
          }
          localChatMessage = (ChatMessage)paramQQAppInterface.get(j);
          if (!localChatMessage.isread) {
            if (i != 0) {
              l2 = localChatMessage.shmsgseq;
            }
          }
        }
        for (;;)
        {
          label177:
          long l1 = l2;
          if (QLog.isColorLevel())
          {
            QLog.d("UnreadTask", 2, "onPreSetReadConfirm_AIOEggs hasUnreadCount=" + paramInt + "totalList count=" + k);
            l1 = l2;
          }
          for (;;)
          {
            label226:
            if (QLog.isColorLevel()) {
              QLog.d("AioAnimationDetector", 2, "onPreSetReadConfirm_AIOEggs: hasUnread=" + bool2 + ", lastMsgTimeOrSeq=" + l1);
            }
            paramQQAppInterface = wnf.a();
            paramQQAppInterface.beC = bool2;
            paramQQAppInterface.Ig = l1;
            if (bool2) {}
            for (;;)
            {
              ujt.Fz = l1;
              return;
              l2 = localChatMessage.time;
              break label177;
              j += 1;
              break;
              paramQQAppInterface = paramQQAppInterface.b().a(this.sessionInfo.aTl, this.sessionInfo.cZ);
              if (paramQQAppInterface == null) {
                break label371;
              }
              if (i != 0)
              {
                l1 = paramQQAppInterface.shmsgseq;
                break label226;
              }
              l1 = paramQQAppInterface.time;
              break label226;
              l1 += 1L;
            }
            label371:
            l1 = -1L;
          }
          label379:
          l2 = -1L;
        }
        label387:
        bool1 = false;
        i = 0;
      }
    }
    
    public void run()
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)this.mAppRef.get();
      if (localQQAppInterface == null)
      {
        QLog.d("UnreadTask", 1, "UnReadTask mApp==null");
        return;
      }
      Object localObject1 = this.a.cF();
      Object localObject2 = ((List)localObject1).iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ChatMessage)((Iterator)localObject2).next();
        if ((localObject3 instanceof MessageForUniteGrayTip))
        {
          localObject3 = (MessageForUniteGrayTip)localObject3;
          if (((MessageForUniteGrayTip)localObject3).tipParam != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendReactive", 2, "graytips lgraymr.hasRead=" + ((MessageForUniteGrayTip)localObject3).hasRead + "grayTipId=" + ((MessageForUniteGrayTip)localObject3).tipParam.dbK + "subtype = " + ((MessageForUniteGrayTip)localObject3).subType);
            }
            if ((((MessageForUniteGrayTip)localObject3).tipParam.dbK == 2097153) && (((MessageForUniteGrayTip)localObject3).hasRead == 0))
            {
              ajoo.a(localQQAppInterface, this.sessionInfo, (MessageForUniteGrayTip)localObject3, this.a.uiHandler, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, ((MessageForUniteGrayTip)localObject3).subType);
              ((MessageForUniteGrayTip)localObject3).hasRead = 1;
              ((MessageForUniteGrayTip)localObject3).updateUniteGrayTipMsgData(localQQAppInterface);
            }
          }
        }
      }
      if (((List)localObject1).size() > 0)
      {
        localObject1 = (ChatMessage)((List)localObject1).get(((List)localObject1).size() - 1);
        ((FlashChatManager)localQQAppInterface.getManager(217)).V((ChatMessage)localObject1);
      }
      this.a.bEj = this.a.vk();
      localObject1 = this.a;
      if (this.a.bEj > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((BaseChatPie)localObject1).aex = bool;
        g(localQQAppInterface, this.a.bEj);
        localObject1 = this.a.jdField_a_of_type_Wki.getList();
        localObject2 = new ArrayList();
        if (this.sessionInfo.cZ != 0) {
          break label478;
        }
        if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
          break;
        }
        int i = ((List)localObject1).size() - 1;
        while (i >= 0)
        {
          localObject3 = (ChatMessage)((List)localObject1).get(i);
          if (((localObject3 instanceof MessageForPoke)) && (!((ChatMessage)localObject3).isSend())) {
            ((List)localObject2).add((MessageForPoke)localObject3);
          }
          i -= 1;
        }
      }
      if (((List)localObject2).size() > 0)
      {
        localObject1 = (MessageForPoke)((List)localObject2).get(0);
        if (!((MessageForPoke)localObject1).isPlayed) {
          localQQAppInterface.a().nc.put(Long.valueOf(((MessageForPoke)localObject1).uniseq), localObject1);
        }
      }
      label478:
      this.a.uiHandler.sendEmptyMessageDelayed(16711689, 300000L);
      if ((this.a.aex) || (this.a.aSo)) {
        ujt.a(localQQAppInterface, this.sessionInfo);
      }
      for (;;)
      {
        localQQAppInterface.b().a(this.sessionInfo.aTl, this.sessionInfo.cZ, true, true);
        if (this.sessionInfo.cZ == 1) {
          ajpd.ar(localQQAppInterface, this.sessionInfo.aTl);
        }
        this.a.aI(localQQAppInterface);
        return;
        if (this.sessionInfo.Ib == -1L) {
          this.sessionInfo.Ib = localQQAppInterface.b().g(this.sessionInfo.aTl, this.sessionInfo.cZ);
        }
      }
    }
  }
  
  static class a
    implements XEditTextEx.c
  {
    private aflb jdField_a_of_type_Aflb;
    private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
    
    a(BaseChatPie paramBaseChatPie)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    }
    
    public void destroy()
    {
      if (this.jdField_a_of_type_Aflb != null) {
        this.jdField_a_of_type_Aflb.onDestroy();
      }
    }
    
    public boolean onPrivateIMECommand(String paramString, Bundle paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IMECommandListener", 2, "onPrivateIMECommand(), action:" + paramString);
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.app;
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.mContext;
      XEditTextEx localXEditTextEx = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a;
      int i;
      if ((!TextUtils.isEmpty(paramString)) && (paramBundle != null) && (aurd.cE((Context)localObject1)))
      {
        if ((!"com.sogou.inputmethod.expression".equals(paramString)) && (!"com.tencent.qqpinyin.expression".equals(paramString))) {
          break label194;
        }
        if (!"com.sogou.inputmethod.expression".equals(paramString)) {
          break label180;
        }
        paramString = paramBundle.getString("SOGOU_EXP_PATH");
        i = 1034;
        if (QLog.isColorLevel()) {
          QLog.d("IMECommandListener", 2, "onPrivateIMECommand(), path:" + paramString + ", busiType = " + i);
        }
        if (!TextUtils.isEmpty(paramString)) {
          ujt.a((QQAppInterface)localObject2, (Context)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo, paramString, i);
        }
      }
      label180:
      label194:
      do
      {
        do
        {
          return true;
          paramString = paramBundle.getString("QQINPUT_EXP_PATH");
          i = 1038;
          break;
          if ("com.sogou.inputmethod.appid".equals(paramString))
          {
            localObject3 = paramBundle.getString("SOGOU_APP_ID");
            String str = ((QQAppInterface)localObject2).getCurrentAccountUin();
            paramString = artw.r(((QQAppInterface)localObject2).getApp(), str, (String)localObject3);
            if (QLog.isColorLevel()) {
              QLog.d("IMECommandListener", 2, "onPrivateIMECommand(), appId:" + (String)localObject3 + "selfUin:" + str + "openId:" + paramString);
            }
            localObject1 = (InputMethodManager)((Context)localObject1).getSystemService("input_method");
            if (localObject1 != null)
            {
              localObject2 = new Bundle();
              ((Bundle)localObject2).putString("SOGOU_OPENID", paramString);
              ((InputMethodManager)localObject1).sendAppPrivateCommand(localXEditTextEx, "com.tencent.mobileqq.sogou.openid", (Bundle)localObject2);
            }
            paramString = paramBundle.getStringArrayList("EXP_ALL_PACKID");
            if (this.jdField_a_of_type_Aflb == null) {
              this.jdField_a_of_type_Aflb = new aflb(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
            }
            this.jdField_a_of_type_Aflb.kq(paramString);
            return true;
          }
          if (("com.sogou.inputmethod.qqexp".equals(paramString)) || ("com.tencent.qqpinyin.qqexp".equals(paramString)))
          {
            i = paramBundle.getInt("PACKAGE_ID");
            paramString = paramBundle.getString("EXP_ID");
            paramBundle = paramBundle.getString("EXP_PATH");
            if (QLog.isColorLevel()) {
              QLog.d("IMECommandListener", 2, "onPrivateIMECommand(), packId:" + i + ",exprId:" + paramString + ",ePath:" + paramBundle);
            }
            if (this.jdField_a_of_type_Aflb == null) {
              this.jdField_a_of_type_Aflb = new aflb(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
            }
            this.jdField_a_of_type_Aflb.cl(i, paramString);
            return true;
          }
        } while (!"com.tencent.mobileqq_audioArgs".equals(paramString));
        paramString = paramBundle.getString("PCMFilePath");
        i = paramBundle.getInt("SampleRate");
        int j = paramBundle.getInt("Channels");
        Object localObject3 = (QQRecorder.RecorderParam)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.mUserData;
        paramBundle = paramBundle.getString("InputMethodName");
        if (QLog.isColorLevel()) {
          QLog.d("sougouptt", 2, "recv args from sogou, pcmPath = " + paramString + " sampleRate = " + i + " channels = " + j + " inputName = " + paramBundle + " my sampleRate = " + ((QQRecorder.RecorderParam)localObject3).mSampleRate);
        }
        if ((i == ((QQRecorder.RecorderParam)localObject3).mSampleRate) && (!aqmr.isEmpty(paramString))) {
          break label644;
        }
      } while (!QLog.isColorLevel());
      QLog.d("sougouptt", 2, "invalid datas from sougou ");
      return true;
      label644:
      ThreadManager.getSubThreadHandler().post(new BaseChatpieHelper.IMECommandListener.1(this, (QQAppInterface)localObject2, paramString, i, paramBundle, (Context)localObject1, localXEditTextEx));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatpieHelper
 * JD-Core Version:    0.7.0.1
 */