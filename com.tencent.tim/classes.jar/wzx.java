import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.flashchat.FlashChatPanel;
import com.tencent.qphone.base.util.QLog;

public class wzx
  extends BaseBubbleBuilder
{
  private static final int bSu = BaseChatItemLayout.bNV;
  private static final int bSv = BaseChatItemLayout.bNW;
  private static final int bSw = BaseChatItemLayout.bNY;
  protected View.OnClickListener mSourceOnClickListener = new xaa(this);
  
  public wzx(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public static String p(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = new StringBuilder(paramString);
    int k = paramString.length();
    int i = 0;
    if (i < k)
    {
      int j = i;
      if ('\024' == paramString.charAt(i))
      {
        j = i;
        if (i + 1 < k)
        {
          j = i;
          if ('ÿ' == paramString.charAt(i + 1))
          {
            j = i;
            if (i + 2 < k)
            {
              if (!paramBoolean) {
                break label116;
              }
              if (paramString.charAt(i + 2) == '\024') {
                paramString.setCharAt(i + 2, 'ý');
              }
            }
          }
        }
      }
      for (;;)
      {
        j = i + 4;
        i = j + 1;
        break;
        label116:
        if (paramString.charAt(i + 2) == 'ý') {
          paramString.setCharAt(i + 2, '\024');
        }
      }
    }
    return paramString.toString();
  }
  
  protected static final String[] parsePackageNameAndData(String paramString1, String paramString2)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    if (TextUtils.isEmpty(paramString2)) {
      if (!TextUtils.isEmpty(paramString1)) {
        break label47;
      }
    }
    label47:
    for (int i = -1;; i = paramString1.indexOf("://"))
    {
      if (i != -1) {
        break label57;
      }
      arrayOfString[0] = paramString1;
      return arrayOfString;
      paramString1 = paramString2;
      break;
    }
    label57:
    arrayOfString[0] = paramString1.substring(0, i);
    arrayOfString[1] = paramString1.substring(i + 3);
    return arrayOfString;
  }
  
  protected void A(ChatMessage paramChatMessage)
  {
    paramChatMessage.msg = p(paramChatMessage.msg, true);
    aviz.a(null, paramChatMessage.msg).b(this.app, paramChatMessage).b((Activity)this.mContext, this.app.getAccount());
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, wlz paramwlz)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramwlz);
    paramViewGroup = (BaseChatItemLayout)paramView;
    paramChatMessage = (MessageForArkFlashChat)paramChatMessage;
    paramChatMessage = (RelativeLayout)paramViewGroup.findViewById(2131378837);
    "com.tencent.mobileqq".equals(this.mContext.getPackageName());
    paramwlz = ((FlashChatManager)this.app.getManager(217)).a;
    if (paramChatMessage != null) {
      paramViewGroup.removeView(paramChatMessage);
    }
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "ArkFlashChatItemBubbleBuilder getBubbleView");
    }
    paramBaseChatItemLayout = (MessageForArkFlashChat)paramChatMessage;
    wzx.a locala;
    Object localObject;
    boolean bool;
    label359:
    int i;
    if (paramBaseChatItemLayout.arkContainer == null)
    {
      paramBaseChatItemLayout.arkContainer = new ArkFlashChatContainerWrapper();
      float f = this.mContext.getResources().getDisplayMetrics().scaledDensity;
      locala = (wzx.a)parame;
      parame = paramView;
      if (paramView == null)
      {
        parame = LayoutInflater.from(this.mContext).inflate(2131558897, null);
        paramView = parame.findViewById(2131362975);
        localObject = (ArkAppLoadLayout)parame.findViewById(2131370776);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((ArkAppLoadLayout)localObject).getLayoutParams();
        localLayoutParams.width = ((int)FlashChatPanel.bd());
        localLayoutParams.height = ((int)FlashChatPanel.be());
        ((ArkAppLoadLayout)localObject).setLayoutParams(localLayoutParams);
        localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
        localLayoutParams.width = ((int)FlashChatPanel.bd());
        localLayoutParams.height = ((int)FlashChatPanel.be());
        paramView.setLayoutParams(localLayoutParams);
        locala.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)localObject);
        locala.wD = locala.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.findViewById(2131367125);
        locala.IT = ((TextView)locala.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.findViewById(2131367126));
        locala.uO = locala.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.findViewById(2131370787);
        locala.d = ((ArkAppView)parame.findViewById(2131362952));
        locala.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar = ((AutoStartProgressBar)parame.findViewById(2131378031));
        locala.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setRadius(15.0F, true);
        locala.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setShowCorner(false);
        locala.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(0);
        paramView = (RelativeLayout.LayoutParams)locala.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.getLayoutParams();
        paramView.width = ((int)FlashChatPanel.bd());
        paramView.height = ((int)FlashChatPanel.be());
        paramView.leftMargin = 0;
        locala.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setLayoutParams(paramView);
      }
      paramChatMessage.isSend();
      paramView = locala.d;
      paramView.setClipRadius(16.0F);
      paramView.setBorderType(1);
      if (paramChatMessage.isSend()) {
        break label895;
      }
      bool = true;
      paramView.setAlignLeft(bool);
      paramChatMessage = locala.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
      localObject = this.app.b().a(this.sessionInfo.aTl, this.sessionInfo.cZ);
      if (paramBaseChatItemLayout.uniseq != ((QQMessageFacade.Message)localObject).uniseq) {
        break label901;
      }
      i = 1;
      label414:
      bool = false;
      localObject = (FlashChatManager)this.app.getManager(217);
      if (i != 0)
      {
        if ((paramBaseChatItemLayout.isread) && (!((FlashChatManager)localObject).a(paramBaseChatItemLayout))) {
          break label907;
        }
        bool = true;
      }
      label458:
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "testMyStopAnimLogic " + bool + " " + paramBaseChatItemLayout.uniseq + " " + paramBaseChatItemLayout.getSummery() + " " + paramBaseChatItemLayout.isread + ", " + ((FlashChatManager)localObject).a(paramBaseChatItemLayout));
      }
      if (!bool) {
        break label913;
      }
      ((FlashChatManager)localObject).b(paramBaseChatItemLayout);
      ((FlashChatManager)localObject).a(null);
    }
    label567:
    label951:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "testMyStopAnimLogic " + bool + " " + paramBaseChatItemLayout.uniseq + " " + paramBaseChatItemLayout.getSummery());
      }
      long l = paramBaseChatItemLayout.uniseq;
      paramBaseChatItemLayout.arkContainer.a(this.app, this.mContext, paramBaseChatItemLayout.ark_app_message.appName, paramBaseChatItemLayout.ark_app_message.appView, paramBaseChatItemLayout.ark_app_message.appMinVersion, paramBaseChatItemLayout.ark_app_message.appResId, paramBaseChatItemLayout.ark_app_message.getMeta(l, false), adqr.getDensity(), this.sessionInfo, FlashChatPanel.bd(), FlashChatPanel.be(), FlashChatPanel.bd(), FlashChatPanel.be(), paramBaseChatItemLayout);
      paramBaseChatItemLayout.setupSendLoading(locala.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar);
      if (bool) {
        paramView.setCallback(new wzy(this, paramBaseChatItemLayout));
      }
      for (;;)
      {
        paramView.a(paramBaseChatItemLayout.arkContainer, paramChatMessage);
        locala.msg = paramBaseChatItemLayout.msg;
        paramView.setTag(locala);
        paramView.setOnTouchListener(paramwlz);
        paramView.setOnLongClickListener(paramwlz);
        if (paramChatMessage != null)
        {
          paramChatMessage.setOnTouchListener(paramwlz);
          paramChatMessage.setOnLongClickListener(paramwlz);
        }
        locala.E = parame;
        locala.wD.setVisibility(8);
        locala.uO.setVisibility(0);
        locala.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(8);
        locala.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.bwe();
        locala.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setBkgColorNormal(ArkAppLoadLayout.bSB);
        if (aTl) {
          paramView.setContentDescription(paramBaseChatItemLayout.ark_app_message.promptText);
        }
        return parame;
        if (!paramBaseChatItemLayout.arkContainer.isLoadFailed()) {
          break;
        }
        paramBaseChatItemLayout.arkContainer.reinitArkContainer();
        break;
        label895:
        bool = false;
        break label359;
        i = 0;
        break label414;
        bool = false;
        break label458;
        if ((i == 0) || (!((FlashChatManager)localObject).b(paramBaseChatItemLayout))) {
          break label951;
        }
        bool = true;
        break label567;
        paramView.setCallback(new wzz(this, paramBaseChatItemLayout));
      }
    }
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new wzx.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    case 2131365509: 
    case 2131366733: 
    case 2131367523: 
      do
      {
        do
        {
          do
          {
            return;
          } while (paramChatMessage.msg == null);
          try
          {
            ((ClipboardManager)this.mContext.getSystemService("clipboard")).setText(paramChatMessage.msg);
            return;
          }
          catch (Exception paramContext) {}
        } while (!QLog.isColorLevel());
        QLog.e("ChatItemBuilder", 2, paramContext.toString());
        return;
        A(paramChatMessage);
        return;
        paramChatMessage = (MessageForArkFlashChat)paramChatMessage;
      } while ((paramChatMessage == null) || (paramChatMessage.ark_app_message == null));
      paramContext = new Bundle();
      paramContext.putInt("uintype", this.sessionInfo.cZ);
      paramContext.putString("uin", this.sessionInfo.aTl);
      paramContext.putString("troop_uin", this.sessionInfo.troopUin);
      paramContext.putInt("forward_type", 33);
      paramContext.putString("forward_flashchat_rawcontent", paramChatMessage.ark_app_message.toAppXml());
      paramContext.putString("forward_ark_app_prompt", paramChatMessage.ark_app_message.getSummery());
      paramContext.putInt("selection_mode", this.bOY);
      paramContext.putInt("forward_source_uin_type", this.sessionInfo.cZ);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      ahgq.f((Activity)this.mContext, paramChatMessage, 21);
      return;
    case 2131365686: 
      ujt.b(this.mContext, this.app, paramChatMessage);
      return;
    case 2131372030: 
      super.j(paramChatMessage);
      return;
    }
    super.m(paramChatMessage);
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
  
  public boolean a(String paramString1, String paramString2, MessageForArkFlashChat paramMessageForArkFlashChat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "SourceClickHandler clickWebMsg  url = " + paramString1);
    }
    if ((TextUtils.isEmpty(paramString1)) || ((!paramString1.startsWith("http://")) && (!paramString1.startsWith("https://")))) {
      return false;
    }
    Intent localIntent = new Intent(this.mContext, QQBrowserActivity.class);
    localIntent.putExtra("key_isReadModeEnabled", true);
    localIntent.putExtra("title", paramString2);
    localIntent.putExtra("url", paramString1);
    ocp.a(paramMessageForArkFlashChat, localIntent, paramString1);
    this.mContext.startActivity(localIntent);
    anot.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString1, "", "", "");
    return true;
  }
  
  public aqob[] a(View paramView)
  {
    aqoa localaqoa = new aqoa();
    paramView = (wko.a)wja.a(paramView);
    localaqoa.Z(2131365509, acfp.m(2131702810), 2130839077);
    if (paramView != null)
    {
      MessageForArkFlashChat localMessageForArkFlashChat = (MessageForArkFlashChat)paramView.mMessage;
      if ((localMessageForArkFlashChat != null) && (localMessageForArkFlashChat.ark_app_message != null))
      {
        localaqoa.Z(2131367523, this.mContext.getString(2131721067), 2130839086);
        if (localMessageForArkFlashChat.isMultiMsg) {
          return localaqoa.a();
        }
        if (localMessageForArkFlashChat.istroop == 0) {
          a(paramView.mMessage, localaqoa);
        }
        if ((localMessageForArkFlashChat.isSend()) && (localMessageForArkFlashChat.extraflag != 32768) && (!this.app.a().aR(localMessageForArkFlashChat))) {
          a(localaqoa, this.sessionInfo.cZ, localMessageForArkFlashChat);
        }
        a(localaqoa, localMessageForArkFlashChat);
        super.c(localaqoa, this.mContext);
        super.a(localaqoa, this.mContext, localMessageForArkFlashChat);
        super.e(localaqoa, this.mContext);
        return localaqoa.a();
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
    if ((paramChatMessage instanceof MessageForArkFlashChat))
    {
      paramChatMessage = (MessageForArkFlashChat)paramChatMessage;
      return acfp.m(2131702812) + paramChatMessage.ark_app_message.promptText;
    }
    return acfp.m(2131702811) + paramChatMessage.msg;
  }
  
  public void ei(View paramView)
  {
    super.ei(paramView);
    paramView = (MessageForArkFlashChat)wja.a(paramView);
    if (paramView == null) {}
    String str1;
    String str2;
    do
    {
      return;
      str1 = this.mContext.getString(2131690230);
      str2 = this.mContext.getString(2131690231);
    } while (!paramView.isSendFromLocal());
    aqha.a(this.mContext, 230, str1, str2, new xab(this, paramView), new xac(this)).show();
  }
  
  public boolean j(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "SourceClickHandler clickAppMsg url = " + paramString1 + ", actionData = " + paramString2 + ", actionDataA = " + paramString3);
    }
    paramString1 = parsePackageNameAndData(paramString2, paramString3);
    paramString2 = this.mContext.getPackageManager();
    try
    {
      if (paramString2.getPackageInfo(paramString1[0], 1) != null)
      {
        paramString2 = paramString2.getLaunchIntentForPackage(paramString1[0]);
        if (paramString2 == null) {
          return false;
        }
        paramString2.addFlags(67108864);
        if (!TextUtils.isEmpty(paramString1[1])) {
          paramString2.setData(Uri.parse(paramString1[1]));
        }
        try
        {
          ((acly)this.app.getBusinessHandler(23)).b(paramString1[0].trim(), this.mContext, paramString2);
          return true;
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AppStartedHandler", 2, "<-- StartAppCheckHandler AbsShareMSG Failed!");
            }
            this.mContext.startActivity(paramString2);
          }
        }
      }
      return false;
    }
    catch (PackageManager.NameNotFoundException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, paramString1.getMessage());
      }
    }
  }
  
  public static class a
    extends BaseBubbleBuilder.e
  {
    public TextView IT;
    public AutoStartProgressBar a;
    public ArkAppLoadLayout a;
    public ArkAppView d;
    public String msg;
    public View uO;
    public View wD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wzx
 * JD-Core Version:    0.7.0.1
 */