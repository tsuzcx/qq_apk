import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;

public final class alca
  implements Parcelable.Creator<PersonalityLabelInfo>
{
  public PersonalityLabelInfo a(Parcel paramParcel)
  {
    return new PersonalityLabelInfo(paramParcel);
  }
  
  public PersonalityLabelInfo[] a(int paramInt)
  {
    return new PersonalityLabelInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alca
 * JD-Core Version:    0.7.0.1
 */