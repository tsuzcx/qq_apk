package com.tencent.moai.mailsdk.protocol.mime.model;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.datasource.DataSource;
import com.tencent.moai.mailsdk.protocol.datasource.FileDataSource;
import com.tencent.moai.mailsdk.protocol.datasource.TextDataSource;
import com.tencent.moai.mailsdk.protocol.mime.DataListener;
import com.tencent.moai.mailsdk.protocol.mime.MimeDefine;
import com.tencent.moai.mailsdk.protocol.model.BodyPart;
import com.tencent.moai.mailsdk.util.FileUtility;
import com.tencent.moai.mailsdk.util.MimeUtility;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

public class MimeBodyPart
  extends BodyPart
  implements MimePart
{
  private static final String TAG = "MimeBodyPart";
  protected String boundary;
  protected String boundaryEnd;
  protected DataSource dataSource;
  protected MimeHeader header;
  
  public MimeBodyPart(DataSource paramDataSource)
  {
    this.header = new MimeHeader();
    this.dataSource = paramDataSource;
  }
  
  public MimeBodyPart(MimeHeader paramMimeHeader)
    throws MessageException
  {
    this.header = paramMimeHeader;
    paramMimeHeader = MimeUtility.getFileName(this);
    Object localObject = MimeUtility.getContentType(this);
    if (paramMimeHeader != null)
    {
      localObject = new FileDataSource();
      ((FileDataSource)localObject).setFile(new File(FileUtility.getDownloadBasePath() + paramMimeHeader));
      ((FileDataSource)localObject).setTempFile(new File(FileUtility.generateTmpFilePath(paramMimeHeader)));
      paramMimeHeader = MimeUtility.getContentDisposition(this);
      if ((paramMimeHeader == null) || (paramMimeHeader.equalsIgnoreCase(MimeDefine.DISPOSITION_ATTACHMENT))) {
        ((FileDataSource)localObject).setType(0);
      }
      for (;;)
      {
        this.dataSource = ((DataSource)localObject);
        return;
        if (paramMimeHeader.equalsIgnoreCase(MimeDefine.DISPOSITION_INLINE)) {
          ((FileDataSource)localObject).setType(1);
        }
      }
    }
    if (MimeUtility.isTextDataPart((String)localObject))
    {
      paramMimeHeader = new TextDataSource("");
      if ((localObject == null) || (((String)localObject).equalsIgnoreCase(MimeDefine.TEXT_PLAIN))) {
        paramMimeHeader.setType(0);
      }
      for (;;)
      {
        this.dataSource = paramMimeHeader;
        return;
        if (((String)localObject).equalsIgnoreCase(MimeDefine.TEXT_HTML)) {
          paramMimeHeader.setType(1);
        } else if (((String)localObject).equals(MimeDefine.TEXT_CALENDAR)) {
          paramMimeHeader.setType(2);
        }
      }
    }
    localObject = FileUtility.generateRandomFileName((String)localObject);
    paramMimeHeader = new FileDataSource();
    paramMimeHeader.setFile(new File(FileUtility.getDownloadBasePath() + (String)localObject));
    paramMimeHeader.setTempFile(new File(FileUtility.generateTmpFilePath((String)localObject)));
    localObject = MimeUtility.getContentDisposition(this);
    if ((localObject == null) || (((String)localObject).equalsIgnoreCase(MimeDefine.DISPOSITION_ATTACHMENT))) {
      paramMimeHeader.setType(0);
    }
    for (;;)
    {
      this.dataSource = paramMimeHeader;
      return;
      if (((String)localObject).equalsIgnoreCase(MimeDefine.DISPOSITION_INLINE)) {
        paramMimeHeader.setType(1);
      }
    }
  }
  
  public void addHeader(String paramString1, String paramString2)
  {
    this.header.addHeader(paramString1, paramString2);
  }
  
  public String getContentDescription()
  {
    try
    {
      String str = MimeUtility.decodeText(MimeUtility.unfold(getHeader(MimeDefine.CONTENT_DESCRIPTION)));
      return str;
    }
    catch (Exception localException) {}
    return getHeader(MimeDefine.CONTENT_DESCRIPTION);
  }
  
  public String getContentEncoding()
  {
    return getHeader(MimeDefine.CONTENT_ENCODING);
  }
  
  public String getContentID()
  {
    return getHeader(MimeDefine.CONTENT_ID);
  }
  
  public String getContentLanguage()
  {
    return getHeader(MimeDefine.CONTENT_LANGUAGE);
  }
  
  public String getContentMD5()
  {
    return getHeader(MimeDefine.CONTENT_MD5);
  }
  
  public String getContentType()
  {
    return getHeader(MimeDefine.CONTENT_TYPE);
  }
  
  public DataSource getDataSource()
  {
    return this.dataSource;
  }
  
  public String getDisposition()
  {
    return getHeader(MimeDefine.CONTENT_DISPOSITION);
  }
  
  public MimeHeader getHeader()
  {
    return this.header;
  }
  
  public String getHeader(String paramString)
  {
    return this.header.getHeader(paramString);
  }
  
  public long getSize()
  {
    long l = 0L;
    if (this.dataSource != null) {
      l = this.dataSource.getSize();
    }
    return l;
  }
  
  public String read(InputStream paramInputStream, DataListener paramDataListener)
    throws MessageException
  {
    return this.dataSource.read(paramInputStream, paramDataListener, MimeUtility.getCharset(getContentType()), getContentEncoding());
  }
  
  public String removeHeader(String paramString)
  {
    return this.header.removeHeader(paramString);
  }
  
  public void setBoundary(String paramString1, String paramString2)
  {
    this.boundary = paramString1;
    this.boundaryEnd = paramString2;
    this.dataSource.setBoundary(paramString1);
    this.dataSource.setBoundaryEnd(paramString2);
  }
  
  public void setContentDescription(String paramString)
  {
    if (paramString == null)
    {
      removeHeader(MimeDefine.CONTENT_DESCRIPTION);
      return;
    }
    try
    {
      String str = MimeUtility.fold(21, MimeUtility.encodeText(paramString));
      paramString = str;
    }
    catch (Exception localException)
    {
      label25:
      break label25;
    }
    addHeader(MimeDefine.CONTENT_DESCRIPTION, paramString);
  }
  
  public void setContentEncoding(String paramString)
  {
    if (paramString == null)
    {
      removeHeader(MimeDefine.CONTENT_ENCODING);
      return;
    }
    addHeader(MimeDefine.CONTENT_ENCODING, paramString);
  }
  
  public void setContentID(String paramString)
  {
    if (paramString == null)
    {
      removeHeader(MimeDefine.CONTENT_ID);
      return;
    }
    addHeader(MimeDefine.CONTENT_ID, paramString);
  }
  
  public void setContentLanguage(String paramString)
  {
    if (paramString == null)
    {
      removeHeader(MimeDefine.CONTENT_LANGUAGE);
      return;
    }
    addHeader(MimeDefine.CONTENT_LANGUAGE, paramString);
  }
  
  public void setContentMD5(String paramString)
  {
    if (paramString == null)
    {
      removeHeader(MimeDefine.CONTENT_MD5);
      return;
    }
    addHeader(MimeDefine.CONTENT_MD5, paramString);
  }
  
  public void setContentType(String paramString)
  {
    if (paramString == null)
    {
      removeHeader(MimeDefine.CONTENT_TYPE);
      return;
    }
    addHeader(MimeDefine.CONTENT_TYPE, paramString);
  }
  
  public void setDataSource(DataSource paramDataSource)
  {
    this.dataSource = paramDataSource;
  }
  
  public void setDisposition(String paramString)
  {
    if (paramString == null)
    {
      removeHeader(MimeDefine.CONTENT_DISPOSITION);
      return;
    }
    addHeader(MimeDefine.CONTENT_DISPOSITION, paramString);
  }
  
  public void write(OutputStream paramOutputStream, DataListener paramDataListener)
    throws MessageException
  {
    this.dataSource.write(paramOutputStream, paramDataListener, MimeUtility.getCharset(getContentType()), getContentEncoding());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.mime.model.MimeBodyPart
 * JD-Core Version:    0.7.0.1
 */