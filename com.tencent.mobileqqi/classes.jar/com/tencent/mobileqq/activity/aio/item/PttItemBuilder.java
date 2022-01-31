package com.tencent.mobileqq.activity.aio.item;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
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
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
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
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.stt.SttManager.ISttListener;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.XListView;
import cooperation.qqfav.QfavUtil;
import cooperation.qqfav.widget.QfavMicroPhoneDialog;
import efh;
import efi;
import efj;
import mqq.manager.ServerConfigManager.ConfigType;

public class PttItemBuilder
  extends BaseBubbleBuilder
  implements FileTransferManager.Callback, MediaPlayerManager.Callback, SttManager.ISttListener
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
  private static final int i = 1;
  private static final int j = 2;
  private static final int k = 3;
  private SpannableString jdField_a_of_type_AndroidTextSpannableString;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SttManager jdField_a_of_type_ComTencentMobileqqSttSttManager;
  private SpannableString b;
  
  public PttItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_ComTencentMobileqqSttSttManager = ((SttManager)paramQQAppInterface.getManager(15));
    this.jdField_a_of_type_ComTencentMobileqqSttSttManager.a(null);
  }
  
  private int a(int paramInt1, String paramString, Paint paramPaint, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int m = Math.min(60, Math.max(1, paramInt1));
    int n;
    float f1;
    if (m > 40)
    {
      m += 40;
      n = AIOUtils.a(m + 20, this.jdField_a_of_type_AndroidContentContext.getResources());
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "viewLenByTime is:" + n);
      }
      if ((paramString == null) || (paramPaint == null)) {
        break label313;
      }
      m = BaseChatItemLayout.g - BaseChatItemLayout.k - BaseChatItemLayout.l - 32;
      f1 = paramPaint.measureText(paramString) + paramInt2;
      if (f1 <= m) {
        break label316;
      }
      f1 = m;
    }
    label313:
    label316:
    for (;;)
    {
      float f2;
      if (paramInt1 > 99)
      {
        f2 = 38.0F;
        int i1 = AIOUtils.a(f2, this.jdField_a_of_type_AndroidContentContext.getResources());
        n = n + i1 + paramInt3;
        paramInt1 = n;
        if (n > m) {
          paramInt1 = m;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PttItemBuilder", 2, "viewLenByText is:" + f1 + ",maxlength is:" + m + ",flagTimeLen is:" + i1 + ",arrowIVWidth is:" + paramInt2 + ",convertIVWidth is:" + paramInt3 + ",convertIVVisible is:" + paramBoolean);
        }
        paramInt2 = Math.max(paramInt1, (int)f1) - i1;
        paramInt1 = paramInt2;
        if (paramBoolean) {
          paramInt1 = paramInt2 - paramInt3;
        }
        return paramInt1;
        m *= 2;
        break;
      }
      if (paramInt1 > 9) {}
      for (paramInt1 = 34;; paramInt1 = 30)
      {
        f2 = paramInt1;
        break;
      }
      return n;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int n = 120;
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
            m = Integer.valueOf(paramQQAppInterface).intValue();
            if (m > 0) {
              return m;
            }
          }
          catch (Exception paramQQAppInterface)
          {
            if (QLog.isColorLevel()) {
              QLog.e("PttItemBuilder", 2, paramQQAppInterface.toString());
            }
          }
          m = n;
        } while ("ConvertText_MaxPtt".equals(paramString));
        m = n;
      } while ("Normal_MaxPtt".equals(paramString));
      if ("VIP_MaxPtt".equals(paramString)) {
        return 180;
      }
      int m = n;
    } while (!"SVIP_MaxPtt".equals(paramString));
    return 300;
  }
  
  private int a(MessageForPtt paramMessageForPtt)
  {
    int n = 2005;
    if (paramMessageForPtt.isSendFromLocal()) {
      if ((paramMessageForPtt.url != null) && (paramMessageForPtt.url.startsWith(AppConstants.al))) {
        if (paramMessageForPtt.fileSize > 0L) {
          m = 1003;
        }
      }
    }
    do
    {
      do
      {
        return m;
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
        m = 1001;
        n = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPtt.url, paramMessageForPtt.uniseq);
      } while ((n != 1005) && (n != -1));
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
      m = n;
    } while (paramMessageForPtt.url == null);
    if ((paramMessageForPtt.url.startsWith(AppConstants.al)) && (FileUtils.a(paramMessageForPtt.url))) {
      return 2003;
    }
    int m = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPtt.url, paramMessageForPtt.uniseq);
    if ((m == -1) && (paramMessageForPtt.fileSize == -4L)) {}
    for (;;)
    {
      m = n;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PttItemBuilder", 2, "handlePttItem recieve status " + n + "   url " + paramMessageForPtt.url + " uniseq " + paramMessageForPtt.uniseq);
      return n;
      n = m;
    }
    return 0;
  }
  
  private String a(int paramInt)
  {
    String str = "";
    int m = paramInt / 60;
    if (m > 0) {
      str = m + "'";
    }
    return str + paramInt % 60 + "\"";
  }
  
  private void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new efh(this, paramMessageForPtt));
  }
  
  private void a(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.isReadPtt = true;
    paramMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
  }
  
  private boolean a(MessageForPtt paramMessageForPtt)
  {
    String str = QQRecorder.b();
    return (paramMessageForPtt.fileSize == -2L) && (!TextUtils.isEmpty(str)) && (str.equals(paramMessageForPtt.url));
  }
  
  private boolean c(ChatMessage paramChatMessage)
  {
    return paramChatMessage.vipBubbleID >= 1L;
  }
  
  private boolean d(ChatMessage paramChatMessage)
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
      paramView.setId(2131230837);
      TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setId(2131230836);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131362077));
      Object localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject).setId(2131230838);
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
      ((RelativeLayout.LayoutParams)localHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131230836);
      ((RelativeLayout.LayoutParams)localHolder.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, -1);
    }
    for (;;)
    {
      int n = a(localMessageForPtt);
      int m = n;
      if (n == -1)
      {
        a(localHolder, localMessageForPtt);
        m = 2001;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTTItem->getBubbleView", 2, "fileStatus = " + m + " url " + localMessageForPtt.url + " uniseq " + localMessageForPtt.uniseq);
      }
      a(localHolder, localMessageForPtt, m, d(localMessageForPtt));
      FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this);
      return paramBaseChatItemLayout;
      ((RelativeLayout.LayoutParams)localHolder.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131230837);
      ((RelativeLayout.LayoutParams)localHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, -1);
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new PttItemBuilder.Holder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558901);
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
        if (2131231192 != paramInt) {
          break;
        }
        paramInt = QQRecorder.a(paramContext.url);
      } while (paramInt <= 0);
      paramChatMessage = new QfavMicroPhoneDialog(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new efi(this, paramContext));
      if (paramChatMessage.a(paramContext.url, paramInt))
      {
        paramChatMessage.show();
        return;
      }
      QfavUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131560785, 1);
      return;
      if (paramInt == 2131234872)
      {
        ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        return;
      }
      if (paramInt == 2131234877)
      {
        if (TextUtils.isEmpty(paramContext.sttText)) {}
        for (paramContext = this.jdField_a_of_type_AndroidContentContext.getString(2131561420);; paramContext = paramContext.sttText) {
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
    } while (paramInt != 2131231190);
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
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558899), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427376));
  }
  
  protected void a(View paramView)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)AIOUtils.a(paramView);
    paramView = (PttItemBuilder.Holder)AIOUtils.a(paramView);
    if (localMessageForPtt.isSendFromLocal())
    {
      paramView = ActionSheet.a(this.jdField_a_of_type_AndroidContentContext);
      paramView.a(2131561439);
      paramView.c(2131562859);
      paramView.d(2131561746);
      paramView.a(new efj(this, localMessageForPtt, paramView));
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
      a(paramView, localMessageForPtt, paramInt2, d(localMessageForPtt));
      return;
      if ((paramFileMsg.u == 1005) || (paramFileMsg.u == 1004))
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
      if (paramChatMessage.isSend())
      {
        paramViewHolder = paramViewHolder.getColorStateList(2131362080);
        if (localHolder.jdField_a_of_type_AndroidWidgetTextView != null) {
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
        }
        if (localHolder.jdField_b_of_type_AndroidWidgetTextView != null) {
          localHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
        }
      }
    }
    label127:
    do
    {
      do
      {
        return;
        paramViewHolder = paramViewHolder.getColorStateList(2131362077);
        break;
        if (paramBubbleInfo.b != 0) {
          break label127;
        }
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      } while (localHolder.jdField_b_of_type_AndroidWidgetTextView == null);
      localHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      return;
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.b);
    } while (localHolder.jdField_b_of_type_AndroidWidgetTextView == null);
    localHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.b);
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
    if (paramHolder.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      paramHolder.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(null);
      paramHolder.c.setVisibility(8);
    }
    if (paramHolder.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      paramHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramHolder.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      paramHolder.d.setVisibility(8);
      paramHolder.e.setVisibility(8);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
    paramHolder.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    paramHolder.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    Object localObject4 = this.jdField_a_of_type_AndroidContentContext.getResources();
    switch (paramInt)
    {
    default: 
      localObject1 = "";
      paramInt = 0;
      switch (paramInt)
      {
      case 2: 
      case 3: 
      default: 
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView != null) {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        }
        break;
      }
      break;
    }
    for (;;)
    {
      if (paramHolder.jdField_b_of_type_JavaLangStringBuilder != null)
      {
        paramHolder.jdField_b_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558900)).append((String)localObject1);
        if (0 != 0) {
          paramHolder.jdField_b_of_type_JavaLangStringBuilder.append(" ").append(null);
        }
      }
      return;
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(10.0F, (Resources)localObject4), BaseChatItemLayout.n, AIOUtils.a(10.0F, (Resources)localObject4), BaseChatItemLayout.o);
      paramInt = 1;
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
      localObject1 = "";
      break;
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(40.0F, (Resources)localObject4), BaseChatItemLayout.n, AIOUtils.a(40.0F, (Resources)localObject4), BaseChatItemLayout.o);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(true);
      localObject1 = "";
      paramInt = 0;
      break;
      int m = QQRecorder.a(paramMessageForPtt.url);
      paramMessageForPtt.timeLength = m;
      if (m <= 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PttItemBuilder", 2, "get a amr file length = 0 return now");
        }
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(10.0F, (Resources)localObject4), BaseChatItemLayout.n, AIOUtils.a(10.0F, (Resources)localObject4), BaseChatItemLayout.o);
        return;
      }
      if (m > a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "ConvertText_MaxPtt")) {
        paramMessageForPtt.sttAbility = 0;
      }
      localObject1 = a(m);
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
      paramHolder.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      label837:
      int n;
      label890:
      int i2;
      label907:
      int i1;
      int i3;
      int i4;
      int i5;
      int i6;
      if (paramMessageForPtt.isSend()) {
        if (paramBoolean)
        {
          m = 2130968622;
          if (c(paramMessageForPtt)) {
            m = 2130968665;
          }
          localObject2 = (AnimationDrawable)((Resources)localObject4).getDrawable(m);
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          ((AnimationDrawable)localObject2).start();
          n = 0;
          if ((paramInt != 2003) && (paramInt != 1003)) {
            break label1193;
          }
          if ((!paramMessageForPtt.isSend()) && (!paramMessageForPtt.isReadPtt)) {
            paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
          }
          if (paramMessageForPtt.sttAbility != 0) {
            break label1148;
          }
          m = 1;
          paramInt = 0;
          i2 = AIOUtils.a(9.0F, (Resources)localObject4);
          if (!paramMessageForPtt.isSend()) {
            break label1223;
          }
          i1 = i2;
          i3 = AIOUtils.a(12.0F, (Resources)localObject4);
          ((Resources)localObject4).getDrawable(2130838677).getIntrinsicWidth();
          i4 = ((Resources)localObject4).getDrawable(2130838677).getIntrinsicHeight();
          i5 = ((Resources)localObject4).getDrawable(2130839791).getIntrinsicWidth();
          i6 = AIOUtils.a(1.0F, (Resources)localObject4);
          if (m != 1) {
            break label1259;
          }
          m = a(paramMessageForPtt.timeLength, null, null, 0, 0, false);
          if (!paramMessageForPtt.isSend()) {
            break label1226;
          }
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, i2, 0);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(m, BaseChatItemLayout.n, BaseChatItemLayout.s, BaseChatItemLayout.o);
        }
      }
      for (;;)
      {
        break;
        if (c(paramMessageForPtt))
        {
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839109);
          break label837;
        }
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839781);
        break label837;
        if (paramBoolean)
        {
          m = 2130968692;
          if (c(paramMessageForPtt)) {
            m = 2130968664;
          }
          localObject2 = (AnimationDrawable)((Resources)localObject4).getDrawable(m);
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          ((AnimationDrawable)localObject2).start();
          break label837;
        }
        if (c(paramMessageForPtt))
        {
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839108);
          break label837;
        }
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839780);
        break label837;
        label1148:
        if (paramMessageForPtt.sttAbility == 1)
        {
          m = 2;
          paramInt = 0;
          break label890;
        }
        if (paramMessageForPtt.expandStt) {}
        for (paramInt = 3;; paramInt = 2)
        {
          i1 = 0;
          n = 1;
          m = paramInt;
          paramInt = i1;
          break;
        }
        label1193:
        if ((paramInt == 1005) || (paramInt == 1004))
        {
          m = 1;
          paramInt = 1;
          break label890;
        }
        m = 1;
        paramInt = 4;
        break label890;
        label1223:
        break label907;
        label1226:
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(i2, 0, 0, 0);
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(BaseChatItemLayout.s, BaseChatItemLayout.n, m, BaseChatItemLayout.o);
      }
      label1259:
      Object localObject3;
      if (m == 2)
      {
        if (paramHolder.jdField_b_of_type_AndroidWidgetImageView == null)
        {
          localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localObject3 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject3).addRule(15);
          ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
          ((ImageView)localObject2).setId(2131230839);
          ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
          localObject3 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          ((ImageView)localObject3).setImageDrawable(new ColorDrawable(838860800));
          ((ImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_XY);
          localObject4 = new RelativeLayout.LayoutParams(i6, -1);
          ((RelativeLayout.LayoutParams)localObject4).addRule(15);
          ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          ((ImageView)localObject3).setId(2131230840);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject2);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject3);
          paramHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
          paramHolder.c = ((ImageView)localObject3);
          label1428:
          paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          paramHolder.c.setVisibility(8);
          paramHolder.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
          if (n == 0) {
            break label1736;
          }
          m = a(paramMessageForPtt.timeLength, null, null, 0, 0, false);
          label1474:
          if (!paramMessageForPtt.isSend()) {
            break label1754;
          }
          localObject2 = (RelativeLayout.LayoutParams)paramHolder.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(0, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(1, -1);
          localObject2 = (RelativeLayout.LayoutParams)paramHolder.c.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(0, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131230839);
          ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131230838);
          ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131230838);
          ((RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams()).addRule(1, 2131230840);
          i1 = 2130839793;
          n = 2130838680;
          if (c(paramMessageForPtt))
          {
            i1 = 2130838682;
            n = 2130838678;
          }
          paramHolder.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(i1);
          paramHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(n);
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, i2, 0);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(m, BaseChatItemLayout.n, BaseChatItemLayout.s, BaseChatItemLayout.o);
          paramHolder.jdField_b_of_type_AndroidWidgetImageView.setPadding(i2, 0, i2, 0);
          paramHolder.c.setPadding(0, BaseChatItemLayout.r, 0, BaseChatItemLayout.r);
          label1676:
          localObject2 = (Animatable)paramHolder.jdField_b_of_type_AndroidWidgetImageView.getDrawable();
          if (paramMessageForPtt.sttAbility != 1) {
            break label1947;
          }
          if (!this.jdField_a_of_type_ComTencentMobileqqSttSttManager.a(paramMessageForPtt)) {
            break label1937;
          }
          ((Animatable)localObject2).start();
        }
        for (;;)
        {
          break;
          paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          paramHolder.c.setVisibility(0);
          break label1428;
          label1736:
          m = a(paramMessageForPtt.timeLength, null, null, 0, 0, false);
          break label1474;
          label1754:
          localObject2 = (RelativeLayout.LayoutParams)paramHolder.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131230840);
          ((RelativeLayout.LayoutParams)localObject2).addRule(0, -1);
          localObject2 = (RelativeLayout.LayoutParams)paramHolder.c.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131230838);
          ((RelativeLayout.LayoutParams)localObject2).addRule(0, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131230838);
          ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131230838);
          i1 = 2130839792;
          n = 2130838679;
          if (c(paramMessageForPtt))
          {
            i1 = 2130838682;
            n = 2130838678;
          }
          paramHolder.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(i1);
          paramHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(n);
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(i2, 0, 0, 0);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(BaseChatItemLayout.s, BaseChatItemLayout.n, m, BaseChatItemLayout.o);
          paramHolder.jdField_b_of_type_AndroidWidgetImageView.setPadding(i2, 0, i2, 0);
          paramHolder.c.setPadding(0, BaseChatItemLayout.r, 0, BaseChatItemLayout.r);
          break label1676;
          label1937:
          ((Animatable)localObject2).stop();
          continue;
          label1947:
          if (paramMessageForPtt.sttAbility == 2) {
            ((Animatable)localObject2).stop();
          }
        }
      }
      if (paramHolder.jdField_b_of_type_AndroidWidgetTextView == null)
      {
        localObject3 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        ((ImageView)localObject3).setImageDrawable(new ColorDrawable(838860800));
        RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, i6);
        ((ImageView)localObject3).setLayoutParams(localLayoutParams1);
        ((ImageView)localObject3).setId(2131230842);
        TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
        if (paramMessageForPtt.isSend())
        {
          localObject2 = ((Resources)localObject4).getColorStateList(2131362080);
          label2057:
          localTextView.setTextColor((ColorStateList)localObject2);
          localTextView.setId(2131230841);
          localObject2 = new RelativeLayout.LayoutParams(-2, -2);
          localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
          localImageView.setLayoutParams(localLayoutParams2);
          localImageView.setImageResource(2130838677);
          localImageView.setScaleType(ImageView.ScaleType.FIT_END);
          localLayoutParams1.addRule(3, 2131230838);
          localLayoutParams1.addRule(14);
          ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131230842);
          localLayoutParams2.addRule(3, 2131230842);
          localLayoutParams2.addRule(14);
          localLayoutParams2.addRule(6, 2131230841);
          localLayoutParams2.addRule(8, 2131230841);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject3);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localTextView);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localImageView);
          paramHolder.d = ((ImageView)localObject3);
          paramHolder.jdField_b_of_type_AndroidWidgetTextView = localTextView;
          paramHolder.e = localImageView;
          label2247:
          paramHolder.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
          paramHolder.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
          paramHolder.jdField_b_of_type_AndroidWidgetTextView.setOnLongClickListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
          if (n == 0) {
            break label2632;
          }
          localObject3 = paramMessageForPtt.sttText;
          localObject2 = localObject3;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131561420);
          }
          if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
            this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
          m = a(paramMessageForPtt.timeLength, (String)localObject2, this.jdField_a_of_type_AndroidWidgetTextView.getPaint(), 0, i2 * 2 + i5 + i6, false);
          label2381:
          paramHolder.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
          n = AIOUtils.a(22.0F, (Resources)localObject4) + i4;
          if (!paramMessageForPtt.isSend()) {
            break label2650;
          }
          localObject2 = (RelativeLayout.LayoutParams)paramHolder.d.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131230838);
          ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131230838);
          localObject2 = (RelativeLayout.LayoutParams)paramHolder.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131230838);
          ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131230838);
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, i2, 0);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(m, BaseChatItemLayout.n, BaseChatItemLayout.s, BaseChatItemLayout.o);
          paramHolder.d.setPadding(i2, 0, i2, 0);
          paramHolder.jdField_b_of_type_AndroidWidgetTextView.setPadding(i2, BaseChatItemLayout.n, i1, n);
          paramHolder.e.setPadding(0, 0, 0, i3);
        }
      }
      for (;;)
      {
        localObject3 = paramMessageForPtt.sttText;
        localObject2 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131561420);
        }
        paramHolder.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        break;
        localObject2 = ((Resources)localObject4).getColorStateList(2131362077);
        break label2057;
        paramHolder.d.setVisibility(0);
        paramHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramHolder.e.setVisibility(0);
        break label2247;
        label2632:
        m = a(paramMessageForPtt.timeLength, null, null, 0, 0, false);
        break label2381;
        label2650:
        localObject2 = (RelativeLayout.LayoutParams)paramHolder.d.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131230838);
        ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131230838);
        localObject2 = (RelativeLayout.LayoutParams)paramHolder.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131230838);
        ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131230838);
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(i2, 0, 0, 0);
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(BaseChatItemLayout.s, BaseChatItemLayout.n, m, BaseChatItemLayout.o);
        paramHolder.d.setPadding(i2, 0, i2, 0);
        paramHolder.jdField_b_of_type_AndroidWidgetTextView.setPadding(i2, BaseChatItemLayout.n, i1, n);
        paramHolder.e.setPadding(0, 0, 0, i3);
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      Object localObject2 = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView;
      if (paramMessageForPtt.isSendFromLocal()) {}
      for (paramMessageForPtt = "重新发送语音消息";; paramMessageForPtt = "重新拉取语音消息")
      {
        ((ImageView)localObject2).setContentDescription(paramMessageForPtt);
        break;
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconResource(2130837860, null);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      ((Animatable)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getDrawable()).start();
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    if (paramView != null)
    {
      paramXListView = (PttItemBuilder.Holder)AIOUtils.a(paramView);
      paramView = (MessageForPtt)paramChatMessage;
      a(paramXListView, paramView, a(paramView), false);
      b();
    }
  }
  
  public void a(boolean paramBoolean, MessageForPtt paramMessageForPtt)
  {
    if (!paramBoolean) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558902), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427376));
    }
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
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
        if (paramView != null)
        {
          a(paramView, paramXListView, a(paramXListView), true);
          a(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout, paramXListView, paramView.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo, 0);
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
    if ((paramView.sttAbility == 2) && (paramView.expandStt))
    {
      localQQCustomMenu.a(2131234877, this.jdField_a_of_type_AndroidContentContext.getString(2131561878));
      localQQCustomMenu.a(2131231190, this.jdField_a_of_type_AndroidContentContext.getString(2131562132));
    }
    localQQCustomMenu.a(this.jdField_a_of_type_AndroidContentContext.getString(2131562611));
    localQQCustomMenu.a(2131231192, this.jdField_a_of_type_AndroidContentContext.getString(2131560772));
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    return localQQCustomMenu.a();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqSttSttManager.a(null);
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    PttItemBuilder.Holder localHolder = (PttItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForPtt localMessageForPtt = (MessageForPtt)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (m == 2131230838) {
      if (d(localMessageForPtt)) {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
      }
    }
    label49:
    do
    {
      do
      {
        do
        {
          break label49;
          do
          {
            return;
          } while ((localMessageForPtt == MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) || (!localMessageForPtt.isReady()));
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131561724, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427376));
            return;
          }
        } while (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(AIOUtils.a(paramView)));
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131561768, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427376));
        return;
        if (m != 2131230839) {
          break;
        }
        if (localMessageForPtt.sttAbility == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqSttSttManager.a(localMessageForPtt);
          this.jdField_a_of_type_ComTencentMobileqqSttSttManager.a(this);
          a(localHolder, localMessageForPtt, a(localMessageForPtt), d(localMessageForPtt));
          return;
        }
      } while ((localMessageForPtt.sttAbility != 2) || (localMessageForPtt.expandStt));
      localMessageForPtt.expandStt = true;
      localMessageForPtt.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForPtt.uniseq, localMessageForPtt.msgData);
      a(localHolder, localMessageForPtt, a(localMessageForPtt), d(localMessageForPtt));
      a(localHolder, localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, localMessageForPtt, localHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
      return;
      if (m != 2131230841) {
        break;
      }
    } while (!localMessageForPtt.expandStt);
    localMessageForPtt.expandStt = false;
    localMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForPtt.uniseq, localMessageForPtt.msgData);
    a(localHolder, localMessageForPtt, a(localMessageForPtt), d(localMessageForPtt));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8003F37", "0X8003F37", 0, 0, "", "", "", "");
    return;
    if (m == 2131230780)
    {
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      paramView.putExtra("url", "http://m.vip.qq.com/freedom/freedom_longvoice.html");
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttItemBuilder
 * JD-Core Version:    0.7.0.1
 */