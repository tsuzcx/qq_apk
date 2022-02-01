package com.tencent.tavsticker.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.libpag.PAGLayer;

public class TAVStickerShapeItem
  extends TAVStickerLayerItem
  implements Parcelable
{
  public static final Parcelable.Creator<TAVStickerShapeItem> CREATOR = new TAVStickerShapeItem.1();
  
  public TAVStickerShapeItem()
  {
    this.layerType = 4;
  }
  
  protected TAVStickerShapeItem(Parcel paramParcel)
  {
    if (paramParcel != null)
    {
      this.layerIndex = paramParcel.readInt();
      this.layerName = paramParcel.readString();
      this.layerType = paramParcel.readInt();
    }
  }
  
  public TAVStickerShapeItem(PAGLayer paramPAGLayer)
  {
    super(paramPAGLayer);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "TAVStickerShapeItem {layerIndex : " + this.layerIndex + ", layerName : " + this.layerName + ", layerType : " + this.layerType + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.layerIndex);
    if (this.layerName == null) {}
    for (String str = "";; str = this.layerName)
    {
      paramParcel.writeString(str);
      paramParcel.writeInt(this.layerType);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVStickerShapeItem
 * JD-Core Version:    0.7.0.1
 */