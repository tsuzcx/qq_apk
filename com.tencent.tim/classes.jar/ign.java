public class ign
{
  public String LR;
  public int age;
  public int alb;
  public int alc;
  public int ald;
  public String desc;
  public String distance;
  public int gender;
  public String hint;
  public boolean isFollowed;
  public String level;
  public String logoUrl;
  public String nick;
  public int showTime;
  public long tinyId;
  public String uin;
  public int vipLevel;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin=").append(this.uin).append(", nick=").append(this.nick).append(", level=").append(this.level).append(", distance=").append(this.distance).append(", age=").append(this.age).append(", gender=").append(this.gender).append(", isFollowed=").append(this.isFollowed).append(", logoUrl=").append(this.logoUrl).append(", hint=").append(this.hint).append(",likeState=").append(this.alb).append(",showTime=").append(this.showTime).append(",vipFee=").append(this.alc).append(",vipLevel=").append(this.vipLevel).append(",desc=").append(this.desc).append(",selfUserType=").append(this.ald).append(",threeWord=").append(this.LR).append(",tinyId=").append(this.tinyId);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ign
 * JD-Core Version:    0.7.0.1
 */