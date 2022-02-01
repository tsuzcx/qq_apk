public class atbe
  implements Comparable<atbe>
{
  public static final atbe b = new atbe("学校", "添加更多学校", true, 2, 11, 2147483647);
  public final String content;
  public final boolean dgZ;
  public Object fO;
  public Object fP;
  public final int id;
  public final String name;
  public final int sort;
  public final int type;
  
  private atbe(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.name = paramString1;
    this.content = paramString2;
    this.dgZ = paramBoolean;
    this.type = paramInt1;
    this.id = paramInt2;
    this.sort = paramInt3;
  }
  
  public int a(atbe paramatbe)
  {
    if (paramatbe != null) {
      return this.sort - paramatbe.sort;
    }
    return 0;
  }
  
  public atbe.a a()
  {
    return new atbe.a().a(this.name).b(this.content).a(this.dgZ).a(this.type).a(this.fO).c(this.sort).b(this.fP).a(this.type).b(this.id);
  }
  
  public String toString()
  {
    return "ProfileCardData{name='" + this.name + '\'' + ", content='" + this.content + '\'' + ", showArrow=" + this.dgZ + ", type=" + this.type + ", id=" + this.id + ", sort=" + this.sort + ", extraData=" + this.fO + ", modifyData=" + this.fP + '}';
  }
  
  public static final class a
  {
    private String content = "";
    private boolean dgZ;
    private Object fO;
    private Object fP;
    private int id = -1;
    private String name = "";
    private int sort = 2147483647;
    private int type = 0;
    
    public a a(int paramInt)
    {
      this.type = paramInt;
      return this;
    }
    
    public a a(Object paramObject)
    {
      this.fO = paramObject;
      return this;
    }
    
    public a a(String paramString)
    {
      this.name = paramString;
      return this;
    }
    
    public a a(boolean paramBoolean)
    {
      this.dgZ = paramBoolean;
      return this;
    }
    
    public atbe a()
    {
      atbe localatbe = new atbe(this.name, this.content, this.dgZ, this.type, this.id, this.sort, null);
      localatbe.fO = this.fO;
      localatbe.fP = this.fP;
      return localatbe;
    }
    
    public a b()
    {
      this.name = "";
      this.content = "";
      this.dgZ = false;
      this.type = 0;
      this.id = -1;
      this.sort = 2147483647;
      return this;
    }
    
    public a b(int paramInt)
    {
      this.id = paramInt;
      return this;
    }
    
    public a b(Object paramObject)
    {
      this.fP = paramObject;
      return this;
    }
    
    public a b(String paramString)
    {
      this.content = paramString;
      return this;
    }
    
    public a c(int paramInt)
    {
      this.sort = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atbe
 * JD-Core Version:    0.7.0.1
 */