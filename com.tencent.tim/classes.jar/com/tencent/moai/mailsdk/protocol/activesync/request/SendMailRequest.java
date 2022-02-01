package com.tencent.moai.mailsdk.protocol.activesync.request;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.activesync.model.ActiveSyncInfo;
import com.tencent.moai.mailsdk.protocol.mime.model.MimeMessage;
import com.tencent.moai.mailsdk.util.FileUtility;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Stack;

public class SendMailRequest
  extends ActiveSyncRequest
{
  private String clientId;
  private MimeMessage mimeMessage;
  private String tmpFilePath;
  
  public SendMailRequest(ActiveSyncInfo paramActiveSyncInfo)
  {
    super(paramActiveSyncInfo, "SendMail", "");
  }
  
  private void encodeMultiByteInteger(int paramInt, OutputStream paramOutputStream)
    throws IOException
  {
    Stack localStack = new Stack();
    while (paramInt > 0)
    {
      int j = (byte)(paramInt & 0x7F);
      int i = j;
      if (!localStack.isEmpty()) {
        i = (byte)(j | 0x80);
      }
      localStack.add(Byte.valueOf(i));
      paramInt >>>= 7;
    }
    while (!localStack.isEmpty()) {
      paramOutputStream.write(((Byte)localStack.pop()).byteValue());
    }
  }
  
  private int indexOf(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int j = 0;
    int i = -1;
    if (j < paramArrayOfByte1.length - paramArrayOfByte2.length)
    {
      i = 0;
      label17:
      if (i >= paramArrayOfByte2.length) {
        break label60;
      }
      if (paramArrayOfByte1[(j + i)] == paramArrayOfByte2[i]) {
        break label44;
      }
    }
    label44:
    label60:
    for (i = -1;; i = j)
    {
      if (i != -1)
      {
        return i;
        i += 1;
        break label17;
      }
      j += 1;
      break;
    }
  }
  
  public File buildCmdDataFile()
    throws MessageException
  {
    File localFile2 = new File(this.tmpFilePath);
    localFile1 = new File(this.tmpFilePath + ".mime");
    try
    {
      localObject1 = new BufferedOutputStream(new FileOutputStream(localFile1, false));
      this.mimeMessage.write((OutputStream)localObject1, null);
      ((BufferedOutputStream)localObject1).flush();
      ((BufferedOutputStream)localObject1).close();
      localObject1 = FileUtility.getFileInputStream(localFile1);
      k = ((InputStream)localObject1).available();
      localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(localFile2, false));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
      ((StringBuilder)localObject2).append("<SendMail xmlns=\"ComposeMail\">");
      ((StringBuilder)localObject2).append("<ClientId>" + this.clientId + "</ClientId>");
      ((StringBuilder)localObject2).append("<SaveInSentItems/>");
      ((StringBuilder)localObject2).append("<Mime><![CDATA[");
      ((StringBuilder)localObject2).append("MIME");
      ((StringBuilder)localObject2).append("]]></Mime>");
      ((StringBuilder)localObject2).append("</SendMail>");
      arrayOfByte1 = XmlDocumentHelper.xml2Bytes(((StringBuilder)localObject2).toString());
      j = indexOf(arrayOfByte1, new byte[] { 77, 73, 77, 69 });
      i = indexOf(arrayOfByte1, new byte[] { -61 });
      if (i == -1) {
        break label427;
      }
      i += 1;
    }
    catch (IOException localIOException3)
    {
      int k;
      byte[] arrayOfByte1;
      byte[] arrayOfByte2;
      throw new MessageException(7, localIOException3.getMessage());
    }
    finally
    {
      try
      {
        Object localObject1;
        BufferedOutputStream localBufferedOutputStream;
        Object localObject2;
        for (;;)
        {
          int j;
          FileUtility.deleteFile(localFile1.getAbsolutePath());
          throw localFile3;
          int i = j;
        }
        if (!"12.1".equals(getActiveSyncInfo().getActiveSyncVersion())) {
          localBufferedOutputStream.write((byte[])localObject2);
        }
        localBufferedOutputStream.flush();
        localBufferedOutputStream.close();
        ((InputStream)localObject1).close();
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          try
          {
            FileUtility.deleteFile(localFile1.getAbsolutePath());
            return localFile3;
          }
          catch (IOException localIOException2) {}
          localIOException1 = localIOException1;
        }
      }
      return localFile3;
    }
    arrayOfByte2 = new byte[i];
    localObject2 = new byte[arrayOfByte1.length - j - 4];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
    System.arraycopy(arrayOfByte1, j + 4, localObject2, 0, arrayOfByte1.length - j - 4);
    if (!"12.1".equals(getActiveSyncInfo().getActiveSyncVersion())) {
      localBufferedOutputStream.write(arrayOfByte2);
    }
    if (!"12.1".equals(getActiveSyncInfo().getActiveSyncVersion())) {
      encodeMultiByteInteger(k, localBufferedOutputStream);
    }
    arrayOfByte1 = new byte[8192];
    for (;;)
    {
      i = ((InputStream)localObject1).read(arrayOfByte1);
      if (i <= 0) {
        break;
      }
      localBufferedOutputStream.write(arrayOfByte1, 0, i);
    }
  }
  
  public String getClientId()
  {
    return this.clientId;
  }
  
  public MimeMessage getMimeMessage()
  {
    return this.mimeMessage;
  }
  
  public String getTmpFilePath()
  {
    return this.tmpFilePath;
  }
  
  public void setClientId(String paramString)
  {
    this.clientId = paramString;
  }
  
  public void setMimeMessage(MimeMessage paramMimeMessage)
  {
    this.mimeMessage = paramMimeMessage;
  }
  
  public void setTmpFilePath(String paramString)
  {
    this.tmpFilePath = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.request.SendMailRequest
 * JD-Core Version:    0.7.0.1
 */