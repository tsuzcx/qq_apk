import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;

public final class gjc
  implements Parcelable.Creator
{
  public MessageRecordInfo a(Parcel paramParcel)
  {
    return new MessageRecordInfo(paramParcel);
  }
  
  public MessageRecordInfo[] a(int paramInt)
  {
    return new MessageRecordInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gjc
 * JD-Core Version:    0.7.0.1
 */