import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;

public final class nli
  implements Parcelable.Creator<BaseData>
{
  public BaseData a(Parcel paramParcel)
  {
    return new BaseData(paramParcel);
  }
  
  public BaseData[] a(int paramInt)
  {
    return new BaseData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nli
 * JD-Core Version:    0.7.0.1
 */