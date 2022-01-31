package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class OverlayItem
  implements Parcelable
{
  public static final Parcelable.Creator<OverlayItem> CREATOR = new Parcelable.Creator() {};
  private Drawable a;
  protected boolean boDragable = true;
  protected GeoPoint mPoint;
  protected final String mSnippet;
  protected final String mTitle;
  
  protected OverlayItem(Parcel paramParcel)
  {
    this.mPoint = ((GeoPoint)paramParcel.readValue(GeoPoint.class.getClassLoader()));
    this.mTitle = paramParcel.readString();
    this.mSnippet = paramParcel.readString();
  }
  
  public OverlayItem(GeoPoint paramGeoPoint, String paramString1, String paramString2)
  {
    this.mPoint = paramGeoPoint.Copy();
    this.mTitle = paramString1;
    this.mSnippet = paramString2;
    this.a = null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Drawable getMarker()
  {
    return this.a;
  }
  
  public GeoPoint getPoint()
  {
    return this.mPoint;
  }
  
  public String getSnippet()
  {
    return this.mSnippet;
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public boolean isDragable()
  {
    return this.boDragable;
  }
  
  public void setDragable(boolean paramBoolean)
  {
    this.boDragable = paramBoolean;
  }
  
  public void setMarker(Drawable paramDrawable)
  {
    this.a = paramDrawable;
    if (this.a == null) {}
    do
    {
      return;
      paramDrawable = this.a.getBounds();
      if (paramDrawable == null)
      {
        ItemizedOverlay.boundCenterBottom(this.a);
        return;
      }
    } while ((paramDrawable.left != 0) || (paramDrawable.right != 0) || (paramDrawable.top != 0) || (paramDrawable.bottom != 0));
    ItemizedOverlay.boundCenterBottom(this.a);
  }
  
  public void setPoint(GeoPoint paramGeoPoint)
  {
    this.mPoint = paramGeoPoint.Copy();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeValue(this.mPoint);
    paramParcel.writeString(this.mTitle);
    paramParcel.writeString(this.mSnippet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.OverlayItem
 * JD-Core Version:    0.7.0.1
 */