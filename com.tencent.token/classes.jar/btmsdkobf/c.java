package btmsdkobf;

public class c
{
  public int b;
  public long c;
  public String value;
  
  public c(String paramString, int paramInt)
  {
    this.value = paramString;
    this.b = paramInt;
    this.c = (System.currentTimeMillis() + 86400000L);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ValueData{value='");
    localStringBuilder.append(this.value);
    localStringBuilder.append('\'');
    localStringBuilder.append(", code=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", expired=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.c
 * JD-Core Version:    0.7.0.1
 */