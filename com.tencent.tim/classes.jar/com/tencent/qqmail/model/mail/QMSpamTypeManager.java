package com.tencent.qqmail.model.mail;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;
import androidx.annotation.Nullable;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.permission.PermissionUtils;
import com.tencent.qqmail.protocol.CloudProtocolHelper;
import com.tencent.qqmail.protocol.CloudProtocolInfo;
import com.tencent.qqmail.protocol.CloudProtocolService;
import com.tencent.qqmail.protocol.MailMarker;
import com.tencent.qqmail.protocol.UMA.CmdQueryEmailTypeReq.EmailInfo;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Future;

public class QMSpamTypeManager
{
  public static final int MAIL_TYPE_BILL = 1;
  public static final int MAIL_TYPE_COMMERCIAL = 2;
  public static final int MAIL_TYPE_PERSIONAL = 4;
  public static final int MAIL_TYPE_REGISTER = 3;
  public static final int MAIL_TYPE_UNKNOWN = 0;
  private static final String TAG = "QMSpamTypeManager";
  public static final int TYPE_NORMAL = -1;
  public static final int TYPE_SPAM = 2;
  public static final int TYPE_UNKNOW = 0;
  private static Future<Void> futureGetIns = Threads.submitTask(new QMSpamTypeManager.1());
  private static QMSpamTypeManager instance;
  private static final MailMarker mailMarkder = new MailMarker();
  private final String EXTRA_PATH = QMApplicationContext.sharedInstance().getCacheDir() + File.separator + "mailmarker_extra.conf";
  private final String FILE_SPAM_EXTRA_RULE = "mailmarker_extra.conf";
  private final String FILE_SPAM_INCREMENT = "mailmarker_increment.conf";
  private final String FILE_SPAM_RULE = "mail/mailmarker_frompri.conf";
  private final String INCREMENT_PATH = QMApplicationContext.sharedInstance().getCacheDir() + File.separator + "mailmarker_increment.conf";
  private final String LOCAL_PATH = QMApplicationContext.sharedInstance().getCacheDir() + File.separator + "mail/mailmarker_frompri.conf";
  
  static
  {
    instance = new QMSpamTypeManager();
  }
  
  private void appendExtraRule(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = String.format("%s\t%s\t%s\t%s\n", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    writeExtraRules(paramString1);
    applyRules(paramString1);
  }
  
  private static int appendMarkerRules(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      mailMarkder.appendRulesEx(paramString);
    }
    for (;;)
    {
      return 0;
      mailMarkder.appendRules(paramString);
    }
  }
  
  private static int appendMarkerRulesByPath(String paramString, boolean paramBoolean)
  {
    byte[] arrayOfByte = FileUtil.fileContent(paramString);
    if (arrayOfByte != null) {
      return appendMarkerRules(new String(arrayOfByte), paramBoolean);
    }
    QMLog.log(6, "QMSpamTypeManager", "append_marker_rules_by_path failed to open at path: " + paramString);
    return 0;
  }
  
  private boolean applyRules(String paramString)
  {
    boolean bool = false;
    try
    {
      int i = appendMarkerRules(paramString, false);
      if (i > 0) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable paramString)
    {
      QMLog.log(5, "QMSpamTypeManager", "applyRules failed", paramString);
    }
    return false;
  }
  
  private boolean applyRulesByPath(String paramString)
  {
    boolean bool = false;
    if (appendMarkerRulesByPath(paramString, false) > 0) {
      bool = true;
    }
    return bool;
  }
  
