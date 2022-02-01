import java.util.HashMap;

public class amzx
{
  private Long ae;
  private Long af;
  private HashMap<Integer, String> na = new HashMap();
  
  public amzx(Long paramLong1, Long paramLong2)
  {
    this.ae = paramLong1;
    this.af = paramLong2;
  }
  
  public boolean awr()
  {
    return this.na.size() == this.ae.longValue();
  }
  
  public void dG(int paramInt, String paramString)
  {
    this.na.put(Integer.valueOf(paramInt), paramString);
  }
  
  public String zr()
  {
    String str = new String();
    if (!awr()) {
      return str;
    }
    int i = 0;
    while (i < this.na.size())
    {
      str = str + (String)this.na.get(Integer.valueOf(i));
      i += 1;
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amzx
 * JD-Core Version:    0.7.0.1
 */