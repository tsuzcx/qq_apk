public final class yjz
{
  private int a = -2147483648;
  
  public yjz(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public String a()
  {
    switch (a())
    {
    default: 
      return null;
    case 0: 
      return "Success";
    case 1: 
      return "Internal Error";
    case 2: 
      return "Ad was re-loaded too frequently";
    case 3: 
      return "Network Error";
    case 4: 
      return "Invalid Request";
    case 5: 
      return "No Fill";
    case 6: 
      return "Server Error";
    }
    return "Display Format Mismatch";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yjz
 * JD-Core Version:    0.7.0.1
 */