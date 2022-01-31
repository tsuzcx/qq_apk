package okhttp3;

import javax.annotation.Nullable;

public final class r
{
  boolean a;
  @Nullable
  String[] b;
  @Nullable
  String[] c;
  boolean d;
  
  public r(q paramq)
  {
    this.a = paramq.e;
    this.b = paramq.g;
    this.c = paramq.h;
    this.d = paramq.f;
  }
  
  r(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public q a()
  {
    return new q(this);
  }
  
  public r a(boolean paramBoolean)
  {
    if (!this.a) {
      throw new IllegalStateException("no TLS extensions for cleartext connections");
    }
    this.d = paramBoolean;
    return this;
  }
  
  public r a(String... paramVarArgs)
  {
    if (!this.a) {
      throw new IllegalStateException("no cipher suites for cleartext connections");
    }
    if (paramVarArgs.length == 0) {
      throw new IllegalArgumentException("At least one cipher suite is required");
    }
    this.b = ((String[])paramVarArgs.clone());
    return this;
  }
  
  public r a(TlsVersion... paramVarArgs)
  {
    if (!this.a) {
      throw new IllegalStateException("no TLS versions for cleartext connections");
    }
    String[] arrayOfString = new String[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfString[i] = paramVarArgs[i].javaName;
      i += 1;
    }
    return b(arrayOfString);
  }
  
  public r a(l... paramVarArgs)
  {
    if (!this.a) {
      throw new IllegalStateException("no cipher suites for cleartext connections");
    }
    String[] arrayOfString = new String[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfString[i] = paramVarArgs[i].bk;
      i += 1;
    }
    return a(arrayOfString);
  }
  
  public r b(String... paramVarArgs)
  {
    if (!this.a) {
      throw new IllegalStateException("no TLS versions for cleartext connections");
    }
    if (paramVarArgs.length == 0) {
      throw new IllegalArgumentException("At least one TLS version is required");
    }
    this.c = ((String[])paramVarArgs.clone());
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.r
 * JD-Core Version:    0.7.0.1
 */