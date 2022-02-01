package moai.patch.log;

public class PendingLog
{
  private long cost;
  private int level;
  private String log;
  private int logId;
  private int processId;
  private String processName;
  
  public PendingLog(int paramInt1, int paramInt2, String paramString1, long paramLong, String paramString2, int paramInt3)
  {
    this.level = paramInt1;
    this.logId = paramInt2;
    this.log = paramString1;
    this.cost = paramLong;
    this.processName = paramString2;
    this.processId = paramInt3;
  }
  
  public long getCost()
  {
    return this.cost;
  }
  
  public int getLevel()
  {
    return this.level;
  }
  
  public String getLog()
  {
    return this.log;
  }
  
  public int getLogId()
  {
    return this.logId;
  }
  
  public int getProcessId()
  {
    return this.processId;
  }
  
  public String getProcessName()
  {
    return this.processName;
  }
  
  public void setCost(long paramLong)
  {
    this.cost = paramLong;
  }
  
  public void setLevel(int paramInt)
  {
    this.level = paramInt;
  }
  
  public void setLog(String paramString)
  {
    this.log = paramString;
  }
  
  public void setLogId(int paramInt)
  {
    this.logId = paramInt;
  }
  
  public void setProcessId(int paramInt)
  {
    this.processId = paramInt;
  }
  
  public void setProcessName(String paramString)
  {
    this.processName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.log.PendingLog
 * JD-Core Version:    0.7.0.1
 */