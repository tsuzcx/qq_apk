import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkHorizontalListView;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkApp.Size;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class wzo
  extends xov
{
  public wzo(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private MessageForArkApp a(MessageForArkApp paramMessageForArkApp, ArkAppMessage paramArkAppMessage)
  {
    MessageForArkApp localMessageForArkApp = new MessageForArkApp();
    localMessageForArkApp.isMultiItemMsg = true;
    localMessageForArkApp.compatibleMsg = paramMessageForArkApp.compatibleMsg;
    localMessageForArkApp.ark_app_message = paramArkAppMessage;
    localMessageForArkApp.issend = paramMessageForArkApp.issend;
    return localMessageForArkApp;
  }
  
  private String a(ArkAppMessage paramArkAppMessage)
  {
    if (paramArkAppMessage == null) {
      return null;
    }
    if ((paramArkAppMessage.mAppList == null) || (paramArkAppMessage.mAppList.isEmpty())) {
      return null;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray();
      paramArkAppMessage = paramArkAppMessage.mAppList.iterator();
      while (paramArkAppMessage.hasNext()) {
        localJSONArray.put(new JSONObject(((ArkAppMessage)paramArkAppMessage.next()).toAppXml()));
      }
      paramArkAppMessage = localJSONArray.toString();
    }
    catch (Exception paramArkAppMessage)
    {
      QLog.e("ChatItemBuilder", 1, "getArrayFromArkAppMessage catch error : " + paramArkAppMessage.getMessage());
      return null;
    }
    return paramArkAppMessage;
  }
  
  private void a(wzo.a parama, MessageForArkApp paramMessageForArkApp)
  {
    if ((aTl) && (parama != null) && (paramMessageForArkApp != null))
    {
      if ((parama.E != null) && (parama.E.length() > 0)) {
        parama.E.setLength(0);
      }
      paramMessageForArkApp = b(paramMessageForArkApp);
      parama.mText.setContentDescription(paramMessageForArkApp);
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, wlz paramwlz)
  {
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    localMessageForArkApp.isMultiItemMsg = true;
    boolean bool = paramChatMessage.isSend();
    paramView = (BaseChatItemLayout)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramwlz);
    paramViewGroup = (wzo.a)paramView.getTag();
    paramChatMessage = this.mContext.getResources();
    Object localObject1 = new ArkAppMessage.Config();
    ((ArkAppMessage.Config)localObject1).fromString(localMessageForArkApp.ark_app_message.config);
    Object localObject2;
    label158:
    label195:
    label231:
    label371:
    int j;
    int i;
    if (MessageForArkApp.isSetSizeByConfig((ArkAppMessage.Config)localObject1))
    {
      paramInt1 = MessageForArkApp.limitToSizeRange(adqr.getDensity(), ((ArkAppMessage.Config)localObject1).width.intValue(), ((ArkAppMessage.Config)localObject1).height.intValue()).height + wja.dp2px(29.0F, paramChatMessage);
      localObject2 = (RelativeLayout.LayoutParams)paramView.a.getLayoutParams();
      localObject1 = new RelativeLayout.LayoutParams(-1, paramInt1);
      if (TextUtils.isEmpty(localMessageForArkApp.ark_app_message.mText)) {
        break label564;
      }
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label569;
      }
      paramViewGroup.mText.setText(localMessageForArkApp.ark_app_message.mText);
      paramViewGroup.mText.setVisibility(0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131364503);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = 0;
      paramView.setPadding(0, BaseChatItemLayout.paddingTop, 0, BaseChatItemLayout.bNW + BaseChatItemLayout.bNZ);
      if (!bool) {
        break label604;
      }
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = BaseChatItemLayout.bOc;
      ((RelativeLayout.LayoutParams)localObject2).addRule(10, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, paramView.vM());
      ((RelativeLayout.LayoutParams)localObject2).topMargin = paramChatMessage.getDimensionPixelSize(2131296437);
      paramView.a.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if ((paramView.mCheckBox != null) && (paramView.mCheckBox.getVisibility() != 8))
      {
        localObject2 = (RelativeLayout.LayoutParams)paramView.mCheckBox.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = BaseChatItemLayout.paddingLeft;
        paramView.mCheckBox.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      if ((paramView.am != null) && (paramView.am.getVisibility() != 8))
      {
        localObject2 = (RelativeLayout.LayoutParams)paramView.am.getLayoutParams();
        if (!bool) {
          break label667;
        }
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = BaseChatItemLayout.paddingRight;
        paramView.am.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      j = BaseChatItemLayout.bOc * 2 + wja.dp2px(40.0F, paramChatMessage) + paramChatMessage.getDimensionPixelSize(2131296407);
      i = paramChatMessage.getDimensionPixelSize(2131296399);
      paramInt2 = BaseChatItemLayout.displayWidth - j - BaseChatItemLayout.bNS - i;
      if (!bool) {
        break label722;
      }
      paramInt1 = paramInt2;
      label434:
      if (!bool) {
        break label731;
      }
      paramInt2 = j - i;
    }
    label564:
    label569:
    label722:
    label731:
    for (;;)
    {
      if ((localMessageForArkApp.ark_app_message.mAppList == null) || (localMessageForArkApp.ark_app_message.mAppList.isEmpty()) || (!localMessageForArkApp.mExtendMsgArkAppList.isEmpty())) {
        break label734;
      }
      paramChatMessage = localMessageForArkApp.ark_app_message.mAppList.iterator();
      while (paramChatMessage.hasNext())
      {
        localObject2 = (ArkAppMessage)paramChatMessage.next();
        ((ArkAppMessage)localObject2).config = localMessageForArkApp.ark_app_message.config;
        localMessageForArkApp.mExtendMsgArkAppList.add(a(localMessageForArkApp, (ArkAppMessage)localObject2));
      }
      paramInt1 = adqr.cJd + wja.dp2px(29.0F, paramChatMessage);
      break;
      paramInt1 = 0;
      break label158;
      ((RelativeLayout.LayoutParams)localObject1).addRule(6, 2131364512);
      ((RelativeLayout.LayoutParams)localObject1).topMargin = (((RelativeLayout.LayoutParams)localObject2).height / 2);
      paramViewGroup.mText.setVisibility(8);
      break label195;
      label604:
      if ((paramView.mCheckBox != null) && (paramView.mCheckBox.getVisibility() != 8))
      {
        paramInt1 = wja.dp2px(30.0F, paramChatMessage);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = (BaseChatItemLayout.paddingLeft + paramInt1);
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = (paramInt1 - BaseChatItemLayout.paddingLeft);
        break label231;
      }
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = BaseChatItemLayout.bOc;
      break label231;
      if ((paramView.mCheckBox != null) && (paramView.mCheckBox.getVisibility() != 8))
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = (wja.dp2px(25.0F, paramView.getResources()) + BaseChatItemLayout.paddingLeft);
        break label371;
      }
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = BaseChatItemLayout.paddingLeft;
      break label371;
      paramInt1 = j - i;
      break label434;
    }
    label667:
    label734:
    if (paramViewGroup.a == null)
    {
      localObject2 = new ArkHorizontalListView(this.mContext);
      ((ArkHorizontalListView)localObject2).MIN_SPACE = (BaseChatItemLayout.displayWidth / 4);
      ((ArkHorizontalListView)localObject2).setDividerWidth(i);
      paramChatMessage = new adrd(this.mContext, this.sessionInfo, (ArkHorizontalListView)localObject2, paramwlz);
      ((ArkHorizontalListView)localObject2).setAdapter(paramChatMessage);
      paramViewGroup.a = ((ArkHorizontalListView)localObject2);
      paramViewGroup.a.setTag(localMessageForArkApp);
      paramView.addView(paramViewGroup.a, 0, (ViewGroup.LayoutParams)localObject1);
      paramViewGroup.a.setIsSend(bool);
      paramChatMessage.hB(paramInt1, paramInt2);
      paramViewGroup.msg = localMessageForArkApp.msg;
      paramInt2 = localMessageForArkApp.getMsgArkAppCount();
      paramChatMessage.Ls(paramChatMessage.getDataCount() - paramInt2);
      paramInt1 = 0;
      label872:
      if (paramInt1 >= paramInt2) {
        break label954;
      }
      paramwlz = localMessageForArkApp.getMsgArkAppByPosition(paramInt1);
      if ((MessageForArkApp)paramChatMessage.b(paramInt1) != null) {
        break label944;
      }
      paramChatMessage.a(paramwlz);
    }
    for (;;)
    {
      paramInt1 += 1;
      break label872;
      paramViewGroup.a.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramViewGroup.a.setTag(localMessageForArkApp);
      paramChatMessage = (adrd)paramViewGroup.a.getAdapter();
      break;
      label944:
      paramChatMessage.b(paramInt1, paramwlz);
    }
    label954:
    a(paramViewGroup, localMessageForArkApp);
    return paramView;
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new wzo.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131367523)
    {
      paramChatMessage = (MessageForArkApp)paramChatMessage;
      if ((paramChatMessage != null) && (paramChatMessage.ark_app_message != null)) {}
    }
    for (;;)
    {
      return;
      Object localObject = (MessageForArkApp)adqq.a(1, paramChatMessage.ark_app_message.appName, paramChatMessage, paramChatMessage);
      if (localObject == null) {}
      while ((paramChatMessage != null) && (paramChatMessage.ark_app_message != null))
      {
        paramInt = paramChatMessage.getMsgArkAppCount();
        localObject = new Intent();
        if (paramInt == 1)
        {
          paramContext = aqjn.a.a(paramChatMessage.ark_app_message.appName, paramChatMessage.ark_app_message.appView, paramChatMessage.ark_app_message.appMinVersion, paramChatMessage.ark_app_message.metaList, paramContext.getResources().getDisplayMetrics().scaledDensity, null, null);
          ((Intent)localObject).putExtra("is_ark_display_share", true);
        }
        for (;;)
        {
          paramContext.putInt("forward_type", 27);
          paramContext.putString("forward_ark_app_name", paramChatMessage.ark_app_message.appName);
          paramContext.putString("forward_ark_app_view", paramChatMessage.ark_app_message.appView);
          paramContext.putString("forward_ark_app_ver", paramChatMessage.ark_app_message.appMinVersion);
          paramContext.putString("forward_ark_app_prompt", paramChatMessage.ark_app_message.promptText);
          paramContext.putString("forward_ark_app_config", paramChatMessage.ark_app_message.config);
          paramContext.putString("forward_ark_app_desc", paramChatMessage.ark_app_message.appDesc);
          paramContext.putString("forward_ark_app_compat", paramChatMessage.ark_app_message.compatibleText);
          paramContext.putString("forward_ark_app_meta", paramChatMessage.ark_app_message.metaList);
          paramContext.putString("forward_ark_app_text", paramChatMessage.ark_app_message.mText);
          paramContext.putString("forward_ark_app_list", a(paramChatMessage.ark_app_message));
          paramContext.putString("forward_appId_ark_from_sdk", paramChatMessage.ark_app_message.appId);
          paramContext.putString("struct_share_key_source_name", paramChatMessage.ark_app_message.mSourceName);
          paramContext.putString("struct_share_key_source_action_data", paramChatMessage.ark_app_message.mSourceActionData);
          paramContext.putString("struct_share_key_source_a_action_data", paramChatMessage.ark_app_message.mSource_A_ActionData);
          paramContext.putString("struct_share_key_source_url", paramChatMessage.ark_app_message.mSourceUrl);
          paramContext.putInt("selection_mode", this.bOY);
          ((Intent)localObject).putExtras(paramContext);
          ahgq.f((Activity)this.mContext, (Intent)localObject, 21);
          return;
          paramContext = new Bundle();
        }
        super.a(paramInt, paramContext, paramChatMessage);
        return;
        paramChatMessage = (ChatMessage)localObject;
      }
    }
  }
  
  public aqob[] a(View paramView)
  {
    int i = 0;
    int k = 1;
    boolean bool = true;
    aqoa localaqoa = new aqoa();
    paramView = (wko.a)wja.a(paramView);
    if (paramView != null)
    {
      paramView = (MessageForArkApp)paramView.mMessage;
      if ((paramView != null) && (paramView.ark_app_message != null))
      {
        if (MessageForArkApp.isAllowedArkForward(false, paramView)) {
          localaqoa.Z(2131367523, this.mContext.getString(2131721067), 2130839086);
        }
        if (paramView.isMultiMsg) {
          return localaqoa.a();
        }
        if (!TextUtils.isEmpty(paramView.ark_app_message.appName)) {
          i = 1;
        }
        int j = k;
        if (paramView.extraflag != 32768)
        {
          j = k;
          if (!this.app.a().aR(paramView))
          {
            j = k;
            if (i == 0)
            {
              Boolean localBoolean = (Boolean)adqq.a(3, paramView.ark_app_message.appName, paramView, Boolean.valueOf(true));
              if (localBoolean != null) {
                bool = localBoolean.booleanValue();
              }
              j = bool;
              if (bool)
              {
                a(localaqoa, this.sessionInfo.cZ, paramView);
                j = bool;
              }
            }
          }
        }
        if (j != 0) {
          a(localaqoa, paramView);
        }
        for (;;)
        {
          super.c(localaqoa, this.mContext);
          super.e(localaqoa, this.mContext);
          return localaqoa.a();
          ujt.a(localaqoa, this.mContext, this.sessionInfo.cZ);
        }
      }
    }
    ujt.a(localaqoa, this.mContext, this.sessionInfo.cZ);
    super.c(localaqoa, this.mContext);
    super.e(localaqoa, this.mContext);
    return localaqoa.a();
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    return ((MessageForArkApp)paramChatMessage).compatibleMsg;
  }
  
  public static class a
    extends xov.a
  {
    public ArkHorizontalListView a;
    public String msg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wzo
 * JD-Core Version:    0.7.0.1
 */