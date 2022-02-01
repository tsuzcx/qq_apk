package dov.com.qq.im.ptv;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.MotionEvent;
import ayai;

public class LWMotionEvent
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<LWMotionEvent> CREATOR = new ayai();
  public int action;
  public int eIZ = 0;
  public float x;
  public float y;
  
  public LWMotionEvent() {}
  
  private LWMotionEvent(Parcel paramParcel)
  {
    this.action = paramParcel.readInt();
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
  }
  
  public void ak(MotionEvent paramMotionEvent)
  {
    this.action = (paramMotionEvent.getAction() & 0xFF);
    this.x = paramMotionEvent.getRawX();
    this.y = paramMotionEvent.getRawY();
    this.eIZ = 0;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getAction()
  {
    return this.action;
  }
  
  public float getRawX()
  {
    return this.x;
  }
  
  public float getRawY()
  {
    return this.y;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.action);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ptv.LWMotionEvent
 * JD-Core Version:    0.7.0.1
 */