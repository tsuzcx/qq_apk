package com.tencent.moai.mailsdk.protocol.mime.model;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.mime.DataListener;
import com.tencent.moai.mailsdk.protocol.mime.MimeDefine;
import com.tencent.moai.mailsdk.protocol.model.Header;
import com.tencent.moai.mailsdk.protocol.model.Pair;
import com.tencent.moai.mailsdk.util.StringUtility;
import com.tencent.moai.mailsdk.util.stream.LineInputStream;
import com.tencent.moai.mailsdk.util.stream.LineOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Vector;

public class MimeHeader
  extends Header
{
  private static final String TAG = "MimeHeader";
  protected Vector<MimePair> vector = new Vector();
  
  public void addHeader(String paramString1, String paramString2)
  {
    this.vector.add(new MimePair(paramString1, paramString2));
  }
  
  public int getCount()
  {
    return this.vector.size();
  }
  
  public Pair getHeader(int paramInt)
  {
    return (Pair)this.vector.get(paramInt);
  }
  
  public String getHeader(String paramString)
  {
    Iterator localIterator = this.vector.iterator();
    while (localIterator.hasNext())
    {
      MimePair localMimePair = (MimePair)localIterator.next();
      if ((localMimePair.getName() != null) && (localMimePair.getName().equalsIgnoreCase(paramString))) {
        return localMimePair.getValue();
      }
    }
    return null;
  }
  
  public long getSize()
  {
    Iterator localIterator = this.vector.iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((MimePair)localIterator.next()).write().length() + MimeDefine.CRLF.getBytes().length + l) {}
    return MimeDefine.CRLF.getBytes().length + l;
  }
  
  public String read(InputStream paramInputStream, DataListener paramDataListener)
    throws MessageException
  {
    LineInputStream localLineInputStream;
    if ((paramInputStream instanceof LineInputStream)) {
      localLineInputStream = (LineInputStream)paramInputStream;
    }
    for (;;)
    {
      try
      {
        localObject1 = localLineInputStream.readLine();
        paramInputStream = (InputStream)localObject1;
        if (localObject1 != null)
        {
          paramInputStream = (InputStream)localObject1;
          if (paramDataListener != null)
          {
            paramDataListener.onDataChange(((String)localObject1).length());
            paramInputStream = (InputStream)localObject1;
          }
        }
        if ((paramInputStream == null) || (!paramInputStream.equalsIgnoreCase(""))) {
          break;
        }
        localObject1 = localLineInputStream.readLine();
        paramInputStream = (InputStream)localObject1;
        if (localObject1 != null)
        {
          paramInputStream = (InputStream)localObject1;
          if (paramDataListener != null)
          {
            paramDataListener.onDataChange(((String)localObject1).length());
            paramInputStream = (InputStream)localObject1;
            continue;
            localLineInputStream = new LineInputStream(paramInputStream);
          }
        }
      }
      catch (IOException paramInputStream)
      {
        throw new MessageException(3, "header read io", paramInputStream);
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 1;
    Object localObject1 = null;
    if (paramInputStream != null)
    {
      Object localObject2;
      if ((paramInputStream.startsWith(" ")) || (paramInputStream.startsWith("\t")))
      {
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localStringBuilder.append((String)localObject1);
          localObject2 = null;
        }
        if (i != 0)
        {
          localObject1 = paramInputStream.trim();
          paramInputStream = (InputStream)localObject2;
          if (((String)localObject1).length() > 0)
          {
            localStringBuilder.append((String)localObject1);
            paramInputStream = (InputStream)localObject2;
          }
        }
      }
      for (;;)
      {
        localObject2 = localLineInputStream.readLine();
        if ((localObject2 != null) && (paramDataListener != null))
        {
          paramDataListener.onDataChange(((String)localObject2).length());
          i = 0;
          localObject1 = paramInputStream;
          paramInputStream = (InputStream)localObject2;
          break;
          if (localStringBuilder.length() > 0) {
            localStringBuilder.append(MimeDefine.CRLF);
          }
          localStringBuilder.append(paramInputStream);
          paramInputStream = (InputStream)localObject2;
          continue;
          if (localObject1 != null)
          {
            localObject1 = new MimePair((String)localObject1);
            ((MimePair)localObject1).read();
            this.vector.add(localObject1);
          }
        }
        for (;;)
        {
          if (StringUtility.isTrimEmpty(paramInputStream))
          {
            return paramInputStream;
            if (localStringBuilder.length() > 0)
            {
              localObject1 = new MimePair(localStringBuilder.toString());
              ((MimePair)localObject1).read();
              this.vector.add(localObject1);
              localStringBuilder.setLength(0);
              continue;
              i = 0;
              localObject1 = paramInputStream;
              paramInputStream = (InputStream)localObject2;
              break;
            }
          }
        }
      }
    }
    return paramInputStream;
  }
  
  public String removeHeader(String paramString)
  {
    Iterator localIterator = this.vector.iterator();
    while (localIterator.hasNext())
    {
      MimePair localMimePair = (MimePair)localIterator.next();
      if (localMimePair.getName().equalsIgnoreCase(paramString))
      {
        localIterator.remove();
        return localMimePair.getValue();
      }
    }
    return null;
  }
  
  public void write(OutputStream paramOutputStream, DataListener paramDataListener)
    throws MessageException
  {
    if ((paramOutputStream instanceof LineOutputStream)) {
      paramOutputStream = (LineOutputStream)paramOutputStream;
    }
    for (;;)
    {
      try
      {
        Iterator localIterator = this.vector.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        String str = ((MimePair)localIterator.next()).write();
        paramOutputStream.writeln(str);
        if ((str != null) && (paramDataListener != null))
        {
          paramDataListener.onDataChange(str.length() + MimeDefine.CRLF.length());
          continue;
          paramOutputStream = new LineOutputStream(paramOutputStream);
        }
      }
      catch (IOException paramOutputStream)
      {
        throw new MessageException(3, "header write io", paramOutputStream);
      }
    }
    paramOutputStream.writeln();
    if (paramDataListener != null) {
      paramDataListener.onDataChange(MimeDefine.CRLF.length());
    }
    paramOutputStream.flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.mime.model.MimeHeader
 * JD-Core Version:    0.7.0.1
 */