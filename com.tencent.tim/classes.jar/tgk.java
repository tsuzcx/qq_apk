public final class tgk
{
  private int errorCode = -2147483648;
  
  public tgk(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public String getErrorMessage()
  {
    switch (getErrorCode())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tgk
 * JD-Core Version:    0.7.0.1
 */