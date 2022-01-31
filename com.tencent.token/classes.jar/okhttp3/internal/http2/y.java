package okhttp3.internal.http2;

import java.util.List;
import okio.ByteString;
import okio.i;

abstract interface y
{
  public abstract void a();
  
  public abstract void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public abstract void a(int paramInt1, int paramInt2, List paramList);
  
  public abstract void a(int paramInt, long paramLong);
  
  public abstract void a(int paramInt, ErrorCode paramErrorCode);
  
  public abstract void a(int paramInt, ErrorCode paramErrorCode, ByteString paramByteString);
  
  public abstract void a(boolean paramBoolean, int paramInt1, int paramInt2);
  
  public abstract void a(boolean paramBoolean, int paramInt1, int paramInt2, List paramList);
  
  public abstract void a(boolean paramBoolean, int paramInt1, i parami, int paramInt2);
  
  public abstract void a(boolean paramBoolean, ai paramai);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.y
 * JD-Core Version:    0.7.0.1
 */