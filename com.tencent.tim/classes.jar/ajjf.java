import com.tencent.mobileqq.data.IntimateInfo;

public class ajjf
{
  public IntimateInfo a;
  public String mNickName;
  private long mTimestamp;
  public int mType = -1;
  
  public ajjf(IntimateInfo paramIntimateInfo)
  {
    this.a = paramIntimateInfo;
    if (this.a != null) {
      if (this.a.isFriend) {
        break label44;
      }
    }
    label44:
    for (this.mType = 1;; this.mType = 0)
    {
      this.mTimestamp = System.currentTimeMillis();
      return;
    }
  }
  
  public boolean aqV()
  {
    if (this.a == null) {}
    int i;
    do
    {
      return false;
      i = this.a.maskType;
    } while ((i != 3) && (i != 2) && (i != 1));
    return true;
  }
  
  public String getNickName()
  {
    return this.mNickName;
  }
  
  public long getTimeStamp()
  {
    return this.mTimestamp;
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  public String getUin()
  {
    if (this.a == null) {
      return null;
    }
    return this.a.friendUin;
  }
  
  public void setNickName(String paramString)
  {
    this.mNickName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajjf
 * JD-Core Version:    0.7.0.1
 */