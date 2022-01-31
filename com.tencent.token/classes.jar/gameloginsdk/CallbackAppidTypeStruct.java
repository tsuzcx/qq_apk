package gameloginsdk;

public class CallbackAppidTypeStruct
  extends CallbackBaseStruct
{
  public int appidType;
  public String url;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString());
    localStringBuilder.append("|appidType|");
    localStringBuilder.append(this.appidType);
    localStringBuilder.append("|url|");
    localStringBuilder.append(this.url);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     gameloginsdk.CallbackAppidTypeStruct
 * JD-Core Version:    0.7.0.1
 */