package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.marcos.CommonDefine;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LocalDraftUtils
{
  private static final String COMPOSE_CRASH_LOCAL_DRAFT_KEY = "compose_crash_local_draft";
  private static final String TAG = "LocalDraftUtils";
  
  public static void deleteLocalDraft()
  {
    QMLog.log(3, "LocalDraftUtils", "LocalDraftUtils : start delete localdraft");
    LocalDraftHelper.sharedInstance().deleteLocalDraft();
  }
  
  public static boolean hasLocalDraft()
  {
    boolean bool = false;
    try
    {
      ComposeMailUI localComposeMailUI = readLocalDraft();
      if (localComposeMailUI != null) {
        bool = true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(6, "LocalDraftUtils", "hasLocalDraft", localException);
      }
    }
    QMLog.log(2, "LocalDraftUtils", "hasLocalDraft: " + bool);
    return bool;
  }
  
  public static ComposeMailUI readLocalDraft()
  {
    try
    {
      ComposeMailUI localComposeMailUI = LocalDraftHelper.sharedInstance().readLocalDraft();
      if ((localComposeMailUI != null) && (localComposeMailUI.getContent() != null) && (localComposeMailUI.getContent().getBody() != null)) {
        return localComposeMailUI;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        System.gc();
        QMLog.log(6, "LocalDraftUtils", "readLocalDraft OOE", localOutOfMemoryError);
        Object localObject = null;
      }
    }
    return null;
  }
  
  public static boolean saveLocalDraft(ComposeMailUI paramComposeMailUI)
  {
    boolean bool = false;
    if (CommonDefine.SAVE_LOCAL_DRAFT) {}
    try
    {
      LocalDraftHelper.sharedInstance().saveLocalDraft(paramComposeMailUI);
      bool = true;
      return bool;
    }
    catch (OutOfMemoryError paramComposeMailUI)
    {
      System.gc();
      QMLog.log(6, "LocalDraftUtils", "saveLocalDraft OOE", paramComposeMailUI);
      return false;
    }
    catch (Exception paramComposeMailUI)
    {
      QMLog.log(6, "LocalDraftUtils", "saveLocalDraft ex", paramComposeMailUI);
    }
    return false;
  }
  
  public static void saveLocalDraftInBackground(ComposeMailUI paramComposeMailUI)
  {
    Threads.runInBackground(new LocalDraftUtils.1(paramComposeMailUI));
  }
  
  static class LocalDraftHelper
  {
    private static final String CONTENT_FILE_DIR = QMApplicationContext.sharedInstance().getFilesDir() + File.separator + "LocalDraft";
    private static final String CONTENT_FILE_NAME = "local_draft_content";
    private static LocalDraftHelper _instance = null;
    
    private static boolean SaveStringToFile(String paramString1, String paramString2, String paramString3)
    {
      File localFile = new File(paramString2);
      if ((!localFile.exists()) && (!localFile.isDirectory()) && (!localFile.mkdirs()))
      {
        QMLog.log(6, "LocalDraftUtils", "error creating directory: " + paramString2);
        return false;
      }
      paramString2 = paramString2 + File.separator + paramString3;
      paramString3 = new File(paramString2);
      try
      {
        paramString3 = new BufferedWriter(new FileWriter(paramString3));
        paramString3.write(paramString1);
        paramString3.close();
        return true;
      }
      catch (IOException paramString1)
      {
        QMLog.log(6, "LocalDraftUtils", "error writing file: " + paramString2, paramString1);
      }
      return false;
    }
    
    public static LocalDraftHelper sharedInstance()
    {
      try
      {
        if (_instance == null) {
          _instance = new LocalDraftHelper();
        }
        LocalDraftHelper localLocalDraftHelper = _instance;
        return localLocalDraftHelper;
      }
      finally {}
    }
    
    public void deleteLocalDraft()
    {
      try
      {
        File localFile = new File(CONTENT_FILE_DIR + File.separator + "local_draft_content");
        if ((localFile.exists()) && (localFile.isFile())) {
          localFile.delete();
        }
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    /* Error */
    public ComposeMailUI readLocalDraft()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: new 18	java/lang/StringBuilder
      //   5: dup
      //   6: invokespecial 21	java/lang/StringBuilder:<init>	()V
      //   9: getstatic 51	com/tencent/qqmail/activity/compose/LocalDraftUtils$LocalDraftHelper:CONTENT_FILE_DIR	Ljava/lang/String;
      //   12: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   15: getstatic 40	java/io/File:separator	Ljava/lang/String;
      //   18: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   21: ldc 12
      //   23: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   26: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   29: astore_1
      //   30: new 118	java/io/BufferedReader
      //   33: dup
      //   34: new 120	java/io/FileReader
      //   37: dup
      //   38: aload_1
      //   39: invokespecial 121	java/io/FileReader:<init>	(Ljava/lang/String;)V
      //   42: invokespecial 124	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   45: astore_1
      //   46: new 18	java/lang/StringBuilder
      //   49: dup
      //   50: invokespecial 21	java/lang/StringBuilder:<init>	()V
      //   53: astore_2
      //   54: aload_1
      //   55: invokevirtual 127	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   58: astore_3
      //   59: aload_3
      //   60: ifnull +34 -> 94
      //   63: aload_2
      //   64: aload_3
      //   65: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   68: pop
      //   69: aload_2
      //   70: ldc 129
      //   72: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   75: pop
      //   76: goto -22 -> 54
      //   79: astore_2
      //   80: aload_1
      //   81: ifnull +7 -> 88
      //   84: aload_1
      //   85: invokevirtual 130	java/io/BufferedReader:close	()V
      //   88: aconst_null
      //   89: astore_2
      //   90: aload_0
      //   91: monitorexit
      //   92: aload_2
      //   93: areturn
      //   94: aload_2
      //   95: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   98: invokevirtual 136	java/lang/String:getBytes	()[B
      //   101: invokestatic 142	com/tencent/qqmail/model/qmdomain/ObjectSerializable:fromByte	([B)Ljava/lang/Object;
      //   104: checkcast 144	com/tencent/qqmail/model/uidomain/ComposeMailUI
      //   107: astore_3
      //   108: aload_3
      //   109: astore_2
      //   110: aload_1
      //   111: ifnull -21 -> 90
      //   114: aload_1
      //   115: invokevirtual 130	java/io/BufferedReader:close	()V
      //   118: aload_3
      //   119: astore_2
      //   120: goto -30 -> 90
      //   123: astore_1
      //   124: aload_3
      //   125: astore_2
      //   126: goto -36 -> 90
      //   129: astore_1
      //   130: aconst_null
      //   131: astore_1
      //   132: aload_1
      //   133: ifnull +7 -> 140
      //   136: aload_1
      //   137: invokevirtual 130	java/io/BufferedReader:close	()V
      //   140: aconst_null
      //   141: astore_2
      //   142: goto -52 -> 90
      //   145: astore_2
      //   146: aconst_null
      //   147: astore_1
      //   148: aload_1
      //   149: ifnull +7 -> 156
      //   152: aload_1
      //   153: invokevirtual 130	java/io/BufferedReader:close	()V
      //   156: aload_2
      //   157: athrow
      //   158: astore_1
      //   159: aload_0
      //   160: monitorexit
      //   161: aload_1
      //   162: athrow
      //   163: astore_1
      //   164: goto -76 -> 88
      //   167: astore_1
      //   168: goto -28 -> 140
      //   171: astore_1
      //   172: goto -16 -> 156
      //   175: astore_2
      //   176: goto -28 -> 148
      //   179: astore_2
      //   180: goto -48 -> 132
      //   183: astore_1
      //   184: aconst_null
      //   185: astore_1
      //   186: goto -106 -> 80
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	189	0	this	LocalDraftHelper
      //   29	86	1	localObject1	Object
      //   123	1	1	localIOException1	IOException
      //   129	1	1	localIOException2	IOException
      //   131	22	1	localObject2	Object
      //   158	4	1	localObject3	Object
      //   163	1	1	localIOException3	IOException
      //   167	1	1	localIOException4	IOException
      //   171	1	1	localIOException5	IOException
      //   183	1	1	localFileNotFoundException1	java.io.FileNotFoundException
      //   185	1	1	localObject4	Object
      //   53	17	2	localStringBuilder	java.lang.StringBuilder
      //   79	1	2	localFileNotFoundException2	java.io.FileNotFoundException
      //   89	53	2	localObject5	Object
      //   145	12	2	localObject6	Object
      //   175	1	2	localObject7	Object
      //   179	1	2	localIOException6	IOException
      //   58	67	3	localObject8	Object
      // Exception table:
      //   from	to	target	type
      //   46	54	79	java/io/FileNotFoundException
      //   54	59	79	java/io/FileNotFoundException
      //   63	76	79	java/io/FileNotFoundException
      //   94	108	79	java/io/FileNotFoundException
      //   114	118	123	java/io/IOException
      //   30	46	129	java/io/IOException
      //   30	46	145	finally
      //   2	30	158	finally
      //   84	88	158	finally
      //   114	118	158	finally
      //   136	140	158	finally
      //   152	156	158	finally
      //   156	158	158	finally
      //   84	88	163	java/io/IOException
      //   136	140	167	java/io/IOException
      //   152	156	171	java/io/IOException
      //   46	54	175	finally
      //   54	59	175	finally
      //   63	76	175	finally
      //   94	108	175	finally
      //   46	54	179	java/io/IOException
      //   54	59	179	java/io/IOException
      //   63	76	179	java/io/IOException
      //   94	108	179	java/io/IOException
      //   30	46	183	java/io/FileNotFoundException
    }
    
    public void saveLocalDraft(ComposeMailUI paramComposeMailUI)
    {
      if (paramComposeMailUI == null) {
        return;
      }
      paramComposeMailUI = paramComposeMailUI.toString();
      try
      {
        SaveStringToFile(paramComposeMailUI, CONTENT_FILE_DIR, "local_draft_content");
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.LocalDraftUtils
 * JD-Core Version:    0.7.0.1
 */