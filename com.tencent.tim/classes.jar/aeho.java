public class aeho
{
  private String zC;
  
  public aeho(String paramString, int paramInt1, int paramInt2)
  {
    this.zC = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof aeho))) {}
    while (!toString().equals(paramObject.toString())) {
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    return this.zC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeho
 * JD-Core Version:    0.7.0.1
 */