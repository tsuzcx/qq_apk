import java.util.List;

public class ovy
{
  private String arG;
  private int bgv;
  private List<String> ln;
  
  public ovy(List<String> paramList, int paramInt)
  {
    this.ln = paramList;
    this.bgv = paramInt;
  }
  
  public boolean HD()
  {
    return (this.bgv > 0) || ((this.ln != null) && (this.ln.size() > 0));
  }
  
  public List<String> bt()
  {
    return this.ln;
  }
  
  public int getMessageCount()
  {
    return this.bgv;
  }
  
  public void qp(String paramString)
  {
    this.arG = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ovy
 * JD-Core Version:    0.7.0.1
 */