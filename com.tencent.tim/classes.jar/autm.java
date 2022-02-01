import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.widget.ExpandableListConnector.GroupMetadata;

public final class autm
  implements Parcelable.Creator<ExpandableListConnector.GroupMetadata>
{
  public ExpandableListConnector.GroupMetadata a(Parcel paramParcel)
  {
    return ExpandableListConnector.GroupMetadata.a(paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readLong());
  }
  
  public ExpandableListConnector.GroupMetadata[] a(int paramInt)
  {
    return new ExpandableListConnector.GroupMetadata[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     autm
 * JD-Core Version:    0.7.0.1
 */