import android.support.annotation.Nullable;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import org.jetbrains.annotations.NotNull;

public class aiqn
{
  private double cK;
  private int deU = -1;
  private LatLng f;
  private String mUin;
  
  public aiqn(String paramString, LatLng paramLatLng, double paramDouble)
  {
    this.mUin = paramString;
    this.f = paramLatLng;
    this.cK = paramDouble;
  }
  
  public LatLng a()
  {
    return this.f;
  }
  
  public void a(LatLng paramLatLng, Double paramDouble)
  {
    if (paramLatLng != null) {
      this.f = paramLatLng;
    }
    if (paramDouble != null) {
      this.cK = paramDouble.doubleValue();
    }
  }
  
  public void dtM()
  {
    this.f = null;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof aiqn))
    {
      paramObject = (aiqn)paramObject;
      return this.mUin.equals(paramObject.getUin());
    }
    return super.equals(paramObject);
  }
  
  public String getUin()
  {
    return this.mUin;
  }
  
  public int getZIndex()
  {
    return this.deU;
  }
  
  public void setZIndex(int paramInt)
  {
    this.deU = paramInt;
  }
  
  @NotNull
  public String toString()
  {
    return "LocationItem{mUin='" + this.mUin + '\'' + ", mLatLng=" + this.f + ", mRotation=" + this.cK + '}';
  }
  
  public double x()
  {
    return this.cK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiqn
 * JD-Core Version:    0.7.0.1
 */