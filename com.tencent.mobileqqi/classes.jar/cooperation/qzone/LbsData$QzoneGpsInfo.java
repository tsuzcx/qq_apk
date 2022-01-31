package cooperation.qzone;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import ign;

public class LbsData$QzoneGpsInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ign();
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  
  public LbsData$QzoneGpsInfo()
  {
    this.a = LbsData.a;
    this.b = LbsData.a;
    this.c = -10000000;
    this.d = 2;
    this.e = -1;
  }
  
  public LbsData$QzoneGpsInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
  }
  
  public QzoneGpsInfo a()
  {
    return new QzoneGpsInfo(this.a, this.b, this.c, this.d, this.e);
  }
  
  public boolean a()
  {
    return (this.a != LbsData.a) && (this.b != LbsData.a);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "lat: " + this.a + ", lon: " + this.b + ", alt: " + this.c + ", gpsType: " + this.d + ", accuracy: " + this.e;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qzone.LbsData.QzoneGpsInfo
 * JD-Core Version:    0.7.0.1
 */