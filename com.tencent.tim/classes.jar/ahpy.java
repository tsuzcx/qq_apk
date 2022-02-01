import com.tencent.mobileqq.fts.entity.FTSEntity;
import java.util.Arrays;

public class ahpy
{
  public ahpy.b[] a;
  public String bLl;
  public String bLm;
  public boolean chT;
  public int limit;
  public Class<? extends FTSEntity> x;
  
  public ahpy(Class<? extends FTSEntity> paramClass, ahpy.b[] paramArrayOfb, boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    this.x = paramClass;
    this.a = paramArrayOfb;
    this.chT = paramBoolean;
    this.limit = paramInt;
    this.bLl = paramString1;
    this.bLm = paramString2;
  }
  
  public String toString()
  {
    return "FTSQueryArgs{entityClazz=" + this.x + ", matchKeys=" + Arrays.toString(this.a) + ", matchKeysOr=" + this.chT + ", limit=" + this.limit + ", selectionSql='" + this.bLl + '\'' + ", orderBySql='" + this.bLm + '\'' + '}';
  }
  
  public static class a
  {
    ahpy.b[] a;
    private String bLl;
    private String bLm;
    private boolean chT;
    private int limit;
    private Class<? extends FTSEntity> x;
    
    public a a(int paramInt)
    {
      this.limit = paramInt;
      return this;
    }
    
    public a a(Class<? extends FTSEntity> paramClass)
    {
      this.x = paramClass;
      return this;
    }
    
    public a a(boolean paramBoolean)
    {
      this.chT = paramBoolean;
      return this;
    }
    
    public a a(ahpy.b... paramVarArgs)
    {
      this.a = paramVarArgs;
      return this;
    }
    
    public ahpy a()
    {
      if (this.x == null) {
        throw new IllegalArgumentException("entityClazz must not be null.");
      }
      return new ahpy(this.x, this.a, this.chT, this.limit, this.bLl, this.bLm);
    }
  }
  
  public static class b
  {
    public String bLn;
    public String keyword;
    @Deprecated
    public boolean needSegment = true;
    public boolean or;
    
    public b(String paramString1, String paramString2, boolean paramBoolean)
    {
      this.bLn = paramString1;
      this.keyword = paramString2;
      this.or = paramBoolean;
    }
    
    public String toString()
    {
      return "MatchKey{column='" + this.bLn + '\'' + ", keyword='" + this.keyword + '\'' + ", or=" + this.or + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahpy
 * JD-Core Version:    0.7.0.1
 */