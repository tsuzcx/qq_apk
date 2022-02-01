public class afts
{
  public String SenderNickName;
  public String bFD;
  public int c2cExpiredTime;
  public boolean caL = true;
  public int leaveChatType = -1;
  public int leftChatTime;
  public int matchExpiredTime;
  public long readyTs;
  public long timeStamp;
  public String tipsWording;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{SenderUin: ").append(this.bFD).append("}");
    localStringBuilder.append("{SenderNickName: ").append(this.SenderNickName).append("}");
    localStringBuilder.append("{bEnter: ").append(this.caL).append("}");
    localStringBuilder.append("{leaveChatType: ").append(this.leaveChatType).append("}");
    localStringBuilder.append("{leftChatTime: ").append(this.leftChatTime).append("}");
    localStringBuilder.append("{timeStamp: ").append(this.timeStamp).append("}");
    localStringBuilder.append("{matchExpired: ").append(this.matchExpiredTime).append("}");
    localStringBuilder.append("{c2cExpiredTime: ").append(this.c2cExpiredTime).append("}");
    localStringBuilder.append("{tipsWording: ").append(this.tipsWording).append("}");
    localStringBuilder.append("{readyTs: ").append(this.readyTs).append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afts
 * JD-Core Version:    0.7.0.1
 */