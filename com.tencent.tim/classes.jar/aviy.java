import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qqdataline.ipc.MessageRecordParcel;

public final class aviy
  implements Parcelable.Creator<MessageRecordParcel>
{
  public MessageRecordParcel[] a(int paramInt)
  {
    return new MessageRecordParcel[paramInt];
  }
  
  public MessageRecordParcel c(Parcel paramParcel)
  {
    return MessageRecordParcel.b(paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aviy
 * JD-Core Version:    0.7.0.1
 */