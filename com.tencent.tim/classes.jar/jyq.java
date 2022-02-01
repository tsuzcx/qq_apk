public class jyq
{
  public String Va;
  public String Vb;
  public String Vc;
  public String Vd;
  public String Ve;
  public String appId;
  public String ex1;
  public String ex2;
  public long pageId;
  public long rc;
  public long rd;
  
  private jyq(jyq.a parama)
  {
    this.pageId = jyq.a.a(parama);
    this.rc = jyq.a.b(parama);
    this.rd = jyq.a.c(parama);
    this.Va = jyq.a.a(parama);
    this.Vb = jyq.a.b(parama);
    this.Vc = jyq.a.c(parama);
    this.appId = jyq.a.d(parama);
    this.ex1 = jyq.a.e(parama);
    this.ex2 = jyq.a.f(parama);
    this.Vd = jyq.a.g(parama);
    this.Ve = jyq.a.h(parama);
  }
  
  public static final class a
  {
    private String Va = "";
    private String Vb = "";
    private String Vc = "";
    private String Vd = "";
    private String Ve = "";
    private String appId = "";
    private String ex1 = "";
    private String ex2 = "";
    private long pageId;
    private long rc;
    private long rd;
    
    public a a(long paramLong)
    {
      this.pageId = paramLong;
      return this;
    }
    
    public a a(String paramString)
    {
      if (paramString != null) {
        this.Va = paramString;
      }
      return this;
    }
    
    public jyq a()
    {
      return new jyq(this, null);
    }
    
    public a b(long paramLong)
    {
      this.rc = paramLong;
      return this;
    }
    
    public a b(String paramString)
    {
      if (paramString != null) {
        this.Vb = paramString;
      }
      return this;
    }
    
    public a c(long paramLong)
    {
      this.rd = paramLong;
      return this;
    }
    
    public a c(String paramString)
    {
      if (paramString != null) {
        this.Vc = paramString;
      }
      return this;
    }
    
    public a d(String paramString)
    {
      if (paramString != null) {
        this.appId = paramString;
      }
      return this;
    }
    
    public a e(String paramString)
    {
      if (paramString != null) {
        this.ex1 = paramString;
      }
      return this;
    }
    
    public a f(String paramString)
    {
      if (paramString != null) {
        this.ex2 = paramString;
      }
      return this;
    }
    
    public a g(String paramString)
    {
      if (paramString != null) {
        this.Vd = paramString;
      }
      return this;
    }
    
    public a h(String paramString)
    {
      if (paramString != null) {
        this.Ve = paramString;
      }
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jyq
 * JD-Core Version:    0.7.0.1
 */