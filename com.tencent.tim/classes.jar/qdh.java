import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class qdh
{
  public final String TAG = "Q.qqstory.share" + getClass().getSimpleName();
  public qdh.a a;
  public boolean aCQ = true;
  public boolean aCR = true;
  public ConcurrentHashMap<String, Object> cb;
  
  public boolean Jp()
  {
    return true;
  }
  
  public boolean Jq()
  {
    return true;
  }
  
  protected abstract void M(Map<String, Object> paramMap);
  
  public final qdh a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.aCQ = paramBoolean1;
    this.aCR = paramBoolean2;
    return this;
  }
  
  public abstract void bnE();
  
  public <T> T k(String paramString)
  {
    if ((this.cb != null) && (!TextUtils.isEmpty(paramString)))
    {
      Object localObject = this.cb.get(paramString);
      ram.a(this.TAG, "getResult key %s, result %s, stack = %s", String.valueOf(paramString), String.valueOf(localObject), rov.getStackTrace(7));
      return localObject;
    }
    ram.b(this.TAG, "getResult key %s, result null, stack = %s", String.valueOf(paramString), rov.getStackTrace(7));
    return null;
  }
  
  public void p(String paramString, Object paramObject)
  {
    ram.a(this.TAG, "putResult key %s, value %s, stack = %s", String.valueOf(paramString), String.valueOf(paramObject), rov.getStackTrace(7));
    if ((this.cb != null) && (!TextUtils.isEmpty(paramString))) {
      this.cb.put(paramString, paramObject);
    }
  }
  
  protected final void sA(boolean paramBoolean)
  {
    ram.b(this.TAG, "onRunFinish %b, stack = %s", Boolean.valueOf(paramBoolean), rov.getStackTrace(7));
    if (this.a != null) {
      this.a.sB(paramBoolean);
    }
  }
  
  public final void sz(boolean paramBoolean)
  {
    ram.b(this.TAG, "onJobFinish %b, stack = %s", Boolean.valueOf(paramBoolean), rov.getStackTrace(7));
    if (this.a != null) {
      this.a.sz(paramBoolean);
    }
  }
  
  public static abstract interface a
  {
    public abstract void sB(boolean paramBoolean);
    
    public abstract void sz(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qdh
 * JD-Core Version:    0.7.0.1
 */