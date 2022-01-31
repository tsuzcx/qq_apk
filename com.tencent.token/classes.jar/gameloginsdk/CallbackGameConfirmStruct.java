package gameloginsdk;

public class CallbackGameConfirmStruct
  extends CallbackBaseStruct
{
  public long appid;
  public int playerStatus;
  public String uin;
  public String wording;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString());
    localStringBuilder.append("|appid|");
    localStringBuilder.append(this.appid);
    localStringBuilder.append("|uin|");
    localStringBuilder.append(this.uin);
    localStringBuilder.append("|playerStatus|");
    localStringBuilder.append(this.playerStatus);
    localStringBuilder.append("|wording|");
    localStringBuilder.append(this.wording);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     gameloginsdk.CallbackGameConfirmStruct
 * JD-Core Version:    0.7.0.1
 */