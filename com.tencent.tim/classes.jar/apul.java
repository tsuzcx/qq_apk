import java.util.List;

public class apul
{
  public List<String> CC;
  public String baE;
  public boolean byl;
  public String clipInfo;
  public int progress;
  public long ts;
  public int type = 0;
  
  public String fP(int paramInt)
  {
    if ((this.CC == null) || (this.CC.size() == 0)) {
      return "";
    }
    if (paramInt < this.CC.size()) {
      return (String)this.CC.get(paramInt);
    }
    return (String)this.CC.get(this.CC.size() - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apul
 * JD-Core Version:    0.7.0.1
 */