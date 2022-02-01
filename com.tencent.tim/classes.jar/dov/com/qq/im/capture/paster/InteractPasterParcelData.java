package dov.com.qq.im.capture.paster;

import android.annotation.TargetApi;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import axst;
import aykb.b;

public class InteractPasterParcelData
  implements Parcelable
{
  public static final Parcelable.Creator<InteractPasterParcelData> CREATOR = new axst();
  public PointF centerP;
  public Rect[] g;
  public String[] jn;
  public float nI;
  public float scaleValue = 1.0F;
  public float translateXValue;
  public float translateYValue;
  public int type;
  
  public InteractPasterParcelData(Parcel paramParcel)
  {
    this.type = paramParcel.readInt();
    this.centerP = ((PointF)paramParcel.readParcelable(PointF.class.getClassLoader()));
    this.scaleValue = paramParcel.readFloat();
    this.nI = paramParcel.readFloat();
    this.translateXValue = paramParcel.readFloat();
    this.translateYValue = paramParcel.readFloat();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.jn = new String[i];
      paramParcel.readStringArray(this.jn);
    }
    i = paramParcel.readInt();
    if (i > 0)
    {
      this.g = new Rect[i];
      paramParcel.readTypedArray(this.g, Rect.CREATOR);
    }
  }
  
  public InteractPasterParcelData(aykb.b paramb)
  {
    this.type = paramb.type;
    this.centerP = paramb.centerP;
    this.scaleValue = paramb.scaleValue;
    this.nI = paramb.nI;
    this.translateXValue = paramb.translateXValue;
    this.translateYValue = paramb.translateYValue;
    this.jn = paramb.jn;
    this.g = paramb.h;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @TargetApi(13)
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.type);
    paramParcel.writeParcelable(this.centerP, 0);
    paramParcel.writeFloat(this.scaleValue);
    paramParcel.writeFloat(this.nI);
    paramParcel.writeFloat(this.translateXValue);
    paramParcel.writeFloat(this.translateYValue);
    if ((this.jn == null) || (this.jn.length == 0)) {
      paramParcel.writeInt(0);
    }
    while ((this.g == null) || (this.g.length == 0))
    {
      paramParcel.writeInt(0);
      return;
      paramParcel.writeInt(this.jn.length);
      paramParcel.writeStringArray(this.jn);
    }
    paramParcel.writeInt(this.g.length);
    paramParcel.writeTypedArray(this.g, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.InteractPasterParcelData
 * JD-Core Version:    0.7.0.1
 */