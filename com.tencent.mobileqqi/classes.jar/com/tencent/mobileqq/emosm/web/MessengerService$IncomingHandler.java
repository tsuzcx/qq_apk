package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.NearHornHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.emoticon.EmoticonController;
import com.tencent.mobileqq.equipmentlock.EquipLockWebImpl;
import com.tencent.mobileqq.maproam.RoamMapController;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpContinueDownloadFileProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;
import java.io.Serializable;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.request.WtloginHelper;
import org.json.JSONObject;

class MessengerService$IncomingHandler
  extends Handler
{
  MessengerService$IncomingHandler(MessengerService paramMessengerService) {}
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    int i = 2;
    if ((paramMessage == null) || (!(MessengerService.access$000(this.this$0) instanceof QQAppInterface))) {}
    Object localObject2;
    Bundle localBundle;
    do
    {
      return;
      localObject2 = (QQAppInterface)MessengerService.access$100(this.this$0);
      if ((paramMessage != null) && (paramMessage.replyTo != null)) {
        this.this$0.mClient = paramMessage.replyTo;
      }
      switch (paramMessage.what)
      {
      default: 
        super.handleMessage(paramMessage);
        return;
      case 1: 
        this.this$0.mClient = paramMessage.replyTo;
        if (localObject2 != null)
        {
          paramMessage = EmoticonController.a((QQAppInterface)localObject2);
          if (paramMessage != null) {
            paramMessage.a(this.this$0.mListener);
          }
        }
        EquipLockWebImpl.a().a((QQAppInterface)localObject2, this.this$0.mClient);
        return;
      case 2: 
        if (localObject2 != null)
        {
          paramMessage = EmoticonController.a((QQAppInterface)localObject2);
          if (paramMessage != null) {
            paramMessage.b(this.this$0.mListener);
          }
        }
        EquipLockWebImpl.a().a();
        this.this$0.mClient = null;
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.MessengerService", 2, "Received server req: ");
      }
      localBundle = paramMessage.getData();
    } while (localBundle == null);
    Object localObject1 = localBundle.getString("cmd");
    paramMessage = localBundle.getBundle("request");
    if (((String)localObject1).equals("queryEmojiInfo"))
    {
      paramMessage = EmoticonController.a((QQAppInterface)localObject2).a().c(paramMessage);
      if ((QLog.isColorLevel()) && (paramMessage != null)) {
        QLog.i("Q.emoji.web.MessengerService", 2, "qq queryEmojiInfo: result:" + paramMessage.getInt("result") + ";id:" + paramMessage.getInt("id") + ";status:" + paramMessage.getInt("status") + ";progress:" + paramMessage.getInt("progress") + ";pluginStatus:" + paramMessage.getInt("pluginStatus") + ";pluginSize:" + paramMessage.getLong("pluginSize"));
      }
      if (paramMessage != null) {
        localBundle.putBundle("response", paramMessage);
      }
      MessengerService.access$200(this.this$0, localBundle);
      return;
    }
    if (((String)localObject1).equals("queryEmojiInfos"))
    {
      paramMessage = EmoticonController.a((QQAppInterface)localObject2).a().a();
      if (paramMessage != null) {
        localBundle.putBundle("response", paramMessage);
      }
      MessengerService.access$200(this.this$0, localBundle);
      return;
    }
    if (((String)localObject1).equals("startDownloadEmoji"))
    {
      paramMessage = EmoticonController.a((QQAppInterface)localObject2).a().b(paramMessage);
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.MessengerService", 2, "qq startDownloadEmoji: result:" + paramMessage.getString("result") + ";messge:" + paramMessage.getString("message"));
      }
      localBundle.putBundle("response", paramMessage);
      MessengerService.access$200(this.this$0, localBundle);
      return;
    }
    if (((String)localObject1).equals("stopDownloadEmoji"))
    {
      paramMessage = EmoticonController.a((QQAppInterface)localObject2).a().a(String.valueOf(paramMessage.getInt("id")));
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.MessengerService", 2, "qq stopDownloadEmoji: result:" + paramMessage.getInt("result") + ";messge:" + paramMessage.getString("messge"));
      }
      localBundle.putBundle("response", paramMessage);
      MessengerService.access$200(this.this$0, localBundle);
      return;
    }
    if ("writeQFaceResult".equals(localObject1))
    {
      paramMessage = EmoticonController.a((QQAppInterface)localObject2).a().a(paramMessage);
      if ((QLog.isColorLevel()) && (paramMessage != null)) {
        QLog.i("Q.emoji.web.MessengerService", 2, "qq writeQFaceResult: result:" + paramMessage.getInt("result") + ";messge:" + paramMessage.getString("messge"));
      }
      MessengerService.access$200(this.this$0, localBundle);
      return;
    }
    if ("getFaceFilePath".equals(localObject1))
    {
      paramMessage = ((QQAppInterface)localObject2).b(1, localBundle.getBundle("request").getString("uin"));
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("faceFilePath", paramMessage);
      localBundle.putBundle("response", (Bundle)localObject1);
      MessengerService.access$200(this.this$0, localBundle);
      return;
    }
    boolean bool1;
    if ("changeAvatar".equals(localObject1))
    {
      bool1 = ProfileCardUtil.a((QQAppInterface)localObject2, localBundle.getBundle("request").getString("path"));
      paramMessage = new Bundle();
      paramMessage.putBoolean("updateResult", bool1);
      localBundle.putBundle("response", paramMessage);
      MessengerService.access$200(this.this$0, localBundle);
      return;
    }
    Object localObject3;
    long l;
    Object localObject4;
    if ("updatePendantId".equals(localObject1))
    {
      paramMessage = localBundle.getBundle("request");
      localObject3 = paramMessage.getString("uin");
      l = paramMessage.getLong("pendantId");
      localObject4 = (FriendsManagerImp)((QQAppInterface)localObject2).getManager(8);
      localObject1 = ((FriendsManagerImp)localObject4).a((String)localObject3);
      paramMessage = (Message)localObject1;
      if (localObject1 == null)
      {
        paramMessage = new ExtensionInfo();
        paramMessage.uin = ((String)localObject3);
      }
      paramMessage.pendantId = l;
      paramMessage.timestamp = System.currentTimeMillis();
      ((FriendsManagerImp)localObject4).a(paramMessage);
      paramMessage = new Bundle();
      paramMessage.putBoolean("updateResult", true);
      localBundle.putBundle("response", paramMessage);
      MessengerService.access$200(this.this$0, localBundle);
      ReportController.b((QQAppInterface)localObject2, "CliStatus", "", "", "AvatarPendant", "ChangeHead", 0, 0, "", "", "", "");
      return;
    }
    int j;
    if ("reportActionCount".equals(localObject1))
    {
      j = ((SVIPHandler)((QQAppInterface)localObject2).a(12)).c();
      localObject1 = StatisticCollector.a(((QQAppInterface)localObject2).getApplication());
      if (j != 3) {
        break label3752;
      }
    }
    for (;;)
    {
      ((StatisticCollector)localObject1).a((AppRuntime)localObject2, ((QQAppInterface)localObject2).a(), paramMessage.getString("optype"), paramMessage.getString("opname"), 0, 1, null, String.valueOf(i), null, null, null);
      return;
      if ("setup".equals(localObject1)) {
        try
        {
          i = paramMessage.getInt("id");
          ((SVIPHandler)((QQAppInterface)localObject2).a(12)).a(i);
          paramMessage = new Bundle();
          paramMessage.putInt("id", i);
          localBundle.putBundle("response", paramMessage);
          MessengerService.access$200(this.this$0, localBundle);
          return;
        }
        catch (Exception paramMessage)
        {
          paramMessage.printStackTrace();
          return;
        }
      }
      if ("queryLocal".equals(localObject1))
      {
        i = ((SVIPHandler)((QQAppInterface)localObject2).a(12)).b();
        paramMessage = new Bundle();
        paramMessage.putInt("id", i);
        localBundle.putBundle("response", paramMessage);
        MessengerService.access$200(this.this$0, localBundle);
        return;
      }
      if ("getFaceFilePath".equals(localObject1))
      {
        paramMessage = ((QQAppInterface)localObject2).b(1, localBundle.getBundle("request").getString("uin"));
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("faceFilePath", paramMessage);
        localBundle.putBundle("response", (Bundle)localObject1);
        MessengerService.access$200(this.this$0, localBundle);
        return;
      }
      if ("changeAvatar".equals(localObject1))
      {
        bool1 = ProfileCardUtil.a((QQAppInterface)localObject2, localBundle.getBundle("request").getString("path"));
        paramMessage = new Bundle();
        paramMessage.putBoolean("updateResult", bool1);
        localBundle.putBundle("response", paramMessage);
        MessengerService.access$200(this.this$0, localBundle);
        return;
      }
      if ("updatePendantId".equals(localObject1))
      {
        paramMessage = localBundle.getBundle("request");
        localObject3 = paramMessage.getString("uin");
        l = paramMessage.getLong("pendantId");
        localObject4 = (FriendsManagerImp)((QQAppInterface)localObject2).getManager(8);
        localObject1 = ((FriendsManagerImp)localObject4).a((String)localObject3);
        paramMessage = (Message)localObject1;
        if (localObject1 == null)
        {
          paramMessage = new ExtensionInfo();
          paramMessage.uin = ((String)localObject3);
        }
        paramMessage.pendantId = l;
        paramMessage.timestamp = System.currentTimeMillis();
        ((FriendsManagerImp)localObject4).a(paramMessage);
        paramMessage = new Bundle();
        paramMessage.putBoolean("updateResult", true);
        localBundle.putBundle("response", paramMessage);
        MessengerService.access$200(this.this$0, localBundle);
        ReportController.b((QQAppInterface)localObject2, "CliStatus", "", "", "AvatarPendant", "ChangeHead", 0, 0, "", "", "", "");
        return;
      }
      if ("addThemeSpecific".equals(localObject1))
      {
        if (this.this$0.themeDownloadHandler == null)
        {
          this.this$0.themeDownloadHandler = new MessengerService.ThemeDownloadHandler(this.this$0, localBundle);
          this.this$0.themeDownloadHandler.addFilter(new Class[] { HttpContinueDownloadFileProcessor.class });
          ((QQAppInterface)localObject2).a().a(this.this$0.themeDownloadHandler);
          return;
        }
        this.this$0.themeDownloadHandler.setBundle(localBundle);
        return;
      }
      if ("removeThemeDownHandler".equals(localObject1)) {
        break;
      }
      if ("startDownloadTheme".equals(localObject1))
      {
        localObject1 = paramMessage.getString("url");
        localObject3 = paramMessage.getString("themeZipPath");
        l = paramMessage.getLong("size");
        localObject4 = paramMessage.getString("id");
        paramMessage = paramMessage.getString("version");
        localObject2 = ((QQAppInterface)localObject2).a();
        if ((localObject2 != null) && (((TransFileController)localObject2).e((String)localObject1, (String)localObject3, l)))
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.emoji.web.MessengerService", 2, "startDownloadTheme OK, id = " + (String)localObject4 + ", version=" + paramMessage);
            bool1 = bool2;
          }
        }
        for (;;)
        {
          paramMessage = new Bundle();
          paramMessage.putBoolean("StartDownloadResult", bool1);
          localBundle.putBundle("response", paramMessage);
          MessengerService.access$200(this.this$0, localBundle);
          return;
          if ((localObject2 != null) && (((TransFileController)localObject2).a((String)localObject1) != null))
          {
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.emoji.web.MessengerService", 2, "startDownloadTheme, already in download queue, id = " + (String)localObject4 + ", version=" + paramMessage);
              bool1 = bool2;
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.emoji.web.MessengerService", 2, "startDownloadTheme Error, id = " + (String)localObject4 + ", version=" + paramMessage);
            }
            bool1 = false;
          }
        }
      }
      if ("stopdownload".equals(localObject1))
      {
        if (paramMessage == null) {
          break;
        }
        localObject1 = new Bundle();
        paramMessage = paramMessage.getString("url");
        localObject2 = ((QQAppInterface)localObject2).a();
        if ((localObject2 != null) && (paramMessage != null))
        {
          localObject2 = (HttpContinueDownloadFileProcessor)((TransFileController)localObject2).a(paramMessage);
          if (localObject2 == null) {
            break label2032;
          }
          bool1 = ((HttpContinueDownloadFileProcessor)localObject2).g();
          ((Bundle)localObject1).putBoolean("processor", bool1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.web.MessengerService", 2, "stop download, result=" + bool1 + " url=" + paramMessage);
          }
        }
        for (;;)
        {
          localBundle.putBundle("response", (Bundle)localObject1);
          MessengerService.access$200(this.this$0, localBundle);
          return;
          label2032:
          if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.web.MessengerService", 2, "p not found");
          }
        }
      }
      if ("pausedownload".equals(localObject1))
      {
        if (paramMessage == null) {
          break;
        }
        paramMessage = new Bundle();
        String str2 = localBundle.getString("url");
        localObject1 = localBundle.getString("currid");
        localObject3 = localBundle.getString("id");
        localObject4 = localBundle.getString("version");
        localObject2 = ((QQAppInterface)localObject2).a();
        if ((localObject2 != null) && (str2 != null))
        {
          localObject2 = (HttpContinueDownloadFileProcessor)((TransFileController)localObject2).a(str2);
          if (localObject2 != null)
          {
            paramMessage.putBoolean("processor", true);
            bool1 = ((HttpContinueDownloadFileProcessor)localObject2).g();
            if (QLog.isColorLevel()) {
              QLog.d("Q.emoji.web.MessengerService", 2, "pause download themeId= " + (String)localObject1 + ",version=" + (String)localObject4 + ",paused=" + bool1 + ",for start download themeid=" + (String)localObject3);
            }
          }
        }
        localBundle.putBundle("response", paramMessage);
        MessengerService.access$200(this.this$0, localBundle);
        return;
      }
      if ("getUserVipType".equals(localObject1))
      {
        localObject1 = new Bundle();
        localObject2 = (SVIPHandler)((QQAppInterface)localObject2).a(12);
        paramMessage = paramMessage.getString("uin");
        i = ((SVIPHandler)localObject2).c();
        ((Bundle)localObject1).putString("uin", paramMessage);
        ((Bundle)localObject1).putInt("type", i);
        localBundle.putBundle("response", (Bundle)localObject1);
        MessengerService.access$200(this.this$0, localBundle);
        return;
      }
      if ("notifyCommentCnt".equals(localObject1))
      {
        ((NearHornHandler)((QQAppInterface)localObject2).a(31)).b(new Object[] { paramMessage.getString("hornKey"), Integer.valueOf(paramMessage.getInt("commentCnt")) });
        return;
      }
      if ("getRoamEncounter".equals(localObject1))
      {
        paramMessage = new Bundle();
        localObject1 = localBundle.getBundle("request");
        i = ((Bundle)localObject1).getInt("lat");
        j = ((Bundle)localObject1).getInt("lon");
        int k = ((Bundle)localObject1).getInt("count");
        paramMessage.putSerializable("list", (Serializable)((RoamMapController)MessengerService.access$300(this.this$0).getManager(40)).a(i, j, k));
        paramMessage.putInt("lat", i);
        paramMessage.putInt("lon", j);
        localBundle.putBundle("response", paramMessage);
        MessengerService.access$200(this.this$0, localBundle);
        return;
      }
      if ("notifyTroopUpgradeSuccess".equals(localObject1))
      {
        ((TroopHandler)((QQAppInterface)localObject2).a(19)).b(paramMessage.getString("groupId"), paramMessage.getInt("type"));
        return;
      }
      if (IPCConstants.IPC_CMD_MAP.containsKey(localObject1))
      {
        switch (((Integer)IPCConstants.IPC_CMD_MAP.get(localObject1)).intValue())
        {
        default: 
          return;
        case 1: 
          i = paramMessage.getInt("id");
          ((SVIPHandler)((QQAppInterface)localObject2).a(12)).b(i);
          paramMessage = new Bundle();
          paramMessage.putInt("id", i);
          paramMessage.putInt("result", 0);
          paramMessage.putString("message", "success");
          localBundle.putBundle("response", paramMessage);
          MessengerService.access$200(this.this$0, localBundle);
          return;
        case 3: 
          i = paramMessage.getInt("id");
          paramMessage = localBundle.getString("callbackid");
          localObject1 = (FontManager)MessengerService.access$400(this.this$0).getManager(41);
          ((FontManager)localObject1).a(this.this$0.mVipIPCDownloadListener);
          ((FontManager)localObject1).a(i, paramMessage);
          return;
        case 2: 
          i = paramMessage.getInt("id");
          paramMessage = ((FontManager)MessengerService.access$500(this.this$0).getManager(41)).a(i);
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("id", i);
          ((Bundle)localObject1).putString("result", paramMessage.toString());
          localBundle.putBundle("response", (Bundle)localObject1);
          MessengerService.access$200(this.this$0, localBundle);
          return;
        case 4: 
          i = paramMessage.getInt("id");
          ((FontManager)MessengerService.access$600(this.this$0).getManager(41)).a(i);
          paramMessage = new Bundle();
          paramMessage.putInt("id", i);
          localBundle.putBundle("response", paramMessage);
          MessengerService.access$200(this.this$0, localBundle);
          return;
        case 5: 
          i = paramMessage.getInt("id");
          paramMessage = localBundle.getString("callbackid");
          localObject1 = (BubbleManager)MessengerService.access$700(this.this$0).getManager(42);
          ((BubbleManager)localObject1).a(this.this$0.mVipIPCDownloadListener);
          ((BubbleManager)localObject1).a(i, paramMessage);
          return;
        case 7: 
          i = paramMessage.getInt("id");
          paramMessage = ((BubbleManager)MessengerService.access$800(this.this$0).getManager(42)).b(i);
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("id", i);
          ((Bundle)localObject1).putString("result", paramMessage.toString());
          localBundle.putBundle("response", (Bundle)localObject1);
          MessengerService.access$200(this.this$0, localBundle);
          return;
        }
        i = paramMessage.getInt("id");
        paramMessage = ((BubbleManager)MessengerService.access$900(this.this$0).getManager(42)).a(i);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("id", i);
        ((Bundle)localObject1).putString("result", paramMessage.toString());
        localBundle.putBundle("response", (Bundle)localObject1);
        MessengerService.access$200(this.this$0, localBundle);
        return;
      }
      if ("downloadPlugin".equals(localObject1))
      {
        if (localBundle == null) {
          break;
        }
        localObject1 = new Bundle();
        localObject2 = paramMessage.getString("pluginid");
        ((Bundle)localObject1).putString("url", paramMessage.getString("url"));
        ((Bundle)localObject1).putLong("sn", paramMessage.getLong("sn", 0L));
        paramMessage = (IPluginManager)MessengerService.access$1000(this.this$0).getManager(24);
        localObject3 = paramMessage.a((String)localObject2);
        if ((localObject3 != null) && (((PluginInfo)localObject3).mState == 4))
        {
          ((Bundle)localObject1).putBoolean("installed", true);
          if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.web.MessengerService", 2, "downloadPlugin:installed=true");
          }
        }
        for (;;)
        {
          localBundle.putBundle("response", (Bundle)localObject1);
          MessengerService.access$200(this.this$0, localBundle);
          return;
          ((Bundle)localObject1).putBoolean("installed", false);
          paramMessage.a((String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.web.MessengerService", 2, "downloadPlugin:start download");
          }
        }
      }
      if ("cancelDownloadPlugin".equals(localObject1))
      {
        if (localBundle == null) {
          break;
        }
        localObject1 = new Bundle();
        localObject2 = paramMessage.getString("pluginid");
        ((Bundle)localObject1).putString("url", paramMessage.getString("url"));
        ((Bundle)localObject1).putLong("sn", paramMessage.getLong("sn", 0L));
        ((IPluginManager)MessengerService.access$1100(this.this$0).getManager(24)).cancelInstall((String)localObject2);
        localBundle.putBundle("response", (Bundle)localObject1);
        MessengerService.access$200(this.this$0, localBundle);
        return;
      }
      if ("queryPlugin".equals(localObject1))
      {
        if (localBundle == null) {
          break;
        }
        localObject1 = new Bundle();
        localObject2 = paramMessage.getString("pluginid");
        ((Bundle)localObject1).putString("url", paramMessage.getString("url"));
        ((Bundle)localObject1).putLong("sn", paramMessage.getLong("sn", 0L));
        paramMessage = ((IPluginManager)MessengerService.access$1200(this.this$0).getManager(24)).a((String)localObject2);
        if (paramMessage == null) {
          ((Bundle)localObject1).putBoolean("erro", true);
        }
        for (;;)
        {
          localBundle.putBundle("response", (Bundle)localObject1);
          MessengerService.access$200(this.this$0, localBundle);
          return;
          ((Bundle)localObject1).putFloat("progress", paramMessage.mDownloadProgress);
          ((Bundle)localObject1).putInt("state", paramMessage.mState);
          if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.web.MessengerService", 2, "queryPlugin:progress=" + paramMessage.mDownloadProgress + " state:" + paramMessage.mState);
          }
        }
      }
      if ("openEquipmentLock".equals(localObject1))
      {
        paramMessage = paramMessage.getByteArray("sppkey");
        EquipLockWebImpl.a().a(paramMessage);
        return;
      }
      if ("setHasSetPwd".equals(localObject1))
      {
        PhoneNumLoginImpl.a().a((QQAppInterface)localObject2, ((QQAppInterface)localObject2).a(), true);
        return;
      }
      if (!"getA2".equals(localObject1)) {
        break;
      }
      paramMessage = paramMessage.getString("uin");
      localObject1 = (WtloginManager)((QQAppInterface)localObject2).getManager(1);
      if (localObject1 != null) {}
      for (;;)
      {
        try
        {
          paramMessage = HexUtil.a(WtloginHelper.GetTicketSig(((WtloginManager)localObject1).GetLocalSig(paramMessage, 16L), 64));
          localObject1 = paramMessage;
          localException1.printStackTrace();
        }
        catch (Exception localException1)
        {
          try
          {
            if (QLog.isColorLevel())
            {
              QLog.d("Q.emoji.web.MessengerService", 2, "a2 = " + paramMessage);
              localObject1 = paramMessage;
            }
            paramMessage = new Bundle();
            paramMessage.putString("A2", (String)localObject1);
            localBundle.putBundle("response", paramMessage);
            MessengerService.access$200(this.this$0, localBundle);
            return;
          }
          catch (Exception localException2)
          {
            Message localMessage;
            break label3728;
          }
          localException1 = localException1;
          paramMessage = "";
        }
        label3728:
        localMessage = paramMessage;
        continue;
        String str1 = "";
      }
      label3752:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler
 * JD-Core Version:    0.7.0.1
 */