public class alyj
  implements Cloneable
{
  public long cost = -1L;
  public int dAi;
  public int dAj;
  public int failCount;
  public String host;
  public int port;
  
  public alyj(String paramString, int paramInt)
  {
    this.host = paramString;
    this.port = paramInt;
  }
  
  public alyj a()
    throws CloneNotSupportedException
  {
    return (alyj)super.clone();
  }
  
  public String toString()
  {
    return this.host + ":" + this.port + " failCount:" + this.failCount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alyj
 * JD-Core Version:    0.7.0.1
 */