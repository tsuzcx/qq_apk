package com.tencent.tencentmap.mapsdk.map;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GeoPoint
  implements Parcelable
{
  public static final Parcelable.Creator<GeoPoint> CREATOR = new Parcelable.Creator() {};
  private int a = 0;
  private int b = 0;
  
  public GeoPoint(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  private GeoPoint(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
  }
  
  public GeoPoint Copy()
  {
    return new GeoPoint(this.a, this.b);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
      } while (paramObject.getClass() != getClass());
      paramObject = (GeoPoint)paramObject;
    } while ((this.a != paramObject.a) || (this.b != paramObject.b));
    return true;
  }
  
  public int getLatitudeE6()
  {
    return this.a;
  }
  
  public int getLongitudeE6()
  {
    return this.b;
  }
  
  public int hashCode()
  {
    return this.b * 7 + this.a * 11;
  }
  
  public void setLatitudeE6(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setLongitudeE6(int paramInt)
  {
    this.b = paramInt;
  }
  
  public String toString()
  {
    return this.a + "," + this.b;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.GeoPoint
 * JD-Core Version:    0.7.0.1
 */