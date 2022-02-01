public class akue
{
  public String bUh;
  public String bUi;
  public double bo;
  public double bp;
  public double cO;
  public int dph;
  public long mUpdateTime;
  
  public akue(double paramDouble1, double paramDouble2, String paramString)
  {
    this.bo = paramDouble1;
    this.bp = paramDouble2;
    this.bUh = paramString;
    if (c(this.bo, this.bp))
    {
      this.dph = 0;
      return;
    }
    this.dph = 1;
  }
  
  public akue(double paramDouble1, double paramDouble2, String paramString, int paramInt)
  {
    this.bo = paramDouble1;
    this.bp = paramDouble2;
    this.bUh = paramString;
    this.dph = paramInt;
  }
  
  public static boolean a(akue paramakue, double paramDouble1, double paramDouble2)
  {
    if (paramakue == null) {}
    do
    {
      return true;
      if ((paramDouble1 < 0.0001D) || (paramDouble2 < 0.0001D)) {
        return false;
      }
    } while ((Math.abs(paramakue.bo - paramDouble1) > 0.001D) || (Math.abs(paramakue.bp - paramDouble2) > 0.001D));
    return false;
  }
  
  public static boolean c(double paramDouble1, double paramDouble2)
  {
    return (paramDouble1 > 0.0001D) && (paramDouble2 > 0.0001D);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("mLatitude:").append(this.bo);
    localStringBuilder.append(" mLongitude:").append(this.bp);
    localStringBuilder.append(" mDirection:").append(this.cO);
    localStringBuilder.append(" mPoiName:").append(this.bUh);
    localStringBuilder.append(" mPoiAddr:").append(this.bUi);
    localStringBuilder.append(" mUpdateTime:").append(this.mUpdateTime);
    localStringBuilder.append(" mValidFlag:").append(this.dph);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akue
 * JD-Core Version:    0.7.0.1
 */