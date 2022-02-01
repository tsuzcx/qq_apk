package com.tencent.qqmail.protocol;

import android.content.Context;
import com.tencent.qqmail.model.ARTCompatibility;
import java.util.HashMap;
import java.util.Map;

public class ProtocolService
{
  public static boolean ActiveSyncCommandPing(Profile paramProfile, Exchange.ActiveSyncExtraInfo paramActiveSyncExtraInfo, OnProtocolListener paramOnProtocolListener)
  {
    return ProtocolServiceNative.ActiveSyncCommandPing(paramProfile, paramActiveSyncExtraInfo, paramOnProtocolListener);
  }
  
  public static void AddRule(Profile paramProfile, Exchange.ExchangeRule[] paramArrayOfExchangeRule, OnProtocolListener paramOnProtocolListener)
  {
    ProtocolServiceNative.AddRule(paramProfile, paramArrayOfExchangeRule, ARTCompatibility.wrap(paramOnProtocolListener));
  }
  
  public static void Init(Context paramContext)
  {
    ProtocolServiceNative.Init(paramContext);
  }
  
  public static void InitFolderListSyncKeyMapping(Map<Integer, String> paramMap)
  {
    ProtocolServiceNative.InitFolderListSyncKeyMapping(paramMap);
  }
  
  public static void InitLogger(String paramString, int paramInt)
  {
    ProtocolServiceNative.InitLogger(paramString, paramInt);
  }
  
  public static void InitSyncKeyMapping(Map<Integer, String> paramMap)
  {
    ProtocolServiceNative.InitSyncKeyMapping(paramMap);
  }
  
  public static void RemoveFolderListSyncKeys(int paramInt)
  {
    ProtocolServiceNative.RemoveFolderListSyncKeys(paramInt);
  }
  
  public static void RemoveSyncKeys(int[] paramArrayOfInt)
  {
    ProtocolServiceNative.RemoveSyncKeys(paramArrayOfInt);
  }
  
  public static void SetFolderListSyncKey(int paramInt, String paramString)
  {
    ProtocolServiceNative.SetFolderListSyncKey(paramInt, paramString);
  }
  
  public static void SetFolderListSyncKeyCallback(OnProtocolListener paramOnProtocolListener)
  {
    ProtocolServiceNative.SetFolderListSyncKeyCallback(ARTCompatibility.wrap(paramOnProtocolListener));
  }
  
  public static void SetFolderSyncKey(int paramInt, String paramString)
  {
    ProtocolServiceNative.SetFolderSyncKey(paramInt, paramString);
  }
  
  public static void SetIsART(boolean paramBoolean)
  {
    ProtocolServiceNative.SetIsART(paramBoolean);
  }
  
  public static void SetMobileInfoCallback(OnProtocolListener paramOnProtocolListener)
  {
    ProtocolServiceNative.SetMobileInfoCallback(paramOnProtocolListener);
  }
  
  public static void SetSyncKeyCallback(OnProtocolListener paramOnProtocolListener)
  {
    ProtocolServiceNative.SetSyncKeyCallback(ARTCompatibility.wrap(paramOnProtocolListener));
  }
  
  public static void SyncActiveSyncFolderStatus(Profile paramProfile, String paramString, int paramInt, OnProtocolListener paramOnProtocolListener)
  {
    ProtocolServiceNative.SyncActiveSyncFolderStatus(paramProfile, paramString, paramInt, ARTCompatibility.wrap(paramOnProtocolListener));
  }
  
  public static void SyncExchangeFolderStatus(Profile paramProfile, String paramString1, String paramString2, OnProtocolListener paramOnProtocolListener)
  {
    ProtocolServiceNative.SyncExchangeFolderStatus(paramProfile, paramString1, paramString2, ARTCompatibility.wrap(paramOnProtocolListener));
  }
  
  public static void SyncImapFolderStatus(Profile paramProfile, String paramString, OnProtocolListener paramOnProtocolListener)
  {
    ProtocolServiceNative.SyncImapFolderStatus(paramProfile, paramString, ARTCompatibility.wrap(paramOnProtocolListener));
  }
  
  public static void addFolder(Profile paramProfile, ReceiveState paramReceiveState, Mail.Folder paramFolder1, Mail.Folder paramFolder2, OnProtocolListener paramOnProtocolListener)
  {
    ProtocolServiceNative.addFolder(paramProfile, paramReceiveState, paramFolder1, paramFolder2, ARTCompatibility.wrap(paramOnProtocolListener));
  }
  
  public static void downloadAttachment(Profile paramProfile, String paramString, Mail paramMail, MailAttachment paramMailAttachment, OnProtocolListener paramOnProtocolListener)
  {
    ProtocolServiceNative.downloadAttachment(paramProfile, paramString, paramMail, paramMailAttachment, ARTCompatibility.wrap(paramOnProtocolListener));
  }
  
