package moai.storage;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

final class Cache$1
  implements ComponentCallbacks2
{
  Cache$1(Cache paramCache) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory()
  {
    this.val$cache.invalidateAll();
  }
  
  public void onTrimMemory(int paramInt)
  {
    if (paramInt >= 60)
    {
      onLowMemory();
      return;
    }
    this.val$cache.cleanUp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.storage.Cache.1
 * JD-Core Version:    0.7.0.1
 */