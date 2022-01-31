import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.widget.ExpandableListConnector.GroupMetadata;

public final class fhw
  implements Parcelable.Creator
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fhw
 * JD-Core Version:    0.7.0.1
 */