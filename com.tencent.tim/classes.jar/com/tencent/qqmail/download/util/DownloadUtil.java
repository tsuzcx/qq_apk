package com.tencent.qqmail.download.util;

import android.util.Log;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.helper.QMWtLoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.download.DownloadInfoManager;
import com.tencent.qqmail.download.activity.DownloadActivity;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.dateextension.DateExtension;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;
import com.tencent.qqmail.utilities.encryptionalgorithm.RsaEncryption;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.CGIRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkConfig;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import moai.oss.OssHelper;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;

public class DownloadUtil
{
  private static final String TAG = "DownloadUtil";
  
  public static void addA2Cookie(ArrayList<Cookie> paramArrayList, QQMailAccount paramQQMailAccount)
  {
    if ((SharedPreferenceUtil.isWtlogin()) && (!paramQQMailAccount.isBizMail()))
    {
      Object localObject = QMWtLoginManager.getInstance().getA2(paramQQMailAccount.getUin());
      if (StringExtention.isNullOrEmpty((String)localObject))
      {
        QMLog.log(6, "DownloadUtil", "wtLogin a2 not exist:" + paramQQMailAccount.getEmail());
        return;
      }
      QMLog.log(4, "DownloadUtil", "add cookie AKey wtLogin. uin:" + paramQQMailAccount.getUin());
      localObject = new StringBuilder().append(SharedPreferenceUtil.getLoginSvrUtc()).append("\t").append(paramQQMailAccount.getUin()).append("\t").append((String)localObject).append("\t");
      if (paramQQMailAccount.getSecondPassword() == null)
      {
        paramQQMailAccount = "";
        paramQQMailAccount = paramQQMailAccount;
        if (!RsaEncryption.isLoginUsedRsa()) {
          break label197;
        }
        paramArrayList.add(new BasicClientCookie("rakey", RsaEncryption.encryptInBlock(paramQQMailAccount)));
      }
      for (;;)
      {
        paramArrayList.add(new BasicClientCookie("ltype", "wtlogin"));
        return;
        paramQQMailAccount = paramQQMailAccount.getSecondPassword();
        break;
        label197:
        paramArrayList.add(new BasicClientCookie("akey", Aes.encode(paramQQMailAccount, Aes.getServerKey())));
      }
    }
    if (RsaEncryption.isLoginUsedRsa())
    {
      paramArrayList.add(new BasicClientCookie("rakey", RsaEncryption.encryptInBlock(paramQQMailAccount.getAutologinKey())));
      return;
    }
    paramArrayList.add(new BasicClientCookie("akey", Aes.encode(paramQQMailAccount.getAutologinKey(), Aes.getServerKey())));
  }
  
