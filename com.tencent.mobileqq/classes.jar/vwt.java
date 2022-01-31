import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;

public final class vwt
  implements Parcelable.Creator<TroopStoryItemInfo>
{
  public TroopStoryItemInfo a(Parcel paramParcel)
  {
    return new TroopStoryItemInfo(paramParcel);
  }
  
  public TroopStoryItemInfo[] a(int paramInt)
  {
    return new TroopStoryItemInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vwt
 * JD-Core Version:    0.7.0.1
 */