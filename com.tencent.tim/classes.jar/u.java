import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.internal.telephony.SmsRawData;

public final class u
  implements Parcelable.Creator<SmsRawData>
{
  public SmsRawData a(Parcel paramParcel)
  {
    byte[] arrayOfByte = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(arrayOfByte);
    return new SmsRawData(arrayOfByte);
  }
  
  public SmsRawData[] a(int paramInt)
  {
    return new SmsRawData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     u
 * JD-Core Version:    0.7.0.1
 */