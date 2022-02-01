import java.util.List;

public abstract class amnt
  implements ampw
{
  protected List<ampx> Bu;
  protected String keyword;
  
  public amnt(List<ampx> paramList, String paramString)
  {
    this.Bu = paramList;
    this.keyword = paramString;
  }
  
  public int Ex()
  {
    return 3;
  }
  
  public List<ampx> eX()
  {
    return this.Bu;
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amnt
 * JD-Core Version:    0.7.0.1
 */