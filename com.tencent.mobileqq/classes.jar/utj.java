import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

public class utj
{
  public final int a;
  public final int b;
  public final int c;
  
  public utj(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = 1;
  }
  
  public utj(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public static utj a(SosoInterface.SosoLocation paramSosoLocation)
  {
    if (paramSosoLocation != null) {
      return new utj((int)(paramSosoLocation.a * 1000000.0D), (int)(paramSosoLocation.b * 1000000.0D));
    }
    return new utj(0, 0);
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
      paramObject = (utj)paramObject;
      if (this.a != paramObject.a) {
        return false;
      }
    } while (this.b == paramObject.b);
    return false;
  }
  
  public int hashCode()
  {
    return this.a * 31 + this.b;
  }
  
  public String toString()
  {
    return "GpsMsg{latitude=" + this.a + ", longitude=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     utj
 * JD-Core Version:    0.7.0.1
 */