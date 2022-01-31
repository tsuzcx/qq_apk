package com.tencent.mobileqq.activity.aio.item;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bxj;
import bxk;
import bxl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Callback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.XListView;
import cooperation.qqfav.QfavUtil;
import cooperation.qqfav.widget.QfavMicroPhoneDialog;
import mqq.manager.ServerConfigManager.ConfigType;

public class PttItemBuilder
  extends BaseBubbleBuilder
  implements FileTransferManager.Callback, MediaPlayerManager.Callback
{
  public static final String b = "ConvertText_MaxPtt";
  public static final String c = "Normal_MaxPtt";
  public static final String d = "VIP_MaxPtt";
  private static final boolean d = true;
  private static final int e = 20;
  public static final String e = "SVIP_MaxPtt";
  private static final int jdField_f_of_type_Int = 1;
  private static final String jdField_f_of_type_JavaLangString = "PttItemBuilder";
  private static final int jdField_g_of_type_Int = 2;
  private static final String jdField_g_of_type_JavaLangString = "param_FailCode";
  private static final int h = 0;
  private static final int i = 1;
  private static final int j = 4;
  private SpannableString jdField_a_of_type_AndroidTextSpannableString;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SpannableString b;
  
  public PttItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  private int a(int paramInt1, String paramString, Paint paramPaint, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int k = Math.min(60, Math.max(1, paramInt1));
    int m;
    float f1;
    if (k > 40)
    {
      k += 40;
      m = AIOUtils.a(k + 20, this.jdField_a_of_type_AndroidContentContext.getResources());
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "viewLenByTime is:" + m);
      }
      if ((paramString == null) || (paramPaint == null)) {
        break label313;
      }
      k = BaseChatItemLayout.g - BaseChatItemLayout.k - BaseChatItemLayout.l - 32;
      f1 = paramPaint.measureText(paramString) + paramInt2;
      if (f1 <= k) {
        break label316;
      }
      f1 = k;
    }
    label313:
    label316:
    for (;;)
    {
      float f2;
      if (paramInt1 > 99)
      {
        f2 = 38.0F;
        int n = AIOUtils.a(f2, this.jdField_a_of_type_AndroidContentContext.getResources());
        m = m + n + paramInt3;
        paramInt1 = m;
        if (m > k) {
          paramInt1 = k;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PttItemBuilder", 2, "viewLenByText is:" + f1 + ",maxlength is:" + k + ",flagTimeLen is:" + n + ",arrowIVWidth is:" + paramInt2 + ",convertIVWidth is:" + paramInt3 + ",convertIVVisible is:" + paramBoolean);
        }
        paramInt2 = Math.max(paramInt1, (int)f1) - n;
        paramInt1 = paramInt2;
        if (paramBoolean) {
          paramInt1 = paramInt2 - paramInt3;
        }
        return paramInt1;
        k *= 2;
        break;
      }
      if (paramInt1 > 9) {}
      for (paramInt1 = 34;; paramInt1 = 30)
      {
        f2 = paramInt1;
        break;
      }
      return m;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt)
  {
    int k = 999;
    int m = 0;
    if (paramMessageForPtt.isSendFromLocal()) {
      if ((paramMessageForPtt.url != null) && (paramMessageForPtt.url.startsWith(AppConstants.aq))) {
        if (paramMessageForPtt.fileSize > 0L) {
          k = 1003;
        }
      }
    }
    do
    {
      int n;
      do
      {
        do
        {
          return k;
          if (paramMessageForPtt.fileSize == -1L) {
            return 1005;
          }
          if (paramMessageForPtt.fileSize != -2L) {
            break;
          }
        } while (a(paramMessageForPtt));
        paramMessageForPtt.fileSize = -1L;
        return 1005;
        if (paramMessageForPtt.fileSize != -3L) {
          break;
        }
        m = 1001;
        n = paramQQAppInterface.a().d(paramMessageForPtt.frienduin, paramMessageForPtt.getLocalFilePath(), paramMessageForPtt.uniseq);
        if ((n == 1005) || (n == -1))
        {
          paramMessageForPtt.fileSize = -1L;
          return 1005;
        }
      } while (n == 7000);
      k = m;
      do
      {
        return k;
        return paramQQAppInterface.a().d(paramMessageForPtt.frienduin, paramMessageForPtt.getLocalFilePath(), paramMessageForPtt.uniseq);
        return 1004;
        if (QLog.isColorLevel()) {
          QLog.d("PttItemBuilder", 2, "handlePttItem recieve friendUin " + paramMessageForPtt.frienduin + " url " + paramMessageForPtt.url + " urlAtServer " + paramMessageForPtt.urlAtServer + " uniseq " + paramMessageForPtt.uniseq);
        }
        k = m;
      } while (paramMessageForPtt == null);
      if (paramMessageForPtt.url == null) {
        return 2005;
      }
      if ((paramMessageForPtt.url.startsWith(AppConstants.aq)) && (FileUtils.a(paramMessageForPtt.getLocalFilePath()))) {
        return 2003;
      }
      k = paramQQAppInterface.a().d(paramMessageForPtt.frienduin, paramMessageForPtt.getLocalFilePath(), paramMessageForPtt.uniseq);
      m = k;
      if (k == -1)
      {
        m = k;
        if (paramMessageForPtt.fileSize == -4L) {
          m = 2005;
        }
      }
      k = m;
    } while (!QLog.isColorLevel());
    QLog.d("PttItemBuilder", 2, "handlePttItem recieve status " + m + "   url " + paramMessageForPtt.url + " uniseq " + paramMessageForPtt.uniseq);
    return m;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int m = 120;
    paramQQAppInterface = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "key = " + paramString + ", time = " + paramQQAppInterface);
    }
    if (paramQQAppInterface != null) {}
    do
    {
      do
      {
        do
        {
          try
          {
            k = Integer.valueOf(paramQQAppInterface).intValue();
            if (k > 0) {
              return k;
            }
          }
          catch (Exception paramQQAppInterface)
          {
            if (QLog.isColorLevel()) {
              QLog.e("PttItemBuilder", 2, paramQQAppInterface.toString());
            }
          }
          k = m;
        } while ("ConvertText_MaxPtt".equals(paramString));
        k = m;
      } while ("Normal_MaxPtt".equals(paramString));
      if ("VIP_MaxPtt".equals(paramString)) {
        return 180;
      }
      int k = m;
    } while (!"SVIP_MaxPtt".equals(paramString));
    return 300;
  }
  
  private void a(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.isReadPtt = true;
    paramMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
  }
  
  protected static boolean a(MessageForPtt paramMessageForPtt)
  {
    String str = QQRecorder.a();
    return (paramMessageForPtt.fileSize == -2L) && (!TextUtils.isEmpty(str)) && (str.equals(paramMessageForPtt.getLocalFilePath()));
  }
  
  private boolean c(ChatMessage paramChatMessage)
  {
    return paramChatMessage.vipBubbleID >= 1L;
  }
  
  @SuppressLint({"NewApi"})
  private void d()
  {
    BluetoothAdapter localBluetoothAdapter;
    if (Build.VERSION.SDK_INT >= 15)
    {
      localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
      if (localBluetoothAdapter != null) {}
    }
    else
    {
      return;
    }
    if (!localBluetoothAdapter.isEnabled())
    {
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttPlayBluetooth", true, 0L, 0L, null, "");
      return;
    }
    if (localBluetoothAdapter.getProfileConnectionState(2) == 2)
    {
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttPlayBluetooth", true, 0L, 0L, null, "");
      return;
    }
    if (localBluetoothAdapter.getProfileConnectionState(1) == 2)
    {
      bxk localbxk = new bxk(this, localBluetoothAdapter);
      localBluetoothAdapter.getProfileProxy(this.jdField_a_of_type_AndroidContentContext, localbxk, 1);
      return;
    }
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttPlayBluetooth", true, 0L, 0L, null, "");
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = b(paramChatMessage, paramViewHolder, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
    FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this);
    return paramChatMessage;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new PttItemBuilder.Holder();
  }
  
  protected String a(int paramInt)
  {
    String str = "";
    int k = paramInt / 60;
    if (k > 0) {
      str = k + "'";
    }
    return str + paramInt % 60 + "\"";
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return "发送了语音";
  }
  
  @TargetApi(11)
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForPtt))) {}
    do
    {
      do
      {
        return;
        paramContext = (MessageForPtt)paramChatMessage;
        if (2131296659 != paramInt) {
          break;
        }
        paramInt = QQRecorder.a(paramContext);
      } while (paramInt <= 0);
      paramChatMessage = new QfavMicroPhoneDialog(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext.voiceType, new bxj(this, paramContext));
      if (paramChatMessage.a(paramContext.getLocalFilePath(), paramInt)) {
        paramChatMessage.show();
      }
      for (;;)
      {
        PttInfoCollector.a(false, PttInfoCollector.i);
        return;
        QfavUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131362684, 1);
      }
      if (paramInt == 2131298958)
      {
        ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        PttInfoCollector.a(false, PttInfoCollector.j);
        return;
      }
      if (paramInt == 2131298963)
      {
        if (TextUtils.isEmpty(paramContext.sttText)) {}
        for (paramContext = this.jdField_a_of_type_AndroidContentContext.getString(2131363152);; paramContext = paramContext.sttText) {
          try
          {
            if (Build.VERSION.SDK_INT >= 11) {
              break;
            }
            ((android.text.ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramContext);
            return;
          }
          catch (Exception paramContext)
          {
            return;
          }
        }
        ((android.content.ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("msg", paramContext));
        return;
      }
    } while (paramInt != 2131296655);
    if ((paramContext.sttText != null) && (paramContext.sttText.length() > 0))
    {
      paramChatMessage = new Bundle();
      paramChatMessage.putInt("forward_type", -1);
      paramChatMessage.putString("forward_text", paramContext.sttText);
      paramContext = new Intent(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
      paramContext.putExtras(paramChatMessage);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramContext, 21);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, "语音消息无文本内容", 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492887));
  }
  
  protected void a(View paramView)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)AIOUtils.a(paramView);
    paramView = (PttItemBuilder.Holder)AIOUtils.a(paramView);
    if (localMessageForPtt.isSendFromLocal())
    {
      paramView = ActionSheet.a(this.jdField_a_of_type_AndroidContentContext, 2131624120);
      paramView.a(2131363084);
      paramView.c(2131363083);
      paramView.d(2131362801);
      paramView.a(new bxl(this, localMessageForPtt, paramView));
      paramView.show();
      return;
    }
    a(paramView, localMessageForPtt, true);
    if (QLog.isColorLevel()) {
      QLog.d("PTTItem->onErrorIconClick", 2, "fileStatus:2001|url " + localMessageForPtt.url + "|uniseq " + localMessageForPtt.uniseq);
    }
    a(paramView, localMessageForPtt, 2001, false);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if ((paramFileMsg.e != 2) || (paramInt1 == 2002) || (paramInt1 == 1002) || (paramInt1 == 2001)) {}
    MessageForPtt localMessageForPtt;
    do
    {
      return;
      localMessageForPtt = (MessageForPtt)AIOUtils.a(paramView);
    } while ((localMessageForPtt == null) || (localMessageForPtt.uniseq != paramFileMsg.c));
    paramView = (PttItemBuilder.Holder)AIOUtils.a(paramView);
    if ((paramInt1 == 1003) || (paramInt1 == 2003))
    {
      paramInt2 = paramInt1;
      if (!paramFileMsg.b)
      {
        paramInt2 = paramInt1;
        if (paramInt1 == 2003)
        {
          a();
          PttInfoCollector.c(paramFileMsg.c, localMessageForPtt.frienduin);
          paramInt2 = paramInt1;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTTItem->handleMessage", 2, "fileStatus:" + paramInt2 + "|url " + localMessageForPtt.url + "|uniseq " + localMessageForPtt.uniseq);
      }
      a(paramView, localMessageForPtt, paramInt2, b(localMessageForPtt));
      return;
      if ((paramFileMsg.B == 1005) || (paramFileMsg.B == 1004))
      {
        this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
        paramInt2 = paramInt1;
      }
      else if (localMessageForPtt.fileSize == -2L)
      {
        paramInt2 = 999;
      }
      else if (localMessageForPtt.fileSize == -3L)
      {
        paramInt2 = 1001;
      }
      else if (localMessageForPtt.fileSize == -1L)
      {
        paramInt2 = 1005;
      }
      else
      {
        paramInt2 = paramInt1;
        if (paramInt1 == 2005)
        {
          localMessageForPtt.fileSize = -4L;
          paramInt2 = paramInt1;
        }
      }
    }
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    PttItemBuilder.Holder localHolder = (PttItemBuilder.Holder)paramViewHolder;
    if ((paramBubbleInfo.jdField_a_of_type_Int == 0) || (!paramBubbleInfo.a()))
    {
      paramViewHolder = paramView.getResources();
      if (paramChatMessage.isSend()) {}
      for (paramViewHolder = paramViewHolder.getColorStateList(2131427479);; paramViewHolder = paramViewHolder.getColorStateList(2131427476))
      {
        if ((localHolder.jdField_a_of_type_AndroidWidgetTextView != null) && (paramViewHolder != null)) {
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
        }
        return;
      }
    }
    if (paramBubbleInfo.c == 0)
    {
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      return;
    }
    localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.c);
  }
  
  protected void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "fileStatus is:" + paramInt + ",url is:" + paramMessageForPtt.url + ",uniseq is:" + paramMessageForPtt.uniseq + ",stt is:" + paramMessageForPtt.sttAbility + ",long is:" + paramMessageForPtt.longPttVipFlag);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject1 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, -1);
    int k = 0;
    String str = "";
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
    paramHolder.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    paramHolder.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    Object localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources();
    switch (paramInt)
    {
    default: 
      localObject1 = null;
      paramInt = k;
    case 2004: 
    case 2005: 
    case -1: 
    case 999: 
    case 1000: 
    case 2000: 
    case 2001: 
    case 2002: 
      for (;;)
      {
        switch (paramInt)
        {
        case 2: 
        case 3: 
        default: 
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
          if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b != null) {
            paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.setBackgroundDrawable(null);
          }
          label358:
          if (paramHolder.b != null)
          {
            paramHolder.b.append("发送了语音.").append(str);
            if (localObject1 != null) {
              paramHolder.b.append(" ").append((String)localObject1);
            }
          }
          return;
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(10.0F, (Resources)localObject2), BaseChatItemLayout.n, AIOUtils.a(10.0F, (Resources)localObject2), BaseChatItemLayout.o);
          paramInt = 1;
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
          localObject1 = null;
          continue;
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(40.0F, (Resources)localObject2), BaseChatItemLayout.n, AIOUtils.a(40.0F, (Resources)localObject2), BaseChatItemLayout.o);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(true);
          localObject1 = null;
          paramInt = k;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "voiceLength showPttItem builder" + paramMessageForPtt.voiceLength);
    }
    if (paramMessageForPtt.voiceLength <= 1) {
      paramMessageForPtt.voiceLength = QQRecorder.a(paramMessageForPtt);
    }
    if (paramMessageForPtt.voiceLength <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "get a amr file length = 0 return now");
      }
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(10.0F, (Resources)localObject2), BaseChatItemLayout.n, AIOUtils.a(10.0F, (Resources)localObject2), BaseChatItemLayout.o);
      return;
    }
    if (paramMessageForPtt.voiceLength > a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt")) {
      if (paramMessageForPtt.longPttVipFlag == 1)
      {
        if (this.jdField_a_of_type_AndroidTextSpannableString == null)
        {
          this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString("[v] QQ会员专享长语音");
          localObject1 = ((Resources)localObject2).getDrawable(2130838190);
          ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
          localObject1 = new OffsetableImageSpan((Drawable)localObject1, 1).a(-0.05F);
          this.jdField_a_of_type_AndroidTextSpannableString.setSpan(localObject1, 0, 3, 17);
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.jdField_a_of_type_AndroidTextSpannableString, this);
        localObject1 = "QQ会员专享长语音";
      }
    }
    for (;;)
    {
      label805:
      if (paramMessageForPtt.voiceLength > a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "ConvertText_MaxPtt")) {
        paramMessageForPtt.sttAbility = 0;
      }
      if ((TextUtils.isEmpty(paramMessageForPtt.timeStr)) || (TextUtils.equals(paramMessageForPtt.timeStr, "0\""))) {
        paramMessageForPtt.timeStr = a(paramMessageForPtt.voiceLength);
      }
      str = paramMessageForPtt.timeStr;
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
      paramHolder.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      int m;
      if (paramMessageForPtt.voiceChangeFlag != 0)
      {
        m = 1;
        label902:
        if (!paramMessageForPtt.isSend()) {
          break label1279;
        }
        if (!paramBoolean) {
          break label1203;
        }
        if (m == 0) {
          break label1187;
        }
        k = 2130968621;
        label924:
        if (!c(paramMessageForPtt)) {
          break label1597;
        }
        if (m == 0) {
          break label1195;
        }
        k = 2130968637;
      }
      label1187:
      label1195:
      label1203:
      label1589:
      label1594:
      label1597:
      for (;;)
      {
        Object localObject3 = (AnimationDrawable)((Resources)localObject2).getDrawable(k);
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
        ((AnimationDrawable)localObject3).start();
        label968:
        if ((paramInt == 2003) || (paramInt == 1003))
        {
          if ((paramMessageForPtt.isSend()) || (paramMessageForPtt.isReadPtt)) {
            break label1589;
          }
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
          paramInt = 0;
          label1008:
          k = AIOUtils.a(9.0F, (Resources)localObject2);
          m = a(paramMessageForPtt.voiceLength, null, null, 0, 0, false);
          if (!paramMessageForPtt.isSend()) {
            break label1457;
          }
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, k, 0);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(m, BaseChatItemLayout.n, BaseChatItemLayout.s, BaseChatItemLayout.o);
          break;
          if (paramMessageForPtt.longPttVipFlag != 2) {
            break label1600;
          }
          if (this.b == null)
          {
            this.b = new SpannableString("[v] 超级会员专享长语音");
            localObject1 = ((Resources)localObject2).getDrawable(2130838189);
            ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
            localObject1 = new OffsetableImageSpan((Drawable)localObject1, 1).a(-0.05F);
            this.b.setSpan(localObject1, 0, 3, 17);
          }
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.b, this);
          localObject1 = "超级会员专享长语音";
          break label805;
          m = 0;
          break label902;
          k = 2130968620;
          break label924;
          k = 2130968636;
          continue;
          if (c(paramMessageForPtt))
          {
            localObject3 = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
            if (m != 0) {}
            for (k = 2130838982;; k = 2130838984)
            {
              ((ImageView)localObject3).setImageResource(k);
              break;
            }
          }
          localObject3 = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
          if (m != 0) {}
          for (k = 2130839252;; k = 2130839255)
          {
            ((ImageView)localObject3).setImageResource(k);
            break;
          }
          label1279:
          if (paramBoolean) {
            if (m != 0)
            {
              k = 2130968652;
              if (!c(paramMessageForPtt)) {
                break label1594;
              }
              if (m == 0) {
                break label1349;
              }
              k = 2130968635;
            }
          }
        }
        for (;;)
        {
          localObject3 = (AnimationDrawable)((Resources)localObject2).getDrawable(k);
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
          ((AnimationDrawable)localObject3).start();
          break label968;
          k = 2130968651;
          break label1294;
          label1349:
          k = 2130968634;
          continue;
          if (c(paramMessageForPtt))
          {
            localObject3 = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
            if (m != 0) {}
            for (k = 2130838976;; k = 2130838983)
            {
              ((ImageView)localObject3).setImageResource(k);
              break;
            }
          }
          localObject3 = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
          if (m != 0) {}
          for (k = 2130839254;; k = 2130839253)
          {
            ((ImageView)localObject3).setImageResource(k);
            break;
          }
          if ((paramInt == 1005) || (paramInt == 1004))
          {
            paramInt = 1;
            break label1008;
          }
          paramInt = 4;
          break label1008;
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(k, 0, 0, 0);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(BaseChatItemLayout.s, BaseChatItemLayout.n, m, BaseChatItemLayout.o);
          break;
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.setBackgroundDrawable(null);
          localObject2 = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b;
          if (paramMessageForPtt.isSendFromLocal()) {}
          for (paramMessageForPtt = "重新发送语音消息";; paramMessageForPtt = "重新拉取语音消息")
          {
            ((ImageView)localObject2).setContentDescription(paramMessageForPtt);
            break;
          }
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconResource(2130837928, null);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.setBackgroundDrawable(null);
          ((Animatable)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.getDrawable()).start();
          break label358;
          paramInt = 0;
          break label1008;
        }
      }
      label1294:
      label1457:
      label1600:
      localObject1 = null;
    }
  }
  
  protected void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int k = 1;; k = 0)
    {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPtt, false, k, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Int);
      return;
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    if (paramView != null)
    {
      paramXListView = AIOUtils.a(paramView);
      if ((paramXListView instanceof PttItemBuilder.Holder))
      {
        paramXListView = (PttItemBuilder.Holder)paramXListView;
        paramView = (MessageForPtt)paramChatMessage;
        a(paramXListView, paramView, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView), false);
      }
    }
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    paramXListView = (MessageForPtt)paramChatMessage;
    return (!paramXListView.isSend()) && (!paramXListView.isReadPtt) && (paramXListView.isReady());
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, AudioPlayer paramAudioPlayer)
  {
    paramXListView = (MessageForPtt)paramChatMessage;
    if (paramXListView.isReady())
    {
      d();
      paramView = AIOUtils.a(paramView);
      if (!(paramView instanceof PttItemBuilder.Holder))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PttItemBuilder", 2, "play failed not Holder " + paramXListView.getLocalFilePath());
        }
        return false;
      }
      paramView = (PttItemBuilder.Holder)paramView;
      if (paramAudioPlayer.a(paramXListView.getLocalFilePath()))
      {
        a(paramXListView);
        if (paramView != null) {
          a(paramView, paramXListView, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramXListView), true);
        }
        PttInfoCollector.a(paramXListView.istroop);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "play failed player return false " + paramXListView.getLocalFilePath());
      }
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "play failed not ready " + paramXListView.getLocalFilePath());
      }
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (MessageForPtt)AIOUtils.a(paramView);
    if (!paramView.isReady())
    {
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      return localQQCustomMenu.a();
    }
    if (QQRecorder.a(paramView) <= 0)
    {
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      return localQQCustomMenu.a();
    }
    localQQCustomMenu.a(this.jdField_a_of_type_AndroidContentContext.getString(2131362805));
    if (!"10000512".equals(AppSetting.a(this.jdField_a_of_type_AndroidContentContext))) {
      localQQCustomMenu.a(2131296659, this.jdField_a_of_type_AndroidContentContext.getString(2131362673));
    }
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    return localQQCustomMenu.a();
  }
  
  protected View b(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (PttItemBuilder.Holder)paramViewHolder;
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new BreathAnimationLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131296367);
      TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setId(2131296366);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427476));
      Object localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject).setId(2131296368);
      ((RelativeLayout)localObject).addView(paramView);
      ((RelativeLayout)localObject).addView(localTextView);
      paramViewHolder.addView((View)localObject);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = paramViewHolder;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = localTextView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject);
    }
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener = paramOnLongClickAndTouchListener;
    if (paramChatMessage.isSend())
    {
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131296366);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, -1);
    }
    for (;;)
    {
      int m = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForPtt);
      int k = m;
      if (m == -1)
      {
        a(paramBaseChatItemLayout, localMessageForPtt, false);
        k = 2001;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTTItem->getBubbleView", 2, "fileStatus = " + k + " url " + localMessageForPtt.url + " uniseq " + localMessageForPtt.uniseq);
      }
      PttInfoCollector.a(localMessageForPtt.uniseq, localMessageForPtt.frienduin);
      a(paramBaseChatItemLayout, localMessageForPtt, k, b(localMessageForPtt));
      PttInfoCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, k, paramChatMessage);
      return paramViewHolder;
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131296367);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, -1);
    }
  }
  
  protected boolean b(ChatMessage paramChatMessage)
  {
    ChatMessage localChatMessage = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    return (localChatMessage == paramChatMessage) || (((localChatMessage instanceof MessageForPtt)) && (localChatMessage.frienduin != null) && (localChatMessage.frienduin.equals(paramChatMessage.frienduin)) && (localChatMessage.uniseq == paramChatMessage.uniseq));
  }
  
  public void c() {}
  
  public void onClick(View paramView)
  {
    int k = paramView.getId();
    MessageForPtt localMessageForPtt = (MessageForPtt)((PttItemBuilder.Holder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (k == 2131296368)
    {
      PttInfoCollector.b(localMessageForPtt.uniseq, localMessageForPtt.frienduin);
      if (b(localMessageForPtt)) {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
      }
      for (;;)
      {
        if (localMessageForPtt.istroop == 1008) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005857", "0X8005857", 0, 0, "", "", localMessageForPtt.timeStr, "");
        }
        return;
        if ((localMessageForPtt != MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) && (localMessageForPtt.isReady())) {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131363150, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492887));
          } else if (!MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(AIOUtils.a(paramView))) {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131363151, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492887));
          }
        }
      }
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttItemBuilder
 * JD-Core Version:    0.7.0.1
 */