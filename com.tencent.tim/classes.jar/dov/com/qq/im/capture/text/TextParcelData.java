package dov.com.qq.im.capture.text;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import axug;
import axvb;
import axvt;
import ayjw;
import ayjw.b;
import ayjw.c;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TextParcelData
  implements Parcelable
{
  public static final Parcelable.Creator<TextParcelData> CREATOR = new axvt();
  private ayjw.b a;
  private DynamicTextItem b;
  private float mS;
  public SegmentKeeper mSegmentKeeper = new SegmentKeeper();
  private float mT;
  private float mU;
  private float mV;
  private float mZ;
  private float mf;
  private float mg;
  private float na;
  private float nb;
  
  public TextParcelData(Parcel paramParcel)
  {
    Object localObject = new axug();
    int i = paramParcel.readInt();
    DynamicTextItem.TextMap localTextMap = (DynamicTextItem.TextMap)paramParcel.readParcelable(DynamicTextItem.TextMap.class.getClassLoader());
    this.b = ((axug)localObject).a(i, localTextMap.hV());
    if (this.b == null)
    {
      QLog.e("TextParcelData", 1, "read mDynamicTextItem from Parcel return null, use normal text instead");
      this.b = new axvb(i, localTextMap.hV());
    }
    localObject = this.b;
    if (paramParcel.readInt() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((DynamicTextItem)localObject).YZ(bool);
      this.a = new ayjw.b(paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat());
      this.mS = paramParcel.readFloat();
      this.mT = paramParcel.readFloat();
      this.mU = paramParcel.readFloat();
      this.mV = paramParcel.readFloat();
      this.mZ = paramParcel.readFloat();
      this.mf = paramParcel.readFloat();
      this.mg = paramParcel.readFloat();
      this.na = paramParcel.readFloat();
      this.nb = paramParcel.readFloat();
      this.mSegmentKeeper = ((SegmentKeeper)paramParcel.readParcelable(SegmentKeeper.class.getClassLoader()));
      return;
    }
  }
  
  public TextParcelData(ayjw.c paramc)
  {
    this.b = paramc.c;
    this.a = new ayjw.b(paramc.centerP.x, paramc.centerP.y, paramc.scaleValue, paramc.nI, paramc.translateXValue, paramc.translateYValue, paramc.width, paramc.height);
    this.mS = paramc.mS;
    this.mT = paramc.mT;
    this.mU = paramc.mU;
    this.mV = paramc.mV;
    this.mZ = paramc.mZ;
    this.mf = paramc.mf;
    this.mg = paramc.mg;
    this.na = paramc.na;
    this.nb = paramc.nb;
    this.mSegmentKeeper.set(paramc.mSegmentKeeper);
  }
  
  public ayjw.c a(ayjw paramayjw)
  {
    paramayjw.getClass();
    paramayjw = new ayjw.c(paramayjw, this.a);
    paramayjw.scaleValue = this.a.scale;
    paramayjw.c = this.b;
    paramayjw.width = this.b.getWidth();
    paramayjw.height = this.b.getHeight();
    paramayjw.mS = this.mS;
    paramayjw.mT = this.mT;
    paramayjw.mU = this.mU;
    paramayjw.mV = this.mV;
    paramayjw.mZ = this.mZ;
    paramayjw.mf = this.mf;
    paramayjw.mg = this.mg;
    paramayjw.na = this.na;
    paramayjw.nb = this.nb;
    paramayjw.mSegmentKeeper.set(this.mSegmentKeeper);
    return paramayjw;
  }
  
  public JSONObject convertToJSON()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("dynamicTextType", this.b.getType());
      DynamicTextItem.TextMap localTextMap = this.b.a();
      if (localTextMap != null)
      {
        localJSONObject.put("dynamicText", localTextMap.l());
        localJSONObject.put("isFromCombo", this.b.aPQ());
      }
      localJSONObject.put("centerPx", this.a.centerP.x);
      localJSONObject.put("centerPy", this.a.centerP.y);
      localJSONObject.put("scale", this.a.scale);
      localJSONObject.put("rotate", this.a.rotate);
      localJSONObject.put("translateX", this.a.translateXValue);
      localJSONObject.put("translateY", this.a.translateYValue);
      localJSONObject.put("width", this.a.width);
      localJSONObject.put("height", this.a.height);
      localJSONObject.put("textLeft", this.mS);
      localJSONObject.put("saveScaleValue", this.mT);
      localJSONObject.put("saveRotateValue", this.mU);
      localJSONObject.put("saveTranslateX", this.mV);
      localJSONObject.put("saveTranslateY", this.mZ);
      localJSONObject.put("distanceX", this.mf);
      localJSONObject.put("distanceY", this.mg);
      localJSONObject.put("dScale", this.na);
      localJSONObject.put("dRotate", this.nb);
      return localJSONObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.b.getType());
    paramParcel.writeParcelable(this.b.a(), 0);
    if (this.b.aPQ()) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeFloat(this.a.centerP.x);
      paramParcel.writeFloat(this.a.centerP.y);
      paramParcel.writeFloat(this.a.scale);
      paramParcel.writeFloat(this.a.rotate);
      paramParcel.writeFloat(this.a.translateXValue);
      paramParcel.writeFloat(this.a.translateYValue);
      paramParcel.writeFloat(this.a.width);
      paramParcel.writeFloat(this.a.height);
      paramParcel.writeFloat(this.mS);
      paramParcel.writeFloat(this.mT);
      paramParcel.writeFloat(this.mU);
      paramParcel.writeFloat(this.mV);
      paramParcel.writeFloat(this.mZ);
      paramParcel.writeFloat(this.mf);
      paramParcel.writeFloat(this.mg);
      paramParcel.writeFloat(this.na);
      paramParcel.writeFloat(this.nb);
      paramParcel.writeParcelable(this.mSegmentKeeper, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.text.TextParcelData
 * JD-Core Version:    0.7.0.1
 */