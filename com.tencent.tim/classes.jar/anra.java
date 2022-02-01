import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tencent.im.babyq.babyq_cookie.BabyQCookie;

public class anra
{
  private static ausj mActionSheet;
  public QQAppInterface mApp;
  protected Context mContext;
  private MessageRecord message;
  
  public anra(QQAppInterface paramQQAppInterface, View paramView)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramView.getContext();
    if ((paramQQAppInterface == null) && (FragmentActivity.class.isInstance(this.mContext)))
    {
      paramQQAppInterface = ((FragmentActivity)this.mContext).getChatFragment();
      if (paramQQAppInterface != null) {
        this.mApp = paramQQAppInterface.a().getApp();
      }
    }
  }
  
  public anra(QQAppInterface paramQQAppInterface, View paramView, MessageRecord paramMessageRecord)
  {
    this(paramQQAppInterface, paramView);
    this.message = paramMessageRecord;
  }
  
  private static void bY(Context paramContext, String paramString)
  {
    if ((mActionSheet == null) || (!mActionSheet.getContext().equals(paramContext)))
    {
      mActionSheet = ausj.b(paramContext);
      mActionSheet.addButton(2131692643, 1);
      mActionSheet.addButton(2131692330, 1);
      mActionSheet.addCancelButton(2131721058);
      mActionSheet.setMainTitle(String.format(paramContext.getString(2131696501), new Object[] { paramString }));
      mActionSheet.a(new anrb(paramString, paramContext));
    }
    if (!mActionSheet.isShowing()) {
      mActionSheet.show();
    }
  }
  
  public boolean a(String paramString, long paramLong, Object... paramVarArgs)
  {
    if (com.tencent.mobileqq.microapp.sdk.MiniAppLauncher.isMiniAppScheme(paramString))
    {
      com.tencent.mobileqq.microapp.sdk.MiniAppLauncher.launchMiniAppByScheme(this.mContext, paramString, 1211);
      return true;
    }
    if (com.tencent.mobileqq.mini.sdk.MiniAppLauncher.isMiniAppUrl(paramString))
    {
      com.tencent.mobileqq.mini.sdk.MiniAppLauncher.startMiniApp(this.mContext, paramString, 1043, null);
      return true;
    }
    if ((TextUtils.isEmpty(paramString)) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))) {
      return false;
    }
    Intent localIntent = new Intent(this.mContext, PublicAccountBrowser.class);
    localIntent.putExtra("key_isReadModeEnabled", true);
    localIntent.putExtra("url", paramString);
    Object localObject;
    if ((this.mContext instanceof FragmentActivity))
    {
      localObject = ((FragmentActivity)this.mContext).getChatFragment();
      if (localObject != null)
      {
        int i = ((ChatFragment)localObject).a().getCurType();
        if (i == 1008)
        {
          String str = ((ChatFragment)localObject).a().oL();
          localIntent.putExtra("puin", str);
          localIntent.putExtra("uin_type", i);
          localIntent.putExtra("msg_id", String.valueOf(paramLong));
          localIntent.putExtra("switch_msg_btn", ocp.GB());
          localIntent.putExtra("articalChannelId", 1);
          localIntent.putExtra("FORCE_BLANK_SCREEN_REPORTE", true);
          localIntent.putExtra("fromOneCLickCLose", true);
          localObject = ocp.fq(str);
          if ((!"3046055438".equals(str)) || (paramVarArgs == null) || (paramVarArgs.length <= 0) || (!(paramVarArgs[0] instanceof Boolean)) || (!((Boolean)paramVarArgs[0]).booleanValue())) {
            break label313;
          }
        }
      }
    }
    label313:
    for (paramVarArgs = "biz_src_ads";; paramVarArgs = (Object[])localObject)
    {
      localIntent.putExtra("big_brother_source_key", paramVarArgs);
      ocp.a(this.message, localIntent, paramString);
      this.mContext.startActivity(localIntent);
      return true;
    }
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      paramString2 = (FragmentActivity)this.mContext;
      if (paramString2.getChatFragment() != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w("StructMsg", 2, "chatfragment is null");
      }
      return true;
      paramString1 = paramString2;
    }
    paramString2 = paramString2.getChatFragment().a().oL();
    kaw.a().a(this.mContext, this.mApp, paramString2, paramString1, false, 0.0D, 0.0D, null, paramInt, paramLong, 2);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, Object... paramVarArgs)
  {
    Object localObject2;
    Object localObject1;
    MessageForStructing localMessageForStructing;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("StructMsgClickHandler doAction action = ").append(paramString1).append(", url = ").append(paramString2).append(", actionData = ").append(paramString3).append(", actionDataA = ").append(paramString4);
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        localObject1 = ", args = " + paramVarArgs[0];
        QLog.d("StructMsg", 2, (String)localObject1);
      }
    }
    else
    {
      if ((this.mContext instanceof FragmentActivity))
      {
        localObject1 = ((FragmentActivity)this.mContext).getChatFragment();
        if (localObject1 != null)
        {
          localObject2 = ((ChatFragment)localObject1).a().oL();
          int i = ((ChatFragment)localObject1).a().getCurType();
          if ((paramString1 != null) && (!paramString1.equals("")) && (i == 1008)) {
            kaw.f(this.mApp, (String)localObject2);
          }
          if (((((ChatFragment)localObject1).a() instanceof ycd)) && ((this.message instanceof MessageForStructing)))
          {
            localMessageForStructing = (MessageForStructing)this.message;
            localObject1 = "";
            if (localMessageForStructing.mExJsonObject != null) {
              localObject1 = localMessageForStructing.mExJsonObject.optString("report_key_bytes_oac_msg_extend");
            }
            if (!(localMessageForStructing.structingMsg instanceof StructMsgForHypertext)) {
              break label337;
            }
            adak.a(this.mApp, (String)localObject2, 0, 2, paramLong, (String)localObject1);
          }
        }
      }
      label267:
      if (!"web".equals(paramString1)) {
        break label416;
      }
      if (paramLong <= 0L) {
        break label406;
      }
    }
    label406:
    for (boolean bool1 = a(paramString2, paramLong, paramVarArgs);; bool1 = clickWebMsg(paramString2))
    {
      boolean bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        if (paramLong > 0L) {
          bool2 = a(paramString2, null, 2, paramLong);
        }
      }
      return bool2;
      localObject1 = "";
      break;
      label337:
      if ((localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)) {
        break label267;
      }
      if ((localMessageForStructing.structingMsg instanceof StructMsgForImageShare))
      {
        adak.a(this.mApp, (String)localObject2, 0, 1, paramLong, (String)localObject1);
        break label267;
      }
      if (!(localMessageForStructing.structingMsg instanceof StructMsgForAudioShare)) {
        break label267;
      }
      adak.a(this.mApp, (String)localObject2, 0, 5, paramLong, (String)localObject1);
      break label267;
    }
    label416:
    if ("app".equals(paramString1)) {
      return j(paramString2, paramString3, paramString4);
    }
    if ("plugin".equals(paramString1))
    {
      if ((TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString2))) {
        return clickPluginMsg(paramString2, null);
      }
      return clickPluginMsg(paramString3, paramString4);
    }
    if ("auto".equals(paramString1)) {
      return pF(paramString2);
    }
    if ("replyMsg".equals(paramString1)) {
      return bH(paramString3, paramString4);
    }
    if ("replyCmd".equals(paramString1))
    {
      if (paramLong == 0L) {
        return bI(paramString3, paramString4);
      }
      return a(paramString3, null, 1, paramLong);
    }
    return false;
  }
  
  public boolean bH(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      localObject = (FragmentActivity)this.mContext;
      if (((FragmentActivity)localObject).getChatFragment() != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w("StructMsg", 2, "chatfragment is null");
      }
      return true;
      paramString1 = paramString2;
    }
    int i = ((FragmentActivity)localObject).getChatFragment().a().getCurType();
    paramString2 = ((FragmentActivity)localObject).getChatFragment().a().oM();
    Object localObject = ((FragmentActivity)localObject).getChatFragment().a().oL();
    Intent localIntent = wja.a(new Intent(this.mContext, SplashActivity.class), null);
    localIntent.putExtra("uin", (String)localObject);
    localIntent.putExtra("uintype", i);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("forward_type", -1);
    localIntent.putExtra("forward_text", paramString1);
    this.mContext.startActivity(localIntent);
    return true;
  }
  
  public boolean bI(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      paramString2 = (FragmentActivity)this.mContext;
      if (paramString2.getChatFragment() != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w("StructMsg", 2, "chatfragment is null");
      }
      return true;
      paramString1 = paramString2;
    }
    paramString2 = paramString2.getChatFragment().a().oL();
    kaw.a().a(this.mContext, this.mApp, paramString2, paramString1, false, 0.0D, 0.0D, null, 1, 0L, 2);
    return true;
  }
  
  public boolean clickPluginMsg(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "StructMsgClickHandler clickPluginMsg  actionData = " + paramString1 + ", actionDataA = " + paramString2);
    }
    if (TextUtils.isEmpty(paramString2)) {
      if (!TextUtils.equals(paramString1, "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent")) {
        break label66;
      }
    }
    label66:
    do
    {
      for (;;)
      {
        return true;
        paramString1 = paramString2;
        break;
        try
        {
          paramString1 = aqik.c(this.mApp, this.mContext, paramString1);
          if (paramString1 != null)
          {
            if (this.message != null) {
              paramString1.fj("msg_uniseq", String.valueOf(this.message.uniseq));
            }
            paramString1.ace();
            if ((this.message != null) && (!this.message.isSend()) && (this.message.istroop == 0) && (aqft.rj(this.message.frienduin)) && (!TextUtils.isEmpty(this.message.getExtInfoFromExtStr("guide_msg_cookie"))))
            {
              paramString1 = aqft.p(this.message.getExtInfoFromExtStr("guide_msg_cookie"));
              if (paramString1 != null)
              {
                paramString2 = new babyq_cookie.BabyQCookie();
                paramString2.mergeFrom(paramString1);
                if (paramString2.uint32_type.get() == 207)
                {
                  this.mApp.b().uz("baqyq_mayknow_people");
                  return true;
                }
              }
            }
          }
        }
        catch (Exception paramString1) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("StructMsg", 2, paramString1.getMessage(), paramString1);
    return true;
  }
  
  public boolean clickWebMsg(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((TextUtils.isEmpty(paramString)) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return bool1;
                  localObject = new Intent(this.mContext, PublicAccountBrowser.class);
                  ((Intent)localObject).putExtra("key_isReadModeEnabled", true);
                  ((Intent)localObject).putExtra("url", paramString);
                  ((Intent)localObject).putExtra("FORCE_BLANK_SCREEN_REPORTE", true);
                  ((Intent)localObject).putExtra("articalChannelId", 1);
                  ocp.a(this.message, (Intent)localObject, paramString);
                  this.mContext.startActivity((Intent)localObject);
                  bool1 = bool2;
                } while (this.message == null);
                bool1 = bool2;
              } while (this.message.isSend());
              bool1 = bool2;
            } while (this.message.istroop != 0);
            bool1 = bool2;
          } while (!aqft.rj(this.message.frienduin));
          bool1 = bool2;
        } while (TextUtils.isEmpty(this.message.getExtInfoFromExtStr("guide_msg_cookie")));
        paramString = aqft.p(this.message.getExtInfoFromExtStr("guide_msg_cookie"));
        bool1 = bool2;
      } while (paramString == null);
      Object localObject = new babyq_cookie.BabyQCookie();
      try
      {
        ((babyq_cookie.BabyQCookie)localObject).mergeFrom(paramString);
        switch (((babyq_cookie.BabyQCookie)localObject).uint32_type.get())
        {
        case 204: 
          this.mApp.b().uz("babyq_game_strategy");
          return true;
        }
      }
      catch (InvalidProtocolBufferMicroException paramString)
      {
        bool1 = bool2;
      }
    } while (!QLog.isColorLevel());
    QLog.d("StructMsg", 2, "babbyq -> sendSpecialMessage:" + paramString.getStackTrace());
    return true;
    this.mApp.b().uz("babyq_game_gift");
    return true;
    return true;
  }
  
  public boolean i(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return a(paramString1, paramString2, paramString3, paramString4, 0L, new Object[0]);
  }
  
  public boolean j(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString3)) {}
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        int i = paramString2.indexOf("://");
        Object localObject = "";
        if (i == -1)
        {
          paramString3 = paramString2;
          paramString2 = (String)localObject;
          label39:
          localObject = this.mContext.getPackageManager();
        }
        try
        {
          if (((PackageManager)localObject).getPackageInfo(paramString3, 1) != null)
          {
            localObject = ((PackageManager)localObject).getLaunchIntentForPackage(paramString3);
            if (localObject != null)
            {
              if (!TextUtils.isEmpty(paramString2)) {
                ((Intent)localObject).setData(Uri.parse(paramString2));
              }
              acly.j("structmsg", "", paramString3, "1", "structmsgClick", this.mContext.getClass().getName());
              this.mContext.startActivity((Intent)localObject);
              return true;
              paramString2 = paramString3;
              continue;
              paramString3 = paramString2.substring(0, i);
              paramString2 = paramString2.substring(i + 3);
              break label39;
            }
            return false;
          }
        }
        catch (Exception paramString2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, paramString2.getMessage());
          }
        }
      }
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = new Intent(this.mContext, QQBrowserActivity.class);
      paramString2.putExtra("key_isReadModeEnabled", true);
      paramString2.putExtra("url", paramString1);
      paramString2.putExtra("fromAio", true);
      ocp.a(this.message, paramString2, paramString1);
      this.mContext.startActivity(paramString2);
      anot.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString1, "", "", "");
      return true;
    }
    return false;
  }
  
  public boolean pF(String paramString)
  {
    if (paramString.startsWith("tel:"))
    {
      paramString = paramString.substring("tel:".length());
      bY(this.mContext, paramString);
    }
    for (;;)
    {
      return true;
      try
      {
        paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        paramString.putExtra("com.android.browser.application_id", this.mContext.getPackageName());
        this.mContext.startActivity(paramString);
      }
      catch (Exception paramString) {}
      if (QLog.isColorLevel()) {
        QLog.d("HyperTextMsg", 2, paramString.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anra
 * JD-Core Version:    0.7.0.1
 */