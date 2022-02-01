package com.tencent.qqmail.protocol;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public class ProtocolServiceNative
{
  public static native boolean ActiveSyncCommandPing(Profile paramProfile, Exchange.ActiveSyncExtraInfo paramActiveSyncExtraInfo, OnProtocolListener paramOnProtocolListener);
  
  public static native void AddRule(Profile paramProfile, Exchange.ExchangeRule[] paramArrayOfExchangeRule, OnProtocolListener paramOnProtocolListener);
  
  public static native void Init(Context paramContext);
  
  public static native void InitFolderListSyncKeyMapping(Map<Integer, String> paramMap);
  
  public static native void InitLogger(String paramString, int paramInt);
  
  public static native void InitSyncKeyMapping(Map<Integer, String> paramMap);
  
  public static native void RemoveFolderListSyncKeys(int paramInt);
  
  public static native void RemoveSyncKeys(int[] paramArrayOfInt);
  
  public static native void SetFolderListSyncKey(int paramInt, String paramString);
  
  public static native void SetFolderListSyncKeyCallback(OnProtocolListener paramOnProtocolListener);
  
  public static native void SetFolderSyncKey(int paramInt, String paramString);
  
  public static native void SetIsART(boolean paramBoolean);
  
  public static native void SetMobileInfoCallback(OnProtocolListener paramOnProtocolListener);
  
  public static native void SetSyncKeyCallback(OnProtocolListener paramOnProtocolListener);
  
  public static native void SyncActiveSyncFolderStatus(Profile paramProfile, String paramString, int paramInt, OnProtocolListener paramOnProtocolListener);
  
  public static native void SyncExchangeFolderStatus(Profile paramProfile, String paramString1, String paramString2, OnProtocolListener paramOnProtocolListener);
  
  public static native void SyncImapFolderStatus(Profile paramProfile, String paramString, OnProtocolListener paramOnProtocolListener);
  
  public static native void addFolder(Profile paramProfile, ReceiveState paramReceiveState, Mail.Folder paramFolder1, Mail.Folder paramFolder2, OnProtocolListener paramOnProtocolListener);
  
  public static native void downloadAttachment(Profile paramProfile, String paramString, Mail paramMail, MailAttachment paramMailAttachment, OnProtocolListener paramOnProtocolListener);
  
  public static native void downloadMailsText(Profile paramProfile, String paramString, int paramInt1, int paramInt2, boolean paramBoolean, Mail[] paramArrayOfMail, OnProtocolListener paramOnProtocolListener);
  
  public static native void fetchFolderList(Profile paramProfile, int paramInt1, boolean paramBoolean, int paramInt2, OnProtocolListener paramOnProtocolListener);
  
  public static native void fetchMailList(Profile paramProfile, String[] paramArrayOfString, ReceiveState paramReceiveState, OnProtocolListener paramOnProtocolListener);
  
  public static native void login(Profile paramProfile, OnProtocolListener paramOnProtocolListener);
  
  public static native void modifyMailFlag(Profile paramProfile, ReceiveState paramReceiveState, String paramString, Mail[] paramArrayOfMail, int paramInt1, int paramInt2, OnProtocolListener paramOnProtocolListener);
  
  public static native void moveMail(Profile paramProfile, String paramString1, String paramString2, String paramString3, String paramString4, String[] paramArrayOfString1, String[] paramArrayOfString2, OnProtocolListener paramOnProtocolListener);
  
  public static native void parseMailFromEml(Profile paramProfile, Mail paramMail, String paramString1, String paramString2, OnProtocolListener paramOnProtocolListener);
  
  public static void preloadSo() {}
  
  public static native void removeFolder(Profile paramProfile, ReceiveState paramReceiveState, Mail.Folder paramFolder, OnProtocolListener paramOnProtocolListener);
  
  public static native void removeMail(Profile paramProfile, ReceiveState paramReceiveState, String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, OnProtocolListener paramOnProtocolListener);
  
  public static native void renameFolder(Profile paramProfile, ReceiveState paramReceiveState, Mail.Folder paramFolder1, Mail.Folder paramFolder2, String paramString, OnProtocolListener paramOnProtocolListener);
  
  public static native void searchExchangeGlobalAddressList(Profile paramProfile, String paramString, int paramInt1, int paramInt2, OnProtocolListener paramOnProtocolListener);
  
  public static native void searchMail(Profile paramProfile, ReceiveState paramReceiveState, String[] paramArrayOfString, HashMap<Integer, String[]> paramHashMap, boolean paramBoolean, OnProtocolListener paramOnProtocolListener);
  
  public static native boolean sendMail(Profile paramProfile, Mail paramMail, OnProtocolListener paramOnProtocolListener);
  
  public static native void syncMailToServer(Profile paramProfile, Mail paramMail, Mail.Folder paramFolder, OnProtocolListener paramOnProtocolListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.ProtocolServiceNative
 * JD-Core Version:    0.7.0.1
 */