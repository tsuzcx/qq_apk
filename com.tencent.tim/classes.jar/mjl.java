import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity.DeliverData;

public final class mjl
  implements Parcelable.Creator<ReadInJoyDeliverUGCActivity.DeliverData>
{
  public ReadInJoyDeliverUGCActivity.DeliverData a(Parcel paramParcel)
  {
    return new ReadInJoyDeliverUGCActivity.DeliverData(paramParcel);
  }
  
  public ReadInJoyDeliverUGCActivity.DeliverData[] a(int paramInt)
  {
    return new ReadInJoyDeliverUGCActivity.DeliverData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mjl
 * JD-Core Version:    0.7.0.1
 */