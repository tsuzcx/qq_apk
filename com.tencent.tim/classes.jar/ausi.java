import java.util.HashMap;

public class ausi
{
  public int action;
  public String content;
  public HashMap<String, Object> tag = new HashMap();
  public int type = 1;
  public int viewid;
  public int visibility;
  
  public ausi(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramString, paramInt2, paramInt3, 1);
  }
  
  public ausi(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    this.viewid = paramInt1;
    this.content = paramString;
    this.action = paramInt2;
    this.visibility = paramInt3;
    this.type = paramInt4;
  }
  
  public ausi(String paramString, int paramInt1, int paramInt2)
  {
    this(0, paramString, paramInt1, paramInt2);
  }
  
  public Object getTag(String paramString)
  {
    return this.tag.get(paramString);
  }
  
  public void setTag(String paramString, Object paramObject)
  {
    this.tag.put(paramString, paramObject);
  }
  
  public void setVisibility(int paramInt)
  {
    this.visibility = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ausi
 * JD-Core Version:    0.7.0.1
 */