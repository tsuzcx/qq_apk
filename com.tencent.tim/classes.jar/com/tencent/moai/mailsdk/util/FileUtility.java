package com.tencent.moai.mailsdk.util;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import com.tencent.moai.mailsdk.MailManager;
import com.tencent.moai.mailsdk.callback.AttachmentCallBack;
import com.tencent.moai.mailsdk.protocol.datasource.DataConfig;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPBodyStructure;
import com.tencent.moai.mailsdk.protocol.mime.MimeDefine;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class FileUtility
{
  private static final String TAG = "FileUtility";
  
  public static boolean createFile(String paramString)
    throws IOException
  {
    paramString = new File(paramString);
    return (!paramString.exists()) && (paramString.createNewFile());
  }
  
  public static boolean deleteFile(String paramString)
    throws IOException
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      return paramString.delete();
    }
    return false;
  }
  
  public static String generateExchangeTmpFilePath(String paramString)
  {
    return getTmpFileDir() + hashLong(paramString) + "_" + System.currentTimeMillis() + ".tmp";
  }
  
  public static String generateExchangeXmlFilePath(String paramString)
  {
    return getTmpFileDir() + hashLong(paramString) + "_" + System.currentTimeMillis() + ".xml";
  }
  
  public static String generateImapAppendFilePath(String paramString)
  {
    return getTmpFileDir() + "imap_" + hashLong(paramString) + "_" + System.currentTimeMillis() + ".append";
  }
  
  public static String generateRandomFileName(String paramString)
  {
    String str2 = "message" + System.currentTimeMillis();
    String str1 = str2;
    if (paramString.equalsIgnoreCase(MimeDefine.MESSAGE_RFC)) {
      str1 = str2 + ".eml";
    }
    return str1;
  }
  
  public static String generateSeqAttachName(int paramInt, IMAPBodyStructure paramIMAPBodyStructure)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("message_").append(paramInt);
    if (paramIMAPBodyStructure.isMessageRfc()) {}
    for (paramIMAPBodyStructure = ".eml";; paramIMAPBodyStructure = "") {
      return paramIMAPBodyStructure;
    }
  }
  
  public static String generateTmpFilePath(String paramString)
  {
    return getTmpFileDir() + hashLong(paramString) + "_" + System.currentTimeMillis() + ".tmp";
  }
  
  public static String generateTmpFilePath(String paramString1, String paramString2)
  {
    return getTmpFileDir() + paramString1 + "_" + paramString2 + ".tmp";
  }
  
  public static String getActiveSyncDirPath()
  {
    if (MailManager.getContext() != null) {}
    for (String str1 = MailManager.getContext().getCacheDir().getAbsolutePath() + "/activesync/";; str1 = "")
    {
      String str2 = str1;
      if (!mkdirs(str1)) {
        str2 = "";
      }
      return str2;
    }
  }
  
  public static String getDownloadBasePath()
  {
    if (MailManager.getContext() != null) {
      return MailManager.getContext().getCacheDir().getAbsolutePath() + File.separator;
    }
    return "";
  }
  
  public static String getExchangeDirPath()
  {
    if (MailManager.getContext() != null) {}
    for (String str1 = MailManager.getContext().getCacheDir().getAbsolutePath() + "/exchange/";; str1 = "")
    {
      String str2 = str1;
      if (!mkdirs(str1)) {
        str2 = "";
      }
      return str2;
    }
  }
  
  public static InputStream getFileInputStream(File paramFile)
    throws FileNotFoundException
  {
    Object localObject = null;
    Uri localUri = DocumentFile.fromFile(paramFile).getUri();
    paramFile = localObject;
    if (localUri != null) {
      paramFile = MailManager.getContext().getContentResolver().openInputStream(localUri);
    }
    return paramFile;
  }
  
  public static OutputStream getFileOutputStream(File paramFile)
    throws FileNotFoundException
  {
    Object localObject = null;
    Uri localUri = DocumentFile.fromFile(paramFile).getUri();
    paramFile = localObject;
    if (localUri != null) {
      paramFile = MailManager.getContext().getContentResolver().openOutputStream(localUri, "w");
    }
    return paramFile;
  }
  
  public static String getPopDirPath()
  {
    if (MailManager.getContext() != null) {}
    for (String str1 = MailManager.getContext().getCacheDir().getAbsolutePath() + "/pop/";; str1 = "")
    {
      String str2 = str1;
      if (!mkdirs(str1)) {
        str2 = "";
      }
      return str2;
    }
  }
  
  public static String getTmpFileDir()
  {
    String str2 = DataConfig.TMP_FILE_DIR;
    String str1 = str2;
    if (!mkdirs(str2)) {
      str1 = "";
    }
    return str1;
  }
  
  private static int hashInt(String paramString)
  {
    int i = 0;
    int j = 0;
    while (i < paramString.length())
    {
      j = j * 131 + paramString.charAt(i);
      i += 1;
    }
    return j;
  }
  
  private static long hashLong(String paramString)
  {
    long l = 0L;
    int i = 0;
    while (i < paramString.length())
    {
      l = l * 131L + paramString.charAt(i);
      i += 1;
    }
    return l;
  }
  
  public static boolean isFileExist(String paramString)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public static boolean mkdirs(String paramString)
  {
    File localFile = new File(paramString);
    if ((!localFile.exists()) && (!localFile.mkdirs()))
    {
      Logger.log(6, "FileUtility", "mkdirs fail:" + paramString);
      return false;
    }
    return true;
  }
  
  public static byte[] readStream(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i <= 0) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    localByteArrayOutputStream.flush();
    arrayOfByte = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    paramInputStream.close();
    return arrayOfByte;
  }
  
  public static void writeFile(String paramString, ArrayList<Long> paramArrayList, InputStream paramInputStream, AttachmentCallBack paramAttachmentCallBack)
    throws IOException
  {
    paramString = getFileOutputStream(new File(paramString));
    byte[] arrayOfByte = new byte[1024];
    long l1 = 0L;
    for (;;)
    {
      int j = paramInputStream.read(arrayOfByte);
      if (j <= 0) {
        break;
      }
      paramString.write(arrayOfByte, 0, j);
      int i = 0;
      while (i < j)
      {
        if (arrayOfByte[i] == 0) {
          paramArrayList.add(Long.valueOf(i + l1));
        }
        i += 1;
      }
      long l2 = l1 + j;
      l1 = l2;
      if (paramAttachmentCallBack != null)
      {
        paramAttachmentCallBack.onProgress(l2);
        l1 = l2;
      }
    }
    paramString.flush();
    paramString.close();
    paramInputStream.close();
  }
  
  public static void writeStream(OutputStream paramOutputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    paramOutputStream.write(paramArrayOfByte);
    paramOutputStream.flush();
    paramOutputStream.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.FileUtility
 * JD-Core Version:    0.7.0.1
 */