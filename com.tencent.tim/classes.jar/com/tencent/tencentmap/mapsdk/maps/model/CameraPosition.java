package com.tencent.tencentmap.mapsdk.maps.model;

public final class CameraPosition
{
  public final float bearing;
  public LatLng target;
  public final float tilt;
  public final float zoom;
  
  public CameraPosition(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this(paramLatLng, paramFloat1, paramFloat2, paramFloat3, (byte)0);
  }
  
  private CameraPosition(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3, byte paramByte)
  {
    this.target = paramLatLng;
    this.zoom = paramFloat1;
    this.tilt = paramFloat2;
    this.bearing = paramFloat3;
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  public static Builder builder(CameraPosition paramCameraPosition)
  {
    return new Builder(paramCameraPosition);
  }
  
  public static final CameraPosition fromLatLngZoom(LatLng paramLatLng, float paramFloat)
  {
    return new CameraPosition(paramLatLng, paramFloat, 0.0F, 0.0F);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof CameraPosition)) {
        return false;
      }
      paramObject = (CameraPosition)paramObject;
    } while ((this.target.equals(paramObject.target)) && (Float.floatToIntBits(this.zoom) == Float.floatToIntBits(paramObject.zoom)) && (Float.floatToIntBits(this.tilt) == Float.floatToIntBits(paramObject.tilt)) && (Float.floatToIntBits(this.bearing) == Float.floatToIntBits(paramObject.bearing)));
    return false;
  }
  
  public final String toString()
  {
    return "latlng:" + this.target.latitude + "," + this.target.longitude + ",zoom:" + this.zoom + ",tilt=" + this.tilt + ",bearing:" + this.bearing;
  }
  
  public static final class Builder
  {
    private LatLng a;
    private float b;
    private float c = 1.4E-45F;
    private float d = 1.4E-45F;
    
    public Builder() {}
    
    public Builder(CameraPosition paramCameraPosition)
    {
      this.a = paramCameraPosition.target;
      this.b = paramCameraPosition.zoom;
      this.c = paramCameraPosition.tilt;
      this.d = paramCameraPosition.bearing;
    }
    
    public final Builder bearing(float paramFloat)
    {
      this.d = paramFloat;
      return this;
    }
    
    public final CameraPosition build()
    {
      return new CameraPosition(this.a, this.b, this.c, this.d);
    }
    
    public final Builder target(LatLng paramLatLng)
    {
      this.a = paramLatLng;
      return this;
    }
    
    public final Builder tilt(float paramFloat)
    {
      this.c = paramFloat;
      return this;
    }
    
    public final Builder zoom(float paramFloat)
    {
      this.b = paramFloat;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.CameraPosition
 * JD-Core Version:    0.7.0.1
 */