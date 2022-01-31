package okhttp3;

import okio.ByteString;

final class k
{
  final String a;
  final String b;
  final String c;
  final ByteString d;
  
  boolean a(String paramString)
  {
    boolean bool2 = false;
    if (this.a.startsWith("*."))
    {
      int i = paramString.indexOf('.');
      boolean bool1 = bool2;
      if (paramString.length() - i - 1 == this.b.length())
      {
        bool1 = bool2;
        if (paramString.regionMatches(false, i + 1, this.b, 0, this.b.length())) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return paramString.equals(this.b);
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof k)) && (this.a.equals(((k)paramObject).a)) && (this.c.equals(((k)paramObject).c)) && (this.d.equals(((k)paramObject).d));
  }
  
  public int hashCode()
  {
    return ((this.a.hashCode() + 527) * 31 + this.c.hashCode()) * 31 + this.d.hashCode();
  }
  
  public String toString()
  {
    return this.c + this.d.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.k
 * JD-Core Version:    0.7.0.1
 */