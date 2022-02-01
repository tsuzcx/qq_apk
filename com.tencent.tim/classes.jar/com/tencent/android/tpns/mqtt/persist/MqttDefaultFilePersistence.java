package com.tencent.android.tpns.mqtt.persist;

import com.tencent.android.tpns.mqtt.MqttClientPersistence;
import com.tencent.android.tpns.mqtt.MqttPersistable;
import com.tencent.android.tpns.mqtt.MqttPersistenceException;
import com.tencent.android.tpns.mqtt.internal.FileLock;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public class MqttDefaultFilePersistence
  implements MqttClientPersistence
{
  private static FilenameFilter FILENAME_FILTER;
  private static final String LOCK_FILENAME = ".lck";
  private static final String MESSAGE_BACKUP_FILE_EXTENSION = ".bup";
  private static final String MESSAGE_FILE_EXTENSION = ".msg";
  private File clientDir = null;
  private File dataDir;
  private FileLock fileLock = null;
  
  public MqttDefaultFilePersistence()
  {
    this(System.getProperty("user.dir"));
  }
  
  public MqttDefaultFilePersistence(String paramString)
  {
    this.dataDir = new File(paramString);
  }
  
  private void checkIsOpen()
    throws MqttPersistenceException
  {
    if (this.clientDir == null) {
      throw new MqttPersistenceException();
    }
  }
  
  private static FilenameFilter getFilenameFilter()
  {
    if (FILENAME_FILTER == null) {
      FILENAME_FILTER = new PersistanceFileNameFilter(".msg");
    }
    return FILENAME_FILTER;
  }
  
  private File[] getFiles()
    throws MqttPersistenceException
  {
    checkIsOpen();
    File[] arrayOfFile = this.clientDir.listFiles(getFilenameFilter());
    if (arrayOfFile == null) {
      throw new MqttPersistenceException();
    }
    return arrayOfFile;
  }
  
  private boolean isSafeChar(char paramChar)
  {
    return (Character.isJavaIdentifierPart(paramChar)) || (paramChar == '-');
  }
  
  private void restoreBackups(File paramFile)
    throws MqttPersistenceException
  {
    File[] arrayOfFile = paramFile.listFiles(new PersistanceFileFilter(".bup"));
    if (arrayOfFile == null) {
      throw new MqttPersistenceException();
    }
    int i = 0;
    while (i < arrayOfFile.length)
    {
      File localFile = new File(paramFile, arrayOfFile[i].getName().substring(0, arrayOfFile[i].getName().length() - ".bup".length()));
      if (!arrayOfFile[i].renameTo(localFile))
      {
        localFile.delete();
        arrayOfFile[i].renameTo(localFile);
      }
      i += 1;
    }
  }
  
  public void clear()
    throws MqttPersistenceException
  {
    checkIsOpen();
    File[] arrayOfFile = getFiles();
    int i = 0;
    while (i < arrayOfFile.length)
    {
      arrayOfFile[i].delete();
      i += 1;
    }
    this.clientDir.delete();
  }
  
  public void close()
    throws MqttPersistenceException
  {
    try
    {
      if (this.fileLock != null) {
        this.fileLock.release();
      }
      if (getFiles().length == 0) {
        this.clientDir.delete();
      }
      this.clientDir = null;
      return;
    }
    finally {}
  }
  
  public boolean containsKey(String paramString)
    throws MqttPersistenceException
  {
    checkIsOpen();
    return new File(this.clientDir, paramString + ".msg").exists();
  }
  
  /* Error */
  public MqttPersistable get(String paramString)
    throws MqttPersistenceException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iconst_0
    //   4: istore_2
    //   5: aload_0
    //   6: invokespecial 64	com/tencent/android/tpns/mqtt/persist/MqttDefaultFilePersistence:checkIsOpen	()V
    //   9: new 140	java/io/FileInputStream
    //   12: dup
    //   13: new 45	java/io/File
    //   16: dup
    //   17: aload_0
    //   18: getfield 41	com/tencent/android/tpns/mqtt/persist/MqttDefaultFilePersistence:clientDir	Ljava/io/File;
    //   21: new 123	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   28: aload_1
    //   29: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 18
    //   34: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokespecial 102	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   43: invokespecial 142	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   46: astore 4
    //   48: aload 4
    //   50: invokevirtual 145	java/io/FileInputStream:available	()I
    //   53: istore_3
    //   54: iload_3
    //   55: newarray byte
    //   57: astore 5
    //   59: iload_2
    //   60: iload_3
    //   61: if_icmpge +20 -> 81
    //   64: iload_2
    //   65: aload 4
    //   67: aload 5
    //   69: iload_2
    //   70: iload_3
    //   71: iload_2
    //   72: isub
    //   73: invokevirtual 149	java/io/FileInputStream:read	([BII)I
    //   76: iadd
    //   77: istore_2
    //   78: goto -19 -> 59
    //   81: aload 4
    //   83: invokevirtual 151	java/io/FileInputStream:close	()V
    //   86: new 153	com/tencent/android/tpns/mqtt/internal/MqttPersistentData
    //   89: dup
    //   90: aload_1
    //   91: aload 5
    //   93: iconst_0
    //   94: aload 5
    //   96: arraylength
    //   97: aconst_null
    //   98: iconst_0
    //   99: iconst_0
    //   100: invokespecial 156	com/tencent/android/tpns/mqtt/internal/MqttPersistentData:<init>	(Ljava/lang/String;[BII[BII)V
    //   103: astore_1
    //   104: aload_1
    //   105: areturn
    //   106: astore_1
    //   107: aload 5
    //   109: astore 4
    //   111: aload 4
    //   113: ifnull +8 -> 121
    //   116: aload 4
    //   118: invokevirtual 151	java/io/FileInputStream:close	()V
    //   121: new 51	com/tencent/android/tpns/mqtt/MqttPersistenceException
    //   124: dup
    //   125: aload_1
    //   126: invokespecial 159	com/tencent/android/tpns/mqtt/MqttPersistenceException:<init>	(Ljava/lang/Throwable;)V
    //   129: athrow
    //   130: astore 4
    //   132: goto -11 -> 121
    //   135: astore_1
    //   136: goto -25 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	MqttDefaultFilePersistence
    //   0	139	1	paramString	String
    //   4	74	2	i	int
    //   53	20	3	j	int
    //   46	71	4	localObject	Object
    //   130	1	4	localIOException	IOException
    //   1	107	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   9	48	106	java/io/IOException
    //   116	121	130	java/io/IOException
    //   48	59	135	java/io/IOException
    //   64	78	135	java/io/IOException
    //   81	104	135	java/io/IOException
  }
  
  public Enumeration keys()
    throws MqttPersistenceException
  {
    checkIsOpen();
    File[] arrayOfFile = getFiles();
    Vector localVector = new Vector(arrayOfFile.length);
    int i = 0;
    while (i < arrayOfFile.length)
    {
      String str = arrayOfFile[i].getName();
      localVector.addElement(str.substring(0, str.length() - ".msg".length()));
      i += 1;
    }
    return localVector.elements();
  }
  
  /* Error */
  public void open(String paramString1, String paramString2)
    throws MqttPersistenceException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: getfield 48	com/tencent/android/tpns/mqtt/persist/MqttDefaultFilePersistence:dataDir	Ljava/io/File;
    //   7: invokevirtual 134	java/io/File:exists	()Z
    //   10: ifeq +21 -> 31
    //   13: aload_0
    //   14: getfield 48	com/tencent/android/tpns/mqtt/persist/MqttDefaultFilePersistence:dataDir	Ljava/io/File;
    //   17: invokevirtual 180	java/io/File:isDirectory	()Z
    //   20: ifne +11 -> 31
    //   23: new 51	com/tencent/android/tpns/mqtt/MqttPersistenceException
    //   26: dup
    //   27: invokespecial 52	com/tencent/android/tpns/mqtt/MqttPersistenceException:<init>	()V
    //   30: athrow
    //   31: aload_0
    //   32: getfield 48	com/tencent/android/tpns/mqtt/persist/MqttDefaultFilePersistence:dataDir	Ljava/io/File;
    //   35: invokevirtual 134	java/io/File:exists	()Z
    //   38: ifne +21 -> 59
    //   41: aload_0
    //   42: getfield 48	com/tencent/android/tpns/mqtt/persist/MqttDefaultFilePersistence:dataDir	Ljava/io/File;
    //   45: invokevirtual 183	java/io/File:mkdirs	()Z
    //   48: ifne +11 -> 59
    //   51: new 51	com/tencent/android/tpns/mqtt/MqttPersistenceException
    //   54: dup
    //   55: invokespecial 52	com/tencent/android/tpns/mqtt/MqttPersistenceException:<init>	()V
    //   58: athrow
    //   59: aload_0
    //   60: getfield 48	com/tencent/android/tpns/mqtt/persist/MqttDefaultFilePersistence:dataDir	Ljava/io/File;
    //   63: invokevirtual 186	java/io/File:canWrite	()Z
    //   66: ifne +11 -> 77
    //   69: new 51	com/tencent/android/tpns/mqtt/MqttPersistenceException
    //   72: dup
    //   73: invokespecial 52	com/tencent/android/tpns/mqtt/MqttPersistenceException:<init>	()V
    //   76: athrow
    //   77: new 188	java/lang/StringBuffer
    //   80: dup
    //   81: invokespecial 189	java/lang/StringBuffer:<init>	()V
    //   84: astore 6
    //   86: iconst_0
    //   87: istore 4
    //   89: iload 4
    //   91: aload_1
    //   92: invokevirtual 95	java/lang/String:length	()I
    //   95: if_icmpge +34 -> 129
    //   98: aload_1
    //   99: iload 4
    //   101: invokevirtual 193	java/lang/String:charAt	(I)C
    //   104: istore_3
    //   105: aload_0
    //   106: iload_3
    //   107: invokespecial 195	com/tencent/android/tpns/mqtt/persist/MqttDefaultFilePersistence:isSafeChar	(C)Z
    //   110: ifeq +10 -> 120
    //   113: aload 6
    //   115: iload_3
    //   116: invokevirtual 198	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   119: pop
    //   120: iload 4
    //   122: iconst_1
    //   123: iadd
    //   124: istore 4
    //   126: goto -37 -> 89
    //   129: aload 6
    //   131: ldc 200
    //   133: invokevirtual 203	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   136: pop
    //   137: iload 5
    //   139: istore 4
    //   141: iload 4
    //   143: aload_2
    //   144: invokevirtual 95	java/lang/String:length	()I
    //   147: if_icmpge +34 -> 181
    //   150: aload_2
    //   151: iload 4
    //   153: invokevirtual 193	java/lang/String:charAt	(I)C
    //   156: istore_3
    //   157: aload_0
    //   158: iload_3
    //   159: invokespecial 195	com/tencent/android/tpns/mqtt/persist/MqttDefaultFilePersistence:isSafeChar	(C)Z
    //   162: ifeq +10 -> 172
    //   165: aload 6
    //   167: iload_3
    //   168: invokevirtual 198	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   171: pop
    //   172: iload 4
    //   174: iconst_1
    //   175: iadd
    //   176: istore 4
    //   178: goto -37 -> 141
    //   181: aload_0
    //   182: monitorenter
    //   183: aload_0
    //   184: getfield 41	com/tencent/android/tpns/mqtt/persist/MqttDefaultFilePersistence:clientDir	Ljava/io/File;
    //   187: ifnonnull +43 -> 230
    //   190: aload 6
    //   192: invokevirtual 204	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   195: astore_1
    //   196: aload_0
    //   197: new 45	java/io/File
    //   200: dup
    //   201: aload_0
    //   202: getfield 48	com/tencent/android/tpns/mqtt/persist/MqttDefaultFilePersistence:dataDir	Ljava/io/File;
    //   205: aload_1
    //   206: invokespecial 102	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   209: putfield 41	com/tencent/android/tpns/mqtt/persist/MqttDefaultFilePersistence:clientDir	Ljava/io/File;
    //   212: aload_0
    //   213: getfield 41	com/tencent/android/tpns/mqtt/persist/MqttDefaultFilePersistence:clientDir	Ljava/io/File;
    //   216: invokevirtual 134	java/io/File:exists	()Z
    //   219: ifne +11 -> 230
    //   222: aload_0
    //   223: getfield 41	com/tencent/android/tpns/mqtt/persist/MqttDefaultFilePersistence:clientDir	Ljava/io/File;
    //   226: invokevirtual 207	java/io/File:mkdir	()Z
    //   229: pop
    //   230: aload_0
    //   231: new 116	com/tencent/android/tpns/mqtt/internal/FileLock
    //   234: dup
    //   235: aload_0
    //   236: getfield 41	com/tencent/android/tpns/mqtt/persist/MqttDefaultFilePersistence:clientDir	Ljava/io/File;
    //   239: ldc 12
    //   241: invokespecial 208	com/tencent/android/tpns/mqtt/internal/FileLock:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   244: putfield 43	com/tencent/android/tpns/mqtt/persist/MqttDefaultFilePersistence:fileLock	Lcom/tencent/android/tpns/mqtt/internal/FileLock;
    //   247: aload_0
    //   248: aload_0
    //   249: getfield 41	com/tencent/android/tpns/mqtt/persist/MqttDefaultFilePersistence:clientDir	Ljava/io/File;
    //   252: invokespecial 210	com/tencent/android/tpns/mqtt/persist/MqttDefaultFilePersistence:restoreBackups	(Ljava/io/File;)V
    //   255: aload_0
    //   256: monitorexit
    //   257: return
    //   258: astore_1
    //   259: aload_0
    //   260: monitorexit
    //   261: aload_1
    //   262: athrow
    //   263: astore_1
    //   264: goto -17 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	MqttDefaultFilePersistence
    //   0	267	1	paramString1	String
    //   0	267	2	paramString2	String
    //   104	64	3	c	char
    //   87	90	4	i	int
    //   1	137	5	j	int
    //   84	107	6	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   183	230	258	finally
    //   230	247	258	finally
    //   247	257	258	finally
    //   259	261	258	finally
    //   230	247	263	java/lang/Throwable
  }
  
  public void put(String paramString, MqttPersistable paramMqttPersistable)
    throws MqttPersistenceException
  {
    checkIsOpen();
    File localFile = new File(this.clientDir, paramString + ".msg");
    paramString = new File(this.clientDir, paramString + ".msg" + ".bup");
    if ((localFile.exists()) && (!localFile.renameTo(paramString)))
    {
      paramString.delete();
      localFile.renameTo(paramString);
    }
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
      localFileOutputStream.write(paramMqttPersistable.getHeaderBytes(), paramMqttPersistable.getHeaderOffset(), paramMqttPersistable.getHeaderLength());
      if (paramMqttPersistable.getPayloadBytes() != null) {
        localFileOutputStream.write(paramMqttPersistable.getPayloadBytes(), paramMqttPersistable.getPayloadOffset(), paramMqttPersistable.getPayloadLength());
      }
      localFileOutputStream.getFD().sync();
      localFileOutputStream.close();
      if (paramString.exists()) {
        paramString.delete();
      }
      return;
    }
    catch (IOException paramMqttPersistable)
    {
      throw new MqttPersistenceException(paramMqttPersistable);
    }
    finally
    {
      if ((paramString.exists()) && (!paramString.renameTo(localFile)))
      {
        localFile.delete();
        paramString.renameTo(localFile);
      }
    }
  }
  
  public void remove(String paramString)
    throws MqttPersistenceException
  {
    checkIsOpen();
    paramString = new File(this.clientDir, paramString + ".msg");
    if (paramString.exists()) {
      paramString.delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.persist.MqttDefaultFilePersistence
 * JD-Core Version:    0.7.0.1
 */