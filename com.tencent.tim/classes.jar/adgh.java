import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;

public final class adgh
  implements Parcelable.Creator<ArConfigInfo>
{
  public ArConfigInfo a(Parcel paramParcel)
  {
    return new ArConfigInfo(paramParcel);
  }
  
  public ArConfigInfo[] a(int paramInt)
  {
    return new ArConfigInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adgh
 * JD-Core Version:    0.7.0.1
 */