package gameloginsdk;

public class CallbackPushStruct
{
  public long appid;
  public int expirtTime;
  public String gameName;
  public String player;
  public String scene;
  public int schemeFlag;
  public String uin;
  public String world;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CallbackPushStruct|appid|");
    localStringBuilder.append(this.appid);
    localStringBuilder.append("|uin|");
    localStringBuilder.append(this.uin);
    localStringBuilder.append("|schemeFlag|");
    localStringBuilder.append(this.schemeFlag);
    localStringBuilder.append("|expirtTime|");
    localStringBuilder.append(this.expirtTime);
    localStringBuilder.append("|player|");
    localStringBuilder.append(this.player);
    localStringBuilder.append("|world|");
    localStringBuilder.append(this.world);
    localStringBuilder.append("|gameName|");
    localStringBuilder.append(this.gameName);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     gameloginsdk.CallbackPushStruct
 * JD-Core Version:    0.7.0.1
 */