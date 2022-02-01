import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.ARRecognition;

public final class adce
  implements Parcelable.Creator<ARRecognition>
{
  public ARRecognition a(Parcel paramParcel)
  {
    return new ARRecognition(paramParcel);
  }
  
  public ARRecognition[] a(int paramInt)
  {
    return new ARRecognition[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adce
 * JD-Core Version:    0.7.0.1
 */