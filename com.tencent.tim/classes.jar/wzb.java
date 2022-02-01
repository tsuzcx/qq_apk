import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.a;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkApp.ArkReportData;
import com.tencent.mobileqq.data.MessageForArkApp.Size;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class wzb
  extends BaseBubbleBuilder
  implements BaseChatItemLayout.a
{
  private static final int bSu = BaseChatItemLayout.bNV;
  private static final int bSv = BaseChatItemLayout.bNW;
  private static final int bSw = BaseChatItemLayout.bNY;
  private int bSx;
  private int bSy;
  private SessionInfo mSessionInfo;
  private List<MessageForArkApp> rZ = new ArrayList();
  
  public wzb(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.mSessionInfo = paramSessionInfo;
  }
  
  private void a(MessageForArkApp paramMessageForArkApp)
  {
    if (!this.rZ.contains(paramMessageForArkApp))
    {
      paramMessageForArkApp.report(0);
      this.rZ.add(paramMessageForArkApp);
    }
  }
  
  private boolean a(MessageForArkApp paramMessageForArkApp)
  {
    if (!ahjz.d(paramMessageForArkApp))
    {
      QLog.d("ArkAppItemBubbleBuilder", 1, "showForbidShareDialog false");
      return false;
    }
    paramMessageForArkApp = paramMessageForArkApp.getExtInfoFromExtStr(anbb.cdg);
    QLog.d("ArkAppItemBubbleBuilder", 1, new Object[] { "resend forbid msg wording=", paramMessageForArkApp });
    aqju localaqju = aqha.a(this.mContext, 230);
    localaqju.setMessage(paramMessageForArkApp);
    localaqju.setPositiveButton(2131721079, new wzf(this));
    try
    {
      localaqju.show();
      return true;
    }
    catch (Exception paramMessageForArkApp)
    {
      for (;;)
      {
        QLog.e("ArkAppItemBubbleBuilder", 1, "Exception", paramMessageForArkApp);
      }
    }
  }
  
  private void b(MessageForArkApp paramMessageForArkApp)
  {
    if ((paramMessageForArkApp == null) || (paramMessageForArkApp.ark_app_message == null) || (TextUtils.isEmpty(paramMessageForArkApp.ark_app_message.metaList))) {
      return;
    }
    ArkAppMessage localArkAppMessage = paramMessageForArkApp.ark_app_message;
    Object localObject;
    if ("com.tencent.giftmall.giftark".equals(localArkAppMessage.appName))
    {
      localObject = localArkAppMessage.metaList;
      if (!paramMessageForArkApp.isSend()) {
        break label171;
      }
    }
    label171:
    for (int i = 1;; i = 0)
    {
      localArkAppMessage.metaList = ((String)localObject).replace("#sender#", String.valueOf(i)).replace("#msgId#", String.valueOf(paramMessageForArkApp.uniseq));
      localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (localObject != null) {
        ((alsg)((QQAppInterface)localObject).getManager(312)).OM(localArkAppMessage.metaList);
      }
      QLog.i("ArkAppItemBubbleBuilder", 1, "debugArkMeta = " + localArkAppMessage.metaList + " id = " + paramMessageForArkApp.msgtype + " _ " + paramMessageForArkApp.msgseq);
      return;
    }
  }
  
  private boolean b(MessageForArkApp paramMessageForArkApp)
  {
    if (paramMessageForArkApp == null) {}
    while ((!"com.tencent.test.troopapp".equals(paramMessageForArkApp.ark_app_message.appName)) && (!"com.tencent.troopapp".equals(paramMessageForArkApp.ark_app_message.appName))) {
      return false;
    }
    return true;
  }
  
  private void y(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      paramView.bottomMargin = MessageForArkApp.dp2px(55.0F);
      if (paramBoolean)
      {
        paramView.addRule(0, 2131364503);
        paramView.addRule(1, 0);
      }
    }
    else
    {
      return;
    }
    paramView.addRule(1, 2131364503);
    paramView.addRule(0, 0);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    paramBaseChatItemLayout.setHeadIconVisible(true);
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    ArkAppMessage.Config localConfig = new ArkAppMessage.Config();
    localConfig.fromString(localMessageForArkApp.ark_app_message.config);
    if ((localConfig.autoSize != null) && (localConfig.autoSize.intValue() == 1)) {}
    label1176:
    label1182:
    for (boolean bool1 = true;; bool1 = false)
    {
      wzb.a locala = (wzb.a)parame;
      View localView = paramView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(this.mContext).inflate(2131558896, null);
        locala.d = ((ArkAppView)localView.findViewById(2131362952));
        locala.he = ((LinearLayout)localView.findViewById(2131362959));
        locala.sN = ((ImageView)localView.findViewById(2131362958));
        locala.xj = ((TextView)localView.findViewById(2131362960));
        locala.d.setTag(locala);
        locala.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)localView.findViewById(2131370776));
      }
      locala.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      paramView = (RelativeLayout.LayoutParams)locala.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getLayoutParams();
      paramView.width = adqr.cJd;
      paramView.height = adqr.cJd;
      paramView.setMargins(0, 0, 0, 0);
      locala.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setLayoutParams(paramView);
      localView.findViewById(2131362975).setPadding(0, 0, 0, 0);
      b(localMessageForArkApp);
      if (locala.he != null) {
        locala.he.setVisibility(8);
      }
      if (adrm.a().bU(paramChatMessage.uniseq)) {
        localMessageForArkApp.arkContainer = adrm.a().a();
      }
      if (localMessageForArkApp.arkContainer == null) {
        localMessageForArkApp.arkContainer = new wyv();
      }
      localMessageForArkApp.arkContainer.setSessionInfo(this.mSessionInfo);
      if (QLog.isColorLevel()) {
        QLog.d("ArkAppItemBubbleBuilder", 2, "multiAio.ArkAppItemBubbleBuilder set session info =" + adnq.a(this.mSessionInfo));
      }
      paramView = locala.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
      localMessageForArkApp.arkContainer.a(localMessageForArkApp.ark_app_message.appName, localMessageForArkApp.ark_app_message.appView, localMessageForArkApp.ark_app_message.appMinVersion, localMessageForArkApp.ark_app_message.metaList, adqr.getDensity(), localMessageForArkApp, this.sessionInfo);
      Object localObject1 = new wzc(this, localMessageForArkApp, locala);
      locala.d.setLoadCallback((ArkViewImplement.LoadCallback)localObject1);
      int i = adqr.cJd;
      int k = MessageForArkApp.dp2px(390.0F);
      boolean bool2 = MessageForArkApp.isSetSizeByConfig(localConfig);
      localObject1 = new StringBuilder("isSetSize=");
      ((StringBuilder)localObject1).append(bool2).append(",param=[");
      Object localObject2;
      int j;
      if (bool2)
      {
        localObject2 = MessageForArkApp.limitToSizeRange(adqr.getDensity(), localConfig.width.intValue(), localConfig.height.intValue());
        if (localObject2 != null)
        {
          if (bool1)
          {
            j = i;
            this.bSx = j;
            this.bSy = ((MessageForArkApp.Size)localObject2).height;
            localMessageForArkApp.arkContainer.setFixSize(this.bSx, this.bSy);
            ((StringBuilder)localObject1).append("arkConfig.width=").append(localConfig.width).append(",arkConfig.height=").append(localConfig.height).append("][autoSize=").append(bool1).append(",maxSize=").append(i).append("][size=").append(((MessageForArkApp.Size)localObject2).width).append(",").append(((MessageForArkApp.Size)localObject2).height).append("]").append("],app=").append(localMessageForArkApp.ark_app_message.appName);
          }
        }
        else
        {
          QLog.i("ArkAppItemBubbleBuilder", 1, ((StringBuilder)localObject1).toString());
          adqr.k("ArkAppItemBubbleBuilder.attachArkView", this.mContext);
          j = MessageForArkApp.dp2px(30.0F);
          int m = MessageForArkApp.dp2px(30.0F);
          localMessageForArkApp.arkContainer.setMinSize(j, m);
          localMessageForArkApp.arkContainer.setHintSize(-1, i);
          localMessageForArkApp.arkContainer.fI(i, i);
          localMessageForArkApp.arkContainer.setMaxSize(i, k);
          locala.msg = localMessageForArkApp.msg;
          localObject1 = locala.d;
          localObject2 = locala.d;
          ((ArkViewImplement.ArkViewInterface)localObject1).setClipRadius(16.0F);
          if (!MessageForArkApp.isRectangleBorder(localConfig)) {
            break label1182;
          }
          ((ArkViewImplement.ArkViewInterface)localObject1).setBorderType(0);
          label800:
          if (paramChatMessage.isSend()) {
            break label1193;
          }
        }
      }
      label1056:
      label1193:
      for (bool1 = true;; bool1 = false)
      {
        ((ArkViewImplement.ArkViewInterface)localObject1).setAlignLeft(bool1);
        ((wyw.c)localObject2).a(localMessageForArkApp.arkContainer, paramView);
        ((ArkViewImplement.ArkViewInterface)localObject1).setOnTouchListener(paramwlz);
        ((ArkViewImplement.ArkViewInterface)localObject1).setOnLongClickListener(paramwlz);
        if (paramView != null)
        {
          paramView.setOnTouchListener(paramwlz);
          paramView.setOnLongClickListener(paramwlz);
        }
        if (aTl)
        {
          paramView = new StringBuilder();
          if ((locala.E != null) && (locala.E.length() > 0)) {
            paramView.append(locala.E);
          }
          paramView.append(b(localMessageForArkApp));
          localView.setContentDescription(paramView);
          ((ArkViewImplement.ArkViewInterface)localObject1).setContentDescription(paramView);
          ArkAppCenter.o("ArkAppItemBubbleBuilder", "Type is normal, and talkbackText is " + paramView);
        }
        adtu.e(localMessageForArkApp);
        if (paramBaseChatItemLayout.sc != null) {
          y(paramBaseChatItemLayout.sc, localMessageForArkApp.isSend());
        }
        if (paramBaseChatItemLayout.mProgress != null) {
          y(paramBaseChatItemLayout.mProgress, localMessageForArkApp.isSend());
        }
        ApolloUtil.a(this.app, this.sessionInfo, paramChatMessage, parame.pos, parame.count);
        a(localMessageForArkApp);
        return localView;
        j = ((MessageForArkApp.Size)localObject2).width;
        break;
        if (bool1)
        {
          j = i;
          this.bSx = j;
          this.bSy = -1;
          localObject2 = localMessageForArkApp.arkContainer;
          if (!bool1) {
            break label1176;
          }
        }
        for (j = i;; j = -1)
        {
          ((wyv)localObject2).setFixSize(j, -1);
          ((StringBuilder)localObject1).append("arkConfig.width=").append(localConfig.width).append(",arkConfig.height=").append(localConfig.height).append("][autoSize=").append(bool1).append(",maxSize=").append(i).append("]").append(",app=").append(localMessageForArkApp.ark_app_message.appName);
          break;
          j = -1;
          break label1056;
        }
        ((ArkViewImplement.ArkViewInterface)localObject1).setBorderType(1);
        break label800;
      }
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
      paramInt = paramContext.getMsgArkAppCount();
      Intent localIntent = new Intent();
      if (paramInt == 1)
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
        return;
        paramChatMessage = new Bundle();
      }
      ujt.b(this.mContext, this.app, paramChatMessage);
      return;
      super.j(paramChatMessage);
      return;
      super.m(paramChatMessage);
      return;
      aviz.a(this.app, this.mContext, paramChatMessage);
      return;
      paramContext = paramChatMessage;
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.mContext.getResources().getDimensionPixelSize(2131296408);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(bSw, bSu, i, bSv);
      return;
    }
    paramView.setPadding(i, bSu, bSw, bSv);
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
  
  public boolean a(BaseBubbleBuilder.e parame)
  {
    return parame instanceof wzb.a;
  }
  
  public aqob[] a(View paramView)
  {
    int j = 0;
    int m = 1;
    boolean bool = true;
    aqoa localaqoa = new aqoa();
    paramView = (wko.a)wja.a(paramView);
    if ((this.sessionInfo != null) && (this.sessionInfo.cZ == 10007)) {
      return localaqoa.a();
    }
    if (paramView != null)
    {
      paramView = (MessageForArkApp)paramView.mMessage;
      if ((paramView != null) && (paramView.ark_app_message != null))
      {
        if ((MessageForArkApp.isAllowedArkForward(false, paramView)) && (!b(paramView))) {
          localaqoa.Z(2131367523, this.mContext.getString(2131721067), 2130839086);
        }
        if (paramView.isMultiMsg) {
          return localaqoa.a();
        }
        int i = j;
        if (!TextUtils.isEmpty(paramView.ark_app_message.appName))
        {
          i = j;
          if (b(paramView)) {
            i = 1;
          }
        }
        int k = m;
        if (paramView.extraflag != 32768)
        {
          k = m;
          if (!this.app.a().aR(paramView))
          {
            k = m;
            if (i == 0)
            {
              Boolean localBoolean = (Boolean)adqq.a(3, paramView.ark_app_message.appName, paramView, Boolean.valueOf(true));
              if (localBoolean != null) {
                bool = localBoolean.booleanValue();
              }
              k = bool;
              if (bool)
              {
                a(localaqoa, this.sessionInfo.cZ, paramView);
                k = bool;
              }
            }
          }
        }
        if (k != 0) {
          a(localaqoa, paramView);
        }
        for (;;)
        {
          super.c(localaqoa, this.mContext);
          try
          {
            if (aejg.a().aS(paramView.ark_app_message.appName, paramView.ark_app_message.appView))
            {
              a(paramView, localaqoa);
              super.b(paramView, localaqoa);
            }
            if (avja.W(paramView)) {
              super.d(localaqoa, this.mContext);
            }
            super.a(localaqoa, this.mContext, paramView);
            super.e(localaqoa, this.mContext);
            return localaqoa.a();
            ujt.a(localaqoa, this.mContext, this.sessionInfo.cZ);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.d("ArkAppItemBubbleBuilder", 2, "add reply menu error, exception =" + localException.getMessage());
            }
          }
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
    } while ((!paramView.isSendFromLocal()) || (a(paramView)));
    aqha.a(this.mContext, 230, str1, str2, new wzd(this, paramView), new wze(this)).show();
  }
  
  public void p(ChatMessage paramChatMessage)
  {
    anot.a(this.app, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "6", "", "", "");
  }
  
  public static class a
    extends BaseBubbleBuilder.e
  {
    public TextView IS;
    public ArkAppLoadLayout a;
    public ArkAppView d;
    public LinearLayout he;
    public String msg;
    public ImageView sN;
    public TextView xj;
    
    public void a(a parama, adpg paramadpg)
    {
      Object localObject2 = paramadpg.getArkAppNameAndPath();
      String str = localObject2[0];
      Object localObject1 = localObject2[1];
      localObject2 = localObject2[2];
      paramadpg.clickTail(null, parama, this.d.getContext());
      if (localObject1 != null)
      {
        ArkAppCacheMgr.getAppIcon(str, new wzg(this, parama));
        paramadpg = ArkAppCacheMgr.getApplicationDesc(str);
        if (paramadpg != null)
        {
          this.he.setVisibility(0);
          parama.xj.setVisibility(0);
          parama.xj.setText(paramadpg);
        }
      }
      while ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime() == null) {
        return;
      }
      ArkAppMgr.getInstance().getAppPathByName(str, (String)localObject2, "0.0.0.1", null, new wzh(this, str, parama));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wzb
 * JD-Core Version:    0.7.0.1
 */