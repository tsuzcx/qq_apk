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
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

public class yee
  extends adwp
  implements ybs
{
  public yee(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
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
      if ((paramMessageForPtt.url != null) && (paramMessageForPtt.url.startsWith(ajsd.aV))) {
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
            else if ((paramMessageForPtt.url.startsWith(ajsd.aV)) && (bbdx.a(paramMessageForPtt.url)))
            {
              i = 2003;
            }
            else if ((paramMessageForPtt.url.startsWith("/data/data")) && (bbdx.a(paramMessageForPtt.url)))
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
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevicePttItemBuilder", 2, "getBubbleView fileStatus");
    }
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    adws localadws = (adws)paramacuj;
    if (!bbdx.b(localMessageForPtt.url)) {
      a(localadws, localMessageForPtt);
    }
    paramChatMessage = b(paramChatMessage, paramacuj, paramView, paramBaseChatItemLayout, paramacxj);
    ((yer)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramChatMessage, this);
    return paramChatMessage;
  }
  
  public void a(acuj paramacuj, View paramView, ChatMessage paramChatMessage, ambg paramambg)
  {
    adws localadws = (adws)paramacuj;
    if (localadws == null) {}
    for (;;)
    {
      return;
      if ((paramambg.jdField_a_of_type_Int == 0) || (!paramambg.a()))
      {
        paramacuj = paramView.getResources();
        if (paramChatMessage.isSend()) {}
        for (paramacuj = paramacuj.getColorStateList(2131166876);; paramacuj = paramacuj.getColorStateList(2131166872))
        {
          if ((localadws.jdField_a_of_type_AndroidWidgetTextView != null) && (paramacuj != null)) {
            localadws.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramacuj);
          }
          if ((localadws.b == null) || (paramacuj == null)) {
            break;
          }
          localadws.b.setTextColor(paramacuj);
          return;
        }
      }
      if (paramambg.jdField_b_of_type_Int == 0)
      {
        localadws.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        if (localadws.b != null) {
          localadws.b.setTextColor(-16777216);
        }
      }
      while ((paramambg.jdField_b_of_type_Boolean) && (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localadws.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor(), 10000.0D * localadws.jdField_a_of_type_Ambg.jdField_a_of_type_Double) == 1))
      {
        float f2 = localadws.jdField_a_of_type_AndroidWidgetTextView.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        localadws.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        localadws.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(f1, 0.0F, 0.0F, paramambg.d);
        return;
        localadws.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramambg.jdField_b_of_type_Int);
        if (localadws.b != null) {
          localadws.b.setTextColor(paramambg.jdField_b_of_type_Int);
        }
      }
    }
  }
  
  protected void a(adws paramadws, MessageForPtt paramMessageForPtt)
  {
    paramadws = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramadws instanceof QQAppInterface))
    {
      paramadws = (QQAppInterface)paramadws;
      if (!bbfj.d(BaseApplication.getContext()))
      {
        paramMessageForPtt.fileSize = -1L;
        paramMessageForPtt.extraflag = 32768;
        paramMessageForPtt.serial();
        paramadws.a().a(paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new DevicePttItemBuilder.3(this, paramMessageForPtt));
  }
  
  protected void a(adws paramadws, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    b(paramadws, paramMessageForPtt, paramInt, paramBoolean);
    if (paramInt == 2005)
    {
      if (TextUtils.isEmpty(paramMessageForPtt.timeStr))
      {
        paramMessageForPtt.timeStr = adwp.a(paramMessageForPtt.voiceLength);
        if (QLog.isColorLevel()) {
          QLog.d("DevicePttItemBuilder", 2, "voiceLength showPttItem voice:" + paramMessageForPtt.voiceLength);
        }
      }
      paramadws.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessageForPtt.timeStr);
    }
  }
  
  public void a(View paramView)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)actj.a(paramView);
    if (localMessageForPtt == null) {
      return;
    }
    paramView = (adws)actj.a(paramView);
    if (localMessageForPtt.isSendFromLocal())
    {
      paramView = bfpc.a(this.jdField_a_of_type_AndroidContentContext);
      paramView.b(2131689995);
      paramView.c(2131690596);
      paramView.a(new yef(this, localMessageForPtt, paramView));
      paramView.show();
      return;
    }
    bfpc localbfpc = bfpc.a(this.jdField_a_of_type_AndroidContentContext);
    localbfpc.a(2131691580);
    localbfpc.b(2131691579);
    localbfpc.c(2131690596);
    localbfpc.a(new yeg(this, paramView, localMessageForPtt, localbfpc));
    localbfpc.show();
  }
  
  public void a(View paramView, ybt paramybt)
  {
    int i = 1005;
    MessageForPtt localMessageForPtt = (MessageForPtt)actj.a(paramView);
    if ((localMessageForPtt == null) || (localMessageForPtt.uniseq != paramybt.jdField_a_of_type_Long)) {
      return;
    }
    int j = paramybt.jdField_a_of_type_Int;
    paramView = (adws)actj.a(paramView);
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
  
  public bbmh[] a(View paramView)
  {
    paramView = new bbmf();
    aanz.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
  
  protected View b(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    paramBaseChatItemLayout = (adws)paramacuj;
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    paramacuj = paramView;
    if (paramView == null)
    {
      paramacuj = new BreathAnimationLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131372933);
      TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setId(2131372938);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166872));
      Object localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject).setId(2131372934);
      ((RelativeLayout)localObject).addView(paramView);
      ((RelativeLayout)localObject).addView(localTextView);
      paramacuj.addView((View)localObject);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = paramacuj;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = localTextView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject);
    }
    paramBaseChatItemLayout.jdField_a_of_type_Acxj = paramacxj;
    if (paramChatMessage.isSend())
    {
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131372938);
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
      return paramacuj;
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131372933);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, -1);
    }
  }
  
  protected void b(adws paramadws, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevicePttItemBuilder", 2, "fileStatus is:" + paramInt + ",url is:" + paramMessageForPtt.url + ",uniseq is:" + paramMessageForPtt.uniseq + ",stt is:" + paramMessageForPtt.sttAbility + ",long is:" + paramMessageForPtt.longPttVipFlag + ", voiceLength is: " + paramMessageForPtt.voiceLength);
    }
    paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject1 = (RelativeLayout.LayoutParams)paramadws.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, -1);
    Object localObject2 = null;
    if (paramadws.c != null)
    {
      paramadws.c.setVisibility(8);
      paramadws.c.setOnClickListener(null);
      paramadws.d.setVisibility(8);
    }
    if (paramadws.b != null)
    {
      paramadws.b.setVisibility(8);
      paramadws.b.setOnClickListener(null);
      paramadws.e.setVisibility(8);
      paramadws.f.setVisibility(8);
    }
    paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
    paramadws.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramadws.jdField_a_of_type_Acxj);
    paramadws.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramadws.jdField_a_of_type_Acxj);
    Object localObject6 = this.jdField_a_of_type_AndroidContentContext.getResources();
    boolean bool2 = a(paramMessageForPtt, paramadws);
    boolean bool1;
    boolean bool3;
    int i;
    int j;
    if (paramMessageForPtt.voiceChangeFlag != 0)
    {
      bool1 = true;
      bool3 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramadws, paramMessageForPtt);
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
          if (this.jdField_a_of_type_Ayag.a(paramMessageForPtt)) {
            j = 4;
          }
        }
        switch (j)
        {
        case 2: 
        case 3: 
        default: 
          paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
          if (paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null) {
            paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
          }
          label522:
          if (bool2)
          {
            paramMessageForPtt = (agzd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(245);
            if (paramMessageForPtt == null) {
              break label3197;
            }
            paramMessageForPtt = paramMessageForPtt.a("voice_pwd", ajya.a(2131703222), new String[] { "lowTipStr" });
            label569:
            paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, paramMessageForPtt, null);
          }
          if (AppSetting.d)
          {
            paramMessageForPtt = ajya.a(2131703224);
            if (i == 0) {
              break label3207;
            }
            paramadws.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForPtt + (String)localObject1 + ajya.a(2131703226) + ajya.a(2131703225));
            label641:
            if (paramadws.jdField_a_of_type_JavaLangStringBuilder != null)
            {
              paramadws.jdField_a_of_type_JavaLangStringBuilder.append("发送了语音.").append((String)localObject1);
              if (localObject2 != null) {
                paramadws.jdField_a_of_type_JavaLangStringBuilder.append(" ").append((String)localObject2);
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
      paramadws.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramadws.jdField_a_of_type_AndroidWidgetTextView.setPadding(actj.a(10.0F, (Resources)localObject6), BaseChatItemLayout.l, actj.a(10.0F, (Resources)localObject6), BaseChatItemLayout.m);
      if (paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      a(paramadws, bool3, bool1, paramMessageForPtt.isSend());
      paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
      a(paramMessageForPtt, bool1, paramadws);
      localObject1 = "";
      paramInt = 1;
      i = j;
      break label431;
      paramadws.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramadws.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      paramadws.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramadws.jdField_a_of_type_AndroidWidgetTextView.setPadding(actj.a(40.0F, (Resources)localObject6), BaseChatItemLayout.l, actj.a(40.0F, (Resources)localObject6), BaseChatItemLayout.m);
      if (paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(true);
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
      paramadws.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramadws.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      paramadws.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramadws.jdField_a_of_type_AndroidWidgetTextView.setPadding(actj.a(10.0F, (Resources)localObject6), BaseChatItemLayout.l, actj.a(10.0F, (Resources)localObject6), BaseChatItemLayout.m);
    } while (paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView == null);
    paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
    return;
    label1034:
    label1167:
    Object localObject3;
    Object localObject5;
    if (paramMessageForPtt.voiceLength > adwp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt")) {
      if (paramMessageForPtt.longPttVipFlag == 1)
      {
        if (this.jdField_a_of_type_AndroidTextSpannableString == null)
        {
          this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString("[v] QQ会员专享长语音");
          localObject1 = ((Resources)localObject6).getDrawable(2130840069);
          ((Drawable)localObject1).setBounds(0, -5, ((Drawable)localObject1).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject1).getIntrinsicHeight() * 4 / 5);
          localObject1 = new bcnx((Drawable)localObject1, 1).a(0.05F);
          this.jdField_a_of_type_AndroidTextSpannableString.setSpan(localObject1, 0, 3, 17);
        }
        paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.jdField_a_of_type_AndroidTextSpannableString, this);
        localObject2 = "QQ会员专享长语音";
        localObject1 = localObject2;
        if (VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          localObject5 = naj.a();
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
      paramadws.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      a(paramadws, bool3, bool1, paramMessageForPtt.isSend());
      paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
      paramadws.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      a(paramMessageForPtt, paramBoolean, bool3, bool1, paramadws);
      if (paramMessageForPtt.isSend()) {
        if (paramMessageForPtt.mRobotFlag == 1)
        {
          localObject3 = ((bamk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
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
          paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
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
            k = actj.a(9.0F, (Resources)localObject6);
            int n = actj.a(12.0F, (Resources)localObject6);
            try
            {
              m = ((Resources)localObject6).getDrawable(2130844026).getIntrinsicHeight();
              i1 = actj.a(1.0F, (Resources)localObject6);
              if (j == 1)
              {
                m = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt.voiceLength, null, null, 0);
                if (paramMessageForPtt.isSend())
                {
                  paramadws.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, k, 0);
                  localObject3 = paramadws.jdField_a_of_type_AndroidWidgetTextView;
                  n = BaseChatItemLayout.l;
                  if (bool3)
                  {
                    j = k;
                    ((TextView)localObject3).setPadding(0, n, j, BaseChatItemLayout.m);
                    localObject3 = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool3, bool1, m + k, paramadws);
                    if (paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView == null) {
                      break label3077;
                    }
                    localObject5 = (RelativeLayout.LayoutParams)paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams();
                    ((RelativeLayout.LayoutParams)localObject5).width = (localObject3[0] + localObject3[1] + localObject3[2]);
                    ((RelativeLayout.LayoutParams)localObject5).height = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool3, paramadws);
                    if (QLog.isColorLevel()) {
                      QLog.d("DevicePttItemBuilder", 2, "message seq=" + paramMessageForPtt.uniseq + ", VpLp.width=" + ((RelativeLayout.LayoutParams)localObject5).width + ", flagTimeContainer.getLeft()=" + paramadws.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft());
                    }
                    if ((!bool3) || (((RelativeLayout.LayoutParams)localObject5).height <= 0)) {
                      break label3069;
                    }
                    paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(0);
                    localObject7 = paramadws.jdField_a_of_type_Ambg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 7);
                    if ((((ambh)((Pair)localObject7).first).a != null) && (((ambh)((Pair)localObject7).first).a.length > 0))
                    {
                      localObject6 = paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView;
                      localObject7 = (ambh)((Pair)localObject7).first;
                      j = localObject3[0];
                      k = ((RelativeLayout.LayoutParams)localObject5).height;
                      m = localObject3[1];
                      n = localObject3[2];
                      if (paramMessageForPtt.isSend()) {
                        break label3052;
                      }
                      bool1 = true;
                      ((VoicePrintUtils.VoicePrintView)localObject6).setBitmap((ambh)localObject7, j, k, m, n, bool1);
                      if (!paramBoolean) {
                        break label3058;
                      }
                      paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.a(false);
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
                      this.b = new SpannableString(ajya.a(2131703220));
                      localObject1 = ((Resources)localObject6).getDrawable(2130840068);
                      ((Drawable)localObject1).setBounds(0, -5, ((Drawable)localObject1).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject1).getIntrinsicHeight() * 4 / 5);
                      localObject1 = new bcnx((Drawable)localObject1, 1).a(0.05F);
                      this.b.setSpan(localObject1, 0, 3, 17);
                    }
                    localObject2 = ajya.a(2131703217);
                    paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.b, this);
                    break label1167;
                    localObject1 = "vip";
                    break label1210;
                    paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject3, null);
                    break label1442;
                    localObject3 = ((bamk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
                    if (TextUtils.isEmpty((CharSequence)localObject3)) {
                      break label1442;
                    }
                    paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject3, null);
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
                int m = actj.a(24.0F, (Resources)localObject6);
                QLog.e("DevicePttItemBuilder", 1, "", localException);
                continue;
                j = BaseChatItemLayout.q;
                continue;
                paramadws.jdField_a_of_type_AndroidWidgetImageView.setPadding(k, 0, 0, 0);
                localObject4 = paramadws.jdField_a_of_type_AndroidWidgetTextView;
                if (bool3) {}
                for (j = k;; j = BaseChatItemLayout.q)
                {
                  ((TextView)localObject4).setPadding(j, BaseChatItemLayout.l, 0, BaseChatItemLayout.m);
                  break;
                }
                if (paramadws.b == null)
                {
                  localObject5 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
                  ((ImageView)localObject5).setImageDrawable(new ColorDrawable(838860800));
                  localObject7 = new RelativeLayout.LayoutParams(-1, i1);
                  ((ImageView)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject7);
                  ((ImageView)localObject5).setId(2131372954);
                  TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
                  if (paramMessageForPtt.isSend())
                  {
                    localObject4 = ((Resources)localObject6).getColorStateList(2131166876);
                    if (localObject4 != null) {
                      localTextView.setTextColor((ColorStateList)localObject4);
                    }
                    localTextView.setId(2131372953);
                    localObject4 = new RelativeLayout.LayoutParams(-2, -2);
                    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
                    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
                    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    localImageView.setLayoutParams(localLayoutParams);
                    localImageView.setImageResource(2130844026);
                    localImageView.setScaleType(ImageView.ScaleType.FIT_END);
                    ((RelativeLayout.LayoutParams)localObject7).addRule(3, 2131372934);
                    ((RelativeLayout.LayoutParams)localObject7).addRule(14);
                    ((RelativeLayout.LayoutParams)localObject4).addRule(3, 2131372954);
                    localLayoutParams.addRule(3, 2131372954);
                    localLayoutParams.addRule(14);
                    localLayoutParams.addRule(6, 2131372953);
                    localLayoutParams.addRule(8, 2131372953);
                    paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject5);
                    paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localTextView);
                    paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localImageView);
                    paramadws.e = ((ImageView)localObject5);
                    paramadws.b = localTextView;
                    paramadws.f = localImageView;
                    label2524:
                    paramadws.b.setOnClickListener(this);
                    paramadws.b.setOnTouchListener(paramadws.jdField_a_of_type_Acxj);
                    paramadws.b.setOnLongClickListener(paramadws.jdField_a_of_type_Acxj);
                    localObject5 = paramMessageForPtt.sttText;
                    localObject4 = localObject5;
                    if (TextUtils.isEmpty((CharSequence)localObject5)) {
                      localObject4 = this.jdField_a_of_type_AndroidContentContext.getString(2131719815);
                    }
                    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
                      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
                    }
                    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
                    j = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt.voiceLength, (String)localObject4, this.jdField_a_of_type_AndroidWidgetTextView.getPaint(), 0);
                    localObject5 = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool3, bool1, j + k, paramadws);
                    paramadws.b.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
                    j = m + actj.a(22.0F, (Resources)localObject6);
                    if (!paramMessageForPtt.isSend()) {
                      break label2917;
                    }
                    localObject4 = (RelativeLayout.LayoutParams)paramadws.e.getLayoutParams();
                    ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131372934);
                    ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131372934);
                    localObject4 = (RelativeLayout.LayoutParams)paramadws.b.getLayoutParams();
                    ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131372934);
                    ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131372934);
                    paramadws.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, k, 0);
                    paramadws.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, BaseChatItemLayout.l, BaseChatItemLayout.q, BaseChatItemLayout.m);
                    paramadws.e.setPadding(k, 0, k, 0);
                    paramadws.b.setPadding(k, BaseChatItemLayout.l, k, j);
                    paramadws.f.setPadding(0, 0, 0, n);
                  }
                }
                for (;;)
                {
                  localObject6 = paramMessageForPtt.sttText;
                  localObject4 = localObject6;
                  if (TextUtils.isEmpty((CharSequence)localObject6)) {
                    localObject4 = this.jdField_a_of_type_AndroidContentContext.getString(2131719815);
                  }
                  paramadws.b.setText((CharSequence)localObject4);
                  localObject4 = localObject5;
                  break;
                  localObject4 = ((Resources)localObject6).getColorStateList(2131166872);
                  break label2329;
                  paramadws.e.setVisibility(0);
                  paramadws.b.setVisibility(0);
                  paramadws.f.setVisibility(0);
                  break label2524;
                  label2917:
                  localObject4 = (RelativeLayout.LayoutParams)paramadws.e.getLayoutParams();
                  ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131372934);
                  ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131372934);
                  localObject4 = (RelativeLayout.LayoutParams)paramadws.b.getLayoutParams();
                  ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131372934);
                  ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131372934);
                  paramadws.jdField_a_of_type_AndroidWidgetImageView.setPadding(k, 0, 0, 0);
                  paramadws.jdField_a_of_type_AndroidWidgetTextView.setPadding(BaseChatItemLayout.q, BaseChatItemLayout.l, 0, BaseChatItemLayout.m);
                  paramadws.e.setPadding(k, 0, k, 0);
                  paramadws.b.setPadding(k, BaseChatItemLayout.l, k, j);
                  paramadws.f.setPadding(0, 0, 0, n);
                }
                label3052:
                bool1 = false;
                continue;
                label3058:
                paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.a(true);
              }
              label3069:
              paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(4);
              localObject4 = localObject1;
              localObject1 = localObject2;
              localObject2 = localObject4;
            }
          }
          break;
          paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
          Object localObject4 = paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c;
          if (paramMessageForPtt.isSendFromLocal()) {}
          for (paramMessageForPtt = ajya.a(2131703221);; paramMessageForPtt = ajya.a(2131703218))
          {
            ((ImageView)localObject4).setContentDescription(paramMessageForPtt);
            break;
          }
          paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconResource(2130839144, null);
          paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
          ((Animatable)paramadws.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getDrawable()).start();
          break label522;
          label3197:
          paramMessageForPtt = ajya.a(2131703222);
          break label569;
          paramadws.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForPtt + (String)localObject1 + ajya.a(2131703223));
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
    ChatMessage localChatMessage = actj.a(paramView);
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
    actj.n = true;
    int i = paramView.getId();
    if ((AppSetting.d) && (i == 2131363076)) {
      paramView.findViewById(2131372934).performClick();
    }
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject1 = (adws)actj.a(paramView);
      } while (localObject1 == null);
      localObject2 = (MessageForPtt)((adws)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (i == 2131372934)
      {
        if (c((ChatMessage)localObject2)) {
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
        }
        for (;;)
        {
          if (((MessageForPtt)localObject2).istroop == 1008) {
            nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005857", "0X8005857", 0, 0, "", "", ((MessageForPtt)localObject2).timeStr, "", false);
          }
          if (((MessageForPtt)localObject2).voiceChangeFlag != 1) {
            break;
          }
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F7E", 0, 0, "" + ((MessageForPtt)localObject2).istroop, "", "", "");
          return;
          if ((localObject2 != MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) && (((MessageForPtt)localObject2).isReady())) {
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) {
              bcql.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695522, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
            } else if (!MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(actj.a(paramView))) {
              bcql.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695521, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
            }
          }
        }
      }
      if (i != 2131372953) {
        break;
      }
    } while (!((MessageForPtt)localObject2).expandStt);
    ((MessageForPtt)localObject2).expandStt = false;
    ((MessageForPtt)localObject2).serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((MessageForPtt)localObject2).uniseq, ((MessageForPtt)localObject2).msgData);
    a((adws)localObject1, (MessageForPtt)localObject2, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForPtt)localObject2), c((ChatMessage)localObject2));
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8003F37", "0X8003F37", 0, 0, "", "", "", "");
    return;
    if (i == 2131364138)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localObject2 = naj.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yee
 * JD-Core Version:    0.7.0.1
 */