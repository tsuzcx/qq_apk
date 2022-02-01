public class arxm
{
  public long awK = 259200L;
  public long awL;
  public String cCQ;
  public String key;
  public long updatetime;
  public String url;
  
  public boolean equals(Object paramObject)
  {
    paramObject = (arxm)paramObject;
    if (paramObject != null) {
      return paramObject.key.equals(this.key);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.key.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arxm
 * JD-Core Version:    0.7.0.1
 */