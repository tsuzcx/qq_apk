import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.msg.activities.DevicePttItemBuilder.3;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils.VoicePrintView;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;

public class szq
  extends xkx
  implements szd.b
{
  public szq(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner, paramBaseChatPie);
  }
  
  protected int a(MessageForPtt paramMessageForPtt)
  {
    int j = 1005;
    if (paramMessageForPtt == null) {
      return 0;
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
      i = j;
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
            i = j;
          }
        }
        else if (paramMessageForPtt.fileSize == -3L)
        {
          i = 1001;
        }
        else
        {
          i = 1001;
          continue;
          i = 1004;
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("DevicePttItemBuilder", 2, "handlePttItem recieve friendUin " + this.sessionInfo.aTl + " url " + paramMessageForPtt.url + " urlAtServer " + paramMessageForPtt.urlAtServer + " uniseq " + paramMessageForPtt.uniseq);
          }
          if (paramMessageForPtt != null)
          {
            if (paramMessageForPtt.url == null)
            {
              i = 2005;
            }
            else if ((paramMessageForPtt.url.startsWith(acbn.SDCARD_ROOT)) && (aqhq.fileExists(paramMessageForPtt.url)))
            {
              i = 2003;
            }
            else if ((paramMessageForPtt.url.startsWith("/data/data")) && (aqhq.fileExists(paramMessageForPtt.url)))
            {
              i = 2003;
            }
            else if (paramMessageForPtt.fileSize == -1L)
            {
              i = 2005;
            }
            else
            {
              j = 2002;
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("DevicePttItemBuilder", 2, "handlePttItem recieve status " + 2002 + "   url " + paramMessageForPtt.url + " uniseq " + paramMessageForPtt.uniseq);
                i = j;
              }
            }
          }
          else {
            i = 0;
          }
        }
      }
    }
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevicePttItemBuilder", 2, "getBubbleView fileStatus");
    }
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    xkx.a locala = (xkx.a)parame;
    if (!aqhq.fileExistsAndNotEmpty(localMessageForPtt.url)) {
      a(locala, localMessageForPtt);
    }
    paramChatMessage = b(paramChatMessage, parame, paramView, paramBaseChatItemLayout, paramwlz);
    ((szy)this.app.getBusinessHandler(49)).a().a(paramChatMessage, this);
    return paramChatMessage;
  }
  
  public void a(View paramView, szd.c paramc)
  {
    int i = 1005;
    MessageForPtt localMessageForPtt = (MessageForPtt)wja.a(paramView);
    if ((localMessageForPtt == null) || (localMessageForPtt.uniseq != paramc.mUniseq)) {
      return;
    }
    int j = paramc.mStatus;
    paramView = (xkx.a)wja.a(paramView);
    if ((j == 1003) || (j == 2003))
    {
      notifyDataSetChanged();
      i = j;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTTItem->handleMessage", 2, "fileStatus:" + i + "|url " + localMessageForPtt.url + "|uniseq " + localMessageForPtt.uniseq);
      }
      a(paramView, localMessageForPtt, i, d(localMessageForPtt));
      return;
      if ((j == 1005) || (j == 1004))
      {
        this.adapter.notifyDataSetChanged();
        i = j;
      }
      else if (localMessageForPtt.fileSize == -2L)
      {
        i = 999;
      }
      else if (localMessageForPtt.fileSize == -3L)
      {
        i = 1001;
      }
      else if (localMessageForPtt.fileSize != -1L)
      {
        if (j == 2005) {
          localMessageForPtt.fileSize = -4L;
        }
        i = j;
      }
    }
  }
  
  public void a(BaseBubbleBuilder.e parame, View paramView, ChatMessage paramChatMessage, adxp paramadxp)
  {
    xkx.a locala = (xkx.a)parame;
    if (locala == null) {}
    for (;;)
    {
      return;
      if ((paramadxp.bubbleId == 0) || (!paramadxp.isLoaded()))
      {
        parame = paramView.getResources();
        if (paramChatMessage.isSend()) {}
        for (parame = parame.getColorStateList(2131167326);; parame = parame.getColorStateList(2131167322))
        {
          if ((locala.ET != null) && (parame != null)) {
            locala.ET.setTextColor(parame);
          }
          if ((locala.Jp == null) || (parame == null)) {
            break;
          }
          locala.Jp.setTextColor(parame);
          return;
        }
      }
      if (paramadxp.mTextColor == 0)
      {
        locala.ET.setTextColor(-16777216);
        if (locala.Jp != null) {
          locala.Jp.setTextColor(-16777216);
        }
      }
      while ((paramadxp.bRF) && (((ChatBackgroundManager)this.app.getManager(63)).a(this.mContext, this.sessionInfo, locala.ET.getCurrentTextColor(), 10000.0D * locala.jdField_b_of_type_Adxp.cs) == 1))
      {
        float f2 = locala.ET.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        locala.ET.setTextColor(-1);
        locala.ET.setShadowLayer(f1, 0.0F, 0.0F, paramadxp.mStrokeColor);
        return;
        locala.ET.setTextColor(paramadxp.mTextColor);
        if (locala.Jp != null) {
          locala.Jp.setTextColor(paramadxp.mTextColor);
        }
      }
    }
  }
  
  protected void a(xkx.a parama, MessageForPtt paramMessageForPtt)
  {
    parama = BaseApplicationImpl.getApplication().getRuntime();
    if ((parama instanceof QQAppInterface))
    {
      parama = (QQAppInterface)parama;
      if (!aqiw.isNetSupport(BaseApplication.getContext()))
      {
        paramMessageForPtt.fileSize = -1L;
        paramMessageForPtt.extraflag = 32768;
        paramMessageForPtt.serial();
        parama.b().c(paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
        return;
      }
    }
    this.app.execute(new DevicePttItemBuilder.3(this, paramMessageForPtt));
  }
  
  protected void a(xkx.a parama, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    b(parama, paramMessageForPtt, paramInt, paramBoolean);
    if (paramInt == 2005)
    {
      if (TextUtils.isEmpty(paramMessageForPtt.timeStr))
      {
        paramMessageForPtt.timeStr = xkx.az(paramMessageForPtt.voiceLength);
        if (QLog.isColorLevel()) {
          QLog.d("DevicePttItemBuilder", 2, "voiceLength showPttItem voice:" + paramMessageForPtt.voiceLength);
        }
      }
      parama.ET.setText(paramMessageForPtt.timeStr);
    }
  }
  
  public aqob[] a(View paramView)
  {
    paramView = new aqoa();
    ujt.a(paramView, this.mContext, this.sessionInfo.cZ);
    super.e(paramView, this.mContext);
    return paramView.a();
  }
  
  protected View b(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    paramBaseChatItemLayout = (xkx.a)parame;
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    parame = paramView;
    if (paramView == null)
    {
      parame = new BreathAnimationLayout(this.mContext);
      paramView = new ImageView(this.mContext);
      paramView.setId(2131374797);
      TextView localTextView = new TextView(this.mContext);
      localTextView.setId(2131374802);
      localTextView.setTextColor(this.mContext.getResources().getColorStateList(2131167322));
      Object localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout(this.mContext);
      ((RelativeLayout)localObject).setId(2131374798);
      ((RelativeLayout)localObject).addView(paramView);
      ((RelativeLayout)localObject).addView(localTextView);
      parame.addView((View)localObject);
      paramBaseChatItemLayout.c = parame;
      paramBaseChatItemLayout.ET = localTextView;
      paramBaseChatItemLayout.qM = paramView;
      paramBaseChatItemLayout.hG = ((RelativeLayout)localObject);
    }
    paramBaseChatItemLayout.jdField_a_of_type_Wlz = paramwlz;
    if (paramChatMessage.isSend())
    {
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.qM.getLayoutParams()).addRule(1, 2131374802);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.ET.getLayoutParams()).addRule(1, -1);
    }
    for (;;)
    {
      int j = a(localMessageForPtt);
      int i = j;
      if (j == -1)
      {
        a(paramBaseChatItemLayout, localMessageForPtt);
        i = 2001;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTTItem->getBubbleView", 2, "fileStatus = " + i + " url " + localMessageForPtt.url + " uniseq " + localMessageForPtt.uniseq);
      }
      a(paramBaseChatItemLayout, localMessageForPtt, i, d(localMessageForPtt));
      return parame;
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.ET.getLayoutParams()).addRule(1, 2131374797);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.qM.getLayoutParams()).addRule(1, -1);
    }
  }
  
  protected void b(xkx.a parama, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevicePttItemBuilder", 2, "fileStatus is:" + paramInt + ",url is:" + paramMessageForPtt.url + ",uniseq is:" + paramMessageForPtt.uniseq + ",stt is:" + paramMessageForPtt.sttAbility + ",long is:" + paramMessageForPtt.longPttVipFlag + ", voiceLength is: " + paramMessageForPtt.voiceLength);
    }
    parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject1 = (RelativeLayout.LayoutParams)parama.hG.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, -1);
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
    }
    parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
    parama.hG.setOnTouchListener(parama.jdField_a_of_type_Wlz);
    parama.hG.setOnLongClickListener(parama.jdField_a_of_type_Wlz);
    Object localObject6 = this.mContext.getResources();
    boolean bool2 = a(paramMessageForPtt, parama);
    boolean bool1;
    boolean bool3;
    int i;
    int j;
    if (paramMessageForPtt.voiceChangeFlag != 0)
    {
      bool1 = true;
      bool3 = b(this.app, this.mContext, this.adapter, parama, paramMessageForPtt);
      i = 0;
      j = 0;
      switch (paramInt)
      {
      default: 
        localObject1 = "";
        paramInt = 0;
        i = j;
        label431:
        j = paramInt;
        if (paramMessageForPtt.sttAbility == 1)
        {
          j = paramInt;
          if (this.a.l(paramMessageForPtt)) {
            j = 4;
          }
        }
        switch (j)
        {
        case 2: 
        case 3: 
        default: 
          parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
          if (parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc != null) {
            parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc.setBackgroundDrawable(null);
          }
          label522:
          if (bool2)
          {
            paramMessageForPtt = (aaai)this.app.getManager(245);
            if (paramMessageForPtt == null) {
              break label3197;
            }
            paramMessageForPtt = paramMessageForPtt.a("voice_pwd", acfp.m(2131705009), new String[] { "lowTipStr" });
            label569:
            parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, paramMessageForPtt, null);
          }
          if (AppSetting.enableTalkBack)
          {
            paramMessageForPtt = acfp.m(2131705011);
            if (i == 0) {
              break label3207;
            }
            parama.hG.setContentDescription(paramMessageForPtt + (String)localObject1 + acfp.m(2131705013) + acfp.m(2131705012));
            label641:
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
      parama.ET.setText("");
      parama.ET.setPadding(wja.dp2px(10.0F, (Resources)localObject6), BaseChatItemLayout.bOa, wja.dp2px(10.0F, (Resources)localObject6), BaseChatItemLayout.bOb);
      if (parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      a(parama, bool3, bool1, paramMessageForPtt.isSend());
      parama.c.setAnimating(false);
      a(paramMessageForPtt, bool1, parama);
      localObject1 = "";
      paramInt = 1;
      i = j;
      break label431;
      parama.qM.setImageDrawable(null);
      parama.qM.setPadding(0, 0, 0, 0);
      parama.ET.setText("");
      parama.ET.setPadding(wja.dp2px(40.0F, (Resources)localObject6), BaseChatItemLayout.bOa, wja.dp2px(40.0F, (Resources)localObject6), BaseChatItemLayout.bOb);
      if (parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      parama.c.setAnimating(true);
      localObject1 = "";
      paramInt = 0;
      i = j;
      break label431;
      if (QLog.isColorLevel()) {
        QLog.d("DevicePttItemBuilder", 2, "voiceLength showPttItem builder" + paramMessageForPtt.voiceLength);
      }
      if (paramMessageForPtt.voiceLength <= 1) {
        paramMessageForPtt.voiceLength = QQRecorder.n(paramMessageForPtt);
      }
      if (paramMessageForPtt.voiceLength > 0) {
        break label1034;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DevicePttItemBuilder", 2, "get a amr file length = 0 return now");
      }
      parama.qM.setImageDrawable(null);
      parama.qM.setPadding(0, 0, 0, 0);
      parama.ET.setText("");
      parama.ET.setPadding(wja.dp2px(10.0F, (Resources)localObject6), BaseChatItemLayout.bOa, wja.dp2px(10.0F, (Resources)localObject6), BaseChatItemLayout.bOb);
    } while (parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView == null);
    parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
    return;
    label1034:
    label1167:
    Object localObject3;
    Object localObject5;
    if (paramMessageForPtt.voiceLength > xkx.f(this.app, "Normal_MaxPtt")) {
      if (paramMessageForPtt.longPttVipFlag == 1)
      {
        if (this.d == null)
        {
          this.d = new SpannableString("[v] QQ会员专享长语音");
          localObject1 = ((Resources)localObject6).getDrawable(2130841026);
          ((Drawable)localObject1).setBounds(0, -5, ((Drawable)localObject1).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject1).getIntrinsicHeight() * 4 / 5);
          localObject1 = new argi((Drawable)localObject1, 1).a(0.05F);
          this.d.setSpan(localObject1, 0, 3, 17);
        }
        parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.d, this);
        localObject2 = "QQ会员专享长语音";
        localObject1 = localObject2;
        if (VipUtils.ce(this.app))
        {
          localObject3 = this.app.getCurrentAccountUin();
          localObject5 = jqc.hS();
          if (!VipUtils.ce(this.app)) {
            break label2055;
          }
          localObject1 = "svip";
          label1210:
          VasWebviewUtil.reportCommercialDrainage((String)localObject3, "LongVoice", "TailView", "0", 1, 0, 0, (String)localObject5, "", (String)localObject1);
        }
      }
    }
    for (localObject1 = localObject2;; localObject1 = null)
    {
      if (paramMessageForPtt.voiceLength > f(this.app, "ConvertText_MaxPtt")) {
        paramMessageForPtt.sttAbility = 0;
      }
      if ((TextUtils.isEmpty(paramMessageForPtt.timeStr)) || (TextUtils.equals(paramMessageForPtt.timeStr, "0\""))) {
        paramMessageForPtt.timeStr = az(paramMessageForPtt.voiceLength);
      }
      localObject2 = paramMessageForPtt.timeStr;
      if (QLog.isColorLevel()) {
        QLog.d("DevicePttItemBuilder", 2, "showPttItem, msgText = " + (String)localObject2 + ", message.voiceLength" + paramMessageForPtt.voiceLength);
      }
      parama.ET.setText((CharSequence)localObject2);
      a(parama, bool3, bool1, paramMessageForPtt.isSend());
      parama.c.setAnimating(false);
      parama.hG.setOnClickListener(this);
      a(paramMessageForPtt, paramBoolean, bool3, bool1, parama);
      if (paramMessageForPtt.isSend()) {
        if (paramMessageForPtt.mRobotFlag == 1)
        {
          localObject3 = ((aptw)this.app.getManager(203)).a(this.app, paramMessageForPtt);
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {}
        }
        else
        {
          label1442:
          if ((paramInt != 2003) && (paramInt != 1003)) {
            break label2122;
          }
          if ((paramMessageForPtt.isSend()) || (paramMessageForPtt.isReadPtt)) {
            break label3256;
          }
          parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
        }
      }
      label2055:
      label2329:
      label3256:
      for (paramInt = 1;; paramInt = 0)
      {
        int k;
        if ((paramMessageForPtt.sttAbility == 2) && (paramMessageForPtt.voiceChangeFlag != 1) && (paramMessageForPtt.expandStt))
        {
          k = 0;
          j = 2;
          i = paramInt;
          paramInt = k;
        }
        for (;;)
        {
          for (;;)
          {
            k = wja.dp2px(9.0F, (Resources)localObject6);
            int n = wja.dp2px(12.0F, (Resources)localObject6);
            try
            {
              m = ((Resources)localObject6).getDrawable(2130845739).getIntrinsicHeight();
              i1 = wja.dp2px(1.0F, (Resources)localObject6);
              if (j == 1)
              {
                m = a(this.mContext, paramMessageForPtt.voiceLength, null, null, 0);
                if (paramMessageForPtt.isSend())
                {
                  parama.qM.setPadding(0, 0, k, 0);
                  localObject3 = parama.ET;
                  n = BaseChatItemLayout.bOa;
                  if (bool3)
                  {
                    j = k;
                    ((TextView)localObject3).setPadding(0, n, j, BaseChatItemLayout.bOb);
                    localObject3 = VoicePrintUtils.a(this.app, bool3, bool1, m + k, parama);
                    if (parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView == null) {
                      break label3077;
                    }
                    localObject5 = (RelativeLayout.LayoutParams)parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams();
                    ((RelativeLayout.LayoutParams)localObject5).width = (localObject3[0] + localObject3[1] + localObject3[2]);
                    ((RelativeLayout.LayoutParams)localObject5).height = VoicePrintUtils.a(this.app, bool3, parama);
                    if (QLog.isColorLevel()) {
                      QLog.d("DevicePttItemBuilder", 2, "message seq=" + paramMessageForPtt.uniseq + ", VpLp.width=" + ((RelativeLayout.LayoutParams)localObject5).width + ", flagTimeContainer.getLeft()=" + parama.hG.getLeft());
                    }
                    if ((!bool3) || (((RelativeLayout.LayoutParams)localObject5).height <= 0)) {
                      break label3069;
                    }
                    parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(0);
                    localObject7 = parama.jdField_b_of_type_Adxp.a(this.app, 7);
                    if ((((adxp.a)((Pair)localObject7).first).ez != null) && (((adxp.a)((Pair)localObject7).first).ez.length > 0))
                    {
                      localObject6 = parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView;
                      localObject7 = (adxp.a)((Pair)localObject7).first;
                      j = localObject3[0];
                      k = ((RelativeLayout.LayoutParams)localObject5).height;
                      m = localObject3[1];
                      n = localObject3[2];
                      if (paramMessageForPtt.isSend()) {
                        break label3052;
                      }
                      bool1 = true;
                      ((VoicePrintUtils.VoicePrintView)localObject6).setBitmap((adxp.a)localObject7, j, k, m, n, bool1);
                      if (!paramBoolean) {
                        break label3058;
                      }
                      parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.yF(false);
                    }
                    localObject3 = localObject1;
                    localObject1 = localObject2;
                    localObject2 = localObject3;
                    break;
                    if (paramMessageForPtt.longPttVipFlag != 2) {
                      break label3261;
                    }
                    if (this.e == null)
                    {
                      this.e = new SpannableString(acfp.m(2131705007));
                      localObject1 = ((Resources)localObject6).getDrawable(2130841025);
                      ((Drawable)localObject1).setBounds(0, -5, ((Drawable)localObject1).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject1).getIntrinsicHeight() * 4 / 5);
                      localObject1 = new argi((Drawable)localObject1, 1).a(0.05F);
                      this.e.setSpan(localObject1, 0, 3, 17);
                    }
                    localObject2 = acfp.m(2131705004);
                    parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.e, this);
                    break label1167;
                    localObject1 = "vip";
                    break label1210;
                    parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject3, null);
                    break label1442;
                    localObject3 = ((aptw)this.app.getManager(203)).a(this.app, paramMessageForPtt);
                    if (TextUtils.isEmpty((CharSequence)localObject3)) {
                      break label1442;
                    }
                    parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject3, null);
                    break label1442;
                    label2122:
                    if ((paramInt == 1005) || (paramInt == 1004))
                    {
                      paramInt = 1;
                      j = 1;
                      continue;
                    }
                    paramInt = 4;
                    j = 1;
                  }
                }
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                int i1;
                Object localObject7;
                int m = wja.dp2px(24.0F, (Resources)localObject6);
                QLog.e("DevicePttItemBuilder", 1, "", localException);
                continue;
                j = BaseChatItemLayout.contentPadding;
                continue;
                parama.qM.setPadding(k, 0, 0, 0);
                localObject4 = parama.ET;
                if (bool3) {}
                for (j = k;; j = BaseChatItemLayout.contentPadding)
                {
                  ((TextView)localObject4).setPadding(j, BaseChatItemLayout.bOa, 0, BaseChatItemLayout.bOb);
                  break;
                }
                if (parama.Jp == null)
                {
                  localObject5 = new ImageView(this.mContext);
                  ((ImageView)localObject5).setImageDrawable(new ColorDrawable(838860800));
                  localObject7 = new RelativeLayout.LayoutParams(-1, i1);
                  ((ImageView)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject7);
                  ((ImageView)localObject5).setId(2131374818);
                  TextView localTextView = new TextView(this.mContext);
                  if (paramMessageForPtt.isSend())
                  {
                    localObject4 = ((Resources)localObject6).getColorStateList(2131167326);
                    if (localObject4 != null) {
                      localTextView.setTextColor((ColorStateList)localObject4);
                    }
                    localTextView.setId(2131374817);
                    localObject4 = new RelativeLayout.LayoutParams(-2, -2);
                    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
                    ImageView localImageView = new ImageView(this.mContext);
                    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    localImageView.setLayoutParams(localLayoutParams);
                    localImageView.setImageResource(2130845739);
                    localImageView.setScaleType(ImageView.ScaleType.FIT_END);
                    ((RelativeLayout.LayoutParams)localObject7).addRule(3, 2131374798);
                    ((RelativeLayout.LayoutParams)localObject7).addRule(14);
                    ((RelativeLayout.LayoutParams)localObject4).addRule(3, 2131374818);
                    localLayoutParams.addRule(3, 2131374818);
                    localLayoutParams.addRule(14);
                    localLayoutParams.addRule(6, 2131374817);
                    localLayoutParams.addRule(8, 2131374817);
                    parama.c.addView((View)localObject5);
                    parama.c.addView(localTextView);
                    parama.c.addView(localImageView);
                    parama.tl = ((ImageView)localObject5);
                    parama.Jp = localTextView;
                    parama.tm = localImageView;
                    label2524:
                    parama.Jp.setOnClickListener(this);
                    parama.Jp.setOnTouchListener(parama.jdField_a_of_type_Wlz);
                    parama.Jp.setOnLongClickListener(parama.jdField_a_of_type_Wlz);
                    localObject5 = paramMessageForPtt.sttText;
                    localObject4 = localObject5;
                    if (TextUtils.isEmpty((CharSequence)localObject5)) {
                      localObject4 = this.mContext.getString(2131720496);
                    }
                    if (this.Jo == null) {
                      this.Jo = new TextView(this.mContext);
                    }
                    this.Jo.setTextSize(0, this.sessionInfo.cN);
                    j = a(this.mContext, paramMessageForPtt.voiceLength, (String)localObject4, this.Jo.getPaint(), 0);
                    localObject5 = VoicePrintUtils.a(this.app, bool3, bool1, j + k, parama);
                    parama.Jp.setTextSize(0, this.sessionInfo.cN);
                    j = m + wja.dp2px(22.0F, (Resources)localObject6);
                    if (!paramMessageForPtt.isSend()) {
                      break label2917;
                    }
                    localObject4 = (RelativeLayout.LayoutParams)parama.tl.getLayoutParams();
                    ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131374798);
                    ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131374798);
                    localObject4 = (RelativeLayout.LayoutParams)parama.Jp.getLayoutParams();
                    ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131374798);
                    ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131374798);
                    parama.qM.setPadding(0, 0, k, 0);
                    parama.ET.setPadding(0, BaseChatItemLayout.bOa, BaseChatItemLayout.contentPadding, BaseChatItemLayout.bOb);
                    parama.tl.setPadding(k, 0, k, 0);
                    parama.Jp.setPadding(k, BaseChatItemLayout.bOa, k, j);
                    parama.tm.setPadding(0, 0, 0, n);
                  }
                }
                for (;;)
                {
                  localObject6 = paramMessageForPtt.sttText;
                  localObject4 = localObject6;
                  if (TextUtils.isEmpty((CharSequence)localObject6)) {
                    localObject4 = this.mContext.getString(2131720496);
                  }
                  parama.Jp.setText((CharSequence)localObject4);
                  localObject4 = localObject5;
                  break;
                  localObject4 = ((Resources)localObject6).getColorStateList(2131167322);
                  break label2329;
                  parama.tl.setVisibility(0);
                  parama.Jp.setVisibility(0);
                  parama.tm.setVisibility(0);
                  break label2524;
                  label2917:
                  localObject4 = (RelativeLayout.LayoutParams)parama.tl.getLayoutParams();
                  ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131374798);
                  ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131374798);
                  localObject4 = (RelativeLayout.LayoutParams)parama.Jp.getLayoutParams();
                  ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131374798);
                  ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131374798);
                  parama.qM.setPadding(k, 0, 0, 0);
                  parama.ET.setPadding(BaseChatItemLayout.contentPadding, BaseChatItemLayout.bOa, 0, BaseChatItemLayout.bOb);
                  parama.tl.setPadding(k, 0, k, 0);
                  parama.Jp.setPadding(k, BaseChatItemLayout.bOa, k, j);
                  parama.tm.setPadding(0, 0, 0, n);
                }
                label3052:
                bool1 = false;
                continue;
                label3058:
                parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.yF(true);
              }
              label3069:
              parama.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(4);
              localObject4 = localObject1;
              localObject1 = localObject2;
              localObject2 = localObject4;
            }
          }
          break;
          parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc.setBackgroundDrawable(null);
          Object localObject4 = parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc;
          if (paramMessageForPtt.isSendFromLocal()) {}
          for (paramMessageForPtt = acfp.m(2131705008);; paramMessageForPtt = acfp.m(2131705005))
          {
            ((ImageView)localObject4).setContentDescription(paramMessageForPtt);
            break;
          }
          parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconResource(2130839657, null);
          parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc.setBackgroundDrawable(null);
          ((Animatable)parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc.getDrawable()).start();
          break label522;
          label3197:
          paramMessageForPtt = acfp.m(2131705009);
          break label569;
          parama.hG.setContentDescription(paramMessageForPtt + (String)localObject1 + acfp.m(2131705010));
          break label641;
          i = paramInt;
          paramInt = 0;
          j = 1;
        }
      }
      label3077:
      label3207:
      label3261:
      localObject2 = null;
      break label1167;
    }
  }
  
  public void ei(View paramView)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)wja.a(paramView);
    if (localMessageForPtt == null) {
      return;
    }
    paramView = (xkx.a)wja.a(paramView);
    if (localMessageForPtt.isSendFromLocal())
    {
      paramView = ausj.b(this.mContext);
      paramView.addButton(2131690230);
      paramView.addCancelButton(2131721058);
      paramView.a(new szr(this, localMessageForPtt, paramView));
      paramView.show();
      return;
    }
    ausj localausj = ausj.b(this.mContext);
    localausj.setMainTitle(2131692583);
    localausj.addButton(2131692582);
    localausj.addCancelButton(2131721058);
    localausj.a(new szs(this, paramView, localMessageForPtt, localausj));
    localausj.show();
  }
  
  public void ej(View paramView)
  {
    ChatMessage localChatMessage = wja.a(paramView);
    if (localChatMessage == null) {}
    do
    {
      do
      {
        return;
      } while (localChatMessage.istroop != 9501);
      if (localChatMessage.isSendFromLocal())
      {
        super.ej(paramView);
        return;
      }
    } while (!"device_groupchat".equals(localChatMessage.extStr));
    super.ej(paramView);
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
      if (localObject1 != null)
      {
        Object localObject2 = (MessageForPtt)((xkx.a)localObject1).mMessage;
        if (i == 2131374798)
        {
          if (d((ChatMessage)localObject2)) {
            MediaPlayerManager.a(this.app).stop(false);
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
              if (this.app.bF()) {
                QQToast.a(this.mContext, 1, 2131697385, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
              } else if (!MediaPlayerManager.a(this.app).k(wja.a(paramView))) {
                QQToast.a(this.mContext, 1, 2131697384, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
              }
            }
          }
        }
        if (i == 2131374817)
        {
          if (((MessageForPtt)localObject2).expandStt)
          {
            ((MessageForPtt)localObject2).expandStt = false;
            ((MessageForPtt)localObject2).serial();
            this.app.b().c(this.sessionInfo.aTl, this.sessionInfo.cZ, ((MessageForPtt)localObject2).uniseq, ((MessageForPtt)localObject2).msgData);
            a((xkx.a)localObject1, (MessageForPtt)localObject2, a(this.app, (MessageForPtt)localObject2), d((ChatMessage)localObject2));
            anot.a(this.app, "CliOper", "", "", "0X8003F37", "0X8003F37", 0, 0, "", "", "", "");
          }
        }
        else
        {
          if (i == 2131364532)
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
          super.onClick(paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     szq
 * JD-Core Version:    0.7.0.1
 */