  public static void addCookies(DownloadInfo paramDownloadInfo, ArrayList<String> paramArrayList)
  {
    if (paramDownloadInfo == null) {
      return;
    }
    Object localObject = AccountManager.shareInstance().getAccountList().getAccountById(paramDownloadInfo.getAccountId());
    QQMailAccount localQQMailAccount;
    if ((localObject != null) && ((localObject instanceof QQMailAccount)))
    {
      localQQMailAccount = (QQMailAccount)localObject;
      localObject = paramDownloadInfo.getCookies();
      if (localObject != null) {
        break label180;
      }
      localObject = new ArrayList();
    }
    label180:
    for (;;)
    {
      if (localQQMailAccount.getCookies() != null) {
        ((ArrayList)localObject).addAll(localQQMailAccount.getCookies());
      }
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          String str = (String)paramArrayList.next();
          if (paramDownloadInfo.getUrl().contains("cgi-bin/" + str + "?")) {
            addA2Cookie((ArrayList)localObject, localQQMailAccount);
          }
        }
      }
      paramDownloadInfo.setCookies((ArrayList)localObject);
      return;
      QMLog.log(6, "DownloadUtil", "addCookies account null :" + paramDownloadInfo.getUrl());
      return;
    }
  }
  
  public static DownloadInfo createDownloadInfoForFtn(MailBigAttach paramMailBigAttach)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.setAccountId(paramMailBigAttach.getAccountId());
    localDownloadInfo.setFid(paramMailBigAttach.getFid());
    localDownloadInfo.setFileSize(StringExtention.sizeStrToLong(paramMailBigAttach.getSize()));
    localDownloadInfo.setFtnKey(paramMailBigAttach.getKey());
    localDownloadInfo.setFtnCode(paramMailBigAttach.getCode());
    localDownloadInfo.setFileName(paramMailBigAttach.getName());
    localDownloadInfo.setFtnBytes(paramMailBigAttach.getBytes());
    localDownloadInfo.setCreateTime(System.currentTimeMillis());
    localDownloadInfo.setDownloadType(1);
    localDownloadInfo.setAttachType(2);
    return localDownloadInfo;
  }
  
  public static DownloadInfo createDownloadInfoForNormal(Attach paramAttach, String paramString, boolean paramBoolean)
  {
    String str = getDownloadUrl(paramAttach);
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.setAttachId(paramAttach.getHashId());
    localDownloadInfo.setAccountId(paramAttach.getAccountId());
    localDownloadInfo.setKey(str);
    localDownloadInfo.setUrl(str);
    localDownloadInfo.setFileSize(StringExtention.sizeStrToLong(paramAttach.getSize()));
    localDownloadInfo.setFileName(paramAttach.getName());
    localDownloadInfo.setFilePath(paramAttach.getPreview().getMyDisk());
    localDownloadInfo.setSaveAsPath(paramString);
    localDownloadInfo.setIsNotify(paramBoolean);
    localDownloadInfo.setIntent(DownloadActivity.createIntent());
    localDownloadInfo.setNotificationId((int)paramAttach.getHashId());
    localDownloadInfo.setIsFixProcess(isFixProcess(paramAttach.isProtocol(), getAccountProtocolType(paramAttach.getAccountId())));
    localDownloadInfo.setDownloadType(1);
    if (paramAttach.isProtocol())
    {
      localDownloadInfo.setAttachType(3);
      localDownloadInfo.setMailId(paramAttach.getBelongMailId());
      return localDownloadInfo;
    }
    localDownloadInfo.setCookies(getCookie(paramAttach.getAccountId()));
    localDownloadInfo.setAttachType(0);
    return localDownloadInfo;
  }
  
  public static DownloadInfo createDownloadInfoForZipInnerAttach(Attach paramAttach, String paramString)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    if (paramAttach != null)
    {
      localDownloadInfo.setAccountId(paramAttach.getAccountId());
      localDownloadInfo.setUrl(paramAttach.getPreview().getDownloadUrl());
      localDownloadInfo.setKey(paramString);
      localDownloadInfo.setFileName(paramAttach.getName());
      localDownloadInfo.setFilePath(paramAttach.getPreview().getMyDisk());
      localDownloadInfo.setFileSize(StringExtention.sizeStrToLong(paramAttach.getSize()));
      localDownloadInfo.setIsNotify(false);
      localDownloadInfo.setDownloadType(1);
      localDownloadInfo.setAttachType(4);
      localDownloadInfo.setSessionType(1);
      localDownloadInfo.setMailId(paramAttach.getBelongMailId());
    }
    return localDownloadInfo;
  }
  
  public static void existFileSaveAs(Attach paramAttach, String paramString, boolean paramBoolean)
  {
    Threads.runInBackground(new DownloadUtil.1(paramAttach, paramString, paramBoolean));
  }
  
  public static String fileCopyTo(String paramString1, String paramString2, String paramString3)
  {
    if ((StringExtention.isNullOrEmpty(paramString1)) || (StringExtention.isNullOrEmpty(paramString2)) || (StringExtention.isNullOrEmpty(paramString3))) {
      paramString2 = "";
    }
    do
    {
      return paramString2;
      paramString2 = FileUtil.toDirPath(paramString2);
      paramString3 = FileUtil.rename(paramString2, paramString3);
      paramString3 = paramString2 + paramString3;
      paramString2 = paramString3;
    } while (safeCopyTo(paramString1, paramString3));
    return "";
  }
  
  public static String formatCookie(ArrayList<Cookie> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Cookie localCookie = (Cookie)paramArrayList.next();
      localStringBuilder.append(localCookie.getName());
      localStringBuilder.append('=');
      localStringBuilder.append(localCookie.getValue());
      localStringBuilder.append(';');
    }
    return localStringBuilder.toString();
  }
  
  public static ArrayList<Cookie> formatCookie(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (StringExtention.isNullOrEmpty(paramString)) {}
    for (;;)
    {
      return localArrayList;
      paramString = paramString.split(";");
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          String[] arrayOfString = paramString[i].split("=");
          if ((arrayOfString != null) && (arrayOfString.length == 2)) {
            localArrayList.add(new BasicClientCookie(arrayOfString[0], arrayOfString[1]));
          }
          i += 1;
        }
      }
    }
  }
  
  public static int getAccountProtocolType(int paramInt)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    if (localAccount != null) {
      return localAccount.getProtocolType();
    }
    return -1;
  }
  
  public static ArrayList<String> getBigAttAchDownloadList(MailInformation paramMailInformation)
  {
    paramMailInformation = paramMailInformation.getBigAttachList();
    ArrayList localArrayList = new ArrayList();
    Date localDate1 = new Date();
    int i = 0;
    while (i < paramMailInformation.size())
    {
      MailBigAttach localMailBigAttach = (MailBigAttach)paramMailInformation.get(i);
      Date localDate2 = localMailBigAttach.getExpire();
      if ((localMailBigAttach.isBizNetDiskAttach()) || ((localDate2 != null) && (localDate2.getTime() - localDate1.getTime() > 0L))) {
        localArrayList.add(localMailBigAttach.getPreview().getDownloadUrl());
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static String getCgiUrl(int paramInt, String paramString)
  {
    if (paramString == null) {
      return "";
    }
    String str1 = "download";
    String str2;
    String[] arrayOfString;
    int i;
    if (paramString.contains("groupattachment"))
    {
      str1 = "groupattachment";
      paramString = paramString.split("\\?");
      paramString = paramString[(paramString.length - 1)].replaceAll("\\{", "%7B").replaceAll("\\}", "%7D");
      str2 = paramString;
      if (str1.equals("viewcompress")) {
        break label218;
      }
      str2 = paramString;
      if (str1.equals("attdownload")) {
        break label218;
      }
      arrayOfString = paramString.split("&");
      str2 = paramString;
      if (arrayOfString.length <= 0) {
        break label218;
      }
      str2 = paramString;
      if (!paramString.contains("&filename=")) {
        break label218;
      }
      paramString = "";
      i = 0;
      label120:
      str2 = paramString;
      if (i >= arrayOfString.length - 1) {
        break label218;
      }
      if (i != arrayOfString.length - 1) {
        break label187;
      }
    }
    label187:
    for (paramString = paramString + arrayOfString[i];; paramString = paramString + arrayOfString[i] + "&")
    {
      i += 1;
      break label120;
      if (!paramString.contains("attdownload")) {
        break;
      }
      str1 = "attdownload";
      break;
    }
    label218:
    return QMNetworkConfig.getCgiRequestHost(paramInt) + "/cgi-bin/" + str1 + "?" + str2;
  }
  
  public static ArrayList<Cookie> getCookie(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    if (localObject == null) {
      return localArrayList;
    }
    BasicClientCookie localBasicClientCookie = new BasicClientCookie("qm_username", ((Account)localObject).getUin());
    localObject = new BasicClientCookie("curuin", ((Account)localObject).getUin());
    localArrayList.add(localBasicClientCookie);
    localArrayList.add(localObject);
    return localArrayList;
  }
  
  public static long getDownloadTaskId(String paramString)
  {
    if (StringExtention.isNullOrEmpty(paramString)) {}
    return QMMath.hashLong(paramString);
  }
  
  public static String getDownloadUrl(Attach paramAttach)
  {
    if (paramAttach == null) {
      return "";
    }
    if (!paramAttach.isProtocol()) {
      return getCgiUrl(paramAttach.getAccountId(), paramAttach.getPreview().getDownloadUrl());
    }
    return paramAttach.getHashId() + "";
  }
  
  public static String getRequestUrl(DownloadInfo paramDownloadInfo)
  {
    Object localObject;
    boolean bool;
    label38:
    String str;
    if (paramDownloadInfo.getSessionType() > 0)
    {
      int i = paramDownloadInfo.getAccountId();
      localObject = paramDownloadInfo.getUrl();
      if (paramDownloadInfo.getSessionType() == 2)
      {
        bool = true;
        localObject = new CGIRequest(i, (String)localObject, bool);
        str = ((QMNetworkRequest)localObject).prepareURL();
        localObject = str;
        if (paramDownloadInfo.getDownloadType() == 1)
        {
          localObject = str;
          if (paramDownloadInfo.getAttachType() == 0)
          {
            if (!QMSettingManager.sharedInstance().isEnableHttpsDomain()) {
              break label149;
            }
            localObject = str;
            if (str.startsWith("http://"))
            {
              QMLog.log(4, "DownloadUtil", "change http to https:" + str);
              localObject = str.replace("http://", "https://");
            }
          }
        }
      }
    }
    label149:
    do
    {
      return localObject;
      bool = false;
      break;
      localObject = new QMNetworkRequest(paramDownloadInfo.getUrl());
      break label38;
      localObject = str;
    } while (!str.startsWith("https://"));
    QMLog.log(4, "DownloadUtil", "change https to http:" + str);
    return str.replace("https://", "http://");
  }
  
  public static String getSizeAndDate(DownloadInfo paramDownloadInfo)
  {
    String str = StringExtention.getHumanReadableSizeString(paramDownloadInfo.getFileSize());
    paramDownloadInfo = DateExtension.getDateString(paramDownloadInfo.getCreateTime());
    return str + " | " + paramDownloadInfo;
  }
  
  public static String getZipInnerAttachName(String paramString1, String paramString2)
  {
    if (!StringExtention.isNullOrEmpty(paramString1))
    {
      int i = paramString1.lastIndexOf(".");
      String str = "";
      if (i > 0) {
        str = paramString1.substring(i, paramString1.length()).toLowerCase(Locale.getDefault());
      }
      return StringExtention.hashKeyForDisk(paramString2) + str;
    }
    return "";
  }
  
  public static boolean isDownloadFileSizeError(long paramLong1, long paramLong2)
  {
    return (paramLong2 != 0L) && (paramLong2 - paramLong1 > paramLong2 * 0.2D);
  }
  
  public static boolean isDownloadInfoComplete(DownloadInfo paramDownloadInfo)
  {
    return (paramDownloadInfo != null) && (paramDownloadInfo.getStatus() == 4) && (FileUtil.isFileExist(paramDownloadInfo.getFilePath()));
  }
  
  public static boolean isFixProcess(boolean paramBoolean, int paramInt)
  {
    return (paramBoolean) && (paramInt == 1);
  }
  
  public static void paddingDownloadInfo(DownloadInfo paramDownloadInfo, ArrayList<String> paramArrayList)
  {
    paramDownloadInfo.setId(DownloadInfo.generateId(paramDownloadInfo.getAccountId(), paramDownloadInfo.getKey(), paramDownloadInfo.getFileName()));
    paramDownloadInfo.setCreateTime(System.currentTimeMillis());
    if (paramDownloadInfo.getUrl().contains("/cgi-bin/"))
    {
      addCookies(paramDownloadInfo, paramArrayList);
      if (paramDownloadInfo.getSessionType() == -1) {
        paramDownloadInfo.setSessionType(1);
      }
    }
    while (paramDownloadInfo.getSessionType() != -1) {
      return;
    }
    paramDownloadInfo.setSessionType(0);
  }
  
  public static void refreshDownloadCookie(DownloadInfo paramDownloadInfo)
  {
    Object localObject1 = AccountManager.shareInstance().getAccountList().getAccountById(paramDownloadInfo.getAccountId());
    Object localObject2;
    Object localObject3;
    if ((localObject1 != null) && ((localObject1 instanceof QQMailAccount)))
    {
      localObject2 = (QQMailAccount)localObject1;
      localObject1 = new ArrayList(paramDownloadInfo.getCookies());
      localObject3 = ((QQMailAccount)localObject2).getCookies();
      addA2Cookie((ArrayList)localObject3, (QQMailAccount)localObject2);
      localObject2 = ((ArrayList)localObject3).iterator();
    }
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Cookie)((Iterator)localObject2).next();
        Iterator localIterator = ((ArrayList)localObject1).iterator();
        if (localIterator.hasNext())
        {
          Cookie localCookie = (Cookie)localIterator.next();
          if (!localCookie.getName().equals(((Cookie)localObject3).getName())) {
            break;
          }
          paramDownloadInfo.getCookies().remove(localCookie);
          paramDownloadInfo.getCookies().add(localObject3);
          continue;
          QMLog.log(6, "DownloadUtil", "addCookies account null :" + paramDownloadInfo.getUrl());
          return;
        }
      }
    }
    DownloadInfoManager.shareInstance().updateDownloadInfoCookie(paramDownloadInfo);
  }
  
  private static String renameTo(String paramString1, String paramString2, String paramString3)
  {
    if ((StringExtention.isNullOrEmpty(paramString1)) || (StringExtention.isNullOrEmpty(paramString2)) || (StringExtention.isNullOrEmpty(paramString3))) {
      return "";
    }
    paramString2 = FileUtil.toDirPath(paramString2);
    paramString3 = paramString2 + FileUtil.rename(paramString2, paramString3);
    try
    {
      localObject2 = Class.forName("libcore.io.Posix");
      Object localObject1 = Class.forName("libcore.io.BlockGuardOs");
      paramString2 = Class.forName("libcore.io.Os");
      localObject1 = ((Class)localObject1).getConstructor(new Class[] { paramString2 });
      localObject2 = ((Class)localObject2).getDeclaredConstructor(new Class[0]);
      ((Constructor)localObject2).setAccessible(true);
      paramString2 = paramString2.getMethod("rename", new Class[] { String.class, String.class });
      paramString2.setAccessible(true);
      paramString2.invoke(((Constructor)localObject1).newInstance(new Object[] { ((Constructor)localObject2).newInstance(new Object[0]) }), new Object[] { paramString1, paramString3 });
      QMLog.log(4, "DownloadUtil", "direct rename success:" + paramString3);
      return paramString3;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder().append("direct rename file error:");
      if (localException.getCause() != null)
      {
        paramString2 = localException.getCause().toString();
        QMLog.log(6, "DownloadUtil", paramString2 + Log.getStackTraceString(localException));
        if (localException.getCause() == null) {
          break label353;
        }
      }
      label353:
      for (paramString2 = localException.getCause().toString();; paramString2 = localException.getMessage())
      {
        OssHelper.attachMoveSaveAsFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", paramString1, paramString3, paramString2 });
        if (!safeCopyTo(paramString1, paramString3)) {
          break label361;
        }
        FileUtil.delFile(paramString1);
        return paramString3;
        paramString2 = localException.toString();
        break;
      }
    }
    label361:
    return "";
  }
  
  /* Error */
  private static boolean safeCopyTo(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore_3
    //   8: aconst_null
    //   9: astore 10
    //   11: aconst_null
    //   12: astore 7
    //   14: iconst_1
    //   15: istore_2
    //   16: aload_0
    //   17: invokestatic 593	com/tencent/qqmail/utilities/fileextention/FileUtil:isFileExist	(Ljava/lang/String;)Z
    //   20: ifeq +10 -> 30
    //   23: aload_1
    //   24: invokestatic 51	com/tencent/qqmail/utilities/stringextention/StringExtention:isNullOrEmpty	(Ljava/lang/String;)Z
    //   27: ifeq +7 -> 34
    //   30: iconst_0
    //   31: istore_2
    //   32: iload_2
    //   33: ireturn
    //   34: new 706	java/io/FileInputStream
    //   37: dup
    //   38: new 708	java/io/File
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 709	java/io/File:<init>	(Ljava/lang/String;)V
    //   46: invokespecial 712	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   49: astore 8
    //   51: aload 7
    //   53: astore 4
    //   55: aload 10
    //   57: astore_3
    //   58: aload 8
    //   60: astore 6
    //   62: new 708	java/io/File
    //   65: dup
    //   66: aload_1
    //   67: invokespecial 709	java/io/File:<init>	(Ljava/lang/String;)V
    //   70: invokestatic 718	androidx/documentfile/provider/DocumentFile:fromFile	(Ljava/io/File;)Landroidx/documentfile/provider/DocumentFile;
    //   73: astore 11
    //   75: aload 9
    //   77: astore 5
    //   79: aload 11
    //   81: ifnull +425 -> 506
    //   84: aload 7
    //   86: astore 4
    //   88: aload 10
    //   90: astore_3
    //   91: aload 8
    //   93: astore 6
    //   95: aload 11
    //   97: invokevirtual 722	androidx/documentfile/provider/DocumentFile:getUri	()Landroid/net/Uri;
    //   100: astore 11
    //   102: aload 9
    //   104: astore 5
    //   106: aload 11
    //   108: ifnull +398 -> 506
    //   111: aload 7
    //   113: astore 4
    //   115: aload 10
    //   117: astore_3
    //   118: aload 8
    //   120: astore 6
    //   122: invokestatic 727	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   125: invokevirtual 731	com/tencent/qqmail/QMApplicationContext:getContentResolver	()Landroid/content/ContentResolver;
    //   128: aload 11
    //   130: invokevirtual 737	android/content/ContentResolver:openOutputStream	(Landroid/net/Uri;)Ljava/io/OutputStream;
    //   133: astore 7
    //   135: aload 7
    //   137: astore 4
    //   139: aload 7
    //   141: astore_3
    //   142: aload 8
    //   144: astore 6
    //   146: sipush 1024
    //   149: newarray byte
    //   151: astore 9
    //   153: aload 7
    //   155: astore 4
    //   157: aload 7
    //   159: astore 5
    //   161: aload 7
    //   163: astore_3
    //   164: aload 8
    //   166: astore 6
    //   168: aload 8
    //   170: aload 9
    //   172: invokevirtual 743	java/io/InputStream:read	([B)I
    //   175: iconst_m1
    //   176: if_icmpeq +330 -> 506
    //   179: aload 7
    //   181: astore 4
    //   183: aload 7
    //   185: astore_3
    //   186: aload 8
    //   188: astore 6
    //   190: aload 7
    //   192: aload 9
    //   194: invokevirtual 749	java/io/OutputStream:write	([B)V
    //   197: goto -44 -> 153
    //   200: astore 7
    //   202: aload 8
    //   204: astore 5
    //   206: aload 4
    //   208: astore_3
    //   209: aload 5
    //   211: astore 6
    //   213: aload 7
    //   215: invokevirtual 673	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   218: ifnull +360 -> 578
    //   221: aload 4
    //   223: astore_3
    //   224: aload 5
    //   226: astore 6
    //   228: aload 7
    //   230: invokevirtual 673	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   233: invokevirtual 676	java/lang/Throwable:toString	()Ljava/lang/String;
    //   236: astore 8
    //   238: aload 4
    //   240: astore_3
    //   241: aload 5
    //   243: astore 6
    //   245: bipush 10
    //   247: anewarray 4	java/lang/Object
    //   250: dup
    //   251: iconst_0
    //   252: ldc_w 683
    //   255: invokestatic 689	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   258: aastore
    //   259: dup
    //   260: iconst_1
    //   261: iconst_1
    //   262: invokestatic 689	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: aastore
    //   266: dup
    //   267: iconst_2
    //   268: ldc 88
    //   270: aastore
    //   271: dup
    //   272: iconst_3
    //   273: ldc 88
    //   275: aastore
    //   276: dup
    //   277: iconst_4
    //   278: ldc 88
    //   280: aastore
    //   281: dup
    //   282: iconst_5
    //   283: ldc 88
    //   285: aastore
    //   286: dup
    //   287: bipush 6
    //   289: ldc 88
    //   291: aastore
    //   292: dup
    //   293: bipush 7
    //   295: aload_0
    //   296: aastore
    //   297: dup
    //   298: bipush 8
    //   300: aload_1
    //   301: aastore
    //   302: dup
    //   303: bipush 9
    //   305: aload 8
    //   307: aastore
    //   308: invokestatic 752	moai/oss/OssHelper:attachWriteSaveAsFail	([Ljava/lang/Object;)V
    //   311: aload 4
    //   313: astore_3
    //   314: aload 5
    //   316: astore 6
    //   318: new 53	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   325: astore_1
    //   326: aload 4
    //   328: astore_3
    //   329: aload 5
    //   331: astore 6
    //   333: aload 7
    //   335: invokevirtual 673	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   338: ifnull +257 -> 595
    //   341: aload 4
    //   343: astore_3
    //   344: aload 5
    //   346: astore 6
    //   348: aload 7
    //   350: invokevirtual 673	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   353: invokevirtual 676	java/lang/Throwable:toString	()Ljava/lang/String;
    //   356: astore_0
    //   357: aload 4
    //   359: astore_3
    //   360: aload 5
    //   362: astore 6
    //   364: aload_1
    //   365: aload_0
    //   366: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload 4
    //   372: astore_3
    //   373: aload 5
    //   375: astore 6
    //   377: aload_1
    //   378: ldc_w 754
    //   381: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload 4
    //   387: astore_3
    //   388: aload 5
    //   390: astore 6
    //   392: aload_1
    //   393: aload 7
    //   395: invokestatic 682	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   398: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload 4
    //   404: astore_3
    //   405: aload 5
    //   407: astore 6
    //   409: new 53	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   416: ldc_w 756
    //   419: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: astore_1
    //   423: aload 4
    //   425: astore_3
    //   426: aload 5
    //   428: astore 6
    //   430: aload 7
    //   432: invokevirtual 673	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   435: ifnull +176 -> 611
    //   438: aload 4
    //   440: astore_3
    //   441: aload 5
    //   443: astore 6
    //   445: aload 7
    //   447: invokevirtual 673	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   450: invokevirtual 676	java/lang/Throwable:toString	()Ljava/lang/String;
    //   453: astore_0
    //   454: aload 4
    //   456: astore_3
    //   457: aload 5
    //   459: astore 6
    //   461: bipush 6
    //   463: ldc 8
    //   465: aload_1
    //   466: aload_0
    //   467: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: aload 7
    //   472: invokestatic 682	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   475: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: invokestatic 72	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   484: aload 4
    //   486: ifnull +8 -> 494
    //   489: aload 4
    //   491: invokevirtual 759	java/io/OutputStream:close	()V
    //   494: aload 5
    //   496: ifnull +8 -> 504
    //   499: aload 5
    //   501: invokevirtual 760	java/io/InputStream:close	()V
    //   504: iconst_0
    //   505: ireturn
    //   506: aload 5
    //   508: astore 4
    //   510: aload 5
    //   512: astore_3
    //   513: aload 8
    //   515: astore 6
    //   517: iconst_4
    //   518: ldc 8
    //   520: new 53	java/lang/StringBuilder
    //   523: dup
    //   524: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   527: ldc_w 762
    //   530: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: aload_0
    //   534: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: ldc_w 764
    //   540: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: aload_1
    //   544: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: invokestatic 72	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   553: aload 5
    //   555: ifnull +8 -> 563
    //   558: aload 5
    //   560: invokevirtual 759	java/io/OutputStream:close	()V
    //   563: aload 8
    //   565: ifnull -533 -> 32
    //   568: aload 8
    //   570: invokevirtual 760	java/io/InputStream:close	()V
    //   573: iconst_1
    //   574: ireturn
    //   575: astore_0
    //   576: iconst_1
    //   577: ireturn
    //   578: aload 4
    //   580: astore_3
    //   581: aload 5
    //   583: astore 6
    //   585: aload 7
    //   587: invokevirtual 699	java/lang/Exception:toString	()Ljava/lang/String;
    //   590: astore 8
    //   592: goto -354 -> 238
    //   595: aload 4
    //   597: astore_3
    //   598: aload 5
    //   600: astore 6
    //   602: aload 7
    //   604: invokevirtual 702	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   607: astore_0
    //   608: goto -251 -> 357
    //   611: aload 4
    //   613: astore_3
    //   614: aload 5
    //   616: astore 6
    //   618: aload 7
    //   620: invokevirtual 699	java/lang/Exception:toString	()Ljava/lang/String;
    //   623: astore_0
    //   624: goto -170 -> 454
    //   627: astore_0
    //   628: aconst_null
    //   629: astore 6
    //   631: aload_3
    //   632: ifnull +7 -> 639
    //   635: aload_3
    //   636: invokevirtual 759	java/io/OutputStream:close	()V
    //   639: aload 6
    //   641: ifnull +8 -> 649
    //   644: aload 6
    //   646: invokevirtual 760	java/io/InputStream:close	()V
    //   649: aload_0
    //   650: athrow
    //   651: astore_1
    //   652: goto -3 -> 649
    //   655: astore_0
    //   656: goto -25 -> 631
    //   659: astore_0
    //   660: goto -156 -> 504
    //   663: astore 7
    //   665: aconst_null
    //   666: astore 5
    //   668: goto -462 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	671	0	paramString1	String
    //   0	671	1	paramString2	String
    //   15	18	2	bool	boolean
    //   7	629	3	localObject1	Object
    //   1	611	4	localObject2	Object
    //   77	590	5	localObject3	Object
    //   60	585	6	localObject4	Object
    //   12	179	7	localOutputStream	java.io.OutputStream
    //   200	419	7	localException1	Exception
    //   663	1	7	localException2	Exception
    //   49	542	8	localObject5	Object
    //   4	189	9	arrayOfByte	byte[]
    //   9	107	10	localObject6	Object
    //   73	56	11	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   62	75	200	java/lang/Exception
    //   95	102	200	java/lang/Exception
    //   122	135	200	java/lang/Exception
    //   146	153	200	java/lang/Exception
    //   168	179	200	java/lang/Exception
    //   190	197	200	java/lang/Exception
    //   517	553	200	java/lang/Exception
    //   558	563	575	java/io/IOException
    //   568	573	575	java/io/IOException
    //   34	51	627	finally
    //   635	639	651	java/io/IOException
    //   644	649	651	java/io/IOException
    //   62	75	655	finally
    //   95	102	655	finally
    //   122	135	655	finally
    //   146	153	655	finally
    //   168	179	655	finally
    //   190	197	655	finally
    //   213	221	655	finally
    //   228	238	655	finally
    //   245	311	655	finally
    //   318	326	655	finally
    //   333	341	655	finally
    //   348	357	655	finally
    //   364	370	655	finally
    //   377	385	655	finally
    //   392	402	655	finally
    //   409	423	655	finally
    //   430	438	655	finally
    //   445	454	655	finally
    //   461	484	655	finally
    //   517	553	655	finally
    //   585	592	655	finally
    //   602	608	655	finally
    //   618	624	655	finally
    //   489	494	659	java/io/IOException
    //   499	504	659	java/io/IOException
    //   34	51	663	java/lang/Exception
  }
  
  public static boolean validateDownloadInfo(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (StringExtention.isNullOrEmpty(paramDownloadInfo.getUrl()))) {
      return false;
    }
    if (StringExtention.isNullOrEmpty(paramDownloadInfo.getKey())) {
      paramDownloadInfo.setKey(paramDownloadInfo.getUrl());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.util.DownloadUtil
 * JD-Core Version:    0.7.0.1
 */