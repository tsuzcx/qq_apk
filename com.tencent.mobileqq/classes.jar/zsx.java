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
import com.tencent.util.Pair;

public class zsx
  extends aftc
  implements zql
{
  public zsx(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
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
      if ((paramMessageForPtt.url != null) && (paramMessageForPtt.url.startsWith(aljq.aW))) {
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
            QLog.d("DevicePttItemBuilder", 2, "handlePttItem recieve friendUin " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + " url " + paramMessageForPtt.url + " urlAtServer " + paramMessageForPtt.urlAtServer + " uniseq " + paramMessageForPtt.uniseq);
          }
          if (paramMessageForPtt != null)
          {
            if (paramMessageForPtt.url == null)
            {
              i = 2005;
            }
            else if ((paramMessageForPtt.url.startsWith(aljq.aW)) && (bdcs.a(paramMessageForPtt.url)))
            {
              i = 2003;
            }
            else if ((paramMessageForPtt.url.startsWith("/data/data")) && (bdcs.a(paramMessageForPtt.url)))
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
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevicePttItemBuilder", 2, "getBubbleView fileStatus");
    }
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    aftf localaftf = (aftf)paramaelt;
    if (!bdcs.b(localMessageForPtt.url)) {
      a(localaftf, localMessageForPtt);
    }
    paramChatMessage = b(paramChatMessage, paramaelt, paramView, paramBaseChatItemLayout, paramaeov);
    ((ztk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramChatMessage, this);
    return paramChatMessage;
  }
  
  public void a(aelt paramaelt, View paramView, ChatMessage paramChatMessage, ansf paramansf)
  {
    aftf localaftf = (aftf)paramaelt;
    if (localaftf == null) {}
    for (;;)
    {
      return;
      if ((paramansf.jdField_a_of_type_Int == 0) || (!paramansf.a()))
      {
        paramaelt = paramView.getResources();
        if (paramChatMessage.isSend()) {}
        for (paramaelt = paramaelt.getColorStateList(2131166923);; paramaelt = paramaelt.getColorStateList(2131166919))
        {
          if ((localaftf.jdField_a_of_type_AndroidWidgetTextView != null) && (paramaelt != null)) {
            localaftf.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaelt);
          }
          if ((localaftf.b == null) || (paramaelt == null)) {
            break;
          }
          localaftf.b.setTextColor(paramaelt);
          return;
        }
      }
      if (paramansf.jdField_b_of_type_Int == 0)
      {
        localaftf.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        if (localaftf.b != null) {
          localaftf.b.setTextColor(-16777216);
        }
      }
      while ((paramansf.jdField_b_of_type_Boolean) && (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localaftf.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor(), 10000.0D * localaftf.jdField_a_of_type_Ansf.jdField_a_of_type_Double) == 1))
      {
        float f2 = localaftf.jdField_a_of_type_AndroidWidgetTextView.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        localaftf.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        localaftf.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(f1, 0.0F, 0.0F, paramansf.d);
        return;
        localaftf.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramansf.jdField_b_of_type_Int);
        if (localaftf.b != null) {
          localaftf.b.setTextColor(paramansf.jdField_b_of_type_Int);
        }
      }
    }
  }
  
  protected void a(aftf paramaftf, MessageForPtt paramMessageForPtt)
  {
    paramaftf = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramaftf instanceof QQAppInterface))
    {
      paramaftf = (QQAppInterface)paramaftf;
      if (!bdee.d(BaseApplication.getContext()))
      {
        paramMessageForPtt.fileSize = -1L;
        paramMessageForPtt.extraflag = 32768;
        paramMessageForPtt.serial();
        paramaftf.a().a(paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new DevicePttItemBuilder.3(this, paramMessageForPtt));
  }
  
  protected void a(aftf paramaftf, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    b(paramaftf, paramMessageForPtt, paramInt, paramBoolean);
    if (paramInt == 2005)
    {
      if (TextUtils.isEmpty(paramMessageForPtt.timeStr))
      {
        paramMessageForPtt.timeStr = aftc.a(paramMessageForPtt.voiceLength);
        if (QLog.isColorLevel()) {
          QLog.d("DevicePttItemBuilder", 2, "voiceLength showPttItem voice:" + paramMessageForPtt.voiceLength);
        }
      }
      paramaftf.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessageForPtt.timeStr);
    }
  }
  
  public void a(View paramView)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)aekt.a(paramView);
    if (localMessageForPtt == null) {
      return;
    }
    paramView = (aftf)aekt.a(paramView);
    if (localMessageForPtt.isSendFromLocal())
    {
      paramView = bhpy.a(this.jdField_a_of_type_AndroidContentContext);
      paramView.b(2131690042);
      paramView.c(2131690648);
      paramView.a(new zsy(this, localMessageForPtt, paramView));
      paramView.show();
      return;
    }
    bhpy localbhpy = bhpy.a(this.jdField_a_of_type_AndroidContentContext);
    localbhpy.a(2131691635);
    localbhpy.b(2131691634);
    localbhpy.c(2131690648);
    localbhpy.a(new zsz(this, paramView, localMessageForPtt, localbhpy));
    localbhpy.show();
  }
  
  public void a(View paramView, zqm paramzqm)
  {
    int i = 1005;
    MessageForPtt localMessageForPtt = (MessageForPtt)aekt.a(paramView);
    if ((localMessageForPtt == null) || (localMessageForPtt.uniseq != paramzqm.jdField_a_of_type_Long)) {
      return;
    }
    int j = paramzqm.jdField_a_of_type_Int;
    paramView = (aftf)aekt.a(paramView);
    if ((j == 1003) || (j == 2003))
    {
      b();
      i = j;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTTItem->handleMessage", 2, "fileStatus:" + i + "|url " + localMessageForPtt.url + "|uniseq " + localMessageForPtt.uniseq);
      }
      a(paramView, localMessageForPtt, i, c(localMessageForPtt));
      return;
      if ((j == 1005) || (j == 1004))
      {
        this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
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
  
  public bdlb[] a(View paramView)
  {
    paramView = new bdkz();
    acex.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
  
  protected View b(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    paramBaseChatItemLayout = (aftf)paramaelt;
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    paramaelt = paramView;
    if (paramView == null)
    {
      paramaelt = new BreathAnimationLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131373371);
      TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setId(2131373376);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166919));
      Object localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject).setId(2131373372);
      ((RelativeLayout)localObject).addView(paramView);
      ((RelativeLayout)localObject).addView(localTextView);
      paramaelt.addView((View)localObject);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = paramaelt;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = localTextView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject);
    }
    paramBaseChatItemLayout.jdField_a_of_type_Aeov = paramaeov;
    if (paramChatMessage.isSend())
    {
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131373376);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, -1);
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
      a(paramBaseChatItemLayout, localMessageForPtt, i, c(localMessageForPtt));
      return paramaelt;
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131373371);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, -1);
    }
  }
  
  protected void b(aftf paramaftf, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevicePttItemBuilder", 2, "fileStatus is:" + paramInt + ",url is:" + paramMessageForPtt.url + ",uniseq is:" + paramMessageForPtt.uniseq + ",stt is:" + paramMessageForPtt.sttAbility + ",long is:" + paramMessageForPtt.longPttVipFlag + ", voiceLength is: " + paramMessageForPtt.voiceLength);
    }
    paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject1 = (RelativeLayout.LayoutParams)paramaftf.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, -1);
    Object localObject2 = null;
    if (paramaftf.c != null)
    {
      paramaftf.c.setVisibility(8);
      paramaftf.c.setOnClickListener(null);
      paramaftf.d.setVisibility(8);
    }
    if (paramaftf.b != null)
    {
      paramaftf.b.setVisibility(8);
      paramaftf.b.setOnClickListener(null);
      paramaftf.e.setVisibility(8);
      paramaftf.f.setVisibility(8);
    }
    paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
    paramaftf.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramaftf.jdField_a_of_type_Aeov);
    paramaftf.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramaftf.jdField_a_of_type_Aeov);
    Object localObject6 = this.jdField_a_of_type_AndroidContentContext.getResources();
    boolean bool2 = a(paramMessageForPtt, paramaftf);
    boolean bool1;
    boolean bool3;
    int i;
    int j;
    if (paramMessageForPtt.voiceChangeFlag != 0)
    {
      bool1 = true;
      bool3 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramaftf, paramMessageForPtt);
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
          if (this.jdField_a_of_type_Azwa.a(paramMessageForPtt)) {
            j = 4;
          }
        }
        switch (j)
        {
        case 2: 
        case 3: 
        default: 
          paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
          if (paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null) {
            paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
          }
          label522:
          if (bool2)
          {
            paramMessageForPtt = (aitd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(245);
            if (paramMessageForPtt == null) {
              break label3197;
            }
            paramMessageForPtt = paramMessageForPtt.a("voice_pwd", alpo.a(2131703594), new String[] { "lowTipStr" });
            label569:
            paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, paramMessageForPtt, null);
          }
          if (AppSetting.c)
          {
            paramMessageForPtt = alpo.a(2131703596);
            if (i == 0) {
              break label3207;
            }
            paramaftf.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForPtt + (String)localObject1 + alpo.a(2131703598) + alpo.a(2131703597));
            label641:
            if (paramaftf.jdField_a_of_type_JavaLangStringBuilder != null)
            {
              paramaftf.jdField_a_of_type_JavaLangStringBuilder.append("发送了语音.").append((String)localObject1);
              if (localObject2 != null) {
                paramaftf.jdField_a_of_type_JavaLangStringBuilder.append(" ").append((String)localObject2);
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
      paramaftf.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramaftf.jdField_a_of_type_AndroidWidgetTextView.setPadding(aekt.a(10.0F, (Resources)localObject6), BaseChatItemLayout.l, aekt.a(10.0F, (Resources)localObject6), BaseChatItemLayout.m);
      if (paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      a(paramaftf, bool3, bool1, paramMessageForPtt.isSend());
      paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
      a(paramMessageForPtt, bool1, paramaftf);
      localObject1 = "";
      paramInt = 1;
      i = j;
      break label431;
      paramaftf.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramaftf.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      paramaftf.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramaftf.jdField_a_of_type_AndroidWidgetTextView.setPadding(aekt.a(40.0F, (Resources)localObject6), BaseChatItemLayout.l, aekt.a(40.0F, (Resources)localObject6), BaseChatItemLayout.m);
      if (paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(true);
      localObject1 = "";
      paramInt = 0;
      i = j;
      break label431;
      if (QLog.isColorLevel()) {
        QLog.d("DevicePttItemBuilder", 2, "voiceLength showPttItem builder" + paramMessageForPtt.voiceLength);
      }
      if (paramMessageForPtt.voiceLength <= 1) {
        paramMessageForPtt.voiceLength = QQRecorder.a(paramMessageForPtt);
      }
      if (paramMessageForPtt.voiceLength > 0) {
        break label1034;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DevicePttItemBuilder", 2, "get a amr file length = 0 return now");
      }
      paramaftf.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramaftf.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      paramaftf.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramaftf.jdField_a_of_type_AndroidWidgetTextView.setPadding(aekt.a(10.0F, (Resources)localObject6), BaseChatItemLayout.l, aekt.a(10.0F, (Resources)localObject6), BaseChatItemLayout.m);
    } while (paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView == null);
    paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
    return;
    label1034:
    label1167:
    Object localObject3;
    Object localObject5;
    if (paramMessageForPtt.voiceLength > aftc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt")) {
      if (paramMessageForPtt.longPttVipFlag == 1)
      {
        if (this.jdField_a_of_type_AndroidTextSpannableString == null)
        {
          this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString("[v] QQ会员专享长语音");
          localObject1 = ((Resources)localObject6).getDrawable(2130840171);
          ((Drawable)localObject1).setBounds(0, -5, ((Drawable)localObject1).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject1).getIntrinsicHeight() * 4 / 5);
          localObject1 = new bemz((Drawable)localObject1, 1).a(0.05F);
          this.jdField_a_of_type_AndroidTextSpannableString.setSpan(localObject1, 0, 3, 17);
        }
        paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.jdField_a_of_type_AndroidTextSpannableString, this);
        localObject2 = "QQ会员专享长语音";
        localObject1 = localObject2;
        if (VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          localObject5 = ndd.a();
          if (!VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
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
      if (paramMessageForPtt.voiceLength > a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "ConvertText_MaxPtt")) {
        paramMessageForPtt.sttAbility = 0;
      }
      if ((TextUtils.isEmpty(paramMessageForPtt.timeStr)) || (TextUtils.equals(paramMessageForPtt.timeStr, "0\""))) {
        paramMessageForPtt.timeStr = a(paramMessageForPtt.voiceLength);
      }
      localObject2 = paramMessageForPtt.timeStr;
      if (QLog.isColorLevel()) {
        QLog.d("DevicePttItemBuilder", 2, "showPttItem, msgText = " + (String)localObject2 + ", message.voiceLength" + paramMessageForPtt.voiceLength);
      }
      paramaftf.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      a(paramaftf, bool3, bool1, paramMessageForPtt.isSend());
      paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
      paramaftf.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      a(paramMessageForPtt, paramBoolean, bool3, bool1, paramaftf);
      if (paramMessageForPtt.isSend()) {
        if (paramMessageForPtt.mRobotFlag == 1)
        {
          localObject3 = ((bckx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
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
          paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
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
            k = aekt.a(9.0F, (Resources)localObject6);
            int n = aekt.a(12.0F, (Resources)localObject6);
            try
            {
              m = ((Resources)localObject6).getDrawable(2130844369).getIntrinsicHeight();
              i1 = aekt.a(1.0F, (Resources)localObject6);
              if (j == 1)
              {
                m = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt.voiceLength, null, null, 0);
                if (paramMessageForPtt.isSend())
                {
                  paramaftf.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, k, 0);
                  localObject3 = paramaftf.jdField_a_of_type_AndroidWidgetTextView;
                  n = BaseChatItemLayout.l;
                  if (bool3)
                  {
                    j = k;
                    ((TextView)localObject3).setPadding(0, n, j, BaseChatItemLayout.m);
                    localObject3 = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool3, bool1, m + k, paramaftf);
                    if (paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView == null) {
                      break label3077;
                    }
                    localObject5 = (RelativeLayout.LayoutParams)paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams();
                    ((RelativeLayout.LayoutParams)localObject5).width = (localObject3[0] + localObject3[1] + localObject3[2]);
                    ((RelativeLayout.LayoutParams)localObject5).height = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool3, paramaftf);
                    if (QLog.isColorLevel()) {
                      QLog.d("DevicePttItemBuilder", 2, "message seq=" + paramMessageForPtt.uniseq + ", VpLp.width=" + ((RelativeLayout.LayoutParams)localObject5).width + ", flagTimeContainer.getLeft()=" + paramaftf.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft());
                    }
                    if ((!bool3) || (((RelativeLayout.LayoutParams)localObject5).height <= 0)) {
                      break label3069;
                    }
                    paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(0);
                    localObject7 = paramaftf.jdField_a_of_type_Ansf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 7);
                    if ((((ansg)((Pair)localObject7).first).a != null) && (((ansg)((Pair)localObject7).first).a.length > 0))
                    {
                      localObject6 = paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView;
                      localObject7 = (ansg)((Pair)localObject7).first;
                      j = localObject3[0];
                      k = ((RelativeLayout.LayoutParams)localObject5).height;
                      m = localObject3[1];
                      n = localObject3[2];
                      if (paramMessageForPtt.isSend()) {
                        break label3052;
                      }
                      bool1 = true;
                      ((VoicePrintUtils.VoicePrintView)localObject6).setBitmap((ansg)localObject7, j, k, m, n, bool1);
                      if (!paramBoolean) {
                        break label3058;
                      }
                      paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.a(false);
                    }
                    localObject3 = localObject1;
                    localObject1 = localObject2;
                    localObject2 = localObject3;
                    break;
                    if (paramMessageForPtt.longPttVipFlag != 2) {
                      break label3261;
                    }
                    if (this.b == null)
                    {
                      this.b = new SpannableString(alpo.a(2131703592));
                      localObject1 = ((Resources)localObject6).getDrawable(2130840170);
                      ((Drawable)localObject1).setBounds(0, -5, ((Drawable)localObject1).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject1).getIntrinsicHeight() * 4 / 5);
                      localObject1 = new bemz((Drawable)localObject1, 1).a(0.05F);
                      this.b.setSpan(localObject1, 0, 3, 17);
                    }
                    localObject2 = alpo.a(2131703589);
                    paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.b, this);
                    break label1167;
                    localObject1 = "vip";
                    break label1210;
                    paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject3, null);
                    break label1442;
                    localObject3 = ((bckx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
                    if (TextUtils.isEmpty((CharSequence)localObject3)) {
                      break label1442;
                    }
                    paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject3, null);
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
                int m = aekt.a(24.0F, (Resources)localObject6);
                QLog.e("DevicePttItemBuilder", 1, "", localException);
                continue;
                j = BaseChatItemLayout.q;
                continue;
                paramaftf.jdField_a_of_type_AndroidWidgetImageView.setPadding(k, 0, 0, 0);
                localObject4 = paramaftf.jdField_a_of_type_AndroidWidgetTextView;
                if (bool3) {}
                for (j = k;; j = BaseChatItemLayout.q)
                {
                  ((TextView)localObject4).setPadding(j, BaseChatItemLayout.l, 0, BaseChatItemLayout.m);
                  break;
                }
                if (paramaftf.b == null)
                {
                  localObject5 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
                  ((ImageView)localObject5).setImageDrawable(new ColorDrawable(838860800));
                  localObject7 = new RelativeLayout.LayoutParams(-1, i1);
                  ((ImageView)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject7);
                  ((ImageView)localObject5).setId(2131373392);
                  TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
                  if (paramMessageForPtt.isSend())
                  {
                    localObject4 = ((Resources)localObject6).getColorStateList(2131166923);
                    if (localObject4 != null) {
                      localTextView.setTextColor((ColorStateList)localObject4);
                    }
                    localTextView.setId(2131373391);
                    localObject4 = new RelativeLayout.LayoutParams(-2, -2);
                    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
                    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
                    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    localImageView.setLayoutParams(localLayoutParams);
                    localImageView.setImageResource(2130844369);
                    localImageView.setScaleType(ImageView.ScaleType.FIT_END);
                    ((RelativeLayout.LayoutParams)localObject7).addRule(3, 2131373372);
                    ((RelativeLayout.LayoutParams)localObject7).addRule(14);
                    ((RelativeLayout.LayoutParams)localObject4).addRule(3, 2131373392);
                    localLayoutParams.addRule(3, 2131373392);
                    localLayoutParams.addRule(14);
                    localLayoutParams.addRule(6, 2131373391);
                    localLayoutParams.addRule(8, 2131373391);
                    paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject5);
                    paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localTextView);
                    paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localImageView);
                    paramaftf.e = ((ImageView)localObject5);
                    paramaftf.b = localTextView;
                    paramaftf.f = localImageView;
                    label2524:
                    paramaftf.b.setOnClickListener(this);
                    paramaftf.b.setOnTouchListener(paramaftf.jdField_a_of_type_Aeov);
                    paramaftf.b.setOnLongClickListener(paramaftf.jdField_a_of_type_Aeov);
                    localObject5 = paramMessageForPtt.sttText;
                    localObject4 = localObject5;
                    if (TextUtils.isEmpty((CharSequence)localObject5)) {
                      localObject4 = this.jdField_a_of_type_AndroidContentContext.getString(2131720341);
                    }
                    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
                      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
                    }
                    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
                    j = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt.voiceLength, (String)localObject4, this.jdField_a_of_type_AndroidWidgetTextView.getPaint(), 0);
                    localObject5 = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool3, bool1, j + k, paramaftf);
                    paramaftf.b.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
                    j = m + aekt.a(22.0F, (Resources)localObject6);
                    if (!paramMessageForPtt.isSend()) {
                      break label2917;
                    }
                    localObject4 = (RelativeLayout.LayoutParams)paramaftf.e.getLayoutParams();
                    ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131373372);
                    ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131373372);
                    localObject4 = (RelativeLayout.LayoutParams)paramaftf.b.getLayoutParams();
                    ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131373372);
                    ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131373372);
                    paramaftf.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, k, 0);
                    paramaftf.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, BaseChatItemLayout.l, BaseChatItemLayout.q, BaseChatItemLayout.m);
                    paramaftf.e.setPadding(k, 0, k, 0);
                    paramaftf.b.setPadding(k, BaseChatItemLayout.l, k, j);
                    paramaftf.f.setPadding(0, 0, 0, n);
                  }
                }
                for (;;)
                {
                  localObject6 = paramMessageForPtt.sttText;
                  localObject4 = localObject6;
                  if (TextUtils.isEmpty((CharSequence)localObject6)) {
                    localObject4 = this.jdField_a_of_type_AndroidContentContext.getString(2131720341);
                  }
                  paramaftf.b.setText((CharSequence)localObject4);
                  localObject4 = localObject5;
                  break;
                  localObject4 = ((Resources)localObject6).getColorStateList(2131166919);
                  break label2329;
                  paramaftf.e.setVisibility(0);
                  paramaftf.b.setVisibility(0);
                  paramaftf.f.setVisibility(0);
                  break label2524;
                  label2917:
                  localObject4 = (RelativeLayout.LayoutParams)paramaftf.e.getLayoutParams();
                  ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131373372);
                  ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131373372);
                  localObject4 = (RelativeLayout.LayoutParams)paramaftf.b.getLayoutParams();
                  ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131373372);
                  ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131373372);
                  paramaftf.jdField_a_of_type_AndroidWidgetImageView.setPadding(k, 0, 0, 0);
                  paramaftf.jdField_a_of_type_AndroidWidgetTextView.setPadding(BaseChatItemLayout.q, BaseChatItemLayout.l, 0, BaseChatItemLayout.m);
                  paramaftf.e.setPadding(k, 0, k, 0);
                  paramaftf.b.setPadding(k, BaseChatItemLayout.l, k, j);
                  paramaftf.f.setPadding(0, 0, 0, n);
                }
                label3052:
                bool1 = false;
                continue;
                label3058:
                paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.a(true);
              }
              label3069:
              paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(4);
              localObject4 = localObject1;
              localObject1 = localObject2;
              localObject2 = localObject4;
            }
          }
          break;
          paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
          Object localObject4 = paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c;
          if (paramMessageForPtt.isSendFromLocal()) {}
          for (paramMessageForPtt = alpo.a(2131703593);; paramMessageForPtt = alpo.a(2131703590))
          {
            ((ImageView)localObject4).setContentDescription(paramMessageForPtt);
            break;
          }
          paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconResource(2130839228, null);
          paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
          ((Animatable)paramaftf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getDrawable()).start();
          break label522;
          label3197:
          paramMessageForPtt = alpo.a(2131703594);
          break label569;
          paramaftf.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForPtt + (String)localObject1 + alpo.a(2131703595));
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
  
  public void b(View paramView)
  {
    ChatMessage localChatMessage = aekt.a(paramView);
    if (localChatMessage == null) {}
    do
    {
      do
      {
        return;
      } while (localChatMessage.istroop != 9501);
      if (localChatMessage.isSendFromLocal())
      {
        super.b(paramView);
        return;
      }
    } while (!"device_groupchat".equals(localChatMessage.extStr));
    super.b(paramView);
  }
  
  public void onClick(View paramView)
  {
    aekt.n = true;
    int i = paramView.getId();
    if ((AppSetting.c) && (i == 2131363112)) {
      paramView.findViewById(2131373372).performClick();
    }
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject1 = (aftf)aekt.a(paramView);
      } while (localObject1 == null);
      localObject2 = (MessageForPtt)((aftf)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (i == 2131373372)
      {
        if (c((ChatMessage)localObject2)) {
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
        }
        for (;;)
        {
          if (((MessageForPtt)localObject2).istroop == 1008) {
            nrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005857", "0X8005857", 0, 0, "", "", ((MessageForPtt)localObject2).timeStr, "", false);
          }
          if (((MessageForPtt)localObject2).voiceChangeFlag != 1) {
            break;
          }
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F7E", 0, 0, "" + ((MessageForPtt)localObject2).istroop, "", "", "");
          return;
          if ((localObject2 != MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) && (((MessageForPtt)localObject2).isReady())) {
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695680, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
            } else if (!MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(aekt.a(paramView))) {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695679, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
            }
          }
        }
      }
      if (i != 2131373391) {
        break;
      }
    } while (!((MessageForPtt)localObject2).expandStt);
    ((MessageForPtt)localObject2).expandStt = false;
    ((MessageForPtt)localObject2).serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((MessageForPtt)localObject2).uniseq, ((MessageForPtt)localObject2).msgData);
    a((aftf)localObject1, (MessageForPtt)localObject2, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForPtt)localObject2), c((ChatMessage)localObject2));
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8003F37", "0X8003F37", 0, 0, "", "", "", "");
    return;
    if (i == 2131364200)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localObject2 = ndd.a();
      if (VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
      for (paramView = "svip";; paramView = "vip")
      {
        VasWebviewUtil.reportCommercialDrainage((String)localObject1, "LongVoice", "TailClick", "0", 1, 0, 0, (String)localObject2, "", paramView);
        paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        paramView.putExtra("url", "https://m.vip.qq.com/freedom/xhycyy.html?_nav_alpha=0");
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        return;
      }
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zsx
 * JD-Core Version:    0.7.0.1
 */