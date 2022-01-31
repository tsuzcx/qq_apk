package com.tencent.mobileqq.activity.aio.item;

import android.annotation.TargetApi;
import android.app.Activity;
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
import bwk;
import bwl;
import bwm;
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
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.QQToast;
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
  private static final int jdField_f_of_type_Int = 0;
  private static final String jdField_f_of_type_JavaLangString = "PttItemBuilder";
  private static final int g = 1;
  private static final int h = 4;
  private SpannableString a;
  private SpannableString b;
  
  public PttItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private int a(int paramInt1, String paramString, Paint paramPaint, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = Math.min(60, Math.max(1, paramInt1));
    int j;
    float f1;
    if (i > 40)
    {
      i += 40;
      j = AIOUtils.a(i + 20, this.jdField_a_of_type_AndroidContentContext.getResources());
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "viewLenByTime is:" + j);
      }
      if ((paramString == null) || (paramPaint == null)) {
        break label313;
      }
      i = BaseChatItemLayout.g - BaseChatItemLayout.k - BaseChatItemLayout.l - 32;
      f1 = paramPaint.measureText(paramString) + paramInt2;
      if (f1 <= i) {
        break label316;
      }
      f1 = i;
    }
    label313:
    label316:
    for (;;)
    {
      float f2;
      if (paramInt1 > 99)
      {
        f2 = 38.0F;
        int k = AIOUtils.a(f2, this.jdField_a_of_type_AndroidContentContext.getResources());
        j = j + k + paramInt3;
        paramInt1 = j;
        if (j > i) {
          paramInt1 = i;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PttItemBuilder", 2, "viewLenByText is:" + f1 + ",maxlength is:" + i + ",flagTimeLen is:" + k + ",arrowIVWidth is:" + paramInt2 + ",convertIVWidth is:" + paramInt3 + ",convertIVVisible is:" + paramBoolean);
        }
        paramInt2 = Math.max(paramInt1, (int)f1) - k;
        paramInt1 = paramInt2;
        if (paramBoolean) {
          paramInt1 = paramInt2 - paramInt3;
        }
        return paramInt1;
        i *= 2;
        break;
      }
      if (paramInt1 > 9) {}
      for (paramInt1 = 34;; paramInt1 = 30)
      {
        f2 = paramInt1;
        break;
      }
      return j;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int j = 120;
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
            i = Integer.valueOf(paramQQAppInterface).intValue();
            if (i > 0) {
              return i;
            }
          }
          catch (Exception paramQQAppInterface)
          {
            if (QLog.isColorLevel()) {
              QLog.e("PttItemBuilder", 2, paramQQAppInterface.toString());
            }
          }
          i = j;
        } while ("ConvertText_MaxPtt".equals(paramString));
        i = j;
      } while ("Normal_MaxPtt".equals(paramString));
      if ("VIP_MaxPtt".equals(paramString)) {
        return 180;
      }
      int i = j;
    } while (!"SVIP_MaxPtt".equals(paramString));
    return 300;
  }
  
  private int a(MessageForPtt paramMessageForPtt)
  {
    int j = 2005;
    if (paramMessageForPtt.isSendFromLocal()) {
      if ((paramMessageForPtt.url != null) && (paramMessageForPtt.url.startsWith(AppConstants.aq))) {
        if (paramMessageForPtt.fileSize > 0L) {
          i = 1003;
        }
      }
    }
    do
    {
      do
      {
        return i;
        if (paramMessageForPtt.fileSize == -1L) {
          return 1005;
        }
        if (paramMessageForPtt.fileSize == -2L)
        {
          if (a(paramMessageForPtt)) {
            return 999;
          }
          paramMessageForPtt.fileSize = -1L;
          return 1005;
        }
        if (paramMessageForPtt.fileSize != -3L) {
          break;
        }
        i = 1001;
        j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPtt.url, paramMessageForPtt.uniseq);
      } while ((j != 1005) && (j != -1));
      paramMessageForPtt.fileSize = -1L;
      return 1005;
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPtt.url, paramMessageForPtt.uniseq);
      return 1004;
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "handlePttItem recieve friendUin " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + " url " + paramMessageForPtt.url + " urlAtServer " + paramMessageForPtt.urlAtServer + " uniseq " + paramMessageForPtt.uniseq);
      }
      if (paramMessageForPtt == null) {
        break;
      }
      i = j;
    } while (paramMessageForPtt.url == null);
    if ((paramMessageForPtt.url.startsWith(AppConstants.aq)) && (FileUtils.a(paramMessageForPtt.url))) {
      return 2003;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPtt.url, paramMessageForPtt.uniseq);
    if ((i == -1) && (paramMessageForPtt.fileSize == -4L)) {}
    for (;;)
    {
      i = j;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PttItemBuilder", 2, "handlePttItem recieve status " + j + "   url " + paramMessageForPtt.url + " uniseq " + paramMessageForPtt.uniseq);
      return j;
      j = i;
    }
    return 0;
  }
  
  private String a(int paramInt)
  {
    String str = "";
    int i = paramInt / 60;
    if (i > 0) {
      str = i + "'";
    }
    return str + paramInt % 60 + "\"";
  }
  
  private void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new bwk(this, paramMessageForPtt));
  }
  
  private void a(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.isReadPtt = true;
    paramMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
  }
  
  private boolean a(MessageForPtt paramMessageForPtt)
  {
    String str = QQRecorder.a();
    return (paramMessageForPtt.fileSize == -2L) && (!TextUtils.isEmpty(str)) && (str.equals(paramMessageForPtt.url));
  }
  
  private boolean b(ChatMessage paramChatMessage)
  {
    return paramChatMessage.vipBubbleID >= 1L;
  }
  
  private boolean c(ChatMessage paramChatMessage)
  {
    ChatMessage localChatMessage = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    return (localChatMessage == paramChatMessage) || (((localChatMessage instanceof MessageForPtt)) && (localChatMessage.frienduin != null) && (localChatMessage.frienduin.equals(paramChatMessage.frienduin)) && (localChatMessage.uniseq == paramChatMessage.uniseq));
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    PttItemBuilder.Holder localHolder = (PttItemBuilder.Holder)paramViewHolder;
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    paramBaseChatItemLayout = paramView;
    if (paramView == null)
    {
      paramBaseChatItemLayout = new BreathAnimationLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131296367);
      TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setId(2131296366);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427473));
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
      paramBaseChatItemLayout.addView((View)localObject);
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = paramBaseChatItemLayout;
      localHolder.jdField_a_of_type_AndroidWidgetTextView = localTextView;
      localHolder.jdField_a_of_type_AndroidWidgetImageView = paramView;
      localHolder.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject);
    }
    localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener = paramOnLongClickAndTouchListener;
    if (paramChatMessage.isSend())
    {
      ((RelativeLayout.LayoutParams)localHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131296366);
      ((RelativeLayout.LayoutParams)localHolder.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, -1);
    }
    for (;;)
    {
      int j = a(localMessageForPtt);
      int i = j;
      if (j == -1)
      {
        a(localHolder, localMessageForPtt);
        i = 2001;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTTItem->getBubbleView", 2, "fileStatus = " + i + " url " + localMessageForPtt.url + " uniseq " + localMessageForPtt.uniseq);
      }
      a(localHolder, localMessageForPtt, i, c(localMessageForPtt));
      FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this);
      return paramBaseChatItemLayout;
      ((RelativeLayout.LayoutParams)localHolder.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131296367);
      ((RelativeLayout.LayoutParams)localHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, -1);
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new PttItemBuilder.Holder();
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
        if (2131296656 != paramInt) {
          break;
        }
        paramInt = QQRecorder.a(paramContext.url);
      } while (paramInt <= 0);
      paramChatMessage = new QfavMicroPhoneDialog(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new bwl(this, paramContext));
      if (paramChatMessage.a(paramContext.url, paramInt))
      {
        paramChatMessage.show();
        return;
      }
      QfavUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131362677, 1);
      return;
      if (paramInt == 2131298932)
      {
        ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        return;
      }
      if (paramInt == 2131298937)
      {
        if (TextUtils.isEmpty(paramContext.sttText)) {}
        for (paramContext = this.jdField_a_of_type_AndroidContentContext.getString(2131363142);; paramContext = paramContext.sttText) {
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
    } while (paramInt != 2131296652);
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
      paramView = ActionSheet.a(this.jdField_a_of_type_AndroidContentContext, 2131624119);
      paramView.a(2131363074);
      paramView.c(2131363073);
      paramView.d(2131362794);
      paramView.a(new bwm(this, localMessageForPtt, paramView));
      paramView.show();
      return;
    }
    a(paramView, localMessageForPtt);
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
          paramInt2 = paramInt1;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTTItem->handleMessage", 2, "fileStatus:" + paramInt2 + "|url " + localMessageForPtt.url + "|uniseq " + localMessageForPtt.uniseq);
      }
      a(paramView, localMessageForPtt, paramInt2, c(localMessageForPtt));
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
      for (paramViewHolder = paramViewHolder.getColorStateList(2131427476);; paramViewHolder = paramViewHolder.getColorStateList(2131427473))
      {
        if (localHolder.jdField_a_of_type_AndroidWidgetTextView != null) {
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
  
  void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "fileStatus is:" + paramInt + ",url is:" + paramMessageForPtt.url + ",uniseq is:" + paramMessageForPtt.uniseq + ",stt is:" + paramMessageForPtt.sttAbility + ",long is:" + paramMessageForPtt.longPttVipFlag);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject1 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, -1);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
    paramHolder.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    paramHolder.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    Object localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources();
    String str;
    switch (paramInt)
    {
    default: 
      str = null;
      paramInt = 0;
      localObject1 = "";
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
          label354:
          if (paramHolder.b != null)
          {
            paramHolder.b.append("发送了语音.").append((String)localObject1);
            if (str != null) {
              paramHolder.b.append(" ").append(str);
            }
          }
          return;
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(10.0F, (Resources)localObject2), BaseChatItemLayout.n, AIOUtils.a(10.0F, (Resources)localObject2), BaseChatItemLayout.o);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
          str = null;
          paramInt = 1;
          localObject1 = "";
          continue;
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(40.0F, (Resources)localObject2), BaseChatItemLayout.n, AIOUtils.a(40.0F, (Resources)localObject2), BaseChatItemLayout.o);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(true);
          str = null;
          paramInt = 0;
          localObject1 = "";
        }
      }
    }
    int i = QQRecorder.a(paramMessageForPtt.url);
    paramMessageForPtt.timeLength = i;
    if (i <= 0)
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
    if (i > a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt")) {
      if (paramMessageForPtt.longPttVipFlag == 1)
      {
        if (this.jdField_a_of_type_AndroidTextSpannableString == null)
        {
          this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString("[v] QQ会员专享长语音");
          localObject1 = ((Resources)localObject2).getDrawable(2130838171);
          ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
          localObject1 = new OffsetableImageSpan((Drawable)localObject1, 1).a(-0.05F);
          this.jdField_a_of_type_AndroidTextSpannableString.setSpan(localObject1, 0, 3, 17);
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.jdField_a_of_type_AndroidTextSpannableString, this);
        str = "QQ会员专享长语音";
      }
    }
    for (;;)
    {
      label765:
      if (i > a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "ConvertText_MaxPtt")) {
        paramMessageForPtt.sttAbility = 0;
      }
      localObject1 = a(i);
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
      paramHolder.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      AnimationDrawable localAnimationDrawable;
      if (paramMessageForPtt.isSend()) {
        if (paramBoolean)
        {
          i = 2130968620;
          if (b(paramMessageForPtt)) {
            i = 2130968633;
          }
          localAnimationDrawable = (AnimationDrawable)((Resources)localObject2).getDrawable(i);
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localAnimationDrawable);
          localAnimationDrawable.start();
          label873:
          if ((paramInt != 2003) && (paramInt != 1003)) {
            break label1206;
          }
          if ((paramMessageForPtt.isSend()) || (paramMessageForPtt.isReadPtt)) {
            break label1362;
          }
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
          paramInt = 0;
        }
      }
      for (;;)
      {
        i = AIOUtils.a(9.0F, (Resources)localObject2);
        int j = a(paramMessageForPtt.timeLength, null, null, 0, 0, false);
        if (paramMessageForPtt.isSend())
        {
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, i, 0);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(j, BaseChatItemLayout.n, BaseChatItemLayout.s, BaseChatItemLayout.o);
          break;
          if (paramMessageForPtt.longPttVipFlag != 2) {
            break label1367;
          }
          if (this.b == null)
          {
            this.b = new SpannableString("[v] 超级会员专享长语音");
            localObject1 = ((Resources)localObject2).getDrawable(2130838170);
            ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
            localObject1 = new OffsetableImageSpan((Drawable)localObject1, 1).a(-0.05F);
            this.b.setSpan(localObject1, 0, 3, 17);
          }
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.b, this);
          str = "超级会员专享长语音";
          break label765;
          if (b(paramMessageForPtt))
          {
            paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838951);
            break label873;
          }
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839197);
          break label873;
          if (paramBoolean)
          {
            i = 2130968647;
            if (b(paramMessageForPtt)) {
              i = 2130968632;
            }
            localAnimationDrawable = (AnimationDrawable)((Resources)localObject2).getDrawable(i);
            paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localAnimationDrawable);
            localAnimationDrawable.start();
            break label873;
          }
          if (b(paramMessageForPtt))
          {
            paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838950);
            break label873;
          }
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839196);
          break label873;
          label1206:
          if ((paramInt == 1005) || (paramInt == 1004))
          {
            paramInt = 1;
            continue;
          }
          paramInt = 4;
          continue;
        }
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(i, 0, 0, 0);
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(BaseChatItemLayout.s, BaseChatItemLayout.n, j, BaseChatItemLayout.o);
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
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconResource(2130837910, null);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.setBackgroundDrawable(null);
        ((Animatable)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.getDrawable()).start();
        break label354;
        label1362:
        paramInt = 0;
      }
      label1367:
      str = null;
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    if (paramView != null)
    {
      paramXListView = (PttItemBuilder.Holder)AIOUtils.a(paramView);
      paramView = (MessageForPtt)paramChatMessage;
      a(paramXListView, paramView, a(paramView), false);
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
      paramView = (PttItemBuilder.Holder)AIOUtils.a(paramView);
      if (paramAudioPlayer.a(paramXListView.url))
      {
        a(paramXListView);
        if (paramView != null) {
          a(paramView, paramXListView, a(paramXListView), true);
        }
        return true;
      }
    }
    return false;
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
    if (QQRecorder.a(paramView.url) <= 0)
    {
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      return localQQCustomMenu.a();
    }
    localQQCustomMenu.a(this.jdField_a_of_type_AndroidContentContext.getString(2131362798));
    localQQCustomMenu.a(2131296656, this.jdField_a_of_type_AndroidContentContext.getString(2131362666));
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    return localQQCustomMenu.a();
  }
  
  public void c() {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    MessageForPtt localMessageForPtt = (MessageForPtt)((PttItemBuilder.Holder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (i == 2131296368)
    {
      if (c(localMessageForPtt)) {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
      }
      do
      {
        do
        {
          return;
        } while ((localMessageForPtt == MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) || (!localMessageForPtt.isReady()));
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d())
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131363140, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492887));
          return;
        }
      } while (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(AIOUtils.a(paramView)));
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131363141, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492887));
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttItemBuilder
 * JD-Core Version:    0.7.0.1
 */