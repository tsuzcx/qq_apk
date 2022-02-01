import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ansf
{
  public ansf a;
  public List<ansf> children;
  public String name;
  public Map<String, String> nq;
  public int type = 1;
  public String value;
  
  public ansf(String paramString, Map<String, String> paramMap)
  {
    this.name = paramString;
    this.nq = paramMap;
  }
  
  public int Ks()
  {
    if (this.children != null) {
      return this.children.size();
    }
    return 0;
  }
  
  public ansf a()
  {
    if (this.children != null) {
      return a(this.children.indexOf(this) + 1);
    }
    return null;
  }
  
  public ansf a(int paramInt)
  {
    if ((this.children != null) && (this.children.size() > paramInt)) {
      return (ansf)this.children.get(paramInt);
    }
    return null;
  }
  
  public void a(ansf paramansf)
  {
    if (this.children == null) {
      this.children = new ArrayList();
    }
    this.children.add(paramansf);
  }
  
  public ansf b()
  {
    return a(0);
  }
  
  public String getAttribute(String paramString)
  {
    if (this.nq != null) {
      return (String)this.nq.get(paramString);
    }
    return null;
  }
  
  public boolean hasAttributes()
  {
    return (this.nq != null) && (this.nq.size() > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ansf
 * JD-Core Version:    0.7.0.1
 */