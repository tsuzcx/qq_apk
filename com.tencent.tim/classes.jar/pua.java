import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

public class pua
{
  public final int mLatitude;
  public final int mLongitude;
  public final int mType;
  
  public pua(int paramInt1, int paramInt2)
  {
    this.mLatitude = paramInt1;
    this.mLongitude = paramInt2;
    this.mType = 1;
  }
  
  public pua(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mLatitude = paramInt1;
    this.mLongitude = paramInt2;
    this.mType = paramInt3;
  }
  
  public static pua a(SosoInterface.SosoLocation paramSosoLocation)
  {
    if (paramSosoLocation != null) {
      return new pua((int)(paramSosoLocation.cd * 1000000.0D), (int)(paramSosoLocation.ce * 1000000.0D));
    }
    return new pua(0, 0);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (pua)paramObject;
      if (this.mLatitude != paramObject.mLatitude) {
        return false;
      }
    } while (this.mLongitude == paramObject.mLongitude);
    return false;
  }
  
  public int hashCode()
  {
    return this.mLatitude * 31 + this.mLongitude;
  }
  
  public String toString()
  {
    return "GpsMsg{latitude=" + this.mLatitude + ", longitude=" + this.mLongitude + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pua
 * JD-Core Version:    0.7.0.1
 */