import java.util.List;

public class mox
{
  private String ajv = "";
  private List<String> jt;
  private int maxCount = 30;
  private int maxSelectNum = 10;
  private int openType;
  private String rowKey = "";
  
  public List<String> bd()
  {
    return this.jt;
  }
  
  public void cP(List<String> paramList)
  {
    this.jt = paramList;
  }
  
  public int getMaxCount()
  {
    return this.maxCount;
  }
  
  public String getRowKey()
  {
    return this.rowKey;
  }
  
  public String kh()
  {
    return this.ajv;
  }
  
  public void nJ(String paramString)
  {
    this.ajv = paramString;
  }
  
  public int pC()
  {
    return this.openType;
  }
  
  public int pD()
  {
    return this.maxSelectNum;
  }
  
  public void setRowKey(String paramString)
  {
    this.rowKey = paramString;
  }
  
  public void sf(int paramInt)
  {
    this.openType = paramInt;
  }
  
  public void sg(int paramInt)
  {
    this.maxSelectNum = paramInt;
  }
  
  public void sh(int paramInt)
  {
    this.maxCount = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mox
 * JD-Core Version:    0.7.0.1
 */