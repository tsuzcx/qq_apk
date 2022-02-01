package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestCalculatingInputStream
  extends ObservableInputStream
{
  private final MessageDigest messageDigest;
  
  public MessageDigestCalculatingInputStream(InputStream paramInputStream)
    throws NoSuchAlgorithmException
  {
    this(paramInputStream, MessageDigest.getInstance("MD5"));
  }
  
  public MessageDigestCalculatingInputStream(InputStream paramInputStream, String paramString)
    throws NoSuchAlgorithmException
  {
    this(paramInputStream, MessageDigest.getInstance(paramString));
  }
  
  public MessageDigestCalculatingInputStream(InputStream paramInputStream, MessageDigest paramMessageDigest)
  {
    super(paramInputStream);
    this.messageDigest = paramMessageDigest;
    add(new MessageDigestMaintainingObserver(paramMessageDigest));
  }
  
  public MessageDigest getMessageDigest()
  {
    return this.messageDigest;
  }
  
  public static class MessageDigestMaintainingObserver
    extends ObservableInputStream.Observer
  {
    private final MessageDigest md;
    
    public MessageDigestMaintainingObserver(MessageDigest paramMessageDigest)
    {
      this.md = paramMessageDigest;
    }
    
    void data(int paramInt)
      throws IOException
    {
      this.md.update((byte)paramInt);
    }
    
    void data(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      this.md.update(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.input.MessageDigestCalculatingInputStream
 * JD-Core Version:    0.7.0.1
 */