  public static void downloadMailsText(Profile paramProfile, String paramString, int paramInt1, int paramInt2, boolean paramBoolean, Mail[] paramArrayOfMail, OnProtocolListener paramOnProtocolListener)
  {
    ProtocolServiceNative.downloadMailsText(paramProfile, paramString, paramInt1, paramInt2, paramBoolean, paramArrayOfMail, ARTCompatibility.wrap(paramOnProtocolListener));
  }
  
  public static void fetchFolderList(Profile paramProfile, int paramInt1, boolean paramBoolean, int paramInt2, OnProtocolListener paramOnProtocolListener)
  {
    ProtocolServiceNative.fetchFolderList(paramProfile, paramInt1, paramBoolean, paramInt2, ARTCompatibility.wrap(paramOnProtocolListener));
  }
  
  public static void fetchMailList(Profile paramProfile, String[] paramArrayOfString, ReceiveState paramReceiveState, OnProtocolListener paramOnProtocolListener)
  {
    ProtocolServiceNative.fetchMailList(paramProfile, paramArrayOfString, paramReceiveState, ARTCompatibility.wrap(paramOnProtocolListener));
  }
  
  public static void login(Profile paramProfile, OnProtocolListener paramOnProtocolListener)
  {
    ProtocolServiceNative.login(paramProfile, ARTCompatibility.wrap(paramOnProtocolListener));
  }
  
  public static void modifyMailFlag(Profile paramProfile, ReceiveState paramReceiveState, String paramString, Mail[] paramArrayOfMail, int paramInt1, int paramInt2, OnProtocolListener paramOnProtocolListener)
  {
    ProtocolServiceNative.modifyMailFlag(paramProfile, paramReceiveState, paramString, paramArrayOfMail, paramInt1, paramInt2, ARTCompatibility.wrap(paramOnProtocolListener));
  }
  
  public static void moveMail(Profile paramProfile, String paramString1, String paramString2, String paramString3, String paramString4, String[] paramArrayOfString1, String[] paramArrayOfString2, OnProtocolListener paramOnProtocolListener)
  {
    ProtocolServiceNative.moveMail(paramProfile, paramString1, paramString2, paramString3, paramString4, paramArrayOfString1, paramArrayOfString2, ARTCompatibility.wrap(paramOnProtocolListener));
  }
  
  public static void parseMailFromEml(Profile paramProfile, Mail paramMail, String paramString1, String paramString2, OnProtocolListener paramOnProtocolListener)
  {
    ProtocolServiceNative.parseMailFromEml(paramProfile, paramMail, paramString1, paramString2, ARTCompatibility.wrap(paramOnProtocolListener));
  }
  
  public static void removeFolder(Profile paramProfile, ReceiveState paramReceiveState, Mail.Folder paramFolder, OnProtocolListener paramOnProtocolListener)
  {
    ProtocolServiceNative.removeFolder(paramProfile, paramReceiveState, paramFolder, ARTCompatibility.wrap(paramOnProtocolListener));
  }
  
  public static void removeMail(Profile paramProfile, ReceiveState paramReceiveState, String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, OnProtocolListener paramOnProtocolListener)
  {
    ProtocolServiceNative.removeMail(paramProfile, paramReceiveState, paramString, paramArrayOfString1, paramArrayOfString2, ARTCompatibility.wrap(paramOnProtocolListener));
  }
  
  public static void renameFolder(Profile paramProfile, ReceiveState paramReceiveState, Mail.Folder paramFolder1, Mail.Folder paramFolder2, String paramString, OnProtocolListener paramOnProtocolListener)
  {
    ProtocolServiceNative.renameFolder(paramProfile, paramReceiveState, paramFolder1, paramFolder2, paramString, ARTCompatibility.wrap(paramOnProtocolListener));
  }
  
  public static void searchExchangeGlobalAddressList(Profile paramProfile, String paramString, int paramInt1, int paramInt2, OnProtocolListener paramOnProtocolListener)
  {
    ProtocolServiceNative.searchExchangeGlobalAddressList(paramProfile, paramString, paramInt1, paramInt2, ARTCompatibility.wrap(paramOnProtocolListener));
  }
  
  public static void searchMail(Profile paramProfile, ReceiveState paramReceiveState, String[] paramArrayOfString, HashMap<Integer, String[]> paramHashMap, boolean paramBoolean, OnProtocolListener paramOnProtocolListener)
  {
    ProtocolServiceNative.searchMail(paramProfile, paramReceiveState, paramArrayOfString, paramHashMap, paramBoolean, ARTCompatibility.wrap(paramOnProtocolListener));
  }
  
  public static boolean sendMail(Profile paramProfile, Mail paramMail, OnProtocolListener paramOnProtocolListener)
  {
    return ProtocolServiceNative.sendMail(paramProfile, paramMail, ARTCompatibility.wrap(paramOnProtocolListener));
  }
  
  public static void syncMailToServer(Profile paramProfile, Mail paramMail, Mail.Folder paramFolder, OnProtocolListener paramOnProtocolListener)
  {
    ProtocolServiceNative.syncMailToServer(paramProfile, paramMail, paramFolder, paramOnProtocolListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.ProtocolService
 * JD-Core Version:    0.7.0.1
 */