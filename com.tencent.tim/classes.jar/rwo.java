public class rwo
{
  public long Cz;
  public String aCQ;
  public int bvB;
  public int bvC;
  public String mAppName;
  public String mDeviceName;
  public int mPriority;
  public int xN;
  
  public rwo(int paramInt)
  {
    this.bvB = paramInt;
    this.mAppName = "QQ";
    this.mPriority = 1;
    switch (paramInt)
    {
    default: 
      return;
    case 65793: 
      this.bvC = 1;
      this.mDeviceName = "Windows";
      this.Cz = 1L;
      this.xN = 1;
      return;
    case 66818: 
    case 66831: 
      this.bvC = 2;
      this.mDeviceName = "Mac";
      this.xN = 1;
      return;
    case 68361: 
    case 72194: 
      this.bvC = 3;
      this.mDeviceName = "iPad";
      this.xN = 2;
      this.mPriority = 2;
      return;
    case 65805: 
    case 68104: 
      this.bvC = 4;
      this.mDeviceName = "aPad";
      this.xN = 2;
      this.mPriority = 2;
      return;
    case 75023: 
    case 78082: 
    case 78096: 
      this.bvC = 5;
      this.mDeviceName = acfp.m(2131707920);
      this.xN = 3;
      this.mPriority = 3;
      return;
    case 77313: 
      this.bvC = 6;
      this.mDeviceName = "Windows";
      this.mAppName = "TIM";
      this.Cz = 1L;
      this.xN = 1;
      return;
    }
    this.bvC = 7;
    this.mDeviceName = "iPad";
    this.mAppName = "TIM";
    this.xN = 2;
    this.mPriority = 2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LoginDevItem[").append(this.mAppName).append("|").append(this.bvB).append("|").append(this.Cz).append("|").append(this.mPriority).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rwo
 * JD-Core Version:    0.7.0.1
 */