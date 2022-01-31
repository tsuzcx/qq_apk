import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.PictureCutInfo;

public final class flo
  implements Parcelable.Creator
{
  public PictureCutInfo a(Parcel paramParcel)
  {
    PictureCutInfo localPictureCutInfo = new PictureCutInfo();
    localPictureCutInfo.jdField_a_of_type_AndroidGraphicsRect = ((Rect)paramParcel.readParcelable(getClass().getClassLoader()));
    localPictureCutInfo.jdField_a_of_type_Int = paramParcel.readInt();
    localPictureCutInfo.b = paramParcel.readInt();
    localPictureCutInfo.c = paramParcel.readInt();
    localPictureCutInfo.d = paramParcel.readInt();
    return localPictureCutInfo;
  }
  
  public PictureCutInfo[] a(int paramInt)
  {
    return new PictureCutInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     flo
 * JD-Core Version:    0.7.0.1
 */