package okhttp3.internal.http2;

import com.tencent.token.gm;

final class r
  extends gm
{
  final boolean a;
  final int c;
  final int d;
  
  r(h paramh, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super("OkHttp %s ping %08x%08x", new Object[] { paramh.d, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.a = paramBoolean;
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public void c()
  {
    this.e.a(this.a, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.r
 * JD-Core Version:    0.7.0.1
 */