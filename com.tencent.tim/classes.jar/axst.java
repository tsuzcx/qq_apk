import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.qq.im.capture.paster.InteractPasterParcelData;

public final class axst
  implements Parcelable.Creator<InteractPasterParcelData>
{
  public InteractPasterParcelData a(Parcel paramParcel)
  {
    return new InteractPasterParcelData(paramParcel);
  }
  
  public InteractPasterParcelData[] a(int paramInt)
  {
    return new InteractPasterParcelData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axst
 * JD-Core Version:    0.7.0.1
 */