  private boolean createLocalRuleFile(String paramString)
  {
    try
    {
      InputStream localInputStream = QMApplicationContext.sharedInstance().getResources().getAssets().open("mail/mailmarker_frompri.conf");
      FileOutputStream localFileOutputStream = new FileOutputStream(paramString);
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i = localInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localFileOutputStream.write(arrayOfByte, 0, i);
      }
      return false;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "QMSpamTypeManager", Log.getStackTraceString(localException));
      try
      {
        paramString = new File(paramString);
        if (paramString.exists()) {
          paramString.delete();
        }
        return false;
      }
      catch (Exception paramString)
      {
        QMLog.log(6, "QMSpamTypeManager", Log.getStackTraceString(paramString));
      }
      localFileOutputStream.flush();
      localFileOutputStream.close();
      localException.close();
      return true;
    }
  }
  
  private static File getFile(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {}
    try
    {
      paramString.createNewFile();
      return paramString;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "QMSpamTypeManager", Log.getStackTraceString(localException));
    }
    return paramString;
  }
  
  public static void init() {}
  
  private void initData()
  {
    if (isExist(this.LOCAL_PATH))
    {
      applyRulesByPath(this.LOCAL_PATH);
      if (!isExist(this.EXTRA_PATH)) {
        break label84;
      }
      applyRulesByPath(this.EXTRA_PATH);
    }
    for (;;)
    {
      if (!isExist(this.INCREMENT_PATH)) {
        break label95;
      }
      applyRulesByPath(this.INCREMENT_PATH);
      return;
      if (!createLocalRuleFile(this.LOCAL_PATH)) {
        break;
      }
      applyRulesByPath(this.LOCAL_PATH);
      break;
      label84:
      getFile(this.EXTRA_PATH);
    }
    label95:
    getFile(this.INCREMENT_PATH);
  }
  
  private boolean isExist(String paramString)
  {
    return new File(paramString).exists();
  }
  
  public static QMSpamTypeManager sharedInstance()
  {
    try
    {
      futureGetIns.get();
      return instance;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(6, "QMSpamTypeManager", Log.getStackTraceString(localException));
      }
    }
  }
  
  /* Error */
  private boolean writeExtraRules(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 106	com/tencent/qqmail/model/mail/QMSpamTypeManager:EXTRA_PATH	Ljava/lang/String;
    //   8: invokestatic 246	com/tencent/qqmail/model/mail/QMSpamTypeManager:getFile	(Ljava/lang/String;)Ljava/io/File;
    //   11: astore_3
    //   12: new 256	java/io/PrintWriter
    //   15: dup
    //   16: new 258	java/io/BufferedWriter
    //   19: dup
    //   20: new 260	java/io/FileWriter
    //   23: dup
    //   24: aload_3
    //   25: iconst_1
    //   26: invokespecial 263	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   29: invokespecial 266	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   32: invokespecial 267	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   35: astore_3
    //   36: aload_3
    //   37: aload_1
    //   38: invokevirtual 270	java/io/PrintWriter:append	(Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
    //   41: pop
    //   42: aload_3
    //   43: invokevirtual 271	java/io/PrintWriter:flush	()V
    //   46: aload_3
    //   47: invokevirtual 272	java/io/PrintWriter:close	()V
    //   50: aload_0
    //   51: monitorexit
    //   52: iload_2
    //   53: ireturn
    //   54: astore_1
    //   55: aload_1
    //   56: invokevirtual 275	java/io/IOException:printStackTrace	()V
    //   59: iconst_0
    //   60: istore_2
    //   61: goto -11 -> 50
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	QMSpamTypeManager
    //   0	69	1	paramString	String
    //   1	60	2	bool	boolean
    //   11	36	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	50	54	java/io/IOException
    //   4	12	64	finally
    //   12	50	64	finally
    //   55	59	64	finally
  }
  
  /* Error */
  private boolean writeIncrementalRules(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 108	com/tencent/qqmail/model/mail/QMSpamTypeManager:INCREMENT_PATH	Ljava/lang/String;
    //   8: invokestatic 246	com/tencent/qqmail/model/mail/QMSpamTypeManager:getFile	(Ljava/lang/String;)Ljava/io/File;
    //   11: astore_3
    //   12: new 256	java/io/PrintWriter
    //   15: dup
    //   16: new 258	java/io/BufferedWriter
    //   19: dup
    //   20: new 260	java/io/FileWriter
    //   23: dup
    //   24: aload_3
    //   25: iconst_1
    //   26: invokespecial 263	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   29: invokespecial 266	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   32: iconst_1
    //   33: invokespecial 279	java/io/PrintWriter:<init>	(Ljava/io/Writer;Z)V
    //   36: astore_3
    //   37: aload_3
    //   38: aload_1
    //   39: invokevirtual 281	java/io/PrintWriter:write	(Ljava/lang/String;)V
    //   42: aload_3
    //   43: invokevirtual 272	java/io/PrintWriter:close	()V
    //   46: aload_0
    //   47: monitorexit
    //   48: iload_2
    //   49: ireturn
    //   50: astore_1
    //   51: aload_1
    //   52: invokevirtual 275	java/io/IOException:printStackTrace	()V
    //   55: iconst_0
    //   56: istore_2
    //   57: goto -11 -> 46
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	QMSpamTypeManager
    //   0	65	1	paramString	String
    //   1	56	2	bool	boolean
    //   11	32	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	46	50	java/io/IOException
    //   4	12	60	finally
    //   12	46	60	finally
    //   51	55	60	finally
  }
  
  public void addIncrementalRules(String paramString)
  {
    writeIncrementalRules(paramString);
    applyRules(paramString);
  }
  
  public int checkSpamType(@Nullable String paramString1, @Nullable String paramString2)
  {
    int i;
    if (paramString1 == null) {
      i = -1;
    }
    for (;;)
    {
      return i;
      try
      {
        i = markMailType(paramString1.toLowerCase(), null, null, null, false);
        if (i == 2)
        {
          i = 2;
          continue;
        }
        if (i == 0)
        {
          i = 0;
          continue;
        }
        i = -1;
      }
      finally {}
    }
  }
  
  public void cloudCheckSpam(ArrayList<Mail> paramArrayList, Runnable paramRunnable)
  {
    if ((!QMNetworkUtils.isNetworkConnected()) || (!PermissionUtils.hasRequiredPermission(QMApplicationContext.sharedInstance())))
    {
      QMLog.log(5, "QMSpamTypeManager", "cloudCheckSpam network is disconnected: " + QMNetworkUtils.getActiveNetworkName());
      return;
    }
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(5, "QMSpamTypeManager", "cloudCheckSpam info null");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Mail localMail = (Mail)paramArrayList.next();
      CmdQueryEmailTypeReq.EmailInfo localEmailInfo = new CmdQueryEmailTypeReq.EmailInfo();
      localEmailInfo.id = localMail.getInformation().getId();
      localEmailInfo.from = localMail.getInformation().getFrom().getAddress();
      localEmailInfo.subject = localMail.getInformation().getSubject();
      localArrayList.add(localEmailInfo);
    }
    localCloudProtocolInfo.email_info_list_ = ((CmdQueryEmailTypeReq.EmailInfo[])localArrayList.toArray(new CmdQueryEmailTypeReq.EmailInfo[localArrayList.size()]));
    CloudProtocolService.QueryEmailType(localCloudProtocolInfo, new QMSpamTypeManager.2(this, paramRunnable));
  }
  
  int markMailType(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    int i = mailMarkder.markMailType(paramString1, paramString2, paramString3, paramString4, paramBoolean);
    QMLog.log(4, "QMSpamTypeManager", "markMailType addr:" + paramString1 + ", sub:" + paramString2 + ", ip:" + paramString3 + ", msg:" + paramString4 + ", blk:" + paramBoolean + ", ret:" + i);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMSpamTypeManager
 * JD-Core Version:    0.7.0.1
 */