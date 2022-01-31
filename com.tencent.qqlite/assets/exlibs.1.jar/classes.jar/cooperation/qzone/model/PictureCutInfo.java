package cooperation.qzone.model;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import flo;

public class PictureCutInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new flo();
  public int a;
  public Rect a;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  
  public PictureCutInfo()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.jdField_a_of_type_AndroidGraphicsRect, paramInt);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.model.PictureCutInfo
 * JD-Core Version:    0.7.0.1
 */