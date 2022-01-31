package okhttp3.internal.http2;

import java.net.Socket;
import okio.i;

public class o
{
  Socket a;
  String b;
  i c;
  okio.h d;
  p e = p.f;
  ag f = ag.a;
  boolean g;
  int h;
  
  public o(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public h a()
  {
    return new h(this);
  }
  
  public o a(int paramInt)
  {
    this.h = paramInt;
    return this;
  }
  
  public o a(Socket paramSocket, String paramString, i parami, okio.h paramh)
  {
    this.a = paramSocket;
    this.b = paramString;
    this.c = parami;
    this.d = paramh;
    return this;
  }
  
  public o a(p paramp)
  {
    this.e = paramp;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.o
 * JD-Core Version:    0.7.0.1
 */