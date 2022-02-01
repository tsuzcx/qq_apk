import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.a;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkHorizontalListView;
import com.tencent.mobileqq.ark.ArkHorizontalListView.a;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkApp.ArkReportData;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class wzr
  extends BaseBubbleBuilder
  implements BaseChatItemLayout.a, ArkHorizontalListView.a
{
  private List<MessageForArkApp> rZ = new ArrayList();
  
  public wzr(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private RelativeLayout.LayoutParams a(BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams1.width = -1;
    localLayoutParams1.height = (adqr.cJd + wja.dp2px(29.0F, this.mContext.getResources()));
    localLayoutParams1.leftMargin = 0;
    paramBaseChatItemLayout.setPadding(0, BaseChatItemLayout.paddingTop, 0, BaseChatItemLayout.bNW + BaseChatItemLayout.bNZ);
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.a.getLayoutParams();
    int i;
    if (paramBoolean)
    {
      localLayoutParams2.rightMargin = this.mContext.getResources().getDimensionPixelSize(2131296409);
      paramBaseChatItemLayout.a.setLayoutParams(localLayoutParams2);
      if (paramBaseChatItemLayout.sb != null)
      {
        localLayoutParams2 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.sb.getLayoutParams();
        i = MessageForArkApp.dp2px(1.0F);
        if (!paramBoolean) {
          break label327;
        }
        localLayoutParams2.addRule(7, 2131364512);
        localLayoutParams2.rightMargin = (-i);
        label147:
        paramBaseChatItemLayout.sb.setLayoutParams(localLayoutParams2);
      }
      if ((paramBaseChatItemLayout.mCheckBox != null) && (paramBaseChatItemLayout.mCheckBox.getVisibility() != 8))
      {
        localLayoutParams2 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.mCheckBox.getLayoutParams();
        localLayoutParams2.leftMargin = BaseChatItemLayout.paddingLeft;
        paramBaseChatItemLayout.mCheckBox.setLayoutParams(localLayoutParams2);
      }
      if ((paramBaseChatItemLayout.am != null) && (paramBaseChatItemLayout.am.getVisibility() != 8))
      {
        localLayoutParams2 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.am.getLayoutParams();
        if (!paramBoolean) {
          break label345;
        }
        localLayoutParams2.rightMargin = BaseChatItemLayout.paddingRight;
      }
    }
    for (;;)
    {
      paramBaseChatItemLayout.am.setLayoutParams(localLayoutParams2);
      return localLayoutParams1;
      if ((paramBaseChatItemLayout.mCheckBox != null) && (paramBaseChatItemLayout.mCheckBox.getVisibility() != 8))
      {
        i = MessageForArkApp.dp2px(30.0F);
        localLayoutParams2.leftMargin = (BaseChatItemLayout.paddingLeft + i);
        localLayoutParams1.leftMargin = (i - BaseChatItemLayout.paddingLeft);
        break;
      }
      localLayoutParams2.leftMargin = this.mContext.getResources().getDimensionPixelSize(2131296409);
      break;
      label327:
      localLayoutParams2.addRule(5, 2131364512);
      localLayoutParams2.leftMargin = (-i);
      break label147;
      label345:
      if ((paramBaseChatItemLayout.mCheckBox != null) && (paramBaseChatItemLayout.mCheckBox.getVisibility() != 8)) {
        localLayoutParams2.leftMargin = (MessageForArkApp.dp2px(25.0F) + BaseChatItemLayout.paddingLeft);
      } else {
        localLayoutParams2.leftMargin = BaseChatItemLayout.paddingLeft;
      }
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, paramInt1);
    localLayoutParams.addRule(8, 2131364503);
    localLayoutParams.bottomMargin = paramInt2;
    if (paramBoolean)
    {
      localLayoutParams.addRule(5, 2131364503);
      localLayoutParams.leftMargin = paramInt3;
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.addRule(7, 2131364503);
      localLayoutParams.rightMargin = paramInt3;
    }
  }
  
  private void a(MessageForArkApp paramMessageForArkApp)
  {
    if (!this.rZ.contains(paramMessageForArkApp))
    {
      paramMessageForArkApp.report(0);
      this.rZ.add(paramMessageForArkApp);
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, wlz paramwlz)
  {
    paramChatMessage = (BaseChatItemLayout)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramwlz);
    paramView = (wzr.a)paramChatMessage.getTag();
    paramViewGroup = (RelativeLayout.LayoutParams)paramView.jdField_E_of_type_AndroidViewView.getLayoutParams();
    paramwlz = paramChatMessage.J();
    if ((paramwlz != null) && (paramwlz.getVisibility() == 0)) {
      paramViewGroup.addRule(3, 2131364521);
    }
    for (paramViewGroup.topMargin = BaseChatItemLayout.bNV;; paramViewGroup.topMargin = 0)
    {
      paramView.jdField_E_of_type_AndroidViewView.setLayoutParams(paramViewGroup);
      return paramChatMessage;
      paramViewGroup.addRule(6, 2131364512);
    }
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    boolean bool = localMessageForArkApp.isSend();
    Object localObject = a(paramBaseChatItemLayout, bool);
    Resources localResources = this.mContext.getResources();
    int i = BaseChatItemLayout.bOc;
    int j = MessageForArkApp.dp2px(40.0F);
    int k = localResources.getDimensionPixelSize(2131296407) + (i * 2 + j);
    int m = localResources.getDimensionPixelSize(2131296399);
    i = adqr.cJg - k - adqr.cJd - m;
    label106:
    wzr.a locala;
    adrd localadrd;
    if (bool)
    {
      j = i;
      if (!bool) {
        break label433;
      }
      k -= m;
      QLog.d("ArkAppShareMultiItemBuilder", 1, new Object[] { "ArkFold.appName:", localMessageForArkApp.ark_app_message.appName, ", getChatbubbleMaxWidth=", Integer.valueOf(adqr.cJd), ", displaywitdh=", Integer.valueOf(adqr.cJf), ", headerWidth=", Integer.valueOf(j), ",footerWidth=", Integer.valueOf(k) });
      locala = (wzr.a)parame;
      paramView = (ArkHorizontalListView)paramView;
      if (paramView != null) {
        break label440;
      }
      paramView = new ArkHorizontalListView(this.mContext);
      paramView.setDividerWidth(m);
      localadrd = new adrd(this.mContext, this.sessionInfo, paramView, paramwlz);
      paramView.setAdapter(localadrd);
      paramwlz = paramView;
      label253:
      paramwlz.setIsSend(bool);
      paramwlz.MIN_SPACE = (adqr.cJf / 4);
      localadrd.hB(j, k);
      paramwlz.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramwlz.setRefreshCallback(this);
      paramwlz.setTag(locala);
      locala.msg = localMessageForArkApp.msg;
      locala.a.setMiniAioShieldItemTouchListener(this);
      k = localMessageForArkApp.getMsgArkAppCount();
      localadrd.Ls(localadrd.getDataCount() - k);
      paramView = null;
      j = 0;
      label343:
      if (j >= k) {
        break label467;
      }
      localObject = localMessageForArkApp.getMsgArkAppByPosition(j);
      if ((MessageForArkApp)localadrd.b(j) != null) {
        break label455;
      }
      localadrd.a((adpg)localObject);
      label379:
      if ((localObject == null) || (TextUtils.isEmpty(((MessageForArkApp)localObject).ark_app_message.appName)) || (!TextUtils.isEmpty(paramView))) {
        break label729;
      }
      paramView = ((MessageForArkApp)localObject).ark_app_message.appName;
    }
    label433:
    label440:
    label455:
    label467:
    label729:
    for (;;)
    {
      j += 1;
      break label343;
      j = k - m;
      break;
      k = i;
      break label106;
      localadrd = (adrd)paramView.getAdapter();
      paramwlz = paramView;
      break label253;
      localadrd.b(j, (adpg)localObject);
      break label379;
      a(paramwlz);
      if (localadrd.getDataCount() == 1)
      {
        int n;
        if (paramBaseChatItemLayout.mProgress != null)
        {
          j = MessageForArkApp.dp2px(16.0F);
          k = MessageForArkApp.dp2px(47.0F);
          m = localResources.getDimensionPixelSize(2131296407);
          n = BaseChatItemLayout.paddingLeft;
          a(paramBaseChatItemLayout.mProgress, j, k, i - j - m - n, bool);
        }
        if (paramBaseChatItemLayout.sc != null)
        {
          j = MessageForArkApp.dp2px(24.0F);
          k = MessageForArkApp.dp2px(45.0F);
          m = localResources.getDimensionPixelSize(2131296407);
          n = BaseChatItemLayout.paddingLeft;
          a(paramBaseChatItemLayout.sc, j, k, i - j - m - n, bool);
        }
      }
      if (aTl)
      {
        paramView = new StringBuilder();
        if ((locala.jdField_E_of_type_JavaLangStringBuilder != null) && (locala.jdField_E_of_type_JavaLangStringBuilder.length() > 0)) {
          paramView.append(locala.jdField_E_of_type_JavaLangStringBuilder);
        }
        paramView.append(b(localMessageForArkApp));
        paramwlz.setContentDescription(paramView);
        ArkAppCenter.o("ArkAppShareMultiItemBuilder", "Type is card, and talkbackText is " + paramView);
      }
      adtu.e(localMessageForArkApp);
      ApolloUtil.a(this.app, this.sessionInfo, paramChatMessage, parame.pos, parame.count);
      a(localMessageForArkApp);
      return paramwlz;
    }
  }
  
  public aqoa a(aqoa paramaqoa, ChatMessage paramChatMessage, wko.a parama)
  {
    paramChatMessage = (MessageForArkApp)paramChatMessage;
    if ((paramChatMessage != null) && (paramChatMessage.ark_app_message != null) && (paramChatMessage.arkContainer.getErrorInfo() != null) && (MessageForArkApp.isAllowedArkForward(false, paramChatMessage))) {
      paramaqoa.Z(2131367523, this.mContext.getString(2131721067), 2130839086);
    }
    return paramaqoa;
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new wzr.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForArkApp localMessageForArkApp;
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    case 2131367523: 
      do
      {
        return;
        localMessageForArkApp = (MessageForArkApp)paramChatMessage;
      } while ((localMessageForArkApp == null) || (localMessageForArkApp.ark_app_message == null));
      paramContext = (MessageForArkApp)adqq.a(1, localMessageForArkApp.ark_app_message.appName, localMessageForArkApp, localMessageForArkApp);
      if (paramContext == null) {
        paramContext = localMessageForArkApp;
      }
      break;
    }
    while ((paramContext != null) && (paramContext.ark_app_message != null))
    {
      Intent localIntent = new Intent();
      if (paramContext.getMsgArkAppCount() >= 1)
      {
        paramChatMessage = aqjn.a.a(paramContext.ark_app_message.appName, paramContext.ark_app_message.appView, paramContext.ark_app_message.appMinVersion, paramContext.ark_app_message.metaList, adqr.getDensity(), null, null);
        localIntent.putExtra("is_ark_display_share", true);
      }
      for (;;)
      {
        MessageForArkApp.ArkReportData localArkReportData = paramContext.buildTypeAndTitle();
        if (localArkReportData.isSdkShare)
        {
          paramChatMessage.putString("forward_ark_app_type", localArkReportData.type);
          paramChatMessage.putString("forward_ark_app_title", localArkReportData.title);
        }
        paramChatMessage.putInt("forward_type", 27);
        paramChatMessage.putString("forward_ark_app_name", paramContext.ark_app_message.appName);
        paramChatMessage.putString("forward_ark_app_view", paramContext.ark_app_message.appView);
        paramChatMessage.putString("forward_ark_app_ver", paramContext.ark_app_message.appMinVersion);
        paramChatMessage.putString("forward_ark_app_prompt", paramContext.ark_app_message.promptText);
        paramChatMessage.putString("forward_ark_app_config", paramContext.ark_app_message.config);
        paramChatMessage.putString("forward_ark_app_desc", paramContext.ark_app_message.appDesc);
        paramChatMessage.putString("forward_ark_app_compat", paramContext.ark_app_message.compatibleText);
        paramChatMessage.putString("forward_ark_app_meta", paramContext.ark_app_message.metaList);
        paramChatMessage.putString("forward_appId_ark_from_sdk", paramContext.ark_app_message.appId);
        paramChatMessage.putString("struct_share_key_source_name", paramContext.ark_app_message.mSourceName);
        paramChatMessage.putString("struct_share_key_source_action_data", paramContext.ark_app_message.mSourceActionData);
        paramChatMessage.putString("struct_share_key_source_a_action_data", paramContext.ark_app_message.mSource_A_ActionData);
        paramChatMessage.putString("struct_share_key_source_url", paramContext.ark_app_message.mSourceUrl);
        paramChatMessage.putInt("selection_mode", this.bOY);
        paramChatMessage.putInt("forward_source_uin_type", this.sessionInfo.cZ);
        localIntent.putExtras(paramChatMessage);
        ahgq.f((Activity)this.mContext, localIntent, 21);
        if (!localMessageForArkApp.isMultiMsg) {
          break;
        }
        anot.a(this.app, "dc00898", "", "", "0X8009D66", "0X8009D66", 11, 0, "11", "", "", "");
        return;
        paramChatMessage = new Bundle();
      }
      ujt.b(this.mContext, this.app, paramChatMessage);
      return;
      super.j(paramChatMessage);
      return;
      super.m(paramChatMessage);
      return;
      super.k(paramChatMessage);
      return;
      aviz.a(this.app, this.mContext, paramChatMessage);
      return;
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, 0, 0);
  }
  
  public void a(ArkHorizontalListView paramArkHorizontalListView)
  {
    int k = 1;
    BaseBubbleBuilder.e locale = (BaseBubbleBuilder.e)paramArkHorizontalListView.getTag();
    if ((locale == null) || (!(locale instanceof wzr.a))) {
      return;
    }
    int[] arrayOfInt1 = new int[2];
    locale.a.a.getLocationOnScreen(arrayOfInt1);
    int j = arrayOfInt1[0];
    int m = locale.a.a.getMeasuredWidth();
    int n = arrayOfInt1[1];
    int i1 = locale.a.a.getMeasuredHeight();
    int i2 = paramArkHorizontalListView.getChildCount();
    int[] arrayOfInt2 = new int[2];
    int i = 0;
    if (i < i2)
    {
      View localView = paramArkHorizontalListView.getChildAt(i);
      if (localView != null)
      {
        localView.getLocationOnScreen(arrayOfInt2);
        int i3 = arrayOfInt2[0];
        int i4 = localView.getMeasuredWidth();
        int i5 = arrayOfInt2[1];
        int i6 = localView.getMeasuredHeight();
        if ((!(localView instanceof LinearLayout)) || (i3 + i4 < arrayOfInt1[0]) || (arrayOfInt2[0] > m + j) || (i5 + i6 < arrayOfInt1[1]) || (arrayOfInt2[1] > i1 + n)) {}
      }
    }
    for (i = 1;; i = 0)
    {
      if ((locale.a.am != null) && (locale.a.am.getVisibility() == 0))
      {
        j = 1;
        label229:
        if ((i == 0) || (j != 0)) {
          break label431;
        }
        i = k;
        label240:
        if (i == 0) {
          break label452;
        }
        i = MessageForArkApp.dp2px(1.0F);
        if (locale.a.sb == null)
        {
          locale.a.sb = new ImageView(this.mContext);
          locale.a.sb.setScaleType(ImageView.ScaleType.FIT_XY);
          j = MessageForArkApp.dp2px(42.0F);
          paramArkHorizontalListView = new RelativeLayout.LayoutParams(j, j);
          locale.a.addView(locale.a.sb, paramArkHorizontalListView);
        }
        paramArkHorizontalListView = (RelativeLayout.LayoutParams)locale.a.sb.getLayoutParams();
        paramArkHorizontalListView.addRule(6, 2131364512);
        paramArkHorizontalListView.topMargin = (-i);
        if (!locale.a.isSend()) {
          break label436;
        }
        paramArkHorizontalListView.addRule(7, 2131364512);
        paramArkHorizontalListView.rightMargin = (-i);
      }
      for (;;)
      {
        locale.a.sb.setBackgroundResource(2130845790);
        locale.a.sb.requestLayout();
        locale.a.sb.setVisibility(0);
        return;
        i += 1;
        break;
        j = 0;
        break label229;
        label431:
        i = 0;
        break label240;
        label436:
        paramArkHorizontalListView.addRule(5, 2131364512);
        paramArkHorizontalListView.leftMargin = (-i);
      }
      label452:
      if (locale.a.sb == null) {
        break;
      }
      locale.a.sb.setVisibility(8);
      return;
    }
  }
  
  public void a(ChatMessage paramChatMessage, aqoa paramaqoa)
  {
    if (paramChatMessage == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramChatMessage.istroop != 1) && (paramChatMessage.istroop != 3000) && (paramChatMessage.istroop != 0));
        if ((paramChatMessage.senderuin.equals(this.app.getCurrentUin())) || (!paramChatMessage.isSupportReply())) {
          break;
        }
      } while ((!(paramChatMessage instanceof MessageForArkApp)) || (((MessageForArkApp)paramChatMessage).msg == null));
      paramaqoa.Z(2131377133, this.mContext.getString(2131699906), 2130839090);
      return;
    } while ((!paramChatMessage.isSend()) || (!paramChatMessage.isSupportReply()) || (paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768) || (!(paramChatMessage instanceof MessageForArkApp)) || (paramChatMessage.istroop == 3000) || (((MessageForArkApp)paramChatMessage).msg == null));
    paramaqoa.Z(2131377133, this.mContext.getString(2131699906), 2130839090);
  }
  
  public aqob[] a(View paramView)
  {
    aqoa localaqoa = new aqoa();
    paramView = (wko.a)wja.a(paramView);
    if (paramView != null)
    {
      paramView = paramView.mMessage;
      if ((paramView != null) && ((paramView instanceof MessageForArkApp)))
      {
        if (!paramView.isMultiMsg) {
          break label61;
        }
        a(localaqoa, paramView, null);
      }
    }
    for (;;)
    {
      return localaqoa.a();
      paramView = null;
      break;
      label61:
      b(localaqoa, paramView, null);
    }
  }
  
  public aqoa b(aqoa paramaqoa, ChatMessage paramChatMessage, wko.a parama)
  {
    parama = (MessageForArkApp)paramChatMessage;
    boolean bool1;
    if ((parama != null) && (parama.ark_app_message != null) && (parama.arkContainer != null) && (parama.arkContainer.getErrorInfo() != null))
    {
      if (MessageForArkApp.isAllowedArkForward(false, parama)) {
        paramaqoa.Z(2131367523, this.mContext.getString(2131721067), 2130839086);
      }
      if ((parama.extraflag == 32768) || (this.app.a().aR(parama))) {
        break label330;
      }
      Boolean localBoolean = (Boolean)adqq.a(3, parama.ark_app_message.appName, parama, Boolean.valueOf(true));
      if (localBoolean == null) {
        break label324;
      }
      bool1 = localBoolean.booleanValue();
      bool2 = bool1;
      if (bool1) {
        a(paramaqoa, this.sessionInfo.cZ, parama);
      }
    }
    label324:
    label330:
    for (boolean bool2 = bool1;; bool2 = true)
    {
      if (bool2) {
        a(paramaqoa, parama);
      }
      try
      {
        for (;;)
        {
          if (aejg.a().aS(parama.ark_app_message.appName, parama.ark_app_message.appView))
          {
            a(parama, paramaqoa);
            super.b(parama, paramaqoa);
          }
          super.c(paramaqoa, this.mContext);
          if (avja.W(paramChatMessage)) {
            super.d(paramaqoa, this.mContext);
          }
          super.a(paramaqoa, this.mContext, parama);
          super.e(paramaqoa, this.mContext);
          return paramaqoa;
          ujt.a(paramaqoa, this.mContext, this.sessionInfo.cZ);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("ArkAppShareMultiItemBuilder", 2, "add reply menu error, exception =" + localException.getMessage());
        }
      }
      ujt.a(paramaqoa, this.mContext, this.sessionInfo.cZ);
      super.c(paramaqoa, this.mContext);
      super.e(paramaqoa, this.mContext);
      return paramaqoa;
      bool1 = true;
      break;
    }
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return "";
    }
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    if ((localMessageForArkApp.ark_app_message == null) || (localMessageForArkApp.ark_app_message.promptText == null)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (aqiu.ms(paramChatMessage.issend)) {
      localStringBuilder.append("发出");
    }
    for (;;)
    {
      localStringBuilder.append(localMessageForArkApp.ark_app_message.promptText);
      if (localMessageForArkApp.arkContainer != null)
      {
        paramChatMessage = localMessageForArkApp.arkContainer.aUA;
        if (!TextUtils.isEmpty(paramChatMessage)) {
          localStringBuilder.append(paramChatMessage);
        }
      }
      return localStringBuilder.toString();
      localStringBuilder.append("发来");
    }
  }
  
  public void ei(View paramView)
  {
    super.ei(paramView);
    paramView = (MessageForArkApp)wja.a(paramView);
    if (paramView == null) {}
    String str1;
    String str2;
    do
    {
      return;
      str1 = this.mContext.getString(2131690230);
      str2 = this.mContext.getString(2131690231);
    } while (!paramView.isSendFromLocal());
    aqha.a(this.mContext, 230, str1, str2, new wzs(this, paramView), new wzt(this)).show();
  }
  
  public void p(ChatMessage paramChatMessage)
  {
    anot.a(this.app, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "6", "", "", "");
  }
  
  public static class a
    extends BaseBubbleBuilder.e
  {
    public String msg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wzr
 * JD-Core Version:    0.7.0.1
 */