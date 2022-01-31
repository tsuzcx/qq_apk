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
    return "ValueData{value='" + this.value + '\'' + ", code=" + this.b + ", expired=" + this.c + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.c
 * JD-Core Version:    0.7.0.1
 */