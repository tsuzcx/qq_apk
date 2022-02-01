import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class wzj
  extends BaseBubbleBuilder
{
  private int bSz;
  private SessionInfo mSessionInfo;
  
  public wzj(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.mSessionInfo = paramSessionInfo;
  }
  
  private String a(MessageForArkApp paramMessageForArkApp)
  {
    String str2 = "";
    String str1 = str2;
    if (paramMessageForArkApp != null)
    {
      paramMessageForArkApp = paramMessageForArkApp.ark_app_message;
      str1 = str2;
      if (paramMessageForArkApp != null) {
        str1 = paramMessageForArkApp.mSourceAd;
      }
    }
    return str1;
  }
  
  private boolean hK(String paramString)
  {
    String str = "";
    if (aqmr.isEmpty(paramString)) {
      return false;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = str;
      if (localJSONObject != null) {
        paramString = localJSONObject.optString("from");
      }
      return "gw".equals(paramString);
    }
    catch (JSONException paramString) {}
    return false;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    if ((BaseChatItemLayout.widthPixels > BaseChatItemLayout.heightPixels) && (QLog.isColorLevel())) {
      QLog.e("ArkAppItemBuilder", 2, String.format(Locale.CHINA, "widthPixels > heightPixels: (%d, %d)", new Object[] { Integer.valueOf(BaseChatItemLayout.widthPixels), Integer.valueOf(BaseChatItemLayout.heightPixels) }));
    }
    paramBaseChatItemLayout.setProgressVisable(false);
    paramBaseChatItemLayout.setFailedIconVisable(false, null);
    paramBaseChatItemLayout.setHeadIconVisible(false);
    paramBaseChatItemLayout.setNetIconVisible(false);
    paramBaseChatItemLayout.setTroopMemberLevel(this.app, false, null, false, -1, -1);
    paramBaseChatItemLayout.setPadding(0, 0, 0, 0);
    this.bSz = (adqr.cJg - BaseChatItemLayout.paddingLeft - BaseChatItemLayout.paddingRight);
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    QLog.i("ArkAppItemBuilder", 1, "ArkFold.ArkAppCenterUtil.sRealDisplayWith=" + adqr.cJg + ",arkAppWidth=" + this.bSz + ",app=" + localMessageForArkApp.ark_app_message.appName);
    wzb.a locala = (wzb.a)parame;
    Object localObject = a(localMessageForArkApp);
    parame = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131558896, null);
      locala.d = ((ArkAppView)paramView.findViewById(2131362952));
      locala.he = ((LinearLayout)paramView.findViewById(2131362959));
      locala.sN = ((ImageView)paramView.findViewById(2131362958));
      locala.xj = ((TextView)paramView.findViewById(2131362960));
      locala.d.setTag(locala);
      locala.a = ((ArkAppLoadLayout)paramView.findViewById(2131370776));
      parame = paramView;
      if (hK((String)localObject))
      {
        locala.IS = new TextView(this.mContext);
        parame = paramView;
      }
    }
    int i = (int)this.mContext.getResources().getDimension(2131296449);
    int j = (int)this.mContext.getResources().getDimension(2131296401);
    int k = (int)this.mContext.getResources().getDimension(2131296450);
    int m = (int)this.mContext.getResources().getDimension(2131296400);
    paramView = (RelativeLayout)parame.findViewById(2131362975);
    ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).addRule(14);
    paramView.setPadding(i, j, k, m);
    if (locala.IS != null)
    {
      if (!new kdv().a(this.mContext, localMessageForArkApp, locala.IS, (String)localObject)) {
        break label1026;
      }
      paramView.removeView(locala.IS);
      paramView.addView(locala.IS);
      paramView = (RelativeLayout.LayoutParams)locala.IS.getLayoutParams();
      paramView.topMargin = rpq.dip2px(this.mContext, 10.0F);
      paramView.height = -2;
      paramView.width = -2;
      paramView.addRule(3, 2131362952);
    }
    for (;;)
    {
      if ((localMessageForArkApp != null) && (localMessageForArkApp.ark_app_message != null))
      {
        paramView = localMessageForArkApp.ark_app_message.config;
        if (!aqmr.isEmpty(paramView))
        {
          localObject = new ArkAppMessage.Config();
          ((ArkAppMessage.Config)localObject).fromString(paramView);
          if ((((ArkAppMessage.Config)localObject).fitWidthAndCentered.intValue() == 1) && ((parame instanceof ArkAppRootLayout)))
          {
            paramView = (RelativeLayout.LayoutParams)parame.getLayoutParams();
            if (paramView != null) {
              paramView.addRule(14);
            }
          }
        }
      }
      paramView = (RelativeLayout.LayoutParams)locala.a.getLayoutParams();
      paramView.addRule(14);
      paramView.width = this.bSz;
      paramView.setMargins(i, j, k, m);
      locala.a.setLayoutParams(paramView);
      if (locala.he != null) {
        locala.he.setVisibility(8);
      }
      paramView = new wzk(this, localMessageForArkApp, locala);
      locala.d.setLoadCallback(paramView);
      if (adrm.a().bU(paramChatMessage.uniseq)) {
        localMessageForArkApp.arkContainer = adrm.a().a();
      }
      if (localMessageForArkApp.arkContainer == null) {
        localMessageForArkApp.arkContainer = new wyv();
      }
      localMessageForArkApp.arkContainer.setSessionInfo(this.mSessionInfo);
      if (QLog.isColorLevel()) {
        QLog.d("ArkAppItemBuilder", 2, new Object[] { "multiAio.ArkAppItemBuilder set session info =", adnq.a(this.mSessionInfo) });
      }
      localMessageForArkApp.arkContainer.a(localMessageForArkApp.ark_app_message.appName, localMessageForArkApp.ark_app_message.appView, localMessageForArkApp.ark_app_message.appMinVersion, localMessageForArkApp.ark_app_message.metaList, adqr.getDensity(), localMessageForArkApp, this.sessionInfo);
      i = wja.dp2px(352.0F, paramBaseChatItemLayout.getResources());
      localMessageForArkApp.arkContainer.setFixSize(this.bSz, -1);
      localMessageForArkApp.arkContainer.setMaxSize(this.bSz, -1);
      localMessageForArkApp.arkContainer.setHintSize(-1, i);
      localMessageForArkApp.arkContainer.fI(this.bSz, i);
      locala.msg = localMessageForArkApp.msg;
      paramView = locala.a;
      paramBaseChatItemLayout = locala.d;
      localObject = locala.d;
      paramBaseChatItemLayout.setClipRadius(16.0F);
      ((wyw.c)localObject).a(localMessageForArkApp.arkContainer, paramView);
      paramBaseChatItemLayout.setOnTouchListener(paramwlz);
      paramBaseChatItemLayout.setOnLongClickListener(paramwlz);
      if (paramView != null)
      {
        paramView.setOnTouchListener(paramwlz);
        paramView.setOnLongClickListener(paramwlz);
      }
      if ((this.sessionInfo.cZ == 1008) && (!this.aA.contains(Long.valueOf(paramChatMessage.uniseq))))
      {
        this.aA.add(Long.valueOf(paramChatMessage.uniseq));
        adak.a(117, paramChatMessage, locala.pos);
      }
      return parame;
      label1026:
      paramView.removeView(locala.IS);
    }
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new wzb.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    case 2131367523: 
      do
      {
        return;
        paramContext = (MessageForArkApp)paramChatMessage;
      } while ((paramContext == null) || (paramContext.ark_app_message == null));
      paramChatMessage = (MessageForArkApp)adqq.a(1, paramContext.ark_app_message.appName, paramContext, paramContext);
      if (paramChatMessage != null) {
        break;
      }
    }
    while ((paramContext != null) && (paramContext.ark_app_message != null))
    {
      new Bundle();
      paramChatMessage = aqjn.a.a(paramContext.ark_app_message.appName, paramContext.ark_app_message.appView, paramContext.ark_app_message.appMinVersion, paramContext.ark_app_message.metaList, adqr.getDensity(), null, null);
      paramChatMessage.putInt("forward_type", 27);
      paramChatMessage.putString("forward_ark_app_name", paramContext.ark_app_message.appName);
      paramChatMessage.putString("forward_ark_app_view", paramContext.ark_app_message.appView);
      paramChatMessage.putString("forward_ark_app_ver", paramContext.ark_app_message.appMinVersion);
      paramChatMessage.putString("forward_ark_app_prompt", paramContext.ark_app_message.promptText);
      paramChatMessage.putString("forward_ark_app_config", paramContext.ark_app_message.config);
      paramChatMessage.putString("forward_ark_app_desc", paramContext.ark_app_message.appDesc);
      paramChatMessage.putString("forward_ark_app_compat", paramContext.ark_app_message.compatibleText);
      paramChatMessage.putString("forward_ark_app_meta", paramContext.ark_app_message.metaList);
      paramChatMessage.putInt("selection_mode", this.bOY);
      paramChatMessage.putInt("forward_source_uin_type", this.sessionInfo.cZ);
      paramContext = new Intent();
      paramContext.putExtras(paramChatMessage);
      paramContext.putExtra("is_ark_display_share", true);
      ahgq.f((Activity)this.mContext, paramContext, 21);
      return;
      ujt.b(this.mContext, this.app, paramChatMessage);
      return;
      paramContext = paramChatMessage;
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, 0, 0);
  }
  
  public aqob[] a(View paramView)
  {
    aqoa localaqoa = new aqoa();
    paramView = (wko.a)wja.a(paramView);
    if (paramView != null)
    {
      paramView = (MessageForArkApp)paramView.mMessage;
      if (MessageForArkApp.isAllowedArkForward(true, paramView)) {
        localaqoa.Z(2131367523, this.mContext.getString(2131721067), 2130839086);
      }
      if (paramView.isMultiMsg) {
        return localaqoa.a();
      }
    }
    localaqoa.Z(2131365686, this.mContext.getString(2131691404), 2130839081);
    e(localaqoa, this.mContext);
    return localaqoa.a();
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wzj
 * JD-Core Version:    0.7.0.1
 */