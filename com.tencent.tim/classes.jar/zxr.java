public class zxr
{
  public long LE;
  public long lastUpdateTime;
  public int source;
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof zxr))
    {
      paramObject = (zxr)paramObject;
      if ((paramObject.source == this.source) && (paramObject.LE == this.LE)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zxr
 * JD-Core Version:    0.7.0.1
 */