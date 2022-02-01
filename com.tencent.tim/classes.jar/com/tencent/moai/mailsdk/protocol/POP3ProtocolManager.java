package com.tencent.moai.mailsdk.protocol;

import android.util.Log;
import com.tencent.moai.mailsdk.MailParser;
import com.tencent.moai.mailsdk.callback.LoginCallBack;
import com.tencent.moai.mailsdk.callback.LogoutCallBack;
import com.tencent.moai.mailsdk.callback.MailAbstractCallBack;
import com.tencent.moai.mailsdk.callback.MailCallBack;
import com.tencent.moai.mailsdk.callback.MailListCallBack;
import com.tencent.moai.mailsdk.callback.MailOperationCallback;
import com.tencent.moai.mailsdk.callback.TaskCallBack;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Attachment;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.model.State;
import com.tencent.moai.mailsdk.protocol.mime.model.MimeMessage;
import com.tencent.moai.mailsdk.protocol.pop3.POP3Handler;
import com.tencent.moai.mailsdk.protocol.pop3.POP3MsgStatus;
import com.tencent.moai.mailsdk.protocol.pop3.POP3MsgUID;
import com.tencent.moai.mailsdk.task.TaskPool;
import com.tencent.moai.mailsdk.task.TaskPool.TaskRunnable;
import com.tencent.moai.mailsdk.util.FileUtility;
import com.tencent.moai.mailsdk.util.LoginUtility;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class POP3ProtocolManager
{
  private static final String ORDER_AESC = "aesc";
  private static final String ORDER_DESC = "desc";
  private static final int POP_TOP_LINES = 100;
  private static final String TAG = "POP3ProtocolManager";
  private static final String TASK_TAG = "POP3Task-";
  private static POP3ProtocolManager instance = new POP3ProtocolManager();
  private HashMap<String, String> uidOrderMap = getUidOrderMap();
  private final Map<String, TaskPool> userTaskPool = new HashMap();
  
  private void clearTaskPool(Profile paramProfile, boolean paramBoolean)
  {
    synchronized (this.userTaskPool)
    {
      TaskPool localTaskPool = (TaskPool)this.userTaskPool.get(getKey(paramProfile));
      if (localTaskPool != null)
      {
        if (paramBoolean)
        {
          localTaskPool.shutDownNow();
          this.userTaskPool.remove(getKey(paramProfile));
        }
      }
      else {
        return;
      }
      localTaskPool.shutDown();
    }
  }
  
  private ArrayList<String> convertUidList(ArrayList<POP3MsgUID> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(((POP3MsgUID)paramArrayList.next()).getUid());
    }
    return localArrayList;
  }
  
  private String fetchUidlOrder(Profile paramProfile, ArrayList<POP3MsgUID> paramArrayList, POP3Handler paramPOP3Handler)
  {
    if (this.uidOrderMap.get(paramProfile.getPopName()) != null) {
      return (String)this.uidOrderMap.get(paramProfile.getPopName());
    }
    if (paramArrayList.size() < 2)
    {
      this.uidOrderMap.put(paramProfile.getPopName(), "aesc");
      saveUidOrderMap(this.uidOrderMap);
      return (String)this.uidOrderMap.get(paramProfile.getPopName());
    }
    try
    {
      MimeMessage localMimeMessage = paramPOP3Handler.top(((POP3MsgUID)paramArrayList.get(0)).getMsgNum(), 0);
      paramPOP3Handler = paramPOP3Handler.top(((POP3MsgUID)paramArrayList.get(paramArrayList.size() - 1)).getMsgNum(), 0);
      if ((localMimeMessage != null) && (paramPOP3Handler != null))
      {
        paramArrayList = localMimeMessage.getDate();
        paramPOP3Handler = paramPOP3Handler.getDate();
        if ((paramArrayList != null) && (paramPOP3Handler != null))
        {
          if (paramPOP3Handler.getTime() - localMimeMessage.getDate().getTime() > 10L) {}
          for (paramArrayList = "aesc";; paramArrayList = "desc")
          {
            this.uidOrderMap.put(paramProfile.getPopName(), paramArrayList);
            saveUidOrderMap(this.uidOrderMap);
            return (String)this.uidOrderMap.get(paramProfile.getPopName());
          }
        }
      }
      return "aesc";
    }
    catch (Exception paramProfile)
    {
      Logger.log(6, "POP3ProtocolManager", Log.getStackTraceString(paramProfile));
    }
  }
  
  private ArrayList<String> getDeleteUidList(Profile paramProfile)
  {
    return getUidListFromFile(FileUtility.getPopDirPath() + paramProfile.getPopName() + ".delete");
  }
  
  private ArrayList<String> getExistUidList(Profile paramProfile)
  {
    return getUidListFromFile(FileUtility.getPopDirPath() + paramProfile.getPopName() + ".exist");
  }
  
  public static POP3ProtocolManager getInstance()
  {
    return instance;
  }
  
  private String getKey(Profile paramProfile)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(paramProfile.getPopName());
    localStringBuilder.append("^");
    localStringBuilder.append(paramProfile.getPopPassword());
    localStringBuilder.append("^");
    localStringBuilder.append(paramProfile.getPopServer());
    localStringBuilder.append("^");
    localStringBuilder.append(paramProfile.getPopPort());
    localStringBuilder.append("^");
    localStringBuilder.append(paramProfile.getPopSSLPort());
    return localStringBuilder.toString();
  }
  
  private ArrayList<String> getLastUidList(Profile paramProfile)
  {
    return getUidListFromFile(FileUtility.getPopDirPath() + paramProfile.getPopName() + ".last");
  }
  
  private long getMailSize(ArrayList<POP3MsgStatus> paramArrayList, int paramInt)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      POP3MsgStatus localPOP3MsgStatus = (POP3MsgStatus)paramArrayList.next();
      if (paramInt == localPOP3MsgStatus.getMsgNum()) {
        return localPOP3MsgStatus.getSize();
      }
    }
    return 0L;
  }
  
  private int getMinMsgLine(ArrayList<POP3MsgStatus> paramArrayList, int paramInt)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      POP3MsgStatus localPOP3MsgStatus = (POP3MsgStatus)paramArrayList.next();
      if (paramInt == localPOP3MsgStatus.getMsgNum()) {
        return localPOP3MsgStatus.getMinMsgLine();
      }
    }
    return 100;
  }
  
  private int getMsgNumByUid(ArrayList<POP3MsgUID> paramArrayList, String paramString)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      POP3MsgUID localPOP3MsgUID = (POP3MsgUID)paramArrayList.next();
      if (localPOP3MsgUID.getUid().equals(paramString)) {
        return localPOP3MsgUID.getMsgNum();
      }
    }
    return -1;
  }
  
  private long getMsgSize(ArrayList<POP3MsgStatus> paramArrayList, int paramInt)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      POP3MsgStatus localPOP3MsgStatus = (POP3MsgStatus)paramArrayList.next();
      if (paramInt == localPOP3MsgStatus.getMsgNum()) {
        return localPOP3MsgStatus.getSize();
      }
    }
    return 0L;
  }
  
  private TaskPool getTaskPoolByUser(Profile paramProfile)
  {
    synchronized (this.userTaskPool)
    {
      String str = getKey(paramProfile);
      TaskPool localTaskPool2 = (TaskPool)this.userTaskPool.get(str);
      TaskPool localTaskPool1 = localTaskPool2;
      if (localTaskPool2 == null)
      {
        localTaskPool1 = new TaskPool(paramProfile, 3, 5, 3);
        this.userTaskPool.put(str, localTaskPool1);
      }
      return localTaskPool1;
    }
  }
  
  /* Error */
  private ArrayList<String> getUidListFromFile(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: new 162	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 163	java/util/ArrayList:<init>	()V
    //   12: astore 6
    //   14: aload_1
    //   15: invokestatic 323	com/tencent/moai/mailsdk/util/FileUtility:createFile	(Ljava/lang/String;)Z
    //   18: pop
    //   19: new 325	java/io/File
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 328	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: invokestatic 332	com/tencent/moai/mailsdk/util/FileUtility:getFileInputStream	(Ljava/io/File;)Ljava/io/InputStream;
    //   30: astore_2
    //   31: new 334	com/tencent/moai/mailsdk/util/stream/LineInputStream
    //   34: dup
    //   35: aload_2
    //   36: invokespecial 337	com/tencent/moai/mailsdk/util/stream/LineInputStream:<init>	(Ljava/io/InputStream;)V
    //   39: astore_3
    //   40: aload_3
    //   41: invokevirtual 340	com/tencent/moai/mailsdk/util/stream/LineInputStream:readLine	()Ljava/lang/String;
    //   44: astore 4
    //   46: aload 4
    //   48: ifnull +70 -> 118
    //   51: aload 6
    //   53: aload 4
    //   55: invokevirtual 187	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   58: pop
    //   59: goto -19 -> 40
    //   62: astore 4
    //   64: bipush 6
    //   66: ldc 17
    //   68: new 252	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   75: ldc_w 342
    //   78: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_1
    //   82: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload 4
    //   87: invokestatic 243	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   90: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 249	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   99: aload_3
    //   100: ifnull +7 -> 107
    //   103: aload_3
    //   104: invokevirtual 345	com/tencent/moai/mailsdk/util/stream/LineInputStream:close	()V
    //   107: aload_2
    //   108: ifnull +7 -> 115
    //   111: aload_2
    //   112: invokevirtual 348	java/io/InputStream:close	()V
    //   115: aload 6
    //   117: areturn
    //   118: aload_3
    //   119: ifnull +7 -> 126
    //   122: aload_3
    //   123: invokevirtual 345	com/tencent/moai/mailsdk/util/stream/LineInputStream:close	()V
    //   126: aload_2
    //   127: ifnull -12 -> 115
    //   130: aload_2
    //   131: invokevirtual 348	java/io/InputStream:close	()V
    //   134: aload 6
    //   136: areturn
    //   137: astore_1
    //   138: aload 6
    //   140: areturn
    //   141: astore_1
    //   142: aconst_null
    //   143: astore 4
    //   145: aload_3
    //   146: astore_2
    //   147: aload 4
    //   149: astore_3
    //   150: aload_3
    //   151: ifnull +7 -> 158
    //   154: aload_3
    //   155: invokevirtual 345	com/tencent/moai/mailsdk/util/stream/LineInputStream:close	()V
    //   158: aload_2
    //   159: ifnull +7 -> 166
    //   162: aload_2
    //   163: invokevirtual 348	java/io/InputStream:close	()V
    //   166: aload_1
    //   167: athrow
    //   168: astore_1
    //   169: goto -43 -> 126
    //   172: astore_1
    //   173: goto -66 -> 107
    //   176: astore_1
    //   177: aload 6
    //   179: areturn
    //   180: astore_3
    //   181: goto -23 -> 158
    //   184: astore_2
    //   185: goto -19 -> 166
    //   188: astore_1
    //   189: aconst_null
    //   190: astore_3
    //   191: goto -41 -> 150
    //   194: astore_1
    //   195: goto -45 -> 150
    //   198: astore_1
    //   199: goto -49 -> 150
    //   202: astore 4
    //   204: aconst_null
    //   205: astore_3
    //   206: aload 5
    //   208: astore_2
    //   209: goto -145 -> 64
    //   212: astore 4
    //   214: aconst_null
    //   215: astore_3
    //   216: goto -152 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	POP3ProtocolManager
    //   0	219	1	paramString	String
    //   30	133	2	localObject1	Object
    //   184	1	2	localIOException1	IOException
    //   208	1	2	localObject2	Object
    //   1	154	3	localObject3	Object
    //   180	1	3	localIOException2	IOException
    //   190	26	3	localObject4	Object
    //   44	10	4	str	String
    //   62	24	4	localIOException3	IOException
    //   143	5	4	localObject5	Object
    //   202	1	4	localIOException4	IOException
    //   212	1	4	localIOException5	IOException
    //   3	204	5	localObject6	Object
    //   12	166	6	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   40	46	62	java/io/IOException
    //   51	59	62	java/io/IOException
    //   130	134	137	java/io/IOException
    //   14	31	141	finally
    //   122	126	168	java/io/IOException
    //   103	107	172	java/io/IOException
    //   111	115	176	java/io/IOException
    //   154	158	180	java/io/IOException
    //   162	166	184	java/io/IOException
    //   31	40	188	finally
    //   40	46	194	finally
    //   51	59	194	finally
    //   64	99	198	finally
    //   14	31	202	java/io/IOException
    //   31	40	212	java/io/IOException
  }
  
  /* Error */
  private HashMap<String, String> getUidOrderMap()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 39	java/util/HashMap
    //   5: dup
    //   6: invokespecial 40	java/util/HashMap:<init>	()V
    //   9: astore 5
    //   11: new 252	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   18: invokestatic 258	com/tencent/moai/mailsdk/util/FileUtility:getPopDirPath	()Ljava/lang/String;
    //   21: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc_w 351
    //   27: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore_1
    //   34: aload_1
    //   35: invokestatic 323	com/tencent/moai/mailsdk/util/FileUtility:createFile	(Ljava/lang/String;)Z
    //   38: pop
    //   39: new 325	java/io/File
    //   42: dup
    //   43: aload_1
    //   44: invokespecial 328	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: invokestatic 332	com/tencent/moai/mailsdk/util/FileUtility:getFileInputStream	(Ljava/io/File;)Ljava/io/InputStream;
    //   50: astore_1
    //   51: new 334	com/tencent/moai/mailsdk/util/stream/LineInputStream
    //   54: dup
    //   55: aload_1
    //   56: invokespecial 337	com/tencent/moai/mailsdk/util/stream/LineInputStream:<init>	(Ljava/io/InputStream;)V
    //   59: astore_3
    //   60: aload_3
    //   61: invokevirtual 340	com/tencent/moai/mailsdk/util/stream/LineInputStream:readLine	()Ljava/lang/String;
    //   64: astore_2
    //   65: aload_2
    //   66: ifnull +71 -> 137
    //   69: aload_2
    //   70: ldc_w 353
    //   73: invokevirtual 357	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   76: astore_2
    //   77: aload_2
    //   78: arraylength
    //   79: iconst_2
    //   80: if_icmpne -20 -> 60
    //   83: aload 5
    //   85: aload_2
    //   86: iconst_0
    //   87: aaload
    //   88: aload_2
    //   89: iconst_1
    //   90: aaload
    //   91: invokevirtual 207	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   94: pop
    //   95: goto -35 -> 60
    //   98: astore 4
    //   100: aload_1
    //   101: astore_2
    //   102: aload_3
    //   103: astore_1
    //   104: aload 4
    //   106: astore_3
    //   107: bipush 6
    //   109: ldc 17
    //   111: aload_3
    //   112: invokestatic 243	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   115: invokestatic 249	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   118: aload_1
    //   119: ifnull +7 -> 126
    //   122: aload_1
    //   123: invokevirtual 345	com/tencent/moai/mailsdk/util/stream/LineInputStream:close	()V
    //   126: aload_2
    //   127: ifnull +7 -> 134
    //   130: aload_2
    //   131: invokevirtual 348	java/io/InputStream:close	()V
    //   134: aload 5
    //   136: areturn
    //   137: aload_3
    //   138: ifnull +7 -> 145
    //   141: aload_3
    //   142: invokevirtual 345	com/tencent/moai/mailsdk/util/stream/LineInputStream:close	()V
    //   145: aload_1
    //   146: ifnull -12 -> 134
    //   149: aload_1
    //   150: invokevirtual 348	java/io/InputStream:close	()V
    //   153: aload 5
    //   155: areturn
    //   156: astore_1
    //   157: aload 5
    //   159: areturn
    //   160: astore_2
    //   161: aconst_null
    //   162: astore_3
    //   163: aconst_null
    //   164: astore_1
    //   165: aload_3
    //   166: ifnull +7 -> 173
    //   169: aload_3
    //   170: invokevirtual 345	com/tencent/moai/mailsdk/util/stream/LineInputStream:close	()V
    //   173: aload_1
    //   174: ifnull +7 -> 181
    //   177: aload_1
    //   178: invokevirtual 348	java/io/InputStream:close	()V
    //   181: aload_2
    //   182: athrow
    //   183: astore_2
    //   184: goto -39 -> 145
    //   187: astore_1
    //   188: goto -62 -> 126
    //   191: astore_1
    //   192: aload 5
    //   194: areturn
    //   195: astore_3
    //   196: goto -23 -> 173
    //   199: astore_1
    //   200: goto -19 -> 181
    //   203: astore_2
    //   204: aconst_null
    //   205: astore_3
    //   206: goto -41 -> 165
    //   209: astore_2
    //   210: goto -45 -> 165
    //   213: astore_3
    //   214: aload_2
    //   215: astore 4
    //   217: aload_3
    //   218: astore_2
    //   219: aload_1
    //   220: astore_3
    //   221: aload 4
    //   223: astore_1
    //   224: goto -59 -> 165
    //   227: astore_3
    //   228: aconst_null
    //   229: astore_1
    //   230: goto -123 -> 107
    //   233: astore_3
    //   234: aconst_null
    //   235: astore 4
    //   237: aload_1
    //   238: astore_2
    //   239: aload 4
    //   241: astore_1
    //   242: goto -135 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	POP3ProtocolManager
    //   33	117	1	localObject1	Object
    //   156	1	1	localIOException1	IOException
    //   164	14	1	localObject2	Object
    //   187	1	1	localIOException2	IOException
    //   191	1	1	localIOException3	IOException
    //   199	21	1	localIOException4	IOException
    //   223	19	1	localObject3	Object
    //   1	130	2	localObject4	Object
    //   160	22	2	localObject5	Object
    //   183	1	2	localIOException5	IOException
    //   203	1	2	localObject6	Object
    //   209	6	2	localObject7	Object
    //   218	21	2	localObject8	Object
    //   59	111	3	localObject9	Object
    //   195	1	3	localIOException6	IOException
    //   205	1	3	localObject10	Object
    //   213	5	3	localObject11	Object
    //   220	1	3	localIOException7	IOException
    //   227	1	3	localIOException8	IOException
    //   233	1	3	localIOException9	IOException
    //   98	7	4	localIOException10	IOException
    //   215	25	4	localObject12	Object
    //   9	184	5	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   60	65	98	java/io/IOException
    //   69	95	98	java/io/IOException
    //   149	153	156	java/io/IOException
    //   34	51	160	finally
    //   141	145	183	java/io/IOException
    //   122	126	187	java/io/IOException
    //   130	134	191	java/io/IOException
    //   169	173	195	java/io/IOException
    //   177	181	199	java/io/IOException
    //   51	60	203	finally
    //   60	65	209	finally
    //   69	95	209	finally
    //   107	118	213	finally
    //   34	51	227	java/io/IOException
    //   51	60	233	java/io/IOException
  }
  
  private void handleAuthError(Profile paramProfile, MessageException paramMessageException)
  {
    synchronized (this.userTaskPool)
    {
      Object localObject = (TaskPool)this.userTaskPool.get(getKey(paramProfile));
      if (localObject != null)
      {
        localObject = ((TaskPool)localObject).shutDownNow();
        this.userTaskPool.remove(getKey(paramProfile));
        paramProfile = ((List)localObject).iterator();
        while (paramProfile.hasNext())
        {
          localObject = (Runnable)paramProfile.next();
          if ((localObject instanceof TaskPool.TaskRunnable)) {
            ((TaskPool.TaskRunnable)localObject).getCallback().onError(paramMessageException);
          }
        }
      }
    }
  }
  
  private List<Runnable> handlePopLock(Profile paramProfile)
  {
    Object localObject = new ArrayList();
    for (;;)
    {
      synchronized (this.userTaskPool)
      {
        TaskPool localTaskPool = (TaskPool)this.userTaskPool.get(getKey(paramProfile));
        if (localTaskPool != null)
        {
          if (localTaskPool.getMaxSize() != 1)
          {
            Logger.log(4, "POP3ProtocolManager", "change pool size to single");
            localObject = localTaskPool.clearAndWait();
            this.userTaskPool.remove(getKey(paramProfile));
            localTaskPool = new TaskPool(paramProfile, 3, 1, 3);
            this.userTaskPool.put(getKey(paramProfile), localTaskPool);
            paramProfile = (Profile)localObject;
            return paramProfile;
          }
        }
        else
        {
          localTaskPool = new TaskPool(paramProfile, 3, 1, 3);
          this.userTaskPool.put(getKey(paramProfile), localTaskPool);
        }
      }
      paramProfile = (Profile)localObject;
    }
  }
  
  private void removeDeleteUidList(Profile paramProfile)
  {
    try
    {
      FileUtility.deleteFile(FileUtility.getPopDirPath() + paramProfile.getPopName() + ".delete");
      return;
    }
    catch (IOException paramProfile)
    {
      Logger.log(6, "POP3ProtocolManager", Log.getStackTraceString(paramProfile));
    }
  }
  
  private void removeExistUidList(Profile paramProfile)
  {
    try
    {
      FileUtility.deleteFile(FileUtility.getPopDirPath() + paramProfile.getPopName() + ".exist");
      return;
    }
    catch (IOException paramProfile)
    {
      Logger.log(6, "POP3ProtocolManager", Log.getStackTraceString(paramProfile));
    }
  }
  
  private void removeLastUidList(Profile paramProfile)
  {
    try
    {
      FileUtility.deleteFile(FileUtility.getPopDirPath() + paramProfile.getPopName() + ".last");
      return;
    }
    catch (IOException paramProfile)
    {
      Logger.log(6, "POP3ProtocolManager", Log.getStackTraceString(paramProfile));
    }
  }
  
  private void removeUidOrderMap(Profile paramProfile)
  {
    this.uidOrderMap.remove(paramProfile.getPopName());
    HashMap localHashMap = getUidOrderMap();
    localHashMap.remove(paramProfile.getPopName());
    saveUidOrderMap(localHashMap);
  }
  
  private void resetMailAttachment(Mail paramMail, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      localObject = paramMail.getAttachments();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Attachment localAttachment = (Attachment)((Iterator)localObject).next();
          try
          {
            FileUtility.deleteFile(localAttachment.getPath());
          }
          catch (IOException localIOException)
          {
            Logger.log(6, "POP3ProtocolManager", "delete unComplete attach fail:" + localIOException);
          }
        }
      }
    }
    if (paramBoolean) {}
    for (Object localObject = paramMail.getAttachments();; localObject = null)
    {
      paramMail.setAttachments((ArrayList)localObject);
      return;
    }
  }
  
  private void saveDeleteUidList(Profile paramProfile, ArrayList<String> paramArrayList)
  {
    saveUidListToFile(FileUtility.getPopDirPath() + paramProfile.getPopName() + ".delete", paramArrayList);
  }
  
  private void saveExistUidList(Profile paramProfile, ArrayList<String> paramArrayList)
  {
    saveUidListToFile(FileUtility.getPopDirPath() + paramProfile.getPopName() + ".exist", paramArrayList);
  }
  
  private void saveLastUidList(Profile paramProfile, ArrayList<String> paramArrayList)
  {
    saveUidListToFile(FileUtility.getPopDirPath() + paramProfile.getPopName() + ".last", paramArrayList);
  }
  
  /* Error */
  private void saveUidListToFile(String paramString, ArrayList<String> paramArrayList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: invokestatic 323	com/tencent/moai/mailsdk/util/FileUtility:createFile	(Ljava/lang/String;)Z
    //   7: pop
    //   8: new 325	java/io/File
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 328	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: invokestatic 422	com/tencent/moai/mailsdk/util/FileUtility:getFileOutputStream	(Ljava/io/File;)Ljava/io/OutputStream;
    //   19: astore_1
    //   20: new 424	com/tencent/moai/mailsdk/util/stream/LineOutputStream
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 427	com/tencent/moai/mailsdk/util/stream/LineOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   28: astore_3
    //   29: aload_2
    //   30: invokevirtual 167	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   33: astore_2
    //   34: aload_2
    //   35: invokeinterface 173 1 0
    //   40: ifeq +56 -> 96
    //   43: aload_3
    //   44: aload_2
    //   45: invokeinterface 177 1 0
    //   50: checkcast 199	java/lang/String
    //   53: invokevirtual 430	com/tencent/moai/mailsdk/util/stream/LineOutputStream:writeln	(Ljava/lang/String;)V
    //   56: goto -22 -> 34
    //   59: astore 4
    //   61: aload_1
    //   62: astore_2
    //   63: aload_3
    //   64: astore_1
    //   65: aload 4
    //   67: astore_3
    //   68: bipush 6
    //   70: ldc 17
    //   72: aload_3
    //   73: invokestatic 243	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   76: invokestatic 249	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   79: aload_1
    //   80: ifnull +7 -> 87
    //   83: aload_1
    //   84: invokevirtual 431	com/tencent/moai/mailsdk/util/stream/LineOutputStream:close	()V
    //   87: aload_2
    //   88: ifnull +7 -> 95
    //   91: aload_2
    //   92: invokevirtual 434	java/io/OutputStream:close	()V
    //   95: return
    //   96: aload_3
    //   97: invokevirtual 437	com/tencent/moai/mailsdk/util/stream/LineOutputStream:flush	()V
    //   100: aload_3
    //   101: ifnull +7 -> 108
    //   104: aload_3
    //   105: invokevirtual 431	com/tencent/moai/mailsdk/util/stream/LineOutputStream:close	()V
    //   108: aload_1
    //   109: ifnull -14 -> 95
    //   112: aload_1
    //   113: invokevirtual 434	java/io/OutputStream:close	()V
    //   116: return
    //   117: astore_1
    //   118: return
    //   119: astore_2
    //   120: aconst_null
    //   121: astore_3
    //   122: aconst_null
    //   123: astore_1
    //   124: aload_3
    //   125: ifnull +7 -> 132
    //   128: aload_3
    //   129: invokevirtual 431	com/tencent/moai/mailsdk/util/stream/LineOutputStream:close	()V
    //   132: aload_1
    //   133: ifnull +7 -> 140
    //   136: aload_1
    //   137: invokevirtual 434	java/io/OutputStream:close	()V
    //   140: aload_2
    //   141: athrow
    //   142: astore_2
    //   143: goto -35 -> 108
    //   146: astore_1
    //   147: goto -60 -> 87
    //   150: astore_1
    //   151: return
    //   152: astore_3
    //   153: goto -21 -> 132
    //   156: astore_1
    //   157: goto -17 -> 140
    //   160: astore_2
    //   161: aconst_null
    //   162: astore_3
    //   163: goto -39 -> 124
    //   166: astore_2
    //   167: goto -43 -> 124
    //   170: astore_3
    //   171: aload_2
    //   172: astore 4
    //   174: aload_3
    //   175: astore_2
    //   176: aload_1
    //   177: astore_3
    //   178: aload 4
    //   180: astore_1
    //   181: goto -57 -> 124
    //   184: astore_3
    //   185: aconst_null
    //   186: astore_1
    //   187: aload 4
    //   189: astore_2
    //   190: goto -122 -> 68
    //   193: astore_3
    //   194: aconst_null
    //   195: astore 4
    //   197: aload_1
    //   198: astore_2
    //   199: aload 4
    //   201: astore_1
    //   202: goto -134 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	POP3ProtocolManager
    //   0	205	1	paramString	String
    //   0	205	2	paramArrayList	ArrayList<String>
    //   28	101	3	localObject1	Object
    //   152	1	3	localIOException1	IOException
    //   162	1	3	localObject2	Object
    //   170	5	3	localObject3	Object
    //   177	1	3	str	String
    //   184	1	3	localIOException2	IOException
    //   193	1	3	localIOException3	IOException
    //   1	1	4	localObject4	Object
    //   59	7	4	localIOException4	IOException
    //   172	28	4	localArrayList	ArrayList<String>
    // Exception table:
    //   from	to	target	type
    //   29	34	59	java/io/IOException
    //   34	56	59	java/io/IOException
    //   96	100	59	java/io/IOException
    //   112	116	117	java/io/IOException
    //   3	20	119	finally
    //   104	108	142	java/io/IOException
    //   83	87	146	java/io/IOException
    //   91	95	150	java/io/IOException
    //   128	132	152	java/io/IOException
    //   136	140	156	java/io/IOException
    //   20	29	160	finally
    //   29	34	166	finally
    //   34	56	166	finally
    //   96	100	166	finally
    //   68	79	170	finally
    //   3	20	184	java/io/IOException
    //   20	29	193	java/io/IOException
  }
  
  /* Error */
  private void saveUidOrderMap(HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 252	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   10: invokestatic 258	com/tencent/moai/mailsdk/util/FileUtility:getPopDirPath	()Ljava/lang/String;
    //   13: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc_w 351
    //   19: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: astore_2
    //   26: aload_2
    //   27: invokestatic 323	com/tencent/moai/mailsdk/util/FileUtility:createFile	(Ljava/lang/String;)Z
    //   30: pop
    //   31: new 325	java/io/File
    //   34: dup
    //   35: aload_2
    //   36: invokespecial 328	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: invokestatic 422	com/tencent/moai/mailsdk/util/FileUtility:getFileOutputStream	(Ljava/io/File;)Ljava/io/OutputStream;
    //   42: astore_2
    //   43: new 424	com/tencent/moai/mailsdk/util/stream/LineOutputStream
    //   46: dup
    //   47: aload_2
    //   48: invokespecial 427	com/tencent/moai/mailsdk/util/stream/LineOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   51: astore_3
    //   52: aload_1
    //   53: invokevirtual 442	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   56: invokeinterface 445 1 0
    //   61: astore_1
    //   62: aload_1
    //   63: invokeinterface 173 1 0
    //   68: ifeq +100 -> 168
    //   71: aload_1
    //   72: invokeinterface 177 1 0
    //   77: checkcast 447	java/util/Map$Entry
    //   80: astore 4
    //   82: aload_3
    //   83: new 252	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   90: aload 4
    //   92: invokeinterface 449 1 0
    //   97: checkcast 199	java/lang/String
    //   100: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc_w 353
    //   106: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload 4
    //   111: invokeinterface 452 1 0
    //   116: checkcast 199	java/lang/String
    //   119: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokevirtual 430	com/tencent/moai/mailsdk/util/stream/LineOutputStream:writeln	(Ljava/lang/String;)V
    //   128: goto -66 -> 62
    //   131: astore 4
    //   133: aload_2
    //   134: astore_1
    //   135: aload_3
    //   136: astore_2
    //   137: aload 4
    //   139: astore_3
    //   140: bipush 6
    //   142: ldc 17
    //   144: aload_3
    //   145: invokestatic 243	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   148: invokestatic 249	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   151: aload_2
    //   152: ifnull +7 -> 159
    //   155: aload_2
    //   156: invokevirtual 431	com/tencent/moai/mailsdk/util/stream/LineOutputStream:close	()V
    //   159: aload_1
    //   160: ifnull +7 -> 167
    //   163: aload_1
    //   164: invokevirtual 434	java/io/OutputStream:close	()V
    //   167: return
    //   168: aload_3
    //   169: invokevirtual 437	com/tencent/moai/mailsdk/util/stream/LineOutputStream:flush	()V
    //   172: aload_3
    //   173: ifnull +7 -> 180
    //   176: aload_3
    //   177: invokevirtual 431	com/tencent/moai/mailsdk/util/stream/LineOutputStream:close	()V
    //   180: aload_2
    //   181: ifnull -14 -> 167
    //   184: aload_2
    //   185: invokevirtual 434	java/io/OutputStream:close	()V
    //   188: return
    //   189: astore_1
    //   190: return
    //   191: astore_1
    //   192: aconst_null
    //   193: astore_3
    //   194: aconst_null
    //   195: astore_2
    //   196: aload_3
    //   197: ifnull +7 -> 204
    //   200: aload_3
    //   201: invokevirtual 431	com/tencent/moai/mailsdk/util/stream/LineOutputStream:close	()V
    //   204: aload_2
    //   205: ifnull +7 -> 212
    //   208: aload_2
    //   209: invokevirtual 434	java/io/OutputStream:close	()V
    //   212: aload_1
    //   213: athrow
    //   214: astore_1
    //   215: goto -35 -> 180
    //   218: astore_2
    //   219: goto -60 -> 159
    //   222: astore_1
    //   223: return
    //   224: astore_3
    //   225: goto -21 -> 204
    //   228: astore_2
    //   229: goto -17 -> 212
    //   232: astore_1
    //   233: aconst_null
    //   234: astore_3
    //   235: goto -39 -> 196
    //   238: astore_1
    //   239: goto -43 -> 196
    //   242: astore_3
    //   243: aload_1
    //   244: astore 4
    //   246: aload_3
    //   247: astore_1
    //   248: aload_2
    //   249: astore_3
    //   250: aload 4
    //   252: astore_2
    //   253: goto -57 -> 196
    //   256: astore_3
    //   257: aconst_null
    //   258: astore_1
    //   259: aload 4
    //   261: astore_2
    //   262: goto -122 -> 140
    //   265: astore_3
    //   266: aload_2
    //   267: astore_1
    //   268: aload 4
    //   270: astore_2
    //   271: goto -131 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	POP3ProtocolManager
    //   0	274	1	paramHashMap	HashMap<String, String>
    //   25	184	2	localObject1	Object
    //   218	1	2	localIOException1	IOException
    //   228	21	2	localIOException2	IOException
    //   252	19	2	localHashMap1	HashMap<String, String>
    //   51	150	3	localObject2	Object
    //   224	1	3	localIOException3	IOException
    //   234	1	3	localObject3	Object
    //   242	5	3	localObject4	Object
    //   249	1	3	localIOException4	IOException
    //   256	1	3	localIOException5	IOException
    //   265	1	3	localIOException6	IOException
    //   1	109	4	localEntry	java.util.Map.Entry
    //   131	7	4	localIOException7	IOException
    //   244	25	4	localHashMap2	HashMap<String, String>
    // Exception table:
    //   from	to	target	type
    //   52	62	131	java/io/IOException
    //   62	128	131	java/io/IOException
    //   168	172	131	java/io/IOException
    //   184	188	189	java/io/IOException
    //   26	43	191	finally
    //   176	180	214	java/io/IOException
    //   155	159	218	java/io/IOException
    //   163	167	222	java/io/IOException
    //   200	204	224	java/io/IOException
    //   208	212	228	java/io/IOException
    //   43	52	232	finally
    //   52	62	238	finally
    //   62	128	238	finally
    //   168	172	238	finally
    //   140	151	242	finally
    //   26	43	256	java/io/IOException
    //   43	52	265	java/io/IOException
  }
  
  private boolean shouldHandlePopLock(Profile paramProfile)
  {
    for (;;)
    {
      synchronized (this.userTaskPool)
      {
        paramProfile = (TaskPool)this.userTaskPool.get(getKey(paramProfile));
        if (paramProfile != null)
        {
          if (paramProfile.getMaxSize() == 1) {
            break label54;
          }
          break label49;
          return bool;
        }
      }
      label49:
      boolean bool = true;
      continue;
      label54:
      bool = false;
    }
  }
  
  public void deleteMail(Profile paramProfile, Folder paramFolder, Mail[] paramArrayOfMail, MailOperationCallback paramMailOperationCallback)
  {
    Logger.log(4, "POP3ProtocolManager", "delete mail size:" + paramArrayOfMail.length);
    getTaskPoolByUser(paramProfile).post(new POP3ProtocolManager.7(this, "POP3Task-deleteMail", paramProfile, paramArrayOfMail, paramMailOperationCallback), new POP3ProtocolManager.8(this, paramProfile, paramFolder, paramArrayOfMail, paramMailOperationCallback));
  }
  
  public void downloadMailsAbstract(Profile paramProfile, Folder paramFolder, Mail[] paramArrayOfMail, MailAbstractCallBack paramMailAbstractCallBack)
  {
    Logger.log(4, "POP3ProtocolManager", "download mail abstract size:" + paramArrayOfMail.length);
    getTaskPoolByUser(paramProfile).post(new POP3ProtocolManager.5(this, "POP3Task-downloadMailsAbs", paramArrayOfMail, paramMailAbstractCallBack), new POP3ProtocolManager.6(this, paramProfile, paramFolder, paramArrayOfMail, paramMailAbstractCallBack));
  }
  
  public void downloadMailsText(Profile paramProfile, Folder paramFolder, Mail[] paramArrayOfMail, boolean paramBoolean, MailCallBack paramMailCallBack)
  {
    Logger.log(4, "POP3ProtocolManager", "download mail text size:" + paramArrayOfMail.length);
    getTaskPoolByUser(paramProfile).post(new POP3ProtocolManager.3(this, "POP3Task-downloadMailsText", paramArrayOfMail, paramMailCallBack, paramBoolean), new POP3ProtocolManager.4(this, paramProfile, paramFolder, paramArrayOfMail, paramBoolean, paramMailCallBack));
  }
  
  public void fetchMailList(Profile paramProfile, State paramState, Folder paramFolder, MailListCallBack paramMailListCallBack)
  {
    Logger.log(4, "POP3ProtocolManager", "fetch mail list folder:" + paramFolder.getRemoteId());
    getTaskPoolByUser(paramProfile).post(new POP3ProtocolManager.1(this, "POP3Task-fetchMailList", paramProfile, paramState, paramFolder, paramMailListCallBack), new POP3ProtocolManager.2(this, paramProfile, paramState, paramFolder, paramMailListCallBack));
  }
  
  public void initProfile(Profile paramProfile)
  {
    getTaskPoolByUser(paramProfile);
  }
  
  public void login(Profile paramProfile, LoginCallBack paramLoginCallBack)
  {
    Logger.log(4, "POP3ProtocolManager", "login name:" + paramProfile.getPopName() + "," + paramProfile.getPopPassword().hashCode());
    POP3Handler localPOP3Handler = new POP3Handler(paramProfile);
    try
    {
      localPOP3Handler.setTag("ExtraHandler");
      localPOP3Handler.openConnection();
      localPOP3Handler.auth(true);
      Logger.log(4, "POP3ProtocolManager", "login success name:" + paramProfile.getPopName());
      if (paramLoginCallBack != null) {
        paramLoginCallBack.onLoginSuccess(paramProfile);
      }
      return;
    }
    catch (MessageException localMessageException)
    {
      Logger.log(6, "POP3ProtocolManager", "login error:" + localMessageException.getResultCode() + ":" + localMessageException.getDetailCode() + ":" + localMessageException.getDetailMessage());
      Logger.log(6, "POP3ProtocolManager", Log.getStackTraceString(localMessageException));
      clearTaskPool(paramProfile, false);
      if (localMessageException.getResultCode() == 4)
      {
        int i = LoginUtility.getProtocolLoginError(localMessageException.getDetailMessage());
        String str = paramProfile.getPopName();
        if ((i != 2) && (i != 3) && (str.contains("@")) && (!MailParser.canUseFullName(str)))
        {
          paramProfile.setPopName(MailParser.getUserName(str));
          login(paramProfile, paramLoginCallBack);
          return;
        }
      }
      if (paramLoginCallBack != null) {
        paramLoginCallBack.onLoginError(localMessageException.getResultCode(), localMessageException.getDetailCode(), localMessageException.getDetailMessage());
      }
      return;
    }
    catch (Exception localException)
    {
      Logger.log(6, "POP3ProtocolManager", "login error:" + Log.getStackTraceString(localException));
      clearTaskPool(paramProfile, false);
      if (paramLoginCallBack != null) {
        paramLoginCallBack.onLoginError(1, 200001, localException.getMessage());
      }
      return;
    }
    finally
    {
      localPOP3Handler.closeConnection();
    }
  }
  
  public void logout(Profile paramProfile, LogoutCallBack paramLogoutCallBack)
  {
    Logger.log(4, "POP3ProtocolManager", "logout name:" + paramProfile.getPopName());
    removeLastUidList(paramProfile);
    removeExistUidList(paramProfile);
    removeDeleteUidList(paramProfile);
    removeUidOrderMap(paramProfile);
    clearTaskPool(paramProfile, true);
    if (paramLogoutCallBack != null) {
      paramLogoutCallBack.onSuccess(paramProfile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.POP3ProtocolManager
 * JD-Core Version:    0.7.0.1
 */