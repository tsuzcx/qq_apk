package okhttp3.internal.http2;

import java.util.List;
import okio.e;

public abstract interface j
{
  public static final j a = new j()
  {
    public void a(int paramAnonymousInt, ErrorCode paramAnonymousErrorCode) {}
    
    public boolean a(int paramAnonymousInt, List<a> paramAnonymousList)
    {
      return true;
    }
    
    public boolean a(int paramAnonymousInt, List<a> paramAnonymousList, boolean paramAnonymousBoolean)
    {
      return true;
    }
    
    public boolean a(int paramAnonymousInt1, e paramAnonymouse, int paramAnonymousInt2, boolean paramAnonymousBoolean)
    {
      paramAnonymouse.h(paramAnonymousInt2);
      return true;
    }
  };
  
  public abstract void a(int paramInt, ErrorCode paramErrorCode);
  
  public abstract boolean a(int paramInt, List<a> paramList);
  
  public abstract boolean a(int paramInt, List<a> paramList, boolean paramBoolean);
  
  public abstract boolean a(int paramInt1, e parame, int paramInt2, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.j
 * JD-Core Version:    0.7.0.1
 */