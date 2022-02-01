import com.tencent.av.gaudio.AVPhoneUserInfo;

public class jfj
{
  public boolean Pk;
  public boolean Pl;
  public boolean Tp;
  public boolean Ts;
  public boolean Wu;
  public boolean Ww;
  public boolean Xc;
  public int accountType;
  public int awy = 0;
  public AVPhoneUserInfo b;
  public long mk = 4L;
  public String name;
  public long uin;
  
  public int getAccountType()
  {
    return this.accountType;
  }
  
  public long getUin()
  {
    return this.uin;
  }
  
  public int getVideoSrcType()
  {
    return this.awy;
  }
  
  public boolean isSpeaking()
  {
    return (this.Wu) && (!this.Pk);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin:=").append(this.uin).append(',');
    localStringBuilder.append("videoSrc:=").append(this.awy).append(',');
    localStringBuilder.append("isVideoIn:=").append(this.Xc).append(',');
    localStringBuilder.append("isAttened:=").append(this.Ww).append(',');
    localStringBuilder.append("isSpeaking:=").append(this.Wu).append(',');
    return localStringBuilder.toString();
  }
  
  public boolean wZ()
  {
    return this.Ww;
  }
  
  public boolean xa()
  {
    return this.awy == 2;
  }
  
  public boolean xb()
  {
    return this.Xc;
  }
  
  public boolean xc()
  {
    return this.Pk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jfj
 * JD-Core Version:    0.7.0.1
 */