import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import java.util.List;

class rgt
  implements LocationListener
{
  rgt(rgp paramrgp) {}
  
  public void onLocationChanged(Location paramLocation)
  {
    if (paramLocation != null)
    {
      ram.b("DoodleEmojiManager", "onLocationChanged, location : %s", paramLocation);
      if (this.a.oM.size() >= 10)
      {
        this.a.oM.remove(0);
        ram.d("DoodleEmojiManager", "onLocationChanged, LocationList size > 5, remove the first location.");
      }
      this.a.oM.add(new Location(paramLocation));
      return;
    }
    ram.w("DoodleEmojiManager", "onLocationChanged, location is null.");
  }
  
  public void onProviderDisabled(String paramString)
  {
    ram.b("DoodleEmojiManager", "onProviderDisabled, provider: %s .", paramString);
  }
  
  public void onProviderEnabled(String paramString)
  {
    ram.b("DoodleEmojiManager", "onProviderEnabled, provider: %s .", paramString);
  }
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
  {
    ram.b("DoodleEmojiManager", "onStatusChanged, provider: %s , status: %s .", paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rgt
 * JD-Core Version:    0.7.0.1
 */