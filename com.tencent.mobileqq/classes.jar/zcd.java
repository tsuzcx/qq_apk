import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import java.util.List;

class zcd
  implements LocationListener
{
  zcd(zbz paramzbz) {}
  
  public void onLocationChanged(Location paramLocation)
  {
    if (paramLocation != null)
    {
      yuk.a("DoodleEmojiManager", "onLocationChanged, location : %s", paramLocation);
      if (this.a.b.size() >= 10)
      {
        this.a.b.remove(0);
        yuk.b("DoodleEmojiManager", "onLocationChanged, LocationList size > 5, remove the first location.");
      }
      this.a.b.add(new Location(paramLocation));
      return;
    }
    yuk.d("DoodleEmojiManager", "onLocationChanged, location is null.");
  }
  
  public void onProviderDisabled(String paramString)
  {
    yuk.a("DoodleEmojiManager", "onProviderDisabled, provider: %s .", paramString);
  }
  
  public void onProviderEnabled(String paramString)
  {
    yuk.a("DoodleEmojiManager", "onProviderEnabled, provider: %s .", paramString);
  }
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
  {
    yuk.a("DoodleEmojiManager", "onStatusChanged, provider: %s , status: %s .", paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zcd
 * JD-Core Version:    0.7.0.1
 */