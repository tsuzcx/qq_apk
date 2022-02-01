package dov.com.qq.im.capture.paster;

import android.annotation.TargetApi;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import axsy;
import ayjn.a;
import ayjn.b;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import org.json.JSONObject;

public class PasterParcelData
  implements Parcelable
{
  public static final Parcelable.Creator<PasterParcelData> CREATOR = new axsy();
  public static int eGW = 1;
  public static int eGX = 2;
  public RectF X;
  public String category;
  public PointF centerP;
  public String data;
  public int eGY;
  public int eGZ;
  public float height;
  public String location;
  public SegmentKeeper mSegmentKeeper = new SegmentKeeper();
  public int mType;
  public float nI;
  public String name;
  public String path;
  public float scaleValue = 1.0F;
  public String text;
  public int textColor;
  public int textSize;
  public float translateXValue;
  public float translateYValue;
  public float width;
  
  public PasterParcelData(Parcel paramParcel)
  {
    this.mType = paramParcel.readInt();
    this.centerP = ((PointF)paramParcel.readParcelable(PointF.class.getClassLoader()));
    this.scaleValue = paramParcel.readFloat();
    this.nI = paramParcel.readFloat();
    this.translateXValue = paramParcel.readFloat();
    this.translateYValue = paramParcel.readFloat();
    this.width = paramParcel.readFloat();
    this.height = paramParcel.readFloat();
    this.X = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
    this.category = paramParcel.readString();
    this.name = paramParcel.readString();
    this.path = paramParcel.readString();
    this.eGY = paramParcel.readInt();
    this.data = paramParcel.readString();
    this.eGZ = paramParcel.readInt();
    this.textSize = paramParcel.readInt();
    this.textColor = paramParcel.readInt();
    this.text = paramParcel.readString();
    this.location = paramParcel.readString();
    this.mSegmentKeeper = ((SegmentKeeper)paramParcel.readParcelable(SegmentKeeper.class.getClassLoader()));
  }
  
  public PasterParcelData(ayjn.b paramb)
  {
    this.centerP = paramb.centerP;
    this.scaleValue = paramb.scaleValue;
    this.nI = paramb.nI;
    this.translateXValue = paramb.translateXValue;
    this.translateYValue = paramb.translateYValue;
    this.width = paramb.width;
    this.height = paramb.height;
    this.X = paramb.X;
    this.category = paramb.category;
    this.name = paramb.name;
    this.path = paramb.path;
    this.eGY = paramb.eGY;
    this.data = paramb.data;
    this.eGZ = paramb.eGZ;
    if ((paramb instanceof ayjn.a))
    {
      this.mType = eGX;
      ayjn.a locala = (ayjn.a)paramb;
      this.textSize = locala.textSize;
      this.textColor = locala.textColor;
      this.text = locala.text;
    }
    for (;;)
    {
      this.location = paramb.getText();
      this.mSegmentKeeper = new SegmentKeeper(paramb.mSegmentKeeper);
      return;
      this.mType = eGW;
    }
  }
  
  public JSONObject convertToJSON()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("centerPx", this.centerP.x);
      localJSONObject.put("centerPy", this.centerP.y);
      localJSONObject.put("scale", this.scaleValue);
      localJSONObject.put("rotate", this.nI);
      localJSONObject.put("translateX", this.translateXValue);
      localJSONObject.put("translateY", this.translateYValue);
      localJSONObject.put("width", this.width);
      localJSONObject.put("height", this.height);
      localJSONObject.put("imageRbottom", this.X.bottom);
      localJSONObject.put("imageRleft", this.X.left);
      localJSONObject.put("imageRtop", this.X.top);
      localJSONObject.put("imageRright", this.X.right);
      localJSONObject.put("category", this.category);
      localJSONObject.put("name", this.name);
      localJSONObject.put("path", this.path);
      localJSONObject.put("dynamicType", this.eGY);
      if (this.data != null) {
        localJSONObject.put("data", this.data);
      }
      localJSONObject.put("autoAdded", this.eGZ);
      if (this.text != null)
      {
        localJSONObject.put("textSize", this.textSize);
        localJSONObject.put("textColor", this.textColor);
        localJSONObject.put("text", this.text);
      }
      localJSONObject.put("location", this.location);
      return localJSONObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @TargetApi(13)
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mType);
    paramParcel.writeParcelable(this.centerP, 0);
    paramParcel.writeFloat(this.scaleValue);
    paramParcel.writeFloat(this.nI);
    paramParcel.writeFloat(this.translateXValue);
    paramParcel.writeFloat(this.translateYValue);
    paramParcel.writeFloat(this.width);
    paramParcel.writeFloat(this.height);
    paramParcel.writeParcelable(this.X, 0);
    paramParcel.writeString(this.category);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.path);
    paramParcel.writeInt(this.eGY);
    paramParcel.writeString(this.data);
    paramParcel.writeInt(this.eGZ);
    paramParcel.writeInt(this.textSize);
    paramParcel.writeInt(this.textColor);
    paramParcel.writeString(this.text);
    paramParcel.writeString(this.location);
    paramParcel.writeParcelable(this.mSegmentKeeper, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.PasterParcelData
 * JD-Core Version:    0.7.0.1
 */