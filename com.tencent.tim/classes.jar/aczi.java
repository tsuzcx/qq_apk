import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoAttribute;

public final class aczi
  implements Parcelable.Creator<SosoInterface.SosoAttribute>
{
  public SosoInterface.SosoAttribute a(Parcel paramParcel)
  {
    return new SosoInterface.SosoAttribute(paramParcel);
  }
  
  public SosoInterface.SosoAttribute[] a(int paramInt)
  {
    return new SosoInterface.SosoAttribute[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aczi
 * JD-Core Version:    0.7.0.1
 */