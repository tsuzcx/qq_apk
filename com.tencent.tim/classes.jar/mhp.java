import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.MultiBiuSameContent;

public final class mhp
  implements Parcelable.Creator<MultiBiuSameContent>
{
  public MultiBiuSameContent a(Parcel paramParcel)
  {
    return new MultiBiuSameContent(paramParcel);
  }
  
  public MultiBiuSameContent[] a(int paramInt)
  {
    return new MultiBiuSameContent[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mhp
 * JD-Core Version:    0.7.0.1
 */