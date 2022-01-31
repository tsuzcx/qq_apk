import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import java.util.List;

class xao
  implements LocationListener
{
  xao(xak paramxak) {}
  
  public void onLocationChanged(Location paramLocation)
  {
    if (paramLocation != null)
    {
      wsv.a("DoodleEmojiManager", "onLocationChanged, location : %s", paramLocation);
      if (this.a.b.size() >= 10)
      {
        this.a.b.remove(0);
        wsv.b("DoodleEmojiManager", "onLocationChanged, LocationList size > 5, remove the first location.");
      }
      this.a.b.add(new Location(paramLocation));
      return;
    }
    wsv.d("DoodleEmojiManager", "onLocationChanged, location is null.");
  }
  
  public void onProviderDisabled(String paramString)
  {
    wsv.a("DoodleEmojiManager", "onProviderDisabled, provider: %s .", paramString);
  }
  
  public void onProviderEnabled(String paramString)
  {
    wsv.a("DoodleEmojiManager", "onProviderEnabled, provider: %s .", paramString);
  }
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
  {
    wsv.a("DoodleEmojiManager", "onStatusChanged, provider: %s , status: %s .", paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xao
 * JD-Core Version:    0.7.0.1
 */