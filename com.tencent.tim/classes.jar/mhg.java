public class mhg
{
  private Integer I;
  private String headUrl;
  private String nickname;
  private Long uin;
  
  public mhg(Long paramLong, Integer paramInteger, String paramString1, String paramString2)
  {
    this.uin = paramLong;
    this.nickname = paramString1;
    this.headUrl = paramString2;
    this.I = paramInteger;
  }
  
  public String getNickName()
  {
    return this.nickname;
  }
  
  public Long getUin()
  {
    return this.uin;
  }
  
  public String hh()
  {
    return this.headUrl;
  }
  
  public String toString()
  {
    return "FollowingMember{uin='" + this.uin + '\'' + ", nickname='" + this.nickname + '\'' + ", headUrl='" + this.headUrl + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mhg
 * JD-Core Version:    0.7.0.1
 */