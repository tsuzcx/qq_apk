package com.tencent.moai.mailsdk;

import android.content.Context;
import com.tencent.moai.mailsdk.callback.AttachmentCallBack;
import com.tencent.moai.mailsdk.callback.CheckMailCallback;
import com.tencent.moai.mailsdk.callback.CreateRuleCallback;
import com.tencent.moai.mailsdk.callback.FolderCallBack;
import com.tencent.moai.mailsdk.callback.FolderListCallBack;
import com.tencent.moai.mailsdk.callback.FolderSyncActiveSyncCallBack;
import com.tencent.moai.mailsdk.callback.FolderSyncExchangeCallBack;
import com.tencent.moai.mailsdk.callback.FolderSyncImapCallBack;
import com.tencent.moai.mailsdk.callback.IdleCallback;
import com.tencent.moai.mailsdk.callback.LoginCallBack;
import com.tencent.moai.mailsdk.callback.LogoutCallBack;
import com.tencent.moai.mailsdk.callback.MailAbstractCallBack;
import com.tencent.moai.mailsdk.callback.MailCallBack;
import com.tencent.moai.mailsdk.callback.MailListCallBack;
import com.tencent.moai.mailsdk.callback.MailOperationCallback;
import com.tencent.moai.mailsdk.callback.SearchMailCallback;
import com.tencent.moai.mailsdk.callback.SendMailCallBack;
import com.tencent.moai.mailsdk.exception.ProtocolNotSupportError;
import com.tencent.moai.mailsdk.model.Attachment;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.model.State;
import com.tencent.moai.mailsdk.protocol.ActiveSyncProtocolManager;
import com.tencent.moai.mailsdk.protocol.ExchangeProtocolManager;
import com.tencent.moai.mailsdk.protocol.IMAPProtocolManager;
import com.tencent.moai.mailsdk.protocol.POP3ProtocolManager;
import com.tencent.moai.mailsdk.protocol.SMTPProtocolManager;
import com.tencent.moai.mailsdk.protocol.activesync.SyncKeyHandler.SyncKeyCallback;
import com.tencent.moai.mailsdk.protocol.activesync.model.DeviceInfo;
import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeRule;
import com.tencent.moai.mailsdk.util.StringUtility;
import com.tencent.moai.mailsdk.util.ThreadUtility;
import com.tencent.moai.mailsdk.util.log.Logger;
import com.tencent.moai.mailsdk.util.log.LoggerDelegate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MailManager
{
  private static final String TAG = "MailManager";
  private static Context context;
  private static MailManager instance = new MailManager();
  
  public static Context getContext()
  {
    return context;
  }
  
  public static MailManager getInstance()
  {
    return instance;
  }
  
  public static void init(Context paramContext)
  {
    context = paramContext;
  }
  
  public static void initLogger(LoggerDelegate paramLoggerDelegate)
  {
    Logger.setDelegate(paramLoggerDelegate);
  }
  
  public static void setDefaultTmpFileDir(String paramString)
  {
    if (!StringUtility.isNullOrEmpty(paramString)) {
      com.tencent.moai.mailsdk.protocol.datasource.DataConfig.TMP_FILE_DIR = paramString;
    }
  }
  
  public void addFolder(Profile paramProfile, State paramState, Folder paramFolder, FolderCallBack paramFolderCallBack)
  {
    Logger.log(4, "MailManager", "add folder");
    ThreadUtility.start(new MailManager.7(this, paramProfile, paramState, paramFolder, paramFolderCallBack));
  }
  
  public void addRule(Profile paramProfile, ArrayList<ExchangeRule> paramArrayList, CreateRuleCallback paramCreateRuleCallback)
  {
    Logger.log(4, "MailManager", "addRule");
    ExchangeProtocolManager.getInstance().createRule(paramProfile, paramArrayList, paramCreateRuleCallback);
  }
  
  public void appendFile(Profile paramProfile, String paramString1, String paramString2, MailOperationCallback paramMailOperationCallback)
  {
    ThreadUtility.start(new MailManager.20(this, paramProfile, paramString1, paramString2, paramMailOperationCallback));
  }
  
  public void appendMailToServer(Profile paramProfile, Mail paramMail, String paramString, MailOperationCallback paramMailOperationCallback)
  {
    Logger.log(4, "MailManager", "append mail");
    ThreadUtility.start(new MailManager.19(this, paramProfile, paramString, paramMail, paramMailOperationCallback));
  }
  
  public void checkMail(Profile paramProfile, Map<Folder, ArrayList<String>> paramMap, CheckMailCallback paramCheckMailCallback)
  {
    Logger.log(4, "MailManager", "check new mail");
    if (paramProfile.getProtocol() == 2)
    {
      IMAPProtocolManager.getInstance().checkMail(paramProfile, paramMap, paramCheckMailCallback);
      return;
    }
    throw new ProtocolNotSupportError("check mails protocol error " + paramProfile.getProtocol());
  }
  
  public void deleteMail(Profile paramProfile, Folder paramFolder, Mail[] paramArrayOfMail, MailOperationCallback paramMailOperationCallback)
  {
    Logger.log(4, "MailManager", "delete mail");
    ThreadUtility.start(new MailManager.15(this, paramProfile, paramFolder, paramArrayOfMail, paramMailOperationCallback));
  }
  
  public void downloadAttachment(Profile paramProfile, Folder paramFolder, Mail paramMail, Attachment paramAttachment, AttachmentCallBack paramAttachmentCallBack)
  {
    Logger.log(4, "MailManager", "download mail attachment");
    ThreadUtility.start(new MailManager.13(this, paramProfile, paramFolder, paramMail, paramAttachment, paramAttachmentCallBack));
  }
  
  public void downloadMailsAbstract(Profile paramProfile, Folder paramFolder, Mail[] paramArrayOfMail, MailAbstractCallBack paramMailAbstractCallBack)
  {
    Logger.log(4, "MailManager", "download mail abstract");
    ThreadUtility.start(new MailManager.12(this, paramProfile, paramFolder, paramArrayOfMail, paramMailAbstractCallBack));
  }
  
  public void downloadMailsText(Profile paramProfile, Folder paramFolder, Mail[] paramArrayOfMail, boolean paramBoolean1, boolean paramBoolean2, MailCallBack paramMailCallBack)
  {
    Logger.log(4, "MailManager", "download mail text");
    ThreadUtility.start(new MailManager.11(this, paramProfile, paramFolder, paramArrayOfMail, paramBoolean1, paramMailCallBack, paramBoolean2));
  }
  
  public void fetchFolderList(Profile paramProfile, State paramState, FolderListCallBack paramFolderListCallBack)
  {
    Logger.log(4, "MailManager", "fetch folder list");
    ThreadUtility.start(new MailManager.4(this, paramProfile, paramState, paramFolderListCallBack));
  }
  
  public void fetchMailList(Profile paramProfile, State paramState, Folder paramFolder, MailListCallBack paramMailListCallBack)
  {
    Logger.log(4, "MailManager", "fetch mail list");
    ThreadUtility.start(new MailManager.10(this, paramProfile, paramState, paramFolder, paramMailListCallBack));
  }
  
  public void initAccountSyncKeyMapping(Map<Integer, String> paramMap)
  {
    Logger.log(4, "MailManager", "initAccountSyncKeyMapping");
    ActiveSyncProtocolManager.getInstance().initAccountSyncKeyMapping(paramMap);
  }
  
  public void initFolderSyncKeyMapping(Map<Integer, String> paramMap)
  {
    Logger.log(4, "MailManager", "initFolderSyncKeyMapping");
    ActiveSyncProtocolManager.getInstance().initFolderSyncKeyMapping(paramMap);
  }
  
  public void initProfile(Profile paramProfile)
  {
    int i = paramProfile.getProtocol();
    if (i == 1)
    {
      SMTPProtocolManager.getInstance().initProfile(paramProfile);
      return;
    }
    if (i == 2)
    {
      IMAPProtocolManager.getInstance().initProfile(paramProfile);
      return;
    }
    if (i == 3)
    {
      POP3ProtocolManager.getInstance().initProfile(paramProfile);
      return;
    }
    if (i == 4)
    {
      ActiveSyncProtocolManager.getInstance().initProfile(paramProfile);
      return;
    }
    if (i == 5)
    {
      ExchangeProtocolManager.getInstance().initProfile(paramProfile);
      return;
    }
    throw new ProtocolNotSupportError("login protocol error " + paramProfile.getProtocol());
  }
  
  public void login(Profile paramProfile, LoginCallBack paramLoginCallBack, boolean paramBoolean)
  {
    Logger.log(4, "MailManager", "login");
    ThreadUtility.start(new MailManager.1(this, paramProfile, paramLoginCallBack, paramBoolean));
  }
  
  public void logout(Profile paramProfile, LogoutCallBack paramLogoutCallBack)
  {
    Logger.log(4, "MailManager", "logout");
    ThreadUtility.start(new MailManager.2(this, paramProfile, paramLogoutCallBack));
  }
  
  public void modifyMailFlag(Profile paramProfile, Folder paramFolder, Mail[] paramArrayOfMail, int paramInt1, int paramInt2, MailOperationCallback paramMailOperationCallback)
  {
    Logger.log(4, "MailManager", "modify mail flag");
    ThreadUtility.start(new MailManager.17(this, paramProfile, paramFolder, paramArrayOfMail, paramInt1, paramInt2, paramMailOperationCallback));
  }
  
  public void moveMail(Profile paramProfile, Folder paramFolder1, Folder paramFolder2, Mail[] paramArrayOfMail, MailOperationCallback paramMailOperationCallback)
  {
    Logger.log(4, "MailManager", "move mail");
    ThreadUtility.start(new MailManager.16(this, paramProfile, paramFolder1, paramFolder2, paramArrayOfMail, paramMailOperationCallback));
  }
  
  public void notifyIdle()
  {
    IMAPProtocolManager.getInstance().notifyIdle();
  }
  
  public void removeAccountSyncKey(int paramInt)
  {
    Logger.log(4, "MailManager", "removeAccountSyncKey");
    ActiveSyncProtocolManager.getInstance().removeAccountSyncKey(paramInt);
  }
  
  public void removeFolder(Profile paramProfile, State paramState, Folder paramFolder, FolderCallBack paramFolderCallBack)
  {
    Logger.log(4, "MailManager", "remove folder");
    ThreadUtility.start(new MailManager.8(this, paramProfile, paramState, paramFolder, paramFolderCallBack));
  }
  
  public void removeFolderSyncKey(int[] paramArrayOfInt)
  {
    Logger.log(4, "MailManager", "removeFolderSyncKey");
    ActiveSyncProtocolManager.getInstance().removeFolderSyncKey(paramArrayOfInt);
  }
  
  public void renameFolder(Profile paramProfile, State paramState, Folder paramFolder, String paramString, FolderCallBack paramFolderCallBack)
  {
    Logger.log(4, "MailManager", "rename folder");
    ThreadUtility.start(new MailManager.9(this, paramProfile, paramState, paramFolder, paramString, paramFolderCallBack));
  }
  
  public void searchMail(Profile paramProfile, ArrayList<String> paramArrayList, State paramState, HashMap<Integer, String> paramHashMap, SearchMailCallback paramSearchMailCallback)
  {
    Logger.log(4, "MailManager", "searchMail");
    ThreadUtility.start(new MailManager.18(this, paramProfile, paramArrayList, paramState, paramHashMap, paramSearchMailCallback));
  }
  
  public void sendMail(Profile paramProfile, Mail paramMail, SendMailCallBack paramSendMailCallBack)
  {
    Logger.log(4, "MailManager", "send mail");
    ThreadUtility.start(new MailManager.3(this, paramProfile, paramMail, paramSendMailCallBack));
  }
  
  public void setAccountSyncKey(int paramInt, String paramString)
  {
    Logger.log(4, "MailManager", "setAccountSyncKey");
    ActiveSyncProtocolManager.getInstance().setAccountSyncKey(paramInt, paramString);
  }
  
  public void setAccountSyncKeyCallback(SyncKeyHandler.SyncKeyCallback paramSyncKeyCallback)
  {
    Logger.log(4, "MailManager", "setAccountSyncKeyCallback");
    ActiveSyncProtocolManager.getInstance().setAccountSyncKeyCallback(paramSyncKeyCallback);
  }
  
  public void setDeviceInfo(DeviceInfo paramDeviceInfo)
  {
    Logger.log(4, "MailManager", "setDeviceInfo");
    ActiveSyncProtocolManager.getInstance().setDeviceInfo(paramDeviceInfo);
  }
  
  public void setFolderSyncKey(int paramInt, String paramString)
  {
    Logger.log(4, "MailManager", "setFolderSyncKey");
    ActiveSyncProtocolManager.getInstance().setFolderSyncKey(paramInt, paramString);
  }
  
  public void setFolderSyncKeyCallback(SyncKeyHandler.SyncKeyCallback paramSyncKeyCallback)
  {
    Logger.log(4, "MailManager", "setFolderSyncKeyCallback");
    ActiveSyncProtocolManager.getInstance().setFolderSyncKeyCallback(paramSyncKeyCallback);
  }
  
  public void setIdleAckInterval(Profile paramProfile, long paramLong)
  {
    IMAPProtocolManager.getInstance().setIdleAckInterval(paramProfile, paramLong);
  }
  
  public void startIdle(Profile paramProfile, Folder paramFolder, IdleCallback paramIdleCallback)
  {
    if (paramProfile.getProtocol() == 2)
    {
      IMAPProtocolManager.getInstance().startIdle(paramProfile, paramFolder, paramIdleCallback);
      return;
    }
    throw new ProtocolNotSupportError("idle protocol error " + paramProfile.getProtocol());
  }
  
  public void stopIdle(Profile paramProfile)
  {
    if (paramProfile.getProtocol() == 2) {
      IMAPProtocolManager.getInstance().stopIdle(paramProfile);
    }
  }
  
  public void syncActiveSyncFolderStatus(Profile paramProfile, State paramState, Folder paramFolder, FolderSyncActiveSyncCallBack paramFolderSyncActiveSyncCallBack)
  {
    Logger.log(4, "MailManager", "sync active sync folder status");
    ThreadUtility.start(new MailManager.5(this, paramProfile, paramState, paramFolder, paramFolderSyncActiveSyncCallBack));
  }
  
  public void syncExchangeFolderStatus(Profile paramProfile, State paramState, Folder paramFolder, FolderSyncExchangeCallBack paramFolderSyncExchangeCallBack)
  {
    Logger.log(4, "MailManager", "sync exchange folder status");
    ThreadUtility.start(new MailManager.6(this, paramProfile, paramState, paramFolder, paramFolderSyncExchangeCallBack));
  }
  
  public void syncImapFolderStatus(Profile paramProfile, Folder paramFolder, FolderSyncImapCallBack paramFolderSyncImapCallBack)
  {
    Logger.log(4, "MailManager", "sync imap folder status");
    if (paramProfile.getProtocol() == 2)
    {
      IMAPProtocolManager.getInstance().syncFolderStatus(paramProfile, paramFolder, paramFolderSyncImapCallBack);
      return;
    }
    throw new ProtocolNotSupportError("syncImapFolderStatus protocol error " + paramProfile.getProtocol());
  }
  
  public void transformTmpAttach(String paramString1, String paramString2, String paramString3, AttachmentCallBack paramAttachmentCallBack)
  {
    Logger.log(4, "MailManager", "transform mail tmp attachment");
    ThreadUtility.start(new MailManager.14(this, paramString1, paramString2, paramString3, paramAttachmentCallBack));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.MailManager
 * JD-Core Version:    0.7.0.1
 */