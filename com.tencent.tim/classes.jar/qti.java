import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem.CardVideoInfo;

public final class qti
  implements Parcelable.Creator<CardItem.CardVideoInfo>
{
  public CardItem.CardVideoInfo a(Parcel paramParcel)
  {
    return new CardItem.CardVideoInfo(paramParcel);
  }
  
  public CardItem.CardVideoInfo[] a(int paramInt)
  {
    return new CardItem.CardVideoInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qti
 * JD-Core Version:    0.7.0.1
 */