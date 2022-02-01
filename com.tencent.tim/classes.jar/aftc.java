import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

public class aftc
{
  public int alt;
  public int gpsType;
  public int lat;
  public int lon;
  
  public static aftc a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramSosoLbsInfo != null)
    {
      localObject1 = localObject2;
      if (paramSosoLbsInfo.a != null)
      {
        localObject1 = new aftc();
        ((aftc)localObject1).lat = ((int)(paramSosoLbsInfo.a.cd * 1000000.0D));
        ((aftc)localObject1).lon = ((int)(paramSosoLbsInfo.a.ce * 1000000.0D));
        ((aftc)localObject1).gpsType = 1;
        ((aftc)localObject1).alt = ((int)paramSosoLbsInfo.a.altitude);
      }
    }
    return localObject1;
  }
  
  @NonNull
  public String toString()
  {
    return "lat:" + this.lat + " lon:" + this.lon + " alt:" + this.alt + " type:" + this.gpsType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aftc
 * JD-Core Version:    0.7.0.1
 */