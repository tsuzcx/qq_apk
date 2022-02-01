package okio;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class HashingSource
  extends ForwardingSource
{
  private final Mac mac;
  private final MessageDigest messageDigest;
  
  private HashingSource(Source paramSource, String paramString)
  {
    super(paramSource);
    try
    {
      this.messageDigest = MessageDigest.getInstance(paramString);
      this.mac = null;
      return;
    }
    catch (NoSuchAlgorithmException paramSource)
    {
      throw new AssertionError();
    }
  }
  
  private HashingSource(Source paramSource, ByteString paramByteString, String paramString)
  {
    super(paramSource);
    try
    {
      this.mac = Mac.getInstance(paramString);
      this.mac.init(new SecretKeySpec(paramByteString.toByteArray(), paramString));
      this.messageDigest = null;
      return;
    }
    catch (NoSuchAlgorithmException paramSource)
    {
      throw new AssertionError();
    }
    catch (InvalidKeyException paramSource)
    {
      throw new IllegalArgumentException(paramSource);
    }
  }
  
  public static HashingSource hmacSha1(Source paramSource, ByteString paramByteString)
  {
    return new HashingSource(paramSource, paramByteString, "HmacSHA1");
  }
  
  public static HashingSource hmacSha256(Source paramSource, ByteString paramByteString)
  {
    return new HashingSource(paramSource, paramByteString, "HmacSHA256");
  }
  
  public static HashingSource md5(Source paramSource)
  {
    return new HashingSource(paramSource, "MD5");
  }
  
  public static HashingSource sha1(Source paramSource)
  {
    return new HashingSource(paramSource, "SHA-1");
  }
  
  public static HashingSource sha256(Source paramSource)
  {
    return new HashingSource(paramSource, "SHA-256");
  }
  
  public final ByteString hash()
  {
    if (this.messageDigest != null) {}
    for (byte[] arrayOfByte = this.messageDigest.digest();; arrayOfByte = this.mac.doFinal()) {
      return ByteString.of(arrayOfByte);
    }
  }
  
  public long read(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    long l4 = super.read(paramBuffer, paramLong);
    if (l4 != -1L)
    {
      long l3 = paramBuffer.size - l4;
      paramLong = paramBuffer.size;
      Segment localSegment1 = paramBuffer.head;
      Segment localSegment2;
      long l1;
      long l2;
      for (;;)
      {
        localSegment2 = localSegment1;
        l1 = paramLong;
        l2 = l3;
        if (paramLong <= l3) {
          break;
        }
        localSegment1 = localSegment1.prev;
        paramLong -= localSegment1.limit - localSegment1.pos;
      }
      if (l1 < paramBuffer.size)
      {
        int i = (int)(l2 + localSegment2.pos - l1);
        if (this.messageDigest != null) {
          this.messageDigest.update(localSegment2.data, i, localSegment2.limit - i);
        }
        for (;;)
        {
          l1 += localSegment2.limit - localSegment2.pos;
          localSegment2 = localSegment2.next;
          l2 = l1;
          break;
          this.mac.update(localSegment2.data, i, localSegment2.limit - i);
        }
      }
    }
    return l4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okio.HashingSource
 * JD-Core Version:    0.7.0.1
 */