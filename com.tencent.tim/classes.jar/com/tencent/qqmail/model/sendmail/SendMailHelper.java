package com.tencent.qqmail.model.sendmail;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.helper.QMWtLoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachProtocol;
import com.tencent.qqmail.card.model.QMCardData;
import com.tencent.qqmail.card.model.QMCardPara;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.model.mail.QMComposeDataManager;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.model.qmdomain.ComposeData;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.qmdomain.MailEditAttach;
import com.tencent.qqmail.model.qmdomain.MailFoldItem;
import com.tencent.qqmail.model.qmdomain.MailGroupContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.readmail.BigAttachHelper;
import com.tencent.qqmail.model.task.QMSendMailTask;
import com.tencent.qqmail.model.task.QMTask.QMTaskState;
import com.tencent.qqmail.model.task.QMTaskManager;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.model.verify.QMVerify;
import com.tencent.qqmail.register.util.RegisterUtil;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.common.QMMailContentParser;
import com.tencent.qqmail.utilities.dateextension.DateExtension;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;
import com.tencent.qqmail.utilities.encryptionalgorithm.RsaEncryption;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMFileEntity;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkConfig;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.qmnetwork.QMUrlUtil;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.template.Template;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class SendMailHelper
{
  public static final int FORWARD_TYPE_ATTACH_FORWARD = 8;
  public static final int FORWARD_TYPE_ATTACH_NOT_COMPLETE_DOWNLOAD = 4;
  public static final int FORWARD_TYPE_ATTACH_NOT_COMPLETE_NOT_DOWNLOAD = 5;
  public static final int FORWARD_TYPE_NORMAL = 1;
  public static final int FORWARD_TYPE_NOT_COMPLETE_DOWNLOAD = 2;
  public static final int FORWARD_TYPE_NOT_COMPLETE_NOT_DOWNLOAD = 3;
  public static final int FORWARD_TYPE_NOT_SHOW_ALL_IMG = 7;
  public static final int FORWARD_TYPE_SHOW_ALL_IMG = 6;
  public static final int NOT_FORWARD_MAIL = 0;
  public static final int SENDER_ADDRESSES_LENGTH = 4096;
  private static final String TAG = "SendMailHelper";
  private static int[] carbonCopyText = { 2131691267, 2131691268 };
  public static int[] forwardText;
  private static int[] forwardTextAliases;
  private static int[] receiverText;
  public static int[] replyText;
  private static int[] replyTextAliases;
  private static int[] sendTimeText;
  private static int[] senderText;
  private static int[] subjectText;
  private static int[] titleText = { 2131721147, 2131721148 };
  
  static
  {
    forwardText = new int[] { 2131694005, 2131694006 };
    forwardTextAliases = new int[] { 2131694004 };
    replyText = new int[] { 2131718809, 2131718810 };
    replyTextAliases = new int[] { 2131718808 };
    senderText = new int[] { 2131719516, 2131719517 };
    sendTimeText = new int[] { 2131719543, 2131719544 };
    receiverText = new int[] { 2131718629, 2131718630 };
    subjectText = new int[] { 2131720619, 2131720620 };
  }
  
  public static void autoRestartSendingTasks()
  {
    QMTaskManager localQMTaskManager = QMTaskManager.sharedInstance(1);
    if (localQMTaskManager == null) {
      return;
    }
    try
    {
      Iterator localIterator = localQMTaskManager.getTaskList().iterator();
      while (localIterator.hasNext())
      {
        QMSendMailTask localQMSendMailTask = (QMSendMailTask)localIterator.next();
        if ((localQMSendMailTask.getTaskState() == QMTask.QMTaskState.QMTaskStateFail) && (localQMSendMailTask.getVerifyKey() == null) && (localQMSendMailTask.getMail().getRetryCount() < 4)) {
          localQMTaskManager.autoRestart(localQMSendMailTask.getId());
        }
      }
    }
    finally {}
  }
  
  public static boolean calculateInlineImgs(String paramString, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    paramString = Pattern.compile("<img\\s+[^>]*\\s*src=\"file://localhost.*?>").matcher(paramString);
    for (boolean bool = paramString.find(); bool; bool = paramString.find())
    {
      Object localObject = paramString.group();
      Matcher localMatcher = Pattern.compile("(?<=/CachePhoto/).*?(?=\")").matcher((CharSequence)localObject);
      if (localMatcher.find()) {
        paramArrayList2.add(localMatcher.group());
      }
      localObject = Pattern.compile("(?<=src=\").*?(?=\")").matcher((CharSequence)localObject);
      if (((Matcher)localObject).find()) {
        paramArrayList1.add(new File(((Matcher)localObject).group().replaceAll("file://localhost", "")).getAbsolutePath());
      }
    }
    return (paramArrayList1.size() > 0) && (paramArrayList1.size() == paramArrayList2.size());
  }
  
  private static void collectForwardAttach(ComposeMailUI paramComposeMailUI, HashMap<String, String> paramHashMap, MailInformation paramMailInformation, int paramInt)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    Object localObject2;
    Object localObject1;
    String str;
    label119:
    Attach localAttach;
    boolean bool;
    if ((paramMailInformation.getAttachList() != null) && (paramMailInformation.getAttachList().size() > 0))
    {
      localObject2 = null;
      Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
      localObject1 = "";
      if (SharedPreferenceUtil.isWtlogin())
      {
        str = "wtlogin";
        QMLog.log(4, "SendMaillHelper", "getFwdType " + paramComposeMailUI.getFwdType() + " isAddFavAttach " + paramComposeMailUI.isAddFavAttach());
        Iterator localIterator = paramMailInformation.getAttachList().iterator();
        paramComposeMailUI = (ComposeMailUI)localObject2;
        paramMailInformation = (MailInformation)localObject1;
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localAttach = (Attach)localIterator.next();
            if (!isAttachNeedDownload(localAttach, localAccount))
            {
              bool = RsaEncryption.isLoginUsedRsa();
              if ((paramComposeMailUI != null) && (localAttach.getAccountId() == paramComposeMailUI.getId())) {
                break label569;
              }
              localObject2 = AccountManager.shareInstance().getAccountList().getAccountById(localAttach.getAccountId());
              if ((localObject2 != null) && ((localObject2 instanceof QQMailAccount)))
              {
                paramComposeMailUI = (QQMailAccount)localObject2;
                if ((SharedPreferenceUtil.isWtlogin()) && (!((Account)localObject2).isBizMail()) && (RsaEncryption.isLoginUsedRsa()))
                {
                  localObject1 = new StringBuilder().append(SharedPreferenceUtil.getLoginSvrUtc()).append("\t").append(((Account)localObject2).getUin()).append("\t").append(QMWtLoginManager.getInstance().getA2(((Account)localObject2).getUin())).append("\t");
                  if (((Account)localObject2).getSecondPassword() == null)
                  {
                    paramMailInformation = "";
                    label293:
                    localObject1 = RsaEncryption.encryptInBlock(paramMailInformation);
                    bool = true;
                    paramMailInformation = paramComposeMailUI;
                    paramComposeMailUI = (ComposeMailUI)localObject1;
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = localAttach.getName();
      try
      {
        localObject2 = StringExtention.urlEncode((String)localObject1);
        localObject1 = localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        for (;;)
        {
          localUnsupportedEncodingException1.printStackTrace();
        }
      }
      if (localAttach.getAlias() == null) {
        localAttach.setAlias("");
      }
      localObject1 = localAttach.getRemoteId() + "|" + localAttach.getAlias() + "|" + (String)localObject1 + "|" + paramMailInformation.getUin() + "|" + paramComposeMailUI + "|" + str + "|1";
      try
      {
        localObject2 = StringExtention.urlEncode((String)localObject1);
        localObject1 = localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        for (;;)
        {
          localUnsupportedEncodingException2.printStackTrace();
          continue;
          localStringBuilder2.append("&othermailattach=").append((String)localObject1);
        }
      }
      if (bool)
      {
        localStringBuilder2.append("&rothermailattach=").append((String)localObject1);
        localObject1 = paramMailInformation;
        paramMailInformation = paramComposeMailUI;
        paramComposeMailUI = (ComposeMailUI)localObject1;
        break label119;
        str = "3g";
        break;
        paramMailInformation = ((Account)localObject2).getSecondPassword();
        break label293;
        localObject1 = paramComposeMailUI.getAutologinKey();
        paramMailInformation = paramComposeMailUI;
        paramComposeMailUI = (ComposeMailUI)localObject1;
        continue;
      }
      paramHashMap.put("attLst", localStringBuilder1.toString());
      paramHashMap.put("othermailattLst", localStringBuilder2.toString());
      return;
      label569:
      localObject1 = paramComposeMailUI;
      paramComposeMailUI = paramMailInformation;
      paramMailInformation = (MailInformation)localObject1;
    }
  }
  
  public static String copyAttachToComposeCache(ComposeMailUI paramComposeMailUI, Attach paramAttach)
  {
    Object localObject = paramAttach.getPreview().getMyDisk();
    if (FileUtil.isFileExist((String)localObject))
    {
      String str = paramComposeMailUI.getComposeCacheFilePath();
      localObject = new File((String)localObject);
      str = FileUtil.createPhotoDirAtRootPath(str);
      str = str + paramAttach.getName();
      FileUtil.copyFile((File)localObject, new File(str));
      paramComposeMailUI = paramComposeMailUI.getAddAttachInfoList();
      if (paramComposeMailUI != null)
      {
        paramComposeMailUI = paramComposeMailUI.iterator();
        while (paramComposeMailUI.hasNext())
        {
          localObject = (AttachInfo)paramComposeMailUI.next();
          if ((((AttachInfo)localObject).getAttach() != null) && (((Attach)((AttachInfo)localObject).getAttach()).getHashId() == paramAttach.getHashId()))
          {
            ((AttachInfo)localObject).setPreviewPath(str);
            ((AttachInfo)localObject).setAttachPath(str);
            ((AttachInfo)localObject).setUploadDataPath(str);
          }
        }
      }
      return str;
    }
    return "";
  }
  
  public static String copyAttachToComposeCacheAndDelete(ComposeMailUI paramComposeMailUI, Attach paramAttach)
  {
    String str = paramAttach.getPreview().getMyDisk();
    paramComposeMailUI = copyAttachToComposeCache(paramComposeMailUI, paramAttach);
    FileUtil.delFile(str);
    QMLog.log(4, "SendMailHelper", "delelte file: " + str + " copy to " + str);
    return paramComposeMailUI;
  }
  
  public static String copyImgToComposeCache(ComposeMailUI paramComposeMailUI, String paramString)
  {
    String str = paramComposeMailUI.getComposeCacheFilePath();
    paramComposeMailUI = new File(paramString);
    str = FileUtil.createPhotoDirAtRootPath(str);
    paramString = str + QMMath.hashInt(paramString) + ".jpg";
    FileUtil.copyFile(paramComposeMailUI, new File(paramString));
    return paramString;
  }
  
  public static String filterCGIRequest(String paramString)
  {
    return paramString.replaceAll("(<\\s*img\\s+[^>]*\\s*src\\s*=\\s*\")/cgi-bin/", "$1" + QMNetworkConfig.getCgiRequestHost(0) + "/cgi-bin/").replaceAll("(<\\s*[aA]\\s+[^>]*\\s*href\\s*=\\s*\")/cgi-bin/", "$1" + QMNetworkConfig.getCgiRequestHost(0) + "/cgi-bin/");
  }
  
  private static ArrayList<Object> filterMySelf(ArrayList<Object> paramArrayList, Account paramAccount)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList == null) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramArrayList.size())
    {
      MailContact localMailContact = (MailContact)paramArrayList.get(i);
      paramAccount.getEncryptedUin();
      if (!isFromMySelf(localMailContact, paramAccount)) {
        localArrayList.add(localMailContact);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static String formatBigAttachs(ArrayList<Object> paramArrayList)
  {
    String str2 = Template.getTemplateSectionWithName(QMApplicationContext.sharedInstance(), Template.CONTENT_HTML_TEMPLATE, "bigattachItemWrapper");
    String str1 = "";
    int i = 0;
    if (i < paramArrayList.size())
    {
      MailBigAttach localMailBigAttach = (MailBigAttach)paramArrayList.get(i);
      String str3 = Template.getTemplateSectionWithName(QMApplicationContext.sharedInstance(), Template.CONTENT_HTML_TEMPLATE, "bigattachItem");
      HashMap localHashMap = new HashMap();
      Object localObject2 = localMailBigAttach.getSize();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localHashMap.put("size", localObject1);
      localObject2 = localMailBigAttach.getPreview().getDownloadUrl();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localHashMap.put("download", localObject1);
      localObject2 = localMailBigAttach.getName();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localHashMap.put("name", localObject1);
      localObject2 = localMailBigAttach.getExpire();
      if (localObject2 == null) {}
      for (localObject1 = "";; localObject1 = DateExtension.fullDateName_yyyyMMddHHmm((Date)localObject2))
      {
        localHashMap.put("expire", localObject1);
        localHashMap.put("expireTime", FtnCommonUtils.generateExpireTime((Date)localObject2));
        str1 = str1 + StringExtention.replaceWithDictionary(str3, localHashMap);
        i += 1;
        break;
      }
    }
    return StringExtention.replace(str2, "content", str1);
  }
  
  public static String formatEditAttaches(ArrayList<Object> paramArrayList)
  {
    String str2 = Template.getTemplateSectionWithName(QMApplicationContext.sharedInstance(), Template.CONTENT_HTML_TEMPLATE, "editAttachItemWrapper");
    String str1 = "";
    int i = 0;
    for (;;)
    {
      if (i < paramArrayList.size())
      {
        MailEditAttach localMailEditAttach = (MailEditAttach)paramArrayList.get(i);
        String str3 = Template.getTemplateSectionWithName(QMApplicationContext.sharedInstance(), Template.CONTENT_HTML_TEMPLATE, "editAttachItem");
        HashMap localHashMap = new HashMap();
        localHashMap.put("filename.DATA", localMailEditAttach.getName());
        localHashMap.put("filesize.DATA", localMailEditAttach.getSize());
        localHashMap.put("key.DATA", localMailEditAttach.getKey());
        localHashMap.put("icon.DATA", localMailEditAttach.getIcon());
        String str4 = localMailEditAttach.getName();
        try
        {
          localHashMap.put("encodename.DATA", new String(Base64.encode(str4.getBytes("gb18030"), 0)));
          localHashMap.put("bytelen.DATA", String.valueOf(StringExtention.sizeStrToLong(localMailEditAttach.getSize())));
          str1 = str1 + StringExtention.replaceWithDictionary(str3, localHashMap);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QMLog.log(6, "SendMailHelper", "formatEditAttach exception:" + localException.toString());
          }
        }
      }
    }
    return StringExtention.replace(str2, "content", str1);
  }
  
  public static String generateBinaryFiles(Account paramAccount, ComposeMailUI paramComposeMailUI, List<String> paramList1, List<String> paramList2, List<QMFileEntity> paramList)
  {
    String str1 = "";
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(paramList1);
    paramList1 = new ArrayList();
    paramList1.addAll(paramList2);
    paramList2 = paramComposeMailUI.getAddAttachInfoList();
    if (paramList2 != null)
    {
      paramList2 = paramList2.iterator();
      while (paramList2.hasNext())
      {
        AttachInfo localAttachInfo = (AttachInfo)paramList2.next();
        String str2 = localAttachInfo.getAttachName();
        String str3 = localAttachInfo.uploadDataPath;
        Object localObject = (Attach)localAttachInfo.getAttach();
        if (((isLocalMail(paramComposeMailUI, QMFolderManager.sharedInstance())) || (paramComposeMailUI.isForceDownload()) || (localAttachInfo.isBinaryAttach()) || (isAttachNeedDownload((Attach)localObject, paramAccount))) && (str3 != null) && (!str3.equals("")))
        {
          localObject = new File(str3);
          if (((File)localObject).exists())
          {
            paramList.add(new QMFileEntity((File)localObject, "application/octet-stream", str2));
            if ((localAttachInfo.isImage()) && (paramList1.contains(str2)))
            {
              while (paramList1.contains(str2)) {
                paramList1.remove(str2);
              }
              while ((localArrayList.contains(str3)) || (localArrayList.contains(StringExtention.replaceIllegalUrl(str3)))) {
                if (!localArrayList.remove(str3)) {
                  localArrayList.remove(StringExtention.replaceIllegalUrl(str3));
                }
              }
            }
          }
        }
      }
    }
    paramComposeMailUI = str1;
    int i;
    if (localArrayList.size() > 0)
    {
      paramComposeMailUI = str1;
      if (localArrayList.size() == paramList1.size())
      {
        i = 0;
        paramAccount = str1;
        paramComposeMailUI = paramAccount;
        if (i < localArrayList.size())
        {
          paramList2 = (String)paramList1.get(i);
          str1 = (String)localArrayList.get(i);
          if ((str1 == null) || (str1.equals(""))) {
            break label471;
          }
          paramComposeMailUI = new File(str1);
          if (paramComposeMailUI.exists()) {
            break label474;
          }
          paramComposeMailUI = new File(StringExtention.replaceBackIllegalUrl(str1));
        }
      }
    }
    label471:
    label474:
    for (;;)
    {
      if (paramComposeMailUI.exists())
      {
        paramComposeMailUI = new QMFileEntity(paramComposeMailUI, "application/octet-stream", paramList2);
        paramAccount = paramAccount + paramList2 + ",";
        paramList.add(paramComposeMailUI);
      }
      for (;;)
      {
        i += 1;
        break;
        return paramComposeMailUI;
      }
    }
  }
  
  public static Mail generateOriginMail(ComposeMailUI paramComposeMailUI)
  {
    Mail localMail = new Mail();
    Object localObject = new MailInformation();
    localMail.setInformation((MailInformation)localObject);
    ((MailInformation)localObject).setId(paramComposeMailUI.getOriginMailId());
    ((MailInformation)localObject).setAccountId(paramComposeMailUI.getOriginAccountId());
    ((MailInformation)localObject).setRemoteId(paramComposeMailUI.getOriginRemoteId());
    ((MailInformation)localObject).setMessageId(paramComposeMailUI.getOriginMessageId());
    ((MailInformation)localObject).setFolderId(paramComposeMailUI.getOriginFolderId());
    localObject = new MailStatus();
    ((MailStatus)localObject).setContentComplete(paramComposeMailUI.isOriginContentComplete());
    localMail.setStatus((MailStatus)localObject);
    localMail.setContent(new MailContent());
    return localMail;
  }
  
  private static String generateSubject(String paramString, ComposeMailUI.QMComposeMailType paramQMComposeMailType, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramQMComposeMailType == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLY) || (paramQMComposeMailType == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLYALL)) {
      paramQMComposeMailType = replyText;
    }
    int k;
    for (Object localObject = replyTextAliases;; localObject = forwardTextAliases)
    {
      j = paramQMComposeMailType.length;
      i = 0;
      while (i < j)
      {
        k = paramQMComposeMailType[i];
        localArrayList.add(QMApplicationContext.sharedInstance().getString(k));
        i += 1;
      }
      if (paramQMComposeMailType != ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_FORWARD) {
        break;
      }
      paramQMComposeMailType = forwardText;
    }
    return "" + paramString;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      k = localObject[i];
      localArrayList.add(QMApplicationContext.sharedInstance().getString(k));
      i += 1;
    }
    if ((paramString == null) || (paramString.equals(""))) {
      paramString = "";
    }
    for (;;)
    {
      if ((paramInt < 0) || (paramInt >= paramQMComposeMailType.length))
      {
        return paramString;
        i = 1;
      }
      while (i != 0)
      {
        Iterator localIterator = localArrayList.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localObject = paramString;
          for (j = i;; j = 1)
          {
            i = j;
            paramString = (String)localObject;
            if (localObject == null) {
              break;
            }
            i = j;
            paramString = (String)localObject;
            if (!((String)localObject).startsWith(str)) {
              break;
            }
            localObject = ((String)localObject).substring(str.length());
          }
        }
        continue;
        return (String)localArrayList.get(paramInt) + paramString;
      }
    }
  }
  
  @NonNull
  public static String getAddress(MailContact paramMailContact)
  {
    if (paramMailContact == null) {
      return "";
    }
    String str = paramMailContact.getNick();
    Object localObject = str;
    if (!TextUtils.isEmpty(str)) {
      localObject = str.replaceAll("\\\\", "\\\\\\\\").replaceAll("\"", "\\\\\"");
    }
    str = paramMailContact.getAddress();
    paramMailContact = (MailContact)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramMailContact = (MailContact)localObject;
      if (!TextUtils.isEmpty(str))
      {
        int i = str.indexOf('@');
        paramMailContact = (MailContact)localObject;
        if (-1 != i) {
          paramMailContact = str.substring(0, i);
        }
      }
    }
    QMLog.log(4, "SendMailHelper", "getAddress, nick: " + paramMailContact + ", address: " + str);
    localObject = new StringBuilder();
    if (!TextUtils.isEmpty(paramMailContact)) {
      ((StringBuilder)localObject).append("\"").append(paramMailContact).append("\"");
    }
    if (!TextUtils.isEmpty(str))
    {
      if (((StringBuilder)localObject).length() == 0) {
        ((StringBuilder)localObject).append("\"").append(str).append("\"");
      }
      ((StringBuilder)localObject).append("<").append(str).append(">");
    }
    return ((StringBuilder)localObject).toString();
  }
  
  public static String getAddresses(ArrayList<Object> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localStringBuilder.append(getAddress((MailContact)paramArrayList.next())).append(';');
      }
    }
    return localStringBuilder.toString();
  }
  
  public static ArrayList<Object> getAllReplyList(Mail paramMail, Account paramAccount)
  {
    ArrayList localArrayList = (ArrayList)paramMail.getInformation().getToList().clone();
    if (paramMail.getInformation().getCcList() != null) {
      localArrayList.addAll(paramMail.getInformation().getCcList());
    }
    return filterMySelf(localArrayList, paramAccount);
  }
  
  @Deprecated
  public static int getCharset()
  {
    return QMSettingManager.sharedInstance().getCharSet() % 2;
  }
  
  public static int getCharset(String paramString)
  {
    if (QMSettingManager.sharedInstance().getReplyForwardSubjectType() == 2) {}
    do
    {
      return 1;
      if (QMSettingManager.sharedInstance().getReplyForwardSubjectType() == 1) {
        return 0;
      }
    } while (!StringExtention.isChineseCharacter(paramString));
    return 0;
  }
  
  public static String getComposeGroupSendParam(HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    Object localObject2 = "ef=js&t=mobile_mgr.json&s=groupsend&qqgroupid=$from$&fmailid=$id$&content__html=$content$&subject=$subject$&signadded=yes&fattachlist=$attLst$&cattachelist=$cattLst$";
    if (paramHashMap.containsKey("devicetoken")) {
      localObject2 = "ef=js&t=mobile_mgr.json&s=groupsend&qqgroupid=$from$&fmailid=$id$&content__html=$content$&subject=$subject$&signadded=yes&fattachlist=$attLst$&cattachelist=$cattLst$" + "&devicetoken=$devicetoken$";
    }
    Object localObject1 = localObject2;
    if (paramHashMap.containsKey("os")) {
      localObject1 = (String)localObject2 + "&os=$os$";
    }
    localObject2 = localObject1;
    if (paramHashMap.containsKey("timezone")) {
      localObject2 = (String)localObject1 + "&timezone=$timezone$";
    }
    localObject1 = localObject2;
    if (paramHashMap.containsKey("notetype")) {
      localObject1 = ((String)localObject2 + "&notetype=true").replace("$attLst$", "");
    }
    localObject2 = localObject1;
    if (paramHashMap.containsKey("fwd"))
    {
      localObject2 = localObject1;
      if (!"".equals(paramHashMap.get("fwd"))) {
        localObject2 = (String)localObject1 + "&ReAndFw=forward&ReAndFwMailid=$fwd$";
      }
    }
    localObject1 = localObject2;
    if (paramHashMap.containsKey("rly"))
    {
      localObject1 = localObject2;
      if ("no".equals(paramHashMap.get("rly"))) {
        localObject1 = (String)localObject2 + "&isreply=no";
      }
    }
    localObject2 = paramHashMap.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      localObject1 = StringExtention.replaceWithEncodeURIValue((String)localObject1, (String)localEntry.getKey(), (String)localEntry.getValue());
    }
    localObject1 = ((String)localObject1).replace("$attLst$", "").replace("$cattLst$", "");
    if ((paramHashMap.get("fwdUin") != null) && (paramHashMap.get("fwdPwd") != null) && (SharedPreferenceUtil.isWtlogin()) && (!paramBoolean)) {
      localObject1 = (String)localObject1 + "&ltype=wtlogin";
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (!StringUtils.isBlank((String)paramHashMap.get("othermailattLst")))
      {
        localObject2 = localObject1;
        if (!paramHashMap.containsKey("notetype")) {
          localObject2 = (String)localObject1 + (String)paramHashMap.get("othermailattLst");
        }
      }
      return localObject2;
    }
  }
  
  public static HashMap<String, String> getComposeInfoFromMail(ComposeMailUI paramComposeMailUI)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = Aes.getEncodeDeviceToken();
    if (localObject1 != null) {
      localHashMap.put("devicetoken", localObject1);
    }
    localObject1 = paramComposeMailUI.getOs();
    if (localObject1 != null) {
      localHashMap.put("os", localObject1);
    }
    Object localObject2 = paramComposeMailUI.getInformation();
    int i = ((MailInformation)localObject2).getAccountId();
    if (((MailInformation)localObject2).getSendContact() != null) {
      localHashMap.put("sendmailname", ((MailInformation)localObject2).getSendContact().getAddress());
    }
    localHashMap.put("content", getContentFromMail(paramComposeMailUI));
    collectForwardAttach(paramComposeMailUI, localHashMap, (MailInformation)localObject2, i);
    String str1 = paramComposeMailUI.getReplyId();
    String str2 = paramComposeMailUI.getForwardId();
    long l1 = paramComposeMailUI.getRlyMailId();
    long l2 = paramComposeMailUI.getFwdMailId();
    Object localObject3 = QMMailManager.sharedInstance();
    localObject1 = null;
    if ((l1 != 0L) || (l2 != 0L)) {
      if (l1 != 0L)
      {
        localObject3 = ((QMMailManager)localObject3).readMailOrSearchMail(l1);
        if (localObject3 != null) {
          localObject1 = new MailUI((Mail)localObject3);
        }
      }
    }
    for (;;)
    {
      boolean bool;
      if ((localObject1 != null) && (((MailUI)localObject1).getStatus() != null))
      {
        bool = ((MailUI)localObject1).getStatus().isConversation();
        label208:
        if (0 != 0) {
          localHashMap.put("conv", null);
        }
        if (str1 != null)
        {
          if (localObject1 == null) {
            break label1023;
          }
          localObject1 = str1;
          label236:
          localHashMap.put("rly", localObject1);
        }
        if (str2 != null)
        {
          if (!bool) {
            break label1030;
          }
          localObject1 = null;
          label260:
          localHashMap.put("fwd", localObject1);
        }
      }
      for (;;)
      {
        if (paramComposeMailUI.getDraftId() != null) {
          localHashMap.put("draft", paramComposeMailUI.getDraftId());
        }
        if (((paramComposeMailUI.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_CLOCKED) || (paramComposeMailUI.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_CLOCKED_CARD)) && (paramComposeMailUI.getClockSendTime() != 0L))
        {
          localObject1 = Calendar.getInstance();
          ((Calendar)localObject1).setTimeInMillis(paramComposeMailUI.getClockSendTime());
          localHashMap.put("sendtime", "1");
          localHashMap.put("sendtimeyear", String.valueOf(((Calendar)localObject1).get(1)));
          localHashMap.put("sendtimemonth", String.valueOf(((Calendar)localObject1).get(2) + 1));
          localHashMap.put("sendtimeday", String.valueOf(((Calendar)localObject1).get(5)));
          localHashMap.put("sendtimehour", String.valueOf(((Calendar)localObject1).get(11)));
          localHashMap.put("sendtimemin", String.valueOf(((Calendar)localObject1).get(12)));
        }
        if (!paramComposeMailUI.getStatus().isGroupMail()) {
          break label1062;
        }
        if ((((MailInformation)localObject2).getRemoteId() != null) && (paramComposeMailUI.getReplyId() != null)) {
          localHashMap.put("id", ((MailInformation)localObject2).getRemoteId());
        }
        if (((MailInformation)localObject2).getGroupContact() != null) {
          localHashMap.put("from", ((MailInformation)localObject2).getGroupContact().getAddress());
        }
        if ((paramComposeMailUI.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_GROUP_FORWARD) && (paramComposeMailUI.getFwdType() != 8))
        {
          localHashMap.put("fwd", "");
          localHashMap.put("rly", "no");
        }
        if ((paramComposeMailUI.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_CLOCKED_CARD) || (paramComposeMailUI.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_CARD)) {
          localHashMap.put("separatedcopy", "bcc_true");
        }
        if (((MailInformation)localObject2).getSubject() == null) {
          break label1326;
        }
        localObject2 = ((MailInformation)localObject2).getSubject();
        localObject1 = localObject2;
        if ("".equals(localObject2))
        {
          localObject1 = localObject2;
          if (paramComposeMailUI.getType() != ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_GROUP) {
            localObject1 = QMApplicationContext.sharedInstance().getResources().getString(2131693126);
          }
        }
        localHashMap.put("subject", localObject1);
        label646:
        if ((paramComposeMailUI.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_NOTE_FORWARD) || (paramComposeMailUI.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_GROUP_NOTE_FORWARD)) {
          localHashMap.put("notetype", "true");
        }
        localObject2 = AccountManager.shareInstance().getAccountList();
        if (((paramComposeMailUI.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_FORWARD) || (paramComposeMailUI.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_GROUP_FORWARD)) && (paramComposeMailUI.getFwdType() != 8))
        {
          int j = paramComposeMailUI.getOriginAccountId();
          if ((i != -1) && (j != -1) && (i != j))
          {
            localObject3 = ((AccountList)localObject2).getAccountById(i);
            localObject1 = ((AccountList)localObject2).getAccountById(j);
            if ((((Account)localObject3).isQQMail()) && (((Account)localObject1).isQQMail()))
            {
              localHashMap.put("fwdUin", ((Account)localObject1).getUin());
              if ((!SharedPreferenceUtil.isWtlogin()) || (((Account)localObject1).isBizMail())) {
                break label1474;
              }
              localObject3 = QMWtLoginManager.getInstance().getA2(((Account)localObject1).getUin());
              if ((localObject3 != null) && (!((String)localObject3).equals(""))) {
                break label1340;
              }
              QMLog.log(6, "SendMaillHelper", "forward mail. wtlogin a2 not exist:" + ((Account)localObject1).getEmail());
            }
          }
        }
        label854:
        localHashMap.put("savesendbox", QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getString(i + "_" + "is_save_sendbox", "1"));
        ((AccountList)localObject2).getAccountById(i);
        if (paramComposeMailUI.getStatus().isGroupMail())
        {
          if ((str1 != null) && (!str1.equals(""))) {
            localHashMap.put("id", str1);
          }
          if ((StringUtils.isEmpty((CharSequence)localHashMap.get("id"))) && (!StringUtils.isEmpty(str2))) {
            localHashMap.put("id", str2);
          }
        }
        return localHashMap;
        localObject1 = ((QMMailManager)localObject3).readMailOrSearchMail(l2);
        if (localObject1 == null) {
          break label1501;
        }
        localObject1 = new MailUI((Mail)localObject1);
        break;
        bool = false;
        break label208;
        label1023:
        localObject1 = "";
        break label236;
        label1030:
        localObject1 = str2;
        break label260;
        localHashMap.put("rly", "");
        localHashMap.put("fwd", "");
      }
      label1062:
      localObject1 = getAddresses(((MailInformation)localObject2).getToList());
      localObject3 = getAddresses(((MailInformation)localObject2).getCcList());
      Object localObject4 = getAddresses(((MailInformation)localObject2).getBccList());
      if ((paramComposeMailUI.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_CLOCKED_CARD) || (paramComposeMailUI.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_CARD))
      {
        localHashMap.put("to", "");
        localHashMap.put("cc", localObject3);
        localHashMap.put("bcc", localObject1);
        localObject3 = paramComposeMailUI.getCardData();
        if (localObject3 != null)
        {
          localObject1 = ((QMCardData)localObject3).getCardParaList();
          if (localObject1 == null) {
            break label1494;
          }
          localObject1 = ((ArrayList)localObject1).iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject4 = (QMCardPara)((Iterator)localObject1).next();
          } while ((localObject4 == null) || (((QMCardPara)localObject4).getType() != 2));
        }
      }
      label1326:
      label1340:
      label1474:
      label1494:
      for (localObject1 = ((QMCardPara)localObject4).getValue();; localObject1 = "")
      {
        localHashMap.put("card_id", ((QMCardData)localObject3).getCardId());
        localHashMap.put("card_subid", paramComposeMailUI.getCardSubId());
        localHashMap.put("card_nick", localObject1);
        label1256:
        if (paramComposeMailUI.isSaved()) {}
        for (localObject1 = "1";; localObject1 = "0")
        {
          localHashMap.put("save", localObject1);
          break;
          localHashMap.put("cc", localObject3);
          localHashMap.put("to", localObject1);
          localHashMap.put("bcc", localObject4);
          break label1256;
        }
        localHashMap.put("subject", "");
        break label646;
        localObject3 = new StringBuilder().append(SharedPreferenceUtil.getLoginSvrUtc()).append("\t").append(((Account)localObject1).getUin()).append("\t").append((String)localObject3).append("\t");
        if (((Account)localObject1).getSecondPassword() == null)
        {
          localObject1 = "";
          label1398:
          localObject1 = (String)localObject1;
          if (!RsaEncryption.isLoginUsedRsa()) {
            break label1454;
          }
          localHashMap.put("rfwdPwd", RsaEncryption.encryptInBlock((String)localObject1));
        }
        for (;;)
        {
          localHashMap.put("wtlogin", "true");
          break;
          localObject1 = ((Account)localObject1).getSecondPassword();
          break label1398;
          localHashMap.put("fwdPwd", Aes.encode((String)localObject1, Aes.getServerKey()));
        }
        localHashMap.put("fwdPwd", ((QQMailAccount)localObject1).getAutologinKey());
        break label854;
      }
      label1454:
      label1501:
      localObject1 = null;
    }
  }
  
  public static ComposeMailUI getComposeMail(long paramLong, ComposeMailUI.QMComposeMailType paramQMComposeMailType)
  {
    return getComposeMail(paramLong, paramQMComposeMailType, false);
  }
  
  @Nullable
  public static ComposeMailUI getComposeMail(long paramLong, ComposeMailUI.QMComposeMailType paramQMComposeMailType, boolean paramBoolean)
  {
    int j = 0;
    Object localObject1 = QMMailManager.sharedInstance();
    if (paramLong == -1L) {
      return null;
    }
    localObject1 = ((QMMailManager)localObject1).readMailOrSearchMail(paramLong);
    if (localObject1 == null) {
      return null;
    }
    MailUI localMailUI = new MailUI((Mail)localObject1);
    ComposeMailUI localComposeMailUI = new ComposeMailUI(localMailUI);
    if ((localMailUI.getStatus().isConversationChild()) && ((paramQMComposeMailType == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLY) || (paramQMComposeMailType == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLYALL)))
    {
      localComposeMailUI.getStatus().setConversationChild(localMailUI.getInformation().getAccountId(), true);
      localComposeMailUI.getInformation().setConvHash(localMailUI.getInformation().getConvHash());
    }
    switch (SendMailHelper.1.$SwitchMap$com$tencent$qqmail$model$uidomain$ComposeMailUI$QMComposeMailType[paramQMComposeMailType.ordinal()])
    {
    }
    int i;
    label320:
    Object localObject2;
    Object localObject3;
    for (;;)
    {
      switch (SendMailHelper.1.$SwitchMap$com$tencent$qqmail$model$uidomain$ComposeMailUI$QMComposeMailType[paramQMComposeMailType.ordinal()])
      {
      default: 
        i = getCharset(localComposeMailUI.getInformation().getSubject());
        if ((paramQMComposeMailType == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_FORWARD) || (((paramQMComposeMailType == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLY) || (paramQMComposeMailType == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLYALL)) && (!localMailUI.getStatus().isGroupMail())))
        {
          localObject1 = localComposeMailUI.getInformation().getSubject();
          if (!paramBoolean)
          {
            localObject1 = generateSubject((String)localObject1, paramQMComposeMailType, i);
            localComposeMailUI.getInformation().setSubject((String)localObject1);
          }
        }
        setSender(paramQMComposeMailType, localComposeMailUI);
        setReplyList(paramQMComposeMailType, localComposeMailUI);
        switch (SendMailHelper.1.$SwitchMap$com$tencent$qqmail$model$uidomain$ComposeMailUI$QMComposeMailType[paramQMComposeMailType.ordinal()])
        {
        default: 
          if ((localMailUI.getStatus().isGroupMail()) && ((paramQMComposeMailType == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLY) || (paramQMComposeMailType == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLYALL))) {
            localComposeMailUI.getStatus().setGroupMail(true);
          }
          localComposeMailUI.createComposeCache();
          return localComposeMailUI;
          localComposeMailUI.setForwardId(localMailUI.getInformation().getRemoteId());
          localComposeMailUI.setFwdMailId(localMailUI.getInformation().getId());
          localComposeMailUI.getInformation().setRemoteId(new Date().getTime() + "");
          continue;
          localComposeMailUI.setReplyId(localMailUI.getInformation().getRemoteId());
          localComposeMailUI.setRlyMailId(localMailUI.getInformation().getId());
          localObject1 = QMMailManager.sharedInstance().readMailOrSearchMail(localMailUI.getInformation().getId());
          localObject2 = ((Mail)localObject1).getInformation().getMessageId();
          localObject3 = ((Mail)localObject1).getInformation().getReferences();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          if (!((String)localObject1).equals("")) {
            localComposeMailUI.getInformation().setReferences("<" + (String)localObject1 + ">" + (String)localObject2);
          }
          for (;;)
          {
            localComposeMailUI.getInformation().setRemoteId(null);
            localComposeMailUI.getInformation().setRemoteId(localComposeMailUI.getComposeId());
            break;
            if ((((String)localObject1).equals("")) && (((String)localObject2).equals("")))
            {
              localComposeMailUI.getInformation().setReferences("");
              localComposeMailUI.getInformation().setMessageId("");
            }
          }
          localComposeMailUI.getInformation().setMessageId(localMailUI.getInformation().getMessageId());
          localComposeMailUI.setDraftId(localMailUI.getInformation().getRemoteId());
          localComposeMailUI.setDraftMailId(localMailUI.getInformation().getId());
        }
        break;
      }
    }
    if (localComposeMailUI.getType() == null) {
      localComposeMailUI.setType(paramQMComposeMailType);
    }
    localObject1 = "";
    Object localObject4;
    if ((localMailUI.getContent() != null) && (localMailUI.getContent().getFold() != null) && (localMailUI.getContent().getFold().size() > 0))
    {
      localObject3 = localMailUI.getContent().getFold().iterator();
      for (localObject2 = ""; ((Iterator)localObject3).hasNext(); localObject2 = (String)localObject2 + ((MailFoldItem)localObject4).getContent()) {
        localObject4 = (MailFoldItem)((Iterator)localObject3).next();
      }
      if (localMailUI.getContent().getFoldText() == null) {
        break label1410;
      }
      localObject3 = localMailUI.getContent().getFoldText().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (MailFoldItem)((Iterator)localObject3).next();
        localObject1 = (String)localObject1 + ((MailFoldItem)localObject4).getContent();
      }
      i = 1;
    }
    for (;;)
    {
      localObject3 = localObject2;
      if (localObject2 == null) {
        localObject3 = "";
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      if ((i != 0) || (paramBoolean))
      {
        localObject1 = originDescribe(localMailUI, true, paramQMComposeMailType);
        localObject4 = originDescribe(localMailUI, false, paramQMComposeMailType);
        localComposeMailUI.getContent().setOrigin((String)localObject1 + "<br/>" + (String)localObject3);
        localComposeMailUI.getContent().setOriginText((String)localObject4 + "\r\n" + (String)localObject2);
        break;
        if ((localMailUI.getStatus().isGroupMail()) && (!paramBoolean))
        {
          if (paramQMComposeMailType == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLY)
          {
            localObject2 = "";
            localObject1 = "";
            i = 0;
            continue;
          }
          if (paramQMComposeMailType == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_FORWARD) {}
          localObject2 = localMailUI.getContent().getBody();
          localObject1 = localMailUI.getContent().getBodyText();
          i = 1;
          continue;
        }
        if ((localMailUI == null) || (localMailUI.getContent() == null))
        {
          localObject2 = "";
          localObject1 = "";
          i = 1;
          continue;
        }
        localObject1 = localMailUI.getContent().getDraft();
        if ((localObject1 != null) && (!((String)localObject1).equals("")))
        {
          localObject2 = localMailUI.getContent().getOrigin();
          localObject1 = localMailUI.getContent().getOriginText();
          i = 1;
          continue;
        }
        localObject2 = localMailUI.getContent().getBody();
        localObject1 = localMailUI.getContent().getBodyText();
        i = 1;
        continue;
      }
      localComposeMailUI.getContent().setOrigin("<br/><!--originqqmail-->");
      localComposeMailUI.getContent().setOriginText("");
      break;
      if (localComposeMailUI.getInformation().getAttachList() != null)
      {
        if ((localMailUI.getStatus().isGroupMail()) || (!localMailUI.getStatus().isProtocolMail())) {
          localComposeMailUI.getInformation().getAttachList().clear();
        }
      }
      else
      {
        label1239:
        if (localComposeMailUI.getInformation().getBigAttachList() != null) {
          localComposeMailUI.getInformation().getBigAttachList().clear();
        }
        if (localComposeMailUI.getInformation().getEditAttachList() == null) {
          break label320;
        }
        localComposeMailUI.getInformation().getEditAttachList().clear();
        break label320;
      }
      localObject1 = localComposeMailUI.getInformation().getAttachList();
      int k = ((ArrayList)localObject1).size();
      i = 0;
      label1306:
      if (j < k)
      {
        if (!((Attach)((ArrayList)localObject1).get(i)).isProtocol()) {
          break label1407;
        }
        if (!((Attach)((ArrayList)localObject1).get(i)).getProtocol().getType().equals("attachment")) {
          break label1376;
        }
        ((ArrayList)localObject1).remove(((ArrayList)localObject1).get(i));
      }
      label1376:
      label1407:
      for (;;)
      {
        j += 1;
        break label1306;
        break label1239;
        i += 1;
        continue;
        localComposeMailUI.getInformation().setBigAttachList(BigAttachHelper.filterExpireBigAttaches(localComposeMailUI.getInformation().getBigAttachList()));
        break;
      }
      label1410:
      localObject1 = "";
      i = 1;
    }
  }
  
  public static String getComposeSendParam(HashMap<String, String> paramHashMap, ComposeMailUI paramComposeMailUI)
  {
    int i = paramComposeMailUI.getInformation().getAccountId();
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(i);
    if (paramComposeMailUI.getStatus().isGroupMail()) {
      return getComposeGroupSendParam(paramHashMap, localAccount.isBizMail());
    }
    return getComposeSendParam(paramHashMap, localAccount.isBizMail());
  }
  
  public static String getComposeSendParam(HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if (paramHashMap == null)
    {
      localObject2 = "";
      return localObject2;
    }
    Object localObject2 = "ef=js&t=mobile_mgr.json&contenttype=html&to=$to$&cc=$cc$&bcc=$bcc$&subject=$subject$&content=$content$&savesendbox=$savesendbox$&signadded=yes";
    Object localObject1;
    if (paramHashMap.containsKey("conv"))
    {
      if (paramHashMap.containsKey("rly")) {
        localObject2 = "ef=js&t=mobile_mgr.json&contenttype=html&to=$to$&cc=$cc$&bcc=$bcc$&subject=$subject$&content=$content$&savesendbox=$savesendbox$&signadded=yes" + "&s=convrly&conv=$conv$";
      }
      localObject1 = localObject2;
      if (paramHashMap.containsKey("fwd")) {
        localObject1 = (String)localObject2 + "&s=convfwd&conv=$conv$";
      }
      localObject2 = localObject1;
      if (paramHashMap.containsKey("rly"))
      {
        localObject2 = localObject1;
        if (!"".equals(paramHashMap.get("rly"))) {
          localObject2 = (String)localObject1 + "&ReAndFw=reply&ReAndFwMailid=$rly$";
        }
      }
      localObject1 = localObject2;
      if (paramHashMap.containsKey("fwd"))
      {
        localObject1 = localObject2;
        if (!"".equals(paramHashMap.get("fwd")))
        {
          localObject1 = (String)localObject2 + "&ReAndFw=forward&ReAndFwMailid=$fwd$";
          localObject1 = (String)localObject1 + "&fattachlist=$attLst$&cattachelist=$cattLst$";
        }
      }
      if ((!paramHashMap.containsKey("fwdAttachMailId")) || ("".equals(paramHashMap.get("fwdAttachMailId")))) {
        break label1213;
      }
      localObject1 = (String)localObject1 + "&fmailid=$fwdAttachMailId$";
    }
    label1213:
    for (localObject2 = (String)localObject1 + "&fattachlist=$attLst$&cattachelist=$cattLst$&fmailid=$fwdAttachMailId$";; localObject2 = localObject1)
    {
      localObject1 = localObject2;
      if (paramHashMap.containsKey("save"))
      {
        localObject1 = localObject2;
        if (Integer.parseInt((String)paramHashMap.get("save")) == 1) {
          localObject1 = (String)localObject2 + "&actiontype=save&fattachlist=$attLst$&cattachelist=$cattLst$";
        }
      }
      localObject2 = localObject1;
      if (paramHashMap.containsKey("draft"))
      {
        localObject1 = (String)localObject1 + "&fmailid=$draft$";
        localObject2 = (String)localObject1 + "&fattachlist=$attLst$&cattachelist=$cattLst$";
      }
      localObject1 = localObject2;
      if (paramHashMap.containsKey("sendmailname")) {
        localObject1 = (String)localObject2 + "&sendmailname=$sendmailname$";
      }
      localObject2 = localObject1;
      if (paramHashMap.containsKey("sendname")) {
        localObject2 = (String)localObject1 + "&sendname=$sendname$";
      }
      localObject1 = localObject2;
      if (paramHashMap.containsKey("devicetoken")) {
        localObject1 = (String)localObject2 + "&devicetoken=$devicetoken$";
      }
      localObject2 = localObject1;
      if (paramHashMap.containsKey("timezone")) {
        localObject2 = (String)localObject1 + "&timezone=$timezone$";
      }
      localObject1 = localObject2;
      if (paramHashMap.containsKey("notetype")) {
        localObject1 = ((String)localObject2 + "&notetype=true").replace("$attLst$", "");
      }
      localObject2 = localObject1;
      if (paramHashMap.containsKey("sendtime")) {
        localObject2 = (String)localObject1 + "&sendtime=" + (String)paramHashMap.get("sendtime");
      }
      localObject1 = localObject2;
      if (paramHashMap.containsKey("sendtimeyear")) {
        localObject1 = (String)localObject2 + "&sendtimeyear=" + (String)paramHashMap.get("sendtimeyear");
      }
      localObject2 = localObject1;
      if (paramHashMap.containsKey("sendtimemonth")) {
        localObject2 = (String)localObject1 + "&sendtimemonth=" + (String)paramHashMap.get("sendtimemonth");
      }
      localObject1 = localObject2;
      if (paramHashMap.containsKey("sendtimeday")) {
        localObject1 = (String)localObject2 + "&sendtimeday=" + (String)paramHashMap.get("sendtimeday");
      }
      localObject2 = localObject1;
      if (paramHashMap.containsKey("sendtimehour")) {
        localObject2 = (String)localObject1 + "&sendtimehour=" + (String)paramHashMap.get("sendtimehour");
      }
      localObject1 = localObject2;
      if (paramHashMap.containsKey("sendtimemin")) {
        localObject1 = (String)localObject2 + "&sendtimemin=" + (String)paramHashMap.get("sendtimemin");
      }
      localObject2 = localObject1;
      if (paramHashMap.containsKey("separatedcopy")) {
        localObject2 = (String)localObject1 + "&separatedcopy=" + (String)paramHashMap.get("separatedcopy");
      }
      localObject1 = localObject2;
      if (paramHashMap.containsKey("card_id")) {
        localObject1 = (String)localObject2 + "&card_id=$card_id$";
      }
      localObject2 = localObject1;
      if (paramHashMap.containsKey("card_subid")) {
        localObject2 = (String)localObject1 + "&card_subid=$card_subid$";
      }
      localObject1 = localObject2;
      if (paramHashMap.containsKey("card_nick")) {
        localObject1 = (String)localObject2 + "&card_nick=$card_nick$";
      }
      localObject2 = paramHashMap.entrySet().iterator();
      Object localObject3;
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          localObject1 = StringExtention.replaceWithEncodeURIValue((String)localObject1, (String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
          continue;
          localObject1 = "ef=js&t=mobile_mgr.json&contenttype=html&to=$to$&cc=$cc$&bcc=$bcc$&subject=$subject$&content=$content$&savesendbox=$savesendbox$&signadded=yes" + "&s=send";
          break;
        }
      }
      localObject2 = ((String)localObject1).replace("$attLst$", "").replace("$cattLst$", "");
      localObject1 = localObject2;
      if (paramHashMap.get("fwdUin") != null)
      {
        localObject1 = localObject2;
        if (paramHashMap.get("fwdPwd") != null)
        {
          localObject3 = (String)paramHashMap.get("wtlogin");
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = localObject2;
            if (((String)localObject3).equals("true")) {
              localObject1 = (String)localObject2 + "&ltype=wtlogin";
            }
          }
        }
      }
      localObject2 = localObject1;
      if (StringUtils.isBlank((String)paramHashMap.get("othermailattLst"))) {
        break;
      }
      localObject2 = localObject1;
      if (paramHashMap.containsKey("notetype")) {
        break;
      }
      return (String)localObject1 + (String)paramHashMap.get("othermailattLst");
    }
  }
  
  @NonNull
  private static String getContentFromMail(ComposeMailUI paramComposeMailUI)
  {
    Object localObject1 = paramComposeMailUI.getContent();
    if ((localObject1 != null) && (((MailContent)localObject1).getOrigin() != null)) {
      localObject1 = "" + ((MailContent)localObject1).getBody();
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (paramComposeMailUI.getAddAttachInfoList() != null)
      {
        ArrayList localArrayList = new ArrayList();
        localObject2 = new ArrayList();
        int i = 0;
        label67:
        if (i < paramComposeMailUI.getAddAttachInfoList().size())
        {
          AttachInfo localAttachInfo = (AttachInfo)paramComposeMailUI.getAddAttachInfoList().get(i);
          if (localAttachInfo.isBigAttach())
          {
            ((Attach)localAttachInfo.getAttach()).setSize(localAttachInfo.getAttachSize());
            localArrayList.add(localAttachInfo.getAttach());
          }
          for (;;)
          {
            i += 1;
            break label67;
            if ((localObject1 == null) || (((MailContent)localObject1).getBody() == null)) {
              break label280;
            }
            localObject1 = "" + paramComposeMailUI.getContent().getBody();
            break;
            if (localAttachInfo.isEditAttach())
            {
              ((Attach)localAttachInfo.getAttach()).setSize(localAttachInfo.getAttachSize());
              ((ArrayList)localObject2).add(localAttachInfo.getAttach());
            }
          }
        }
        paramComposeMailUI = (ComposeMailUI)localObject1;
        if (((ArrayList)localObject2).size() > 0)
        {
          paramComposeMailUI = formatEditAttaches((ArrayList)localObject2);
          paramComposeMailUI = (String)localObject1 + paramComposeMailUI;
        }
        localObject2 = paramComposeMailUI;
        if (localArrayList.size() > 0)
        {
          localObject1 = formatBigAttachs(localArrayList);
          localObject2 = paramComposeMailUI + (String)localObject1;
        }
      }
      return localObject2;
      label280:
      localObject1 = "";
    }
  }
  
  public static String getGroupAddress(MailGroupContact paramMailGroupContact)
  {
    String str = paramMailGroupContact.getGid();
    paramMailGroupContact = str;
    if (str.indexOf("@groupmail.qq.com") == -1) {
      paramMailGroupContact = str + "@groupmail.qq.com";
    }
    return paramMailGroupContact;
  }
  
  public static ArrayList<String> getPhoneAccounts(ComposeMailUI paramComposeMailUI)
  {
    ArrayList localArrayList = new ArrayList();
    paramComposeMailUI = paramComposeMailUI.getInformation();
    paddingPhoneAccounts(localArrayList, paramComposeMailUI.getToList());
    paddingPhoneAccounts(localArrayList, paramComposeMailUI.getCcList());
    paddingPhoneAccounts(localArrayList, paramComposeMailUI.getBccList());
    return localArrayList;
  }
  
  public static ArrayList<Object> getReplyAllCcList(Mail paramMail)
  {
    ArrayList localArrayList2 = new ArrayList();
    int i = paramMail.getInformation().getAccountId();
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(i);
    if (paramMail.getInformation().getToList() != null) {
      localArrayList2.addAll(paramMail.getInformation().getCcList());
    }
    ArrayList localArrayList1 = localArrayList2;
    if (!isFromMyself(paramMail)) {
      localArrayList1 = filterMySelf(localArrayList2, localAccount);
    }
    return localArrayList1;
  }
  
  public static ArrayList<Object> getReplyAllToList(Mail paramMail)
  {
    MailContact localMailContact = paramMail.getInformation().getReply();
    if (localMailContact != null) {}
    ArrayList localArrayList;
    for (;;)
    {
      int i = paramMail.getInformation().getAccountId();
      Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(i);
      localArrayList = new ArrayList();
      if (paramMail.getInformation().getToList() != null) {
        localArrayList.addAll(paramMail.getInformation().getToList());
      }
      if (isFromMyself(paramMail)) {
        break;
      }
      localArrayList.add(0, localMailContact);
      return filterMySelf(uniqueContacts(localArrayList), localAccount);
      localMailContact = paramMail.getInformation().getFrom();
    }
    return localArrayList;
  }
  
  @NonNull
  public static String getSendMailSettingErrorMsg(int paramInt, String paramString1, String paramString2)
  {
    String str2 = "对方";
    String str1 = str2;
    if (!StringExtention.isNullOrEmpty(paramString2))
    {
      paramString2 = paramString2.split("@");
      str1 = str2;
      if (paramString2.length == 2) {
        str1 = paramString2[1];
      }
    }
    paramString2 = QMApplicationContext.sharedInstance();
    if (!StringExtention.isNullOrEmpty(paramString1))
    {
      if (paramString1.contains("User has no permission")) {
        return paramString2.getString(2131697369);
      }
      if (paramString1.contains("authentication failed")) {
        return paramString2.getString(2131697367);
      }
      if (paramString1.contains("IP is rejected, smtp auth error limit exceed")) {
        return paramString2.getString(2131697368);
      }
      if (paramString1.contains("554 DT:SPM")) {
        return String.format(paramString2.getString(2131697376), new Object[] { str1 });
      }
      if (paramString1.contains("550 User not found")) {
        return paramString2.getString(2131697370);
      }
    }
    switch (paramInt)
    {
    default: 
      return String.format(paramString2.getString(2131697371), new Object[] { str1 });
    case 354: 
      return String.format(paramString2.getString(2131697371), new Object[] { str1 });
    case 421: 
      return String.format(paramString2.getString(2131697372), new Object[] { str1 });
    case 552: 
      return String.format(paramString2.getString(2131697366), new Object[] { str1 });
    case 553: 
      return String.format(paramString2.getString(2131697373), new Object[] { str1 });
    }
    return String.format(paramString2.getString(2131697374), new Object[] { str1 });
  }
  
  public static String[] getSenderEmailAndNick(MailInformation paramMailInformation)
  {
    Object localObject = paramMailInformation.getSendContact();
    if (localObject != null) {
      if (StringUtils.isBlank(((MailContact)localObject).getName())) {
        if (StringUtils.isBlank(((MailContact)localObject).getNick())) {
          localObject = ((MailContact)localObject).getAddress();
        }
      }
    }
    for (paramMailInformation = paramMailInformation.getSendContact().getAddress();; paramMailInformation = AccountManager.shareInstance().getAccountList().getAccountById(paramMailInformation.getAccountId()).getSendEmail())
    {
      return new String[] { paramMailInformation, localObject };
      localObject = ((MailContact)localObject).getNick();
      break;
      localObject = ((MailContact)localObject).getName();
      break;
      localObject = QMSettingManager.sharedInstance().getAccountNick(paramMailInformation.getAccountId());
    }
  }
  
  public static String getStrFromCid(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    int i;
    do
    {
      do
      {
        do
        {
          return str;
          i = paramString.length();
          str = paramString;
        } while (i <= 0);
        str = paramString;
      } while (paramString.charAt(0) != '<');
      str = paramString;
    } while (paramString.charAt(i - 1) != '>');
    return paramString.substring(1, i - 1);
  }
  
  public static String getVerifyParams(QMVerify paramQMVerify)
  {
    String str = "";
    if (paramQMVerify != null)
    {
      paramQMVerify = StringExtention.replaceWithEncodeURIValue(StringExtention.replaceWithEncodeURIValue(StringExtention.replaceWithEncodeURIValue(StringExtention.replaceWithEncodeURIValue("&verifycode=$verifycode$&verifykey=$verifykey$&mverifysession=$mverifysession$&qm_authimgs_id=$qm_authimgs_id$", "verifycode", String.valueOf(paramQMVerify.getVerifyCode())), "verifykey", String.valueOf(paramQMVerify.getVerifyKey())), "mverifysession", String.valueOf(paramQMVerify.getVerifySession())), "qm_authimgs_id", String.valueOf(paramQMVerify.getAuthImagesId()));
      str = "" + paramQMVerify;
    }
    return str;
  }
  
  private static boolean isAddressInComposeData(ComposeData paramComposeData, String paramString)
  {
    if ((paramComposeData == null) || (paramComposeData.getAlias_set() == null) || (paramString == null) || ("".endsWith(paramString))) {
      return false;
    }
    paramComposeData = paramComposeData.getAlias_set().iterator();
    while (paramComposeData.hasNext()) {
      if (((String)paramComposeData.next()).equalsIgnoreCase(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isAddressToLong(ArrayList<Object> paramArrayList)
  {
    return getAddresses(paramArrayList).length() > 4096;
  }
  
  public static boolean isAttachNeedDownload(Attach paramAttach, Account paramAccount)
  {
    if (paramAttach == null) {}
    for (;;)
    {
      return false;
      if ((paramAccount != null) && (!paramAttach.isBigAttach()))
      {
        if (paramAttach.isProtocol()) {
          return true;
        }
        paramAttach = AccountManager.shareInstance().getAccountList().getAccountById(paramAttach.getAccountId());
        if ((paramAttach != null) && (paramAccount.getId() != paramAttach.getId()))
        {
          if ((paramAccount.isQQMail()) && (paramAttach.isQQMail()) && (!paramAttach.isBizMail()) && (!paramAccount.isBizMail())) {}
          for (int i = 1; i == 0; i = 0) {
            return true;
          }
        }
      }
    }
  }
  
  public static boolean isFromMySelf(MailContact paramMailContact, Account paramAccount)
  {
    return (paramMailContact != null) && (paramAccount != null) && ((TextUtils.equals(paramMailContact.getAddress(), paramAccount.getEmail())) || ((!TextUtils.isEmpty(paramAccount.getEncryptedUin())) && (TextUtils.equals(paramAccount.getEncryptedUin(), paramMailContact.getUin()))));
  }
  
  private static boolean isFromMyself(Mail paramMail)
  {
    String str = paramMail.getInformation().getFrom().getAddress();
    int i = paramMail.getInformation().getAccountId();
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(i);
    paramMail = QMMailManager.sharedInstance().getComposeData(i);
    if (paramMail == null) {}
    for (paramMail = new ArrayList(); localAccount.isQQMail(); paramMail = paramMail.getFilterAliasSet()) {
      return paramMail.contains(str);
    }
    return str.equals(localAccount.getEmail());
  }
  
  private static boolean isLocalMail(ComposeMailUI paramComposeMailUI, QMFolderManager paramQMFolderManager)
  {
    boolean bool2 = paramComposeMailUI.getStatus().isLocalMail();
    boolean bool1 = bool2;
    if (paramQMFolderManager.getDraftFolderId(paramComposeMailUI.getOriginAccountId()) == paramComposeMailUI.getOriginFolderId())
    {
      if ((bool2) && (!paramComposeMailUI.getOriginRemoteId().startsWith("Z"))) {
        bool1 = true;
      }
    }
    else {
      return bool1;
    }
    return false;
  }
  
  public static boolean isRlyHideInline(ComposeMailUI paramComposeMailUI)
  {
    return ((paramComposeMailUI.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLY) || (paramComposeMailUI.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLYALL)) && ((QMSettingManager.sharedInstance().getMailLoadImgType() == 2) || (QMNetworkUtils.isMobileConnected(QMApplicationContext.sharedInstance())));
  }
  
  public static boolean isShowReplyAll(Mail paramMail, Account paramAccount)
  {
    paramMail = getAllReplyList(paramMail, paramAccount);
    if (paramMail == null) {}
    while (paramMail.size() <= 0) {
      return false;
    }
    return true;
  }
  
  private static String originDescribe(MailUI paramMailUI, boolean paramBoolean, ComposeMailUI.QMComposeMailType paramQMComposeMailType)
  {
    int i = getCharset(paramMailUI.getInformation().getSubject());
    String str7 = getAddresses(paramMailUI.getInformation().getCcList());
    String str5 = getAddress(paramMailUI.getInformation().getFrom());
    String str6 = DateExtension.fullDateName_yyyyMMddHHmmss(paramMailUI.getInformation().getDate(), i);
    paramQMComposeMailType = paramMailUI.getInformation().getSubject();
    String str4 = "\n";
    Object localObject = paramQMComposeMailType;
    String str2 = str6;
    String str3 = str5;
    String str1 = str7;
    if (paramBoolean)
    {
      str4 = "<br/>";
      str1 = StringExtention.htmlEncode(str7);
      str2 = StringExtention.htmlEncode(str6);
      str3 = StringExtention.htmlEncode(str5);
      localObject = StringExtention.htmlEncode(paramQMComposeMailType);
    }
    boolean bool = paramMailUI.getStatus().isGroupMail();
    paramQMComposeMailType = QMApplicationContext.sharedInstance().getString(titleText[i]);
    if (bool)
    {
      paramQMComposeMailType = paramQMComposeMailType + str4 + QMApplicationContext.sharedInstance().getString(senderText[i]) + paramMailUI.getInformation().getFrom().getNick();
      str5 = paramQMComposeMailType + str4 + QMApplicationContext.sharedInstance().getString(sendTimeText[i]) + str2;
      paramQMComposeMailType = str5;
      if (!bool)
      {
        str5 = str5 + str4 + QMApplicationContext.sharedInstance().getString(receiverText[i]) + getAddresses(paramMailUI.getInformation().getToList());
        paramQMComposeMailType = str5;
        if (str1 != null)
        {
          paramQMComposeMailType = str5;
          if (!str1.equals("")) {
            paramQMComposeMailType = str5 + str4 + QMApplicationContext.sharedInstance().getString(carbonCopyText[i]) + str1;
          }
        }
      }
      paramQMComposeMailType = paramQMComposeMailType + str4 + QMApplicationContext.sharedInstance().getString(subjectText[i]) + (String)localObject + str4;
      if (paramBoolean)
      {
        paramQMComposeMailType = "<div style=\"font-size:12px;padding:2px 0;\">" + QMApplicationContext.sharedInstance().getString(titleText[i]) + "</div>";
        paramQMComposeMailType = paramQMComposeMailType + "<div style=\"font-size:12px;background:#f0f0f0;color:#212121;padding:8px!important;border-radius:4px;line-height:1.5;\">";
        if (!bool) {
          break label836;
        }
        str3 = StringExtention.htmlEncode(paramMailUI.getInformation().getFrom().getNick());
      }
    }
    label836:
    for (paramQMComposeMailType = paramQMComposeMailType + "<div><b>" + QMApplicationContext.sharedInstance().getString(senderText[i]) + "</b> " + str3 + "</div>";; paramQMComposeMailType = paramQMComposeMailType + "<div><b>" + QMApplicationContext.sharedInstance().getString(senderText[i]) + "</b> " + str3 + "</div>")
    {
      str2 = paramQMComposeMailType + "<div><b>" + QMApplicationContext.sharedInstance().getString(sendTimeText[i]) + "</b> " + str2 + "</div>";
      paramQMComposeMailType = str2;
      if (!bool)
      {
        paramMailUI = StringExtention.htmlEncode(getAddresses(paramMailUI.getInformation().getToList()));
        paramMailUI = str2 + "<div><b>" + QMApplicationContext.sharedInstance().getString(receiverText[i]) + "</b> " + paramMailUI + "</div>";
        paramQMComposeMailType = paramMailUI;
        if (str1 != null)
        {
          paramQMComposeMailType = paramMailUI;
          if (!str1.equals("")) {
            paramQMComposeMailType = paramMailUI + "<div><b>" + QMApplicationContext.sharedInstance().getString(carbonCopyText[i]) + "</b> " + str1 + "</div>";
          }
        }
      }
      paramMailUI = paramQMComposeMailType + "<div><b>" + QMApplicationContext.sharedInstance().getString(subjectText[i]) + "</b> " + (String)localObject + "</div>";
      paramQMComposeMailType = paramMailUI + "</div>";
      return paramQMComposeMailType;
      paramQMComposeMailType = paramQMComposeMailType + str4 + QMApplicationContext.sharedInstance().getString(senderText[i]) + str3;
      break;
    }
  }
  
  private static void paddingPhoneAccounts(ArrayList<String> paramArrayList, ArrayList<Object> paramArrayList1)
  {
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0))
    {
      int i = 0;
      if (i < paramArrayList1.size())
      {
        MailContact localMailContact = (MailContact)paramArrayList1.get(i);
        String str;
        if (localMailContact.getType() == MailContact.ContactType.PhoneContact)
        {
          str = localMailContact.getAddress();
          if (!RegisterUtil.isMobiPhoneNum(str)) {
            break label93;
          }
          paramArrayList.add(str);
          localMailContact.setAddress(str + "@qq.com");
        }
        for (;;)
        {
          i += 1;
          break;
          label93:
          if ((str.contains("@qq.com")) && (RegisterUtil.isMobiPhoneNum(str.split("@")[0]))) {
            paramArrayList.add(str);
          }
        }
      }
    }
  }
  
  public static ArrayList<AttachInfo> prepareFwdUploadAttList(ComposeMailUI paramComposeMailUI)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = paramComposeMailUI.getAddAttachInfoList();
    if (localArrayList2 != null)
    {
      Object localObject = paramComposeMailUI.getDraftId();
      int i;
      if ((paramComposeMailUI.isAddFavAttach()) || (!StringUtils.isBlank((CharSequence)localObject)) || (paramComposeMailUI.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_NOTE_FORWARD) || ((paramComposeMailUI.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_FORWARD) && (paramComposeMailUI.getFwdType() != 5)) || (paramComposeMailUI.getFwdType() == 8))
      {
        i = paramComposeMailUI.getInformation().getAccountId();
        localObject = AccountManager.shareInstance().getAccountList().getAccountById(i);
        if ((localObject != null) && (((Account)localObject).isQQMail())) {
          i = 0;
        }
      }
      while (i < localArrayList2.size())
      {
        AttachInfo localAttachInfo = (AttachInfo)localArrayList2.get(i);
        Attach localAttach = (Attach)localAttachInfo.getAttach();
        if ((localAttach != null) && (isAttachNeedDownload(localAttach, (Account)localObject)) && (!prepareFwdUploadAttach(paramComposeMailUI, localAttachInfo))) {
          localArrayList1.add(localAttachInfo);
        }
        i += 1;
        continue;
        i = 0;
        while (i < localArrayList2.size())
        {
          localObject = (AttachInfo)localArrayList2.get(i);
          if ((localObject != null) && (!prepareFwdUploadAttach(paramComposeMailUI, (AttachInfo)localObject))) {
            localArrayList1.add(localObject);
          }
          i += 1;
          continue;
          if (paramComposeMailUI.isForceDownload())
          {
            i = 0;
            while (i < localArrayList2.size())
            {
              localObject = (AttachInfo)localArrayList2.get(i);
              if ((localObject != null) && (!prepareFwdUploadAttach(paramComposeMailUI, (AttachInfo)localObject))) {
                localArrayList1.add(localObject);
              }
              i += 1;
            }
          }
        }
      }
    }
    return localArrayList1;
  }
  
  public static boolean prepareFwdUploadAttach(ComposeMailUI paramComposeMailUI, AttachInfo paramAttachInfo)
  {
    if ((paramAttachInfo.isBigAttach()) || ((paramAttachInfo.uploadDataPath != null) && (!paramAttachInfo.uploadDataPath.equals(""))) || ((paramAttachInfo.getAttachPath() != null) && (!paramAttachInfo.getAttachPath().equals(""))))
    {
      if (((paramAttachInfo.uploadDataPath == null) || (paramAttachInfo.uploadDataPath.equals(""))) && (paramAttachInfo.getAttachPath() != null) && (!paramAttachInfo.getAttachPath().equals(""))) {
        paramAttachInfo.uploadDataPath = paramAttachInfo.getAttachPath();
      }
      return (paramAttachInfo == null) || (paramAttachInfo.uploadDataPath == null) || (!paramAttachInfo.uploadDataPath.startsWith("http:"));
    }
    if (paramAttachInfo.isEditAttach()) {
      return true;
    }
    paramAttachInfo = (Attach)paramAttachInfo.getAttach();
    if ((paramAttachInfo != null) && (paramAttachInfo.getPreview() != null) && (paramAttachInfo.isExist()))
    {
      copyAttachToComposeCache(paramComposeMailUI, paramAttachInfo);
      return true;
    }
    return false;
  }
  
  public static ArrayList<Attach> prepareInlineImgAttachList(ComposeMailUI paramComposeMailUI, boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    List localList = QMMailContentParser.findAllImages(paramComposeMailUI.getContent().getBody());
    int i;
    if ((paramComposeMailUI.isRlyHideInline()) || (paramComposeMailUI.getFwdType() == 7))
    {
      if (localList != null) {
        i = 0;
      }
    }
    else {
      while (i < localList.size())
      {
        Object localObject1 = (String)localList.get(i);
        if ((((String)localObject1).startsWith("cid:")) || (QMUrlUtil.isViewFile((String)localObject1)) || (((String)localObject1).contains("cgi-bin/groupattachment")) || (((String)localObject1).equals("file:///android_asset/pic_text.png"))) {
          paramComposeMailUI.getContent().setBody(updateInlineImgsToHTML(paramComposeMailUI.getContent().getBody(), (String)localObject1, "<span style=\"display:inline-block; background: #eee; padding: 3px 5px; line-height:1.5; font-size: 12px; color: #999\">原文图片</span>"));
        }
        i += 1;
        continue;
        i = paramComposeMailUI.getInformation().getAccountId();
        localObject1 = AccountManager.shareInstance().getAccountList().getAccountById(i);
        ArrayList localArrayList2 = paramComposeMailUI.getInformation().getAttachList();
        if ((localList != null) && (localArrayList2 != null))
        {
          i = 0;
          while (i < localList.size())
          {
            String str1 = (String)localList.get(i);
            Object localObject2;
            if (str1.startsWith("cid:"))
            {
              localObject2 = localArrayList2.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                Attach localAttach = (Attach)((Iterator)localObject2).next();
                if ((localAttach != null) && (StringUtils.equals(localAttach.getProtocol().getCid(), removeInlineImgCid(str1)))) {
                  if (localAttach.isExist())
                  {
                    String str2 = copyAttachToComposeCache(paramComposeMailUI, localAttach);
                    paramComposeMailUI.getContent().setBody(updateInlineImgsByComposeCache(paramComposeMailUI.getContent().getBody(), getStrFromCid(localAttach.getProtocol().getCid()), "file://localhost" + str2));
                    paramComposeMailUI.getContent().setOrigin(updateInlineImgsByComposeCache(paramComposeMailUI.getContent().getOrigin(), getStrFromCid(localAttach.getProtocol().getCid()), "file://localhost" + str2));
                  }
                  else
                  {
                    localAttach.setIsInline(true);
                    localArrayList1.add(localAttach);
                  }
                }
              }
            }
            if (((QMUrlUtil.isViewFile(str1)) || (str1.contains("cgi-bin/groupattachment")) || (str1.contains("cgi-bin/download"))) && ((!((Account)localObject1).isQQMail()) || (paramBoolean)))
            {
              localObject2 = new Attach(false);
              ((Attach)localObject2).setIsInline(true);
              ((Attach)localObject2).setHttpUrl(str1);
              ((Attach)localObject2).setHashId(QMMath.hashInt(str1));
              localArrayList1.add(localObject2);
            }
            i += 1;
          }
        }
      }
    }
    return localArrayList1;
  }
  
  public static ArrayList<Attach> prepareUploadAttachList(ComposeMailUI paramComposeMailUI, boolean paramBoolean)
  {
    new ArrayList();
    ArrayList localArrayList = new ArrayList();
    if (paramComposeMailUI.getFwdType() != 5) {
      localArrayList = prepareFwdUploadAttList(paramComposeMailUI);
    }
    for (;;)
    {
      paramComposeMailUI = prepareInlineImgAttachList(paramComposeMailUI, paramBoolean);
      int i = 0;
      while (i < localArrayList.size())
      {
        Attach localAttach = (Attach)((AttachInfo)localArrayList.get(i)).getAttach();
        if (localAttach != null) {
          paramComposeMailUI.add(localAttach);
        }
        i += 1;
      }
      return paramComposeMailUI;
    }
  }
  
  public static String removeInlineImgCid(String paramString)
  {
    return paramString.replaceAll("^cid:", "");
  }
  
  public static String replaceDefaultImg(String paramString1, String paramString2)
  {
    if (paramString2.contains("cid:")) {}
    for (String str1 = StringExtention.filterRegxpllega(paramString2.replace("cid:", ""));; str1 = StringExtention.MD5With32Charactor(paramString2))
    {
      String str2 = paramString1;
      if (!str1.equals("")) {
        str2 = paramString1.replaceAll("(<\\s*img\\s+[^>]*\\s*src\\s*=\\s*\")" + StringExtention.filterRegxpllega(paramString2) + "(\"\\s*[^>]*\\s*>)", "$1" + "file:///android_asset/spacer.png" + "\" cid=\"" + str1 + "$2");
      }
      return str2;
    }
  }
  
  public static void revertAllSendingTask()
  {
    QMTaskManager localQMTaskManager = QMTaskManager.sharedInstance(1);
    if (localQMTaskManager != null) {
      localQMTaskManager.revertAllTask();
    }
  }
  
  private static void setReplyList(ComposeMailUI.QMComposeMailType paramQMComposeMailType, ComposeMailUI paramComposeMailUI)
  {
    Object localObject = paramComposeMailUI.getInformation().getReply();
    ArrayList localArrayList;
    if (localObject != null)
    {
      localArrayList = new ArrayList();
      switch (SendMailHelper.1.$SwitchMap$com$tencent$qqmail$model$uidomain$ComposeMailUI$QMComposeMailType[paramQMComposeMailType.ordinal()])
      {
      default: 
        label56:
        if (paramQMComposeMailType == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLYALL)
        {
          localObject = getReplyAllCcList(paramComposeMailUI);
          paramComposeMailUI.getInformation().setCcList((ArrayList)localObject);
        }
        break;
      }
    }
    for (;;)
    {
      if ((paramQMComposeMailType != ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_DRAFT) && (paramComposeMailUI.getInformation().getBccList() != null)) {
        paramComposeMailUI.getInformation().getBccList().clear();
      }
      return;
      localObject = paramComposeMailUI.getInformation().getFrom();
      break;
      if (paramComposeMailUI.getInformation().getToList() == null) {
        break label56;
      }
      paramComposeMailUI.getInformation().getToList().clear();
      paramComposeMailUI.getInformation().setToList(null);
      break label56;
      paramComposeMailUI.getInformation().setToList(getReplyAllToList(paramComposeMailUI));
      break label56;
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      paramComposeMailUI.getInformation().setToList(localArrayList);
      break label56;
      if ((paramQMComposeMailType != ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_DRAFT) && (paramComposeMailUI.getInformation().getCcList() != null)) {
        paramComposeMailUI.getInformation().getCcList().clear();
      }
    }
  }
  
  private static void setSender(ComposeMailUI.QMComposeMailType paramQMComposeMailType, ComposeMailUI paramComposeMailUI)
  {
    Object localObject2 = AccountManager.shareInstance().getAccountList().getAccountById(paramComposeMailUI.getInformation().getAccountId());
    Object localObject1 = QMComposeDataManager.sharedInstance().getComposeData(((Account)localObject2).getId());
    MailContact localMailContact = new MailContact();
    if (localObject1 != null)
    {
      localMailContact.setAddress(((ComposeData)localObject1).getDefaultName());
      localMailContact.setName(((Account)localObject2).getName());
      localMailContact.setNick(((Account)localObject2).getName());
    }
    int i;
    switch (SendMailHelper.1.$SwitchMap$com$tencent$qqmail$model$uidomain$ComposeMailUI$QMComposeMailType[paramQMComposeMailType.ordinal()])
    {
    default: 
    case 2: 
    case 3: 
      do
      {
        return;
        localMailContact.setAddress(((Account)localObject2).getSendEmail());
        localMailContact.setName(((Account)localObject2).getName());
        localMailContact.setNick(((Account)localObject2).getName());
        break;
        if (!paramComposeMailUI.getStatus().isGroupMail()) {
          break label181;
        }
        paramComposeMailUI.getInformation().setSendContact(localMailContact);
        i = 0;
      } while (i != 0);
      paramComposeMailUI.getInformation().setSendContact(localMailContact);
      return;
      label181:
      QMMailManager.sharedInstance();
      paramQMComposeMailType = paramComposeMailUI.getInformation().getToList();
      if ((paramQMComposeMailType != null) && (paramQMComposeMailType.size() > 0))
      {
        paramQMComposeMailType = (MailContact)paramQMComposeMailType.get(0);
        if ((paramQMComposeMailType != null) && (isAddressInComposeData((ComposeData)localObject1, paramQMComposeMailType.getAddress())))
        {
          localObject2 = new MailContact();
          ((MailContact)localObject2).setAddress(paramQMComposeMailType.getAddress());
          ((MailContact)localObject2).setName(paramQMComposeMailType.getName());
          ((MailContact)localObject2).setNick(paramQMComposeMailType.getNick());
          paramComposeMailUI.getInformation().setSendContact((MailContact)localObject2);
        }
      }
      break;
    }
    for (int j = 1;; j = 0)
    {
      paramQMComposeMailType = paramComposeMailUI.getInformation().getCcList();
      i = j;
      if (j != 0) {
        break;
      }
      i = j;
      if (paramQMComposeMailType == null) {
        break;
      }
      i = j;
      if (paramQMComposeMailType.size() <= 0) {
        break;
      }
      paramQMComposeMailType = (MailContact)paramQMComposeMailType.get(0);
      i = j;
      if (paramQMComposeMailType == null) {
        break;
      }
      i = j;
      if (!isAddressInComposeData((ComposeData)localObject1, paramQMComposeMailType.getAddress())) {
        break;
      }
      localObject1 = new MailContact();
      ((MailContact)localObject1).setAddress(paramQMComposeMailType.getAddress());
      ((MailContact)localObject1).setName(paramQMComposeMailType.getName());
      ((MailContact)localObject1).setNick(paramQMComposeMailType.getNick());
      paramComposeMailUI.getInformation().setSendContact((MailContact)localObject1);
      i = 1;
      break;
      paramComposeMailUI.getInformation().setSendContact(localMailContact);
      return;
      paramQMComposeMailType = paramComposeMailUI.getInformation().getFrom();
      if (paramQMComposeMailType != null)
      {
        paramComposeMailUI.getInformation().setSendContact(paramQMComposeMailType);
        return;
      }
      paramComposeMailUI.getInformation().setSendContact(localMailContact);
      return;
    }
  }
  
  public static ArrayList<Object> uniqueContacts(ArrayList<Object> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    MailContact localMailContact;
    if (i < paramArrayList.size())
    {
      localMailContact = (MailContact)paramArrayList.get(i);
      if (localMailContact != null)
      {
        String str = localMailContact.getAddress();
        j = 0;
        label42:
        if (j >= localArrayList.size()) {
          break label98;
        }
        if (!((MailContact)localArrayList.get(j)).getAddress().equals(str)) {
          break label89;
        }
      }
    }
    label89:
    label98:
    for (int j = 0;; j = 1)
    {
      if (j != 0) {
        localArrayList.add(localMailContact);
      }
      i += 1;
      break;
      j += 1;
      break label42;
      return localArrayList;
    }
  }
  
  public static String updateInlineImgsByComposeCache(String paramString1, String paramString2, String paramString3)
  {
    paramString2 = getStrFromCid(paramString2).replaceAll("\\$", "\\\\$0");
    paramString3 = paramString3.replaceAll("\\$", "\\\\$0");
    String str = "(\"\\scid=\"" + paramString2 + "\"\\s*[^>]*\\s*>)";
    return paramString1.replaceAll("(<\\s*img\\s+[^>]*\\s*src\\s*=\\s*\")" + "[^\"]*?" + str, "$1" + paramString3 + "$2").replaceAll("(<\\s*img\\s+[^>]*\\s*src\\s*=\\s*\")" + "cid:" + paramString2 + "(\"\\s*[^>]*\\s*>)", "$1" + paramString3 + "$2");
  }
  
  public static String updateInlineImgsToHTML(String paramString1, String paramString2, String paramString3)
  {
    return paramString1.replaceAll("(<\\s*img\\s+[^>]*\\s*src\\s*=\\s*\")" + StringExtention.filterRegxpllega(paramString2) + "(\"\\s*[^>]*\\s*>)", paramString3);
  }
  
  public static String updateInlineImgsWithSrc(String paramString1, String paramString2, String paramString3)
  {
    return paramString1.replaceAll("(<\\s*img\\s+[^>]*\\s*src\\s*=\\s*\")" + StringExtention.filterRegxpllega(paramString2) + "(\"\\s*[^>]*\\s*>)", "$1" + paramString3 + "$2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailHelper
 * JD-Core Version:    0.7.0.1
 */