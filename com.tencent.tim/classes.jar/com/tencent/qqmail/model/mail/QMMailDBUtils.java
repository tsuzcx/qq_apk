package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.qmdomain.MailFoldItem;
import com.tencent.qqmail.model.qmdomain.ObjectSerializable;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.File;
import java.util.ArrayList;

public class QMMailDBUtils
{
  private static final String TAG = "QMMailDBUtils";
  private static final String TMPMAILCONTENT = "mail_content_not_here";
  private static final long mailContentThreshold = 493158L;
  private static final long mailContentThresholdText = 30158L;
  
  /* Error */
  public static byte[] getContentBytes(long paramLong, MailContent paramMailContent)
  {
    // Byte code:
    //   0: iconst_1
    //   1: newarray byte
    //   3: astore_3
    //   4: aload_2
    //   5: invokestatic 35	com/tencent/qqmail/model/mail/QMMailDBUtils:isMailContOverThreshold	(Lcom/tencent/qqmail/model/qmdomain/MailContent;)Z
    //   8: ifeq +131 -> 139
    //   11: iconst_3
    //   12: ldc 8
    //   14: new 37	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   21: ldc 40
    //   23: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: lload_0
    //   27: invokevirtual 47	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   30: ldc 49
    //   32: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 59	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   41: ldc 11
    //   43: invokevirtual 65	java/lang/String:getBytes	()[B
    //   46: astore_3
    //   47: new 67	java/io/FileOutputStream
    //   50: dup
    //   51: lload_0
    //   52: invokestatic 71	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   55: invokestatic 75	com/tencent/qqmail/model/mail/QMMailDBUtils:getFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   58: invokespecial 78	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   61: astore 4
    //   63: new 80	java/io/ObjectOutputStream
    //   66: dup
    //   67: aload 4
    //   69: invokespecial 83	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   72: astore 5
    //   74: aload 5
    //   76: aload_2
    //   77: invokevirtual 87	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   80: aload 5
    //   82: invokevirtual 90	java/io/ObjectOutputStream:close	()V
    //   85: aload 4
    //   87: invokevirtual 91	java/io/FileOutputStream:close	()V
    //   90: aload_3
    //   91: areturn
    //   92: astore_2
    //   93: bipush 6
    //   95: ldc 8
    //   97: new 37	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   104: ldc 93
    //   106: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_2
    //   110: invokevirtual 96	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   113: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 59	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   122: goto -42 -> 80
    //   125: astore_2
    //   126: aload_2
    //   127: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   130: aload_3
    //   131: areturn
    //   132: astore_2
    //   133: aload_2
    //   134: invokevirtual 100	java/io/FileNotFoundException:printStackTrace	()V
    //   137: aload_3
    //   138: areturn
    //   139: aload_2
    //   140: invokestatic 106	com/tencent/qqmail/model/qmdomain/ObjectSerializable:toByte	(Ljava/lang/Object;)[B
    //   143: astore_2
    //   144: aload_2
    //   145: areturn
    //   146: astore_2
    //   147: bipush 6
    //   149: ldc 8
    //   151: new 37	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   158: ldc 108
    //   160: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_2
    //   164: invokevirtual 96	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   167: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 59	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   176: aload_3
    //   177: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	paramLong	long
    //   0	178	2	paramMailContent	MailContent
    //   3	174	3	arrayOfByte	byte[]
    //   61	25	4	localFileOutputStream	java.io.FileOutputStream
    //   72	9	5	localObjectOutputStream	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   74	80	92	java/lang/Exception
    //   63	74	125	java/io/IOException
    //   74	80	125	java/io/IOException
    //   80	90	125	java/io/IOException
    //   93	122	125	java/io/IOException
    //   47	63	132	java/io/FileNotFoundException
    //   63	74	132	java/io/FileNotFoundException
    //   74	80	132	java/io/FileNotFoundException
    //   80	90	132	java/io/FileNotFoundException
    //   93	122	132	java/io/FileNotFoundException
    //   126	130	132	java/io/FileNotFoundException
    //   139	144	146	java/lang/Exception
  }
  
  private static String getFilePath(String paramString)
  {
    File localFile = QMApplicationContext.sharedInstance().getFilesDir();
    String str = "";
    if (localFile != null) {
      str = localFile.getAbsolutePath() + "/" + paramString;
    }
    return str;
  }
  
