import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.intervideo.singtogether.SingTogetherSession;

public final class aihb
  implements Parcelable.Creator<SingTogetherSession>
{
  public SingTogetherSession a(Parcel paramParcel)
  {
    return new SingTogetherSession(paramParcel, null);
  }
  
  public SingTogetherSession[] a(int paramInt)
  {
    return new SingTogetherSession[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aihb
 * JD-Core Version:    0.7.0.1
 */