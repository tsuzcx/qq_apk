package okhttp3.internal.http2;

import com.tencent.token.fc;
import okio.ByteString;

public final class a
{
  public static final ByteString a = ByteString.a(":");
  public static final ByteString b = ByteString.a(":status");
  public static final ByteString c = ByteString.a(":method");
  public static final ByteString d = ByteString.a(":path");
  public static final ByteString e = ByteString.a(":scheme");
  public static final ByteString f = ByteString.a(":authority");
  public final ByteString g;
  public final ByteString h;
  final int i;
  
  public a(String paramString1, String paramString2)
  {
    this(ByteString.a(paramString1), ByteString.a(paramString2));
  }
  
  public a(ByteString paramByteString, String paramString)
  {
    this(paramByteString, ByteString.a(paramString));
  }
  
  public a(ByteString paramByteString1, ByteString paramByteString2)
  {
    this.g = paramByteString1;
    this.h = paramByteString2;
    this.i = (paramByteString1.g() + 32 + paramByteString2.g());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof a;
    boolean bool2 = false;
    if (bool1)
    {
      paramObject = (a)paramObject;
      bool1 = bool2;
      if (this.g.equals(paramObject.g))
      {
        bool1 = bool2;
        if (this.h.equals(paramObject.h)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return false;
  }
  
  public int hashCode()
  {
    return (527 + this.g.hashCode()) * 31 + this.h.hashCode();
  }
  
  public String toString()
  {
    return fc.a("%s: %s", new Object[] { this.g.a(), this.h.a() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.a
 * JD-Core Version:    0.7.0.1
 */