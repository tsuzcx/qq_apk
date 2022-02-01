import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;

public final class mgx
  implements Parcelable.Creator<ColumnInfo>
{
  public ColumnInfo a(Parcel paramParcel)
  {
    return new ColumnInfo(paramParcel);
  }
  
  public ColumnInfo[] a(int paramInt)
  {
    return new ColumnInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mgx
 * JD-Core Version:    0.7.0.1
 */