  /* Error */
  public static MailContent getMailContent(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 61	java/lang/String
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 136	java/lang/String:<init>	([B)V
    //   10: astore 4
    //   12: aload 4
    //   14: ifnull +82 -> 96
    //   17: aload 4
    //   19: ldc 11
    //   21: invokevirtual 140	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   24: ifeq +72 -> 96
    //   27: iconst_1
    //   28: istore_2
    //   29: iload_2
    //   30: ifeq +115 -> 145
    //   33: new 122	java/io/File
    //   36: dup
    //   37: aload_0
    //   38: invokestatic 75	com/tencent/qqmail/model/mail/QMMailDBUtils:getFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   41: invokespecial 141	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: invokevirtual 145	java/io/File:exists	()Z
    //   47: ifeq +147 -> 194
    //   50: new 147	java/io/FileInputStream
    //   53: dup
    //   54: aload_0
    //   55: invokestatic 75	com/tencent/qqmail/model/mail/QMMailDBUtils:getFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   58: invokespecial 148	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   61: astore_3
    //   62: new 150	java/io/ObjectInputStream
    //   65: dup
    //   66: aload_3
    //   67: invokespecial 153	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   70: astore 4
    //   72: aload 4
    //   74: invokevirtual 157	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   77: checkcast 159	com/tencent/qqmail/model/qmdomain/MailContent
    //   80: astore_0
    //   81: aload_0
    //   82: astore_1
    //   83: aload 4
    //   85: invokevirtual 160	java/io/ObjectInputStream:close	()V
    //   88: aload_0
    //   89: astore_1
    //   90: aload_3
    //   91: invokevirtual 161	java/io/FileInputStream:close	()V
    //   94: aload_0
    //   95: areturn
    //   96: iconst_0
    //   97: istore_2
    //   98: goto -69 -> 29
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 162	java/lang/ClassNotFoundException:printStackTrace	()V
    //   106: aconst_null
    //   107: astore_0
    //   108: goto -27 -> 81
    //   111: astore_3
    //   112: aconst_null
    //   113: astore_0
    //   114: aload_0
    //   115: astore_1
    //   116: aload_3
    //   117: invokevirtual 163	java/io/StreamCorruptedException:printStackTrace	()V
    //   120: goto -26 -> 94
    //   123: astore_3
    //   124: aload_1
    //   125: astore_0
    //   126: aload_3
    //   127: invokevirtual 100	java/io/FileNotFoundException:printStackTrace	()V
    //   130: goto -36 -> 94
    //   133: astore_3
    //   134: aconst_null
    //   135: astore_0
    //   136: aload_0
    //   137: astore_1
    //   138: aload_3
    //   139: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   142: goto -48 -> 94
    //   145: aload_3
    //   146: astore_0
    //   147: aload 4
    //   149: ifnull -55 -> 94
    //   152: aload_3
    //   153: astore_0
    //   154: aload_1
    //   155: ifnull -61 -> 94
    //   158: aload_1
    //   159: invokestatic 167	com/tencent/qqmail/model/qmdomain/ObjectSerializable:fromByte	([B)Ljava/lang/Object;
    //   162: checkcast 159	com/tencent/qqmail/model/qmdomain/MailContent
    //   165: astore_0
    //   166: aload_0
    //   167: areturn
    //   168: astore_0
    //   169: bipush 6
    //   171: ldc 8
    //   173: ldc 169
    //   175: invokestatic 59	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   178: aconst_null
    //   179: areturn
    //   180: astore_3
    //   181: aconst_null
    //   182: astore_0
    //   183: goto -57 -> 126
    //   186: astore_3
    //   187: goto -51 -> 136
    //   190: astore_3
    //   191: goto -77 -> 114
    //   194: aconst_null
    //   195: astore_0
    //   196: goto -102 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	paramString	String
    //   0	199	1	paramArrayOfByte	byte[]
    //   28	70	2	i	int
    //   1	90	3	localFileInputStream	java.io.FileInputStream
    //   111	6	3	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   123	4	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   133	20	3	localIOException1	java.io.IOException
    //   180	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   186	1	3	localIOException2	java.io.IOException
    //   190	1	3	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   10	138	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   72	81	101	java/lang/ClassNotFoundException
    //   62	72	111	java/io/StreamCorruptedException
    //   72	81	111	java/io/StreamCorruptedException
    //   102	106	111	java/io/StreamCorruptedException
    //   83	88	123	java/io/FileNotFoundException
    //   90	94	123	java/io/FileNotFoundException
    //   116	120	123	java/io/FileNotFoundException
    //   138	142	123	java/io/FileNotFoundException
    //   62	72	133	java/io/IOException
    //   72	81	133	java/io/IOException
    //   102	106	133	java/io/IOException
    //   158	166	168	java/lang/Exception
    //   50	62	180	java/io/FileNotFoundException
    //   62	72	180	java/io/FileNotFoundException
    //   72	81	180	java/io/FileNotFoundException
    //   102	106	180	java/io/FileNotFoundException
    //   83	88	186	java/io/IOException
    //   90	94	186	java/io/IOException
    //   83	88	190	java/io/StreamCorruptedException
    //   90	94	190	java/io/StreamCorruptedException
  }
  
  public static byte[] getVoteBytes(Mail paramMail)
  {
    Object localObject = paramMail.getVote();
    paramMail = new byte[1];
    try
    {
      localObject = ObjectSerializable.toByte(localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "QMMailDBUtilsmason", "getVoteBytes error : " + localException.getMessage());
    }
    return paramMail;
  }
  
  public static boolean isMailContOverThreshold(MailContent paramMailContent)
  {
    if (paramMailContent == null) {}
    do
    {
      return false;
      long l2 = 0L;
      long l1 = l2;
      if (paramMailContent.getFold() != null)
      {
        l1 = l2;
        if (paramMailContent.getFold().size() > 0)
        {
          l1 = 0L;
          int i = 0;
          while (i < paramMailContent.getFold().size())
          {
            l2 = l1;
            if (((MailFoldItem)paramMailContent.getFold().get(i)).getContent() != null) {
              l2 = l1 + ((MailFoldItem)paramMailContent.getFold().get(i)).getContent().length();
            }
            i += 1;
            l1 = l2;
          }
        }
      }
      if (l1 > 493158L) {
        return true;
      }
      if ((paramMailContent.getBody() != null) && (paramMailContent.getBody().length() > 493158L)) {
        return true;
      }
    } while ((paramMailContent.getBodyText() == null) || (paramMailContent.getBodyText().length() <= 30158L));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailDBUtils
 * JD-Core Version:    0.7.0.1
 */