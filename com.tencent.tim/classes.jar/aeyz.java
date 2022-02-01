import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.AutoReplyText;

public final class aeyz
  implements Parcelable.Creator<AutoReplyText>
{
  public AutoReplyText a(Parcel paramParcel)
  {
    return new AutoReplyText(paramParcel);
  }
  
  public AutoReplyText[] a(int paramInt)
  {
    return new AutoReplyText[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeyz
 * JD-Core Version:    0.7.0.1
 */