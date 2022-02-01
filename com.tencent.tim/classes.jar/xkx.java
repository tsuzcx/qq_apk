import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.os.StatFs;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.d;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.a;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.c;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.a;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils.VoicePrintView;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.activity.aio.item.PttAudioChangeView;
import com.tencent.mobileqq.activity.aio.item.PttAudioPlayView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView.a;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder.2;
import com.tencent.mobileqq.activity.aio.item.SyncParentPressedRelativeLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.XListView;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.os.MqqHandler;

public class xkx
  extends BaseBubbleBuilder
  implements anvq.a, BaseBubbleBuilder.d, BaseChatItemLayout.a, CustomizeStrategyFactory.c, MediaPlayerManager.a, PttAudioWaveView.a, wla.a
{
  protected TextView Jo;
  protected anvo a;
  private BaseChatPie a;
  Set<xkx.a> bp = new HashSet();
  protected SpannableString d;
  protected SpannableString e;
  private Map<Long, String> hM = new HashMap();
  
  public xkx(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Anvo = ((anvo)paramQQAppInterface.getManager(17));
    this.jdField_a_of_type_Anvo.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public static int a(Context paramContext, int paramInt1, float paramFloat, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramInt1 = Math.min(60, Math.max(1, paramInt1));
    if (paramInt1 == 1)
    {
      paramInt1 = 25;
      int i = 0;
      if (paramBoolean1) {
        i = 16;
      }
      int j = i;
      if (paramBoolean2) {
        j = i + 38;
      }
      i = paramInt1;
      if (j != 0)
      {
        i = paramInt1;
        if (paramInt1 > 170 - j) {
          i = 170 - j;
        }
      }
      paramInt1 = i;
      if (i % 5 != 0) {
        paramInt1 = i / 5 * 5;
      }
      paramInt1 = wja.dp2px(paramInt1, paramContext.getResources());
      if (paramFloat <= 0.0F) {
        break label196;
      }
      paramInt1 = Math.max(paramInt1 + wja.dp2px(paramInt2, paramContext.getResources()) + wja.dp2px(paramInt3, paramContext.getResources()), (int)paramFloat);
      paramInt3 = BaseChatItemLayout.bNT - BaseChatItemLayout.bNX - BaseChatItemLayout.bNY - 32;
      if (paramInt1 <= paramInt3) {
        break label209;
      }
      paramInt1 = paramInt3;
    }
    label196:
    label209:
    for (;;)
    {
      return paramInt1 - wja.dp2px(paramInt2 - 40, paramContext.getResources());
      paramInt1 = 15 + (int)(PttAudioWaveView.b(paramInt1, 60, 1.5F) * 125.0F);
      break;
      return paramInt1 + wja.dp2px(paramInt3, paramContext.getResources());
    }
  }
  
  public static int a(Context paramContext, int paramInt1, String paramString, Paint paramPaint, int paramInt2)
  {
    int i = Math.min(60, Math.max(1, paramInt1));
    int j;
    float f1;
    if (i > 40)
    {
      i += 40;
      j = wja.dp2px(i + 20, paramContext.getResources());
      if ((paramString == null) || (paramPaint == null)) {
        break label173;
      }
      i = BaseChatItemLayout.bNT - BaseChatItemLayout.bNX - BaseChatItemLayout.bNY - 32;
      f1 = paramPaint.measureText(paramString) + paramInt2;
      if (f1 <= i) {
        break label176;
      }
      f1 = i;
    }
    label173:
    label176:
    for (;;)
    {
      float f2;
      if (paramInt1 > 99)
      {
        f2 = 38.0F;
        int k = wja.dp2px(f2, paramContext.getResources());
        paramInt2 = j + k;
        paramInt1 = paramInt2;
        if (paramInt2 > i) {
          paramInt1 = i;
        }
        return Math.max(paramInt1, (int)f1) - k;
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
  
  public static int a(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt)
  {
    int j = 999;
    int k = 1005;
    if (paramMessageForPtt == null) {
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "parsePttStatus  fileSize " + paramMessageForPtt.fileSize + " url " + paramMessageForPtt.url + " uniseq " + paramMessageForPtt.uniseq);
    }
    int i;
    if (paramMessageForPtt.isSendFromLocal()) {
      if ((paramMessageForPtt.url != null) && (paramMessageForPtt.url.startsWith(acbn.SDCARD_ROOT))) {
        if (paramMessageForPtt.fileSize > 0L) {
          i = 1003;
        }
      }
    }
    for (;;)
    {
      return i;
      i = k;
      if (paramMessageForPtt.fileSize != -1L) {
        if (paramMessageForPtt.fileSize == -2L)
        {
          if (a(paramMessageForPtt))
          {
            i = 999;
          }
          else
          {
            paramMessageForPtt.fileSize = -1L;
            i = k;
          }
        }
        else
        {
          if (paramMessageForPtt.fileSize == -3L)
          {
            boolean bool = paramQQAppInterface.a().k(paramMessageForPtt.frienduin, paramMessageForPtt.getLocalFilePath(), paramMessageForPtt.uniseq);
            k = paramQQAppInterface.a().c(paramMessageForPtt.frienduin, paramMessageForPtt.getLocalFilePath(), paramMessageForPtt.uniseq);
            if (QLog.isColorLevel()) {
              QLog.d("PttItemBuilder", 2, "parsePttStatus transStatus  " + k + ", hasTransProc " + bool);
            }
            if ((!bool) || (k == 1005))
            {
              paramMessageForPtt.fileSize = -1L;
              i = 1005;
            }
            for (;;)
            {
              break;
              i = j;
              if (k != 7000) {
                i = 1001;
              }
            }
          }
          j = paramQQAppInterface.a().c(paramMessageForPtt.frienduin, paramMessageForPtt.getLocalFilePath(), paramMessageForPtt.uniseq);
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("PttItemBuilder", 2, "parsePttStatus status  " + j);
            i = j;
            continue;
            i = 1004;
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("PttItemBuilder", 2, "handlePttItem recieve friendUin " + paramMessageForPtt.frienduin + " url " + paramMessageForPtt.url + " urlAtServer " + paramMessageForPtt.urlAtServer + " uniseq " + paramMessageForPtt.uniseq);
            }
            if (paramMessageForPtt != null)
            {
              j = alip.b(paramQQAppInterface, paramMessageForPtt);
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("PttItemBuilder", 2, "handlePttItem recieve status " + j + "   url " + paramMessageForPtt.url + " uniseq " + paramMessageForPtt.uniseq);
                i = j;
              }
            }
            else
            {
              i = 0;
            }
          }
        }
      }
    }
  }
  
  private void a(int paramInt, xkx.a parama)
  {
    if (parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
      parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgressColor(paramInt);
    }
    if (parama.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
      parama.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setThemeColor(paramInt);
    }
    if (parama.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView != null) {
      parama.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setThemeColor(paramInt);
    }
  }
  
  private void a(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.isReadPtt = true;
    paramMessageForPtt.serial();
    this.app.b().c(this.sessionInfo.aTl, this.sessionInfo.cZ, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
  }
  
  private void a(MessageForPtt paramMessageForPtt, int paramInt)
  {
    if (xla.bhD)
    {
      this.jdField_a_of_type_Anvo.a(paramMessageForPtt);
      return;
    }
    this.jdField_a_of_type_Anvo.b(paramMessageForPtt, paramInt);
  }
  
  private void a(xkx.a parama, MessageForPtt paramMessageForPtt, View paramView)
  {
    if (this.app.bF())
    {
      QQToast.a(this.mContext, 1, 2131697385, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      return;
    }
    if (!ahbj.fileExistsAndNotEmpty(paramMessageForPtt.getLocalFilePath()))
    {
      a(parama, paramMessageForPtt, false, true);
      a(parama, paramMessageForPtt, 5003, false);
      return;
    }
    PttAudioWaveView localPttAudioWaveView = (PttAudioWaveView)paramView.findViewById(2131374801);
    float f;
    int i;
    if (localPttAudioWaveView != null)
    {
      f = paramMessageForPtt.playProgress;
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "onClick, onPlayProgress progress = " + f);
      }
      if (f == 1.0F)
      {
        localPttAudioWaveView.setProgress(0.0F);
        paramMessageForPtt.playProgress = 0.0F;
        i = 0;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "onClick, onPlayProgress offset = " + i);
      }
      MediaPlayerManager.a(this.app).Cl(parama.pos);
      anot.a(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 1, 0, "", "", "", "");
      if (MediaPlayerManager.a(this.app).a(wja.a(paramView), i)) {
        break;
      }
      QQToast.a(this.mContext, 1, 2131697384, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      return;
      i = (int)(paramMessageForPtt.voiceLength * 1000.0F * f);
      continue;
      i = 0;
    }
  }
  
  protected static boolean a(MessageForPtt paramMessageForPtt)
  {
    String str = QQRecorder.Cf();
    return (paramMessageForPtt.fileSize == -2L) && (!TextUtils.isEmpty(str)) && (str.equals(paramMessageForPtt.getLocalFilePath()));
  }
  
  public static String az(int paramInt)
  {
    String str = "";
    int i = paramInt / 60;
    if (i > 0) {
      str = i + "'";
    }
    return str + paramInt % 60 + "\"";
  }
  
  private void b(View paramView, ColorFilter paramColorFilter)
  {
    Object localObject = (xkx.a)paramView.getTag();
    if (localObject != null)
    {
      paramView = wja.a(paramView);
      if ((paramView != null) && (paramView.vipBubbleID == 0L))
      {
        localObject = ((xkx.a)localObject).c.getBackground();
        if ((localObject != null) && (paramView.vipBubbleID == 0L))
        {
          ((Drawable)localObject).setColorFilter(paramColorFilter);
          ((Drawable)localObject).invalidateSelf();
        }
      }
    }
  }
  
  public static int f(QQAppInterface paramQQAppInterface, String paramString)
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
  
  private boolean r(ChatMessage paramChatMessage)
  {
    return paramChatMessage.vipBubbleID >= 1L;
  }
  
  public void M(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (this.app != null))
    {
      MqqHandler localMqqHandler = this.app.getHandler(ChatActivity.class);
      if (localMqqHandler != null)
      {
        Message localMessage = new Message();
        localMessage.what = 78;
        localMessage.arg1 = 889;
        Bundle localBundle = new Bundle();
        localBundle.putLong("messageUniseq", paramMessageRecord.uniseq);
        localMessage.setData(localBundle);
        localMqqHandler.sendMessage(localMessage);
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    paramChatMessage = b(paramChatMessage, parame, paramView, paramBaseChatItemLayout, paramwlz);
    wla.a(this.app).a(parame.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this);
    if (AppSetting.enableTalkBack) {
      parame.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setOnClickListener(this);
    }
    parame.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    return paramChatMessage;
  }
  
  public BaseBubbleBuilder.d a(View paramView)
  {
    if (wja.a(paramView) != null) {
      return this;
    }
    return null;
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new xkx.a();
  }
  
  @TargetApi(11)
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForPtt))) {}
    label173:
    label1455:
    label2096:
    label2099:
    for (;;)
    {
      return;
      MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
      Object localObject;
      if (2131366733 == paramInt)
      {
        paramInt = QQRecorder.n(localMessageForPtt);
        if (paramInt > 0)
        {
          avkr localavkr = new avkr(this.mContext, this.app, localMessageForPtt.voiceType, new xky(this, localMessageForPtt));
          if (localMessageForPtt.isSend())
          {
            paramChatMessage = localMessageForPtt.selfuin;
            paramContext = null;
            if (jof.a(localMessageForPtt)) {
              paramContext = this.mContext.getResources().getDrawable(2130844459);
            }
            localObject = this.jdField_d_of_type_Aqdf.b(1, paramChatMessage);
            paramChatMessage = (ChatMessage)localObject;
            if (localObject == null) {
              paramChatMessage = this.jdField_d_of_type_Aqdf.b(1, localMessageForPtt.frienduin);
            }
            if (!localavkr.a(localMessageForPtt.getLocalFilePath(), paramInt, paramChatMessage, paramContext)) {
              break label173;
            }
            localavkr.show();
          }
          for (;;)
          {
            aomq.VV(1);
            return;
            paramChatMessage = localMessageForPtt.senderuin;
            break;
            avjj.z(this.mContext, 2131693409, 1);
          }
        }
      }
      else
      {
        if (paramInt == 2131365686)
        {
          if (d(localMessageForPtt)) {
            MediaPlayerManager.a(this.app).stop(false);
          }
          ujt.b(this.mContext, this.app, paramChatMessage);
          aomq.VV(2);
          return;
        }
        if (paramInt == 2131372073)
        {
          aomq.VV(6);
          super.m(paramChatMessage);
          return;
        }
        if (paramInt == 2131365509)
        {
          if (TextUtils.isEmpty(localMessageForPtt.sttText))
          {
            paramContext = this.mContext.getString(2131720496);
            aomq.VV(3);
          }
          for (;;)
          {
            try
            {
              if (Build.VERSION.SDK_INT >= 11) {
                break label355;
              }
              ((android.text.ClipboardManager)this.mContext.getSystemService("clipboard")).setText(paramContext);
              anot.a(this.app, "CliOper", "", "", "0X8007359", "0X8007359", 0, 0, "", "", "", "");
              return;
            }
            catch (Exception paramContext)
            {
              return;
            }
            paramContext = localMessageForPtt.sttText;
            break;
            label355:
            paramChatMessage = (android.content.ClipboardManager)this.mContext.getSystemService("clipboard");
            paramContext = ClipData.newPlainText("msg", paramContext);
            alkw.a(paramChatMessage, paramContext);
            paramChatMessage.setPrimaryClip(paramContext);
          }
        }
        if (paramInt == 2131367523)
        {
          aomq.VV(4);
          if ((localMessageForPtt.sttText != null) && (localMessageForPtt.sttText.length() > 0))
          {
            paramContext = new Bundle();
            paramContext.putInt("forward_type", -1);
            paramContext.putString("forward_text", localMessageForPtt.sttText);
            paramContext.putInt("selection_mode", this.bOY);
            paramChatMessage = new Intent();
            paramChatMessage.putExtras(paramContext);
            ahgq.f((Activity)this.mContext, paramChatMessage, 21);
            anot.a(this.app, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
            return;
          }
          QQToast.a(this.mContext, acfp.m(2131710188), 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
          return;
        }
        int i;
        if (paramInt == 2131378857)
        {
          paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Wki.b(localMessageForPtt) + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.getHeaderViewsCount();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.delmsg", 2, "autochange pos is:" + paramInt);
          }
          if (paramInt >= 0)
          {
            i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.getFirstVisiblePosition();
            paramContext = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.getChildAt(paramInt - i);
            if (paramContext != null)
            {
              anot.a(this.app, "CliOper", "", "", "0X8005B40", "0X8005B40", 0, 0, "", "", "", "");
              anot.a(null, "dc00898", "", "", "0X8009DF7", "0X8009DF7", 0, 0, "", "", "", "");
              paramContext = (xkx.a)paramContext.getTag();
              aomq.VV(5);
              if ((localMessageForPtt.sttAbility == 1) || (localMessageForPtt.sttAbility == 3))
              {
                if ((localMessageForPtt.sttAbility == 3) && (!localMessageForPtt.expandStt)) {
                  localMessageForPtt.expandStt = true;
                }
                this.hM.put(Long.valueOf(paramChatMessage.uniseq), acfp.m(2131710186));
                a(localMessageForPtt, 1);
                this.jdField_a_of_type_Anvo.a(this);
                a(paramContext, localMessageForPtt, a(this.app, localMessageForPtt), d(localMessageForPtt));
                return;
              }
              if ((localMessageForPtt.sttAbility == 2) && (!localMessageForPtt.expandStt))
              {
                localMessageForPtt.expandStt = true;
                localMessageForPtt.serial();
                this.app.b().c(this.sessionInfo.aTl, this.sessionInfo.cZ, localMessageForPtt.uniseq, localMessageForPtt.msgData);
                a(paramContext, localMessageForPtt, a(this.app, localMessageForPtt), d(localMessageForPtt));
                a(paramContext, paramContext.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, localMessageForPtt, paramContext.jdField_b_of_type_Adxp);
              }
            }
          }
        }
        else
        {
          if (paramInt == 2131372030)
          {
            if (d(localMessageForPtt)) {
              MediaPlayerManager.a(this.app).stop(true);
            }
            super.j(paramChatMessage);
            return;
          }
          boolean bool1;
          label1090:
          label1137:
          boolean bool2;
          float f;
          if (paramInt == 2131373390)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.du) {}
            for (paramInt = 9;; paramInt = 10)
            {
              aomq.VV(paramInt);
              if (!localMessageForPtt.isReady()) {
                break;
              }
              if (!this.app.bF()) {
                break label1048;
              }
              QQToast.a(this.mContext, 1, 2131697385, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
              return;
            }
            paramContext = this.app;
            if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.du)
            {
              bool1 = true;
              paramContext.setLoudSpeakerState(bool1);
              paramContext = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.du) {
                break label1455;
              }
              bool1 = true;
              paramContext.du = bool1;
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo != null))
              {
                paramContext = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.du) {
                  break label1461;
                }
                bool1 = true;
                paramContext.bN(bool1, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.cZ);
              }
              bool1 = ija.Y(BaseApplicationImpl.getContext());
              bool2 = AudioHelper.bL(BaseApplicationImpl.getContext());
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.du, bool1, bool2);
              if (d(localMessageForPtt)) {
                MediaPlayerManager.a(this.app).stop(false);
              }
              paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Wki.b(localMessageForPtt) + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.getHeaderViewsCount();
              i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.getFirstVisiblePosition();
              if (paramInt < 0) {
                break label2096;
              }
              paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.getChildAt(paramInt - i);
              localObject = (xkx.a)wja.a(paramChatMessage);
              if ((paramChatMessage == null) || (localObject == null)) {
                break label2096;
              }
              paramContext = (MessageForPtt)((xkx.a)localObject).mMessage;
              MediaPlayerManager.a(this.app).Cl(((xkx.a)localObject).pos);
              ((xkx.a)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
              ((xkx.a)localObject).jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
              ((xkx.a)localObject).zu(true);
              paramChatMessage = (PttAudioWaveView)paramChatMessage.findViewById(2131374801);
              if ((paramChatMessage == null) || (paramContext == null)) {
                break label2096;
              }
              f = paramContext.playProgress;
              if (QLog.isColorLevel()) {
                QLog.d("PttItemBuilder", 2, "onMenuItemClicked, progress = " + f);
              }
              if (f != 1.0F) {
                break label1467;
              }
              paramChatMessage.setProgress(0.0F);
              paramInt = 0;
            }
          }
          for (;;)
          {
            if (MediaPlayerManager.a(this.app).a(localMessageForPtt, paramInt)) {
              break label2099;
            }
            QQToast.a(this.mContext, 1, 2131697384, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
            return;
            bool1 = false;
            break label1066;
            bool1 = false;
            break label1090;
            label1461:
            bool1 = false;
            break label1137;
            label1467:
            paramInt = (int)(paramContext.voiceLength * 1000.0F * f);
            continue;
            if ((paramInt == 2131378644) || (paramInt == 2131378645) || (paramInt == 2131378642))
            {
              f = MediaPlayerManager.pC;
              paramContext = "0X8009DE4";
              if (paramInt == 2131378645)
              {
                f = MediaPlayerManager.pD;
                paramContext = "0X8009E7D";
              }
            }
            for (;;)
            {
              if (!localMessageForPtt.isReady()) {
                break label2094;
              }
              if (this.app.bF())
              {
                QQToast.a(this.mContext, 1, 2131697385, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
                return;
                if (paramInt == 2131378642)
                {
                  f = MediaPlayerManager.pE;
                  paramContext = "0X8009DE3";
                }
              }
              else
              {
                bool1 = ija.Y(BaseApplicationImpl.getContext());
                bool2 = AudioHelper.bL(BaseApplicationImpl.getContext());
                paramChatMessage = aqjf.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.du, bool1, bool2, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.playMode, f);
                if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.playMode == 0) {
                  this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.playMode = aqjf.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.du, bool1, bool2);
                }
                if (!TextUtils.isEmpty(paramChatMessage)) {
                  QQToast.a(this.mContext, paramChatMessage, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
                }
                if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.getCurType() == 0)
                {
                  paramInt = 1;
                  anot.a(null, "dc00898", "", "", paramContext, paramContext, paramInt, 0, "", "", "", "");
                  if (d(localMessageForPtt)) {
                    MediaPlayerManager.a(this.app).stop(false);
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("PttItemBuilder", 2, "getMenuItem oriSpeed:" + localMessageForPtt.playSpeedPos + ", newSpeed:" + f);
                  }
                  paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Wki.b(localMessageForPtt) + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.getHeaderViewsCount();
                  i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.getFirstVisiblePosition();
                  if (paramInt < 0) {
                    break label2088;
                  }
                  paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.getChildAt(paramInt - i);
                  localObject = (xkx.a)wja.a(paramChatMessage);
                  if ((paramChatMessage == null) || (localObject == null)) {
                    break label2088;
                  }
                  paramContext = (MessageForPtt)((xkx.a)localObject).mMessage;
                  MediaPlayerManager.a(this.app).Cl(((xkx.a)localObject).pos);
                  if (paramContext != null) {
                    paramContext.playSpeedPos = f;
                  }
                  ((xkx.a)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
                  ((xkx.a)localObject).jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
                  ((xkx.a)localObject).zu(true);
                  paramChatMessage = (PttAudioWaveView)paramChatMessage.findViewById(2131374801);
                  if ((paramChatMessage == null) || (paramContext == null)) {
                    break label2088;
                  }
                  f = paramContext.playProgress;
                  if (QLog.isColorLevel()) {
                    QLog.d("PttItemBuilder", 2, "onMenuItemClicked, progress = " + f);
                  }
                  if (f != 1.0F) {
                    break label2063;
                  }
                  paramChatMessage.setProgress(0.0F);
                  paramInt = 0;
                }
                for (;;)
                {
                  if (MediaPlayerManager.a(this.app).a(localMessageForPtt, paramInt)) {
                    break label2091;
                  }
                  QQToast.a(this.mContext, 1, 2131697384, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
                  return;
                  paramInt = 2;
                  break;
                  paramInt = (int)(paramContext.voiceLength * 1000.0F * f);
                  continue;
                  super.a(paramInt, paramContext, paramChatMessage);
                  return;
                  paramInt = 0;
                }
                break;
              }
            }
            break;
            paramInt = 0;
          }
        }
      }
    }
  }
  
  public void a(View paramView, aoko paramaoko, int paramInt1, int paramInt2)
  {
    if ((paramaoko.fileType != 2) || (paramInt1 == 2002) || (paramInt1 == 1002) || (paramInt1 == 2001)) {}
    MessageForPtt localMessageForPtt;
    do
    {
      do
      {
        return;
      } while (!(wja.a(paramView) instanceof MessageForPtt));
      localMessageForPtt = (MessageForPtt)wja.a(paramView);
    } while ((localMessageForPtt == null) || (localMessageForPtt.uniseq != paramaoko.uniseq));
    paramView = (xkx.a)wja.a(paramView);
    if ((paramInt1 == 1003) || (paramInt1 == 2003))
    {
      paramInt2 = paramInt1;
      if (!paramaoko.cMw)
      {
        paramInt2 = paramInt1;
        if (paramInt1 == 2003)
        {
          notifyDataSetChanged();
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
      if ((paramaoko.status == 1005) || (paramaoko.status == 1004))
      {
        this.adapter.notifyDataSetChanged();
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
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    Object localObject = (MessageForPtt)paramChatMessage;
    if (paramInt == 889) {
      paramInt = 1;
    }
    for (;;)
    {
      if ((paramInt != 0) && (paramView != null))
      {
        localObject = (BaseBubbleBuilder.e)paramView.getTag();
        paramView = (BaseChatItemLayout)paramView;
        b(paramChatMessage, (BaseBubbleBuilder.e)localObject, ((BaseBubbleBuilder.e)localObject).E, paramView, null);
      }
      return;
      super.a(paramView, paramChatMessage, paramInt);
      if (((MessageForPtt)localObject).voiceChangeFlag != 0) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
    }
  }
  
  public void a(BaseBubbleBuilder.e parame, View paramView, ChatMessage paramChatMessage, adxp paramadxp)
  {
    xkx.a locala = (xkx.a)parame;
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    boolean bool = b(this.app, this.mContext, this.adapter, locala, localMessageForPtt);
    if ((paramadxp.bubbleId == 0) || (!paramadxp.isLoaded()))
    {
      parame = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        parame = parame.getColorStateList(2131167326);
        if ((locala.ET != null) && (parame != null)) {
          locala.ET.setTextColor(parame);
        }
        if ((locala.Jp != null) && (parame != null))
        {
          locala.Jp.setTextColor(parame);
          if (this.jdField_a_of_type_Anvo.l(localMessageForPtt)) {
            locala.Jp.setTextColor(PttAudioWaveView.c(parame.getDefaultColor(), 0.5F));
          }
          if ((locala.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView != null) && (locala.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.getVisibility() == 0))
          {
            locala.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setThemeColor(parame.getDefaultColor());
            locala.Jp.setTextColor(PttAudioWaveView.c(parame.getDefaultColor(), 0.5F));
          }
        }
        if (!bool)
        {
          if (paramChatMessage.isSend()) {
            break label227;
          }
          a(Color.parseColor("#424448"), locala);
        }
      }
    }
    label227:
    label633:
    for (;;)
    {
      return;
      parame = parame.getColorStateList(2131167322);
      break;
      if (parame != null)
      {
        a(parame.getDefaultColor(), locala);
        return;
        if (paramadxp.mTextColor == 0)
        {
          locala.ET.setTextColor(-16777216);
          if (locala.Jp != null)
          {
            locala.Jp.setTextColor(-16777216);
            if (this.jdField_a_of_type_Anvo.l(localMessageForPtt)) {
              locala.Jp.setTextColor(PttAudioWaveView.c(-16777216, 0.5F));
            }
            if ((locala.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView != null) && (locala.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.getVisibility() == 0))
            {
              locala.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setThemeColor(-16777216);
              locala.Jp.setTextColor(PttAudioWaveView.c(-16777216, 0.5F));
            }
          }
          if (!bool) {
            a(-16777216, locala);
          }
        }
        for (;;)
        {
          if ((!paramadxp.bRF) || (((ChatBackgroundManager)this.app.getManager(63)).a(this.mContext, this.sessionInfo, locala.ET.getCurrentTextColor(), locala.jdField_b_of_type_Adxp.cs * 10000.0D) != 1)) {
            break label633;
          }
          float f2 = locala.ET.getTextSize() * 3.0F / 16.0F;
          float f1 = f2;
          if (f2 > 25.0F) {
            f1 = 25.0F;
          }
          locala.ET.setTextColor(-1);
          locala.ET.setShadowLayer(f1, 0.0F, 0.0F, paramadxp.mStrokeColor);
          if (bool) {
            break;
          }
          a(-1, locala);
          return;
          locala.ET.setTextColor(paramadxp.mTextColor);
          if (locala.Jp != null)
          {
            locala.Jp.setTextColor(paramadxp.mTextColor);
            if (this.jdField_a_of_type_Anvo.l(localMessageForPtt)) {
              locala.Jp.setTextColor(PttAudioWaveView.c(paramadxp.mTextColor, 0.5F));
            }
            if ((locala.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView != null) && (locala.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.getVisibility() == 0))
            {
              locala.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setThemeColor(paramadxp.mTextColor);
              locala.Jp.setTextColor(PttAudioWaveView.c(paramadxp.mTextColor, 0.5F));
            }
          }
          if (!bool) {
            a(paramadxp.mTextColor, locala);
          }
        }
      }
    }
  }
  
  public void a(PttAudioWaveView paramPttAudioWaveView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "onStartSeek ");
    }
    paramPttAudioWaveView = (xkx.a)wja.a(paramPttAudioWaveView);
    if (paramPttAudioWaveView != null)
    {
      MediaPlayerManager localMediaPlayerManager = MediaPlayerManager.a(this.app);
      localMediaPlayerManager.a(localMediaPlayerManager.a(), paramPttAudioWaveView.mMessage);
    }
    MediaPlayerManager.a(this.app).stop(false);
  }
  
  public void a(PttAudioWaveView paramPttAudioWaveView, float paramFloat)
  {
    paramPttAudioWaveView = (xkx.a)wja.a(paramPttAudioWaveView);
    MessageForPtt localMessageForPtt;
    if (paramPttAudioWaveView != null)
    {
      localMessageForPtt = (MessageForPtt)paramPttAudioWaveView.mMessage;
      if (localMessageForPtt != null) {
        localMessageForPtt.playProgress = paramFloat;
      }
      if ((paramPttAudioWaveView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView == null) || (paramPttAudioWaveView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getPlayState())) {
        break label50;
      }
    }
    label50:
    while (localMessageForPtt == null) {
      return;
    }
    int i = (int)(localMessageForPtt.voiceLength * 1000.0F * paramFloat);
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "onSeekProgressUpdate, offset = " + i);
    }
    MediaPlayerManager.a(this.app).a(localMessageForPtt, i);
  }
  
  protected void a(MessageForPtt paramMessageForPtt, boolean paramBoolean, xkx.a parama)
  {
    this.mContext.getResources();
    if (paramMessageForPtt.isSend())
    {
      if (r(paramMessageForPtt))
      {
        paramMessageForPtt = parama.qM;
        if (paramBoolean) {}
        for (i = 2130847926;; i = 2130847929)
        {
          paramMessageForPtt.setImageResource(i);
          return;
        }
      }
      paramMessageForPtt = parama.qM;
      if (paramBoolean) {}
      for (i = 2130850981;; i = 2130850982)
      {
        paramMessageForPtt.setImageResource(i);
        return;
      }
    }
    if (r(paramMessageForPtt))
    {
      paramMessageForPtt = parama.qM;
      if (paramBoolean) {}
      for (i = 2130847920;; i = 2130847927)
      {
        paramMessageForPtt.setImageResource(i);
        return;
      }
    }
    paramMessageForPtt = parama.qM;
    if (paramBoolean) {}
    for (int i = 2130850975;; i = 2130850974)
    {
      paramMessageForPtt.setImageResource(i);
      return;
    }
  }
  
  protected void a(MessageForPtt paramMessageForPtt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, xkx.a parama)
  {
    for (;;)
    {
      try
      {
        Resources localResources = this.mContext.getResources();
        if ((paramBoolean1) && (!paramBoolean2))
        {
          if (paramMessageForPtt.isSend())
          {
            if (!r(paramMessageForPtt)) {
              break label140;
            }
            if (paramBoolean3)
            {
              i = 2130772330;
              paramMessageForPtt = (AnimationDrawable)localResources.getDrawable(i);
              parama.qM.setImageDrawable(paramMessageForPtt);
              paramMessageForPtt.start();
            }
          }
          else
          {
            if (!r(paramMessageForPtt)) {
              break label169;
            }
            if (!paramBoolean3) {
              break label161;
            }
            i = 2130772328;
            continue;
          }
        }
        else
        {
          a(paramMessageForPtt, paramBoolean3, parama);
          return;
        }
      }
      catch (Throwable paramMessageForPtt)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PttItemBuilder", 2, "when handlePttFlagOnAnim throw a exception " + paramMessageForPtt);
        }
        return;
      }
      int i = 2130772329;
      continue;
      label140:
      if (paramBoolean3)
      {
        i = 2130772159;
      }
      else
      {
        i = 2130772158;
        continue;
        label161:
        i = 2130772327;
        continue;
        label169:
        if (paramBoolean3) {
          i = 2130772433;
        } else {
          i = 2130772432;
        }
      }
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat)
  {
    if ((paramView != null) && (paramFloat > 0.0F))
    {
      paramXListView = wja.a(paramView);
      if ((paramXListView instanceof xkx.a))
      {
        paramXListView = (xkx.a)paramXListView;
        if (paramXListView.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null)
        {
          paramXListView.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(paramFloat);
          if ((paramChatMessage instanceof MessageForPtt)) {
            ((MessageForPtt)paramChatMessage).playProgress = paramFloat;
          }
        }
      }
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if (paramView != null)
    {
      paramXListView = wja.a(paramView);
      if ((paramXListView instanceof xkx.a))
      {
        paramXListView = (xkx.a)paramXListView;
        paramView = (MessageForPtt)paramChatMessage;
        a(paramXListView, paramView, a(this.app, paramView), false);
        if (paramXListView.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null)
        {
          if (paramBoolean)
          {
            paramXListView.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
            paramView.playProgress = 0.0F;
            paramXListView.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(false);
            paramXListView.zu(false);
          }
          if ((!paramXListView.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.bhq) && (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null)) {
            paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
          }
        }
      }
    }
    gt();
    if ((paramBoolean) && ((paramChatMessage instanceof MessageForPtt))) {
      ((MessageForPtt)paramChatMessage).playSpeedPos = MediaPlayerManager.pC;
    }
  }
  
  public void a(String paramString, MessageForPtt paramMessageForPtt)
  {
    this.hM.put(Long.valueOf(paramMessageForPtt.uniseq), paramString);
    this.adapter.notifyDataSetChanged();
  }
  
  protected void a(xkx.a parama, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "fileStatus is:" + paramInt + ",url is:" + paramMessageForPtt.url + ",uniseq is:" + paramMessageForPtt.uniseq + ",stt is:" + paramMessageForPtt.sttAbility + ",long is:" + paramMessageForPtt.longPttVipFlag + ", voiceLength is: " + paramMessageForPtt.voiceLength);
    }
    parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject1 = (RelativeLayout.LayoutParams)parama.hG.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, -1);
    int k = 0;
    Object localObject2 = null;
    if (parama.tj != null)
    {
      parama.tj.setVisibility(8);
      parama.tj.setOnClickListener(null);
      parama.tk.setVisibility(8);
    }
    if (parama.Jp != null)
    {
      parama.Jp.setVisibility(8);
      parama.Jp.setOnClickListener(null);
      parama.tl.setVisibility(8);
      parama.tm.setVisibility(8);
      parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(8);
      parama.Q.setVisibility(8);
    }
    parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
    parama.hG.setOnTouchListener(parama.jdField_a_of_type_Wlz);
    parama.hG.setOnLongClickListener(parama.jdField_a_of_type_Wlz);
    Object localObject5 = this.mContext.getResources();
    boolean bool3 = aagm.b(paramMessageForPtt);
    boolean bool2 = a(paramMessageForPtt, parama);
    boolean bool1;
    boolean bool4;
    int i;
    int j;
    int m;
    if (paramMessageForPtt.voiceChangeFlag != 0)
    {
      bool1 = true;
      bool4 = b(this.app, this.mContext, this.adapter, parama, paramMessageForPtt);
      i = 0;
      j = 0;
      m = wja.dp2px(15.0F, this.mContext.getResources());
      switch (paramInt)
      {
      default: 
        localObject1 = "";
        paramInt = k;
        i = j;
        label480:
        if (parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
          parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setSeekListener(this);
        }
        switch (paramInt)
        {
        default: 
          parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
          if (parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc != null) {
            parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc.setBackgroundDrawable(null);
          }
          label562:
          if (bool2)
          {
            paramMessageForPtt = (aaai)this.app.getManager(245);
            if (paramMessageForPtt == null) {
              break label3972;
            }
            paramMessageForPtt = paramMessageForPtt.a("voice_pwd", acfp.m(2131710184), new String[] { "lowTipStr" });
            label609:
            parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, paramMessageForPtt, null);
          }
          if (AppSetting.enableTalkBack)
          {
            paramMessageForPtt = acfp.m(2131710175);
            if (i == 0) {
              break label3982;
            }
            parama.hG.setContentDescription(paramMessageForPtt + (String)localObject1 + acfp.m(2131710180) + acfp.m(2131710176));
            label681:
            if (parama.E != null)
            {
              parama.E.append("发送了语音.").append((String)localObject1);
              if (localObject2 != null) {
                parama.E.append(" ").append((String)localObject2);
              }
            }
          }
          break;
        }
        break;
      }
    }
    do
    {
      return;
      bool1 = false;
      break;
      paramInt = 7;
      localObject1 = "";
      i = j;
      break label480;
      parama.ET.setText("");
      parama.ET.setPadding(wja.dp2px(10.0F, (Resources)localObject5), BaseChatItemLayout.bOa, wja.dp2px(10.0F, (Resources)localObject5), BaseChatItemLayout.bOb);
      if (parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      a(parama, bool4, bool1, paramMessageForPtt.isSend());
      paramInt = 1;
      parama.c.setAnimating(false);
      ((RelativeLayout.LayoutParams)parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = m;
      parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
      localObject1 = "";
      i = j;
      break label480;
      ((RelativeLayout.LayoutParams)parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = m;
      parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
      parama.ET.setText("");
      parama.ET.setPadding(wja.dp2px(40.0F, (Resources)localObject5), BaseChatItemLayout.bOa, wja.dp2px(40.0F, (Resources)localObject5), BaseChatItemLayout.bOb);
      if (parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      if (paramInt == 999)
      {
        parama.c.setAnimating(false);
        parama.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(8);
        localObject1 = "";
        i = j;
        paramInt = k;
        break label480;
      }
      parama.c.setAnimating(true);
      parama.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(0);
      localObject1 = "";
      i = j;
      paramInt = k;
      break label480;
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "showPttItem builder, voiceLength:" + paramMessageForPtt.voiceLength);
      }
      if (paramMessageForPtt.voiceLength <= 1) {
        paramMessageForPtt.voiceLength = QQRecorder.n(paramMessageForPtt);
      }
      if (paramMessageForPtt.voiceLength > 0) {
        break label1145;
      }
      ((RelativeLayout.LayoutParams)parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = m;
      parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
      parama.ET.setText("");
      parama.ET.setPadding(wja.dp2px(10.0F, (Resources)localObject5), BaseChatItemLayout.bOa, wja.dp2px(10.0F, (Resources)localObject5), BaseChatItemLayout.bOb);
    } while (parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView == null);
    parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
    return;
    label1145:
    label1278:
    Object localObject4;
    Object localObject6;
    if (paramMessageForPtt.voiceLength > f(this.app, "Normal_MaxPtt")) {
      if (paramMessageForPtt.longPttVipFlag == 1)
      {
        if (this.jdField_d_of_type_AndroidTextSpannableString == null)
        {
          this.jdField_d_of_type_AndroidTextSpannableString = new SpannableString("[v] QQ会员专享长语音");
          localObject1 = ((Resources)localObject5).getDrawable(2130841026);
          ((Drawable)localObject1).setBounds(0, -5, ((Drawable)localObject1).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject1).getIntrinsicHeight() * 4 / 5);
          localObject1 = new argi((Drawable)localObject1, 1).a(0.05F);
          this.jdField_d_of_type_AndroidTextSpannableString.setSpan(localObject1, 0, 3, 17);
        }
        parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.jdField_d_of_type_AndroidTextSpannableString, this);
        localObject2 = "QQ会员专享长语音";
        localObject1 = localObject2;
        if (VipUtils.ce(this.app))
        {
          localObject4 = this.app.getCurrentAccountUin();
          localObject6 = jqc.hS();
          if (!VipUtils.ce(this.app)) {
            break label3322;
          }
          localObject1 = "svip";
          label1321:
          VasWebviewUtil.reportCommercialDrainage((String)localObject4, "LongVoice", "TailView", "0", 1, 0, 0, (String)localObject6, "", (String)localObject1);
        }
      }
    }
    for (localObject1 = localObject2;; localObject1 = null)
    {
      if ((paramMessageForPtt.voiceLength > f(this.app, "ConvertText_MaxPtt")) && (paramMessageForPtt.autoToText != 2)) {
        paramMessageForPtt.sttAbility = 0;
      }
      if ((TextUtils.isEmpty(paramMessageForPtt.timeStr)) || (TextUtils.equals(paramMessageForPtt.timeStr, "0\""))) {
        paramMessageForPtt.timeStr = az(paramMessageForPtt.voiceLength);
      }
      localObject4 = paramMessageForPtt.timeStr;
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "showPttItem, msgText = " + (String)localObject4 + ", message.voiceLength" + paramMessageForPtt.voiceLength);
      }
      parama.ET.setText((CharSequence)localObject4);
      a(parama, bool4, bool1, paramMessageForPtt.isSend());
      parama.c.setAnimating(false);
      parama.hG.setOnClickListener(this);
      if (paramMessageForPtt.isSend()) {
        if (paramMessageForPtt.mRobotFlag == 1)
        {
          localObject2 = ((aptw)this.app.getManager(203)).a(this.app, paramMessageForPtt);
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
        }
        else
        {
          label1549:
          j = 1;
          if ((paramInt != 2003) && (paramInt != 1003)) {
            break label3454;
          }
          if ((paramMessageForPtt.isSend()) || (paramMessageForPtt.isReadPtt)) {
            break label4028;
          }
          parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
        }
      }
      label3586:
      label3735:
      label3754:
      label4020:
      label4028:
      for (paramInt = 1;; paramInt = 0)
      {
        if ((paramMessageForPtt.sttAbility == 2) && (paramMessageForPtt.voiceChangeFlag != 1) && (paramMessageForPtt.expandStt))
        {
          j = 2;
          k = 0;
          i = paramInt;
        }
        for (paramInt = k;; paramInt = 0)
        {
          for (;;)
          {
            m = wja.dp2px(9.0F, (Resources)localObject5);
            int i1 = wja.dp2px(12.0F, (Resources)localObject5);
            try
            {
              k = ((Resources)localObject5).getDrawable(2130845739).getIntrinsicHeight();
              int i2 = wja.dp2px(1.0F, (Resources)localObject5);
              n = wja.dp2px(1.5F, (Resources)localObject5);
              int i3 = wja.dp2px(1.5F, (Resources)localObject5);
              parama.ET.setPadding(0, BaseChatItemLayout.bOa, m, BaseChatItemLayout.bOb);
              parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setPadding(0, 0, n, 0);
              parama.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setPadding(0, 0, i3, 0);
              localObject2 = (RelativeLayout.LayoutParams)parama.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getLayoutParams();
              if (bool3)
              {
                ((RelativeLayout.LayoutParams)localObject2).width = wja.dp2px(35.0F, this.mContext.getResources());
                parama.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPadding(wja.dp2px(2.0F, (Resources)localObject5) + m, 0, 0, 0);
                if (j == 2)
                {
                  if (parama.Jp != null) {
                    break label3586;
                  }
                  localObject6 = new ImageView(this.mContext);
                  ((ImageView)localObject6).setImageDrawable(new ColorDrawable(838860800));
                  RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, i2);
                  ((ImageView)localObject6).setLayoutParams(localLayoutParams1);
                  ((ImageView)localObject6).setId(2131374818);
                  localObject7 = new TextView(this.mContext);
                  if (!paramMessageForPtt.isSend()) {
                    break label3545;
                  }
                  localObject2 = ((Resources)localObject5).getColorStateList(2131167326);
                  if (localObject2 != null)
                  {
                    ((TextView)localObject7).setTextColor((ColorStateList)localObject2);
                    if ((paramInt == 5) && (parama.jdField_b_of_type_Adxp != null) && (parama.jdField_b_of_type_Adxp.mTextColor != 0)) {
                      ((TextView)localObject7).setTextColor(PttAudioWaveView.c(parama.jdField_b_of_type_Adxp.mTextColor, 0.5F));
                    }
                  }
                  ((TextView)localObject7).setId(2131374817);
                  ((TextView)localObject7).setMaxWidth(BaseChatItemLayout.bNT);
                  localObject9 = new RelativeLayout.LayoutParams(-2, -2);
                  localObject2 = new RelativeLayout(this.mContext);
                  ((RelativeLayout)localObject2).setId(2131374814);
                  localProgressBar = new ProgressBar(this.mContext);
                  localProgressBar.setId(2131374815);
                  localObject8 = new RelativeLayout.LayoutParams(wja.dp2px(13.0F, this.mContext.getResources()), wja.dp2px(13.0F, this.mContext.getResources()));
                  localProgressBar.setIndeterminate(true);
                  localProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(2130839651));
                  ((RelativeLayout.LayoutParams)localObject8).topMargin = wja.dp2px(13.0F, (Resources)localObject5);
                  ((RelativeLayout.LayoutParams)localObject8).leftMargin = wja.dp2px(16.0F, (Resources)localObject5);
                  localProgressBar.setLayoutParams((ViewGroup.LayoutParams)localObject8);
                  localObject8 = new PttAudioChangeView(this.mContext, 2130838310, 6);
                  ((PttAudioChangeView)localObject8).setThemeColor(this.mContext.getResources().getColorStateList(2131167322).getDefaultColor());
                  ((PttAudioChangeView)localObject8).setId(2131374816);
                  RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(wja.dp2px(13.0F, this.mContext.getResources()), wja.dp2px(13.0F, this.mContext.getResources()));
                  localLayoutParams2.topMargin = wja.dp2px(13.0F, (Resources)localObject5);
                  localLayoutParams2.leftMargin = wja.dp2px(16.0F, (Resources)localObject5);
                  ((PttAudioChangeView)localObject8).setLayoutParams(localLayoutParams2);
                  if ((paramInt != 5) && (paramInt != 6)) {
                    break label3558;
                  }
                  ((RelativeLayout.LayoutParams)localObject9).leftMargin = wja.dp2px(25.0F, (Resources)localObject5);
                  if (paramInt == 5)
                  {
                    localProgressBar.setVisibility(0);
                    ((PttAudioChangeView)localObject8).setVisibility(8);
                  }
                  if (paramInt == 6)
                  {
                    ((PttAudioChangeView)localObject8).setVisibility(0);
                    localProgressBar.setVisibility(8);
                  }
                  ((TextView)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject9);
                  ((RelativeLayout)localObject2).addView((View)localObject8);
                  ((RelativeLayout)localObject2).addView(localProgressBar);
                  ((RelativeLayout)localObject2).addView((View)localObject7);
                  localObject9 = new ImageView(this.mContext);
                  localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                  ((ImageView)localObject9).setLayoutParams(localLayoutParams2);
                  ((ImageView)localObject9).setImageResource(2130845739);
                  ((ImageView)localObject9).setScaleType(ImageView.ScaleType.FIT_END);
                  localLayoutParams1.addRule(3, 2131374798);
                  localLayoutParams1.addRule(14);
                  localLayoutParams2.addRule(3, 2131374818);
                  localLayoutParams2.addRule(14);
                  localLayoutParams2.addRule(6, 2131374814);
                  localLayoutParams2.addRule(8, 2131374814);
                  localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
                  localLayoutParams1.addRule(3, 2131374818);
                  ((RelativeLayout)localObject2).setLayoutParams(localLayoutParams1);
                  parama.c.addView((View)localObject6);
                  parama.c.addView((View)localObject2);
                  parama.c.addView((View)localObject9);
                  parama.tl = ((ImageView)localObject6);
                  parama.Jp = ((TextView)localObject7);
                  parama.tm = ((ImageView)localObject9);
                  parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView = ((PttAudioChangeView)localObject8);
                  parama.Q = localProgressBar;
                  parama.Jp.setOnClickListener(this);
                  parama.Jp.setOnTouchListener(parama.jdField_a_of_type_Wlz);
                  parama.Jp.setOnLongClickListener(parama.jdField_a_of_type_Wlz);
                  if ((paramInt != 5) && (paramInt != 6)) {
                    break label3735;
                  }
                  parama.Jp.setTextSize(0, wja.dp2px(17.0F, this.mContext.getResources()));
                  localObject2 = (RelativeLayout.LayoutParams)parama.tl.getLayoutParams();
                  ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131374798);
                  ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131374798);
                  localObject2 = (RelativeLayout.LayoutParams)parama.Jp.getLayoutParams();
                  ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131374798);
                  ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131374798);
                  i2 = wja.dp2px(22.0F, (Resources)localObject5);
                  parama.tl.setPadding(m, 0, m, 0);
                  parama.Jp.setPadding(m, BaseChatItemLayout.bOa, m, i2 + k);
                  parama.tm.setPadding(0, 0, 0, i1);
                  localObject5 = paramMessageForPtt.sttText;
                  if (paramInt != 5) {
                    break label3754;
                  }
                  localObject2 = (String)this.hM.get(Long.valueOf(paramMessageForPtt.uniseq));
                  parama.Jp.setText((CharSequence)localObject2);
                }
                float f = 0.0F;
                if (j == 2)
                {
                  localObject5 = paramMessageForPtt.sttText;
                  localObject2 = localObject5;
                  if (TextUtils.isEmpty((CharSequence)localObject5)) {
                    localObject2 = this.mContext.getString(2131720496);
                  }
                  if (this.Jo == null) {
                    this.Jo = new TextView(this.mContext);
                  }
                  this.Jo.setTextSize(0, this.sessionInfo.cN);
                  f = this.Jo.getPaint().measureText((String)localObject2);
                }
                k = m + 44 + (int)wja.a((int)parama.ET.getPaint().measureText((String)localObject4), this.mContext.getResources());
                j = k;
                if (bool1) {
                  j = k + 16;
                }
                k = j;
                if (bool3) {
                  k = j + 38;
                }
                j = a(this.mContext, paramMessageForPtt.voiceLength, f, k, n, bool1, bool3);
                localObject6 = (RelativeLayout.LayoutParams)parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
                ((RelativeLayout.LayoutParams)localObject6).width = j;
                localObject2 = VoicePrintUtils.a(this.app, bool4, bool1, j + m, parama);
                localObject5 = (RelativeLayout.LayoutParams)parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams();
                ((RelativeLayout.LayoutParams)localObject5).width = (localObject2[0] + localObject2[1] + localObject2[2]);
                ((RelativeLayout.LayoutParams)localObject5).height = VoicePrintUtils.a(this.app, bool4, parama);
                if (QLog.isColorLevel()) {
                  QLog.d("PttItemBuilder", 2, "message seq=" + paramMessageForPtt.uniseq + ", VpLp.width=" + ((RelativeLayout.LayoutParams)localObject5).width + ", flagTimeContainer.getLeft()=" + parama.hG.getLeft());
                }
                if ((!bool4) || (((RelativeLayout.LayoutParams)localObject5).height <= 0)) {
                  break label3798;
                }
                parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(8);
                parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(0);
                Object localObject7 = parama.jdField_b_of_type_Adxp.a(this.app, 7);
                if ((((adxp.a)((Pair)localObject7).first).ez != null) && (((adxp.a)((Pair)localObject7).first).ez.length > 0))
                {
                  localObject6 = parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView;
                  localObject7 = (adxp.a)((Pair)localObject7).first;
                  j = localObject2[0];
                  k = ((RelativeLayout.LayoutParams)localObject5).height;
                  m = localObject2[1];
                  n = localObject2[2];
                  if (paramMessageForPtt.isSend()) {
                    break label3781;
                  }
                  bool1 = true;
                  ((VoicePrintUtils.VoicePrintView)localObject6).setBitmap((adxp.a)localObject7, j, k, m, n, bool1);
                  if (!paramBoolean) {
                    break label3787;
                  }
                  parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.yF(false);
                }
                localObject2 = localObject1;
                localObject1 = localObject4;
                break;
                if (paramMessageForPtt.longPttVipFlag != 2) {
                  break label4033;
                }
                if (this.e == null)
                {
                  this.e = new SpannableString(acfp.m(2131710183));
                  localObject1 = ((Resources)localObject5).getDrawable(2130841025);
                  ((Drawable)localObject1).setBounds(0, -5, ((Drawable)localObject1).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject1).getIntrinsicHeight() * 4 / 5);
                  localObject1 = new argi((Drawable)localObject1, 1).a(0.05F);
                  this.e.setSpan(localObject1, 0, 3, 17);
                }
                localObject2 = acfp.m(2131710181);
                parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.e, this);
                break label1278;
                label3322:
                localObject1 = "vip";
                break label1321;
                parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject2, null);
                break label1549;
                localObject2 = ((aptw)this.app.getManager(203)).a(this.app, paramMessageForPtt);
                if (TextUtils.isEmpty((CharSequence)localObject2)) {
                  break label1549;
                }
                parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject2, null);
                break label1549;
                if (((paramMessageForPtt.sttAbility == 1) || (paramMessageForPtt.sttAbility == 3)) && (this.jdField_a_of_type_Anvo.l(paramMessageForPtt)))
                {
                  j = 2;
                  i = paramInt;
                  paramInt = 5;
                  continue;
                }
                if ((paramMessageForPtt.sttAbility != 3) || (!paramMessageForPtt.expandStt)) {
                  break label4020;
                }
                j = 2;
                i = paramInt;
                paramInt = 6;
                continue;
                label3454:
                if ((paramInt == 1005) || (paramInt == 1004))
                {
                  paramInt = 1;
                  continue;
                }
                paramInt = 4;
              }
            }
            catch (Exception localException)
            {
              int n;
              for (;;)
              {
                Object localObject9;
                ProgressBar localProgressBar;
                Object localObject8;
                k = wja.dp2px(24.0F, (Resources)localObject5);
                QLog.e("PttItemBuilder", 1, "", localException);
                continue;
                localException.width = wja.dp2px(44.0F, this.mContext.getResources());
                parama.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPadding(wja.dp2px(2.0F, (Resources)localObject5) + m, 0, m, 0);
                continue;
                label3545:
                localObject3 = ((Resources)localObject5).getColorStateList(2131167322);
                continue;
                label3558:
                ((RelativeLayout.LayoutParams)localObject9).leftMargin = wja.dp2px(0.0F, (Resources)localObject5);
                ((PttAudioChangeView)localObject8).setVisibility(8);
                localProgressBar.setVisibility(8);
                continue;
                parama.tl.setVisibility(0);
                parama.Jp.setVisibility(0);
                parama.tm.setVisibility(0);
                localObject3 = (RelativeLayout.LayoutParams)parama.Jp.getLayoutParams();
                if ((paramInt == 5) || (paramInt == 6))
                {
                  ((RelativeLayout.LayoutParams)localObject3).leftMargin = wja.dp2px(25.0F, (Resources)localObject5);
                  if (paramInt == 5)
                  {
                    parama.Q.setVisibility(0);
                    parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(8);
                  }
                  if (paramInt == 6)
                  {
                    parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(0);
                    parama.Q.setVisibility(8);
                  }
                }
                for (;;)
                {
                  parama.Jp.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                  break;
                  ((RelativeLayout.LayoutParams)localObject3).leftMargin = wja.dp2px(0.0F, (Resources)localObject5);
                  parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(8);
                  parama.Q.setVisibility(8);
                }
                parama.Jp.setTextSize(0, this.sessionInfo.cN);
                continue;
                localObject3 = localObject5;
                if (TextUtils.isEmpty((CharSequence)localObject5))
                {
                  localObject3 = this.mContext.getString(2131720496);
                  continue;
                  label3781:
                  bool1 = false;
                  continue;
                  label3787:
                  parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.yF(true);
                }
              }
              label3798:
              if (paramMessageForPtt.voiceLength > 0) {
                parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramMessageForPtt.waveformArray, ((RelativeLayout.LayoutParams)localObject6).width - wja.dp2px(n, this.mContext.getResources()), paramMessageForPtt.voiceLength);
              }
              parama.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(0);
              parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
              localObject3 = localObject1;
              localObject1 = localObject4;
            }
          }
          break;
          parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc.setBackgroundDrawable(null);
          localObject4 = parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc;
          if (paramMessageForPtt.isSendFromLocal()) {}
          for (paramMessageForPtt = acfp.m(2131710185);; paramMessageForPtt = acfp.m(2131710177))
          {
            ((ImageView)localObject4).setContentDescription(paramMessageForPtt);
            break;
          }
          parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconResource(2130839657, null);
          parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc.setBackgroundDrawable(null);
          ((Animatable)parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc.getDrawable()).start();
          break label562;
          paramMessageForPtt = acfp.m(2131710184);
          break label609;
          parama.hG.setContentDescription(paramMessageForPtt + (String)localObject1 + acfp.m(2131710189));
          break label681;
          i = paramInt;
        }
      }
      label3972:
      label3982:
      label4033:
      Object localObject3 = null;
      break label1278;
    }
  }
  
  protected void a(xkx.a parama, MessageForPtt paramMessageForPtt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      if (paramBoolean1) {
        i = 2;
      }
    }
    for (int j = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.bEi;; j = 0)
    {
      ujt.a(this.app, this.sessionInfo.aTl, paramMessageForPtt, false, i, j, paramBoolean2);
      return;
      i = 1;
      break;
      i = 5;
    }
  }
  
  protected void a(xkx.a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      Object localObject = this.mContext.getResources();
      parama.ET.setCompoundDrawablePadding(wja.dp2px(6.0F, this.mContext.getResources()));
      if (paramBoolean3)
      {
        localObject = ((Resources)localObject).getDrawable(2130847930);
        if (localObject != null)
        {
          ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
          parama.ET.setCompoundDrawables((Drawable)localObject, null, null, null);
        }
      }
      do
      {
        return;
        localObject = ((Resources)localObject).getDrawable(2130847928);
      } while (localObject == null);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
      parama.ET.setCompoundDrawables(null, null, (Drawable)localObject, null);
      return;
    }
    parama.ET.setCompoundDrawablePadding(0);
    parama.ET.setCompoundDrawables(null, null, null, null);
  }
  
  public void a(boolean paramBoolean, MessageForPtt paramMessageForPtt)
  {
    this.hM.remove(Long.valueOf(paramMessageForPtt.uniseq));
    this.adapter.notifyDataSetChanged();
  }
  
  public boolean a(BaseBubbleBuilder.e parame)
  {
    return parame instanceof xkx.a;
  }
  
  protected boolean a(MessageForPtt paramMessageForPtt, xkx.a parama)
  {
    boolean bool1 = false;
    int j = 0;
    boolean bool2 = true;
    Object localObject;
    if (aagm.b(paramMessageForPtt)) {
      if (CustomizeStrategyFactory.a().Rr())
      {
        localObject = (aaai)this.app.getManager(245);
        if (localObject != null)
        {
          i = ((aaai)localObject).a("voice_pwd", 1, new String[] { "scoreSwitch" });
          if (i != 1) {
            break label351;
          }
          String str = paramMessageForPtt.getExtInfoFromExtStr("voice_score_id");
          if (TextUtils.isEmpty(str)) {
            break label213;
          }
          localObject = new CustomizeStrategyFactory.RedPacketInfo();
          ((CustomizeStrategyFactory.RedPacketInfo)localObject).h = paramMessageForPtt;
          ((CustomizeStrategyFactory.RedPacketInfo)localObject).type = 6;
          ((CustomizeStrategyFactory.RedPacketInfo)localObject).templateId = str;
          paramMessageForPtt = CustomizeStrategyFactory.a().a(this.app, (CustomizeStrategyFactory.RedPacketInfo)localObject, this);
          if (QLog.isColorLevel()) {
            QLog.d("PttItemBuilder", 2, "redPacketInfo.icon = " + paramMessageForPtt.icon);
          }
          if (paramMessageForPtt.icon == null) {
            break label388;
          }
          parama.ti.setImageBitmap(paramMessageForPtt.icon);
        }
      }
    }
    label388:
    for (int i = 1;; i = 0)
    {
      bool1 = false;
      for (;;)
      {
        label188:
        paramMessageForPtt = parama.ti;
        if (i != 0)
        {
          i = j;
          label200:
          paramMessageForPtt.setVisibility(i);
        }
        label213:
        label351:
        do
        {
          for (;;)
          {
            return bool1;
            i = 1;
            break;
            try
            {
              i = Integer.parseInt(paramMessageForPtt.getExtInfoFromExtStr("voice_low_tips_tag"));
              if (i == 1)
              {
                bool1 = true;
                if (bool1) {
                  break label383;
                }
                i = ((aaai)localObject).a("voice_pwd", 5, new String[] { "lowTipsLimit" });
                int k = zyn.getInt(this.app.getAccount(), "voice_low_tips_count", 0);
                if (k >= i) {
                  break label383;
                }
                paramMessageForPtt.saveExtInfoToExtStr("voice_low_tips_tag", "1");
                ThreadManager.post(new PttItemBuilder.2(this, paramMessageForPtt), 10, null, false);
                zyn.putInt(this.app.getAccount(), "voice_low_tips_count", k + 1);
                i = 0;
                bool1 = bool2;
              }
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;)
              {
                i = 0;
                continue;
                bool1 = false;
              }
            }
          }
          CustomizeStrategyFactory.a().yw(true);
          i = 0;
          bool1 = false;
          break label188;
          i = 8;
          break label200;
        } while (parama.ti == null);
        parama.ti.setVisibility(8);
        return false;
        label383:
        i = 0;
      }
    }
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    paramXListView = (MessageForPtt)paramChatMessage;
    return (!paramXListView.isSend()) && (!paramXListView.isReadPtt) && (paramXListView.isReady());
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayerBase paramAudioPlayerBase, int paramInt2)
  {
    paramXListView = (MessageForPtt)paramChatMessage;
    alip.a(this.app).g(paramXListView);
    if (paramXListView.isReady())
    {
      paramView = wja.a(paramView);
      if ((paramView != null) && (!(paramView instanceof xkx.a))) {
        if (QLog.isColorLevel()) {
          QLog.d("PttItemBuilder", 2, "play failed not Holder " + paramXListView.getLocalFilePath());
        }
      }
      do
      {
        return false;
        paramView = (xkx.a)paramView;
      } while (paramAudioPlayerBase == null);
      paramAudioPlayerBase.ao(paramXListView.playSpeedPos);
      paramAudioPlayerBase.fT(paramXListView.time);
      if (paramAudioPlayerBase.seekPlay(paramXListView.getLocalFilePath(), paramInt2))
      {
        a(paramXListView);
        if (paramView != null)
        {
          a(paramView, paramXListView, a(this.app, paramXListView), true);
          if (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
            paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          }
          if (paramView.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
            paramView.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
          }
          paramView.zu(true);
          a(paramView.c, paramXListView, paramView.jdField_b_of_type_Adxp, 0);
        }
        aomq.i(this.app, paramXListView.istroop, paramXListView.issend);
        if (!paramXListView.isSendFromLocal())
        {
          if (paramXListView.istroop != 0) {
            break label253;
          }
          paramInt1 = 1;
        }
      }
    }
    for (;;)
    {
      paramXListView = this.app;
      if (paramChatMessage.getPttStreamFlag() == 10001) {}
      for (boolean bool = true;; bool = false)
      {
        aomq.b(paramXListView, paramInt1, bool, 1);
        return true;
        label253:
        if (paramXListView.istroop == 1)
        {
          paramInt1 = 3;
          break;
        }
        if (paramXListView.istroop != 3000) {
          break label361;
        }
        paramInt1 = 2;
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PttItemBuilder", 2, "play failed player return false " + paramXListView.getLocalFilePath());
      return false;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PttItemBuilder", 2, "play failed not ready " + paramXListView.getLocalFilePath());
      return false;
      label361:
      paramInt1 = 4;
    }
  }
  
  public aqob[] a(View paramView)
  {
    aqoa localaqoa = new aqoa();
    MessageForPtt localMessageForPtt = (MessageForPtt)wja.a(paramView);
    if (aegu.ag(localMessageForPtt)) {
      return localaqoa.a();
    }
    if (!localMessageForPtt.isReady())
    {
      ujt.a(localaqoa, this.mContext, this.sessionInfo.cZ);
      super.c(localaqoa, this.mContext);
      super.e(localaqoa, this.mContext);
      return localaqoa.a();
    }
    if (QQRecorder.n(localMessageForPtt) <= 0)
    {
      ujt.a(localaqoa, this.mContext, this.sessionInfo.cZ);
      super.c(localaqoa, this.mContext);
      super.e(localaqoa, this.mContext);
      return localaqoa.a();
    }
    if (d(localMessageForPtt)) {
      MediaPlayerManager.a(this.app).stop(false);
    }
    paramView = (xkx.a)wja.a(paramView);
    if (((paramView != null) && ((paramView.mMessage instanceof MessageForLightVideo))) || (wja.Rc()))
    {
      if (((localMessageForPtt.extraflag != 32768) && (a(this.app, localMessageForPtt) == 1003) && (!this.app.a().aR(localMessageForPtt))) || (apuh.a(this.app, localMessageForPtt, this.app.getCurrentAccountUin()))) {
        a(localaqoa, this.sessionInfo.cZ, localMessageForPtt);
      }
      if (xla.bhy)
      {
        boolean bool1 = MediaPlayerManager.C(localMessageForPtt.playSpeedPos, MediaPlayerManager.pC);
        boolean bool2 = MediaPlayerManager.C(localMessageForPtt.playSpeedPos, MediaPlayerManager.pD);
        boolean bool3 = MediaPlayerManager.C(localMessageForPtt.playSpeedPos, MediaPlayerManager.pE);
        if (!bool1) {
          localaqoa.Z(2131378644, this.mContext.getString(2131697000), 2130839083);
        }
        if (!bool2) {
          localaqoa.Z(2131378645, this.mContext.getString(2131696999), 2130839083);
        }
        if (!bool3) {
          localaqoa.Z(2131378642, this.mContext.getString(2131696995), 2130839083);
        }
        if (QLog.isColorLevel()) {
          QLog.d("PttItemBuilder", 2, "getMenuItem speed:" + localMessageForPtt.playSpeedPos);
        }
      }
      if (localMessageForPtt.voiceChangeFlag != 1)
      {
        if ((localMessageForPtt.sttAbility != 1) && (localMessageForPtt.sttAbility != 3)) {
          break label679;
        }
        if ((!this.jdField_a_of_type_Anvo.l(localMessageForPtt)) && ((!localMessageForPtt.isSend()) || (localMessageForPtt.fileSize > 0L)) && (!aagm.b(localMessageForPtt))) {
          localaqoa.Z(2131378857, this.mContext.getString(2131720497), 2130839076);
        }
      }
    }
    for (;;)
    {
      a(localMessageForPtt, localaqoa);
      localaqoa.UY(this.mContext.getString(2131692253));
      a(localaqoa, localMessageForPtt);
      localaqoa.Z(2131366733, this.mContext.getString(2131693407), 2130839085);
      super.a(localaqoa, this.mContext, localMessageForPtt);
      b(localMessageForPtt, localaqoa);
      super.c(localaqoa, this.mContext);
      super.e(localaqoa, this.mContext);
      return localaqoa.a();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.du))
      {
        paramView = this.mContext.getString(2131696996);
        label624:
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.du)) {
          break label672;
        }
      }
      label672:
      for (int i = 2130839083;; i = 2130839087)
      {
        localaqoa.Z(2131373390, paramView, i);
        break;
        paramView = this.mContext.getString(2131696998);
        break label624;
      }
      label679:
      if (localMessageForPtt.sttAbility == 2) {
        if (localMessageForPtt.expandStt)
        {
          localaqoa.Z(2131365509, this.mContext.getString(2131720495), 2130839079);
          localaqoa.Z(2131367523, this.mContext.getString(2131690247), 2130839086);
        }
        else if (!aagm.b(localMessageForPtt))
        {
          localaqoa.Z(2131378857, this.mContext.getString(2131720497), 2130839076);
        }
      }
    }
  }
  
  protected View b(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    paramBaseChatItemLayout = (xkx.a)parame;
    this.bp.add(paramBaseChatItemLayout);
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    parame = paramView;
    if (paramView == null)
    {
      parame = new BreathAnimationLayout(this.mContext);
      parame.setId(2131374795);
      paramView = new PttAudioPlayView(this.mContext, 12);
      paramView.setThemeColor(this.mContext.getResources().getColorStateList(2131167322).getDefaultColor());
      paramView.setId(2131374800);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject1).width = wja.dp2px(44.0F, this.mContext.getResources());
      ((RelativeLayout.LayoutParams)localObject1).height = wja.dp2px(44.0F, this.mContext.getResources());
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new PttAudioChangeView(this.mContext, 2130838311, 8);
      ((PttAudioChangeView)localObject1).setThemeColor(this.mContext.getResources().getColorStateList(2131167322).getDefaultColor());
      ((PttAudioChangeView)localObject1).setId(2131374806);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject2).width = wja.dp2px(16.0F, this.mContext.getResources());
      ((RelativeLayout.LayoutParams)localObject2).height = wja.dp2px(19.0F, this.mContext.getResources());
      ((PttAudioChangeView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = new PttAudioWaveView(this.mContext);
      ((PttAudioWaveView)localObject2).setProgressColor(this.mContext.getResources().getColorStateList(2131167322).getDefaultColor());
      ((PttAudioWaveView)localObject2).setId(2131374801);
      Object localObject3 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject3).width = wja.dp2px(10.0F, this.mContext.getResources());
      ((RelativeLayout.LayoutParams)localObject3).height = wja.dp2px(52.0F, this.mContext.getResources());
      ((PttAudioWaveView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject3 = new TextView(this.mContext);
      ((TextView)localObject3).setId(2131374802);
      ((TextView)localObject3).setTextColor(this.mContext.getResources().getColorStateList(2131167322));
      VoicePrintUtils.VoicePrintView localVoicePrintView = new VoicePrintUtils.VoicePrintView(this.mContext);
      localVoicePrintView.setId(2131374803);
      ImageView localImageView = new ImageView(this.mContext);
      localImageView.setId(2131374805);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
      ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
      localVoicePrintView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject4).width = wja.dp2px(47.0F, this.mContext.getResources());
      ((RelativeLayout.LayoutParams)localObject4).height = wja.dp2px(41.0F, this.mContext.getResources());
      localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject4 = new SyncParentPressedRelativeLayout(this.mContext);
      ((RelativeLayout)localObject4).setId(2131374798);
      ((RelativeLayout)localObject4).addView((View)localObject2);
      ((RelativeLayout)localObject4).addView(paramView);
      ((RelativeLayout)localObject4).addView((View)localObject1);
      ((RelativeLayout)localObject4).addView((View)localObject3);
      ((RelativeLayout)localObject4).addView(localVoicePrintView);
      ((RelativeLayout)localObject4).addView(localImageView);
      parame.addView((View)localObject4);
      paramBaseChatItemLayout.c = parame;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView = ((PttAudioChangeView)localObject1);
      paramBaseChatItemLayout.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)localObject2);
      paramBaseChatItemLayout.ET = ((TextView)localObject3);
      paramBaseChatItemLayout.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView = localVoicePrintView;
      paramBaseChatItemLayout.ti = localImageView;
      paramBaseChatItemLayout.hG = ((RelativeLayout)localObject4);
    }
    if (paramwlz != null) {
      paramBaseChatItemLayout.jdField_a_of_type_Wlz = paramwlz;
    }
    int i;
    boolean bool;
    if (localMessageForPtt.voiceChangeFlag != 0)
    {
      i = 1;
      bool = b(this.app, this.mContext, this.adapter, paramBaseChatItemLayout, localMessageForPtt);
      if (!bool) {
        break label1069;
      }
      paramBaseChatItemLayout.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(0);
      paramBaseChatItemLayout.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(8);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(8);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(8);
      if (!paramChatMessage.isSend()) {
        break label1356;
      }
      paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.ET.getLayoutParams();
      if (!bool) {
        break label1275;
      }
      paramView.addRule(1, 2131374803);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams()).addRule(1, 2131374805);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.ti.getLayoutParams()).addRule(1, -1);
    }
    for (;;)
    {
      int j = a(this.app, localMessageForPtt);
      i = j;
      if (j == -1)
      {
        a(paramBaseChatItemLayout, localMessageForPtt, false, true);
        i = 2001;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTTItem->getBubbleView", 2, "fileStatus = " + i + " url " + localMessageForPtt.url + " uniseq " + localMessageForPtt.uniseq);
      }
      if (((localMessageForPtt.istroop == 1) || (localMessageForPtt.istroop == 3000)) && (i == 2003) && (this.jdField_a_of_type_Anvo.m(localMessageForPtt)))
      {
        a(localMessageForPtt, 2);
        anot.a(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
      }
      a(paramBaseChatItemLayout, localMessageForPtt, i, d(localMessageForPtt));
      alip.a(this.app).f(localMessageForPtt);
      aomq.a(this.app, i, paramChatMessage);
      return parame;
      i = 0;
      break;
      label1069:
      paramBaseChatItemLayout.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(0);
      paramBaseChatItemLayout.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(0);
      paramBaseChatItemLayout.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnClickListener(this);
      if (i != 0) {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(0);
      }
      for (;;)
      {
        paramBaseChatItemLayout.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnTouchListener(paramBaseChatItemLayout.jdField_a_of_type_Wlz);
        paramBaseChatItemLayout.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnLongClickListener(paramBaseChatItemLayout.jdField_a_of_type_Wlz);
        if ((!d(paramChatMessage)) && (!paramBaseChatItemLayout.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.bhq)) {
          break label1205;
        }
        paramBaseChatItemLayout.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
        paramBaseChatItemLayout.zu(true);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
        break;
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(8);
      }
      label1205:
      if (((MessageForPtt)paramChatMessage).playProgress > 0.0F)
      {
        paramBaseChatItemLayout.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
        paramBaseChatItemLayout.zu(true);
      }
      for (;;)
      {
        paramBaseChatItemLayout.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(localMessageForPtt.playProgress);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
        break;
        paramBaseChatItemLayout.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(false);
        paramBaseChatItemLayout.zu(false);
      }
      label1275:
      paramView.addRule(1, 2131374801);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).addRule(1, 2131374806);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.getLayoutParams()).addRule(1, 2131374805);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.ti.getLayoutParams()).addRule(1, 2131374800);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getLayoutParams()).addRule(1, -1);
      continue;
      label1356:
      if (bool)
      {
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.ti.getLayoutParams()).addRule(1, 2131374802);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.ET.getLayoutParams()).addRule(1, 2131374803);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams()).addRule(1, -1);
      }
      else
      {
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.ET.getLayoutParams()).addRule(1, 2131374801);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).addRule(1, 2131374806);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.getLayoutParams()).addRule(1, 2131374805);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.ti.getLayoutParams()).addRule(1, 2131374800);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getLayoutParams()).addRule(1, -1);
      }
    }
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    if (aqiu.ms(paramChatMessage.issend)) {
      return acfp.m(2131710178);
    }
    return acfp.m(2131710179);
  }
  
  protected boolean b(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, BaseBubbleBuilder.e parame, MessageForPtt paramMessageForPtt)
  {
    return VoicePrintUtils.a(paramQQAppInterface, this.mContext, paramBaseAdapter, parame, paramMessageForPtt);
  }
  
  public void bYO()
  {
    aomq.VV(7);
    super.bYO();
  }
  
  protected boolean d(ChatMessage paramChatMessage)
  {
    ChatMessage localChatMessage = MediaPlayerManager.a(this.app).a();
    return (localChatMessage == paramChatMessage) || (((localChatMessage instanceof MessageForPtt)) && (localChatMessage.frienduin != null) && (localChatMessage.frienduin.equals(paramChatMessage.frienduin)) && (localChatMessage.uniseq == paramChatMessage.uniseq));
  }
  
  public void destroy()
  {
    this.jdField_a_of_type_Anvo.a(null);
    Iterator localIterator = this.bp.iterator();
    while (localIterator.hasNext()) {
      ((xkx.a)localIterator.next()).destory();
    }
    this.bp.clear();
    this.bp = null;
    this.hM.clear();
  }
  
  public void e(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        return;
        paramView = (xkx.a)((View)paramView.getParent().getParent()).getTag();
      } while (paramView == null);
      paramView = paramView.c.getBackground();
    } while (paramView == null);
    paramView.setColorFilter(null);
    paramView.invalidateSelf();
  }
  
  public boolean e(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public void ei(View paramView)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)wja.a(paramView);
    paramView = (xkx.a)wja.a(paramView);
    if (localMessageForPtt.isSendFromLocal())
    {
      paramView = ausj.b(this.mContext);
      paramView.setMainTitle(2131690231);
      paramView.addButton(2131690230);
      paramView.addCancelButton(2131721058);
      paramView.a(new xkz(this, localMessageForPtt, paramView));
      paramView.show();
      return;
    }
    if ((!Environment.getExternalStorageState().equals("mounted")) || (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() < 1))
    {
      if (!Environment.getExternalStorageState().equals("mounted"))
      {
        QQToast.a(BaseApplication.getContext(), 2131696376, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
        return;
      }
      QQToast.a(BaseApplication.getContext(), 2131719247, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
      return;
    }
    a(paramView, localMessageForPtt, true, false);
    if (QLog.isColorLevel()) {
      QLog.d("PTTItem->onErrorIconClick", 2, "fileStatus:2001|url " + localMessageForPtt.url + "|uniseq " + localMessageForPtt.uniseq);
    }
    a(paramView, localMessageForPtt, 2001, false);
  }
  
  public void onClick(View paramView)
  {
    wja.bcO = true;
    int i = paramView.getId();
    if ((AppSetting.enableTalkBack) && (i == 2131363321)) {
      paramView.findViewById(2131374798).performClick();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = (xkx.a)wja.a(paramView);
      Object localObject2 = (MessageForPtt)((xkx.a)localObject1).mMessage;
      if ((i == 2131374798) || (i == 2131374801))
      {
        if (localObject2 != null)
        {
          if (d((ChatMessage)localObject2))
          {
            MediaPlayerManager.a(this.app).stop(false);
            anot.a(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 2, 0, "", "", "", "");
          }
          for (;;)
          {
            if (((MessageForPtt)localObject2).istroop == 1008) {
              kbp.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005857", "0X8005857", 0, 0, "", "", ((MessageForPtt)localObject2).timeStr, "", false);
            }
            if (((MessageForPtt)localObject2).voiceChangeFlag != 1) {
              break;
            }
            anot.a(this.app, "CliOper", "", "", "changevoice", "0X8006F7E", 0, 0, "" + ((MessageForPtt)localObject2).istroop, "", "", "");
            break;
            if ((localObject2 != MediaPlayerManager.a(this.app).a()) && (((MessageForPtt)localObject2).isReady())) {
              a((xkx.a)localObject1, (MessageForPtt)localObject2, paramView);
            }
          }
        }
      }
      else if (i == 2131374817)
      {
        if ((localObject2 != null) && (((MessageForPtt)localObject2).expandStt))
        {
          ((MessageForPtt)localObject2).expandStt = false;
          ((MessageForPtt)localObject2).serial();
          this.app.b().c(this.sessionInfo.aTl, this.sessionInfo.cZ, ((MessageForPtt)localObject2).uniseq, ((MessageForPtt)localObject2).msgData);
          a((xkx.a)localObject1, (MessageForPtt)localObject2, a(this.app, (MessageForPtt)localObject2), d((ChatMessage)localObject2));
          anot.a(null, "dc00898", "", "", "0X8009DF8", "0X8009DF8", 0, 0, "", "", "", "");
          anot.a(this.app, "CliOper", "", "", "0X8003F37", "0X8003F37", 0, 0, "", "", "", "");
        }
      }
      else if (i == 2131364532)
      {
        if (this.mContext != null)
        {
          localObject2 = this.app.getCurrentAccountUin();
          String str = jqc.hS();
          if (VipUtils.ce(this.app)) {}
          for (localObject1 = "svip";; localObject1 = "vip")
          {
            VasWebviewUtil.reportCommercialDrainage((String)localObject2, "LongVoice", "TailClick", "0", 1, 0, 0, str, "", (String)localObject1);
            localObject1 = new Intent(this.mContext, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("uin", this.app.getCurrentAccountUin());
            ((Intent)localObject1).putExtra("url", "https://m.vip.qq.com/freedom/xhycyy.html?_nav_alpha=0");
            this.mContext.startActivity((Intent)localObject1);
            break;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("PttItemBuilder", 2, "chat_item_tail_message onclick nullpoint");
        }
      }
      else
      {
        super.onClick(paramView);
      }
    }
  }
  
  public void onSucc(int paramInt, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null) {
      switch (paramInt)
      {
      }
    }
    do
    {
      return;
    } while (paramRedPacketInfo.icon == null);
    M(paramRedPacketInfo.h);
  }
  
  public void p(ChatMessage paramChatMessage)
  {
    anot.a(this.app, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "1", "", "", "");
  }
  
  public void v(View paramView, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        View localView;
        Object localObject;
        if ((paramView instanceof PttAudioWaveView))
        {
          localView = (View)paramView.getParent().getParent().getParent();
          localObject = (xkx.a)localView.getTag();
          if (localObject == null) {
            break label196;
          }
          localObject = ((xkx.a)localObject).jdField_b_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView;
          paramView = wja.a((View)paramView.getParent().getParent().getParent());
          if ((paramView == null) || (!(paramView instanceof MessageForPtt))) {
            break label196;
          }
          if (paramBoolean)
          {
            if (((MessageForPtt)paramView).playProgress <= 0.0F) {
              break label196;
            }
            ((PttAudioWaveView)localObject).setCanSupportSlide(true);
            break label196;
            b(localView, paramView);
          }
        }
        else
        {
          localView = (View)paramView.getParent().getParent();
          continue;
        }
        if (!d(paramView)) {
          break label196;
        }
        ((PttAudioWaveView)localObject).setCanSupportSlide(false);
      }
      catch (Exception paramView)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      QLog.d("PttItemBuilder", 2, "longClicked:" + paramView.toString());
      return;
      label196:
      while (!paramBoolean)
      {
        paramView = jdField_d_of_type_AndroidGraphicsColorFilter;
        break;
      }
      paramView = null;
    }
  }
  
  public static class a
    extends BaseBubbleBuilder.e
  {
    public StringBuilder E;
    public TextView ET;
    public TextView Jp;
    public ProgressBar Q;
    public PttAudioChangeView a;
    public PttAudioPlayView a;
    public wlz a;
    public VoicePrintUtils.VoicePrintView b;
    public PttAudioChangeView b;
    public PttAudioWaveView b;
    private boolean bhv;
    public BreathAnimationLayout c;
    public RelativeLayout hG;
    public ImageView qM;
    public ImageView ti;
    public ImageView tj;
    public ImageView tk;
    public ImageView tl;
    public ImageView tm;
    
    public boolean SB()
    {
      return this.bhv;
    }
    
    public void destory()
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.destory();
      }
      if (this.b != null) {
        this.b.destory();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.destory();
      }
    }
    
    public void zu(boolean paramBoolean)
    {
      this.bhv = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xkx
 * JD-Core Version:    0.7.0.1
 */