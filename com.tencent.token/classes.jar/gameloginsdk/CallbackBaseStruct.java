package gameloginsdk;

public class CallbackBaseStruct
{
  public String errMsg;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("|errMsg|");
    localStringBuilder.append(this.errMsg);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     gameloginsdk.CallbackBaseStruct
 * JD-Core Version:    0.7.0.1
 */