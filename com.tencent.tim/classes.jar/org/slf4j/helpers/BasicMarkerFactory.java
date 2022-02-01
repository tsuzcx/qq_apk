package org.slf4j.helpers;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.IMarkerFactory;
import org.slf4j.Marker;

public class BasicMarkerFactory
  implements IMarkerFactory
{
  private final ConcurrentMap<String, Marker> markerMap = new ConcurrentHashMap();
  
  public boolean detachMarker(String paramString)
  {
    if (paramString == null) {}
    while (this.markerMap.remove(paramString) == null) {
      return false;
    }
    return true;
  }
  
  public boolean exists(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return this.markerMap.containsKey(paramString);
  }
  
  public Marker getDetachedMarker(String paramString)
  {
    return new BasicMarker(paramString);
  }
  
  public Marker getMarker(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Marker name cannot be null");
    }
    Object localObject2 = (Marker)this.markerMap.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = new BasicMarker(paramString);
      localObject1 = (Marker)this.markerMap.putIfAbsent(paramString, localObject2);
      if (localObject1 == null) {}
    }
    else
    {
      return localObject1;
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.slf4j.helpers.BasicMarkerFactory
 * JD-Core Version:    0.7.0.1
 */